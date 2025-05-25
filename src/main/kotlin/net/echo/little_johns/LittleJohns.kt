package net.echo.little_johns

import net.echo.little_johns.block.ModBlocks
import net.echo.little_johns.item.ModItems
import net.echo.little_johns.screen.ModScreenHandlers
import net.echo.little_johns.stat.ModStats
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object LittleJohns : ModInitializer {
	const val MOD_ID = "little_johns"
    val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {

		ModItems.registerAll()
		ModBlocks.registerAll()
		ModStats.registerAll()
		ModScreenHandlers.registerAll()


	}
}