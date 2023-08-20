package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class NCItems {

    //logo
    public static final Item NINNIS_CAVES = register("ninnis_caves", new Item(new FabricItemSettings().maxCount(1).rarity(Rarity.EPIC).fireproof()));

    //andesite blocks
    public static final Item ANDESITE_SHINGLES = register("andesite_shingles", new BlockItem(NCBlocks.ANDESITE_SHINGLES, new FabricItemSettings()));
    public static final Item ANDESITE_PEDISTAL = register("andesite_pedistal", new BlockItem(NCBlocks.ANDESITE_PEDISTAL, new FabricItemSettings()));
    public static final Item ANDESITE_SHINGLE_STAIRS = register("andesite_shingle_stairs", new BlockItem(NCBlocks.ANDESITE_SHINGLE_STAIRS, new FabricItemSettings()));
    public static final Item ANDESITE_SHINGLE_SLAB = register("andesite_shingle_slab", new BlockItem(NCBlocks.ANDESITE_SHINGLE_SLAB, new FabricItemSettings()));
    public static final Item ANDESITE_SHINGLE_WALL = register("andesite_shingle_wall", new BlockItem(NCBlocks.ANDESITE_SHINGLE_WALL, new FabricItemSettings()));

    //granite blocks
    public static final Item GRANITE_COPPER_ORE = register("granite_copper_ore", new BlockItem(NCBlocks.GRANITE_COPPER_ORE, new FabricItemSettings()));
    public static final Item GRANITE_TILES = register("granite_tiles", new BlockItem(NCBlocks.GRANITE_TILES, new FabricItemSettings()));
    public static final Item GRANITE_TILE_STAIRS = register("granite_tile_stairs", new BlockItem(NCBlocks.GRANITE_TILE_STAIRS, new FabricItemSettings()));
    public static final Item GRANITE_TILE_SLAB = register("granite_tile_slab", new BlockItem(NCBlocks.GRANITE_TILE_SLAB, new FabricItemSettings()));
    public static final Item GRANITE_TILE_WALL = register("granite_tile_wall", new BlockItem(NCBlocks.GRANITE_TILE_WALL, new FabricItemSettings()));

    //diorite blocks
    public static final Item DIORITE_COAL_ORE = register("diorite_coal_ore", new BlockItem(NCBlocks.DIORITE_COAL_ORE, new FabricItemSettings()));
    public static final Item ORNATE_DIORITE = register("ornate_diorite", new BlockItem(NCBlocks.ORNATE_DIORITE, new FabricItemSettings()));
    public static final Item ORNATE_DIORITE_PILLAR = register("ornate_diorite_pillar", new BlockItem(NCBlocks.ORNATE_DIORITE_PILLAR, new FabricItemSettings()));

    //limestone blocks
    public static final Item LIMESTONE = register("limestone", new BlockItem(NCBlocks.LIMESTONE, new FabricItemSettings()));
    public static final Item LIMESTONE_STAIRS = register("limestone_stairs", new BlockItem(NCBlocks.LIMESTONE_STAIRS, new FabricItemSettings()));
    public static final Item LIMESTONE_SLAB = register("limestone_slab", new BlockItem(NCBlocks.LIMESTONE_SLAB, new FabricItemSettings()));
    public static final Item LIMESTONE_WALL = register("limestone_wall", new BlockItem(NCBlocks.LIMESTONE_WALL, new FabricItemSettings()));
    public static final Item LIMESTONE_BRICKS = register("limestone_bricks", new BlockItem(NCBlocks.LIMESTONE_BRICKS, new FabricItemSettings()));
    public static final Item CRACKED_LIMESTONE_BRICKS = register("cracked_limestone_bricks", new BlockItem(NCBlocks.CRACKED_LIMESTONE_BRICKS, new FabricItemSettings()));
    public static final Item LIMESTONE_BRICK_STAIRS = register("limestone_brick_stairs", new BlockItem(NCBlocks.LIMESTONE_BRICK_STAIRS, new FabricItemSettings()));
    public static final Item LIMESTONE_BRICK_SLAB = register("limestone_brick_slab", new BlockItem(NCBlocks.LIMESTONE_BRICK_SLAB, new FabricItemSettings()));
    public static final Item LIMESTONE_BRICK_WALL = register("limestone_brick_wall", new BlockItem(NCBlocks.LIMESTONE_BRICK_WALL, new FabricItemSettings()));
    public static final Item REINFORCED_GLASS = register("reinforced_glass", new BlockItem(NCBlocks.REINFORCED_GLASS, new FabricItemSettings()));
    public static final Item REINFORCED_GLASS_PANE = register("reinforced_glass_pane", new BlockItem(NCBlocks.REINFORCED_GLASS_PANE, new FabricItemSettings()));

    //shale blocks
    public static final Item SHALE = register("shale", new BlockItem(NCBlocks.SHALE, new FabricItemSettings()));
    public static final Item SHALE_STAIRS = register("shale_stairs", new BlockItem(NCBlocks.SHALE_STAIRS, new FabricItemSettings()));
    public static final Item SHALE_SLAB = register("shale_slab", new BlockItem(NCBlocks.SHALE_SLAB, new FabricItemSettings()));
    public static final Item SHALE_WALL = register("shale_wall", new BlockItem(NCBlocks.SHALE_WALL, new FabricItemSettings()));

    //gabbro blocks
    public static final Item GABBRO = register("gabbro", new BlockItem(NCBlocks.GABBRO, new FabricItemSettings()));
    public static final Item GABBRO_STAIRS = register("gabbro_stairs", new BlockItem(NCBlocks.GABBRO_STAIRS, new FabricItemSettings()));
    public static final Item GABBRO_SLAB = register("gabbro_slab", new BlockItem(NCBlocks.GABBRO_SLAB, new FabricItemSettings()));
    public static final Item GABBRO_WALL = register("gabbro_wall", new BlockItem(NCBlocks.GABBRO_WALL, new FabricItemSettings()));

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(NinnisCaves.MOD_ID, id), item);
    }
}
