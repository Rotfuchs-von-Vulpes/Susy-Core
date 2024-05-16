package supersymmetry.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import net.minecraft.entity.EntityLivingBase;
import supersymmetry.entity.passive.EntityFox;

@SideOnly(Side.CLIENT)
public class ModelFox extends ModelBase {
    private final ModelRenderer foxBody;
    private final ModelRenderer foxTail;
    private final ModelRenderer foxHead;
    private final ModelRenderer foxLeftArm;
    private final ModelRenderer foxRightLeg;
    private final ModelRenderer foxRightArm;
    private final ModelRenderer foxLeftLeg;

    public ModelFox() {
        textureWidth = 64;
        textureHeight = 64;

        foxBody = new ModelRenderer(this);
        foxBody.setRotationPoint(0.0F, 16.5F, 1.0F);
        foxBody.cubeList.add(new ModelBox(foxBody, 0, 12, -4.0F, -2.5F, -6.0F, 8, 5, 12, 0.0F, false));
        foxBody.cubeList.add(new ModelBox(foxBody, 0, 29, -4.5F, -3.0F, -6.5F, 9, 6, 13, 0.0F, false));

        foxTail = new ModelRenderer(this);
        foxTail.setRotationPoint(0.0F, 17.0F, 7.0F);
        foxTail.cubeList.add(new ModelBox(foxTail, 28, 8, -3.0F, -4.0F, 0.0F, 6, 5, 11, 0.0F, false));

        foxHead = new ModelRenderer(this);
        foxHead.setRotationPoint(0.0F, 17.0F, -5.0F);
        foxHead.cubeList.add(new ModelBox(foxHead, 22, 3, -7.0F, -2.0F, -4.0F, 3, 3, 0, 0.0F, true));
        foxHead.cubeList.add(new ModelBox(foxHead, 22, 3, 4.0F, -2.0F, -4.0F, 3, 3, 0, 0.0F, false));
        foxHead.cubeList.add(new ModelBox(foxHead, 28, 6, -4.0F, -9.0F, -3.0F, 3, 4, 1, 0.0F, true));
        foxHead.cubeList.add(new ModelBox(foxHead, 28, 6, 1.0F, -9.0F, -3.0F, 3, 4, 1, 0.0F, false));
        foxHead.cubeList.add(new ModelBox(foxHead, 28, 1, -2.0F, -1.0F, -9.0F, 4, 2, 3, 0.0F, false));
        foxHead.cubeList.add(new ModelBox(foxHead, 0, 0, -4.0F, -5.0F, -6.0F, 8, 6, 6, 0.0F, false));

        foxLeftArm = new ModelRenderer(this);
        foxLeftArm.setRotationPoint(3.0F, 20.0F, -3.0F);
        foxLeftArm.cubeList.add(new ModelBox(foxLeftArm, 0, 16, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, false));

        foxRightLeg = new ModelRenderer(this);
        foxRightLeg.setRotationPoint(-3.0F, 20.0F, 7.0F);
        foxRightLeg.cubeList.add(new ModelBox(foxRightLeg, 0, 29, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, true));

        foxRightArm = new ModelRenderer(this);
        foxRightArm.setRotationPoint(-3.0F, 20.0F, -3.0F);
        foxRightArm.cubeList.add(new ModelBox(foxRightArm, 0, 16, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, true));

        foxLeftLeg = new ModelRenderer(this);
        foxLeftLeg.setRotationPoint(3.0F, 20.0F, 7.0F);
        foxLeftLeg.cubeList.add(new ModelBox(foxLeftLeg, 0, 29, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, false));
    }

    @Override
    public void render(@NotNull Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

        if (this.isChild)
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 5.0F * scale, 2.0F * scale);
            this.foxHead.render(scale);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 24.0F * scale, 0.0F);
            this.foxBody.render(scale);
            this.foxRightArm.render(scale);
            this.foxLeftArm.render(scale);
            this.foxRightLeg.render(scale);
            this.foxLeftLeg.render(scale);
            this.foxTail.render(scale);
            GlStateManager.popMatrix();
        }
        else
        {
            this.foxHead.render(scale);
            this.foxBody.render(scale);
            this.foxRightArm.render(scale);
            this.foxLeftArm.render(scale);
            this.foxRightLeg.render(scale);
            this.foxLeftLeg.render(scale);
            this.foxTail.render(scale);
        }
    }

    public void setLivingAnimations(@NotNull EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {

        EntityFox entityFox = (EntityFox)entitylivingbaseIn;

        if (entityFox.isAngry())
        {
            this.foxTail.rotateAngleY = 0.0F;
        }
        else
        {
            this.foxTail.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        }

        if (entityFox.isSitting()) {
            this.foxHead.offsetY = -0.05F;
            this.foxBody.rotateAngleX = -((float)Math.PI / 8F);
            this.foxBody.offsetY = 0.05F;
            this.foxRightLeg.rotateAngleX = -(float)Math.PI / 2;
            this.foxRightLeg.rotateAngleY = (float)Math.PI / 4;
            this.foxRightLeg.offsetX = -0.1F;
            this.foxRightLeg.offsetY = 0.05F;
            this.foxRightLeg.offsetZ = -0.25F;
            this.foxLeftLeg.rotateAngleX = -(float)Math.PI / 2;
            this.foxLeftLeg.rotateAngleY = -(float)Math.PI / 4;
            this.foxLeftLeg.offsetX = 0.1F;
            this.foxLeftLeg.offsetY = 0.05F;
            this.foxLeftLeg.offsetZ = -0.25F;
            this.foxTail.offsetY = 0.3F;
            this.foxTail.offsetZ = -0.1F;
        } else {
            this.foxBody.rotateAngleX = 0.0F;
            this.foxBody.offsetY = 0.0F;
            this.foxRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.foxLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.foxRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
            this.foxRightLeg.rotateAngleY = 0.0F;
            this.foxRightLeg.offsetX = 0.0F;
            this.foxRightLeg.offsetY = 0.0F;
            this.foxRightLeg.offsetZ = 0.0F;
            this.foxLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
            this.foxLeftLeg.rotateAngleY = 0.0F;
            this.foxLeftLeg.offsetX = 0.0F;
            this.foxLeftLeg.offsetY = 0.0F;
            this.foxLeftLeg.offsetZ = 0.0F;
            this.foxTail.offsetY = 0.0F;
            this.foxTail.offsetZ = 0.0F;
        }

        this.foxHead.rotateAngleZ = entityFox.getInterestedAngle(partialTickTime) + entityFox.getShakeAngle(partialTickTime, 0.0F);
        this.foxBody.rotateAngleZ = entityFox.getShakeAngle(partialTickTime, -0.16F);
        this.foxTail.rotateAngleZ = entityFox.getShakeAngle(partialTickTime, -0.1F);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, @NotNull Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.foxHead.rotateAngleX = headPitch * 0.017453292F;
        this.foxHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.foxTail.rotateAngleX = ageInTicks;
    }
}
