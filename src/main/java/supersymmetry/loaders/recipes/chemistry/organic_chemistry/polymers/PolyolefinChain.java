package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.plate;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_PLATE;
import static supersymmetry.api.recipes.SuSyRecipeMaps.POLYMERIZATION_RECIPES;
import static supersymmetry.api.unification.ore.SusyOrePrefix.fiber;
import static supersymmetry.api.unification.ore.SusyOrePrefix.thread;
import static supersymmetry.common.item.SuSyMetaItems.SPINNERET;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolyolefinChain {
    public static void init() {
        // Polyethylene

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Ethylene.getFluid(2000))
                .output(dust, Polyethylene)
                .EUt(30)
                .duration(300)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(dust, PhilipsCatalyst)
                .fluidInputs(Ethylene.getFluid(1500))
                .output(dust, Polyethylene)
                .EUt(30)
                .duration(150)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(dust, ZieglerNattaCatalyst)
                .fluidInputs(Ethylene.getFluid(1250))
                .output(dust, Polyethylene)
                .EUt(30)
                .duration(75)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .notConsumable(dust, KaminskyCatalyst)
                .fluidInputs(Ethylene.getFluid(1000))
                .output(dust, Polyethylene)
                .EUt(30)
                .duration(30)
                .buildAndRegister();

// UHMWPE

// Ultra High Molecular Weight Polyethylene (UHMWPE) Plate * 1
        removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(dust, UltraHighMolecularWeightPolyethylene));
// Ultra High Molecular Weight Polyethylene (UHMWPE) Plate * 1
        removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES, new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()}, new FluidStack[]{UltraHighMolecularWeightPolyethylene.getFluid(144)});
// Ultra High Molecular Weight Polyethylene (UHMWPE) * 144
        removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(plate, UltraHighMolecularWeightPolyethylene));

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(5)
                .notConsumable(dust, ZieglerNattaCatalyst)
                .fluidInputs(Ethylene.getFluid(1000))
                .chancedOutput(dust, UltraHighMolecularWeightPolyethylene, 5000, 0)
                .EUt(1920)
                .duration(20)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .notConsumable(dust, KaminskyCatalyst)
                .fluidInputs(Ethylene.getFluid(1000))
                .output(dust, UltraHighMolecularWeightPolyethylene)
                .EUt(1920)
                .duration(20)
                .buildAndRegister();

        EXTRUDER_RECIPES.recipeBuilder()
                .notConsumable(SPINNERET)
                .fluidInputs(UltraHighMolecularWeightPolyethylene.getFluid(144))
                .output(fiber, UltraHighMolecularWeightPolyethylene, 8)
                .EUt(480)
                .duration(20)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(thread, UltraHighMolecularWeightPolyethylene, 8)
                .output(plate, UltraHighMolecularWeightPolyethylene)
                .EUt(1920)
                .duration(300)
                .buildAndRegister();

// Polypropylene

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .notConsumable(dust, PhilipsCatalyst)
                .fluidInputs(Propene.getFluid(2000))
                .output(dust, Polypropylene)
                .EUt(30)
                .duration(500)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(dust, ZieglerNattaCatalyst)
                .fluidInputs(Propene.getFluid(1500))
                .output(dust, Polypropylene)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .notConsumable(dust, KaminskyCatalyst)
                .fluidInputs(Propene.getFluid(1000))
                .output(dust, Polypropylene)
                .EUt(30)
                .duration(50)
                .buildAndRegister();
    }
}
