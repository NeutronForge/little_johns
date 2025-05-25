package net.echo.little_johns.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager


class EcoFriendlyWoodVeneersBlock(settings: Settings) : ModdedMultifaceBlock(settings) {

    override fun getCodec(): MapCodec<EcoFriendlyWoodVeneersBlock> = CODEC

    override fun canReplace(state: BlockState, context: ItemPlacementContext): Boolean {
        return context.stack.isOf(this.asItem())
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)
    }

    init {
        defaultState = defaultState.with(WATERLOGGED, false)
    }

    companion object {
        val CODEC: MapCodec<EcoFriendlyWoodVeneersBlock> = createCodec(::EcoFriendlyWoodVeneersBlock)
    }
}
