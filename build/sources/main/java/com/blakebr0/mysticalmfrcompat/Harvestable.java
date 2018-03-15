package com.blakebr0.mysticalmfrcompat;

import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import powercrystals.minefactoryreloaded.api.HarvestType;
import powercrystals.minefactoryreloaded.api.IFactoryHarvestable;

public class Harvestable implements IFactoryHarvestable {
	
	private Block block;
	
	public Harvestable(Block block){
		this.block = block;
	}

	@Override
	public boolean breakBlock(){
		return true;
	}

	@Override
	public boolean canBeHarvested(World arg0, Map<String, Boolean> arg1, BlockPos arg2){
		return arg0.getBlockState(arg2).getBlock().getMetaFromState(arg0.getBlockState(arg2)) >= 7;
	}

	@Override
	public List<ItemStack> getDrops(World arg0, Random arg1, Map<String, Boolean> arg2, BlockPos arg3){
		return arg0.getBlockState(arg3).getBlock().getDrops(arg0, arg3, arg0.getBlockState(arg3), 0);
	}

	@Override
	public HarvestType getHarvestType(){
		return HarvestType.Normal;
	}

	@Override
	public Block getPlant(){
		return block;
	}

	@Override
	public void postHarvest(World arg0, BlockPos arg1){
		
	}

	@Override
	public void preHarvest(World arg0, BlockPos arg1){
		
	}
}
