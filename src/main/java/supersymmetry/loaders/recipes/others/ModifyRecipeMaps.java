package supersymmetry.loaders.recipes.others;

import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.*;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtechfoodoption.GTFOMaterialHandler;
import gregtechfoodoption.item.GTFOMetaItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import supersymmetry.common.blocks.BlockResource;

import java.util.Arrays;
import java.util.Objects;

import static biomesoplenty.api.item.BOPItems.*;
import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.GTRecipeHandler.removeAllRecipes;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.ore.OrePrefix.gem;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.*;
import static gregtech.common.blocks.BlockSteamCasing.SteamCasingType.*;
import static gregtech.common.blocks.MetaBlocks.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static gregtechfoodoption.recipe.GTFORecipeMaps.*;
import static net.minecraft.init.Blocks.*;
import static net.minecraft.init.Items.*;
import static net.minecraft.init.Items.NETHER_WART;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.blocks.SuSyBlocks.RESOURCE_BLOCK;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.metatileentities.SuSyMetaTileEntities.*;

public class ModifyRecipeMaps {
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
        removeAllRecipes(GREENHOUSE_RECIPES);
        removeAllRecipes(VACUUM_RECIPES);
        removeAllRecipes(ELECTROLYZER_RECIPES);

        for(int i = 1; i < 35; i++){
            ModHandler.removeRecipeByName("notreepunching:saw_planks_" + i);
        }

        ModHandler.removeRecipeByName("notreepunching:misc/saw_log_sticks");
        ModHandler.removeRecipeByName("notreepunching:misc/saw_planks_sticks");

