package com.pouffydev.krystalsmaterialcompats.foundation.data.manual;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GearCraftingRecipe {
    
    
    public static void main(String[] args) {
        String metalTypesFilePath = "src/main/resources/assets/" + MaterialCompats.ID + "/manualDataGens/default.txt";
        try {
            String[] metalTypes = Files.readAllLines(Paths.get(metalTypesFilePath)).toArray(new String[0]);
            for (String metalType : metalTypes) {
                generateJson(metalType);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the input files.");
            e.printStackTrace();
        }
    }
    
    public static void generateJson(String metalName) {
        String directoryPath = "src/main/resources/data/" + MaterialCompats.ID + "/recipes/crafting/gears/";
        File directory = new File(directoryPath);
        directory.mkdirs();
        String outputItem = metalName + "_gear";
        String outputFileName = outputItem + ".json";
        File file = new File(directory, outputFileName);
        try {
            JsonObject json = new JsonObject();
            json.addProperty("type", "minecraft:crafting_shaped");
            // Create the conditions array
            JsonArray conditionsArray = new JsonArray();
            JsonArray patternArray = new JsonArray();
            JsonObject conditionObject = new JsonObject();
            conditionObject.addProperty("type", "forge:not");
            
            // Create the value object
            JsonObject valueObject = new JsonObject();
            valueObject.addProperty("type", "forge:tag_empty");
            valueObject.addProperty("tag", "forge:ingots/" + metalName);
            
            // Add the value object to the condition object
            conditionObject.add("value", valueObject);
            
            // Add the condition object to the conditions array
            conditionsArray.add(conditionObject);
            patternArray.add(" # ");
            patternArray.add("#N#");
            patternArray.add(" # ");
            // Add the conditions array to the recipe
            json.add("conditions", conditionsArray);
            json.add("pattern", patternArray);
            JsonObject objectKey = new JsonObject();
            JsonObject objectKeyN = new JsonObject();
            JsonObject objectKeyPound = new JsonObject();
            objectKeyN.addProperty("tag", "forge:nuggets/iron");
            objectKeyPound.addProperty("tag", "forge:ingots/" + metalName);
            objectKey.add("#", objectKeyPound);
            objectKey.add("N", objectKeyN);
            json.add("key", objectKey);
            JsonObject objectResult = new JsonObject();
            objectResult.addProperty("item", MaterialCompats.ID + ":" + outputItem);
            objectResult.addProperty("count", 4);
            json.add("result", objectResult);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonString = gson.toJson(json);
            
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(jsonString);
            fileWriter.close();
            System.out.println("Generated JSON for " + metalName + ": " + jsonString);
            System.out.println("Generated Gear Crafting Recipe For: " + metalName + " at: " + file);
        } catch (IOException e) {
            System.out.println("An error occurred while generating Gear Crafting Recipe: " + e.getMessage());
        }
    }
}
