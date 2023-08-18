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

    private static Item register(String id, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(NinnisCaves.MOD_ID, id), item);
    }
}
