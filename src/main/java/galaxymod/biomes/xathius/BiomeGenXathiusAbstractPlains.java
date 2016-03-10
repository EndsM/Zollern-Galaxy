/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.xathius;

import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenXathiusAbstractPlains extends BiomeGenXathiusBase {
	
	public BiomeGenXathiusAbstractPlains(int par1) {
		super(par1);
		this.setBiomeName("Abstract Plains");
		this.setHeightBaseModifier(145);
		this.setHeight(new Height(0.1F, 0.1F));
		this.setChunkHeightModifier(5);
		this.setTemp(6F);
		this.grassFoilageColorMultiplier = 0xbfbfbf;
		this.theBiomeDecorator.generateLakes = false;
		this.waterColorMultiplier = 0x000000;
		this.topBlock = BlockList.xathGrass;
		this.fillerBlock = BlockList.xathRock;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x008b00;
	}
	
}