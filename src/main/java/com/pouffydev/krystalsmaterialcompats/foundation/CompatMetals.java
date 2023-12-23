package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystal_core.foundation.data.lang.KrystalCoreLang;

import java.util.Arrays;
import java.util.List;

import static com.pouffydev.krystalsmaterialcompats.foundation.Mods.*;

public enum CompatMetals {
    aluminum(immersiveengineering, milkyway),
    lead(mekanism, thermal, immersiveengineering),
    nickel(thermal, immersiveengineering),
    brass(create),
    zinc(create),
    osmium(mekanism),
    platinum(the_edge),
    bronze(thermal, mekanism),
    strong_bronze(dreams_and_desires),
    refined_obsidian(mekanism),
    refined_glowstone(mekanism),
    quicksilver(),
    silver(thermal, immersiveengineering),
    tin(thermal, mekanism, dreams_and_desires),
    steel(dreams_and_desires),
    uranium(mekanism, immersiveengineering),
    slimesteel(tconstruct),
    queens_slime(tconstruct),
    hepatizon(tconstruct),
    constantan(thermal),
    rose_gold(tconstruct),
    amethyst_bronze(tconstruct),
    cobalt(tconstruct),
    manyullyn(tconstruct),
    electrum(tconstruct, crafts_and_additions, immersiveengineering),
    enderium(thermal),
    invar(thermal),
    lumium(thermal),
    signalum(thermal),
    arcane_gold(forbidden_arcanus),
    pendorite(oh_the_biomes_youll_go),
    
    ;
    
    private final Mods[] mods;
    private final String name;
    
    CompatMetals(Mods... mods) {
        this.name = KrystalCoreLang.asId(name());
        this.mods = mods;
    }
    public static List<CompatMetals> getAllMaterials() {
        return Arrays.asList(CompatMetals.values());
    }
    public String getName() {
        return name;
    }
    public String getCapitalizedName(String str) {
        //Capitalize the first letter of each word and replace "_" with " "
        StringBuilder result = new StringBuilder();
        String[] words = str.split("_");
        for (String word : words) {
            // capitalize the first letter of the word and append it to the result
            result.append(word.substring(0, 1).toUpperCase());
            // append the rest of the word to the result
            result.append(word.substring(1));
            // append a space character to the result
            result.append(" ");
        }
        // trim the trailing space and return the result as a string
        return result.toString().trim();
    }
    
    /**
     * These mods must provide an ingot and nugget variant of the corresponding metal.
     */
    public Mods[] getMods() {
        return mods;
    }
}
