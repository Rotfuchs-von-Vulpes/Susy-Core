package supersymmetry.loaders.recipes.chemistry;

import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import supersymmetry.common.blocks.BlockDeposit;
import supersymmetry.common.blocks.BlockResource;
import supersymmetry.common.blocks.SuSyBlocks;
import supersymmetry.common.materials.SusyMaterials;
import gregtech.api.items.metaitem.MetaItem.MetaValueItem;

import java.util.HashMap;
import java.util.Map;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.ore;
import static net.minecraft.init.Blocks.SOUL_SAND;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ORE_SORTER_RECIPES;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class OreSorting {
    public static class OreRock {
        public MetaValueItem input_rock;
        public int starting_tier;
        public Map<ItemStack, Integer>[] ore_lists;

        @SafeVarargs
        public OreRock(MetaValueItem rock, int startingTier, Map<ItemStack, Integer> ...ore_list){
            this.input_rock = rock;
            this.ore_lists = ore_list;
            this.starting_tier = startingTier;
        }
    }

    public static void init() {
        Map<ItemStack, Integer> orthomagmaticTier1 = new HashMap<>();
        orthomagmaticTier1.put(OreDictUnifier.get(ore, Spodumene), 10000);
        orthomagmaticTier1.put(OreDictUnifier.get(ore, Lepidolite), 10000);
        orthomagmaticTier1.put(OreDictUnifier.get(ore, Magnetite), 10000);
        orthomagmaticTier1.put(OreDictUnifier.get(ore, Chalcopyrite), 10000);
        orthomagmaticTier1.put(OreDictUnifier.get(ore, Sphalerite), 10000);
        orthomagmaticTier1.put(OreDictUnifier.get(ore, Cassiterite), 10000);

        Map<ItemStack, Integer> orthomagmaticTier2 = new HashMap<>(orthomagmaticTier1);
        orthomagmaticTier2.put(OreDictUnifier.get(ore, Pollucite), 10000);

        Map<ItemStack, Integer> orthomagmaticTier3 = new HashMap<>(orthomagmaticTier2);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, Thortveitite), 10000);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, VanadiferousTitanomagnetite), 10000);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, Perovskite), 10000);
        orthomagmaticTier3.put(new ItemStack(SOUL_SAND), 10000);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, Chromite), 10000);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, Pentlandite), 10000);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, SusyMaterials.Pyrochlore), 10000);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, Molybdenite), 10000);
        orthomagmaticTier3.put(OreDictUnifier.get(ore, Tantalite), 10000);

        Map<ItemStack, Integer> orthomagmaticTier4 = new HashMap<>(orthomagmaticTier3);
        orthomagmaticTier4.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.EUXENITE_ALLUVIAL), 10000);
        orthomagmaticTier4.put(OreDictUnifier.get(ore, Baddeleyite), 10000);

        Map<ItemStack, Integer> sedimentaryTier1 = new HashMap<>();
        sedimentaryTier1.put(OreDictUnifier.get(ore, Coal), 10000);
        sedimentaryTier1.put(OreDictUnifier.get(ore, Saltpeter), 10000);
        sedimentaryTier1.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.PHOSPHORITE), 10000);
        sedimentaryTier1.put(OreDictUnifier.get(ore, BandedIron), 10000);
        sedimentaryTier1.put(OreDictUnifier.get(ore, Pyrite), 10000);
        sedimentaryTier1.put(OreDictUnifier.get(ore, Malachite), 10000);
        sedimentaryTier1.put(OreDictUnifier.get(ore, Cinnabar), 10000);
        sedimentaryTier1.put(OreDictUnifier.get(ore, Fluorite), 10000);
        sedimentaryTier1.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.BAUXITE), 10000);
        sedimentaryTier1.put(OreDictUnifier.get(ore, Pyrolusite), 10000);

        Map<ItemStack, Integer> sedimentaryTier2 = new HashMap<>(sedimentaryTier1);
        sedimentaryTier2.put(OreDictUnifier.get(ore, Magnesite), 10000);

        Map<ItemStack, Integer> sedimentaryTier3 = new HashMap<>(sedimentaryTier2);
        sedimentaryTier3.put(OreDictUnifier.get(ore, Celestine), 10000);
        sedimentaryTier3.put(OreDictUnifier.get(ore, Barite), 10000);
        sedimentaryTier3.put(OreDictUnifier.get(ore, Ilmenite), 10000);
        sedimentaryTier3.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.CALICHE), 10000);

        Map<ItemStack, Integer> sedimentaryTier4 = new HashMap<>(sedimentaryTier3);
        sedimentaryTier4.put(OreDictUnifier.get(ore, Uraninite), 10000);
        sedimentaryTier4.put(OreDictUnifier.get(ore, Carnotite), 10000);

        Map<ItemStack, Integer> metamorphicTier1 = new HashMap<>();
        metamorphicTier1.put(OreDictUnifier.get(ore, Magnetite), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Pyrite), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Cobaltite), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Realgar), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Arsenopyrite), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Pyrargyrite), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Redstone), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Tetrahedrite), 10000);
        metamorphicTier1.put(OreDictUnifier.get(ore, Cinnabar), 10000);

        Map<ItemStack, Integer> metamorphicTier2 = new HashMap<>(metamorphicTier1);
        metamorphicTier2.put(OreDictUnifier.get(ore, Stephanite), 10000);
        metamorphicTier2.put(OreDictUnifier.get(ore, Magnesite), 10000);

        Map<ItemStack, Integer> metamorphicTier3 = new HashMap<>(metamorphicTier2);
        metamorphicTier3.put(OreDictUnifier.get(ore, Ilmenite), 10000);

        Map<ItemStack, Integer> magmaticHydrothermalTier1 = new HashMap<>();
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Magnetite), 10000);
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Pyrite), 10000);
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Cobaltite), 10000);
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Chalcopyrite), 10000);
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Sphalerite), 10000);
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Enargite), 10000);
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Redstone), 10000);
        magmaticHydrothermalTier1.put(OreDictUnifier.get(ore, Cassiterite), 10000);

        Map<ItemStack, Integer> magmaticHydrothermalTier2 = new HashMap<>(magmaticHydrothermalTier1);

        Map<ItemStack, Integer> magmaticHydrothermalTier3 = new HashMap<>(magmaticHydrothermalTier2);
        magmaticHydrothermalTier3.put(OreDictUnifier.get(ore, Scheelite), 10000);
        magmaticHydrothermalTier3.put(OreDictUnifier.get(ore, Wolframite), 10000);
        magmaticHydrothermalTier3.put(OreDictUnifier.get(ore, SusyMaterials.Pyrochlore), 10000);

        Map<ItemStack, Integer> magmaticHydrothermalTier4 = new HashMap<>(magmaticHydrothermalTier3);
        magmaticHydrothermalTier4.put(OreDictUnifier.get(ore, Uraninite), 10000);
        magmaticHydrothermalTier4.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.BASTNASITE_ALLUVIAL), 10000);

        Map<ItemStack, Integer> hydrothermalTier1 = new HashMap<>();
        hydrothermalTier1.put(OreDictUnifier.get(ore, Fluorite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Pyrolusite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Pyrite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Cobaltite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Bornite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Realgar), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Arsenopyrite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Proustite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Cassiterite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Acanthite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Stibnite), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Cinnabar), 10000);
        hydrothermalTier1.put(OreDictUnifier.get(ore, Galena), 10000);

        Map<ItemStack, Integer> hydrothermalTier2 = new HashMap<>(hydrothermalTier1);
        hydrothermalTier2.put(OreDictUnifier.get(ore, Vanadinite), 10000);

        Map<ItemStack, Integer> hydrothermalTier3 = new HashMap<>(hydrothermalTier2);
        hydrothermalTier3.put(OreDictUnifier.get(ore, Witherite), 10000);
        hydrothermalTier3.put(OreDictUnifier.get(ore, Bismuthinite), 10000);
        hydrothermalTier3.put(OreDictUnifier.get(ore, Strontianite), 10000);

        Map<ItemStack, Integer> hydrothermalTier4 = new HashMap<>(hydrothermalTier3);
        hydrothermalTier4.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.XENOTIME_ALLUVIAL), 10000);

        Map<ItemStack, Integer> alluvialTier1 = new HashMap<>();
        alluvialTier1.put(OreDictUnifier.get(ore, Cassiterite), 10000);

        Map<ItemStack, Integer> alluvialTier2 = new HashMap<>(alluvialTier1);
        alluvialTier2.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.PLATINUM_PLACER), 100);
        alluvialTier2.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.GOLD_ALLUVIAL), 5000);

        Map<ItemStack, Integer> alluvialTier3 = new HashMap<>(alluvialTier2);
        alluvialTier3.put(new ItemStack(SOUL_SAND), 10000);

        Map<ItemStack, Integer> alluvialTier4 = new HashMap<>();
        alluvialTier4.put(OreDictUnifier.get(ore, Cassiterite), 10000);
        alluvialTier4.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.PLATINUM_PLACER), 10000);
        alluvialTier4.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.GOLD_ALLUVIAL), 10000);
        alluvialTier4.put(new ItemStack(SOUL_SAND), 10000);
        alluvialTier4.put(SuSyBlocks.RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.MONAZITE_ALLUVIAL), 10000);

        OreRock rock_orthomagmatic = new OreRock(ROCK_ORTHOMAGMATIC, 1, orthomagmaticTier1, orthomagmaticTier2, orthomagmaticTier3, orthomagmaticTier4);
        OreRock rock_sedimentary = new OreRock(ROCK_SEDIMENTARY, 1, sedimentaryTier1, sedimentaryTier2, sedimentaryTier3, sedimentaryTier4);
        OreRock rock_metamorphic = new OreRock(ROCK_METAMORPHIC, 1, metamorphicTier1, metamorphicTier2, metamorphicTier3);
        OreRock rock_magmatic_hydrothermal = new OreRock(ROCK_MAGMATIC_HYDROTHERMAL, 1, magmaticHydrothermalTier1, magmaticHydrothermalTier2, magmaticHydrothermalTier3, magmaticHydrothermalTier4);
        OreRock rock_hydrothermal = new OreRock(ROCK_HYDROTHERMAL, 1, hydrothermalTier1, hydrothermalTier2, hydrothermalTier3, hydrothermalTier4);
        OreRock rock_alluvial = new OreRock(ROCK_ALLUVIAL, 1, alluvialTier1, alluvialTier2, alluvialTier3, alluvialTier4);

        OreRock[] rocks = {
                rock_orthomagmatic,
                rock_sedimentary,
                rock_metamorphic,
                rock_magmatic_hydrothermal,
                rock_hydrothermal,
                rock_alluvial
        };

        int[] VoltAmps = {7, 30, 120, 480, 1920, 7680, 30720, 122880, 491520, 1966080, 7864320, 31457280, 125829120, 503316480, 2013265920};

        for (OreRock rock : rocks) {
            int a = 0;
            for (var oreList : rock.ore_lists) {
                RecipeBuilder<SimpleRecipeBuilder> recipe = ORE_SORTER_RECIPES.recipeBuilder();
                recipe.circuitMeta(a + 1);
                rock.input_rock.getStackForm(oreList.size());
                recipe.input(rock.input_rock);

                oreList.forEach((oreBlock, chance) -> {
                    if (oreBlock == OreDictUnifier.get(ore, Coal)) {
                        oreBlock.setCount(2);
                        recipe.chancedOutput(oreBlock, chance, 0);
                    } else {
                        recipe.chancedOutput(oreBlock, chance, 0);
                    }
                });

                recipe.duration(20);
                recipe.EUt(VoltAmps[rock.starting_tier + a]);
                recipe.buildAndRegister();
                a += 1;
            }
        }
    }
}