        // LPG * 370
        removeRecipesByInputs(CENTRIFUGE_RECIPES, Butane.getFluid(320));
        // LPG * 290
        removeRecipesByInputs(CENTRIFUGE_RECIPES, Propane.getFluid(320));
        // Water * 1000
        removeRecipesByInputs(CENTRIFUGE_RECIPES, BakingSodaSolution.getFluid(1000));
        // Clay Dust * 1
        removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Brick));
        // Epoxy Resin Pulp * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, ReinforcedEpoxyResin));
        // Clay Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Fireclay, 2));
        // Red sand centrifuging
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(SAND, 1, 1));
        // Nitrogen Dioxide * 3900
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, EnderAir.getFluid(10000));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Plutonium241));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Plutonium239));
        // Carbon Monoxide * 3900
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, NetherAir.getFluid(10000));
        // Nitrogen * 3900
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, Air.getFluid(10000));
        // Silicon Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(REDSTONE, 10));
        // Small Pile of Banded Iron Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, MetalMixture));
        // Silicon Dioxide Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, PlatinumSludgeResidue, 5));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Uranium235));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Uranium238));
        // Lead Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, LeadZincSolution.getFluid(1000));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(MYCELIUM));
        // Antimony Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Stibnite, 5));
        // Raw Platinum Powder * 3
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, PlatinumGroupSludge, 6)}, new FluidStack[]{AquaRegia.getFluid(1200)});
        // Small Pile of Redstone Dust * 2
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(GLOWSTONE_DUST, 2));
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
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(DIRT));
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(GRASS));
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
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(SOUL_SAND));
        // Methane * 60
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(RUBBER_LOG));
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
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BLAZE_POWDER, 2));
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
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(persimmon));
        // Methane * 35
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(PORKCHOP));
        // Methane * 94
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(PUMPKIN_PIE));
        // Methane * 126
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:golden_frog_leg'));
        // Methane * 144
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(RABBIT_STEW));
        // Methane * 35
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BEEF));
        // Methane * 12
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(POTATO));
        // Methane * 58
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(pear));
        // Methane * 130
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKED_PORKCHOP));
        // Methane * 35
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(RABBIT));
        // Methane * 40
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(ROTTEN_FLESH));
        // Methane * 18
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(RED_MUSHROOM));
        // Methane * 14
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BEETROOT));
        // Methane * 119
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(GOLDEN_CARROT));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(MUTTON));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(berries));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(MELON));
        // Methane * 18
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(NETHER_WART));
        // Methane * 47
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(APPLE));
        // Methane * 20
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(FISH));
        // Methane * 20
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(FISH, 1, 1));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(FISH, 1, 2));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(FISH, 1, 3));
        // Methane * 38
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(filled_honeycomb));
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
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BREAD));
        // Methane * 47
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack((CHORUS_FRUIT)));
        // Methane * 81
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:cooked_frog_leg'));
        // Methane * 72
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKED_FISH));
        // Methane * 97
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKED_FISH, 1, 1));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(CHICKEN));
        // Methane * 72
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKED_RABBIT));
        // Methane * 79
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(GOLDEN_APPLE));
        // Methane * 79
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(GOLDEN_APPLE, 1, 1));
        // Methane * 23
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:frog_leg'));
        // Methane * 130
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKED_BEEF));
        // Methane * 10
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(shroompowder));
        // Methane * 18
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BROWN_MUSHROOM));
        // Methane * 86
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKED_CHICKEN));
        // Methane * 12
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:crab_leg'));
        // Methane * 54
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(peach));
        // Methame * 56
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(ricebowl));
        // Methane * 86
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(MUSHROOM_STEW));
        // Methane * 130
        // removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, item('quark:cooked_crab_leg'));
        // Methane * 72
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BAKED_POTATO));
        // Methane * 86
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(BEETROOT_SOUP));
        // Methane * 23
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(POISONOUS_POTATO));
        // Methane * 32
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(SPIDER_EYE));
        // Methane * 20
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKIE));
        // Methane * 97
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(COOKED_MUTTON));
        // Methane * 43
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, new ItemStack(CARROT));

        // Iron Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, YellowLimonite, 4));
        // Iron Dust * 1
        removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, BrownLimonite, 4));

        // Baking Soda Solution * 1000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{ OreDictUnifier.get(OrePrefix.dust, SodiumBicarbonate) }, new FluidStack[]{ Water.getFluid(1000) });
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{ OreDictUnifier.get(OrePrefix.dust, SodiumBicarbonate) }, new FluidStack[]{ Water.getFluid(1000) });

        // Crushed Bauxite Ore * 1
        removeRecipesByInputs(FORGE_HAMMER_RECIPES, OreDictUnifier.get(ore, Bauxite));
        // Crushed Bauxite Ore * 2
        removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(ore, Bauxite));

        // Flower Pot * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack(BRICK, 3));

        // Carbon Dust * 2
        removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Coal));
        // Small Pile of Rare Earth * 1
        removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(dust, Monazite));

        ItemStack circuit = INTEGRATED_CIRCUIT.getStackForm();
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setInteger("Configuration", 1);
        circuit.setTagCompound(nbt);
        // Graphene Dust * 1
        removeRecipesByInputs(MIXER_RECIPES, OreDictUnifier.get(dust, Graphite), OreDictUnifier.get(dust, Silicon), OreDictUnifier.get(dust, Carbon, 4), circuit);
        removeRecipesByInputs(BLENDER_RECIPES, OreDictUnifier.get(dust, Graphite), OreDictUnifier.get(dust, Silicon), OreDictUnifier.get(dust, Carbon, 4), circuit);
        // Wrought Iron Ingot * 2
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Ilmenite, 10), OreDictUnifier.get(dust, Carbon, 4));
        // Hot Titanium Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, TitaniumTrifluoride, 4)}, new FluidStack[]{Hydrogen.getFluid(3000)});

        nbt.setInteger("Configuration", 2);
        circuit.setTagCompound(nbt);
        // Heated Water * 1000
        removeRecipesByInputs(FLUID_HEATER_RECIPES, new ItemStack[]{circuit}, new FluidStack[]{Water.getFluid(1000)}); // (circuit.id).withNbt("Configuration": 2)
        // Beryllium Oxide Plate * 1
        removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES, new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()}, new FluidStack[]{BerylliumOxide.getFluid(144)});
        // Beryllium Oxide Plate * 1
        removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(dust, BerylliumOxide));
        // Laminated Glass * 1
        removeRecipesByInputs(FORMING_PRESS_RECIPES, TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.TEMPERED_GLASS, 2), OreDictUnifier.get(plate, PolyvinylButyral));
        // Magnalium Ingot * 3
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{TURBINE_CASING.getItemVariant(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING)} , new FluidStack[]{Oxygen.getFluid(150)});
        // Magnalium Dust * 3
        removeRecipesByInputs(MACERATOR_RECIPES, TURBINE_CASING.getItemVariant(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING));
        // Gelatin Mixture * 4000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Collagen, 4)}, new FluidStack[]{PhosphoricAcid.getFluid(1000), Water.getFluid(3000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Collagen, 4)}, new FluidStack[]{PhosphoricAcid.getFluid(1000), Water.getFluid(3000)});
        // Phosphorus Dust * 1
        removeRecipesByInputs(CENTRIFUGE_RECIPES, GelatinMixture.getFluid(6000));
        // Reservoir Hatch * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, COVER_INFINITE_WATER.getStackForm(), MetaTileEntities.FLUID_EXPORT_HATCH[EV].getStackForm(), ELECTRIC_PUMP_EV.getStackForm());

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
                "gregtech:gregtech.machine.arc_furnace.lv",
                "gregtech:gregtech.machine.arc_furnace.mv",
                "gregtech:gregtech.machine.arc_furnace.hv",
                "gregtech:gregtech.machine.arc_furnace.ev",
                "gregtech:gregtech.machine.arc_furnace.iv",
                "gregtech:gregtech.machine.arc_furnace.luv",
                "gregtech:gregtech.machine.arc_furnace.zpm",
                "gregtech:gregtech.machine.arc_furnace.uv",
                "gregtech:gregtech.machine.chemical_reactor.lv",
                "gregtech:gregtech.machine.chemical_reactor.mv",
                "gregtech:gregtech.machine.chemical_reactor.hv",
                "gregtech:gregtech.machine.chemical_reactor.ev",
                "gregtech:gregtech.machine.chemical_reactor.iv",
                "gregtech:gregtech.machine.chemical_reactor.luv",
                "gregtech:gregtech.machine.chemical_reactor.zpm",
                "gregtech:gregtech.machine.chemical_reactor.uv"
        };

        Arrays.stream(name_removals).forEach(ModHandler::removeRecipeByName);

        ModHandler.removeFurnaceSmelting(new ItemStack(IRON_NUGGET));

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

        // Polycaprolactam Bar * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Caprolactam)}, new FluidStack[]{Nitrogen.getFluid(1000)});
        nbt.setInteger("Configuration", 2);
        circuit.setTagCompound(nbt);
        // Monocrystalline Silicon Boule * 1
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Silicon, 32), OreDictUnifier.get(dustSmall, GalliumArsenide), circuit);
        // Cupronickel Coil Block * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Cupronickel, 8), OreDictUnifier.get(foil, Bronze, 8)}, new FluidStack[]{TinAlloy.getFluid(144)});
        // Kanthal Coil Block * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Kanthal, 8), OreDictUnifier.get(foil, Aluminium, 8)}, new FluidStack[]{Copper.getFluid(144)});
        // Nichrome Coil Block * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, Nichrome, 8), OreDictUnifier.get(foil, StainlessSteel, 8)}, new FluidStack[]{Aluminium.getFluid(144)});
        // Aluminium Nugget * 3
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(gem, Ruby));
        // Aluminium Nugget * 3
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(gem, Sapphire));
        // Aluminium Nugget * 3
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(gem, GreenSapphire));
        // Aluminium Nugget * 3
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, GreenSapphire));
        // Aluminium Nugget * 3
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Sapphire));
        // Iron Dust * 1
        removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, Ferrochromium, 3));
        // Iron Dust * 6
        removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, StainlessSteel, 9));
        // Aluminium Ingot * 21
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{MetaTileEntities.PYROLYSE_OVEN.getStackForm()}, new FluidStack[]{Oxygen.getFluid(2493)});
        // Aluminium Dust * 21
        removeRecipesByInputs(MACERATOR_RECIPES, MetaTileEntities.PYROLYSE_OVEN.getStackForm());
        // Lapotron Crystal * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(gem, Lapotron), circuit);


        ModHandler.addShapelessRecipe("gregtech:salt_water_bucket",
                FluidUtil.getFilledBucket(SaltWater.getFluid(1000)),
                new UnificationEntry(dust, Salt),
                new UnificationEntry(dust, Salt),
                new ItemStack(WATER_BUCKET));

        ModHandler.addShapedRecipe(true, "gregtech:pbf_bronze",
                MetaTileEntities.PRIMITIVE_BLAST_FURNACE.getStackForm(), "hRS", "PBR", "dRS",
                'R', new UnificationEntry(stick, Bronze),
                'S', new UnificationEntry(screw, Bronze),
                'P', new UnificationEntry(plate, Bronze),
                'B', METAL_CASING.getItemVariant(PRIMITIVE_BRICKS));

        ModHandler.addShapedRecipe(true, "gregtech:coke_oven_bronze",
                COKE_OVEN.getStackForm(), "CPC", "PwP", "CPC",
                'C', METAL_CASING.getItemVariant(COKE_BRICKS),
                'P', new UnificationEntry(plate, Bronze));

        ModHandler.addShapedRecipe(true, "gregtech:drum_wood",
                WOODEN_DRUM.getStackForm(), "rDs", "WLW", "WLW",
                'D', STICKY_RESIN,
                'W', "plankWood",
                'L', new UnificationEntry(stickLong, Bronze));

        ModHandler.addShapedRecipe(true, "pig_iron_tiny_pile_manual",
                OreDictUnifier.get(dustTiny, PigIron), "h ", " N",
                'N', new UnificationEntry(nugget, PigIron));

        ModHandler.addShapedRecipe(true, "gregtech:steam_piston",
                STEAM_PISTON.getStackForm(), "PPP", "FSS", "FhB",
                'P', new UnificationEntry(plate, Bronze),
                'F', new UnificationEntry(pipeTinyFluid, Bronze),
                'S', new UnificationEntry(stick, Bronze),
                'B', new UnificationEntry(gearSmall, Bronze));


        //Steam Piston
        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(plate, Bronze, 3))
                .inputs(OreDictUnifier.get(stick, Bronze, 2))
                .inputs(OreDictUnifier.get(gearSmall, Bronze))
                .inputs(OreDictUnifier.get(pipeTinyFluid, Bronze, 2))
                .outputs(STEAM_PISTON.getStackForm())
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "gregtech:steam_motor",
                STEAM_MOTOR.getStackForm(), "PSP", "GSG", "XSX",
                'P', new UnificationEntry(plate, Bronze),
                'S', new UnificationEntry(stick, Bronze),
                'G', new UnificationEntry(gearSmall, Bronze),
                'X', STEAM_PISTON);

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(plate, Bronze, 2))
                .inputs(OreDictUnifier.get(stick, Bronze, 3))
                .inputs(OreDictUnifier.get(gearSmall, Bronze, 2))
                .inputs(STEAM_PISTON.getStackForm(2))
                .outputs(STEAM_MOTOR.getStackForm())
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "gregtech:steam_conveyor_rubber",
                CONVEYOR_STEAM.getStackForm(), "RRR", "MGM", "RRR",
                'R', new UnificationEntry(plate, Rubber),
                'M', STEAM_MOTOR,
                'G', new UnificationEntry(gearSmall, Bronze));
        ModHandler.addShapedRecipe(true, "gregtech:steam_conveyor_silicone",
                CONVEYOR_STEAM.getStackForm(), "RRR", "MGM", "RRR",
                'R', new UnificationEntry(plate, SiliconeRubber),
                'M', STEAM_MOTOR,
                'G', new UnificationEntry(gearSmall, Bronze));
        ModHandler.addShapedRecipe(true, "gregtech:steam_conveyor_styrene_butadiene",
                CONVEYOR_STEAM.getStackForm(), "RRR", "MGM", "RRR",
                'R', new UnificationEntry(plate, StyreneButadieneRubber),
                'M', STEAM_MOTOR,
                'G', new UnificationEntry(gearSmall, Bronze));

        ModHandler.addShapedRecipe(true, "gregtech:steam_pump_iron",
                PUMP_STEAM.getStackForm(), "SRB", "dFw", "BMF",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'F', new UnificationEntry(pipeTinyFluid, Bronze),
                'B', new UnificationEntry(ring, Iron),
                'M', STEAM_MOTOR);

        ModHandler.addShapedRecipe(true, "gregtech:steam_pump_brass",
                PUMP_STEAM.getStackForm(), "SRB", "dFw", "BMF",
                'S', new UnificationEntry(screw, Bronze),
                'R', new UnificationEntry(rotor, Bronze),
                'F', new UnificationEntry(pipeTinyFluid, Bronze),
                'B', new UnificationEntry(ring, Brass),
                'M', STEAM_MOTOR);

        ASSEMBLER_RECIPES.recipeBuilder()
                .inputs(OreDictUnifier.get(screw, Bronze))
                .inputs(OreDictUnifier.get(rotor, Bronze))
                .inputs(OreDictUnifier.get(ring, Iron, 2))
                .inputs(STEAM_MOTOR.getStackForm())
                .inputs(OreDictUnifier.get(pipeTinyFluid, Bronze, 2))
                .outputs(PUMP_STEAM.getStackForm())
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ModHandler.removeRecipeByOutput(MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm());
        ModHandler.addShapedRecipe(true, "gregtech:steam_extractor_bronze",
                STEAM_EXTRACTOR_BRONZE.getStackForm(), "FFF", "PXG", "FFF",
                'F', new UnificationEntry(pipeSmallFluid, Bronze),
                'P', STEAM_PISTON,
                'X', STEAM_CASING.getItemVariant(BRONZE_HULL),
                'G', new UnificationEntry(blockGlass));

        ModHandler.addShapedRecipe(true, "gregtech:steam_vacuum_chamber",
                STEAM_VACUUM_CHAMBER[0].getStackForm(), "FFF", "PXG", "FFF",
                'F', new UnificationEntry(pipeSmallFluid, Bronze),
                'P', PUMP_STEAM,
                'X', STEAM_CASING.getItemVariant(BRONZE_HULL),
                'G', new UnificationEntry(blockGlass));

        ModHandler.removeRecipeByOutput(STEAM_MACERATOR_BRONZE.getStackForm());
        ModHandler.addShapedRecipe(true, "gregtech:steam_macerator_bronze",
                STEAM_MACERATOR_BRONZE.getStackForm(), "BSB", "SXS", "PSP",
                'S', new UnificationEntry(pipeSmallFluid, Bronze),
                'P', STEAM_PISTON,
                'B', new UnificationEntry(toolHeadBuzzSaw, Steel),
                'X', STEAM_CASING.getItemVariant(BRONZE_HULL));

        ModHandler.removeRecipeByOutput(STEAM_COMPRESSOR_BRONZE.getStackForm());
        ModHandler.addShapedRecipe(true, "gregtech:steam_compressor_bronze",
                STEAM_COMPRESSOR_BRONZE.getStackForm(), "FFF", "PXP", "FFF",
                'F', new UnificationEntry(pipeSmallFluid, Bronze),
                'P', PUMP_STEAM,
                'X', STEAM_CASING.getItemVariant(BRONZE_HULL));

        ModHandler.removeRecipeByOutput(STEAM_HAMMER_BRONZE.getStackForm());
        ModHandler.addShapedRecipe(true, "gregtech:steam_hammer_bronze",
                STEAM_HAMMER_BRONZE.getStackForm(), "FPF", "FXF", "FAF",
                'F', new UnificationEntry(pipeSmallFluid, Bronze),
                'P', STEAM_PISTON,
                'A', new ItemStack(ANVIL),
                'X', STEAM_CASING.getItemVariant(BRONZE_HULL));

        ModHandler.removeRecipeByOutput(STEAM_ROCK_BREAKER_BRONZE.getStackForm());
        ModHandler.addShapedRecipe(true, "gregtech:steam_rock_breaker_bronze",
                STEAM_ROCK_BREAKER_BRONZE.getStackForm(), "PFP", "FXF", "DFD",
                'F', new UnificationEntry(pipeSmallFluid, Bronze),
                'P', STEAM_PISTON,
                'D', new UnificationEntry(gem, Diamond),
                'X', STEAM_CASING.getItemVariant(BRONZE_HULL));

        ModHandler.removeRecipeByOutput(MACERATOR[LV].getStackForm());
        ModHandler.addShapedRecipe(true, "gregtech:gregtech.machine.macerator.lv",
                MACERATOR[LV].getStackForm(), "PMH", "WWX", "CCW",
                'P', ELECTRIC_PISTON_LV,
                'M', ELECTRIC_MOTOR_LV,
                'H', new UnificationEntry(toolHeadBuzzSaw, Steel),
                'W', new UnificationEntry(cableGtSingle, Tin),
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.LV),
                'X', HULL[LV].getStackForm());

        ModHandler.addSmeltingRecipe(OreDictUnifier.get(dust, Limestone), OreDictUnifier.get(dust, Quicklime));

        //Remove old rubber recipes
        // Rubber Bar * 1
        removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(dust, Sulfur), OreDictUnifier.get(dust, RawRubber));

        //Slaked Lime
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Quicklime, 2)
                .fluidInputs(Water.getFluid(1000))
                .output(dust, CalciumHydroxide, 5)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        //Iron III chloride
        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(Iron3Chloride.getFluid(144))
                .output(dust, Iron3Chloride, 1)
                .duration(30)
                .EUt(16)
                .buildAndRegister();

        // Lava
        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(ChilledLava.getFluid(1000))
                .notConsumable(SHAPE_MOLD_BLOCK)
                .outputs(new ItemStack(OBSIDIAN))
                .duration(210)
                .EUt(16)
                .buildAndRegister();

        // coils
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Lava.getFluid(1000))
                .notConsumable(stick, Steel)
                .outputs(MINERAL_WOOL.getStackForm(16))
                .duration(500)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ChilledLava.getFluid(1000))
                .notConsumable(stick, Steel)
                .outputs(MINERAL_WOOL.getStackForm(16))
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(TinAlloy.getFluid(144))
                .input(wireGtDouble, Cupronickel, 8)
                .inputs(MINERAL_WOOL.getStackForm(8))
                .input(foil, Bronze, 8)
                .outputs(WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.CUPRONICKEL))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Copper.getFluid(144))
                .input(wireGtDouble, Kanthal, 8)
                .inputs(MINERAL_WOOL.getStackForm(8))
                .input(foil, Aluminium, 8)
                .outputs(WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.KANTHAL))
                .duration(300)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Aluminium.getFluid(144))
                .input(wireGtDouble, Nichrome, 8)
                .inputs(MINERAL_WOOL.getStackForm(8))
                .input(foil, StainlessSteel, 8)
                .outputs(WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.NICHROME))
                .duration(400)
                .EUt(480)
                .buildAndRegister();

        // Cleanroom Filter Casing
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Steel, 4)
                .input(foil, Aluminium, 8)
                .input(foil, Polypropylene, 16)
                .outputs(HEPA_FILTER.getStackForm())
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        ModHandler.removeRecipeByOutput(CLEANROOM_CASING.getItemVariant(BlockCleanroomCasing.CasingType.FILTER_CASING));
        ModHandler.addShapedRecipe(true, "gregtech:filter_casing",
                CLEANROOM_CASING.getItemVariant(BlockCleanroomCasing.CasingType.FILTER_CASING, 2), "III", "MSM", "FHF",
                'I', IRON_BARS,
                'M', ELECTRIC_MOTOR_MV,
                'S', new UnificationEntry(rotor, Steel),
                'F', new UnificationEntry(frameGt, Steel),
                'H', HEPA_FILTER);

        // Lights
        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtSingle, Tin, 2)
                .inputs(GRAPHITE_ELECTRODE.getStackForm())
                .inputs(GLASS_TUBE.getStackForm(8))
                .outputs(CARBON_ARC_LAMP.getStackForm(8))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        // Ore
        MACERATOR_RECIPES.recipeBuilder()
                .input(RESOURCE_BLOCK)
                .output(crushed, Bauxite, 4)
                .chancedOutput(OreDictUnifier.get(dust, Stone), 6700, 800)
                .duration(400)
                .EUt(2)
                .buildAndRegister();

        //Mud
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(Mud.getFluid(1000))
                .chancedOutput(new ItemStack(CLAY), 2500, 250)
                .chancedOutput(new ItemStack(SAND), 2500, 250)
                .chancedOutput(new ItemStack(GRAVEL), 2500, 250)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 2500, 250)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(Mud.getFluid(250))
                .notConsumable(SHAPE_MOLD_BALL)
                .outputs(new ItemStack(mudball))
                .duration(40)
                .EUt(4)
                .buildAndRegister();

        // Acetone * 200
        nbt.setInteger("Configuration", 1);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(FLUID_HEATER_RECIPES, new ItemStack[]{circuit}, new FluidStack[]{DissolvedCalciumAcetate.getFluid(200)});

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, PegmatiteTailings, 3)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .chancedOutput(new ItemStack(EMERALD), 1000, 250)
                .chancedOutput(OreDictUnifier.get(gem, Tourmaline), 1000, 250)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, GraniteTailings, 3)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Quartzite), 5000, 500)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, LimestoneTailings, 3)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, UltramaficTailings, 3)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Limestone), 5000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Magnesia), 2000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Magnetite), 1000, 500)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, Kimberlite)
                .chancedOutput(OreDictUnifier.get(dust, UltramaficTailings), 7500, 500)
                .chancedOutput(new ItemStack(DIAMOND), 1000, 500)
                .chancedOutput(OreDictUnifier.get(gem, Pyrope), 500, 250)
                .chancedOutput(OreDictUnifier.get(gem, Almandine), 500, 250)
                .chancedOutput(new ItemStack(DYE, 1, 4), 500, 250)
                .chancedOutput(OreDictUnifier.get(dust, Chromite), 500, 250)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, Corundum)
                .chancedOutput(OreDictUnifier.get(dust, UltramaficTailings), 7500, 500)
                .chancedOutput(OreDictUnifier.get(gem, Ruby), 1000, 250)
                .chancedOutput(OreDictUnifier.get(gem, Sapphire), 1000, 250)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.NON_MARINE_EVAPORITE))
                .output(dust, NonMarineEvaporite, 4)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.SULFATE_EVAPORITE))
                .output(dust, SulfateEvaporite, 4)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.CARBONATE_EVAPORITE))
                .output(dust, CarbonateEvaporite, 4)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.HALIDE_EVAPORITE))
                .output(dust, HalideEvaporite, 4)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.PHOSPHORITE))
                .output(dust, Phosphorite, 8)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.POTASH))
                .output(dust, PotashConcentrate, 8)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.SULFUR))
                .output(dust, Sulfur, 8)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, NonMarineEvaporite)
                .chancedOutput(OreDictUnifier.get(dust, Salt), 8000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Borax), 7000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Trona), 5000, 250)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, SulfateEvaporite)
                .chancedOutput(OreDictUnifier.get(dust, Salt), 8000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Gypsum), 5000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Kieserite), 5000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Langbeinite), 5000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Polyhalite), 5000, 250)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, CarbonateEvaporite)
                .chancedOutput(OreDictUnifier.get(dust, Salt), 8000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Dolomite), 5000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Calcite), 5000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Magnesite), 5000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Trona), 5000, 250)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, HalideEvaporite)
                .chancedOutput(OreDictUnifier.get(dust, Salt), 8000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Salt), 8000, 500)
                .chancedOutput(OreDictUnifier.get(dust, Carnallite), 7000, 250)
                .chancedOutput(OreDictUnifier.get(dust, Kainite), 5000, 250)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Limestone)
                .output(dust, Calcite)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        PACKER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(SAND))
                .outputs(SAND_DUST.getStackForm(4))
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "gregtech:fluid_filter_brass",
                FLUID_FILTER.getStackForm(), "FFF", "FPF", "FFF",
                'F', new UnificationEntry(foil, Zinc),
                'P', new UnificationEntry(plate, Brass));

        ModHandler.addShapedRecipe(true, "gregtech:brass_drum",
                BRASS_DRUM.getStackForm(), " h ", "PSP", "PSP",
                'P', new UnificationEntry(plate, Brass),
                'S', new UnificationEntry(stickLong, Brass));

        ModHandler.addShapedRecipe(true, "gregtech:electrolytic_cell",
                ELECTROLYTIC_CELL.getStackForm(), "PCP", "WXW", "CTC",
                'P', new UnificationEntry(plate, Steel),
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.LV),
                'W', new UnificationEntry(wireGtQuadruple, Tin),
                'T', new UnificationEntry(cableGtSingle, Tin),
                'X', HULL[LV].getStackForm());

        ModHandler.addShapedRecipe(true, "gregtech:prospector_lead_acid",
                PROSPECTOR_LV.getStackForm(), "EPS", "CGC", "PBP",
                'E', EMITTER_LV,
                'S', SENSOR_LV,
                'P', new UnificationEntry(plate, Steel),
                'G', new UnificationEntry(plate, Glass),
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.LV),
                'B', BATTERY_LEAD_ACID);

        LATEX_COLLECTOR_RECIPES.recipeBuilder()
                .notConsumable(Water.getFluid(10))
                .fluidOutputs(Latex.getFluid(100))
                .blockStates("latex_logs", MetaBlocks.RUBBER_LOG.getBlockState())
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        LATEX_COLLECTOR_RECIPES.recipeBuilder()
                .notConsumable(DistilledWater.getFluid(10))
                .fluidOutputs(Resin.getFluid(100))
                .blockStates("extractable_logs_1", Blocks.LOG.getBlockState())
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        LATEX_COLLECTOR_RECIPES.recipeBuilder()
                .notConsumable(Lubricant.getFluid(10))
                .fluidOutputs(Resin.getFluid(100))
                .blockStates("extractable_logs_2", Blocks.LOG2.getBlockState())
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, RawRubber)}, new FluidStack[]{Concrete.getFluid(576)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, RawRubber)}, new FluidStack[]{Concrete.getFluid(576)});

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Rubber)
                .fluidInputs(Concrete.getFluid(576))
                .fluidOutputs(ConstructionFoam.getFluid(1000))
                .duration(20)
                .EUt(16)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Anthracite)
                .chancedOutput(OreDictUnifier.get(dust, Carbon), 9000, 0)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Coal)
                .chancedOutput(OreDictUnifier.get(dust, Carbon), 7500, 0)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Charcoal)
                .chancedOutput(OreDictUnifier.get(dust, Carbon), 6000, 0)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Coke)
                .output(dust, Carbon)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Diamond)
                .output(dust, Carbon)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .output(dust, Carbon)
                .duration(40)
                .EUt(30)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "gregtech:lv_magnet_lead_acid",
                ITEM_MAGNET_LV.getStackForm(), "SwS", "SBS", "CPC",
                'S', new UnificationEntry(stick, SteelMagnetic),
                'B', BATTERY_LEAD_ACID,
                'C', new UnificationEntry(cableGtSingle, Tin),
                'P', new UnificationEntry(plate, Steel));

        ModHandler.addShapedRecipe(true, "gregtech:lv_power_unit_lead_acid",
                POWER_UNIT_LV.getStackForm(), "S d", "GMG", "PBP",
                'S', new UnificationEntry(screw, Steel),
                'B', BATTERY_LEAD_ACID,
                'G', new UnificationEntry(gearSmall, Steel),
                'M', ELECTRIC_MOTOR_LV,
                'P', new UnificationEntry(plate, Steel));

        ModHandler.addShapedRecipe(true, "gregtech:distillation_tower",
                DISTILLATION_TOWER.getStackForm(), "CPC", "EXE", "CPC",
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.HV),
                'P', new UnificationEntry(pipeLargeFluid, StainlessSteel),
                'E', ELECTRIC_MOTOR_MV,
                'X', HULL[MV].getStackForm());

        FORMING_PRESS_RECIPES.recipeBuilder()
                .inputs(TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.TEMPERED_GLASS))
                .input(plate, PolyvinylButyral, 2)
                .input(plate, Polycarbonate, 2)
                .outputs(TRANSPARENT_CASING.getItemVariant(BlockGlassCasing.CasingType.LAMINATED_GLASS))
                .duration(200)
                .EUt(480)
                .buildAndRegister();

        // Nickel Zinc Ferrite * 864
        nbt.setInteger("Configuration", 6);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Nickel),
                        OreDictUnifier.get(dust, Zinc),
                        OreDictUnifier.get(dust, Iron, 4),
                        circuit
                },
                new FluidStack[]{Oxygen.getFluid(8000)});
        // Molten Yttrium Barium Cuprate * 1872
        nbt.setInteger("Configuration", 14);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Yttrium),
                        OreDictUnifier.get(dust, Barium, 2),
                        OreDictUnifier.get(dust, Copper, 3),
                        circuit
                },
                new FluidStack[]{Oxygen.getFluid(7000), Argon.getFluid(650)});
        // Molten Yttrium Barium Cuprate * 1872
        nbt.setInteger("Configuration", 4);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Yttrium),
                        OreDictUnifier.get(dust, Barium, 2),
                        OreDictUnifier.get(dust, Copper, 3),
                        circuit
                },
                new FluidStack[]{Oxygen.getFluid(7000)});
        // Molten Mercury Barium Calcium Cuprate * 2304
        nbt.setInteger("Configuration", 5);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Barium, 2),
                        OreDictUnifier.get(dust, Calcium, 2),
                        OreDictUnifier.get(dust, Copper, 3),
                        circuit
                },
                new FluidStack[]{Mercury.getFluid(1000), Oxygen.getFluid(8000)});
        // Molten Mercury Barium Calcium Cuprate * 2304
        nbt.setInteger("Configuration", 15);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Barium, 2),
                        OreDictUnifier.get(dust, Calcium, 2),
                        OreDictUnifier.get(dust, Copper, 3),
                        circuit
                },
                new FluidStack[]{Mercury.getFluid(1000), Oxygen.getFluid(8000), Nitrogen.getFluid(14000)});
        // Molten Indium Tin Barium Titanium Cuprate * 2304
        nbt.setInteger("Configuration", 16);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Indium, 4),
                        OreDictUnifier.get(dust, Tin, 2),
                        OreDictUnifier.get(dust, Barium, 2),
                        OreDictUnifier.get(dust, Titanium),
                        OreDictUnifier.get(dust, Copper, 7),
                        circuit
                },
                new FluidStack[]{Oxygen.getFluid(9000), Argon.getFluid(800)});
        // Molten Indium Tin Barium Titanium Cuprate * 2304
        nbt.setInteger("Configuration", 6);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Indium, 4),
                        OreDictUnifier.get(dust, Tin, 2),
                        OreDictUnifier.get(dust, Barium, 2),
                        OreDictUnifier.get(dust, Titanium), OreDictUnifier.get(dust, Copper, 7),
                        circuit
                },
                new FluidStack[]{Oxygen.getFluid(9000)});
        // Molten Samarium Iron Arsenic Oxide * 576
        nbt.setInteger("Configuration", 14);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Samarium),
                        OreDictUnifier.get(dust, Iron),
                        OreDictUnifier.get(dust, Arsenic),
                        circuit
                },
                new FluidStack[]{Oxygen.getFluid(1000), Helium.getFluid(400)});
        // Molten Samarium Iron Arsenic Oxide * 576
        nbt.setInteger("Configuration", 4);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ALLOY_BLAST_RECIPES,
                new ItemStack[]{
                        OreDictUnifier.get(dust, Samarium),
                        OreDictUnifier.get(dust, Iron),
                        OreDictUnifier.get(dust, Arsenic),
                        circuit
                },
                new FluidStack[]{Oxygen.getFluid(1000)});

