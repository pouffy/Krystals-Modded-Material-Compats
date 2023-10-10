package com.pouffydev.krystalsmaterialcompats.foundation.data.manual;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import com.pouffydev.krystalsmaterialcompats.foundation.CompatMetals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RollingRodRecipe {
    
    public static void main(String[] args) {
        String mainResourcesPath = "src/main/resources/";
        String outputFolderPath = mainResourcesPath + "data/" + MaterialCompats.ID + "/recipes/create/rolling/";
        String metalTypesFilePath = "src/main/resources/assets/" + MaterialCompats.ID + "/manualDataGens/metals.txt";
        List<CompatMetals> metals = CompatMetals.getAllMaterials().stream().toList();
        //loop through all the values in the enum and convert them to specific strings
            try {
                BufferedReader reader = new BufferedReader(new FileReader(metalTypesFilePath));
                String line = reader.readLine();
                if (line != null) {
                    String metalName = line.trim();
                    String resultItem = metalName + "_rod";
                    String outputFileName = resultItem + ".json";
                    String outputFilePath = outputFolderPath + outputFileName;
                    
                    JsonObject json = new JsonObject();
                    json.addProperty("type", "createaddition:rolling");
                    JsonArray arrayConditions = new JsonArray();
                    JsonArray notValue = new JsonArray();
                    JsonObject notCondition = new JsonObject();
                    notCondition.addProperty("type", "forge:not");
                    notCondition.add("value", notValue);
                    JsonObject tagCondition = new JsonObject();
                    tagCondition.addProperty("type", "forge:tag_empty");
                    tagCondition.addProperty("tag", "forge:ingots/" + metalName);
                    notValue.add(tagCondition);
                    arrayConditions.add(notCondition);
                    json.add("conditions", arrayConditions);
                    JsonObject objectIngredient = new JsonObject();
                    objectIngredient.addProperty("tag", "forge:ingots/" + metalName);
                    json.add("input", objectIngredient);
                    JsonObject objectResult = new JsonObject();
                    objectResult.addProperty("item", MaterialCompats.ID + ":" + resultItem);
                    objectResult.addProperty("count", 2);
                    json.add("result", objectResult);
                    
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    String jsonString = gson.toJson(json);
                    
                    FileWriter fileWriter = new FileWriter(outputFilePath);
                    fileWriter.write(jsonString);
                    fileWriter.close();
                    
                    System.out.println("Generated Rolling Recipe For: " + metalName + " at: " + outputFilePath);
                } else {
                    System.out.println("Wtf, where metals?");
                }
            } catch (IOException e) {
                System.out.println("An error occurred while generating Rolling Recipe: " + e.getMessage());
            }
    }
}
