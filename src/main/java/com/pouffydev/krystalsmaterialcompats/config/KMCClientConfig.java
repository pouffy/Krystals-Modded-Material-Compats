package com.pouffydev.krystalsmaterialcompats.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KMCClientConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    
    public static final ForgeConfigSpec.ConfigValue<String> aluminumSpriteLocation;
    public static final ForgeConfigSpec.ConfigValue<Enum<CreativeTabFilterMode>> creativeTabFilterMode;
    
    static {
        BUILDER.push("Client Configs for Krystals Material Compats");
        creativeTabFilterMode = BUILDER.comment("The mode for the creative tab filter.").define("creativeTabFilterMode", CreativeTabFilterMode.groupByMaterial);
        aluminumSpriteLocation = BUILDER.comment("The location of the aluminum sprites. Only change if the new location has all sprite variants.").define("aluminumSpriteLocation", "items/aluminum/create");
        
        
        BUILDER.pop();
        SPEC = BUILDER.build();
    }
    
    public enum CreativeTabFilterMode {
        groupByMaterial, groupByCategory, groupByDimension;
        
    }
}
