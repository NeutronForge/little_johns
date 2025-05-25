package net.echo.little_johns

import net.echo.little_johns.datagen.ModBlockLootTableProvider
import net.echo.little_johns.datagen.ModBlockModelProvider
import net.echo.little_johns.datagen.ModBlockTagProvider
import net.echo.little_johns.datagen.ModLanguageProviderEnglish
import net.echo.little_johns.datagen.ModRecipeProvider
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator

object LittleJohnsDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {

		val pack: FabricDataGenerator.Pack = fabricDataGenerator.createPack()

		pack.addProvider(::ModBlockLootTableProvider)
		pack.addProvider(::ModBlockModelProvider)
		pack.addProvider(::ModBlockTagProvider)
		pack.addProvider(::ModLanguageProviderEnglish)
		pack.addProvider(::ModRecipeProvider)

	}
}