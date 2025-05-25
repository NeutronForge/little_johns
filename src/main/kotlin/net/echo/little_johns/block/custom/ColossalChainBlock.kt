package net.echo.little_johns.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.block.*
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView
import net.minecraft.world.WorldView
import net.minecraft.world.tick.ScheduledTickView

class ColossalChainBlock(settings: Settings) : PillarBlock(settings), Waterloggable {

    override fun getCodec(): MapCodec<ColossalChainBlock> = CODEC

    companion object {
        val CODEC: MapCodec<ColossalChainBlock> = createCodec(::ColossalChainBlock)
        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED

        private val Y_SHAPE: VoxelShape = createCuboidShape(4.0, 0.0, 4.0, 12.0, 16.0, 12.0)
        private val Z_SHAPE: VoxelShape = createCuboidShape(4.0, 4.0, 0.0, 12.0, 12.0, 16.0)
        private val X_SHAPE: VoxelShape = createCuboidShape(0.0, 4.0, 4.0, 16.0, 12.0, 12.0)
    }

    init {
        defaultState = stateManager.defaultState
            .with(WATERLOGGED, false)
            .with(AXIS, Direction.Axis.Y)
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return when (state.get(AXIS)) {
            Direction.Axis.X -> X_SHAPE
            Direction.Axis.Z -> Z_SHAPE
            else -> Y_SHAPE
        }
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState? {
        val fluidState = ctx.world.getFluidState(ctx.blockPos)
        val waterlogged = fluidState.fluid == Fluids.WATER
        return super.getPlacementState(ctx)?.with(WATERLOGGED, waterlogged)
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
        return super.getStateForNeighborUpdate(state, world, tickView, pos, direction, neighborPos, neighborState, random)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(WATERLOGGED, AXIS)
    }

    override fun getFluidState(state: BlockState): FluidState {
        return if (state[WATERLOGGED]) {
            Fluids.WATER.getStill(false)
        } else {
            super.getFluidState(state)
        }
    }

    override fun canPathfindThrough(state: BlockState, type: NavigationType): Boolean {
        return false
    }
}
