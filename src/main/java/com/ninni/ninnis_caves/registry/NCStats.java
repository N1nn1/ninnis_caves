package com.ninni.ninnis_caves.registry;


import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.StatFormatter;

import static net.minecraft.stats.Stats.CUSTOM;

public interface NCStats {

    ResourceLocation INTERACT_WITH_PEDISTAL = register("interact_with_pedistal", StatFormatter.DEFAULT);


    private static ResourceLocation register(String id, StatFormatter formatter) {
        ResourceLocation rl = new ResourceLocation(id);
        Registry.register(BuiltInRegistries.CUSTOM_STAT, id, rl);
        CUSTOM.get(rl, formatter);
        return rl;
    }
}
