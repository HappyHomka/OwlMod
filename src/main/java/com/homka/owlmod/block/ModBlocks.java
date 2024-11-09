package com.homka.owlmod.block;

import com.homka.owlmod.OwlMod;
import com.homka.owlmod.block.entity.owlstatues.one.OwlStatueOneBEBlock;
import com.homka.owlmod.block.entity.owlstatues.three.OwlStatueThreeBEBlock;
import com.homka.owlmod.block.entity.owlstatues.two.OwlStatueTwoBEBlock;
import com.homka.owlmod.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PLATINUM_ORE_BLOCK = registerWithItem("platinum_ore_block",
            new Block(AbstractBlock.Settings.create().strength(3f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block PLATINUM_BLOCK = registerWithItem("platinum_block",
            new Block(AbstractBlock.Settings.create().strength(4f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block PLATINUM_RAW_BLOCK = registerWithItem("platinum_raw_block",
            new Block(AbstractBlock.Settings.create().strength(3f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final OwlStatueOneBEBlock OWL_STATUE_ONE = registerWithItem("owl_statue_one",new OwlStatueOneBEBlock(
            AbstractBlock.Settings.create()
                    .strength(3f,6f)
                    .requiresTool()));

    public static final OwlStatueTwoBEBlock OWL_STATUE_TWO = registerWithItem("owl_statue_two",new OwlStatueTwoBEBlock(
            AbstractBlock.Settings.create()
                    .strength(3f,6f)
                    .requiresTool()));

    public static final OwlStatueThreeBEBlock OWL_STATUE_THREE = registerWithItem("owl_statue_three",new OwlStatueThreeBEBlock(
            AbstractBlock.Settings.create()
                    .strength(3f,6f)
                    .requiresTool()));


    public static <T extends Block> T register(String name, T block){
        return Registry.register(Registries.BLOCK, Identifier.of(OwlMod.MOD_ID, name),block);
    }

    public static <T extends Block> T registerWithItem(String name, T block, Item.Settings settings){
        T registered = register(name,block);
        ModItems.register(name,new BlockItem(registered,settings));
        return  registered;
    }

    public static <T extends Block> T registerWithItem(String name, T block){
        return registerWithItem(name,block,new Item.Settings());
    }

    public static void registerModBlocks(){
        OwlMod.LOGGER.info("registering Mod Blocks " + OwlMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PLATINUM_ORE_BLOCK);
            entries.add(PLATINUM_BLOCK);
            entries.add(PLATINUM_RAW_BLOCK);
            entries.add(OWL_STATUE_ONE);
            entries.add(OWL_STATUE_TWO);
            entries.add(OWL_STATUE_THREE);
        });

    }

}
