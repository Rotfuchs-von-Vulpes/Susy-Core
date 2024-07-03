package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group1;

import static gregtech.api.recipes.RecipeMaps.BLAST_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.FIXED_BED_REACTOR_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.CeriumIIIOxide;
import static supersymmetry.common.materials.SusyMaterials.CeriumIVOxide;

public class HydrogenChein {
    public static void init() {
        BLAST_RECIPES.recipeBuilder()
                .input(dust, CeriumIVOxide, 12)
                .output(dust, CeriumIIIOxide, 10)
                .fluidOutputs(Oxygen.getFluid(2000))
                .EUt(1920)
                .blastFurnaceTemp(2273)
                .duration(20)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CeriumIIIOxide, 10)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, CeriumIVOxide, 12)
                .fluidOutputs(Hydrogen.getFluid(4000))
                .EUt(1920)
                .duration(20)
                .buildAndRegister();
    }
}
