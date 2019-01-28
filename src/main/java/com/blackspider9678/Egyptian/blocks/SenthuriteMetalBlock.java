package com.blackspider9678.Egyptian.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class SenthuriteMetalBlock extends BlockBase{
	public SenthuriteMetalBlock (String name, Material material) {
		super(name,material);
		
		setSoundType(SoundType.METAL);
		setHardness(2f);
		setResistance(20.0f);
		setHarvestLevel("pickaxe", 2);
	}
}
