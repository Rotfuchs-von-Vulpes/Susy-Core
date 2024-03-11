package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ROASTER_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.BismuthIIIOxide;
import static supersymmetry.common.materials.SusyMaterials.Bismuthinite;
import static supersymmetry.loaders.recipes.Utils.highPurityCombustibles;

public class BismuthChain {
    public static void init() {
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Bismuthinite, 5)
                .fluidInputs(Oxygen.getFluid(9000))
                .output(dust, BismuthIIIOxide, 5)
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .EUt(120)
                .duration(120)
                .buildAndRegister();

        for (Utils.CarbonSource highPurityCombustible : highPurityCombustibles) {
            highPurityCombustible.name.setCount(highPurityCombustible.equivalent(3));
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, BismuthIIIOxide, 5)
                    .inputs(highPurityCombustible.name)
                    .output(dust, Bismuth, 2)
                    .fluidOutputs(CarbonMonoxide.getFluid(3000))
                    .EUt(120)
                    .duration(120)
                    .buildAndRegister();
        }
    }
}
