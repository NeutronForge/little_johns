package net.echo.little_johns.block.custom

import com.google.common.collect.ImmutableMap
import com.mojang.serialization.MapCodec
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.PaneBlock
import net.minecraft.block.ShapeContext
import net.minecraft.block.Waterloggable
import net.minecraft.block.enums.WallShape
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.registry.tag.BlockTags
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.EnumProperty
import net.minecraft.state.property.Properties
import net.minecraft.state.property.Property
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.WorldView
import net.minecraft.world.tick.ScheduledTickView
import java.util.EnumMap
import java.util.function.Function

open class CustomWallBlock(settings: Settings) : Block(settings), Waterloggable {
    override fun getCodec(): MapCodec<out CustomWallBlock?> = CODEC

    private val outlineShapeFunction: Function<BlockState, VoxelShape>
    private val collisionShapeFunction: Function<BlockState, VoxelShape>

    init {
        defaultState = stateManager.defaultState
            .with(UP, true)
            .with(NORTH_WALL_SHAPE, WallShape.NONE)
            .with(EAST_WALL_SHAPE, WallShape.NONE)
            .with(SOUTH_WALL_SHAPE, WallShape.NONE)
            .with(WEST_WALL_SHAPE, WallShape.NONE)
            .with(WATERLOGGED, false)

        outlineShapeFunction = createShapeFunction(16.0f, 14.0f)
        collisionShapeFunction = createShapeFunction(24.0f, 24.0f)
    }

    private fun createShapeFunction(tallHeight: Float, lowHeight: Float): Function<BlockState, VoxelShape> {
        val center = Block.createColumnShape(8.0, 0.0, tallHeight.toDouble())
        val low = VoxelShapes.createHorizontalFacingShapeMap(Block.createCuboidZShape(6.0, 0.0, lowHeight.toDouble(), 0.0, 11.0))
        val tall = VoxelShapes.createHorizontalFacingShapeMap(Block.createCuboidZShape(6.0, 0.0, tallHeight.toDouble(), 0.0, 11.0))
        return createShapeFunction(Function { state ->
            var shape = if (state[UP]) center else VoxelShapes.empty()
            for ((dir, property) in WALL_SHAPE_PROPERTIES_BY_DIRECTION) {
                shape = VoxelShapes.union(shape, when (state[property]) {
                    WallShape.NONE -> VoxelShapes.empty()
                    WallShape.LOW -> low[dir]
                    WallShape.TALL -> tall[dir]
                })
            }
            shape
        }, WATERLOGGED)
    }

    override fun getOutlineShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape =
        outlineShapeFunction.apply(state)

    override fun getCollisionShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape =
        collisionShapeFunction.apply(state)

    override fun canPathfindThrough(state: BlockState, type: NavigationType): Boolean = false

    private fun shouldConnectTo(state: BlockState, faceFullSquare: Boolean, side: Direction): Boolean {
        val block = state.block
        val gate = block is FenceGateBlock && FenceGateBlock.canWallConnect(state, side)
        return state.isIn(BlockTags.WALLS) || !cannotConnect(state) && faceFullSquare || block is PaneBlock || gate
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        val world = ctx.world
        val pos = ctx.blockPos
        val fluid = world.getFluidState(pos)
        val neighbors = listOf(
            Direction.NORTH to pos.north(),
            Direction.EAST to pos.east(),
            Direction.SOUTH to pos.south(),
            Direction.WEST to pos.west()
        ).associate { (dir, p) -> dir to world.getBlockState(p) }

        val connect = neighbors.mapValues { (dir, state) ->
            shouldConnectTo(state, state.isSideSolidFullSquare(world, pos.offset(dir), dir.opposite), dir.opposite)
        }

        val upState = world.getBlockState(pos.up())
        val baseState = defaultState.with(WATERLOGGED, fluid.fluid == Fluids.WATER)
        return getStateWith(world, baseState, pos.up(), upState, connect[Direction.NORTH]!!, connect[Direction.EAST]!!, connect[Direction.SOUTH]!!, connect[Direction.WEST]!!)
    }

