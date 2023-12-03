package com.pouffydev.krystalsmaterialcompats.foundation.data;

import com.google.gson.JsonElement;
import com.pouffydev.krystal_core.foundation.data.lang.KrystalCoreLang;
import com.pouffydev.krystal_core.foundation.data.lang.LangPartial;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;

import java.util.function.Supplier;

public enum AllLangPartials implements LangPartial {
    UNTRANSLATABLE("Stuff the data generator can't translate"),
    MOD_IDS("Mod IDs"),
    CATEGORIES("Item Group Categories"),
    ;
    
    private final String displayName;
    private final Supplier<JsonElement> provider;
    
    private AllLangPartials(String displayName) {
        this.displayName = displayName;
        String fileName = KrystalCoreLang.asId(name());
        this.provider = () -> LangPartial.fromResource(MaterialCompats.ID, fileName);
    }
    
    private AllLangPartials(String displayName, Supplier<JsonElement> provider) {
        this.displayName = displayName;
        this.provider = provider;
    }
    
    @Override
    public String getDisplayName() {
        return displayName;
    }
    
    @Override
    public JsonElement provide() {
        return provider.get();
    }
}
