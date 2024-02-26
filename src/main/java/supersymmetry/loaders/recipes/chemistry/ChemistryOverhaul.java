package supersymmetry.loaders.recipes.chemistry;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.loaders.recipes.Utils.CarbonSource;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static gregtechfoodoption.GTFOMaterialHandler.AceticAnhydride;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.materials.SusyMaterials.SodiumCyanide;

public class ChemistryOverhaul {
    public static void init() {
        CarbonSource[] CarbonGlobalsSources = {
                new CarbonSource(OreDictUnifier.get(dust, HighPurityCarbon), 100, OreDictUnifier.get(dustTiny, Ash), 1),
                new CarbonSource(OreDictUnifier.get(dust, Carbon), 100, OreDictUnifier.get(dustTiny, Ash), 1),
                new CarbonSource(OreDictUnifier.get(gem, Coke), 100, OreDictUnifier.get(dustTiny, Ash), 2),
                new CarbonSource(OreDictUnifier.get(dust, Coke), 100, OreDictUnifier.get(dustTiny, Ash), 2),
                new CarbonSource(OreDictUnifier.get(gem, Anthracite), 100, OreDictUnifier.get(dustTiny, Ash), 2),
                new CarbonSource(OreDictUnifier.get(dust, Anthracite), 100, OreDictUnifier.get(dustTiny, Ash), 2),
                new CarbonSource(OreDictUnifier.get(gem, LigniteCoke), 75, OreDictUnifier.get(dustTiny, Ash), 3),
                new CarbonSource(OreDictUnifier.get(dust, LigniteCoke), 75, OreDictUnifier.get(dustTiny, Ash), 3),
                new CarbonSource(OreDictUnifier.get(gem, Coal), 75, OreDictUnifier.get(dustTiny, Ash), 4),
                new CarbonSource(OreDictUnifier.get(dust, Coal), 75, OreDictUnifier.get(dustTiny, Ash), 4),
                new CarbonSource(OreDictUnifier.get(gem, Charcoal), 75, OreDictUnifier.get(dustTiny, Ash), 4),
                new CarbonSource(OreDictUnifier.get(dust, Charcoal), 75, OreDictUnifier.get(dustTiny, Ash), 4),
                new CarbonSource(OreDictUnifier.get(dust, Charcoal), 75, OreDictUnifier.get(dustTiny, Ash), 4),
                new CarbonSource(OreDictUnifier.get(gem, Lignite), 25, OreDictUnifier.get(dustTiny, Ash), 4),
                new CarbonSource(OreDictUnifier.get(dust, Lignite), 25, OreDictUnifier.get(dustTiny, Ash), 4)
        };

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, Iron, 4)
                .input(pipeTinyFluid, Steel, 4)
                .output(CATALYST_BED_SUPPORT_GRID)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

// Soap

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(250))
                .fluidInputs(FishOil.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(250))
                .fluidInputs(FishOil.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(EthanolWaterAzeotrope.getFluid(280))
                .fluidInputs(FishOil.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(250))
                .fluidInputs(SeedOil.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(250))
                .fluidInputs(SeedOil.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(EthanolWaterAzeotrope.getFluid(280))
                .fluidInputs(SeedOil.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(250))
                .fluidInputs(Stearin.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(250))
                .fluidInputs(Stearin.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(EthanolWaterAzeotrope.getFluid(280))
                .fluidInputs(Stearin.getFluid(6000))
                .fluidOutputs(BioDiesel.getFluid(6000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Ammonium Chloride

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(AmmoniumChlorideSolution.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumChlorideSolution.getFluid(1000))
                .output(dust, AmmoniumChloride, 6)
                .fluidOutputs(Water.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        // Carbon Monoxide ROASTER_RECIPES
        // TODO: set output according to carbon amount?
        for (CarbonSource carbon : CarbonGlobalsSources) {
            carbon.name.setCount(carbon.equivalent(1));

            ROASTER_RECIPES.recipeBuilder()
                    .fluidInputs(Oxygen.getFluid(1000))
                    .inputs(carbon.name)
                    .circuitMeta(1)
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .duration(80)
                    .EUt(7)
                    .buildAndRegister();
        }

        // Carbon Dioxide ROASTER_RECIPES
        // TODO: set output according to carbon amount?
        for (CarbonSource carbon : CarbonGlobalsSources) {
            ROASTER_RECIPES.recipeBuilder()
                    .fluidInputs(Oxygen.getFluid(2000))
                    .inputs(carbon.name)
                    .circuitMeta(2)
                    .fluidOutputs(CarbonDioxide.getFluid(1000))
                    .duration(40)
                    .EUt(7)
                    .buildAndRegister();
        }

        //CARBON DISULFIDE

        for (CarbonSource carbon : CarbonGlobalsSources) {
            ROASTER_RECIPES.recipeBuilder()
                    .inputs(carbon.name)
                    .input("dustAnyPuritySulfur", 2)
                    .fluidOutputs(CarbonDisulfide.getFluid(1000))
                    .duration(100)
                    .EUt(60)
                    .buildAndRegister();
        }


// Phosphorous Pentoxide ROASTER_RECIPES

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(10000))
                .input("dustAnyPurityPhosphorus", 4)
                .output(dust, PhosphorusPentoxide, 14)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

// Sulfur Dioxide ROASTER_RECIPES

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(2000))
                .input("dustAnyPuritySulfur", 1)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(60)
                .EUt(7)
                .buildAndRegister();

//Phosphoric Acid batch

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhosphorusPentoxide)
                .fluidInputs(Water.getFluid(6000))
                .fluidOutputs(PhosphoricAcid.getFluid(4000))
                .duration(40)
                .EUt(30)
                .buildAndRegister();

//Hydrochloric Acid

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(50))
                .fluidInputs(Chlorine.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidInputs(Water.getFluid(50))
                .fluidOutputs(HydrochloricAcid.getFluid(50))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidInputs(Water.getFluid(100))
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(100))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(50))
                .fluidInputs(Water.getFluid(50))
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(100))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

//Chlorine

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, CopperIIChloride)
                .fluidInputs(HydrogenChloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(500))
                .fluidOutputs(Chlorine.getFluid(1000))
                .fluidOutputs(Steam.getFluid(500))
                .duration(40)
                .EUt(120)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, RutheniumIVOxide)
                .fluidInputs(HydrogenChloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(500))
                .fluidOutputs(Chlorine.getFluid(1000))
                .fluidOutputs(Steam.getFluid(500))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

// Hexafluorosilicic Acid

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 3)
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .fluidOutputs(DilutedHexafluorosilicicAcid.getFluid(9000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedHexafluorosilicicAcid.getFluid(9000))
                .fluidOutputs(HexafluorosilicicAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(8000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Hydrofluoric acid

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Fluorite, 3)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(HydrogenFluoride.getFluid(2000))
                .output(dust, CalciumSulfate, 6)
                .duration(30)
                .EUt(7)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(50))
                .fluidInputs(Fluorine.getFluid(50))
                .fluidOutputs(HydrogenFluoride.getFluid(50))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenFluoride.getFluid(50))
                .fluidInputs(Water.getFluid(50))
                .fluidOutputs(HydrofluoricAcid.getFluid(50))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, CalciumSulfate, 6)
                .input("dustAnyPurityCarbon", 2)
                .output(dust, CalciumSulfide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .duration(30)
                .EUt(7)
                .buildAndRegister();

// Fe2O3

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(4000))
                .input(dust, Iron, 3)
                .output(dust, IronTwoThreeOxide, 7)
                .fluidOutputs(Hydrogen.getFluid(8000))
                .duration(160)
                .EUt(60)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(4000))
                .input(dust, HighPurityIron, 3)
                .output(dust, PurifiedIronTwoThreeOxide, 7)
                .fluidOutputs(Hydrogen.getFluid(8000))
                .duration(160)
                .EUt(60)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(1000))
                .input(dust, IronTwoThreeOxide, 14)
                .output(dust, IronIIIOxide, 15)
                .duration(160)
                .EUt(60)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(1000))
                .input(dust, PurifiedIronTwoThreeOxide, 14)
                .output(dust, PurifiedIronIIIOxide, 15)
                .duration(160)
                .EUt(60)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .input(dust, IronIISulfide, 2)
                .output(dust, IronSulfate, 6)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .input("dustAnyPurityIron", 1)
                .output(dust, IronSulfate, 6)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, IronSulfate, 12)
                .output(dust, IronIIIOxide, 5)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Hydrogen Sulfide

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, IronIISulfide, 2)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, IronIIChloride, 3)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(30)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPuritySulfur", 1)
                .input("dustAnyPurityIron", 1)
                .output(dust, IronIISulfide, 2)
                .duration(160)
                .EUt(7)
                .buildAndRegister();

// Antimony Trioxide ROASTER_RECIPES
        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(3000))
                .input("dustAnyPurityAntimony", 1)
                .output(dust, AntimonyTrioxide)
                .duration(60)
                .EUt(7)
                .buildAndRegister();

// Sodium bisulfate and related

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfate, 7)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, SodiumBisulfate, 14)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumBisulfate, 7)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(SodiumBisulfateSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SaltWater.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(SodiumBisulfateSolution.getFluid(50))
                .duration(1)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumChlorideSolution.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(PotassiumBisulfateSolution.getFluid(50))
                .duration(1)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumBisulfateSolution.getFluid(1000))
                .output(dust, SodiumBisulfate, 7)
                .fluidOutputs(Water.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumBisulfateSolution.getFluid(1000))
                .output(dust, PotassiumBisulfate, 7)
                .fluidOutputs(Water.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumBisulfate, 14)
                .output(dust, SodiumSulfate, 7)
                .fluidOutputs(Steam.getFluid(1000))
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, PotassiumBisulfate, 14)
                .output(dust, PotassiumSulfate, 7)
                .fluidOutputs(Steam.getFluid(1000))
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, PotassiumBisulfate, 14)
                .output(dust, PotassiumPyrosulfate, 11)
                .fluidOutputs(Steam.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .input(dust, Saltpeter, 5)
                .fluidOutputs(NitricAcid.getFluid(1000))
                .output(dust, PotassiumBisulfate, 7)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

// Sodium Sulfide

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfate, 7)
                .input("dustAnyPurityCarbon", 2)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .output(dust, SodiumSulfide, 3)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

// Silicon Dioxide

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Quartzite)
                .output(dust, SiliconDioxide)
                .duration(60)
                .EUt(8)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, NetherQuartz)
                .output(dust, SiliconDioxide)
                .duration(60)
                .EUt(8)
                .buildAndRegister();

// Antimony trifluoride

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .input(dust, AntimonyTrioxide, 5)
                .output(dust, WetAntimonyTrifluoride, 8)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .input(dust, WetAntimonyTrifluoride, 4)
                .fluidOutputs(Water.getFluid(4500))
                .output(dust, AntimonyTrifluoride, 4)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Chlorofluoromethanes

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(3000))
                .input("dustAnyPurityAntimony", 1)
                .output(dust, AntimonyTrichloride, 4)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AntimonyTrichloride.getFluid(72))
                .fluidInputs(Chlorine.getFluid(250))
                .fluidOutputs(AntimonyPentachloride.getFluid(125))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(CarbonTetrachloride.getFluid(150))
                .fluidInputs(HydrogenFluoride.getFluid(300))
                .fluidInputs(AntimonyPentachloride.getFluid(50))
                .fluidOutputs(ChlorofluoromethaneMix.getFluid(500))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChlorofluoromethaneMix.getFluid(5000))
                .fluidOutputs(AntimonyPentachloride.getFluid(500))
                .fluidOutputs(Trichlorofluoromethane.getFluid(500))
                .fluidOutputs(Dichlorodifluoromethane.getFluid(500))
                .fluidOutputs(Chlorotrifluoromethane.getFluid(500))
                .fluidOutputs(HydrogenChloride.getFluid(3000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Synthetic methane

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Nickel)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(8000))
                .fluidOutputs(Methane.getFluid(1000))
                .fluidOutputs(Steam.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Nickel)
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(6000))
                .fluidOutputs(Methane.getFluid(1000))
                .fluidOutputs(Steam.getFluid(1000))
                .duration(150)
                .EUt(120)
                .buildAndRegister();


