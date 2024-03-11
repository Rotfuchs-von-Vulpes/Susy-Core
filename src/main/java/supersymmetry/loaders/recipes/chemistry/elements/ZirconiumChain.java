package supersymmetry.loaders.recipes.chemistry.elements;

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
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.sifted;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.*;

public class ZirconiumChain {
    public static void init() {
        // Benefication

// Zircon
        GRAVITY_SEPARATOR_RECIPES.recipeBuilder()
                .input(dust, Zircon)
                .output(sifted, Zircon)
                .chancedOutput(dust, CertusQuartz, 5000, 0)
                .EUt(30)
                .duration(40)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(sifted, Zircon, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Zircon.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Zircon.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(SodaAshSolution.getFluid(1000))
                .notConsumable(AlkalineSodiumOleateSolution.getFluid(1000))
                .notConsumable(dust, SodiumSilicate, 6)
                .notConsumable(dust, Iron3Chloride, 4)
                .notConsumable(dust, SodiumSulfide, 3)
                .fluidOutputs(Zircon.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Zircon.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(flotated, Zircon, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ELECTROSTATIC_SEPARATOR.recipeBuilder()
                .input(flotated, Zircon)
                .output(concentrate, Zircon)
                .chancedOutput(dust, Ilmenite, 500, 100)
                .chancedOutput(dust, Chromite, 500, 100)
                .chancedOutput(dust, Hematite, 500, 100)
                .chancedOutput(dust, Rutile, 500, 100)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Thermal disassociation (90%)
        ADVANCED_ARC_FURNACE.recipeBuilder()
                .input(concentrate, Zircon)
                .chancedOutput(dust, FusedZirconia, 3, 9000, 0)
                .output(dust, SiliconDioxide, 3)
                .duration(20)
                .EUt(1920)
                .buildAndRegister();

// Carbochlorination (100%)
        for (CarbonSource combutible : highPurityCombustibles) {
            combutible.name.setCount(combutible.equivalent(4));
            FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                    .input(concentrate, Zircon)
                    .inputs(combutible.name)
                    .fluidInputs(Chlorine.getFluid(8000))
                    .output(dust, ImpureZirconiumTetrachloride, 5)
                    .chancedOutput(combutible.byproduct, 1000, 0)
                    .chancedOutput(dust, Cobalt, 500, 100)
                    .fluidOutputs(SiliconTetrachloride.getFluid(1000))
                    .fluidOutputs(CarbonMonoxide.getFluid(4000))
                    .duration(40 * combutible.duration)
                    .EUt(480)
                    .buildAndRegister();
        }

// Baddeleyite
        ADVANCED_ARC_FURNACE.recipeBuilder()
                .input(dust, Baddeleyite)
                .chancedOutput(dust, FusedZirconia, 3, 9000, 0)
                .duration(20)
                .EUt(7680)
                .buildAndRegister();

// Direct sulfatization (75%)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, FusedZirconia, 3)
                .fluidInputs(SulfuricAcid.getFluid(1500))
                .fluidInputs(DistilledWater.getFluid(750))
                .fluidOutputs(ZirconiumSulfateSolution.getFluid(2250))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Calcium zirconate sulfatization (90%)

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, FusedZirconia, 3)
                .input(dust, Quicklime, 2)
                .chancedOutput(dust, CalciumZirconate, 5, 9000, 0)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumZirconate, 3)
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .fluidOutputs(ZirconiumSulfateSolution.getFluid(3000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumChloride, 6)
                .fluidInputs(ZirconiumSulfateSolution.getFluid(3000))
                .output(dust, CalciumSulfate, 6)
                .fluidOutputs(ZirconylChlorideSolution.getFluid(2000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Carbochlorination (100%)
        for (CarbonSource combutible : highPurityCombustibles) {
            combutible.name.setCount(combutible.equivalent(2));
            FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, Baddeleyite)
                    .inputs(combutible.name)
                    .fluidInputs(Chlorine.getFluid(4000))
                    .output(dust, ImpureZirconiumTetrachloride, 5)
                    .chancedOutput(combutible.byproduct, 1000, 0)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .duration(40 * combutible.duration)
                    .EUt(480)
                    .buildAndRegister();
        }

// Hafnium separation
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ImpureZirconiumTetrachloride, 5)
                .fluidInputs(DistilledWater.getFluid(3000))
                .fluidOutputs(ZirconylChlorideSolution.getFluid(2000))
                .duration(40)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumThiocyanate, 8)
                .fluidInputs(Kerosene.getFluid(900))
                .fluidInputs(MethylIsobutylKetone.getFluid(100))
                .fluidOutputs(HafniumExtractionMixture.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ZirconylChlorideSolution.getFluid(2000))
                .fluidInputs(HafniumExtractionMixture.getFluid(1000))
                .fluidOutputs(PurifiedZirconylChlorideSolution.getFluid(2000))
                .fluidOutputs(HafniumExtract.getFluid(1000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedZirconylChlorideSolution.getFluid(10000))
                .fluidInputs(SulfuricAcid.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(13000))
                .notConsumable(AmmoniaSolution.getFluid(1000))
                .output(dust, ZirconiumBasicSulfate, 23)
                .fluidOutputs(HydrochloricAcid.getFluid(12000))
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZirconiumBasicSulfate, 23)
                .fluidInputs(AmmoniaSolution.getFluid(4000))
                .output(dust, ZirconiumDioxide, 15)
                .fluidOutputs(AmmoniumSulfateSolution.getFluid(2000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        for (CarbonSource combutible : highPurityCombustibles) {
            combutible.name.setCount(combutible.equivalent(2));
            FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, ZirconiumDioxide)
                    .inputs(combutible.name)
                    .fluidInputs(Chlorine.getFluid(4000))
                    .output(dust, ZirconiumTetrachloride, 5)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .duration(40 * combutible.duration)
                    .EUt(480)
                    .buildAndRegister();
        }

        for (InertGas inertGas : inertGases) {
            BLAST_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .input(dust, ZirconiumTetrachloride, 5)
                    .notConsumable(inertGas.name)
                    .input("dustAnyPurityMagnesium", 2)
                    .output(SPONGE_ZIRCONIUM_CRUDE)
                    .fluidOutputs(MagnesiumChloride.getFluid(864))
                    .blastFurnaceTemp(2150)
                    .duration(20 * inertGas.duration)
                    .EUt(1920)
                    .buildAndRegister();
        }

        VACUUM_CHAMBER.recipeBuilder()
                .input(SPONGE_ZIRCONIUM_CRUDE)
                .output(SPONGE_ZIRCONIUM)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(SPONGE_ZIRCONIUM)
                .output(dust, Zirconium)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

//VAN ARKEL-DE BOER

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Zirconium)
                .input("dustAnyPurityIodine", 4)
                .output(dust, ZirconiumIodide, 5)
                .duration(300)
                .EUt(480)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(dust, ZirconiumIodide, 5)
                .notConsumable(stick, Tungsten)
                .output(dust, HighPurityZirconium)
                .fluidOutputs(Iodine.getFluid(576))
                .duration(150)
                .EUt(1920)
                .buildAndRegister();

    }
}
