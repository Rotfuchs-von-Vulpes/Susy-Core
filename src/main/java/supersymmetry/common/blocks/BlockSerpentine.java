package supersymmetry.common.blocks;

import gregtech.api.block.VariantActiveBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.IStringSerializable;

public class BlockSerpentine extends VariantActiveBlock<BlockSerpentine.SerpentineType> {

    public BlockSerpentine() {
        super(Material.IRON);
        setTranslationKey("serpentine");
        setHardness(0.5f);
        setSoundType(SoundType.METAL);
        setHarvestLevel("wrench", 2);
        setDefaultState(getState(SerpentineType.BASIC));
    }

    public enum SerpentineType implements IStringSerializable {
        BASIC("basic");

        public final String name;

        SerpentineType(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.getName();
        }
    }
}
