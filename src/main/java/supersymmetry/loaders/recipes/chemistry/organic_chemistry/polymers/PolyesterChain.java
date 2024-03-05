package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import gregtech.api.unification.OreDictUnifier;

import static gregtech.api.recipes.RecipeMaps.EXTRUDER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.foil;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BATCH_REACTOR_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.POLYMERIZATION_RECIPES;
import static supersymmetry.api.unification.ore.SusyOrePrefix.fiber;
import static supersymmetry.common.item.SuSyMetaItems.MYLAR;
import static supersymmetry.common.item.SuSyMetaItems.SPINNERET;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolyesterChain {
    public static void init() {
        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidInputs(TerephthalicAcid.getFluid(2592))
                .output(dust, PolyethyleneTerephthalate, 2)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CobaltOxide, 2)
                .fluidInputs(AceticAcid.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(3000))
                .output(dust, CobaltIIAcetate, 18)
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .notConsumable(dust, CobaltIIAcetate)
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidInputs(DimethylTerephthalate.getFluid(3456))
                .output(dust, PolyethyleneTerephthalate, 2)
                .fluidOutputs(Methanol.getFluid(2000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .notConsumable(SPINNERET)
                .fluidInputs(PolyethyleneTerephthalate.getFluid(144))
                .output(fiber, PolyethyleneTerephthalate, 8)
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .input(foil, PolyethyleneTerephthalate)
                .output(MYLAR)
                .EUt(120)
                .duration(10)
                .buildAndRegister();

        OreDictUnifier.registerOre(MYLAR.getStackForm(), "foilMylar");
    }
}
