package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group2;

import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.rotary_kiln_comburents;
import static supersymmetry.loaders.recipes.Utils.rotary_kiln_fuels;

public class BariumChain {
    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Barite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Barite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Barite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .notConsumable(LauricAcid.getFluid(100))
                .fluidOutputs(Barite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Barite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(dust, Barite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(GraniteTailingSlurry.getFluid(1000))
                .output(dust, GraniteTailings, 2)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        for (Utils.Combustible fuel : rotary_kiln_fuels) {
            for (Utils.Comburent comburent : rotary_kiln_comburents) {
                ROTARY_KILN.recipeBuilder()
                        .input(dust, Barite)
                        .input("dustAnyPurityCarbon", 2)
                        .fluidInputs(fuel.fluid)
                        .fluidInputs(comburent.fluid)
                        .output(dust, ImpureBariumSulfide, 2)
                        .fluidOutputs(CarbonDioxide.getFluid(2025))
                        .EUt(30)
                        .duration(fuel.duration + comburent.duration)
                        .buildAndRegister();
            }
        }

        MIXER_RECIPES.recipeBuilder()
                .input(dust, ImpureBariumSulfide, 4)
                .fluidInputs(HeatedWater.getFluid(1000))
                .output(dust, BariumResidue, 2)
                .fluidOutputs(ImpureBariumSulfideSolution.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BariumResidue, 2)
                .fluidInputs(HeatedWater.getFluid(1000))
                .fluidInputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(ImpureBariumSulfideSolution.getFluid(1000))
                .output(dust, SiliconDioxide)
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(ImpureBariumSulfideSolution.getFluid(1000))
                .output(dust, BariumSulfide, 2)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BariumSulfide, 2)
                .input(dust, SodaAsh, 6)
                .fluidInputs(DistilledWater.getFluid(4000))
                .output(dust, BariumCarbonate, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(SodiumHydroxideSolution.getFluid(2000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BariumSulfide, 2)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(2000))
                .output(dust, BariumCarbonate, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BariumCarbonate, 5)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(BariumChlorideSolution.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(BariumChlorideSolution.getFluid(1000))
                .output(dust, BariumChloride, 3)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium", 2)
                .input(dust, BariumOxide, 6)
                .output(dust, Barium, 3)
                .output(dust, Alumina, 5)
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Witherite, 5)
                .output(dust, BariumOxide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, BariumCarbonate, 5)
                .output(dust, BariumOxide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();
    }
}
