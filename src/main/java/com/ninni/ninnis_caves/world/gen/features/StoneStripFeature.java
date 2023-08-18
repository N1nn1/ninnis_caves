package com.ninni.ninnis_caves.world.gen.features;

import com.mojang.serialization.Codec;
import com.ninni.ninnis_caves.world.gen.FastNoise;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.DripstoneUtils;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import com.ninni.ninnis_caves.world.gen.features.config.StoneStripConfig;

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
        fastNoise.SetFrequency(0.004F);
        int range = 16;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int x = 0; x < range; x++) {
            for (int z = 0; z < range; z++) {
                for (int y = 0; y < range; y++) {
                    mutableBlockPos.set(blockPos.getX() + x, blockPos.getY() + y, blockPos.getZ() + z);
                    float noise = fastNoise.GetNoise(mutableBlockPos.getX(), mutableBlockPos.getY(), mutableBlockPos.getZ());
                    double threshold = 0.97655;
                    if (noise > threshold) {
                        BlockState blockState = world.getBlockState(mutableBlockPos);
                        if (!blockState.is(BlockTags.BASE_STONE_OVERWORLD)) continue;
                        for (Direction direction : Direction.values()) {
                            if (!world.isStateAtPosition(mutableBlockPos.relative(direction), DripstoneUtils::isEmptyOrWaterOrLava)) {
                                continue;
                            }
                            world.setBlock(mutableBlockPos, featurePlaceContext.config().blockStateProvider().getState(randomSource, mutableBlockPos), 2);
                        }
                    }
                }
            }
        }
        return true;
    }
}
