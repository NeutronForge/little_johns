package net.echo.little_johns

import net.echo.little_johns.block.ModBlocks
import net.echo.little_johns.gui.screen.TableSawScreen
import net.echo.little_johns.screen.ModScreenHandlers
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry
import net.minecraft.block.Block
import net.minecraft.client.color.world.BiomeColors
import net.minecraft.client.gui.screen.ingame.HandledScreens
import net.minecraft.client.render.RenderLayer
import net.minecraft.world.biome.FoliageColors
import net.minecraft.world.biome.GrassColors
import org.slf4j.LoggerFactory

object LittleJohnsClient : ClientModInitializer {

	const val MOD_ID = "little_johns"
	val LOGGER = LoggerFactory.getLogger(MOD_ID)

	override fun onInitializeClient() {


		HandledScreens.register(ModScreenHandlers.TABLE_SAW_SCREEN_HANDLER, ::TableSawScreen)




		// BLOCK CUTOUT RENDER LAYER
		// getBlockCutout(ModBlocks.BAMBOO_LEAVES)
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_OAK_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_SPRUCE_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_BIRCH_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_JUNGLE_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_ACACIA_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_DARK_OAK_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_MANGROVE_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_CHERRY_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_PALE_OAK_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_AZALEA_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_FLOWERING_AZALEA_LEAF_VENEERS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ECO_FRIENDLY_BAMBOO_LEAF_VENEERS, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OAK_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPRUCE_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIRCH_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNGLE_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACACIA_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_OAK_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGROVE_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHERRY_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALE_OAK_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.AZALEA_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOWERING_AZALEA_LEAF_HEDGE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAMBOO_LEAF_HEDGE, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OAK_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPRUCE_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BIRCH_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.JUNGLE_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ACACIA_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DARK_OAK_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MANGROVE_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHERRY_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PALE_OAK_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAMBOO_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CRIMSON_TABLE_SAW, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WARPED_TABLE_SAW, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ORANGE_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGENTA_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_BLUE_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.YELLOW_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIME_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINK_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAY_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LIGHT_GRAY_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYAN_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PURPLE_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BROWN_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GREEN_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_CHANDELIER, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_CHANDELIER, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GRAND_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COLOSSAL_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_GRAND_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLDEN_COLOSSAL_CHAIN, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BAMBOO_LEAVES, RenderLayer.getCutout());






		// NATURAL BLOCK COLOR PROVIDERS
		// GRASS
		ColorProviderRegistry.BLOCK.register({ state, world, pos, tintIndex ->
			if (world == null || pos == null) {
				GrassColors.getDefaultColor()
			} else {
				BiomeColors.getGrassColor(world, pos)
			}
		}, ModBlocks.ECO_FRIENDLY_GRASS_VENEERS)



		// FOLIAGE
		ColorProviderRegistry.BLOCK.register({ state, world, pos, tintIndex ->
			if (world == null || pos == null) {
				FoliageColors.getColor(0.5, 1.0)
			} else {
				BiomeColors.getFoliageColor(world, pos)
			}
		},
			ModBlocks.ECO_FRIENDLY_OAK_LEAF_VENEERS,
			ModBlocks.ECO_FRIENDLY_JUNGLE_LEAF_VENEERS,
			ModBlocks.ECO_FRIENDLY_ACACIA_LEAF_VENEERS,
			ModBlocks.ECO_FRIENDLY_DARK_OAK_LEAF_VENEERS,
			ModBlocks.OAK_LEAF_HEDGE,
			ModBlocks.JUNGLE_LEAF_HEDGE,
			ModBlocks.ACACIA_LEAF_HEDGE,
			ModBlocks.DARK_OAK_LEAF_HEDGE
		)

		ColorProviderRegistry.BLOCK.register({ state, world, pos, tintIndex ->
			-10380959
		},
			ModBlocks.ECO_FRIENDLY_SPRUCE_LEAF_VENEERS,
			ModBlocks.SPRUCE_LEAF_HEDGE
		)

		ColorProviderRegistry.BLOCK.register({ state, world, pos, tintIndex ->
			-8345771
		},
			ModBlocks.ECO_FRIENDLY_BIRCH_LEAF_VENEERS,
			ModBlocks.BIRCH_LEAF_HEDGE
		)

		ColorProviderRegistry.BLOCK.register({ state, world, pos, tintIndex ->
			if (world == null || pos == null) {
				-7158200
			} else {
				BiomeColors.getFoliageColor(world, pos)
			}
		},
			ModBlocks.ECO_FRIENDLY_MANGROVE_LEAF_VENEERS,
			ModBlocks.MANGROVE_LEAF_HEDGE
		)





	}

	fun getBlockCutout(block: Block) {
		return BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout())

	}
}