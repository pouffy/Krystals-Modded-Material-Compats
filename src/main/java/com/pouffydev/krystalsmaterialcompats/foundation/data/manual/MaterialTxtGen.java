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
            FileWriter defaultMetals = new FileWriter(metalTypesFilePath + "default.txt");
            BufferedWriter defaultWriter = new BufferedWriter(defaultMetals);
            FileWriter sheetMetals = new FileWriter(metalTypesFilePath + "sheets.txt");
            BufferedWriter sheetWriter = new BufferedWriter(sheetMetals);
            
            // Iterate through the enum values and write them to the file
            for (CompatMetals metals : CompatMetals.values()) {
                defaultWriter.write(metals.name());
                defaultWriter.newLine(); // Add a newline for each value
                if (metals != CompatMetals.zinc && metals != CompatMetals.brass) {
                    sheetWriter.write(metals.name());
                    sheetWriter.newLine(); // Add a newline for each value
                }
            }
            
            // Close the writer to save the file
            defaultWriter.close();
            sheetWriter.close();
            
            System.out.println("Enum values have been written to: '" + metalTypesFilePath + "default.txt' and: '" + metalTypesFilePath + "sheets.txt'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
