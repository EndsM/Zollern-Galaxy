/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WorldGenTunnel extends ZGWorldGenMaster {
	
	private int tunnelDepth = 10;
	private IBlockState airBlock = Blocks.AIR.getDefaultState();
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (!this.isValidSpawn(worldIn, pos)) {
			return false;
		}
		
		this.generateTunnel(worldIn, pos);
		this.generateTunnel(worldIn, pos.add(1, 0, 0));
		this.generateTunnel(worldIn, pos.add(0, 0, 1));
		this.generateTunnel(worldIn, pos.add(-1, 0, 0));
		this.generateTunnel(worldIn, pos.add(0, 0, -1));
		
		return true;
	}
	
	private void generateTunnel(World worldIn, BlockPos pos) {
		for (int i = 0; i < this.tunnelDepth; i++) {
			worldIn.setBlockState(pos.add(i, 0, 0), airBlock);
			worldIn.setBlockState(pos.add(i, 1, 0), airBlock);
			worldIn.setBlockState(pos.add(i, 2, 0), airBlock);
		}
	}
}