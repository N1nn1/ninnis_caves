package com.ninni.ninnis_caves.block;

import com.ninni.ninnis_caves.block.entity.AndesitePedestalBlockEntity;
import com.ninni.ninnis_caves.registry.NCStats;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

//TODO make it emit redstone when an item is taken out
@SuppressWarnings("deprecation")
public class AndesitePedestalBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.box(3, 0, 3, 13, 12, 13);

    public AndesitePedestalBlock(Properties settings) {
        super(settings);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false).setValue(FACING, Direction.NORTH));
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        ItemStack stackInHand = player.getItemInHand(hand);

        if (blockEntity instanceof AndesitePedestalBlockEntity pedistal) {
            if (!level.isClientSide && (stackInHand.getItem() instanceof TieredItem || stackInHand.getItem() instanceof TridentItem) && !stackInHand.isEmpty() && pedistal.addItem(player, player.getAbilities().instabuild ? stackInHand.copy() : stackInHand) ) {
                player.awardStat(NCStats.INTERACT_WITH_PEDISTAL);
                level.playSound(null, blockPos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 1, 1);
                return InteractionResult.SUCCESS;
            }
            if (stackInHand.isEmpty() && !pedistal.getItemsDisplayed().get(0).is(ItemStack.EMPTY.getItem())) {
                if (!level.isClientSide) {
                    player.setItemInHand(hand, pedistal.getItemsDisplayed().get(0));
                    player.awardStat(NCStats.INTERACT_WITH_PEDISTAL);
                    level.playSound(null, blockPos, SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS, 1, 1);
                }
                //TODO this doesn't update in a server
                pedistal.getItemsDisplayed().set(0, ItemStack.EMPTY);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return InteractionResult.PASS;
    }


    @Override
    public void onRemove(BlockState state, Level world, BlockPos blockPos, BlockState newState, boolean moved) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockEntity = world.getBlockEntity(blockPos);
        if (blockEntity instanceof AndesitePedestalBlockEntity) {
            Containers.dropContents(world, blockPos, ((AndesitePedestalBlockEntity)blockEntity).getItemsDisplayed());
        }

        super.onRemove(state, world, blockPos, newState, moved);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return SHAPE;
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new AndesitePedestalBlockEntity(blockPos, blockState);
    }

    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }


    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        Level levelAccessor = blockPlaceContext.getLevel();
        boolean bl = levelAccessor.getFluidState(blockPlaceContext.getClickedPos()).getType() == Fluids.WATER;
        return (((this.defaultBlockState().setValue(WATERLOGGED, bl)))).setValue(FACING, blockPlaceContext.getHorizontalDirection());
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        if (blockState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(blockPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        if (blockState.getValue(WATERLOGGED)) {
            return Fluids.WATER.getSource(false);
        }
        return super.getFluidState(blockState);
    }

    @Override
    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return blockState.setValue(FACING, rotation.rotate(blockState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return blockState.rotate(mirror.getRotation(blockState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WATERLOGGED, FACING);
    }
}
