/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.ZollernGalaxyCore;
import galaxymod.utils.ZGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BloodSand extends BlockFalling {
	public BloodSand() {
		super(Material.sand);
		ZGHelper.setNameAndTexture(this, "bloodsand");
		this.setResistance(1F);
		this.setHardness(1F);
		this.setStepSound(soundTypeSand);
		this.setHarvestLevel("shovel", 2);
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z,
			ForgeDirection direction, IPlantable plantable) {
		Block plant = plantable.getPlant(world, x, y + 1, z);
		EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
		if (plantType == EnumPlantType.Desert) {
			return true;
		}
		return false;
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernGalaxyCore.novaTabBlocks;
	}
}