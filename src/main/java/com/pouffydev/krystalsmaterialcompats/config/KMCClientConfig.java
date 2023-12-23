package com.pouffydev.krystalsmaterialcompats.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KMCClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    
    public static final ForgeConfigSpec.ConfigValue<String> aluminumSpriteLocation;
    
    
    static {
        BUILDER.push("Client Configs for Krystals Material Compats");
        aluminumSpriteLocation = BUILDER.comment("The location of the aluminum sprites. Only change if the new location has all sprite variants.").define("aluminumSpriteLocation", "items/aluminum/mw_core/");
        
        
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
