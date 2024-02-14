package supersymmetry.loaders.recipes;

import biomesoplenty.api.item.BOPItems;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.StoneVariantBlock;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtechfoodoption.item.GTFOMetaItem;
import gregtechfoodoption.recipe.GTFORecipeMaps;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import supersymmetry.common.blocks.SuSyBlocks;
import supersymmetry.common.blocks.SusyStoneVariantBlock;
import supersymmetry.common.item.SuSyMetaItems;
import supersymmetry.common.materials.SusyMaterials;
import supersymmetry.loaders.recipes.misc.BrickChain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static gregtech.api.recipes.GTRecipeHandler.removeAllRecipes;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS;
import static gregtech.common.blocks.BlockSteamCasing.SteamCasingType.BRONZE_HULL;
import static gregtech.common.blocks.MetaBlocks.STEAM_CASING;
import static gregtech.common.items.MetaItems.SHAPE_EXTRUDER_BLOCK;
import static gregtechfoodoption.GTFOMaterialHandler.BakingSodaSolution;

public class SuSyRecipeLoader {

    public static void init() {
        removeAllRecipes(DISTILLERY_RECIPES);
        removeAllRecipes(DISTILLATION_RECIPES);
        removeAllRecipes(CRACKING_RECIPES);
        removeAllRecipes(BREWING_RECIPES);
        removeAllRecipes(CHEMICAL_RECIPES);
        removeAllRecipes(LARGE_CHEMICAL_RECIPES);
        removeAllRecipes(FERMENTING_RECIPES);
        removeAllRecipes(PYROLYSE_RECIPES);
        removeAllRecipes(IMPLOSION_RECIPES);
        removeAllRecipes(LASER_ENGRAVER_RECIPES);
        removeAllRecipes(GTFORecipeMaps.GREENHOUSE_RECIPES);
        removeAllRecipes(VACUUM_RECIPES);
        removeAllRecipes(ELECTROLYZER_RECIPES);

        removeRecipesByInputs(CENTRIFUGE_RECIPES, Butane.getFluid(320));
        removeRecipesByInputs(CENTRIFUGE_RECIPES, Propane.getFluid(320));

        // Water * 1000
        removeRecipesByInputs(CENTRIFUGE_RECIPES, BakingSodaSolution.getFluid(1000));

        removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(OrePrefix.dust, Brick));

