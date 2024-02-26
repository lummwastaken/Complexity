package com.lummwastaken.complexity;

import org.slf4j.Logger;

import com.lummwastaken.complexity.blocks.ComplexityBlocks;
import com.lummwastaken.complexity.items.ComplexityItems;
import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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
        
        register(modEventBus);

        // Register ourselves
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::commonSetup);
    }
    
    // call this class and its members with Complexity.Tabs
    public static class Tabs {
    	// create anonymous class to instantiate a new creative mode tab
    	public static final CreativeModeTab EXAMPLE_TAB = new CreativeModeTab("example_tab") {
    		public ItemStack makeIcon() {
    			return new ItemStack(ComplexityItems.TEST_BANANA.get());
    		}
    	};
    	// another creative mode tab
    	public static final CreativeModeTab EXAMPLE_TAB_2 = new CreativeModeTab("example_tab_2") {
    		public ItemStack makeIcon() {
    			return new ItemStack(ComplexityBlocks.BANANA_BLOCK.get());
    		}
    	};
    }
    
    public static void register(IEventBus eventBus) {
    	ComplexityItems.ITEMS.register(eventBus);
    	ComplexityBlocks.BLOCKS.register(eventBus);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Complexity Common Setup");
    }
}
