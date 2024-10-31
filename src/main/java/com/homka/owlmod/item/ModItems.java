package com.homka.owlmod.item;

import com.homka.owlmod.OwlMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OWL_MEAT = registerItem("owl_meat",new Item(new Item.Settings()));
    public static final Item OWL_FEATHER = registerItem("owl_feather", new Item(new Item.Settings()));
    public static final Item OWL_ICON = registerItem("owl_icon", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(OwlMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        OwlMod.LOGGER.info("Registering Item" + OwlMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(OWL_MEAT);
            entries.add(OWL_FEATHER);
        });
    }
}
