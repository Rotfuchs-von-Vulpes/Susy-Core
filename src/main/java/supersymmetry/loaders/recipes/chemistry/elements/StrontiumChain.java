package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.rotary_kiln_comburents;
import static supersymmetry.loaders.recipes.Utils.rotary_kiln_fuels;

public class StrontiumChain {
    public static void init() {
        GRAVITY_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, Celestine)
                .output(sifted, Celestine)
                .chancedOutput(dust, Limestone, 2500, 0)
                .chancedOutput(dust, Dolomite, 2500, 0)
                .EUt(30)
                .duration(40)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(sifted, Celestine, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(ImpureCelestineSlurry.getFluid(2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(ImpureCelestineSlurry.getFluid(2000))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .notConsumable(AlkalineSodiumOleateSolution.getFluid(100))
                .fluidOutputs(CelestineSlurry.getFluid(1000))
                .fluidOutputs(LimestoneTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(CelestineSlurry.getFluid(1000))
                .output(flotated, Celestine, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        for (Utils.Combustible fuel : rotary_kiln_fuels) {
            for (Utils.Comburent comburent : rotary_kiln_comburents) {
                ROTARY_KILN.recipeBuilder()
                        .input(flotated, Celestine)
                        .input("dustAnyPurityCarbon", 2)
                        .fluidInputs(fuel.fluid)
                        .fluidInputs(comburent.fluid)
                        .output(dust, ImpureStrontiumSulfide, 2)
                        .fluidOutputs(CarbonDioxide.getFluid(2025))
                        .EUt(30)
                        .duration(fuel.duration + comburent.duration)
                        .buildAndRegister();
            }
        }

        MIXER_RECIPES.recipeBuilder()
                .input(dust, ImpureStrontiumSulfide, 4)
                .fluidInputs(HeatedWater.getFluid(2000))
                .fluidOutputs(ImpureStrontiumSulfideSlurry.getFluid(2000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(ImpureStrontiumSulfideSlurry.getFluid(1000))
                .output(dust, SiliconDioxide)
                .fluidOutputs(StrontiumSulfideSolution.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .fluidInputs(StrontiumSulfideSolution.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(4000))
                .output(dust, StrontiumCarbonate, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(SodiumHydroxideSolution.getFluid(2000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, StrontiumCarbonate, 5)
                .output(dust, StrontiumOxide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Strontianite, 5)
                .output(dust, StrontiumOxide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium", 2)
                .input(dust, StrontiumOxide, 6)
                .output(dust, Strontium, 3)
                .output(dust, Alumina, 5)
                .EUt(120)
                .duration(100)
                .buildAndRegister();
    }
}
