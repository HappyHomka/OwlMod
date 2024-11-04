package com.homka.owlmod.block.entity.owlstatues.three;

import com.homka.owlmod.block.ModBlockEntities;
import com.homka.owlmod.block.entity.owlstatues.one.OwlStatueOneBlockEntity;
import com.homka.owlmod.sound.ModSounds;
import com.homka.owlmod.util.TickableBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class OwlStatueThreeBEBlock extends Block implements BlockEntityProvider {

     /* SETUP STUFF
    *
    *
    *
     SETUP STUFF */

    public OwlStatueThreeBEBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return ModBlockEntities.OWL_STATUE_THREE.instantiate(pos,state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return TickableBlockEntity.getTicker(world);
    }

    /* LOGIC STUFF
    *
    *
    *
     LOGIC STUFF */

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient)
            return ActionResult.PASS;

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof OwlStatueThreeBlockEntity StatueBE && player != null){
            if(StatueBE.is_ready()){
                float pitch = (float)Math.random();
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,2400,0));
                world.playSound(null,pos, ModSounds.OWL_STATUE_USE_THREE, SoundCategory.BLOCKS,1f, pitch);
                StatueBE.put_on_cooldown();
                return ActionResult.SUCCESS;
            }

        }
        return ActionResult.PASS;
    }

    /* Model STUFF
    *
    *
    *
     Model STUFF */

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING,ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING,rotation.rotate(state.get(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.2f, 0f, 0.2f, 0.8f, 1.0f, 0.8f);
    }
}
