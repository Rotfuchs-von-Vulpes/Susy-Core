package supersymmetry.common.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.material.Material;
import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.materials.Util.determineTemperatureGas;
import static supersymmetry.common.materials.Util.determineTemperatureLiquid;

public class SuSyThermodynamicsMaterials {

    private static Material[] generateHighPressureGases(Material materialName, int id){
        var color = materialName.getMaterialRGB();

        Material mat1 = new Material.Builder(id, SuSyUtility.susyId("hot_hp_" + materialName.toString()))
                .gas(new FluidBuilder().temperature(323))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat2 = new Material.Builder(id + 1, SuSyUtility.susyId("hp_" + materialName.toString()))
                .gas()
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        return new Material[]{mat1, mat2};
    }

    private static Material generateColdHighPressureGases(Material materialName, int id){
        var color = materialName.getMaterialRGB();
        return new Material.Builder(id + 2, SuSyUtility.susyId("cold_hp_" + materialName.toString()))
                .gas(new FluidBuilder().temperature(223))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
    }

    private static Material generateLiquidFromGas(Material materialName, int id, int boilingTemperature){
        var color = materialName.getMaterialRGB();

        return new Material.Builder(id, SuSyUtility.susyId("liquid_" + materialName.toString()))
                .liquid(new FluidBuilder().temperature(boilingTemperature))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
    }

    private static Material[] generateThermoRefrigerant(Material materialName, int id){
        var color = materialName.getMaterialRGB();

        Material mat1 = new Material.Builder(id, SuSyUtility.susyId("hot_compressed_" + materialName.toString()))
                .gas(new FluidBuilder().temperature(323))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat2 = new Material.Builder(id + 1, SuSyUtility.susyId("compressed_" + materialName.toString()))
                .gas()
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat3 = new Material.Builder(id + 2, SuSyUtility.susyId("cold_compressed_" + materialName.toString()))
                .gas(new FluidBuilder().temperature(223))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat4 = new Material.Builder(id + 3, SuSyUtility.susyId("cold_" + materialName.toString()))
                .gas(new FluidBuilder().temperature(223))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        return new Material[]{mat1, mat2, mat3, mat4};
    }

