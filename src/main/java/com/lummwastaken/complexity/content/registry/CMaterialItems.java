package com.lummwastaken.complexity.content.registry;

import static com.lummwastaken.complexity.Complexity.REGISTRATE;

import com.lummwastaken.complexity.Complexity;

@SuppressWarnings("unused")
public final class CMaterialItems {
    /*COMPLEXITY MATERIAL REGISTRY*/
    static {
        REGISTRATE.creativeModeTab(() -> CCreativeTab.TAB_COMPLEXITY_MATERIALS);
    }

    // NATURAL MATERIALS

    // ORES

    // MINERALS

    // GEMS

    public static void register() {
        Complexity.LOGGER.info("Registering items [Materials]");
    }
}