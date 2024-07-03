package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group7;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.item.SuSyMetaItems.*;

public class RheniumChain {
    public static void init() {
        ELECTROSTATIC_SEPARATOR.recipeBuilder()
                .notConsumable(ITEM_FILTER)
                .fluidInputs(MolybdeniteFlueGas.getFluid(2000))
                .chancedOutput(dust, RheniumRichFlue, 5000, 0)
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RheniumRichFlue)
                .fluidInputs(DistilledWater.getFluid(50))
                .output(dust, Ash)
                .fluidOutputs(ScrubbedPerrhenateSolution.getFluid(50))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        ION_EXCHANGE_COLUMN_RECIPES.recipeBuilder()
                .input(BEADS_RHENIUM_ION_EXCHANGE)
                .fluidInputs(ScrubbedPerrhenateSolution.getFluid(1000))
                .output(BEADS_LOADED_RHENIUM_ION_EXCHANGE)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(200)
                .EUt(1920)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(BEADS_LOADED_RHENIUM_ION_EXCHANGE)
                .fluidInputs(AmmoniaSolution.getFluid(1000))
                .output(BEADS_RHENIUM_ION_EXCHANGE)
                .fluidOutputs(AmmoniumPerrhenateSolution.getFluid(1000))
                .duration(200)
                .EUt(480)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniumPerrhenateSolution.getFluid(1000))
                .output(dust, AmmoniumPerrhenate, 10)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(200)
                .EUt(480)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, AmmoniumPerrhenate, 10)
                .fluidInputs(Hydrogen.getFluid(7000))
                .output(dust, Rhenium)
                .fluidOutputs(Steam.getFluid(4000))
                .fluidOutputs(Ammonia.getFluid(1000))
                .duration(200)
                .EUt(1920)
                .buildAndRegister();
    }
}
