package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group2;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ROASTER_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.VACUUM_DISTILLATION_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.CalciumSulfate;
import static supersymmetry.common.materials.SusyMaterials.HighPurityCalcium;

public class CalciumChain {
    public static void init() {
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Gypsum, 8)
                .output(dust, CalciumSulfate, 6)
                .fluidOutputs(Steam.getFluid(2000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, CalciumSulfate, 6)
                .output(dust, Quicklime, 2)
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .input(dust, Calcium)
                .output(dust, HighPurityCalcium)
                .EUt(30)
                .duration(20)
                .buildAndRegister();
    }
}
