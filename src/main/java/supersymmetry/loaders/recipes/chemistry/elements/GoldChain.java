package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.unification.OreDictUnifier;
import supersymmetry.common.blocks.BlockResource;
import supersymmetry.common.blocks.SuSyBlocks;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HydrogenCyanide;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class GoldChain {
    public static void init() {
        // Silver Dust * 1
        removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, RawElectrum, 2));
        removeRecipesByInputs(MIXER_RECIPES, HydrochloricAcid.getFluid(2000), NitricAcid.getFluid(1000));

//GOLD AMALGAMATION (50% EFFICIENCY)
        MIXER_RECIPES.recipeBuilder()
                .input(dust, RawElectrum, 2)
                .fluidInputs(Mercury.getFluid(1000))
                .output(dust, Silver)
                .fluidOutputs(GoldAmalgam.getFluid(1000))
                .duration(60)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(GoldAmalgam.getFluid(1000))
                .output(dust, Gold)
                .fluidOutputs(Mercury.getFluid(1000))
                .duration(360)
                .EUt(30)
                .buildAndRegister();

//NATURAL ELECTRUM PURIFICATION VIA PARTING (PRIMITIVE, 67% EFFICIENCY)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RawElectrum, 3)
                .fluidInputs(NitricAcid.getFluid(4000))
                .fluidInputs(DistilledWater.getFluid(2000))
                .output(dust, Gold, 2)
                .fluidOutputs(SilverNitrateSolution.getFluid(4000))
                .fluidOutputs(NitricOxide.getFluid(1000))
                .duration(360)
                .EUt(30)
                .buildAndRegister();

//ADD PLACER DEPOSIT GRAVITY SEPARATION

//MILLER PROCESS (UNIVERSAL, 100%)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(RawElectrum.getFluid(144))
                .fluidInputs(Chlorine.getFluid(500))
                .output(dust, SilverChloride)
                .fluidOutputs(Gold.getFluid(144))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        //ADD MILLER PROCESS FOR OTHER ELECTROREFINING DORES

