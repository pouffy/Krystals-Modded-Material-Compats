package com.pouffydev.krystalsmaterialcompats.foundation;

import com.tterrag.registrate.AbstractRegistrate;
import net.minecraftforge.eventbus.api.IEventBus;
import org.jetbrains.annotations.NotNull;

public class KrystalsCompatRegistrate extends AbstractRegistrate<KrystalsCompatRegistrate> {
    /**
     * Construct a new Registrate for the given mod ID.
     *
     * @param modid The mod ID for which objects will be registered
     */
    protected KrystalsCompatRegistrate(String modid) {
        super(modid);
    }
    public static KrystalsCompatRegistrate create(String modid) {
        return new KrystalsCompatRegistrate(modid);
    }
    
    @Override
    public @NotNull KrystalsCompatRegistrate registerEventListeners(@NotNull IEventBus bus) {
        return super.registerEventListeners(bus);
    }
}
