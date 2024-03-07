package supersymmetry.loaders.recipes.biology;

import biomesoplenty.api.block.BOPBlocks;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtechfoodoption.block.GTFOMetaBlocks;
import gregtechfoodoption.block.tree.GTFOBlockLeaves;
import gregtechfoodoption.item.GTFOMetaItem;
import gregtechfoodoption.worldgen.trees.GTFOTrees;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.MetaBlocks.RUBBER_LEAVES;
import static gregtech.common.blocks.MetaBlocks.RUBBER_LOG;
import static gregtech.common.items.MetaItems.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static gregtechfoodoption.item.GTFOMetaItem.*;
import static gregtechfoodoption.recipe.GTFORecipeMaps.GREENHOUSE_RECIPES;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BLENDER_RECIPES;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class GreenhouseChain {
    private static void generateGreenhouseTreeRecipes(Material gasType, ItemStack sapling, ItemStack leaves, ItemStack wood) {
        var builder = GREENHOUSE_RECIPES.recipeBuilder();

        sapling.setCount(1);
        builder.notConsumable(sapling);
        sapling.setCount(2);
        builder.outputs(sapling);
        builder.circuitMeta(1)
                .fluidInputs(gasType.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(wood)
                .outputs(leaves)
                .EUt(30)
                .duration(2400)
                .buildAndRegister();
    }

    private static void generateGreenhouseCropRecipes(Material gasType, ItemStack input, ItemStack output, int multiplier) {
        ItemStack output1 = output.copy();
        ItemStack output2 = output.copy();
        ItemStack output3 = output.copy();

        output1.setCount(multiplier);
        output2.setCount(2 * multiplier);
        output3.setCount(3 * multiplier);

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(input)
                .circuitMeta(1)
                .fluidInputs(gasType.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(output1)
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(input)
                .circuitMeta(2)
                .fluidInputs(gasType.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(WeedKiller.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(output2)
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(input)
                .circuitMeta(3)
                .fluidInputs(gasType.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(output2)
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(input)
                .circuitMeta(4)
                .fluidInputs(gasType.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .fluidInputs(WeedKiller.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(output3)
                .EUt(30)
                .duration(1200)
                .buildAndRegister();
    }
    public static void init() {
        //REMOVALS

// Fertilizer * 4
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{new ItemStack(DIRT), OreDictUnifier.get(dust, Wood, 2), new ItemStack(SAND, 4)}, new FluidStack[]{Water.getFluid(1000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{new ItemStack(DIRT), OreDictUnifier.get(dust, Wood, 2), new ItemStack(SAND, 4)}, new FluidStack[]{Water.getFluid(1000)});
// Fertilizer Solution * 5000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{new ItemStack(DYE, 1, 15)}, new FluidStack[]{Water.getFluid(5000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{new ItemStack(DYE, 1, 15)}, new FluidStack[]{Water.getFluid(5000)});

//COTTON RECIPES
        ModHandler.addShapedRecipe("susy:cotton_seeds", SEED_COTTON.getStackForm(2),
                "   ", "   ", " SS", 'S', UNKNOWN_SEED);

        EXTRUDER_RECIPES.recipeBuilder()
                .inputs(CROP_COTTON.getStackForm(20))
                .notConsumable(gear, Steel, 8)
                .outputs(SEED_COTTON.getStackForm(5))
                .outputs(STEM_COTTON.getStackForm(5))
                .output(fiber, Cotton, 40)
                .EUt(7)
                .duration(80)
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(SEED_COTTON)
                .fluidOutputs(SeedOil.getFluid(10))
                .EUt(2)
                .duration(32)
                .buildAndRegister();

        ModHandler.addShapelessRecipe("string.cotton", new ItemStack(STRING), new UnificationEntry(thread, Cotton));

        MACERATOR_RECIPES.recipeBuilder()
                .input(thread, Cotton, 2)
                .output(dust, Cellulose)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

//FERTILIZER CHAIN

        MIXER_RECIPES.recipeBuilder()
                .input("nutrientNitrogen")
                .input("nutrientPotassium")
                .input("nutrientPhosphorous")
                .outputs(MetaItems.FERTILIZER.getStackForm(5))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumDihydrogenPhosphate, 2)
                .inputs(OreDictUnifier.get("nutrientPotassium"))
                .outputs(MetaItems.FERTILIZER.getStackForm(5))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Saltpeter, 2)
                .input("nutrientPhosphorous")
                .outputs(MetaItems.FERTILIZER.getStackForm(5))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .inputs(BIO_CHAFF.getStackForm(2))
                .input("nutrientPhosphorous")
                .outputs(MetaItems.FERTILIZER.getStackForm(5))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(FermentedBiomass.getFluid(1000))
                .input("nutrientPhosphorous")
                .outputs(MetaItems.FERTILIZER.getStackForm(5))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(FertilizerSolution.getFluid(1000))
                .EUt(30)
                .duration(60)
                .buildAndRegister();



        COMPRESSOR_RECIPES.recipeBuilder()
                .input("treeLeaves", 16)
                .output(PLANT_BALL)
                .EUt(2)
                .duration(300)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .inputs(new ItemStack(SUGAR, 24))
                .output(dust, Carbon, 6)
                .fluidOutputs(Steam.getFluid(6000))
                .duration(320)
                .EUt(64)
                .buildAndRegister();

// WEED KILLERS & PESTICIDES

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(AceticAcid.getFluid(100))
                .fluidInputs(SodiumStearate.getFluid(100))
                .fluidInputs(SaltWater.getFluid(1000))
                .fluidOutputs(WeedKiller.getFluid(1000))
                .EUt(30)
                .duration(60)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(SeedOil.getFluid(100))
                .fluidInputs(SodiumStearate.getFluid(100))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Pesticide.getFluid(1000))
                .EUt(30)
                .duration(60)
                .buildAndRegister();

// GREENHOUSE_RECIPES GASES

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Air.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(100))
                .fluidOutputs(EarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(EarthGreenhouseGas.getFluid(1000))
                .fluidOutputs(WarmEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(40))
                .fluidInputs(EarthGreenhouseGas.getFluid(1000))
                .fluidOutputs(CoolEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(EarthGreenhouseGas.getFluid(1000))
                .fluidInputs(Water.getFluid(100))
                .fluidOutputs(HumidEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(EarthGreenhouseGas.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(20))
                .fluidOutputs(DryEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(WarmEarthGreenhouseGas.getFluid(1000))
                .fluidInputs(Water.getFluid(100))
                .fluidOutputs(WarmHumidEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(WarmEarthGreenhouseGas.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(20))
                .fluidOutputs(WarmDryEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(1000))
                .fluidInputs(Water.getFluid(100))
                .fluidOutputs(CoolHumidEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(20))
                .fluidOutputs(CoolDryEarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

//THIS IS FOR GREENHOUSES IN OUTER SPACE

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Nitrogen.getFluid(780))
                .fluidInputs(Oxygen.getFluid(220))
                .fluidOutputs(EarthLikeAir.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(EarthLikeAir.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(100))
                .fluidOutputs(EarthGreenhouseGas.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

//TREES
        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(SAPLING))
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(LOG, 6))
                .outputs(new ItemStack(LEAVES, 12))
                .outputs(new ItemStack(SAPLING, 2))
                .outputs(new ItemStack(APPLE, 1))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(SAPLING, 1, 1))
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(LOG, 6, 1))
                .outputs(new ItemStack(LEAVES, 12, 1))
                .outputs(new ItemStack(SAPLING, 2, 1))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(SAPLING, 1, 2))
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(LOG, 6, 2))
                .outputs(new ItemStack(LEAVES, 12, 2))
                .outputs(new ItemStack(SAPLING, 2, 2))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(SAPLING, 1, 3))
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(8))
                .outputs(new ItemStack(LOG, 24, 3))
                .outputs(new ItemStack(LEAVES, 40, 3))
                .outputs(new ItemStack(SAPLING, 5, 3))
                .EUt(30)
                .duration(7200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(SAPLING, 1, 4))
                .fluidInputs(WarmEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(LOG2, 6))
                .outputs(new ItemStack(LEAVES2, 12))
                .outputs(new ItemStack(SAPLING, 2, 4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(SAPLING, 1, 5))
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(8))
                .outputs(new ItemStack(LOG2, 24, 1))
                .outputs(new ItemStack(LEAVES2, 40, 1))
                .outputs(new ItemStack(SAPLING, 5, 5))
                .outputs(new ItemStack(APPLE, 2))
                .EUt(30)
                .duration(7200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(MetaBlocks.RUBBER_SAPLING))
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(RUBBER_LOG, 6))
                .outputs(new ItemStack(RUBBER_LEAVES, 12))
                .outputs(STICKY_RESIN.getStackForm(4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

//FRUIT TREES

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(GTFOTrees.BANANA_TREE.getSaplingStack())
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .output(GTFOTrees.BANANA_TREE.logState.getBlock(), 6)
                .output(GTFOTrees.BANANA_TREE.leavesState.getBlock(), 12)
                .output(GTFOTrees.BANANA_TREE.getSaplingStack().getItem(), 2)
                .outputs(GTFOMetaItem.BANANA.getStackForm(4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(GTFOTrees.BANANA_TREE.getSaplingStack())
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .output(GTFOTrees.BANANA_TREE.logState.getBlock(), 6)
                .output(GTFOTrees.BANANA_TREE.leavesState.getBlock(), 12)
                .output(GTFOTrees.BANANA_TREE.getSaplingStack().getItem(), 2)
                .outputs(GTFOMetaItem.BANANA.getStackForm(8))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 2))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(0), 6, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(0), 12, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 2))
                .outputs(GTFOMetaItem.ORANGE.getStackForm(4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 2))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(0), 6, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(0), 12, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 2))
                .outputs(GTFOMetaItem.ORANGE.getStackForm(8))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 4))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(0), 6, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(0), 12, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 4))
                .outputs(GTFOMetaItem.MANGO.getStackForm(4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 4))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(0), 6, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(0), 12, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 4))
                .outputs(GTFOMetaItem.MANGO.getStackForm(8))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 6))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(0), 6, 12))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(0), 12, 12))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 6))
                .outputs(GTFOMetaItem.APRICOT.getStackForm(4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 6))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(0), 6, 12))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(0), 12, 12))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 6))
                .outputs(GTFOMetaItem.APRICOT.getStackForm(8))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 8))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 8))
                .outputs(GTFOMetaItem.LEMON.getStackForm(4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 8))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 8))
                .outputs(GTFOMetaItem.LEMON.getStackForm(8))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 10))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 10))
                .outputs(GTFOMetaItem.LIME.getStackForm(4))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 10))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 10))
                .outputs(GTFOMetaItem.LIME.getStackForm(8))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 12))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 12))
                .outputs(GTFOMetaItem.OLIVE.getStackForm(20))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 12))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 12))
                .outputs(GTFOMetaItem.OLIVE.getStackForm(40))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 12))
                .circuitMeta(1)
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 12))
                .outputs(GTFOMetaItem.OLIVE.getStackForm(20))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 1, 12))
                .circuitMeta(2)
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(1), 6, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(1), 12, 8))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(0), 2, 12))
                .outputs(GTFOMetaItem.OLIVE.getStackForm(40))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(1), 1, 0))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(2), 6, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(2), 12, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(1), 2, 0))
                .outputs(GTFOMetaItem.NUTMEG_SEED.getStackForm(10))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(1), 1, 0))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LOGS.get(2), 6, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_LEAVES.get(2), 12, 0))
                .outputs(new ItemStack(GTFOMetaBlocks.GTFO_SAPLINGS.get(1), 2, 0))
                .outputs(GTFOMetaItem.NUTMEG_SEED.getStackForm(20))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(BOPBlocks.sapling_0, 1, 2))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(4))
                .outputs(new ItemStack(BOPBlocks.bamboo, 12))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(BOPBlocks.sapling_1, 1, 7))
                .circuitMeta(1)
                .fluidInputs(EarthGreenhouseGas.getFluid(20000))
                .fluidInputs(Water.getFluid(20000))
                .inputs(MetaItems.FERTILIZER.getStackForm(16))
                .outputs(new ItemStack(LOG, 120))
                .outputs(new ItemStack(LEAVES, 64))
                .EUt(30)
                .duration(6000)
                .buildAndRegister();

        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_0, 2, 1), new ItemStack(BOPBlocks.leaves_0, 12, 9), new ItemStack(LOG, 6, 1));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_0, 2, 0), new ItemStack(BOPBlocks.leaves_0, 12, 8), new ItemStack(LOG, 6, 2));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_0, 2, 3), new ItemStack(BOPBlocks.leaves_0, 12, 11), new ItemStack(BOPBlocks.log_1, 6, 5));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_0, 2, 4), new ItemStack(BOPBlocks.leaves_1, 12, 8), new ItemStack(BOPBlocks.log_0, 6, 6));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_0, 2, 5), new ItemStack(BOPBlocks.leaves_1, 12, 9), new ItemStack(BOPBlocks.log_4, 6, 5));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_0, 2, 6), new ItemStack(BOPBlocks.leaves_1, 12, 10), new ItemStack(BOPBlocks.log_0, 6, 7));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_0, 2, 7), new ItemStack(BOPBlocks.leaves_1, 12, 11), new ItemStack(BOPBlocks.log_1, 6, 4));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_1, 2, 0), new ItemStack(BOPBlocks.leaves_2, 12, 8), new ItemStack(LOG, 6));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_1, 2, 1), new ItemStack(BOPBlocks.leaves_2, 12, 9), new ItemStack(BOPBlocks.log_0, 6, 5));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_1, 2, 2), new ItemStack(BOPBlocks.leaves_2, 12, 10), new ItemStack(BOPBlocks.log_0, 6, 5));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_1, 2, 3), new ItemStack(BOPBlocks.leaves_2, 12, 11), new ItemStack(LOG, 6));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_1, 2, 5), new ItemStack(BOPBlocks.leaves_3, 12, 9), new ItemStack(LOG, 6));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_1, 2, 6), new ItemStack(BOPBlocks.leaves_3, 12, 10), new ItemStack(BOPBlocks.log_3, 6, 4));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 0), new ItemStack(BOPBlocks.leaves_4, 12, 8), new ItemStack(BOPBlocks.log_1, 6, 6));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 1), new ItemStack(BOPBlocks.leaves_4, 12, 9), new ItemStack(BOPBlocks.log_1, 6, 7));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 2), new ItemStack(BOPBlocks.leaves_4, 12, 10), new ItemStack(BOPBlocks.log_2, 6, 4));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 3), new ItemStack(BOPBlocks.leaves_4, 12, 11), new ItemStack(BOPBlocks.log_2, 6, 5));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 4), new ItemStack(BOPBlocks.leaves_5, 12, 8), new ItemStack(BOPBlocks.log_2, 6, 6));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 5), new ItemStack(BOPBlocks.leaves_5, 12, 9), new ItemStack(BOPBlocks.log_3, 6, 5));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 6), new ItemStack(BOPBlocks.leaves_5, 12, 10), new ItemStack(BOPBlocks.log_3, 6, 6));
        generateGreenhouseTreeRecipes(EarthGreenhouseGas, new ItemStack(BOPBlocks.sapling_2, 2, 7), new ItemStack(BOPBlocks.leaves_5, 12, 11), new ItemStack(BOPBlocks.log_3, 6, 7));

