package net.echo.little_johns.datagen

import net.echo.little_johns.block.ModBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider
import net.minecraft.block.Blocks
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModBlockLootTableProvider(
    dataOutput: FabricDataOutput,
    registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricBlockLootTableProvider(dataOutput, registryLookup) {

    override fun generate() {

        addDrop(ModBlocks.CHANDELIER)
        addDrop(ModBlocks.WHITE_CHANDELIER)
        addDrop(ModBlocks.LIGHT_GRAY_CHANDELIER)
        addDrop(ModBlocks.GRAY_CHANDELIER)
        addDrop(ModBlocks.BLACK_CHANDELIER)
        addDrop(ModBlocks.BROWN_CHANDELIER)
        addDrop(ModBlocks.RED_CHANDELIER)
        addDrop(ModBlocks.ORANGE_CHANDELIER)
        addDrop(ModBlocks.YELLOW_CHANDELIER)
        addDrop(ModBlocks.LIME_CHANDELIER)
        addDrop(ModBlocks.GREEN_CHANDELIER)
        addDrop(ModBlocks.CYAN_CHANDELIER)
        addDrop(ModBlocks.LIGHT_BLUE_CHANDELIER)
        addDrop(ModBlocks.BLUE_CHANDELIER)
        addDrop(ModBlocks.PURPLE_CHANDELIER)
        addDrop(ModBlocks.MAGENTA_CHANDELIER)
        addDrop(ModBlocks.PINK_CHANDELIER)


        addDrop(ModBlocks.OAK_TABLE_SAW)
        addDrop(ModBlocks.SPRUCE_TABLE_SAW)
        addDrop(ModBlocks.BIRCH_TABLE_SAW)
        addDrop(ModBlocks.JUNGLE_TABLE_SAW)
        addDrop(ModBlocks.ACACIA_TABLE_SAW)
        addDrop(ModBlocks.DARK_OAK_TABLE_SAW)
        addDrop(ModBlocks.MANGROVE_TABLE_SAW)
        addDrop(ModBlocks.CHERRY_TABLE_SAW)
        addDrop(ModBlocks.PALE_OAK_TABLE_SAW)
        addDrop(ModBlocks.BAMBOO_TABLE_SAW)
        addDrop(ModBlocks.CRIMSON_TABLE_SAW)
        addDrop(ModBlocks.WARPED_TABLE_SAW)

        addDrop(ModBlocks.GRAND_CHAIN)
        addDrop(ModBlocks.COLOSSAL_CHAIN)
        addDrop(ModBlocks.GOLDEN_CHAIN)
        addDrop(ModBlocks.GOLDEN_GRAND_CHAIN)
        addDrop(ModBlocks.GOLDEN_COLOSSAL_CHAIN)


        addDrop(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK)
        addDrop(ModBlocks.GALVANIZED_SQUARE_STEEL_STAIRS)
        addDrop(ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB, slabDrops(ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB))
        addDrop(ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM)
        addDrop(ModBlocks.GALVANIZED_SQUARE_STEEL) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.GALVANIZED_SQUARE_STEEL_GRATE) { block -> multifaceGrowthDrops(block) }


        addDrop(ModBlocks.OAK_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.SPRUCE_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.BIRCH_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.JUNGLE_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ACACIA_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.DARK_OAK_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.MANGROVE_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.CHERRY_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.PALE_OAK_WOOD_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.BAMBOO_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.CRIMSON_HYPHAE_FRAMEWORK) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.WARPED_HYPHAE_FRAMEWORK) { block -> multifaceGrowthDrops(block) }

        addDrop(ModBlocks.ECO_FRIENDLY_OAK_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_SPRUCE_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_BIRCH_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_JUNGLE_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_ACACIA_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_DARK_OAK_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_MANGROVE_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_CHERRY_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_PALE_OAK_WOOD_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_BAMBOO_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_CRIMSON_HYPHAE_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_WARPED_HYPHAE_VENEERS) { block -> multifaceGrowthDrops(block) }

        addDrop(ModBlocks.ECO_FRIENDLY_OAK_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_SPRUCE_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_BIRCH_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_JUNGLE_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_ACACIA_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_DARK_OAK_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_MANGROVE_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_CHERRY_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_PALE_OAK_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_BAMBOO_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_CRIMSON_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_WARPED_PLANK_VENEERS) { block -> multifaceGrowthDrops(block) }


        addDrop(ModBlocks.ECO_FRIENDLY_OAK_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_SPRUCE_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_BIRCH_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_JUNGLE_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_ACACIA_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_DARK_OAK_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_MANGROVE_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_CHERRY_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_PALE_OAK_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_AZALEA_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_FLOWERING_AZALEA_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }
        addDrop(ModBlocks.ECO_FRIENDLY_BAMBOO_LEAF_VENEERS) { block -> multifaceGrowthDrops(block, createWithSilkTouchOrShearsCondition()) }

        addDrop(ModBlocks.ECO_FRIENDLY_NETHER_WART_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_WARPED_WART_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_MOSS_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_PALE_MOSS_VENEERS) { block -> multifaceGrowthDrops(block) }
        addDrop(ModBlocks.ECO_FRIENDLY_GRASS_VENEERS) { block -> multifaceGrowthDrops(block) }



        addDrop(ModBlocks.OAK_LEAF_HEDGE) { block -> oakLeavesDrops(block, Blocks.OAK_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.SPRUCE_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.SPRUCE_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.BIRCH_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.BIRCH_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.JUNGLE_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.JUNGLE_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.ACACIA_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.ACACIA_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.DARK_OAK_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.DARK_OAK_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.MANGROVE_LEAF_HEDGE) { block -> mangroveLeavesDrops(block) }
        addDrop(ModBlocks.CHERRY_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.CHERRY_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.PALE_OAK_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.PALE_OAK_SAPLING, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.AZALEA_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.AZALEA, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.FLOWERING_AZALEA_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.FLOWERING_AZALEA, *SAPLING_DROP_CHANCE) }
        addDrop(ModBlocks.BAMBOO_LEAF_HEDGE) { block -> leavesDrops(block, Blocks.BAMBOO, *SAPLING_DROP_CHANCE) }

        addDrop(ModBlocks.NETHER_WART_HEDGE)
        addDrop(ModBlocks.WARPED_WART_HEDGE)
        addDrop(ModBlocks.MOSS_HEDGE)
        addDrop(ModBlocks.PALE_MOSS_HEDGE)



        addDrop(ModBlocks.OAK_WOOD_WALL)
        addDrop(ModBlocks.SPRUCE_WOOD_WALL)
        addDrop(ModBlocks.BIRCH_WOOD_WALL)
        addDrop(ModBlocks.JUNGLE_WOOD_WALL)
        addDrop(ModBlocks.ACACIA_WOOD_WALL)
        addDrop(ModBlocks.DARK_OAK_WOOD_WALL)
        addDrop(ModBlocks.MANGROVE_WOOD_WALL)
        addDrop(ModBlocks.CHERRY_WOOD_WALL)
        addDrop(ModBlocks.PALE_OAK_WOOD_WALL)
        addDrop(ModBlocks.BAMBOO_STEM_WALL)
        addDrop(ModBlocks.CRIMSON_HYPHAE_WALL)
        addDrop(ModBlocks.WARPED_HYPHAE_WALL)

        addDrop(ModBlocks.OAK_PLANK_WALL)
        addDrop(ModBlocks.SPRUCE_PLANK_WALL)
        addDrop(ModBlocks.BIRCH_PLANK_WALL)
        addDrop(ModBlocks.JUNGLE_PLANK_WALL)
        addDrop(ModBlocks.ACACIA_PLANK_WALL)
        addDrop(ModBlocks.DARK_OAK_PLANK_WALL)
        addDrop(ModBlocks.MANGROVE_PLANK_WALL)
        addDrop(ModBlocks.CHERRY_PLANK_WALL)
        addDrop(ModBlocks.PALE_OAK_PLANK_WALL)
        addDrop(ModBlocks.BAMBOO_PLANK_WALL)
        addDrop(ModBlocks.CRIMSON_PLANK_WALL)
        addDrop(ModBlocks.WARPED_PLANK_WALL)


        addDrop(ModBlocks.OAK_WOOD_FENCE)
        addDrop(ModBlocks.SPRUCE_WOOD_FENCE)
        addDrop(ModBlocks.BIRCH_WOOD_FENCE)
        addDrop(ModBlocks.JUNGLE_WOOD_FENCE)
        addDrop(ModBlocks.ACACIA_WOOD_FENCE)
        addDrop(ModBlocks.DARK_OAK_WOOD_FENCE)
        addDrop(ModBlocks.MANGROVE_WOOD_FENCE)
        addDrop(ModBlocks.CHERRY_WOOD_FENCE)
        addDrop(ModBlocks.PALE_OAK_WOOD_FENCE)
        addDrop(ModBlocks.BAMBOO_STEM_FENCE)
        addDrop(ModBlocks.CRIMSON_HYPHAE_FENCE)
        addDrop(ModBlocks.WARPED_HYPHAE_FENCE)

        addDrop(ModBlocks.OAK_WOOD_FENCE_GATE)
        addDrop(ModBlocks.SPRUCE_WOOD_FENCE_GATE)
        addDrop(ModBlocks.BIRCH_WOOD_FENCE_GATE)
        addDrop(ModBlocks.JUNGLE_WOOD_FENCE_GATE)
        addDrop(ModBlocks.ACACIA_WOOD_FENCE_GATE)
        addDrop(ModBlocks.DARK_OAK_WOOD_FENCE_GATE)
        addDrop(ModBlocks.MANGROVE_WOOD_FENCE_GATE)
        addDrop(ModBlocks.CHERRY_WOOD_FENCE_GATE)
        addDrop(ModBlocks.PALE_OAK_WOOD_FENCE_GATE)
        addDrop(ModBlocks.BAMBOO_STEM_FENCE_GATE)
        addDrop(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE)
        addDrop(ModBlocks.WARPED_HYPHAE_FENCE_GATE)


        addDrop(ModBlocks.OAK_WOOD_STAIRS)
        addDrop(ModBlocks.SPRUCE_WOOD_STAIRS)
        addDrop(ModBlocks.BIRCH_WOOD_STAIRS)
        addDrop(ModBlocks.JUNGLE_WOOD_STAIRS)
        addDrop(ModBlocks.ACACIA_WOOD_STAIRS)
        addDrop(ModBlocks.DARK_OAK_WOOD_STAIRS)
        addDrop(ModBlocks.MANGROVE_WOOD_STAIRS)
        addDrop(ModBlocks.CHERRY_WOOD_STAIRS)
        addDrop(ModBlocks.PALE_OAK_WOOD_STAIRS)
        addDrop(ModBlocks.BAMBOO_STEM_STAIRS)
        addDrop(ModBlocks.CRIMSON_HYPHAE_STAIRS)
        addDrop(ModBlocks.WARPED_HYPHAE_STAIRS)

        addDrop(ModBlocks.OAK_WOOD_SLAB, slabDrops(ModBlocks.OAK_WOOD_SLAB))
        addDrop(ModBlocks.SPRUCE_WOOD_SLAB, slabDrops(ModBlocks.SPRUCE_WOOD_SLAB))
        addDrop(ModBlocks.BIRCH_WOOD_SLAB, slabDrops(ModBlocks.BIRCH_WOOD_SLAB))
        addDrop(ModBlocks.JUNGLE_WOOD_SLAB, slabDrops(ModBlocks.JUNGLE_WOOD_SLAB))
        addDrop(ModBlocks.ACACIA_WOOD_SLAB, slabDrops(ModBlocks.ACACIA_WOOD_SLAB))
        addDrop(ModBlocks.DARK_OAK_WOOD_SLAB, slabDrops(ModBlocks.DARK_OAK_WOOD_SLAB))
        addDrop(ModBlocks.MANGROVE_WOOD_SLAB, slabDrops(ModBlocks.MANGROVE_WOOD_SLAB))
        addDrop(ModBlocks.CHERRY_WOOD_SLAB, slabDrops(ModBlocks.CHERRY_WOOD_SLAB))
        addDrop(ModBlocks.PALE_OAK_WOOD_SLAB, slabDrops(ModBlocks.PALE_OAK_WOOD_SLAB))
        addDrop(ModBlocks.BAMBOO_STEM_SLAB, slabDrops(ModBlocks.BAMBOO_STEM_SLAB))
        addDrop(ModBlocks.CRIMSON_HYPHAE_SLAB, slabDrops(ModBlocks.CRIMSON_HYPHAE_SLAB))
        addDrop(ModBlocks.WARPED_HYPHAE_STAIRS, slabDrops(ModBlocks.WARPED_HYPHAE_SLAB))




    }
}