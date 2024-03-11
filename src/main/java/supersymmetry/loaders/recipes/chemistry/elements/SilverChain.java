package supersymmetry.loaders.recipes.chemistry.elements;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.ANODE_SLIME_SILVER;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;

public class SilverChain {
    public static void init() {
        //ACANTHITE ROASTING (PRIMITIVE), (75%)
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Acanthite)
                .input(dustTiny, Calcite)
                .fluidInputs(Oxygen.getFluid(3000))
                .chancedOutput(dust, SilverOxide, 3, 7500, 0)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(60)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Acanthite)
                .input(dustTiny, Calcite)
                .fluidInputs(Air.getFluid(4500))
                .chancedOutput(dust, SilverOxide, 3, 7500, 0)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(60)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SilverSulfide, 3)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, SilverOxide, 3)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(60)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SilverSulfide, 3)
                .fluidInputs(Air.getFluid(4500))
                .output(dust, SilverOxide, 3)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(60)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SilverOxide, 3)
                .output(dust, Silver, 2)
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(120)
                .EUt(7)
                .buildAndRegister();

//CYANIDE LEACHING (UNIVERSAL)
//ACANTHITE (100%)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Acanthite)
                .input(dust, SodiumCyanide, 12)
                .fluidInputs(DistilledWater.getFluid(8000))
                .fluidOutputs(SulfidicSilverCyanideSolution.getFluid(8000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SulfidicSilverCyanideSolution.getFluid(400))
                .fluidInputs(HydrogenChloride.getFluid(200))
                .fluidOutputs(SilverCyanideSolution.getFluid(400))
                .fluidOutputs(HydrogenSulfide.getFluid(100))
                .duration(12)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(SilverCyanideSolution.getFluid(8000))
                .notConsumable(stick, Silver)
                .notConsumable(GRAPHITE_ELECTRODE)
                .output(dust, Silver, 2)
                .fluidOutputs(Chlorine.getFluid(2000))
                .fluidOutputs(SodiumCyanideSolution.getFluid(8000))
                .duration(480)
                .EUt(30)
                .buildAndRegister();

//PYRARGYRITE (90%)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Pyrargyrite)
                .input(dust, SodiumCyanide, 18)
                .fluidInputs(DistilledWater.getFluid(12000))
                .fluidOutputs(SulfidicPyrargyriteCyanideLeachSolution.getFluid(12000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfidicPyrargyriteCyanideLeachSolution.getFluid(12000))
                .fluidInputs(HydrogenChloride.getFluid(3000))
                .chancedOutput(dust, AntimonyIIISulfide, 5, 5000, 0)
                .fluidOutputs(PyrargyriteCyanideLeachSolution.getFluid(12000))
                .fluidOutputs(HydrogenSulfide.getFluid(1500))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(PyrargyriteCyanideLeachSolution.getFluid(12000))
                .notConsumable(stick, Silver)
                .notConsumable(GRAPHITE_ELECTRODE)
                .output(dust, Silver, 3)
                .fluidOutputs(Chlorine.getFluid(6000))
                .fluidOutputs(SodiumCyanideSolution.getFluid(12000))
                .duration(480)
                .EUt(30)
                .buildAndRegister();

//STEPHANITE (100%)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Stephanite)
                .input(dust, SodiumCyanide, 15)
                .fluidInputs(DistilledWater.getFluid(10000))
                .fluidOutputs(SulfidicStephaniteCyanideLeachSolution.getFluid(10000))
                .chancedOutput(dust, Stephanite, 5000, 0)
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfidicStephaniteCyanideLeachSolution.getFluid(10000))
                .fluidInputs(HydrogenChloride.getFluid(2500))
                .chancedOutput(dust, AntimonyIIISulfide, 5, 2500, 0)
                .fluidOutputs(StephaniteCyanideLeachSolution.getFluid(10000))
                .fluidOutputs(HydrogenSulfide.getFluid(1250))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(StephaniteCyanideLeachSolution.getFluid(20000))
                .notConsumable(stick, Silver)
                .notConsumable(GRAPHITE_ELECTRODE)
                .output(dust, Silver, 5)
                .fluidOutputs(Chlorine.getFluid(5000))
                .fluidOutputs(SodiumCyanideSolution.getFluid(20000))
                .duration(480)
                .EUt(30)
                .buildAndRegister();

//THIOSULFATE LEACHING (SPECIALIZED) (100%)
//PYRARGYRITE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Pyrargyrite, 7)
                .input(dust, SodiumThiosulfate, 42)
                .fluidInputs(DistilledWater.getFluid(5000))
                .fluidOutputs(PyrargyriteThiosulfateLeachSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfide, 9)
                .fluidInputs(PyrargyriteThiosulfateLeachSolution.getFluid(2000))
                .output(dust, SilverSulfide, 9)
                .fluidOutputs(ThiosulfateThioantimoniteSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ThiosulfateThioantimoniteSolution.getFluid(1000))
                .fluidInputs(IronIIIChlorideSolution.getFluid(1000))
                .output(dust, IronThioantimonite, 5)
                .fluidOutputs(SodiumThiosulfateSolution.getFluid(6000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, IronThioantimonite, 10)
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, AntimonyIIISulfide, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(3000))
                .fluidOutputs(DilutedIronIIIChlorideSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedIronIIIChlorideSolution.getFluid(3000))
                .output(dust, Iron3Chloride, 4)
                .fluidOutputs(Water.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//PROUSTITE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Proustite, 7)
                .input(dust, SodiumThiosulfate, 42)
                .fluidInputs(DistilledWater.getFluid(5000))
                .fluidOutputs(ProustiteThiosulfateLeachSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfide, 9)
                .fluidInputs(ProustiteThiosulfateLeachSolution.getFluid(2000))
                .output(dust, SilverSulfide, 9)
                .fluidOutputs(ThiosulfateThioarseniteSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ThiosulfateThioarseniteSolution.getFluid(1000))
                .fluidInputs(IronIIIChlorideSolution.getFluid(1000))
                .output(dust, IronThioarsenite, 5)
                .fluidOutputs(SodiumThiosulfateSolution.getFluid(6000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, IronThioarsenite, 10)
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, ArsenicIIISulfide, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(3000))
                .fluidOutputs(DilutedIronIIIChlorideSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//SILVER CHLORIDE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SilverChloride, 4)
                .input("dustAnyPurityZinc")
                .fluidInputs(DistilledWater.getFluid(1000))
                .notConsumable(SulfuricAcid.getFluid(10))
                .output(dust, Silver, 2)
                .fluidOutputs(ZincChlorideSolution.getFluid(1000))
                .duration(360)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(ZincChlorideSolution.getFluid(1000))
                .output(dust, ZincChloride, 3)
                .fluidOutputs(Water.getFluid(1000))
                .duration(100)
                .EUt(7)
                .buildAndRegister();

//SILVER NITRATE
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(SilverNitrateSolution.getFluid(1000))
                .fluidOutputs(DilutedSilverNitrateSolution.getFluid(1000))
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(stick, Silver)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(DilutedSilverNitrateSolution.getFluid(2000))
                .output(dust, Silver, 2)
                .fluidOutputs(NitricAcid.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(100)
                .EUt(7)
                .buildAndRegister();

//HIGH PURITY SILVER
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Silver, 3)
                .fluidInputs(NitricAcid.getFluid(4000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(SilverNitrateSolution.getFluid(2700))
                .fluidOutputs(NitricOxide.getFluid(1000))
                .duration(360)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(plate, Silver)
                .fluidInputs(SilverNitrateSolution.getFluid(250))
                .notConsumable(plate, StainlessSteel)
                .notConsumable(SilverNitrateSolution.getFluid(1000))
                .output(dust, HighPuritySilver)
                .output(ANODE_SLIME_SILVER)
                .fluidOutputs(SpentMoebiusElectrolyte.getFluid(250))
                .duration(480)
                .EUt(30)
                .buildAndRegister();

    }
}
