package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import static com.ninni.ninnis_caves.registry.NCItems.*;

public class NCCreativeModeTab {

    public static final CreativeModeTab ITEM_GROUP = register("item_group", FabricItemGroup.builder().icon(NINNIS_CAVES::getDefaultInstance).title(Component.translatable("ninnis_caves.item_group")).displayItems((featureFlagSet, output) -> {

                //rhyolite blocks
                output.accept(LIMESTONE);
                output.accept(LIMESTONE_STAIRS);
                output.accept(LIMESTONE_SLAB);
                output.accept(LIMESTONE_WALL);
                output.accept(LIMESTONE_BRICKS);
                output.accept(CRACKED_LIMESTONE_BRICKS);
                output.accept(LIMESTONE_BRICK_STAIRS);
                output.accept(LIMESTONE_BRICK_SLAB);
                output.accept(LIMESTONE_BRICK_WALL);
                output.accept(REINFORCED_GLASS);
                output.accept(REINFORCED_GLASS_PANE);

            }).build()
    );

    private static CreativeModeTab register(String id, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(NinnisCaves.MOD_ID, id), tab);
    }
}
