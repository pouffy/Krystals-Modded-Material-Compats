package com.pouffydev.krystalsmaterialcompats.foundation.client;

import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = MaterialCompats.ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class KMCClientEvents {
    @SubscribeEvent
    static void registerModelLoaders(ModelRegistryEvent event) {
    }
}
