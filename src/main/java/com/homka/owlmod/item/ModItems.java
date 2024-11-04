package com.homka.owlmod.item;

import com.homka.owlmod.OwlMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.sql.Struct;

public class ModItems {
    // Adding Items
    public static final Item OWL_ICON = register("owl_icon", new Item(new Item.Settings()));


    public static final Item OWL_RAW_MEAT = register("owl_raw_meat",new Item(new Item.Settings().food(ModFoodComponent.OWL_RAW_MEAT)));
    public static final Item OWL_COOKED_MEAT = register("owl_cooked_meat",new Item(new Item.Settings().food(ModFoodComponent.OWL_COOKED_MEAT)));
    public static final Item HARPY_RAW_MEAT = register("harpy_raw_meat",new Item(new Item.Settings().food(ModFoodComponent.HARPY_RAW_MEAT)));
    public static final Item HARPY_COOKED_MEAT = register("harpy_cooked_meat",new Item(new Item.Settings().food(ModFoodComponent.HARPY_COOKED_MEAT)));

    public static final Item OWL_FEATHER = register("owl_feather", new Item(new Item.Settings()));
    public static final Item OWL_BOSS_FEATHER = register("owl_boss_feather", new Item(new Item.Settings()));
    public static final Item OWL_CLAW = register("owl_claw",new Item(new Item.Settings()));
    public static final Item HARPY_EYE = register("harpy_eye",new Item(new Item.Settings()));
    public static final Item OWL_BEAK = register("owl_beak",new Item(new Item.Settings()));
    public static final Item OWL_EYE = register("owl_eye",new Item(new Item.Settings()));

    public static final Item PLATINUM_RAW_ORE = register("platinum_raw_ore", new Item(new Item.Settings()));
    public static final Item PLATINUM_INGOT = register("platinum_ingot", new Item(new Item.Settings()));
    public static final Item PLATINUM_NUGGET = register("platinum_nugget", new Item(new Item.Settings()));
    public static final Item OWL_ALLOY = register("owl_alloy", new Item(new Item.Settings()));
    public static final Item OWL_COPPER = register("owl_copper", new Item(new Item.Settings()));


    // Helpers and Init Methods
    public static <T extends Item> T register(String name, T item){
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

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(OWL_FEATHER);
            entries.add(OWL_BOSS_FEATHER);
            entries.add(OWL_BEAK);
            entries.add(OWL_EYE);
            entries.add(OWL_CLAW);
            entries.add(HARPY_EYE);
            entries.add(PLATINUM_RAW_ORE);
            entries.add(PLATINUM_INGOT);
            entries.add(PLATINUM_NUGGET);
            entries.add(OWL_ALLOY);
            entries.add(OWL_COPPER);
        });

    }
}
