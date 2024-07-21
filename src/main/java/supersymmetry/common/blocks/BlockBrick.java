package supersymmetry.common.blocks;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BlockBrick extends VariantBlock<BlockBrick.BrickType> {
    public BlockBrick() {
        super(Material.ROCK);
        this.setTranslationKey("brazilian_bricks");
        this.setHardness(1.0f);
        this.setSoundType(SoundType.STONE);
        this.setHarvestLevel("pickaxe", 1);
        this.setDefaultState(getState(BrickType.NORMAL));
    }

    public enum BrickType implements IStringSerializable {
        NORMAL("bricks");
        public final String name;
        BrickType(String name) {this.name = name;}

        @NotNull
        @Override
        public String getName() {
            return this.name;
        }
        public String toString() {
            return this.getName();
        }
    }
}
