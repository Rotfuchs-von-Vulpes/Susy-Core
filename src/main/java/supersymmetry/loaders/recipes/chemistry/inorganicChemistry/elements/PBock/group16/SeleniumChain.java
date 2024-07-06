package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group16;

import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.ANODE_SLIME_COPPER;
import static supersymmetry.common.item.SuSyMetaItems.ANODE_SLIME_DECOPPERIZED;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.highPurityCombustibles;

public class SeleniumChain {
    public static void init() {
        // Composition of slime: 15% Se, 5% Te, 40% Ag/Au, 40% Cu
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(ANODE_SLIME_COPPER)
                .fluidInputs(SulfuricAcid.getFluid(400))
                .fluidInputs(Oxygen.getFluid(400))
                .output(ANODE_SLIME_DECOPPERIZED)
                .fluidOutputs(CopperSulfateSolution.getFluid(400))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(ANODE_SLIME_DECOPPERIZED, 5)
                .input(dust, SodaAsh, 6)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(CopperAnodeSlimePaste.getFluid(1000))
                .duration(600)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(CopperAnodeSlimePaste.getFluid(1000))
                .output(dust, SeleniumTelluriumConcentrate) // 0.75 Na2SeO4, 0.25 Na2TeO4, 2 Ag/Au
                .fluidOutputs(Steam.getFluid(1000))
                .duration(600)
                .EUt(120)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, SeleniumTelluriumConcentrate)
                .fluidInputs(DistilledWater.getFluid(750))
                .output(dust, TelluriumResidue) // 0.25 Na2TeO4, 2 Ag/Au
                .fluidOutputs(SodiumSelenateSolution.getFluid(750))
                .duration(600)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSelenateSolution.getFluid(50))
                .fluidInputs(HydrochloricAcid.getFluid(100))
                .fluidOutputs(SodiumSeleniteSolution.getFluid(200))
                .fluidOutputs(Chlorine.getFluid(100))
                .duration(30)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSeleniteSolution.getFluid(4000))
                .fluidInputs(SulfurDioxide.getFluid(2000))
                .output(dust, Selenium)
                .fluidOutputs(AcidicWastewater.getFluid(3000))
                .duration(6)
                .EUt(30)
                .buildAndRegister();

// Further refining

        HIGH_TEMPERATURE_DISTILLATION.recipeBuilder()
                .input(dust, Selenium)
                .fluidOutputs(Selenium.getFluid(60))
                .fluidOutputs(HighPuritySelenium.getFluid(72))
                //.chancedOutput(dust, Selenium, 4000, 0)
                //.chancedOutput(dust, HighPuritySelenium, 5000, 0)
                //.chancedOutputLogic(ChancedOutputLogic.XOR)
                .duration(500)
                .EUt(240)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(Selenium.getFluid(144))
                .output(dust, Selenium)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(HighPuritySelenium.getFluid(144))
                .output(dust, HighPuritySelenium)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Selenium)
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidOutputs(HydrogenSelenide.getFluid(1000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenSelenide.getFluid(1000))
                .chancedOutput(dust, HighPuritySelenium, 9900, 0)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();
    }
}
