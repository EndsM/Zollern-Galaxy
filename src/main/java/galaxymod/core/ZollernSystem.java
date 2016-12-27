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

package galaxymod.core;

import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;

public class ZollernSystem extends SolarSystem {
	
	public ZollernSystem(String solarSystemName) {
		super(solarSystemName, "milkyWay");
	}
	
	public ZollernSystem(String solarSystemName, Vector3 mapPosition) {
		super(solarSystemName, "milkyWay");
		this.setMapPosition(mapPosition);
	}
	
	public ZollernSystem(String solarSystemName, Star mainStar) {
		super(solarSystemName, "milkyWay");
		this.setMainStar(mainStar);
	}
	
	public ZollernSystem(String solarSystemName, Vector3 mapPosition,
			Star mainStar) {
		super(solarSystemName, "milkyWay");
		this.setMapPosition(mapPosition);
		this.setMainStar(mainStar);
	}
	
}