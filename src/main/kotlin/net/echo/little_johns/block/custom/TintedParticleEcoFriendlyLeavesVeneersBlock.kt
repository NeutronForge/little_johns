package net.echo.little_johns.block.custom

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.particle.EntityEffectParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.particle.ParticleUtil
import net.minecraft.state.StateManager
import net.minecraft.util.dynamic.Codecs
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

class TintedParticleEcoFriendlyLeavesVeneersBlock(
    leafParticleChance: Float,
    settings: Settings
) : EcoFriendlyLeavesVeneersBlock(leafParticleChance, settings) {

    override fun getCodec(): MapCodec<out TintedParticleEcoFriendlyLeavesVeneersBlock> = CODEC

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
        val CODEC: MapCodec<TintedParticleEcoFriendlyLeavesVeneersBlock> =
            RecordCodecBuilder.mapCodec { instance ->
                instance.group(
                    Codecs.rangedInclusiveFloat(0.0f, 1.0f)
                        .fieldOf("leaf_particle_chance")
                        .forGetter { it.leafParticleChance },
                    createSettingsCodec()
                ).apply(instance, ::TintedParticleEcoFriendlyLeavesVeneersBlock)
            }
    }

    override fun spawnLeafParticle(world: World, pos: BlockPos, random: Random) {
        val color = world.getBlockColor(pos)
        val particle = EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, color)
        ParticleUtil.spawnParticle(world, pos, random, particle)
    }
}
