package supersymmetry.loaders.recipes.miscChains;

import static gregtech.api.recipes.RecipeMaps.EXTRACTOR_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.SHAPE_EXTRUDER_ROD;
import static supersymmetry.api.recipes.SuSyRecipeMaps.SINTERING_RECIPES;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.Syngas;

public class GraphiteElectrodeChain {
    public static void init() {
        //Nerf arc furnaces, add graphite rod chain
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(CoalTar.getFluid(1000))
                .input(dust, Coke, 4)
                .output(PITCH_BINDER, 4)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_EXTRUDER_ROD)
                .input(PITCH_BINDER)
                .output(RAW_ELECTRODE)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(RAW_ELECTRODE)
                .fluidInputs(Syngas.getFluid(100))
                .fluidInputs(Air.getFluid(100))
                .output(GRAPHITE_ELECTRODE)
                .fluidOutputs(CarbonDioxide.getFluid(50))
                .EUt(30)
                .duration(150)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(RAW_ELECTRODE)
                .fluidInputs(Methane.getFluid(100))
                .fluidInputs(Air.getFluid(100))
                .output(GRAPHITE_ELECTRODE)
                .fluidOutputs(CarbonDioxide.getFluid(50))
                .EUt(30)
                .duration(150)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(RAW_ELECTRODE)
                .fluidInputs(Syngas.getFluid(100))
                .fluidInputs(Oxygen.getFluid(80))
                .output(GRAPHITE_ELECTRODE)
                .fluidOutputs(CarbonDioxide.getFluid(50))
                .EUt(30)
                .duration(150)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(RAW_ELECTRODE)
                .fluidInputs(Methane.getFluid(100))
                .fluidInputs(Oxygen.getFluid(80))
                .output(GRAPHITE_ELECTRODE)
                .fluidOutputs(CarbonDioxide.getFluid(50))
                .EUt(30)
                .duration(150)
                .buildAndRegister();
    }
}
