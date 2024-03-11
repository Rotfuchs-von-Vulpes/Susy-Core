package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.ANODE_SLIME_LEAD;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.*;

public class LeadChain {
    public static void init() {
        //REMOVAL
        // mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustGalena')], [fluid('oxygen') * 3000])

//OPTIONAL FLOTATION
//GALENA
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Galena, 8)
                .fluidInputs(DistilledWater.getFluid(3000))
                .fluidOutputs(Galena.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 3000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Galena.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 3000))
                .notConsumable(dust, SodiumEthylXanthate)
                .notConsumable(SodiumCyanideSolution.getFluid(100))
                .fluidOutputs(Galena.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(GalenaByproductsSlurry.getFluid(2000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Galena.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(dust, Galena, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(GalenaByproductsSlurry.getFluid(2000))
                .notConsumable(dust, SodiumEthylXanthate)
                .fluidOutputs(SphaleriteByproductSlurry.getFluid(1000))
                .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(SphaleriteByproductSlurry.getFluid(1000))
                .output(dust, Sphalerite, 2)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(7)
                .duration(20)
                .buildAndRegister();

//CERUSSITE
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Cerussite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Cerussite.getFluid(SusyFluidStorageKeys.SLURRY, 2000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Cerussite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(dust, SodiumEthylXanthate)
                .fluidOutputs(Cerussite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Cerussite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(dust, Cerussite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Cerussite, 1)
                .output(dust, Massicot, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

//ANGLESITE
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Anglesite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Anglesite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Anglesite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(dust, SodiumEthylXanthate)
                .fluidOutputs(Anglesite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 1000))
                .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                .EUt(120)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Anglesite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(dust, Anglesite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(7)
                .duration(20)
                .buildAndRegister();

//CONCENTRATE SINTERING
        for (Utils.Combustible fuel : rotary_kiln_fuels) {
            for (Utils.Comburent comburent : rotary_kiln_comburents) {
                ROTARY_KILN.recipeBuilder()
                        .input(dust, Massicot, 2)
                        .output(dust, SinteredLeadConcentrate, 2)
                        .fluidInputs(fuel.fluid)
                        .fluidInputs(comburent.fluid)
                        .fluidOutputs(fuel.byproduct)
                        .duration(fuel.duration + comburent.duration)
                        .EUt(120)
                        .buildAndRegister();

                ROTARY_KILN.recipeBuilder()
                        .input(dust, Galena, 1)
                        .output(dust, SinteredLeadConcentrate, 2)
                        .fluidInputs(fuel.fluid)
                        .fluidInputs(comburent.fluid)
                        .fluidOutputs(SulfurDioxide.getFluid(1000))
                        .duration(fuel.duration + comburent.duration)
                        .EUt(120)
                        .buildAndRegister();

                ROTARY_KILN.recipeBuilder()
                        .input(dust, Anglesite, 1)
                        .output(dust, SinteredLeadConcentrate, 2)
                        .fluidInputs(fuel.fluid)
                        .fluidInputs(comburent.fluid)
                        .fluidOutputs(SulfurTrioxide.getFluid(1000))
                        .duration(fuel.duration + comburent.duration)
                        .EUt(120)
                        .buildAndRegister();
            }
        }

//SINTER-ROAST PROCESS (UNIVERSAL, 200%)
        for (Utils.CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            BLAST_RECIPES.recipeBuilder()
                    .input(dust, SinteredLeadConcentrate, 2)
                    .inputs(combustible.name)
                    .input(dustTiny, Calcite)
                    .output(ingot, CrudeLead, 2)
                    .outputs(combustible.byproduct)
                    .fluidOutputs(CadmiumRichFlueGas.getFluid(1000))
                    .EUt(120)
                    .blastFurnaceTemp(850)
                    .duration(160)
                    .buildAndRegister();
        }

        SIFTER_RECIPES.recipeBuilder()
                .notConsumable(ITEM_FILTER)
                .fluidInputs(CadmiumRichFlueGas.getFluid(1000))
                .output(dust, CadmiumRichFlue)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .EUt(120)
                .duration(160)
                .buildAndRegister();

//DECOPPERING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPuritySulfur")
                .fluidInputs(CrudeLead.getFluid(3600))
                .output(dust, CopperDross, 2)
                .fluidOutputs(DecopperedLead.getFluid(3600))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, CopperDross, 2)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .fluidOutputs(CopperSulfateSolution.getFluid(1000))
                //.fluidOutputs(SulfurDioxide.getFluid(1000)) Add when susycore 0.0.14
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(CopperSulfateSolution.getFluid(1000))
                .output(dust, CopperSulfate, 6)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

//SOFTENING (HARRIS PROCESS) (4% Sb, 2% As, 5% Sn)
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(SodiumNitrate.getFluid(720))
                .fluidInputs(DecopperedLead.getFluid(1440))
                .fluidInputs(SodiumHydroxide.getFluid(288))
                .output(dust, HarrisSlag)
                .fluidOutputs(SoftenedLead.getFluid(1440))
                .fluidOutputs(Nitrogen.getFluid(1000))
                .fluidOutputs(Water.getFluid(900))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, HarrisSlag)
                .fluidInputs(DistilledWater.getFluid(10))
                .chancedOutput(dust, SodiumAntimonate, 400, 0)
                .fluidOutputs(SodiumArsenateStannateSolution.getFluid(10))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumArsenateStannateSolution.getFluid(1000))
                .output(dust, SodiumArsenateStannateMixture, 6)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumArsenateStannateMixture, 6)
                .fluidOutputs(SodiumArsenate.getFluid(1152))
                .output(dust, SodiumStannate, 25)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumArsenate, 8)
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .fluidOutputs(SaltyArsenicAcid.getFluid(3000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(SaltyArsenicAcid.getFluid(6000))
                .output(dust, SaltyArsenicPentoxide, 7)
                .fluidOutputs(Steam.getFluid(9000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SaltyArsenicPentoxide, 7)
                .fluidInputs(Water.getFluid(6000))
                .output(dust, ArsenicVOxide, 7)
                .fluidOutputs(SaltWater.getFluid(6000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumStannate, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(dust, TinIVOxide, 3)
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumAntimonate, 10)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, AntimonyVOxide, 7)
                .fluidOutputs(SaltWater.getFluid(2000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        for (CarbonSource carbon : sources) {
            carbon.name.setCount(carbon.equivalent(5));
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, AntimonyVOxide, 7)
                    .inputs(carbon.name)
                    .output(dust, Antimony, 2)
                    .fluidOutputs(CarbonMonoxide.getFluid(5000))
                    .EUt(120)
                    .duration(200)
                    .buildAndRegister();

            carbon.name.setCount(carbon.equivalent(2));
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, TinIVOxide, 3)
                    .inputs(carbon.name)
                    .output(dust, Tin)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .EUt(120)
                    .duration(200)
                    .buildAndRegister();

            if (carbon.equivalent(23) <= 64) {
                carbon.name.setCount(carbon.equivalent(23));
                ROASTER_RECIPES.recipeBuilder()
                        .input(dust, LithargeSlag, 10)
                        .inputs(carbon.name)
                        .output(ingot, BettsCrudeLead, 10)
                        .EUt(120)
                        .duration(400)
                        .buildAndRegister();
            }
        }

//SILVER REMOVAL (PARKES PROCESS)
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SoftenedLead.getFluid(3600))
                .fluidInputs(Zinc.getFluid(144))
                .fluidOutputs(SilverFreeLead.getFluid(3600))
                .fluidOutputs(ZincDross.getFluid(216))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(ZincDross.getFluid(432))
                .output(dust, Silver)
                .fluidOutputs(Zinc.getFluid(288))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

//DEZINCING
        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(SilverFreeLead.getFluid(2880))
                .fluidOutputs(DezincedLead.getFluid(2880))
                .fluidOutputs(Zinc.getFluid(144))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(DezincedLead.getFluid(144))
                .notConsumable(SHAPE_MOLD_INGOT)
                .output(ingot, Lead)
                .EUt(7)
                .duration(20)
                .buildAndRegister();

//DEBISMUTHIZING (KROLL-BETTERTON PROCESS)
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(SilverFreeLead.getFluid(9600))
                .input("dustAnyPurityMagnesium", 6)
                .input("dustAnyPurityCalcium", 3)
                .fluidOutputs(Lead.getFluid(9600))
                .fluidOutputs(BismuthDross.getFluid(1440))
                .fluidOutputs(AntimonyDross.getFluid(720))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(BismuthDross.getFluid(720))
                .fluidInputs(Chlorine.getFluid(6000))
                .output(dust, Bismuth, 2)
                .output(dust, MagnesiumChloride, 6)
                .output(dust, CalciumChloride, 3)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

//HIGH PURITY LEAD (BETTS PROCESS)
        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(plate, Lead)
                .notConsumable(HexafluorosilicicAcid.getFluid(1000))
                .input(plate, CrudeLead, 2)
                .fluidInputs(DistilledWater.getFluid(1000))
                .chancedOutput(dust, HighPurityLead, 2, 9800, 0)
                .output(ANODE_SLIME_LEAD)
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(256)
                .duration(400)
                .buildAndRegister();

//SLIME TREATMENT
        ROASTER_RECIPES.recipeBuilder()
                .input(ANODE_SLIME_LEAD)
                .output(dust, BlackMetal)
                .EUt(120)
                .duration(400)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, BlackMetal, 50)
                .fluidInputs(Oxygen.getFluid(9000))
                .fluidOutputs(AntimonyArsenicFlueGas.getFluid(1000))
                .output(dust, BurnedBlackMetal, 2)
                .EUt(120)
                .duration(400)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .notConsumable(ITEM_FILTER)
                .fluidInputs(AntimonyArsenicFlueGas.getFluid(1000))
                .output(dust, CadmiumRichFlue, 3)
                .fluidOutputs(FlueGas.getFluid(1000))
                .EUt(120)
                .duration(160)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, BurnedBlackMetal, 2)
                .fluidInputs(Oxygen.getFluid(2500))
                .output(dust, Silver)
                .output(dust, LithargeSlag, 5)
                .EUt(120)
                .duration(400)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPuritySulfur")
                .fluidInputs(BettsCrudeLead.getFluid(1440))
                .output(dust, CopperDross, 2)
                .fluidOutputs(DecopperedBettsLead.getFluid(1296))
                .EUt(120)
                .duration(400)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(DecopperedBettsLead.getFluid(2592))
                .input("dustAnyPurityMagnesium", 6)
                .input("dustAnyPurityCalcium", 3)
                .fluidOutputs(Lead.getFluid(1728))
                .fluidOutputs(BismuthDross.getFluid(2160))
                .EUt(120)
                .duration(800)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(LeadChloride.getFluid(432))
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(plate, Lead, 1)
                .output(dust, Lead, 1)
                .fluidOutputs(Chlorine.getFluid(2000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, LeadIIHydroxide, 5)
                .output(dust, LeadOxide, 2)
                .fluidOutputs(Steam.getFluid(1000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, LeadOxide, 2)
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .output(dust, Lead)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .blastFurnaceTemp(1200)
                .duration(80)
                .EUt(120)
                .buildAndRegister();
    }
}
