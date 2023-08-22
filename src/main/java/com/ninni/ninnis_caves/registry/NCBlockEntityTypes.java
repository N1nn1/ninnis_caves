package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import com.ninni.ninnis_caves.block.entity.AndesitePedestalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class NCBlockEntityTypes {

    public static final BlockEntityType<AndesitePedestalBlockEntity> ANDESITE_PEDISTAL = Registry.register(
            BuiltInRegistries.BLOCK_ENTITY_TYPE, new ResourceLocation(NinnisCaves.MOD_ID, "andesite_pedistal"),
            FabricBlockEntityTypeBuilder.create(AndesitePedestalBlockEntity::new,
                    NCBlocks.ANDESITE_PEDESTAL
            ).build(null)
    );
}
