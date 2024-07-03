package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group16;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.AUTOCLAVE_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.wireFine;
import static supersymmetry.api.recipes.SuSyRecipeMaps.DRYER_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.PRESSURE_SWING_ADSORBER_RECIPES;
import static supersymmetry.common.item.SuSyMetaItems.ZEOLITE_MEMBRANE;
import static supersymmetry.common.item.SuSyMetaItems.ZEOLITE_MEMBRANE_SUPPORT;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.materials.SusyMaterials.Zeolite13X;

public class OxygenChain {
    public static void init() {
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Aluminium, 8)
                .circuitMeta(8)
                .output(ZEOLITE_MEMBRANE_SUPPORT, 1)
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(RawMolecularSieve.getFluid(4000))
                .input(dust, Clay, 8)
                .fluidOutputs(Zeolite13XSolution.getFluid(4000))
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(Zeolite13XSolution.getFluid(4000))
                .output(dust, Zeolite13X, 8)
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(1000))
                .input(dust, Zeolite13X, 4)
                .input(ZEOLITE_MEMBRANE_SUPPORT, 1)
                .output(ZEOLITE_MEMBRANE, 1)
                .duration(180)
                .EUt(30)
                .buildAndRegister();

        PRESSURE_SWING_ADSORBER_RECIPES.recipeBuilder()
                .fluidInputs(Air.getFluid(10000))
                .notConsumable(ZEOLITE_MEMBRANE)
                .fluidOutputs(Nitrogen.getFluid(7808))
                .fluidOutputs(Oxygen.getFluid(2095))
                .duration(100)
                .EUt(64)
                .buildAndRegister();
    }
}
