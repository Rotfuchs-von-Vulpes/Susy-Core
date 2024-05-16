package supersymmetry.entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import supersymmetry.Supersymmetry;
import supersymmetry.client.renderer.entity.RenderFox;
import supersymmetry.entity.passive.EntityFox;

@Mod.EventBusSubscriber(modid = Supersymmetry.MODID)
public class SuSyEntityList {
    @SubscribeEvent
    public static void onEntityRegistry(RegistryEvent.Register<EntityEntry> event)
    {
        event.getRegistry().register(EntityEntryBuilder.create().entity(EntityFox.class)
                .id(new ResourceLocation(Supersymmetry.MODID, "fox"), 28)
                .name("fox")
                .tracker(80, 3, true)
                .spawn(EnumCreatureType.CREATURE, 2, 1, 3, EntityFox.POSSIBLE_BIOME_SPAWNS)
                .egg(0xff8700, 0xe1feff).build());
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityFox.class, RenderFox::new);
    }
}
