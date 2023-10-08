package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystalsmaterialcompats.foundation.data.lang.Lang;
import static com.pouffydev.krystalsmaterialcompats.foundation.Mods.*;
public enum CompatModItems {
    sheet(create, thermal, immersiveengineering),
    rod(crafts_and_additions),
    sturdySheet(milkyway),
    gear(thermal),
    dust(thermal, immersiveengineering),
    coin(thermal),
    
    
    
    
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
