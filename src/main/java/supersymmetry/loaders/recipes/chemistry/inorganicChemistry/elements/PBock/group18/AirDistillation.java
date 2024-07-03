package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group18;

import gregtech.api.fluids.store.FluidStorageKeys;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.FLUID_FILTER;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.common.materials.SusyMaterials.*;

public class AirDistillation {
    public static void init() {
//TIER ONE (OXYGEN + NITROGEN)

/*AIR PREPROCESSING
//COMPRESSION
FLUID_COMPRESSOR_RECIPES.recipeBuilder()
    .fluidInputs(Air.getFluid(6000))
    .fluidOutputs(CompressedAir.getFluid(1000))
    .duration(31)
    .EUt(30)
    .buildAndRegister();

//WATER COOLING
HEAT_EXCHANGER_RECIPES.recipeBuilder()
    .fluidInputs(LiquidNitrogen.getFluid(10))
    .fluidInputs(Water.getFluid(1280))
    .fluidOutputs(Nitrogen.getFluid(640))
    .fluidOutputs(ColdWater.getFluid(1280))
    .duration(31)
    .buildAndRegister();

HEAT_EXCHANGER_RECIPES.recipeBuilder()
    .fluidInputs(PurifiedWasteGaseousNitrogen.getFluid(640))
    .fluidInputs(Water.getFluid(1280))
    .fluidOutputs(Nitrogen.getFluid(640))
    .fluidOutputs(ColdWater.getFluid(1280))
    .duration(5)
    .buildAndRegister();

//AIR WASHING AND PRECOOLING
CONTACT_COOLER.recipeBuilder()
    .fluidInputs(CompressedAir.getFluid(1000))
    .fluidInputs(ColdWater.getFluid(640))
    .fluidOutputs(ChilledAir.getFluid(1000))
    .fluidOutputs(Water.getFluid(640))
    .duration(31)
    .EUt(30)
    .buildAndRegister()*/;

//CO2 REMOVAL
        SIFTER_RECIPES.recipeBuilder()
                .input(dustTiny, MolecularSieve)
                .fluidInputs(Air.getFluid(12000))
                .fluidOutputs(DecarburizedAir.getFluid(12000))
                .output(dustTiny, DirtyMolecularSieve)
                .duration(4)
                .EUt(480)
                .buildAndRegister();

//VACUUM REHEATING FOR REGENERATION
        VACUUM_CHAMBER.recipeBuilder()
                .input(dustTiny, DirtyMolecularSieve)
                .notConsumable(spring, Kanthal)
                .output(dustTiny, MolecularSieve)
                .fluidOutputs(CarbonDioxide.getFluid(20))
                .duration(4)
                .EUt(30)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(ChillyWasteGaseousNitrogen.getFluid(640))
                .fluidInputs(HighPressureDecarburizedAir.getFluid(1000))
                .fluidOutputs(WasteGaseousNitrogen.getFluid(640))
                .fluidOutputs(ColdHighPressureDecarburizedAir.getFluid(1000))
                .duration(1)
                .buildAndRegister();
/*
//SIDESTREAM OF BOOSTED AIR FOR COLD GENERATION
        FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedAir.getFluid(1000))
                .fluidOutputs(BoostedAir.getFluid(300))
                .duration(114)
                .EUt(30)
                .buildAndRegister();

//FIVE LANE HEAT EXCHANGER
        TAPPED_OFF_HEAT_EXCHANGER.recipeBuilder()
                .fluidInputs(BoostedAir.getFluid(300))
                .fluidInputs(PurifiedAir.getFluid(500))
                .fluidOutputs(ChilledBoostedAir.getFluid(150))
                .fluidOutputs(PartiallyLiquefiedAir.getFluid(150))
                .fluidOutputs(GaseousAirFeedstock.getFluid(500))
                .duration(5)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedAir.getFluid(500))
                .fluidInputs(UntreatedLiquidOxygen.getFluid(15))
                .fluidOutputs(GaseousAirFeedstock.getFluid(500))
                .fluidOutputs(Oxygen.getFluid(720))
                .duration(5)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(UntreatedLiquidOxygen.getFluid(10))
                .fluidInputs(ChillyWasteGaseousNitrogen.getFluid(320))
                .fluidOutputs(Oxygen.getFluid(480))
                .fluidOutputs(WasteGaseousNitrogen.getFluid(320))
                .duration(5)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(ChillyWasteGaseousNitrogen.getFluid(320))
                .fluidInputs(UntreatedLiquidNitrogen.getFluid(25))
                .fluidOutputs(WasteGaseousNitrogen.getFluid(320))
                .fluidOutputs(Nitrogen.getFluid(1200))
                .duration(5)
                .buildAndRegister();

//STARTUP HEAT EXCHANGE
        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedAir.getFluid(500))
                .fluidInputs(LiquidOxygen.getFluid(10))
                .fluidOutputs(GaseousAirFeedstock.getFluid(500))
                .fluidOutputs(Oxygen.getFluid(640))
                .duration(5)
                .buildAndRegister();

//FINAL PREPROCESSING
        FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                .fluidInputs(ChilledBoostedAir.getFluid(150))
                .fluidOutputs(GaseousAirFeedstock.getFluid(500))
                .duration(114)
                .EUt(30)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(PartiallyLiquifiedAir.getFluid(150))
                .fluidOutputs(LiquidAirFeedstock.getFluid(50))
                .fluidOutputs(GaseousAirFeedstock.getFluid(100))
                .duration(114)
                .buildAndRegister()*/;

//STARTUP DISTILLATION RECIPE
        HIGH_PRESSURE_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(LiquidDecarburizedAir.getFluid(100))
                .fluidInputs(ColdHighPressureDecarburizedAir.getFluid(5600))
                .fluidOutputs(OxygenRichLiquid.getFluid(50))
                .fluidOutputs(OxygenRichGas.getFluid(200))
                .fluidOutputs(NitrogenRichGas.getFluid(1400))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

//REFLUXED DISTILLATION RECIPE
        BATH_CONDENSER.recipeBuilder()
                .fluidInputs(NitrogenRichGas.getFluid(200))
                .fluidOutputs(UntreatedLiquidNitrogen.getFluid(25))
                //.cleanroom(CleanroomType.LOW_PRESSURE_DISTILLATION_TOWER)
                .duration(1)
                .buildAndRegister();

        HIGH_PRESSURE_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(UntreatedLiquidNitrogen.getFluid(25))
                .fluidInputs(LiquidDecarburizedAir.getFluid(100))
                .fluidInputs(ColdHighPressureDecarburizedAir.getFluid(5600))
                .fluidOutputs(OxygenRichLiquid.getFluid(50))
                .fluidOutputs(OxygenRichGas.getFluid(200))
                .fluidOutputs(NitrogenRichGas.getFluid(1600))
                .duration(5)
                .EUt(480)
                .buildAndRegister();

//UPPER COLUMN FOR FINAL AIR SEPARATION
//STARTUP
        LOW_PRESSURE_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(OxygenRichLiquid.getFluid(50))
                .fluidInputs(OxygenRichGas.getFluid(800))
                .fluidInputs(NitrogenRichGas.getFluid(3200))
                .fluidOutputs(UntreatedLiquidOxygen.getFluid(50))
                .fluidOutputs(ColdWasteGaseousNitrogen.getFluid(5440))
                .fluidOutputs(ArgonRichGas.getFluid(200))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

//SUBCOOLED
        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(ColdWasteGaseousNitrogen.getFluid(640))
                .fluidInputs(UntreatedLiquidNitrogen.getFluid(50))
                .fluidOutputs(ChillyWasteGaseousNitrogen.getFluid(640))
                .fluidOutputs(SubcooledLiquidNitrogen.getFluid(50))
                .duration(5)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(UntreatedLiquidNitrogen.getFluid(25))
                .fluidInputs(UntreatedLiquidOxygen.getFluid(50))
                .fluidOutputs(SubcooledLiquidNitrogen.getFluid(25))
                .fluidOutputs(LiquidOxygenProduct.getFluid(50))
                .duration(5)
                .buildAndRegister();

        LOW_PRESSURE_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(OxygenRichLiquid.getFluid(50))
                .fluidInputs(OxygenRichGas.getFluid(800))
                .fluidInputs(NitrogenRichGas.getFluid(3200))
                .fluidInputs(SubcooledLiquidNitrogen.getFluid(50))
                .fluidOutputs(UntreatedLiquidOxygen.getFluid(50))
                .fluidOutputs(ColdWasteGaseousNitrogen.getFluid(640))
                .fluidOutputs(LiquidNitrogen.getFluid(150))
                .fluidOutputs(ArgonRichGas.getFluid(200))
                .duration(5)
                .EUt(480)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LiquidNitrogenProduct.getFluid(100))
                .fluidOutputs(LiquidNitrogen.getFluid(75))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LiquidOxygenProduct.getFluid(100))
                .fluidOutputs(Oxygen.getFluid(FluidStorageKeys.LIQUID, 75))
                .duration(1)
                .EUt(7)
                .buildAndRegister();

