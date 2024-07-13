package supersymmetry.common.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import org.jetbrains.annotations.NotNull;
import supersymmetry.common.world.SuSyChunkGeneratorOverworld;

public class SuSyWorldType extends WorldType {
    public SuSyWorldType() {
        super("SUSY");
    }

    @Override
    public @NotNull BiomeProvider getBiomeProvider(@NotNull World world)
    {
        return new BiomeProvider(world.getWorldInfo());
    }

    @Override
    public @NotNull IChunkGenerator getChunkGenerator(@NotNull World world, @NotNull String generatorOptions)
    {
        return new SuSyChunkGeneratorOverworld(world, world.getSeed(), generatorOptions);
    }
}
