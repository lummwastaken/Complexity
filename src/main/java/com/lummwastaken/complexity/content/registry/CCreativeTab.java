package com.lummwastaken.complexity.content.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

@SuppressWarnings("all")
public final class CCreativeTab {
    // Nonexistent tab icons are placeholders
    public static final CreativeModeTab TAB_COMPLEXITY_BLOCKS = new CreativeModeTab(CreativeModeTab.TABS.length, "complexity world") {
        public ItemStack makeIcon() {
            return Items.AIR.getDefaultInstance();
        }
    };
    public static final CreativeModeTab TAB_COMPLEXITY_MATERIALS = new CreativeModeTab(CreativeModeTab.TABS.length, "complexity materials") {
        public ItemStack makeIcon() {
            return Items.AIR.getDefaultInstance();
        }
    };
}