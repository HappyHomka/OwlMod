package com.homka.owlmod.item;

import com.homka.owlmod.OwlMod;
import com.homka.owlmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    //Adding Item Groups
    public static final ItemGroup OWL_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(OwlMod.MOD_ID, "owl_mod_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.OWL_ICON))
                    .displayName(Text.translatable("itemgroup.owlmod.owl_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.OWL_FEATHER);
                        entries.add(ModItems.OWL_BOSS_FEATHER);
                        entries.add(ModItems.OWL_RAW_MEAT);
                        entries.add(ModItems.OWL_COOKED_MEAT);
                        entries.add(ModItems.HARPY_RAW_MEAT);
                        entries.add(ModItems.HARPY_COOKED_MEAT);
                        entries.add(ModItems.HARPY_EYE);
                        entries.add(ModItems.OWL_CLAW);
                        entries.add(ModItems.OWL_BEAK);
                        entries.add(ModItems.OWL_EYE);

                        entries.add(ModBlocks.PLATINUM_BLOCK);
                        entries.add(ModBlocks.PLATINUM_ORE_BLOCK);
                        entries.add(ModBlocks.PLATINUM_DEEPSLATE_ORE_BLOCK);
                        entries.add(ModBlocks.PLATINUM_RAW_BLOCK);

                        entries.add(ModBlocks.OWL_STATUE_ONE);
                        entries.add(ModBlocks.OWL_STATUE_TWO);
                        entries.add(ModBlocks.OWL_STATUE_THREE);

                        entries.add(ModItems.PLATINUM_NUGGET);
                        entries.add(ModItems.PLATINUM_RAW_ORE);
                        entries.add(ModItems.PLATINUM_INGOT);
                        entries.add(ModItems.OWL_ALLOY);
                        entries.add(ModItems.OWL_COPPER);

                    }).build());

    // Helpers and Init Methods
    public static void registerItemGroups(){
        OwlMod.LOGGER.info("Registering Item Groups for " + OwlMod.MOD_ID);
    }
}
