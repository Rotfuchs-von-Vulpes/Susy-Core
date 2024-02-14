package supersymmetry.loaders.recipes.misc;

import biomesoplenty.api.item.BOPItems;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.StoneVariantBlock;
import gregtech.common.items.MetaItems;
import gregtechfoodoption.item.GTFOMetaItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import supersymmetry.api.unification.ore.SusyStoneTypes;
import supersymmetry.common.blocks.*;

import static supersymmetry.common.blocks.SuSyBlocks.*;
import static supersymmetry.common.blocks.SusyStoneVariantBlock.*;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static biomesoplenty.api.item.BOPItems.mudball;
import static com.alcatrazescapee.notreepunching.common.items.ModItems.GRASS_FIBER;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS;
import static gregtech.common.blocks.MetaBlocks.METAL_CASING;
import static gregtech.common.items.MetaItems.*;
import gregtechfoodoption.item.GTFOMetaItem.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class BrickChain {
    private static void CompressBrickRecipes(ItemStack brick_mix, ItemStack compressed_brick) {
        ModHandler.addShapelessRecipe("Compress" + brick_mix.getDisplayName() + "_1", compressed_brick, MetaItems.WOODEN_FORM_BRICK, brick_mix);
        compressed_brick.setCount(8);
        ModHandler.addShapedRecipe(false, "Compress" + brick_mix.getDisplayName() + "_8", compressed_brick,
                "MMM", "MWM", "MMM",
                'M', brick_mix,
                'W', MetaItems.WOODEN_FORM_BRICK);
    }
    public static void init() {
        String[] name_removals = {
                "gregtech:fireclay_dust",
                "gregtechfoodoption:mud_bricks1",
                "gregtechfoodoption:mud_bricks2",
                "gregtechfoodoption:mud_bricks3",
                "gregtechfoodoption:mud_bricks4",
                "gregtech:casing_primitive_bricks"
        };

        Arrays.stream(name_removals).forEach(ModHandler::removeRecipeByName);

        ModHandler.addSmeltingRecipe(
                SUSY_STONE_BLOCKS.get(StoneVariant.COBBLE).getItemVariant(StoneType.LIMESTONE),
                OreDictUnifier.get(dust, Quicklime));
        ModHandler.addShapedRecipe("slaked_lime_manual", OreDictUnifier.get(dust, CalciumHydroxide, 8),
                "XXX", "XYX", "XXX",
                'X', OreDictUnifier.get(dust, Quicklime),
                'Y', new ItemStack(Items.WATER_BUCKET));
        ModHandler.addShapelessRecipe("ManualFineSandPile", SAND_DUST.getStackForm(4), Blocks.SAND);
        ModHandler.addShapelessRecipe("ManualFireclay", OreDictUnifier.get(dust, Fireclay, 4),
                SAND_DUST.getStackForm(),
                OreDictUnifier.get(dust, CalciumHydroxide),
                OreDictUnifier.get(dust, Clay),
                OreDictUnifier.get(dust, Flint));
        CompressBrickRecipes(OreDictUnifier.get(dust, Fireclay), FIRECLAY_BRICK.getStackForm());
        ModHandler.addShapedRecipe("pfb_casing_firebricks",
                METAL_CASING.getItemVariant(PRIMITIVE_BRICKS), "BB", "BB",
                'B', FIRECLAY_BRICK);

        ModHandler.addShapedRecipe("StrawCutting", STRAW.getStackForm(2), "k", "X",
                'X', new ItemStack(GRASS_FIBER));
        ModHandler.addShapelessRecipe("ManualMudbrickMix", MUDBRICK_MIX.getStackForm(4),
                mudball, SAND_DUST.getStackForm(), STRAW.getStackForm(), Items.CLAY_BALL);
        CompressBrickRecipes(MUDBRICK_MIX.getStackForm(), GTFOMetaItem.ADOBE_BRICK.getStackForm());
    }
}
