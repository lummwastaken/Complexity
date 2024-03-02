package com.lummwastaken.complexity.content.registry;

import static com.lummwastaken.complexity.Complexity.REGISTRATE;

import com.tterrag.registrate.builders.FluidBuilder.FluidTypeFactory;
import com.tterrag.registrate.util.entry.FluidEntry;
import com.lummwastaken.complexity.Complexity;

public final class CFluidTypes {

    // When new fluid types are implemented, this registry will be used.

    public static void register() {
        Complexity.LOGGER.info("Registering fluid types");
    }
}
