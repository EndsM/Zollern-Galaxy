/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.events;

import java.util.Random;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.LootTableManager;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAltum;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityAbyssalVillager;
import zollerngalaxy.mobs.entities.EntityBladeFish;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.CachedEnum;

public class ZGEvents {
	
	private ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	private IProxy proxy = this.core.proxy;
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLootTableLoadEvent(LootTableLoadEvent event) {
		ResourceLocation lootName = event.getName();
		if (lootName == LootTableList.GAMEPLAY_FISHING_FISH) {
			LootTableManager lootMgr = event.getLootTableManager();
			LootTable lootTbl = event.getTable();
			LootCondition[] conditions = new LootCondition[] {};
			RandomValueRange rng = new RandomValueRange(1.0F);
			RandomValueRange rngBonus = new RandomValueRange(0.0F);
			LootEntry entryZGFish = new LootEntryTable(ZGLootTables.GAMEPLAY_FISHING, 20, 10, conditions, "zgfishingentry");
			LootPool pool = new LootPool(new LootEntry[] { entryZGFish }, conditions, rng, rngBonus, "zgfishingpool");
			lootTbl.addPool(pool);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onJoinWorldEvent(EntityJoinWorldEvent event) {
		World world = event.getWorld();
		WorldProvider provider = world.provider;
		if (!world.isRemote) {
			Entity ent = event.getEntity();
			if (ent instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) ent;
				if (this.core.isInTestMode() || this.core.isInDevMode()) {
					String txtFormat = TextFormatting.BOLD + "" + TextFormatting.RED;
					String msg = txtFormat + "WARNING: This is NOT a valid version of Zollern Galaxy! "
							+ "Please uninstall the mod and install the correct version, or it will not operate correctly.";
					this.proxy.sendChatMessage(player, msg);
				}
			}
		}
		
		// Convert Alien Villagers to Abyssal Villagers
		if (provider instanceof WorldProviderAltum) {
			if (!world.isRemote) {
				Entity entity = event.getEntity();
				if (entity instanceof EntityAlienVillager) {
					EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
					BlockPos worldPos = alienVillager.getPos();
					alienVillager.setDead();
					EntityAbyssalVillager abyssalVillager = new EntityAbyssalVillager(world);
					abyssalVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
					world.spawnEntity(abyssalVillager);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.getEntityLiving();
		World worldObj = theEntity.world;
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		
		// Moolus (Alien Cow)
		if (theEntity instanceof EntityMoolus) {
			for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBeef, worldObj, theEntity);
			}
		}
		
		// Oinkus (Alien Pig)
		if (theEntity instanceof EntityOinkus) {
			for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBacon, worldObj, theEntity);
			}
		}
		
		// Gray Alien
		if (theEntity instanceof EntityGrayAlien) {
			for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
				ZGHelper.dropItem(ZGItems.alienStone, worldObj, theEntity);
			}
		}
		
		// Mega Creeper
		if (theEntity instanceof EntityMegaCreeper) {
			for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
				ZGHelper.dropItem(ZGItems.superChargedCoal, worldObj, theEntity);
			}
		}
		
		// Mummy
		if (theEntity instanceof EntityMummy) {
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
					ZGHelper.dropItem(Items.PAPER, worldObj, theEntity);
				}
			}
			
			if (ZGHelper.getRNGChance(5, 20)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.perdGlowdust, worldObj, theEntity);
				}
			}
		}
		
		// Scorpion
		if (theEntity instanceof EntityScorpion) {
			if (ZGHelper.getRNGChance(5, 20)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.dustEmerald, worldObj, theEntity);
				}
			}
		}
		
		// Blubber Fish
		if (theEntity instanceof EntityBlubberFish) {
			ZGHelper.dropItem(ZGItems.rawBlubberFish, worldObj, theEntity);
		}
		
		// Gypsy Fish
		if (theEntity instanceof EntityBlubberFish) {
			ZGHelper.dropItem(ZGItems.rawGypsyFish, worldObj, theEntity);
		}
		
		// Blade Fish
		if (theEntity instanceof EntityBladeFish) {
			ZGHelper.dropItem(ZGItems.rawBladeFish, worldObj, theEntity);
		}
		
		// Shark
		if (theEntity instanceof EntityShark) {
			// Shagreen (Shark Leather)
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.shagreen, worldObj, theEntity);
				}
			}
			
			// Shark Tooth
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
					ZGHelper.dropItem(ZGItems.sharkTooth, worldObj, theEntity);
				}
			}
		}
		
		// Shade Entities
		if (theEntity instanceof IShadeEntity) {
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.darkEssence, worldObj, theEntity);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onUseHoe(UseHoeEvent event) {
		if (event.getResult() != Result.DEFAULT || event.isCanceled()) {
			return;
		}
		
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		
		if (world.isAirBlock(pos.up())) {
			if (block instanceof ZGBlockGrass || block instanceof ZGBlockDirt) {
				this.setFarmland(event, world, pos, Blocks.FARMLAND);
			}
		}
	}
	
	private void setFarmland(UseHoeEvent event, World world, BlockPos pos, Block farmland) {
		world.setBlockState(pos, farmland.getDefaultState());
		event.setResult(Result.ALLOW);
		world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundType.GROUND.getStepSound(), SoundCategory.BLOCKS,
				(SoundType.GROUND.getVolume() + 1.0F) / 2.0F, SoundType.GROUND.getPitch() * 0.8F);
		
		for (EnumHand hand : CachedEnum.valuesHandCached()) {
			event.getEntityPlayer().swingArm(hand);
		}
	}
}