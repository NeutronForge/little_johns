package net.echo.little_johns.item

import net.echo.little_johns.LittleJohns
import net.echo.little_johns.block.ModBlocks
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.Items
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModItems {

    /*
    public static final Item MUSIC_DISC_MORSMORDRE = registerItem("music_disc_morsmordre", (settings) ->
    new Item(settings.maxCount(1).rarity(Rarity.UNCOMMON).jukeboxPlayable(ModJukeboxSongs.MORSMORDRE)));

     */

    val BORROWED_SCREWS = registerItem("borrowed_screws") { Item(it) }



    fun registerBuildingBlocksToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.CHAIN, ModBlocks.GRAND_CHAIN)
            content.addAfter(ModBlocks.GRAND_CHAIN, ModBlocks.COLOSSAL_CHAIN)
            content.addAfter(ModBlocks.COLOSSAL_CHAIN, ModBlocks.GOLDEN_CHAIN)
            content.addAfter(ModBlocks.GOLDEN_CHAIN, ModBlocks.GOLDEN_GRAND_CHAIN)
            content.addAfter(ModBlocks.GOLDEN_GRAND_CHAIN, ModBlocks.GOLDEN_COLOSSAL_CHAIN)

            content.addAfter(ModBlocks.GOLDEN_COLOSSAL_CHAIN, ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK)
            content.addAfter(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK, ModBlocks.GALVANIZED_SQUARE_STEEL_STAIRS)
            content.addAfter(ModBlocks.GALVANIZED_SQUARE_STEEL_STAIRS, ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB)
            content.addAfter(ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB, ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM)
            content.addAfter(ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM, ModBlocks.GALVANIZED_SQUARE_STEEL)
            content.addAfter(ModBlocks.GALVANIZED_SQUARE_STEEL, ModBlocks.GALVANIZED_SQUARE_STEEL_GRATE)
        }
    }

    fun registerIngredientsToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register { content ->
            content.addAfter(Items.NETHERITE_INGOT, ModItems.BORROWED_SCREWS)
        }
    }

    fun registerToolsUtilitiesToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register { content ->

        }
    }

    fun registerColoredToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register { content ->
            // Chandeliers
            content.addAfter(Items.PINK_CANDLE, ModBlocks.CHANDELIER)
            content.addAfter(ModBlocks.CHANDELIER, ModBlocks.WHITE_CHANDELIER)
            content.addAfter(ModBlocks.WHITE_CHANDELIER, ModBlocks.LIGHT_GRAY_CHANDELIER)
            content.addAfter(ModBlocks.LIGHT_GRAY_CHANDELIER, ModBlocks.GRAY_CHANDELIER)
            content.addAfter(ModBlocks.GRAY_CHANDELIER, ModBlocks.BLACK_CHANDELIER)
            content.addAfter(ModBlocks.BLACK_CHANDELIER, ModBlocks.BROWN_CHANDELIER)
            content.addAfter(ModBlocks.BROWN_CHANDELIER, ModBlocks.RED_CHANDELIER)
            content.addAfter(ModBlocks.RED_CHANDELIER, ModBlocks.ORANGE_CHANDELIER)
            content.addAfter(ModBlocks.ORANGE_CHANDELIER, ModBlocks.YELLOW_CHANDELIER)
            content.addAfter(ModBlocks.YELLOW_CHANDELIER, ModBlocks.LIME_CHANDELIER)
            content.addAfter(ModBlocks.LIME_CHANDELIER, ModBlocks.GREEN_CHANDELIER)
            content.addAfter(ModBlocks.GREEN_CHANDELIER, ModBlocks.CYAN_CHANDELIER)
            content.addAfter(ModBlocks.CYAN_CHANDELIER, ModBlocks.LIGHT_BLUE_CHANDELIER)
            content.addAfter(ModBlocks.LIGHT_BLUE_CHANDELIER, ModBlocks.BLUE_CHANDELIER)
            content.addAfter(ModBlocks.BLUE_CHANDELIER, ModBlocks.PURPLE_CHANDELIER)
            content.addAfter(ModBlocks.PURPLE_CHANDELIER, ModBlocks.MAGENTA_CHANDELIER)
            content.addAfter(ModBlocks.MAGENTA_CHANDELIER, ModBlocks.PINK_CHANDELIER)
        }
    }

    fun registerFunctionalToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register { content ->

            // Chandeliers
            content.addAfter(Items.PINK_CANDLE, ModBlocks.CHANDELIER)
            content.addAfter(ModBlocks.CHANDELIER, ModBlocks.WHITE_CHANDELIER)
            content.addAfter(ModBlocks.WHITE_CHANDELIER, ModBlocks.LIGHT_GRAY_CHANDELIER)
            content.addAfter(ModBlocks.LIGHT_GRAY_CHANDELIER, ModBlocks.GRAY_CHANDELIER)
            content.addAfter(ModBlocks.GRAY_CHANDELIER, ModBlocks.BLACK_CHANDELIER)
            content.addAfter(ModBlocks.BLACK_CHANDELIER, ModBlocks.BROWN_CHANDELIER)
            content.addAfter(ModBlocks.BROWN_CHANDELIER, ModBlocks.RED_CHANDELIER)
            content.addAfter(ModBlocks.RED_CHANDELIER, ModBlocks.ORANGE_CHANDELIER)
            content.addAfter(ModBlocks.ORANGE_CHANDELIER, ModBlocks.YELLOW_CHANDELIER)
            content.addAfter(ModBlocks.YELLOW_CHANDELIER, ModBlocks.LIME_CHANDELIER)
            content.addAfter(ModBlocks.LIME_CHANDELIER, ModBlocks.GREEN_CHANDELIER)
            content.addAfter(ModBlocks.GREEN_CHANDELIER, ModBlocks.CYAN_CHANDELIER)
            content.addAfter(ModBlocks.CYAN_CHANDELIER, ModBlocks.LIGHT_BLUE_CHANDELIER)
            content.addAfter(ModBlocks.LIGHT_BLUE_CHANDELIER, ModBlocks.BLUE_CHANDELIER)
            content.addAfter(ModBlocks.BLUE_CHANDELIER, ModBlocks.PURPLE_CHANDELIER)
            content.addAfter(ModBlocks.PURPLE_CHANDELIER, ModBlocks.MAGENTA_CHANDELIER)
            content.addAfter(ModBlocks.MAGENTA_CHANDELIER, ModBlocks.PINK_CHANDELIER)

            // Table Saws
            content.addAfter(Items.STONECUTTER, ModBlocks.OAK_TABLE_SAW)
            content.addAfter(ModBlocks.OAK_TABLE_SAW, ModBlocks.SPRUCE_TABLE_SAW)
            content.addAfter(ModBlocks.SPRUCE_TABLE_SAW, ModBlocks.BIRCH_TABLE_SAW)
            content.addAfter(ModBlocks.BIRCH_TABLE_SAW, ModBlocks.JUNGLE_TABLE_SAW)
            content.addAfter(ModBlocks.JUNGLE_TABLE_SAW, ModBlocks.ACACIA_TABLE_SAW)
            content.addAfter(ModBlocks.ACACIA_TABLE_SAW, ModBlocks.DARK_OAK_TABLE_SAW)
            content.addAfter(ModBlocks.DARK_OAK_TABLE_SAW, ModBlocks.MANGROVE_TABLE_SAW)
            content.addAfter(ModBlocks.MANGROVE_TABLE_SAW, ModBlocks.CHERRY_TABLE_SAW)
            content.addAfter(ModBlocks.CHERRY_TABLE_SAW, ModBlocks.PALE_OAK_TABLE_SAW)
            content.addAfter(ModBlocks.PALE_OAK_TABLE_SAW, ModBlocks.BAMBOO_TABLE_SAW)
            content.addAfter(ModBlocks.BAMBOO_TABLE_SAW, ModBlocks.CRIMSON_TABLE_SAW)
            content.addAfter(ModBlocks.CRIMSON_TABLE_SAW, ModBlocks.WARPED_TABLE_SAW)
        }
    }

    fun registerNaturalToVanillaItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register { content ->
            content.addAfter(Items.OAK_LEAVES, ModBlocks.OAK_LEAF_HEDGE)
            content.addAfter(ModBlocks.OAK_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_OAK_LEAF_VENEERS)

            content.addAfter(Items.SPRUCE_LEAVES, ModBlocks.SPRUCE_LEAF_HEDGE)
            content.addAfter(ModBlocks.SPRUCE_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_SPRUCE_LEAF_VENEERS)

            content.addAfter(Items.BIRCH_LEAVES, ModBlocks.BIRCH_LEAF_HEDGE)
            content.addAfter(ModBlocks.BIRCH_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_BIRCH_LEAF_VENEERS)

            content.addAfter(Items.JUNGLE_LEAVES, ModBlocks.JUNGLE_LEAF_HEDGE)
            content.addAfter(ModBlocks.JUNGLE_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_JUNGLE_LEAF_VENEERS)

            content.addAfter(Items.ACACIA_LEAVES, ModBlocks.ACACIA_LEAF_HEDGE)
            content.addAfter(ModBlocks.ACACIA_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_ACACIA_LEAF_VENEERS)

            content.addAfter(Items.DARK_OAK_LEAVES, ModBlocks.DARK_OAK_LEAF_HEDGE)
            content.addAfter(ModBlocks.DARK_OAK_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_DARK_OAK_LEAF_VENEERS)

            content.addAfter(Items.MANGROVE_LEAVES, ModBlocks.MANGROVE_LEAF_HEDGE)
            content.addAfter(ModBlocks.MANGROVE_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_MANGROVE_LEAF_VENEERS)

            content.addAfter(Items.CHERRY_LEAVES, ModBlocks.CHERRY_LEAF_HEDGE)
            content.addAfter(ModBlocks.CHERRY_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_CHERRY_LEAF_VENEERS)

            content.addAfter(Items.PALE_OAK_LEAVES, ModBlocks.PALE_OAK_LEAF_HEDGE)
            content.addAfter(ModBlocks.PALE_OAK_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_PALE_OAK_LEAF_VENEERS)

            content.addAfter(Items.AZALEA_LEAVES, ModBlocks.AZALEA_LEAF_HEDGE)
            content.addAfter(ModBlocks.AZALEA_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_AZALEA_LEAF_VENEERS)

            content.addAfter(Items.FLOWERING_AZALEA_LEAVES, ModBlocks.FLOWERING_AZALEA_LEAF_HEDGE)
            content.addAfter(ModBlocks.FLOWERING_AZALEA_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_FLOWERING_AZALEA_LEAF_VENEERS)

            content.addAfter(ModBlocks.ECO_FRIENDLY_FLOWERING_AZALEA_LEAF_VENEERS, ModBlocks.BAMBOO_LEAVES)
            content.addAfter(ModBlocks.BAMBOO_LEAVES, ModBlocks.BAMBOO_LEAF_HEDGE)
            content.addAfter(ModBlocks.BAMBOO_LEAF_HEDGE, ModBlocks.ECO_FRIENDLY_BAMBOO_LEAF_VENEERS)

            content.addAfter(Items.NETHER_WART_BLOCK, ModBlocks.NETHER_WART_HEDGE)
            content.addAfter(ModBlocks.NETHER_WART_HEDGE, ModBlocks.ECO_FRIENDLY_NETHER_WART_VENEERS)

            content.addAfter(Items.WARPED_WART_BLOCK, ModBlocks.WARPED_WART_HEDGE)
            content.addAfter(ModBlocks.WARPED_WART_HEDGE, ModBlocks.ECO_FRIENDLY_WARPED_WART_VENEERS)

            content.addAfter(Items.MOSS_BLOCK, ModBlocks.MOSS_HEDGE)
            content.addAfter(ModBlocks.MOSS_HEDGE, ModBlocks.ECO_FRIENDLY_MOSS_VENEERS)

            content.addAfter(Items.PALE_MOSS_BLOCK, ModBlocks.PALE_MOSS_HEDGE)
            content.addAfter(ModBlocks.PALE_MOSS_HEDGE, ModBlocks.ECO_FRIENDLY_PALE_MOSS_VENEERS)

            content.addAfter(Items.GRASS_BLOCK, ModBlocks.ECO_FRIENDLY_GRASS_VENEERS)
        }
    }

    fun registerWoodToVanillaItemGroups() {
        // Oak
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.OAK_WOOD, ModBlocks.OAK_WOOD_STAIRS)
            content.addAfter(ModBlocks.OAK_WOOD_STAIRS, ModBlocks.OAK_WOOD_SLAB)
            content.addAfter(ModBlocks.OAK_WOOD_SLAB, ModBlocks.OAK_WOOD_WALL)
            content.addAfter(ModBlocks.OAK_WOOD_WALL, ModBlocks.OAK_WOOD_FENCE)
            content.addAfter(ModBlocks.OAK_WOOD_FENCE, ModBlocks.OAK_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.OAK_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_OAK_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_OAK_WOOD_VENEERS, ModBlocks.OAK_WOOD_FRAMEWORK)
            content.addAfter(Items.OAK_SLAB, ModBlocks.OAK_PLANK_WALL)
            content.addAfter(Items.OAK_FENCE_GATE, ModBlocks.ECO_FRIENDLY_OAK_PLANK_VENEERS)
        }

        // Spruce
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.SPRUCE_WOOD, ModBlocks.SPRUCE_WOOD_STAIRS)
            content.addAfter(ModBlocks.SPRUCE_WOOD_STAIRS, ModBlocks.SPRUCE_WOOD_SLAB)
            content.addAfter(ModBlocks.SPRUCE_WOOD_SLAB, ModBlocks.SPRUCE_WOOD_WALL)
            content.addAfter(ModBlocks.SPRUCE_WOOD_WALL, ModBlocks.SPRUCE_WOOD_FENCE)
            content.addAfter(ModBlocks.SPRUCE_WOOD_FENCE, ModBlocks.SPRUCE_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.SPRUCE_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_SPRUCE_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_SPRUCE_WOOD_VENEERS, ModBlocks.SPRUCE_WOOD_FRAMEWORK)
            content.addAfter(Items.SPRUCE_SLAB, ModBlocks.SPRUCE_PLANK_WALL)
            content.addAfter(Items.SPRUCE_FENCE_GATE, ModBlocks.ECO_FRIENDLY_SPRUCE_PLANK_VENEERS)
        }

        // Birch
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.BIRCH_WOOD, ModBlocks.BIRCH_WOOD_STAIRS)
            content.addAfter(ModBlocks.BIRCH_WOOD_STAIRS, ModBlocks.BIRCH_WOOD_SLAB)
            content.addAfter(ModBlocks.BIRCH_WOOD_SLAB, ModBlocks.BIRCH_WOOD_WALL)
            content.addAfter(ModBlocks.BIRCH_WOOD_WALL, ModBlocks.BIRCH_WOOD_FENCE)
            content.addAfter(ModBlocks.BIRCH_WOOD_FENCE, ModBlocks.BIRCH_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.BIRCH_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_BIRCH_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_BIRCH_WOOD_VENEERS, ModBlocks.BIRCH_WOOD_FRAMEWORK)
            content.addAfter(Items.BIRCH_SLAB, ModBlocks.BIRCH_PLANK_WALL)
            content.addAfter(Items.BIRCH_FENCE_GATE, ModBlocks.ECO_FRIENDLY_BIRCH_PLANK_VENEERS)
        }

        // Jungle
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.JUNGLE_WOOD, ModBlocks.JUNGLE_WOOD_STAIRS)
            content.addAfter(ModBlocks.JUNGLE_WOOD_STAIRS, ModBlocks.JUNGLE_WOOD_SLAB)
            content.addAfter(ModBlocks.JUNGLE_WOOD_SLAB, ModBlocks.JUNGLE_WOOD_WALL)
            content.addAfter(ModBlocks.JUNGLE_WOOD_WALL, ModBlocks.JUNGLE_WOOD_FENCE)
            content.addAfter(ModBlocks.JUNGLE_WOOD_FENCE, ModBlocks.JUNGLE_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.JUNGLE_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_JUNGLE_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_JUNGLE_WOOD_VENEERS, ModBlocks.JUNGLE_WOOD_FRAMEWORK)
            content.addAfter(Items.JUNGLE_SLAB, ModBlocks.JUNGLE_PLANK_WALL)
            content.addAfter(Items.JUNGLE_FENCE_GATE, ModBlocks.ECO_FRIENDLY_JUNGLE_PLANK_VENEERS)
        }

        // Acacia
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.ACACIA_WOOD, ModBlocks.ACACIA_WOOD_STAIRS)
            content.addAfter(ModBlocks.ACACIA_WOOD_STAIRS, ModBlocks.ACACIA_WOOD_SLAB)
            content.addAfter(ModBlocks.ACACIA_WOOD_SLAB, ModBlocks.ACACIA_WOOD_WALL)
            content.addAfter(ModBlocks.ACACIA_WOOD_WALL, ModBlocks.ACACIA_WOOD_FENCE)
            content.addAfter(ModBlocks.ACACIA_WOOD_FENCE, ModBlocks.ACACIA_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.ACACIA_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_ACACIA_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_ACACIA_WOOD_VENEERS, ModBlocks.ACACIA_WOOD_FRAMEWORK)
            content.addAfter(Items.ACACIA_SLAB, ModBlocks.ACACIA_PLANK_WALL)
            content.addAfter(Items.ACACIA_FENCE_GATE, ModBlocks.ECO_FRIENDLY_ACACIA_PLANK_VENEERS)
        }

        // Dark Oak
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.DARK_OAK_WOOD, ModBlocks.DARK_OAK_WOOD_STAIRS)
            content.addAfter(ModBlocks.DARK_OAK_WOOD_STAIRS, ModBlocks.DARK_OAK_WOOD_SLAB)
            content.addAfter(ModBlocks.DARK_OAK_WOOD_SLAB, ModBlocks.DARK_OAK_WOOD_WALL)
            content.addAfter(ModBlocks.DARK_OAK_WOOD_WALL, ModBlocks.DARK_OAK_WOOD_FENCE)
            content.addAfter(ModBlocks.DARK_OAK_WOOD_FENCE, ModBlocks.DARK_OAK_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.DARK_OAK_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_DARK_OAK_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_DARK_OAK_WOOD_VENEERS, ModBlocks.DARK_OAK_WOOD_FRAMEWORK)
            content.addAfter(Items.DARK_OAK_SLAB, ModBlocks.DARK_OAK_PLANK_WALL)
            content.addAfter(Items.DARK_OAK_FENCE_GATE, ModBlocks.ECO_FRIENDLY_DARK_OAK_PLANK_VENEERS)
        }

        // Mangrove
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.MANGROVE_WOOD, ModBlocks.MANGROVE_WOOD_STAIRS)
            content.addAfter(ModBlocks.MANGROVE_WOOD_STAIRS, ModBlocks.MANGROVE_WOOD_SLAB)
            content.addAfter(ModBlocks.MANGROVE_WOOD_SLAB, ModBlocks.MANGROVE_WOOD_WALL)
            content.addAfter(ModBlocks.MANGROVE_WOOD_WALL, ModBlocks.MANGROVE_WOOD_FENCE)
            content.addAfter(ModBlocks.MANGROVE_WOOD_FENCE, ModBlocks.MANGROVE_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.MANGROVE_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_MANGROVE_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_MANGROVE_WOOD_VENEERS, ModBlocks.MANGROVE_WOOD_FRAMEWORK)
            content.addAfter(Items.MANGROVE_SLAB, ModBlocks.MANGROVE_PLANK_WALL)
            content.addAfter(Items.MANGROVE_FENCE_GATE, ModBlocks.ECO_FRIENDLY_MANGROVE_PLANK_VENEERS)
        }

        // Cherry
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.CHERRY_WOOD, ModBlocks.CHERRY_WOOD_STAIRS)
            content.addAfter(ModBlocks.CHERRY_WOOD_STAIRS, ModBlocks.CHERRY_WOOD_SLAB)
            content.addAfter(ModBlocks.CHERRY_WOOD_SLAB, ModBlocks.CHERRY_WOOD_WALL)
            content.addAfter(ModBlocks.CHERRY_WOOD_WALL, ModBlocks.CHERRY_WOOD_FENCE)
            content.addAfter(ModBlocks.CHERRY_WOOD_FENCE, ModBlocks.CHERRY_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.CHERRY_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_CHERRY_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_CHERRY_WOOD_VENEERS, ModBlocks.CHERRY_WOOD_FRAMEWORK)
            content.addAfter(Items.CHERRY_SLAB, ModBlocks.CHERRY_PLANK_WALL)
            content.addAfter(Items.CHERRY_FENCE_GATE, ModBlocks.ECO_FRIENDLY_CHERRY_PLANK_VENEERS)
        }

        // Pale Oak
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.PALE_OAK_WOOD, ModBlocks.PALE_OAK_WOOD_STAIRS)
            content.addAfter(ModBlocks.PALE_OAK_WOOD_STAIRS, ModBlocks.PALE_OAK_WOOD_SLAB)
            content.addAfter(ModBlocks.PALE_OAK_WOOD_SLAB, ModBlocks.PALE_OAK_WOOD_WALL)
            content.addAfter(ModBlocks.PALE_OAK_WOOD_WALL, ModBlocks.PALE_OAK_WOOD_FENCE)
            content.addAfter(ModBlocks.PALE_OAK_WOOD_FENCE, ModBlocks.PALE_OAK_WOOD_FENCE_GATE)
            content.addAfter(ModBlocks.PALE_OAK_WOOD_FENCE_GATE, ModBlocks.ECO_FRIENDLY_PALE_OAK_WOOD_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_PALE_OAK_WOOD_VENEERS, ModBlocks.PALE_OAK_WOOD_FRAMEWORK)
            content.addAfter(Items.PALE_OAK_SLAB, ModBlocks.PALE_OAK_PLANK_WALL)
            content.addAfter(Items.PALE_OAK_FENCE_GATE, ModBlocks.ECO_FRIENDLY_PALE_OAK_PLANK_VENEERS)
        }

        // Bamboo
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.BAMBOO_BLOCK, ModBlocks.BAMBOO_STEM_STAIRS)
            content.addAfter(ModBlocks.BAMBOO_STEM_STAIRS, ModBlocks.BAMBOO_STEM_SLAB)
            content.addAfter(ModBlocks.BAMBOO_STEM_SLAB, ModBlocks.BAMBOO_STEM_WALL)
            content.addAfter(ModBlocks.BAMBOO_STEM_WALL, ModBlocks.BAMBOO_STEM_FENCE)
            content.addAfter(ModBlocks.BAMBOO_STEM_FENCE, ModBlocks.BAMBOO_STEM_FENCE_GATE)
            content.addAfter(ModBlocks.BAMBOO_STEM_FENCE_GATE, ModBlocks.ECO_FRIENDLY_BAMBOO_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_BAMBOO_VENEERS, ModBlocks.BAMBOO_FRAMEWORK)
            content.addAfter(Items.BAMBOO_SLAB, ModBlocks.BAMBOO_PLANK_WALL)
            content.addAfter(Items.BAMBOO_FENCE_GATE, ModBlocks.ECO_FRIENDLY_BAMBOO_PLANK_VENEERS)
        }

        // Crimson
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.CRIMSON_HYPHAE, ModBlocks.CRIMSON_HYPHAE_STAIRS)
            content.addAfter(ModBlocks.CRIMSON_HYPHAE_STAIRS, ModBlocks.CRIMSON_HYPHAE_SLAB)
            content.addAfter(ModBlocks.CRIMSON_HYPHAE_SLAB, ModBlocks.CRIMSON_HYPHAE_WALL)
            content.addAfter(ModBlocks.CRIMSON_HYPHAE_WALL, ModBlocks.CRIMSON_HYPHAE_FENCE)
            content.addAfter(ModBlocks.CRIMSON_HYPHAE_FENCE, ModBlocks.CRIMSON_HYPHAE_FENCE_GATE)
            content.addAfter(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE, ModBlocks.ECO_FRIENDLY_CRIMSON_HYPHAE_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_CRIMSON_HYPHAE_VENEERS, ModBlocks.CRIMSON_HYPHAE_FRAMEWORK)
            content.addAfter(Items.CRIMSON_SLAB, ModBlocks.CRIMSON_PLANK_WALL)
            content.addAfter(Items.CRIMSON_FENCE_GATE, ModBlocks.ECO_FRIENDLY_CRIMSON_PLANK_VENEERS)
        }

        // Warped
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register { content ->
            content.addAfter(Items.WARPED_HYPHAE, ModBlocks.WARPED_HYPHAE_STAIRS)
            content.addAfter(ModBlocks.WARPED_HYPHAE_STAIRS, ModBlocks.WARPED_HYPHAE_SLAB)
            content.addAfter(ModBlocks.WARPED_HYPHAE_SLAB, ModBlocks.WARPED_HYPHAE_WALL)
            content.addAfter(ModBlocks.WARPED_HYPHAE_WALL, ModBlocks.WARPED_HYPHAE_FENCE)
            content.addAfter(ModBlocks.WARPED_HYPHAE_FENCE, ModBlocks.WARPED_HYPHAE_FENCE_GATE)
            content.addAfter(ModBlocks.WARPED_HYPHAE_FENCE_GATE, ModBlocks.ECO_FRIENDLY_WARPED_HYPHAE_VENEERS)
            content.addAfter(ModBlocks.ECO_FRIENDLY_WARPED_HYPHAE_VENEERS, ModBlocks.WARPED_HYPHAE_FRAMEWORK)
            content.addAfter(Items.WARPED_SLAB, ModBlocks.WARPED_PLANK_WALL)
            content.addAfter(Items.WARPED_FENCE_GATE, ModBlocks.ECO_FRIENDLY_WARPED_PLANK_VENEERS)
        }
    }



    // --- --- --- --- --- //

    fun <T : Item> registerItem(
        name: String,
        factory: (Item.Settings) -> T
    ): T = registerItem(Identifier.of(LittleJohns.MOD_ID, name), factory)

    fun <T : Item> registerItem(
        id: Identifier,
        factory: (Item.Settings) -> T
    ): T {
        val item = factory(Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)))
        return Registry.register(Registries.ITEM, id, item)
    }

    fun registerAll() {
        LittleJohns.LOGGER.info("Registering mod items for ${LittleJohns.MOD_ID}")

        registerBuildingBlocksToVanillaItemGroups()
        registerIngredientsToVanillaItemGroups()
        registerToolsUtilitiesToVanillaItemGroups()
        registerColoredToVanillaItemGroups()
        registerFunctionalToVanillaItemGroups()
        registerNaturalToVanillaItemGroups()
        registerWoodToVanillaItemGroups()

    }
}