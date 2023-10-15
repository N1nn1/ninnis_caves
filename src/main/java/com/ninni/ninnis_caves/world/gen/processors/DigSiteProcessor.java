package com.ninni.ninnis_caves.world.gen.processors;

import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.ninni.ninnis_caves.NinnisCaves;
import com.ninni.ninnis_caves.registry.NCBlocks;
import com.ninni.ninnis_caves.registry.NCBuiltinLootTables;
import com.ninni.ninnis_caves.registry.NCStructureProcessorTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.CappedProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.Nullable;

public class DigSiteProcessor extends StructureProcessor {
    public static final Codec<DigSiteProcessor> CODEC = Codec.unit(DigSiteProcessor::new);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader levelReader, BlockPos blockPos, BlockPos blockPos2, StructureTemplate.StructureBlockInfo structureBlockInfo, StructureTemplate.StructureBlockInfo structureBlockInfo2, StructurePlaceSettings structurePlaceSettings) {
        if (structureBlockInfo2.state().is(Blocks.LAPIS_BLOCK)) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putString("LootTable", NCBuiltinLootTables.GRANITE_DIG_SITE_BARREL.toString());
            return new StructureTemplate.StructureBlockInfo(structureBlockInfo2.pos(), Blocks.BARREL.defaultBlockState(), compoundTag);
        }
        if (structureBlockInfo2.state().is(Blocks.EMERALD_BLOCK)) {
            return new StructureTemplate.StructureBlockInfo(structureBlockInfo2.pos(), NCBlocks.MOLTEN_GRANITE.defaultBlockState(), structureBlockInfo2.nbt());
        }
        if (structureBlockInfo2.state().is(Blocks.DIAMOND_BLOCK)) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putString("LootTable", NCBuiltinLootTables.GRANITE_DIG_SITE_GRAVEL.toString());
            return new StructureTemplate.StructureBlockInfo(structureBlockInfo2.pos(), Blocks.SUSPICIOUS_GRAVEL.defaultBlockState(), compoundTag);
        }
        return structureBlockInfo2;
    }

    @Override
    protected StructureProcessorType<?> getType() {
        return NCStructureProcessorTypes.DIG_SITE;
    }

}
