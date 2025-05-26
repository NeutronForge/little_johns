package net.echo.little_johns.datagen

import net.echo.little_johns.block.ModBlocks
import net.echo.little_johns.item.ModItems
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.registry.RegistryWrapper
import java.util.concurrent.CompletableFuture

class ModLanguageProviderEnglish(
    dataOutput: FabricDataOutput,
    registryLookup: CompletableFuture<RegistryWrapper.WrapperLookup>
) : FabricLanguageProvider(dataOutput, "en_us", registryLookup) {


    override fun generateTranslations(
        wrapperLookup: RegistryWrapper.WrapperLookup,
        translationBuilder: TranslationBuilder
    ) {
        with(translationBuilder) {

            add(ModBlocks.OAK_TABLE_SAW, "Oak Table Saw")
            add(ModBlocks.SPRUCE_TABLE_SAW, "Spruce Table Saw")
            add(ModBlocks.BIRCH_TABLE_SAW, "Birch Table Saw")
            add(ModBlocks.JUNGLE_TABLE_SAW, "Jungle Table Saw")
            add(ModBlocks.ACACIA_TABLE_SAW, "Acacia Table Saw")
            add(ModBlocks.DARK_OAK_TABLE_SAW, "Dark Oak Table Saw")
            add(ModBlocks.MANGROVE_TABLE_SAW, "Mangrove Table Saw")
            add(ModBlocks.CHERRY_TABLE_SAW, "Cherry Table Saw")
            add(ModBlocks.PALE_OAK_TABLE_SAW, "Pale Oak Table Saw")
            add(ModBlocks.BAMBOO_TABLE_SAW, "Bamboo Table Saw")
            add(ModBlocks.CRIMSON_TABLE_SAW, "Crimson Table Saw")
            add(ModBlocks.WARPED_TABLE_SAW, "Warped Table Saw")


            add(ModBlocks.ECO_FRIENDLY_OAK_WOOD_VENEERS,"Eco Friendly Oak Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_SPRUCE_WOOD_VENEERS,"Eco Friendly Spruce Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_BIRCH_WOOD_VENEERS,"Eco Friendly Birch Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_JUNGLE_WOOD_VENEERS,"Eco Friendly Jungle Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_ACACIA_WOOD_VENEERS,"Eco Friendly Acacia Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_DARK_OAK_WOOD_VENEERS,"Eco Friendly Dark Oak Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_MANGROVE_WOOD_VENEERS,"Eco Friendly Mangrove Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_CHERRY_WOOD_VENEERS,"Eco Friendly Cherry Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_PALE_OAK_WOOD_VENEERS,"Eco Friendly Pale Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_BAMBOO_VENEERS,"Eco Friendly Bamboo Veneers")
            add(ModBlocks.ECO_FRIENDLY_CRIMSON_HYPHAE_VENEERS,"Eco Friendly Crimson Hyphae Veneers")
            add(ModBlocks.ECO_FRIENDLY_WARPED_HYPHAE_VENEERS,"Eco Friendly Warped Hyphae Veneers")


            add(ModBlocks.ECO_FRIENDLY_STRIPPED_OAK_WOOD_VENEERS,"Eco Friendly Stripped Oak Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_SPRUCE_WOOD_VENEERS,"Eco Friendly Stripped Spruce Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_BIRCH_WOOD_VENEERS,"Eco Friendly Stripped Birch Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_JUNGLE_WOOD_VENEERS,"Eco Friendly Stripped Jungle Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_ACACIA_WOOD_VENEERS,"Eco Friendly Stripped Acacia Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_DARK_OAK_WOOD_VENEERS,"Eco Friendly Stripped Dark Oak Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_MANGROVE_WOOD_VENEERS,"Eco Friendly Stripped Mangrove Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_CHERRY_WOOD_VENEERS,"Eco Friendly Stripped Cherry Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_PALE_OAK_WOOD_VENEERS,"Eco Friendly Stripped Pale Wood Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_CRIMSON_HYPHAE_VENEERS,"Eco Friendly Stripped Crimson Hyphae Veneers")
            add(ModBlocks.ECO_FRIENDLY_STRIPPED_WARPED_HYPHAE_VENEERS,"Eco Friendly Stripped Warped Hyphae Veneers")


            add(ModBlocks.ECO_FRIENDLY_OAK_PLANK_VENEERS,"Eco Friendly Oak Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_SPRUCE_PLANK_VENEERS,"Eco Friendly Spruce Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_BIRCH_PLANK_VENEERS,"Eco Friendly Birch Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_JUNGLE_PLANK_VENEERS,"Eco Friendly Jungle Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_ACACIA_PLANK_VENEERS,"Eco Friendly Acacia Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_DARK_OAK_PLANK_VENEERS,"Eco Friendly Dark Oak Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_MANGROVE_PLANK_VENEERS,"Eco Friendly Mangrove Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_CHERRY_PLANK_VENEERS,"Eco Friendly Cherry Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_PALE_OAK_PLANK_VENEERS,"Eco Friendly Pale Oak Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_BAMBOO_PLANK_VENEERS,"Eco Friendly Bamboo Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_CRIMSON_PLANK_VENEERS,"Eco Friendly Crimson Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_WARPED_PLANK_VENEERS,"Eco Friendly Warped Plank Veneers")
            add(ModBlocks.ECO_FRIENDLY_BAMBOO_MOSAIC_VENEERS,"Eco Friendly Bamboo Mosaic Veneers")


            add(ModBlocks.OAK_WOOD_FRAMEWORK,"Oak Wood Framework")
            add(ModBlocks.SPRUCE_WOOD_FRAMEWORK,"Spruce Wood Framework")
            add(ModBlocks.BIRCH_WOOD_FRAMEWORK,"Birch Wood Framework")
            add(ModBlocks.JUNGLE_WOOD_FRAMEWORK,"Jungle Wood Framework")
            add(ModBlocks.ACACIA_WOOD_FRAMEWORK,"Acacia Wood Framework")
            add(ModBlocks.DARK_OAK_WOOD_FRAMEWORK,"Dark Oak Wood Framework")
            add(ModBlocks.MANGROVE_WOOD_FRAMEWORK,"Mangrove Wood Framework")
            add(ModBlocks.CHERRY_WOOD_FRAMEWORK,"Cherry Wood Framework")
            add(ModBlocks.PALE_OAK_WOOD_FRAMEWORK,"Pale Oak Wood Framework")
            add(ModBlocks.BAMBOO_FRAMEWORK,"Bamboo Framework")
            add(ModBlocks.CRIMSON_HYPHAE_FRAMEWORK,"Crimson Hyphae Framework")
            add(ModBlocks.WARPED_HYPHAE_FRAMEWORK,"Warped Hyphae Framework")


            add(ModBlocks.STRIPPED_OAK_WOOD_FRAMEWORK,"Stripped Oak Wood Framework")
            add(ModBlocks.STRIPPED_SPRUCE_WOOD_FRAMEWORK,"Stripped Spruce Wood Framework")
            add(ModBlocks.STRIPPED_BIRCH_WOOD_FRAMEWORK,"Stripped Birch Wood Framework")
            add(ModBlocks.STRIPPED_JUNGLE_WOOD_FRAMEWORK,"Stripped Jungle Wood Framework")
            add(ModBlocks.STRIPPED_ACACIA_WOOD_FRAMEWORK,"Stripped Acacia Wood Framework")
            add(ModBlocks.STRIPPED_DARK_OAK_WOOD_FRAMEWORK,"Stripped Dark Oak Wood Framework")
            add(ModBlocks.STRIPPED_MANGROVE_WOOD_FRAMEWORK,"Stripped Mangrove Wood Framework")
            add(ModBlocks.STRIPPED_CHERRY_WOOD_FRAMEWORK,"Stripped Cherry Wood Framework")
            add(ModBlocks.STRIPPED_PALE_OAK_WOOD_FRAMEWORK,"Stripped Pale Oak Wood Framework")
            add(ModBlocks.STRIPPED_BAMBOO_FRAMEWORK,"Stripped Bamboo Framework")
            add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FRAMEWORK,"Stripped Crimson Hyphae Framework")
            add(ModBlocks.STRIPPED_WARPED_HYPHAE_FRAMEWORK,"Stripped Warped Hyphae Framework")

            add(ModBlocks.BAMBOO_MOSAIC_FRAMEWORK,"Bamboo Mosaic Framework")



            add(ModBlocks.ECO_FRIENDLY_OAK_LEAF_VENEERS,"Eco Friendly Oak Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_SPRUCE_LEAF_VENEERS,"Eco Friendly Spruce Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_BIRCH_LEAF_VENEERS,"Eco Friendly Birch Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_JUNGLE_LEAF_VENEERS,"Eco Friendly Jungle Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_ACACIA_LEAF_VENEERS,"Eco Friendly Acacia Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_DARK_OAK_LEAF_VENEERS,"Eco Friendly Dark Oak Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_MANGROVE_LEAF_VENEERS,"Eco Friendly Mangrove Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_CHERRY_LEAF_VENEERS,"Eco Friendly Cherry Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_PALE_OAK_LEAF_VENEERS,"Eco Friendly Pale Oak Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_AZALEA_LEAF_VENEERS,"Eco Friendly Azalea Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_FLOWERING_AZALEA_LEAF_VENEERS,"Eco Friendly Flowering Azalea Leaf Veneers")

            add(ModBlocks.ECO_FRIENDLY_BAMBOO_LEAF_VENEERS, "Eco Friendly Bamboo Leaf Veneers")
            add(ModBlocks.ECO_FRIENDLY_NETHER_WART_VENEERS, "Eco Friendly Nether Wart Veneers")
            add(ModBlocks.ECO_FRIENDLY_WARPED_WART_VENEERS, "Eco Friendly Warped Wart Veneers")
            add(ModBlocks.ECO_FRIENDLY_MOSS_VENEERS, "Eco Friendly Moss Veneers")
            add(ModBlocks.ECO_FRIENDLY_PALE_MOSS_VENEERS, "Eco Friendly Pale Moss Veneers")
            add(ModBlocks.ECO_FRIENDLY_GRASS_VENEERS, "Eco Friendly Grass Veneers")



            add(ModBlocks.OAK_LEAF_HEDGE,"Oak Leaf Hedge")
            add(ModBlocks.SPRUCE_LEAF_HEDGE,"Spruce Leaf Hedge")
            add(ModBlocks.BIRCH_LEAF_HEDGE,"Birch Leaf Hedge")
            add(ModBlocks.JUNGLE_LEAF_HEDGE,"Jungle Leaf Hedge")
            add(ModBlocks.ACACIA_LEAF_HEDGE,"Acacia Leaf Hedge")
            add(ModBlocks.DARK_OAK_LEAF_HEDGE,"Dark Oak Leaf Hedge")
            add(ModBlocks.MANGROVE_LEAF_HEDGE,"Mangrove Leaf Hedge")
            add(ModBlocks.CHERRY_LEAF_HEDGE,"Cherry Leaf Hedge")
            add(ModBlocks.PALE_OAK_LEAF_HEDGE,"Pale Oak Leaf Hedge")
            add(ModBlocks.AZALEA_LEAF_HEDGE,"Azalea Leaf Hedge")
            add(ModBlocks.FLOWERING_AZALEA_LEAF_HEDGE,"Flowering Azalea Leaf Hedge")

            add(ModBlocks.BAMBOO_LEAF_HEDGE, "Bamboo Leaf Hedge")
            add(ModBlocks.NETHER_WART_HEDGE, "Nether Wart Hedge")
            add(ModBlocks.WARPED_WART_HEDGE, "Warped Wart Hedge")
            add(ModBlocks.MOSS_HEDGE, "Moss Hedge")
            add(ModBlocks.PALE_MOSS_HEDGE, "Pale Moss Hedge")


            add(ModBlocks.BAMBOO_LEAVES, "Bamboo Leaves")


            add(ModBlocks.OAK_WOOD_WALL,"Oak Wood Wall")
            add(ModBlocks.SPRUCE_WOOD_WALL,"Spruce Wood Wall")
            add(ModBlocks.BIRCH_WOOD_WALL,"Birch Wood Wall")
            add(ModBlocks.JUNGLE_WOOD_WALL,"Jungle Wood Wall")
            add(ModBlocks.ACACIA_WOOD_WALL,"Acacia Wood Wall")
            add(ModBlocks.DARK_OAK_WOOD_WALL,"Dark Oak Wood Wall")
            add(ModBlocks.MANGROVE_WOOD_WALL,"Mangrove Wood Wall")
            add(ModBlocks.CHERRY_WOOD_WALL,"Cherry Wood Wall")
            add(ModBlocks.PALE_OAK_WOOD_WALL,"Pale Oak Wood Wall")
            add(ModBlocks.BAMBOO_STEM_WALL,"Bamboo Wall")
            add(ModBlocks.CRIMSON_HYPHAE_WALL,"Crimson Hyphae Wall")
            add(ModBlocks.WARPED_HYPHAE_WALL,"Warped Hyphae Wall")


            add(ModBlocks.STRIPPED_OAK_WOOD_WALL,"Stripped Oak Wood Wall")
            add(ModBlocks.STRIPPED_SPRUCE_WOOD_WALL,"Stripped Spruce Wood Wall")
            add(ModBlocks.STRIPPED_BIRCH_WOOD_WALL,"Stripped Birch Wood Wall")
            add(ModBlocks.STRIPPED_JUNGLE_WOOD_WALL,"Stripped Jungle Wood Wall")
            add(ModBlocks.STRIPPED_ACACIA_WOOD_WALL,"Stripped Acacia Wood Wall")
            add(ModBlocks.STRIPPED_DARK_OAK_WOOD_WALL,"Stripped Dark Oak Wood Wall")
            add(ModBlocks.STRIPPED_MANGROVE_WOOD_WALL,"Stripped Mangrove Wood Wall")
            add(ModBlocks.STRIPPED_CHERRY_WOOD_WALL,"Stripped Cherry Wood Wall")
            add(ModBlocks.STRIPPED_PALE_OAK_WOOD_WALL,"Stripped Pale Oak Wood Wall")
            add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_WALL,"Stripped Crimson Hyphae Wall")
            add(ModBlocks.STRIPPED_WARPED_HYPHAE_WALL,"Stripped Warped Hyphae Wall")


            add(ModBlocks.OAK_PLANK_WALL,"Oak Plank Wall")
            add(ModBlocks.SPRUCE_PLANK_WALL,"Spruce Plank Wall")
            add(ModBlocks.BIRCH_PLANK_WALL,"Birch Plank Wall")
            add(ModBlocks.JUNGLE_PLANK_WALL,"Jungle Plank Wall")
            add(ModBlocks.ACACIA_PLANK_WALL,"Acacia Plank Wall")
            add(ModBlocks.DARK_OAK_PLANK_WALL,"Dark Oak Plank Wall")
            add(ModBlocks.MANGROVE_PLANK_WALL,"Mangrove Plank Wall")
            add(ModBlocks.CHERRY_PLANK_WALL,"Cherry Plank Wall")
            add(ModBlocks.PALE_OAK_PLANK_WALL,"Pale Oak Plank Wall")
            add(ModBlocks.BAMBOO_PLANK_WALL,"Bamboo Plank Wall")
            add(ModBlocks.CRIMSON_PLANK_WALL,"Crimson Plank Wall")
            add(ModBlocks.WARPED_PLANK_WALL,"Warped Plank Wall")


            add(ModBlocks.OAK_WOOD_FENCE,"Oak Wood Fence")
            add(ModBlocks.SPRUCE_WOOD_FENCE,"Spruce Wood Fence")
            add(ModBlocks.BIRCH_WOOD_FENCE,"Birch Wood Fence")
            add(ModBlocks.JUNGLE_WOOD_FENCE,"Jungle Wood Fence")
            add(ModBlocks.ACACIA_WOOD_FENCE,"Acacia Wood Fence")
            add(ModBlocks.DARK_OAK_WOOD_FENCE,"Dark Oak Wood Fence")
            add(ModBlocks.MANGROVE_WOOD_FENCE,"Mangrove Wood Fence")
            add(ModBlocks.CHERRY_WOOD_FENCE,"Cherry Wood Fence")
            add(ModBlocks.PALE_OAK_WOOD_FENCE,"Pale Oak Wood Fence")
            add(ModBlocks.BAMBOO_STEM_FENCE,"Bamboo Fence")
            add(ModBlocks.CRIMSON_HYPHAE_FENCE,"Crimson Hyphae Fence")
            add(ModBlocks.WARPED_HYPHAE_FENCE,"Warped Hyphae Fence")
            add(ModBlocks.BAMBOO_MOSAIC_WALL,"Bamboo Mosaic Wall")



            add(ModBlocks.STRIPPED_OAK_WOOD_FENCE,"Stripped Oak Wood Fence")
            add(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE,"Stripped Spruce Wood Fence")
            add(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE,"Stripped Birch Wood Fence")
            add(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE,"Stripped Jungle Wood Fence")
            add(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE,"Stripped Acacia Wood Fence")
            add(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE,"Stripped Dark Oak Wood Fence")
            add(ModBlocks.STRIPPED_MANGROVE_WOOD_FENCE,"Stripped Mangrove Wood Fence")
            add(ModBlocks.STRIPPED_CHERRY_WOOD_FENCE,"Stripped Cherry Wood Fence")
            add(ModBlocks.STRIPPED_PALE_OAK_WOOD_FENCE,"Stripped Pale Oak Wood Fence")
            add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE,"Stripped Crimson Hyphae Fence")
            add(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE,"Stripped Warped Hyphae Fence")

            add(ModBlocks.BAMBOO_MOSAIC_FENCE,"Bamboo Mosaic Fence")


            add(ModBlocks.OAK_WOOD_FENCE_GATE,"Oak Wood Fence Gate")
            add(ModBlocks.SPRUCE_WOOD_FENCE_GATE,"Spruce Wood Fence Gate")
            add(ModBlocks.BIRCH_WOOD_FENCE_GATE,"Birch Wood Fence Gate")
            add(ModBlocks.JUNGLE_WOOD_FENCE_GATE,"Jungle Wood Fence Gate")
            add(ModBlocks.ACACIA_WOOD_FENCE_GATE,"Acacia Wood Fence Gate")
            add(ModBlocks.DARK_OAK_WOOD_FENCE_GATE,"Dark Oak Wood Fence Gate")
            add(ModBlocks.MANGROVE_WOOD_FENCE_GATE,"Mangrove Wood Fence Gate")
            add(ModBlocks.CHERRY_WOOD_FENCE_GATE,"Cherry Wood Fence Gate")
            add(ModBlocks.PALE_OAK_WOOD_FENCE_GATE,"Pale Oak Wood Fence Gate")
            add(ModBlocks.BAMBOO_STEM_FENCE_GATE,"Bamboo Fence Gate")
            add(ModBlocks.CRIMSON_HYPHAE_FENCE_GATE,"Crimson Hyphae Fence Gate")
            add(ModBlocks.WARPED_HYPHAE_FENCE_GATE,"Warped Hyphae Fence Gate")


            add(ModBlocks.STRIPPED_OAK_WOOD_FENCE_GATE,"Stripped Oak Wood Fence Gate")
            add(ModBlocks.STRIPPED_SPRUCE_WOOD_FENCE_GATE,"Stripped Spruce Wood Fence Gate")
            add(ModBlocks.STRIPPED_BIRCH_WOOD_FENCE_GATE,"Stripped Birch Wood Fence Gate")
            add(ModBlocks.STRIPPED_JUNGLE_WOOD_FENCE_GATE,"Stripped Jungle Wood Fence Gate")
            add(ModBlocks.STRIPPED_ACACIA_WOOD_FENCE_GATE,"Stripped Acacia Wood Fence Gate")
            add(ModBlocks.STRIPPED_DARK_OAK_WOOD_FENCE_GATE,"Stripped Dark Oak Wood Fence Gate")
            add(ModBlocks.STRIPPED_MANGROVE_WOOD_FENCE_GATE,"Stripped Mangrove Wood Fence Gate")
            add(ModBlocks.STRIPPED_CHERRY_WOOD_FENCE_GATE,"Stripped Cherry Wood Fence Gate")
            add(ModBlocks.STRIPPED_PALE_OAK_WOOD_FENCE_GATE,"Stripped Pale Oak Wood Fence Gate")
            add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_FENCE_GATE,"Stripped Crimson Hyphae Fence Gate")
            add(ModBlocks.STRIPPED_WARPED_HYPHAE_FENCE_GATE,"Stripped Warped Hyphae Fence Gate")

            add(ModBlocks.BAMBOO_MOSAIC_FENCE_GATE,"Bamboo Mosaic Fence Gate")


            add(ModBlocks.OAK_WOOD_STAIRS,"Oak Wood Stairs")
            add(ModBlocks.SPRUCE_WOOD_STAIRS,"Spruce Wood Stairs")
            add(ModBlocks.BIRCH_WOOD_STAIRS,"Birch Wood Stairs")
            add(ModBlocks.JUNGLE_WOOD_STAIRS,"Jungle Wood Stairs")
            add(ModBlocks.ACACIA_WOOD_STAIRS,"Acacia Wood Stairs")
            add(ModBlocks.DARK_OAK_WOOD_STAIRS,"Dark Oak Wood Stairs")
            add(ModBlocks.MANGROVE_WOOD_STAIRS,"Mangrove Wood Stairs")
            add(ModBlocks.CHERRY_WOOD_STAIRS,"Cherry Wood Stairs")
            add(ModBlocks.PALE_OAK_WOOD_STAIRS,"Pale Oak Wood Stairs")
            add(ModBlocks.BAMBOO_STEM_STAIRS,"Bamboo Stairs")
            add(ModBlocks.CRIMSON_HYPHAE_STAIRS,"Crimson Hyphae Stairs")
            add(ModBlocks.WARPED_HYPHAE_STAIRS,"Warped Hyphae Stairs")


            add(ModBlocks.STRIPPED_OAK_WOOD_STAIRS,"Stripped Oak Wood Stairs")
            add(ModBlocks.STRIPPED_SPRUCE_WOOD_STAIRS,"Stripped Spruce Wood Stairs")
            add(ModBlocks.STRIPPED_BIRCH_WOOD_STAIRS,"Stripped Birch Wood Stairs")
            add(ModBlocks.STRIPPED_JUNGLE_WOOD_STAIRS,"Stripped Jungle Wood Stairs")
            add(ModBlocks.STRIPPED_ACACIA_WOOD_STAIRS,"Stripped Acacia Wood Stairs")
            add(ModBlocks.STRIPPED_DARK_OAK_WOOD_STAIRS,"Stripped Dark Oak Wood Stairs")
            add(ModBlocks.STRIPPED_MANGROVE_WOOD_STAIRS,"Stripped Mangrove Wood Stairs")
            add(ModBlocks.STRIPPED_CHERRY_WOOD_STAIRS,"Stripped Cherry Wood Stairs")
            add(ModBlocks.STRIPPED_PALE_OAK_WOOD_STAIRS,"Stripped Pale Oak Wood Stairs")
            add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_STAIRS,"Stripped Crimson Hyphae Stairs")
            add(ModBlocks.STRIPPED_WARPED_HYPHAE_STAIRS,"Stripped Warped Hyphae Stairs")


            add(ModBlocks.OAK_WOOD_SLAB,"Oak Wood Slab")
            add(ModBlocks.SPRUCE_WOOD_SLAB,"Spruce Wood Slab")
            add(ModBlocks.BIRCH_WOOD_SLAB,"Birch Wood Slab")
            add(ModBlocks.JUNGLE_WOOD_SLAB,"Jungle Wood Slab")
            add(ModBlocks.ACACIA_WOOD_SLAB,"Acacia Wood Slab")
            add(ModBlocks.DARK_OAK_WOOD_SLAB,"Dark Oak Wood Slab")
            add(ModBlocks.MANGROVE_WOOD_SLAB,"Mangrove Wood Slab")
            add(ModBlocks.CHERRY_WOOD_SLAB,"Cherry Wood Slab")
            add(ModBlocks.PALE_OAK_WOOD_SLAB,"Pale Oak Wood Slab")
            add(ModBlocks.BAMBOO_STEM_SLAB,"Bamboo Slab")
            add(ModBlocks.CRIMSON_HYPHAE_SLAB,"Crimson Hyphae Slab")
            add(ModBlocks.WARPED_HYPHAE_SLAB,"Warped Hyphae Slab")


            add(ModBlocks.STRIPPED_OAK_WOOD_SLAB,"Stripped Oak Wood Slab")
            add(ModBlocks.STRIPPED_SPRUCE_WOOD_SLAB,"Stripped Spruce Wood Slab")
            add(ModBlocks.STRIPPED_BIRCH_WOOD_SLAB,"Stripped Birch Wood Slab")
            add(ModBlocks.STRIPPED_JUNGLE_WOOD_SLAB,"Stripped Jungle Wood Slab")
            add(ModBlocks.STRIPPED_ACACIA_WOOD_SLAB,"Stripped Acacia Wood Slab")
            add(ModBlocks.STRIPPED_DARK_OAK_WOOD_SLAB,"Stripped Dark Oak Wood Slab")
            add(ModBlocks.STRIPPED_MANGROVE_WOOD_SLAB,"Stripped Mangrove Wood Slab")
            add(ModBlocks.STRIPPED_CHERRY_WOOD_SLAB,"Stripped Cherry Wood Slab")
            add(ModBlocks.STRIPPED_PALE_OAK_WOOD_SLAB,"Stripped Pale Oak Wood Slab")
            add(ModBlocks.STRIPPED_CRIMSON_HYPHAE_SLAB,"Stripped Crimson Hyphae Slab")
            add(ModBlocks.STRIPPED_WARPED_HYPHAE_SLAB,"Stripped Warped Hyphae Slab")


            add(ModBlocks.CHANDELIER, "Chandelier")
            add(ModBlocks.WHITE_CHANDELIER, "White Chandelier")
            add(ModBlocks.LIGHT_GRAY_CHANDELIER, "Light Gray Chandelier")
            add(ModBlocks.GRAY_CHANDELIER, "Gray Chandelier")
            add(ModBlocks.BLACK_CHANDELIER, "Black Chandelier")
            add(ModBlocks.BROWN_CHANDELIER, "Brown Chandelier")
            add(ModBlocks.RED_CHANDELIER, "Red Chandelier")
            add(ModBlocks.ORANGE_CHANDELIER, "Orange Chandelier")
            add(ModBlocks.YELLOW_CHANDELIER, "Yellow Chandelier")
            add(ModBlocks.LIME_CHANDELIER, "Lime Chandelier")
            add(ModBlocks.GREEN_CHANDELIER, "Green Chandelier")
            add(ModBlocks.CYAN_CHANDELIER, "Cyan Chandelier")
            add(ModBlocks.LIGHT_BLUE_CHANDELIER, "Light Blue Chandelier")
            add(ModBlocks.BLUE_CHANDELIER, "Blue Chandelier")
            add(ModBlocks.PURPLE_CHANDELIER, "Purple Chandelier")
            add(ModBlocks.MAGENTA_CHANDELIER, "Magenta Chandelier")
            add(ModBlocks.PINK_CHANDELIER, "Pink Chandelier")


            add(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK, "Galvanized Square Steel Block")
            add(ModBlocks.GALVANIZED_SQUARE_STEEL_STAIRS, "Galvanized Square Steel Stairs")
            add(ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB, "Galvanized Square Steel Slab")
            add(ModBlocks.GALVANIZED_SQUARE_STEEL_BEAM, "Galvanized Square Steel Beam")
            add(ModBlocks.GALVANIZED_SQUARE_STEEL, "Galvanized Square Steel")
            add(ModBlocks.GALVANIZED_SQUARE_STEEL_GRATE, "Galvanized Square Steel Grate")


            add(ModBlocks.GRAND_CHAIN, "Grand Chain")
            add(ModBlocks.COLOSSAL_CHAIN, "Colossal Chain")
            add(ModBlocks.GOLDEN_CHAIN, "Golden Chain")
            add(ModBlocks.GOLDEN_GRAND_CHAIN, "Golden Grand Chain")
            add(ModBlocks.GOLDEN_COLOSSAL_CHAIN, "Golden Colossal Chain")


            add("container.little_johns.table_saw", "Table Saw")


            add(ModItems.BORROWED_SCREWS, "Screws Borrowed From Aunt")


        }
    }
}