//TIER TWO: ADDED ARGON

//NO GAS TAPOFF
        HIGH_PRESSURE_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(UntreatedLiquidNitrogen.getFluid(25))
                .fluidInputs(LiquidDecarburizedAir.getFluid(100))
                .fluidInputs(ColdHighPressureDecarburizedAir.getFluid(5600))
                .fluidOutputs(OxygenRichLiquid.getFluid(75))
                .fluidOutputs(NitrogenRichGas.getFluid(1600))
                .duration(5)
                .EUt(480)
                .buildAndRegister();

//STARTUP DISTILLATION
        SINGLE_COLUMN_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(ArgonRichGas.getFluid(800))
                .fluidOutputs(CrudeArgonVapor.getFluid(80))
                .fluidOutputs(OxygenRichLiquid.getFluid(90))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

//REFLUXED DISTILLATION
        SINGLE_COLUMN_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(LiquidCrudeArgon.getFluid(5))
                .fluidInputs(ArgonRichGas.getFluid(400))
                .fluidOutputs(CrudeArgonVapor.getFluid(120))
                .fluidOutputs(OxygenRichLiquid.getFluid(90))
                .duration(10)
                .EUt(480)
                .buildAndRegister();

//CONDENSATION
        BATH_CONDENSER.recipeBuilder()
                .fluidInputs(SubcooledOxygenRichLiquid.getFluid(150))
                .fluidInputs(CrudeArgonVapor.getFluid(60))
                .fluidOutputs(LiquidCrudeArgon.getFluid(15))
                .fluidOutputs(OxygenRichLiquid.getFluid(100))
                .fluidOutputs(OxygenRichGas.getFluid(400))
                //.cleanroom(CleanroomType.SINGLE_COLUMN_CRYOGENIC_DISTILLATION)
                .duration(1)
                .buildAndRegister();

