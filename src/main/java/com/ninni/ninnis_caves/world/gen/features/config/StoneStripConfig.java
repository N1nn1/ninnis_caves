package com.ninni.ninnis_caves.world.gen.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public record StoneStripConfig(BlockStateProvider blockStateProvider) implements FeatureConfiguration {
    public static final Codec<StoneStripConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(BlockStateProvider.CODEC.fieldOf("state").forGetter(StoneStripConfig::blockStateProvider)).apply(instance, StoneStripConfig::new));
}