// Chloroform

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(50))
                .fluidInputs(Chlorine.getFluid(250))
                .fluidOutputs(ChlorinatedMethaneMixture.getFluid(200))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChlorinatedMethaneMixture.getFluid(4000))
                .fluidOutputs(CarbonTetrachloride.getFluid(250))
                .fluidOutputs(Chloroform.getFluid(250))
                .fluidOutputs(Dichloromethane.getFluid(250))
                .fluidOutputs(Chloromethane.getFluid(250))
                .fluidOutputs(HydrogenChloride.getFluid(2500))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Chloromethane.getFluid(15))
                .fluidInputs(Chlorine.getFluid(60))
                .fluidOutputs(ChlorinatedChloromethaneMixture.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChlorinatedChloromethaneMixture.getFluid(5000))
                .fluidOutputs(CarbonTetrachloride.getFluid(500))
                .fluidOutputs(Chloroform.getFluid(500))
                .fluidOutputs(Dichloromethane.getFluid(500))
                .fluidOutputs(HydrogenChloride.getFluid(3000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloromethane.getFluid(50))
                .fluidInputs(Chlorine.getFluid(150))
                .fluidOutputs(ChlorinatedDichloromethaneMixture.getFluid(150))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChlorinatedDichloromethaneMixture.getFluid(3000))
                .fluidOutputs(CarbonTetrachloride.getFluid(500))
                .fluidOutputs(Chloroform.getFluid(500))
                .fluidOutputs(HydrogenChloride.getFluid(1500))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Chloroform.getFluid(50))
                .fluidInputs(Chlorine.getFluid(50))
                .fluidOutputs(CarbonTetrachloride.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

// Chloromethane alternative production

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(50))
                .fluidInputs(HydrochloricAcid.getFluid(50))
                .fluidOutputs(ChloromethaneSolution.getFluid(150))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChloromethaneSolution.getFluid(3000))
                .fluidOutputs(Water.getFluid(2000))
                .fluidOutputs(Chloromethane.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Calcium Chloride
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Calcite, 5), OreDictUnifier.get(dust, Salt, 4));

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .input(dust, CalciumSulfide, 2)
                .fluidOutputs(CalciumChlorideSolution.getFluid(1000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(CalciumChlorideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, CalciumChloride, 3)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Soda Ash

// Soda Ash (Sodium Carbonate) Dust * 1
        removeRecipesByInputs(CENTRIFUGE_RECIPES, SodiumCarbonateSolution.getFluid(1000));
// Sodium Carbonate Solution * 1000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, SodaAsh)}, new FluidStack[]{Water.getFluid(1000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, SodaAsh)}, new FluidStack[]{Water.getFluid(1000)});
// Dutched Chocolate Liquor * 1
//        removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{new ItemStack(CHOCOLATE_LIQUOR_REFINED_CRUSHED))}, new FluidStack[]{SodiumCarbonateSolution.getFluid(1000)})

//        CHEMICAL_BATH_RECIPES.recipeBuilder()
//                .inputs(metaitem('gregtechfoodoption:chocolate_liquor_refined_crushed'))
//                .notConsumable(SodaAshSolution.getFluid(1000))
//                .outputs(metaitem('gregtechfoodoption:chocolate_liquor_dutched_crushed'))
//                .duration(160)
//                .EUt(540)
//                .buildAndRegister();

// Leblanc process

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .input(dust, Salt, 4)
                .fluidOutputs(HydrochloricAcid.getFluid(1000))
                .output(dust, SodiumSulfate, 7)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfide, 3)
                .input(dust, Calcite, 5)
                .output(dust, BlackAsh, 8)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, SodaAsh, 6)
                .fluidOutputs(SodaAshSolution.getFluid(1000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, BlackAsh, 8)
                .fluidOutputs(SodaAshSolution.getFluid(1000))
                .output(dust, CalciumSulfide, 2)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodaAshSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, SodaAsh, 6)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        // Solvay Process

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(SaltWater.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSaltwater.getFluid(100))
                .fluidInputs(CarbonDioxide.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(AmmoniacalSodiumBicarbonateSolution.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniacalSodiumBicarbonateSolution.getFluid(1000))
                .fluidOutputs(AmmoniumChlorideSolution.getFluid(1000))
                .output(dust, SodiumBicarbonate, 6)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumChloride, 12)
                .input(dust, Quicklime, 2)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(Steam.getFluid(1000))
                .output(dust, CalciumChloride, 3)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Calcite, 5)
                .circuitMeta(1)
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .output(dust, Quicklime, 2)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .circuitMeta(1)
                .fluidInputs(CarbonDioxide.getFluid(3000))
                .output(dust, Calcite, 5)
                .duration(120)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Limestone, 5)
                .circuitMeta(2)
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .output(dust, Quicklime, 2)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumChlorideSolution.getFluid(2000))
                .input(dust, Quicklime, 2)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(CalciumChlorideSolution.getFluid(2000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumBicarbonate, 12)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(Steam.getFluid(1000))
                .output(dust, SodaAsh, 6)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumBicarbonate, 6)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

// Acetic Acid

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(100))
                .fluidInputs(Oxygen.getFluid(100))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(Acetaldehyde.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Acetaldehyde.getFluid(100))
                .fluidInputs(Oxygen.getFluid(100))
                .notConsumable(catalystBed, Cobalt)
                .fluidOutputs(AceticAcid.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

// Nitrous Oxide

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumNitrate, 9)
                .fluidOutputs(Steam.getFluid(2000))
                .fluidOutputs(NitricOxide.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(100))
                .fluidInputs(Oxygen.getFluid(250))
                .fluidOutputs(Steam.getFluid(150))
                .fluidOutputs(NitricOxide.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

// Ethylene

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HotSulfuricAcid.getFluid(90))
                .fluidInputs(EthanolWaterAzeotrope.getFluid(100))
                .fluidOutputs(Ethylene.getFluid(90))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(180))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HotSulfuricAcid.getFluid(100))
                .fluidInputs(Ethanol.getFluid(100))
                .fluidOutputs(Ethylene.getFluid(100))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(200))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        Material[] dyes = {DyeBlack, DyeRed, DyeGreen, DyeBrown, DyeBlue, DyePurple, DyeCyan, DyeLightGray, DyeGray, DyePink, DyeLime, DyeYellow, DyeLightBlue, DyeMagenta, DyeOrange, DyeWhite};
        String[] dyesUppercase = {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "LightGray", "Gray", "Pink", "Lime", "Yellow", "LightBlue", "Magenta", "Orange", "White"};
        for (int i = 0; i < 16; i++) {
            MIXER_RECIPES.recipeBuilder()
                    .input("dye" + dyesUppercase[i], 1)
                    .input(dust, Salt, 2)
                    .fluidInputs(SulfuricAcid.getFluid(250))
                    .fluidOutputs(dyes[i].getFluid(288))
                    .duration(160)
                    .EUt(24)
                    .buildAndRegister();
        }

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(500))
                .fluidOutputs(Water.getFluid(500))
                .fluidOutputs(HydrogenChloride.getFluid(500))
                .duration(50)
                .EUt(30)
                .buildAndRegister();

// Tetrafluoroethylene

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Chloroform.getFluid(50))
                .fluidInputs(HydrogenFluoride.getFluid(100))
                .fluidOutputs(AcidicChlorodifluoromethane.getFluid(150))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(AcidicChlorodifluoromethane.getFluid(3000))
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(Chlorodifluoromethane.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .fluidInputs(AcidicChlorodifluoromethane.getFluid(6000))
                .fluidOutputs(AcidicTetrafluoroethylene.getFluid(5000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(AcidicTetrafluoroethylene.getFluid(5000))
                .fluidInputs(Water.getFluid(4000))
                .fluidOutputs(Tetrafluoroethylene.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Tetranitromethane

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(NitricAcid.getFluid(150))
                .fluidInputs(Acetylene.getFluid(50))
                .fluidOutputs(TrinitromethaneSolution.getFluid(150))
                .fluidOutputs(CarbonMonoxide.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(TrinitromethaneSolution.getFluid(150))
                .fluidInputs(NitrationMixture.getFluid(100))
                .fluidOutputs(TetranitromethaneSolution.getFluid(250))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(TetranitromethaneSolution.getFluid(5000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Tetranitromethane.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Ammonia

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, AmmoniumChloride, 6)
                .fluidOutputs(AmmoniumChlorideSolution.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumChlorideSolution.getFluid(50))
                .fluidInputs(SodiumHydroxideSolution.getFluid(50))
                .fluidOutputs(Ammonia.getFluid(50))
                .fluidOutputs(SaltWater.getFluid(50))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

// Dinitrogen Tetroxide

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(NitrogenDioxide.getFluid(2000))
                .fluidOutputs(DinitrogenTetroxide.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// 1,1-dimethylhydrazine

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Monochloramine.getFluid(50))
                .fluidInputs(Dimethylamine.getFluid(50))
                .fluidOutputs(Dimethylhydrazine.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Monomethylhydrazine

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Monochloramine.getFluid(50))
                .fluidInputs(Methylamine.getFluid(50))
                .fluidOutputs(Monomethylhydrazine.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Vinyl acetate

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AceticAcid.getFluid(50))
                .fluidInputs(Ethylene.getFluid(50))
                .notConsumable(catalystBed, Palladium)
                .fluidOutputs(VinylAcetate.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Hypochlorous Acid

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(50))
                .fluidInputs(Chlorine.getFluid(100))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(HypochlorousAcid.getFluid(50))
                .duration(6)
                .EUt(30)
                .buildAndRegister();


// PVB

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PolyvinylAcetate.getFluid(144))
                .fluidInputs(Butyraldehyde.getFluid(250))
                .fluidOutputs(PolyvinylButyral.getFluid(250))
                .duration(400)
                .EUt(480)
                .buildAndRegister();

// Cyclohexane

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(300))
                .fluidInputs(Benzene.getFluid(50))
                .notConsumable(dust, ActivatedRaneyNickel, 1)
                .fluidOutputs(Cyclohexane.getFluid(50))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Iron(III)-chloride

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(1000))
                .input(dust, IronIIChloride, 3)
                .output(dust, Iron3Chloride, 4)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(6000))
                .input("dustAnyPurityIron", 2)
                .output(dust, Iron3Chloride, 8)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, Iron3Chloride, 4)
                .fluidOutputs(IronIIIChlorideSolution.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Fluoroantimonic Acid

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(HydrofluoricAcid.getFluid(4000))
                .input(dust, AntimonyTrifluoride, 4)
                .fluidOutputs(FluoroantimonicAcid.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(3000)
                .EUt(480)
                .buildAndRegister();

// Sodium Potassium

        MIXER_RECIPES.recipeBuilder()
                .input("dustAnyPuritySodium", 1)
                .input("dustAnyPurityPotassium", 1)
                .fluidOutputs(SodiumPotassium.getFluid(1000))
                .duration(3000)
                .EUt(30)
                .buildAndRegister();

// Polyphenylene Sulfide

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(NMethylTwoPyrrolidone.getFluid(1000))
                .input(dust, Dichlorobenzene, 12)
                .input(dust, SodiumSulfide, 3)
                .fluidOutputs(SaltyNMethylTwoPyrrolidone.getFluid(1000))
                .output(dust, PolyphenyleneSulfide, 11)
                .duration(600)
                .EUt(240)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SaltyNMethylTwoPyrrolidone.getFluid(1000))
                .fluidOutputs(NMethylTwoPyrrolidone.getFluid(1000))
                .output(dust, Salt, 4)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

// Nitric Acid, Nitrogen Dioxide

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(50))
                .fluidInputs(NitricOxide.getFluid(50))
                .fluidOutputs(NitrogenDioxide.getFluid(50))
                .duration(8)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(50))
                .fluidInputs(NitrogenDioxide.getFluid(150))
                .fluidOutputs(NitricAcid.getFluid(100))
                .fluidOutputs(NitricOxide.getFluid(50))
                .duration(12)
                .EUt(30)
                .buildAndRegister();

