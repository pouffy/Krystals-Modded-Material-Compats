package com.pouffydev.krystalsmaterialcompats;

import com.mojang.logging.LogUtils;
import com.pouffydev.krystal_core.foundation.data.lang.KrystalCoreLangMerger;
import com.pouffydev.krystalsmaterialcompats.foundation.KrystalsCompatRegistrate;
import com.pouffydev.krystalsmaterialcompats.foundation.client.MaterialCompatsClient;
import com.pouffydev.krystalsmaterialcompats.foundation.creative.MaterialCompatCreativeTab;
import com.pouffydev.krystalsmaterialcompats.foundation.data.AllLangPartials;
import com.pouffydev.krystalsmaterialcompats.foundation.data.recipe.Recipes;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.stream.Collectors;

import static com.pouffydev.krystalsmaterialcompats.MaterialCompats.ID;

@Mod(ID)
public class MaterialCompats
{
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String ID = "krystalsmaterialcompats";
    public static final KrystalsCompatRegistrate registrate = KrystalsCompatRegistrate.create(ID);
    public static final CreativeModeTab itemGroup = new MaterialCompatCreativeTab(ID);
    public MaterialCompats()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        MinecraftForge.EVENT_BUS.register(this);
        KMCItems.register();
        registrate.registerEventListeners(eventBus);
        
        
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(EventPriority.LOWEST, MaterialCompats::gatherData);
        
    }
    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(MaterialCompatsClient::setup);
    }
    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        InterModComms.sendTo("krystalsmaterialcompats", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            LOGGER.info("HELLO from Register Block");
        }
    }
    public static void gatherData(@NotNull GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if (event.includeClient()) {
            gen.addProvider(new KrystalCoreLangMerger(gen, ID, "Krystal's Material Compats", AllLangPartials.values()));
        }
        if (event.includeServer()) {
            //gen.addProvider(new MWAdvancements(gen));
            gen.addProvider(new Recipes(gen));
        }
    }
    @Contract("_ -> new")
    public static @NotNull ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
    public static @NotNull KrystalsCompatRegistrate registrate() {
        return registrate;
    }
}
