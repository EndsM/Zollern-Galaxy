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

package galaxymod.biomes.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.BiomeSpace;
import galaxymod.biomes.decorators.BiomeDecoratorEden;
import galaxymod.blocks.BlockList;
import galaxymod.core.ZGPlanets;
import galaxymod.core.config.ConfigManagerZG;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;

public abstract class BiomeGenEdenBase extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x00ff00;
	public static int chunkHeightModifier = 12;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public static int biomeHeightBaseModifier = 212;
	public BiomeDecoratorEden biomeDecor = this.getBiomeDecorator();
	
	public BiomeGenEdenBase(int p_i1971_1_) {
		super(p_i1971_1_);
		this.enableRain = true;
		this.enableSnow = true;
		this.setColor(BiomeList.biomeColor);
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.biomeDecor.edenTallGrassPerChunk = 2;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.stoneBlock = BlockList.edenRock;
		this.setPlanetForBiome(ZGPlanets.planetEden);
		if (ConfigManagerZG.canEarthAnimalsSpawnOnEden) {
			this.spawnableCreatureList.add(new SpawnListEntry(
					EntityChicken.class, 100, 1, 2));
			this.spawnableCreatureList.add(new SpawnListEntry(
					EntitySheep.class, 100, 3, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class,
					100, 5, 8));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class,
					100, 2, 4));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class,
					100, 1, 3));
			this.spawnableCreatureList.add(new SpawnListEntry(
					EntityHorse.class, 100, 2, 5));
		}
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeGenEdenBase setColor(int var1) {
		return (BiomeGenEdenBase) super.setColor(var1);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorEden();
	}
	
	protected BiomeDecoratorEden getBiomeDecorator() {
		return (BiomeDecoratorEden) this.theBiomeDecorator;
	}
	
	public void genEdenBiomeTerrain(World world, Random rand, Block[] block,
			byte[] meta, int x, int z, double stoneNoise) {
		Block topBlock = this.topBlock;
		byte topMeta = 0;
		Block fillerBlock = this.fillerBlock;
		byte fillerMeta = 0;
		int currentFillerDepth = -1;
		int maxFillerDepth = (int) (stoneNoise / 3.0D + 3.0D + rand
				.nextDouble() * 0.25D);
		int maskX = x & 15;
		int maskZ = z & 15;
		int worldHeight = block.length / 256;
		int seaLevel = 32;
		
		for (int y = 255; y >= 0; y--) {
			int index = (maskZ * 16 + maskX) * worldHeight + y;
			
			if (y <= 0 + rand.nextInt(5)) {
				block[index] = Blocks.bedrock;
			} else {
				Block currentBlock = block[index];
				
				if (currentBlock != null
						&& currentBlock.getMaterial() != Material.air) {
					if (currentBlock == Blocks.stone) {
						if (this.stoneBlock != null) {
							block[index] = this.stoneBlock;
							meta[index] = this.stoneMeta;
						}
						if (currentFillerDepth == -1) {
							if (maxFillerDepth <= 0) {
								topBlock = null;
								topMeta = 0;
								fillerBlock = BlockList.edenSurfaceRock;
								fillerMeta = 0;
							} else if (y >= seaLevel - 5 && y <= seaLevel) {
								topBlock = this.topBlock;
								topMeta = this.topMeta;
								fillerBlock = this.fillerBlock;
								fillerMeta = 0;
							}
							if (y < seaLevel - 1
									&& (topBlock == null || topBlock
											.getMaterial() == Material.air)) {
								if (this.getIsColdBiome()) {
									topBlock = Blocks.ice;
									topMeta = 0;
								} else {
									topBlock = Blocks.water;
									topMeta = 0;
								}
							}
							
							currentFillerDepth = maxFillerDepth;
							
							if (y >= seaLevel - 2) {
								block[index] = topBlock;
								meta[index] = topMeta;
							} else if (y < seaLevel - 8 - maxFillerDepth) {
								topBlock = null;
								fillerBlock = BlockList.edenSurfaceRock;
								fillerMeta = 0;
								block[index] = BlockList.edenSoil;
							} else {
								block[index] = fillerBlock;
								meta[index] = fillerMeta;
							}
						} else if (currentFillerDepth > 0) {
							currentFillerDepth--;
							block[index] = fillerBlock;
							meta[index] = fillerMeta;
							
							if (currentFillerDepth == 0
									&& fillerBlock == BlockList.edenBloodSand) {
								currentFillerDepth = rand.nextInt(4)
										+ Math.max(0, y - (seaLevel - 1));
								fillerBlock = BlockList.edenBloodStone;
								fillerMeta = 0;
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public void genTerrainBlocks(World world, Random rand, Block[] block,
			byte[] meta, int x, int z, double stoneNoise) {
		this.genEdenBiomeTerrain(world, rand, block, meta, x, z, stoneNoise);
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
}