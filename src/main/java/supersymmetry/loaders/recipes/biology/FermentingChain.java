package supersymmetry.loaders.recipes.biology;

import net.minecraft.item.ItemStack;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.items.MetaItems.BIO_CHAFF;
import static gregtechfoodoption.GTFOMaterialHandler.AppleCider;
import static net.minecraft.init.Items.SUGAR;
import static net.minecraft.init.Items.WHEAT_SEEDS;
import static supersymmetry.common.item.SuSyMetaItems.MALTED_GRAIN;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;

public class FermentingChain {
    public static void init() {
        PYROLYSE_RECIPES.recipeBuilder()
                .inputs(BIO_CHAFF.getStackForm(16))
                .fluidInputs(Water.getFluid(4000))
                .fluidOutputs(Biomass.getFluid(4000))
                .duration(320)
                .EUt(64)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .inputs(BIO_CHAFF.getStackForm(2))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Biomass.getFluid(1000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .fluidInputs(Biomass.getFluid(16000))
                .fluidOutputs(FermentedBiomass.getFluid(16000))
                .fluidOutputs(Methane.getFluid(10000))
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

//ETHANOL CHAIN

        AUTOCLAVE_RECIPES.recipeBuilder()
                .inputs(new ItemStack(WHEAT_SEEDS, 4))
                .fluidInputs(Water.getFluid(1000))
                .outputs(MALTED_GRAIN.getStackForm(4))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .inputs(MALTED_GRAIN.getStackForm(2))
                .input(dust, Wheat, 2)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Mash.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .inputs(MALTED_GRAIN.getStackForm(2))
                .circuitMeta(1)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Mash.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Wheat, 2)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(GrainSolution.getFluid(1000))
                .circuitMeta(4)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .fluidInputs(GrainSolution.getFluid(16000))
                .fluidOutputs(YeastSolution.getFluid(16000))
                .circuitMeta(1)
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .fluidInputs(Mash.getFluid(16000))
                .fluidInputs(GrainSolution.getFluid(1000))
                .fluidOutputs(ImpureEthanol.getFluid(16000))
                .circuitMeta(2)
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .inputs(new ItemStack(SUGAR, 24))
                .fluidInputs(Water.getFluid(16000))
                .fluidInputs(GrainSolution.getFluid(1000))
                .fluidOutputs(ImpureEthanol.getFluid(16000))
                .circuitMeta(3)
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureEthanol.getFluid(2000))
                .output(dust, Wood)
                .fluidOutputs(FuselOil.getFluid(20))
                .fluidOutputs(Water.getFluid(1280))
                .fluidOutputs(EthanolWaterAzeotrope.getFluid(700))
                .duration(50)
                .EUt(30)
                .buildAndRegister();

//EXTRACTIVE DISTILLATION
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(EthanolWaterAzeotrope.getFluid(700))
                .fluidInputs(Toluene.getFluid(10))
                .fluidOutputs(EntrainedEthanolWaterAzeotrope.getFluid(710))
                .duration(50)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(EntrainedEthanolWaterAzeotrope.getFluid(710))
                .fluidOutputs(Toluene.getFluid(10))
                .fluidOutputs(Water.getFluid(70))
                .fluidOutputs(Ethanol.getFluid(630))
                .duration(50)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(FuselOil.getFluid(1000))
                .fluidOutputs(IsoamylAlcohol.getFluid(615))
                .fluidOutputs(NButanol.getFluid(10))
                .fluidOutputs(IsobutylAlcohol.getFluid(155))
                .fluidOutputs(Water.getFluid(110))
                .fluidOutputs(NPropanol.getFluid(10))
                .fluidOutputs(EthanolWaterAzeotrope.getFluid(100))
                .duration(50)
                .EUt(30)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(8000))
                .fluidInputs(Oxygen.getFluid(4000))
                .fluidOutputs(Vinegar.getFluid(16000))
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .fluidInputs(Ethanol.getFluid(8000))
                .fluidInputs(Air.getFluid(12000))
                .fluidOutputs(Vinegar.getFluid(16000))
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .fluidInputs(ImpureEthanol.getFluid(16000))
                .fluidInputs(Oxygen.getFluid(4000))
                .fluidOutputs(Vinegar.getFluid(16000))
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

        FERMENTATION_VAT_RECIPES.recipeBuilder()
                .fluidInputs(ImpureEthanol.getFluid(16000))
                .fluidInputs(Air.getFluid(12000))
                .fluidOutputs(Vinegar.getFluid(16000))
                .duration(2400)
                .EUt(16)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Vinegar.getFluid(2000))
                .output(dust, Wood)
                .fluidOutputs(AceticAcid.getFluid(400))
                .fluidOutputs(Water.getFluid(1600))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AppleCider.getFluid(2000))
                .fluidOutputs(AceticAcid.getFluid(400))
                .fluidOutputs(Water.getFluid(1600))
                .duration(200)
                .EUt(30)
                .buildAndRegister();
    }
}
