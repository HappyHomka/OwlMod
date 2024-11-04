package com.homka.owlmod.block;

import com.homka.owlmod.OwlMod;
import com.homka.owlmod.block.entity.owlstatues.three.OwlStatueThreeBlockEntity;
import com.homka.owlmod.block.entity.owlstatues.one.OwlStatueOneBlockEntity;
import com.homka.owlmod.block.entity.owlstatues.two.OwlStatueTwoBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {

    public static final BlockEntityType<OwlStatueOneBlockEntity> OWL_STATUE_ONE = register("owl_statue_one",
            BlockEntityType.Builder.create(OwlStatueOneBlockEntity::new, ModBlocks.OWL_STATUE_ONE).build());

    public static final BlockEntityType<OwlStatueTwoBlockEntity> OWL_STATUE_TWO = register("owl_statue_two",
            BlockEntityType.Builder.create(OwlStatueTwoBlockEntity::new, ModBlocks.OWL_STATUE_TWO).build());

    public static final BlockEntityType<OwlStatueThreeBlockEntity> OWL_STATUE_THREE = register("owl_statue_three",
            BlockEntityType.Builder.create(OwlStatueThreeBlockEntity::new, ModBlocks.OWL_STATUE_THREE).build());

    public static <T extends BlockEntity> BlockEntityType<T> register(String name,BlockEntityType<T> type){
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(OwlMod.MOD_ID, name),type);
    }

    public static void registerModBE(){
        OwlMod.LOGGER.info("registering Mod BE " + OwlMod.MOD_ID);
    }
}
