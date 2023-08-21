package com.ninni.ninnis_caves.client.renderer.block.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.ninni.ninnis_caves.block.entity.AndesitePedestalBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

@Environment(value= EnvType.CLIENT)
public class AndesitePedistalBlockEntityRenderer implements BlockEntityRenderer<AndesitePedestalBlockEntity> {
    private final ItemRenderer itemRenderer;

    public AndesitePedistalBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {
        this.itemRenderer = ctx.getItemRenderer();
    }

    @Override
    public void render(AndesitePedestalBlockEntity entity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay) {
        Direction direction = entity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
        NonNullList<ItemStack> defaultedList = entity.getItemsDisplayed();
        for (int l = 0; l < defaultedList.size(); ++l) {
            ItemStack itemStack = defaultedList.get(l);
            if (itemStack == ItemStack.EMPTY) continue;

            poseStack.pushPose();
            Direction direction2 = Direction.from2DDataValue((l + direction.get2DDataValue()) % 4);
            float d = -direction2.toYRot();
            if (itemStack.getItem() instanceof SwordItem) {
                poseStack.scale(0.8f, 0.8f, 0.8f);
                poseStack.translate(0.625f, 1.25f, 0.625f);
                poseStack.mulPose(Axis.YP.rotationDegrees(d));
                poseStack.mulPose(Axis.ZP.rotationDegrees(135));
            }
            if (itemStack.getItem() instanceof ShovelItem) {
                poseStack.scale(0.8f, 0.8f, 0.8f);
                poseStack.translate(0.625f, 1.25f, 0.625f);
                poseStack.mulPose(Axis.YP.rotationDegrees(d));
                poseStack.translate(-0.045f, 0f, 0f);
                poseStack.mulPose(Axis.ZP.rotationDegrees(135));
            }
            if (itemStack.getItem() instanceof AxeItem || itemStack.getItem() instanceof HoeItem || itemStack.getItem() instanceof PickaxeItem) {
                poseStack.scale(0.8f, 0.8f, 0.8f);
                poseStack.translate(0.625f, 1.2f, 0.625f);
                poseStack.mulPose(Axis.YP.rotationDegrees(d));
                poseStack.translate(-0.15f, 0f, 0f);
                poseStack.mulPose(Axis.ZP.rotationDegrees(200));
            }

            this.itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED, light, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, entity.getLevel(), (int)entity.getBlockPos().asLong());
            poseStack.popPose();
        }
    }
}
