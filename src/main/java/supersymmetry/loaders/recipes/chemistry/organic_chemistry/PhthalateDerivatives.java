package supersymmetry.loaders.recipes.chemistry.organic_chemistry;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PhthalateDerivatives {
    public static void init() {
        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(OrthoXylene.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(6000))
                .notConsumable(dust, VanadiumPentoxide)
                .fluidOutputs(Steam.getFluid(3000))
                .output(dust, PhthalicAnhydride, 13)
                .duration(300)
                .EUt(240)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .input(dust, PhthalicAnhydride, 15)
                .output(dust, PhthalicAcid, 18)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, VanadiumPentoxide)
                .fluidInputs(Naphthalene.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(9000))
                .output(dust, PhthalicAcid, 18)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Amoco process

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Bromine.getFluid(8000))
                .output(dust, CarbonTetrabromide, 5)
                .fluidOutputs(HydrogenBromide.getFluid(4000))
                .EUt(120)
                .duration(3)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Cobalt)
                .input(dust, Manganese)
                .input(dust, CarbonTetrabromide, 5)
                .output(dust, AmocoProcessCatalyst, 2)
                .EUt(120)
                .duration(120)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(HotHighPressureAir.getFluid(8000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .notConsumable(dust, AmocoProcessCatalyst)
                .fluidOutputs(TerephthalicAcidSlurry.getFluid(2000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(ParaXylene.getFluid(1000))
                .fluidInputs(HotHighPressureOxygen.getFluid(2000))
                .notConsumable(CarbonDioxide.getFluid(6000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .notConsumable(dust, AmocoProcessCatalyst)
                .fluidOutputs(TerephthalicAcidSlurry.getFluid(2000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(MetaXylene.getFluid(1000))
                .fluidInputs(HotHighPressureAir.getFluid(8000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .notConsumable(dust, AmocoProcessCatalyst)
                .fluidOutputs(IsophthalicAcidSlurry.getFluid(2000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(MetaXylene.getFluid(1000))
                .fluidInputs(HotHighPressureOxygen.getFluid(2000))
                .notConsumable(CarbonDioxide.getFluid(6000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .notConsumable(dust, AmocoProcessCatalyst)
                .fluidOutputs(IsophthalicAcidSlurry.getFluid(2000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .notConsumable(ITEM_FILTER)
                .fluidInputs(IsophthalicAcidSlurry.getFluid(2000))
                .output(dust, AmocoIsophthalicAcid, 18)
                .fluidOutputs(DilutedAceticAcid.getFluid(2000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .notConsumable(ITEM_FILTER)
                .fluidInputs(TerephthalicAcidSlurry.getFluid(2000))
                .output(dust, AmocoTerephthalicAcid, 18)
                .fluidOutputs(DilutedAceticAcid.getFluid(2000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedAceticAcid.getFluid(2000))
                .fluidOutputs(AceticAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

// Amoco purification process

        MIXER_RECIPES.recipeBuilder()
                .input(dust, AmocoTerephthalicAcid, 18)
                .fluidInputs(HeatedWater.getFluid(1000))
                .fluidOutputs(CrudeTerephthalicAcidSlurry.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, AmocoIsophthalicAcid, 18)
                .fluidInputs(HeatedWater.getFluid(1000))
                .fluidOutputs(CrudeIsophthalicAcidSlurry.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, PalladiumOnCarbon)
                .fluidInputs(CrudeTerephthalicAcidSlurry.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(15))
                .fluidOutputs(HydrogenatedTerephthalicAcidSlurry.getFluid(1005))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, PalladiumOnCarbon)
                .fluidInputs(CrudeIsophthalicAcidSlurry.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(15))
                .fluidOutputs(HydrogenatedIsophthalicAcidSlurry.getFluid(1005))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenatedTerephthalicAcidSlurry.getFluid(1005))
                .output(dust, WetTerephthalicAcid, 18)
                .fluidOutputs(AmocoPurificationMotherLiquor.getFluid(505))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenatedIsophthalicAcidSlurry.getFluid(1005))
                .output(dust, WetIsophthalicAcid, 18)
                .fluidOutputs(AmocoPurificationMotherLiquor.getFluid(505))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .input(dust, WetTerephthalicAcid, 18)
                .output(dust, TerephthalicAcid, 18)
                .fluidOutputs(Water.getFluid(500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .input(dust, WetIsophthalicAcid, 18)
                .output(dust, IsophthalicAcid, 18)
                .fluidOutputs(Water.getFluid(500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AmocoPurificationMotherLiquor.getFluid(505))
                .chancedOutput(dust, ParaToluicAcid, 50, 0)
                .fluidOutputs(Water.getFluid(500))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(dust, ParaToluicAcid)
                .fluidOutputs(ParaToluicAcid.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

// Dynamit-Nobel process
// Initialization
        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .notConsumable(catalystBed, Cobalt)
                .fluidInputs(ParaXylene.getFluid(50))
                .fluidInputs(Oxygen.getFluid(150))
                .fluidOutputs(Water.getFluid(50))
                .fluidOutputs(ParaToluicAcid.getFluid(50))
                .EUt(120)
                .duration(20)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(ParaToluicAcid.getFluid(1000))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(MethylParaToluate.getFluid(1000))
                .EUt(120)
                .duration(400)
                .buildAndRegister();

// Looping
        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(catalystBed, Cobalt)
                .fluidInputs(ParaXylene.getFluid(50))
                .fluidInputs(MethylParaToluate.getFluid(50))
                .fluidInputs(Oxygen.getFluid(300))
                .fluidOutputs(Water.getFluid(100))
                .fluidOutputs(ParaToluateMixture.getFluid(100))
                .EUt(120)
                .duration(20)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(ParaToluateMixture.getFluid(2000))
                .fluidInputs(Methanol.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .fluidOutputs(MethylParaToluateMixture.getFluid(2000))
                .EUt(120)
                .duration(400)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylParaToluateMixture.getFluid(2000))
                .output(dust, CrudeDimethylTerephthalate, 24)
                .fluidOutputs(MethylParaToluate.getFluid(1000))
                .EUt(120)
                .duration(400)
                .buildAndRegister();

// Dynamit-Nobel purification process
// Initialization
        MIXER_RECIPES.recipeBuilder()
                .input(dust, CrudeDimethylTerephthalate, 24)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(CrudeDimethylTerephthalateSolution.getFluid(1000))
                .EUt(120)
                .duration(20)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(CrudeDimethylTerephthalateSolution.getFluid(1000))
                .output(dust, DimethylTerephthalate, 12)
                .fluidOutputs(TerephthalateMotherLiquor.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

// Looping
        MIXER_RECIPES.recipeBuilder()
                .input(dust, CrudeDimethylTerephthalate, 12)
                .fluidInputs(TerephthalateMotherLiquor.getFluid(1000))
                .fluidOutputs(CrudeDimethylTerephthalateSolution.getFluid(1000))
                .EUt(120)
                .duration(20)
                .buildAndRegister();

// Isophthaloyl chloride

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .input(dust, IsophthalicAcid, 18)
                .fluidOutputs(DichloroethaneIsophthalicAcidSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DichloroethaneIsophthalicAcidSolution.getFluid(1000))
                .fluidInputs(Phosgene.getFluid(2000))
                .fluidOutputs(IsophthaloylChlorideSolution.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(IsophthaloylChlorideSolution.getFluid(1000))
                .output(dust, IsophthaloylChloride, 16)
                .fluidOutputs(Dichloroethane.getFluid(1000))
                .duration(40)
                .EUt(30)
                .buildAndRegister();

// Terephthaloyl chloride

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TerephthalicAcid, 3)
                .fluidInputs(Bistrichloromethylbenzene.getFluid(1000))
                .output(dust, TerephthaloylChloride, 32)
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

    }
}
