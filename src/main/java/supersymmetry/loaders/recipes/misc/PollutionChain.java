package supersymmetry.loaders.recipes.misc;

import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.SIFTER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustTiny;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PollutionChain {
    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(100))
                .input(dustTiny, Ash)
                .fluidOutputs(AshSlurry.getFluid(100))
                .duration(5)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(100))
                .input(dustTiny, DarkAsh)
                .fluidOutputs(AshSlurry.getFluid(100))
                .duration(5)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, Ash)
                .fluidOutputs(AshSlurry.getFluid(1000))
                .duration(40)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, DarkAsh)
                .fluidOutputs(AshSlurry.getFluid(1000))
                .duration(40)
                .EUt(7)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .fluidInputs(FlueGas.getFluid(16000))
                .input(dust, Calcite, 5)
                .fluidOutputs(DesulfurizedFlueGas.getFluid(16000))
                .output(dust, CalciumSulfite, 5)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, CalciumSulfite, 5)
                .circuitMeta(1)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .output(dust, Quicklime, 2)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Air.getFluid(1500))
                .input(dust, CalciumSulfite, 5)
                .output(dust, CalciumSulfate, 6)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(1000))
                .input(dust, CalciumSulfite, 5)
                .output(dust, CalciumSulfate, 6)
                .duration(80)
                .EUt(30)
                .buildAndRegister();
    }
}
