package com.blackspider9678.Egyptian.init;

import java.util.ArrayList;
import java.util.List;

import com.blackspider9678.Egyptian.blocks.BlockBase;
import com.blackspider9678.Egyptian.blocks.SmallPedestalBlock;
import com.blackspider9678.Egyptian.blocks.SunAltarBlock;
import com.blackspider9678.Egyptian.blocks.SunCauldronBlock;
import com.blackspider9678.Egyptian.blocks.SunSandstoneBlock;
import com.blackspider9678.Egyptian.blocks.TallPedestalBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Alter ritual blocks
	public static final Block SUN_ALTAR_BLOCK = new SunAltarBlock("sun_altar_block", Material.ROCK);
	public static final Block SUN_CAULDRON_BLOCK = new SunCauldronBlock("sun_cauldron_block", Material.ROCK);
	public static final Block SMALL_PEDESTAL_BLOCK = new SmallPedestalBlock("small_pedestal_block", Material.ROCK);
	public static final Block TALL_PEDESTAL_BLOCK = new TallPedestalBlock("tall_pedestal_block", Material.ROCK);

	//Decor for Egypt
	public static final Block SUN_SANDSTONE_BLOCK = new SunSandstoneBlock("sun_sandstone_block", Material.ROCK);	
}
