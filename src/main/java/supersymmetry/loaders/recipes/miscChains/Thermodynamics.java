package supersymmetry.loaders.recipes.miscChains;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.Material;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Thermodynamics {
    private static class ICoolant{

        public Material coldCoolant;
        public Material warmCoolant;

        public int durationRadiator = 200;
        public int amountToUse = 1000;
        public int hxTimeFactor = 10;

        public ICoolant(Material coolant_normal, Material coolant_warm){
            this.coldCoolant = coolant_normal;
            this.warmCoolant = coolant_warm;
        }
    }
    private static class ICryoGas{

        public Material normalGas;
        public Material hotHighPressureGas;
        public Material highPressureGas;
        public Material coldHighPressureGas;
        public Material liquidGas;

        public int amountToUse = 20000;

        public int EUt = 30;
        public int duration = 20;

        public int powerHeatExchanger = 20;
        public int durationHeatExchanger = 10;

        public int durationRadiator = 100;

        public int fluidTemperature = 300;

        public ICryoGas(Material gas_normal, Material gas_hot_hp, Material gas_hp, Material gas_cold_hp, Material gas_liquid) {
            normalGas = gas_normal;
            hotHighPressureGas = gas_hot_hp;
            highPressureGas = gas_hp;
            coldHighPressureGas = gas_cold_hp;
            liquidGas = gas_liquid;
        }
    }
    private static class IRefrigerant{

        Material normalRefrigerant;
        Material hotRefrigerant;
        Material compRefrigerant;
        Material coldRefrigerant;

        int EUt = 30;
        int duration = 20;

        int durationRadiator = 20;
        int amountToUse = 1000;

        int hxTimeFactor = 10;

        public IRefrigerant(Material refrigerant_normal, Material refrigerant_hot, Material refrigerant_comp, Material refrigerant_cold) {
            normalRefrigerant = refrigerant_normal;
            hotRefrigerant = refrigerant_hot;
            compRefrigerant = refrigerant_comp;
            coldRefrigerant = refrigerant_cold;
        }
    }
    private static class IFluidFuel{

        public Material liquidFuel;
        public Material byproduct;

        public int duration;
        public int amountToBurn;

        public int byproductAmount = 1000;

        public boolean refinedFuel = false;
        public boolean gasTurbine = true;

        public IFluidFuel(Material fuel_liquid, Material byproduct_liquid) {
            this.liquidFuel = fuel_liquid;
            this.byproduct = byproduct_liquid;
        }
    }
    private static class IWorkingFluid{
        public Material normalFluid;
        public Material heatedFluid;
        public Material leftoverFluid;

        public int duration;
        public int amountToUse;

        public int conversionFactor = 160;

        public int efficiency = 1;

        public IWorkingFluid(Material fluid_normal, Material fluid_heated, Material fluid_leftover) {
            this.normalFluid = fluid_normal;
            this.heatedFluid = fluid_heated;
            this.leftoverFluid = fluid_leftover;
        }
    }


    public static class ILubricant {
        public Material name;
        public int amountRequired;
        public double boost;
        public ILubricant(Material name, int amountRequired, double boost) {
            this.name = name;
            this.amountRequired = amountRequired;
            this.boost = boost;
        }
    }
    public static void init() {
        ILubricant[] lubricants = {
                new ILubricant(LubricatingOil, 1, 1.1),
                new ILubricant(Lubricant, 2, 1.2),
                new ILubricant(MidgradeLubricant, 2, 1.3),
                new ILubricant(PremiumLubricant, 1, 1.4),
                new ILubricant(SupremeLubricant, 1, 1.5)
        };

//REMOVALS
        removeRecipesByInputs(GAS_TURBINE_FUELS, Steam.getFluid(640));
        removeRecipesByInputs(GAS_TURBINE_FUELS, CoalGas.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Ethylene.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, NaturalGas.getFluid(8));
        removeRecipesByInputs(GAS_TURBINE_FUELS, RefineryGas.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, SulfuricNaphtha.getFluid(4));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Propane.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, WoodGas.getFluid(8));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Methane.getFluid(2));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Butane.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Phenol.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, LPG.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Benzene.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Ethane.getFluid(4));
        removeRecipesByInputs(GAS_TURBINE_FUELS, SulfuricGas.getFluid(32));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Propane.getFluid(4));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Butane.getFluid(4));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Nitrobenzene.getFluid(1));
        removeRecipesByInputs(GAS_TURBINE_FUELS, Butadiene.getFluid(16));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, Octane.getFluid(2));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, OilLight.getFluid(32));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, SulfuricLightFuel.getFluid(4));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, Ethanol.getFluid(1));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, BioDiesel.getFluid(1));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, Methanol.getFluid(4));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, LightFuel.getFluid(1));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, Toluene.getFluid(1));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, Naphtha.getFluid(1));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, Diesel.getFluid(1));
