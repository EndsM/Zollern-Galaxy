/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;
import zollerngalaxy.mobs.entities.base.EntityWaterMobZG;

public class EntityBlubberFish extends EntityWaterMobZG {
	
	public EntityBlubberFish(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.0F, this.height * 1.0F);
		this.rand.setSeed(1 + this.getEntityId());
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
}