package com.homka.owlmod.block.entity.owlstatues.two;

import com.homka.owlmod.block.ModBlockEntities;
import com.homka.owlmod.util.TickableBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.math.BlockPos;

public class OwlStatueTwoBlockEntity extends BlockEntity implements TickableBlockEntity {

    private int cooldown_ticks = 1200 + 1200;
    private int ticks = 0;
    private boolean ready = true;

    public OwlStatueTwoBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OWL_STATUE_TWO, pos, state);
    }

    @Override
    public void tick() {
        if(this.world == null || this.world.isClient)
            return;

        if(!ready){
            ticks++;
            if(ticks >= cooldown_ticks){
                ready = true;
                ticks = 0;
            }
        }
    }

    public boolean is_ready(){
        return ready;
    }
    public void put_on_cooldown(){
        ready = false;
    }
    public int getTicks(){
        return ticks;
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        this.ticks = nbt.getInt("Ticks");
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putInt("Ticks",this.ticks);
    }


}
