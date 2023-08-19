package com.ninni.ninnis_caves.mixin;

import com.mojang.datafixers.util.Pair;
import com.ninni.ninnis_caves.registry.NCBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeBuilderMixin {

    @Shadow @Final private Climate.Parameter FULL_RANGE;

    @Shadow @Final private Climate.Parameter[] erosions;

    @Inject(at = @At("RETURN"), method = "addUndergroundBiomes")
    private void NC$addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
        consumer.accept(Pair.of(Climate.parameters(this.FULL_RANGE, Climate.Parameter.span(0.6F, 0.8F), this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.2F, 0.7F), this.FULL_RANGE, 0.0F), NCBiomes.GRANITE_MINES));
        consumer.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.6F, 1.0F), Climate.Parameter.span(this.erosions[0], this.erosions[1]), Climate.Parameter.span(0.2F, 0.7F), this.FULL_RANGE, 0.0F), NCBiomes.DIORITE_MINES));
    }

}