// Methyl Acetate

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AceticAcid.getFluid(50))
                .fluidInputs(Methanol.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(MethylAcetateSolution.getFluid(150))
                .duration(12)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylAcetateSolution.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(MethylAcetate.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

// Chlorobenzene

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Benzene.getFluid(50))
                .fluidInputs(Chlorine.getFluid(100))
                .notConsumable(dust, Iron3Chloride)
                .fluidOutputs(Chlorobenzene.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(12)
                .EUt(30)
                .buildAndRegister();

// Chloronitrobenzenes

        CSTR_RECIPES.recipeBuilder()
                .notConsumable(spring, Nichrome)
                .fluidInputs(Chlorobenzene.getFluid(50))
                .fluidInputs(NitrationMixture.getFluid(100))
                .fluidOutputs(AcidicChloronitrobenzeneMixture.getFluid(100))
                .duration(10)
                .EUt(480)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(AcidicChloronitrobenzeneMixture.getFluid(2000))
                .output(dust, MixedChloronitrobenzene)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(2000))
                .duration(50)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(MixedChloronitrobenzene.getFluid(144))
                .chancedOutput(dust, FourChloronitrobenzene, 6500, 0)
                .fluidOutputs(TwoChloronitrobenzene.getFluid(48))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//Phosgene

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(50))
                .fluidInputs(Chlorine.getFluid(100))
                .notConsumable(OreDictUnifier.get("dustAnyPurityCarbon"))
                .fluidOutputs(Phosgene.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(CarbonTetrachloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidOutputs(Phosgene.getFluid(1000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .duration(30)
                .EUt(120)
                .buildAndRegister();

// Rutile

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(Chlorine.getFluid(4000))
                .output(dust, TitaniumDioxide, 3)
                .duration(200)
                .EUt(480)
                .buildAndRegister();

        OreDictUnifier.registerOre(OreDictUnifier.get(dust, TitaniumDioxide), "dyeWhite");

// Butyraldehyde

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, DicobaltOctacarbonyl, 18)
                .fluidInputs(Propene.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(HotHighPressureHydrogen.getFluid(2000))
                .fluidOutputs(ButyraldehydeMixture.getFluid(1000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ButyraldehydeMixture.getFluid(1000))
                .output(dust, DicobaltOctacarbonyl, 18)
                .fluidOutputs(Butyraldehyde.getFluid(800))
                .fluidOutputs(Isobutyraldehyde.getFluid(200))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Isobutyl alcohol

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutyraldehyde.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .notConsumable(catalystBedReduction, MarkerMaterials.Tier.HV)
                .fluidOutputs(IsobutylAlcohol.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutyraldehyde.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(IsobutylAlcohol.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

// Salt from Sodium and Chlorine

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(1000))
                .input("dustAnyPuritySodium", 1)
                .output(dust, Salt, 2)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

// Rock Salt from Sodium and Chlorine

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(1000))
                .input("dustAnyPurityPotassium", 1)
                .output(dust, RockSalt, 2)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

// TNT

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(NitrationMixture.getFluid(6000))
                .fluidOutputs(TNTSlurry.getFluid(3000))
                .duration(200)
                .EUt(24)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(TNTSlurry.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .output(dust, TNT, 7)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Sulfur Trioxide

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .notConsumable(dust, VanadiumPentoxide)
                .fluidOutputs(SulfurTrioxide.getFluid(1000))

                .duration(200)
                .EUt(7)
                .buildAndRegister();

// Saltpeter and Sodium Hydroxide Solution

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(1000))
                .input(dust, SodiumHydroxide, 3)
                .fluidOutputs(SodiumHydroxideSolution.getFluid(1000))
                .duration(80)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, AmmoniumNitrate, 9)
                .fluidOutputs(AmmoniumNitrateSolution.getFluid(1000))
                .duration(80)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, PotassiumHydroxide, 3)
                .fluidOutputs(PotassiumHydroxideSolution.getFluid(1000))
                .duration(80)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, RockSalt, 2)
                .fluidOutputs(PotassiumChlorideSolution.getFluid(1000))
                .duration(80)
                .EUt(7)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumNitrateSolution.getFluid(50))
                .fluidInputs(PotassiumHydroxideSolution.getFluid(50))
                .fluidOutputs(Ammonia.getFluid(50))
                .fluidOutputs(DilutedSaltpeterSolution.getFluid(150))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSaltpeterSolution.getFluid(3000))
                .fluidOutputs(Water.getFluid(3000))
                .output(dust, Saltpeter, 5)
                .duration(300)
                .EUt(24)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumNitrateSolution.getFluid(50))
                .fluidInputs(PotassiumChlorideSolution.getFluid(50))
                .fluidOutputs(NitrateSolution.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(NitrateSolution.getFluid(2000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, NitrateSaltMix, 11)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, NitrateSaltMix, 11)
                .output(dust, AmmoniumChloride, 6)
                .output(dust, Saltpeter, 5)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(NitricAcid.getFluid(50))
                .fluidInputs(PotassiumHydroxideSolution.getFluid(50))
                .fluidOutputs(SaltpeterSolution.getFluid(100))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SaltpeterSolution.getFluid(2000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, Saltpeter, 5)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(NitricAcid.getFluid(1000))
                .input(dust, SodiumHydroxide, 3)
                .fluidOutputs(SodiumNitrateSolution.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumNitrateSolution.getFluid(50))
                .fluidInputs(PotassiumChlorideSolution.getFluid(50))
                .fluidOutputs(SaltySaltpeterSolution.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SaltySaltpeterSolution.getFluid(2000))
                .fluidOutputs(SaltWater.getFluid(1000))
                .output(dust, Saltpeter, 5)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Molecular Sieves

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSilicateSolution.getFluid(1000))
                .output(dust, SodiumSilicate, 6)
                .fluidOutputs(Water.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .fluidInputs(Steam.getFluid(1000))
                .input(dust, SiliconDioxide, 3)
                .fluidOutputs(DilutedSodiumSilicateSolution.getFluid(4000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumAluminateSolution.getFluid(1500))
                .fluidOutputs(Water.getFluid(1500))
                .output(dust, SodiumAluminate, 4)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .input("dustAnyPurityAluminium", 2)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .output(dust, SodiumAluminate, 8)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSodiumSilicateSolution.getFluid(4000))
                .input(dust, SodiumAluminate, 4)
                .fluidOutputs(RawMolecularSieve.getFluid(4000))
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSilicateSolution.getFluid(1000))
                .input(dust, SodiumAluminate, 4)
                .fluidOutputs(RawMolecularSieve.getFluid(4000))
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSodiumSilicateSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(750))
                .fluidOutputs(SodiumSilicateSolution.getFluid(250))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(RawMolecularSieve.getFluid(4000))
                .output(dust, MolecularSieve, 10)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, MolecularSieve, 1)
                .input(dust, Clay, 1)
                .output(CRACKING_CATALYST)
                .duration(100)
                .EUt(60)
                .buildAndRegister();

//Glyceryl Trinitrate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Glycerol.getFluid(1000))
                .fluidInputs(NitrationMixture.getFluid(6000))
                .fluidOutputs(GlycerylTrinitrate.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(6000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Allyl Chloride

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(100))
                .fluidInputs(HotHighPressurePropene.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(AllylChloride.getFluid(50))
                .duration(8)
                .EUt(30)
                .buildAndRegister();

// Monochloramine

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(100))
                .fluidInputs(Chlorine.getFluid(100))
                .fluidOutputs(ImpureBleach.getFluid(200))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureBleach.getFluid(4000))
                .fluidOutputs(Water.getFluid(2000))
                .fluidOutputs(Bleach.getFluid(1000))
                .output(dust, Salt, 2)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Bleach.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .fluidOutputs(Monochloramine.getFluid(1000))
                .fluidOutputs(SodiumHydroxideSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Dichlorobenzene

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Toluene.getFluid(50))
                .fluidInputs(Chlorobenzene.getFluid(50))
                .fluidInputs(Chlorine.getFluid(100))
                .notConsumable(catalystBed, IronIIChloride, 1)
                .fluidOutputs(MixedDichlorobenzeneSolution.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MixedDichlorobenzeneSolution.getFluid(1000))
                .fluidOutputs(OneTwoDichlorobenzeneSolution.getFluid(400))
                .fluidOutputs(OneFourDichlorobenzeneSolution.getFluid(600))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(OneFourDichlorobenzeneSolution.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(1000))
                .output(dust, Dichlorobenzene, 12)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(OneTwoDichlorobenzeneSolution.getFluid(1000))
                .fluidOutputs(Toluene.getFluid(1000))
                .output(dust, OneTwoDichlorobenzene, 12)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

//acetylene

        for (CarbonSource carbon : CarbonGlobalsSources) {
            carbon.name.setCount(carbon.equivalent(3));

            ARC_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, Quicklime, 2)
                    .inputs(carbon.name)
                    .output(dust, CalciumCarbide, 3)
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .EUt(120)
                    .duration(400)
                    .buildAndRegister();
        }


        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumCarbide, 3)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, CalciumHydroxide, 5)
                .fluidOutputs(Acetylene.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

//dealing with calcium hydroxide

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, Calcite, 5)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, CalciumHydroxide, 5)
                .output(dust, Quicklime, 2)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

//ammonium nitrate

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(NitricAcid.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(AmmoniumNitrateSolution.getFluid(50))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumNitrateSolution.getFluid(1000))
                .output(dust, AmmoniumNitrate, 2)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(90)
                .duration(300)
                .buildAndRegister();

//1,2-dichloroethane

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(100))
                .fluidInputs(Ethylene.getFluid(50))
                .notConsumable(catalystBed, IronIIIOxide)
                .fluidOutputs(Dichloroethane.getFluid(50))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(50))
                .fluidInputs(HydrochloricAcid.getFluid(100))
                .fluidInputs(Oxygen.getFluid(50))
                .notConsumable(catalystBed, CopperIIChloride)
                .fluidOutputs(Dichloroethane.getFluid(50))
                .fluidOutputs(Water.getFluid(150))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

