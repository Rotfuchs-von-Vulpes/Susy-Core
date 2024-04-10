package supersymmetry.common.world;

import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.StoneVariantBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import org.jetbrains.annotations.NotNull;
import supersymmetry.common.blocks.SuSyBlocks;
import supersymmetry.common.blocks.SusyStoneVariantBlock;

import static gregtech.common.blocks.StoneVariantBlock.StoneType.*;
import static supersymmetry.common.blocks.SusyStoneVariantBlock.StoneType.*;

public class SuSyMapGenStoneLayers {
    private static IBlockState getGTStone(StoneVariantBlock.StoneType stoneType) {
        return MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getState(stoneType);
    }
    private static IBlockState getSuSyStone(SusyStoneVariantBlock.StoneType stoneType) {
        return SuSyBlocks.SUSY_STONE_BLOCKS.get(SusyStoneVariantBlock.StoneVariant.SMOOTH).getState(stoneType);
    }
    public static void generate(@NotNull World worldIn, int x, int z, @NotNull ChunkPrimer primer) {
        for (int i = 0; i < 16; i++) for (int j = 0; j < 16; j++) {
            IBlockState stone = getSuSyStone(GNEISS);
            for (int k = 0; k < 175; k++) {
                if (k > 10) stone = getSuSyStone(PHYLLITE);
                if (k > 12) stone = getSuSyStone(QUARTZITE);
                if (k > 19) stone = getSuSyStone(GABBRO);
                if (k > 25) stone = getSuSyStone(PHYLLITE);
                if (k > 30) stone = getGTStone(MARBLE);
                if (k > 37) stone = getSuSyStone(SOAPSTONE);
                if (k > 40) stone = getSuSyStone(GABBRO);
                if (k > 43) stone = getGTStone(RED_GRANITE);
                if (k > 45) stone = getGTStone(BASALT);
                if (k > 52) stone = getSuSyStone(LIMESTONE);
                if (k > 55) stone = getSuSyStone(SLATE);
                if (k > 60) stone = getGTStone(MARBLE);
                if (k > 63) stone = getSuSyStone(LIMESTONE);
                if (k > 70) stone = getSuSyStone(SHALE);
                if (k > 73) stone = getSuSyStone(SLATE);
                if (k > 77) stone = getSuSyStone(LIMESTONE);
                if (k > 80) stone = getSuSyStone(SHALE);
                if (k > 87) stone = getSuSyStone(LIMESTONE);
                if (k > 95) stone = getSuSyStone(SLATE);
                if (k > 102) stone = getSuSyStone(LIMESTONE);
                if (k > 104) stone = getSuSyStone(SHALE);
                if (k > 110) stone = getSuSyStone(SLATE);
                assert Blocks.STONE != null;
                if (primer.getBlockState(i, k, j) == Blocks.STONE.getDefaultState())
                    primer.setBlockState(i, k, j, stone);
            }
        }
    }
}
