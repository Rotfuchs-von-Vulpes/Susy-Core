package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.MaterialStack;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.api.recipes.SuSyRecipeMaps;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;

public class ArsenicChain {
    public static void init() {
        //ROAST RECOVERY OF As2O3 (75% EFFICIENCY)
//COBALTITE MODIFICATION
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Cobaltite)}, new FluidStack[]{Oxygen.getFluid(3000)});

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Cobaltite, 2)
                .fluidInputs(Oxygen.getFluid(3000 + 4000 + 2000))
                .output(dust, CobaltOxide, 4)
                .chancedOutput(dust, ArsenicTrioxide, 5, 7500, 0)
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .blastFurnaceTemp(1200)
                .duration(120)
                .EUt(120)
                .buildAndRegister();

//SPERRYLITE ROASTING
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Sperrylite)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, RoastedSperrylite)
                .chancedOutput(dust, ArsenicTrioxide, 5, 7500, 0)
                .blastFurnaceTemp(1200)
                .duration(120)
                .EUt(120)
                .buildAndRegister();

//REALGAR ROASTING
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Realgar)
                .fluidInputs(Oxygen.getFluid(6000 + 8000))
                .chancedOutput(dust, ArsenicTrioxide, 10, 7500, 0)
                .fluidOutputs(SulfurDioxide.getFluid(4000))
                .blastFurnaceTemp(1200)
                .duration(240)
                .EUt(120)
                .buildAndRegister();

//ARSENOPYRITE ROASTING
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Arsenopyrite, 2)
                .fluidInputs(Oxygen.getFluid(3000 + 4000 + 3000))
                .output(dust, IronIIIOxide, 5)
                .chancedOutput(dust, ArsenicTrioxide, 5, 7500, 0)
                .fluidOutputs(SulfurDioxide.getFluid(2000))
                .blastFurnaceTemp(1200)
                .duration(240)
                .EUt(120)
                .buildAndRegister();

//NOTE: ENARGITE AND PROUSTITE CANNOT BE PYROMETALLURGICALLY TREATED TO FORM SIGNIFICANT QUANTITES OF ARSENIC TRIOXIDE.

//ARSENOPYRITE AND COBALTITE ACID LEACHING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Cobaltite, 3)
                .fluidInputs(NitricAcid.getFluid(13000))
                .fluidInputs(DistilledWater.getFluid(3000))
                .output(dust, Sulfur, 3)
                .fluidOutputs(CobaltiteLeachSolution.getFluid(1000))
                .fluidOutputs(NitricOxide.getFluid(7000))
                .duration(240)
                .EUt(480)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Cobalt)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(CobaltiteLeachSolution.getFluid(1000))
                .output(dust, Cobalt, 3)
                .fluidOutputs(Oxygen.getFluid(3000))
                .fluidOutputs(AcidicArsenateVSolution.getFluid(1000))
                .duration(240)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Arsenopyrite, 3)
                .fluidInputs(NitricAcid.getFluid(13000))
                .fluidInputs(DistilledWater.getFluid(3000))
                .output(dust, Sulfur, 3)
                .fluidOutputs(ArsenopyriteLeachSolution.getFluid(1000))
                .fluidOutputs(NitricOxide.getFluid(7000))
                .duration(240)
                .EUt(480)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(stick, Iron)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(ArsenopyriteLeachSolution.getFluid(1000))
                .output(dust, Iron, 3)
                .fluidOutputs(Oxygen.getFluid(3000))
                .fluidOutputs(AcidicArsenateVSolution.getFluid(1000))
                .duration(240)
                .EUt(480)
                .buildAndRegister();

//ARSENATE PROCESSING
        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(AcidicArsenateVSolution.getFluid(2000))
                .output(dust, ArsenicVOxide, 21)
                .fluidOutputs(Steam.getFluid(15000))
                .fluidOutputs(NitrogenDioxide.getFluid(12000))
                .fluidOutputs(Oxygen.getFluid(6000))
                .duration(120)
                .EUt(360)
                .buildAndRegister();

//ARSENIC OXIDES REDUCTION
        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityCarbon", 3)
                .input(dust, ArsenicTrioxide, 5)
                .output(dust, Arsenic, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(3000))
                .duration(30)
                .EUt(16)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input("dustAnyPurityCarbon", 5)
                .input(dust, ArsenicVOxide, 7)
                .output(dust, Arsenic, 2)
                .fluidOutputs(CarbonMonoxide.getFluid(5000))
                .duration(30)
                .EUt(30)
                .buildAndRegister();

