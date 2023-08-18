package com.ninni.ninnis_caves.world.gen.features;

import com.mojang.serialization.Codec;
import com.ninni.ninnis_caves.world.gen.FastNoise;
import com.ninni.ninnis_caves.world.gen.features.config.StoneStripConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class StoneStripFeature extends Feature<StoneStripConfig> {

    public StoneStripFeature(Codec<StoneStripConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<StoneStripConfig> featurePlaceContext) {
        WorldGenLevel world = featurePlaceContext.level();
        BlockPos blockPos = featurePlaceContext.origin();
        RandomSource randomSource = featurePlaceContext.random();
        int seed = (int) world.getSeed();
        FastNoise fastNoise = new FastNoise(seed);
        fastNoise.SetFractalType(FastNoise.FractalType.RigidMulti);
        fastNoise.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
        fastNoise.SetFractalOctaves(1);
        fastNoise.SetFrequency(0.015F);
        fastNoise.SetFractalLacunarity(0.2F);
        int range = 16;
        int yRange = range / 2;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int x = 0; x < range; x++) {
            for (int z = 0; z < range; z++) {
                for (int y = -yRange; y < yRange; y++) {
                    mutableBlockPos.set(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    double noise = fastNoise.GetNoise(mutableBlockPos.getX(), mutableBlockPos.getY(), mutableBlockPos.getZ());
                    if (noise > 0.95D) {
                        BlockState blockState = world.getBlockState(mutableBlockPos);
                        boolean flag = !blockState.is(BlockTags.GEODE_INVALID_BLOCKS) && !blockState.isAir() && blockState.is(BlockTags.BASE_STONE_OVERWORLD) && !(blockState.is(Blocks.DEEPSLATE) || blockState.is(Blocks.TUFF));
                        if (flag) {
                            world.setBlock(mutableBlockPos, featurePlaceContext.config().blockStateProvider().getState(randomSource, mutableBlockPos), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
