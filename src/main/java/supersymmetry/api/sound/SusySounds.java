package supersymmetry.api.sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import supersymmetry.Supersymmetry;

public class SusySounds {

    public static SoundEvent ROCKET_LOOP;
    public static SoundEvent DRONE_TAKEOFF;
    public static SoundEvent FOX_AGGRO;
    public static SoundEvent FOX_BITE;
    public static SoundEvent FOX_DEATH;
    public static SoundEvent FOX_EAT;
    public static SoundEvent FOX_HURT;
    public static SoundEvent FOX_IDLE;
    public static SoundEvent FOX_SCREECH;
    public static SoundEvent FOX_SLEEP;
    public static SoundEvent FOX_SNIFF;

    public static void registerSounds() {
        ROCKET_LOOP = registerSound("entity.rocket_loop");
        DRONE_TAKEOFF = registerSound("entity.drone_takeoff");

        FOX_AGGRO = registerSound("entity.fox_aggro");
        FOX_BITE = registerSound("entity.fox_bite");
        FOX_DEATH = registerSound("entity.fox_death");
        FOX_EAT = registerSound("entity.fox_eat");
        FOX_HURT = registerSound("entity.fox_hurt");
        FOX_IDLE = registerSound("entity.fox_idle");
        FOX_SCREECH = registerSound("entity.fox_screech");
        FOX_SLEEP = registerSound("entity.fox_sleep");
        FOX_SNIFF = registerSound("entity.fox_sniff");
    }

    private static SoundEvent registerSound(String soundNameIn) {
        ResourceLocation location = new ResourceLocation(Supersymmetry.MODID, soundNameIn);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(location);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
