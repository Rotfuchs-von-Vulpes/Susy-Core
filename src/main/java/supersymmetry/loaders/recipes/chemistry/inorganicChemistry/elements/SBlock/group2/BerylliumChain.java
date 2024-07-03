package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group2;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class BerylliumChain {
    public static void init() {
        //Emerald: 3BeO · Al2O3 · 6SiO2
//Bertrandite: Be4Si2O7(OH)2

//SULFATE PROCESS (PRIMITIVE, 75%)
//ALKALI FUSION
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Emerald)
                .input(dust, SodaAsh, 6)
                .output(dust, AlkaliFusedBeryl, 2)
                .EUt(120)
                .duration(100)
                .buildAndRegister();

//DISSOLUTION
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AlkaliFusedBeryl, 2)
                .fluidInputs(SulfuricAcid.getFluid(7100))
                .fluidInputs(DistilledWater.getFluid(900))
                .output(dust, SiliconDioxide, 18)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(DissolvedAlkaliBeryl.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

//Na2CO3 + H2SO4 --> Na2SO4 + H2O + CO2
//3 BeO + 3 H2SO4 --> 3 BeSO4 + 3 H2O
//Al2O3 + 3 H2SO4 --> Al2SO4 + 3 H2O

//ALUM SEPARATION
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumSulfate, 7)
                .fluidInputs(DissolvedAlkaliBeryl.getFluid(2000))
                .output(dust, PotassiumAlum, 24)
                .fluidOutputs(ImpureBerylliumSulfateSolution.getFluid(1500))
                //Beryllium, 3, Sodium, 2, Sulfur, 4, Oxygen, 16, Water, 8 + Iron/Manganese sulfate impurities
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder() //Potassium permangante is typically added to oxidize iron II to III, however this may be too demanding for an MV line
                .input(dustTiny, Calcite, 5)
                .fluidInputs(ImpureBerylliumSulfateSolution.getFluid(1000))
                .output(dustTiny, IronIIIHydroxide)
                .output(dustTiny, ChromiumIIIHydroxide)
                .output(dustTiny, Gypsum, 8)
                .fluidOutputs(BerylliumSulfateSolution.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder() //75%
                .input(dust, SodiumHydroxide, 18)
                .circuitMeta(1)
                .fluidInputs(BerylliumSulfateSolution.getFluid(1000))
                .output(dust, BerylliumHydroxide, 9)
                .fluidOutputs(SodiumSulfateSolution.getFluid(8000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder() //100% (Technically, it makes a little bit of ferric EDTA but I dont want to model it)
                .input(dust, SodiumHydroxide, 18)
                .input(dustTiny, TetrasodiumEthylenediaminetetraacetate)
                .fluidInputs(BerylliumSulfateSolution.getFluid(1000))
                .output(dust, BerylliumHydroxide, 12)
                .fluidOutputs(SodiumSulfateSolution.getFluid(8000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

//FLUORIDE PROCESS (UNIVERSAL, 100%)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HexafluorosilicicAcid.getFluid(1000))
                .fluidInputs(SaltWater.getFluid(2000))
                .output(dust, SodiumFluorosilicate, 9)
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .EUt(1920)
                .duration(400)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Emerald, 2)
                .input(dust, SodiumFluorosilicate, 54)
                .output(dust, FluorideFusedBeryl, 23)
                .fluidOutputs(SiliconTetrafluoride.getFluid(1000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

//REGENERATION OF SODIUM FLUOROSILICATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumFluoride, 4)
                .fluidInputs(SiliconTetrafluoride.getFluid(1000))
                .output(dust, SodiumFluorosilicate, 9)
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

//SEPARATION OF SODIUM FLUOROBERYLLATE
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, FluorideFusedBeryl, 23)
                .fluidInputs(DistilledWater.getFluid(6000))
                .output(dust, Alumina, 10)
                .output(dust, SiliconDioxide, 45)
                .fluidOutputs(SodiumFluoroberyllateSolution.getFluid(5400))
                .EUt(1920)
                .duration(300)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 6)
                .fluidInputs(SodiumFluoroberyllateSolution.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(3000))
                .output(dust, BerylliumHydroxide, 5)
                .fluidOutputs(SodiumFluorideSolution.getFluid(4000))
                .EUt(1920)
                .duration(80)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, BerylliumHydroxide, 5)
                .output(dust, BerylliumOxide, 2)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(1920)
                .duration(80)
                .buildAndRegister();

//CHLORIDE PROCESS (UNIVERSAL, 90%, SHORTER)
//3BeO · Al2O3 · 6SiO2 + 18Cl2 + 18C → 3BeCl2 + 2AlCl3 + 6SiCl4 + 18CO
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Emerald)
                .input("dustAnyPurityCarbon", 18)
                .fluidInputs(Chlorine.getFluid(36000))
                .fluidOutputs(ChlorinatedBeryl.getFluid(900))
                .EUt(1920)
                .duration(480)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder() //Maybe switch to a fractional condenser
                .fluidInputs(ChlorinatedBeryl.getFluid(1000))
                .output(dust, BerylliumChloride, 9)
                .fluidOutputs(AluminiumChloride.getFluid(2000))
                .fluidOutputs(SiliconTetrachloride.getFluid(6000))
                .fluidOutputs(CarbonMonoxide.getFluid(18000))
                .EUt(1920)
                .duration(480)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(AluminiumChloride.getFluid(1000))
                .output(dust, AluminiumChloride, 4)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AluminiumChloride, 4)
                .circuitMeta(1)
                .fluidInputs(SodiumHydroxideSolution.getFluid(3000))
                .output(dust, AluminiumHydroxide, 7)
                .fluidOutputs(SaltWater.getFluid(3000))
                .EUt(30)
                .duration(480)
                .buildAndRegister();

//BERYLLIUM CHLORIDE ROUTE (SHORTER, EV)
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, BerylliumOxide, 2)
                .input("dustAnyPurityCarbon", 1)
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, BerylliumChloride, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .EUt(1920)
                .duration(240)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Aluminium)
                .notConsumable(Salt.getFluid(432))
                .fluidInputs(BerylliumChloride.getFluid(432))
                .fluidOutputs(Chlorine.getFluid(2000))
                .output(dust, Beryllium)
                .EUt(1920)
                .duration(480)
                .buildAndRegister();

