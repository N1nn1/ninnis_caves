package com.ninni.ninnis_caves;

import com.google.common.reflect.Reflection;
import com.ninni.ninnis_caves.init.NinnisCavesFeatures;
import com.ninni.ninnis_caves.init.NinnisCavesPlacedFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NinnisCaves implements ModInitializer {
	public static final String MODID = "ninnis_caves";

	@Override
	public void onInitialize() {
		Reflection.initialize(NinnisCavesFeatures.class);
		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NinnisCavesPlacedFeatures.LIMESTONE_STRIP);
	}
}