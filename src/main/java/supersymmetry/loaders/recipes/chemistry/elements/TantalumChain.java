package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.api.fluids.SusyFluidStorageKeys;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.common.materials.SusyMaterials.*;
public class TantalumChain {
    public static void init() {
        // Beneficiation

// Tantalite

        GRAVITY_SEPARATOR_RECIPES.recipeBuilder() // Sifted Tantalite
                .input(dust, Tantalite)
                .output(sifted, Tantalite)
                .chancedOutput(dust, PegmatiteTailings, 2500, 0)
                .chancedOutput(dust, NetherQuartz, 2500, 0)
                .EUt(7)
                .duration(40)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder() // Tantalite Concentrate
                .input(sifted, Tantalite)
                .output(concentrate, Tantalite)
                .chancedOutput(dust, PegmatiteTailings, 2500, 0)
                .chancedOutput(dust, NetherQuartz, 2500, 0)
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder() // Impure Tantalite Slurry
                .input(concentrate, Tantalite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Tantalite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder() // Tantalite Slurry
                .notConsumable(dust, SodiumFluorosilicate)
                .fluidInputs(Tantalite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(OneAmidoethylTwoAlkylTwoImidazoline.getFluid(100))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .notConsumable(HydrochloricAcid.getFluid(100))
                .fluidOutputs(Tantalite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(1000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder() // Flotated Tantalite
                .fluidInputs(Tantalite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(flotated, Tantalite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder() // Impure Fluorotantalic Acid Solution
                .input(flotated, Tantalite, 1)
                .fluidInputs(HydrogenFluoride.getFluid(14000))
                .fluidInputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(ImpureFluorotantalicAcidSolution.getFluid(1000))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Tantalum-rich Extract
                .fluidInputs(ImpureFluorotantalicAcidSolution.getFluid(1000))
                .fluidInputs(MethylIsobutylKetone.getFluid(8000))
                .fluidOutputs(TantalumRichExtract.getFluid(8000))
                .fluidOutputs(MetalSulfateWaste.getFluid(1000))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Scrubbed Tantalum-rich Extract
                .fluidInputs(TantalumRichExtract.getFluid(500))
                .notConsumable(SulfuricAcid.getFluid(500))
                .fluidOutputs(ScrubbedTantalumRichExtract.getFluid(500))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Tantalum Extract
                .fluidInputs(ScrubbedTantalumRichExtract.getFluid(9000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(TantalumExtract.getFluid(9000))
                .fluidOutputs(PurifiedFluoroniobicAcidSolution.getFluid(1000))
                .duration(90)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Fluorotantalic Acid Solution
                .fluidInputs(TantalumExtract.getFluid(8000))
                .fluidInputs(DilutedAmmoniaSolution.getFluid(2000))
                .fluidOutputs(MethylIsobutylKetone.getFluid(8000))
                .fluidOutputs(FluorotantalicAcidSolution.getFluid(2000)) // 9/5 mol Ta
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder() // Potassium Heptafluorotantalate
                .input(dust, PotassiumFluoride, 18)
                .fluidInputs(FluorotantalicAcidSolution.getFluid(2500))
                .output(dust, PotassiumHeptafluorotantalate, 20)
                .chancedOutput(dust, PotassiumHeptafluorotantalate, 10, 2500, 0)
                .fluidOutputs(HydrofluoricAmmoniaMixture.getFluid(2500))
                .duration(90)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HydrofluoricAmmoniaMixture.getFluid(2500))
                .fluidOutputs(Water.getFluid(2500))
                .fluidOutputs(HydrogenFluoride.getFluid(9000))
                .fluidOutputs(Ammonia.getFluid(1250))
                .duration(90)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder() // Tantalum
                .input(dust, PotassiumHeptafluorotantalate, 10)
                .input("dustAnyPuritySodium", 5)
                .output(dust, Tantalum)
                .output(dust, SodiumFluoride, 10)
                .output(dust, PotassiumFluoride, 4)
                .duration(40)
                .EUt(120)
                .buildAndRegister();

// From columbite
        CENTRIFUGE_RECIPES.recipeBuilder() // Fluorotantalic Acid Solution
                .fluidInputs(DilutedTantalumExtract.getFluid(4500))
                .fluidInputs(DilutedAmmoniaSolution.getFluid(250))
                .fluidOutputs(MethylIsobutylKetone.getFluid(4500))
                .fluidOutputs(FluorotantalicAcidSolution.getFluid(250)) //0.2 mol of Ta per 8000L of dil. Ta ext.
                .duration(80)
                .EUt(120)
                .buildAndRegister();

// From pyrochlore
        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(TantalumPentachloride.getFluid(1000))
                .output(dust, TantalumPentachloride, 6)
                .duration(100)
                .EUt(7)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TantalumPentachloride, 6)
                .fluidInputs(HydrogenFluoride.getFluid(5000))
                .output(dust, TantalumFluoride, 6)
                .fluidOutputs(HydrogenChloride.getFluid(5000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, TantalumFluoride, 6)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(TantalumFluorideSolution.getFluid(2000))
                .duration(100)
                .EUt(7)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, PotassiumFluoride, 4)
                .fluidInputs(TantalumFluorideSolution.getFluid(2000))
                .output(dust, PotassiumHeptafluorotantalate, 10)
                .fluidOutputs(HydrofluoricAcid.getFluid(2000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();
    }
}