//        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, OilMedium.getFluid(64));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, CetaneBoostedDiesel.getFluid(2));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, Gasoline.getFluid(1));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, PremiumGasoline.getFluid(1));
        removeRecipesByInputs(COMBUSTION_GENERATOR_FUELS, RocketFuel.getFluid(16));

        ICoolant WaterCoolant = new ICoolant(Water, WarmWater);
        WaterCoolant.durationRadiator = 100;
        WaterCoolant.amountToUse = 1000;
        WaterCoolant.hxTimeFactor = 10;

        ICoolant SaltWaterCoolant = new ICoolant(SaltWater, WarmSaltWater);
        SaltWaterCoolant.durationRadiator = 100;
        SaltWaterCoolant.amountToUse = 1000;
        SaltWaterCoolant.hxTimeFactor = 15;

        ICoolant BrineCoolant = new ICoolant(Brine, WarmBrine);
        BrineCoolant.durationRadiator = 100;
        BrineCoolant.amountToUse = 1000;
        BrineCoolant.hxTimeFactor = 15;

        ICoolant LubricantCoolant = new ICoolant(Lubricant, WarmLubricant);
        LubricantCoolant.durationRadiator = 75;
        LubricantCoolant.amountToUse = 1000;
        LubricantCoolant.hxTimeFactor = 6;

        ICoolant SodiumPotassiumCoolant = new ICoolant(SodiumPotassium, WarmSodiumPotassium);
        SodiumPotassiumCoolant.durationRadiator = 60;
        SodiumPotassiumCoolant.amountToUse = 2000;
        SodiumPotassiumCoolant.hxTimeFactor = 5;

        ICoolant EthyleneGlycolCoolant = new ICoolant(EthyleneGlycol, WarmEthyleneGlycol);
        EthyleneGlycolCoolant.durationRadiator = 50;
        EthyleneGlycolCoolant.amountToUse = 2000;
        EthyleneGlycolCoolant.hxTimeFactor = 4;

        ICoolant PolychlorinatedBiphenylCoolant = new ICoolant(PolychlorinatedBiphenyl, WarmPolychlorinatedBiphenyl);
        PolychlorinatedBiphenylCoolant.durationRadiator = 40;
        PolychlorinatedBiphenylCoolant.amountToUse = 1000;
        PolychlorinatedBiphenylCoolant.hxTimeFactor = 2;

        ICoolant[] coolants = {
                WaterCoolant,
                SaltWaterCoolant,
                BrineCoolant,
                LubricantCoolant,
                SodiumPotassiumCoolant,
                EthyleneGlycolCoolant,
                PolychlorinatedBiphenylCoolant
        };

        ICryoGas CryoHydrogen = new ICryoGas(
                Hydrogen,
                HotHighPressureHydrogen,
                HighPressureHydrogen,
                ColdHighPressureHydrogen,
                LiquidHydrogen
        );
        CryoHydrogen.EUt = 240;
        CryoHydrogen.powerHeatExchanger = 100;
        CryoHydrogen.duration = 5;
        CryoHydrogen.durationRadiator = 400;
        CryoHydrogen.fluidTemperature = (14);

        ICryoGas CryoOxygen = new ICryoGas(
                Oxygen,
                HotHighPressureOxygen,
                HighPressureOxygen,
                ColdHighPressureOxygen,
                ColdLiquidOxygen
        );
        CryoOxygen.EUt = 30;
        CryoOxygen.powerHeatExchanger = 100;
        CryoOxygen.duration = 5;
        CryoOxygen.durationRadiator = 400;
        CryoOxygen.fluidTemperature = (90);

        ICryoGas CryoHelium = new ICryoGas(
                Helium,
                HotHighPressureHelium,
                HighPressureHelium,
                ColdHighPressureHelium,
                Helium
        );
        CryoHelium.EUt = 720;
        CryoHelium.powerHeatExchanger = 100;
        CryoHelium.duration = 5;
        CryoHelium.durationRadiator = 400;
        CryoHelium.fluidTemperature = (4);

        ICryoGas CryoNeon = new ICryoGas(
                Neon,
                HotHighPressureNeon,
                HighPressureNeon,
                ColdHighPressureNeon,
                LiquidNeon
        );
        CryoNeon.EUt = 240;
        CryoNeon.powerHeatExchanger = 100;
        CryoNeon.duration = 5;
        CryoNeon.durationRadiator = 400;
        CryoNeon.fluidTemperature = (27);

        ICryoGas CryoArgon = new ICryoGas(
                Argon,
                HotHighPressureArgon,
                HighPressureArgon,
                ColdHighPressureArgon,
                LiquidArgon
        );
        CryoArgon.EUt = 120;
        CryoArgon.powerHeatExchanger = 100;
        CryoArgon.duration = 5;
        CryoArgon.durationRadiator = 400;
        CryoArgon.fluidTemperature = (87);

        ICryoGas CryoKrypton = new ICryoGas(
                Krypton,
                HotHighPressureKrypton,
                HighPressureKrypton,
                ColdHighPressureKrypton,
                LiquidKrypton
        );
        CryoKrypton.EUt = 120;
        CryoKrypton.powerHeatExchanger = 100;
        CryoKrypton.duration = 5;
        CryoKrypton.durationRadiator = 400;
        CryoKrypton.fluidTemperature = (120);

        ICryoGas CryoXenon = new ICryoGas(
                Xenon,
                HotHighPressureXenon,
                HighPressureXenon,
                ColdHighPressureXenon,
                LiquidXenon
        );
        CryoXenon.EUt = 120;
        CryoXenon.powerHeatExchanger = 100;
        CryoXenon.duration = 5;
        CryoXenon.durationRadiator = 400;
        CryoXenon.fluidTemperature = (165);

        ICryoGas CryoAir = new ICryoGas(
                Air,
                HotHighPressureAir,
                HighPressureAir,
                ColdHighPressureAir,
                LiquidAir
        );
        CryoAir.EUt = 60;
        CryoAir.powerHeatExchanger = 100;
        CryoAir.duration = 5;
        CryoAir.durationRadiator = 400;
        CryoAir.fluidTemperature = (80);

        ICryoGas CryoDecarburizedAir = new ICryoGas(
                DecarburizedAir,
                HotHighPressureDecarburizedAir,
                HighPressureDecarburizedAir,
                ColdHighPressureDecarburizedAir,
                LiquidDecarburizedAir
        );
        CryoDecarburizedAir.EUt = 60;
        CryoDecarburizedAir.powerHeatExchanger = 100;
        CryoDecarburizedAir.duration = 8;
        CryoDecarburizedAir.durationRadiator = 40;
        CryoDecarburizedAir.fluidTemperature = (80);

        ICryoGas CryoNitrogen = new ICryoGas(
                Nitrogen,
                HotHighPressureNitrogen,
                HighPressureNitrogen,
                ColdHighPressureNitrogen,
                LiquidNitrogen
        );
        CryoNitrogen.EUt = 60;
        CryoNitrogen.powerHeatExchanger = 100;
        CryoNitrogen.duration = 5;
        CryoNitrogen.durationRadiator = 400;
        CryoNitrogen.fluidTemperature = (77);

        ICryoGas CryoNetherAir = new ICryoGas(
                NetherAir,
                HotHighPressureNetherAir,
                HighPressureNetherAir,
                ColdHighPressureNetherAir,
                LiquidNetherAir
        );
        CryoNetherAir.EUt = 60;
        CryoNetherAir.powerHeatExchanger = 100;
        CryoNetherAir.duration = 5;
        CryoNetherAir.durationRadiator = 400;
        CryoNetherAir.fluidTemperature = (80);

        ICryoGas CryoRefineryGas = new ICryoGas(
                RefineryGas,
                HotHighPressureRefineryGas,
                HighPressureRefineryGas,
                ColdHighPressureRefineryGas,
                LiquidRefineryGas
        );
        CryoRefineryGas.EUt = 60;
        CryoRefineryGas.powerHeatExchanger = 100;
        CryoRefineryGas.duration = 5;
        CryoRefineryGas.durationRadiator = 400;
        CryoRefineryGas.fluidTemperature = (80);

        ICryoGas CryoNaturalGas = new ICryoGas(
                NaturalGas,
                HotHighPressureNaturalGas,
                HighPressureNaturalGas,
                ColdHighPressureNaturalGas,
                LiquidNaturalGas
        );
        CryoNaturalGas.EUt = 60;
        CryoNaturalGas.powerHeatExchanger = 100;
        CryoNaturalGas.duration = 5;
        CryoNaturalGas.durationRadiator = 400;
        CryoNaturalGas.fluidTemperature = (80);

        ICryoGas CryoMethane = new ICryoGas(
                Methane,
                HotHighPressureMethane,
                HighPressureMethane,
                ColdHighPressureMethane,
                LiquidMethane
        );
        CryoMethane.EUt = 60;
        CryoMethane.powerHeatExchanger = 100;
        CryoMethane.duration = 5;
        CryoMethane.durationRadiator = 400;
        CryoMethane.fluidTemperature = (80);

        ICryoGas[] cryoGases = {
                CryoHydrogen,
                CryoOxygen,
                CryoHelium,
                CryoNeon,
                CryoArgon,
                CryoKrypton,
                CryoXenon,
                CryoNitrogen,
                CryoAir,
                CryoDecarburizedAir,
                CryoNetherAir,
                CryoRefineryGas,
                CryoNaturalGas,
                CryoMethane
        };

        IRefrigerant AmmoniaRefrigerant = new IRefrigerant(
                Ammonia,
                HotCompressedAmmonia,
                CompressedAmmonia,
                ColdAmmonia
        );
        AmmoniaRefrigerant.EUt = 120;
        AmmoniaRefrigerant.duration = 20;
        AmmoniaRefrigerant.durationRadiator = 20;
        AmmoniaRefrigerant.amountToUse = 1000;
        AmmoniaRefrigerant.hxTimeFactor = 10;

        IRefrigerant PropaneRefrigerant = new IRefrigerant(
                Propane,
                HotCompressedPropane,
                CompressedPropane,
                ColdPropane
        );
        PropaneRefrigerant.EUt = 60;
        PropaneRefrigerant.duration = 30;
        PropaneRefrigerant.durationRadiator = 10;
        PropaneRefrigerant.amountToUse = 2000;
        PropaneRefrigerant.hxTimeFactor = 15;

        IRefrigerant CarbonDioxideRefrigerant = new IRefrigerant(
                CarbonDioxide,
                HotCompressedCarbonDioxide,
                CompressedCarbonDioxide,
                ColdCarbonDioxide
        );
        CarbonDioxideRefrigerant.EUt = 30;
        CarbonDioxideRefrigerant.duration = 60;
        CarbonDioxideRefrigerant.durationRadiator = 10;
        CarbonDioxideRefrigerant.amountToUse = 3000;
        CarbonDioxideRefrigerant.hxTimeFactor = 20;

        IRefrigerant TrichlorofluoromethaneRefrigerant = new IRefrigerant(
                Trichlorofluoromethane,
                HotCompressedTrichlorofluoromethane,
                CompressedTrichlorofluoromethane,
                ColdTrichlorofluoromethane
        );
        TrichlorofluoromethaneRefrigerant.EUt = 180;
        TrichlorofluoromethaneRefrigerant.duration = 4;
        TrichlorofluoromethaneRefrigerant.durationRadiator = 2;
        TrichlorofluoromethaneRefrigerant.amountToUse = 1000;
        TrichlorofluoromethaneRefrigerant.hxTimeFactor = 2;

        IRefrigerant DichlorodifluoromethaneRefrigerant = new IRefrigerant(
                Dichlorodifluoromethane,
                HotCompressedDichlorodifluoromethane,
                CompressedDichlorodifluoromethane,
                ColdDichlorodifluoromethane
        );
        DichlorodifluoromethaneRefrigerant.EUt = 180;
        DichlorodifluoromethaneRefrigerant.duration = 4;
        DichlorodifluoromethaneRefrigerant.durationRadiator = 2;
        DichlorodifluoromethaneRefrigerant.amountToUse = 1000;
        DichlorodifluoromethaneRefrigerant.hxTimeFactor = 2;

        IRefrigerant ChlorotrifluoromethaneRefrigerant = new IRefrigerant(
                Chlorotrifluoromethane,
                HotCompressedChlorotrifluoromethane,
                CompressedChlorotrifluoromethane,
                ColdChlorotrifluoromethane
        );
        ChlorotrifluoromethaneRefrigerant.EUt = 180;
        ChlorotrifluoromethaneRefrigerant.duration = 4;
        ChlorotrifluoromethaneRefrigerant.durationRadiator = 2;
        ChlorotrifluoromethaneRefrigerant.amountToUse = 1000;
        ChlorotrifluoromethaneRefrigerant.hxTimeFactor = 2;

        IRefrigerant ChlorodifluoromethaneRefrigerant = new IRefrigerant(
                Chlorodifluoromethane,
                HotCompressedChlorodifluoromethane,
                CompressedChlorodifluoromethane,
                ColdChlorodifluoromethane
        );
        ChlorodifluoromethaneRefrigerant.EUt = 180;
        ChlorodifluoromethaneRefrigerant.duration = 4;
        ChlorodifluoromethaneRefrigerant.durationRadiator = 2;
        ChlorodifluoromethaneRefrigerant.amountToUse = 1000;
        ChlorodifluoromethaneRefrigerant.hxTimeFactor = 2;

        IRefrigerant[] refrigerants = {
                AmmoniaRefrigerant,
                PropaneRefrigerant,
                CarbonDioxideRefrigerant,
                TrichlorofluoromethaneRefrigerant,
                DichlorodifluoromethaneRefrigerant,
                ChlorotrifluoromethaneRefrigerant,
                ChlorodifluoromethaneRefrigerant
        };

