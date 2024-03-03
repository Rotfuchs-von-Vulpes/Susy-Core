package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import gregtech.api.unification.material.MarkerMaterial;
import gregtech.api.unification.material.MarkerMaterials;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ELECTRIC_PUMP_HV;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class AramidChain {
    public static void init() {
        // Spinneret

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(11)
                .input(plate, StainlessSteel, 4)
                .input(spring, Nichrome)
                .input(pipeTinyFluid, Polyethylene)
                .input(circuit, MarkerMaterials.Tier.HV)
                .input(ELECTRIC_PUMP_HV)
                .output(SPINNERET)
                .duration(600)
                .EUt(480)
                .buildAndRegister();

// 4-nitroaniline

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, FourChloronitrobenzene)
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(FourNitroanilineSolution.getFluid(1000))
                .output(dust, AmmoniumChloride, 6)
                .duration(600)
                .EUt(120)
                .buildAndRegister();

// p-Phenylenediamine

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Palladium)
                .fluidInputs(FourNitroanilineSolution.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(300))
                .fluidOutputs(ParaPhenylenediamineSolution.getFluid(150))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ParaPhenylenediamineSolution.getFluid(3000))
                .fluidOutputs(Toluene.getFluid(1000))
                .fluidOutputs(Steam.getFluid(2000))
                .output(dust, ParaPhenylenediamine, 16)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Kevlar

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, ParaPhenylenediamine, 16)
                .input(dust, TerephthaloylChloride, 16)
                .notConsumable(NMethylTwoPyrrolidone.getFluid(4000))
                .fluidInputs(SodaAshSolution.getFluid(1000))
                .output(wetFiber, Kevlar, 8)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(DilutedCalciumChlorideSolution.getFluid(2000))
                .EUt(1920)
                .duration(300)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .input(dust, ParaPhenylenediamine, 16)
                .input(dust, TerephthaloylChloride, 16)
                .fluidInputs(Dimethylacetamide.getFluid(4000))
                .fluidOutputs(KevlarPolymerizationMix.getFluid(4000))
                .EUt(1920)
                .duration(300)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .fluidInputs(KevlarPolymerizationMix.getFluid(4000))
                .fluidInputs(HotAir.getFluid(1000))
                .fluidInputs(Water.getFluid(100))
                .notConsumable(SPINNERET)
                .output(wetFiber, Kevlar, 16)
                .fluidOutputs(SpentDimethylacetamide.getFluid(4000))
                .fluidOutputs(Wastewater.getFluid(100))
                .duration(300)
                .EUt(480)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SpentDimethylacetamide.getFluid(4000))
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(Dimethylacetamide.getFluid(4000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(thread, Kevlar, 8)
                .output(plate, Kevlar)
                .EUt(1920)
                .duration(300)
                .buildAndRegister();

// m-Phenylenediamine

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Nitrobenzene.getFluid(50))
                .fluidInputs(NitrationMixture.getFluid(100))
                .fluidOutputs(AcidicDinitrobenzeneMixture.getFluid(100))
                .duration(10)
                .EUt(480)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(AcidicDinitrobenzeneMixture.getFluid(2000))
                .output(dust, DinitrobenzeneMixture)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(2000))
                .duration(50)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, DinitrobenzeneMixture)
                .fluidInputs(SodiumHydroxideSolution.getFluid(100))
                .chancedOutput(dust, OneThreeDinitrobenzene, 8800, 0)
                .fluidOutputs(Wastewater.getFluid(100))
                .duration(200)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, OneThreeDinitrobenzene)
                .fluidInputs(Hydrogen.getFluid(4000))
                .notConsumable(dust, ActivatedRaneyNickel, 1)
                .output(dust, MetaPhenylenediamine, 16)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Nomex

        POLYMERIZATION_RECIPES.recipeBuilder()
                .input(dust, MetaPhenylenediamine, 16)
                .input(dust, IsophthaloylChloride, 16)
                .fluidInputs(Dimethylacetamide.getFluid(4000))
                .fluidOutputs(NomexPolymerizationMix.getFluid(4000))
                .EUt(1920)
                .duration(300)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .fluidInputs(NomexPolymerizationMix.getFluid(4000))
                .fluidInputs(HotAir.getFluid(1000))
                .fluidInputs(Water.getFluid(100))
                .notConsumable(SPINNERET)
                .output(wetFiber, Nomex, 16)
                .fluidOutputs(SpentDimethylacetamide.getFluid(4000))
                .fluidOutputs(Wastewater.getFluid(100))
                .duration(300)
                .EUt(480)
                .buildAndRegister();
    }
}
