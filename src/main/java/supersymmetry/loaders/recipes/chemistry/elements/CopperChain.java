package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.api.fluids.SusyFluidStorageKeys;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.recipes.RecipeMaps.DISTILLERY_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static supersymmetry.api.fluids.SusyFluidStorageKeys.IMPURE_SLURRY;
import static supersymmetry.api.fluids.SusyFluidStorageKeys.SLURRY;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.ANODE_SLIME_COPPER;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.*;

public class CopperChain {
    private static class CopperOre {
        Material name;
        Material impureSlurry;
        int amount_produced;
        boolean produces_iron;

        CopperOre(Material name, Material impureSlurry, int amount_produced, boolean produces_iron) {
            this.name = name;
            this.impureSlurry = impureSlurry;
            this.amount_produced = amount_produced;
            this.produces_iron = produces_iron;
        }
    }
    public static void init() {
        // Cupric Oxide Dust * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Tetrahedrite)}, new FluidStack[]{Oxygen.getFluid(3000)});
        // Cupric Oxide Dust * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Chalcopyrite), OreDictUnifier.get(dust, SiliconDioxide)}, new FluidStack[] {Oxygen.getFluid(3000)});

        //MALACHITE
        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Malachite, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Malachite.getFluid(IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Malachite.getFluid(IMPURE_SLURRY, 2000))
                .notConsumable(OreDictUnifier.get(dust, Quicklime))
                .notConsumable(OreDictUnifier.get(dust, PotassiumOctylHydroxamate))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .fluidOutputs(Malachite.getFluid(SLURRY, 1000))
                .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Malachite.getFluid(SLURRY, 1000))
                .output(dust, Malachite, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Malachite)
                .fluidInputs(SulfuricAcid.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(MalachiteLeach.getFluid(3000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(MalachiteLeach.getFluid(150))
                .fluidInputs(HydrogenPeroxideSolution.getFluid(5))
                .fluidOutputs(OxidizedMalachiteLeach.getFluid(150))
                .EUt(30)
                .duration(5)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(OxidizedMalachiteLeach.getFluid(3000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(300))
                .chancedOutput(dust, IronIIIHydroxide, 7, 1000, 0)
                .fluidOutputs(DilutedCopperSulfateSolution.getFluid(3300))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedCopperSulfateSolution.getFluid(3300))
                .output(dust, CopperSulfate, 12)
                .fluidOutputs(Water.getFluid(3300))
                .circuitMeta(1)
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedCopperSulfateSolution.getFluid(3300))
                .fluidOutputs(CopperSulfateSolution.getFluid(2000))
                .fluidOutputs(Water.getFluid(1300))
                .disableDistilleryRecipes()
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(MalachiteLeach.getFluid(3000))
                .output(dust, CopperSulfate, 8)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        CopperOre[] copperOres = {
                new CopperOre(Chalcopyrite, ImpureChalcopyriteSlurry, 1, true),
                new CopperOre(Bornite, ImpureBorniteSlurry, 5, true),
                new CopperOre(Chalcocite, ImpureChalcociteSlurry, 2, false)
        };

        for (CopperOre copperOre : copperOres) {
            MIXER_RECIPES.recipeBuilder()
                    .input(dustImpure, copperOre.name, 8)
                    .fluidInputs(DistilledWater.getFluid((copperOre.amount_produced * 1000) + 1000))
                    .fluidOutputs(copperOre.impureSlurry.getFluid((copperOre.amount_produced * 1000) + 1000))
                    .EUt(480)
                    .duration(80)
                    .buildAndRegister();

            if (copperOre.produces_iron) {
                FROTH_FLOTATION.recipeBuilder()
                        .fluidInputs(copperOre.impureSlurry.getFluid((copperOre.amount_produced * 1000) + 1000))
                        .notConsumable(dust, Quicklime)
                        .notConsumable(dust,SodiumEthylXanthate)
                        .notConsumable(SodiumCyanideSolution.getFluid(100))
                        .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                        .fluidOutputs(CopperConcentrateSlurry.getFluid(copperOre.amount_produced * 1000))
                        .fluidOutputs(PyriteSlurry.getFluid(1000))
                        .EUt(480)
                        .duration(80)
                        .buildAndRegister();
            } else {
                FROTH_FLOTATION.recipeBuilder()
                        .fluidInputs(copperOre.impureSlurry.getFluid( (copperOre.amount_produced * 1000) + 1000))
                        .notConsumable(dust, Quicklime)
                        .notConsumable(dust,SodiumEthylXanthate)
                        .notConsumable(SodiumCyanideSolution.getFluid(100))
                        .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                        .fluidOutputs(CopperConcentrateSlurry.getFluid(copperOre.amount_produced * 1000))
                        .fluidOutputs(GraniteTailingSlurry.getFluid(1000))
                        .EUt(480)
                        .duration(80)
                        .buildAndRegister();
            }
        }

        CLARIFIER.recipeBuilder()
                .fluidInputs(CopperConcentrateSlurry.getFluid(1000))
                .output(dust, CopperConcentrate, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(PyriteSlurry.getFluid(1000))
                .output(dust, Pyrite, 2)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        REVERBERATORY_FURNACE.recipeBuilder()
                .input(dust, CopperConcentrate)
                .chancedOutput(dust, CopperMatte, 9000, 0)
                .duration(80)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, CopperConcentrate)
                .notConsumable(pipeTinyFluid, StainlessSteel)
                .fluidInputs(Oxygen.getFluid(50))
                .fluidInputs(NaturalGas.getFluid(50))
                .output(dust, CopperMatte)
                .fluidOutputs(CopperMatteFlueGas.getFluid(500))
                .blastFurnaceTemp(1200)
                .EUt(480)
                .duration(10)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, Calcite, 5)
                .fluidInputs(CopperMatteFlueGas.getFluid(3000))
                .output(dust, CalciumSulfite, 5)
                .fluidOutputs(DesulfurizedFlueGas.getFluid(2000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, CopperMatte)
                .fluidInputs(Oxygen.getFluid(50))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .output(dust, CopperMatteFlueDust)
                .output(ingot, BlisterCopper)
                .EUt(480)
                .duration(10)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, CopperMatteFlueDust)
                .chancedOutput(dust, ArsenicTrioxide, 1000, 0)
                .chancedOutput(dust, AntimonyTrioxide, 1000, 0)
                .chancedOutput(dust, BismuthIIIOxide, 1000, 0)
                .chancedOutput(dust, TinIVOxide, 1000, 0)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(plate, BlisterCopper, 4)
                .notConsumable(plate, StainlessSteel, 4)
                .notConsumable(CopperSulfateSolution.getFluid(1000))
                .fluidInputs(DilutedSulfuricAcid.getFluid(320))
                .output(dust, Copper, 4)
                .chancedOutput(ANODE_SLIME_COPPER, 1000, 0)
                .fluidOutputs(NickelSulfateSolution.getFluid( 160))
                .EUt(480)
                .duration(40)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .fluidInputs(CopperMatteFlueGas.getFluid(1000))
                .notConsumable(ITEM_FILTER)
                .output(dust, CopperMatteFlueDust)
                .fluidOutputs(FlueGas.getFluid(1000))
                .EUt(480)
                .duration(10)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, CopperMatteFlueDust)
                .chancedOutput(dust, ZincOxide, 2, 2000, 0)
                .chancedOutput(dust, Massicot, 2, 2000, 0)
                .chancedOutput(dust, Cassiterite, 2, 2000, 0)
                .EUt(480)
                .duration(10)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .input(dust, CopperSulfate, 6)
                .notConsumable(stick, Copper)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(Water.getFluid(2000))
                .output(dust, Copper)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();
    }
}