//tri/methyl/dimethylamine

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(300))
                .fluidInputs(Ammonia.getFluid(150))
                .notConsumable(dust, ImpregnatedAluminaCatalyst, 1)
                .fluidOutputs(MethylamineMix.getFluid(450))
                .duration(8)
                .EUt(120)
                .buildAndRegister();


        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylamineMix.getFluid(9000))
                .fluidOutputs(Water.getFluid(6000))
                .fluidOutputs(Methylamine.getFluid(1000))
                .fluidOutputs(Dimethylamine.getFluid(1000))
                .fluidOutputs(Trimethylamine.getFluid(1000))
                .EUt(90)
                .duration(1200)
                .buildAndRegister();

//1,4-butanediol

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Formaldehyde.getFluid(100))
                .fluidInputs(Acetylene.getFluid(50))
                .notConsumable(catalystBed, BismuthCopper, 1)
                .fluidOutputs(Butynediol.getFluid(50))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butynediol.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(200))
                .notConsumable(dust, ActivatedRaneyNickel, 1)
                .fluidOutputs(Butanediol.getFluid(50))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

// Formaldehyde

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(100))
                .fluidInputs(Oxygen.getFluid(100))
                .notConsumable(catalystBed, Silver, 1)
                .fluidOutputs(Formaldehyde.getFluid(100))
                .fluidOutputs(Water.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

//gamma-Butyrolactone


        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butanediol.getFluid(50))
                .notConsumable(catalystBed, ChromiumTrioxide, 1)
                .fluidOutputs(GammaButyrolactone.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(200))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

//N-methyl-2-pyrrolidone

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(GammaButyrolactone.getFluid(50))
                .fluidInputs(Methylamine.getFluid(50))
                .fluidOutputs(DilutedNMethylTwoPyrrolidone.getFluid(100))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedNMethylTwoPyrrolidone.getFluid(2000))
                .fluidOutputs(NMethylTwoPyrrolidone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(90)
                .duration(450)
                .buildAndRegister();

//1-bromobutane

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HydrobromicAcid.getFluid(50))
                .fluidInputs(NButanol.getFluid(50))
                .fluidOutputs(OneBromobutane.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

//n-butyllithium

        MIXER_RECIPES.recipeBuilder()
                .input("dustAnyPurityLithium", 2)
                .fluidInputs(DiethylEther.getFluid(1000))
                .fluidOutputs(LithiumSolution.getFluid(1000))
                .EUt(30)
                .duration(320)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LithiumSolution.getFluid(1000))
                .fluidInputs(OneBromobutane.getFluid(1000))
                .fluidOutputs(DilutedButyllithium.getFluid(2000))
                .output(dust, LithiumBromide, 2)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedButyllithium.getFluid(2000))
                .fluidOutputs(Butyllithium.getFluid(1000))
                .fluidOutputs(DiethylEther.getFluid(1000))
                .EUt(90)
                .duration(360)
                .buildAndRegister();

//Diethyl Ether

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(100))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(DiethylEtherSolution.getFluid(150))
                .EUt(30)
                .duration(5)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DiethylEtherSolution.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(DiethylEther.getFluid(1000))
                .EUt(90)
                .duration(600)
                .buildAndRegister();

// Useful reactions

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .fluidOutputs(DilutedRockSaltSolution.getFluid(2000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedRockSaltSolution.getFluid(2000))
                .fluidOutputs(PotassiumChlorideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(16)
                .duration(60)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumChlorideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, RockSalt, 2)
                .EUt(16)
                .duration(60)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumHydroxideSolution.getFluid(100))
                .fluidInputs(CarbonDioxide.getFluid(50))
                .fluidOutputs(DilutedPotassiumCarbonateSolution.getFluid(150))
                .EUt(30)
                .duration(15)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedPotassiumCarbonateSolution.getFluid(3000))
                .output(dust, PotassiumCarbonate, 6)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(30)
                .duration(400)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumChlorideSolution.getFluid(2000))
                .input(dust, CalciumHydroxide, 5)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(DilutedCalciumChlorideSolution.getFluid(2000))
                .EUt(30)
                .duration(360)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedCalciumChlorideSolution.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .output(dust, CalciumChloride, 3)
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, PotassiumCarbonate, 6)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(PotassiumCarbonateSolution.getFluid(1000))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(PotassiumCarbonateSolution.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Calcite, 5)
                .fluidOutputs(PotassiumHydroxideSolution.getFluid(2000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(50))
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(SaltWater.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .fluidInputs(HydrogenChloride.getFluid(2000))
                .fluidOutputs(CalciumChlorideSolution.getFluid(1000))
                .duration(100)
                .EUt(16)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(HydrogenChloride.getFluid(2000))
                .fluidOutputs(DilutedCalciumChlorideSolution.getFluid(2000))
                .duration(100)
                .EUt(16)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Calcium)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, Quicklime, 2)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

//Silicon & Graphite

        for (CarbonSource carbon : CarbonGlobalsSources) {
            if (OreDictUnifier.getPrefix(carbon.name) != dust) continue;
            carbon.name.setCount(carbon.equivalent(2));

            ARC_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, SiliconDioxide, 3)
                    .inputs(carbon.name)
                    .output(dust, Silicon)
                    .circuitMeta(1)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .EUt(30)
                    .duration(300)
                    .buildAndRegister();

            ARC_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, Quartzite, 3)
                    .inputs(carbon.name)
                    .output(dust, Silicon)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .EUt(30)
                    .duration(300)
                    .buildAndRegister();

            ARC_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, CertusQuartz, 3)
                    .inputs(carbon.name)
                    .output(dust, Silicon)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .EUt(30)
                    .duration(300)
                    .buildAndRegister();

            ARC_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, NetherQuartz, 3)
                    .inputs(carbon.name)
                    .output(dust, Silicon)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .EUt(30)
                    .duration(300)
                    .buildAndRegister();

            carbon.name.setCount(carbon.equivalent(3));
            ARC_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, SiliconDioxide, 3)
                    .inputs(carbon.name)
                    .circuitMeta(2)
                    .output(dust, SiliconCarbide, 2)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .EUt(60)
                    .duration(300)
                    .buildAndRegister();
        }

        ARC_FURNACE_RECIPES.recipeBuilder()
                .input(dust, SiliconCarbide, 2)
                .output(dust, Silicon)
                .output(dust, Graphite)
                .EUt(60)
                .duration(270)
                .buildAndRegister();

