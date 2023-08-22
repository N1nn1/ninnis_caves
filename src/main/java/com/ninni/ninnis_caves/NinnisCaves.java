package com.ninni.ninnis_caves;

import com.google.common.reflect.Reflection;
import com.ninni.ninnis_caves.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public class NinnisCaves implements ModInitializer {
	public static final String MOD_ID = "ninnis_caves";

	@Override
	public void onInitialize() {
		Reflection.initialize(
				NCBlocks.class,
				NCBlockEntityTypes.class,
				NCItems.class,
				NCStats.class,
				NCCreativeModeTab.class,
				NCFeatures.class,
				NCStructureProcessorTypes.class
		);
		NCVanillaIntegration.serverInit();
	}
}