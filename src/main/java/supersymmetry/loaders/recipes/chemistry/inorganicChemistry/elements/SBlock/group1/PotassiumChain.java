package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group1;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PotassiumChain {
    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .input(dust, PotashConcentrate, 8)
                .fluidInputs(Brine.getFluid(2000))
                .fluidOutputs(ImpurePotashSlurry.getFluid(2000))
                .EUt(30)
                .duration(40)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(ImpurePotashSlurry.getFluid(2000))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .notConsumable(dust, NHexadecylammoniumAcetate)
                .fluidOutputs(SupersaturatedBrine.getFluid(1000))
                .fluidOutputs(PotashSlurry.getFluid(1000))
                .EUt(480)
                .duration(40)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(PotashSlurry.getFluid(1000))
                .output(dust, RockSalt, 16)
                .fluidOutputs(Brine.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SupersaturatedBrine.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(Brine.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, WoodAsh, 10)
                .output(dust, DarkAsh, 9)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(PotassiumCarbonateSolution.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumCarbonateSolution.getFluid(1000))
                .output(dust, PotassiumCarbonate, 6)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PotassiumCarbonate, 6)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(PotassiumChlorideSolution.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Kainite, 11)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(KainiteLeach.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(KainiteLeach.getFluid(1000))
                .output(dust, MagnesiumSulfate, 6)
                .fluidOutputs(PotassiumChlorideSolution.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Carnallite, 11)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(CarnalliteLeach.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(CarnalliteLeach.getFluid(1000))
                .output(dust, MagnesiumChloride, 3)
                .fluidOutputs(PotassiumChlorideSolution.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PotassiumSulfate, 6)
                .output(dust, Potash, 2)
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PotassiumSulfate, 7)
                .input("dustAnyPurityCarbon", 4)
                .output(dust, PotassiumSulfide, 3)
                .fluidOutputs(CarbonDioxide.getFluid(4000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PotassiumSulfide, 3)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, Potash, 3)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input("dustAnyPuritySodium")
                .fluidInputs(RockSalt.getFluid(288))
                .fluidOutputs(PotassiumSaltMixture.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumSaltMixture.getFluid(1000))
                .output(dust, Salt, 2)
                .fluidOutputs(Potassium.getFluid(144))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, PotashConcentrate, 8)
                .output(dust, RockSalt, 2)
                .EUt(30)
                .duration(200)
                .buildAndRegister();
    }
}