//Refrigerant recipes generation
        for (IRefrigerant refrigerant : refrigerants) {
            //Compression
            FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.normalRefrigerant.getFluid(refrigerant.amountToUse))
                    .fluidOutputs(refrigerant.hotRefrigerant.getFluid(refrigerant.amountToUse))
                    .EUt(refrigerant.EUt)
                    .duration(refrigerant.duration)
                    .buildAndRegister();

            //Decompression
            FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.compRefrigerant.getFluid(refrigerant.amountToUse))
                    .fluidOutputs(refrigerant.coldRefrigerant.getFluid(refrigerant.amountToUse))
                    .EUt(8)
                    .duration(refrigerant.duration)
                    .buildAndRegister();

            //Radiative Cooling
            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.hotRefrigerant.getFluid(refrigerant.amountToUse))
                    .fluidOutputs(refrigerant.compRefrigerant.getFluid(refrigerant.amountToUse))
                    .duration(refrigerant.durationRadiator)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.hotRefrigerant.getFluid(refrigerant.amountToUse))
                    .fluidOutputs(refrigerant.compRefrigerant.getFluid(refrigerant.amountToUse))
                    .duration(refrigerant.durationRadiator / 2)
                    .EUt(480)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.compRefrigerant.getFluid(refrigerant.amountToUse))
                    .fluidOutputs(refrigerant.coldRefrigerant.getFluid(refrigerant.amountToUse))
                    .duration(refrigerant.durationRadiator / 2)
                    .EUt(480)
                    .buildAndRegister();
        }

