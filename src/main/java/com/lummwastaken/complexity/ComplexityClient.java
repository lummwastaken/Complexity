package com.lummwastaken.complexity;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
public class ComplexityClient {
    public static void clientStartup(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(ComplexityClient::clientSetup);
    }
    public static void clientSetup(final FMLClientSetupEvent event) {
        // Register client events here
    }
}
