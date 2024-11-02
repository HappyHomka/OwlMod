package com.homka.owlmod.block;

import com.homka.owlmod.OwlMod;
import com.homka.owlmod.block.custom.OwlStatue1;
import com.homka.owlmod.block.custom.OwlStatue2;
import com.homka.owlmod.block.custom.OwlStatue3;
import com.homka.owlmod.item.ModItemGroup;
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

    public static final Block PLATINUM_ORE_BLOCK = registerBlock("platinum_ore_block",
            new Block(AbstractBlock.Settings.create().strength(3f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block PLATINUM_DEEPSLATE_ORE_BLOCK = registerBlock("platinum_deepslate_ore_block",
            new Block(AbstractBlock.Settings.create().strength(4.5f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block PLATINUM_BLOCK = registerBlock("platinum_block",
            new Block(AbstractBlock.Settings.create().strength(4f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block PLATINUM_RAW_BLOCK = registerBlock("platinum_raw_block",
            new Block(AbstractBlock.Settings.create().strength(3f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)));

    public static final Block OWL_STATUE_ONE = registerBlock("owl_statue_one",
            new OwlStatue1(AbstractBlock.Settings.create().strength(3f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOD)
            ));

    public static final Block OWL_STATUE_TWO = registerBlock("owl_statue_two",
            new OwlStatue2(AbstractBlock.Settings.create().strength(3f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOD)
            ));

    public static final Block OWL_STATUE_THREE = registerBlock("owl_statue_three",
            new OwlStatue3(AbstractBlock.Settings.create().strength(3f,3f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOD)
            ));



    private static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(OwlMod.MOD_ID,name),block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(OwlMod.MOD_ID,name),
                new BlockItem(block,new Item.Settings()));
    }

    public static void registerModBlocks(){
        OwlMod.LOGGER.info("registering Mod Blocks " + OwlMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PLATINUM_ORE_BLOCK);
            entries.add(PLATINUM_BLOCK);
            entries.add(PLATINUM_DEEPSLATE_ORE_BLOCK);
            entries.add(PLATINUM_RAW_BLOCK);
            entries.add(OWL_STATUE_ONE);
            entries.add(OWL_STATUE_TWO);
            entries.add(OWL_STATUE_THREE);
        });

    }

}
