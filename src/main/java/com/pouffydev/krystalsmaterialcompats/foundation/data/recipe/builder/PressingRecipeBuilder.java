package com.pouffydev.krystalsmaterialcompats.foundation.data.recipe.builder;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.simibubi.create.AllRecipeTypes;

import java.util.function.Consumer;

public class PressingRecipeBuilder {
    private final Item result;
    private final int resultCount;
    private final String requiredTag;
    private PressingRecipeBuilder(ItemLike resultIn, int count, String requiredTag) {
        this.result = resultIn.asItem();
        this.resultCount = count;
        this.requiredTag = requiredTag;
    }
    public static PressingRecipeBuilder createPressing(ItemLike resultIn, int count, String requiredTag) {
        return new PressingRecipeBuilder(resultIn, count, requiredTag);
    }
    public void build(Consumer<FinishedRecipe> consumerIn) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(this.result);
        this.build(consumerIn, MaterialCompats.ID + ":compat/create/press/" + location.getPath());
    }
    public void build(Consumer<FinishedRecipe> consumerIn, String save) {
        ResourceLocation resourcelocation = ForgeRegistries.ITEMS.getKey(this.result);
        if ((new ResourceLocation(save)).equals(resourcelocation)) {
            throw new IllegalStateException("Pressing Recipe " + save + " should remove its 'save' argument");
        } else {
            this.build(consumerIn, new ResourceLocation(save));
        }
    }
    public void build(Consumer<FinishedRecipe> consumerIn, ResourceLocation id) {
        consumerIn.accept(new PressingRecipeBuilder.Result(id, this.result, this.resultCount, this.requiredTag));
    }
    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final String requiredTag;
        
        public Result(ResourceLocation idIn, Item resultIn, int countIn, String requiredTag) {
            this.id = idIn;
            this.result = resultIn;
            this.count = countIn;
            this.requiredTag = requiredTag;
        }
        public void serializeRecipeData(JsonObject json) {
            JsonArray arrayConditions = new JsonArray();
            JsonArray notValue = new JsonArray();
            JsonObject notCondition = new JsonObject();
            notCondition.addProperty("type", "forge:not");
            notCondition.add("values", notValue);
            JsonObject tagCondition = new JsonObject();
            tagCondition.addProperty("type", "forge:tag_empty");
            tagCondition.addProperty("tag", requiredTag);
            notValue.add(tagCondition);
            arrayConditions.add(notCondition);
            json.add("conditions", arrayConditions);
            JsonObject objectIngredient = new JsonObject();
            objectIngredient.addProperty("tag", requiredTag);
            JsonArray arrayIngredients = new JsonArray();
            arrayIngredients.add(objectIngredient);
            json.add("ingredients", arrayIngredients);
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (this.count > 1) {
                objectResult.addProperty("count", this.count);
            }
            JsonArray arrayResults = new JsonArray();
            arrayResults.add(objectResult);
            json.add("results", arrayResults);
        }
        
        public @NotNull ResourceLocation getId() {
            return this.id;
        }
        
        public @NotNull RecipeSerializer<?> getType() {
            return AllRecipeTypes.PRESSING.getSerializer();
        }
        
        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null;
        }
        
        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
