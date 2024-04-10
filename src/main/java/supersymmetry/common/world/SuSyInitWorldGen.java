package supersymmetry.common.world;

import net.minecraft.world.WorldType;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import supersymmetry.common.world.SuSyWorldType;
import supersymmetry.common.world.SuSyWorldGen;

public class SuSyInitWorldGen {
    public static SuSyWorldType SuSyWorldType;
    public static void registerWorldGenerators()
    {
        SuSyWorldType = new SuSyWorldType();
        //GameRegistry.registerWorldGenerator(new SuSyWorldGen(), 10);
    }
}
