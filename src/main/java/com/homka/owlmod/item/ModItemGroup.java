package com.homka.owlmod.item;

import com.homka.owlmod.OwlMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup OWL_MOD_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(OwlMod.MOD_ID, "owl_mod_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.OWL_ICON))
                    .displayName(Text.translatable("itemgroup.owlmod.owl_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.OWL_FEATHER);
                        entries.add(ModItems.OWL_RAW_MEAT);
                        entries.add(ModItems.OWL_COOKED_MEAT);
                        entries.add(ModItems.HARPY_RAW_MEAT);
                        entries.add(ModItems.HARPY_COOKED_MEAT);

                    }).build());


    public static void registerItemGroups(){
        OwlMod.LOGGER.info("Registering Item Groups for " + OwlMod.MOD_ID);
    }
}