//CELLULOSE ACETATE

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(MethylAcetate.getFluid(50))
                .fluidInputs(CarbonMonoxide.getFluid(50))
                .fluidOutputs(AceticAnhydride.getFluid(50))
                .EUt(480)
                .duration(1)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Cellulose)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(AceticAnhydride.getFluid(1000))
                .fluidOutputs(AcidicCelluloseSolution.getFluid(1000))
                .EUt(480)
                .duration(160)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AcidicCelluloseSolution.getFluid(50))
                .fluidInputs(AceticAcid.getFluid(50))
                .fluidInputs(Water.getFluid(50))
                .fluidOutputs(CelluloseAcetateSolution.getFluid(100))
                .EUt(480)
                .duration(1)
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(Air.getFluid(1000))
                .fluidOutputs(HotAir.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(CelluloseAcetateSolution.getFluid(2000))
                .fluidInputs(HotAir.getFluid(1000))
                .notConsumable(SPINNERET)
                .output(fiber, CelluloseAcetate, 8)
                .fluidOutputs(Air.getFluid(1000))
                .fluidOutputs(DilutedAceticAcid.getFluid(2000))
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(thread, CelluloseAcetate, 16)
                .output(CELLULOSE_ACETATE_MESH)
                .EUt(120)
                .duration(160)
                .buildAndRegister();

// Distilled Water

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(288))
                .circuitMeta(1)
                .fluidOutputs(DistilledWater.getFluid(260))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Furfural

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .input(dust, Wood, 4)
                .fluidOutputs(FurfuralSolution.getFluid(5000))
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(FurfuralSolution.getFluid(5000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Furfural.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

// Graphene

// Steam Reforming

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(HotHighPressureMethane.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .notConsumable(OreDictUnifier.get("dustAnyPurityNickel"))
                .fluidOutputs(Syngas.getFluid(7000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(HotHighPressureNaturalGas.getFluid(1500))
                .fluidInputs(Steam.getFluid(1000))
                .notConsumable(OreDictUnifier.get("dustAnyPurityNickel"))
                .fluidOutputs(Syngas.getFluid(7000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityZinc", 1)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, ZincOxide, 2)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ChromiumTrioxide, 1)
                .input(dust, IronIIIOxide, 12)
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .output(dust, HTSCatalyst, 8)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZincOxide, 1)
                .input(dust, CupricOxide, 1)
                .input(dust, Alumina, 1)
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .output(dust, LTSCatalyst, 4)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Syngas.getFluid(7000))
                .fluidInputs(Steam.getFluid(1000))
                .notConsumable(CATALYST_BED_SUPPORT_GRID)
                .fluidOutputs(ReformedSyngas.getFluid(9000))
                .duration(320)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Syngas.getFluid(7000))
                .fluidInputs(Steam.getFluid(1000))
                .notConsumable(dust, HTSCatalyst)
                .fluidOutputs(ReformedSyngas.getFluid(9000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(4000))
                .input("dustAnyPurityBismuth", 2)
                .output(dust, SpentBismuthCatalyst, 2)
                .duration(10)
                .EUt(480 * 2)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, SpentBismuthCatalyst, 2)
                .output(dust, Bismuth, 1)
                .output(dust, Carbon, 1)
                .duration(20)
                .EUt(480)
                .buildAndRegister();

        PRESSURE_SWING_ADSORBER_RECIPES.recipeBuilder()
                .fluidInputs(ReformedSyngas.getFluid(9000))
                .notConsumable(dust, MolecularSieve, 5)
                .fluidOutputs(Hydrogen.getFluid(8000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        PRESSURE_SWING_ADSORBER_RECIPES.recipeBuilder()
                .fluidInputs(Syngas.getFluid(7000))
                .notConsumable(dust, MolecularSieve, 5)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

// Ammonia (Haber Process)

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(HotHighPressureAir.getFluid(1500))
                .fluidInputs(Hydrogen.getFluid(3000))
                .notConsumable(dust, WustiteCatalyst)
                .fluidOutputs(AmmoniaRichGas.getFluid(4000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(HotHighPressureNitrogen.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(3000))
                .notConsumable(dust, WustiteCatalyst)
                .fluidOutputs(AmmoniaRichGas.getFluid(4000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniaReactionMix.getFluid(4000))
                .notConsumable(dust, WustiteCatalyst)
                .fluidOutputs(AmmoniaRichGas.getFluid(4000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniaRichGas.getFluid(4000))
                .fluidInputs(Water.getFluid(500))
                .fluidOutputs(AmmoniaSolution.getFluid(500))
                .fluidOutputs(AmmoniaReactionMix.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Syngas.getFluid(1000))
                .input(dust, IronIIIOxide, 5)
                .output(dust, WustiteCatalyst, 5)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniaSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(150)
                .EUt(30)
                .buildAndRegister();

// Butadiene without oil

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Acetaldehyde.getFluid(50))
                .fluidInputs(Ethanol.getFluid(50))
                .notConsumable(catalystBed, Tantalum)
                .fluidOutputs(Butadiene.getFluid(50))
                .fluidOutputs(Water.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

// Ethanol from ethylene

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .fluidInputs(PhosphoricAcid.getFluid(500))
                .input(dust, SilicaGel)
                .output(dust, PhosphoricAcidSilicaGel)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(50))
                .fluidInputs(Steam.getFluid(50))
                .notConsumable(dust, PhosphoricAcidSilicaGel)
                .fluidOutputs(Ethanol.getFluid(50))
                .duration(5)
                .EUt(480)
                .buildAndRegister();

// Wacker Process

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(2000))
                .input("dustAnyPurityPalladium", 1)
                .output(dust, PalladiumChloride, 3)
                .duration(280)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(2000))
                .input("dustAnyPurityCopper", 1)
                .output(dust, CopperIIChloride, 3)
                .duration(280)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, PalladiumChloride, 3)
                .input(dust, CopperIIChloride, 3)
                .output(dust, WackerCatalyst)
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, WackerCatalyst, 6)
                .fluidOutputs(WackerCatalystSolution.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();


        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(WackerCatalystSolution.getFluid(50))
                .fluidInputs(Ethylene.getFluid(50))
                .fluidInputs(Oxygen.getFluid(50))
                .fluidOutputs(ImpureAcetaldehyde.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(ImpureAcetaldehyde.getFluid(1000))
                .fluidOutputs(Acetaldehyde.getFluid(900))
                .output(dust, WackerCatalyst, 6)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

// Cativa Process

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(AceticAcid.getFluid(1000))
                .notConsumable(dust, CativaProcessCatalyst)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, HexachloroiridicAcid, 9)
                .fluidInputs(PotassiumIodideSolution.getFluid(4000))
                .output(dust, IridiumIodide, 5)
                .fluidOutputs(PotassiumChlorideSolution.getFluid(4000))
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusTrichloride.getFluid(1000))
                .fluidInputs(Chlorobenzene.getFluid(3000))
                .input("dustAnyPuritySodium", 6)
                .output(dust, Triphenylphosphine)
                .output(dust, Salt, 12)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Triphenylphosphine)
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, TriphenylphosphineDichloride)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TriphenylphosphineDichloride, 2)
                .input(dust, Triphenylphosphine)
                .fluidInputs(Hydroxylamine.getFluid(1000))
                .fluidInputs(HydrogenChloride.getFluid(1000))
                .output(dust, BistriphenylphosphineiminiumChloride)
                .output(dust, TriphenylphosphineOxide)
                .fluidOutputs(HydrogenChloride.getFluid(4000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, IridiumIodide, 5)
                .fluidInputs(Dimethylformamide.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(CativaProcessPreparation.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(CativaProcessPreparation.getFluid(500))
                .input(dust, BistriphenylphosphineiminiumChloride)
                .fluidOutputs(CativaProcessSolution.getFluid(500))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(CativaProcessSolution.getFluid(1000))
                .output(dust, CativaProcessCatalyst, 10)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, PotassiumIodide, 2)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(PotassiumIodideSolution.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Dimethylformamide

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(50))
                .fluidInputs(Dimethylamine.getFluid(50))
                .fluidOutputs(Dimethylformamide.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Cumene rearranging

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HotHighPressurePropene.getFluid(50))
                .fluidInputs(HotHighPressureBenzene.getFluid(50))
                .fluidInputs(PhosphoricAcid.getFluid(50))
                .fluidOutputs(AcidicCumene.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(50))
                .fluidInputs(AcidicCumene.getFluid(100))
                .fluidOutputs(RearrangedCumene.getFluid(150))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(RearrangedCumene.getFluid(150))
                .fluidOutputs(PhosphoricAcid.getFluid(50))
                .fluidOutputs(Phenol.getFluid(50))
                .fluidOutputs(Acetone.getFluid(50))
                .disableDistilleryRecipes()
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Nitrogen Dioxide

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .duration(60)
                .EUt(120)
                .buildAndRegister();

// Isobutylene

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Butane.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(AlkylatedButane.getFluid(100))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AlkylatedButane.getFluid(100))
                .fluidOutputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(Isobutane.getFluid(50))
                .duration(300)
                .EUt(30 * 2)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutane.getFluid(50))
                .notConsumable(catalystBed, ChromiumTrioxide)
                .fluidOutputs(Isobutylene.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Raney Nickel and cyclohexane

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Aluminium.getFluid(144))
                .input("dustAnyPurityNickel", 1)
                .input(dustTiny, Zinc, 1)
                .output(dust, RaneyNickel, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .input(dust, SodiumDichromate, 11)
                .output(dust, ChromiumTrioxide, 8)
                .fluidOutputs(SodiumSulfateSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSulfateSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, SodiumSulfate, 7)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RaneyNickel, 4)
                .input(dust, SodiumHydroxide, 6)
                .fluidInputs(Water.getFluid(6000))
                .output(dust, ActivatedRaneyNickel, 2)
                .output(dust, SodiumAluminate, 20)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input("dustAnyPurityCopper", 1)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, CupricOxide, 2)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input("dustAnyPurityCopper", 2)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, CuprousOxide, 3)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, CupricOxide, 2)
                .input(dust, Alumina, 5)
                .output(dust, ImpregnatedCopperOxideCatalyst, 7)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Methanol

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CarbonMonoxide.getFluid(50))
                .fluidInputs(HotHighPressureHydrogen.getFluid(200))
                .notConsumable(dust, ImpregnatedCopperOxideCatalyst, 1)
                .fluidOutputs(Methanol.getFluid(50))
                .duration(2)
                .EUt(480)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CarbonDioxide.getFluid(50))
                .fluidInputs(HotHighPressureHydrogen.getFluid(300))
                .notConsumable(dust, ImpregnatedCopperOxideCatalyst, 1)
                .fluidOutputs(Methanol.getFluid(50))
                .fluidOutputs(Steam.getFluid(50))
                .duration(2)
                .EUt(480)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Syngas.getFluid(350))
                .fluidInputs(CarbonMonoxide.getFluid(25))
                .notConsumable(dust, ImpregnatedCopperOxideCatalyst, 1)
                .fluidOutputs(Methanol.getFluid(75))
                .duration(2)
                .EUt(480)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Syngas.getFluid(350))
                .fluidInputs(CarbonDioxide.getFluid(16))
                .notConsumable(dust, ImpregnatedCopperOxideCatalyst, 1)
                .fluidOutputs(Methanol.getFluid(66))
                .fluidOutputs(Steam.getFluid(16))
                .duration(2)
                .EUt(480)
                .buildAndRegister();

// DicobaltOctacarbonyl

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityCobalt", 2)
                .fluidInputs(CarbonMonoxide.getFluid(8000))
                .output(dust, DicobaltOctacarbonyl, 18)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Impregnated Alumina Catalyst

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, SilicaGel, 3)
                .input(dust, Alumina, 5)
                .output(dust, ImpregnatedAluminaCatalyst, 8)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Copper Bismuth

        MIXER_RECIPES.recipeBuilder()
                .input("dustAnyPurityBismuth", 1)
                .input("dustAnyPurityCopper", 1)
                .output(dust, BismuthCopper, 2)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// 2-EAQ

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhthalicAnhydride, 13)
                .fluidInputs(Ethylbenzene.getFluid(1000))
                .fluidOutputs(TwoEthylanthraquinone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();;

// 2-EAHQ

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TwoEthylanthraquinone.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .notConsumable(catalystBed, Palladium, 1)
                .fluidOutputs(TwoEthylanthrahydroquinone.getFluid(50))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Hydrogen Peroxide

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TwoEthylanthrahydroquinone.getFluid(50))
                .fluidInputs(HotHighPressureHydrogen.getFluid(100))
                .fluidOutputs(TwoEthylanthraquinoneSolution.getFluid(200))
                .duration(100) // Adjust the duration as needed
                .EUt(30)
                .buildAndRegister();;

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(TwoEthylanthraquinoneSolution.getFluid(200))
                .fluidInputs(Water.getFluid(150))
                .fluidOutputs(TwoEthylanthraquinone.getFluid(50))
                .fluidOutputs(HydrogenPeroxideSolution.getFluid(300))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenPeroxideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(HydrogenPeroxide.getFluid(1000))
                .duration(40)
                .EUt(120)
                .buildAndRegister();

// Butanone

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TwoButanol.getFluid(50))
                .notConsumable(catalystBed, ChromiumTrioxide, 1)
                .fluidOutputs(Butanone.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(100))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Aluminium Chloride

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Benzene.getFluid(50))
                .fluidInputs(Bromine.getFluid(50))
                .notConsumable(dust, AluminiumChloride)
                .fluidOutputs(Bromobenzene.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();;

// Philips catalyst

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(dust, SilicaGel, 3)
                .input(dust, ChromiumTrioxide, 4)
                .output(dust, PhilipsCatalyst, 7)
                .duration(200)
                .EUt(30)
                .buildAndRegister();;

// Ziegler-Natta

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium", 1)
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, AluminiumChloride, 4)
                .duration(100) // Adjust the duration as needed
                .EUt(30)
                .buildAndRegister();;

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium", 2)
                .fluidInputs(Hydrogen.getFluid(6000))
                .fluidInputs(Ethylene.getFluid(6000))
                .fluidOutputs(Triethylaluminium.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();;

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Triethylaluminium.getFluid(1000))
                .fluidInputs(TitaniumTetrachloride.getFluid(1000))
                .output(dust, ZieglerNattaCatalyst, 10)
                .duration(160)
                .EUt(30)
                .buildAndRegister();;