        // Epoxy Resin Pulp * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, ReinforcedEpoxyResin));
        // Clay Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Fireclay, 2));
        // Red sand centrifuging
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Blocks.SAND, 1, 1));
        // Nitrogen Dioxide * 3900
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, EnderAir.getFluid(10000));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Plutonium241));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Plutonium239));
        // Carbon Monoxide * 3900
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, NetherAir.getFluid(10000));
        // Nitrogen * 3900
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, Air.getFluid(10000));
        // Silicon Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.REDSTONE, 10));
        // Small Pile of Banded Iron Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, MetalMixture));
        // Silicon Dioxide Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, PlatinumSludgeResidue, 5));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Uranium235));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Uranium238));
        // Lead Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, LeadZincSolution.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Blocks.MYCELIUM));
        // Antimony Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Stibnite, 5));
        // Raw Platinum Powder * 3
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, PlatinumGroupSludge, 6)}, new FluidStack[]{AquaRegia.getFluid(1200)});
        // Small Pile of Redstone Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.GLOWSTONE_DUST, 2));
        // Small Pile of Quartzite Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Stone));
        // Raw Rubber Pulp * 3
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, MetaItems.STICKY_RESIN.getStackForm());
        // Sulfur Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Cinnabar, 2));
        // Aluminium Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GreenSapphireSlurry.getFluid(3000));
        // Aluminium Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, SapphireSlurry.getFluid(3000));
        // Aluminium Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, RubySlurry.getFluid(3000));
        // Helium * 120
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Endstone));
        // Biomass * 200
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Meat, 3));
        // Centrifuging dirt or grass
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Blocks.DIRT));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Blocks.GRASS));
        // Magnesium Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Marble, 8));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Ash));
        // Calcium Dust * 3
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, TricalciumPhosphate, 5));
        // Samarium Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, SamariumMagnetic));
        // Neodymium Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, NeodymiumMagnetic));
        // Phosphorus Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, PhosphorusPentoxide, 7));
        // Iridium Chloride Dust * 4
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, IridiumMetalResidue, 5));
        // Oil * 80
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Blocks.SOUL_SAND));
        // Methane * 60
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(MetaBlocks.RUBBER_LOG));
        // Methane * 4000
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, RefineryGas.getFluid(8000));
        // Heavy Oil * 2000
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(ore, Oilsands));
        // Enriched Uranium Hexafluoride * 100
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, UraniumHexafluoride.getFluid(1000));
        // Tritium * 40
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, Deuterium.getFluid(160));
        // Helium-3 * 5
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, Helium.getFluid(80));
        // Centrifuging nether rack dust
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Netherrack));
        // Deuterium * 40
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, Hydrogen.getFluid(160));
        // Arsenic Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Realgar, 2));
        // Silicon Dioxide Dust * 4
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Granite, 5));
        // Silicon Dioxide Dust * 4
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, GraniteBlack, 5));
        // Rare Earth
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, RareEarth));
        // Dark Ashes * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.BLAZE_POWDER, 2));
        // Lava
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, Lava.getFluid(100));
        // Iron Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, IronMagnetic));
        // Steel Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, SteelMagnetic));
        // Steel Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, DamascusSteel));
        // Calcite Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Redrock, 3));
        // Copper Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, AnnealedCopper));
        // Methane * 54
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BOPItems.persimmon));
        // Methane * 35
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.PORKCHOP));
        // Methane * 94
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.PUMPKIN_PIE));
        // Methane * 126
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:golden_frog_leg'));
        // Methane * 144
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.RABBIT_STEW));
        // Methane * 35
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.BEEF));
        // Methane * 12
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.POTATO));
        // Methane * 58
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BOPItems.pear));
        // Methane * 130
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKED_PORKCHOP));
        // Methane * 35
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.RABBIT));
        // Methane * 40
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.ROTTEN_FLESH));
        // Methane * 18
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Blocks.RED_MUSHROOM));
        // Methane * 14
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.BEETROOT));
        // Methane * 119
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.GOLDEN_CARROT));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.MUTTON));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BOPItems.berries));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.MELON));
        // Methane * 18
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.NETHER_WART));
        // Methane * 47
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.APPLE));
        // Methane * 20
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.FISH));
        // Methane * 20
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.FISH, 1, 1));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.FISH, 1, 2));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.FISH, 1, 3));
        // Methane * 38
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BOPItems.filled_honeycomb));
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.CORN_COB.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.LEMON.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.LIME.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.OLIVE.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.TOMATO.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.ONION.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.CUCUMBER.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.BANANA.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.ORANGE.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.MANGO.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.APRICOT.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.SOYBEAN.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.COFFEE_CHERRY.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.PEA_POD.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.BEANS.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.HORSERADISH.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.BASIL.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.OREGANO.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.ARTICHOKE_HEART.getStackForm());
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.ARTICHOKE_SEED.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.BLACK_PEPPERCORN.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.RICE.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.GARLIC_BULB.getStackForm());
        // Methane * 34
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, GTFOMetaItem.AUBERGINE.getStackForm());
        // Methane * 72
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.BREAD));
        // Methane * 47
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack((Items.CHORUS_FRUIT)));
        // Methane * 81
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:cooked_frog_leg'));
        // Methane * 72
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKED_FISH));
        // Methane * 97
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKED_FISH, 1, 1));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.CHICKEN));
        // Methane * 72
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKED_RABBIT));
        // Methane * 79
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.GOLDEN_APPLE));
        // Methane * 79
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.GOLDEN_APPLE, 1, 1));
        // Methane * 23
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:frog_leg'));
        // Methane * 130
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKED_BEEF));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BOPItems.shroompowder));
        // Methane * 18
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Blocks.BROWN_MUSHROOM));
        // Methane * 86
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKED_CHICKEN));
        // Methane * 12
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:crab_leg'));
        // Methane * 54
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BOPItems.peach));
        // Methame * 56
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BOPItems.ricebowl));
        // Methane * 86
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.MUSHROOM_STEW));
        // Methane * 130
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:cooked_crab_leg'));
        // Methane * 72
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.BAKED_POTATO));
        // Methane * 86
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.BEETROOT_SOUP));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.POISONOUS_POTATO));
        // Methane * 32
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.SPIDER_EYE));
        // Methane * 20
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKIE));
        // Methane * 97
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.COOKED_MUTTON));
        // Methane * 43
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(Items.CARROT));
        // Iron Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, YellowLimonite, 4));
        // Iron Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, BrownLimonite, 4));


        // Baking Soda Solution * 1000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{ OreDictUnifier.get(OrePrefix.dust, Brick) }, new FluidStack[]{ Water.getFluid(1000) });
        // Crushed Bauxite Ore * 1
        removeRecipesByInputs(FORGE_HAMMER_RECIPES, OreDictUnifier.get(ore, Bauxite));
        // Crushed Bauxite Ore * 2
        removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(ore, Bauxite));
        // Flower Pot * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack(Items.BRICK, 3));

        String[] name_removals = {
                "gregtech:cover_fluid_voiding",
                "gregtech:cover_item_voiding",
                "gregtech:fluid_filter_lapis",
                "gregtech:fluid_filter_sodalite",
                "gregtech:fluid_filter_lazurite",
                "gregtech:comparator_certus",
//                "gregtech:gregtech.machine.world_accelerator.lv",
//                "gregtech:gregtech.machine.world_accelerator.mv",
//                "gregtech:gregtech.machine.world_accelerator.hv",
//                "gregtech:gregtech.machine.world_accelerator.ev",
//                "gregtech:gregtech.machine.world_accelerator.iv",
//                "gregtech:gregtech.machine.world_accelerator.luv",
//                "gregtech:gregtech.machine.world_accelerator.zpm",
//                "gregtech:gregtech.machine.world_accelerator.uv",
                "gregtech:nano_helmet",
                "gregtech:nano_chestplate",
                "gregtech:nano_leggings",
                "gregtech:nano_boots",
//                "gregtech:super_chest_lv",
//                "gregtech:super_chest_mv",
//                "gregtech:super_chest_hv",
//                "gregtech:super_chest_ev",
//                "gregtech:super_tank_lv",
//                "gregtech:super_tank_mv",
//                "gregtech:super_tank_hv",
//                "gregtech:super_tank_ev",
//                "gregtech:quantum_chest_iv",
//                "gregtech:quantum_chest_luv",
//                "gregtech:quantum_chest_zpm",
//                "gregtech:quantum_chest_uv",
//                "gregtech:quantum_chest_uhv",
//                "gregtech:quantum_tank_iv",
//                "gregtech:quantum_tank_luv",
//                "gregtech:quantum_tank_zpm",
//                "gregtech:quantum_tank_uv",
//                "gregtech:quantum_tank_uhv",
                "gregtech:large_combustion_engine",
                "gregtech:extreme_combustion_engine",
                "gregtech:gregtech.machine.fisher.lv",
                "gregtech:gregtech.machine.fisher.mv",
                "gregtech:gregtech.machine.fisher.hv",
                "gregtech:gregtech.machine.fisher.ev"
        };

        Arrays.stream(name_removals).forEach(ModHandler::removeRecipeByName);

        ModHandler.removeFurnaceSmelting(new ItemStack(Items.IRON_NUGGET));

        String[] ore_smelting_removals = {
                "lapis",
                "emerald",
                "almandine",
                "lazurite",
                "pyrope",
                "spessartine",
                "sodalite",
                "grossular",
                "garnet_red",
                "apatite",
                "blue_topaz",
                "certus_quartz",
                "garnet_yellow",
                "olivine",
                "monazite",
                "vanadinite",
                "celestine",
                "green_sapphire",
                "sperrylite",
                "sapphire",
                "ruby",
                "proustite",
                "topaz",
                "lorandite",
                "fluorite",
                "realgar",
                "amethyst",
                "opal",
                "perovskite",
                "cinnabar",
                "fluorapatite",
                "diamond"
        };

        for (String name : ore_smelting_removals) {
            ModHandler.removeFurnaceSmelting(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("gregtech:ore_" + name + "_0")), 1, 0));
            ModHandler.removeFurnaceSmelting(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("gregtech:ore_" + name + "_0")), 1, 1));
            ModHandler.removeFurnaceSmelting(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("gregtech:ore_" + name + "_0")), 1, 2));
        }

        ModHandler.addShapelessRecipe("gregtech:salt_water_bucket",
                FluidUtil.getFilledBucket(SaltWater.getFluid(1000)),
                OreDictUnifier.get(dust, Salt),
                OreDictUnifier.get(dust, Salt),
                new ItemStack(Items.WATER_BUCKET));

        ModHandler.addShapedRecipe(true, "gregtech:pbf_bronze",
                MetaTileEntities.PRIMITIVE_BLAST_FURNACE.getStackForm(), "hRS", "PBR", "dRS",
                'R', new UnificationEntry(stick, Bronze),
                'S', new UnificationEntry(screw, Bronze),
                'P', new UnificationEntry(plate, Bronze),
                'B', MetaBlocks.METAL_CASING.getItemVariant(PRIMITIVE_BRICKS));

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(plate, Bronze, 3))
                .inputs(OreDictUnifier.get(stick, Bronze, 2))
                .inputs(OreDictUnifier.get(gearSmall, Bronze))
                .inputs(OreDictUnifier.get(pipeTinyFluid, Bronze, 2))
                .outputs(SuSyMetaItems.STEAM_PISTON.getStackForm())
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm());
        ModHandler.addShapedRecipe(true, "gregtech:steam_extractor_bronze",
                MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm(), "SSS", "PRG", "SSS",
                'S', OreDictUnifier.get(pipeSmallFluid, Bronze),
                'P', SuSyMetaItems.STEAM_PISTON.getStackForm(),
                'R', STEAM_CASING.getItemVariant(BRONZE_HULL),
                'G', new ItemStack(Blocks.GLASS));

        BrickChain.init();

        // ModHandler.addShapelessRecipe("convert_old_slaked_lime", OreDictUnifier.get(dust, CalciumHydroxide), OreDictUnifier.get(dust, Quicklime));

