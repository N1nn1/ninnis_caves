package com.ninni.ninnis_caves.world.gen.features;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.ninni.ninnis_caves.registry.NCBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.DripstoneUtils;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import org.jetbrains.annotations.Nullable;

public class GabbroDeltaFeature extends Feature<ColumnFeatureConfiguration> {
    private static final ImmutableList<Block> CANNOT_PLACE_ON = ImmutableList.of(Blocks.LAVA, Blocks.BEDROCK, Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND, Blocks.NETHER_BRICKS, Blocks.NETHER_BRICK_FENCE, Blocks.NETHER_BRICK_STAIRS, Blocks.NETHER_WART, Blocks.CHEST, Blocks.SPAWNER);

    public GabbroDeltaFeature(Codec<ColumnFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<ColumnFeatureConfiguration> featurePlaceContext) {
        int i = featurePlaceContext.chunkGenerator().getSeaLevel();
        BlockPos blockPos = featurePlaceContext.origin();
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        RandomSource randomSource = featurePlaceContext.random();
        ColumnFeatureConfiguration columnFeatureConfiguration = featurePlaceContext.config();
        boolean flag = worldGenLevel.isStateAtPosition(blockPos, DripstoneUtils::isEmptyOrWaterOrLava) && !worldGenLevel.getBlockState(blockPos.below()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        if (!flag) {
            return false;
        }
        int j = columnFeatureConfiguration.height().sample(randomSource);
        if (!worldGenLevel.getBlockState(blockPos.above(5)).isAir()) {
            j /= 2;
        }
        boolean bl = randomSource.nextFloat() < 0.9f;
        int k = Math.min(j, bl ? 6 : 8);
        int l = bl ? 50 : 15;
        boolean bl2 = false;
        for (BlockPos blockPos2 : BlockPos.randomBetweenClosed(randomSource, l, blockPos.getX() - k, blockPos.getY(), blockPos.getZ() - k, blockPos.getX() + k, blockPos.getY(), blockPos.getZ() + k)) {
            int m = j - blockPos2.distManhattan(blockPos);
            if (m < 0) continue;
            bl2 |= this.placeColumn(worldGenLevel, i, blockPos2, m, columnFeatureConfiguration.reach().sample(randomSource));
        }
        return bl2;
    }

    private boolean placeColumn(LevelAccessor levelAccessor, int i, BlockPos blockPos, int j, int k) {
        boolean bl = false;
        block0: for (BlockPos blockPos2 : BlockPos.betweenClosed(blockPos.getX() - k, blockPos.getY(), blockPos.getZ() - k, blockPos.getX() + k, blockPos.getY(), blockPos.getZ() + k)) {
            int l = blockPos2.distManhattan(blockPos);
            BlockPos blockPos3 = isAirOrLavaOcean(levelAccessor, i, blockPos2) ? findSurface(levelAccessor, i, blockPos2.mutable(), l) : findAir(levelAccessor, blockPos2.mutable(), l);
            if (blockPos3 == null) continue;
            BlockPos.MutableBlockPos mutableBlockPos = blockPos3.mutable();
            for (int m = j - l / 2; m >= 0; --m) {
                if (!levelAccessor.getBlockState(mutableBlockPos.below()).is(BlockTags.DEEPSLATE_ORE_REPLACEABLES)) {
                    break block0;
                }
                if (isAirOrLavaOcean(levelAccessor, i, mutableBlockPos)) {
                    this.setBlock(levelAccessor, mutableBlockPos, NCBlocks.GABBRO.defaultBlockState());
                    mutableBlockPos.move(Direction.UP);
                    bl = true;
                    continue;
                }
                if (!(levelAccessor.getBlockState(mutableBlockPos).is(NCBlocks.GABBRO))) continue block0;
                mutableBlockPos.move(Direction.UP);
            }
        }
        return bl;
    }

    @Nullable
    private static BlockPos findSurface(LevelAccessor levelAccessor, int i, BlockPos.MutableBlockPos mutableBlockPos, int j) {
        while (mutableBlockPos.getY() > levelAccessor.getMinBuildHeight() + 1 && j > 0) {
            --j;
            if (canPlaceAt(levelAccessor, i, mutableBlockPos)) {
                return mutableBlockPos;
            }
            mutableBlockPos.move(Direction.DOWN);
        }
        return null;
    }

    private static boolean canPlaceAt(LevelAccessor levelAccessor, int i, BlockPos.MutableBlockPos mutableBlockPos) {
        if (isAirOrLavaOcean(levelAccessor, i, mutableBlockPos)) {
            BlockState blockState = levelAccessor.getBlockState(mutableBlockPos.move(Direction.DOWN));
            mutableBlockPos.move(Direction.UP);
            return !levelAccessor.isStateAtPosition(mutableBlockPos.move(Direction.DOWN), DripstoneUtils::isEmptyOrWaterOrLava) && !CANNOT_PLACE_ON.contains(blockState.getBlock());
        }
        return false;
    }

    @Nullable
    private static BlockPos findAir(LevelAccessor levelAccessor, BlockPos.MutableBlockPos mutableBlockPos, int i) {
        while (mutableBlockPos.getY() < levelAccessor.getMaxBuildHeight() && i > 0) {
            --i;
            BlockState blockState = levelAccessor.getBlockState(mutableBlockPos);
            if (CANNOT_PLACE_ON.contains(blockState.getBlock())) {
                return null;
            }
            if (blockState.isAir()) {
                return mutableBlockPos;
            }
            mutableBlockPos.move(Direction.UP);
        }
        return null;
    }

    private static boolean isAirOrLavaOcean(LevelAccessor levelAccessor, int i, BlockPos blockPos) {
        return levelAccessor.isStateAtPosition(blockPos, DripstoneUtils::isEmptyOrWaterOrLava) && blockPos.getY() <= i;
    }
}
