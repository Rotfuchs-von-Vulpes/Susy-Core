package supersymmetry.loaders.recipes.chemistry;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.stick;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumChlorate;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ELECTROLYTIC_CELL_RECIPES;

public class ElectrolysisOverhaul {
    public static void init() {
        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Iron)
                .fluidInputs(PotassiumBisulfate.getFluid(2016))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .output(dust, PotassiumPersulfate, 12)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Iron)
                .fluidInputs(Water.getFluid(4000))
                .input(dust, Salt, 2)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .fluidOutputs(SodiumChlorateSolution.getFluid(1000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumChlorateSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .outputs(SodiumChlorate.getItemStack(5))
                .EUt(16)
                .duration(100)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .duration(1500)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .notConsumable(SodiumHydroxideSolution.getFluid(50))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .duration(400)
                .buildAndRegister();

//CHLOROALKALI PROCESS
        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(SaltWater.getFluid(2000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(Chlorine.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .fluidOutputs(SodiumHydroxideSolution.getFluid(1000))
                .EUt(30)
                .duration(720)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(PotassiumChlorideSolution.getFluid(2000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(Chlorine.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .fluidOutputs(DilutedRockSaltSolution.getFluid(2000))
                .fluidOutputs(PotassiumHydroxideSolution.getFluid(1000))
                .EUt(30)
                .duration(720)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSaltwater.getFluid(2000))
                .fluidOutputs(SaltWater.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(16)
                .duration(60)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, SodiumHydroxide, 3)
                .EUt(16)
                .duration(60)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, PotassiumHydroxide, 3)
                .EUt(16)
                .duration(60)
                .buildAndRegister();

//CASTNER PROCESS
        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxide.getFluid(432))
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .output(dust, Sodium)
                .fluidOutputs(Oxygen.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .duration(200)
                .EUt(60)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .notConsumable(RockSalt.getFluid(144))
                .notConsumable(PotassiumCarbonate.getFluid(14))
                .input(dust, PotassiumHydroxide, 6)
                .output(dust, Potassium, 2)
                .fluidOutputs(Oxygen.getFluid(1000))
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(30)
                .duration(600)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .fluidInputs(RockSalt.getFluid(288))
                .notConsumable(PotassiumFluoride.getFluid(144))
                .fluidOutputs(Chlorine.getFluid(1000))
                .output(dust, Potassium)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

//DOWNS CELL PROCESSES
        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .fluidInputs(Salt.getFluid(288))
                .fluidOutputs(Chlorine.getFluid(1000))
                .output(dust, Sodium)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Steel)
                .fluidInputs(CalciumChloride.getFluid(432))
                .fluidOutputs(Chlorine.getFluid(2000))
                .output(dust, Calcium)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Steel)
                .fluidInputs(MagnesiumChloride.getFluid(432))
                .fluidOutputs(Chlorine.getFluid(2000))
                .output(dust, Magnesium)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Steel)
                .fluidInputs(PurifiedMagnesiumChloride.getFluid(432))
                .fluidOutputs(Chlorine.getFluid(2000))
                .output(dust, HighPurityMagnesium)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Iron)
                .fluidInputs(Iron3Chloride.getFluid(576))
                .fluidOutputs(Chlorine.getFluid(3000))
                .output(dust, Iron)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Zinc)
                .fluidInputs(ZincChloride.getFluid(432))
                .fluidOutputs(Chlorine.getFluid(2000))
                .output(dust, Zinc)
                .EUt(30)
                .duration(300)
                .buildAndRegister();
    }
}
