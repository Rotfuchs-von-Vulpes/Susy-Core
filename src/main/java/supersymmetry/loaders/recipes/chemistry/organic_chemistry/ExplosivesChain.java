package supersymmetry.loaders.recipes.chemistry.organic_chemistry;

import static gregtech.api.unification.material.Materials.GlycerylTrinitrate;
import static gregtech.common.items.MetaItems.DYNAMITE;
import static net.minecraft.init.Items.PAPER;
import static net.minecraft.init.Items.STRING;
import static supersymmetry.api.recipes.SuSyRecipeMaps.WEAPONS_FACTORY_RECIPES;

public class ExplosivesChain {
    public static void init() {
        WEAPONS_FACTORY_RECIPES.recipeBuilder()
                .input(PAPER)
                .input(STRING)
                .fluidInputs(GlycerylTrinitrate.getFluid(100))
                .outputs(DYNAMITE.getStackForm(4))
                .EUt(30)
                .duration(60)
                .buildAndRegister();
    }
}
