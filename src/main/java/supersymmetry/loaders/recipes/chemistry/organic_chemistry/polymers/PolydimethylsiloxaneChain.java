package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolydimethylsiloxaneChain {
    public static void init() {
        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Chloromethane.getFluid(2000))
                .notConsumable(dust, CuprousOxide)
                .input(dust, Silicon)
                .fluidOutputs(OrganosiliconMixture.getFluid(2000))
                .duration(160)
                .EUt(480 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(OrganosiliconMixture.getFluid(1000))
                .fluidOutputs(Dimethyldichlorosilane.getFluid(800))
                .fluidOutputs(Methyltrichlorosilane.getFluid(100))
                .fluidOutputs(Methyldichlorosilane.getFluid(50))
                .fluidOutputs(Chlorotrimethylsilane.getFluid(50))
                .duration(400)
                .EUt(30 * 2)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Methyltrichlorosilane.getFluid(50))
                .duration(2)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Methyldichlorosilane.getFluid(50))
                .duration(2)
                .buildAndRegister();

        DUMPING.recipeBuilder()
                .fluidInputs(Chlorotrimethylsilane.getFluid(50))
                .duration(2)
                .buildAndRegister();

//Methyltrichlorosilane can be used as a water repellent when put on a surface with water
//Chlorotrimethylsilane has some uses but mostly in reactions that are not relevant to this

// PDMS & Silicone Rubber

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Dimethyldichlorosilane.getFluid(50))
                .fluidInputs(Water.getFluid(125))
                .fluidOutputs(ImpurePolydimethylsiloxaneMixture.getFluid(75))
                .fluidOutputs(HydrochloricAcid.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(ImpurePolydimethylsiloxaneMixture.getFluid(1500))
                .fluidOutputs(HydrochloricAcid.getFluid(500))
                .fluidOutputs(RawPolydimethylsiloxaneMixture.getFluid(1000))
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(RawPolydimethylsiloxaneMixture.getFluid(1000))
                .fluidInputs(Water.getFluid(500))
                .fluidOutputs(HydrochloricAcid.getFluid(500))
                .fluidOutputs(Polydimethylsiloxane.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(Polydimethylsiloxane.getFluid(1000))
                .fluidInputs(DiTertButylPeroxide.getFluid(50))
                .input(dust, SiliconDioxide)
                .fluidOutputs(SiliconeRubber.getFluid(144))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(Polydimethylsiloxane.getFluid(1000))
                .fluidInputs(DiTertButylPeroxide.getFluid(50))
                .input(dust, Carbon)
                .fluidOutputs(SiliconeRubber.getFluid(144))
                .duration(100)
                .EUt(480)
                .buildAndRegister();
    }
}
