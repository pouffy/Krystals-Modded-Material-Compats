package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystal_core.foundation.data.lang.KrystalCoreLang;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public enum Mods {
    
    mekanism("mekanism", b -> b.reverseMetalPrefix()),
    thermal("thermal"),
    immersiveengineering("immersiveengineering", b -> b.reverseMetalPrefix()),
    farmersdelight("farmersdelight"),
    ars_nouveau("ars_nouveau"),
    blue_skies("blue_skies"),
    botania("botania", b -> b.omitWoodSuffix()),
    forbidden_arcanus("forbidden_arcanus", b -> b.omitWoodSuffix()),
    hexcasting("hexcasting", b -> b.strippedWoodIsSuffix()),
    integrateddynamics("integrateddynamics", b -> b.strippedWoodIsSuffix()),
    silentgear("silentgear"),
    tconstruct("tconstruct"),
    architects_palette("architects_palette"),
    quark("quark"),
    biomesoplenty("biomesoplenty"),
    twilightforest("twilightforest"),
    ecologics("ecologics"),
    create("create"),
    milkyway("mw_core"),
    the_edge("the_edge"),
    crafts_and_additions("createaddition"),
    oh_the_biomes_youll_go("byg"),
    dreams_and_desires("create_dd"),
    ;
    
    private final String id;
    
    public boolean reversedMetalPrefix;
    public boolean strippedIsSuffix;
    public boolean omitWoodSuffix;
    
    private Mods(String id) {
        this(id, b -> {
        });
    }
    
    private Mods(String id, Consumer<Builder> props) {
        props.accept(new Builder());
        this.id = id;
    }
    
    public ResourceLocation ingotOf(String type) {
        return new ResourceLocation(id, reversedMetalPrefix ? "ingot_" + type : type + "_ingot");
    }
    
    public ResourceLocation nuggetOf(String type) {
        return new ResourceLocation(id, reversedMetalPrefix ? "nugget_" + type : type + "_nugget");
    }
    
    public ResourceLocation oreOf(String type) {
        return new ResourceLocation(id, reversedMetalPrefix ? "ore_" + type : type + "_ore");
    }
    
    public ResourceLocation deepslateOreOf(String type) {
        return new ResourceLocation(id, reversedMetalPrefix ? "deepslate_ore_" + type : "deepslate_" + type + "_ore");
    }
    
    public ResourceLocation asResource(String id) {
        return new ResourceLocation(this.id, id);
    }
    
    public String recipeId(String id) {
        return "compat/" + this.id + "/" + id;
    }
    
    public String getId() {
        return id;
    }
    public Component getDisplayName() {
        return KrystalCoreLang.translateDirect(MaterialCompats.ID, "mod." + id);
    }
    
    class Builder {
        
        Builder reverseMetalPrefix() {
            reversedMetalPrefix = true;
            return this;
        }
        
        Builder strippedWoodIsSuffix() {
            strippedIsSuffix = true;
            return this;
        }
        
        Builder omitWoodSuffix() {
            omitWoodSuffix = true;
            return this;
        }
        
    }
}
