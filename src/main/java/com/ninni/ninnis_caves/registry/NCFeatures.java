package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import com.ninni.ninnis_caves.world.gen.features.GabbroDeltaFeature;
import com.ninni.ninnis_caves.world.gen.features.SprinkledClusterFeature;
import com.ninni.ninnis_caves.world.gen.features.StoneStripFeature;
import com.ninni.ninnis_caves.world.gen.features.config.StoneStripConfig;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;

public class NCFeatures {

    public static final Feature<StoneStripConfig> STONE_STRIP = register("stone_strip", new StoneStripFeature(StoneStripConfig.CODEC));
    public static final Feature<SimpleBlockConfiguration> SPRINKLED_CLUSTER = register("sprinkled_cluster", new SprinkledClusterFeature(SimpleBlockConfiguration.CODEC));
    public static final Feature<ColumnFeatureConfiguration> GABBRO_DELTA = register("gabbro_delta", new GabbroDeltaFeature(ColumnFeatureConfiguration.CODEC));

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> F register(String name, F feature) {
        return Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(NinnisCaves.MOD_ID, name), feature);
    }

}
