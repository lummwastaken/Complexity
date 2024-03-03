package com.lummwastaken.complexity.content.registry;

import static com.lummwastaken.complexity.Complexity.REGISTRATE;

import com.lummwastaken.complexity.Complexity;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;


@SuppressWarnings("unused")
public final class CBlocks {
    /*COMPLEXITY BLOCK REGISTRY*/
    static {
        REGISTRATE.creativeModeTab(() -> CCreativeTab.TAB_COMPLEXITY_BLOCKS);
    }

    // SOIL

    // POWDERS

    // ROCK

    // ORES

    public static void register() {
        Complexity.LOGGER.info("Registering blocks");
    }
}