package net.echo.little_johns.block.custom

import com.google.common.collect.ImmutableList
import com.mojang.serialization.MapCodec
import it.unimi.dsi.fastutil.ints.Int2ObjectMap
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import net.minecraft.block.AbstractCandleBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.ShapeContext
import net.minecraft.block.Waterloggable
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.item.ItemStack
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.Util
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import net.minecraft.world.WorldAccess
import net.minecraft.world.WorldView
import net.minecraft.world.tick.ScheduledTickView
import java.util.function.ToIntFunction

class ChandelierBlock(settings: Settings) : AbstractCandleBlock(settings), Waterloggable {

    companion object {
        val CODEC: MapCodec<ChandelierBlock> = createCodec(::ChandelierBlock)
        val LIT: BooleanProperty = AbstractCandleBlock.LIT
        val HANGING: BooleanProperty = Properties.HANGING
        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED

        val STATE_TO_LUMINANCE = ToIntFunction<BlockState> { state -> if (state[LIT]) 15 else 0 }

        val CHANDELIER_STATE_TO_PARTICLE_OFFSETS: Int2ObjectMap<List<Vec3d>> = Util.make({
            val map = Int2ObjectOpenHashMap<List<Vec3d>>().apply {
                defaultReturnValue(ImmutableList.of())
            }
            map[0] = ImmutableList.of(
                Vec3d(0.5, 0.9375, 0.1875),
                Vec3d(0.1875, 0.9375, 0.5),
                Vec3d(0.8125, 0.9375, 0.5),
                Vec3d(0.5, 0.9375, 0.8125),
                Vec3d(0.5, 1.0625, 0.5)
            )
            map[1] = ImmutableList.of(
                Vec3d(0.5, 0.9375, 0.1875),
                Vec3d(0.1875, 0.9375, 0.5),
                Vec3d(0.8125, 0.9375, 0.5),
                Vec3d(0.5, 0.9375, 0.8125)
            )
            Int2ObjectMaps.unmodifiable(map)
        })

        val STANDING_SHAPE: VoxelShape = VoxelShapes.union(
            Block.createCuboidShape(4.5, 0.0, 4.5, 11.5, 4.0, 11.5),
            Block.createCuboidShape(8.0, 2.0, 0.0, 8.0, 5.0, 14.0),
            Block.createCuboidShape(7.0, 5.0, 2.0, 9.0, 13.0, 4.0),
            Block.createCuboidShape(12.0, 5.0, 7.0, 14.0, 13.0, 9.0),
            Block.createCuboidShape(7.0, 5.0, 12.0, 9.0, 13.0, 14.0),
            Block.createCuboidShape(2.0, 5.0, 7.0, 4.0, 13.0, 9.0),
            Block.createCuboidShape(7.0, 7.0, 7.0, 9.0, 15.0, 9.0)
        )

        val HANGING_SHAPE: VoxelShape = VoxelShapes.union(
            Block.createCuboidShape(6.5, 3.0, 6.5, 9.5, 16.0, 9.5),
            Block.createCuboidShape(2.0, 2.0, 8.0, 14.0, 5.0, 8.0),
            Block.createCuboidShape(8.0, 2.0, 0.0, 8.0, 5.0, 14.0),
            Block.createCuboidShape(7.0, 5.0, 2.0, 9.0, 13.0, 4.0),
            Block.createCuboidShape(12.0, 5.0, 7.0, 14.0, 13.0, 9.0),
            Block.createCuboidShape(7.0, 5.0, 12.0, 9.0, 13.0, 14.0),
            Block.createCuboidShape(2.0, 5.0, 7.0, 4.0, 13.0, 9.0)
        )

        fun canBeLit(state: BlockState): Boolean =
            !state[LIT] && !state[WATERLOGGED]

        fun attachedDirection(state: BlockState): Direction =
            if (state[HANGING]) Direction.DOWN else Direction.UP
    }

    init {
        defaultState = stateManager.defaultState
            .with(LIT, false)
            .with(HANGING, false)
            .with(WATERLOGGED, false)
    }

    override fun getCodec(): MapCodec<out ChandelierBlock> = CODEC

    override fun onUseWithItem(
        stack: ItemStack,
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        if (stack.isEmpty && player.abilities.allowModifyWorld && state[LIT]) {
            extinguish(player, state, world, pos)
            return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION
        }
        return super.onUseWithItem(stack, state, world, pos, player, hand, hit)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
        val fluidState = ctx.world.getFluidState(ctx.blockPos)
        for (direction in ctx.placementDirections) {
            if (direction.axis != Direction.Axis.Y) continue
            val blockState = defaultState.with(HANGING, direction == Direction.UP)
            if (blockState.canPlaceAt(ctx.world, ctx.blockPos)) {
                return blockState.with(WATERLOGGED, fluidState.fluid == Fluids.WATER)
            }
        }
        return null
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return if (state[HANGING]) HANGING_SHAPE else STANDING_SHAPE
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(HANGING, LIT, WATERLOGGED)
    }

    override fun canPlaceAt(state: BlockState, world: WorldView, pos: BlockPos): Boolean {
        val direction = attachedDirection(state).opposite
        return Block.sideCoversSmallSquare(world, pos.offset(direction), direction.opposite)
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
        return if (attachedDirection(state).opposite == direction && !state.canPlaceAt(world, pos)) {
            Blocks.AIR.defaultState
        } else super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random)
    }

    override fun getFluidState(state: BlockState): FluidState {
        return if (state[WATERLOGGED]) Fluids.WATER.getStill(false) else super.getFluidState(state)
    }

    override fun canPathfindThrough(state: BlockState, type: NavigationType): Boolean = false

    override fun tryFillWithFluid(world: WorldAccess, pos: BlockPos, state: BlockState, fluidState: FluidState): Boolean {
        if (state[WATERLOGGED] || fluidState.fluid != Fluids.WATER) return false

        val newState = state.with(WATERLOGGED, true)
        if (state[LIT]) {
            extinguish(null, newState, world, pos)
        } else {
            world.setBlockState(pos, newState, Block.NOTIFY_ALL)
        }
        world.scheduleFluidTick(pos, fluidState.fluid, fluidState.fluid.getTickRate(world))
        return true
    }

    override fun getParticleOffsets(state: BlockState): Iterable<Vec3d> {
        return CHANDELIER_STATE_TO_PARTICLE_OFFSETS.get(state.get(LIT)?.let { if (it) 0 else 1 } ?: 1)
    }


}