package com.homka.owlmod.datagen;

import com.homka.owlmod.block.ModBlocks;
import com.homka.owlmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_DEEPSLATE_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_ORE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLATINUM_RAW_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.OWL_ICON, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_RAW_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_COOKED_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARPY_RAW_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARPY_COOKED_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_BOSS_FEATHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_CLAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.HARPY_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_BEAK, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_EYE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_RAW_ORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_ALLOY, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_COPPER, Models.GENERATED);
    }
}
