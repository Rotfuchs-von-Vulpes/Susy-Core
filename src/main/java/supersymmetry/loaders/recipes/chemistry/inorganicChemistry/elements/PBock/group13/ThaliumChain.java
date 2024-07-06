package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group13;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class ThaliumChain {
    public static void init() {
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ThalliumIChloride, 4)
                .fluidInputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(AcidicThalliumSulfateSolution.getFluid(1000)) // 1 Tl2SO4, 1 H2O, 2 HCl
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AcidicThalliumSulfateSolution.getFluid(1000))
                .fluidOutputs(ThalliumSulfateSolution.getFluid(1000))
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Platinum)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(ThalliumSulfateSolution.getFluid(1000))
                .output(dust, Thallium)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();
    }
}
