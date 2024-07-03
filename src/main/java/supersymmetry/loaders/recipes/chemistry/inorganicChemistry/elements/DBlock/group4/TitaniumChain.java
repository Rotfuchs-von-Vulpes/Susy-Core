package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group4;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.api.unification.ore.SusyOrePrefix.concentrate;
import static supersymmetry.common.item.SuSyMetaItems.SPONGE_TITANIUM;
import static supersymmetry.common.item.SuSyMetaItems.SPONGE_TITANIUM_CRUDE;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.highPurityCombustibles;
import static supersymmetry.loaders.recipes.Utils.inertGases;

public class TitaniumChain {
    public static void init() {
        // Hot Titanium Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Magnesium, 2)}, new FluidStack[]{TitaniumTetrachloride.getFluid(1000)});

// Benefication

        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Ilmenite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Ilmenite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Ilmenite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(DilutedSulfuricAcid.getFluid(1000))
                .notConsumable(OleicAcid.getFluid(144))
                .notConsumable(dust, SodiumFluoride, 2)
                .fluidOutputs(Ilmenite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(UltramaficTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Ilmenite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(concentrate, Ilmenite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UltramaficTailingSlurry.getFluid(1000))
                .output(dust, UltramaficTailings, 2)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(concentrate, Ilmenite)
                .output(dust, Ilmenite)
                .chancedOutput(dust, Magnetite, 1000, 250)
                .chancedOutput(concentrate, Rutile, 1000, 250)
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(concentrate, Rutile)
                .output(dust, Rutile)
                .chancedOutput(dust, Zircon, 1000, 250)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dustImpure, Perovskite)
                .output(dust, Perovskite)
                .chancedOutput(concentrate, Rutile, 1000, 250)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Sulfate Process

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Oleum.getFluid(1000))
                .input(dust, Ilmenite)
                .fluidOutputs(TitanylSulfateSolution.getFluid(1000))
                .output(dust, UltramaficTailings)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(HeatedWater.getFluid(1000))
                .fluidInputs(TitanylSulfateSolution.getFluid(1000))
                .fluidOutputs(RutileSlurry.getFluid(2000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .fluidInputs(RutileSlurry.getFluid(2000))
                .notConsumable(ITEM_FILTER)
                .fluidOutputs(AcidicWastewater.getFluid(2000))
                .output(dust, Rutile, 3)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AcidicWastewater.getFluid(1000))
                .input(dust, SodaAsh)
                .fluidOutputs(Wastewater.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Chloride Ilmenite Process

        for (Utils.CarbonSource combustible : highPurityCombustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                    .fluidInputs(Chlorine.getFluid(3000))
                    .input(dust, Ilmenite)
                    .inputs(combustible.name)
                    .chancedOutput(combustible.byproduct, 1000, 0)
                    .fluidOutputs(GaseousIronIIIChloride.getFluid(480))
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .output(dust, Rutile, 3)
                    .duration(100 * combustible.duration)
                    .EUt(30)
                    .buildAndRegister();

            FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                    .fluidInputs(Chlorine.getFluid(2000))
                    .input(dust, Perovskite)
                    .inputs(combustible.name)
                    .chancedOutput(combustible.byproduct, 1000, 0)
                    .fluidOutputs(CalciumChloride.getFluid(432))
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .output(dust, Rutile, 3)
                    .duration(100 * combustible.duration)
                    .EUt(30)
                    .buildAndRegister();

            combustible.name.setCount(combustible.equivalent(2));
            FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, Rutile, 3)
                    .inputs(combustible.name)
                    .fluidInputs(Chlorine.getFluid(4700))
                    .chancedOutput(combustible.byproduct, 1000, 0)
                    .fluidOutputs(GaseousTitaniumTetrachloride.getFluid(1000))
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .duration(50 * combustible.duration)
                    .EUt(120)
                    .buildAndRegister();
        }

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(GaseousIronIIIChloride.getFluid(144))
                .output(dust, Iron3Chloride)
                .duration(200)
                .EUt(30 * 2)
                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(GaseousAluminiumChloride.getFluid(144))
                .output(dust, AluminiumChloride)
                .duration(200)
                .EUt(30 * 2)
                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(GaseousTitaniumTetrachloride.getFluid(1000))
                .fluidOutputs(ImpureTitaniumTetrachloride.getFluid(1000))
                .duration(200)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureTitaniumTetrachloride.getFluid(1000))
                .fluidOutputs(DistilledTitaniumTetrachloride.getFluid(1000))
                .fluidOutputs(TinTetrachloride.getFluid(50))
                .fluidOutputs(SiliconTetrachloride.getFluid(50))
                .duration(400)
                .EUt(120  * 2)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DistilledTitaniumTetrachloride.getFluid(1000))
                .fluidInputs(HydrogenSulfide.getFluid(25))
                .notConsumable(catalystBed, Copper)
                .fluidOutputs(VanadiumFreeTitaniumTetrachloride.getFluid(1000))
                .chancedOutput(dust, VanadiumOxydichloride, 6000, 0)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(VanadiumFreeTitaniumTetrachloride.getFluid(1000))
                .fluidOutputs(GaseousAluminiumChloride.getFluid(50))
                .fluidOutputs(TitaniumTetrachloride.getFluid(1000))
                .chancedOutput(dust, Iron3Chloride, 2000, 250)
                .duration(300)
                .EUt(120 * 2)
                .buildAndRegister();

// Kroll Process

        for (Utils.InertGas inertGas : inertGases) {
            BLAST_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .fluidInputs(TitaniumTetrachloride.getFluid(900))
                    .notConsumable(inertGas.name)
                    .input(dust, Magnesium, 2)
                    .output(SPONGE_TITANIUM_CRUDE)
                    .fluidOutputs(MagnesiumChloride.getFluid(756))
                    .chancedOutput(dust, Magnesium, 1250, 0)
                    .blastFurnaceTemp(2150)
                    .duration(100 * inertGas.duration)
                    .EUt(480 * 2)
                    .buildAndRegister();
        }

        VACUUM_CHAMBER.recipeBuilder()
                .input(SPONGE_TITANIUM_CRUDE)
                .output(SPONGE_TITANIUM)
                .fluidOutputs(TitaniumTetrachloride.getFluid(25))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(SPONGE_TITANIUM)
                .chancedOutput(dust, Titanium, 8500, 0)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Byproducts

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, VanadiumOxydichloride, 4)
                .fluidInputs(Chlorine.getFluid(1000))
                .fluidOutputs(VanadiumOxytrichloride.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(VanadiumOxytrichloride.getFluid(2000))
                .fluidInputs(Water.getFluid(9000))
                .output(dust, VanadiumPentoxide, 7)
                .fluidOutputs(HydrochloricAcid.getFluid(6000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TinTetrachloride.getFluid(1000))
                .fluidInputs(Water.getFluid(6000))
                .output(dust, TinIVOxide, 3)
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

//VAN ARKEL-DE BOER

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Titanium)
                .input("dustAnyPurityIodine", 4)
                .output(dust, TitaniumIodide, 5)
                .duration(240)
                .EUt(480)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(dust, TitaniumIodide, 5)
                .notConsumable(stick, Tungsten)
                .output(dust, HighPurityTitanium)
                .fluidOutputs(Iodine.getFluid(576))
                .duration(120)
                .EUt(1920)
                .buildAndRegister();
    }
}
