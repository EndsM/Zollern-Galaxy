package zollerngalaxy.biomes.genlayers;

import micdoodle8.mods.miccore.IntCache;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import zollerngalaxy.planets.ZGPlanets;

public class GenLayerPurgotBiomes extends GenLayer {
	
	private static final Biome[] biomes = ZGPlanets.planetPurgot.biomesToGenerate
			.toArray(new Biome[0]);// { ZGBiomes.PURGOT, ZGBiomes.LIMBO };
	
	public GenLayerPurgotBiomes(long l, GenLayer parent) {
		super(l);
		this.parent = parent;
	}
	
	public GenLayerPurgotBiomes(long l) {
		super(l);
	}
	
	@Override
	public int[] getInts(int x, int z, int width, int depth) {
		int[] dest = IntCache.getIntCache(width * depth);
		
		for (int k = 0; k < depth; ++k) {
			for (int i = 0; i < width; ++i) {
				initChunkSeed(x + i, z + k);
				dest[i + k * width] = Biome.getIdForBiome(biomes[nextInt(biomes.length)]);
			}
		}
		
		return dest;
	}
}