    override fun getStateForNeighborUpdate(
        state: BlockState,
        world: WorldView,
        tickView: ScheduledTickView,
        pos: BlockPos,
        direction: Direction,
        neighborPos: BlockPos,
        neighborState: BlockState,
        random: Random
    ): BlockState {
        if (state[WATERLOGGED]) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world))
        }
        return when (direction) {
            Direction.DOWN -> super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random)
            Direction.UP -> getStateAt(world, state, neighborPos, neighborState)
            else -> getStateWithNeighbor(world, pos, state, neighborPos, neighborState, direction)
        }
    }

    private fun isConnected(state: BlockState, property: Property<WallShape>) = state[property] != WallShape.NONE

    private fun shouldUseTallShape(aboveShape: VoxelShape, tallShape: VoxelShape): Boolean =
        !VoxelShapes.matchesAnywhere(tallShape, aboveShape, BooleanBiFunction.ONLY_FIRST)

    private fun getStateAt(world: WorldView, state: BlockState, pos: BlockPos, aboveState: BlockState): BlockState {
        return getStateWith(
            world, state, pos, aboveState,
            isConnected(state, NORTH_WALL_SHAPE),
            isConnected(state, EAST_WALL_SHAPE),
            isConnected(state, SOUTH_WALL_SHAPE),
            isConnected(state, WEST_WALL_SHAPE)
        )
    }

    private fun getStateWithNeighbor(world: WorldView, pos: BlockPos, state: BlockState, neighborPos: BlockPos, neighborState: BlockState, direction: Direction): BlockState {
        val opposite = direction.opposite
        val map = mapOf(
            Direction.NORTH to NORTH_WALL_SHAPE,
            Direction.EAST to EAST_WALL_SHAPE,
            Direction.SOUTH to SOUTH_WALL_SHAPE,
            Direction.WEST to WEST_WALL_SHAPE
        )
        val newState = map.mapValues { (dir, prop) ->
            if (direction == dir) shouldConnectTo(neighborState, neighborState.isSideSolidFullSquare(world, neighborPos, opposite), opposite)
            else isConnected(state, prop)
        }
        val above = world.getBlockState(pos.up())
        return getStateWith(world, state, pos.up(), above, newState[Direction.NORTH]!!, newState[Direction.EAST]!!, newState[Direction.SOUTH]!!, newState[Direction.WEST]!!)
    }

    private fun getStateWith(world: WorldView, state: BlockState, pos: BlockPos, aboveState: BlockState, north: Boolean, east: Boolean, south: Boolean, west: Boolean): BlockState {
        val aboveShape = aboveState.getCollisionShape(world, pos).getFace(Direction.DOWN)
        val newState = getStateWith(state, north, east, south, west, aboveShape)
        return newState.with(UP, shouldHavePost(newState, aboveState, aboveShape))
    }

    private fun shouldHavePost(state: BlockState, aboveState: BlockState, aboveShape: VoxelShape): Boolean {
        if (aboveState.block is CustomWallBlock && aboveState[UP]) return true
        val nsew = listOf(NORTH_WALL_SHAPE, SOUTH_WALL_SHAPE, EAST_WALL_SHAPE, WEST_WALL_SHAPE).map { state[it] }
        val none = nsew.map { it == WallShape.NONE }
        val mismatch = none[0] != none[1] || none[2] != none[3]
        if (none.all { it } || mismatch) return true
        val tallPairs = nsew[0] == WallShape.TALL && nsew[1] == WallShape.TALL || nsew[2] == WallShape.TALL && nsew[3] == WallShape.TALL
        return if (tallPairs) false else aboveState.isIn(BlockTags.WALL_POST_OVERRIDE) || shouldUseTallShape(aboveShape, POST_SHAPE_FOR_TALL_TEST)
    }

    private fun getStateWith(state: BlockState, north: Boolean, east: Boolean, south: Boolean, west: Boolean, aboveShape: VoxelShape): BlockState {
        return state
            .with(NORTH_WALL_SHAPE, getWallShape(north, aboveShape, WALL_SHAPES_FOR_TALL_TEST_BY_DIRECTION[Direction.NORTH]!!))
            .with(EAST_WALL_SHAPE, getWallShape(east, aboveShape, WALL_SHAPES_FOR_TALL_TEST_BY_DIRECTION[Direction.EAST]!!))
            .with(SOUTH_WALL_SHAPE, getWallShape(south, aboveShape, WALL_SHAPES_FOR_TALL_TEST_BY_DIRECTION[Direction.SOUTH]!!))
            .with(WEST_WALL_SHAPE, getWallShape(west, aboveShape, WALL_SHAPES_FOR_TALL_TEST_BY_DIRECTION[Direction.WEST]!!))
    }

    private fun getWallShape(connected: Boolean, aboveShape: VoxelShape, tallShape: VoxelShape): WallShape =
        if (connected) if (shouldUseTallShape(aboveShape, tallShape)) WallShape.TALL else WallShape.LOW else WallShape.NONE

    override fun getFluidState(state: BlockState): FluidState =
        if (state[WATERLOGGED]) Fluids.WATER.getStill(false) else super.getFluidState(state)

    override fun isTransparent(state: BlockState): Boolean = !state[WATERLOGGED]

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(UP, NORTH_WALL_SHAPE, EAST_WALL_SHAPE, WEST_WALL_SHAPE, SOUTH_WALL_SHAPE, WATERLOGGED)
    }

    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState = when (rotation) {
        BlockRotation.CLOCKWISE_180 -> state
            .with(NORTH_WALL_SHAPE, state[SOUTH_WALL_SHAPE])
            .with(EAST_WALL_SHAPE, state[WEST_WALL_SHAPE])
            .with(SOUTH_WALL_SHAPE, state[NORTH_WALL_SHAPE])
            .with(WEST_WALL_SHAPE, state[EAST_WALL_SHAPE])
        BlockRotation.COUNTERCLOCKWISE_90 -> state
            .with(NORTH_WALL_SHAPE, state[EAST_WALL_SHAPE])
            .with(EAST_WALL_SHAPE, state[SOUTH_WALL_SHAPE])
            .with(SOUTH_WALL_SHAPE, state[WEST_WALL_SHAPE])
            .with(WEST_WALL_SHAPE, state[NORTH_WALL_SHAPE])
        BlockRotation.CLOCKWISE_90 -> state
            .with(NORTH_WALL_SHAPE, state[WEST_WALL_SHAPE])
            .with(EAST_WALL_SHAPE, state[NORTH_WALL_SHAPE])
            .with(SOUTH_WALL_SHAPE, state[EAST_WALL_SHAPE])
            .with(WEST_WALL_SHAPE, state[SOUTH_WALL_SHAPE])
        else -> state
    }

    override fun mirror(state: BlockState, mirror: BlockMirror): BlockState = when (mirror) {
        BlockMirror.LEFT_RIGHT -> state
            .with(NORTH_WALL_SHAPE, state[SOUTH_WALL_SHAPE])
            .with(SOUTH_WALL_SHAPE, state[NORTH_WALL_SHAPE])
        BlockMirror.FRONT_BACK -> state
            .with(EAST_WALL_SHAPE, state[WEST_WALL_SHAPE])
            .with(WEST_WALL_SHAPE, state[EAST_WALL_SHAPE])
        else -> super.mirror(state, mirror)
    }

    companion object {
        val CODEC: MapCodec<CustomWallBlock> = createCodec(::CustomWallBlock)
        val UP: BooleanProperty = Properties.UP
        val EAST_WALL_SHAPE: EnumProperty<WallShape> = Properties.EAST_WALL_SHAPE
        val NORTH_WALL_SHAPE: EnumProperty<WallShape> = Properties.NORTH_WALL_SHAPE
        val SOUTH_WALL_SHAPE: EnumProperty<WallShape> = Properties.SOUTH_WALL_SHAPE
        val WEST_WALL_SHAPE: EnumProperty<WallShape> = Properties.WEST_WALL_SHAPE
        val WALL_SHAPE_PROPERTIES_BY_DIRECTION: Map<Direction, EnumProperty<WallShape>> =
            ImmutableMap.copyOf(EnumMap(mapOf(
                Direction.NORTH to NORTH_WALL_SHAPE,
                Direction.EAST to EAST_WALL_SHAPE,
                Direction.SOUTH to SOUTH_WALL_SHAPE,
                Direction.WEST to WEST_WALL_SHAPE
            )))
        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED
        private val POST_SHAPE_FOR_TALL_TEST = Block.createColumnShape(2.0, 0.0, 16.0)
        private val WALL_SHAPES_FOR_TALL_TEST_BY_DIRECTION: Map<Direction, VoxelShape> =
            VoxelShapes.createHorizontalFacingShapeMap(Block.createCuboidZShape(2.0, 16.0, 0.0, 9.0))
    }
}