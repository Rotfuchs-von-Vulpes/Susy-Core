package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.combustibles;

public class MagnesiumChain {
    public static void init() {
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Magnesite, 5)
                .output(dust, Magnesia, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Dolomite, 10)
                .output(dust, Magnesia, 2)
                .output(dust, Quicklime, 2)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Magnesia, 4)
                .input(dust, Quicklime, 4)
                .input(dust, Silicon, 1)
                .output(dust, CalciumOrthosilicate, 7)
                .fluidOutputs(Magnesium.getFluid(288))
                .EUt(30)
                .duration(200)
                .blastFurnaceTemp(1370)
                .buildAndRegister();

        for (Utils.CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            BLAST_RECIPES.recipeBuilder()
                    .input(dust, Magnesia, 2)
                    .inputs(combustible.name)
                    .output(dust, Magnesium)
                    .outputs(combustible.byproduct)
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .EUt(120)
                    .duration(20 * combustible.duration)
                    .blastFurnaceTemp(2500)
                    .buildAndRegister();
        }

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, CalciumOrthosilicate, 7)
                .output(dust, SiliconDioxide, 3)
                .output(dust, Quicklime, 4)
                .EUt(30)
                .duration(120)
                .buildAndRegister();

//IG FARBEN CHLORINATION
        for (Utils.CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            REACTION_FURNACE_RECIPES.recipeBuilder()
                    .input(dust, Magnesia, 2)
                    .inputs(combustible.name)
                    .fluidInputs(Chlorine.getFluid(2000))
                    .output(dust, MagnesiumChloride, 3)
                    .outputs(combustible.byproduct)
                    .fluidOutputs(CarbonDioxide.getFluid(1000))
                    .EUt(30)
                    .duration(120)
                    .buildAndRegister();
        }

//MPLC CHLORINATION
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Magnesite, 5)
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, MagnesiumChloride, 3)
                .fluidOutputs(CarbonDioxide.getFluid(2000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Magnesite, 5)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(MagnesiumChlorideSolution.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Magnesia, 2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, MagnesiumHydroxide, 5)
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, MagnesiumHydroxide, 5)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidOutputs(MagnesiumChlorideSolution.getFluid(2000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(MagnesiumChlorideSolution.getFluid(2000))
                .output(dust, MagnesiumChloride, 3)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, MagnesiumSulfate, 6)
                .output(dust, Magnesia, 2)
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Kieserite, 7)
                .output(dust, MagnesiumSulfate, 6)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Langbeinite, 24)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(LangbeiniteLeach.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(LangbeiniteLeach.getFluid(1000))
                .output(dust, MagnesiumSulfate, 12)
                .fluidOutputs(PotassiumSulfateSolution.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumSulfateSolution.getFluid(1000))
                .output(dust, PotassiumSulfate, 7)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(30)
                .duration(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Polyhalite, 32)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, CalciumSulfate, 12)
                .fluidOutputs(PolyhaliteLeach.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(PolyhaliteLeach.getFluid(1000))
                .output(dust, MagnesiumSulfate, 6)
                .fluidOutputs(PotassiumSulfateSolution.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

//QMC PROCESS
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(MagnesiumChlorideSolution.getFluid(1000))
                .fluidInputs(EthyleneGlycol.getFluid(3000))
                .fluidOutputs(HydratedMagnesiumChlorideGlycolate.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(HydratedMagnesiumChlorideGlycolate.getFluid(1000))
                .fluidOutputs(MagnesiumChlorideGlycolate.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(MagnesiumChlorideGlycolate.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(6000))
                .output(dust, MagnesiumChlorideAmmoniate, 9)
                .fluidOutputs(ImpureEthyleneGlycol.getFluid(3000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(ImpureEthyleneGlycol.getFluid(3000))
                .chancedOutput(dust, CalciumChloride, 3, 500, 0)
                .fluidOutputs(EthyleneGlycol.getFluid(2900))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Ammonia.getFluid(500))
                .fluidInputs(Methanol.getFluid(1000))
                .fluidOutputs(SaturatedAmmoniacalMethanol.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, MagnesiumChlorideAmmoniate, 9)
                .fluidInputs(SaturatedAmmoniacalMethanol.getFluid(1000))
                .output(dust, WashedMagnesiumChlorideAmmoniate, 9)
                .fluidOutputs(ImpureSaturatedAmmoniacalMethanol.getFluid(1000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureSaturatedAmmoniacalMethanol.getFluid(1000))
                .fluidOutputs(EthyleneGlycol.getFluid(100))
                .fluidOutputs(Methanol.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(500))
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, MagnesiumChlorideAmmoniate, 9)
                .output(dust, PurifiedMagnesiumChloride, 3)
                .fluidOutputs(Ammonia.getFluid(6000))
                .EUt(480)
                .duration(200)
                .buildAndRegister();
    }
}
