package com.homka.owlmod.datagen;

import com.homka.owlmod.block.ModBlocks;
import com.homka.owlmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    List<ItemConvertible> PLATINUM_INGOT_SMELTABLES = List.of(ModItems.PLATINUM_RAW_ORE, ModBlocks.PLATINUM_ORE_BLOCK,
            ModBlocks.PLATINUM_DEEPSLATE_ORE_BLOCK);

    @Override
    public void generate(RecipeExporter exporter) {

        offerSmelting(exporter,PLATINUM_INGOT_SMELTABLES, RecipeCategory.MISC,ModItems.PLATINUM_INGOT,0.25f,200,"platinum_ingot");
        offerBlasting(exporter,PLATINUM_INGOT_SMELTABLES, RecipeCategory.MISC,ModItems.PLATINUM_INGOT,0.25f,100,"platinum_ingot");

        offerSmelting(exporter,List.of(ModItems.OWL_BOSS_FEATHER),RecipeCategory.MISC,ModItems.OWL_COPPER,0.25f,200,"owl_copper");
        offerBlasting(exporter,List.of(ModItems.OWL_BOSS_FEATHER),RecipeCategory.MISC,ModItems.OWL_COPPER,0.25f,100,"owl_copper");

        offerSmelting(exporter,List.of(ModBlocks.PLATINUM_RAW_BLOCK),RecipeCategory.MISC,ModBlocks.PLATINUM_BLOCK,2f,1800,"platinum_block");
        offerBlasting(exporter,List.of(ModBlocks.PLATINUM_RAW_BLOCK),RecipeCategory.MISC,ModBlocks.PLATINUM_BLOCK,2f,900,"platinum_block");

        offerSmelting(exporter, List.of(ModItems.HARPY_RAW_MEAT),RecipeCategory.FOOD,ModItems.HARPY_COOKED_MEAT,0.25f,200,"harpy_cooked_meat");
        offerSmoking(exporter, List.of(ModItems.HARPY_RAW_MEAT),RecipeCategory.FOOD,ModItems.HARPY_COOKED_MEAT,0.25f,100,"harpy_cooked_meat");
        offerCampFire(exporter, List.of(ModItems.HARPY_RAW_MEAT),RecipeCategory.FOOD,ModItems.HARPY_COOKED_MEAT,0.25f,600,"harpy_cooked_meat");

        offerSmelting(exporter, List.of(ModItems.OWL_RAW_MEAT),RecipeCategory.FOOD,ModItems.OWL_COOKED_MEAT,0.25f,200,"owl_cooked_meat");
        offerSmoking(exporter, List.of(ModItems.OWL_RAW_MEAT),RecipeCategory.FOOD,ModItems.OWL_COOKED_MEAT,0.25f,100,"owl_cooked_meat");
        offerCampFire(exporter, List.of(ModItems.OWL_RAW_MEAT),RecipeCategory.FOOD,ModItems.OWL_COOKED_MEAT,0.25f,600,"owl_cooked_meat");

        offerReversibleCompactingRecipes(exporter,RecipeCategory.BUILDING_BLOCKS,ModItems.PLATINUM_RAW_ORE,RecipeCategory.MISC,ModBlocks.PLATINUM_RAW_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.OWL_ALLOY)
                .pattern("#R ")
                .pattern("R# ")
                .pattern("   ")
                .input('#',ModItems.OWL_COPPER)
                .input('R',ModItems.PLATINUM_INGOT)
                .criterion(hasItem(ModItems.OWL_COPPER),conditionsFromItem(ModItems.OWL_COPPER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.PLATINUM_BLOCK)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#',ModItems.PLATINUM_INGOT)
                .criterion(hasItem(ModItems.PLATINUM_INGOT),conditionsFromItem(ModItems.PLATINUM_INGOT))
                .offerTo(exporter,"platinum_block_from_platinum_ingot");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PLATINUM_INGOT,9)
                .input(ModBlocks.PLATINUM_BLOCK)
                .criterion(hasItem(ModItems.PLATINUM_INGOT),conditionsFromItem(ModItems.PLATINUM_INGOT))
                .offerTo(exporter,"platinum_ingot_from_platinum_block");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PLATINUM_INGOT)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#',ModItems.PLATINUM_NUGGET)
                .criterion(hasItem(ModItems.PLATINUM_INGOT),conditionsFromItem(ModItems.PLATINUM_INGOT))
                .offerTo(exporter,"platinum_ingot_from_platinum_nugget");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.PLATINUM_NUGGET,9)
                .input(ModItems.PLATINUM_INGOT)
                .criterion(hasItem(ModItems.PLATINUM_INGOT),conditionsFromItem(ModItems.PLATINUM_INGOT))
                .offerTo(exporter,"platinum_nugget_from_platinum_ingot");
    }

    public static void offerSmoking(
            RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group
    ) {
        offerMultipleOptions(exporter, RecipeSerializer.SMOKING, SmokingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_smoking");
    }

    public static void offerCampFire(
            RecipeExporter exporter, List<ItemConvertible> inputs, RecipeCategory category, ItemConvertible output, float experience, int cookingTime, String group
    ) {
        offerMultipleOptions(exporter, RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, inputs, category, output, experience, cookingTime, group, "_from_campfirecooking");
    }
}
