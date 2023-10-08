package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystalsmaterialcompats.foundation.data.lang.Lang;

import static com.pouffydev.krystalsmaterialcompats.foundation.Mods.*;

public enum CompatMetals {
    aluminum(immersiveengineering, milkyway),
    lead(mekanism, thermal, immersiveengineering),
    nickel(thermal, immersiveengineering),
    osmium(mekanism),
    platinum(the_edge),
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
    
    public String getName() {
        return name;
    }
    
    /**
     * These mods must provide an ingot and nugget variant of the corresponding metal.
     */
    public Mods[] getMods() {
        return mods;
    }
}
