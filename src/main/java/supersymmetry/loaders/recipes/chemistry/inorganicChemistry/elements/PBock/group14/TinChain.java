package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group14;

import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.concentrate;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.combustibles;

public class TinChain {
    public static void init() {
        // Tin Dust * 1
        removeRecipesByInputs(CENTRIFUGE_RECIPES, CrudeTin.getFluid(1000));

//CASSITERITE BENEFICIATION
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Cassiterite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Cassiterite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Cassiterite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(dust, SodiumFluorosilicate)
                .notConsumable(OleicAcid.getFluid(144))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .fluidOutputs(Cassiterite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(LimestoneTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Cassiterite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(dust, Cassiterite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LimestoneTailingSlurry.getFluid(1000))
                .output(dust, LimestoneTailings, 2)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, Cassiterite)
                .output(concentrate, Cassiterite)
                .chancedOutput(dust, Hematite, 2500, 0)
                .EUt(7)
                .duration(100)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(concentrate, Cassiterite)
                .fluidInputs(AmmoniaSolution.getFluid(120))
                .fluidOutputs(AmmoniumTungstateSolution.getFluid(60))
                .output(dust, LeachedCassiteriteConcentrate)
                .EUt(1920)
                .duration(100)
                .buildAndRegister();

//SMELTING
        for (Utils.CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(2));
            REACTION_FURNACE_RECIPES.recipeBuilder()
                    .input(concentrate, Cassiterite)
                    .inputs(combustible.name)
                    .outputs(combustible.byproduct)
                    .fluidOutputs(CrudeTin.getFluid(190))
                    .fluidOutputs(TinDross.getFluid(25))
                    .fluidOutputs(CarbonDioxide.getFluid(1000))
                    .EUt(120)
                    .duration(160)
                    .buildAndRegister();

            REACTION_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, LeachedCassiteriteConcentrate)
                    .inputs(combustible.name)
                    .outputs(combustible.byproduct)
                    .fluidOutputs(CrudeTin.getFluid(190))
                    .fluidOutputs(TinDross.getFluid(25))
                    .fluidOutputs(CarbonDioxide.getFluid(1000))
                    .EUt(120)
                    .duration(160)
                    .buildAndRegister();
        }

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(TinDross.getFluid(100))
                .fluidOutputs(CrudeTin.getFluid(85))
                .fluidOutputs(Iron.getFluid(15))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(CrudeTin.getFluid(216))
                .output(ingot, Tin)
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(DecopperizedTin.getFluid(180))
                .output(ingot, Tin)
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .notConsumable(SulfuricAcid.getFluid(1000))
                .fluidInputs(HotHighPressureOxygen.getFluid(1000))
                .input(dust, Tin)
                .output(dust, PurifiedTinIIOxide, 2)
                .EUt(480)
                .duration(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PurifiedTinIIOxide, 2)
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, HighPurityTin)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(120)
                .duration(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input("dustAnyPuritySulfur")
                .fluidInputs(CrudeTin.getFluid(5760))
                .fluidOutputs(DecopperizedTin.getFluid(5760))
                .output(dust, CopperMonosulfide, 2)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(2000))
                .input(dust, CopperMonosulfide, 2)
                .output(dust, Copper)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(DecopperizedTin.getFluid(2880))
                .notConsumable(wireFine, Aluminium)
                .chancedOutput(dust, Antimony, 500, 0)
                .chancedOutput(dust, Bismuth, 500, 0)
                .fluidOutputs(Tin.getFluid(2880))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

    }
}
