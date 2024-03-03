package supersymmetry.loaders.recipes.chemistry;

import static gregtech.api.recipes.RecipeMaps.ELECTROLYZER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.LARGE_CHEMICAL_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.stick;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ELECTROLYTIC_CELL_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.*;

public class DeuteriumChain {
    public static void init() {
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenSulfide.getFluid(2000))
                .fluidInputs(SeaWater.getFluid(128000))
                .fluidOutputs(ImpureSemiheavyWater.getFluid(128000))
                .fluidOutputs(IsotopicallyPureHydrogenSulfide.getFluid(2000))
                .circuitMeta(3)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ImpureSemiheavyWater.getFluid(128000))
                .fluidInputs(IsotopicallyPureHydrogenSulfide.getFluid(2000))
                .fluidOutputs(ImpureSemiheavyHydrogenSulfide.getFluid(2000))
                .fluidOutputs(SaltWater.getFluid(128000))
                .circuitMeta(1)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ImpureSemiheavyHydrogenSulfide.getFluid(2000))
                .fluidInputs(ImpureSemiheavyWater.getFluid(1000))
                .fluidOutputs(SemiHeavyHydrogenSulfide.getFluid(2000))
                .fluidOutputs(Steam.getFluid(1000))
                .circuitMeta(2)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ImpureSemiheavyHydrogenSulfide.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(ImpureSemiheavyWater.getFluid(1000))
                .fluidOutputs(HydrogenSulfide.getFluid(2000))
                .circuitMeta(1)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(SemiHeavyHydrogenSulfide.getFluid(2000))
                .fluidInputs(SemiHeavyWater.getFluid(1000))
                .fluidOutputs(ImpureHeavyHydrogenSulfide.getFluid(2000))
                .fluidOutputs(DistilledWater.getFluid(1000))
                .circuitMeta(2)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(SemiHeavyHydrogenSulfide.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(SemiHeavyWater.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(2000))
                .circuitMeta(1)
                .EUt(480)
                .duration(1000)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ImpureHeavyHydrogenSulfide.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(HeavyWater.getFluid(1000))
                .fluidOutputs(ImpureSemiheavyHydrogenSulfide.getFluid(2000))
                .circuitMeta(1)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .fluidInputs(HeavyWater.getFluid(1000))
                .fluidOutputs(Deuterium.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .duration(1500)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Nickel)
                .notConsumable(stick, Iron)
                .notConsumable(SodiumHydroxideSolution.getFluid(50))
                .fluidInputs(HeavyWater.getFluid(1000))
                .fluidOutputs(Deuterium.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

    }
}
