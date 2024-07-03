package supersymmetry.loaders.recipes.chemistry.inorganicChemistry;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;

import static gregtech.api.recipes.RecipeMaps.BLAST_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.CupricHydrogenArsenite;
import static gregtechfoodoption.GTFOMaterialHandler.SodiumArseniteSolution;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BATCH_REACTOR_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Dyes {
    public static void init() {
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, LeadOxide, 2)
                .fluidInputs(NitricAcid.getFluid(2000))
                .output(dust, LeadNitrate, 9)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, ManganeseIIOxide)
                .input(dust, IronIIIOxide)
                .output(dust, Sienna, 2)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        ModHandler.addSmeltingRecipe(new UnificationEntry(dust, Sienna), OreDictUnifier.get(dust, BurntSienna));

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ArsenicTrioxide, 5)
                .fluidInputs(SodaAshSolution.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(SodiumArseniteSolution.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Copper, 2)
                .fluidInputs(SulfuricAcid.getFluid(2000))
                .fluidInputs(SodiumArseniteSolution.getFluid(1000))
                .outputs(CupricHydrogenArsenite.getItemStack(12))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Alumina, 5)
                .input(dust, CobaltOxide, 2)
                .output(dust, CobaltAluminate, 7)
                .blastFurnaceTemp(1100)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, LeadNitrate, 9)
                .fluidInputs(SodiumChromateSolution.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(SodiumNitrateSolution.getFluid(2000))
                .output(dust, LeadChromate, 6)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

    }
}
