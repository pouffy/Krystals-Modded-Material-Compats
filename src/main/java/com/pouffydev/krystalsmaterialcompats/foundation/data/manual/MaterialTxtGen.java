package com.pouffydev.krystalsmaterialcompats.foundation.data.manual;

import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import com.pouffydev.krystalsmaterialcompats.foundation.CompatMetals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MaterialTxtGen {
    public static void main(String[] args) {
        String metalTypesFilePath = "src/main/resources/assets/" + MaterialCompats.ID + "/manualDataGens/";
        try {
            // Create a FileWriter and BufferedWriter to write to a file
            FileWriter fileWriter = new FileWriter(metalTypesFilePath + "metals.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            
            // Iterate through the enum values and write them to the file
            for (CompatMetals metals : CompatMetals.values()) {
                writer.write(metals.name());
                writer.newLine(); // Add a newline for each value
            }
            
            // Close the writer to save the file
            writer.close();
            
            System.out.println("Enum values have been written to 'metals.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
