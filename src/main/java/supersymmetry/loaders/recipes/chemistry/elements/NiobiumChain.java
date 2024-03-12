package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.api.fluids.SusyFluidStorageKeys;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.Materials.Pyrochlore;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class NiobiumChain {
    public static void init() {
        // Beneficiation

// Pyrochlore
// EM Sep, FF, roast with CaO/CaCl2, calcine with H2SO4

        GRAVITY_SEPARATOR_RECIPES.recipeBuilder() // Sifted Pyrochlore
                .input(dust, Pyrochlore)
                .output(sifted, Pyrochlore)
                .chancedOutput(dust, LimestoneTailings, 2500, 0)
                .chancedOutput(dust, Calcite, 2500, 0)
                .EUt(30)
                .duration(40)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder() // Pyrochlore Concentrate
                .input(sifted, Pyrochlore)
                .output(concentrate, Pyrochlore)
                .chancedOutput(dust, LimestoneTailings, 2500, 0)
                .chancedOutput(dust, Calcite, 2500, 0)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder() // Impure Pyrochlore Slurry
                .input(concentrate, Pyrochlore, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Pyrochlore.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder() // Pyrochlore Slurry
                .notConsumable(dust, OxalicAcid)
                .fluidInputs(Pyrochlore.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(HexafluorosilicicAcid.getFluid(100))
                .notConsumable(OneAmidoethylTwoAlkylTwoImidazoline.getFluid(100))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .fluidOutputs(Pyrochlore.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(LimestoneTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder() // Flotated Pyrochlore
                .fluidInputs(Pyrochlore.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(flotated, Pyrochlore, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder() // Roasted Pyrochlore
                .input(flotated, Pyrochlore, 16)
                .input(dust, Quicklime)
                .output(dust, RoastedPyrochlore, 16)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder() // Digested Pyrochlore
                .input(dust, RoastedPyrochlore, 16)
                .fluidInputs(HotSulfuricAcid.getFluid(1000))
                .output(dust, DigestedPyrochlore, 16)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder() // Ferroniobium-tantalum
                .input(dust, IronIIIOxide, 15)
                .input(dust, DigestedPyrochlore, 7)
                .input("dustAnyPurityAluminium", 42)
                .fluidInputs(SodiumNitrate.getFluid(720))
                .output(dust, FerroniobiumTantalum, 20)
                .output(dust, Alumina, 105)
                .output(dust, Calcium, 14)
                .fluidOutputs(SodiumNitrite.getFluid(720))
                .duration(800)
                .EUt(1920)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(SodiumNitrite.getFluid(144))
                .output(dust, SodiumNitrite)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder() // Impure Niobium Pentachloride
                .input(dust, FerroniobiumTantalum, 10)
                .fluidInputs(Chlorine.getFluid(45000 + 9000))
                .notConsumable(Salt.getFluid(1440))
                .notConsumable(Iron3Chloride.getFluid(1440))
                .fluidOutputs(Iron3Chloride.getFluid(1296))
                .fluidOutputs(ImpureNiobiumPentachloride.getFluid(7000))
                .duration(400)
                .EUt(1920)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder() // Niobium Pentachloride
                .fluidInputs(ImpureNiobiumPentachloride.getFluid(7000))
                .fluidOutputs(TantalumPentachloride.getFluid(500))
                .fluidOutputs(NiobiumPentachloride.getFluid(6500))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(NiobiumPentachloride.getFluid(1000))
                .output(dust, NiobiumPentachloride, 6)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder() // Niobium Oxide Dihydrate
                .input(dust, NiobiumPentachloride, 12)
                .fluidInputs(DistilledWater.getFluid(17000))
                .output(dust, NiobiumOxideDihydrate, 9)
                .fluidOutputs(HydrochloricAcid.getFluid(10000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Columbite
// FF, autoclave with HF & H2SO4, dissolve, MIBK solv extr.

        GRAVITY_SEPARATOR_RECIPES.recipeBuilder() // Sifted Columbite
                .input(dust, Columbite)
                .output(sifted, Columbite)
                .chancedOutput(dust, PegmatiteTailings, 2500, 0)
                .chancedOutput(dust, NetherQuartz, 2500, 0)
                .EUt(30)
                .duration(40)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder() // Columbite Concentrate
                .input(sifted, Columbite)
                .output(concentrate, Columbite)
                .chancedOutput(dust, PegmatiteTailings, 2500, 0)
                .chancedOutput(dust, NetherQuartz, 2500, 0)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder() // Impure Columbite Slurry
                .input(concentrate, Columbite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Columbite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder() // Columbite Slurry
                .notConsumable(dust, SodiumFluorosilicate)
                .fluidInputs(Columbite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(OneAmidoethylTwoAlkylTwoImidazoline.getFluid(100))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .notConsumable(HydrochloricAcid.getFluid(100))
                .fluidOutputs(Columbite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder() // Flotated Columbite
                .fluidInputs(Columbite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(flotated, Columbite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder() // Impure Fluoroniobic Acid Solution
                .input(flotated, Columbite, 1)
                .fluidInputs(HydrogenFluoride.getFluid(14000))
                .fluidInputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(ImpureFluoroniobicAcidSolution.getFluid(1000))
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Niobium-rich Extract
                .fluidInputs(ImpureFluoroniobicAcidSolution.getFluid(1000))
                .fluidInputs(MethylIsobutylKetone.getFluid(6000))
                .fluidOutputs(NiobiumRichExtract.getFluid(6000))
                .fluidOutputs(MetalSulfateWaste.getFluid(1000))
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Scrubbed Niobium-rich Extract
                .fluidInputs(NiobiumRichExtract.getFluid(500))
                .notConsumable(SulfuricAcid.getFluid(500))
                .fluidOutputs(ScrubbedNiobiumRichExtract.getFluid(500))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Fluoroniobic Acid Solution
                .fluidInputs(ScrubbedNiobiumRichExtract.getFluid(500))
                .fluidInputs(DistilledWater.getFluid(500))
                .fluidOutputs(DilutedTantalumExtract.getFluid(500))
                .fluidOutputs(FluoroniobicAcidSolution.getFluid(500))
                .duration(5)
                .EUt(480)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder() // Purified Fluoroniobic Acid Solution
                .fluidInputs(FluoroniobicAcidSolution.getFluid(6000))
                .fluidInputs(MethylIsobutylKetone.getFluid(1500))
                .fluidOutputs(PurifiedFluoroniobicAcidSolution.getFluid(6000))
                .fluidOutputs(NiobiumRichExtract.getFluid(1500))
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder() // Niobium Oxide Dihydrate (2 H2NbF7 + 14 NH3 + 5 H2O --> 14 NH4F + Nb2O5)
                .fluidInputs(PurifiedFluoroniobicAcidSolution.getFluid(6000)) // 27/20 mol Nb
                .fluidInputs(AmmoniaSolution.getFluid(9450))
                .fluidInputs(DistilledWater.getFluid(4725))
                .chancedOutput(dust, NiobiumOxideDihydrate, 9, 6750, 0)
                .fluidOutputs(AmmoniumFluorideSolution.getFluid(9450))
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, AmmoniumFluoride, 6)
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(HydrogenFluoride.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder() // Niobium Oxide
                .input(dust, NiobiumOxideDihydrate, 9)
                .output(dust, NiobiumOxide, 7)
                .fluidOutputs(Steam.getFluid(2000))
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        ADVANCED_ARC_FURNACE.recipeBuilder() // Niobium
                .input(dust, NiobiumOxide, 21)
                .input("dustAnyPurityAluminium", 10)
                .output(dust, Alumina, 25)
                .fluidOutputs(Niobium.getFluid(864))
                .duration(240)
                .EUt(1920)
                .buildAndRegister();

// From tantalite
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(DilutedNiobiumExtract.getFluid(9000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(MethylIsobutylKetone.getFluid(9000))
                .fluidOutputs(PurifiedFluoroniobicAcidSolution.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(MetalSulfateWaste.getFluid(1000))
                .fluidOutputs(Steam.getFluid(1000))
                .chancedOutput(dust, IronSulfate, 6, 5000, 0)
                .chancedOutput(dust, ManganeseIISulfate, 6, 5000, 0)
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, ManganeseIISulfate, 6)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(ManganeseIISulfateSolution.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();
    }
}
