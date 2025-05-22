package net.echo.little_johns.sound

import net.minecraft.sound.BlockSoundGroup
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents

class ModBlockSoundGroup(
    volume: Float,
    pitch: Float,
    breakSound: SoundEvent,
    stepSound: SoundEvent,
    placeSound: SoundEvent,
    hitSound: SoundEvent,
    fallSound: SoundEvent
) : BlockSoundGroup(volume, pitch, breakSound, stepSound, placeSound, hitSound, fallSound) {

    companion object {
        val COLOSSAL_CHAIN = BlockSoundGroup(
            1.5f, 0.6f,
            SoundEvents.BLOCK_CHAIN_BREAK,
            SoundEvents.BLOCK_CHAIN_STEP,
            SoundEvents.BLOCK_CHAIN_PLACE,
            SoundEvents.BLOCK_CHAIN_HIT,
            SoundEvents.BLOCK_CHAIN_FALL
        )
        val GRAND_CHAIN = BlockSoundGroup(
            1.2f, 0.9f,
            SoundEvents.BLOCK_CHAIN_BREAK,
            SoundEvents.BLOCK_CHAIN_STEP,
            SoundEvents.BLOCK_CHAIN_PLACE,
            SoundEvents.BLOCK_CHAIN_HIT,
            SoundEvents.BLOCK_CHAIN_FALL
        )
    }
}
