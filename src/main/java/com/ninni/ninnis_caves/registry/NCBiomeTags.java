package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class NCBiomeTags {

    public static final TagKey<Biome> RETAIN_GRANITE = TagKey.create(Registries.BIOME, new ResourceLocation(NinnisCaves.MOD_ID, "retain_granite"));
    public static final TagKey<Biome> RETAIN_DIORITE = TagKey.create(Registries.BIOME, new ResourceLocation(NinnisCaves.MOD_ID, "retain_diorite"));

}
