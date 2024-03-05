package supersymmetry.loaders.recipes.biology;

import gregtech.api.recipes.ModHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Glue;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_BALL;
import static gregtech.common.items.MetaItems.STICKY_RESIN;
import static gregtechfoodoption.GTFOMaterialHandler.RubberSap;
import static net.minecraft.init.Items.SLIME_BALL;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static supersymmetry.common.materials.SusyMaterials.Resin;

public class ResinChain {
    public static void init() {
//REMOVALS
        ModHandler.removeFurnaceSmelting(new ItemStack(SLIME_BALL));
// Sticky Resin * 1
        removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES, new ItemStack[]{SHAPE_MOLD_BALL.getStackForm()}, new FluidStack[]{RubberSap.getFluid(100)});

//ADDITIONS
        ModHandler.addShapedRecipe("gregtech:resin_item", STICKY_RESIN.getStackForm(4),
                "B", "M",
                'B', FluidUtil.getFilledBucket(Resin.getFluid(1000)),
                'M', SHAPE_MOLD_BALL.getStackForm());

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(Resin.getFluid(100))
                .fluidOutputs(Glue.getFluid(75))
                .duration(15)
                .EUt(30)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(Resin.getFluid(250))
                .output(STICKY_RESIN)
                .duration(20)
                .EUt(2)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(STICKY_RESIN)
                .fluidOutputs(Resin.getFluid(250))
                .duration(40)
                .EUt(8)
                .buildAndRegister();
    }
}
