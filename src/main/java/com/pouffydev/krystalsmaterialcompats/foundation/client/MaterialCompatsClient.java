package com.pouffydev.krystalsmaterialcompats.foundation.client;

import com.pouffydev.krystalsmaterialcompats.foundation.creative.CreativeScreenEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;

public class MaterialCompatsClient {
    public static void setup()
    {
        if(!ModList.get().isLoaded("filters"))
        {
            MinecraftForge.EVENT_BUS.register(new CreativeScreenEvents());
        }
    }
}
