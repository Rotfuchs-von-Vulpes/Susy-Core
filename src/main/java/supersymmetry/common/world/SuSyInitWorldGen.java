package supersymmetry.common.world;

import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SuSyInitWorldGen {
    public static final WorldType CLOUD_WORLD_TYPE = new SuSyWorldType();
    public static void registerWorldGenerators()
    {
        GameRegistry.registerWorldGenerator(new SuSyWorldGen(), 10);
    }
}
