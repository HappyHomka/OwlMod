package com.homka.owlmod.datagen;

import com.homka.owlmod.block.ModBlocks;
import com.homka.owlmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PLATINUM_BLOCK);
        addDrop(ModBlocks.PLATINUM_RAW_BLOCK);
        addDrop(ModBlocks.OWL_STATUE_ONE);
        addDrop(ModBlocks.OWL_STATUE_TWO);
        addDrop(ModBlocks.OWL_STATUE_THREE);

        addDrop(ModBlocks.PLATINUM_ORE_BLOCK,oreDrops(ModBlocks.PLATINUM_ORE_BLOCK, ModItems.PLATINUM_RAW_ORE));

        addDrop(ModBlocks.PLATINUM_DEEPSLATE_ORE_BLOCK,multipleOreDrops(ModBlocks.PLATINUM_DEEPSLATE_ORE_BLOCK, ModItems.PLATINUM_RAW_ORE,2,5));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