//BERYLLIUM FLUORIDE ROUTE (TAKES LONGER, MV)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HexafluorosilicicAcid.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(6000))
                .fluidInputs(DistilledWater.getFluid(2000))
                .output(dust, SiliconDioxide, 3)
                .output(dust, AmmoniumFluoride, 36)
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, AmmoniumFluoride, 12)
                .output(dust, AmmoniumBifluoride, 8)
                .fluidOutputs(Ammonia.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AmmoniumBifluoride, 16)
                .input(dust, BerylliumHydroxide, 5)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(AmmoniumFluoroberyllateSolution.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dustTiny, SodiumHydroxide)
                .fluidInputs(AmmoniumFluoroberyllateSolution.getFluid(1000))
                .chancedOutput(dustTiny, ChromiumIIIHydroxide, 200, 0)
                .chancedOutput(dustTiny, IronIIIHydroxide, 200, 0)
                .fluidOutputs(AmmoniumFluoroberyllateSolution.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumFluoroberyllateSolution.getFluid(1000))
                .output(dust, AmmoniumFluoroberyllate, 13)
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumFluoroberyllate, 13)
                .output(dust, BerylliumFluoride, 3)
                .fluidOutputs(DisassociatedAmmoniumFluoride.getFluid(2000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DisassociatedAmmoniumFluoride.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(AmmoniumFluorideSolution.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumFluorideSolution.getFluid(1000))
                .output(dust, AmmoniumFluoride, 6)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(dust, Graphite, 7)
                .notConsumable(SHAPE_MOLD_CRUCIBLE)
                .fluidInputs(CoalTar.getFluid(1000))
                .output(CRUCIBLE_GRAPHITE)
                .duration(1440)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, BerylliumFluoride, 3)
                .input("dustAnyPurityMagnesium")
                .notConsumable(CRUCIBLE_GRAPHITE)
                .output(dust, Beryllium)
                .output(dust, MagnesiumFluoride, 3)
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, MagnesiumFluoride, 3)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(DissolvedMagnesiumFluoride.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DissolvedMagnesiumFluoride.getFluid(1000))
                .output(dust, MagnesiumChloride, 3)
                .fluidOutputs(HydrofluoricAcid.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

//BERTRANDITE CHAIN (SPECIALIZED)

//HIGH PURITY CHAIN

    }
}
