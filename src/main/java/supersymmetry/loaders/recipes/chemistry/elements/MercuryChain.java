package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.api.fluids.SusyFluidStorageKeys;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustImpure;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;
public class MercuryChain {
    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Cinnabar, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Cinnabar.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Cinnabar.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(dust, PotassiumButylXanthate)
                .notConsumable(dust, LeadNitrate, 9)
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(1000))
                .fluidOutputs(Cinnabar.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Cinnabar.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .output(dust, Cinnabar, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Cinnabar)
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(Mercury.getFluid(1000))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();
    }
}
