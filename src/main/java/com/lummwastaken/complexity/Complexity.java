package com.lummwastaken.complexity;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

@SuppressWarnings({"all"})
@Mod(Complexity.MOD_ID)
public class Complexity {
    public static final String MOD_ID = "complexity";
    public static final String NAME = "Complexity";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Complexity() {
        LOGGER.info("Initializing Complexity");

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        // Register ourselves
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Complexity Common Setup");
    }
}