// Pyromellitic Dianhydride

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Durene, 4)
                .fluidInputs(Oxygen.getFluid(2000))
                .output(dust, PyromelliticDianhydride, 3)
                .fluidOutputs(Steam.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();;

// Kapton K

        POLYMERIZATION_RECIPES.recipeBuilder()
                .input(dust, PyromelliticDianhydride)
                .input(dust, FourFourOxydianiline)
                .fluidInputs(Acetone.getFluid(2000))
                .fluidOutputs(ImpureKaptonK.getFluid(2000))
                .duration(400)
                .EUt(480 * 2)
                .buildAndRegister();;

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(ImpureKaptonK.getFluid(1000))
                .fluidOutputs(Acetone.getFluid(1000))
                .output(dust, KaptonK)
                .duration(200)
                .EUt(120)
                .buildAndRegister();;

// Kapton E

        MIXER_RECIPES.recipeBuilder()
                .input(dust, PyromelliticDianhydride)
                .input(dust, FourFourOxydianiline)
                .input(dust, BiphenylTetracarboxylicAcidDianhydride)
                .input(dust, ParaPhenylenediamine)
                .fluidInputs(Acetone.getFluid(4000))
                .fluidOutputs(KaptonEPreparation.getFluid(4000))
                .duration(800)
                .EUt(30)
                .buildAndRegister();;

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(KaptonEPreparation.getFluid(1000))
                .fluidOutputs(ImpureKaptonE.getFluid(1000))
                .duration(200)
                .EUt(120 * 2)
                .buildAndRegister();;

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(ImpureKaptonE.getFluid(1000))
                .fluidOutputs(Acetone.getFluid(1000))
                .output(dust, KaptonE)
                .duration(200)
                .EUt(30)
                .buildAndRegister();;

// Bromomethane

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(6000))
                .fluidInputs(Bromine.getFluid(3000))
                .input("dustAnyPuritySulfur", 1)
                .fluidOutputs(Bromomethane.getFluid(6000))
                .fluidOutputs(VeryDilutedSulfuricAcid.getFluid(3000))
                .duration(60) // Adjust the duration as needed
                .EUt(30)
                .buildAndRegister();;

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(VeryDilutedSulfuricAcid.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();;

// Hydrazine
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Butene.getFluid(1000))
                .fluidOutputs(Isobutylene.getFluid(500))
                .fluidOutputs(OneButene.getFluid(300))
                .fluidOutputs(TwoButene.getFluid(200))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidInputs(TwoButene.getFluid(50))
                .fluidInputs(Water.getFluid(50))
                .fluidOutputs(TwoButanolSolution.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(TwoButanolSolution.getFluid(2000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(TwoButanol.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniaSolution.getFluid(50))
                .fluidInputs(AceticAcid.getFluid(50))
                .fluidOutputs(AmmoniumAcetateSolution.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumAcetateSolution.getFluid(1000))
                .output(dust, Acetamide, 9)
                .fluidOutputs(Water.getFluid(2000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Acetamide, 18)
                .fluidInputs(Butanone.getFluid(1000))
                .fluidOutputs(AcetamideSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(AcetamideSolution.getFluid(50))
                .fluidInputs(HydrogenPeroxide.getFluid(50))
                .fluidInputs(Ammonia.getFluid(200))
                .fluidOutputs(HydrazineSolution.getFluid(250))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HydrazineSolution.getFluid(5000))
                .fluidOutputs(Hydrazine.getFluid(1000))
                .fluidOutputs(Water.getFluid(4000))
                .fluidOutputs(Ammonia.getFluid(2000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Amine oligomerization

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1525))
                .fluidInputs(Ammonia.getFluid(2425))
                .fluidOutputs(AminatedEthyleneMixture.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AminatedEthyleneMixture.getFluid(1000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(3050))
                .fluidOutputs(NeutralizedAminatedEthyleneMixture.getFluid(4050))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(NeutralizedAminatedEthyleneMixture.getFluid(4050))
                .output(dust, Salt, 6)
                .fluidOutputs(Piperazine.getFluid(50))
                .fluidOutputs(Triethylenetetramine.getFluid(100))
                .fluidOutputs(Aminoethylpiperazine.getFluid(50))
                .fluidOutputs(Diethylenetriamine.getFluid(300))
                .fluidOutputs(Ethylenediamine.getFluid(500))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Nitrosyl Chloride
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(50))
                .fluidInputs(NitricOxide.getFluid(50))
                .fluidOutputs(NitrosylChloride.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPuritySulfur", 1)
                .fluidInputs(Chlorine.getFluid(2000))
                .fluidOutputs(SulfurDichloride.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Thionyl chloride
        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfurTrioxide.getFluid(50))
                .fluidInputs(SulfurDichloride.getFluid(50))
                .fluidOutputs(ThionylChloride.getFluid(50))
                .fluidOutputs(SulfurDioxide.getFluid(50))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ThionylChloride.getFluid(50))
                .fluidInputs(Water.getFluid(150))
                .fluidOutputs(SulfurDioxide.getFluid(50))
                .fluidOutputs(HydrochloricAcid.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Diborane
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, LithiumHydride, 12)
                .fluidInputs(BoronTrifluoride.getFluid(8000))
                .output(dust, LithiumTetrafluoroborate, 36)
                .fluidOutputs(Diborane.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, LithiumTetrafluoroborate, 6)
                .output(dust, LithiumFluoride, 2)
                .fluidOutputs(BoronTrifluoride.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Lithium Hydride
        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityLithium", 1)
                .fluidInputs(Hydrogen.getFluid(1000))
                .output(dust, LithiumHydride, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Tetramethylammonium hydroxide
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TetramethylammoniumChloride, 6)
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(TetramethylammoniumHydroxideSolution.getFluid(1000))
                .output(dust, Salt, 2)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Pyrocatechol
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(HydrogenPeroxide.getFluid(1000))
                .output(dust, Pyrocatechol, 12)
                .fluidOutputs(Water.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Tetramethylammonium chloride
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Trimethylamine.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(1000))
                .fluidInputs(Ethanol.getFluid(4000))
                .output(dust, TetramethylammoniumChloride, 6)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// 1,4-Bis(trichloromethyl)benzene
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(50))
                .fluidInputs(Chlorine.getFluid(300))
                .fluidOutputs(Bistrichloromethylbenzene.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(300))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Ammonium Bisulfate
        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(stick, Platinum)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(AmmoniumBisulfate.getFluid(1584))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Tosylic Acid, Hydrogen Silsesquioxane

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Toluene.getFluid(50))
                .fluidInputs(Oleum.getFluid(550))
                .fluidInputs(DistilledWater.getFluid(50))
                .fluidOutputs(TosylicAcidSolution.getFluid(50))
                .fluidOutputs(SulfuricAcid.getFluid(500))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Trichlorosilane.getFluid(50))
                .fluidInputs(Toluene.getFluid(300))
                .fluidOutputs(TrichlorosilaneSolution.getFluid(350))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(TosylicAcidSolution.getFluid(3500))
                .fluidInputs(TrichlorosilaneSolution.getFluid(3500))
                .fluidOutputs(AcidicHydrogenSilsesquioxaneSolution.getFluid(3000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AcidicHydrogenSilsesquioxaneSolution.getFluid(3000))
                .fluidInputs(DistilledWater.getFluid(100))
                .fluidOutputs(HydrogenSilsesquioxaneSolution.getFluid(3050))
                .fluidOutputs(AcidicWastewater.getFluid(50))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenSilsesquioxaneSolution.getFluid(3050))
                .chancedOutput(dust, HydrogenSilsesquioxane, 625, 0)
                .fluidOutputs(Water.getFluid(50))
                .fluidOutputs(Toluene.getFluid(3000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

/*
Let us produce a 5% wt solution of hydrogen silsesquioxane (H8Si8O12) in MIBK.

Assume 100g.
5g HSQ / (424.744 g/mol) = 0.0117718 mol HSQ
95g MIBK / (100.16 g/mol) = 0.94848 mol MIBK

Thus, HSQ should be 1.24% molar in MIBK
*/

        MIXER_RECIPES.recipeBuilder()
                .input(dustTiny, HydrogenSilsesquioxane)
                .fluidInputs(MethylIsobutylKetone.getFluid(11000))
                .fluidOutputs(HydrogenSilsesquioxanePhotoresist.getFluid(11000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Phosphine

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumHydroxideSolution.getFluid(3000))
                .input("dustAnyPurityPhosphorus", 4)
                .fluidOutputs(Phosphine.getFluid(1000))
                .output(dust, PotassiumHypophosphite, 18)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(3000))
                .input("dustAnyPurityPhosphorus", 4)
                .fluidOutputs(Phosphine.getFluid(1000))
                .output(dust, SodiumHypophosphite, 18)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumHypophosphite, 12)
                .fluidOutputs(Phosphine.getFluid(1000))
                .output(dust, DisodiumPhosphate, 8)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PotassiumHypophosphite, 12)
                .fluidOutputs(Phosphine.getFluid(1000))
                .output(dust, DipotassiumPhosphate, 8)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Boron Trifluoride

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BoronTrioxide, 5)
                .fluidInputs(HydrogenFluoride.getFluid(6000))
                .fluidOutputs(BoronTrifluoride.getFluid(2000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BoricAcid, 7)
                .fluidInputs(HydrogenFluoride.getFluid(3000))
                .fluidOutputs(BoronTrifluoride.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Tetrasodium EDTA
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumCyanide, 12)
                .fluidInputs(Ethylenediamine.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(4000))
                .fluidInputs(DilutedHydrochloricAcid.getFluid(8000))
                .output(dust, EthylenediaminetetraaceticAcid, 32)
                .fluidOutputs(Ammonia.getFluid(4000))
                .fluidOutputs(Wastewater.getFluid(4000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, EthylenediaminetetraaceticAcid, 36)
                .fluidInputs(SodiumHydroxideSolution.getFluid(4000))
                .fluidOutputs(TetrasodiumEthylenediaminetetraacetateSolution.getFluid(4000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(TetrasodiumEthylenediaminetetraacetateSolution.getFluid(4000))
                .fluidOutputs(DilutedSaltwater.getFluid(8000))
                .output(dust, TetrasodiumEthylenediaminetetraacetate, 36)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Phosphoryl chloride
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusTrichloride.getFluid(50))
                .fluidInputs(Oxygen.getFluid(50))
                .fluidOutputs(PhosphorylChloride.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Phosphorus trichloride
        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityPhosphorus", 4)
                .fluidInputs(Chlorine.getFluid(12000))
                .fluidOutputs(PhosphorusTrichloride.getFluid(2000))
                .output(dust, PhosphorusPentachloride, 12)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusTrichloride.getFluid(1000))
                .input("dustAnyPurityPhosphorus", 4)
                .fluidOutputs(PhosphorusSolution.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusSolution.getFluid(50))
                .fluidInputs(Chlorine.getFluid(600))
                .fluidOutputs(PhosphorusTrichloride.getFluid(250))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PhosphorusTrichloride.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, PhosphorusPentachloride, 6)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Durene
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(Chloromethane.getFluid(2000))
                .output(dust, Durene, 24)
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Creating diiodobenzene

// Step 1: Producing urea solution
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(100))
                .fluidInputs(CarbonDioxide.getFluid(50))
                .fluidOutputs(UreaSolution.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(UreaSolution.getFluid(1000))
                .output(dust, Urea, 8)
                .fluidOutputs(Water.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Step 2: Creating impure 1,4-diiodobenzene
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumNitrateSolution.getFluid(1000))
                .output(dust, SodiumNitrate, 5)
                .fluidOutputs(Water.getFluid(1000))
                .duration(140)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumNitrate, 5)
                .output(dust, SodiumNitrite, 4)
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumNitrate.getFluid(720))
                .fluidInputs(Lead.getFluid(144))
                .fluidOutputs(SodiumNitrite.getFluid(576))
                .output(dust, LeadOxide, 2)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodiumNitrite, 8)
                .output(dust, SodiumOxide, 3)
                .fluidOutputs(NitricOxide.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumOxide, 3)
                .fluidInputs(Water.getFluid(3000))
                .fluidOutputs(SodiumHydroxideSolution.getFluid(2000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumNitrate, 5)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(PhosphoricAcid.getFluid(1000))
                .fluidInputs(UreaSolution.getFluid(1000))
                .input(dust, ParaPhenylenediamine, 16)
                .input(dust, PotassiumIodide, 4)
                .fluidOutputs(ImpureDiiodobenzene.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Step 3: Purifying 1,4-diiodobenzene
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ImpureDiiodobenzene.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Diiodobenzene, 12)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Turning diiodobenzene into oxydianiline

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Diiodobenzene, 12)
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidOutputs(DiiodobenzeneSolution.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DiiodobenzeneSolution.getFluid(50))
                .fluidInputs(AmmoniaSolution.getFluid(150))
                .fluidOutputs(ImpureFourFourOxydianiline.getFluid(200))
                .notConsumable(catalystBed, Copper)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(AmmoniaSolution.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(100))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(DilutedAmmoniaSolution.getFluid(100))
                .duration(1)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniaSolution.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(DilutedAmmoniaSolution.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();


        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedAmmoniaSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(AmmoniaSolution.getFluid(1000))
                .duration(150)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureFourFourOxydianiline.getFluid(8000))
                .fluidOutputs(FourFourOxydianilineSlurry.getFluid(5000))
                .fluidOutputs(Ethanol.getFluid(2000))
                .output(dust, AmmoniumIodide, 24)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(FourFourOxydianilineSlurry.getFluid(5000))
                .fluidOutputs(Water.getFluid(5000))
                .output(dust, FourFourOxydianiline, 27)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumIodide.getFluid(1728))
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .output(dust, Iodine, 2)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Ethylene glycol
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneOxide.getFluid(70))
                .fluidInputs(Water.getFluid(100))
                .fluidOutputs(EthyleneGlycolMix.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneGlycolMix.getFluid(1000))
                .fluidOutputs(DiethyleneGlycol.getFluid(100))
                .fluidOutputs(EthyleneGlycol.getFluid(500))
                .fluidOutputs(Water.getFluid(400))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Hydrobromic acid
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Bromine.getFluid(100))
                .fluidInputs(SulfurDioxide.getFluid(50))
                .fluidInputs(Water.getFluid(100))
                .fluidOutputs(BrominatedSulfurDioxide.getFluid(150))
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(BrominatedSulfurDioxide.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(HydrogenBromide.getFluid(2000))
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenBromide.getFluid(50))
                .fluidInputs(Water.getFluid(50))
                .fluidOutputs(HydrobromicAcid.getFluid(50))
                .EUt(7)
                .duration(1)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(HydrogenBromide.getFluid(1000))
                .fluidOutputs(SodiumBromideSolution.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

// Hydrogen cyanide
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidInputs(Oxygen.getFluid(150))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(HydrogenCyanide.getFluid(50))
                .fluidOutputs(Water.getFluid(150))
                .EUt(120)
                .duration(10)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(1000))
                .input("dustAnyPuritySodium", 1)
                .fluidOutputs(Hydrogen.getFluid(1000))
                .output(dust, SodiumAmide, 4)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityCarbon", 1)
                .input(dust, SodiumAmide, 4)
                .fluidOutputs(Hydrogen.getFluid(2000))
                .output(dust, SodiumCyanide, 3)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .input(dust, SodiumCyanide, 3)
                .fluidOutputs(HydrogenCyanide.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

// Ethylene oxide
        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(50))
                .fluidInputs(Oxygen.getFluid(50))
                .notConsumable(catalystBed, Silver)
                .fluidOutputs(CarbonDioxide.getFluid(5))
                .fluidOutputs(ImpureEthyleneOxide.getFluid(45))
                .EUt(30)
                .duration(10)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureEthyleneOxide.getFluid(900))
                .fluidOutputs(Water.getFluid(100))
                .fluidOutputs(EthyleneOxide.getFluid(800))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

