package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustTiny;
import static gregtechfoodoption.GTFOMaterialHandler.HydrogenCyanide;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumStearate;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolymethacrylateChain {
    public static void init() {
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenCyanide.getFluid(50))
                .fluidInputs(Acetone.getFluid(50))
                .fluidOutputs(AcetoneCyanohydrin.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AcetoneCyanohydrin.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, MethacrylamideSulfate, 20)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, MethacrylamideSulfate, 20)
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(MethylMethacrylate.getFluid(1000))
                .output(dust, AmmoniumBisulfate, 11)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Route 2

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, MolybdenumTrioxide)
                .fluidInputs(Isobutylene.getFluid(50))
                .fluidInputs(Oxygen.getFluid(100))
                .fluidOutputs(GaseousMethacroleinMixture.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, PurifiedMolybdenumTrioxide, 48)
                .fluidInputs(PhosphoricAcid.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(28000))
                .output(dust, PhosphomolybdicAcid)
                .duration(500)
                .EUt(480)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, PhosphomolybdicAcid)
                .fluidInputs(GaseousMethacroleinMixture.getFluid(100))
                .fluidInputs(Oxygen.getFluid(50))
                .fluidOutputs(GaseousMethacrylicAcidMixture.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder() // MOVE TO QUENCHER
                .fluidInputs(GaseousMethacrylicAcidMixture.getFluid(2000)) // 1000L water, 750L methacrylic acid, 250L methacrolein
                .fluidInputs(Water.getFluid(750))
                .fluidOutputs(MethacrylicAcidSolution.getFluid(1500))
                .fluidOutputs(GaseousMethacroleinResidue.getFluid(1250))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(GaseousMethacroleinResidue.getFluid(1250))
                .fluidInputs(Water.getFluid(250))
                .fluidInputs(AceticAcid.getFluid(1000))
                .fluidOutputs(AbsorbedMethacrolein.getFluid(2500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AbsorbedMethacrolein.getFluid(2500))
                .fluidOutputs(DilutedAceticAcid.getFluid(2000))
                .fluidOutputs(GaseousMethacroleinMixture.getFluid(500))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethacrylicAcidSolution.getFluid(2000))
                .fluidOutputs(MethacrylicAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(250)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(MethacrylicAcid.getFluid(50))
                .fluidInputs(Methanol.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(MethylMethacrylate.getFluid(50))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// Polymerization

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(MethylMethacrylate.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(SodiumStearate.getFluid(100))
                .fluidOutputs(MethylMethacrylateEmulsion.getFluid(2000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylMethacrylateEmulsion.getFluid(2000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(PolymethylMethacrylateSolution.getFluid(2000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PolymethylMethacrylateSolution.getFluid(2000))
                .output(dust, PMMA)
                .duration(300)
                .EUt(30)
                .buildAndRegister();
    }
}