//VANILLA CROPS

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(CACTUS))
                .notConsumable(new ItemStack(SAND))
                .fluidInputs(WarmDryEarthGreenhouseGas.getFluid(10000))
                .outputs(new ItemStack(CACTUS, 12))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(DYE, 1, 3))
                .notConsumable(new ItemStack(LOG, 1, 3))
                .circuitMeta(1)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(DYE, 15, 3))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(DYE, 1, 3))
                .notConsumable(new ItemStack(LOG, 1, 3))
                .circuitMeta(2)
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(DYE, 30, 3))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(Items.REEDS))
                .notConsumable(new ItemStack(SAND))
                .fluidInputs(WarmHumidEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(Items.REEDS, 40))
                .EUt(30)
                .duration(2400)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(WHEAT_SEEDS))
                .circuitMeta(1)
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(WHEAT_SEEDS, 25))
                .outputs(new ItemStack(Items.WHEAT, 30))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(WHEAT_SEEDS))
                .circuitMeta(2)
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(WeedKiller.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(WHEAT_SEEDS, 50))
                .outputs(new ItemStack(Items.WHEAT, 60))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(WHEAT_SEEDS))
                .circuitMeta(3)
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(WHEAT_SEEDS, 50))
                .outputs(new ItemStack(Items.WHEAT, 60))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(WHEAT_SEEDS))
                .circuitMeta(4)
                .fluidInputs(EarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(Pesticide.getFluid(500))
                .fluidInputs(WeedKiller.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(WHEAT_SEEDS, 75))
                .outputs(new ItemStack(Items.WHEAT, 90))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(BROWN_MUSHROOM))
                .circuitMeta(1)
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(BROWN_MUSHROOM, 10))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(BROWN_MUSHROOM))
                .circuitMeta(2)
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(WeedKiller.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(BROWN_MUSHROOM, 20))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(RED_MUSHROOM))
                .circuitMeta(1)
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(RED_MUSHROOM, 10))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        GREENHOUSE_RECIPES.recipeBuilder()
                .notConsumable(new ItemStack(RED_MUSHROOM))
                .circuitMeta(2)
                .fluidInputs(CoolEarthGreenhouseGas.getFluid(10000))
                .fluidInputs(Water.getFluid(5000))
                .fluidInputs(WeedKiller.getFluid(500))
                .inputs(MetaItems.FERTILIZER.getStackForm(2))
                .outputs(new ItemStack(RED_MUSHROOM, 20))
                .EUt(30)
                .duration(1200)
                .buildAndRegister();

        generateGreenhouseCropRecipes(EarthGreenhouseGas, new ItemStack(POTATO), new ItemStack(POTATO), 30);
        generateGreenhouseCropRecipes(EarthGreenhouseGas, new ItemStack(CARROT), new ItemStack(CARROT), 30);
        generateGreenhouseCropRecipes(EarthGreenhouseGas, new ItemStack(BEETROOT_SEEDS), new ItemStack(BEETROOT), 30);
        generateGreenhouseCropRecipes(WarmEarthGreenhouseGas, new ItemStack(MELON_SEEDS), new ItemStack(MELON_BLOCK), 10);
        generateGreenhouseCropRecipes(CoolEarthGreenhouseGas, new ItemStack(PUMPKIN_SEEDS), new ItemStack(PUMPKIN), 10);

