package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group1;



import supersymmetry.api.fluids.SusyFluidStorageKeys;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.Materials.LithiumChloride;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.LithiumCarbonate;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumSulfate;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.*;

public class LithiumChain {
    public static void init() {
        //UNIVERSAL
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Spodumene, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Spodumene.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Spodumene.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(AlkalineSodiumOleateSolution.getFluid(1000))
                .fluidOutputs(Spodumene.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 1000))
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Spodumene.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 1000))
                .output(dust, Spodumene, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(PegmatiteTailingSlurry.getFluid(1000))
                .output(dust, PegmatiteTailings, 2)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Spodumene, 10)
                .output(dust, BetaSpodumene, 8)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Petalite, 1)
                .output(dust, RoastedPetalite, 12)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Spodumene, 10)
                .output(dust, BetaSpodumene, 10)
                .EUt(120)
                .duration(40)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Petalite, 1)
                .output(dust, RoastedPetalite, 16)
                .EUt(160)
                .duration(40)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, RoastedPetalite, 16)
                .output(dust, BetaSpodumene, 10)
                .output(dust, SiliconDioxide, 6)
                .EUt(30)
                .duration(40)
                .buildAndRegister();

//ACID DIGESTION (90%)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(2000))
                .input(dust, BetaSpodumene, 20)
                .fluidOutputs(ImpureLithiumSulfateSolution.getFluid(2000))
                .output(dust, AluminiumSilicate, 8)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

//ALUMINIUM SILICATE PROCESSING
        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .input(dust, AluminiumSilicate, 8)
                .fluidOutputs(SodiumSilicateSolution.getFluid(1000))
                .output(dust, Alumina, 5)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSilicateSolution.getFluid(1000))
                .fluidInputs(HydrogenChloride.getFluid(2000))
                .output(dust, WetSilicaGel, 3)
                .fluidOutputs(SaltWater.getFluid(2000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .input(dust, WetSilicaGel)
                .output(dust, SilicaGel)
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(dust, SilicaGel)
                .output(dust, SiliconDioxide)
                .EUt(30)
                .duration(80)
                .buildAndRegister();

//IMPURITY PRECIPITATION
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide)
                .fluidInputs(ImpureLithiumSulfateSolution.getFluid(1000))
                .chancedOutput(dust, AluminiumHydroxide, 1111, 0)
                .chancedOutput(dust, IronIIIHydroxide, 1111, 0)
                .chancedOutput(dust, MagnesiumHydroxide, 1667, 0)
                .fluidOutputs(LithiumSulfateSolution.getFluid(900))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LithiumSulfateSolution.getFluid(1000))
                .input(dust, SodaAsh, 6)
                .outputs(LithiumCarbonate.getItemStack(6))
                .fluidOutputs(SodiumSulfateSolution.getFluid(1000))
                .duration(180)
                .EUt(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .inputs(LithiumCarbonate.getItemStack(6))
                .output(dust, LithiumChloride, 4)
                .fluidOutputs(Steam.getFluid(3000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(180)
                .EUt(200)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Steel)
                .notConsumable(RockSalt.getFluid(358))
                .fluidInputs(LithiumChloride.getFluid(288))
                .fluidOutputs(Chlorine.getFluid(1000))
                .output(dust, Lithium)
                .EUt(120)
                .duration(180)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(1000))
                .input(dust, Amblygonite, 8)
                .output(dust, AluminiumPhosphate, 6)
                .fluidOutputs(AmblygoniteLeach.getFluid(1000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AmblygoniteLeach.getFluid(2000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, LithiumSulfate, 7)
                .fluidOutputs(DilutedHydrofluoricAcid.getFluid(2000))
                .duration(60)
                .EUt(200)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedHydrofluoricAcid.getFluid(2000))
                .fluidOutputs(HydrofluoricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, LithiumSulfate, 7)
                .fluidInputs(SodaAshSolution.getFluid(1000))
                .outputs(LithiumCarbonate.getItemStack(6))
                .fluidOutputs(SodiumSulfateSolution.getFluid(1000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AluminiumPhosphate, 6)
                .fluidInputs(HydrogenChloride.getFluid(3000))
                .output(dust, AluminiumChloride, 3)
                .fluidOutputs(PhosphoricAcid.getFluid(1000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        for (Combustible fuel : sintering_fuels) {
            if (!fuel.isPlasma) {
                for (Comburent comburent : sintering_comburents) {
                    ROTARY_KILN.recipeBuilder()
                            .input(dust, Lepidolite, 20)
                            .input(dust, Quicklime, 4)
                            .output(dust, RoastedLepidolite, 20)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .fluidOutputs(fuel.byproduct)
                            .duration(fuel.duration + comburent.duration)
                            .EUt(120)
                            .buildAndRegister();
                }
            }
        }

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, RoastedLepidolite, 20)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(LepidoliteLeach.getFluid(1000))
                .output(dust, AlkaliAlumMix, 4)
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .fluidInputs(LepidoliteLeach.getFluid(1000))
                .output(dust, CalciumSulfate, 6)
                .fluidOutputs(NeutralizedLepidoliteLeach.getFluid(1000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .notConsumable(dustTiny, AluminiumSulfate)
                .fluidInputs(NeutralizedLepidoliteLeach.getFluid(1000))
                .output(dust, AluminiumSulfate, 17)
                .fluidOutputs(AluminiumFreeLepidoliteLeach.getFluid(1000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AluminiumSulfate, 17)
                .fluidInputs(SodiumBicarbonateSolution.getFluid(6000))
                .output(dust, AluminiumHydroxide, 14)
                .fluidOutputs(DilutedSodiumSulfateSolution.getFluid(6000))
                .fluidOutputs(CarbonDioxide.getFluid(6000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSodiumSulfateSolution.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .output(dust, SodiumSulfate, 7)
                .duration(30)
                .EUt(200)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .fluidInputs(AluminiumFreeLepidoliteLeach.getFluid(1000))
                .outputs(LithiumCarbonate.getItemStack(6))
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(120)
                .EUt(200)
                .buildAndRegister();
    }
}
