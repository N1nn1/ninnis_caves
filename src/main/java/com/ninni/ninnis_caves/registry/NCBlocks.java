package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class NCBlocks {

    //limestone blocks
    public static final Block LIMESTONE = register("limestone", new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).requiresCorrectToolForDrops().strength(1F)));
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


    private static Block register(String id, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(NinnisCaves.MOD_ID, id), block);
    }
}