//Coolant recipes generation
        for (ICoolant coolant : coolants) {
            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(coolant.warmCoolant.getFluid(coolant.amountToUse))
                    .fluidOutputs(coolant.coldCoolant.getFluid(coolant.amountToUse))
                    .duration(coolant.durationRadiator)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(coolant.warmCoolant.getFluid(coolant.amountToUse))
                    .fluidOutputs(coolant.coldCoolant.getFluid(coolant.amountToUse))
                    .duration(coolant.durationRadiator / 2)
                    .EUt(480)
                    .buildAndRegister();
        }

//Heat exchanger recipes generation
        for (ICryoGas cryoGas : cryoGases) {
            for (ICoolant coolant : coolants) {
                HEAT_EXCHANGER_RECIPES.recipeBuilder()
                        .fluidInputs(cryoGas.hotHighPressureGas.getFluid(cryoGas.amountToUse))
                        .fluidInputs(coolant.coldCoolant.getFluid(coolant.amountToUse))
                        .fluidOutputs(coolant.warmCoolant.getFluid(coolant.amountToUse))
                        .fluidOutputs(cryoGas.highPressureGas.getFluid(cryoGas.amountToUse))
                        .duration(cryoGas.durationHeatExchanger + coolant.hxTimeFactor)
                        .buildAndRegister();
            }
            for (IRefrigerant refrigerant : refrigerants) {
                HEAT_EXCHANGER_RECIPES.recipeBuilder()
                        .fluidInputs(cryoGas.highPressureGas.getFluid(cryoGas.amountToUse))
                        .fluidInputs(refrigerant.coldRefrigerant.getFluid(refrigerant.amountToUse))
                        .fluidOutputs(refrigerant.normalRefrigerant.getFluid(refrigerant.amountToUse))
                        .fluidOutputs(cryoGas.coldHighPressureGas.getFluid(cryoGas.amountToUse))
                        .duration(cryoGas.durationHeatExchanger + refrigerant.hxTimeFactor)
                        .buildAndRegister();
            }

            FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                    .fluidInputs(cryoGas.normalGas.getFluid(1280))
                    .fluidOutputs(cryoGas.hotHighPressureGas.getFluid(1280))
                    .duration(cryoGas.duration)
                    .EUt(cryoGas.EUt)
                    .buildAndRegister();

            //Decompression
            if (cryoGas.liquidGas == cryoGas.normalGas) {
                FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                        .fluidInputs(cryoGas.coldHighPressureGas.getFluid(1280))
                        .fluidOutputs(cryoGas.normalGas.getFluid(FluidStorageKeys.LIQUID, 20))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();

                //Reheating
                FLUID_HEATER_RECIPES.recipeBuilder()
                        .fluidInputs(cryoGas.normalGas.getFluid(FluidStorageKeys.LIQUID, 20))
                        .fluidOutputs(cryoGas.coldHighPressureGas.getFluid(1280))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();
            } else {
                FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                        .fluidInputs(cryoGas.coldHighPressureGas.getFluid(1280))
                        .fluidOutputs(cryoGas.liquidGas.getFluid(20))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();

                //Reheating
                FLUID_HEATER_RECIPES.recipeBuilder()
                        .fluidInputs(cryoGas.liquidGas.getFluid(20))
                        .fluidOutputs(cryoGas.coldHighPressureGas.getFluid(1280))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();
            }

            //Radiative Cooling
            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(cryoGas.hotHighPressureGas.getFluid(cryoGas.amountToUse))
                    .fluidOutputs(cryoGas.highPressureGas.getFluid(cryoGas.amountToUse))
                    .duration(cryoGas.durationHeatExchanger * 5)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(cryoGas.hotHighPressureGas.getFluid(cryoGas.amountToUse))
                    .fluidOutputs(cryoGas.highPressureGas.getFluid(cryoGas.amountToUse))
                    .duration(cryoGas.durationHeatExchanger * 2)
                    .EUt(480)
                    .buildAndRegister();

    /*if (!cryogas.needsAdvancedCooling) {
     COOLING_UNIT_RECIPES.recipeBuilder()
        .fluidInputs(liquid(cryogas.high_pressure_gas) * cryogas.amount_to_use)
        .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * cryogas.amount_to_use)
        .duration(cryogas.duration_heat_exchanger * 2)
        .EUt(480)
        .buildAndRegister();

    } else {
        for (CryoGas in ICryoGas.cryo_gases) {
            HEAT_EXCHANGER_RECIPES.recipeBuilder()
                    .fluidInputs(liquid(cryogas.high_pressure_gas) * (int) (cryogas.amount_to_use / 4))
                    .fluidInputs(liquid(CryoGas.Liquidgas) * 100)
                    .fluidOutputs(liquid(CryoGas.normal_gas) * 6400)
                    .fluidOutputs(liquid(cryogas.cold_high_pressure_gas) * (int) (cryogas.amount_to_use / 4))
                    .duration(cryogas.duration_heat_exchanger * 4)
                    .buildAndRegister();
        }
    }
    */
            // return to gas
            FLUID_HEATER_RECIPES.recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(cryoGas.coldHighPressureGas.getFluid(1280))
                    .fluidOutputs(cryoGas.highPressureGas.getFluid(1280))
                    .duration(20)
                    .EUt(8)
                    .buildAndRegister();

            FLUID_HEATER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .fluidInputs(cryoGas.coldHighPressureGas.getFluid(1280))
                    .fluidOutputs(cryoGas.hotHighPressureGas.getFluid(1280))
                    .duration(40)
                    .EUt(8)
                    .buildAndRegister();

            FLUID_HEATER_RECIPES.recipeBuilder()
                    .fluidInputs(cryoGas.highPressureGas.getFluid(1280))
                    .fluidOutputs(cryoGas.hotHighPressureGas.getFluid(1280))
                    .duration(20)
                    .EUt(8)
                    .buildAndRegister();

            FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                    .fluidInputs(cryoGas.hotHighPressureGas.getFluid(1280))
                    .fluidOutputs(cryoGas.normalGas.getFluid(1280))
                    .duration(cryoGas.duration)
                    .EUt(cryoGas.EUt)
                    .buildAndRegister();
        }

