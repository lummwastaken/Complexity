package com.lummwastaken.complexity.blocks;

import java.util.function.Supplier;

import com.lummwastaken.complexity.Complexity;
import com.lummwastaken.complexity.items.ComplexityItems;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ComplexityBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Complexity.MOD_ID);
    
    // new method for initializing block properties; requires a Material as input
    private static BlockBehaviour.Properties blockBuilder(Material material) {
    	return BlockBehaviour.Properties.of(material);
    }
    
    // default item properties
    private static BlockItem.Properties pItemBase = new Item.Properties();
	
    // example block
    public static final RegistryObject<Block> BANANA_BLOCK = register("banana_block", 
    	() -> new Block(
    		blockBuilder(Material.MOSS)
    			.instabreak()
    			.sound(SoundType.FUNGUS)
    	), 
    	pItemBase
    		.food(new FoodProperties
    			.Builder()
    				.nutrition(18)
    				.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 40, 1), 1)
    			.build())
    		.tab(Complexity.Tabs.EXAMPLE_TAB)
    	);
    
    // new blocks here
    
    
    
    
    
    
    
    
    
    // method that registers associated item for each block
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties properties) {
    	RegistryObject<T> blockRegistry = BLOCKS.register(name, block);
    	ComplexityItems.ITEMS.register(name, () -> new BlockItem(blockRegistry.get(), properties));
    	return blockRegistry;
    }
}
