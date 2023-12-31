package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import com.ninni.ninnis_caves.block.AndesitePedestalBlock;
import com.ninni.ninnis_caves.block.MoltenGraniteBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class NCBlocks {

    //andesite blocks
    public static final Block ANDESITE_PEDESTAL = register("andesite_pedestal", new AndesitePedestalBlock(BlockBehaviour.Properties.copy(Blocks.ANDESITE).noOcclusion()));
    public static final Block ANDESITE_SHINGLES = register("andesite_shingles", new Block(BlockBehaviour.Properties.copy(Blocks.ANDESITE)));
    public static final Block ANDESITE_SHINGLE_STAIRS = register("andesite_shingle_stairs", new StairBlock(ANDESITE_SHINGLES.defaultBlockState(), BlockBehaviour.Properties.copy(ANDESITE_SHINGLES)));
    public static final Block ANDESITE_SHINGLE_SLAB = register("andesite_shingle_slab", new SlabBlock(BlockBehaviour.Properties.copy(ANDESITE_SHINGLES)));
    public static final Block ANDESITE_SHINGLE_WALL = register("andesite_shingle_wall", new WallBlock(BlockBehaviour.Properties.copy(ANDESITE_SHINGLES)));

    //granite blocks
    public static final Block MOLTEN_GRANITE = register("molten_granite", new MoltenGraniteBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE).pushReaction(PushReaction.DESTROY).mapColor(MapColor.DIRT)));
    public static final Block GRANITE_COPPER_ORE = register("granite_copper_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE).mapColor(MapColor.DIRT)));
    public static final Block GRANITE_TILES = register("granite_tiles", new Block(BlockBehaviour.Properties.copy(Blocks.GRANITE)));
    public static final Block GRANITE_TILE_STAIRS = register("granite_tile_stairs", new StairBlock(GRANITE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(GRANITE_TILES)));
    public static final Block GRANITE_TILE_SLAB = register("granite_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(GRANITE_TILES)));
    public static final Block GRANITE_TILE_WALL = register("granite_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(GRANITE_TILES)));

    //diorite blocks
    public static final Block DIORITE_COAL_ORE = register("diorite_coal_ore", new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COAL_ORE).mapColor(MapColor.QUARTZ), UniformInt.of(0, 2)));
    public static final Block ORNATE_DIORITE = register("ornate_diorite", new GlazedTerracottaBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final Block ORNATE_DIORITE_PILLAR = register("ornate_diorite_pillar", new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.DIORITE)));

    //limestone blocks
    public static final Block LIMESTONE = register("limestone", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1F)));
    public static final Block LIMESTONE_STAIRS = register("limestone_stairs", new StairBlock(LIMESTONE.defaultBlockState(), BlockBehaviour.Properties.copy(LIMESTONE)));
    public static final Block LIMESTONE_SLAB = register("limestone_slab", new SlabBlock(BlockBehaviour.Properties.copy(LIMESTONE)));
    public static final Block LIMESTONE_WALL = register("limestone_wall", new WallBlock(BlockBehaviour.Properties.copy(LIMESTONE)));
    public static final Block LIMESTONE_BRICKS = register("limestone_bricks", new Block(BlockBehaviour.Properties.copy(LIMESTONE)));
    public static final Block CRACKED_LIMESTONE_BRICKS = register("cracked_limestone_bricks", new Block(BlockBehaviour.Properties.copy(LIMESTONE_BRICKS)));
    public static final Block LIMESTONE_BRICK_STAIRS = register("limestone_brick_stairs", new StairBlock(LIMESTONE_BRICKS.defaultBlockState(), BlockBehaviour.Properties.copy(LIMESTONE_BRICKS)));
    public static final Block LIMESTONE_BRICK_SLAB = register("limestone_brick_slab", new SlabBlock(BlockBehaviour.Properties.copy(LIMESTONE_BRICKS)));
    public static final Block LIMESTONE_BRICK_WALL = register("limestone_brick_wall", new WallBlock(BlockBehaviour.Properties.copy(LIMESTONE_BRICKS)));
    public static final Block REINFORCED_GLASS = register("reinforced_glass", new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(3.0F, 1200.0F)));
    public static final Block REINFORCED_GLASS_PANE = register("reinforced_glass_pane", new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.GLASS_PANE).strength(3.0F, 1200.0F)));

    //shale blocks
    public static final Block SHALE = register("shale", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1.75F, 6.0F).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1F)));
    public static final Block SHALE_STAIRS = register("shale_stairs", new StairBlock(SHALE.defaultBlockState(), BlockBehaviour.Properties.copy(SHALE)));
    public static final Block SHALE_SLAB = register("shale_slab", new SlabBlock(BlockBehaviour.Properties.copy(SHALE)));
    public static final Block SHALE_WALL = register("shale_wall", new WallBlock(BlockBehaviour.Properties.copy(SHALE)));
    public static final Block REFINED_SHALE = register("refined_shale", new Block(BlockBehaviour.Properties.copy(SHALE)));
    public static final Block REFINED_SHALE_STAIRS = register("refined_shale_stairs", new StairBlock(REFINED_SHALE.defaultBlockState(), BlockBehaviour.Properties.copy(REFINED_SHALE)));
    public static final Block REFINED_SHALE_SLAB = register("refined_shale_slab", new SlabBlock(BlockBehaviour.Properties.copy(REFINED_SHALE)));
    public static final Block REFINED_SHALE_TILES = register("refined_shale_tiles", new Block(BlockBehaviour.Properties.copy(REFINED_SHALE)));
    public static final Block REFINED_SHALE_TILE_STAIRS = register("refined_shale_tile_stairs", new StairBlock(REFINED_SHALE_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(REFINED_SHALE_TILES)));
    public static final Block REFINED_SHALE_TILE_SLAB = register("refined_shale_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(REFINED_SHALE_TILES)));
    public static final Block REFINED_SHALE_TILE_WALL = register("refined_shale_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(REFINED_SHALE_TILES)));

    //gabbro blocks
    public static final Block GABBRO = register("gabbro", new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(1.5F, 4.0F).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1F)));
    public static final Block GABBRO_STAIRS = register("gabbro_stairs", new StairBlock(GABBRO.defaultBlockState(), BlockBehaviour.Properties.copy(GABBRO)));
    public static final Block GABBRO_SLAB = register("gabbro_slab", new SlabBlock(BlockBehaviour.Properties.copy(GABBRO)));
    public static final Block GABBRO_WALL = register("gabbro_wall", new WallBlock(BlockBehaviour.Properties.copy(GABBRO)));
    public static final Block REFINED_GABBRO = register("refined_gabbro", new Block(BlockBehaviour.Properties.copy(GABBRO)));
    public static final Block REFINED_GABBRO_STAIRS = register("refined_gabbro_stairs", new StairBlock(REFINED_GABBRO.defaultBlockState(), BlockBehaviour.Properties.copy(REFINED_GABBRO)));
    public static final Block REFINED_GABBRO_SLAB = register("refined_gabbro_slab", new SlabBlock(BlockBehaviour.Properties.copy(REFINED_GABBRO)));
    public static final Block REFINED_GABBRO_TILES = register("refined_gabbro_tiles", new Block(BlockBehaviour.Properties.copy(REFINED_GABBRO)));
    public static final Block REFINED_GABBRO_TILE_STAIRS = register("refined_gabbro_tile_stairs", new StairBlock(REFINED_GABBRO_TILES.defaultBlockState(), BlockBehaviour.Properties.copy(REFINED_GABBRO_TILES)));
    public static final Block REFINED_GABBRO_TILE_SLAB = register("refined_gabbro_tile_slab", new SlabBlock(BlockBehaviour.Properties.copy(REFINED_GABBRO_TILES)));
    public static final Block REFINED_GABBRO_TILE_WALL = register("refined_gabbro_tile_wall", new WallBlock(BlockBehaviour.Properties.copy(REFINED_GABBRO_TILES)));

    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(NinnisCaves.MOD_ID, id), block);
    }
}
