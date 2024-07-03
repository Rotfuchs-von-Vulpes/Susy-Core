package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group1;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustImpure;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BATCH_REACTOR_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ROASTER_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.HaliteLeach;

public class SodiumChain {
    public static void init() {
        //TRONA
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Trona, 28)
                .output(dust, SodaAsh, 18)
                .fluidOutputs(Steam.getFluid(5000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 6)
                .input("dustAnyPurityCarbon", 2)
                .output(dust, Sodium, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

//IMPURE HALITE PURIFICATION
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dustImpure, Salt, 2)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(HaliteLeach.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodaAsh)
                .fluidInputs(HaliteLeach.getFluid(8000))
                .chancedOutput(dust, Barite, 5, 1667, 0)
                .output(dust, Clay)
                .fluidOutputs(SaltWater.getFluid(8000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();
    }
}
