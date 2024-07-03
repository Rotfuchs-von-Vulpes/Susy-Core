package supersymmetry.loaders.recipes.components;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.api.unification.ore.OrePrefix.wireFine;
import static gregtech.common.items.MetaItems.SILICON_WAFER;
import static gregtech.common.items.MetaItems.TRANSISTOR;

public class IntegratedCircuit {
    public static void init() {
        //Change transistor to use silicon wafer instead of silicon plate
// Transistor * 8
        removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(plate, Silicon), OreDictUnifier.get(wireFine, Tin)},
                new FluidStack[]{Polyethylene.getFluid(144)});

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(wireFine, Tin, 6)
                .input(SILICON_WAFER)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(TRANSISTOR, 8)
                .duration(160)
                .EUt(120)
                .buildAndRegister();
    }
}
