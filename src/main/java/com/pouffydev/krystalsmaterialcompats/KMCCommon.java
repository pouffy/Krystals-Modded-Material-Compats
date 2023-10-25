package com.pouffydev.krystalsmaterialcompats;

import com.pouffydev.krystalsmaterialcompats.foundation.ModFilePackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;

public class KMCCommon {
    public static void init(final FMLCommonSetupEvent event) {
    
    }
    
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents {
        
        @SubscribeEvent
        public static void addPackFinders(AddPackFindersEvent event) {
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                IModFileInfo modFileInfo = ModList.get().getModFileById(MaterialCompats.ID);
                if (modFileInfo == null) {
                    MaterialCompats.LOGGER.error("Could not find Krystal's Material Compats mod file info; built-in resource packs will be missing!");
                    return;
                }
                IModFile modFile = modFileInfo.getFile();
                event.addRepositorySource((consumer, constructor) -> {
                    consumer.accept(Pack.create(MaterialCompats.asResource("krystals_material_resprites").toString(), false, () -> new ModFilePackResources("Krystal's Material Resprites", modFile, "resourcepacks/krystals_material_resprites"), constructor, Pack.Position.TOP, PackSource.DEFAULT));
                });
            }
        }
        
    }
}
