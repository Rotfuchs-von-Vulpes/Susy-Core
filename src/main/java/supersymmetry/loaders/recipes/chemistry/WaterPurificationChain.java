package supersymmetry.loaders.recipes.chemistry;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.CELLULOSE_ACETATE_MESH;
import static gregtechfoodoption.GTFOMaterialHandler.LithiumCarbonate;

public class WaterPurificationChain {
    public static void init() {
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SaltWater.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(Water.getFluid(1000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SeaWater.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(Water.getFluid(1000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(ConcentratedSaltWater.getFluid(1000))
                .output(dust, Salt, 4)
                .fluidOutputs(Water.getFluid(1000))
                .duration(280)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(HypersalineWater.getFluid(1000))
                .output(dust, Salt, 8)
                .fluidOutputs(Water.getFluid(1000))
                .duration(320)
                .EUt(30)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .fluidInputs(SaltWater.getFluid(20000))
                .output(dust, Salt, 40)
                .duration(1800)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .fluidInputs(SeaWater.getFluid(20000))
                .output(dust, Salt, 20)
                .duration(1800)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .fluidInputs(ConcentratedSaltWater.getFluid(20000))
                .output(dust, Salt, 64)
                .output(dust, Salt, 16)
                .duration(1800)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .fluidInputs(HypersalineWater.getFluid(20000))
                .output(dust, Salt, 64)
                .output(dust, Salt, 64)
                .output(dust, Salt, 32)
                .duration(1800)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Brine.getFluid(10000))
                .output(dust, Salt, 64)
                .output(dust, Salt, 16)
                .duration(150)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(Brine.getFluid(10000))
                .output(dust, Salt, 64)
                .output(dust, Salt, 16)
                .fluidOutputs(ConcentratedBrine.getFluid(2500))
                .duration(1800)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(ConcentratedBrine.getFluid(2500))
                .output(dust, Carnallite, 50)
                .output(dust, PotassiumCarbonate, 20)
                .output(dust, CalciumChloride, 15)
                .duration(1800)
                .buildAndRegister();

        EVAPORATION_POOL.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(ConcentratedBrine.getFluid(2500))
                .output(dust, Carnallite, 50)
                .output(dust, PotassiumCarbonate, 20)
                .output(dust, CalciumChloride, 15)
                .fluidOutputs(VeryConcentratedBrine.getFluid(250))
                .duration(1800)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(VeryConcentratedBrine.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(200))
                .output(dust, BoricAcid, 7)
                .fluidOutputs(BoronFreeBrine.getFluid(1000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(BoronFreeBrine.getFluid(1000))
                .input(dust, SodaAsh, 6)
                .outputs(LithiumCarbonate.getItemStack(6))
                .fluidOutputs(LithiumFreeBrine.getFluid(1000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(LithiumFreeBrine.getFluid(50))
                .fluidInputs(Chlorine.getFluid(10))
                .fluidOutputs(ChlorinatedBrine.getFluid(50))
                .duration(1)
                .EUt(120)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(Steam.getFluid(250))
                .fluidInputs(ChlorinatedBrine.getFluid(1000))
                .fluidOutputs(ImpureBromine.getFluid(100))
                .fluidOutputs(WastewaterSludge.getFluid(500))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ImpureBromine.getFluid(1000))
                .fluidOutputs(Bromine.getFluid(1000))
                .chancedOutput(dust, Iodine, 1000, 1000)
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        MULTI_STAGE_FLASH_DISTILLATION.recipeBuilder()
                .fluidInputs(SeaWater.getFluid(10000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(Water.getFluid(5000))
                .fluidOutputs(SaltWater.getFluid(5000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        MULTI_STAGE_FLASH_DISTILLATION.recipeBuilder()
                .fluidInputs(SaltWater.getFluid(5000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(Water.getFluid(2500))
                .fluidOutputs(ConcentratedSaltWater.getFluid(2500))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        MULTI_STAGE_FLASH_DISTILLATION.recipeBuilder()
                .fluidInputs(ConcentratedSaltWater.getFluid(2500))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(Water.getFluid(1250))
                .fluidOutputs(HypersalineWater.getFluid(1250))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        MULTI_STAGE_FLASH_DISTILLATION.recipeBuilder()
                .fluidInputs(Water.getFluid(8750))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(DistilledWater.getFluid(8750))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        PRESSURE_SWING_ADSORBER_RECIPES.recipeBuilder()
                .notConsumable(CELLULOSE_ACETATE_MESH)
                .fluidInputs(SaltWater.getFluid(10000))
                .output(dust, Salt, 20)
                .fluidOutputs(Water.getFluid(10000))
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        PRESSURE_SWING_ADSORBER_RECIPES.recipeBuilder()
                .notConsumable(CELLULOSE_ACETATE_MESH)
                .fluidInputs(ConcentratedSaltWater.getFluid(10000))
                .output(dust, Salt, 40)
                .fluidOutputs(Water.getFluid(10000))
                .duration(80)
                .EUt(480)
                .buildAndRegister();

        PRESSURE_SWING_ADSORBER_RECIPES.recipeBuilder()
                .notConsumable(CELLULOSE_ACETATE_MESH)
                .fluidInputs(HypersalineWater.getFluid(5000))
                .output(dust, Salt, 40)
                .fluidOutputs(Water.getFluid(5000))
                .duration(40)
                .EUt(480)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(WastewaterSludge.getFluid(1000))
                .duration(20)
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(Wastewater.getFluid(1000))
                .fluidOutputs(HeatedWastewater.getFluid(1000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(HeatedWastewater.getFluid(1000))
                .input(dust, AluminiumSulfate, 1)
                .fluidOutputs(FlocculatedWastewater.getFluid(1000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(FlocculatedWastewater.getFluid(8000))
                .output(dust, AluminiumSulfate, 8)
                .fluidOutputs(WastewaterSludge.getFluid(2000))
                .fluidOutputs(Water.getFluid(6000))
                .duration(600)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .input(dust, WetMolecularSieve)
                .output(dust, MolecularSieve)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ION_EXCHANGE_COLUMN_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(1000))
                .notConsumable(dust, MolecularSieve)
                .fluidOutputs(DemineralizedWater.getFluid(900))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(DemineralizedWater.getFluid(1000))
                .fluidInputs(Steam.getFluid(100))
                .fluidOutputs(DeaeratedWater.getFluid(900))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .fluidInputs(DeaeratedWater.getFluid(1000))
                .notConsumable(CELLULOSE_ACETATE_MESH)
                .fluidOutputs(FilteredWater.getFluid(900))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        UV_RECIPES.recipeBuilder()
                .fluidInputs(FilteredWater.getFluid(1000))
                .fluidOutputs(SterilizedWater.getFluid(900))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DeaeratedWater.getFluid(100))
                .fluidOutputs(UltrapureWater.getFluid(15))
                .duration(10)
                .EUt(50)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(FilteredWater.getFluid(100))
                .fluidOutputs(UltrapureWater.getFluid(30))
                .duration(10)
                .EUt(40)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DemineralizedWater.getFluid(100))
                .fluidOutputs(UltrapureWater.getFluid(5))
                .duration(10)
                .EUt(60)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SterilizedWater.getFluid(100))
                .fluidOutputs(UltrapureWater.getFluid(90))
                .duration(10)
                .EUt(30)
                .buildAndRegister();
    }
}
