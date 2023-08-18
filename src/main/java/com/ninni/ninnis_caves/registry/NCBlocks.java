package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;

public class NCBlocks {

    //limestone blocks
    public static final Block LIMESTONE = register("limestone", new Block(FabricBlockSettings.of().mapColor(DyeColor.YELLOW).requiresCorrectToolForDrops().strength(1F)));
    public static final Block LIMESTONE_STAIRS = register("limestone_stairs", new StairBlock(LIMESTONE.defaultBlockState(), FabricBlockSettings.copyOf(LIMESTONE)));
    public static final Block LIMESTONE_SLAB = register("limestone_slab", new SlabBlock(FabricBlockSettings.copyOf(LIMESTONE)));
    public static final Block LIMESTONE_WALL = register("limestone_wall", new WallBlock(FabricBlockSettings.copyOf(LIMESTONE)));
    public static final Block LIMESTONE_BRICKS = register("limestone_bricks", new Block(FabricBlockSettings.copyOf(LIMESTONE)));
    public static final Block CRACKED_LIMESTONE_BRICKS = register("cracked_limestone_bricks", new Block(FabricBlockSettings.copyOf(LIMESTONE_BRICKS)));
    public static final Block LIMESTONE_BRICK_STAIRS = register("limestone_brick_stairs", new StairBlock(LIMESTONE_BRICKS.defaultBlockState(), FabricBlockSettings.copyOf(LIMESTONE_BRICKS)));
    public static final Block LIMESTONE_BRICK_SLAB = register("limestone_brick_slab", new SlabBlock(FabricBlockSettings.copyOf(LIMESTONE_BRICKS)));
    public static final Block LIMESTONE_BRICK_WALL = register("limestone_brick_wall", new WallBlock(FabricBlockSettings.copyOf(LIMESTONE_BRICKS)));

    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(NinnisCaves.MOD_ID, id), block);
    }
}
