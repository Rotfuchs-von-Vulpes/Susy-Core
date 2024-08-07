package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group9;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ROASTER_RECIPES;
import static supersymmetry.loaders.recipes.Utils.combustibles;

public class CobaltChain {
    public static void init() {
        for (Utils.CarbonSource combustible : combustibles) {
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, CobaltOxide, 2)
                    .input(combustible.name.getItem(), combustible.equivalent(1))
                    .output(dust, Cobalt)
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .duration(120)
                    .EUt(120)
                    .buildAndRegister();
        }
    }
}
