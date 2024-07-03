package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group6;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.api.fluids.SusyFluidStorageKeys;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumSulfate;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.sifted;
import static supersymmetry.common.materials.SusyMaterials.*;

public class TungstenChain {
    public static void init() {
        // Tungstic Acid Dust * 7
        removeRecipesByInputs(CHEMICAL_BATH_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Scheelite, 6)},
                new FluidStack[]{HydrochloricAcid.getFluid(2000)});
        // Tungstic Acid Dust * 7
        removeRecipesByInputs(CHEMICAL_BATH_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Tungstate, 6)},
                new FluidStack[]{HydrochloricAcid.getFluid(2000)});

// Benefication

// Scheelite
        GRAVITY_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, Scheelite)
                .output(sifted, Scheelite)
                .chancedOutput(dust, GraniteTailings, 5000, 0)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(sifted, Scheelite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Scheelite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Scheelite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(OleicAcid.getFluid(144))
                .notConsumable(dust, SodiumSilicate, 6)
                .fluidOutputs(Scheelite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Scheelite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(flotated, Scheelite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(flotated, Scheelite)
                .fluidInputs(HydrochloricAcid.getFluid(50))
                .output(dust, CalcinedScheelite)
                .fluidOutputs(HydrogenChloride.getFluid(25))
                .fluidOutputs(Steam.getFluid(50))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, CalcinedScheelite)
                .fluidInputs(SodaAshSolution.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(dust, Calcite, 5)
                .fluidOutputs(SodiumTungstateSolution.getFluid(1000))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

// Wolframite

        GRAVITY_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, Wolframite)
                .output(sifted, Wolframite)
                .chancedOutput(dust, GraniteTailings, 5000, 0)
                .chancedOutput(dust, GoldConcentrate, 500, 100)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(sifted, Wolframite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Wolframite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Wolframite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(OleicAcid.getFluid(144))
                .notConsumable(dust, SodiumSilicate, 6)
                .fluidOutputs(Wolframite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Wolframite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(flotated, Wolframite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(flotated, Wolframite)
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .chancedOutput(dust, ManganeseIIHydroxide, 5, 5000, 0)
                .chancedOutput(dust, IronIIHydroxide, 5, 5000, 0)
                .fluidOutputs(SodiumTungstateSolution.getFluid(1000)) // 2x H2O, 8/9x Na2WO4, 1/18x Na2MoO4 1/18x Na2SiO3
                .duration(20)
                .EUt(480)
                .buildAndRegister();

// Purification

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AluminiumSulfate, 17)
                .fluidInputs(SodiumTungstateSolution.getFluid(18000))
                .output(dust, AluminiumSilicate, 8)
                .fluidOutputs(SilicateFreeTungstateSolution.getFluid(18000)) // 18x H2O, 8x Na2WO4, 1/2x Na2MoO4, 1/2x Na2SO4
                .EUt(480)
                .duration(90)
                .buildAndRegister();

/*
Conversion to thiomolybdate: 9x H2O, 4x Na2WO4, 1/4x Na2MoS4, 1/4x Na2SO4, 2x NaOH
Precipitation of MoS3: 45/4x H2O, 4x Na2WO4, 5/4x Na2SO4
*/

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfide, 6)
                .fluidInputs(SilicateFreeTungstateSolution.getFluid(9000))
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .fluidInputs(DistilledWater.getFluid(2000))
                .chancedOutput(dust, MolybdenumTrisulfide, 4, 5000, 0)
                .fluidOutputs(MolybdenumFreeTungstateSolution.getFluid(11250))
                .fluidOutputs(HydrogenSulfide.getFluid(500))
                .EUt(480)
                .duration(180)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Kerosene.getFluid(325))
                .fluidInputs(Trioctylamine.getFluid(625))
                .fluidInputs(Isodecanol.getFluid(50))
                .fluidOutputs(TungstenExtractionMixture.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumTungstateSolution.getFluid(4000))
                .fluidInputs(TungstenExtractionMixture.getFluid(8000))
                .fluidOutputs(AmmoniaSolution.getFluid(4000))
                .fluidOutputs(TungstenExtract.getFluid(8000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(MolybdenumFreeTungstateSolution.getFluid(11250)) // 45/4x H2O, 4x Na2WO4, 5/4x Na2SO4
                .fluidInputs(TungstenExtractionMixture.getFluid(8000))
                .fluidOutputs(VeryDilutedSodiumSulfateSolution.getFluid(11250))
                .fluidOutputs(TungstenExtract.getFluid(8000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(VeryDilutedSodiumSulfateSolution.getFluid(9000))
                .output(dust, SodiumSulfate, 7)
                .fluidOutputs(Water.getFluid(9000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(TungstenExtract.getFluid(8000))
                .fluidInputs(DemineralizedWater.getFluid(2000))
                .fluidOutputs(ScrubbedTungstenExtract.getFluid(8000))
                .fluidOutputs(Wastewater.getFluid(2000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ScrubbedTungstenExtract.getFluid(8000))
                .fluidInputs(AmmoniaSolution.getFluid(5000))
                .fluidOutputs(TungstenExtractionMixture.getFluid(8000))
                .fluidOutputs(AmmoniumIsopolytungstateSolution.getFluid(5000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumIsopolytungstateSolution.getFluid(5000))
                .chancedOutput(dust, AmmoniumParatungstate, 5000, 0)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(480)
                .duration(600)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumParatungstate)
                .fluidInputs(Air.getFluid(1000))
                .output(dust, TungstenTrioxide, 48)
                .fluidOutputs(Steam.getFluid(10000))
                .fluidOutputs(Ammonia.getFluid(10000))
                .EUt(480)
                .duration(1200)
                .buildAndRegister();

// REDUCTION TO PURE METAL

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(6000))
                .input(dust, TungstenTrioxide, 4)
                .fluidOutputs(Steam.getFluid(3000))
                .output(dust, Tungsten)
                .duration(100)
                .EUt(1920)
                .buildAndRegister();
    }
}
