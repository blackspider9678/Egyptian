package com.blackspider9678.Egyptian.init;

import java.util.ArrayList;
import java.util.List;

import com.blackspider9678.Egyptian.items.ItemBase;

import net.minecraft.item.Item;

public class ModItems {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Crystals
	public static final Item SUN_CRYSTAL = new ItemBase("sun_crystal");
	
	//Gems
	public static final Item AZURITE_STONE = new ItemBase("azurite_stone");
	public static final Item SENTHURITE_INGOT = new ItemBase("senthurite_ingot");
}
