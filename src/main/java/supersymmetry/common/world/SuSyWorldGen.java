package supersymmetry.common.world;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class SuSyWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider)
    {
        // DEBUG
        // System.out.println("Calling custom world generator");
        // It is important to convert the passed in chunk coordinates to
        // world coordinates.
        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;
        // generate differently based on dimension
        switch (world.provider.getDimensionType().getId())
        {
            case -1:
                generateNether(world, random, blockX, blockZ);
                break;
            case 0:
                generateOverworld(world, random, blockX, blockZ);
                break;
            case 1:
                generateEnd(world, random, blockX, blockZ);
                break;
        }

    }

    private void generateOverworld(World world, Random random, int blockX, int blockZ)
    {
        // TODO Auto-generated method stub

    }

    private void generateEnd(World world, Random random, int blockX, int blockZ)
    {
        // TODO Auto-generated method stub

    }

    private void generateNether(World world, Random random, int blockX, int blockZ)
    {
        // TODO Auto-generated method stub

    }
}
