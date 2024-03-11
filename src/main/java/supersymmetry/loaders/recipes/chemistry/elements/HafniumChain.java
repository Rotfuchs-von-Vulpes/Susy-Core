package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.stick;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.SPONGE_HAFNIUM;
import static supersymmetry.common.item.SuSyMetaItems.SPONGE_HAFNIUM_CRUDE;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.highPurityCombustibles;
import static supersymmetry.loaders.recipes.Utils.inertGases;

public class HafniumChain {
    public static void init() {
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HafniumExtract.getFluid(1000))
                .fluidInputs(DilutedSulfuricAcid.getFluid(80))
                .fluidOutputs(HafniumExtractionMixture.getFluid(1000))
                .fluidOutputs(HafniumSulfateSolution.getFluid(40))
                .EUt(120)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(HafniumSulfateSolution.getFluid(2000))
                .output(dust, HafniumDioxide, 3)
                .fluidOutputs(Steam.getFluid(2000))
                .fluidOutputs(SulfurTrioxide.getFluid(2000))
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        for (Utils.CarbonSource highPurityCombustible : highPurityCombustibles) {
            highPurityCombustible.name.setCount(highPurityCombustible.equivalent(2));
            FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, HafniumDioxide)
                    .inputs(highPurityCombustible.name)
                    .fluidInputs(Chlorine.getFluid(4000))
                    .output(dust, ImpureHafniumTetrachloride, 5)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .duration(200 * highPurityCombustible.duration)
                    .EUt(120)
                    .buildAndRegister();
        }

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, ImpureHafniumTetrachloride, 5)
                .notConsumable(Nitrogen.getFluid(1000))
                .notConsumable(Hydrogen.getFluid(1000))
                .fluidOutputs(HafniumTetrachloride.getFluid(720))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        for (Utils.InertGas inertGas : inertGases) {
            BLAST_RECIPES.recipeBuilder()
                    .circuitMeta(2)
                    .fluidInputs(HafniumTetrachloride.getFluid(720))
                    .notConsumable(inertGas.name)
                    .input("dustAnyPurityMagnesium", 2)
                    .output(SPONGE_HAFNIUM_CRUDE)
                    .fluidOutputs(MagnesiumChloride.getFluid(864))
                    .blastFurnaceTemp(2150)
                    .duration(100 * inertGas.duration)
                    .EUt(480)
                    .buildAndRegister();
        }

        VACUUM_CHAMBER.recipeBuilder()
                .input(SPONGE_HAFNIUM_CRUDE)
                .output(SPONGE_HAFNIUM)
                .duration(100)
                .EUt(7)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(SPONGE_HAFNIUM)
                .output(dust, Hafnium)
                .duration(100)
                .EUt(7)
                .buildAndRegister();

//VAN ARKEL-DE BOER

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Hafnium)
                .input("dustAnyPurityIodine", 4)
                .output(dust, HafniumIodide, 5)
                .duration(360)
                .EUt(120)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(dust, HafniumIodide, 5)
                .notConsumable(stick, Tungsten)
                .output(dust, HighPurityHafnium)
                .fluidOutputs(Iodine.getFluid(576))
                .duration(180)
                .EUt(480)
                .buildAndRegister();
    }
}
