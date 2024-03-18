package supersymmetry.loaders.recipes.misc;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.Material;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Thermodynamics {
    private static class ICoolant{

        public Material cold_coolant;
        public Material warm_coolant;

        public int duration_radiator = 200;
        public int amount_to_use = 1000;
        public int hx_time_factor = 10;

        public ICoolant(Material coolant_normal, Material coolant_warm){
            this.cold_coolant = coolant_normal;
            this.warm_coolant = coolant_warm;
        }

        public void setDurationRadiator(int time) {
            this.duration_radiator = time;
        }

        public void setAmountToUse(int amount) {
            this.amount_to_use = amount;
        }

        public void setTimeFactor(int time) {
            this.hx_time_factor = time;
        }
    }
    private static class ICryoGas{

        public Material normal_gas;
        public Material hot_high_pressure_gas;
        public Material high_pressure_gas;
        public Material cold_high_pressure_gas;
        public Material liquid_gas;

        public int amount_to_use = 20000;

        public int EUt = 30;
        public int duration = 20;

        public int power_heat_exchanger = 20;
        public int duration_heat_exchanger = 10;

        public int duration_radiator = 100;

        public int fluid_temperature = 300;

        public ICryoGas(Material gas_normal, Material gas_hot_hp, Material gas_hp, Material gas_cold_hp, Material gas_liquid) {
            normal_gas = gas_normal;
            hot_high_pressure_gas = gas_hot_hp;
            high_pressure_gas = gas_hp;
            cold_high_pressure_gas = gas_cold_hp;
            liquid_gas = gas_liquid;
        }

        public void setEUt(int power) {
            EUt = power;
        }

        public void setDuration(int time) {
            duration = time;
        }

        public void setPowerHX(int power_hx) {
            power_heat_exchanger = power_hx;
        }

        public void setDurationHX(int duration_hx) {
            duration_heat_exchanger = duration_hx;
        }

        public void setDurationRadiator(int duration_rad) {
            duration_radiator = duration_rad;
        }

        public void setTemperature(int temp){
            this.fluid_temperature = temp;
        }
    }
    private static class IRefrigerant{

        Material normal_refrigerant;
        Material hot_refrigerant;
        Material comp_refrigerant;
        Material cold_refrigerant;

        int EUt = 30;
        int duration = 20;

        int duration_radiator = 20;
        int amount_to_use = 1000;

        int hx_time_factor = 10;

        public IRefrigerant(Material refrigerant_normal, Material refrigerant_hot, Material refrigerant_comp, Material refrigerant_cold) {
            normal_refrigerant = refrigerant_normal;
            hot_refrigerant = refrigerant_hot;
            comp_refrigerant = refrigerant_comp;
            cold_refrigerant = refrigerant_cold;
        }

        public void setPowerToCompress(int power) {
            EUt = power;
        }

        public void setDurationToCompress(int time) {
            duration = time;
        }

        public void setDurationRadiator(int time) {
            duration_radiator = time;
        }

        public void setAmountToUse(int amount) {
            amount_to_use = amount;
        }

        public void setTimeFactor(int time) {
            hx_time_factor = time;
        }
    }
    private static class IFluidFuel{

        public Material liquid_fuel;
        public Material byproduct;

        public int duration;
        public int amount_to_burn;

        public int byproduct_amount = 1000;

        public boolean refined_fuel = false;
        public boolean gas_turbine = true;

        public IFluidFuel(Material fuel_liquid, Material byproduct_liquid) {
            this.liquid_fuel = fuel_liquid;
            this.byproduct = byproduct_liquid;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setAmountToBurn(int amount_to_burn) {
            this.amount_to_burn = amount_to_burn;
        }

        public void setByproductAmount(int byproduct_amount) {
            this.byproduct_amount = byproduct_amount;
        }

        public void setIsRefinedFuel(boolean b) {
            this.refined_fuel = b;
        }
    }
    private static class IWorkingFluid{
        public Material normal_fluid;
        public Material heated_fluid;
        public Material leftover_fluid;

        public int duration;
        public int amount_to_use;

        public int conversion_factor = 160;

        public int efficiency = 1;

        public IWorkingFluid(Material fluid_normal, Material fluid_heated, Material fluid_leftover) {
            this.normal_fluid = fluid_normal;
            this.heated_fluid = fluid_heated;
            this.leftover_fluid = fluid_leftover;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public void setAmountToUse(int amount_to_use) {
            this.amount_to_use = amount_to_use;
        }

        public void setEfficiency(int efficiency) {
            this.efficiency = efficiency;
        }

        public void setConversionFactor(int conversion_factor) {
            this.conversion_factor = conversion_factor;
        }
    }


    public static class ILubricant {
        public Material name;
        public int amount_required;
        public double boost;
        public ILubricant(Material name, int amount_required, double boost) {
            this.name = name;
            this.amount_required = amount_required;
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
        WaterCoolant.setDurationRadiator(100);
        WaterCoolant.setAmountToUse(1000);
        WaterCoolant.setTimeFactor(10);

        ICoolant SaltWaterCoolant = new ICoolant(SaltWater, WarmSaltWater);
        SaltWaterCoolant.setDurationRadiator(100);
        SaltWaterCoolant.setAmountToUse(1000);
        SaltWaterCoolant.setTimeFactor(15);

        ICoolant BrineCoolant = new ICoolant(Brine, WarmBrine);
        BrineCoolant.setDurationRadiator(100);
        BrineCoolant.setAmountToUse(1000);
        BrineCoolant.setTimeFactor(15);

        ICoolant LubricantCoolant = new ICoolant(Lubricant, WarmLubricant);
        LubricantCoolant.setDurationRadiator(75);
        LubricantCoolant.setAmountToUse(1000);
        LubricantCoolant.setTimeFactor(6);

        ICoolant SodiumPotassiumCoolant = new ICoolant(SodiumPotassium, WarmSodiumPotassium);
        SodiumPotassiumCoolant.setDurationRadiator(60);
        SodiumPotassiumCoolant.setAmountToUse(2000);
        SodiumPotassiumCoolant.setTimeFactor(5);

        ICoolant EthyleneGlycolCoolant = new ICoolant(EthyleneGlycol, WarmEthyleneGlycol);
        EthyleneGlycolCoolant.setDurationRadiator(50);
        EthyleneGlycolCoolant.setAmountToUse(2000);
        EthyleneGlycolCoolant.setTimeFactor(4);

        ICoolant PolychlorinatedBiphenylCoolant = new ICoolant(PolychlorinatedBiphenyl, WarmPolychlorinatedBiphenyl);
        PolychlorinatedBiphenylCoolant.setDurationRadiator(40);
        PolychlorinatedBiphenylCoolant.setAmountToUse(1000);
        PolychlorinatedBiphenylCoolant.setTimeFactor(2);

        ICoolant[] coolants = {
                WaterCoolant,
                SaltWaterCoolant,
                BrineCoolant,
                LubricantCoolant,
                SodiumPotassiumCoolant,
                EthyleneGlycolCoolant,
                PolychlorinatedBiphenylCoolant
        };

        ICryoGas CryoHydrogen = new ICryoGas(Hydrogen, HotHighPressureHydrogen, HighPressureHydrogen, ColdHighPressureHydrogen, LiquidHydrogen);
        CryoHydrogen.setEUt(240);
        CryoHydrogen.setDuration(100);
        CryoHydrogen.setPowerHX(100);
        CryoHydrogen.setDurationHX(5);
        CryoHydrogen.setDurationRadiator(400);
        CryoHydrogen.setTemperature(14);

        ICryoGas CryoOxygen = new ICryoGas(Oxygen, HotHighPressureOxygen, HighPressureOxygen, ColdHighPressureOxygen, ColdLiquidOxygen);
        CryoOxygen.setEUt(30);
        CryoOxygen.setDuration(100);
        CryoOxygen.setPowerHX(100);
        CryoOxygen.setDurationHX(5);
        CryoOxygen.setDurationRadiator(400);
        CryoOxygen.setTemperature(90);

        ICryoGas CryoHelium = new ICryoGas(Helium, HotHighPressureHelium, HighPressureHelium, ColdHighPressureHelium, Helium);
        CryoHelium.setEUt(720);
        CryoHelium.setDuration(100);
        CryoHelium.setPowerHX(100);
        CryoHelium.setDurationHX(5);
        CryoHelium.setDurationRadiator(400);
        CryoHelium.setTemperature(4);

        ICryoGas CryoNeon = new ICryoGas(Neon, HotHighPressureNeon, HighPressureNeon, ColdHighPressureNeon, LiquidNeon);
        CryoNeon.setEUt(240);
        CryoNeon.setDuration(100);
        CryoNeon.setPowerHX(100);
        CryoNeon.setDurationHX(5);
        CryoNeon.setDurationRadiator(400);
        CryoNeon.setTemperature(27);

        ICryoGas CryoArgon = new ICryoGas(Argon, HotHighPressureArgon, HighPressureArgon, ColdHighPressureArgon, LiquidArgon);
        CryoArgon.setEUt(120);
        CryoArgon.setDuration(100);
        CryoArgon.setPowerHX(100);
        CryoArgon.setDurationHX(5);
        CryoArgon.setDurationRadiator(400);
        CryoArgon.setTemperature(87);

        ICryoGas CryoKrypton = new ICryoGas(Krypton, HotHighPressureKrypton, HighPressureKrypton, ColdHighPressureKrypton, LiquidKrypton);
        CryoKrypton.setEUt(120);
        CryoKrypton.setDuration(100);
        CryoKrypton.setPowerHX(100);
        CryoKrypton.setDurationHX(5);
        CryoKrypton.setDurationRadiator(400);
        CryoKrypton.setTemperature(120);

        ICryoGas CryoXenon = new ICryoGas(Xenon, HotHighPressureXenon, HighPressureXenon, ColdHighPressureXenon, LiquidXenon);
        CryoXenon.setEUt(120);
        CryoXenon.setDuration(100);
        CryoXenon.setPowerHX(100);
        CryoXenon.setDurationHX(5);
        CryoXenon.setDurationRadiator(400);
        CryoXenon.setTemperature(165);

        ICryoGas CryoAir = new ICryoGas(Air, HotHighPressureAir, HighPressureAir, ColdHighPressureAir, LiquidAir);
        CryoAir.setEUt(60);
        CryoAir.setDuration(100);
        CryoAir.setPowerHX(100);
        CryoAir.setDurationHX(5);
        CryoAir.setDurationRadiator(400);
        CryoAir.setTemperature(80);

        ICryoGas CryoDecarburizedAir = new ICryoGas(DecarburizedAir, HotHighPressureDecarburizedAir, HighPressureDecarburizedAir, ColdHighPressureDecarburizedAir, LiquidDecarburizedAir);
        CryoDecarburizedAir.setEUt(60);
        CryoDecarburizedAir.setDuration(1);
        CryoDecarburizedAir.setPowerHX(100);
        CryoDecarburizedAir.setDurationHX(8);
        CryoDecarburizedAir.setDurationRadiator(40);
        CryoDecarburizedAir.setTemperature(80);

        ICryoGas CryoNitrogen = new ICryoGas(Nitrogen, HotHighPressureNitrogen, HighPressureNitrogen, ColdHighPressureNitrogen, LiquidNitrogen);
        CryoNitrogen.setEUt(60);
        CryoNitrogen.setDuration(100);
        CryoNitrogen.setPowerHX(100);
        CryoNitrogen.setDurationHX(5);
        CryoNitrogen.setDurationRadiator(400);
        CryoNitrogen.setTemperature(77);

        ICryoGas CryoNetherAir = new ICryoGas(NetherAir, HotHighPressureNetherAir, HighPressureNetherAir, ColdHighPressureNetherAir, LiquidNetherAir);
        CryoNetherAir.setEUt(60);
        CryoNetherAir.setDuration(100);
        CryoNetherAir.setPowerHX(100);
        CryoNetherAir.setDurationHX(5);
        CryoNetherAir.setDurationRadiator(400);
        CryoNetherAir.setTemperature(80);

        ICryoGas CryoRefineryGas = new ICryoGas(RefineryGas, HotHighPressureRefineryGas, HighPressureRefineryGas, ColdHighPressureRefineryGas, LiquidRefineryGas);
        CryoRefineryGas.setEUt(60);
        CryoRefineryGas.setDuration(100);
        CryoRefineryGas.setPowerHX(100);
        CryoRefineryGas.setDurationHX(5);
        CryoRefineryGas.setDurationRadiator(400);
        CryoRefineryGas.setTemperature(80);

        ICryoGas CryoNaturalGas = new ICryoGas(NaturalGas, HotHighPressureNaturalGas, HighPressureNaturalGas, ColdHighPressureNaturalGas, LiquidNaturalGas);
        CryoNaturalGas.setEUt(60);
        CryoNaturalGas.setDuration(100);
        CryoNaturalGas.setPowerHX(100);
        CryoNaturalGas.setDurationHX(5);
        CryoNaturalGas.setDurationRadiator(400);
        CryoNaturalGas.setTemperature(80);

        ICryoGas CryoMethane = new ICryoGas(Methane, HotHighPressureMethane, HighPressureMethane, ColdHighPressureMethane, LiquidMethane);
        CryoMethane.setEUt(60);
        CryoMethane.setDuration(100);
        CryoMethane.setPowerHX(100);
        CryoMethane.setDurationHX(5);
        CryoMethane.setDurationRadiator(400);
        CryoMethane.setTemperature(80);

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

        IRefrigerant AmmoniaRefrigerant = new IRefrigerant(Ammonia, HotCompressedAmmonia, CompressedAmmonia, ColdAmmonia);
        AmmoniaRefrigerant.setPowerToCompress(120);
        AmmoniaRefrigerant.setDurationToCompress(20);
        AmmoniaRefrigerant.setDurationRadiator(20);
        AmmoniaRefrigerant.setAmountToUse(1000);
        AmmoniaRefrigerant.setTimeFactor(10);

        IRefrigerant PropaneRefrigerant = new IRefrigerant(Propane, HotCompressedPropane, CompressedPropane, ColdPropane);
        PropaneRefrigerant.setPowerToCompress(60);
        PropaneRefrigerant.setDurationToCompress(30);
        PropaneRefrigerant.setDurationRadiator(10);
        PropaneRefrigerant.setAmountToUse(2000);
        PropaneRefrigerant.setTimeFactor(15);

        IRefrigerant CarbonDioxideRefrigerant = new IRefrigerant(CarbonDioxide, HotCompressedCarbonDioxide, CompressedCarbonDioxide, ColdCarbonDioxide);
        CarbonDioxideRefrigerant.setPowerToCompress(30);
        CarbonDioxideRefrigerant.setDurationToCompress(60);
        CarbonDioxideRefrigerant.setDurationRadiator(10);
        CarbonDioxideRefrigerant.setAmountToUse(3000);
        CarbonDioxideRefrigerant.setTimeFactor(20);

        IRefrigerant TrichlorofluoromethaneRefrigerant = new IRefrigerant(Trichlorofluoromethane, HotCompressedTrichlorofluoromethane, CompressedTrichlorofluoromethane, ColdTrichlorofluoromethane);
        TrichlorofluoromethaneRefrigerant.setPowerToCompress(180);
        TrichlorofluoromethaneRefrigerant.setDurationToCompress(4);
        TrichlorofluoromethaneRefrigerant.setDurationRadiator(2);
        TrichlorofluoromethaneRefrigerant.setAmountToUse(1000);
        TrichlorofluoromethaneRefrigerant.setTimeFactor(2);

        IRefrigerant DichlorodifluoromethaneRefrigerant = new IRefrigerant(Dichlorodifluoromethane, HotCompressedDichlorodifluoromethane, CompressedDichlorodifluoromethane, ColdDichlorodifluoromethane);
        DichlorodifluoromethaneRefrigerant.setPowerToCompress(180);
        DichlorodifluoromethaneRefrigerant.setDurationToCompress(4);
        DichlorodifluoromethaneRefrigerant.setDurationRadiator(2);
        DichlorodifluoromethaneRefrigerant.setAmountToUse(1000);
        DichlorodifluoromethaneRefrigerant.setTimeFactor(2);

        IRefrigerant ChlorotrifluoromethaneRefrigerant = new IRefrigerant(Chlorotrifluoromethane, HotCompressedChlorotrifluoromethane, CompressedChlorotrifluoromethane, ColdChlorotrifluoromethane);
        ChlorotrifluoromethaneRefrigerant.setPowerToCompress(180);
        ChlorotrifluoromethaneRefrigerant.setDurationToCompress(4);
        ChlorotrifluoromethaneRefrigerant.setDurationRadiator(2);
        ChlorotrifluoromethaneRefrigerant.setAmountToUse(1000);
        ChlorotrifluoromethaneRefrigerant.setTimeFactor(2);

        IRefrigerant ChlorodifluoromethaneRefrigerant = new IRefrigerant(Chlorodifluoromethane, HotCompressedChlorodifluoromethane, CompressedChlorodifluoromethane, ColdChlorodifluoromethane);
        ChlorodifluoromethaneRefrigerant.setPowerToCompress(180);
        ChlorodifluoromethaneRefrigerant.setDurationToCompress(4);
        ChlorodifluoromethaneRefrigerant.setDurationRadiator(2);
        ChlorodifluoromethaneRefrigerant.setAmountToUse(1000);
        ChlorodifluoromethaneRefrigerant.setTimeFactor(2);

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
                    .fluidInputs(refrigerant.normal_refrigerant.getFluid(refrigerant.amount_to_use))
                    .fluidOutputs(refrigerant.hot_refrigerant.getFluid(refrigerant.amount_to_use))
                    .EUt(refrigerant.EUt)
                    .duration(refrigerant.duration)
                    .buildAndRegister();

            //Decompression
            FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.comp_refrigerant.getFluid(refrigerant.amount_to_use))
                    .fluidOutputs(refrigerant.cold_refrigerant.getFluid(refrigerant.amount_to_use))
                    .EUt(8)
                    .duration(refrigerant.duration)
                    .buildAndRegister();

            //Radiative Cooling
            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.hot_refrigerant.getFluid(refrigerant.amount_to_use))
                    .fluidOutputs(refrigerant.comp_refrigerant.getFluid(refrigerant.amount_to_use))
                    .duration(refrigerant.duration_radiator)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.hot_refrigerant.getFluid(refrigerant.amount_to_use))
                    .fluidOutputs(refrigerant.comp_refrigerant.getFluid(refrigerant.amount_to_use))
                    .duration(refrigerant.duration_radiator / 2)
                    .EUt(480)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(refrigerant.comp_refrigerant.getFluid(refrigerant.amount_to_use))
                    .fluidOutputs(refrigerant.cold_refrigerant.getFluid(refrigerant.amount_to_use))
                    .duration(refrigerant.duration_radiator / 2)
                    .EUt(480)
                    .buildAndRegister();
        }

//Coolant recipes generation
        for (ICoolant coolant : coolants) {
            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(coolant.warm_coolant.getFluid(coolant.amount_to_use))
                    .fluidOutputs(coolant.cold_coolant.getFluid(coolant.amount_to_use))
                    .duration(coolant.duration_radiator)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(coolant.warm_coolant.getFluid(coolant.amount_to_use))
                    .fluidOutputs(coolant.cold_coolant.getFluid(coolant.amount_to_use))
                    .duration(coolant.duration_radiator / 2)
                    .EUt(480)
                    .buildAndRegister();
        }

//Heat exchanger recipes generation
        for (ICryoGas cryogas : cryoGases) {
            for (ICoolant coolant : coolants) {
                HEAT_EXCHANGER_RECIPES.recipeBuilder()
                        .fluidInputs(cryogas.hot_high_pressure_gas.getFluid(cryogas.amount_to_use))
                        .fluidInputs(coolant.cold_coolant.getFluid(coolant.amount_to_use))
                        .fluidOutputs(coolant.warm_coolant.getFluid(coolant.amount_to_use))
                        .fluidOutputs(cryogas.high_pressure_gas.getFluid(cryogas.amount_to_use))
                        .duration(cryogas.duration_heat_exchanger + coolant.hx_time_factor)
                        .buildAndRegister();
            }
            for (IRefrigerant refrigerant : refrigerants) {
                HEAT_EXCHANGER_RECIPES.recipeBuilder()
                        .fluidInputs(cryogas.high_pressure_gas.getFluid(cryogas.amount_to_use))
                        .fluidInputs(refrigerant.cold_refrigerant.getFluid(refrigerant.amount_to_use))
                        .fluidOutputs(refrigerant.normal_refrigerant.getFluid(refrigerant.amount_to_use))
                        .fluidOutputs(cryogas.cold_high_pressure_gas.getFluid(cryogas.amount_to_use))
                        .duration(cryogas.duration_heat_exchanger + refrigerant.hx_time_factor)
                        .buildAndRegister();
            }

            FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                    .fluidInputs(cryogas.normal_gas.getFluid(1280))
                    .fluidOutputs(cryogas.hot_high_pressure_gas.getFluid(1280))
                    .duration(cryogas.duration)
                    .EUt(cryogas.EUt)
                    .buildAndRegister();

            //Decompression
            if (cryogas.liquid_gas == cryogas.normal_gas) {
                FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                        .fluidInputs(cryogas.cold_high_pressure_gas.getFluid(1280))
                        .fluidOutputs(cryogas.normal_gas.getFluid(FluidStorageKeys.LIQUID, 20))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();

                //Reheating
                FLUID_HEATER_RECIPES.recipeBuilder()
                        .fluidInputs(cryogas.normal_gas.getFluid(FluidStorageKeys.LIQUID, 20))
                        .fluidOutputs(cryogas.cold_high_pressure_gas.getFluid(1280))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();
            } else {
                FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                        .fluidInputs(cryogas.cold_high_pressure_gas.getFluid(1280))
                        .fluidOutputs(cryogas.liquid_gas.getFluid(20))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();

                //Reheating
                FLUID_HEATER_RECIPES.recipeBuilder()
                        .fluidInputs(cryogas.liquid_gas.getFluid(20))
                        .fluidOutputs(cryogas.cold_high_pressure_gas.getFluid(1280))
                        .duration(20)
                        .EUt(8)
                        .buildAndRegister();
            }

            //Radiative Cooling
            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(cryogas.hot_high_pressure_gas.getFluid(cryogas.amount_to_use))
                    .fluidOutputs(cryogas.high_pressure_gas.getFluid(cryogas.amount_to_use))
                    .duration(cryogas.duration_heat_exchanger * 5)
                    .buildAndRegister();

            COOLING_UNIT_RECIPES.recipeBuilder()
                    .fluidInputs(cryogas.hot_high_pressure_gas.getFluid(cryogas.amount_to_use))
                    .fluidOutputs(cryogas.high_pressure_gas.getFluid(cryogas.amount_to_use))
                    .duration(cryogas.duration_heat_exchanger * 2)
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
                    .fluidInputs(cryogas.cold_high_pressure_gas.getFluid(1280))
                    .fluidOutputs(cryogas.high_pressure_gas.getFluid(1280))
                    .duration(20)
                    .EUt(8)
                    .buildAndRegister();

            FLUID_HEATER_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .fluidInputs(cryogas.cold_high_pressure_gas.getFluid(1280))
                    .fluidOutputs(cryogas.hot_high_pressure_gas.getFluid(1280))
                    .duration(40)
                    .EUt(8)
                    .buildAndRegister();

            FLUID_HEATER_RECIPES.recipeBuilder()
                    .fluidInputs(cryogas.high_pressure_gas.getFluid(1280))
                    .fluidOutputs(cryogas.hot_high_pressure_gas.getFluid(1280))
                    .duration(20)
                    .EUt(8)
                    .buildAndRegister();

            FLUID_DECOMPRESSOR_RECIPES.recipeBuilder()
                    .fluidInputs(cryogas.hot_high_pressure_gas.getFluid(1280))
                    .fluidOutputs(cryogas.normal_gas.getFluid(1280))
                    .duration(cryogas.duration)
                    .EUt(cryogas.EUt)
                    .buildAndRegister();
        }

//Water cooling
        for (IRefrigerant refrigerant : refrigerants) {
            HEAT_EXCHANGER_RECIPES.recipeBuilder()
                    .fluidInputs(Water.getFluid(1000))
                    .fluidInputs(refrigerant.cold_refrigerant.getFluid(refrigerant.amount_to_use))
                    .fluidOutputs(Ice.getFluid(1000))
                    .fluidOutputs(refrigerant.normal_refrigerant.getFluid(refrigerant.amount_to_use))
                    .duration(60)
                    .buildAndRegister();
        }

        IFluidFuel NaphthaFuel = new IFluidFuel(Naphtha, FlueGas);
        NaphthaFuel.setDuration(160);
        NaphthaFuel.setAmountToBurn(10);
        NaphthaFuel.setByproductAmount(1000);

        IFluidFuel NaturalGasFuel = new IFluidFuel(NaturalGas, FlueGas);
        NaturalGasFuel.setDuration(100);
        NaturalGasFuel.setAmountToBurn(160);
        NaturalGasFuel.setByproductAmount(750);

        IFluidFuel MethaneFuel = new IFluidFuel(Methane, FlueGas);
        MethaneFuel.setDuration(80);
        MethaneFuel.setAmountToBurn(160);
        MethaneFuel.setByproductAmount(500);

        IFluidFuel EthaneFuel = new IFluidFuel(Ethane, FlueGas);
        EthaneFuel.setDuration(85);
        EthaneFuel.setAmountToBurn(160);
        EthaneFuel.setByproductAmount(500);

        IFluidFuel ButadieneFuel = new IFluidFuel(Butadiene, FlueGas);
        ButadieneFuel.setDuration(100);
        ButadieneFuel.setAmountToBurn(160);
        ButadieneFuel.setByproductAmount(600);

        IFluidFuel PropaneFuel = new IFluidFuel(Propane, FlueGas);
        PropaneFuel.setDuration(90);
        PropaneFuel.setAmountToBurn(160);
        PropaneFuel.setByproductAmount(500);

        IFluidFuel ButaneFuel = new IFluidFuel(Butane, FlueGas);
        ButaneFuel.setDuration(95);
        ButaneFuel.setAmountToBurn(160);
        ButaneFuel.setByproductAmount(500);

        IFluidFuel TolueneFuel = new IFluidFuel(Toluene, FlueGas);
        TolueneFuel.setDuration(160);
        TolueneFuel.setAmountToBurn(10);
        TolueneFuel.setByproductAmount(1000);

        IFluidFuel WoodGasFuel = new IFluidFuel(WoodGas, FlueGas);
        WoodGasFuel.setDuration(80);
        WoodGasFuel.setAmountToBurn(160);
        WoodGasFuel.setByproductAmount(750);

        IFluidFuel CoalGasFuel = new IFluidFuel(CoalGas, FlueGas);
        CoalGasFuel.setDuration(90);
        CoalGasFuel.setAmountToBurn(160);
        CoalGasFuel.setByproductAmount(750);

        IFluidFuel SyngasFuel = new IFluidFuel(Syngas, FlueGas);
        SyngasFuel.setDuration(200);
        SyngasFuel.setAmountToBurn(160);
        SyngasFuel.setByproductAmount(1500);

        IFluidFuel EthyleneFuel = new IFluidFuel(Ethylene, FlueGas);
        EthyleneFuel.setDuration(85);
        EthyleneFuel.setAmountToBurn(160);
        EthyleneFuel.setByproductAmount(500);

        IFluidFuel RefineryGasFuel = new IFluidFuel(RefineryGas, FlueGas);
        RefineryGasFuel.setDuration(100);
        RefineryGasFuel.setAmountToBurn(160);
        RefineryGasFuel.setByproductAmount(750);

        IFluidFuel AmmoniaFuel = new IFluidFuel(Ammonia, Nitrogen);
        AmmoniaFuel.setDuration(70);
        AmmoniaFuel.setAmountToBurn(160);
        AmmoniaFuel.setByproductAmount(500);

        IFluidFuel PropeneFuel = new IFluidFuel(Propene, FlueGas);
        PropeneFuel.setDuration(85);
        PropeneFuel.setAmountToBurn(160);
        PropeneFuel.setByproductAmount(500);

        IFluidFuel ButeneFuel = new IFluidFuel(Butene, FlueGas);
        ButeneFuel.setDuration(90);
        ButeneFuel.setAmountToBurn(160);
        ButeneFuel.setByproductAmount(500);

        IFluidFuel PhenolFuel = new IFluidFuel(Phenol, FlueGas);
        PhenolFuel.setDuration(120);
        PhenolFuel.setAmountToBurn(10);
        PhenolFuel.setByproductAmount(750);

        IFluidFuel BenzeneFuel = new IFluidFuel(Benzene, FlueGas);
        BenzeneFuel.setDuration(120);
        BenzeneFuel.setAmountToBurn(10);
        BenzeneFuel.setByproductAmount(750);

        IFluidFuel HydrogenFuel = new IFluidFuel(Hydrogen, Steam);
        HydrogenFuel.setDuration(10);
        HydrogenFuel.setAmountToBurn(160);
        HydrogenFuel.setByproductAmount(80);

        IFluidFuel MethanolFuel = new IFluidFuel(Methanol, FlueGas);
        MethanolFuel.setDuration(40);
        MethanolFuel.setAmountToBurn(10);
        MethanolFuel.setByproductAmount(1000);
        MethanolFuel.setIsRefinedFuel(true);

        IFluidFuel EthanolFuel = new IFluidFuel(Ethanol, FlueGas);
        EthanolFuel.setDuration(48);
        EthanolFuel.setAmountToBurn(10);
        EthanolFuel.setByproductAmount(1200);
        EthanolFuel.setIsRefinedFuel(true);

        IFluidFuel LiquidNaturalGasFuel = new IFluidFuel(LiquidNaturalGas, FlueGas);
        LiquidNaturalGasFuel.setDuration(120);
        LiquidNaturalGasFuel.setAmountToBurn(10);
        LiquidNaturalGasFuel.setByproductAmount(1250);
        LiquidNaturalGasFuel.setIsRefinedFuel(true);

        IFluidFuel FuelOilFuel = new IFluidFuel(FuelOil, FlueGas);
        FuelOilFuel.setDuration(100);
        FuelOilFuel.setAmountToBurn(10);
        FuelOilFuel.setByproductAmount(2000);
        FuelOilFuel.setIsRefinedFuel(true);

        IFluidFuel BioDieselFuel = new IFluidFuel(BioDiesel, FlueGas);
        BioDieselFuel.setDuration(75);
        BioDieselFuel.setAmountToBurn(10);
        BioDieselFuel.setByproductAmount(1500);
        BioDieselFuel.setIsRefinedFuel(true);

        IFluidFuel DieselFuel = new IFluidFuel(Diesel, FlueGas);
        DieselFuel.setDuration(100);
        DieselFuel.setAmountToBurn(10);
        DieselFuel.setByproductAmount(2000);
        DieselFuel.setIsRefinedFuel(true);

        IFluidFuel MidgradeDieselFuel = new IFluidFuel(MidgradeDiesel, FlueGas);
        MidgradeDieselFuel.setDuration(150);
        MidgradeDieselFuel.setAmountToBurn(10);
        MidgradeDieselFuel.setByproductAmount(3000);
        MidgradeDieselFuel.setIsRefinedFuel(true);

        IFluidFuel PremiumDieselFuel = new IFluidFuel(PremiumDiesel, FlueGas);
        PremiumDieselFuel.setDuration(200);
        PremiumDieselFuel.setAmountToBurn(10);
        PremiumDieselFuel.setByproductAmount(4000);
        PremiumDieselFuel.setIsRefinedFuel(true);

        IFluidFuel SupremeDieselFuel = new IFluidFuel(SupremeDiesel, FlueGas);
        SupremeDieselFuel.setDuration(250);
        SupremeDieselFuel.setAmountToBurn(10);
        SupremeDieselFuel.setByproductAmount(5000);
        SupremeDieselFuel.setIsRefinedFuel(true);

        IFluidFuel GasolineFuel = new IFluidFuel(Gasoline, FlueGas);
        GasolineFuel.setDuration(100);
        GasolineFuel.setAmountToBurn(10);
        GasolineFuel.setByproductAmount(2000);
        GasolineFuel.setIsRefinedFuel(true);

        IFluidFuel MidgradeGasolineFuel = new IFluidFuel(MidgradeGasoline, FlueGas);
        MidgradeGasolineFuel.setDuration(150);
        MidgradeGasolineFuel.setAmountToBurn(10);
        MidgradeGasolineFuel.setByproductAmount(3000);
        MidgradeGasolineFuel.setIsRefinedFuel(true);

        IFluidFuel PremiumGasolineFuel = new IFluidFuel(PremiumGasoline, FlueGas);
        PremiumGasolineFuel.setDuration(200);
        PremiumGasolineFuel.setAmountToBurn(10);
        PremiumGasolineFuel.setByproductAmount(4000);
        PremiumGasolineFuel.setIsRefinedFuel(true);

        IFluidFuel SupremeGasolineFuel = new IFluidFuel(SupremeGasoline, FlueGas);
        SupremeGasolineFuel.setDuration(250);
        SupremeGasolineFuel.setAmountToBurn(10);
        SupremeGasolineFuel.setByproductAmount(5000);
        SupremeGasolineFuel.setIsRefinedFuel(true);

        IFluidFuel KeroseneFuel = new IFluidFuel(Kerosene, FlueGas);
        KeroseneFuel.setDuration(100);
        KeroseneFuel.setAmountToBurn(10);
        KeroseneFuel.setByproductAmount(1000);
        KeroseneFuel.setIsRefinedFuel(true);

        IFluidFuel MidgradeKeroseneFuel = new IFluidFuel(MidgradeKerosene, FlueGas);
        MidgradeKeroseneFuel.setDuration(150);
        MidgradeKeroseneFuel.setAmountToBurn(10);
        MidgradeKeroseneFuel.setByproductAmount(3000);
        MidgradeKeroseneFuel.setIsRefinedFuel(true);

        IFluidFuel PremiumKeroseneFuel = new IFluidFuel(PremiumKerosene, FlueGas);
        PremiumKeroseneFuel.setDuration(200);
        PremiumKeroseneFuel.setAmountToBurn(10);
        PremiumKeroseneFuel.setByproductAmount(4000);
        PremiumKeroseneFuel.setIsRefinedFuel(true);

        IFluidFuel SupremeKeroseneFuel = new IFluidFuel(SupremeKerosene, FlueGas);
        SupremeKeroseneFuel.setDuration(250);
        SupremeKeroseneFuel.setAmountToBurn(10);
        SupremeKeroseneFuel.setByproductAmount(5000);
        SupremeKeroseneFuel.setIsRefinedFuel(true);

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
        WaterWF.setDuration(10);
        WaterWF.setAmountToUse(6);
        WaterWF.setEfficiency(1);
        WaterWF.setConversionFactor(160);

        IWorkingFluid[] workingFluids = {
                WaterWF
        };

        for (IFluidFuel fluidFuel : fluidFuels) {
            if (fluidFuel.gas_turbine) {
                if (fluidFuel.refined_fuel) {
                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquid_fuel.getFluid(fluidFuel.amount_to_burn))
                            .fluidInputs(Air.getFluid(100))
                            .fluidOutputs(fluidFuel.byproduct.getFluid(fluidFuel.byproduct_amount))
                            .duration(fluidFuel.duration)
                            .EUt(128)
                            .buildAndRegister();

                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquid_fuel.getFluid(fluidFuel.amount_to_burn))
                            .fluidInputs(Oxygen.getFluid(20))
                            .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproduct_amount * 1.5f)))
                            .duration((int) (fluidFuel.duration * 1.5))
                            .EUt(128)
                            .buildAndRegister();
                } else {
                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquid_fuel.getFluid(fluidFuel.amount_to_burn))
                            .fluidInputs(Air.getFluid(100))
                            .fluidOutputs(fluidFuel.byproduct.getFluid(fluidFuel.byproduct_amount))
                            .duration(fluidFuel.duration)
                            .EUt(32)
                            .buildAndRegister();

                    GAS_TURBINE_FUELS.recipeBuilder()
                            .circuitMeta(1)
                            .fluidInputs(fluidFuel.liquid_fuel.getFluid(fluidFuel.amount_to_burn))
                            .fluidInputs(Oxygen.getFluid(20))
                            .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproduct_amount * 1.5f)))
                            .duration((int) (fluidFuel.duration * 1.5))
                            .EUt(32)
                            .buildAndRegister();
                }

                for (ILubricant lubricant : lubricants) {
                    if (fluidFuel.refined_fuel) {
                        GAS_TURBINE_FUELS.recipeBuilder()
                                .fluidInputs(lubricant.name.getFluid(lubricant.amount_required))
                                .fluidInputs(fluidFuel.liquid_fuel.getFluid(fluidFuel.amount_to_burn))
                                .fluidInputs(Oxygen.getFluid(20))
                                .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproduct_amount * 1.5f)))
                                .duration((int) (fluidFuel.duration * lubricant.boost * 1.5))
                                .EUt(128)
                                .buildAndRegister();
                    } else {
                        GAS_TURBINE_FUELS.recipeBuilder()
                                .fluidInputs(lubricant.name.getFluid(lubricant.amount_required))
                                .fluidInputs(fluidFuel.liquid_fuel.getFluid(fluidFuel.amount_to_burn))
                                .fluidInputs(Oxygen.getFluid(20))
                                .fluidOutputs(fluidFuel.byproduct.getFluid((int) (fluidFuel.byproduct_amount * 1.5f)))
                                .duration((int) (fluidFuel.duration * lubricant.boost * 1.5))
                                .EUt(32)
                                .buildAndRegister();
                    }
                }
            }

            //THIS IS ONLY ADDED SO THAT IT IS A VALID JETPACK FUEL
            COMBUSTION_GENERATOR_FUELS.recipeBuilder()
                    .fluidInputs(fluidFuel.liquid_fuel.getFluid(25))
                    .duration(100)
                    .EUt(1)
                    .buildAndRegister();
        }

        for (IWorkingFluid workingFluid : workingFluids) {
            HEAT_EXCHANGER_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.normal_fluid.getFluid(workingFluid.amount_to_use))
                    .fluidInputs(DesulfurizedFlueGas.getFluid(500))
                    .fluidOutputs(workingFluid.heated_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                    .fluidOutputs(ChilledFlueGas.getFluid(500))
                    .duration((int) (workingFluid.duration * 0.75))
                    .buildAndRegister();

            HEAT_EXCHANGER_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.normal_fluid.getFluid(workingFluid.amount_to_use))
                    .fluidInputs(FlueGas.getFluid(500))
                    .fluidOutputs(workingFluid.heated_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                    .fluidOutputs(ChilledFlueGas.getFluid(500))
                    .duration(workingFluid.duration)
                    .buildAndRegister();

            STEAM_TURBINE_FUELS.recipeBuilder()
                    .fluidInputs(workingFluid.heated_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                    .fluidOutputs(workingFluid.leftover_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                    .duration(workingFluid.duration * workingFluid.efficiency)
                    .EUt(32)
                    .buildAndRegister();

            LARGE_STEAM_TURBINE.recipeBuilder()
                    .circuitMeta(1)
                    .fluidInputs(workingFluid.heated_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                    .fluidOutputs(workingFluid.leftover_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                    .duration(workingFluid.duration * workingFluid.efficiency)
                    .EUt(32)
                    .buildAndRegister();

            for (var lubricant : lubricants) {
                LARGE_STEAM_TURBINE.recipeBuilder()
                        .fluidInputs(lubricant.name.getFluid(lubricant.amount_required))
                        .fluidInputs(workingFluid.heated_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                        .fluidOutputs(workingFluid.leftover_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor))
                        .duration((int) (workingFluid.duration * workingFluid.efficiency * lubricant.boost))
                        .EUt(32)
                        .buildAndRegister();
            }

            COOLING_TOWER_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.leftover_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor * 64))
                    .fluidInputs(Water.getFluid(1000))
                    .fluidOutputs(workingFluid.normal_fluid.getFluid(workingFluid.amount_to_use * 64))
                    .fluidOutputs(Water.getFluid(750))
                    .duration(workingFluid.duration)
                    .EUt(8)
                    .buildAndRegister();

            HEAT_RADIATOR_RECIPES.recipeBuilder()
                    .fluidInputs(workingFluid.leftover_fluid.getFluid(workingFluid.amount_to_use * workingFluid.conversion_factor * 16))
                    .fluidOutputs(workingFluid.normal_fluid.getFluid(workingFluid.amount_to_use * 16))
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
