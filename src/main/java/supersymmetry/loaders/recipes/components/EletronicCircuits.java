package supersymmetry.loaders.recipes.components;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static net.minecraft.init.Items.PAPER;
import static supersymmetry.common.materials.SusyMaterials.Anthracite;
import static supersymmetry.common.materials.SusyMaterials.HighPurityCarbon;

public class EletronicCircuits {
    public static void init() {/*
        // Diode * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, AnnealedCopper, 4), OreDictUnifier.get(dustSmall, GalliumArsenide)}, new FluidStack[]{Glass.getFluid(144)});
// Diode * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, Copper, 4), OreDictUnifier.get(dustSmall, GalliumArsenide)}, new FluidStack[]{Glass.getFluid(144)});
// Diode * 4
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, AnnealedCopper, 4), SILICON_WAFER.getStackForm()}, new FluidStack[]{Polyethylene.getFluid(144)});
// Diode * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, Copper, 4), SILICON_WAFER.getStackForm()}, new FluidStack[]{Polyethylene.getFluid(144)});
// Diode * 4
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, AnnealedCopper, 4), OreDictUnifier.get(dustSmall, GalliumArsenide)}, new FluidStack[]{Polyethylene.getFluid(144)});
// Diode * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, Copper, 4), OreDictUnifier.get(dustSmall, GalliumArsenide)}, new FluidStack[]{Polyethylene.getFluid(144)});
// Resistor * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, Copper, 4), OreDictUnifier.get(dust, Coal)}, new FluidStack[]{Glue.getFluid(100)});
// Resistor * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, Copper, 4), OreDictUnifier.get(dust, Charcoal)}, new FluidStack[]{Glue.getFluid(100)});
// Resistor * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, Copper, 4), OreDictUnifier.get(dust, Carbon)}, new FluidStack[]{Glue.getFluid(100)});
// Resistor * 4
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, AnnealedCopper, 4), OreDictUnifier.get(dust, Coal)}, new FluidStack[]{Glue.getFluid(100)});
// Resistor * 4
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, AnnealedCopper, 4), OreDictUnifier.get(dust, Charcoal)}, new FluidStack[]{Glue.getFluid(100)});
// Resistor * 4
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, AnnealedCopper, 4), OreDictUnifier.get(dust, Carbon)}, new FluidStack[]{Glue.getFluid(100)});

        ModHandler.removeRecipeByOutput(RESISTOR.getStackForm(2));*/

        ItemStack[] carbons = new ItemStack[]{
                OreDictUnifier.get(dust, Coal),
                OreDictUnifier.get(dust, Charcoal),
                OreDictUnifier.get(dust, Carbon),
                OreDictUnifier.get(dust, HighPurityCarbon),
                OreDictUnifier.get(dust, Anthracite),
                OreDictUnifier.get(dust, Coke)
        };

        //for (ItemStack carbon : carbons) {
        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Glue.getFluid(100))
                .input(dust, Anthracite)
                .input(wireFine, AnnealedCopper, 4)
                .output(RESISTOR, 4)
                .duration(160)
                .EUt(6)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Glue.getFluid(100))
                .input(dust, Anthracite)
                .input(wireFine, Copper, 4)
                .output(RESISTOR, 2)
                .duration(160)
                .EUt(6)
                .buildAndRegister();
        //}

        //for (Material carbon : new Material[]{Anthracite, Coke, Carbon, Coal, Charcoal}) {
            ModHandler.addShapedRecipe(true, "gregtech:resitor_wire_fine_"+Anthracite.getName(), RESISTOR.getStackForm(2),
                    "RPR", "WCW", " P ",
                    'R', STICKY_RESIN,
                    'P', PAPER,
                    'W', new UnificationEntry(wireFine, Copper),
                    'C', new UnificationEntry(dust, Anthracite));

            ModHandler.addShapedRecipe(true, "gregtech:resitor_wire_"+Anthracite.getName(), RESISTOR.getStackForm(2),
                    "RPR", "WCW", " P ",
                    'R', STICKY_RESIN,
                    'P', PAPER,
                    'W', new UnificationEntry(wireGtSingle, Copper),
                    'C', new UnificationEntry(dust, Anthracite));
        //}

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Glass.getFluid(144))
                .input(wireFine, Copper, 4)
                .input(dustSmall, Galena, 1)
                .output(DIODE)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Glass.getFluid(144))
                .input(wireFine, AnnealedCopper, 4)
                .input(dustSmall, Galena, 1)
                .output(DIODE, 2)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(wireFine, Copper, 4)
                .input(dustSmall, Galena, 1)
                .output(DIODE, 2)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(wireFine, AnnealedCopper, 4)
                .input(dustSmall, Galena, 1)
                .output(DIODE, 4)
                .duration(400)
                .EUt(30)
                .buildAndRegister();
/*
        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Glass.getFluid(144))
                .input(wireFine, Copper, 4)
                .input(dustSmall, GalliumArsenide, 1)
                .output(DIODE, 3)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Glass.getFluid(144))
                .input(wireFine, AnnealedCopper, 4)
                .input(dustSmall, GalliumArsenide, 1)
                .output(DIODE, 4)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(wireFine, Copper, 4)
                .input(dustSmall, GalliumArsenide, 1)
                .output(DIODE, 6)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(wireFine, AnnealedCopper, 4)
                .input(dustSmall, GalliumArsenide, 1)
                .output(DIODE, 8)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(wireFine, Copper, 4)
                .input(SILICON_WAFER, 1)
                .output(DIODE, 12)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(wireFine, AnnealedCopper, 4)
                .input(SILICON_WAFER, 1)
                .output(DIODE, 16)
                .duration(400)
                .EUt(30)
                .buildAndRegister();*/
    }
}
