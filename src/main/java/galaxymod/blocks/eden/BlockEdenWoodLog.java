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
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEdenWoodLog extends BlockRotatedPillar {
	
	@SideOnly(Side.CLIENT)
	protected IIcon field_150167_a;
	@SideOnly(Side.CLIENT)
	protected IIcon field_150166_b;
	
	public BlockEdenWoodLog() {
		super(Material.wood);
		ZGHelper.setNameAndTexture(this, "edenwoodlog");
		ZGHelper.setHardResist(this, 2.0F);
		this.setStepSound(soundTypeWood);
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernGalaxyCore.novaTabBlocks;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.field_150167_a = p_149651_1_
				.registerIcon("galaxymod:edentreelog_side");
		this.field_150166_b = p_149651_1_
				.registerIcon("galaxymod:edentreelog_top");
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 1;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(this);
	}
	
	@Override
	public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_,
			int p_149749_4_, Block p_149749_5_, int p_149749_6_) {
		byte b0 = 4;
		int i1 = b0 + 1;
		
		if (p_149749_1_.checkChunksExist(p_149749_2_ - i1, p_149749_3_ - i1,
				p_149749_4_ - i1, p_149749_2_ + i1, p_149749_3_ + i1,
				p_149749_4_ + i1)) {
			for (int j1 = -b0; j1 <= b0; ++j1) {
				for (int k1 = -b0; k1 <= b0; ++k1) {
					for (int l1 = -b0; l1 <= b0; ++l1) {
						Block block = p_149749_1_.getBlock(p_149749_2_ + j1,
								p_149749_3_ + k1, p_149749_4_ + l1);
						if (block.isLeaves(p_149749_1_, p_149749_2_ + j1,
								p_149749_3_ + k1, p_149749_4_ + l1)) {
							block.beginLeavesDecay(p_149749_1_, p_149749_2_
									+ j1, p_149749_3_ + k1, p_149749_4_ + l1);
						}
					}
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getSideIcon(int p_150163_1_) {
		return this.field_150167_a;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected IIcon getTopIcon(int p_150161_1_) {
		return this.field_150166_b;
	}
	
	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}
	
	@Override
	public boolean isWood(IBlockAccess world, int x, int y, int z) {
		return true;
	}
}