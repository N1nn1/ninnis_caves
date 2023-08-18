package com.ninni.ninnis_caves.world.gen.features;

import com.mojang.serialization.Codec;
import com.ninni.ninnis_caves.registry.NCBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraft.world.level.levelgen.synth.PerlinNoise;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;

public class BigClusterFeature extends Feature<NoneFeatureConfiguration> {

    public BigClusterFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        BlockPos blockPos = featurePlaceContext.origin();
        RandomSource randomSource = featurePlaceContext.random();
        WorldGenLevel world = featurePlaceContext.level();
        int range = 16;
        WorldgenRandom worldgenRandom = new WorldgenRandom(new LegacyRandomSource(world.getSeed()));
        NormalNoise normalNoise = NormalNoise.create(worldgenRandom, -4, 1.0);
        for (int y = 0; y <= range; y++) {
            for (int x = 0; x <= range; x++) {
                for (int z = 0; z <= range; z++) {
                    BlockPos pos = blockPos.offset(x, y, z);
                    double noise = normalNoise.getValue(pos.getX(), pos.getY(), pos.getZ()) * 0.2F;
                    BlockState state = world.getBlockState(pos);
                    if (noise < 0.0D && state.is(BlockTags.BASE_STONE_OVERWORLD) && !(state.is(Blocks.TUFF) || state.is(Blocks.DEEPSLATE))) {
                        world.setBlock(pos, Blocks.ANDESITE.defaultBlockState(), 2);
                    }
                }
            }
        }
        return true;
    }
}