//ALON

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium", 1)
                .fluidInputs(Nitrogen.getFluid(1000))
                .notConsumable(dust, AmmoniumChloride, 6)
                .output(dust, AluminiumNitride, 2)
                .EUt(1920)
                .duration(20)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(dust, AluminiumNitride, 10)
                .input(dust, Alumina, 45)
                .notConsumable(Argon.getFluid(1000))
                .output(dust, AluminiumOxynitride)
                .EUt(1920)
                .duration(20)
                .buildAndRegister();

//TETRAHYDROFURAN

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Butanediol.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(TetrahydrofuranSolution.getFluid(150))
                .EUt(30)
                .duration(5)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(TetrahydrofuranSolution.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(Tetrahydrofuran.getFluid(1000))
                .EUt(90)
                .duration(600)
                .buildAndRegister();

//KAMINSKY CATALYST

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Sodium.getFluid(144))
                .fluidInputs(Cyclopentadiene.getFluid(1000))
                .fluidInputs(Tetrahydrofuran.getFluid(1000))
                .fluidOutputs(SodiumCyclopentadienideSolution.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .EUt(1920)
                .duration(60)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZirconiumTetrachloride, 5)
                .fluidInputs(Tetrahydrofuran.getFluid(2000))
                .output(dust, ZirconiumTetrachlorideTetrahydrofuranComplex, 7)
                .EUt(1920)
                .duration(60)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZirconiumTetrachlorideTetrahydrofuranComplex, 7)
                .fluidInputs(SodiumCyclopentadienideSolution.getFluid(2000))
                .output(dust, ZirconoceneDichloride)
                .output(dust, Salt, 4)
                .fluidOutputs(Tetrahydrofuran.getFluid(4000))
                .EUt(1920)
                .duration(60)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium", 1)
                .input("dustAnyPuritySodium", 3)
                .fluidInputs(Chloromethane.getFluid(3000))
                .output(dust, Salt, 6)
                .fluidOutputs(Trimethylaluminium.getFluid(1000))
                .EUt(1920)
                .duration(60)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Trimethylaluminium.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .output(dust, Methylaluminoxane)
                .fluidOutputs(Methane.getFluid(2000))
                .EUt(1920)
                .duration(60)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZirconiumDioxide, 6)
                .input(dust, Methylaluminoxane)
                .input(dust, ZirconoceneDichloride)
                .notConsumable(Toluene.getFluid(1000))
                .output(dust, KaminskyCatalyst)
                .EUt(1920)
                .duration(60)
                .buildAndRegister();

//DISTILLATION REORDERING

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSulfuricAcid.getFluid(500))
                .fluidOutputs(SulfuricAcid.getFluid(250))
                .fluidOutputs(Water.getFluid(250))
                .EUt(30)
                .duration(50)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(2000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

//PATCH PHOSPHORUS DUPE
        removeRecipesByInputs(BATCH_REACTOR_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, PhosphorusPentoxide)}, new FluidStack[]{Water.getFluid(6000)});

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhosphorusPentoxide, 14)
                .fluidInputs(Water.getFluid(4000))
                .fluidOutputs(PhosphoricAcid.getFluid(4000))
                .EUt(30)
                .duration(40)
                .buildAndRegister();

//PICRIC ACID

//        BATCH_REACTOR_RECIPES.recipeBuilder()

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(NitrationMixture.getFluid(6000))
                .fluidOutputs(TNPSlurry.getFluid(3000))
                .duration(200)
                .EUt(24)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(TNPSlurry.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .output(dust, PicricAcid, 7)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

//AMMONIUM THIOCYANATE

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(CarbonDisulfide.getFluid(50))
                .fluidInputs(AmmoniaSolution.getFluid(50))
                .fluidOutputs(AmmoniumThiocyanateSolution.getFluid(50))
                .fluidOutputs(HydrogenSulfide.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumThiocyanateSolution.getFluid(1000))
                .output(dust, AmmoniumThiocyanate, 8)
                .fluidOutputs(Water.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

//TOLUENE FROM BENZENE
        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, AluminiumChloride)
                .circuitMeta(1)
                .fluidInputs(Benzene.getFluid(50))
                .fluidInputs(Chloromethane.getFluid(50))
                .fluidOutputs(Toluene.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

//XYLENE FROM BENZENE
        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, AluminiumChloride)
                .circuitMeta(2)
                .fluidInputs(Benzene.getFluid(50))
                .fluidInputs(Chloromethane.getFluid(100))
                .fluidOutputs(OrthoParaXyleneMixture.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(OrthoParaXyleneMixture.getFluid(1000))
                .fluidOutputs(ParaXylene.getFluid(575))
                .fluidOutputs(OrthoXylene.getFluid(375))
                .fluidOutputs(MetaXylene.getFluid(50))
                .duration(100)
                .EUt(30 * 2)
                .buildAndRegister();

//XYLENE FROM TOLUENE
        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, AluminiumChloride)
                .fluidInputs(Toluene.getFluid(50))
                .fluidInputs(Chloromethane.getFluid(50))
                .fluidOutputs(OrthoParaXyleneMixture.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

//POLYCHLORINATED BIPHENYL, BENZENE FROM TOLUENE

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .fluidOutputs(HydrodealkylatedTolueneMixture.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HydrodealkylatedTolueneMixture.getFluid(1000))
                .chancedOutput(dust, Biphenyl, 250, 0)
                .fluidOutputs(Toluene.getFluid(200))
                .fluidOutputs(Benzene.getFluid(750))
                .fluidOutputs(Methane.getFluid(750))
                .fluidOutputs(Hydrogen.getFluid(2400))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, Iron3Chloride)
                .input(dust, Biphenyl)
                .fluidInputs(Chlorine.getFluid(5000))
                .fluidOutputs(PolychlorinatedBiphenyl.getFluid(1000))
                .fluidOutputs(HydrogenChloride.getFluid(5000))
                .duration(15)
                .EUt(30)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(spring, Nichrome)
                .fluidInputs(Benzene.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(50))
                .chancedOutput(dust, Biphenyl, 500, 0)
                .fluidOutputs(Benzene.getFluid(900))
                .fluidOutputs(Water.getFluid(50))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxide.getFluid(432))
                .fluidInputs(Chlorobenzene.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(Phenol.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumPhenoxideSolution.getFluid(1000))
                .fluidInputs(HydrogenChloride.getFluid(1000))
                .fluidOutputs(Phenol.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

//BENZENE FROM PHENOL
        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .input("dustAnyPurityZinc", 1)
                .fluidOutputs(Benzene.getFluid(1000))
                .output(dust, ZincOxide, 2)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//ZnO -> ZnCl2
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .input(dust, ZincOxide)
                .fluidOutputs(DilutedZincChlorideSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedZincChlorideSolution.getFluid(2000))
                .output(dust, ZincChloride, 3)
                .fluidOutputs(Water.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

//ZIEGLER-ALFOL PROCESS
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Triethylaluminium.getFluid(50))
                .fluidInputs(Ethylene.getFluid(300))
                .fluidInputs(DiethylEther.getFluid(50))
                .fluidOutputs(AlfolTrialkylaluminiumMixture.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(AlfolTrialkylaluminiumMixture.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .fluidOutputs(AluminiumAlkoxideSolution.getFluid(1000))
                .duration(500)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AluminiumAlkoxideSolution.getFluid(1000))
                .output(dust, AluminiumAlkoxideMixture)
                .fluidOutputs(DiethylEther.getFluid(1000))
                .duration(500)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AluminiumAlkoxideMixture)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, AluminiumHydroxide, 7)
                .fluidOutputs(ZieglerAlfolMixture.getFluid(3000))
                .duration(500)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder() //SCHULZ FLORY DISTRIBUTION, p = 0.73, ROUNDED TO NEAREST 5s, TRUNCATED
                .fluidInputs(ZieglerAlfolMixture.getFluid(1000))
                .fluidOutputs(NHexadecanol.getFluid(30))
                .fluidOutputs(NTetradecanol.getFluid(45))
                .fluidOutputs(NDodecanol.getFluid(60))
                .fluidOutputs(NDecanol.getFluid(90))
                .fluidOutputs(NOctanol.getFluid(115))
                .fluidOutputs(NHexanol.getFluid(150))
                .fluidOutputs(NButanol.getFluid(215))
                .fluidOutputs(Ethanol.getFluid(295))
                .duration(166)
                .EUt(30)
                .buildAndRegister();


//CYCLOOCTADIENE

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelChloride, 3)
                .input(dust, Triphenylphosphine, 2)
                .notConsumable(AceticAcid.getFluid(1000))
                .output(dust, DichlorobistriphenylphosphinenickelII)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPurityZinc", 1)
                .input(dust, DichlorobistriphenylphosphinenickelII)
                .fluidInputs(CarbonMonoxide.getFluid(2000))
                .notConsumable(Tetrahydrofuran.getFluid(1000))
                .output(dust, DicarbonylbistriphenylphosphinenickelZero)
                .output(dust, ZincChloride, 3)
                .duration(200)
                .EUt(480)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, DicarbonylbistriphenylphosphinenickelZero)
                .fluidInputs(Butadiene.getFluid(100))
                .fluidOutputs(Cyclooctadiene.getFluid(50))
                .duration(10)
                .EUt(480)
                .buildAndRegister();

