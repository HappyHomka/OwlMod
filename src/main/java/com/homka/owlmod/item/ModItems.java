package com.homka.owlmod.item;

import com.homka.owlmod.OwlMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item OWL_ICON = registerItem("owl_icon", new Item(new Item.Settings()));


    public static final Item OWL_RAW_MEAT = registerItem("owl_raw_meat",new Item(new Item.Settings().food(ModFoodComponent.OWL_RAW_MEAT)));
    public static final Item OWL_COOKED_MEAT = registerItem("owl_cooked_meat",new Item(new Item.Settings().food(ModFoodComponent.OWL_COOKED_MEAT)));
    public static final Item HARPY_RAW_MEAT = registerItem("harpy_raw_meat",new Item(new Item.Settings().food(ModFoodComponent.HARPY_RAW_MEAT)));
    public static final Item HARPY_COOKED_MEAT = registerItem("harpy_cooked_meat",new Item(new Item.Settings().food(ModFoodComponent.HARPY_COOKED_MEAT)));
    public static final Item OWL_FEATHER = registerItem("owl_feather", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(OwlMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        OwlMod.LOGGER.info("Registering Item" + OwlMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(OWL_RAW_MEAT);
            entries.add(OWL_COOKED_MEAT);
            entries.add(HARPY_RAW_MEAT);
            entries.add(HARPY_COOKED_MEAT);
        });
    }
}
