package galaxymod.dimensions.providers.renderers;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;

public class SkyProviderZollus extends IRenderHandler {

	private ResourceLocation starTexture = new ResourceLocation(
			"galaxymod:textures/gui/psion6.png");

	public int starList;
	public int glSkyList;
	public int glSkyList2;
	private float sunSize;

	public SkyProviderZollus(IGalacticraftWorldProvider zollusProvider) {
		this.sunSize = 7.5F * zollusProvider.getSolarSize();

		int displayLists = GLAllocation.generateDisplayLists(3);
		this.starList = displayLists;
		this.glSkyList = displayLists + 1;
		this.glSkyList2 = displayLists + 2;

		// Bind stars to display list
		GL11.glPushMatrix();
		GL11.glNewList(this.starList, GL11.GL_COMPILE);
		this.renderStars();
		GL11.glEndList();
		GL11.glPopMatrix();

		Tessellator tessellator = Tessellator.instance;
		GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
		byte byte2 = 64;
		int i = 256 / byte2 + 2;
		float f = 16F;

		for (int j = -byte2 * i; j <= byte2 * i; j += byte2) {
			for (int l = -byte2 * i; l <= byte2 * i; l += byte2) {
				tessellator.startDrawingQuads();
				tessellator.addVertex(j + 0, f, l + 0);
				tessellator.addVertex(j + byte2, f, l + 0);
				tessellator.addVertex(j + byte2, f, l + byte2);
				tessellator.addVertex(j + 0, f, l + byte2);
				tessellator.draw();
			}
		}

		GL11.glEndList();
		GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
		f = -16F;
		tessellator.startDrawingQuads();

		for (int k = -byte2 * i; k <= byte2 * i; k += byte2) {
			for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2) {
				tessellator.addVertex(k + byte2, f, i1 + 0);
				tessellator.addVertex(k + 0, f, i1 + 0);
				tessellator.addVertex(k + 0, f, i1 + byte2);
				tessellator.addVertex(k + byte2, f, i1 + byte2);
			}
		}
		tessellator.draw();
		GL11.glEndList();
	}

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableStandardItemLighting();
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		Vec3 vec3 = world.getSkyColor(mc.renderViewEntity, partialTicks);
		float f1 = (float) vec3.xCoord;
		float f2 = (float) vec3.yCoord;
		float f3 = (float) vec3.zCoord;
		float f6;

		GL11.glColor3f(f1, f2, f3);
		Tessellator tessellator1 = Tessellator.instance;
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_FOG);
		GL11.glColor3f(f1, f2, f3);
		GL11.glCallList(this.glSkyList);
		GL11.glDisable(GL11.GL_FOG);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();
		float f7;
		float f8;
		float f9;
		float f10;
		float f18 = world.getStarBrightness(partialTicks);

		if (f18 > 0.0F) {
			GL11.glColor4f(f18, f18, f18, f18);
			GL11.glCallList(this.starList);
		}

		float[] afloat = new float[4];
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);
		GL11.glPushMatrix();
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F,
				0.0F, 0.0F);
		afloat[0] = 0 / 255.0F;
		afloat[1] = 225 / 255.0F;
		afloat[2] = 255 / 255.0F;
		afloat[3] = 0.4F;
		f6 = afloat[0];
		f7 = afloat[1];
		f8 = afloat[2];
		float f11;

		f18 = 1.0F - f18;

		tessellator1.startDrawing(GL11.GL_TRIANGLE_FAN);
		tessellator1.setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * 2
				/ f18);
		tessellator1.addVertex(0.0D, 100.0D, 0.0D);
		tessellator1.setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2]
				* f18, 0.0F);

		tessellator1.draw();
		GL11.glPopMatrix();
		GL11.glShadeModel(GL11.GL_FLAT);

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPushMatrix();

		GL11.glPopMatrix();
		GL11.glPushMatrix();
		f7 = 0.0F;
		f8 = 0.0F;
		f9 = 0.0F;
		GL11.glTranslatef(f7, f8, f9);
		GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F,
				0.0F, 0.0F);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
		f10 = 9.5F / 3.5F;
		tessellator1.startDrawingQuads();
		tessellator1.addVertex(-f10, 99.9D, -f10);
		tessellator1.addVertex(f10, 99.9D, -f10);
		tessellator1.addVertex(f10, 99.9D, f10);
		tessellator1.addVertex(-f10, 99.9D, f10);
		tessellator1.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		// Render sirius
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
		// Some blanking to conceal the stars
		f10 = this.sunSize / 3.5F;
		tessellator1.startDrawingQuads();
		tessellator1.addVertex(-f10, 99.9D, -f10);
		tessellator1.addVertex(f10, 99.9D, -f10);
		tessellator1.addVertex(f10, 99.9D, f10);
		tessellator1.addVertex(-f10, 99.9D, f10);
		tessellator1.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		f10 = this.sunSize + 0;
		mc.renderEngine.bindTexture(this.starTexture);
		tessellator1.startDrawingQuads();
		tessellator1.addVertexWithUV(-f10, 100.0D, -f10, 0.0D, 0.0D);
		tessellator1.addVertexWithUV(f10, 100.0D, -f10, 1.0D, 0.0D);
		tessellator1.addVertexWithUV(f10, 100.0D, f10, 1.0D, 1.0D);
		tessellator1.addVertexWithUV(-f10, 100.0D, f10, 0.0D, 1.0D);
		tessellator1.draw();

		GL11.glPopMatrix();
		GL11.glPushMatrix();

		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDepthMask(true);
	}

	private void renderStars() {
		Random rand = new Random(10842L);
		Tessellator var2 = Tessellator.instance;
		var2.startDrawingQuads();

		for (int starIndex = 0; starIndex < (ConfigManagerCore.moreStars ? 35000
				: 6000); ++starIndex) {
			double var4 = rand.nextFloat() * 2.0F - 1.0F;
			double var6 = rand.nextFloat() * 2.0F - 1.0F;
			double var8 = rand.nextFloat() * 2.0F - 1.0F;
			double var10 = 0.15F + rand.nextFloat() * 0.1F;
			double var12 = var4 * var4 + var6 * var6 + var8 * var8;

			if (var12 < 1.0D && var12 > 0.01D) {
				var12 = 1.0D / Math.sqrt(var12);
				var4 *= var12;
				var6 *= var12;
				var8 *= var12;
				double var14 = var4
						* (ConfigManagerCore.moreStars ? rand.nextDouble() * 150D + 130D
								: 100.0D);
				double var16 = var6
						* (ConfigManagerCore.moreStars ? rand.nextDouble() * 150D + 130D
								: 100.0D);
				double var18 = var8
						* (ConfigManagerCore.moreStars ? rand.nextDouble() * 150D + 130D
								: 100.0D);
				double var20 = Math.atan2(var4, var8);
				double var22 = Math.sin(var20);
				double var24 = Math.cos(var20);
				double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8),
						var6);
				double var28 = Math.sin(var26);
				double var30 = Math.cos(var26);
				double var32 = rand.nextDouble() * Math.PI * 2.0D;
				double var34 = Math.sin(var32);
				double var36 = Math.cos(var32);

				for (int var38 = 0; var38 < 4; ++var38) {
					double var39 = 0.0D;
					double var41 = ((var38 & 2) - 1) * var10;
					double var43 = ((var38 + 1 & 2) - 1) * var10;
					double var47 = var41 * var36 - var43 * var34;
					double var49 = var43 * var36 + var41 * var34;
					double var53 = var47 * var28 + var39 * var30;
					double var55 = var39 * var28 - var47 * var30;
					double var57 = var55 * var22 - var49 * var24;
					double var61 = var49 * var22 + var55 * var24;
					var2.addVertex(var14 + var57, var16 + var53, var18 + var61);
				}
			}
		}
		var2.draw();
	}

	public float getSkyBrightness(float par1) {
		float var2 = FMLClientHandler.instance().getClient().theWorld
				.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.sin(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

		if (var3 < 0.0F) {
			var3 = 0.0F;
		}
		if (var3 > 1.0F) {
			var3 = 1.0F;
		}
		return var3 * var3 * 1F;
	}
}