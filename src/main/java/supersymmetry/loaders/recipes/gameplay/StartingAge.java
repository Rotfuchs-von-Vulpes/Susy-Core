package supersymmetry.loaders.recipes.gameplay;

import appeng.api.AEApi;
import appeng.api.definitions.IDefinitions;
import appeng.api.features.IGrinderRecipeBuilder;
import appeng.api.features.IGrinderRegistry;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import supersymmetry.common.blocks.BlockResource;

import java.util.HashMap;
import java.util.Map;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
//import static net.minecraft.init.Blocks.*;
//import static net.minecraft.init.Items.REEDS;
//import static net.minecraft.init.Items.WHEAT;
import static supersymmetry.common.blocks.SuSyBlocks.RESOURCE_BLOCK;
import static supersymmetry.common.item.SuSyMetaItems.CHUNK_MAGNETITE;
import static supersymmetry.common.materials.SusyMaterials.*;
;

public class StartingAge {

    private static final IGrinderRegistry reg = AEApi.instance().registries().grinder();
    public static void init() {
        String[] name_removals = {
                "notreepunching:tools/iron_saw",
                "notreepunching:tools/gold_saw",
                "notreepunching:tools/diamond_saw",
                "notreepunching:misc/clay_tool_clay_brick_2",
                "notreepunching:misc/clay_tool_clay_brick",
                "notreepunching:tools/iron_knife",
                "notreepunching:tools/gold_knife",
                "notreepunching:tools/diamond_knife"
        };

        for (String name : name_removals) {
            ModHandler.removeRecipeByName(name);
        }

        ModHandler.removeRecipeByName("gregtech:clay_block_to_dust");
        ModHandler.addShapelessRecipe("gregtech:clay_block_to_dust", OreDictUnifier.get(dust, Clay, 4), new UnificationEntry(block, Clay), 'm');

//        ModHandler.addShapelessRecipe("fiber_from_reeds", new ItemStack(GRASS_FIBER, 2), new ItemStack(REEDS), 'k');
//        ModHandler.addShapelessRecipe("fiber_from_wheat", new ItemStack(GRASS_FIBER, 2), new ItemStack(WHEAT), 'k');
//        ModHandler.addShapelessRecipe("fiber_from_grass", new ItemStack(GRASS_FIBER), new ItemStack(TALLGRASS, 1, 1), 'k');
//        ModHandler.addShapelessRecipe("fiber_from_fern", new ItemStack(GRASS_FIBER), new ItemStack(TALLGRASS, 1, 2), 'k');
//        ModHandler.addShapelessRecipe("fiber_from_leaves", new ItemStack(GRASS_FIBER), "treeLeaves", 'k');

        ModHandler.addShapelessRecipe("gregtech:clay_block_to_ball", OreDictUnifier.get(dust, Clay), new UnificationEntry(ingot, Clay), 'm');
//        ModHandler.addShapelessRecipe("gregtech:mud_block_to_ball", new ItemStack(mudball, 4), new ItemStack(mud));

        ModHandler.addShapelessRecipe("gregtech:magnetite_chunk", CHUNK_MAGNETITE.getStackForm(), new UnificationEntry(ore, Magnetite), "rock");
        ModHandler.addShapelessRecipe("gregtech:magnetite_chunk_1", CHUNK_MAGNETITE.getStackForm(), new UnificationEntry(ore, VanadiumMagnetite), "rock");

        IDefinitions definitions = AEApi.instance().definitions();
        ItemStack grindstone = definitions.blocks().grindstone().maybeStack(1).orElse(ItemStack.EMPTY);
        ModHandler.addShapedRecipe(true, "appliedenergistics2:misc/grindstone",
                grindstone, "S S", "GfG", "CCC",
                'S', new UnificationEntry(stone),
                'G', new UnificationEntry(gear, Bronze),
                'C', "cobblestone");

        Map<ItemStack, ItemStack> GrindstoneMap = new HashMap<>();

        GrindstoneMap.put(OreDictUnifier.get(ore, Acanthite), OreDictUnifier.get(crushed, Acanthite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Anglesite), OreDictUnifier.get(crushed, Anglesite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Sphalerite), OreDictUnifier.get(crushed, Sphalerite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Chlorapatite), OreDictUnifier.get(crushed, Chlorapatite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Fluorapatite), OreDictUnifier.get(crushed, Fluorapatite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Arsenopyrite), OreDictUnifier.get(crushed, Arsenopyrite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Pyrite), OreDictUnifier.get(crushed, Pyrite));
        GrindstoneMap.put(OreDictUnifier.get(ore, BandedIron), OreDictUnifier.get(crushed, BandedIron));
        GrindstoneMap.put(OreDictUnifier.get(ore, Magnetite), OreDictUnifier.get(crushed, Magnetite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Bornite), OreDictUnifier.get(crushed, Bornite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Chalcopyrite), OreDictUnifier.get(crushed, Chalcopyrite));
        GrindstoneMap.put(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.NON_MARINE_EVAPORITE), OreDictUnifier.get(dust, Salt));
        GrindstoneMap.put(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.HALIDE_EVAPORITE), OreDictUnifier.get(dust, Salt));
        GrindstoneMap.put(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.SULFATE_EVAPORITE), OreDictUnifier.get(dust, Salt));
        GrindstoneMap.put(RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.CARBONATE_EVAPORITE), OreDictUnifier.get(dust, Salt));
        GrindstoneMap.put(OreDictUnifier.get(ore, Cassiterite), OreDictUnifier.get(crushed, Cassiterite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Cerussite), OreDictUnifier.get(crushed, Cerussite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Cinnabar), OreDictUnifier.get(crushed, Cinnabar));
        GrindstoneMap.put(OreDictUnifier.get(ore, Stibnite), OreDictUnifier.get(crushed, Stibnite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Coal), OreDictUnifier.get(crushed, Coal));
        GrindstoneMap.put(OreDictUnifier.get(ore, Fluorite), OreDictUnifier.get(crushed, Fluorite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Galena), OreDictUnifier.get(crushed, Galena));
        GrindstoneMap.put(OreDictUnifier.get(ore, Lapis), OreDictUnifier.get(crushed, Lapis));
        GrindstoneMap.put(OreDictUnifier.get(ore, Lazurite), OreDictUnifier.get(crushed, Lazurite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Sodalite), OreDictUnifier.get(crushed, Sodalite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Lignite), OreDictUnifier.get(crushed, Lignite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Malachite), OreDictUnifier.get(crushed, Malachite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Proustite), OreDictUnifier.get(crushed, Proustite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Pyrolusite), OreDictUnifier.get(crushed, Pyrolusite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Realgar), OreDictUnifier.get(crushed, Realgar));
        GrindstoneMap.put(OreDictUnifier.get(ore, Redstone), OreDictUnifier.get(crushed, Redstone));
        GrindstoneMap.put(OreDictUnifier.get(ore, Saltpeter), OreDictUnifier.get(crushed, Saltpeter));
        GrindstoneMap.put(OreDictUnifier.get(ore, Chalcocite), OreDictUnifier.get(crushed, Chalcocite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Enargite), OreDictUnifier.get(crushed, Enargite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Tetrahedrite), OreDictUnifier.get(crushed, Tetrahedrite));
        GrindstoneMap.put(OreDictUnifier.get(ore, Anthracite), OreDictUnifier.get(crushed, Anthracite));

        GrindstoneMap.forEach((key, value) -> {
            final IGrinderRecipeBuilder builder = reg.builder();

            key.setCount(2);
            value.setCount(3);

            builder.withInput(key);
            builder.withOutput(value);
            builder.withTurns(5);

            reg.addRecipe(builder.build());
        });




//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_0", new ItemStack(GTFO_PLANKS.get(0)), GTFO_LOGS.get(0));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_1", new ItemStack(GTFO_PLANKS.get(1)), GTFO_LOGS.get(1));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_2", new ItemStack(GTFO_PLANKS.get(2)), GTFO_LOGS.get(2));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_3", new ItemStack(GTFO_PLANKS.get(3)), GTFO_LOGS.get(3));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_4", new ItemStack(GTFO_PLANKS.get(4)), GTFO_LOGS.get(4));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_5", new ItemStack(GTFO_PLANKS.get(5)), GTFO_LOGS.get(5));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_6", new ItemStack(GTFO_PLANKS.get(6)), GTFO_LOGS.get(6));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_7", new ItemStack(GTFO_PLANKS.get(7)), GTFO_LOGS.get(7));
//        ModHandler.addShapelessRecipe("gtfo:wood_crafting_8", new ItemStack(GTFO_PLANKS.get(8)), GTFO_LOGS.get(8));
    }
}
