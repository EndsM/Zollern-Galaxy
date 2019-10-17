package zollerngalaxy.core.dimensions.worldproviders.orbit;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOverworldOrbit;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderOrbitZG;
import zollerngalaxy.planets.ZGPlanet;
import zollerngalaxy.planets.ZGPlanets;
import zollerngalaxy.planets.ZGSpaceStations;

public class WorldProviderOrbitPurgot extends WorldProviderOverworldOrbit {
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGSpaceStations.PURGOT_SPACE_STATION;
	}
	
	@Override
	public Vector3 getSkyColor() {
		float f = 0.6F - this.getStarBrightness(1.0F);
		return new Vector3(255 / 255F * f, 20 / 255F * f, 255 / 255F * f);
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(200 / 255F * f, 27 / 255F * f, 200 / 255F * f);
	}
	
	@Override
	public boolean canRainOrSnow() {
		return false;
	}
	
	@Override
	public boolean hasSunset() {
		return true;
	}
	
	@Override
	public long getDayLength() {
		return 22000L;
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderOrbitZG.class;
	}
	
	@Override
	public boolean isDaytime() {
		final float a = this.world.getCelestialAngle(0F);
		return a < 0.42F || a > 0.58F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		final float var2 = this.world.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.cos(var2 * Constants.twoPI) * 2.0F + 0.25F);
		
		if (var3 < 0.0F) {
			var3 = 0.0F;
		}
		
		if (var3 > 1.0F) {
			var3 = 1.0F;
		}
		
		return var3 * var3 * 0.5F + 0.3F;
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public double getHorizon() {
		return 44.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 44;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}
	
	@Override
	public float getGravity() {
		return 0.073F;// 0.073F;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 0;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 1.0D;
	}
	
	@Override
	public String getPlanetToOrbit() {
		return "planet.purgot";
	}
	
	@Override
	public String getSaveFolder() {
		return "space_stations/purgot";
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return ConfigManagerCore.spaceStationEnergyScalar;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier > ZGPlanets.planetPurgot.getTierRequirement();
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.4F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 50.0F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return 0.0F;
	}
	
	public ZGPlanet getPlanet() {
		return ZGPlanets.planetPurgot;
	}
	
	@Override
	public float getWindLevel() {
		return 0.1F;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.PURGOT_ORBIT;
	}
}