package net.echo.little_johns.datagen

import net.echo.little_johns.block.ModBlocks
import net.echo.little_johns.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.advancement.AdvancementCriterion
import net.minecraft.advancement.criterion.InventoryChangedCriterion
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.data.recipe.RecipeExporter
import net.minecraft.data.recipe.RecipeGenerator
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder
import net.minecraft.data.recipe.StonecuttingRecipeJsonBuilder
import net.minecraft.item.Item
import net.minecraft.item.ItemConvertible
import net.minecraft.item.Items
import net.minecraft.predicate.item.ItemPredicate
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.book.RecipeCategory
import net.minecraft.registry.Registries
import net.minecraft.registry.RegistryEntryLookup
import net.minecraft.registry.RegistryKeys
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(
    output: FabricDataOutput,
    registriesFuture: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricRecipeProvider(output, registriesFuture) {


    companion object {
        private lateinit var itemLookup: RegistryEntryLookup<Item>

        fun conditionsFromItem(item: ItemConvertible): AdvancementCriterion<InventoryChangedCriterion.Conditions> {
            return RecipeGenerator.conditionsFromPredicates(ItemPredicate.Builder.create().items(itemLookup, item))
        }

        fun offerCuttingRecipe(
            exporter: RecipeExporter,
            category: RecipeCategory,
            output: ItemConvertible,
            input: ItemConvertible,
            count: Int
        ) {
            StonecuttingRecipeJsonBuilder
                .createStonecutting(Ingredient.ofItems(input), category, output, count)
                .criterion("has_${getItemPath(input)}", conditionsFromItem(input))
                .offerTo(exporter, "${getItemPath(output)}_from_${getItemPath(input)}_stonecutting")
        }

        fun getItemPath(item: ItemConvertible): String {
            return Registries.ITEM.getId(item.asItem()).path
        }
    }




    override fun getRecipeGenerator(
        registryLookup: RegistryWrapper.WrapperLookup,
        exporter: RecipeExporter
    ): RecipeGenerator {
        itemLookup = registryLookup.getOrThrow(RegistryKeys.ITEM)

        return object : RecipeGenerator(registryLookup, exporter) {

            override fun generate() {

                val itemLookup = registries.getOrThrow<Item>(RegistryKeys.ITEM)




                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK, 1)
                    .input('G', ModBlocks.GALVANIZED_SQUARE_STEEL)
                    .input('B', ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM)
                    .input('S', ModItems.BORROWED_SCREWS)
                    .pattern("SGS")
                    .pattern("GBG")
                    .pattern("SGS")
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);


                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM, 1)
                    .input('#', Items.IRON_INGOT)
                    .pattern("#")
                    .pattern("#")
                    .pattern("#")
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GALVANIZED_SQUARE_STEEL, 4)
                    .input('#', ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM)
                    .input('S', ModItems.BORROWED_SCREWS)
                    .pattern("S#S")
                    .pattern("#S#")
                    .pattern("S#S")
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GALVANIZED_SQUARE_STEEL_GRATE, 4)
                    .input('#', ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM)
                    .input('S', ModItems.BORROWED_SCREWS)
                    .pattern("#S#")
                    .pattern("S#S")
                    .pattern("#S#")
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);

                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.BORROWED_SCREWS, 4)
                    .input('I', Items.IRON_INGOT)
                    .input('N', Items.IRON_NUGGET)
                    .pattern("  ")
                    .pattern(" I")
                    .pattern("N ")
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);


                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.OAK_TABLE_SAW, 1, Items.STICK, Blocks.OAK_SLAB, Items.IRON_INGOT, "has_oak_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.SPRUCE_TABLE_SAW, 1, Items.STICK, Blocks.SPRUCE_SLAB, Items.IRON_INGOT, "has_spruce_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.BIRCH_TABLE_SAW, 1, Items.STICK, Blocks.BIRCH_SLAB, Items.IRON_INGOT, "has_birch_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.JUNGLE_TABLE_SAW, 1, Items.STICK, Blocks.JUNGLE_SLAB, Items.IRON_INGOT, "has_jungle_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.ACACIA_TABLE_SAW, 1, Items.STICK, Blocks.ACACIA_SLAB, Items.IRON_INGOT, "has_acacia_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.DARK_OAK_TABLE_SAW, 1, Items.STICK, Blocks.DARK_OAK_SLAB, Items.IRON_INGOT, "has_dark_oak_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.MANGROVE_TABLE_SAW, 1, Items.STICK, Blocks.MANGROVE_SLAB, Items.IRON_INGOT, "has_mangrove_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.CHERRY_TABLE_SAW, 1, Items.STICK, Blocks.CHERRY_SLAB, Items.IRON_INGOT, "has_cherry_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.PALE_OAK_TABLE_SAW, 1, Items.STICK, Blocks.PALE_OAK_SLAB, Items.IRON_INGOT, "has_pale_oak_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.BAMBOO_TABLE_SAW, 1, Items.STICK, Blocks.BAMBOO_SLAB, Items.IRON_INGOT, "has_bamboo_slab", "has_iron_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.CRIMSON_TABLE_SAW, 1, Items.STICK, Blocks.CRIMSON_SLAB, Items.GOLD_INGOT, "has_crimson_slab", "has_gold_ingot", exporter);
                offerTableSawBlockRecipe(RecipeCategory.MISC, ModBlocks.WARPED_TABLE_SAW, 1, Items.STICK, Blocks.WARPED_SLAB, Items.GOLD_INGOT, "has_warped_slab", "has_gold_ingot", exporter);

                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.OAK_LOG, "has_oak_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.SPRUCE_LOG, "has_spruce_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.BIRCH_LOG, "has_birch_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.JUNGLE_LOG, "has_jungle_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.ACACIA_LOG, "has_acacia_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.DARK_OAK_LOG, "has_dark_oak_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.MANGROVE_LOG, "has_mangrove_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.CHERRY_LOG, "has_cherry_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_WOOD_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.PALE_OAK_LOG, "has_pale_oak_log", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.BAMBOO_BLOCK, "has_bamboo_block", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_HYPHAE_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.CRIMSON_STEM, "has_crimson_stem", exporter);
                offerCrossRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_HYPHAE_FRAMEWORK, 8, Block.getBlockFromItem(Items.STRING), Blocks.WARPED_STEM, "has_warped_stem", exporter);

                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_OAK_PLANK_VENEERS, 16, Blocks.OAK_PLANKS, "has_oak_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_SPRUCE_PLANK_VENEERS, 16, Blocks.SPRUCE_PLANKS, "has_spruce_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_BIRCH_PLANK_VENEERS, 16, Blocks.BIRCH_PLANKS, "has_birch_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_JUNGLE_PLANK_VENEERS, 16, Blocks.JUNGLE_PLANKS, "has_jungle_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_ACACIA_PLANK_VENEERS, 16, Blocks.ACACIA_PLANKS, "has_acacia_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_DARK_OAK_PLANK_VENEERS, 16, Blocks.DARK_OAK_PLANKS, "has_dark_oak_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_MANGROVE_PLANK_VENEERS, 16, Blocks.MANGROVE_PLANKS, "has_mangrove_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_CHERRY_PLANK_VENEERS, 16, Blocks.CHERRY_PLANKS, "has_cherry_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_PALE_OAK_PLANK_VENEERS, 16, Blocks.PALE_OAK_PLANKS, "has_pale_oak_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_BAMBOO_PLANK_VENEERS, 16, Blocks.BAMBOO_BLOCK, "has_bamboo_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_CRIMSON_PLANK_VENEERS, 16, Blocks.CRIMSON_PLANKS, "has_crimson_planks", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_WARPED_PLANK_VENEERS, 16, Blocks.WARPED_PLANKS, "has_warped_planks", exporter);

                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_OAK_WOOD_VENEERS, 16, Blocks.OAK_LOG, "has_oak_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_SPRUCE_WOOD_VENEERS, 16, Blocks.SPRUCE_LOG, "has_spruce_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_BIRCH_WOOD_VENEERS, 16, Blocks.BIRCH_LOG, "has_birch_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_JUNGLE_WOOD_VENEERS, 16, Blocks.JUNGLE_LOG, "has_jungle_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_ACACIA_WOOD_VENEERS, 16, Blocks.ACACIA_LOG, "has_acacia_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_DARK_OAK_WOOD_VENEERS, 16, Blocks.DARK_OAK_LOG, "has_dark_oak_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_MANGROVE_WOOD_VENEERS, 16, Blocks.MANGROVE_LOG, "has_mangrove_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_CHERRY_WOOD_VENEERS, 16, Blocks.CHERRY_LOG, "has_cherry_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_PALE_OAK_WOOD_VENEERS, 16, Blocks.PALE_OAK_LOG, "has_pale_oak_log", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_BAMBOO_VENEERS, 16, Blocks.BAMBOO_BLOCK, "has_bamboo_block", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_CRIMSON_HYPHAE_VENEERS, 16, Blocks.CRIMSON_STEM, "has_crimson_stem", exporter);
                offerEcoFriendlyWoodVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_WARPED_HYPHAE_VENEERS, 16, Blocks.WARPED_STEM, "has_warped_stem", exporter);

                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_OAK_LEAF_VENEERS, 16, Blocks.OAK_LEAVES, "has_oak_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_SPRUCE_LEAF_VENEERS, 16, Blocks.SPRUCE_LEAVES, "has_spruce_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_BIRCH_LEAF_VENEERS, 16, Blocks.BIRCH_LEAVES, "has_birch_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_JUNGLE_LEAF_VENEERS, 16, Blocks.JUNGLE_LEAVES, "has_jungle_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_ACACIA_LEAF_VENEERS, 16, Blocks.ACACIA_LEAVES, "has_acacia_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_DARK_OAK_LEAF_VENEERS, 16, Blocks.DARK_OAK_LEAVES, "has_dark_oak_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_MANGROVE_LEAF_VENEERS, 16, Blocks.MANGROVE_LEAVES, "has_mangrove_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_CHERRY_LEAF_VENEERS, 16, Blocks.CHERRY_LEAVES, "has_cherry_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_PALE_OAK_LEAF_VENEERS, 16, Blocks.PALE_OAK_LEAVES, "has_pale_oak_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_AZALEA_LEAF_VENEERS, 16, Blocks.AZALEA_LEAVES, "has_azalea_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_FLOWERING_AZALEA_LEAF_VENEERS, 16, Blocks.FLOWERING_AZALEA_LEAVES, "has_flowering_azalea_leaves", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_BAMBOO_LEAF_VENEERS, 16, ModBlocks.BAMBOO_LEAVES, "has_bamboo_leaves", exporter);
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_LEAVES, 4)
                    .input('B', Items.BAMBOO)
                    .input('L', Items.STRING)
                    .pattern("BLB")
                    .pattern("LBL")
                    .pattern("BLB")
                    .criterion("has_bamboo", conditionsFromItem(Items.BAMBOO)).offerTo(exporter);



                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_NETHER_WART_VENEERS, 16, Blocks.NETHER_WART_BLOCK, "has_nether_wart_block", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_WARPED_WART_VENEERS, 16, Blocks.WARPED_WART_BLOCK, "has_warped_wart_block", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_MOSS_VENEERS, 16, Blocks.MOSS_BLOCK, "has_moss_block", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_PALE_MOSS_VENEERS, 16, Blocks.PALE_MOSS_BLOCK, "has_pale_moss_block", exporter);
                offerEcoFriendlyLeafVeneersRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ECO_FRIENDLY_GRASS_VENEERS, 16, Blocks.GRASS_BLOCK, "has_moss_block", exporter);


                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_PLANK_WALL, Blocks.OAK_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_PLANK_WALL, Blocks.SPRUCE_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_PLANK_WALL, Blocks.BIRCH_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_PLANK_WALL, Blocks.JUNGLE_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_PLANK_WALL, Blocks.ACACIA_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_PLANK_WALL, Blocks.DARK_OAK_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_PLANK_WALL, Blocks.MANGROVE_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_PLANK_WALL, Blocks.CHERRY_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_PLANK_WALL, Blocks.PALE_OAK_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_PLANK_WALL, Blocks.BAMBOO_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_PLANK_WALL, Blocks.CRIMSON_PLANKS, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_PLANK_WALL, Blocks.WARPED_PLANKS, exporter);

                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_WOOD_WALL, Blocks.OAK_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_WOOD_WALL, Blocks.SPRUCE_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_WOOD_WALL, Blocks.BIRCH_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_WOOD_WALL, Blocks.JUNGLE_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_WOOD_WALL, Blocks.ACACIA_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_WOOD_WALL, Blocks.DARK_OAK_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_WOOD_WALL, Blocks.MANGROVE_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_WOOD_WALL, Blocks.CHERRY_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_WOOD_WALL, Blocks.PALE_OAK_LOG, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_STEM_WALL, Blocks.BAMBOO_BLOCK, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_HYPHAE_WALL, Blocks.CRIMSON_STEM, exporter);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_HYPHAE_WALL, Blocks.WARPED_STEM, exporter);


                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OAK_LEAF_HEDGE, Blocks.OAK_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPRUCE_LEAF_HEDGE, Blocks.SPRUCE_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BIRCH_LEAF_HEDGE, Blocks.BIRCH_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JUNGLE_LEAF_HEDGE, Blocks.JUNGLE_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ACACIA_LEAF_HEDGE, Blocks.ACACIA_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_OAK_LEAF_HEDGE, Blocks.DARK_OAK_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MANGROVE_LEAF_HEDGE, Blocks.MANGROVE_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHERRY_LEAF_HEDGE, Blocks.CHERRY_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_OAK_LEAF_HEDGE, Blocks.PALE_OAK_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_LEAF_HEDGE, Blocks.AZALEA_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.FLOWERING_AZALEA_LEAF_HEDGE, Blocks.FLOWERING_AZALEA_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSS_HEDGE, Blocks.MOSS_BLOCK, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALE_MOSS_HEDGE, Blocks.PALE_MOSS_BLOCK, exporter);


                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BAMBOO_LEAF_HEDGE, ModBlocks.BAMBOO_LEAVES, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHER_WART_HEDGE, Blocks.NETHER_WART_BLOCK, exporter);
                offerHedgeRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_WART_HEDGE, Blocks.WARPED_WART_BLOCK, exporter);



                offerFenceRecipe(Blocks.OAK_LOG, ModBlocks.OAK_WOOD_FENCE, "has_oak_log", exporter);
                offerFenceRecipe(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_WOOD_FENCE, "has_spruce_log", exporter);
                offerFenceRecipe(Blocks.BIRCH_LOG, ModBlocks.BIRCH_WOOD_FENCE, "has_birch_log", exporter);
                offerFenceRecipe(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_WOOD_FENCE, "has_jungle_log", exporter);
                offerFenceRecipe(Blocks.ACACIA_LOG, ModBlocks.ACACIA_WOOD_FENCE, "has_acacia_log", exporter);
                offerFenceRecipe(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_WOOD_FENCE, "has_dark_oak_log", exporter);
                offerFenceRecipe(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_WOOD_FENCE, "has_mangrove_log", exporter);
                offerFenceRecipe(Blocks.CHERRY_LOG, ModBlocks.CHERRY_WOOD_FENCE, "has_cherry_log", exporter);
                offerFenceRecipe(Blocks.PALE_OAK_LOG, ModBlocks.PALE_OAK_WOOD_FENCE, "has_pale_oak_log", exporter);
                offerFenceRecipe(Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_STEM_FENCE, "has_bamboo_block", exporter);
                offerFenceRecipe(Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_HYPHAE_FENCE, "has_crimson_stem", exporter);
                offerFenceRecipe(Blocks.WARPED_STEM, ModBlocks.WARPED_HYPHAE_FENCE, "has_warped_stem", exporter);

                offerFenceGateRecipe(Blocks.OAK_LOG, ModBlocks.OAK_WOOD_FENCE_GATE, "has_oak_log", exporter);
                offerFenceGateRecipe(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_WOOD_FENCE_GATE, "has_spruce_log", exporter);
                offerFenceGateRecipe(Blocks.BIRCH_LOG, ModBlocks.BIRCH_WOOD_FENCE_GATE, "has_birch_log", exporter);
                offerFenceGateRecipe(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_WOOD_FENCE_GATE, "has_jungle_log", exporter);
                offerFenceGateRecipe(Blocks.ACACIA_LOG, ModBlocks.ACACIA_WOOD_FENCE_GATE, "has_acacia_log", exporter);
                offerFenceGateRecipe(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_WOOD_FENCE_GATE, "has_dark_oak_log", exporter);
                offerFenceGateRecipe(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_WOOD_FENCE_GATE, "has_mangrove_log", exporter);
                offerFenceGateRecipe(Blocks.CHERRY_LOG, ModBlocks.CHERRY_WOOD_FENCE_GATE, "has_cherry_log", exporter);
                offerFenceGateRecipe(Blocks.PALE_OAK_LOG, ModBlocks.PALE_OAK_WOOD_FENCE_GATE, "has_pale_oak_log", exporter);
                offerFenceGateRecipe(Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_STEM_FENCE_GATE, "has_bamboo_block", exporter);
                offerFenceGateRecipe(Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_HYPHAE_FENCE_GATE, "has_crimson_stem", exporter);
                offerFenceGateRecipe(Blocks.WARPED_STEM, ModBlocks.WARPED_HYPHAE_FENCE_GATE, "has_warped_stem", exporter);

                offerStairsRecipe(Blocks.OAK_LOG, ModBlocks.OAK_WOOD_STAIRS, "has_oak_log", exporter);
                offerStairsRecipe(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_WOOD_STAIRS, "has_spruce_log", exporter);
                offerStairsRecipe(Blocks.BIRCH_LOG, ModBlocks.BIRCH_WOOD_STAIRS, "has_birch_log", exporter);
                offerStairsRecipe(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_WOOD_STAIRS, "has_jungle_log", exporter);
                offerStairsRecipe(Blocks.ACACIA_LOG, ModBlocks.ACACIA_WOOD_STAIRS, "has_acacia_log", exporter);
                offerStairsRecipe(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_WOOD_STAIRS, "has_dark_oak_log", exporter);
                offerStairsRecipe(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_WOOD_STAIRS, "has_mangrove_log", exporter);
                offerStairsRecipe(Blocks.CHERRY_LOG, ModBlocks.CHERRY_WOOD_STAIRS, "has_cherry_log", exporter);
                offerStairsRecipe(Blocks.PALE_OAK_LOG, ModBlocks.PALE_OAK_WOOD_STAIRS, "has_pale_oak_log", exporter);
                offerStairsRecipe(Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_STEM_STAIRS, "has_bamboo_block", exporter);
                offerStairsRecipe(Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_HYPHAE_STAIRS, "has_crimson_stem", exporter);
                offerStairsRecipe(Blocks.WARPED_STEM, ModBlocks.WARPED_HYPHAE_STAIRS, "has_warped_stem", exporter);

                offerSlabRecipe(Blocks.OAK_LOG, ModBlocks.OAK_WOOD_SLAB, "has_oak_log", exporter);
                offerSlabRecipe(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_WOOD_SLAB, "has_spruce_log", exporter);
                offerSlabRecipe(Blocks.BIRCH_LOG, ModBlocks.BIRCH_WOOD_SLAB, "has_birch_log", exporter);
                offerSlabRecipe(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_WOOD_SLAB, "has_jungle_log", exporter);
                offerSlabRecipe(Blocks.ACACIA_LOG, ModBlocks.ACACIA_WOOD_SLAB, "has_acacia_log", exporter);
                offerSlabRecipe(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_WOOD_SLAB, "has_dark_oak_log", exporter);
                offerSlabRecipe(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_WOOD_SLAB, "has_mangrove_log", exporter);
                offerSlabRecipe(Blocks.CHERRY_LOG, ModBlocks.CHERRY_WOOD_SLAB, "has_cherry_log", exporter);
                offerSlabRecipe(Blocks.PALE_OAK_LOG, ModBlocks.PALE_OAK_WOOD_SLAB, "has_pale_oak_log", exporter);
                offerSlabRecipe(Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_STEM_SLAB, "has_bamboo_block", exporter);
                offerSlabRecipe(Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_HYPHAE_SLAB, "has_crimson_stem", exporter);
                offerSlabRecipe(Blocks.WARPED_STEM, ModBlocks.WARPED_HYPHAE_SLAB, "has_warped_stem", exporter);



                offerCuttingGroupRecipe(exporter, Blocks.OAK_LOG, Blocks.OAK_PLANKS,
                    ModBlocks.ECO_FRIENDLY_OAK_WOOD_VENEERS,
                    ModBlocks.OAK_WOOD_FRAMEWORK,
                    ModBlocks.OAK_WOOD_STAIRS,
                    ModBlocks.OAK_WOOD_SLAB,
                    ModBlocks.OAK_WOOD_WALL,
                    ModBlocks.OAK_WOOD_FENCE,
                    ModBlocks.OAK_WOOD_FENCE_GATE,
                    Blocks.OAK_PLANKS,
                    ModBlocks.ECO_FRIENDLY_OAK_PLANK_VENEERS,
                    Blocks.OAK_STAIRS,
                    Blocks.OAK_SLAB,
                    ModBlocks.OAK_PLANK_WALL,
                    Blocks.OAK_FENCE,
                    Blocks.OAK_FENCE_GATE,
                    Blocks.OAK_DOOR,
                    Blocks.OAK_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.SPRUCE_LOG, Blocks.SPRUCE_PLANKS,
                    ModBlocks.ECO_FRIENDLY_SPRUCE_WOOD_VENEERS,
                    ModBlocks.SPRUCE_WOOD_FRAMEWORK,
                    ModBlocks.SPRUCE_WOOD_STAIRS,
                    ModBlocks.SPRUCE_WOOD_SLAB,
                    ModBlocks.SPRUCE_WOOD_WALL,
                    ModBlocks.SPRUCE_WOOD_FENCE,
                    ModBlocks.SPRUCE_WOOD_FENCE_GATE,
                    Blocks.SPRUCE_PLANKS,
                    ModBlocks.ECO_FRIENDLY_SPRUCE_PLANK_VENEERS,
                    Blocks.SPRUCE_STAIRS,
                    Blocks.SPRUCE_SLAB,
                    ModBlocks.SPRUCE_PLANK_WALL,
                    Blocks.SPRUCE_FENCE,
                    Blocks.SPRUCE_FENCE_GATE,
                    Blocks.SPRUCE_DOOR,
                    Blocks.SPRUCE_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.BIRCH_LOG, Blocks.BIRCH_PLANKS,
                    ModBlocks.ECO_FRIENDLY_BIRCH_WOOD_VENEERS,
                    ModBlocks.BIRCH_WOOD_FRAMEWORK,
                    ModBlocks.BIRCH_WOOD_STAIRS,
                    ModBlocks.BIRCH_WOOD_SLAB,
                    ModBlocks.BIRCH_WOOD_WALL,
                    ModBlocks.BIRCH_WOOD_FENCE,
                    ModBlocks.BIRCH_WOOD_FENCE_GATE,
                    Blocks.BIRCH_PLANKS,
                    ModBlocks.ECO_FRIENDLY_BIRCH_PLANK_VENEERS,
                    Blocks.BIRCH_STAIRS,
                    Blocks.BIRCH_SLAB,
                    ModBlocks.BIRCH_PLANK_WALL,
                    Blocks.BIRCH_FENCE,
                    Blocks.BIRCH_FENCE_GATE,
                    Blocks.BIRCH_DOOR,
                    Blocks.BIRCH_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.JUNGLE_LOG, Blocks.JUNGLE_PLANKS,
                    ModBlocks.ECO_FRIENDLY_JUNGLE_WOOD_VENEERS,
                    ModBlocks.JUNGLE_WOOD_FRAMEWORK,
                    ModBlocks.JUNGLE_WOOD_STAIRS,
                    ModBlocks.JUNGLE_WOOD_SLAB,
                    ModBlocks.JUNGLE_WOOD_WALL,
                    ModBlocks.JUNGLE_WOOD_FENCE,
                    ModBlocks.JUNGLE_WOOD_FENCE_GATE,
                    Blocks.JUNGLE_PLANKS,
                    ModBlocks.ECO_FRIENDLY_JUNGLE_PLANK_VENEERS,
                    Blocks.JUNGLE_STAIRS,
                    Blocks.JUNGLE_SLAB,
                    ModBlocks.JUNGLE_PLANK_WALL,
                    Blocks.JUNGLE_FENCE,
                    Blocks.JUNGLE_FENCE_GATE,
                    Blocks.JUNGLE_DOOR,
                    Blocks.JUNGLE_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.ACACIA_LOG, Blocks.ACACIA_PLANKS,
                    ModBlocks.ECO_FRIENDLY_ACACIA_WOOD_VENEERS,
                    ModBlocks.ACACIA_WOOD_FRAMEWORK,
                    ModBlocks.ACACIA_WOOD_STAIRS,
                    ModBlocks.ACACIA_WOOD_SLAB,
                    ModBlocks.ACACIA_WOOD_WALL,
                    ModBlocks.ACACIA_WOOD_FENCE,
                    ModBlocks.ACACIA_WOOD_FENCE_GATE,
                    Blocks.ACACIA_PLANKS,
                    ModBlocks.ECO_FRIENDLY_ACACIA_PLANK_VENEERS,
                    Blocks.ACACIA_STAIRS,
                    Blocks.ACACIA_SLAB,
                    ModBlocks.ACACIA_PLANK_WALL,
                    Blocks.ACACIA_FENCE,
                    Blocks.ACACIA_FENCE_GATE,
                    Blocks.ACACIA_DOOR,
                    Blocks.ACACIA_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_PLANKS,
                    ModBlocks.ECO_FRIENDLY_DARK_OAK_WOOD_VENEERS,
                    ModBlocks.DARK_OAK_WOOD_FRAMEWORK,
                    ModBlocks.DARK_OAK_WOOD_STAIRS,
                    ModBlocks.DARK_OAK_WOOD_SLAB,
                    ModBlocks.DARK_OAK_WOOD_WALL,
                    ModBlocks.DARK_OAK_WOOD_FENCE,
                    ModBlocks.DARK_OAK_WOOD_FENCE_GATE,
                    Blocks.DARK_OAK_PLANKS,
                    ModBlocks.ECO_FRIENDLY_DARK_OAK_PLANK_VENEERS,
                    Blocks.DARK_OAK_STAIRS,
                    Blocks.DARK_OAK_SLAB,
                    ModBlocks.DARK_OAK_PLANK_WALL,
                    Blocks.DARK_OAK_FENCE,
                    Blocks.DARK_OAK_FENCE_GATE,
                    Blocks.DARK_OAK_DOOR,
                    Blocks.DARK_OAK_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.MANGROVE_LOG, Blocks.MANGROVE_PLANKS,
                    ModBlocks.ECO_FRIENDLY_MANGROVE_WOOD_VENEERS,
                    ModBlocks.MANGROVE_WOOD_FRAMEWORK,
                    ModBlocks.MANGROVE_WOOD_STAIRS,
                    ModBlocks.MANGROVE_WOOD_SLAB,
                    ModBlocks.MANGROVE_WOOD_WALL,
                    ModBlocks.MANGROVE_WOOD_FENCE,
                    ModBlocks.MANGROVE_WOOD_FENCE_GATE,
                    Blocks.MANGROVE_PLANKS,
                    ModBlocks.ECO_FRIENDLY_MANGROVE_PLANK_VENEERS,
                    Blocks.MANGROVE_STAIRS,
                    Blocks.MANGROVE_SLAB,
                    ModBlocks.MANGROVE_PLANK_WALL,
                    Blocks.MANGROVE_FENCE,
                    Blocks.MANGROVE_FENCE_GATE,
                    Blocks.MANGROVE_DOOR,
                    Blocks.MANGROVE_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.CHERRY_LOG, Blocks.CHERRY_PLANKS,
                    ModBlocks.ECO_FRIENDLY_CHERRY_WOOD_VENEERS,
                    ModBlocks.CHERRY_WOOD_FRAMEWORK,
                    ModBlocks.CHERRY_WOOD_STAIRS,
                    ModBlocks.CHERRY_WOOD_SLAB,
                    ModBlocks.CHERRY_WOOD_WALL,
                    ModBlocks.CHERRY_WOOD_FENCE,
                    ModBlocks.CHERRY_WOOD_FENCE_GATE,
                    Blocks.CHERRY_PLANKS,
                    ModBlocks.ECO_FRIENDLY_CHERRY_PLANK_VENEERS,
                    Blocks.CHERRY_STAIRS,
                    Blocks.CHERRY_SLAB,
                    ModBlocks.CHERRY_PLANK_WALL,
                    Blocks.CHERRY_FENCE,
                    Blocks.CHERRY_FENCE_GATE,
                    Blocks.CHERRY_DOOR,
                    Blocks.CHERRY_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.PALE_OAK_LOG, Blocks.PALE_OAK_PLANKS,
                    ModBlocks.ECO_FRIENDLY_PALE_OAK_WOOD_VENEERS,
                    ModBlocks.PALE_OAK_WOOD_FRAMEWORK,
                    ModBlocks.PALE_OAK_WOOD_STAIRS,
                    ModBlocks.PALE_OAK_WOOD_SLAB,
                    ModBlocks.PALE_OAK_WOOD_WALL,
                    ModBlocks.PALE_OAK_WOOD_FENCE,
                    ModBlocks.PALE_OAK_WOOD_FENCE_GATE,
                    Blocks.PALE_OAK_PLANKS,
                    ModBlocks.ECO_FRIENDLY_PALE_OAK_PLANK_VENEERS,
                    Blocks.PALE_OAK_STAIRS,
                    Blocks.PALE_OAK_SLAB,
                    ModBlocks.PALE_OAK_PLANK_WALL,
                    Blocks.PALE_OAK_FENCE,
                    Blocks.PALE_OAK_FENCE_GATE,
                    Blocks.PALE_OAK_DOOR,
                    Blocks.PALE_OAK_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.BAMBOO_BLOCK, Blocks.BAMBOO_PLANKS,
                    ModBlocks.ECO_FRIENDLY_BAMBOO_VENEERS,
                    ModBlocks.BAMBOO_FRAMEWORK,
                    ModBlocks.BAMBOO_STEM_STAIRS,
                    ModBlocks.BAMBOO_STEM_SLAB,
                    ModBlocks.BAMBOO_STEM_WALL,
                    ModBlocks.BAMBOO_STEM_FENCE,
                    ModBlocks.BAMBOO_STEM_FENCE_GATE,
                    Blocks.BAMBOO_PLANKS,
                    ModBlocks.ECO_FRIENDLY_BAMBOO_PLANK_VENEERS,
                    Blocks.BAMBOO_STAIRS,
                    Blocks.BAMBOO_SLAB,
                    ModBlocks.BAMBOO_PLANK_WALL,
                    Blocks.BAMBOO_FENCE,
                    Blocks.BAMBOO_FENCE_GATE,
                    Blocks.BAMBOO_DOOR,
                    Blocks.BAMBOO_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.CRIMSON_STEM, Blocks.CRIMSON_PLANKS,
                    ModBlocks.ECO_FRIENDLY_CRIMSON_HYPHAE_VENEERS,
                    ModBlocks.CRIMSON_HYPHAE_FRAMEWORK,
                    ModBlocks.CRIMSON_HYPHAE_STAIRS,
                    ModBlocks.CRIMSON_HYPHAE_SLAB,
                    ModBlocks.CRIMSON_HYPHAE_WALL,
                    ModBlocks.CRIMSON_HYPHAE_FENCE,
                    ModBlocks.CRIMSON_HYPHAE_FENCE_GATE,
                    Blocks.CRIMSON_PLANKS,
                    ModBlocks.ECO_FRIENDLY_CRIMSON_PLANK_VENEERS,
                    Blocks.CRIMSON_STAIRS,
                    Blocks.CRIMSON_SLAB,
                    ModBlocks.CRIMSON_PLANK_WALL,
                    Blocks.CRIMSON_FENCE,
                    Blocks.CRIMSON_FENCE_GATE,
                    Blocks.CRIMSON_DOOR,
                    Blocks.CRIMSON_TRAPDOOR);

                offerCuttingGroupRecipe(exporter, Blocks.WARPED_STEM, Blocks.WARPED_PLANKS,
                    ModBlocks.ECO_FRIENDLY_WARPED_HYPHAE_VENEERS,
                    ModBlocks.WARPED_HYPHAE_FRAMEWORK,
                    ModBlocks.WARPED_HYPHAE_STAIRS,
                    ModBlocks.WARPED_HYPHAE_SLAB,
                    ModBlocks.WARPED_HYPHAE_WALL,
                    ModBlocks.WARPED_HYPHAE_FENCE,
                    ModBlocks.WARPED_HYPHAE_FENCE_GATE,
                    Blocks.WARPED_PLANKS,
                    ModBlocks.ECO_FRIENDLY_WARPED_PLANK_VENEERS,
                    Blocks.WARPED_STAIRS,
                    Blocks.WARPED_SLAB,
                    ModBlocks.WARPED_PLANK_WALL,
                    Blocks.WARPED_FENCE,
                    Blocks.WARPED_FENCE_GATE,
                    Blocks.WARPED_DOOR,
                    Blocks.WARPED_TRAPDOOR);



                offerChandelierRecipe(Items.CANDLE, ModBlocks.CHANDELIER, exporter);
                offerChandelierRecipe(Items.WHITE_CANDLE, ModBlocks.WHITE_CHANDELIER, exporter);
                offerChandelierRecipe(Items.LIGHT_GRAY_CANDLE, ModBlocks.LIGHT_GRAY_CHANDELIER, exporter);
                offerChandelierRecipe(Items.GRAY_CANDLE, ModBlocks.GRAY_CHANDELIER, exporter);
                offerChandelierRecipe(Items.BLACK_CANDLE, ModBlocks.BLACK_CHANDELIER, exporter);
                offerChandelierRecipe(Items.BROWN_CANDLE, ModBlocks.BROWN_CHANDELIER, exporter);
                offerChandelierRecipe(Items.RED_CANDLE, ModBlocks.RED_CHANDELIER, exporter);
                offerChandelierRecipe(Items.ORANGE_CANDLE, ModBlocks.ORANGE_CHANDELIER, exporter);
                offerChandelierRecipe(Items.YELLOW_CANDLE, ModBlocks.YELLOW_CHANDELIER, exporter);
                offerChandelierRecipe(Items.LIME_CANDLE, ModBlocks.LIME_CHANDELIER, exporter);
                offerChandelierRecipe(Items.GREEN_CANDLE, ModBlocks.GREEN_CHANDELIER, exporter);
                offerChandelierRecipe(Items.CYAN_CANDLE, ModBlocks.CYAN_CHANDELIER, exporter);
                offerChandelierRecipe(Items.LIGHT_BLUE_CANDLE, ModBlocks.LIGHT_BLUE_CHANDELIER, exporter);
                offerChandelierRecipe(Items.BLUE_CANDLE, ModBlocks.BLUE_CHANDELIER, exporter);
                offerChandelierRecipe(Items.PURPLE_CANDLE, ModBlocks.PURPLE_CHANDELIER, exporter);
                offerChandelierRecipe(Items.MAGENTA_CANDLE, ModBlocks.MAGENTA_CHANDELIER, exporter);
                offerChandelierRecipe(Items.PINK_CANDLE, ModBlocks.PINK_CHANDELIER, exporter);


                offerChainRecipe(Items.CHAIN, Items.IRON_NUGGET, ModBlocks.GRAND_CHAIN, 1, "has_chain", exporter);
                offerChainRecipe(ModBlocks.GRAND_CHAIN, Items.IRON_INGOT, ModBlocks.COLOSSAL_CHAIN, 1, "has_grand_chain", exporter);
                offerChainRecipe(Items.GOLD_INGOT, Items.GOLD_NUGGET, ModBlocks.GOLDEN_CHAIN, 1, "has_gold_ingot", exporter);
                offerChainRecipe(ModBlocks.GOLDEN_CHAIN, Items.GOLD_NUGGET, ModBlocks.GOLDEN_GRAND_CHAIN, 1, "has_golden_chain", exporter);
                offerChainRecipe(ModBlocks.GOLDEN_GRAND_CHAIN, Items.GOLD_INGOT, ModBlocks.GOLDEN_COLOSSAL_CHAIN, 1, "has_golden_grand_chain", exporter);



            }



            private fun offerStairsRecipe(
                input: ItemConvertible,
                output: ItemConvertible,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, output, 4)
                    .input('#', input)
                    .pattern("#  ")
                    .pattern("## ")
                    .pattern("###")
                    .group("stairs")
                    .criterion(criterion, conditionsFromItem(input))
                    .offerTo(exporter)
            }

            private fun offerSlabRecipe(
                input: ItemConvertible,
                output: ItemConvertible,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, output, 6)
                    .input('#', input)
                    .pattern("   ")
                    .pattern("   ")
                    .pattern("###")
                    .group("slabs")
                    .criterion(criterion, conditionsFromItem(input))
                    .offerTo(exporter)
            }

            private fun offerFenceRecipe(
                inputWood: ItemConvertible,
                output: ItemConvertible,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, output, 3)
                    .input('#', Items.STICK)
                    .input('@', inputWood)
                    .pattern("   ")
                    .pattern("@#@")
                    .pattern("@#@")
                    .group("fences")
                    .criterion(criterion, conditionsFromItem(inputWood))
                    .offerTo(exporter)
            }

            private fun offerFenceGateRecipe(
                inputWood: ItemConvertible,
                output: ItemConvertible,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, output, 3)
                    .input('#', Items.STICK)
                    .input('@', inputWood)
                    .pattern("   ")
                    .pattern("#@#")
                    .pattern("#@#")
                    .group("fence_gates")
                    .criterion(criterion, conditionsFromItem(inputWood))
                    .offerTo(exporter)
            }

            private fun offerChandelierRecipe(
                inputCandle: ItemConvertible,
                output: ItemConvertible,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.DECORATIONS, output, 1)
                    .input('#', Items.IRON_INGOT)
                    .input('*', Items.IRON_NUGGET)
                    .input('@', inputCandle)
                    .pattern(" * ")
                    .pattern("@#@")
                    .pattern("#*#")
                    .group("chandeliers")
                    .criterion("has_candle", conditionsFromItem(inputCandle))
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter)
            }

            private fun offerCuttingGroupRecipe(
                exporter: RecipeExporter,
                inputLog: ItemConvertible,
                inputPlanks: ItemConvertible,
                outputLogVeneers: ItemConvertible,
                outputFramework: ItemConvertible,
                outputLogStairs: ItemConvertible,
                outputLogSlabs: ItemConvertible,
                outputLogWalls: ItemConvertible,
                outputLogFence: ItemConvertible,
                outputLogFenceGate: ItemConvertible,
                outputPlanks: ItemConvertible,
                outputPlankVeneers: ItemConvertible,
                outputStairs: ItemConvertible,
                outputSlabs: ItemConvertible,
                outputPlankWalls: ItemConvertible,
                outputFence: ItemConvertible,
                outputFenceGate: ItemConvertible,
                outputDoor: ItemConvertible,
                outputTrapdoor: ItemConvertible
            ) {
                // Log input
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputLogVeneers, inputLog, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputFramework, inputLog, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputLogStairs, inputLog, 1)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputLogSlabs, inputLog, 2)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputLogWalls, inputLog, 1)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputLogFence, inputLog, 1)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputLogFenceGate, inputLog, 1)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputPlanks, inputLog, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputPlankVeneers, inputLog, 16)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputStairs, inputLog, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputSlabs, inputLog, 8)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputPlankWalls, inputLog, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputFence, inputLog, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputFenceGate, inputLog, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputDoor, inputLog, 2)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputTrapdoor, inputLog, 2)

                // Plank input
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputPlankVeneers, inputPlanks, 4)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputStairs, inputPlanks, 1)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputSlabs, inputPlanks, 2)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputPlankWalls, inputPlanks, 1)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputFence, inputPlanks, 1)
                offerCuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, outputFenceGate, inputPlanks, 1)
            }

            override fun createShaped(
                category: RecipeCategory,
                output: ItemConvertible,
                count: Int
            ): ShapedRecipeJsonBuilder {
                return ShapedRecipeJsonBuilder.create(itemLookup, category, output, count)
            }

            fun offerWallRecipe(
                category: RecipeCategory,
                output: ItemConvertible,
                input: ItemConvertible,
                exporter: RecipeExporter
            ) {
                getWallRecipe(category, output, Ingredient.ofItems(input))
                    .group("walls")
                    .criterion("has_${getItemPath(input)}", conditionsFromItem(input))
                    .offerTo(exporter)
            }

            fun offerHedgeRecipe(
                category: RecipeCategory,
                output: ItemConvertible,
                input: ItemConvertible,
                exporter: RecipeExporter
            ) {
                getWallRecipe(category, output, Ingredient.ofItems(input))
                    .group("hedges")
                    .criterion("has_${getItemPath(input)}", conditionsFromItem(input))
                    .offerTo(exporter)
            }

            private fun offerChainRecipe(
                inputMiddle: ItemConvertible,
                inputTopBottom: ItemConvertible,
                output: ItemConvertible,
                amount: Int,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.BUILDING_BLOCKS, output, amount)
                    .input('@', inputMiddle)
                    .input('#', inputTopBottom)
                    .pattern("#")
                    .pattern("@")
                    .pattern("#")
                    .criterion(criterion, conditionsFromItem(inputMiddle))
                    .offerTo(exporter)
            }

            private fun offerEcoFriendlyWoodVeneersRecipe(
                category: RecipeCategory,
                output: Block,
                count: Int,
                input: Block,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, category, output, count)
                    .input('#', input)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .group("eco_friendly_wood_veneers")
                    .criterion(criterion, conditionsFromItem(input))
                    .offerTo(exporter)
            }

            private fun offerEcoFriendlyLeafVeneersRecipe(
                category: RecipeCategory,
                output: Block,
                count: Int,
                input: Block,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, category, output, count)
                    .input('#', input)
                    .pattern("###")
                    .pattern("###")
                    .pattern("###")
                    .group("eco_friendly_leaf_veneers")
                    .criterion(criterion, conditionsFromItem(input))
                    .offerTo(exporter)
            }

            private fun offerCrossRecipe(
                category: RecipeCategory,
                output: Block,
                count: Int,
                inputCross: Block,
                inputX: Block,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, category, output, count)
                    .input('#', inputCross)
                    .input('*', inputX)
                    .pattern("#*#")
                    .pattern("*#*")
                    .pattern("#*#")
                    .group("frameworks")
                    .criterion(criterion, conditionsFromItem(inputX))
                    .offerTo(exporter)
            }

            private fun offerTableSawBlockRecipe(
                category: RecipeCategory,
                output: Block,
                count: Int,
                inputStick: Item,
                inputSlab: Block,
                inputSaw: Item,
                criterion1: String,
                criterion2: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, category, output, count)
                    .input('#', inputStick)
                    .input('*', inputSlab)
                    .input('@', inputSaw)
                    .pattern("*@*")
                    .pattern("# #")
                    .pattern("# #")
                    .group("tablesaws")
                    .criterion(criterion1, conditionsFromItem(inputStick))
                    .criterion(criterion2, conditionsFromItem(inputSaw))
                    .offerTo(exporter)
            }

            private fun offerLayerRecipe(
                category: RecipeCategory,
                output: Block,
                count: Int,
                input: Block,
                criterion: String,
                exporter: RecipeExporter
            ) {
                ShapedRecipeJsonBuilder.create(itemLookup, category, output, count)
                    .input('#', input)
                    .pattern("   ")
                    .pattern("   ")
                    .pattern("###")
                    .criterion(criterion, conditionsFromItem(input))
                    .offerTo(exporter)
            }


        }


    }

    override fun getName(): String {
        return "Little John's RecipeProvider"
    }

}