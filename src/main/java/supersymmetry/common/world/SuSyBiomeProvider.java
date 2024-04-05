package supersymmetry.common.world;

import biomesoplenty.api.generation.Generators;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;

public class SuSyBiomeProvider extends BiomeProvider {
    public SuSyBiomeProvider(long seed, WorldType worldType, String chunkProviderSettings) {
        super();

        GenLayer[] agenlayer = GenLayer.initializeAllBiomeGenerators(seed, worldType, this.settings);
        agenlayer = getModdedBiomeGenerators(worldType, seed, agenlayer);
        this.genBiomes = agenlayer[0];
        this.biomeIndexLayer = agenlayer[1];
    }
    public SuSyBiomeProvider(World world) {
        this(world.getSeed(), world.getWorldInfo().getTerrainType(), world.getWorldInfo().getGeneratorOptions());
    }
}