//CYANIDATION (UNIVERSAL, 100%)
        MACERATOR_RECIPES.recipeBuilder()
                .inputs(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.GOLD_ALLUVIAL))
                .output(dust, GoldConcentrate, 8)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, GoldConcentrate, 20)
                .fluidInputs(DistilledWater.getFluid(6000))
                .fluidOutputs(GoldOreSlurry.getFluid(6000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumCyanide, 24)
                .input(dustTiny, Quicklime)
                .fluidInputs(GoldOreSlurry.getFluid(6000))
                .fluidInputs(Air.getFluid(10000))
                .output(SAND_DUST, 16)
                .fluidOutputs(GoldLeachSolution.getFluid(6000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityCarbon")
                .fluidInputs(Nitrogen.getFluid(1000))
                .output(dust, ActivatedCarbon)
                .duration(1440)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, ActivatedCarbon, 4)
                .fluidInputs(GoldLeachSolution.getFluid(6000))
                .output(dust, LoadedCarbon, 4)
                .fluidOutputs(SodiumHydroxideSolution.getFluid(4000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumCyanide)
                .input(dust, SodiumHydroxide)
                .fluidInputs(DistilledWater.getFluid(9000))
                .fluidOutputs(GoldEluent.getFluid(9000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, LoadedCarbon)
                .fluidInputs(GoldEluent.getFluid(1000))
                .output(dust, SpentActivatedCarbon)
                .fluidOutputs(GoldEluteSolution.getFluid(1000))
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, SpentActivatedCarbon)
                .fluidInputs(HydrochloricAcid.getFluid(5))
                .output(dust, WashedActivatedCarbon)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, WashedActivatedCarbon)
                .fluidInputs(Air.getFluid(100))
                .output(dust, ActivatedCarbon)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(wireFine, Steel, 8)
                .notConsumable(plate, StainlessSteel, 8)
                .notConsumable(plate, Polyethylene, 8)
                .fluidInputs(GoldEluteSolution.getFluid(1000))
                .output(wireFine, GoldPlatedSteel, 16)
                .fluidOutputs(Oxygen.getFluid(500))
                .fluidOutputs(MixedCyanideSolution.getFluid(500))
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MixedCyanideSolution.getFluid(500))
                .output(dust, SodiumCyanide, 3)
                .fluidOutputs(Water.getFluid(500))
                .fluidOutputs(HydrogenCyanide.getFluid(1000))
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(wireFine, GoldPlatedSteel, 16)
                .fluidInputs(NitricAcid.getFluid(6000))
                .output(dust, Gold)
                .fluidOutputs(NitrogenDioxide.getFluid(3000))
                .fluidOutputs(IronIIINitrateSolution.getFluid(3000))
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(IronIIINitrateSolution.getFluid(6000))
                .output(dust, IronIIIOxide, 5)
                .fluidOutputs(Steam.getFluid(6000))
                .fluidOutputs(NitrogenDioxide.getFluid(6000))
                .fluidOutputs(Oxygen.getFluid(3000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

//PURIFIED GOLD (SPECIALIZED)
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenChloride.getFluid(150))
                .fluidInputs(NitricAcid.getFluid(50))
                .fluidOutputs(AquaRegia.getFluid(200))
                .duration(6)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Gold, 3)
                .fluidInputs(AquaRegia.getFluid(16000))
                .fluidOutputs(ChloroauricAcidSolution.getFluid(1000))
                .chancedOutput(dust, SilverChloride, 1000, 0)
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(ChloroauricAcidSolution.getFluid(1000))
                .output(dust, ChloroauricAcid, 15)
                .fluidOutputs(Steam.getFluid(6500))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(500))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ChloroauricAcid, 5)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(WohlwillElectrolyte.getFluid(1000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(plate, Gold)
                .fluidInputs(WohlwillElectrolyte.getFluid(250))
                .notConsumable(plate, Titanium)
                .notConsumable(WohlwillElectrolyte.getFluid(1000))
                .output(dust, HighPurityGold)
                .output(ANODE_SLIME_GOLD)
                .fluidOutputs(SpentWohlwilElectrolyte.getFluid(250))
                .duration(480)
                .EUt(120)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(plate, Gold)
                .fluidInputs(WohlwillElectrolyte.getFluid(250))
                .notConsumable(plate, HighPurityGold)
                .notConsumable(WohlwillElectrolyte.getFluid(1000))
                .output(dust, HighPurityGold)
                .output(ANODE_SLIME_GOLD)
                .fluidOutputs(SpentWohlwilElectrolyte.getFluid(250))
                .duration(560)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SpentWohlwilElectrolyte.getFluid(2000))
                .fluidInputs(SulfurDioxide.getFluid(3000))
                .output(dust, Gold)
                .fluidOutputs(SulfuricPGMSolution.getFluid(1000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        //Au3+ + 3e- --> Au
        //SO2 + 2H2O --> SO4 2- + 4H+ + 2e-
        //2 Au3+ + 3SO2 + 6H2O --> 3SO4 2- + 12H+
        //in solution containing 2 H+, 8 Cl-, 4 HCl
        //added products: 3 SO4 2-, 12 H+
        //final solution: 12 HCl, 3 H2SO4, 8 H2O

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 15)
                .fluidInputs(SulfuricPGMSolution.getFluid(1000))
                .output(dust, CalciumSulfate, 18)
                .fluidOutputs(PGMSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//ANODE SLIME PROCESSING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(ANODE_SLIME_SILVER, 27)
                .fluidInputs(AquaRegia.getFluid(16000))
                .fluidOutputs(ChloroauricAcidSolution.getFluid(1000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(ANODE_SLIME_GOLD, 18)
                .fluidInputs(NitricAcid.getFluid(2000))
                .fluidOutputs(PGMSolution.getFluid(1000))
                .fluidOutputs(SilverNitrateSolution.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();
    }
}
