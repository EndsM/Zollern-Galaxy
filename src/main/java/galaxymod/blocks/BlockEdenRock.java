package galaxymod.blocks;

import galaxymod.lib.ModInfo;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockEdenRock extends Block {
	public BlockEdenRock() {
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(ModInfo.MODID + "_edenrock");
		this.setResistance(9.8F);
		this.setHardness(1.8F);
		this.setBlockTextureName(ModInfo.MODID + ":edenrock");
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(BlockList.edenCobbleRock);
	}
}