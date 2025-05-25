package net.echo.little_johns.datagen

import net.echo.little_johns.LittleJohns
import net.echo.little_johns.block.ModBlocks
import net.echo.little_johns.item.ModItems
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.client.data.BlockStateModelGenerator
import net.minecraft.client.data.ItemModelGenerator
import net.minecraft.client.data.Model
import net.minecraft.client.data.ModelIds
import net.minecraft.client.data.Models
import net.minecraft.client.data.TextureKey
import net.minecraft.client.data.TextureMap
import net.minecraft.client.data.TexturedModel
import net.minecraft.data.family.BlockFamily
import net.minecraft.registry.Registries
import net.minecraft.util.Identifier
import java.util.Optional

class ModBlockModelProvider(
    output: FabricDataOutput
) : FabricModelProvider(output) {

    override fun generateBlockStateModels(blockStateModelGenerator: BlockStateModelGenerator) {

        val galvanizedSquareSteelPool =
            blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GALVANIZED_SQUARE_STEEL_BLOCK)
        galvanizedSquareSteelPool.stairs(ModBlocks.GALVANIZED_SQUARE_STEEL_STAIRS)
        galvanizedSquareSteelPool.slab(ModBlocks.GALVANIZED_SQUARE_STEEL_SLAB)

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BAMBOO_LEAVES)

        // PLANK POOLS
        val plankVariantsList = listOf(
            PlankVariant(Blocks.OAK_PLANKS, ModBlocks.OAK_PLANK_WALL),
            PlankVariant(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PLANK_WALL),
            PlankVariant(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PLANK_WALL),
            PlankVariant(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PLANK_WALL),
            PlankVariant(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PLANK_WALL),
            PlankVariant(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PLANK_WALL),
            PlankVariant(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PLANK_WALL),
            PlankVariant(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PLANK_WALL),
            PlankVariant(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_PLANK_WALL),
            PlankVariant(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PLANK_WALL),
            PlankVariant(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PLANK_WALL),
            PlankVariant(Blocks.WARPED_PLANKS, ModBlocks.WARPED_PLANK_WALL)
        )

        plankVariantsList.forEach { (base, wall) ->
            val family = BlockFamily.Builder(base)
                .wall(wall)
                .build()

            blockStateModelGenerator.registerVanillaCompatibleFamily(family)
        }


        val woodVariantsList = listOf(
            WoodVariants(Blocks.OAK_LOG, ModBlocks.OAK_WOOD_WALL, ModBlocks.OAK_WOOD_FENCE, ModBlocks.OAK_WOOD_FENCE_GATE, ModBlocks.OAK_WOOD_SLAB, ModBlocks.OAK_WOOD_STAIRS),
            WoodVariants(Blocks.SPRUCE_LOG, ModBlocks.SPRUCE_WOOD_WALL, ModBlocks.SPRUCE_WOOD_FENCE, ModBlocks.SPRUCE_WOOD_FENCE_GATE, ModBlocks.SPRUCE_WOOD_SLAB, ModBlocks.SPRUCE_WOOD_STAIRS),
            WoodVariants(Blocks.BIRCH_LOG, ModBlocks.BIRCH_WOOD_WALL, ModBlocks.BIRCH_WOOD_FENCE, ModBlocks.BIRCH_WOOD_FENCE_GATE, ModBlocks.BIRCH_WOOD_SLAB, ModBlocks.BIRCH_WOOD_STAIRS),
            WoodVariants(Blocks.JUNGLE_LOG, ModBlocks.JUNGLE_WOOD_WALL, ModBlocks.JUNGLE_WOOD_FENCE, ModBlocks.JUNGLE_WOOD_FENCE_GATE, ModBlocks.JUNGLE_WOOD_SLAB, ModBlocks.JUNGLE_WOOD_STAIRS),
            WoodVariants(Blocks.ACACIA_LOG, ModBlocks.ACACIA_WOOD_WALL, ModBlocks.ACACIA_WOOD_FENCE, ModBlocks.ACACIA_WOOD_FENCE_GATE, ModBlocks.ACACIA_WOOD_SLAB, ModBlocks.ACACIA_WOOD_STAIRS),
            WoodVariants(Blocks.DARK_OAK_LOG, ModBlocks.DARK_OAK_WOOD_WALL, ModBlocks.DARK_OAK_WOOD_FENCE, ModBlocks.DARK_OAK_WOOD_FENCE_GATE, ModBlocks.DARK_OAK_WOOD_SLAB, ModBlocks.DARK_OAK_WOOD_STAIRS),
            WoodVariants(Blocks.MANGROVE_LOG, ModBlocks.MANGROVE_WOOD_WALL, ModBlocks.MANGROVE_WOOD_FENCE, ModBlocks.MANGROVE_WOOD_FENCE_GATE, ModBlocks.MANGROVE_WOOD_SLAB, ModBlocks.MANGROVE_WOOD_STAIRS),
            WoodVariants(Blocks.CHERRY_LOG, ModBlocks.CHERRY_WOOD_WALL, ModBlocks.CHERRY_WOOD_FENCE, ModBlocks.CHERRY_WOOD_FENCE_GATE, ModBlocks.CHERRY_WOOD_SLAB, ModBlocks.CHERRY_WOOD_STAIRS),
            WoodVariants(Blocks.PALE_OAK_LOG, ModBlocks.PALE_OAK_WOOD_WALL, ModBlocks.PALE_OAK_WOOD_FENCE, ModBlocks.PALE_OAK_WOOD_FENCE_GATE, ModBlocks.PALE_OAK_WOOD_SLAB, ModBlocks.PALE_OAK_WOOD_STAIRS),
            WoodVariants(Blocks.BAMBOO_BLOCK, ModBlocks.BAMBOO_STEM_WALL, ModBlocks.BAMBOO_STEM_FENCE, ModBlocks.BAMBOO_STEM_FENCE_GATE, ModBlocks.BAMBOO_STEM_SLAB, ModBlocks.BAMBOO_STEM_STAIRS),
            WoodVariants(Blocks.CRIMSON_STEM, ModBlocks.CRIMSON_HYPHAE_WALL, ModBlocks.CRIMSON_HYPHAE_FENCE, ModBlocks.CRIMSON_HYPHAE_FENCE_GATE, ModBlocks.CRIMSON_HYPHAE_SLAB, ModBlocks.CRIMSON_HYPHAE_STAIRS),
            WoodVariants(Blocks.WARPED_STEM, ModBlocks.WARPED_HYPHAE_WALL, ModBlocks.WARPED_HYPHAE_FENCE, ModBlocks.WARPED_HYPHAE_FENCE_GATE, ModBlocks.WARPED_HYPHAE_SLAB, ModBlocks.WARPED_HYPHAE_STAIRS)
        )

        woodVariantsList.forEach { (base, wall, fence, gate, slab, stairs) ->
            val family = BlockFamily.Builder(base)
                .wall(wall)
                .fence(fence)
                .fenceGate(gate)
                .slab(slab)
                .stairs(stairs)
                .build()

            blockStateModelGenerator.registerVanillaCompatibleFamily(family)
        }


        val hedgeVariantsList = listOf(
            HedgeVariant(Blocks.OAK_LEAVES, ModBlocks.OAK_LEAF_HEDGE),
            HedgeVariant(Blocks.SPRUCE_LEAVES, ModBlocks.SPRUCE_LEAF_HEDGE),
            HedgeVariant(Blocks.BIRCH_LEAVES, ModBlocks.BIRCH_LEAF_HEDGE),
            HedgeVariant(Blocks.JUNGLE_LEAVES, ModBlocks.JUNGLE_LEAF_HEDGE),
            HedgeVariant(Blocks.ACACIA_LEAVES, ModBlocks.ACACIA_LEAF_HEDGE),
            HedgeVariant(Blocks.DARK_OAK_LEAVES, ModBlocks.DARK_OAK_LEAF_HEDGE),
            HedgeVariant(Blocks.MANGROVE_LEAVES, ModBlocks.MANGROVE_LEAF_HEDGE),
            HedgeVariant(Blocks.CHERRY_LEAVES, ModBlocks.CHERRY_LEAF_HEDGE),
            HedgeVariant(Blocks.PALE_OAK_LEAVES, ModBlocks.PALE_OAK_LEAF_HEDGE),
            HedgeVariant(Blocks.AZALEA_LEAVES, ModBlocks.AZALEA_LEAF_HEDGE),
            HedgeVariant(Blocks.FLOWERING_AZALEA_LEAVES, ModBlocks.FLOWERING_AZALEA_LEAF_HEDGE),
            HedgeVariant(ModBlocks.BAMBOO_LEAVES, ModBlocks.BAMBOO_LEAF_HEDGE),
            HedgeVariant(Blocks.NETHER_WART_BLOCK, ModBlocks.NETHER_WART_HEDGE),
            HedgeVariant(Blocks.WARPED_WART_BLOCK, ModBlocks.WARPED_WART_HEDGE),
            HedgeVariant(Blocks.MOSS_BLOCK, ModBlocks.MOSS_HEDGE),
            HedgeVariant(Blocks.PALE_MOSS_BLOCK, ModBlocks.PALE_MOSS_HEDGE)
        )

        hedgeVariantsList.forEach { (base, wall) ->

            blockStateModelGenerator.registerTintableVanillaStyledWall(wall, base)
        }




    }

    override fun generateItemModels(itemModelGenerator: ItemModelGenerator) {

        itemModelGenerator.register(ModItems.BORROWED_SCREWS)

    }




    // Absulute bullshit

    // ----- ----- ----- //

    private fun BlockStateModelGenerator.registerVanillaCompatibleFamily(family: BlockFamily) {
        family.variants.forEach { (type, block) ->
            when (type) {
                BlockFamily.Variant.SLAB -> this.registerVanillaStyledSlab(block, family.baseBlock)
                BlockFamily.Variant.STAIRS -> this.registerVanillaStyledStairs(block, family.baseBlock)
                BlockFamily.Variant.FENCE -> this.registerVanillaStyledFence(block, family.baseBlock)
                BlockFamily.Variant.FENCE_GATE -> this.registerVanillaStyledFenceGate(block, family.baseBlock)
                BlockFamily.Variant.WALL -> this.registerVanillaStyledWall(block, family.baseBlock)
                else -> {}
            }
        }
    }



    data class WoodVariants(
        val base: Block,
        val wall: Block,
        val fence: Block,
        val gate: Block,
        val slab: Block,
        val stairs: Block
    )

    data class HedgeVariant(
        val base: Block,
        val wall: Block
    )

    data class PlankVariant(
        val base: Block,
        val wall: Block
    )








    fun BlockStateModelGenerator.registerVanillaStyledSlab(slab: Block, textureBlock: Block) {
        val textureMap = TextureMap.all(textureBlock)
        val bottom = Models.SLAB.upload(slab, textureMap, modelCollector)
        val top = Models.SLAB_TOP.upload(slab, textureMap, modelCollector)
        val full = ModelIds.getBlockModelId(textureBlock)
        blockStateCollector.accept(
            BlockStateModelGenerator.createSlabBlockState(
                slab,
                BlockStateModelGenerator.createWeightedVariant(bottom),
                BlockStateModelGenerator.createWeightedVariant(top),
                BlockStateModelGenerator.createWeightedVariant(full)
            )
        )
        registerParentedItemModel(slab, bottom)
    }

    fun BlockStateModelGenerator.registerVanillaStyledStairs(stairs: Block, textureBlock: Block) {
        val textureMap = TextureMap.all(textureBlock)
        val inner = Models.INNER_STAIRS.upload(stairs, textureMap, modelCollector)
        val straight = Models.STAIRS.upload(stairs, textureMap, modelCollector)
        val outer = Models.OUTER_STAIRS.upload(stairs, textureMap, modelCollector)
        blockStateCollector.accept(
            BlockStateModelGenerator.createStairsBlockState(
                stairs,
                BlockStateModelGenerator.createWeightedVariant(inner),
                BlockStateModelGenerator.createWeightedVariant(straight),
                BlockStateModelGenerator.createWeightedVariant(outer)
            )
        )
        registerParentedItemModel(stairs, straight)
    }

    fun BlockStateModelGenerator.registerVanillaStyledFence(fence: Block, textureBlock: Block) {
        val textureMap = TextureMap.all(textureBlock)
        val post = Models.FENCE_POST.upload(fence, textureMap, modelCollector)
        val side = Models.FENCE_SIDE.upload(fence, textureMap, modelCollector)
        val inventory = Models.FENCE_INVENTORY.upload(fence, textureMap, modelCollector)
        blockStateCollector.accept(
            BlockStateModelGenerator.createFenceBlockState(
                fence,
                BlockStateModelGenerator.createWeightedVariant(post),
                BlockStateModelGenerator.createWeightedVariant(side)
            )
        )
        registerParentedItemModel(fence, inventory)
    }

    fun BlockStateModelGenerator.registerVanillaStyledFenceGate(gate: Block, textureBlock: Block) {
        val textureMap = TextureMap.all(textureBlock)
        val open = Models.TEMPLATE_FENCE_GATE_OPEN.upload(gate, textureMap, modelCollector)
        val closed = Models.TEMPLATE_FENCE_GATE.upload(gate, textureMap, modelCollector)
        val wallOpen = Models.TEMPLATE_FENCE_GATE_WALL_OPEN.upload(gate, textureMap, modelCollector)
        val wallClosed = Models.TEMPLATE_FENCE_GATE_WALL.upload(gate, textureMap, modelCollector)
        blockStateCollector.accept(
            BlockStateModelGenerator.createFenceGateBlockState(
                gate,
                BlockStateModelGenerator.createWeightedVariant(open),
                BlockStateModelGenerator.createWeightedVariant(closed),
                BlockStateModelGenerator.createWeightedVariant(wallOpen),
                BlockStateModelGenerator.createWeightedVariant(wallClosed),
                true
            )
        )
    }

    fun BlockStateModelGenerator.registerVanillaStyledWall(wall: Block, textureBlock: Block) {
        val textureMap = TextureMap.all(textureBlock)
        val post = Models.TEMPLATE_WALL_POST.upload(wall, textureMap, modelCollector)
        val side = Models.TEMPLATE_WALL_SIDE.upload(wall, textureMap, modelCollector)
        val sideTall = Models.TEMPLATE_WALL_SIDE_TALL.upload(wall, textureMap, modelCollector)
        val inventory = Models.WALL_INVENTORY.upload(wall, textureMap, modelCollector)
        blockStateCollector.accept(
            BlockStateModelGenerator.createWallBlockState(
                wall,
                BlockStateModelGenerator.createWeightedVariant(post),
                BlockStateModelGenerator.createWeightedVariant(side),
                BlockStateModelGenerator.createWeightedVariant(sideTall)
            )
        )
        registerParentedItemModel(wall, inventory)
    }


    fun BlockStateModelGenerator.registerTintableVanillaStyledWall(wall: Block, textureBlock: Block) {
        val modId = LittleJohns.MOD_ID
        val wallTextureMap = TextureMap().put(TextureKey.WALL, ModelIds.getBlockModelId(textureBlock))

        val post = Model(
            Optional.of(Identifier.of(modId, "block/template_wall_post_tintable")),
            Optional.empty(),
            TextureKey.WALL
        ).upload(wall, "_post", wallTextureMap, modelCollector)

        val side = Model(
            Optional.of(Identifier.of(modId, "block/template_wall_side_tintable")),
            Optional.empty(),
            TextureKey.WALL
        ).upload(wall, "_side", wallTextureMap, modelCollector)

        val sideTall = Model(
            Optional.of(Identifier.of(modId, "block/template_wall_side_tall_tintable")),
            Optional.empty(),
            TextureKey.WALL
        ).upload(wall, "_side_tall", wallTextureMap, modelCollector)

        val inventory = Model(
            Optional.of(Identifier.of(modId, "block/template_wall_inventory_tintable")),
            Optional.empty(),
            TextureKey.WALL
        ).upload(wall, "_inventory", wallTextureMap, modelCollector)

        blockStateCollector.accept(
            BlockStateModelGenerator.createWallBlockState(
                wall,
                BlockStateModelGenerator.createWeightedVariant(post),
                BlockStateModelGenerator.createWeightedVariant(side),
                BlockStateModelGenerator.createWeightedVariant(sideTall)
            )
        )

        registerParentedItemModel(wall, inventory)
    }


    fun BlockStateModelGenerator.registerVanillaStyledButton(button: Block, textureBlock: Block) {
        val textureMap = TextureMap.all(textureBlock)
        val up = Models.BUTTON.upload(button, textureMap, modelCollector)
        val down = Models.BUTTON_PRESSED.upload(button, textureMap, modelCollector)
        val inventory = Models.BUTTON_INVENTORY.upload(button, textureMap, modelCollector)
        blockStateCollector.accept(
            BlockStateModelGenerator.createButtonBlockState(
                button,
                BlockStateModelGenerator.createWeightedVariant(up),
                BlockStateModelGenerator.createWeightedVariant(down)
            )
        )
        registerParentedItemModel(button, inventory)
    }

    fun BlockStateModelGenerator.registerVanillaStyledPressurePlate(plate: Block, textureBlock: Block) {
        val textureMap = TextureMap.all(textureBlock)
        val up = Models.PRESSURE_PLATE_UP.upload(plate, textureMap, modelCollector)
        val down = Models.PRESSURE_PLATE_DOWN.upload(plate, textureMap, modelCollector)
        blockStateCollector.accept(
            BlockStateModelGenerator.createPressurePlateBlockState(
                plate,
                BlockStateModelGenerator.createWeightedVariant(up),
                BlockStateModelGenerator.createWeightedVariant(down)
            )
        )
    }

}