package com.blakebr0.mysticalmfrcompat;

import com.blakebr0.mysticalagradditions.blocks.ModBlocks;
import com.blakebr0.mysticalagradditions.items.ModItems;
import com.blakebr0.mysticalagradditions.lib.CropType;

import net.minecraft.block.Block;
import powercrystals.minefactoryreloaded.MFRRegistry;
import powercrystals.minefactoryreloaded.api.FertilizerType;
import powercrystals.minefactoryreloaded.farmables.fertilizables.FertilizableCropPlant;
import powercrystals.minefactoryreloaded.farmables.plantables.PlantableCropPlant;

public class MAgradditionsCompat {
	
	public static void init(){
		MFRRegistry.registerHarvestable(new Harvestable(ModBlocks.blockTier6InferiumCrop));
		MFRRegistry.registerPlantable(new PlantableCropPlant(ModItems.itemTier6InferiumSeeds, ModBlocks.blockTier6InferiumCrop));
		MFRRegistry.registerFertilizable(new FertilizableCropPlant((Block)ModBlocks.blockTier6InferiumCrop, FertilizerType.GrowMagicalCrop, 0));
		for(CropType.Type crop : CropType.Type.values()){
			if(crop.isEnabled()){
				MFRRegistry.registerHarvestable(new Harvestable(crop.getPlant()));
				MFRRegistry.registerPlantable(new PlantableCropPlant(crop.getSeed(), crop.getPlant()));
			}
		}
	}

}