//        SuSyMetaTileEntityLoader.init();
//        FridgeRecipes.init();
//        CoagulationRecipes.init();
//        VulcanizationRecipes.init();
//        SusyOreRecipeHandler.init();
//        SuSyMaterialRecipeHandler.init();
//        registerStoneRecipes();

        // make more loaders to categorize recipes and what is added

        //RES Example Recipe

        /*
        TagCompound tag = new TagCompound();

        tag.setString("defID", "rolling_stock/locomotives/k4_pacific.json");
        tag.setFloat("gauge", (float) Gauges.STANDARD);

        cam72cam.mod.item.ItemStack is = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
        is.setTagCompound(tag);
        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
                .input(plate, Materials.Steel)
                .input(plate, Materials.Iron)
                .outputs(is.internal)
                .EUt(GTValues.VA[4])
                .duration(1000)
                .buildAndRegister();

        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
                .inputNBT(IRItems.ITEM_ROLLING_STOCK.internal, NBTMatcher.EQUAL_TO, NBTCondition.create(NBTTagType.STRING, "defID", "rolling_stock/locomotives/black_mesa_tram.json"))
                .outputs(is.internal)
                .EUt(GTValues.VA[4])
                .duration(4000)
                .buildAndRegister();


        SuSyRecipeMaps.DRONE_PAD.recipeBuilder()
                .input(ingot, Materials.Iron)
                .output(Items.BEEF, 16)
                .duration(10)
                .dimension(0)
                .EUt(2)
                .buildAndRegister();
        */
    }

    private static void registerStoneRecipes(){
        EnumMap<SusyStoneVariantBlock.StoneVariant, List<ItemStack>> susyVariantListMap = new EnumMap<>(SusyStoneVariantBlock.StoneVariant.class);
        for (SusyStoneVariantBlock.StoneVariant shape : SusyStoneVariantBlock.StoneVariant.values()) {
            SusyStoneVariantBlock block = SuSyBlocks.SUSY_STONE_BLOCKS.get(shape);
            susyVariantListMap.put(shape,
                    Arrays.stream(SusyStoneVariantBlock.StoneType.values())
                            .map(block::getItemVariant)
                            .collect(Collectors.toList()));
        }
        List<ItemStack> susycobbles = susyVariantListMap.get(SusyStoneVariantBlock.StoneVariant.COBBLE);
        List<ItemStack> susysmooths = susyVariantListMap.get(SusyStoneVariantBlock.StoneVariant.SMOOTH);

        EnumMap<StoneVariantBlock.StoneVariant, List<ItemStack>> variantListMap = new EnumMap<>(StoneVariantBlock.StoneVariant.class);
        for (StoneVariantBlock.StoneVariant shape : StoneVariantBlock.StoneVariant.values()) {
            StoneVariantBlock block = MetaBlocks.STONE_BLOCKS.get(shape);
            variantListMap.put(shape,
                    Arrays.stream(StoneVariantBlock.StoneType.values())
                            .map(block::getItemVariant)
                            .collect(Collectors.toList()));
        }

        List<ItemStack> cobbles = variantListMap.get(StoneVariantBlock.StoneVariant.COBBLE);
        List<ItemStack> smooths = variantListMap.get(StoneVariantBlock.StoneVariant.SMOOTH);

        registerSmoothRecipe(susycobbles, susysmooths);
        registerCobbleRecipe(susysmooths, susycobbles);
        registerCobbleSmashingRecipe(susysmooths, susycobbles);
        registerCobbleSmashingRecipe(smooths, cobbles);
        registerMacerationToStoneDustRecipe();
    }

    private static void registerCobbleRecipe(List<ItemStack> smoothStack, List<ItemStack> cobbleStack) {
        for (int i = 0; i < smoothStack.size(); i++) {
            FORGE_HAMMER_RECIPES.recipeBuilder()
                    .inputs(smoothStack.get(i))
                    .outputs(cobbleStack.get(i))
                    .duration(12).EUt(4).buildAndRegister();
        }
    }

    private static void registerSmoothRecipe(List<ItemStack> roughStack, List<ItemStack> smoothStack) {
        for (int i = 0; i < roughStack.size(); i++) {
            ModHandler.addSmeltingRecipe(roughStack.get(i), smoothStack.get(i), 0.1f);

            EXTRUDER_RECIPES.recipeBuilder()
                    .inputs(roughStack.get(i))
                    .notConsumable(SHAPE_EXTRUDER_BLOCK.getStackForm())
                    .outputs(smoothStack.get(i))
                    .duration(24).EUt(8).buildAndRegister();
        }
    }


    private static void registerCobbleSmashingRecipe(List<ItemStack> smoothStack, List<ItemStack> cobbleStack) {
        for (int i = 0; i < smoothStack.size(); i++) {

            ModHandler.addShapedRecipe(smoothStack.get(i).getDisplayName() + "_hammer_smashing", cobbleStack.get(i), new Object[]{"hS", 'S', smoothStack.get(i)});
        }
    }

    private static void registerMacerationToStoneDustRecipe() {
        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Gabbro)
                .output(dust, SusyMaterials.Gabbro)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Gneiss)
                .output(dust, SusyMaterials.Gneiss)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Limestone)
                .output(dust, SusyMaterials.Limestone)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Phyllite)
                .output(dust, SusyMaterials.Phyllite)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, Materials.Quartzite)
                .output(dust, Materials.Quartzite)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Shale)
                .output(dust, SusyMaterials.Shale)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Slate)
                .output(dust, SusyMaterials.Slate)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, Materials.Soapstone)
                .output(dust, Materials.Soapstone)
                .buildAndRegister();


        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Kimberlite)
                .output(dust, SusyMaterials.Kimberlite)
                .buildAndRegister();

    }
}
