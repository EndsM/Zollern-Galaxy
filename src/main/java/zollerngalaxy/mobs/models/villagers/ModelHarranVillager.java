package zollerngalaxy.mobs.models.villagers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelHarranVillager extends ModelBase {
	
	private final ModelRenderer Head;
	private final ModelRenderer rightHeadThing_r1;
	private final ModelRenderer Body;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;
	private final ModelRenderer RightLeg;
	private final ModelRenderer LeftLeg;
	
	public ModelHarranVillager() {
		textureWidth = 64;
		textureHeight = 64;
		
		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.cubeList.add(new ModelBox(Head, 0, 0, -4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 20, 8, -3.0F, -16.0F, -2.0F, 6, 6, 4, 0.0F, false));
		Head.cubeList.add(new ModelBox(Head, 25, 0, -1.0F, -3.0F, -6.0F, 2, 4, 2, 0.0F, false));
		
		rightHeadThing_r1 = new ModelRenderer(this);
		rightHeadThing_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.addChild(rightHeadThing_r1);
		setRotationAngle(rightHeadThing_r1, -0.2618F, 0.0F, 0.0F);
		rightHeadThing_r1.cubeList.add(new ModelBox(rightHeadThing_r1, 34, 6, 4.0F, -12.0F, -3.0F, 4, 8, 3, 0.0F, false));
		rightHeadThing_r1.cubeList.add(new ModelBox(rightHeadThing_r1, 34, 6, -8.0F, -12.0F, -3.0F, 4, 8, 3, 0.0F, false));
		
		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 18, 19, -4.0F, 0.25F, -2.0F, 8, 12, 4, 0.0F, false));
		
		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.cubeList.add(new ModelBox(RightArm, 0, 22, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.cubeList.add(new ModelBox(LeftArm, 1, 22, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F, false));
		
		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg.cubeList.add(new ModelBox(RightLeg, 15, 50, -2.1F, 0.0F, -1.0F, 4, 12, 2, 0.0F, true));
		
		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg.cubeList.add(new ModelBox(LeftLeg, 15, 49, -2.0F, 0.0F, -1.0F, 4, 12, 2, 0.0F, false));
		
	}
	
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		Head.render(scale);
		Body.render(scale);
		RightArm.render(scale);
		LeftArm.render(scale);
		RightLeg.render(scale);
		LeftLeg.render(scale);
	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		boolean flag = (entityIn instanceof EntityLivingBase) && (((EntityLivingBase) entityIn).getTicksElytraFlying() > 4);
		float f = 1.0F;
		
		if (flag) {
			f = (float) (entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
			f = f / 0.2F;
			f = f * f * f;
		}
		
		if (f < 1.0F) {
			f = 1.0F;
		}
		
		this.Head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.Head.rotateAngleX = headPitch * 0.017453292F;
		
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;
		this.LeftArm.rotateAngleX = -0.75F;
		this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.RightArm.rotateAngleX = -0.75F;
		
		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleZ = 0.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;
		
		this.RightArm.rotateAngleY = 0.0F;
		this.RightArm.rotateAngleZ = 0.0F;
		
		if (this.swingProgress > 0.0F) {
			EnumHandSide enumhandside = EnumHandSide.LEFT;
			ModelRenderer modelrenderer = this.LeftArm;
			float f1 = this.swingProgress;
			this.Body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			
			if (enumhandside == EnumHandSide.LEFT) {
				this.Body.rotateAngleY *= -1.0F;
			}
			
			this.RightArm.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.Head.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float) (modelrenderer.rotateAngleX - (f2 * 1.2D + f3));
			modelrenderer.rotateAngleY += this.Body.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
		
		this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}