//Water cooling
        for (IRefrigerant refrigerant : refrigerants) {
            HEAT_EXCHANGER_RECIPES.recipeBuilder()
                    .fluidInputs(Water.getFluid(1000))
                    .fluidInputs(refrigerant.coldRefrigerant.getFluid(refrigerant.amountToUse))
                    .fluidOutputs(Ice.getFluid(1000))
                    .fluidOutputs(refrigerant.normalRefrigerant.getFluid(refrigerant.amountToUse))
                    .duration(60)
                    .buildAndRegister();
        }

        IFluidFuel NaphthaFuel = new IFluidFuel(Naphtha, FlueGas);
        NaphthaFuel.duration = 160;
        NaphthaFuel.amountToBurn = 10;
        NaphthaFuel.byproductAmount = 1000;

        IFluidFuel NaturalGasFuel = new IFluidFuel(NaturalGas, FlueGas);
        NaturalGasFuel.duration = 100;
        NaturalGasFuel.amountToBurn = 160;
        NaturalGasFuel.byproductAmount = 750;

        IFluidFuel MethaneFuel = new IFluidFuel(Methane, FlueGas);
        MethaneFuel.duration = 80;
        MethaneFuel.amountToBurn = 160;
        MethaneFuel.byproductAmount = 500;

        IFluidFuel EthaneFuel = new IFluidFuel(Ethane, FlueGas);
        EthaneFuel.duration = 85;
        EthaneFuel.amountToBurn = 160;
        EthaneFuel.byproductAmount = 500;

        IFluidFuel ButadieneFuel = new IFluidFuel(Butadiene, FlueGas);
        ButadieneFuel.duration = 100;
        ButadieneFuel.amountToBurn = 160;
        ButadieneFuel.byproductAmount = 600;

        IFluidFuel PropaneFuel = new IFluidFuel(Propane, FlueGas);
        PropaneFuel.duration = 90;
        PropaneFuel.amountToBurn = 160;
        PropaneFuel.byproductAmount = 500;

        IFluidFuel ButaneFuel = new IFluidFuel(Butane, FlueGas);
        ButaneFuel.duration = 95;
        ButaneFuel.amountToBurn = 160;
        ButaneFuel.byproductAmount = 500;

        IFluidFuel TolueneFuel = new IFluidFuel(Toluene, FlueGas);
        TolueneFuel.duration = 160;
        TolueneFuel.amountToBurn = 10;
        TolueneFuel.byproductAmount = 1000;

        IFluidFuel WoodGasFuel = new IFluidFuel(WoodGas, FlueGas);
        WoodGasFuel.duration = 80;
        WoodGasFuel.amountToBurn = 160;
        WoodGasFuel.byproductAmount = 750;

        IFluidFuel CoalGasFuel = new IFluidFuel(CoalGas, FlueGas);
        CoalGasFuel.duration = 90;
        CoalGasFuel.amountToBurn = 160;
        CoalGasFuel.byproductAmount = 750;

        IFluidFuel SyngasFuel = new IFluidFuel(Syngas, FlueGas);
        SyngasFuel.duration = 200;
        SyngasFuel.amountToBurn = 160;
        SyngasFuel.byproductAmount = 1500;

        IFluidFuel EthyleneFuel = new IFluidFuel(Ethylene, FlueGas);
        EthyleneFuel.duration = 85;
        EthyleneFuel.amountToBurn = 160;
        EthyleneFuel.byproductAmount = 500;

        IFluidFuel RefineryGasFuel = new IFluidFuel(RefineryGas, FlueGas);
        RefineryGasFuel.duration = 100;
        RefineryGasFuel.amountToBurn = 160;
        RefineryGasFuel.byproductAmount = 750;

        IFluidFuel AmmoniaFuel = new IFluidFuel(Ammonia, Nitrogen);
        AmmoniaFuel.duration = 70;
        AmmoniaFuel.amountToBurn = 160;
        AmmoniaFuel.byproductAmount = 500;

        IFluidFuel PropeneFuel = new IFluidFuel(Propene, FlueGas);
        PropeneFuel.duration = 85;
        PropeneFuel.amountToBurn = 160;
        PropeneFuel.byproductAmount = 500;

        IFluidFuel ButeneFuel = new IFluidFuel(Butene, FlueGas);
        ButeneFuel.duration = 90;
        ButeneFuel.amountToBurn = 160;
        ButeneFuel.byproductAmount = 500;

        IFluidFuel PhenolFuel = new IFluidFuel(Phenol, FlueGas);
        PhenolFuel.duration = 120;
        PhenolFuel.amountToBurn = 10;
        PhenolFuel.byproductAmount = 750;

        IFluidFuel BenzeneFuel = new IFluidFuel(Benzene, FlueGas);
        BenzeneFuel.duration = 120;
        BenzeneFuel.amountToBurn = 10;
        BenzeneFuel.byproductAmount = 750;

        IFluidFuel HydrogenFuel = new IFluidFuel(Hydrogen, Steam);
        HydrogenFuel.duration = 10;
        HydrogenFuel.amountToBurn = 160;
        HydrogenFuel.byproductAmount = 80;

        IFluidFuel MethanolFuel = new IFluidFuel(Methanol, FlueGas);
        MethanolFuel.duration = 40;
        MethanolFuel.amountToBurn = 10;
        MethanolFuel.byproductAmount = 1000;
        MethanolFuel.refinedFuel = true;

        IFluidFuel EthanolFuel = new IFluidFuel(Ethanol, FlueGas);
        EthanolFuel.duration = 48;
        EthanolFuel.amountToBurn = 10;
        EthanolFuel.byproductAmount = 1200;
        EthanolFuel.refinedFuel = true;

        IFluidFuel LiquidNaturalGasFuel = new IFluidFuel(LiquidNaturalGas, FlueGas);
        LiquidNaturalGasFuel.duration = 120;
        LiquidNaturalGasFuel.amountToBurn = 10;
        LiquidNaturalGasFuel.byproductAmount = 1250;
        LiquidNaturalGasFuel.refinedFuel = true;

        IFluidFuel FuelOilFuel = new IFluidFuel(FuelOil, FlueGas);
        FuelOilFuel.duration = 100;
        FuelOilFuel.amountToBurn = 10;
        FuelOilFuel.byproductAmount = 2000;
        FuelOilFuel.refinedFuel = true;

        IFluidFuel BioDieselFuel = new IFluidFuel(BioDiesel, FlueGas);
        BioDieselFuel.duration = 75;
        BioDieselFuel.amountToBurn = 10;
        BioDieselFuel.byproductAmount = 1500;
        BioDieselFuel.refinedFuel = true;

        IFluidFuel DieselFuel = new IFluidFuel(Diesel, FlueGas);
        DieselFuel.duration = 100;
        DieselFuel.amountToBurn = 10;
        DieselFuel.byproductAmount = 2000;
        DieselFuel.refinedFuel = true;

        IFluidFuel MidgradeDieselFuel = new IFluidFuel(MidgradeDiesel, FlueGas);
        MidgradeDieselFuel.duration = 150;
        MidgradeDieselFuel.amountToBurn = 10;
        MidgradeDieselFuel.byproductAmount = 3000;
        MidgradeDieselFuel.refinedFuel = true;

        IFluidFuel PremiumDieselFuel = new IFluidFuel(PremiumDiesel, FlueGas);
        PremiumDieselFuel.duration = 200;
        PremiumDieselFuel.amountToBurn = 10;
        PremiumDieselFuel.byproductAmount = 4000;
        PremiumDieselFuel.refinedFuel = true;

        IFluidFuel SupremeDieselFuel = new IFluidFuel(SupremeDiesel, FlueGas);
        SupremeDieselFuel.duration = 250;
        SupremeDieselFuel.amountToBurn = 10;
        SupremeDieselFuel.byproductAmount = 5000;
        SupremeDieselFuel.refinedFuel = true;

        IFluidFuel GasolineFuel = new IFluidFuel(Gasoline, FlueGas);
        GasolineFuel.duration = 100;
        GasolineFuel.amountToBurn = 10;
        GasolineFuel.byproductAmount = 2000;
        GasolineFuel.refinedFuel = true;

        IFluidFuel MidgradeGasolineFuel = new IFluidFuel(MidgradeGasoline, FlueGas);
        MidgradeGasolineFuel.duration = 150;
        MidgradeGasolineFuel.amountToBurn = 10;
        MidgradeGasolineFuel.byproductAmount = 3000;
        MidgradeGasolineFuel.refinedFuel = true;

        IFluidFuel PremiumGasolineFuel = new IFluidFuel(PremiumGasoline, FlueGas);
        PremiumGasolineFuel.duration = 200;
        PremiumGasolineFuel.amountToBurn = 10;
        PremiumGasolineFuel.byproductAmount = 4000;
        PremiumGasolineFuel.refinedFuel = true;

        IFluidFuel SupremeGasolineFuel = new IFluidFuel(SupremeGasoline, FlueGas);
        SupremeGasolineFuel.duration = 250;
        SupremeGasolineFuel.amountToBurn = 10;
        SupremeGasolineFuel.byproductAmount = 5000;
        SupremeGasolineFuel.refinedFuel = true;

        IFluidFuel KeroseneFuel = new IFluidFuel(Kerosene, FlueGas);
        KeroseneFuel.duration = 100;
        KeroseneFuel.amountToBurn = 10;
        KeroseneFuel.byproductAmount = 1000;
        KeroseneFuel.refinedFuel = true;

        IFluidFuel MidgradeKeroseneFuel = new IFluidFuel(MidgradeKerosene, FlueGas);
        MidgradeKeroseneFuel.duration = 150;
        MidgradeKeroseneFuel.amountToBurn = 10;
        MidgradeKeroseneFuel.byproductAmount = 3000;
        MidgradeKeroseneFuel.refinedFuel = true;

        IFluidFuel PremiumKeroseneFuel = new IFluidFuel(PremiumKerosene, FlueGas);
        PremiumKeroseneFuel.duration = 200;
        PremiumKeroseneFuel.amountToBurn = 10;
        PremiumKeroseneFuel.byproductAmount = 4000;
        PremiumKeroseneFuel.refinedFuel = true;

        IFluidFuel SupremeKeroseneFuel = new IFluidFuel(SupremeKerosene, FlueGas);
        SupremeKeroseneFuel.duration = 250;
        SupremeKeroseneFuel.amountToBurn = 10;
        SupremeKeroseneFuel.byproductAmount = 5000;
        SupremeKeroseneFuel.refinedFuel = true;

        IFluidFuel[] fluidFuels = {
                NaphthaFuel,
                NaturalGasFuel,
                MethaneFuel,
                EthaneFuel,
                ButadieneFuel,
                PropaneFuel,
                ButaneFuel,
                TolueneFuel,
                WoodGasFuel,
                CoalGasFuel,
                SyngasFuel,
                EthyleneFuel,
                RefineryGasFuel,
                AmmoniaFuel,
                PropeneFuel,
                ButeneFuel,
                PhenolFuel,
                BenzeneFuel,
                HydrogenFuel,
                MethanolFuel,
                EthanolFuel,
                LiquidNaturalGasFuel,
                FuelOilFuel,
                BioDieselFuel,
                DieselFuel,
                MidgradeDieselFuel,
                PremiumDieselFuel,
                SupremeDieselFuel,
                GasolineFuel,
                MidgradeGasolineFuel,
                PremiumGasolineFuel,
                SupremeGasolineFuel,
                KeroseneFuel,
                MidgradeKeroseneFuel,
                PremiumKeroseneFuel,
                SupremeKeroseneFuel
        };

        IWorkingFluid WaterWF = new IWorkingFluid(Water, Steam, ExhaustSteam);
        WaterWF.duration = 10;
        WaterWF.amountToUse = 6;
        WaterWF.efficiency = 1;
        WaterWF.conversionFactor = 160;

        IWorkingFluid[] workingFluids = {
                WaterWF
        };

        for (IFluidFuel fluidFuel : fluidFuels) {
            if (fluidFuel.gasTurbine) {
                if (fluidFuel.refinedFuel) {
                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquidFuel.getFluid(fluidFuel.amountToBurn))
                            .fluidInputs(Air.getFluid(100))
                            .fluidOutputs(fluidFuel.byproduct.getFluid(fluidFuel.byproductAmount))
                            .duration(fluidFuel.duration)
                            .EUt(128)
                            .buildAndRegister();

                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquidFuel.getFluid(fluidFuel.amountToBurn))
                            .fluidInputs(Oxygen.getFluid(20))
                            .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproductAmount * 1.5f)))
                            .duration((int) (fluidFuel.duration * 1.5))
                            .EUt(128)
                            .buildAndRegister();
                } else {
                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquidFuel.getFluid(fluidFuel.amountToBurn))
                            .fluidInputs(Air.getFluid(100))
                            .fluidOutputs(fluidFuel.byproduct.getFluid(fluidFuel.byproductAmount))
                            .duration(fluidFuel.duration)
                            .EUt(32)
                            .buildAndRegister();

                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquidFuel.getFluid(fluidFuel.amountToBurn))
                            .fluidInputs(Oxygen.getFluid(20))
                            .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproductAmount * 1.5f)))
                            .duration((int) (fluidFuel.duration * 1.5))
                            .EUt(32)
                            .buildAndRegister();
                }

                for (ILubricant lubricant : lubricants) {
                    if (fluidFuel.refinedFuel) {
                        GAS_TURBINE_FUELS.recipeBuilder()
                                .fluidInputs(lubricant.name.getFluid(lubricant.amountRequired))
                                .fluidInputs(fluidFuel.liquidFuel.getFluid(fluidFuel.amountToBurn))
                                .fluidInputs(Oxygen.getFluid(20))
                                .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproductAmount * 1.5f)))
                                .duration((int) (fluidFuel.duration * lubricant.boost * 1.5))
                                .EUt(128)
                                .buildAndRegister();
                    } else {
                        GAS_TURBINE_FUELS.recipeBuilder()
                                .fluidInputs(lubricant.name.getFluid(lubricant.amountRequired))
                                .fluidInputs(fluidFuel.liquidFuel.getFluid(fluidFuel.amountToBurn))
                                .fluidInputs(Oxygen.getFluid(20))
                                .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproductAmount * 1.5f)))
                                .duration((int) (fluidFuel.duration * lubricant.boost * 1.5))
                                .EUt(32)
                                .buildAndRegister();
                    }
                }
            }

            //THIS IS ONLY ADDED SO THAT IT IS A VALID JETPACK FUEL
            COMBUSTION_GENERATOR_FUELS.recipeBuilder()
                    .fluidInputs(fluidFuel.liquidFuel.getFluid(25))
                    .duration(100)
                    .EUt(1)
                    .buildAndRegister();
        }

        for (IWorkingFluid workingFluid : workingFluids) {
            HEAT_EXCHANGER_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.normalFluid.getFluid(workingFluid.amountToUse))
                    .fluidInputs(DesulfurizedFlueGas.getFluid(500))
                    .fluidOutputs(workingFluid.heatedFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                    .fluidOutputs(ChilledFlueGas.getFluid(500))
                    .duration((int) (workingFluid.duration * 0.75))
                    .buildAndRegister();

            HEAT_EXCHANGER_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.normalFluid.getFluid(workingFluid.amountToUse))
                    .fluidInputs(FlueGas.getFluid(500))
                    .fluidOutputs(workingFluid.heatedFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                    .fluidOutputs(ChilledFlueGas.getFluid(500))
                    .duration(workingFluid.duration)
                    .buildAndRegister();

            STEAM_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(workingFluid.heatedFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                    .fluidOutputs(workingFluid.leftoverFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                    .duration(workingFluid.duration * workingFluid.efficiency)
                    .EUt(32)
                    .buildAndRegister();

            LARGE_STEAM_TURBINE.recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(workingFluid.heatedFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                    .fluidOutputs(workingFluid.leftoverFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                    .duration(workingFluid.duration * workingFluid.efficiency)
                    .EUt(32)
                    .buildAndRegister();

            for (var lubricant : lubricants) {
                LARGE_STEAM_TURBINE.recipeBuilder()
                        .fluidInputs(lubricant.name.getFluid(lubricant.amountRequired))
                        .fluidInputs(workingFluid.heatedFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                        .fluidOutputs(workingFluid.leftoverFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor))
                        .duration((int) (workingFluid.duration * workingFluid.efficiency * lubricant.boost))
                        .EUt(32)
                        .buildAndRegister();
            }

            COOLING_TOWER_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.leftoverFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor * 64))
                    .fluidInputs(Water.getFluid(1000))
                    .fluidOutputs(workingFluid.normalFluid.getFluid(workingFluid.amountToUse * 64))
                    .fluidOutputs(Water.getFluid(750))
                    .duration(workingFluid.duration)
                    .EUt(8)
                    .buildAndRegister();

            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.leftoverFluid.getFluid(workingFluid.amountToUse * workingFluid.conversionFactor * 16))
                    .fluidOutputs(workingFluid.normalFluid.getFluid(workingFluid.amountToUse * 16))
                    .duration(workingFluid.duration)
                    .EUt(8)
                    .buildAndRegister();
        }

        FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                .fluidInputs(Benzene.getFluid(1280))
                .fluidOutputs(HotHighPressureBenzene.getFluid(1280))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                .fluidInputs(Propene.getFluid(1280))
                .fluidOutputs(HotHighPressurePropene.getFluid(1280))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(HotHighPressureSteam.getFluid(400))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(96))
                .fluidInputs(Lava.getFluid(3))
                .fluidOutputs(Steam.getFluid(15360))
                .fluidOutputs(ChilledLava.getFluid(3))
                .duration(10)
                .buildAndRegister();
    }
}
