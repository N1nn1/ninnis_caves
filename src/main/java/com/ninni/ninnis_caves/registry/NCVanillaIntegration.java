package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

public class NCVanillaIntegration {

    public static void serverInit() {
        registerBiomeModifications();
    }

    public static void clientInit() {
        registerBlockRenderLayers();
    }

    //server
    private static void registerBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NCPlacedFeatures.LIMESTONE_STRIP);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OVERWORLD), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NCPlacedFeatures.BIG_ANDESITE_CLUSTER);
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "remove_dirt")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_DIRT);
        });
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "remove_diorite")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_DIORITE_LOWER);
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_DIORITE_UPPER);
        });
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "remove_granite")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_GRANITE_LOWER);
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_GRANITE_UPPER);
        });
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "remove_andesite")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_ANDESITE_LOWER);
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_ANDESITE_UPPER);
        });
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "replace_gravel")).add(ModificationPhase.REPLACEMENTS, BiomeSelectors.foundInOverworld(), biomeModificationContext -> {
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_GRAVEL);
            biomeModificationContext.getGenerationSettings().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NCPlacedFeatures.ORE_GRAVEL_UPPER);
        });
    }

    //client
    private static void registerBlockRenderLayers() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.translucent(),
                NCBlocks.REINFORCED_GLASS,
                NCBlocks.REINFORCED_GLASS_PANE
        );
    }
}
