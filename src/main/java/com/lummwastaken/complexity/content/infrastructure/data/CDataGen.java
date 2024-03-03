package com.lummwastaken.complexity.content.infrastructure.data;

import com.simibubi.create.foundation.utility.FilesHelper;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import com.lummwastaken.complexity.Complexity;

@SuppressWarnings("unused")
public class CDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        Complexity.LOGGER.info("Generating data for Complexity");
        DataGenerator gen = event.getGenerator();
        genLang();
    }

    private static void genLang() {
        providePonderLang();
    }

    private static void provideDefaultLang(String fileName) {
        String path = "assets/" + Complexity.MOD_ID + "/lang/default/" + fileName + ".json";

        JsonObject jsonObject = Preconditions.checkNotNull(FilesHelper.loadJsonResource(path),
                "Could not find default lang file: %s", path).getAsJsonObject();

        jsonObject.entrySet().forEach(entry ->
                Complexity.REGISTRATE.addRawLang(entry.getKey(), entry.getValue().getAsString())
        );
    }

    private static void providePonderLang() {
        // Register ponder data here
    }
}