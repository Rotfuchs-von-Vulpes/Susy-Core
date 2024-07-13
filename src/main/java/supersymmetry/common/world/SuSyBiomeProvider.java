package supersymmetry.common.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.layer.GenLayer;

public class SuSyBiomeProvider extends BiomeProvider {
    public SuSyBiomeProvider(long seed, WorldType worldType) {
        super();

//        this.settings = ChunkGeneratorSettings.Factory.jsonToFactory("").build();
//
//        GenLayer[] agenlayer = GenLayer.initializeAllBiomeGenerators(seed, worldType, this.settings);
//        agenlayer = getModdedBiomeGenerators(worldType, seed, agenlayer);
//        this.genBiomes = agenlayer[0];
//        this.biomeIndexLayer = agenlayer[1];
    }
    public SuSyBiomeProvider(World world) {
        this(world.getSeed(), world.getWorldInfo().getTerrainType());
    }
}