//DEOXYGENATION
        MIXER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumHexachloroplatinate, 17)
                .fluidInputs(PhosphoricAcid.getFluid(1000))
                .fluidOutputs(PlatinumPrecursorSolution.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(dust, Alumina, 5)
                .fluidInputs(PlatinumPrecursorSolution.getFluid(1000))
                .output(dust, SupportedPlatinum)
                .fluidOutputs(PhosphoricAcid.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LiquidCrudeArgon.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(24))
                .notConsumable(catalystBed, SupportedPlatinum)
                .chancedOutput(dust, Ice, 120, 0)
                .fluidOutputs(LiquidDeoxygenatedArgon.getFluid(50))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

//ARGON PURIFICATION
//STARTUP DISTILLATION
        SINGLE_COLUMN_CRYOGENIC_DISTILLATION.recipeBuilder()
                .fluidInputs(LiquidDeoxygenatedArgon.getFluid(200))
                .fluidOutputs(ColdWasteGaseousNitrogen.getFluid(16))
                .fluidOutputs(LiquidArgonProduct.getFluid(200))
                .duration(200)
                .EUt(480)
                .buildAndRegister();

//REFLUXED DISTILLATION
        BATH_CONDENSER.recipeBuilder()
                .fluidInputs(ColdWasteGaseousNitrogen.getFluid(8))
                .fluidOutputs(LiquidWasteNitrogen.getFluid(1))
                //.cleanroom(CleanroomType.SINGLE_COLUMN_CRYOGENIC_DISTILLATION)
                .duration(1)
                .buildAndRegister();

        SINGLE_COLUMN_CRYOGENIC_DISTILLATION.recipeBuilder()
                .fluidInputs(LiquidDeoxygenatedArgon.getFluid(200))
                .fluidInputs(Argon.getFluid(400))
                .fluidInputs(LiquidWasteNitrogen.getFluid(1))
                .fluidOutputs(ColdWasteGaseousNitrogen.getFluid(24))
                .fluidOutputs(LiquidArgonProduct.getFluid(200))
                .duration(83)
                .EUt(480)
                .buildAndRegister();

//STARTUP SUBCOOLING
        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(OxygenRichLiquid.getFluid(75))
                .fluidInputs(LiquidNitrogen.getFluid(150))
                .fluidOutputs(SubcooledOxygenRichLiquid.getFluid(75))
                .fluidOutputs(Nitrogen.getFluid(9600))
                .duration(5)
                .buildAndRegister();

//NORMAL SUBCOOLING
        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(OxygenRichLiquid.getFluid(75))
                .fluidInputs(LiquidArgonProduct.getFluid(5))
                .fluidOutputs(SubcooledOxygenRichLiquid.getFluid(75))
                .fluidOutputs(PartiallyLiquefiedArgon.getFluid(18))
                .duration(5)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(PartiallyLiquefiedArgon.getFluid(450))
                .fluidOutputs(Argon.getFluid(400))
                .fluidOutputs(LiquidArgonProduct.getFluid(50))
                .duration(29)
                .EUt(480)
                .buildAndRegister();

//ADAPTED LOW PRESSURE RECIPE
        LOW_PRESSURE_CRYOGENIC_DISTILLATION.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(OxygenRichLiquid.getFluid(100))
                .fluidInputs(OxygenRichGas.getFluid(1600))
                .fluidInputs(NitrogenRichGas.getFluid(6400))
                .fluidInputs(SubcooledLiquidNitrogen.getFluid(100))
                .fluidOutputs(UntreatedLiquidOxygen.getFluid(105))
                .fluidOutputs(ColdWasteGaseousNitrogen.getFluid(1280))
                .fluidOutputs(LiquidNitrogenProduct.getFluid(300))
                .fluidOutputs(ArgonRichGas.getFluid(400))
                .duration(5)
                .EUt(480)
                .buildAndRegister();

//ADAPTED HEAT EXCHANGE (SUBCOOLING)
        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(ColdWasteGaseousNitrogen.getFluid(1280))
                .fluidInputs(UntreatedLiquidNitrogen.getFluid(100))
                .fluidOutputs(ChillyWasteGaseousNitrogen.getFluid(1280))
                .fluidOutputs(SubcooledLiquidNitrogen.getFluid(100))
                .duration(5)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(UntreatedLiquidNitrogen.getFluid(100))
                .fluidInputs(UntreatedLiquidOxygen.getFluid(55))
                .fluidOutputs(SubcooledLiquidNitrogen.getFluid(100))
                .fluidOutputs(LiquidOxygenProduct.getFluid(55))
                .duration(5)
                .buildAndRegister();
    }
}
