package net.echo.little_johns.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.particle.ParticleTypes
import net.minecraft.particle.ParticleUtil
import net.minecraft.state.StateManager
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.math.random.Random
import net.minecraft.world.World

abstract class EcoFriendlyLeavesVeneersBlock(
    protected val leafParticleChance: Float,
    settings: Settings
) : ModdedMultifaceBlock(settings) {

    override fun randomDisplayTick(state: BlockState, world: World, pos: BlockPos, random: Random) {
        super.randomDisplayTick(state, world, pos, random)
        val posBelow = pos.down()
        val belowState = world.getBlockState(posBelow)

        if (world.hasRain(pos.up()) && random.nextInt(15) == 1 &&
            (!belowState.isOpaque || !belowState.isSideSolidFullSquare(world, posBelow, Direction.UP))) {
            ParticleUtil.spawnParticle(world, pos, random, ParticleTypes.DRIPPING_WATER)
        }

        if (random.nextFloat() < leafParticleChance &&
            !isFaceFullSquare(belowState.getCollisionShape(world, posBelow), Direction.UP)) {
            spawnLeafParticle(world, pos, random)
        }
    }


    protected abstract fun spawnLeafParticle(world: World, pos: BlockPos, random: Random)

}