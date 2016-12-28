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

package galaxymod.worldgen.eden.village;

import galaxymod.blocks.BlockList;
import galaxymod.worldgen.NGWorldGenStructureCore;
import galaxymod.worldgen.eden.treasure.TreasureGenEden;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import net.minecraft.world.World;

public class VillageHouseTwo extends NGWorldGenStructureCore {
	
	public VillageHouseTwo() {
	}
	
	@Override
	public boolean generate(World world, Random rand, int i, int j, int k) {
		
		j = j + 1;
		
		NGEdenVillageHelper.spawnAlien(world, i - 4, j + 1, k + 2, 2);
		
		world.setBlock(i + 0, j + 1, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 0, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 0, k + 1, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 0, k + 2, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 0, k + 3, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 0, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 1, k + 0, BlockList.edenCobbleRock);
		
		TreasureGenEden.addChest(i + 1, j - 2, k - 4, rand, world);
		
		world.setBlock(i + 0, j + 1, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 1, k + 2, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 1, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 1, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 2, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 2, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 2, k + 2, BlockList.edenGlass);
		world.setBlock(i + 0, j + 2, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 2, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 3, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 3, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 3, k + 2, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 3, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 0, j + 3, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 0, j + 4, k + 0, BlockList.edenWoodLog);
		world.setBlock(i + 0, j + 4, k + 1, BlockList.edenWoodLog);
		world.setBlock(i + 0, j + 4, k + 2, BlockList.edenWoodLog);
		world.setBlock(i + 0, j + 4, k + 3, BlockList.edenWoodLog);
		world.setBlock(i + 0, j + 4, k + 4, BlockList.edenWoodLog);
		world.setBlock(i + 1, j + 0, k + 1, BlockList.edenCobbleRock);
		world.setBlock(i + 1, j + 0, k + 2, BlockList.edenCobbleRock);
		world.setBlock(i + 1, j + 0, k + 3, BlockList.edenCobbleRock);
		world.setBlock(i + 1, j + 0, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 1, j + 1, k + 0, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 1, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 2, k + 0, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 2, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 3, k + 0, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 3, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 4, k + 0, BlockList.edenWoodLog);
		world.setBlock(i + 1, j + 4, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 4, k + 2, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 4, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 1, j + 4, k + 4, BlockList.edenWoodLog);
		world.setBlock(i + 2, j + 0, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 2, j + 0, k + 1, BlockList.edenCobbleRock);
		world.setBlock(i + 2, j + 0, k + 2, BlockList.edenCobbleRock);
		world.setBlock(i + 2, j + 0, k + 3, BlockList.edenCobbleRock);
		world.setBlock(i + 2, j + 0, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 2, j + 1, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 2, j + 2, k + 4, BlockList.edenGlass);
		world.setBlock(i + 2, j + 3, k + 0, BlockList.edenWoodPlanks);
		world.setBlock(i + 2, j + 3, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 2, j + 4, k + 0, BlockList.edenWoodLog);
		world.setBlock(i + 2, j + 4, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 2, j + 4, k + 2, BlockList.edenWoodPlanks);
		world.setBlock(i + 2, j + 4, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 2, j + 4, k + 4, BlockList.edenWoodLog);
		world.setBlock(i + 3, j + 0, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 3, j + 0, k + 1, BlockList.edenCobbleRock);
		world.setBlock(i + 3, j + 0, k + 2, BlockList.edenCobbleRock);
		world.setBlock(i + 3, j + 0, k + 3, BlockList.edenCobbleRock);
		world.setBlock(i + 3, j + 0, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 3, j + 1, k + 0, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 1, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 2, k + 0, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 2, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 3, k + 0, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 3, k + 4, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 4, k + 0, BlockList.edenWoodLog);
		world.setBlock(i + 3, j + 4, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 4, k + 2, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 4, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 3, j + 4, k + 4, BlockList.edenWoodLog);
		world.setBlock(i + 4, j + 0, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 0, k + 1, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 0, k + 2, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 0, k + 3, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 0, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 1, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 1, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 1, k + 2, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 1, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 1, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 2, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 2, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 2, k + 2, BlockList.edenGlass);
		world.setBlock(i + 4, j + 2, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 2, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 3, k + 0, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 3, k + 1, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 3, k + 2, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 3, k + 3, BlockList.edenWoodPlanks);
		world.setBlock(i + 4, j + 3, k + 4, BlockList.edenCobbleRock);
		world.setBlock(i + 4, j + 4, k + 0, BlockList.edenWoodLog);
		world.setBlock(i + 4, j + 4, k + 1, BlockList.edenWoodLog);
		world.setBlock(i + 4, j + 4, k + 2, BlockList.edenWoodLog);
		world.setBlock(i + 4, j + 4, k + 3, BlockList.edenWoodLog);
		world.setBlock(i + 4, j + 4, k + 4, BlockList.edenWoodLog);
		world.setBlock(i + 2, j + 3, k + 1, GCBlocks.glowstoneTorch);
		
		(new VillageHouseThree()).generate(world, rand, i, j, k);
		return true;
	}
}