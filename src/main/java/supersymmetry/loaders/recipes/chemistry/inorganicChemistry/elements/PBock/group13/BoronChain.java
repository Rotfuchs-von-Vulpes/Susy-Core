package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group13;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.item.SuSyMetaItems.SHAPE_MOLD_ROD;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.sintering_blankets;

public class BoronChain {
    public static void init() {
        //BORAX CALCINATION
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Borax, 4)
                .output(dust, SodiumTetraborate, 13)
                .fluidOutputs(Steam.getFluid(10000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//DISSOLUTION OF TETRABORATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumTetraborate, 13)
                .fluidInputs(DistilledWater.getFluid(2000))
                .output(dustTiny, Clay)
                .fluidOutputs(BorateLiquor.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//PRECIPITATION OF BORIC ACID
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(BorateLiquor.getFluid(2000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .output(dust, BoricAcid, 28)
                .fluidOutputs(SaltWater.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//CALCINATION OF BORIC ACID
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, BoricAcid, 14)
                .output(dust, BoronTrioxide, 5)
                .fluidOutputs(Steam.getFluid(3000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

//REDUCTION OF BORON TRIOXIDE
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, BoronTrioxide, 5)
                .input("dustAnyPurityMagnesium", 3)
                .output(dust, AmorphousBoron, 2)
                .output(dust, Magnesia, 6)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(dust, AmorphousBoron, 2)
                .output(dust, Boron)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

//MAGNESIUM REGERNATION
        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(dust, Magnesia, 2)
                .notConsumable(stick, Tantalum)
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(RockSalt.getFluid(288))
                .notConsumable(MagnesiumChloride.getFluid(864))
                .duration(100)
                .output(dust, Magnesium)
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(dust, Magnesia, 2)
                .notConsumable(stick, Steel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(RockSalt.getFluid(288))
                .notConsumable(MagnesiumChloride.getFluid(864))
                .duration(400)
                .output(dust, Magnesium)
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .buildAndRegister();

//PRODUCTION OF KBF4
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BoricAcid, 7)
                .fluidInputs(HydrofluoricAcid.getFluid(4000))
                .fluidOutputs(TetrafluoroboricAcid.getFluid(1000))
                .duration(600)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumCarbonate, 6)
                .fluidInputs(TetrafluoroboricAcid.getFluid(1000))
                .fluidOutputs(PotassiumTetrafluoroborateSolution.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumTetrafluoroborateSolution.getFluid(1000))
                .output(dust, PotassiumTetrafluoroborate, 12)
                .fluidOutputs(Water.getFluid(7000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

//ELECTROLYSIS ELECTRODE PRODUCTION
        ARC_FURNACE_RECIPES.recipeBuilder()
                .input(dust, BoronTrioxide, 10)
                .input("dustAnyPurityCarbon", 7)
                .output(dust, BoronCarbide, 5)
                .fluidOutputs(CarbonMonoxide.getFluid(6000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        for (Utils.Blanket blanket : sintering_blankets) {
            SINTERING_RECIPES.recipeBuilder()
                    .input(dust, BoronCarbide)
                    .notConsumable(SHAPE_MOLD_ROD)
                    .fluidInputs(blanket.fluid)
                    .output(stick, BoronCarbide)
                    .duration(blanket.duration)
                    .EUt(120)
                    .buildAndRegister();
        }

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(dust, BoronCarbide)
                .notConsumable(SHAPE_MOLD_ROD)
                .output(stick, BoronCarbide)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//ELECTROLYSIS OF B2O3
        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(dust, BoronTrioxide, 5)
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, BoronCarbide)
                .notConsumable(SodiumFluoride.getFluid())
                .notConsumable(PotassiumTetrafluoroborate.getFluid())
                .output(dust, ElectrolyticBoron, 2)
                .fluidOutputs(Oxygen.getFluid(3000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(dust, ElectrolyticBoron, 4)
                .output(dust, Boron, 3)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

//PURIFICATION OF SEMICONDUCTOR-GRADE BORON
        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AmorphousBoron, 1)
                .fluidInputs(Chlorine.getFluid(4040))
                .chancedOutput(dust, MagnesiumChloride, 3, 600, 0)
                .fluidOutputs(BoronTrichloride.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ElectrolyticBoron, 1)
                .fluidInputs(Chlorine.getFluid(3040))
                .chancedOutput(dust, MagnesiumChloride, 3, 600, 0)
                .fluidOutputs(BoronTrichloride.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(BoronTrichloride.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(dust, HighPurityBoron)
                .fluidOutputs(HydrogenChloride.getFluid(3000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();
    }
}
