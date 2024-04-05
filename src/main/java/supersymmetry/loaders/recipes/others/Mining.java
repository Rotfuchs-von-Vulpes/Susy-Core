package supersymmetry.loaders.recipes.others;

import supersymmetry.common.blocks.BlockDeposit;
import supersymmetry.common.blocks.SuSyBlocks;

import static supersymmetry.api.recipes.SuSyRecipeMaps.MINING_DRILL_RECIPES;
import static supersymmetry.common.item.SuSyMetaItems.*;

public class Mining {
    public static void init() {
        MINING_DRILL_RECIPES.recipeBuilder()
                .notConsumable(SuSyBlocks.DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.ORTHOMAGMATIC))
                .output(ROCK_ORTHOMAGMATIC)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        MINING_DRILL_RECIPES.recipeBuilder()
                .notConsumable(SuSyBlocks.DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.METAMORPHIC))
                .output(ROCK_METAMORPHIC)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        MINING_DRILL_RECIPES.recipeBuilder()
                .notConsumable(SuSyBlocks.DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.SEDIMENTARY))
                .output(ROCK_SEDIMENTARY)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        MINING_DRILL_RECIPES.recipeBuilder()
                .notConsumable(SuSyBlocks.DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.HYDROTHERMAL))
                .output(ROCK_HYDROTHERMAL)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        MINING_DRILL_RECIPES.recipeBuilder()
                .notConsumable(SuSyBlocks.DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.ALLUVIAL))
                .output(ROCK_ALLUVIAL)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        MINING_DRILL_RECIPES.recipeBuilder()
                .notConsumable(SuSyBlocks.DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.MAGMATIC_HYDROTHERMAL))
                .output(ROCK_MAGMATIC_HYDROTHERMAL)
                .duration(20)
                .EUt(30)
                .buildAndRegister();
    }
}
