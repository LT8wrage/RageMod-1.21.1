package net.lt8wrage.ragemod;

import net.lt8wrage.ragemod.block.ModBlocks;
import net.lt8wrage.ragemod.item.ModCreativeModeTabs;
import net.lt8wrage.ragemod.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(RageMod.MODID)
public class RageMod {

    public static final String MODID = "ragemod";

    public static final Logger LOGGER = LogUtils.getLogger();


    public RageMod(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.ENDERITE_SCRAP);
            event.accept(ModItems.ENDERITE_INGOT);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.ENDERITE_DEBRIS);
            event.accept(ModBlocks.ENDERITE_BLOCK);
        }
    }



    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
