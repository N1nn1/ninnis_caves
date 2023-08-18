package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import com.ninni.ninnis_caves.world.gen.features.StoneStripFeature;
import com.ninni.ninnis_caves.world.gen.features.config.StoneStripConfig;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class NCFeatures {

    public static final Feature<StoneStripConfig> STONE_STRIP = register("stone_strip", new StoneStripFeature(StoneStripConfig.CODEC));

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> F register(String name, F feature) {
        return Registry.register(BuiltInRegistries.FEATURE, new ResourceLocation(NinnisCaves.MOD_ID, name), feature);
    }

}
