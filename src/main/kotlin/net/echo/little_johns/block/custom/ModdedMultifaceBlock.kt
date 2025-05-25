package net.echo.little_johns.block.custom

import com.google.common.collect.Maps
import com.mojang.serialization.MapCodec
import net.minecraft.block.*
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation
import net.minecraft.util.Util
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.WorldView
import net.minecraft.world.tick.ScheduledTickView

abstract class ModdedMultifaceBlock(settings: Settings) : Block(settings), Waterloggable {

    companion object {
        private val UP_SHAPE = createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0)
        private val DOWN_SHAPE = createCuboidShape(0.0, 0.0, 0.0, 16.0, 2.0, 16.0)
        private val EAST_SHAPE = createCuboidShape(0.0, 0.0, 0.0, 2.0, 16.0, 16.0)
        private val WEST_SHAPE = createCuboidShape(14.0, 0.0, 0.0, 16.0, 16.0, 16.0)
        private val SOUTH_SHAPE = createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 2.0)
        private val NORTH_SHAPE = createCuboidShape(0.0, 0.0, 14.0, 16.0, 16.0, 16.0)

        private val FACING_PROPERTIES: Map<Direction, BooleanProperty> = ConnectingBlock.FACING_PROPERTIES
        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED

        private val SHAPES_FOR_DIRECTIONS: Map<Direction, VoxelShape> =
            Util.make(Maps.newEnumMap(Direction::class.java)) { shapes ->
                shapes[Direction.NORTH] = SOUTH_SHAPE
                shapes[Direction.EAST] = WEST_SHAPE
                shapes[Direction.SOUTH] = NORTH_SHAPE
                shapes[Direction.WEST] = EAST_SHAPE
                shapes[Direction.UP] = UP_SHAPE
                shapes[Direction.DOWN] = DOWN_SHAPE
            }

        private val DIRECTIONS = Direction.entries.toTypedArray()

        @JvmStatic
        fun hasDirection(state: BlockState, direction: Direction): Boolean {
            val property = getProperty(direction)
            return state.contains(property) && state[property] == true
        }

        @JvmStatic
        fun getProperty(direction: Direction): BooleanProperty = FACING_PROPERTIES[direction]!!

        @JvmStatic
        fun withAllDirections(stateManager: StateManager<Block, BlockState>): BlockState {
            var state = stateManager.defaultState.with(WATERLOGGED, false)
            for (property in FACING_PROPERTIES.values) {
                state = state.withIfExists(property, false)
            }
            return state
        }


        @JvmStatic
        fun getShapeForState(state: BlockState): VoxelShape {
            var shape: VoxelShape = VoxelShapes.empty()
            for (direction in DIRECTIONS) {
                if (hasDirection(state, direction)) {
                    shape = VoxelShapes.union(shape, SHAPES_FOR_DIRECTIONS[direction])
                }
            }
            return if (shape.isEmpty) VoxelShapes.fullCube() else shape
        }

        @JvmStatic
        fun hasAnyDirection(state: BlockState): Boolean {
            return DIRECTIONS.any { hasDirection(state, it) }
        }

        @JvmStatic
        fun isNotFullBlock(state: BlockState): Boolean {
            return DIRECTIONS.any { !hasDirection(state, it) }
        }

        @JvmStatic
        fun disableDirection(state: BlockState, property: BooleanProperty): BlockState {
            val newState = state.with(property, false)
            return if (hasAnyDirection(newState)) newState else Blocks.AIR.defaultState
        }
    }

    private val SHAPES: (BlockState) -> VoxelShape =
        createShapeFunction(::getShapeForState).let { func ->
        { state -> func.apply(state) }
    }
    private val hasAllHorizontalDirections: Boolean =
        Direction.Type.HORIZONTAL.stream().allMatch(this::canHaveDirection)
    private val canMirrorX: Boolean =
        Direction.Type.HORIZONTAL.stream().filter { it.axis == Direction.Axis.X }.filter(this::canHaveDirection).count() % 2L == 0L
    private val canMirrorZ: Boolean =
        Direction.Type.HORIZONTAL.stream().filter { it.axis == Direction.Axis.Z }.filter(this::canHaveDirection).count() % 2L == 0L

    init {
        defaultState = withAllDirections(stateManager)
    }

    abstract override fun getCodec(): MapCodec<out ModdedMultifaceBlock?>?

    protected open fun canHaveDirection(direction: Direction): Boolean = true

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        for (direction in DIRECTIONS) {
            if (canHaveDirection(direction)) {
                builder.add(getProperty(direction))
            }
        }
        builder.add(WATERLOGGED)
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
        if (state[WATERLOGGED] == true) {
            tickView.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world))
        }
        return if (!hasAnyDirection(state)) {
            Blocks.AIR.defaultState
        } else {
            state
        }
    }

    override fun getFluidState(state: BlockState): FluidState {
        return if (state[WATERLOGGED] == true)
            Fluids.WATER.getStill(false)
        else
            super.getFluidState(state)
    }

    override fun getOutlineShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape {
        return SHAPES(state)
    }

    override fun canReplace(state: BlockState, context: ItemPlacementContext): Boolean {
        return isNotFullBlock(state)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
        val world = ctx.world
        val pos = ctx.blockPos
        val currentState = world.getBlockState(pos)
        return ctx.placementDirections
            .asSequence()
            .mapNotNull { withDirection(currentState, world, pos, it) }
            .firstOrNull()
    }



    fun withDirection(state: BlockState, world: BlockView, pos: BlockPos, direction: Direction): BlockState? {
        val baseState = when {
            state.isOf(this) -> state
            state.fluidState.isEqualAndStill(Fluids.WATER) -> defaultState.with(Properties.WATERLOGGED, true)
            else -> defaultState
        }

        return baseState.with(getProperty(direction), true)
    }


    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
        return if (hasAllHorizontalDirections) mirror(state) { rotation.rotate(it) } else state
    }

    override fun mirror(state: BlockState, mirror: BlockMirror): BlockState {
        return when (mirror) {
            BlockMirror.FRONT_BACK -> if (!canMirrorX) state else mirror(state) { mirror.apply(it) }
            BlockMirror.LEFT_RIGHT -> if (!canMirrorZ) state else mirror(state) { mirror.apply(it) }
            else -> state
        }
    }

    private fun mirror(state: BlockState, transform: (Direction) -> Direction): BlockState {
        var newState = state
        for (direction in DIRECTIONS) {
            if (canHaveDirection(direction)) {
                newState = newState.with(getProperty(transform(direction)), state[getProperty(direction)])
            }
        }
        return newState
    }

    private fun isWaterlogged(): Boolean {
        return Properties.WATERLOGGED in stateManager.properties
    }
}
