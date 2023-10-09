package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystalsmaterialcompats.foundation.data.lang.Lang;
public enum CompatModItems {
    sheet(),
    rod(),
    sturdySheet(),
    gear(),
    dust(),
    coin(),
    
    
    
    
    ;
    private final Mods[] mod;
    private final String type;
    
    CompatModItems(Mods... mods) {
        this.type = Lang.asId(name());
        this.mod = mods;
    }
    
    public String getName() {
        return type;
    }
    
    /**
     * These mods must provide an ingot and nugget variant of the corresponding metal.
     */
    public Mods[] getMods() {
        return mod;
    }
}
