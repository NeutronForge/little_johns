package net.echo.little_johns.block.custom

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.particle.ParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.particle.ParticleUtil
import net.minecraft.state.StateManager
import net.minecraft.util.dynamic.Codecs
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

class UntintedParticleEcoFriendlyLeavesVeneersBlock(
    leafParticleChance: Float,
    private val leafParticleEffect: ParticleEffect,
    settings: Settings
) : EcoFriendlyLeavesVeneersBlock(leafParticleChance, settings) {

    override fun getCodec(): MapCodec<out UntintedParticleEcoFriendlyLeavesVeneersBlock> = CODEC

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
        val CODEC: MapCodec<UntintedParticleEcoFriendlyLeavesVeneersBlock> =
            RecordCodecBuilder.mapCodec { instance ->
                instance.group(
                    Codecs.rangedInclusiveFloat(0.0f, 1.0f)
                        .fieldOf("leaf_particle_chance")
                        .forGetter { it.leafParticleChance },
                    ParticleTypes.TYPE_CODEC
                        .fieldOf("leaf_particle")
                        .forGetter { it.leafParticleEffect },
                    createSettingsCodec()
                ).apply(instance, ::UntintedParticleEcoFriendlyLeavesVeneersBlock)
            }
    }

    override fun spawnLeafParticle(world: World, pos: BlockPos, random: Random) {
        ParticleUtil.spawnParticle(world, pos, random, leafParticleEffect)
    }
}
