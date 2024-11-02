package com.homka.owlmod.datagen;

import com.homka.owlmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.PLATINUM_BLOCK)
                .add(ModBlocks.PLATINUM_ORE_BLOCK)
                .add(ModBlocks.PLATINUM_RAW_BLOCK)
                .add(ModBlocks.PLATINUM_DEEPSLATE_ORE_BLOCK)
                .add(ModBlocks.OWL_STATUE_ONE)
                .add(ModBlocks.OWL_STATUE_TWO)
                .add(ModBlocks.OWL_STATUE_THREE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.OWL_STATUE_ONE)
                .add(ModBlocks.OWL_STATUE_TWO)
                .add(ModBlocks.OWL_STATUE_THREE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PLATINUM_BLOCK)
                .add(ModBlocks.PLATINUM_ORE_BLOCK)
                .add(ModBlocks.PLATINUM_RAW_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PLATINUM_DEEPSLATE_ORE_BLOCK);

    }
}
