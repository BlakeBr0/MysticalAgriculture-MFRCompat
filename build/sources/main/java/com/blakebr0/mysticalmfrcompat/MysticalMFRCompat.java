package com.blakebr0.mysticalmfrcompat;

import java.lang.reflect.Method;

import com.blakebr0.mysticalagriculture.blocks.ModBlocks;
import com.blakebr0.mysticalagriculture.items.ModItems;
import com.blakebr0.mysticalagriculture.lib.CropType;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import powercrystals.minefactoryreloaded.MFRRegistry;
import powercrystals.minefactoryreloaded.api.FertilizerType;
import powercrystals.minefactoryreloaded.farmables.fertilizables.FertilizableCropPlant;
import powercrystals.minefactoryreloaded.farmables.fertilizables.FertilizerStandard;
import powercrystals.minefactoryreloaded.farmables.plantables.PlantableCropPlant;
import powercrystals.minefactoryreloaded.farmables.plantables.PlantableStandard;

@Mod(modid = "mysticalmfrcompat", name = "Mystical MFR Compat", version = "1.0.0", dependencies = "required-after:minefactoryreloaded;required-after:mysticalagriculture;after:mysticalagradditions")
public class MysticalMFRCompat {
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		if(Loader.isModLoaded("mysticalagriculture")){
			MFRRegistry.registerHarvestable(new Harvestable(ModBlocks.blockTier1InferiumCrop));
			MFRRegistry.registerHarvestable(new Harvestable(ModBlocks.blockTier2InferiumCrop));
			MFRRegistry.registerHarvestable(new Harvestable(ModBlocks.blockTier3InferiumCrop));
			MFRRegistry.registerHarvestable(new Harvestable(ModBlocks.blockTier4InferiumCrop));
			MFRRegistry.registerHarvestable(new Harvestable(ModBlocks.blockTier5InferiumCrop));
			MFRRegistry.registerPlantable(new PlantableCropPlant(ModItems.itemTier1InferiumSeeds, ModBlocks.blockTier1InferiumCrop));
			MFRRegistry.registerPlantable(new PlantableCropPlant(ModItems.itemTier2InferiumSeeds, ModBlocks.blockTier2InferiumCrop));
			MFRRegistry.registerPlantable(new PlantableCropPlant(ModItems.itemTier3InferiumSeeds, ModBlocks.blockTier3InferiumCrop));
			MFRRegistry.registerPlantable(new PlantableCropPlant(ModItems.itemTier4InferiumSeeds, ModBlocks.blockTier4InferiumCrop));
			MFRRegistry.registerPlantable(new PlantableCropPlant(ModItems.itemTier5InferiumSeeds, ModBlocks.blockTier5InferiumCrop));
			MFRRegistry.registerFertilizable(new FertilizableCropPlant((Block)ModBlocks.blockTier1InferiumCrop, FertilizerType.GrowMagicalCrop, 0));
			MFRRegistry.registerFertilizable(new FertilizableCropPlant((Block)ModBlocks.blockTier2InferiumCrop, FertilizerType.GrowMagicalCrop, 0));
			MFRRegistry.registerFertilizable(new FertilizableCropPlant((Block)ModBlocks.blockTier3InferiumCrop, FertilizerType.GrowMagicalCrop, 0));
			MFRRegistry.registerFertilizable(new FertilizableCropPlant((Block)ModBlocks.blockTier4InferiumCrop, FertilizerType.GrowMagicalCrop, 0));
			MFRRegistry.registerFertilizable(new FertilizableCropPlant((Block)ModBlocks.blockTier5InferiumCrop, FertilizerType.GrowMagicalCrop, 0));
			for(CropType.Type crop : CropType.Type.values()){
				if(crop.isEnabled()){
					MFRRegistry.registerHarvestable(new Harvestable(crop.getPlant()));
					MFRRegistry.registerPlantable(new PlantableCropPlant(crop.getSeed(), crop.getPlant()));
					MFRRegistry.registerFertilizable(new FertilizableCropPlant((Block)crop.getPlant(), FertilizerType.GrowMagicalCrop, 0));
				}
			}
			MFRRegistry.registerFertilizer(new FertilizerStandard(ModItems.itemFertilizedEssence, 0, FertilizerType.GrowMagicalCrop));
		}

		if(Loader.isModLoaded("mysticalagradditions")){
			MAgradditionsCompat.init();
		}
	}
}
