package com.ninni.ninnis_caves.registry;

import com.mojang.serialization.Codec;
import com.ninni.ninnis_caves.NinnisCaves;
import com.ninni.ninnis_caves.world.gen.processors.DigSiteProcessor;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class NCStructureProcessorTypes {

    public static final StructureProcessorType<DigSiteProcessor> DIG_SITE = register("dig_site", DigSiteProcessor.CODEC);

    private static <P extends StructureProcessor> StructureProcessorType<P> register(String name, Codec<P> codec) {
        return Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, new ResourceLocation(NinnisCaves.MOD_ID, name), () -> codec);
    }

}