//ETHENONE

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(150))
                .fluidInputs(PhosphorylChloride.getFluid(50))
                .fluidOutputs(AcidicTriethylPhosphate.getFluid(200))
                .duration(3)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 9)
                .fluidInputs(AcidicTriethylPhosphate.getFluid(4000))
                .fluidOutputs(TriethylPhosphate.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(3000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .notConsumable(Ammonia.getFluid(1000))
                .notConsumable(TriethylPhosphate.getFluid(1000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .fluidOutputs(Ethenone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(40)
                .EUt(480)
                .buildAndRegister();

//ACETYLACETONE

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Ethenone.getFluid(50))
                .fluidInputs(Acetone.getFluid(50))
                .fluidOutputs(IsopropenylAcetate.getFluid(50))
                .duration(20)
                .EUt(120)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .fluidInputs(IsopropenylAcetate.getFluid(1000))
                .fluidOutputs(Acetylacetone.getFluid(1000))
                .duration(400)
                .EUt(120)
                .buildAndRegister();

//SHELL HIGHER OLEFIN PROCESS

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelIIOxide, 2)
                .fluidInputs(NitricAcid.getFluid(2000))
                .fluidOutputs(NickelIINitrateSolution.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(NickelIINitrateSolution.getFluid(1000))
                .output(dust, NickelIINitrate, 9)
                .fluidOutputs(Water.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelIINitrate, 9)
                .fluidInputs(Acetylacetone.getFluid(2000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .fluidOutputs(NickelIIBisacetylacetonateSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(NickelIIBisacetylacetonateSolution.getFluid(2000))
                .output(dust, NickelIIBisacetylacetonate)
                .output(dust, SodiumNitrate, 10)
                .fluidOutputs(Steam.getFluid(2000))
                .duration(120)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelIIBisacetylacetonate)
                .fluidInputs(Cyclooctadiene.getFluid(2000))
                .fluidInputs(Triethylaluminium.getFluid(2000))
                .output(dust, BiscyclooctadienenickelZero)
                .fluidOutputs(Ethane.getFluid(1000))
                .fluidOutputs(Ethylene.getFluid(1000))
                .fluidOutputs(DiethylaluminiumAcetylacetonate.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DiethylaluminiumAcetylacetonate.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .fluidOutputs(AluminiumChlorideSolution.getFluid(3000))
                .fluidOutputs(Acetylacetone.getFluid(1000))
                .fluidOutputs(Ethylene.getFluid(2000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AluminiumChlorideSolution.getFluid(3000))
                .output(dust, AluminiumChloride, 4)
                .fluidOutputs(Water.getFluid(3000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Triphenylphosphine)
                .fluidInputs(PhosphorusTrichloride.getFluid(500))
                .fluidOutputs(Chlorodiphenylphosphine.getFluid(1500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Chlorodiphenylphosphine.getFluid(50))
                .fluidInputs(AceticAcid.getFluid(50))
                .notConsumable(SodiumHydroxideSolution.getFluid(50))
                .fluidOutputs(DiphenylphosphinoaceticAcid.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BiscyclooctadienenickelZero)
                .fluidInputs(DiphenylphosphinoaceticAcid.getFluid(1000))
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidOutputs(ShellHigherOlefinCatalystSolution.getFluid(1000))
                .duration(200)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Ethylene.getFluid(1000))
                .notConsumable(ShellHigherOlefinCatalystSolution.getFluid(1000))
                .fluidOutputs(AlphaOlefinMixture.getFluid(1000))
                .duration(125)
                .EUt(480)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder() // SCHULZ-FLORY, p = 0.82, ROUNDED TO NEAREST 5
                .fluidInputs(AlphaOlefinMixture.getFluid(1000))
                .fluidOutputs(OneTetracosene.getFluid(20))
                .fluidOutputs(OneDocosene.getFluid(30))
                .fluidOutputs(OneIcosene.getFluid(35))
                .fluidOutputs(OneOctadecene.getFluid(40))
                .fluidOutputs(OneHexadecene.getFluid(50))
                .fluidOutputs(OneTetradecene.getFluid(60))
                .fluidOutputs(OneDodecene.getFluid(75))
                .fluidOutputs(OneDecene.getFluid(90))
                .fluidOutputs(OneOctene.getFluid(130))
                .fluidOutputs(OneHexene.getFluid(110))
                .fluidOutputs(OneButene.getFluid(160))
                .fluidOutputs(Ethylene.getFluid(200))
                .duration(125)
                .EUt(480)
                .buildAndRegister();

//OXALIC ACID
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(4000))
                .notConsumable(NitricAcid.getFluid(800))
                .notConsumable(dust, VanadiumPentoxide, 7)
                .notConsumable(dust, Iron3Chloride, 4)
                .output(dust, OxalicAcid)
                .fluidOutputs(Water.getFluid(2000))
                .duration(120)
                .EUt(480)
                .buildAndRegister();

//ANILINE
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Benzene.getFluid(50))
                .fluidInputs(NitrationMixture.getFluid(100))
                .fluidOutputs(AcidicNitrobenzeneMixture.getFluid(150))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(AcidicNitrobenzeneMixture.getFluid(3000))
                .fluidOutputs(Nitrobenzene.getFluid(1000))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .duration(50)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Palladium)
                .fluidInputs(Nitrobenzene.getFluid(50))
                .fluidInputs(HotHighPressureHydrogen.getFluid(150))
                .fluidOutputs(Aniline.getFluid(50))
                .fluidOutputs(Water.getFluid(100))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

// Heated water
        FLUID_HEATER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(HeatedWater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Soda Ash Solution
        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(100))
                .fluidInputs(CarbonDioxide.getFluid(50))
                .fluidOutputs(DilutedSodiumCarbonateSolution.getFluid(150))
                .duration(4)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSodiumCarbonateSolution.getFluid(3000))
                .output(dust, SodaAsh, 6)
                .fluidOutputs(Water.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

// Pd/C

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PalladiumChloride)
                .input(dust, ActivatedCarbon, 4)
                .fluidInputs(DemineralizedWater.getFluid(250))
                .fluidInputs(Formaldehyde.getFluid(50))
                .output(dust, PalladiumOnCarbon, 5)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//Acetone from dry distillation

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Calcite, 5)// CaCO3 + 2 CH3COOH --> Ca(CH3COO)2 + H2O + CO2
                .fluidInputs(AceticAcid.getFluid(2000))
                .fluidOutputs(DissolvedCalciumAcetate.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(1800)
                .EUt(16)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2) // CaO + 2 CH3COOH --> Ca(CH3COO)2 + H2O
                .fluidInputs(AceticAcid.getFluid(2000))
                .fluidOutputs(DissolvedCalciumAcetate.getFluid(1000))
                .duration(1800)
                .EUt(16)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DissolvedCalciumAcetate.getFluid(1000))
                .output(dust, CalciumAcetate, 15)
                .fluidOutputs(Water.getFluid(1000))
                .duration(20)
                .EUt(16)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, CalciumAcetate, 15)
                .output(dust, Quicklime, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(Acetone.getFluid(1000))
                .duration(600)
                .EUt(30)
                .buildAndRegister();

// Ethylbenzene

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Benzene.getFluid(50))
                .fluidInputs(Ethylene.getFluid(50))
                .notConsumable(SulfuricAcid.getFluid(50))
                .fluidOutputs(Ethylbenzene.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

// Nitromethane

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Propane.getFluid(50))
                .fluidInputs(NitricAcid.getFluid(150))
                .fluidOutputs(DilutedNitromethane.getFluid(200))
                .fluidOutputs(NitricOxide.getFluid(100))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedNitromethane.getFluid(4000))
                .fluidOutputs(Water.getFluid(3000))
                .fluidOutputs(Nitromethane.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Di-tert-butyl peroxide

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutane.getFluid(50))
                .fluidInputs(Oxygen.getFluid(100))
                .fluidOutputs(TertButylHydroperoxide.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TertButylHydroperoxide.getFluid(50))
                .fluidInputs(TertButylAlcohol.getFluid(50))
                .notConsumable(dust, MolecularSieve)
                .fluidOutputs(DilutedDiTertButylPeroxide.getFluid(100))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedDiTertButylPeroxide.getFluid(2000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(DiTertButylPeroxide.getFluid(1000))
                .duration(200)
                .EUt(120);
// Dimethylacetamide

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylamine.getFluid(50))
                .fluidInputs(AceticAcid.getFluid(50))
                .fluidOutputs(DimethylacetamideSolution.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DimethylacetamideSolution.getFluid(2000))
                .fluidOutputs(Dimethylacetamide.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

// gamma-Butyrolactone

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Acetylene.getFluid(50))
                .fluidInputs(Formaldehyde.getFluid(100))
                .fluidOutputs(Butanediol.getFluid(50))
                .EUt(120)
                .duration(4)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butanediol.getFluid(50))
                .notConsumable(catalystBed, Copper)
                .fluidOutputs(GammaButyrolactone.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(200))
                .EUt(120)
                .duration(4)
                .buildAndRegister();

// Hydrogen Iodide

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Iodine.getFluid(576))
                .fluidInputs(Hydrazine.getFluid(1000))
                .fluidOutputs(HydrogenIodide.getFluid(4000))
                .fluidOutputs(Nitrogen.getFluid(2000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

// Early butyraldehyde

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(spring, Cupronickel)
                .fluidInputs(Acetaldehyde.getFluid(2000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(CrotonaldehydeMixture.getFluid(1000))
                .fluidOutputs(Steam.getFluid(2000))
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(CrotonaldehydeMixture.getFluid(1000))
                .output(dust, SodiumHydroxide, 3)
                .fluidOutputs(Crotonaldehyde.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Copper)
                .fluidInputs(Crotonaldehyde.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .fluidOutputs(Butyraldehyde.getFluid(50))
                .duration(20)
                .EUt(120)
                .buildAndRegister();

//1-butene from n-butanol

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HotSulfuricAcid.getFluid(50))
                .fluidInputs(NButanol.getFluid(50))
                .fluidOutputs(OneButene.getFluid(50))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

// NaHCO3 solutions

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(1000))
                .input(dust, SodiumBicarbonate, 6)
                .fluidOutputs(SodiumBicarbonateSolution.getFluid(1000))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Water.getFluid(1000))
                .input(dust, SodiumBicarbonate)
                .fluidOutputs(BakingSodaSolution.getFluid(1000))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

// NaF Chemistry

        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumFluoride, 2)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(SodiumFluorideSolution.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumFluorideSolution.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(SaltyHydrofluoricAcid.getFluid(50))
                .duration(2)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SaltyHydrofluoricAcid.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(HydrofluoricAcid.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

//Ca(OH)2.H2O
        MIXER_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(CalciumHydroxideSolution.getFluid(1000))
                .EUt(16)
                .duration(100)
                .buildAndRegister();
    }
}
