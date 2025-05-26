package net.echo.little_johns.block

import net.echo.little_johns.LittleJohns
import net.echo.little_johns.block.custom.BeamBlock
import net.echo.little_johns.block.custom.ChandelierBlock
import net.echo.little_johns.block.custom.ColossalChainBlock
import net.echo.little_johns.block.custom.EcoFriendlyWoodVeneersBlock
import net.echo.little_johns.block.custom.GrandChainBlock
import net.echo.little_johns.block.custom.TableSawBlock
import net.echo.little_johns.block.custom.TintedParticleEcoFriendlyLeavesVeneersBlock
import net.echo.little_johns.block.custom.UntintedParticleEcoFriendlyLeavesVeneersBlock
import net.echo.little_johns.item.ModItems
import net.echo.little_johns.sound.ModBlockSoundGroup
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.block.Blocks.createLeavesSettings
import net.minecraft.block.ChainBlock
import net.minecraft.block.FenceBlock
import net.minecraft.block.FenceGateBlock
import net.minecraft.block.MapColor
import net.minecraft.block.SlabBlock
import net.minecraft.block.StairsBlock
import net.minecraft.block.UntintedParticleLeavesBlock
import net.minecraft.block.WallBlock
import net.minecraft.block.WoodType
import net.minecraft.block.piston.PistonBehavior
import net.minecraft.item.BlockItem
import net.minecraft.particle.EntityEffectParticleEffect
import net.minecraft.particle.ParticleTypes
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier

object ModBlocks {



