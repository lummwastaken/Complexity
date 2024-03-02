package com.lummwastaken.complexity.compat.jei;

import com.lummwastaken.complexity.Complexity;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;

import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

@JeiPlugin
@SuppressWarnings("unused")
public class ComplexityJEI implements IModPlugin {
    private static final ResourceLocation ID = Complexity.asResource("jei_plugin");


    @Nonnull
    @Override
    public ResourceLocation getPluginUid() {
        return ID;
    }
}
