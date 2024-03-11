package supersymmetry.loaders.recipes.chemistry.elements;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class SulfurChain {
    public static void init() {
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Pyrite, 2)
                .output(dust, IronIIISulfate)
                .output(dust, Sulfur)
                .duration(80)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, IronIIISulfate)
                .output(dust, BandedIron)
                .fluidOutputs(SulfurTrioxide.getFluid(3000))
                .duration(160)
                .EUt(7)
                .buildAndRegister();
    }
}
