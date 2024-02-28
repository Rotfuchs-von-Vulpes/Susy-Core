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
        SMOKE_STACK.recipeBuilder()
                .fluidInputs(CarbonDioxide.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(Steam.getFluid(4000))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(SulfurTrioxide.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(SulfurDioxide.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(NitricOxide.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(NitrogenDioxide.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(HydrogenSulfide.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(Nitrogen.getFluid(10000))
                .duration(5)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(5000))
                .duration(5)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(ExhaustSteam.getFluid(1000))
                .duration(2)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(FlueGas.getFluid(1000))
                .duration(2)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(CoalGas.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(DesulfurizedFlueGas.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(UnscrubbedWoodGas.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(ChilledFlueGas.getFluid(1000))
                .duration(2)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(SourGas.getFluid(500))
                .duration(20)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(NitrosylChloride.getFluid(500))
                .duration(10)
                .buildAndRegister();

        SMOKE_STACK.recipeBuilder()
                .fluidInputs(CarbonTetrachloride.getFluid(500))
                .duration(10)
                .buildAndRegister();

        FLARE_STACK.recipeBuilder()
                .fluidInputs(LubricatingOil.getFluid(500))
                .duration(10)
                .buildAndRegister();

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

        DUMPING.recipeBuilder()
                .fluidInputs(AshSlurry.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(RedMud.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(ConcentratedRedMud.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(ChilledLava.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(CoalTar.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .duration(5)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(SeaWater.getFluid(1000))
                .duration(5)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(SaltWater.getFluid(1000))
                .duration(5)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(AmmoniaSolution.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(CrudePyridiniumSulfate.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(NaphthaleneOil.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(AnthraceneOil.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Triethylenetetramine.getFluid(100))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Aminoethylpiperazine.getFluid(50))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Diethylenetriamine.getFluid(300))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Ethylenediamine.getFluid(500))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Piperazine.getFluid(50))
                .duration(20)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Wastewater.getFluid(5000))
                .duration(4)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(MetalSulfateWaste.getFluid(1000))
                .duration(20)
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
