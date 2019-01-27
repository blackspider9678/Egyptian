package com.blackspider9678.Egyptian.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SunAltarBlock extends BlockBase {
	public SunAltarBlock(String name, Material material) {
		super(name,material);
		
		setSoundType(SoundType.METAL);
		setHardness(2f);
		setResistance(20.0f);
		setHarvestLevel("pickaxe", 2);
	}
	
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
