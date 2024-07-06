package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group12;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BATCH_REACTOR_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ELECTROLYTIC_CELL_RECIPES;
import static supersymmetry.common.item.SuSyMetaItems.SPONGE_CADMIUM;
import static supersymmetry.common.materials.SusyMaterials.*;

public class CadmiumChain {
    public static void init() {
        // From zinc pyrometallurgy
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZincFlue)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, Ash)
                .fluidOutputs(ImpureCadmiumSulfateSolution.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Salt, 2)
                .fluidInputs(ImpureCadmiumSulfateSolution.getFluid(10000))
                .output(dust, ThalliumIChloride, 2)
                .fluidOutputs(CadmiumSulfateSolution.getFluid(10000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

// From zinc hydrometallurgy
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .input(dust, CopperCadmiumResidue, 30)
                .fluidOutputs(CadmiumSulfateSolution.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .output(dust, Copper, 2)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Zinc)
                .fluidInputs(CadmiumSulfateSolution.getFluid(1000))
                .chancedOutput(SPONGE_CADMIUM, 9000, 0)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

// Electrorefining
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(SPONGE_CADMIUM)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Air.getFluid(4000))
                .fluidOutputs(PurifiedCadmiumSolution.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Lead)
                .notConsumable(plate, Aluminium)
                .fluidInputs(PurifiedCadmiumSolution.getFluid(1000))
                .output(dust, Cadmium)
                .fluidOutputs(Oxygen.getFluid(1000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();
    }
}
