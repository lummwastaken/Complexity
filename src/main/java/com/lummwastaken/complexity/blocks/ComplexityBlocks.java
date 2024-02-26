package com.lummwastaken.complexity.blocks;

import java.util.function.Supplier;

import com.lummwastaken.complexity.Complexity;
import com.lummwastaken.complexity.items.ComplexityItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion.BlockInteraction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ComplexityBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Complexity.MOD_ID);
    
    // new overloaded method for initializing block properties
    // takes no input
    private static BlockBehaviour.Properties pBlockBase() {
    	return BlockBehaviour.Properties.of(Material.STONE);
    }
    // takes Material input
    private static BlockBehaviour.Properties pBlockBase(Material material) {
    	return BlockBehaviour.Properties.of(material);
    }
	
    // example block
    public static final RegistryObject<Block> BANANA_BLOCK = register("banana_block", 
    	() -> new Block(
    		pBlockBase(Material.MOSS)
    			.instabreak()
    			.sound(SoundType.FUNGUS)
    	), 
    	new Item.Properties()
    		.food(new FoodProperties
    			.Builder()
    				.nutrition(18)
    				.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 40, 1), 1)
    			.build())
    		.tab(Complexity.Tabs.EXAMPLE_TAB_2)
    );
    
    // example block with custom functionality
    public static final RegistryObject<Block> CUSTOM_BLOCK = register("custom_block",
    	() -> new CustomBlock(
    		pBlockBase()
    			.requiresCorrectToolForDrops(),
    		5, 	 // sets explosionRadius
    		true // sets createsFire
    	),
    	new Item.Properties()
    		.tab(Complexity.Tabs.EXAMPLE_TAB_2)
    );
    	// create a new static block class extending Block that does something when right clicked
    public static class CustomBlock extends Block {
    	int explosionRadius;
    	boolean createsFire;
		public CustomBlock(Properties properties, int explosionRadius, boolean createsFire) {
			super(properties);
			this.explosionRadius = explosionRadius;
			this.createsFire = createsFire;
		}
		// if player has custom_item in inventory and player right clicks custom_block, create explosion and destroy custom_block
		@SuppressWarnings("deprecation")
		public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
			if (player.getInventory().contains(new ItemStack(ComplexityItems.CUSTOM_ITEM.get()))) {
				level.removeBlock(pos, false); // it is important to remove the block before exploding if you do not want the block to drop
				level.explode(null, DamageSource.CACTUS, null, pos.getX(), pos.getY(), pos.getZ(), explosionRadius, createsFire, BlockInteraction.DESTROY);
				return InteractionResult.SUCCESS;
			}
			return super.use(state, level, pos, player, hand ,hitResult);
		}
    }
    
    // new blocks here
    
    
    
    
    
    
    
    
    
    // method that registers associated item for each block
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block, Item.Properties properties) {
    	RegistryObject<T> blockRegistry = BLOCKS.register(name, block);
    	ComplexityItems.ITEMS.register(name, () -> new BlockItem(blockRegistry.get(), properties));
    	return blockRegistry;
    }
}
