package com.ninni.ninnis_caves.block.entity;

import com.ninni.ninnis_caves.registry.NCBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Clearable;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class AndesitePedestalBlockEntity extends BlockEntity implements Clearable {
    private final NonNullList<ItemStack> itemsDisplayed = NonNullList.withSize(1, ItemStack.EMPTY);

    public AndesitePedestalBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public AndesitePedestalBlockEntity(BlockPos pos, BlockState state) {
        this(NCBlockEntityTypes.ANDESITE_PEDISTAL, pos, state);
    }

    public NonNullList<ItemStack> getItemsDisplayed() {
        return this.itemsDisplayed;
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbtCompound = new CompoundTag();
        ContainerHelper.saveAllItems(nbtCompound, this.itemsDisplayed, true);
        return nbtCompound;
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.itemsDisplayed.clear();
        ContainerHelper.loadAllItems(nbt, this.itemsDisplayed);
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        ContainerHelper.saveAllItems(nbt, this.itemsDisplayed, true);
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public boolean addItem(@Nullable Entity user, ItemStack stack) {
        for (int i = 0; i < this.itemsDisplayed.size(); ++i) {
            ItemStack itemStack = this.itemsDisplayed.get(i);
            if (!itemStack.isEmpty()) continue;
            this.itemsDisplayed.set(i, stack.split(1));
            this.level.gameEvent(GameEvent.BLOCK_CHANGE, this.getBlockPos(), GameEvent.Context.of(user, this.getBlockState()));
            this.updateListeners();
            return true;
        }
        return false;
    }

    private void updateListeners() {
        this.setChanged();
        this.getLevel().sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_ALL);
    }

    @Override
    public void clearContent() {
        this.itemsDisplayed.clear();
    }
}
