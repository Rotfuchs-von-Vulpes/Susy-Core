package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group1;

import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.highPurityCombustibles;

public class CaesiumChain {
    public static void init() {

// From pollucite
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Pollucite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Pollucite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Pollucite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .fluidInputs(AluminiumSulfateSolution.getFluid(50))
                .notConsumable(CocoAmineAcetate.getFluid(1000))
                .notConsumable(SulfuricAcid.getFluid(100))
                .fluidOutputs(Pollucite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Pollucite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(dust, Pollucite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Pollucite)
                .fluidInputs(HotSulfuricAcid.getFluid(4000))
                .output(dust, SiliconDioxide, 12)
                .fluidOutputs(PolluciteLeach.getFluid(4000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(PolluciteLeach.getFluid(4000))
                .fluidOutputs(SodiumAlumSolution.getFluid(4000))
                .output(dust, CaesiumRubidiumAlumMixture)
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumAlumSolution.getFluid(4000))
                .output(dust, SodiumAlum, 12)
                .fluidOutputs(Water.getFluid(4000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, CaesiumRubidiumAlumMixture)
                .fluidOutputs(HeatedWater.getFluid(10000))
                .chancedOutput(dust, CaesiumAlum, 12, 9500, 0)
                .chancedOutput(dust, RubidiumAlum, 12, 500, 0)
                .EUt(30)
                .duration(800)
                .buildAndRegister();

// Refining into metal

        for (Utils.CarbonSource combustible : highPurityCombustibles) {
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, CaesiumAlum, 24)
                    .input(combustible.name.getItem(), combustible.equivalent(2))
                    .output(dust, CaesiumAluminaMixture, 8)
                    .fluidOutputs(CarbonDioxide.getFluid(2000))
                    .fluidOutputs(SulfurDioxide.getFluid(4000))
                    .EUt(30)
                    .duration(160 * combustible.duration)
                    .buildAndRegister();
        }

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, CaesiumAluminaMixture, 8)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, Alumina, 5)
                .fluidOutputs(CaesiumSulfateSolution.getFluid(1000))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, CaesiumAluminaMixture, 8)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, Alumina, 5)
                .fluidOutputs(CaesiumChlorideSolution.getFluid(3000))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(CaesiumChlorideSolution.getFluid(3000))
                .output(dust, CaesiumChloride, 4)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, CaesiumChloride, 4)
                .input(dust, Calcium)
                .output(dust, ReducedCaesiumMixture, 5)
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .input(dust, ReducedCaesiumMixture, 5)
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(Caesium.getFluid(288))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

// Caesium Formate (for drilling fluid)

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CaesiumSulfateSolution.getFluid(1000))
                .fluidInputs(CalciumHydroxideSolution.getFluid(1000))
                .output(dust, CalciumSulfate, 6)
                .fluidOutputs(CaesiumHydroxideSolution.getFluid(2000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(CaesiumHydroxideSolution.getFluid(50))
                .fluidInputs(FormicAcid.getFluid(50))
                .fluidOutputs(CaesiumFormateSolution.getFluid(100))
                .EUt(120)
                .duration(4)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(Caesium.getFluid(144))
                .output(dust, Caesium)
                .EUt(30)
                .duration(20)
                .buildAndRegister();
    }
}
