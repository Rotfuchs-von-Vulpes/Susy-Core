package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group10;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.BLAST_RECIPES;
import static gregtech.api.recipes.RecipeMaps.PRIMITIVE_BLAST_FURNACE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.combustibles;

public class NickelChain {
    public static void init() {
        // Garnierite Dust * 1
//        mods.gregtech.electric_blast_furnace.removeByInput(120, [metaitem('dustPentlandite')], [fluid('oxygen') * 3000])

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Pentlandite)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, Garnierite)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .EUt(30)
                .blastFurnaceTemp(1728)
                .duration(40)
                .buildAndRegister();

        for (Utils.CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            combustible.byproduct.setCount(combustible.equivalent(1));
            PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                    .input("dustAnyPurityNickel")
                    .inputs(combustible.name)
                    .output(ingot, Nickel)
                    .outputs(combustible.byproduct)
                    .duration(250)
                    .buildAndRegister();

            PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, Garnierite)
                    .inputs(combustible.name)
                    .output(ingot, Nickel)
                    .outputs(combustible.byproduct)
                    .duration(250)
                    .buildAndRegister();

            combustible.name.setCount(combustible.equivalent(4));
            combustible.byproduct.setCount(combustible.equivalent(4));
            PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, Pentlandite)
                    .inputs(combustible.name)
                    .output(ingot, Nickel)
                    .outputs(combustible.byproduct)
                    .duration(250)
                    .buildAndRegister();

            BLAST_RECIPES.recipeBuilder()
                    .input(dust, Garnierite)
                    .inputs(combustible.name)
                    .output(ingot, Nickel)
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .EUt(30)
                    .blastFurnaceTemp(1728)
                    .duration(40)
                    .buildAndRegister();
        }

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .fluidInputs(NickelSulfateSolution.getFluid(1000))
                .fluidInputs(Water.getFluid(2000))
                .notConsumable(stick, Nickel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .output(dust, Nickel)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();

//MOND PROCESS

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Nickel)
                .fluidInputs(CarbonMonoxide.getFluid(4000))
                .fluidOutputs(NickelCarbonyl.getFluid(1000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(NickelCarbonyl.getFluid(1000))
                .output(dust, HighPurityNickel)
                .fluidOutputs(CarbonMonoxide.getFluid(4000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Garnierite)
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, Nickel)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(30)
                .duration(40)
                .buildAndRegister();
    }
}
