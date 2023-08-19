package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class NCBiomes {
    
    public static final ResourceKey<Biome> GRANITE_MINES = register("granite_mines");
    public static final ResourceKey<Biome> DIORITE_MINES = register("diorite_mines");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(NinnisCaves.MOD_ID, name));
    }

}
