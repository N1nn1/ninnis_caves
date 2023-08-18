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
				NCItems.class,
				NCCreativeModeTab.class,
				NCFeatures.class
		);
		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NCPlacedFeatures.LIMESTONE_STRIP);
		BiomeModifications.create(new ResourceLocation(MOD_ID, "remove_dirt")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
			biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_DIRT);
		});
		BiomeModifications.create(new ResourceLocation(MOD_ID, "remove_diorite")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
			biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_DIORITE_LOWER);
			biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_DIORITE_UPPER);
		});
		BiomeModifications.create(new ResourceLocation(MOD_ID, "remove_granite")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
			biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_GRANITE_LOWER);
			biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_GRANITE_UPPER);
		});
		BiomeModifications.create(new ResourceLocation(MOD_ID, "remove_andesite")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
			biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_ANDESITE_LOWER);
			biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_ANDESITE_UPPER);
		});
	}
}