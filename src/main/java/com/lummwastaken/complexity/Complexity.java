package com.lummwastaken.complexity;

import com.lummwastaken.complexity.content.infrastructure.config.CommonConfig;
import com.lummwastaken.complexity.content.infrastructure.data.CDataGen;
import com.lummwastaken.complexity.content.registry.CBlocks;
import com.lummwastaken.complexity.content.registry.CFluidTypes;
import com.lummwastaken.complexity.content.registry.CMaterialItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.ItemDescription.Modifier;
import com.simibubi.create.foundation.item.TooltipHelper.Palette;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.mojang.logging.LogUtils;
import net.minecraftforge.forgespi.language.IModInfo;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Function;

@SuppressWarnings({"all"})
@Mod(Complexity.MOD_ID)
public class Complexity {
    public static final String MOD_ID = "complexity";
    public static final String NAME = getModProperties(IModInfo::getDisplayName);
    public static final String VERSION = getModProperties(IModInfo::getVersion);
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MOD_ID);

    static {
        REGISTRATE.setTooltipModifierFactory(item -> new Modifier(item, Palette.STANDARD_CREATE));
    }

    public Complexity() {
        LOGGER.info("Initializing Complexity");

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        final IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        CBlocks.register();
        CFluidTypes.register();
        CMaterialItems.register();

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(EventPriority.LOWEST, CDataGen::gatherData);
        REGISTRATE.registerEventListeners(modEventBus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ComplexityClient.clientStartup(modEventBus, forgeEventBus));

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CommonConfig.SPEC, "complexity-common.toml");

        // Register ourselves
        modEventBus.addListener(this::commonSetup);
    }

    public void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Complexity Common Setup");

        event.enqueueWork(() -> {
           // Empty for now, may be needed later for post-registration objects.
        });
    }

    private static String getModProperties(Function<IModInfo, ?> f) {
        List<IModInfo> infoList = ModList.get().getModFileById(MOD_ID).getMods();
        if(infoList.size() > 1 && LOGGER != null) {
            LOGGER.error("Multiple mods for ID:" + MOD_ID);
        }
        for(IModInfo info : infoList) {
            if(info.getModId().equals(MOD_ID)) {
                return f.apply(info).toString();
            }
        }
        return "UNKNOWN";
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
