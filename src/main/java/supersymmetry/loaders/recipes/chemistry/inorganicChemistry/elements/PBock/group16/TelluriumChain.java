package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group16;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;

public class TelluriumChain {
    public static void init() {
        BLAST_RECIPES.recipeBuilder()
                .input(dust, TelluriumResidue) // 0.25 Na2TeO4, 2 Ag/Au
                .output(dust, RawElectrum, 2)
                .chancedOutput(dust, TelluriumSlag, 2500, 0)
                .blastFurnaceTemp(1400)
                .duration(120)
                .EUt(240)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumSulfiteSolution.getFluid(1000))
                .output(dust, SodiumSulfite, 6)
                .fluidOutputs(Water.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, TelluriumSlag)
                .fluidInputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(TelluriumLiquor.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumSulfite, 6)
                .fluidInputs(TelluriumLiquor.getFluid(1000)) // 1 H2TeO4, 1 Na2SO4, 1 H2O
                .output(dust, TelluriumDioxide, 3)
                .fluidOutputs(SodiumSulfateSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, TelluriumDioxide, 3)
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .fluidOutputs(SodiumTelluriteSolution.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

// 4OH− −→ 2H2O + O2 + 4e−
// TeO3 2− + 3H2O + 4e− −→ Te + 6OH−
// TeO3 2− + H2O −→ O2 + 2OH-

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, StainlessSteel)
                .fluidInputs(SodiumTelluriteSolution.getFluid(3000))
                .chancedOutput(dust, Tellurium, 5000, 0)
                .fluidOutputs(SodiumHydroxideSolution.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(2000))
                .duration(600)
                .EUt(120)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(plate, Tellurium)
                .fluidInputs(SodiumTelluriteSolution.getFluid(3000))
                .output(dust, Tellurium)
                .fluidOutputs(SodiumHydroxideSolution.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(2000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

// Further refining

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .input(dust, Tellurium)
                .chancedOutput(dust, HighPurityTellurium, 9900, 0)
                .duration(1000)
                .EUt(120)
                .buildAndRegister();

        ZONE_REFINER_RECIPES.recipeBuilder()
                .input(ingot, Tellurium)
                .chancedOutput(ingot, HighPurityTellurium, 9900, 0)
                .duration(120)
                .EUt(30)
                .buildAndRegister();
    }
}
