package net.sjllet.cyclomod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.block.ModBlocks;
import net.sjllet.cyclomod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> WILLOVIUM_SMELTABLES = List.of(ModItems.RAW_WILLOVIUM.get(),
            ModBlocks.WILLOVIUM_ORE.get(), ModBlocks.DEEPSLATE_WILLOVIUM_ORE.get(), ModBlocks.NETHER_WILLOVIUM_ORE.get(), ModBlocks.END_STONE_WILLOVIUM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, WILLOVIUM_SMELTABLES, RecipeCategory.MISC, ModItems.WILLOVIUM_INGOT.get(), 0.25f, 200, "willovium");
        oreBlasting(pWriter, WILLOVIUM_SMELTABLES, RecipeCategory.MISC, ModItems.WILLOVIUM_INGOT.get(), 0.25f, 100, "willovium");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WILLOVIUM_BLOCK.get())
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .define('W', ModItems.WILLOVIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.WILLOVIUM_INGOT.get()), has(ModItems.WILLOVIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_WILLOVIUM_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RAW_WILLOVIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_WILLOVIUM.get()), has(ModItems.RAW_WILLOVIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WILLOVIUM_INGOT.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.WILLOVIUM_NUGGET.get())
                .unlockedBy(getHasName(ModItems.WILLOVIUM_NUGGET.get()), has(ModItems.WILLOVIUM_NUGGET.get()))
                .save(pWriter, "willovium_ingot_from_willovium_nugget");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SIHIRLITE_BLOCK.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.SIHIRLITE_SHARD.get())
                .unlockedBy(getHasName(ModItems.SIHIRLITE_SHARD.get()), has(ModItems.SIHIRLITE_SHARD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WILLOVIUM_INGOT.get(), 9)
                .requires(ModBlocks.WILLOVIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.WILLOVIUM_BLOCK.get()), has(ModBlocks.WILLOVIUM_BLOCK.get()))
                .save(pWriter, "willovium_ingot_from_willovium_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_WILLOVIUM.get(), 9)
                .requires(ModBlocks.RAW_WILLOVIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_WILLOVIUM_BLOCK.get()), has(ModBlocks.RAW_WILLOVIUM_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WILLOVIUM_NUGGET.get(), 9)
                .requires(ModItems.WILLOVIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.WILLOVIUM_INGOT.get()), has(ModItems.WILLOVIUM_INGOT.get()))
                .save(pWriter, "willovium_nugget_from_willovium_ingot");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, CycloMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}