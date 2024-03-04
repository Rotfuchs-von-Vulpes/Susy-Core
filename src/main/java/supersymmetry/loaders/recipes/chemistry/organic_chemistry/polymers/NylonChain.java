package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.common.materials.SusyMaterials.*;

public class NylonChain {
    public static void init() {
        // Caprolactam

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(NitricOxide.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(150))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(Hydroxylamine.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Cyclohexane.getFluid(50))
                .fluidInputs(Oxygen.getFluid(100))
                .notConsumable(catalystBed, Cobalt)
                .fluidOutputs(Cyclohexanone.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Cyclohexanone.getFluid(1000))
                .fluidInputs(Hydroxylamine.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, CyclohexanoneOxime, 34)
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CyclohexanoneOxime, 34)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(AmmoniaSolution.getFluid(2000))
                .fluidOutputs(CaprolactamSolution.getFluid(3000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Cyclohexanone.getFluid(1000))
                .fluidInputs(Hydroxylamine.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(AmmoniaSolution.getFluid(2000))
                .output(dust, CyclohexanoneOxime, 34)
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(CaprolactamSolution.getFluid(3000))
                .duration(160)
                .EUt(480)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(CaprolactamSolution.getFluid(3000))
                .fluidInputs(Toluene.getFluid(1000))
                .fluidOutputs(ExtractedCaprolactamSolution.getFluid(1000))
                .fluidOutputs(DilutedAmmoniumSulfateSolution.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedAmmoniumSulfateSolution.getFluid(1000))
                .output(dust, AmmoniumSulfate, 15)
                .fluidOutputs(Water.getFluid(2000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(ExtractedCaprolactamSolution.getFluid(1000))
                .output(dust, Caprolactam)
                .fluidOutputs(Toluene.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumSulfate, 15)
                .fluidOutputs(Ammonia.getFluid(1000))
                .output(dust, AmmoniumBisulfate, 11)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Polycaprolactam

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .notConsumable(Nitrogen.getFluid(4000))
                .input(dust, Caprolactam)
                .output(dust, Polycaprolactam)
                .EUt(200)
                .duration(25)
                .buildAndRegister();
    }
}
