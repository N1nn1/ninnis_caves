package com.ninni.ninnis_caves.registry;

import com.ninni.ninnis_caves.NinnisCaves;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

import static com.ninni.ninnis_caves.registry.NCItems.*;

public class NCCreativeModeTab {

    public static final CreativeModeTab ITEM_GROUP = register("item_group", FabricItemGroup.builder().icon(NINNIS_CAVES::getDefaultInstance).title(Component.translatable("ninnis_caves.item_group")).displayItems((featureFlagSet, output) -> {

                //andesite blocks
                output.accept(ANDESITE_SHINGLES);
                output.accept(ANDESITE_SHINGLE_STAIRS);
                output.accept(ANDESITE_SHINGLE_SLAB);
                output.accept(ANDESITE_SHINGLE_WALL);

                //granite blocks
                output.accept(GRANITE_COPPER_ORE);

                //diorite blocks
                output.accept(DIORITE_COAL_ORE);

                //limestone blocks
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

                //shale blocks
                output.accept(SHALE);
                output.accept(SHALE_STAIRS);
                output.accept(SHALE_SLAB);
                output.accept(SHALE_WALL);

                //gabbro blocks
                output.accept(GABBRO);
                output.accept(GABBRO_STAIRS);
                output.accept(GABBRO_SLAB);
                output.accept(GABBRO_WALL);


            }).build()
    );

    static {

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(entries -> {
            entries.addBefore(Items.GRANITE,
                    LIMESTONE,
                    LIMESTONE_STAIRS,
                    LIMESTONE_SLAB,
                    LIMESTONE_WALL,
                    LIMESTONE_BRICKS,
                    CRACKED_LIMESTONE_BRICKS,
                    LIMESTONE_BRICK_STAIRS,
                    LIMESTONE_BRICK_SLAB,
                    LIMESTONE_BRICK_WALL,
                    LIMESTONE_BRICKS
            );
            entries.addAfter(Items.POLISHED_ANDESITE_SLAB,
                    ANDESITE_SHINGLES,
                    ANDESITE_SHINGLE_STAIRS,
                    ANDESITE_SHINGLE_SLAB,
                    ANDESITE_SHINGLE_WALL
            );
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(entries -> {

            entries.addAfter(Items.COAL_ORE, DIORITE_COAL_ORE);
            entries.addAfter(Items.COPPER_ORE, GRANITE_COPPER_ORE);
            entries.addBefore(Items.GRANITE, LIMESTONE);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COLORED_BLOCKS).register(entries -> {
            entries.addAfter(Items.GLASS, REINFORCED_GLASS);
            entries.addAfter(Items.GLASS_PANE, REINFORCED_GLASS_PANE);
        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(entries -> {
            entries.addBefore(Items.TINTED_GLASS, REINFORCED_GLASS, REINFORCED_GLASS_PANE);
        });
    }

    private static CreativeModeTab register(String id, CreativeModeTab tab) {
        return Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, new ResourceLocation(NinnisCaves.MOD_ID, id), tab);
    }
}