    private static Material generateCoolant(Material materialName, int id){
        int color = materialName.getMaterialRGB();

        return new Material.Builder(id, SuSyUtility.susyId("warm_" + materialName.toString()))
                .liquid(new FluidBuilder().temperature(303))
                .color(color)
                .components(materialName, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

    }

    private static Material generateHotGas(Material material, int id) {
        int color = material.getMaterialRGB();

        return new Material.Builder(id, SuSyUtility.susyId("hot_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 100))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();
    }

    private static Material[] generateGreenhouseGases(Material material, int id) {
        int color = material.getMaterialRGB();

        Material mat1 = new Material.Builder(id, SuSyUtility.susyId("warm_dry_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat2 = new Material.Builder(id + 1, SuSyUtility.susyId("warm_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat3 = new Material.Builder(id + 2, SuSyUtility.susyId("warm_humid_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) + 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat4 = new Material.Builder(id + 3, SuSyUtility.susyId("dry_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat5 = new Material.Builder(id + 4, SuSyUtility.susyId("humid_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat6 = new Material.Builder(id + 5, SuSyUtility.susyId("cool_dry_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat7 = new Material.Builder(id + 6, SuSyUtility.susyId("cool_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        Material mat8 = new Material.Builder(id + 7, SuSyUtility.susyId("cool_humid_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material) - 20))
                .color(color)
                .components(material, 1)
                .flags(DISABLE_DECOMPOSITION)
                .build();

        return new Material[]{mat1, mat2, mat3, mat4, mat5, mat6, mat7, mat8};
    }

    private static Material generatePurifiedGas(Material material, int id) {
        int color = material.getMaterialRGB();

        return new Material.Builder(id, SuSyUtility.susyId("high_purity_" + material.toString()))
                .gas(new FluidBuilder().temperature(determineTemperatureGas(material)))
                .color(color)
                .components(material, 1)
                .build();
    }

    private static Material generatePurifiedLiquid(Material material, int id) {
        var color = material.getMaterialRGB();

        return new Material.Builder(id, SuSyUtility.susyId("high_purity_" + material.toString()))
                .liquid(new FluidBuilder().temperature(determineTemperatureLiquid(material)))
                .color(color)
                .components(material, 1)
                .build();
    }
    public static void init() {
        Material[] temp;

        temp = generateHighPressureGases(Hydrogen, 22000);
        HotHighPressureHydrogen = temp[0];
        HighPressureHydrogen = temp[1];

        ColdHighPressureHydrogen = generateColdHighPressureGases(Hydrogen, 22000);

        temp = generateHighPressureGases(Oxygen, 22003);
        HotHighPressureOxygen = temp[0];
        HighPressureOxygen = temp[1];

        ColdHighPressureOxygen = generateColdHighPressureGases(Oxygen, 22003);

        temp = generateHighPressureGases(Helium, 22006);
        HotHighPressureHelium = temp[0];
        HighPressureHelium = temp[1];

        ColdHighPressureHelium = generateColdHighPressureGases(Helium, 22006);

        temp = generateHighPressureGases(Neon, 22009);
        HotHighPressureNeon = temp[0];
        HighPressureNeon = temp[1];

        ColdHighPressureNeon = generateColdHighPressureGases(Neon, 22009);

        temp = generateHighPressureGases(Argon, 22012);
        HotHighPressureArgon = temp[0];
        HighPressureArgon = temp[1];

        ColdHighPressureArgon = generateColdHighPressureGases(Argon, 22012);

        temp = generateHighPressureGases(Krypton, 22015);
        HotHighPressureKrypton = temp[0];
        HighPressureKrypton = temp[1];

        ColdHighPressureKrypton = generateColdHighPressureGases(Krypton, 22015);

        temp = generateHighPressureGases(Xenon, 22018);
        HotHighPressureXenon = temp[0];
        HighPressureXenon = temp[1];

        ColdHighPressureXenon = generateColdHighPressureGases(Xenon, 22018);

        temp = generateHighPressureGases(Nitrogen, 22021);
        HotHighPressureNitrogen = temp[0];
        HighPressureNitrogen = temp[1];

        ColdHighPressureNitrogen = generateColdHighPressureGases(Nitrogen, 22021);

        temp = generateHighPressureGases(Propene, 22024);
        HotHighPressurePropene = temp[0];
        HighPressurePropene = temp[1];

        temp = generateHighPressureGases(Benzene, 22027);
        HotHighPressureBenzene = temp[0];
        HighPressureBenzene = temp[1];

        temp = generateHighPressureGases(CarbonMonoxide, 22030);
        HotHighPressureCarbonMonoxide = temp[0];
        HighPressureCarbonMonoxide = temp[1];

        temp = generateHighPressureGases(Air, 22033);
        HotHighPressureAir = temp[0];
        HighPressureAir = temp[1];

        ColdHighPressureAir = generateColdHighPressureGases(Air, 22033);

        temp = generateHighPressureGases(NetherAir, 22036);
        HotHighPressureNetherAir = temp[0];
        HighPressureNetherAir = temp[1];

        ColdHighPressureNetherAir = generateColdHighPressureGases(NetherAir, 22036);

        temp = generateHighPressureGases(RefineryGas, 22039);
        HotHighPressureRefineryGas = temp[0];
        HighPressureRefineryGas = temp[1];

        ColdHighPressureRefineryGas = generateColdHighPressureGases(RefineryGas, 22039);

        temp = generateHighPressureGases(Methane, 22042);
        HotHighPressureMethane = temp[0];
        HighPressureMethane = temp[1];

        ColdHighPressureMethane = generateColdHighPressureGases(Methane, 22042);

        temp = generateHighPressureGases(NaturalGas, 22045);
        HotHighPressureNaturalGas = temp[0];
        HighPressureNaturalGas = temp[1];

        ColdHighPressureNaturalGas = generateColdHighPressureGases(NaturalGas, 22045);

        temp = generateHighPressureGases(DecarburizedAir, 22048);
        HotHighPressureDecarburizedAir = temp[0];
        HighPressureDecarburizedAir = temp[1];

        ColdHighPressureDecarburizedAir = generateColdHighPressureGases(DecarburizedAir, 22048);

        LiquidHydrogen = generateLiquidFromGas(Hydrogen, 22100, 14);

        LiquidNeon = generateLiquidFromGas(Neon, 22102, 27);

        LiquidArgon = generateLiquidFromGas(Argon, 22103, 88);

        LiquidKrypton = generateLiquidFromGas(Krypton, 22104, 120);

        LiquidXenon = generateLiquidFromGas(Xenon, 22105, 165);

        LiquidNitrogen = generateLiquidFromGas(Nitrogen, 22106, 77);

        LiquidRefineryGas = generateLiquidFromGas(RefineryGas, 22107, 112);

        LiquidMethane = generateLiquidFromGas(Methane, 22108, 112);

        LiquidNaturalGas = generateLiquidFromGas(NaturalGas, 22109, 110);

        LiquidDecarburizedAir = generateLiquidFromGas(DecarburizedAir, 22110, 80);

        temp = generateThermoRefrigerant(Ammonia, 22150);
        HotCompressedAmmonia = temp[0];
        CompressedAmmonia = temp[1];
        ColdCompressedAmmonia = temp[2];
        ColdAmmonia = temp[3];

        temp = generateThermoRefrigerant(Propane, 22155);
        HotCompressedPropane = temp[0];
        CompressedPropane = temp[1];
        ColdCompressedPropane = temp[2];
        ColdPropane = temp[3];

        temp = generateThermoRefrigerant(CarbonDioxide, 22160);
        HotCompressedCarbonDioxide = temp[0];
        CompressedCarbonDioxide = temp[1];
        ColdCompressedCarbonDioxide = temp[2];
        ColdCarbonDioxide = temp[3];

        temp = generateThermoRefrigerant(Trichlorofluoromethane, 22165);
        HotCompressedTrichlorofluoromethane = temp[0];
        CompressedTrichlorofluoromethane = temp[1];
        ColdCompressedTrichlorofluoromethane = temp[2];
        ColdTrichlorofluoromethane = temp[3];

        temp = generateThermoRefrigerant(Dichlorodifluoromethane, 22170);
        HotCompressedDichlorodifluoromethane = temp[0];
        CompressedDichlorodifluoromethane = temp[1];
        ColdCompressedDichlorodifluoromethane = temp[2];
        ColdDichlorodifluoromethane = temp[3];

        temp = generateThermoRefrigerant(Chlorotrifluoromethane, 22175);
        HotCompressedChlorotrifluoromethane = temp[0];
        CompressedChlorotrifluoromethane = temp[1];
        ColdCompressedChlorotrifluoromethane = temp[2];
        ColdChlorotrifluoromethane = temp[3];

        temp = generateThermoRefrigerant(Chlorodifluoromethane, 22180);
        HotCompressedChlorodifluoromethane = temp[0];
        CompressedChlorodifluoromethane = temp[1];
        ColdCompressedChlorodifluoromethane = temp[2];
        ColdChlorodifluoromethane = temp[3];

        WarmWater = generateCoolant(Water, 22300);

        WarmEthyleneGlycol = generateCoolant(EthyleneGlycol, 22305);

        WarmSaltWater = generateCoolant(SaltWater, 22310);

        WarmLubricant = generateCoolant(Lubricant, 22315);

        WarmPolychlorinatedBiphenyl = generateCoolant(PolychlorinatedBiphenyl, 22320);

        WarmBrine = generateCoolant(Brine, 22325);

        WarmSodiumPotassium = generateCoolant(SodiumPotassium, 22330);

        HotAir = generateHotGas(Air, 22400);

        HotNitrogen = generateHotGas(Nitrogen, 22401);

        HighPurifyHydrogen = generatePurifiedGas(Hydrogen, 22500);

        HighPurifyHelium = generatePurifiedGas(Helium, 22501);

        HighPurifyNitrogen = generatePurifiedGas(Nitrogen, 22502);

        HighPurifyOxygen = generatePurifiedGas(Oxygen, 22503);

        HighPurifyFluorine = generatePurifiedGas(Fluorine, 22504);

        HighPurifyNeon = generatePurifiedGas(Neon, 22505);

        HighPurifyChlorine = generatePurifiedGas(Chlorine, 22506);

        HighPurifyArgon = generatePurifiedGas(Argon, 22507);

        HighPurifyKrypton = generatePurifiedGas(Krypton, 22508);

        HighPurifyXenon = generatePurifiedGas(Xenon, 22509);

        HighPurifyBromine = generatePurifiedLiquid(Bromine, 22600);

        HighPurifyMercury = generatePurifiedLiquid(Mercury, 22601);

        temp = generateGreenhouseGases(EarthGreenhouseGas, 22700);
        WarmDryEarthGreenhouseGas = temp[0];
        WarmEarthGreenhouseGas = temp[1];
        WarmHumidEarthGreenhouseGas = temp[2];
        DryEarthGreenhouseGas = temp[1];
        HumidEarthGreenhouseGas = temp[1];
        CoolEarthGreenhouseGas = temp[1];
        CoolDryEarthGreenhouseGas = temp[1];
        CoolHumidEarthGreenhouseGas = temp[1];

        EarthLikeAir = new Material.Builder(22800, SuSyUtility.susyId("earth_like_air"))
                .gas()
                .color(0x8fbfe3)
                .build();

        HotHighPressureSteam = new Material.Builder(22801, SuSyUtility.susyId("hot_hp_steam"))
                .gas(new FluidBuilder().temperature(1200))
                .color(0xffffff)
                .build();

        WasteGaseousNitrogen = new Material.Builder(22807, SuSyUtility.susyId("waste_gaseous_nitrogen"))
                .gas()
                .color(0x29a4a6)
                .build();

        ChillyWasteGaseousNitrogen = new Material.Builder(22813, SuSyUtility.susyId("chilly_waste_gaseous_nitrogen"))
                .gas(new FluidBuilder().temperature(243))
                .color(0x3f9d9e)
                .build();

        SubcooledLiquidNitrogen = new Material.Builder(22814, SuSyUtility.susyId("subcooled_liquid_nitrogen"))
                .liquid(new FluidBuilder().temperature(60))
                .color(0x009a9c)
                .build();

        ColdWasteGaseousNitrogen = new Material.Builder(22815, SuSyUtility.susyId("cold_waste_gaseous_nitrogen"))
                .gas(new FluidBuilder().temperature(223))
                .color(0x367f80)
                .build();

        UntreatedLiquidOxygen = new Material.Builder(22816, SuSyUtility.susyId("untreated_liquid_oxygen"))
                .liquid(new FluidBuilder().temperature(55))
                .color(0x49a4d1)
                .build();

        UntreatedLiquidNitrogen = new Material.Builder(22817, SuSyUtility.susyId("untreated_liquid_nitrogen"))
                .liquid(new FluidBuilder().temperature(60))
                .color(0x029799)
                .build();

        OxygenRichLiquid = new Material.Builder(22818, SuSyUtility.susyId("oxygen_rich_liquid"))
                .liquid(new FluidBuilder().temperature(55))
                .color(0x67c6e0)
                .build();

        OxygenRichGas = new Material.Builder(22819, SuSyUtility.susyId("oxygen_rich_gas"))
                .gas(new FluidBuilder().temperature(90))
                .color(0x78d2eb)
                .build();

        NitrogenRichGas = new Material.Builder(22820, SuSyUtility.susyId("nitrogen_rich_gas"))
                .gas(new FluidBuilder().temperature(120))
                .color(0x7ee0dd)
                .build();

        ArgonRichGas = new Material.Builder(22821, SuSyUtility.susyId("argon_rich_gas"))
                .gas(new FluidBuilder().temperature(140))
                .color(0x6bc9aa)
                .build();

        OxygenRichVapor = new Material.Builder(22822, SuSyUtility.susyId("oxygen_rich_vapor"))
                .gas(new FluidBuilder().temperature(170))
                .color(0x92e1f7)
                .build();

        CrudeArgonVapor = new Material.Builder(22823, SuSyUtility.susyId("crude_argon_vapor"))
                .gas(new FluidBuilder().temperature(160))
                .color(0x78e3c0)
                .build();

        SubcooledOxygenRichLiquid = new Material.Builder(22824, SuSyUtility.susyId("subcooled_oxygen_rich_liquid"))
                .gas(new FluidBuilder().temperature(90))
                .color(0x0dba0d)
                .build();

        CrudeLiquidKrypton = new Material.Builder(22825, SuSyUtility.susyId("crude_liquid_krypton"))
                .liquid(new FluidBuilder().temperature(120))
                .color(0x579e57)
                .build();

        RareGasRichFraction = new Material.Builder(22826, SuSyUtility.susyId("rare_gas_rich_fraction"))
                .gas(new FluidBuilder().temperature(80))
                .color(0xd3eb94)
                .build();

        CondensedRareGasRichFraction = new Material.Builder(22827, SuSyUtility.susyId("condensed_rare_gas_rich_fraction"))
                .gas(new FluidBuilder().temperature(60))
                .color(0xe3a56b)
                .build();

        CrudeNeonVapor = new Material.Builder(22828, SuSyUtility.susyId("crude_neon_vapor"))
                .gas(new FluidBuilder().temperature(40))
                .color(0xc77b7b)
                .build();

        GaseousCrudeKrypton = new Material.Builder(22829, SuSyUtility.susyId("gaseous_crude_krypton"))
                .gas(new FluidBuilder().temperature(160))
                .color(0x579e57)
                .build();

        ColdLiquidOxygen = new Material.Builder(22830, SuSyUtility.susyId("cold_liquid_oxygen"))
                .liquid(new FluidBuilder().temperature(40))
                .color(0x1f729c)
                .build();

        CompressedCrudeNeon = new Material.Builder(22831, SuSyUtility.susyId("compressed_crude_neon"))
                .gas(new FluidBuilder().temperature(40))
                .color(0xa65e5e)
                .build();

        PartiallyLiquefiedCrudeNeon = new Material.Builder(22832, SuSyUtility.susyId("partially_liquefied_crude_neon"))
                .liquid(new FluidBuilder().temperature(30))
                .color(0xb35959)
                .build();

        GaseousCrudeNeon = new Material.Builder(22833, SuSyUtility.susyId("gaseous_crude_neon"))
                .gas(new FluidBuilder().temperature(35))
                .color(0xbd5757)
                .build();

        LiquidCrudeNeon = new Material.Builder(22834, SuSyUtility.susyId("liquid_crude_neon"))
                .liquid(new FluidBuilder().temperature(25))
                .color(0x944444)
                .build();

        LiquidCrudeArgon = new Material.Builder(22835, SuSyUtility.susyId("liquid_crude_argon"))
                .liquid(new FluidBuilder().temperature(90))
                .color(0x0dba0d)
                .build();

        ColdGaseousNitrogen = new Material.Builder(22836, SuSyUtility.susyId("cold_gaseous_nitrogen"))
                .gas(new FluidBuilder().temperature(140))
                .color(0x23b9ba)
                .build();

        LiquidArgonProduct = new Material.Builder(22837, SuSyUtility.susyId("liquid_argon_product"))
                .liquid(new FluidBuilder().temperature(87))
                .color(0x0ecc0e)
                .build();

        LiquidOxygenProduct = new Material.Builder(22838, SuSyUtility.susyId("liquid_oxygen_product"))
                .liquid(new FluidBuilder().temperature(90))
                .color(0x459fcc)
                .build();

        LiquidNitrogenProduct = new Material.Builder(22839, SuSyUtility.susyId("liquid_nitrogen_product"))
                .liquid(new FluidBuilder().temperature(77))
                .color(0x0b9a9c)
                .build();

        LiquidDeoxygenatedArgon = new Material.Builder(22840, SuSyUtility.susyId("liquid_deoxygenated_argon"))
                .liquid(new FluidBuilder().temperature(87))
                .color(0x3de03d)
                .build();

        LiquidWasteNitrogen = new Material.Builder(22841, SuSyUtility.susyId("liquid_waste_nitrogen"))
                .liquid(new FluidBuilder().temperature(77))
                .color(0x379394)
                .build();

        PartiallyLiquefiedArgon = new Material.Builder(22842, SuSyUtility.susyId("partially_liquefied_argon"))
                .liquid(new FluidBuilder().temperature(120))
                .color(0x56bf56)
                .build();

        SupercriticalCarbonDioxide = new Material.Builder(22843, SuSyUtility.susyId("supercritical_carbon_dioxide"))
                .liquid(new FluidBuilder().temperature(373))
                .components(CarbonDioxide, 1)
                .colorAverage()
                .build();
    }
}
