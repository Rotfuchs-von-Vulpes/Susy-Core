package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.DISTILLATION_RECIPES;
import static gregtech.api.unification.material.Materials.BisphenolA;
import static gregtech.api.unification.material.Materials.SaltWater;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolycarbonateChain {
    public static void init() {
        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Phosgene.getFluid(50))
                .fluidInputs(Dichloromethane.getFluid(50))
                .fluidOutputs(PhosgeneSolution.getFluid(100))
                .EUt(480)
                .duration(3)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(100))
                .fluidInputs(BisphenolA.getFluid(50))
                .fluidOutputs(SodiumBisphenolateSolution.getFluid(100))
                .EUt(480)
                .duration(3)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(PhosgeneSolution.getFluid(100))
                .fluidInputs(SodiumBisphenolateSolution.getFluid(100))
                .fluidOutputs(OligomericBisphenolSolution.getFluid(50))
                .fluidOutputs(SaltWater.getFluid(100))
                .EUt(480)
                .duration(3)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(OligomericBisphenolSolution.getFluid(4000))
                .fluidInputs(Triethylamine.getFluid(1000))
                .output(dust, Polycarbonate, 8)
                .fluidOutputs(TriethylamineSolution.getFluid(5000))
                .EUt(480)
                .duration(60)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(TriethylamineSolution.getFluid(5000))
                .fluidOutputs(Triethylamine.getFluid(1000))
                .fluidOutputs(Dichloromethane.getFluid(4000))
                .EUt(480)
                .duration(60)
                .buildAndRegister();
    }
}
