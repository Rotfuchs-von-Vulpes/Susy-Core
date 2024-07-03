package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group15;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BATCH_REACTOR_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ROASTER_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.AntimonyDross;
import static supersymmetry.common.materials.SusyMaterials.AntimonyIIISulfide;

public class AntimonyChain {
    public static void init() {
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AntimonyDross.getFluid(720))
                .fluidInputs(Chlorine.getFluid(6000))
                .output(dust, Antimony, 2)
                .output(dust, MagnesiumChloride, 6)
                .output(dust, CalciumChloride, 3)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AntimonyIIISulfide, 5)
                .input("dustAnyPurityCarbon", 3)
                .fluidInputs(Oxygen.getFluid(6000))
                .output(dust, Antimony, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();
    }
}
