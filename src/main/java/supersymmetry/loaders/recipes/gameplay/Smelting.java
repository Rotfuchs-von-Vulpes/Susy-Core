package supersymmetry.loaders.recipes.gameplay;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

import static gregtech.api.unification.material.Materials.Iron;
import static gregtech.api.unification.ore.OrePrefix.dust;

public class Smelting {
    public static void init() {
        String[] oreDictSmeltingRemovals = {

                "oreIron",
                "oreNetherrackIron",
                "oreEndstoneIron",
                "crushedIron",
                "crushedPurifiedIron",
                "crushedCentrifugedIron",
                "dustImpureIron",
                "dustPureIron",

                "oreBandedIron",
                "oreNetherrackBandedIron",
                "oreEndstoneBandedIron",
                "crushedBandedIron",
                "crushedPurifiedBandedIron",
                "crushedCentrifugedBandedIron",
                "dustImpureBandedIron",
                "dustPureBandedIron",
                "dustBandedIron",

                "orePyrite",
                "oreNetherrackPyrite",
                "oreEndstonePyrite",
                "crushedPyrite",
                "crushedPurifiedPyrite",
                "crushedCentrifugedPyrite",
                "dustImpurePyrite",
                "dustPurePyrite",
                "dustPyrite",

                "oreYellowLimonite",
                "oreNetherrackYellowLimonite",
                "oreEndstoneYellowLimonite",
                "crushedYellowLimonite",
                "crushedPurifiedYellowLimonite",
                "crushedCentrifugedYellowLimonite",
                "dustImpureYellowLimonite",
                "dustPureYellowLimonite",
                "dustYellowLimonite",

                "oreBrownLimonite",
                "oreNetherrackBrownLimonite",
                "oreEndstoneBrownLimonite",
                "crushedBrownLimonite",
                "crushedPurifiedBrownLimonite",
                "crushedCentrifugedBrownLimonite",
                "dustImpureBrownLimonite",
                "dustPureBrownLimonite",
                "dustBrownLimonite",

                "oreMagnetite",
                "oreNetherrackMagnetite",
                "oreEndstoneMagnetite",
                "crushedMagnetite",
                "crushedPurifiedMagnetite",
                "crushedCentrifugedMagnetite",
                "dustImpureMagnetite",
                "dustPureMagnetite",
                "dustMagnetite",

                "oreGraniticMineralSand",
                "oreNetherrackGraniticMineralSand",
                "oreEndstoneGraniticMineralSand",
                "crushedGraniticMineralSand",
                "crushedPurifiedGraniticMineralSand",
                "crushedCentrifugedGraniticMineralSand",
                "dustImpureGraniticMineralSand",
                "dustPureGraniticMineralSand",
                "dustGraniticMineralSand",

                "oreBasalticMineralSand",
                "oreNetherrackBasalticMineralSand",
                "oreEndstoneBasalticMineralSand",
                "crushedBasalticMineralSand",
                "crushedPurifiedBasalticMineralSand",
                "crushedCentrifugedBasalticMineralSand",
                "dustImpureBasalticMineralSand",
                "dustPureBasalticMineralSand",
                "dustBasalticMineralSand"
        };

        for (String entry : oreDictSmeltingRemovals) {
            List<ItemStack> ores = OreDictionary.getOres(entry);

            for(ItemStack ore : ores) {
                ModHandler.removeFurnaceSmelting(ore);
            }
        }

        ModHandler.removeFurnaceSmelting(OreDictUnifier.get(dust, Iron));
    }
}
