package supersymmetry.loaders.recipes.chemistry;

import net.minecraft.item.ItemStack;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static net.minecraft.init.Items.PAPER;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.STEM_COTTON;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PaperChain {
    public static void init() {
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Wood)
                .fluidInputs(WhiteLiquor.getFluid(1000))
                .output(dust, RawCellulose)
                .fluidOutputs(BlackLiquor.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .inputs(STEM_COTTON.getStackForm(5))
                .fluidInputs(WhiteLiquor.getFluid(1000))
                .output(dust, RawCellulose)
                .fluidOutputs(BlackLiquor.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, RawCellulose)
                .fluidInputs(Water.getFluid(250))
                .output(dust, Cellulose)
                .fluidOutputs(BlackLiquor.getFluid(250))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Cellulose)
                .fluidInputs(Water.getFluid(1000))
                .outputs(new ItemStack(PAPER, 8))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Cellulose)
                .fluidInputs(DistilledWater.getFluid(1000))
                .outputs(new ItemStack(PAPER, 8))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(BlackLiquor.getFluid(1250))
                .fluidOutputs(ConcentratedBlackLiquor.getFluid(1000))
                .fluidOutputs(Resin.getFluid(250))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Carbon, 2)
                .fluidInputs(ConcentratedBlackLiquor.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .fluidOutputs(GreenLiquor.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .fluidInputs(GreenLiquor.getFluid(1000))
                .output(dust, Limestone, 5)
                .fluidOutputs(WhiteLiquor.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfide, 3)
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(WhiteLiquor.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();
    }
}
