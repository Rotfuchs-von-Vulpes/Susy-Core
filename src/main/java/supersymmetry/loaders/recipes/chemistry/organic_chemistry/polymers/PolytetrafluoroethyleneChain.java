package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumSulfate;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolytetrafluoroethyleneChain {
    public static void init() {
        // PTFE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ChromiumTrioxide, 8)
                .fluidInputs(NOctanol.getFluid(1500))
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .fluidInputs(Acetone.getFluid(500))
                .fluidOutputs(CaprylicAcid.getFluid(1500))
                .fluidOutputs(ChromiumSulfateSolution.getFluid(500))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 18)
                .fluidInputs(ChromiumSulfateSolution.getFluid(500))
                .output(dust, ChromiumIIIHydroxide, 14)
                .fluidOutputs(SodiumSulfateAcetoneSolution.getFluid(500))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSulfateAcetoneSolution.getFluid(1000))
                .output(dust, SodiumSulfate, 42)
                .fluidOutputs(Water.getFluid(9000))
                .fluidOutputs(Acetone.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CaprylicAcid.getFluid(1000))
                .fluidInputs(ThionylChloride.getFluid(1000))
                .fluidOutputs(OctanoylChloride.getFluid(1000))
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(plate, Nickel)
                .notConsumable(plate, Cobalt)
                .fluidInputs(OctanoylChloride.getFluid(1000))
                .fluidInputs(HydrogenFluoride.getFluid(15000))
                .fluidOutputs(FluorinatedOctanoylChlorideMixture.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(15000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(FluorinatedOctanoylChlorideMixture.getFluid(1000))
                .fluidOutputs(PerfluorooctanoylFluoride.getFluid(150))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PerfluorooctanoylFluoride.getFluid(500))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(PerfluorooctanoicAcidMixture.getFluid(500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PerfluorooctanoicAcidMixture.getFluid(500))
                .output(dust, PerfluorooctanoicAcid, 13)
                .fluidOutputs(HydrofluoricAcid.getFluid(500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(500))
                .input(dust, PerfluorooctanoicAcid, 13)
                .fluidOutputs(FluorinatedSurfactantMixture.getFluid(500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Tetrafluoroethylene.getFluid(1000))
                .fluidInputs(FluorinatedSurfactantMixture.getFluid(500))
                .fluidOutputs(TetrafluoroethyleneEmulsion.getFluid(1500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(TetrafluoroethyleneEmulsion.getFluid(1500))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(PolytetrafluoroethyleneSolution.getFluid(500))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PolytetrafluoroethyleneSolution.getFluid(500))
                .output(dust, Polytetrafluoroethylene)
                .fluidOutputs(FluorinatedSurfactantMixture.getFluid(500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();
    }
}
