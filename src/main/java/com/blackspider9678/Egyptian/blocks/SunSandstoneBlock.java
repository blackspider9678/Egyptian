package com.blackspider9678.Egyptian.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SunSandstoneBlock extends BlockBase {

	public SunSandstoneBlock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(1.5F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 0);
		
	}

}