//GTFO CROPS
        generateGreenhouseCropRecipes(WarmEarthGreenhouseGas, SOYBEAN_SEED.getStackForm(), SOYBEAN.getStackForm(), 20);
        generateGreenhouseCropRecipes(EarthGreenhouseGas, TOMATO_SEED.getStackForm(), TOMATO.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmEarthGreenhouseGas, CUCUMBER_SEED.getStackForm(), CUCUMBER.getStackForm(), 20);
        generateGreenhouseCropRecipes(EarthGreenhouseGas, ONION_SEED.getStackForm(), ONION.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmHumidEarthGreenhouseGas, GRAPE_SEED.getStackForm(), GRAPES.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmHumidEarthGreenhouseGas, COFFEE_SEED.getStackForm(), COFFEE_SEED.getStackForm(), 20);
        generateGreenhouseCropRecipes(EarthGreenhouseGas, PEAS.getStackForm(), PEAS.getStackForm(), 20);
        generateGreenhouseCropRecipes(EarthGreenhouseGas, BEANS.getStackForm(), BEANS.getStackForm(), 20);
        generateGreenhouseCropRecipes(CoolHumidEarthGreenhouseGas, HORSERADISH_SEED.getStackForm(), HORSERADISH.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmDryEarthGreenhouseGas, OREGANO_SEED.getStackForm(), OREGANO.getStackForm(), 20);
        generateGreenhouseCropRecipes(CoolEarthGreenhouseGas, GARLIC_CLOVE.getStackForm(), GARLIC_CLOVE.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmHumidEarthGreenhouseGas, BASIL_SEED.getStackForm(), BASIL.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmHumidEarthGreenhouseGas, AUBERGINE_SEED.getStackForm(), AUBERGINE.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmEarthGreenhouseGas, CORN_EAR.getStackForm(), CORN_EAR.getStackForm(), 20);
        generateGreenhouseCropRecipes(EarthGreenhouseGas, ARTICHOKE_SEED.getStackForm(), ARTICHOKE_HEART.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmHumidEarthGreenhouseGas, BLACK_PEPPERCORN.getStackForm(), BLACK_PEPPERCORN.getStackForm(), 20);
        generateGreenhouseCropRecipes(WarmHumidEarthGreenhouseGas, RICE.getStackForm(), RICE.getStackForm(), 20);

//CUSTOM CROPS
        generateGreenhouseCropRecipes(WarmHumidEarthGreenhouseGas, SEED_COTTON.getStackForm(), STEM_COTTON.getStackForm(), 20);
    }
}
