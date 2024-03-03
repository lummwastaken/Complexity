package com.lummwastaken.complexity.content.registry;

import com.lummwastaken.complexity.Complexity;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class CTags {
    public static final class CBlockTags {
        // Register Material Types for world blocks
        public static final TagKey<Block> MATERIAL_TYPES_METAL = BlockTags.create(Complexity.asResource("material_types/metal"));

        // Register other BlockTags below
    }
    public static final class CItemTags {
        // Register ItemTags below
        public static final TagKey<Item> METALLIC = ItemTags.create(Complexity.asResource("metallic"));
    }
}
