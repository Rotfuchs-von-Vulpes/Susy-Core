package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.DISTILLATION_RECIPES;
import static gregtech.api.recipes.RecipeMaps.DISTILLERY_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.sintering_fuels;

public class ChromiumChain {
    public static void init() {
        ADVANCED_ARC_FURNACE.recipeBuilder()
                .input(dust, Chromite)
                .input("dustAnyPurityCarbon", 4)
                .input(dustTiny, Quicklime)
                .output(dust, Ferrochromium, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(4000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        for (Utils.Combustible fuel : sintering_fuels) {
            if (!fuel.isPlasma) {
                ROTARY_KILN.recipeBuilder()
                        .input(dust, Chromite, 2)
                        .input(dust, SodaAsh, 24)
                        .fluidInputs(fuel.fluid)
                        .fluidInputs(Oxygen.getFluid(7010))
                        .output(dust, SodiumChromateMixture, 5)
                        .fluidOutputs(CarbonDioxide.getFluid(4000))
                        .duration(400)
                        .EUt(120)
                        .buildAndRegister();
            }
        }

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumChromateMixture, 10)
                .fluidInputs(DistilledWater.getFluid(8000))
                .output(dust, IronIIIOxide, 10)
                .fluidOutputs(SodiumChromateSolution.getFluid(8000))
                .duration(800)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumChromateSolution.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(SodiumDichromateSolution.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SodiumDichromateSolution.getFluid(1000))
                .output(dust, SodiumDichromate, 11)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityCarbon", 2)
                .input(dust, SodiumDichromate, 11)
                .output(dust, ChromiumSodaMixture, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ChromiumSodaMixture, 2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, ChromiumIIIOxide, 5)
                .fluidOutputs(SodaAshSolution.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ChromiumIIIHydroxide, 14)
                .output(dust, ChromiumIIIOxide, 5)
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium", 2)
                .input(dust, ChromiumIIIOxide, 5)
                .output(dust, Alumina, 5)
                .output(dust, Chrome, 2)
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(100))
                .fluidInputs(DilutedSulfuricAcid.getFluid(100))
                .fluidOutputs(AmmoniumSulfateSolution.getFluid(50))
                .EUt(120)
                .duration(5)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumSulfateSolution.getFluid(1000))
                .output(dust, AmmoniumSulfate, 15)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(120)
                .duration(5)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, Ferrochromium, 3)
                .input(dust, AmmoniumSulfate, 15)
                .fluidInputs(SulfuricAcid.getFluid(6000))
                .fluidInputs(DistilledWater.getFluid(750))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .fluidOutputs(DissolvedFerrochromium.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DissolvedFerrochromium.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(4000))
                .output(dust, CrudeAmmoniumIronIISulfate, 21)
                .fluidOutputs(AmmoniumChromeAlumSolution.getFluid(750))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DissolvedFerrochromium.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(4000))
                .fluidInputs(MohrMotherLiquor.getFluid(250))
                .output(dust, CrudeAmmoniumIronIISulfate, 21)
                .fluidOutputs(AmmoniumChromeAlumSolution.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CrudeAmmoniumIronIISulfate, 21)
                .fluidInputs(HeatedWater.getFluid(250))
                .fluidOutputs(CrudeAmmoniumIronIISulfateSolution.getFluid(250))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(CrudeAmmoniumIronIISulfateSolution.getFluid(250))
                .output(dust, AmmoniumIronIISulfate, 21)
                .fluidOutputs(MohrMotherLiquor.getFluid(250))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AmmoniumIronIISulfate, 21)
                .fluidInputs(HeatedWater.getFluid(1000))
                .fluidOutputs(AmmoniumIronIISulfateSolution.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniaSolution.getFluid(2000))
                .fluidInputs(CrudeAmmoniumIronIISulfateSolution.getFluid(1000))
                .output(dust, IronIIHydroxide, 5)
                .fluidOutputs(AmmoniumSulfateSolution.getFluid(2000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(WarmWater.getFluid(1000))
                .fluidInputs(AmmoniumChromeAlumSolution.getFluid(1000))
                .fluidOutputs(AgedAmmoniumChromeAlumSolution.getFluid(2000))
                .EUt(30)
                .duration(800)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(AgedAmmoniumChromeAlumSolution.getFluid(2000))
                .output(dust, AmmoniumChromeAlum, 12)
                .fluidOutputs(ChromiumMotherLiquor.getFluid(2000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HeatedWater.getFluid(1000))
                .input(dust, AmmoniumChromeAlum, 16)
                .fluidOutputs(PurifiedAmmoniumChromeAlumSolution.getFluid(1000))
                .EUt(30)
                .duration(800)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedAmmoniumChromeAlumSolution.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(400))
                .notConsumable(plate, StainlessSteel)
                .notConsumable(plate, Silver)
                .notConsumable(foil, Asbestos, 4)
                .chancedOutput(dust, ElectrolyticChromium, 8000, 0)
                .fluidOutputs(Oxygen.getFluid(1200))
                .fluidOutputs(ChromiumAnolyte.getFluid(100))
                .fluidOutputs(ChromiumCatholyte.getFluid(100))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(WarmWater.getFluid(1000))
                .fluidInputs(ChromiumCatholyte.getFluid(1000))
                .fluidOutputs(AgedAmmoniumChromeAlumSolution.getFluid(2000))
                .EUt(30)
                .duration(800)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ChromiumAnolyte.getFluid(100))
                .fluidInputs(SulfurDioxide.getFluid(150))
                .fluidOutputs(ReducedChromiumAnolyte.getFluid(100))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Ferrochromium, 3)
                .input(dust, AmmoniumSulfate, 15)
                .fluidInputs(ReducedChromiumAnolyte.getFluid(3000))
                .fluidInputs(SulfuricAcid.getFluid(6000))
                .fluidInputs(DistilledWater.getFluid(750))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .fluidOutputs(DissolvedFerrochromium.getFluid(2000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Ferrochromium, 3)
                .input(dust, AmmoniumSulfate, 15)
                .fluidInputs(ChromiumMotherLiquor.getFluid(8000))
                .fluidInputs(SulfuricAcid.getFluid(6000))
                .fluidInputs(DistilledWater.getFluid(750))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .fluidOutputs(DissolvedFerrochromium.getFluid(2000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(ElectrolyticChromium.getFluid(1440))
                .fluidOutputs(HighPurityChrome.getFluid(1440))
                .fluidOutputs(Oxygen.getFluid(144))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ChromiumTrioxide, 8)
                .output(dust, ChromiumIIIOxide, 5)
                .fluidOutputs(Oxygen.getFluid(3000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();
    }
}
