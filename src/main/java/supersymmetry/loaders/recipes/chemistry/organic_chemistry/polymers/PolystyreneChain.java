package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.DISTILLATION_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolystyreneChain {
    public static void init() {
        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ethylbenzene.getFluid(50))
                .fluidInputs(Steam.getFluid(50))
                .notConsumable(catalystBed, IronIIIOxide)
                .fluidOutputs(CrudeStyrene.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(90))
                .duration(2)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrudeStyrene.getFluid(1000))
                .fluidOutputs(Styrene.getFluid(900))
                .fluidOutputs(Ethylbenzene.getFluid(100))
                .duration(30)
                .EUt(30)
                .buildAndRegister();

// Polysterene

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Styrene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(StyreneSuspension.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(StyreneSuspension.getFluid(2000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(PolystyreneSuspension.getFluid(2000))
                .duration(300)
                .EUt(60)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PolystyreneSuspension.getFluid(2000))
                .output(dust, Polystyrene)
                .fluidOutputs(Water.getFluid(1000))
                .duration(260)
                .EUt(30)
                .buildAndRegister();

// Polystyrene Sulfonate
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Polystyrene.getFluid(2304))
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .fluidOutputs(PolystyreneSulfonate.getFluid(2304))
                .duration(300)
                .EUt(30)
                .buildAndRegister();
    }
}
