package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group6;

import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.api.unification.ore.SusyOrePrefix;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.flotated;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.materials.SusyMaterials.Wulfenite;

public class MolybdenumChain {
    public static void init() {
        // MOLYBDENITE BENEFICIATION

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Molybdenite, 8)
                .fluidInputs(DistilledWater.getFluid(2500))
                .fluidOutputs(Molybdenite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2500))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Molybdenite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2500))
                .notConsumable(dust, Quicklime)
                .notConsumable(dust, PotassiumAmylXanthate)
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .fluidOutputs(CopperMolybdeniteSlurry.getFluid(2000))
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(500))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input("dustAnyPuritySulfur", 5)
                .fluidInputs(Phosphorus.getFluid(288))
                .output(dust, PhosphorusPentasulfide, 7)
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhosphorusPentasulfide, 7)
                .input(dust, SodiumHydroxide, 18)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(SodiumDithiophosphateSolution.getFluid(4000))
                .fluidOutputs(HydrogenSulfide.getFluid(2000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(CopperMolybdeniteSlurry.getFluid(2000))
                .fluidInputs(SodiumDithiophosphateSolution.getFluid(50))
                .notConsumable(dust, SodiumCyanide, 3)
                .notConsumable(Diesel.getFluid(1000))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .fluidOutputs(CopperConcentrateSlurry.getFluid(1000))
                .fluidOutputs(Molybdenite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Molybdenite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(flotated, Molybdenite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// WULFENITE

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Wulfenite)
                .input(dust, SodiumHydroxide, 6)
                .output(dust, AlkaliFusedWulfenite, 9)
                .blastFurnaceTemp(700)
                .duration(100)
                .EUt(1920)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AlkaliFusedWulfenite, 9)
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(dust, LeadIIHydroxide, 5)
                .fluidOutputs(SodiumMolybdateSolution.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(spring, Nichrome)
                .fluidInputs(SodiumMolybdateSolution.getFluid(2000))
                .fluidInputs(AmmoniumChlorideSolution.getFluid(4000))
                .output(dust, AmmoniumDimolybdate, 19)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(Steam.getFluid(3000))
                .fluidOutputs(SaltWater.getFluid(4000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

// PURIFICATION

        ROASTER_RECIPES.recipeBuilder()
                .input(flotated, Molybdenite, 3)
                .fluidInputs(Oxygen.getFluid(7000))
                .output(dust, MolybdenumTrioxide, 4)
                .fluidOutputs(MolybdeniteFlueGas.getFluid(2000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrioxide, 4)
                .fluidInputs(AmmoniaSolution.getFluid(2000))
                .fluidOutputs(AmmoniumMolybdateSolution.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(spring, Nichrome)
                .fluidInputs(AmmoniumMolybdateSolution.getFluid(2000))
                .output(dust, AmmoniumDimolybdate, 19)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(Steam.getFluid(2000))
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

// TUNGSTEN BYPRODUCT PROCESSING

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrisulfide, 4)
                .fluidInputs(Oxygen.getFluid(9000))
                .output(dust, ImpureMolybdenumTrioxide, 4)
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ImpureMolybdenumTrioxide, 4)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(MolybdicAcidSolution.getFluid(1000)) // 1x H2MoO4, 1x HCl, 1x H2O
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(MolybdicAcidSolution.getFluid(1000))
                .fluidInputs(AmmoniaSolution.getFluid(3000))
                .fluidOutputs(NeutralizedAmmoniumMolybdateSolution.getFluid(4000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(spring, Nichrome)
                .fluidInputs(NeutralizedAmmoniumMolybdateSolution.getFluid(8000))
                .output(dust, AmmoniumDimolybdate, 19)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(Steam.getFluid(7000))
                .fluidOutputs(AmmoniumChlorideSolution.getFluid(2000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

// FINAL PROCESSING

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumDimolybdate, 19)
                .output(dust, PurifiedMolybdenumTrioxide, 8)
                .fluidOutputs(Steam.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(2000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

// BYPASS (95% yield)

        BLAST_RECIPES.recipeBuilder()
                .input(dust, ImpureMolybdenumTrioxide, 4)
                .fluidInputs(Air.getFluid(1000))
                .fluidOutputs(SublimatedMolybdenumTrioxide.getFluid(1000))
                .blastFurnaceTemp(1400)
                .duration(100)
                .EUt(7680)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrioxide, 4)
                .fluidInputs(Air.getFluid(1000))
                .fluidOutputs(SublimatedMolybdenumTrioxide.getFluid(1000))
                .blastFurnaceTemp(1400)
                .duration(100)
                .EUt(7680)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .notConsumable(ITEM_FILTER)
                .fluidInputs(SublimatedMolybdenumTrioxide.getFluid(1000))
                .chancedOutput(dust, PurifiedMolybdenumTrioxide, 4, 9500, 0)
                .fluidOutputs(Air.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// REDUCTION TO PURE METAL

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(6000))
                .input(dust, PurifiedMolybdenumTrioxide, 4)
                .fluidOutputs(Steam.getFluid(3000))
                .output(dust, Molybdenum)
                .duration(100)
                .EUt(1920)
                .buildAndRegister();
    }
}
