package net.echo.little_johns.block.custom

import com.mojang.serialization.MapCodec
import net.echo.little_johns.screen.TableSawScreenHandler
import net.echo.little_johns.stat.ModStats
import net.minecraft.block.*
import net.minecraft.entity.ai.pathing.NavigationType
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.fluid.FluidState
import net.minecraft.fluid.Fluids
import net.minecraft.item.ItemPlacementContext
import net.minecraft.screen.*
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.EnumProperty
import net.minecraft.state.property.Properties
import net.minecraft.text.Text
import net.minecraft.util.*
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.*
import net.minecraft.util.math.random.Random
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.*
import net.minecraft.world.tick.ScheduledTickView
import org.jetbrains.annotations.Nullable

class TableSawBlock(settings: Settings) : Block(settings), Waterloggable {
    companion object {
        val CODEC: MapCodec<TableSawBlock> = createCodec(::TableSawBlock)
        val WATERLOGGED: BooleanProperty = Properties.WATERLOGGED
        val TITLE: Text = Text.translatable("container.little_johns.table_saw")
        val FACING: EnumProperty<Direction> = HorizontalFacingBlock.FACING

        private val CENTER: VoxelShape = Block.createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0)
        private val LEG_1: VoxelShape = Block.createCuboidShape(0.0, 0.0, 0.0, 2.0, 16.0, 2.0)
        private val LEG_2: VoxelShape = Block.createCuboidShape(0.0, 0.0, 14.0, 2.0, 16.0, 16.0)
        private val LEG_3: VoxelShape = Block.createCuboidShape(14.0, 0.0, 0.0, 16.0, 16.0, 2.0)
        private val LEG_4: VoxelShape = Block.createCuboidShape(14.0, 0.0, 14.0, 16.0, 16.0, 16.0)
        private val SHAPE: VoxelShape = VoxelShapes.union(CENTER, LEG_1, LEG_2, LEG_3, LEG_4)
    }

    override fun getCodec(): MapCodec<TableSawBlock> = CODEC

    init {
        defaultState = stateManager.defaultState
            .with(FACING, Direction.NORTH)
            .with(WATERLOGGED, false)
    }

    override fun getPlacementState(ctx: ItemPlacementContext): BlockState {
        return defaultState.with(FACING, ctx.horizontalPlayerFacing.opposite)
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hit: BlockHitResult
    ): ActionResult {
        if (!world.isClient) {
            player.openHandledScreen(createScreenHandlerFactory(state, world, pos))
            player.incrementStat(ModStats.INTERACT_WITH_TABLE_SAW)
        }
        return ActionResult.SUCCESS
    }

    @Nullable
    override fun createScreenHandlerFactory(
        state: BlockState,
        world: World,
        pos: BlockPos
    ): NamedScreenHandlerFactory {
        return SimpleNamedScreenHandlerFactory(
            { syncId, inventory, player ->
                TableSawScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos))
            },
            TITLE
        )
    }

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape = SHAPE

    override fun hasSidedTransparency(state: BlockState): Boolean = true

    override fun getRenderType(state: BlockState): BlockRenderType = BlockRenderType.MODEL

    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState {
        return state.with(FACING, rotation.rotate(state[FACING]))
    }

    override fun mirror(state: BlockState, mirror: BlockMirror): BlockState {
        return state.rotate(mirror.getRotation(state[FACING]))
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        builder.add(FACING, WATERLOGGED)
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

    override fun getFluidState(state: BlockState): FluidState {
        return if (state[WATERLOGGED]) {
            Fluids.WATER.getStill(false)
        } else {
            super.getFluidState(state)
        }
    }

    override fun canPathfindThrough(state: BlockState, type: NavigationType): Boolean = false
}