//        // NAND Chip * 8
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{GOOD_CIRCUIT_BOARD.getStackForm(), SIMPLE_SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(bolt, RedAlloy, 2), OreDictUnifier.get(wireFine, Tin)}, new FluidStack[]{SolderingAlloy.getFluid(72)});
//        // NAND Chip * 8
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{GOOD_CIRCUIT_BOARD.getStackForm(), SIMPLE_SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(bolt, RedAlloy, 2), OreDictUnifier.get(wireFine, Tin)}, new FluidStack[]{Tin.getFluid(144)});
//        // NAND Chip * 12
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(), SIMPLE_SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(bolt, RedAlloy, 2), OreDictUnifier.get(wireFine, Tin)}, new FluidStack[]{SolderingAlloy.getFluid(72)});
//        // NAND Chip * 12
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(), SIMPLE_SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(bolt, RedAlloy, 2), OreDictUnifier.get(wireFine, Tin)}, new FluidStack[]{Tin.getFluid(144)});
//
//        // Microprocessor * 3
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(), CENTRAL_PROCESSING_UNIT.getStackForm(), RESISTOR.getStackForm(2), CAPACITOR.getStackForm(2), TRANSISTOR.getStackForm(2), OreDictUnifier.get(wireFine, Copper, 2)}, new FluidStack[]{SolderingAlloy.getFluid(72)});
//        // Microprocessor * 3
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(), CENTRAL_PROCESSING_UNIT.getStackForm(), RESISTOR.getStackForm(2), CAPACITOR.getStackForm(2), TRANSISTOR.getStackForm(2), OreDictUnifier.get(wireFine, Copper, 2)}, new FluidStack[]{Tin.getFluid(144)});
//        // Microprocessor * 6
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(), SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(wireFine, Copper, 2), OreDictUnifier.get(bolt, Tin, 2)}, new FluidStack[]{SolderingAlloy.getFluid(72)});
//        // Microprocessor * 6
//        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{PLASTIC_CIRCUIT_BOARD.getStackForm(), SYSTEM_ON_CHIP.getStackForm(), OreDictUnifier.get(wireFine, Copper, 2), OreDictUnifier.get(bolt, Tin, 2)}, new FluidStack[]{Tin.getFluid(144)});

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SoybeanOil.getFluid(1000))
                .fluidOutputs(SeedOil.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        // Steel Turbine Casing * 2
        ModHandler.removeRecipeByName("gregtech:casing_steel_turbine_casing");
        ModHandler.addShapedRecipe(true, "gregtech:casing_steel_turbine_casing",
                TURBINE_CASING.getItemVariant(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING, 4), "PhP", "LCL", "PwP",
                'P', new UnificationEntry(plate, Steel),
                'L', new UnificationEntry(stickLong, Steel),
                'C', STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(StoneVariantBlock.StoneType.CONCRETE_LIGHT));
        nbt.setInteger("Configuration", 6);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(plate, Magnalium, 6), OreDictUnifier.get(frameGt, BlueSteel), circuit);
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(stickLong, Steel, 2)
                .input(plate, Steel, 4)
                .inputs(STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(StoneVariantBlock.StoneType.CONCRETE_LIGHT))
                .outputs(TURBINE_CASING.getItemVariant(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING, 4))
                .duration(50)
                .EUt(16)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(SulfuricDiesel.getFluid(16))
                .duration(5)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(Diesel.getFluid(8))
                .duration(15)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(SulfuricFuelOil.getFluid(16))
                .duration(7)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(FuelOil.getFluid(8))
                .duration(21)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(SulfuricRefineryGas.getFluid(16))
                .duration(4)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(RefineryGas.getFluid(8))
                .duration(12)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(SulfuricRefineryGas.getFluid(16))
                .duration(4)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(NaturalGas.getFluid(8))
                .duration(12)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(Propane.getFluid(8))
                .duration(15)
                .EUt(-32)
                .buildAndRegister();

        SEMI_FLUID_GENERATOR_FUELS.recipeBuilder()
                .fluidInputs(Stearin.getFluid(8))
                .duration(15)
                .EUt(-32)
                .buildAndRegister();

        removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES, new ItemStack[]{SHAPE_MOLD_BLOCK.getStackForm()}, new FluidStack[]{Concrete.getFluid(144)});

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_BLOCK.getStackForm())
                .fluidInputs(Concrete.getFluid(144))
                .outputs(STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(StoneVariantBlock.StoneType.CONCRETE_LIGHT, 4))
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        // ---------- Multiblock components rebalance ----------

        // Solid Steel Machine Casing * 2
        nbt.setInteger("Configuration", 6);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(plate, Steel, 6), OreDictUnifier.get(frameGt, Steel), circuit);
        ModHandler.addShapedRecipe(true, "gregtech:casing_steel_solid",
                METAL_CASING.getItemVariant(STEEL_SOLID, 4), "PhP", "PFP", "PwP",
                'P', new UnificationEntry(plate, Steel),
                'F', new UnificationEntry(frameGt, Steel));
        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(plate, Steel, 6)
                .input(frameGt, Steel)
                .outputs(METAL_CASING.getItemVariant(STEEL_SOLID, 4))
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        // Steel Frame Box * 1
        nbt.setInteger("Configuration", 4);
        circuit.setTagCompound(nbt);
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(stick, Steel, 4), circuit);
        ModHandler.removeRecipeByName("gregtech:frame_steel");
        ModHandler.addShapedRecipe(true, "gregtech:frame_steel",
                OreDictUnifier.get(frameGt, Steel, 4), "SSS", "SwS", "SSS",
                'S', new UnificationEntry(stick, Steel));

        //Steel Pipe Casing
        ModHandler.removeRecipeByName("gregtech:casing_steel_pipe");
        ModHandler.addShapedRecipe(true, "gregtech:casing_steel_pipe",
                BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE, 4), "PFP", "FBF", "PFP",
                'P', new UnificationEntry(plate, Steel),
                'F', new UnificationEntry(pipeNormalFluid, Steel),
                'B', new UnificationEntry(frameGt, Steel));

        //Steel Firebox Casing
        ModHandler.removeRecipeByName("gregtech:casing_steel_firebox");
        ModHandler.addShapedRecipe(true, "gregtech:casing_steel_firebox",
                BOILER_FIREBOX_CASING.getItemVariant(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX, 4), "PSP", "SBS", "PSP",
                'P', new UnificationEntry(plate, Steel),
                'S', new UnificationEntry(stick, Steel),
                'B', new UnificationEntry(frameGt, Steel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(stick, Steel, 4)
                .output(frameGt, Steel, 2)
                .EUt(7)
                .duration(60)
                .buildAndRegister();

        // Steel components recycling

        // Steel Dust * 4
        removeRecipesByInputs(MACERATOR_RECIPES, METAL_CASING.getItemVariant(STEEL_SOLID, 4));
        // Steel Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{METAL_CASING.getItemVariant(STEEL_SOLID, 4)}, new FluidStack[]{Oxygen.getFluid(224)});

        // Steel Dust * 9
        removeRecipesByInputs(MACERATOR_RECIPES, BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE, 4));
        // Block of Steel * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE)}, new FluidStack[]{Oxygen.getFluid(504)});

        // Steel Dust * 4
        removeRecipesByInputs(MACERATOR_RECIPES, BOILER_FIREBOX_CASING.getItemVariant(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX));
        // Steel Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{BOILER_FIREBOX_CASING.getItemVariant(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX)}, new FluidStack[]{Oxygen.getFluid(224)});

        // Steel Dust * 2
        removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(frameGt, Steel));
        // Steel Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(frameGt, Steel)}, new FluidStack[]{Oxygen.getFluid(112)});
        // Steel * 288
        removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(frameGt, Steel));

        // Solid Steel Casing
        MACERATOR_RECIPES.recipeBuilder()
                .inputs(METAL_CASING.getItemVariant(STEEL_SOLID, 4))
                .output(dust, Steel, 2)
                .duration(220)
                .EUt(8)
                .buildAndRegister();

        ARC_FURNACE_RECIPES.recipeBuilder()
                .inputs(METAL_CASING.getItemVariant(STEEL_SOLID, 4))
                .fluidInputs(Oxygen.getFluid(224))
                .output(ingot, Steel, 2)
                .duration(220)
                .EUt(30)
                .buildAndRegister();

        // Steel Pipe Casing
        MACERATOR_RECIPES.recipeBuilder()
                .inputs(BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE))
                .output(dust, Steel, 4)
                .duration(220)
                .EUt(8)
                .buildAndRegister();

        ARC_FURNACE_RECIPES.recipeBuilder()
                .inputs(BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE))
                .fluidInputs(Oxygen.getFluid(504))
                .output(ingot, Steel, 4)
                .duration(220)
                .EUt(30)
                .buildAndRegister();

        // Steel Fireboxes
        MACERATOR_RECIPES.recipeBuilder()
                .inputs(BOILER_FIREBOX_CASING.getItemVariant(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX))
                .output(dust, Steel, 2)
                .duration(220)
                .EUt(8)
                .buildAndRegister();

        ARC_FURNACE_RECIPES.recipeBuilder()
                .inputs(BOILER_FIREBOX_CASING.getItemVariant(BlockFireboxCasing.FireboxCasingType.STEEL_FIREBOX))
                .fluidInputs(Oxygen.getFluid(224))
                .output(ingot, Steel, 4)
                .duration(220)
                .EUt(30)
                .buildAndRegister();

        // Steel Frameboxes
        MACERATOR_RECIPES.recipeBuilder()
                .input(frameGt, Steel)
                .output(dust, Steel)
                .duration(220)
                .EUt(8)
                .buildAndRegister();

        ARC_FURNACE_RECIPES.recipeBuilder()
                .input(frameGt, Steel)
                .fluidInputs(Oxygen.getFluid(112))
                .output(ingot, Steel)
                .duration(220)
                .EUt(30)
                .buildAndRegister();

        // ULV Input Bus * 1
        ModHandler.addShapedRecipe("gregtech:item_bus.import.ulv",
                ITEM_IMPORT_BUS[ULV].getStackForm(), " C ", " H ", "   ",
                'C', "chestWood",
                'H', HULL[ULV].getStackForm());

        // ULV Output Bus * 1
        ModHandler.addShapedRecipe("gregtech:item_bus.export.ulv",
                ITEM_EXPORT_BUS[ULV].getStackForm(), "   ", " H ", " C ",
                'C', "chestWood",
                'H', HULL[ULV].getStackForm());

        // ULV Input Hatch * 1
        ModHandler.addShapedRecipe("gregtech:fluid_hatch.import.ulv",
                FLUID_IMPORT_HATCH[ULV].getStackForm(), " G ", " H ", "   ",
                'G', new UnificationEntry(blockGlass),
                'H', HULL[ULV].getStackForm());

        // ULV Output Hatch * 1
        ModHandler.addShapedRecipe("gregtech:fluid_hatch.export.ulv",
                FLUID_EXPORT_HATCH[ULV].getStackForm(), "   ", " H ", " G ",
                'G', new UnificationEntry(blockGlass),
                'H', HULL[ULV].getStackForm());

        VACUUM_RECIPES.recipeBuilder()
                .inputs(GTFOMaterialHandler.MATTER_GRAHAM_HOT.getItemStack())
                .outputs(GTFOMetaItem.GRAHAM_CRACKER.getStackForm())
                .EUt(60)
                .duration(20)
                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .inputs(GTFOMaterialHandler.HotAppleHardCandy.getItemStack())
                .outputs(GTFOMetaItem.APPLE_HARD_CANDY.getStackForm())
                .EUt(5)
                .duration(200)
                .buildAndRegister();
    }
}
