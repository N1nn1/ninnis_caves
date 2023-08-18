package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class NCPlacedFeatures {

    public static final ResourceKey<PlacedFeature> LIMESTONE_STRIP = createKey("limestone_strip");
    public static final ResourceKey<PlacedFeature> ORE_GRAVEL_UPPER = createKey("ore_gravel_upper");

    public static ResourceKey<PlacedFeature> createKey(String string) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(NinnisCaves.MOD_ID, string));
    }

}
