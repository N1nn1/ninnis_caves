package com.ninni.ninnis_caves.world.gen.features;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import org.jetbrains.annotations.Nullable;

public class ReplaceStoneFeature extends Feature<SimpleBlockConfiguration> {

    public ReplaceStoneFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> featurePlaceContext) {
        WorldGenLevel worldGenLevel = featurePlaceContext.level();
        TagKey<Block> block = BlockTags.BASE_STONE_OVERWORLD;
        BlockPos blockPos = findTarget(worldGenLevel, featurePlaceContext.origin().mutable().clamp(Direction.Axis.Y, worldGenLevel.getMinBuildHeight() + 1, worldGenLevel.getMaxBuildHeight() - 1), block);
        if (blockPos == null) {
            return false;
        }
        int i = 8;
        boolean bl = false;
        BlockStateProvider blockStateProvider = featurePlaceContext.config().toPlace();
        for (BlockPos blockPos2 : BlockPos.withinManhattan(blockPos, i, i, i)) {
            BlockState blockState = worldGenLevel.getBlockState(blockPos2);
            if (!blockState.is(block) || blockState.is(Blocks.DEEPSLATE) || blockState.is(Blocks.TUFF)) continue;
            this.setBlock(worldGenLevel, blockPos2, blockStateProvider.getState(featurePlaceContext.random(), blockPos2));
            bl = true;
        }
        return bl;
    }

    @Nullable
    private static BlockPos findTarget(LevelAccessor levelAccessor, BlockPos.MutableBlockPos mutableBlockPos, TagKey<Block> block) {
        while (mutableBlockPos.getY() > levelAccessor.getMinBuildHeight() + 1) {
            BlockState blockState = levelAccessor.getBlockState(mutableBlockPos);
            if (blockState.is(block)) {
                return mutableBlockPos;
            }
            mutableBlockPos.move(Direction.DOWN);
        }
        return null;
    }
}