//PROUSTITE ALKALINE LEACHING (90% EFFICIENT)
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Proustite, 7)
                .input(dust, Salt, 6)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidInputs(DistilledWater.getFluid(5000))
                .output(dust, SilverChloride, 6) //TO SILVER PROCESSING
                .fluidOutputs(ProustiteAlkalineLeachSolution.getFluid(1000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

//ENARGITE ALKALINE SULFIDE LEACHING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Enargite, 14)
                .input(dust, SodiumSulfide, 9)
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(4000))
                .output(dust, EnargiteResidue, 6)
                .fluidOutputs(EnargiteSulfideLeachSolution.getFluid(1000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

//SEPARATION OF ARSENIC FROM ANTIMONY
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ProustiteAlkalineLeachSolution.getFluid(2000))
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, ArsenicIIISulfide, 5)
                .fluidOutputs(HydrogenSulfide.getFluid(3000))
                .fluidOutputs(DilutedSaltwater.getFluid(6000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(EnargiteSulfideLeachSolution.getFluid(2000))
                .fluidInputs(HydrochloricAcid.getFluid(6000))
                .output(dust, ArsenicVSulfide, 7)
                .fluidOutputs(HydrogenSulfide.getFluid(4500))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

//REDUCTION OF ARSENIC SULFIDES
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ArsenicIIISulfide, 5)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, Arsenic, 2)
                .fluidOutputs(HydrogenSulfide.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ArsenicVSulfide, 5)
                .fluidInputs(Hydrogen.getFluid(10000))
                .output(dust, Arsenic, 2)
                .fluidOutputs(HydrogenSulfide.getFluid(5000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ArsenicVSulfide, 7)
                .fluidInputs(Oxygen.getFluid(15000))
                .output(dust, ArsenicVOxide, 7)
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ArsenicIIISulfide, 5)
                .fluidInputs(Oxygen.getFluid(9000))
                .output(dust, ArsenicTrioxide, 5)
                .fluidOutputs(SulfurDioxide.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//SEMICONDUCTOR GRADE ARSENIC
//ARSENIC TRICHLORIDE DISTILLATION
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, ArsenicTrioxide, 5)
                .fluidInputs(HydrogenChloride.getFluid(6500))
                .fluidOutputs(CrudeArsenicTrichloride.getFluid(2000))
                .fluidOutputs(Water.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Arsenic)
                .fluidInputs(Chlorine.getFluid(3000))
                .fluidOutputs(CrudeArsenicTrichloride.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrudeArsenicTrichloride.getFluid(2000))
                .fluidOutputs(ArsenicTrichloride.getFluid(2000))
                .fluidOutputs(SulfurDichloride.getFluid(250))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfurDichloride.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, Sulfur)
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ArsenicTrichloride.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(dust, HighPurityArsenic)
                .fluidOutputs(HydrogenChloride.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ARC_FURNACE_RECIPES.recipeBuilder()
                .input("dustAnyPuritySodium", 3)
                .input(dust, HighPurityArsenic)
                .output(dust, SodiumArsenide, 4)
                .duration(120)
                .EUt(120)
                .buildAndRegister();

//Arsine gas is used for chemical vapor deposition of high purity arsenic.
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumArsenide, 4)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, SodiumHydroxide, 9)
                .fluidOutputs(Arsine.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//BROMINE REGENERATION
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumBromide, 2)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(SodiumBromideSolution.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumBromideSolution.getFluid(100))
                .fluidInputs(Chlorine.getFluid(100))
                .fluidOutputs(Bromine.getFluid(100))
                .fluidOutputs(SaltWater.getFluid(100))
                .duration(6)
                .EUt(30)
                .buildAndRegister();

//ROASTED ORE PROCESSING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RoastedSperrylite)
                .fluidInputs(HydrochloricAcid.getFluid(500))
                .output(dust, Platinum)
                .fluidOutputs(SperryliteWaste.getFluid(750))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SperryliteWaste.getFluid(6000))
                .notConsumable(stick, Nickel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .output(dust, Cobalt)
                .output(dust, Nickel)
                .fluidOutputs(Chlorine.getFluid(4000))
                .fluidOutputs(Water.getFluid(6000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

//LEACH RESIDUE PROCESSING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, EnargiteResidue, 3)
                .fluidInputs(NitricAcid.getFluid(8000))
                .output(dustSmall, Gold)
                .fluidOutputs(NitrogenDioxide.getFluid(2000))
                .fluidOutputs(AcidicCopperSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(AcidicCopperSolution.getFluid(2000))
                .output(dust, CopperSulfate, 24)
                .fluidOutputs(Steam.getFluid(8000 + 2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(4000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();
    }
}
