package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group17;

import static gregtech.api.recipes.RecipeMaps.DISTILLERY_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.stick;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ELECTROLYTIC_CELL_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ROASTER_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.*;

public class FluorineChain {
    public static void init() {
        //POTASSIUM FLUORIDE PRODUCTION
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PotassiumCarbonate, 6)
                .fluidInputs(HydrofluoricAcid.getFluid(2000))
                .fluidOutputs(PotassiumFluorideSolution.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumFluorideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, PotassiumFluoride, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//HYDROFLUORIC ACID ELECTROLYSIS
        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Platinum)
                .notConsumable(PotassiumFluoride.getFluid(1152))
                .fluidInputs(HydrogenFluoride.getFluid(2000))
                .fluidOutputs(Fluorine.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(120)
                .duration(720)
                .buildAndRegister();
    }
}
