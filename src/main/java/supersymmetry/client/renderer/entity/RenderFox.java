package supersymmetry.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import supersymmetry.Supersymmetry;
import supersymmetry.client.model.ModelFox;
import supersymmetry.entity.passive.EntityFox;

@SideOnly(Side.CLIENT)
public class RenderFox extends RenderLiving<EntityFox> {
    private static final ResourceLocation FOX_TEXTURES = new ResourceLocation(Supersymmetry.MODID, "textures/entities/fox.png");

    public RenderFox(RenderManager rendermanagerIn) {
        super(rendermanagerIn, new ModelFox(), 0.5F);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityFox livingBase, float partialTicks)
    {
        return livingBase.getTailRotation();
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityFox entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        if (entity.isFoxWet())
        {
            float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
            GlStateManager.color(f, f, f);
        }

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(@NotNull EntityFox entity) {
        return FOX_TEXTURES;
    }
}