    // MISC
    val BAMBOO_LEAVES = registerBlockWithItem("bamboo_leaves",{ settings -> UntintedParticleLeavesBlock(0.01F, EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, -11712407), settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first



    // GALVANIZED SQUARE STEEL
    val GALVANIZED_SQUARE_STEEL_BLOCK = registerBlockWithItem("galvanized_square_steel_block", { settings -> Block(settings) }, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)).first
    val GALVANIZED_SQUARE_STEEL_STAIRS = registerBlockWithItem("galvanized_square_steel_stairs", { settings -> StairsBlock(GALVANIZED_SQUARE_STEEL_BLOCK.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)).first
    val GALVANIZED_SQUARE_STEEL_SLAB = registerBlockWithItem("galvanized_square_steel_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.NETHERITE)).first
    val GALVANIZED_SQUARE_STEEL_BEAM = registerBlockWithItem("galvanized_square_steel_beam", { settings -> BeamBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHAIN).nonOpaque().sounds(BlockSoundGroup.NETHERITE)).first
    val GALVANIZED_SQUARE_STEEL = registerBlockWithItem("galvanized_square_steel", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()).first
    val GALVANIZED_SQUARE_STEEL_GRATE = registerBlockWithItem("galvanized_square_steel_grate", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()).first



    // Table Saws
    val OAK_TABLE_SAW = registerBlockWithItem("oak_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque()).first
    val SPRUCE_TABLE_SAW = registerBlockWithItem("spruce_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).nonOpaque()).first
    val BIRCH_TABLE_SAW = registerBlockWithItem("birch_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD).nonOpaque()).first
    val JUNGLE_TABLE_SAW = registerBlockWithItem("jungle_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD).nonOpaque()).first
    val ACACIA_TABLE_SAW = registerBlockWithItem("acacia_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD).nonOpaque()).first
    val DARK_OAK_TABLE_SAW = registerBlockWithItem("dark_oak_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD).nonOpaque()).first
    val MANGROVE_TABLE_SAW = registerBlockWithItem("mangrove_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD).nonOpaque()).first
    val CHERRY_TABLE_SAW = registerBlockWithItem("cherry_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD).nonOpaque()).first
    val PALE_OAK_TABLE_SAW = registerBlockWithItem("pale_oak_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD).nonOpaque()).first
    val BAMBOO_TABLE_SAW = registerBlockWithItem("bamboo_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()).first
    val CRIMSON_TABLE_SAW = registerBlockWithItem("crimson_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE).nonOpaque()).first
    val WARPED_TABLE_SAW = registerBlockWithItem("warped_table_saw", { settings -> TableSawBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE).nonOpaque()).first



    // WOOD FRAMEWORK
    val OAK_WOOD_FRAMEWORK = registerBlockWithItem("oak_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque()).first
    val SPRUCE_WOOD_FRAMEWORK = registerBlockWithItem("spruce_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).nonOpaque()).first
    val BIRCH_WOOD_FRAMEWORK = registerBlockWithItem("birch_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD).nonOpaque()).first
    val JUNGLE_WOOD_FRAMEWORK = registerBlockWithItem("jungle_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD).nonOpaque()).first
    val ACACIA_WOOD_FRAMEWORK = registerBlockWithItem("acacia_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD).nonOpaque()).first
    val DARK_OAK_WOOD_FRAMEWORK = registerBlockWithItem("dark_oak_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD).nonOpaque()).first
    val MANGROVE_WOOD_FRAMEWORK = registerBlockWithItem("mangrove_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD).nonOpaque()).first
    val CHERRY_WOOD_FRAMEWORK = registerBlockWithItem("cherry_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD).nonOpaque()).first
    val PALE_OAK_WOOD_FRAMEWORK = registerBlockWithItem("pale_oak_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD).nonOpaque()).first
    val BAMBOO_FRAMEWORK = registerBlockWithItem("bamboo_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()).first
    val CRIMSON_HYPHAE_FRAMEWORK = registerBlockWithItem("crimson_hyphae_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE).nonOpaque()).first
    val WARPED_HYPHAE_FRAMEWORK = registerBlockWithItem("warped_hyphae_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE).nonOpaque()).first



    // STRIPPED WOOD FRAMEWORK
    val STRIPPED_OAK_WOOD_FRAMEWORK = registerBlockWithItem("stripped_oak_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque()).first
    val STRIPPED_SPRUCE_WOOD_FRAMEWORK = registerBlockWithItem("stripped_spruce_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).nonOpaque()).first
    val STRIPPED_BIRCH_WOOD_FRAMEWORK = registerBlockWithItem("stripped_birch_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD).nonOpaque()).first
    val STRIPPED_JUNGLE_WOOD_FRAMEWORK = registerBlockWithItem("stripped_jungle_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD).nonOpaque()).first
    val STRIPPED_ACACIA_WOOD_FRAMEWORK = registerBlockWithItem("stripped_acacia_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD).nonOpaque()).first
    val STRIPPED_DARK_OAK_WOOD_FRAMEWORK = registerBlockWithItem("stripped_dark_oak_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD).nonOpaque()).first
    val STRIPPED_MANGROVE_WOOD_FRAMEWORK = registerBlockWithItem("stripped_mangrove_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD).nonOpaque()).first
    val STRIPPED_CHERRY_WOOD_FRAMEWORK = registerBlockWithItem("stripped_cherry_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD).nonOpaque()).first
    val STRIPPED_PALE_OAK_WOOD_FRAMEWORK = registerBlockWithItem("stripped_pale_oak_wood_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD).nonOpaque()).first
    val STRIPPED_BAMBOO_FRAMEWORK = registerBlockWithItem("stripped_bamboo_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()).first
    val STRIPPED_CRIMSON_HYPHAE_FRAMEWORK = registerBlockWithItem("stripped_crimson_hyphae_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE).nonOpaque()).first
    val STRIPPED_WARPED_HYPHAE_FRAMEWORK = registerBlockWithItem("stripped_warped_hyphae_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE).nonOpaque()).first

    val BAMBOO_MOSAIC_FRAMEWORK = registerBlockWithItem("mosaic_bamboo_framework", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_MOSAIC).nonOpaque()).first



    // WOOD PLANK VENEERS
    val ECO_FRIENDLY_OAK_PLANK_VENEERS = registerBlockWithItem("eco_friendly_oak_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_SPRUCE_PLANK_VENEERS = registerBlockWithItem("eco_friendly_spruce_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_BIRCH_PLANK_VENEERS = registerBlockWithItem("eco_friendly_birch_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_JUNGLE_PLANK_VENEERS = registerBlockWithItem("eco_friendly_jungle_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_ACACIA_PLANK_VENEERS = registerBlockWithItem("eco_friendly_acacia_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_DARK_OAK_PLANK_VENEERS = registerBlockWithItem("eco_friendly_dark_oak_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_MANGROVE_PLANK_VENEERS = registerBlockWithItem("eco_friendly_mangrove_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_CHERRY_PLANK_VENEERS = registerBlockWithItem("eco_friendly_cherry_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_PALE_OAK_PLANK_VENEERS = registerBlockWithItem("eco_friendly_pale_oak_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_BAMBOO_PLANK_VENEERS = registerBlockWithItem("eco_friendly_bamboo_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_CRIMSON_PLANK_VENEERS = registerBlockWithItem("eco_friendly_crimson_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_WARPED_PLANK_VENEERS = registerBlockWithItem("eco_friendly_warped_plank_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS).nonOpaque()).first

    val ECO_FRIENDLY_BAMBOO_MOSAIC_VENEERS = registerBlockWithItem("eco_friendly_bamboo_mosaic_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_MOSAIC).nonOpaque()).first



    // WOOD LOG VENEERS
    val ECO_FRIENDLY_OAK_WOOD_VENEERS = registerBlockWithItem("eco_friendly_oak_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_SPRUCE_WOOD_VENEERS = registerBlockWithItem("eco_friendly_spruce_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_BIRCH_WOOD_VENEERS = registerBlockWithItem("eco_friendly_birch_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_JUNGLE_WOOD_VENEERS = registerBlockWithItem("eco_friendly_jungle_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_ACACIA_WOOD_VENEERS = registerBlockWithItem("eco_friendly_acacia_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_DARK_OAK_WOOD_VENEERS = registerBlockWithItem("eco_friendly_dark_oak_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_MANGROVE_WOOD_VENEERS = registerBlockWithItem("eco_friendly_mangrove_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_CHERRY_WOOD_VENEERS = registerBlockWithItem("eco_friendly_cherry_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_PALE_OAK_WOOD_VENEERS = registerBlockWithItem("eco_friendly_pale_oak_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_BAMBOO_VENEERS = registerBlockWithItem("eco_friendly_bamboo_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_CRIMSON_HYPHAE_VENEERS = registerBlockWithItem("eco_friendly_crimson_hyphae_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE).nonOpaque()).first
    val ECO_FRIENDLY_WARPED_HYPHAE_VENEERS = registerBlockWithItem("eco_friendly_warped_hyphae_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE).nonOpaque()).first



    // STRIPPED WOOD LOG VENEERS
    val ECO_FRIENDLY_STRIPPED_OAK_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_oak_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_SPRUCE_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_spruce_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_BIRCH_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_birch_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_JUNGLE_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_jungle_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_ACACIA_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_acacia_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_DARK_OAK_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_dark_oak_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_MANGROVE_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_mangrove_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_CHERRY_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_cherry_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_PALE_OAK_WOOD_VENEERS = registerBlockWithItem("eco_friendly_stripped_pale_oak_wood_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD).nonOpaque()).first
    //val ECO_FRIENDLY_STRIPPED_BAMBOO_VENEERS = registerBlockWithItem("eco_friendly_stripped_bamboo_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_CRIMSON_HYPHAE_VENEERS = registerBlockWithItem("eco_friendly_stripped_crimson_hyphae_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE).nonOpaque()).first
    val ECO_FRIENDLY_STRIPPED_WARPED_HYPHAE_VENEERS = registerBlockWithItem("eco_friendly_stripped_warped_hyphae_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE).nonOpaque()).first



    // LEAF VENEERS
    val ECO_FRIENDLY_OAK_LEAF_VENEERS = registerBlockWithItem("eco_friendly_oak_leaf_veneers", { settings -> TintedParticleEcoFriendlyLeavesVeneersBlock(0.01f, settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_SPRUCE_LEAF_VENEERS = registerBlockWithItem("eco_friendly_spruce_leaf_veneers", { settings -> TintedParticleEcoFriendlyLeavesVeneersBlock(0.01f, settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_BIRCH_LEAF_VENEERS = registerBlockWithItem("eco_friendly_birch_leaf_veneers", { settings -> TintedParticleEcoFriendlyLeavesVeneersBlock(0.01f, settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_JUNGLE_LEAF_VENEERS = registerBlockWithItem("eco_friendly_jungle_leaf_veneers", { settings -> TintedParticleEcoFriendlyLeavesVeneersBlock(0.01f, settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_ACACIA_LEAF_VENEERS = registerBlockWithItem("eco_friendly_acacia_leaf_veneers", { settings -> TintedParticleEcoFriendlyLeavesVeneersBlock(0.01f, settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_DARK_OAK_LEAF_VENEERS = registerBlockWithItem("eco_friendly_dark_oak_leaf_veneers", { settings -> TintedParticleEcoFriendlyLeavesVeneersBlock(0.01f, settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_MANGROVE_LEAF_VENEERS = registerBlockWithItem("eco_friendly_mangrove_leaf_veneers", { settings -> TintedParticleEcoFriendlyLeavesVeneersBlock(0.01f, settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_CHERRY_LEAF_VENEERS = registerBlockWithItem("eco_friendly_cherry_leaf_veneers", { settings -> UntintedParticleEcoFriendlyLeavesVeneersBlock(0.1f,ParticleTypes.CHERRY_LEAVES, settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES)).first
    val ECO_FRIENDLY_PALE_OAK_LEAF_VENEERS = registerBlockWithItem("eco_friendly_pale_oak_leaf_veneers", { settings -> UntintedParticleEcoFriendlyLeavesVeneersBlock(0.02f,ParticleTypes.PALE_OAK_LEAVES, settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_LEAVES)).first
    val ECO_FRIENDLY_AZALEA_LEAF_VENEERS = registerBlockWithItem("eco_friendly_azalea_leaf_veneers", { settings -> UntintedParticleEcoFriendlyLeavesVeneersBlock(0.01f,EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, -9399763), settings) }, createLeavesSettings(BlockSoundGroup.AZALEA_LEAVES)).first
    val ECO_FRIENDLY_FLOWERING_AZALEA_LEAF_VENEERS = registerBlockWithItem("eco_friendly_flowering_azalea_leaf_veneers", { settings -> UntintedParticleEcoFriendlyLeavesVeneersBlock(0.01f,EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, -9399763), settings) }, createLeavesSettings(BlockSoundGroup.AZALEA_LEAVES)).first
    val ECO_FRIENDLY_BAMBOO_LEAF_VENEERS = registerBlockWithItem("eco_friendly_bamboo_leaf_veneers", { settings -> UntintedParticleEcoFriendlyLeavesVeneersBlock(0.01f,EntityEffectParticleEffect.create(ParticleTypes.TINTED_LEAVES, -11712407), settings) }, createLeavesSettings(BlockSoundGroup.GRASS)).first
    val ECO_FRIENDLY_NETHER_WART_VENEERS = registerBlockWithItem("eco_friendly_nether_wart_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.NETHER_WART_BLOCK).nonOpaque()).first
    val ECO_FRIENDLY_WARPED_WART_VENEERS = registerBlockWithItem("eco_friendly_warped_wart_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_WART_BLOCK).nonOpaque()).first



    // OTHER VENEERS
    val ECO_FRIENDLY_MOSS_VENEERS = registerBlockWithItem("eco_friendly_moss_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK).nonOpaque()).first
    val ECO_FRIENDLY_PALE_MOSS_VENEERS = registerBlockWithItem("eco_friendly_pale_moss_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_MOSS_BLOCK).nonOpaque()).first
    val ECO_FRIENDLY_GRASS_VENEERS = registerBlockWithItem("eco_friendly_grass_veneers", { settings -> EcoFriendlyWoodVeneersBlock(settings) }, AbstractBlock.Settings.copy(Blocks.GRASS_BLOCK).nonOpaque()).first



    // LEAF HEDGES
    val OAK_LEAF_HEDGE = registerBlockWithItem("oak_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_LEAVES).nonOpaque()).first
    val SPRUCE_LEAF_HEDGE = registerBlockWithItem("spruce_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_LEAVES).nonOpaque()).first
    val BIRCH_LEAF_HEDGE = registerBlockWithItem("birch_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_LEAVES).nonOpaque()).first
    val JUNGLE_LEAF_HEDGE = registerBlockWithItem("jungle_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_LEAVES).nonOpaque()).first
    val ACACIA_LEAF_HEDGE = registerBlockWithItem("acacia_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_LEAVES).nonOpaque()).first
    val DARK_OAK_LEAF_HEDGE = registerBlockWithItem("dark_oak_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_LEAVES).nonOpaque()).first
    val MANGROVE_LEAF_HEDGE = registerBlockWithItem("mangrove_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_LEAVES).nonOpaque()).first
    val CHERRY_LEAF_HEDGE = registerBlockWithItem("cherry_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_LEAVES).nonOpaque()).first
    val PALE_OAK_LEAF_HEDGE = registerBlockWithItem("pale_oak_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_LEAVES).nonOpaque()).first
    val AZALEA_LEAF_HEDGE = registerBlockWithItem("azalea_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.AZALEA_LEAVES).nonOpaque()).first
    val FLOWERING_AZALEA_LEAF_HEDGE = registerBlockWithItem("flowering_azalea_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.FLOWERING_AZALEA_LEAVES).nonOpaque()).first
    val BAMBOO_LEAF_HEDGE = registerBlockWithItem("bamboo_leaf_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(ModBlocks.BAMBOO_LEAVES).nonOpaque()).first
    val NETHER_WART_HEDGE = registerBlockWithItem("nether_wart_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.NETHER_WART_BLOCK).nonOpaque()).first
    val WARPED_WART_HEDGE = registerBlockWithItem("warped_wart_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_WART_BLOCK).nonOpaque()).first
    val MOSS_HEDGE = registerBlockWithItem("moss_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MOSS_BLOCK).nonOpaque()).first
    val PALE_MOSS_HEDGE = registerBlockWithItem("pale_moss_hedge", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_MOSS_BLOCK).nonOpaque()).first



    // FENCES
    val OAK_WOOD_FENCE = registerBlockWithItem("oak_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val SPRUCE_WOOD_FENCE = registerBlockWithItem("spruce_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val BIRCH_WOOD_FENCE = registerBlockWithItem("birch_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val JUNGLE_WOOD_FENCE = registerBlockWithItem("jungle_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val ACACIA_WOOD_FENCE = registerBlockWithItem("acacia_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val DARK_OAK_WOOD_FENCE = registerBlockWithItem("dark_oak_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val MANGROVE_WOOD_FENCE = registerBlockWithItem("mangrove_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val CHERRY_WOOD_FENCE = registerBlockWithItem("cherry_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val PALE_OAK_WOOD_FENCE = registerBlockWithItem("pale_oak_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    val BAMBOO_STEM_FENCE = registerBlockWithItem("bamboo_stem_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val CRIMSON_HYPHAE_FENCE = registerBlockWithItem("crimson_hyphae_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val WARPED_HYPHAE_FENCE = registerBlockWithItem("warped_hyphae_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // STRIPPED FENCES
    val STRIPPED_OAK_WOOD_FENCE = registerBlockWithItem("stripped_oak_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val STRIPPED_SPRUCE_WOOD_FENCE = registerBlockWithItem("stripped_spruce_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val STRIPPED_BIRCH_WOOD_FENCE = registerBlockWithItem("stripped_birch_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val STRIPPED_JUNGLE_WOOD_FENCE = registerBlockWithItem("stripped_jungle_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val STRIPPED_ACACIA_WOOD_FENCE = registerBlockWithItem("stripped_acacia_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val STRIPPED_DARK_OAK_WOOD_FENCE = registerBlockWithItem("stripped_dark_oak_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val STRIPPED_MANGROVE_WOOD_FENCE = registerBlockWithItem("stripped_mangrove_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val STRIPPED_CHERRY_WOOD_FENCE = registerBlockWithItem("stripped_cherry_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val STRIPPED_PALE_OAK_WOOD_FENCE = registerBlockWithItem("stripped_pale_oak_wood_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    //val STRIPPED_BAMBOO_STEM_FENCE = registerBlockWithItem("stripped_bamboo_stem_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val STRIPPED_CRIMSON_HYPHAE_FENCE = registerBlockWithItem("stripped_crimson_hyphae_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val STRIPPED_WARPED_HYPHAE_FENCE = registerBlockWithItem("stripped_warped_hyphae_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first

    val BAMBOO_MOSAIC_FENCE = registerBlockWithItem("bamboo_mosaic_fence", { settings -> FenceBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_MOSAIC)).first



    // FENCE GATES
    val OAK_WOOD_FENCE_GATE = registerBlockWithItem("oak_wood_fence_gate", { settings -> FenceGateBlock(WoodType.OAK, settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val SPRUCE_WOOD_FENCE_GATE = registerBlockWithItem("spruce_wood_fence_gate", { settings -> FenceGateBlock(WoodType.SPRUCE, settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val BIRCH_WOOD_FENCE_GATE = registerBlockWithItem("birch_wood_fence_gate", { settings -> FenceGateBlock(WoodType.BIRCH, settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val JUNGLE_WOOD_FENCE_GATE = registerBlockWithItem("jungle_wood_fence_gate", { settings -> FenceGateBlock(WoodType.JUNGLE, settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val ACACIA_WOOD_FENCE_GATE = registerBlockWithItem("acacia_wood_fence_gate", { settings -> FenceGateBlock(WoodType.ACACIA, settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val DARK_OAK_WOOD_FENCE_GATE = registerBlockWithItem("dark_oak_wood_fence_gate", { settings -> FenceGateBlock(WoodType.DARK_OAK, settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val MANGROVE_WOOD_FENCE_GATE = registerBlockWithItem("mangrove_wood_fence_gate", { settings -> FenceGateBlock(WoodType.MANGROVE, settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val CHERRY_WOOD_FENCE_GATE = registerBlockWithItem("cherry_wood_fence_gate", { settings -> FenceGateBlock(WoodType.CHERRY, settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val PALE_OAK_WOOD_FENCE_GATE = registerBlockWithItem("pale_oak_wood_fence_gate", { settings -> FenceGateBlock(WoodType.PALE_OAK, settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    val BAMBOO_STEM_FENCE_GATE = registerBlockWithItem("bamboo_stem_fence_gate", { settings -> FenceGateBlock(WoodType.BAMBOO, settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val CRIMSON_HYPHAE_FENCE_GATE = registerBlockWithItem("crimson_hyphae_fence_gate", { settings -> FenceGateBlock(WoodType.CRIMSON, settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val WARPED_HYPHAE_FENCE_GATE = registerBlockWithItem("warped_hyphae_fence_gate", { settings -> FenceGateBlock(WoodType.WARPED, settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // STRIPPED FENCE GATES
    val STRIPPED_OAK_WOOD_FENCE_GATE = registerBlockWithItem("stripped_oak_wood_fence_gate", { settings -> FenceGateBlock(WoodType.OAK, settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val STRIPPED_SPRUCE_WOOD_FENCE_GATE = registerBlockWithItem("stripped_spruce_wood_fence_gate", { settings -> FenceGateBlock(WoodType.SPRUCE, settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val STRIPPED_BIRCH_WOOD_FENCE_GATE = registerBlockWithItem("stripped_birch_wood_fence_gate", { settings -> FenceGateBlock(WoodType.BIRCH, settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val STRIPPED_JUNGLE_WOOD_FENCE_GATE = registerBlockWithItem("stripped_jungle_wood_fence_gate", { settings -> FenceGateBlock(WoodType.JUNGLE, settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val STRIPPED_ACACIA_WOOD_FENCE_GATE = registerBlockWithItem("stripped_acacia_wood_fence_gate", { settings -> FenceGateBlock(WoodType.ACACIA, settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val STRIPPED_DARK_OAK_WOOD_FENCE_GATE = registerBlockWithItem("stripped_dark_oak_wood_fence_gate", { settings -> FenceGateBlock(WoodType.DARK_OAK, settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val STRIPPED_MANGROVE_WOOD_FENCE_GATE = registerBlockWithItem("stripped_mangrove_wood_fence_gate", { settings -> FenceGateBlock(WoodType.MANGROVE, settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val STRIPPED_CHERRY_WOOD_FENCE_GATE = registerBlockWithItem("stripped_cherry_wood_fence_gate", { settings -> FenceGateBlock(WoodType.CHERRY, settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val STRIPPED_PALE_OAK_WOOD_FENCE_GATE = registerBlockWithItem("stripped_pale_oak_wood_fence_gate", { settings -> FenceGateBlock(WoodType.PALE_OAK, settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    //val STRIPPED_BAMBOO_STEM_FENCE_GATE = registerBlockWithItem("stripped_bamboo_stem_fence_gate", { settings -> FenceGateBlock(WoodType.BAMBOO, settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val STRIPPED_CRIMSON_HYPHAE_FENCE_GATE = registerBlockWithItem("stripped_crimson_hyphae_fence_gate", { settings -> FenceGateBlock(WoodType.CRIMSON, settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val STRIPPED_WARPED_HYPHAE_FENCE_GATE = registerBlockWithItem("stripped_warped_hyphae_fence_gate", { settings -> FenceGateBlock(WoodType.WARPED, settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first

    val BAMBOO_MOSAIC_FENCE_GATE = registerBlockWithItem("bamboo_mosaic_fence_gate", { settings -> FenceGateBlock(WoodType.BAMBOO, settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_MOSAIC)).first



    // WALLS
    val OAK_WOOD_WALL = registerBlockWithItem("oak_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val SPRUCE_WOOD_WALL = registerBlockWithItem("spruce_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val BIRCH_WOOD_WALL = registerBlockWithItem("birch_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val JUNGLE_WOOD_WALL = registerBlockWithItem("jungle_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val ACACIA_WOOD_WALL = registerBlockWithItem("acacia_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val DARK_OAK_WOOD_WALL = registerBlockWithItem("dark_oak_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val MANGROVE_WOOD_WALL = registerBlockWithItem("mangrove_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val CHERRY_WOOD_WALL = registerBlockWithItem("cherry_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val PALE_OAK_WOOD_WALL = registerBlockWithItem("pale_oak_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    val BAMBOO_STEM_WALL = registerBlockWithItem("bamboo_stem_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val CRIMSON_HYPHAE_WALL = registerBlockWithItem("crimson_hyphae_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val WARPED_HYPHAE_WALL = registerBlockWithItem("warped_hyphae_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // STRIPPED WALLS
    val STRIPPED_OAK_WOOD_WALL = registerBlockWithItem("stripped_oak_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val STRIPPED_SPRUCE_WOOD_WALL = registerBlockWithItem("stripped_spruce_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val STRIPPED_BIRCH_WOOD_WALL = registerBlockWithItem("stripped_birch_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val STRIPPED_JUNGLE_WOOD_WALL = registerBlockWithItem("stripped_jungle_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val STRIPPED_ACACIA_WOOD_WALL = registerBlockWithItem("stripped_acacia_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val STRIPPED_DARK_OAK_WOOD_WALL = registerBlockWithItem("stripped_dark_oak_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val STRIPPED_MANGROVE_WOOD_WALL = registerBlockWithItem("stripped_mangrove_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val STRIPPED_CHERRY_WOOD_WALL = registerBlockWithItem("stripped_cherry_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val STRIPPED_PALE_OAK_WOOD_WALL = registerBlockWithItem("stripped_pale_oak_wood_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    //val STRIPPED_BAMBOO_STEM_WALL = registerBlockWithItem("stripped_bamboo_stem_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val STRIPPED_CRIMSON_HYPHAE_WALL = registerBlockWithItem("stripped_crimson_hyphae_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val STRIPPED_WARPED_HYPHAE_WALL = registerBlockWithItem("stripped_warped_hyphae_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // PLANK WALLS
    val OAK_PLANK_WALL = registerBlockWithItem("oak_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)).first
    val SPRUCE_PLANK_WALL = registerBlockWithItem("spruce_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS)).first
    val BIRCH_PLANK_WALL = registerBlockWithItem("birch_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS)).first
    val JUNGLE_PLANK_WALL = registerBlockWithItem("jungle_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS)).first
    val ACACIA_PLANK_WALL = registerBlockWithItem("acacia_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS)).first
    val DARK_OAK_PLANK_WALL = registerBlockWithItem("dark_oak_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS)).first
    val MANGROVE_PLANK_WALL = registerBlockWithItem("mangrove_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS)).first
    val CHERRY_PLANK_WALL = registerBlockWithItem("cherry_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS)).first
    val PALE_OAK_PLANK_WALL = registerBlockWithItem("pale_oak_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_PLANKS)).first
    val BAMBOO_PLANK_WALL = registerBlockWithItem("bamboo_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val CRIMSON_PLANK_WALL = registerBlockWithItem("crimson_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS)).first
    val WARPED_PLANK_WALL = registerBlockWithItem("warped_plank_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS)).first

    val BAMBOO_MOSAIC_WALL = registerBlockWithItem("bamboo_mosaic_wall", { settings -> WallBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_MOSAIC)).first



    // SLABS
    val OAK_WOOD_SLAB = registerBlockWithItem("oak_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val SPRUCE_WOOD_SLAB = registerBlockWithItem("spruce_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val BIRCH_WOOD_SLAB = registerBlockWithItem("birch_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val JUNGLE_WOOD_SLAB = registerBlockWithItem("jungle_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val ACACIA_WOOD_SLAB = registerBlockWithItem("acacia_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val DARK_OAK_WOOD_SLAB = registerBlockWithItem("dark_oak_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val MANGROVE_WOOD_SLAB = registerBlockWithItem("mangrove_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val CHERRY_WOOD_SLAB = registerBlockWithItem("cherry_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val PALE_OAK_WOOD_SLAB = registerBlockWithItem("pale_oak_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    val BAMBOO_STEM_SLAB = registerBlockWithItem("bamboo_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val CRIMSON_HYPHAE_SLAB = registerBlockWithItem("crimson_hyphae_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val WARPED_HYPHAE_SLAB = registerBlockWithItem("warped_hyphae_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // STRIPPED SLABS
    val STRIPPED_OAK_WOOD_SLAB = registerBlockWithItem("stripped_oak_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val STRIPPED_SPRUCE_WOOD_SLAB = registerBlockWithItem("stripped_spruce_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val STRIPPED_BIRCH_WOOD_SLAB = registerBlockWithItem("stripped_birch_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val STRIPPED_JUNGLE_WOOD_SLAB = registerBlockWithItem("stripped_jungle_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val STRIPPED_ACACIA_WOOD_SLAB = registerBlockWithItem("stripped_acacia_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val STRIPPED_DARK_OAK_WOOD_SLAB = registerBlockWithItem("stripped_dark_oak_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val STRIPPED_MANGROVE_WOOD_SLAB = registerBlockWithItem("stripped_mangrove_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val STRIPPED_CHERRY_WOOD_SLAB = registerBlockWithItem("stripped_cherry_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val STRIPPED_PALE_OAK_WOOD_SLAB = registerBlockWithItem("stripped_pale_oak_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    //val STRIPPED_BAMBOO_STEM_SLAB = registerBlockWithItem("stripped_bamboo_wood_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val STRIPPED_CRIMSON_HYPHAE_SLAB = registerBlockWithItem("stripped_crimson_hyphae_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val STRIPPED_WARPED_HYPHAE_SLAB = registerBlockWithItem("stripped_warped_hyphae_slab", { settings -> SlabBlock(settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // STAIRS
    val OAK_WOOD_STAIRS = registerBlockWithItem("oak_wood_stairs", { settings -> StairsBlock(Blocks.OAK_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val SPRUCE_WOOD_STAIRS = registerBlockWithItem("spruce_wood_stairs", { settings -> StairsBlock(Blocks.SPRUCE_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val BIRCH_WOOD_STAIRS = registerBlockWithItem("birch_wood_stairs", { settings -> StairsBlock(Blocks.BIRCH_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val JUNGLE_WOOD_STAIRS = registerBlockWithItem("jungle_wood_stairs", { settings -> StairsBlock(Blocks.JUNGLE_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val ACACIA_WOOD_STAIRS = registerBlockWithItem("acacia_wood_stairs", { settings -> StairsBlock(Blocks.ACACIA_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val DARK_OAK_WOOD_STAIRS = registerBlockWithItem("dark_oak_wood_stairs", { settings -> StairsBlock(Blocks.DARK_OAK_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val MANGROVE_WOOD_STAIRS = registerBlockWithItem("mangrove_wood_stairs", { settings -> StairsBlock(Blocks.MANGROVE_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val CHERRY_WOOD_STAIRS = registerBlockWithItem("cherry_wood_stairs", { settings -> StairsBlock(Blocks.CHERRY_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val PALE_OAK_WOOD_STAIRS = registerBlockWithItem("pale_oak_wood_stairs", { settings -> StairsBlock(Blocks.PALE_OAK_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    val BAMBOO_STEM_STAIRS = registerBlockWithItem("bamboo_wood_stairs", { settings -> StairsBlock(Blocks.BAMBOO_BLOCK.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val CRIMSON_HYPHAE_STAIRS = registerBlockWithItem("crimson_hyphae_stairs", { settings -> StairsBlock(Blocks.CRIMSON_HYPHAE.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val WARPED_HYPHAE_STAIRS = registerBlockWithItem("warped_hyphae_stairs", { settings -> StairsBlock(Blocks.WARPED_HYPHAE.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // STRIPPED STAIRS
    val STRIPPED_OAK_WOOD_STAIRS = registerBlockWithItem("stripped_oak_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_OAK_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.OAK_WOOD)).first
    val STRIPPED_SPRUCE_WOOD_STAIRS = registerBlockWithItem("stripped_spruce_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_SPRUCE_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD)).first
    val STRIPPED_BIRCH_WOOD_STAIRS = registerBlockWithItem("stripped_birch_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_BIRCH_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.BIRCH_WOOD)).first
    val STRIPPED_JUNGLE_WOOD_STAIRS = registerBlockWithItem("stripped_jungle_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_JUNGLE_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.JUNGLE_WOOD)).first
    val STRIPPED_ACACIA_WOOD_STAIRS = registerBlockWithItem("stripped_acacia_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_ACACIA_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD)).first
    val STRIPPED_DARK_OAK_WOOD_STAIRS = registerBlockWithItem("stripped_dark_oak_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_DARK_OAK_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.DARK_OAK_WOOD)).first
    val STRIPPED_MANGROVE_WOOD_STAIRS = registerBlockWithItem("stripped_mangrove_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_MANGROVE_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.MANGROVE_WOOD)).first
    val STRIPPED_CHERRY_WOOD_STAIRS = registerBlockWithItem("stripped_cherry_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_CHERRY_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.CHERRY_WOOD)).first
    val STRIPPED_PALE_OAK_WOOD_STAIRS = registerBlockWithItem("stripped_pale_oak_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_PALE_OAK_WOOD.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.PALE_OAK_WOOD)).first
    //val STRIPPED_BAMBOO_STEM_STAIRS = registerBlockWithItem("stripped_bamboo_wood_stairs", { settings -> StairsBlock(Blocks.STRIPPED_BAMBOO_BLOCK.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.BAMBOO_PLANKS)).first
    val STRIPPED_CRIMSON_HYPHAE_STAIRS = registerBlockWithItem("stripped_crimson_hyphae_stairs", { settings -> StairsBlock(Blocks.CRIMSON_HYPHAE.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.CRIMSON_HYPHAE)).first
    val STRIPPED_WARPED_HYPHAE_STAIRS = registerBlockWithItem("stripped_warped_hyphae_stairs", { settings -> StairsBlock(Blocks.STRIPPED_WARPED_HYPHAE.defaultState, settings) }, AbstractBlock.Settings.copy(Blocks.WARPED_HYPHAE)).first



    // CHAINS
    val GRAND_CHAIN = registerBlockWithItem("grand_chain", { settings -> GrandChainBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHAIN).strength(6.0f, 7.0f).nonOpaque().sounds(ModBlockSoundGroup.GRAND_CHAIN)).first
    val COLOSSAL_CHAIN = registerBlockWithItem("colossal_chain", { settings -> ColossalChainBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHAIN).strength(8.0f, 10.0f).nonOpaque().sounds(ModBlockSoundGroup.COLOSSAL_CHAIN)).first

    val GOLDEN_CHAIN = registerBlockWithItem("golden_chain", { settings -> ChainBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHAIN).strength(5.0f, 6.0f).nonOpaque()).first
    val GOLDEN_GRAND_CHAIN = registerBlockWithItem("golden_grand_chain", { settings -> GrandChainBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHAIN).strength(6.0f, 7.0f).nonOpaque().sounds(ModBlockSoundGroup.GRAND_CHAIN)).first
    val GOLDEN_COLOSSAL_CHAIN = registerBlockWithItem("golden_colossal_chain", { settings -> ColossalChainBlock(settings) }, AbstractBlock.Settings.copy(Blocks.CHAIN).strength(8.0f, 10.0f).nonOpaque().sounds(ModBlockSoundGroup.COLOSSAL_CHAIN)).first



    // CHANDELIERS
    val CHANDELIER = registerBlockWithItem("chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.PALE_YELLOW) }).first
    val WHITE_CHANDELIER = registerBlockWithItem("white_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.WHITE_GRAY) }).first
    val LIGHT_GRAY_CHANDELIER = registerBlockWithItem("light_gray_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.LIGHT_GRAY) }).first
    val GRAY_CHANDELIER = registerBlockWithItem("gray_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.GRAY) }).first
    val BLACK_CHANDELIER = registerBlockWithItem("black_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.BLACK) }).first
    val BROWN_CHANDELIER = registerBlockWithItem("brown_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.BROWN) }).first
    val RED_CHANDELIER = registerBlockWithItem("red_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.RED) }).first
    val ORANGE_CHANDELIER = registerBlockWithItem("orange_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.ORANGE) }).first
    val YELLOW_CHANDELIER = registerBlockWithItem("yellow_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.YELLOW) }).first
    val LIME_CHANDELIER = registerBlockWithItem("lime_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.LIME) }).first
    val GREEN_CHANDELIER = registerBlockWithItem("green_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.GREEN) }).first
    val CYAN_CHANDELIER = registerBlockWithItem("cyan_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.CYAN) }).first
    val LIGHT_BLUE_CHANDELIER = registerBlockWithItem("light_blue_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.LIGHT_BLUE) }).first
    val BLUE_CHANDELIER = registerBlockWithItem("blue_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.BLUE) }).first
    val PURPLE_CHANDELIER = registerBlockWithItem("purple_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.PURPLE) }).first
    val MAGENTA_CHANDELIER = registerBlockWithItem("magenta_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.MAGENTA) }).first
    val PINK_CHANDELIER = registerBlockWithItem("pink_chandelier", { settings -> ModBlocks.createChandelierBlock(settings, MapColor.PINK) }).first




    val allTableSaws = listOf(
        OAK_TABLE_SAW, SPRUCE_TABLE_SAW, BIRCH_TABLE_SAW,
        JUNGLE_TABLE_SAW, ACACIA_TABLE_SAW, DARK_OAK_TABLE_SAW,
        MANGROVE_TABLE_SAW, CHERRY_TABLE_SAW, PALE_OAK_TABLE_SAW,
        BAMBOO_TABLE_SAW, CRIMSON_TABLE_SAW, WARPED_TABLE_SAW
    )



    private fun createChandelierBlock(settings: AbstractBlock.Settings, color: MapColor): Block {
        return ChandelierBlock(
            settings
                .solid()
                .requiresTool()
                .mapColor(color)
                .nonOpaque()
                .strength(5.0f, 6.0f)
                .sounds(BlockSoundGroup.CHAIN)
                .luminance(ChandelierBlock.STATE_TO_LUMINANCE)
                .pistonBehavior(PistonBehavior.DESTROY)
        )
    }



    // --- --- --- --- --- //

    fun <T : Block> registerBlockWithItem(
        name: String,
        factory: (AbstractBlock.Settings) -> T,
        settings: AbstractBlock.Settings = AbstractBlock.Settings.create()
    ): Pair<T, BlockItem> {
        val id = Identifier.of(LittleJohns.MOD_ID, name)
        val block = registerBlock(id, factory, settings)
        val item = ModItems.registerItem(id) {
            BlockItem(block, it.useBlockPrefixedTranslationKey())
        }
        return block to item
    }

    private fun <T : Block> registerBlock(
        id: Identifier,
        factory: (AbstractBlock.Settings) -> T,
        settings: AbstractBlock.Settings = AbstractBlock.Settings.create()
    ): T {
        val realBlock = factory(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, id)))
        return Registry.register(Registries.BLOCK, id, realBlock)
    }

    fun registerAll() {
        LittleJohns.LOGGER.info("Registering blocks for ${LittleJohns.MOD_ID}")
    }
}