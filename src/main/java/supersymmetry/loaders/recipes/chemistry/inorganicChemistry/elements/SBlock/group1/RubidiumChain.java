package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group1;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.HeatedWater;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class RubidiumChain {
    public static void init() {
        // From lepidolite

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dust, AlkaliAlumMix)
                .fluidOutputs(HeatedWater.getFluid(10000))
                .chancedOutput(dust, PotassiumAlum, 12, 9000, 0)
                .chancedOutput(dust, RubidiumAlum, 12, 500, 0)
                .EUt(30)
                .duration(800)
                .buildAndRegister();

        // Refining into metal

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RubidiumAlum, 12)
                .notConsumable(spring, Cupronickel)
                .fluidInputs(SodiumHydroxideSolution.getFluid(4000))
                .output(dust, AluminiumHydroxide, 7)
                .fluidOutputs(RubidiumHydroxideSolution.getFluid(4000))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(RubidiumHydroxideSolution.getFluid(4000))
                .output(dust, RubidiumHydroxide, 3)
                .fluidOutputs(Water.getFluid(4000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, RubidiumHydroxide, 3)
                .input("dustAnyPurityMagnesium")
                .output(dust, Rubidium)
                .output(dust, MagnesiumHydroxide, 5)
                .EUt(30)
                .duration(80)
                .buildAndRegister();
    }
}
