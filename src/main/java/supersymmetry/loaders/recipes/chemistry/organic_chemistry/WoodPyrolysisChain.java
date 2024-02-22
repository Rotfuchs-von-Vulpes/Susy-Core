package supersymmetry.loaders.recipes.chemistry.organic_chemistry;

import net.minecraft.item.ItemStack;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.Guaiacol;
import static net.minecraft.init.Items.COAL;
import static supersymmetry.common.item.SuSyMetaItems.BITUMEN;
import static supersymmetry.common.materials.SusyMaterials.*;

public class WoodPyrolysisChain {
    public static void init() {
        PYROLYSE_RECIPES.recipeBuilder()
                .input("logWood", 16)
                .outputs(new ItemStack(COAL, 8, 1))
                .fluidOutputs(UnscrubbedWoodGas.getFluid(3000))
                .fluidOutputs(WoodVinegar.getFluid(2000))
                .fluidOutputs(Creosote.getFluid(2000))
                .duration(320)
                .EUt(64)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input("dustWood", 24)
                .output(dust, WoodAsh, 20)
                .fluidOutputs(UnscrubbedWoodGas.getFluid(3000))
                .duration(320)
                .EUt(64)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input("treeLeaves", 24)
                .output(dust, WoodAsh, 10)
                .duration(240)
                .EUt(64)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .fluidInputs(FermentedBiomass.getFluid(5000))
                .output(dust, DarkAsh, 8)
                .fluidOutputs(UnscrubbedWoodGas.getFluid(3000))
                .duration(320)
                .EUt(64)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .fluidInputs(Biomass.getFluid(3000))
                .output(dust, DarkAsh, 8)
                .fluidOutputs(UnscrubbedWoodGas.getFluid(3000))
                .duration(320)
                .EUt(64)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UnscrubbedWoodGas.getFluid(1000))
                .fluidInputs(Water.getFluid(200))
                .fluidOutputs(Creosote.getFluid(50))
                .fluidOutputs(WoodGas.getFluid(2000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(WoodVinegar.getFluid(1000))
                .fluidOutputs(AceticAcid.getFluid(100))
                .fluidOutputs(Water.getFluid(700))
                .fluidOutputs(Methanol.getFluid(100))
                .fluidOutputs(Acetone.getFluid(100))
                .duration(200)
                .EUt(24)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .chancedOutput(BITUMEN, 5000, 0)
                .fluidInputs(Creosote.getFluid(1000))
                .fluidOutputs(Creosol.getFluid(400))
                .fluidOutputs(Guaiacol.getFluid(250))
                .fluidOutputs(Xylenol.getFluid(50))
                .fluidOutputs(Cresol.getFluid(100))
                .fluidOutputs(Phenol.getFluid(100))
                .duration(200)
                .EUt(48)
                .buildAndRegister();
    }
}
