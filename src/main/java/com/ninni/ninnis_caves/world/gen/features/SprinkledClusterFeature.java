package com.ninni.ninnis_caves.world.gen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.DripstoneUtils;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class SprinkledClusterFeature extends Feature<SimpleBlockConfiguration> {

    public SprinkledClusterFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> featurePlaceContext) {
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        BlockPos blockPos = featurePlaceContext.origin();
        RandomSource randomSource = featurePlaceContext.random();
        if (!worldGenLevel.isStateAtPosition(blockPos, DripstoneUtils::isEmptyOrWater)) {
            return false;
        }
        int j = 8;
        int k = 8;
        for (int l = -j; l <= j; ++l) {
            for (int m = -k; m <= k; ++m) {
                for (int y = -j; y <= j; y++) {
                    BlockPos blockPos2 = blockPos.offset(l, y, m);
                    int distance = Math.max(1, Math.round(Mth.sqrt((float) blockPos.distSqr(blockPos2))));
                    BlockState blockState = worldGenLevel.getBlockState(blockPos2);
                    if (blockState.is(BlockTags.BASE_STONE_OVERWORLD) && !(blockState.is(Blocks.DEEPSLATE) || blockState.is(Blocks.TUFF))) {
                        if (distance > 5 && randomSource.nextInt(distance) > 0) {
                            continue;
                        }
                        worldGenLevel.setBlock(blockPos2, featurePlaceContext.config().toPlace().getState(randomSource, blockPos2), 2);
                    }
                }
            }
        }
        return true;
    }

}
