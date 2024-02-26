package com.lummwastaken.complexity.items;

import com.lummwastaken.complexity.Complexity;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ComplexityItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Complexity.MOD_ID);
	
	// object for default item properties; apply methods to pBase as demonstrated with the test banana
	private static Item.Properties pBase = new Item.Properties();
	
	// example item
	public static final RegistryObject<Item> TEST_BANANA = ITEMS.register("test_banana", 
		() -> new Item(
			pBase
				.stacksTo(16)
				.food(new FoodProperties
					.Builder()
						.nutrition(2)
					.build())
				.tab(Complexity.Tabs.EXAMPLE_TAB)
		)
	);
	
	// example item with more functionality; replace all Item class with the custom item class
	private static Item.Properties pFoilBase = new FoilItem.Properties();
	public static final RegistryObject<Item> CUSTOM_ITEM = ITEMS.register("custom_item", 
		() -> new FoilItem(
			pFoilBase
				.fireResistant()
				.tab(Complexity.Tabs.EXAMPLE_TAB)
		)
	);
		// create a new static item class extending Item that has enchant glow
	public static class FoilItem extends Item {
		public FoilItem(Properties properties) {
			super(properties);
		}
		
		public boolean isFoil(ItemStack stack) {
			return true;
		}
	}
		// for custom items that have many methods, it is often better to create a separate class file to reduce clutter
	
	// new items here
	
	
	
	
	
	
	
	
}
