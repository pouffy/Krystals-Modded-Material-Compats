package com.pouffydev.krystalsmaterialcompats.foundation.data.manual;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;

import java.io.*;

public class ProcessingRecipe {
    public static String recipeType = "bleh:y_no_type";
    public static String metalTagType = "forge:blerp/";
    public static String resultItemType_front = "some_";
    public static String resultItemType_back = "_thingy";
    public static void main(String[] args) {
        String metalTypesFilePath = "src/main/resources/assets/" + MaterialCompats.ID + "/manualDataGens/metals.txt";
        String directoryPath = "src/generated/resources/data/" + MaterialCompats.ID + "/recipes/";
        try {
            File directory = new File(directoryPath);
            BufferedReader reader = new BufferedReader(new FileReader(metalTypesFilePath));
            String line = reader.readLine();
            if (line != null) {
                
                directory.mkdirs();
                
                String metalName = line.trim();
                String resultItem = resultItemType_front + metalName + resultItemType_back;
                String outputFileName = resultItem + ".json";
                File file = new File(directory, outputFileName);
                
                JsonObject json = new JsonObject();
                json.addProperty("type", recipeType);
                JsonArray arrayConditions = new JsonArray();
                JsonArray notValue = new JsonArray();
                JsonObject notCondition = new JsonObject();
                notCondition.addProperty("type", "forge:not");
                notCondition.add("value", notValue);
                JsonObject tagCondition = new JsonObject();
                tagCondition.addProperty("type", "forge:tag_empty");
                tagCondition.addProperty("tag", metalTagType + metalName);
                notValue.add(tagCondition);
                arrayConditions.add(notCondition);
                json.add("conditions", arrayConditions);
                JsonObject objectIngredient = new JsonObject();
                objectIngredient.addProperty("tag", metalTagType + metalName);
                JsonArray arrayIngredients = new JsonArray();
                arrayIngredients.add(objectIngredient);
                json.add("ingredients", arrayIngredients);
                JsonObject objectResult = new JsonObject();
                objectResult.addProperty("item", MaterialCompats.ID + ":" + resultItem);
                JsonArray arrayResults = new JsonArray();
                arrayResults.add(objectResult);
                json.add("results", arrayResults);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String jsonString = gson.toJson(json);
                
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(jsonString);
                fileWriter.close();
                
                System.out.println("Generated Processing Recipe For: " + metalName + " at: " + file);
            } else {
                System.out.println("Wtf, where metals?");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while generating Processing Recipe: " + e.getMessage());
        }
    }
}
