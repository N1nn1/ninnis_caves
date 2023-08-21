package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import com.ninni.ninnis_caves.client.renderer.block.entity.AndesitePedistalBlockEntityRenderer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.datafix.fixes.ObjectiveRenderTypeFix;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.function.Predicate;

public class NCVanillaIntegration {

    public static void serverInit() {
        registerBiomeModifications();
    }

    public static void clientInit() {
        registerBlockEntityRenderer();
        registerBlockRenderLayers();
    }

    //server
    private static void registerBiomeModifications() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NCPlacedFeatures.LIMESTONE_STRIP);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NCPlacedFeatures.BIG_ANDESITE_CLUSTER);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NCPlacedFeatures.SHALE_STRIP);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Decoration.LOCAL_MODIFICATIONS, NCPlacedFeatures.GABBRO_DELTA);
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "remove_dirt")).add(ModificationPhase.REMOVALS, BiomeSelectors.foundInOverworld(), (biomeModificationContext) -> {
            biomeModificationContext.getGenerationSettings().removeFeature(OrePlacements.ORE_DIRT);
        });
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "remove_diorite")).add(ModificationPhase.REMOVALS, BiomeSelectors.tag(BiomeTags.IS_OVERWORLD).and(Predicate.not(BiomeSelectors.tag(NCBiomeTags.RETAIN_DIORITE))), (biomeModificationContext) -> {
            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_DIORITE_LOWER);
            biomeModificationContext.getGenerationSettings().removeFeature(GenerationStep.Decoration.UNDERGROUND_ORES, OrePlacements.ORE_DIORITE_UPPER);
        });
        BiomeModifications.create(new ResourceLocation(NinnisCaves.MOD_ID, "remove_granite")).add(ModificationPhase.REMOVALS, BiomeSelectors.tag(BiomeTags.IS_OVERWORLD).and(Predicate.not(BiomeSelectors.tag(NCBiomeTags.RETAIN_GRANITE))), (biomeModificationContext) -> {
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

    @SuppressWarnings("deprecation")
    private static void registerBlockEntityRenderer() {
        BlockEntityRendererRegistry.register(NCBlockEntityTypes.ANDESITE_PEDISTAL, AndesitePedistalBlockEntityRenderer::new);
    }
}
