package com.pouffydev.krystalsmaterialcompats.foundation.data.recipe;

import com.pouffydev.krystalsmaterialcompats.foundation.data.recipe.generator.CreateRecipes;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator generator) {
        super(generator);
    }
    
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        CreateRecipes.register(consumer);
    }
}
