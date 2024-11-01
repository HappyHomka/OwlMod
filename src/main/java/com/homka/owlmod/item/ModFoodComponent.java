package com.homka.owlmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponent {
    // Adding Food Stats for food items
    public static final FoodComponent OWL_RAW_MEAT = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.3f).build();

    public static final FoodComponent OWL_COOKED_MEAT = new FoodComponent.Builder()
            .nutrition(4)
            .saturationModifier(0.3f).build();



    public static final FoodComponent HARPY_RAW_MEAT = new FoodComponent.Builder()
            .nutrition(2)
            .saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON,600,0),1.0f).build();

    public static final FoodComponent HARPY_COOKED_MEAT = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(0.3f).build();
}
