package com.pouffydev.krystalsmaterialcompats.config;

import com.pouffydev.krystalsmaterialcompats.foundation.CompatMetals;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

public enum MaterialConfigs {
    aluminum("aluminum", KMCClientConfig.aluminumSpriteLocation);
    ;
    
    private final String materialType;
    private final ForgeConfigSpec.ConfigValue<String> spriteLocation;
    
    MaterialConfigs(String materialType, ForgeConfigSpec.ConfigValue<String> spriteLocation) {
        this.materialType = materialType;
        this.spriteLocation = spriteLocation;
    }
    
    public String getMaterialType() {
        return materialType;
    }
    
    public ForgeConfigSpec.ConfigValue<String> getSpriteLocation() {
        return spriteLocation;
    }
    
    public static MaterialConfigs getMaterialConfig(String materialType) {
        for (MaterialConfigs materialConfig : MaterialConfigs.values()) {
            if (materialConfig.getMaterialType().equals(materialType)) {
                return materialConfig;
            }
        }
        return null;
    }
    private static final ResourceLocation fallbackSpriteLocation = new ResourceLocation("krystalsmaterialcompats", "items/missing_tag_notifier");
    /**
        * Returns the sprite location for the given material type and item type.
     * @param materialType The material type.
     *                     Example: "aluminum"
     * @param itemType The item type.
     *                 Example: "sheet"
     * @return The sprite location for the given material type and item type.
     *        Example: "krystalsmaterialcompats:items/aluminum/create/sheet"
     */
    public static ResourceLocation getSpriteLocation(String materialType, String itemType) {
        MaterialConfigs materialConfig = getMaterialConfig(materialType);
        if (materialConfig != null) {
            return new ResourceLocation("krystalsmaterialcompats", materialConfig.getSpriteLocation().get() + "/" + itemType);
        }
        return fallbackSpriteLocation;
    }
}
