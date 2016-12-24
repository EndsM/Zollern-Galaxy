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

package galaxymod.blocks.zollus;

import galaxymod.ZollernGalaxyCore;
import galaxymod.blocks.BlockList;
import galaxymod.items.ItemList;
import galaxymod.utils.ZGHelper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BlockZolniumCrystals extends BlockBush implements IPlantable {
	
	public static Item dropItem = ItemList.zollusCrystal;
	
	public BlockZolniumCrystals() {
		super(Material.rock);
		ZGHelper.setNameAndTexture(this, "spacecrystals");
		ZGHelper.setHardResist(this, 0.5F);
		this.setHarvestLevel("pickaxe", 4);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Cave;
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block plantBlock) {
		return (plantBlock == BlockList.zolarBlock);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return this.dropItem;
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		if (par1Rand.nextInt(2) == 1) {
			return 2;
		} else {
			return 1;
		}
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernGalaxyCore.novaTabBlocks;
	}
}