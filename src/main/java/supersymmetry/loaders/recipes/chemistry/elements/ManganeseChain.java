package supersymmetry.loaders.recipes.chemistry.elements;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.BLAST_RECIPES;
import static gregtech.api.recipes.RecipeMaps.DISTILLERY_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.combustibles;
import static supersymmetry.loaders.recipes.Utils.highPurityCombustibles;

public class ManganeseChain {
    private static class Reductant {
        FluidStack name;
        FluidStack byproduct;

        Reductant(FluidStack name, FluidStack byproduct) {
            this.name = name;
            this.byproduct = byproduct;
        }
    }
    public static void init() {
        //PYROMETALLUGRICAL METHODS (75%)

        for (Utils.CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            BLAST_RECIPES.recipeBuilder()
                    .input(dust, Pyrolusite)
                    .inputs(combustible.name)
                    .input(dustTiny, Calcite)
                    .chancedOutput(dust, Manganese, 7500, 0)
                    .fluidOutputs(CarbonDioxide.getFluid(1000))
                    .blastFurnaceTemp(1200)
                    .duration(120)
                    .EUt(120)
                    .buildAndRegister();
        }

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Rhodochrosite)
                .output(dust, ManganeseIIOxide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        for (Utils.CarbonSource combustible : highPurityCombustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, ManganeseIIOxide, 2)
                    .inputs(combustible.name)
                    .chancedOutput(dust, Manganese, 8500, 0)
                    .chancedOutput(combustible.byproduct, 1000, 0)
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .duration(120 * combustible.duration)
                    .EUt(30)
                    .buildAndRegister();
        }

//PARTIAL REDUCTION OF PYROLUSITE FOR SULFURIC ACID LEACH

        Reductant[] hydrocarbonReductants = {
                new Reductant(FuelOil.getFluid(67), CarbonDioxide.getFluid(288)),
                new Reductant(NaturalGas.getFluid(167), CarbonDioxide.getFluid(234))
        };

        Reductant[] reductants = {
                new Reductant(CarbonMonoxide.getFluid(1000), CarbonDioxide.getFluid(1000)),
                new Reductant(Hydrogen.getFluid(2000), Steam.getFluid(1000))
        };

/*
FUEL OIL: 11.4 mol H, 4.6 mol C, 29.8 mol e-
NATURAL GAS: 5.4 mol H, 1.65 mol C, 12 mol e-
*/

        for (Reductant reductant : hydrocarbonReductants) {
            REACTION_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, Pyrolusite)
                    .fluidInputs(reductant.name)
                    .output(dust, ManganeseIIOxide, 2)
                    .fluidOutputs(reductant.byproduct)
                    .fluidOutputs(Steam.getFluid(1000 - reductant.byproduct.amount))
                    .duration(120)
                    .EUt(480)
                    .buildAndRegister();
        }

        for (Reductant reductant : reductants) {
            REACTION_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, Pyrolusite)
                    .fluidInputs(reductant.name)
                    .output(dust, ManganeseIIOxide, 2)
                    .fluidOutputs(reductant.byproduct)
                    .duration(120)
                    .EUt(480)
                    .buildAndRegister();
        }

//HYDROMETALLURGICAL MANGANESE PROCESSING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ManganeseIIOxide)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(CrudeManganeseIISulfateSolution.getFluid(1000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dustTiny, SodiumHydroxide, 2)
                .fluidInputs(CrudeManganeseIISulfateSolution.getFluid(4000))
                .chancedOutput(dust, IronIIIHydroxide, 7, 500, 0)
                .fluidOutputs(ManganeseIISulfateSolution.getFluid(4000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(ManganeseIISulfateSolution.getFluid(1000))
                .notConsumable(stick, Manganese)
                .notConsumable(GRAPHITE_ELECTRODE)
                .output(dust, Manganese)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(480)
                .EUt(120)
                .buildAndRegister();

// MnCl2

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPurityManganese")
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, ManganeseIIChloride, 3)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ManganeseIIOxide, 2)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(ManganeseIIChlorideSolution.getFluid(3000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(ManganeseIIChlorideSolution.getFluid(3000))
                .output(dust, ManganeseIIChloride, 3)
                .fluidOutputs(Water.getFluid(3000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ManganeseDioxide, 3)
                .fluidInputs(HydrochloricAcid.getFluid(4000))
                .fluidOutputs(DilutedManganeseIIChlorideSolution.getFluid(6000))
                .fluidOutputs(Chlorine.getFluid(2000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedManganeseIIChlorideSolution.getFluid(3000))
                .output(dust, ManganeseIIChloride, 3)
                .fluidOutputs(Water.getFluid(6000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// MnO2

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Pyrolusite, 3)
                .fluidInputs(NitrogenDioxide.getFluid(2000))
                .output(dust, ManganeseIINitrate, 9)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ManganeseIINitrate, 9)
                .fluidOutputs(NitrogenDioxide.getFluid(2000))
                .output(dust, ManganeseDioxide, 3)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

// Manganese hydroxide calcination

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ManganeseIIHydroxide, 5)
                .fluidOutputs(Steam.getFluid(1000))
                .output(dust, ManganeseIIOxide, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();
    }
}
