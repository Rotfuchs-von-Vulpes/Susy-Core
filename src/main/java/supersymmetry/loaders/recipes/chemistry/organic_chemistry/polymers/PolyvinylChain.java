package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolyvinylChain {
    public static void init() {
        // Vinyl Chloride

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Mercury.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, MercuryIIChloride, 3)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, MercuryIIChloride)
                .fluidInputs(Acetylene.getFluid(50))
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(VinylChloride.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(100))
                .fluidInputs(Ethylene.getFluid(50))
                .fluidOutputs(VinylChloride.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(50))
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidInputs(Oxygen.getFluid(50))
                .fluidOutputs(VinylChloride.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ethane.getFluid(50))
                .fluidInputs(Chlorine.getFluid(200))
                .fluidOutputs(VinylChloride.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(150))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ethane.getFluid(50))
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidInputs(Oxygen.getFluid(100))
                .fluidOutputs(VinylChloride.getFluid(50))
                .fluidOutputs(Water.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// PVC

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(VinylChloride.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(VinylChlorideSuspension.getFluid(2000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(VinylChlorideSuspension.getFluid(2000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(PolyvinylChlorideSuspension.getFluid(2000))
                .duration(300)
                .EUt(60)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PolyvinylChlorideSuspension.getFluid(2000))
                .output(dust, PolyvinylChloride)
                .fluidOutputs(Water.getFluid(1000))
                .duration(260)
                .EUt(30)
                .buildAndRegister();

// Polyvinyl Acetate

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(VinylAcetate.getFluid(1000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(VinylAcetateSuspension.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(VinylAcetateSuspension.getFluid(2000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(PolyvinylAcetateSuspension.getFluid(2000))
                .duration(150)
                .EUt(60)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(PolyvinylAcetateSuspension.getFluid(2000))
                .output(dust, PolyvinylAcetate)
                .fluidOutputs(Methanol.getFluid(1000))
                .duration(50)
                .buildAndRegister();

// Ethylene-vinyl acetate

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(VinylAcetateSuspension.getFluid(1000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(EthyleneVinylAcetateSuspension.getFluid(2000))
                .duration(150)
                .EUt(60)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(EthyleneVinylAcetateSuspension.getFluid(2000))
                .output(dust, EthyleneVinylAcetate)
                .fluidOutputs(Methanol.getFluid(1000))
                .duration(50)
                .buildAndRegister();
    }
}
