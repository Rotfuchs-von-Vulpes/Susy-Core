package supersymmetry.loaders.recipes.chemistry.elements;

import supersymmetry.common.blocks.BlockResource;
import supersymmetry.common.blocks.SuSyBlocks;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.SPONGE_PLATINUM;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PlatinumGroupChain {
    public static void init() {
        //LOW YIELD CHAIN FROM SECONDARY ORES
        MACERATOR_RECIPES.recipeBuilder()
                .inputs(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.PLATINUM_PLACER))
                .output(dust, AlluvialPGMSand, 9)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, AlluvialPGMSand)
                .output(nugget, AlluvialPGM, 4)
                .output(dust, NetherQuartz, 3)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AlluvialPGM, 2)
                .fluidInputs(AquaRegia.getFluid(12000))
                .fluidInputs(NitricAcid.getFluid(1000))
                .fluidOutputs(AlluvialPGMSolution.getFluid(5000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .fluidOutputs(NitrogenDioxide.getFluid(5000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPurityZinc")
                .fluidInputs(AlluvialPGMSolution.getFluid(10000))
                .output(dust, IronIIChloride, 3)
                .fluidOutputs(CementedAlluvialPGMSolution.getFluid(10000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder() // 2 H2PtCl6 + 4 NH4Cl --> 2 (NH4)2PtCl6 + 4 HCl
                .circuitMeta(1)
                .fluidInputs(CementedAlluvialPGMSolution.getFluid(10000)) // 67% (NH4)2Pt, 33% H2PdCl4
                .fluidInputs(AmmoniumChlorideSolution.getFluid(4000))
                .chancedOutput(dust, AmmoniumHexachloroplatinate, 34, 7500, 0)
                .fluidOutputs(AlluvialPlatinumMotherLiquor.getFluid(14000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AlluvialPlatinumMotherLiquor.getFluid(14000))
                .chancedOutput(dust, ZincChloride, 3, 9000, 0)
                .fluidOutputs(AmmoniumChlorideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(13000))
                .fluidOutputs(HydrogenChloride.getFluid(4000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, AmmoniumHexachloroplatinate, 17)
                .fluidInputs(Hydrogen.getFluid(4000))
                .output(SPONGE_PLATINUM)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(HydrogenChloride.getFluid(6000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(SPONGE_PLATINUM)
                .output(dust, Platinum)
                .duration(240)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(spring, Cupronickel)
                .fluidInputs(AlluvialPlatinumMotherLiquor.getFluid(14000))
                .fluidOutputs(AlluvialDivalentPalladiumSolution.getFluid(14000))
                .fluidOutputs(Chlorine.getFluid(50))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(AmmoniaSolution.getFluid(1000))
                .fluidInputs(AlluvialDivalentPalladiumSolution.getFluid(7000)) //(H2PdCl4)(ZnCl2)(HCl)4(H2O)14
                .chancedOutput(dust, Diamminedichloropalladium, 11, 3750, 0)
                .fluidOutputs(AlluvialPalladiumMotherLiquor.getFluid(8000)) //(NH4Cl)2(ZnCl2)(HCl)4(H2O)16
                .duration(60)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Diamminedichloropalladium, 11)
                .fluidInputs(Hydrogen.getFluid(4000))
                .output(dust, Palladium)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AlluvialPalladiumMotherLiquor.getFluid(16000))
                .chancedOutput(dust, ZincChloride, 3, 9500, 0)
                .fluidOutputs(AmmoniumChlorideSolution.getFluid(2000))
                .fluidOutputs(Water.getFluid(14000))
                .fluidOutputs(HydrogenChloride.getFluid(4000))
                .duration(240)
                .EUt(120)
                .buildAndRegister();

//MODERN SEPARATION PROCESSES


    }
}
