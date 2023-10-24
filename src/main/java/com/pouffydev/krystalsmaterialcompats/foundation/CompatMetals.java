package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystalsmaterialcompats.foundation.data.lang.Lang;

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
    tin(thermal, mekanism),
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
        this.name = Lang.asId(name());
        this.mods = mods;
    }
    public static List<CompatMetals> getAllMaterials() {
        return Arrays.asList(CompatMetals.values());
    }
    public String getName() {
        return name;
    }
    public String getCapitalizedName() {
        //Capitalize the first letter of each word and replace "_" with " "
        return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase().replace("_", " ");
    }
    
    /**
     * These mods must provide an ingot and nugget variant of the corresponding metal.
     */
    public Mods[] getMods() {
        return mods;
    }
}
