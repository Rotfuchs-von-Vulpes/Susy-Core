package supersymmetry.loaders.recipes.chemistry;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import supersymmetry.loaders.recipes.Utils.CarbonSource;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.INTEGRATED_CIRCUIT;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ADVANCED_ARC_FURNACE;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BLENDER_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.highPurityCombustibles;

public class StainlessSteelChain {
    public static void init() {
        ItemStack nbtCircuit = INTEGRATED_CIRCUIT.getStackForm();
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setInteger("Configuration", 3);
        nbtCircuit.setTagCompound(nbt);
        //REMOVE OLD RECIPES
// Stainless Steel Dust * 9
        removeRecipesByInputs(MIXER_RECIPES,
                OreDictUnifier.get(dust, Iron, 6),
                OreDictUnifier.get(dust, Nickel),
                OreDictUnifier.get(dust, Manganese),
                OreDictUnifier.get(dust, Chrome),
                nbtCircuit);
        removeRecipesByInputs(BLENDER_RECIPES,
                OreDictUnifier.get(dust, Iron, 6),
                OreDictUnifier.get(dust, Nickel),
                OreDictUnifier.get(dust, Manganese),
                OreDictUnifier.get(dust, Chrome),
                nbtCircuit);
// Stainless Steel Dust * 9
        nbt.setInteger("Configuration", 1);
        nbtCircuit.setTagCompound(nbt);
        removeRecipesByInputs(MIXER_RECIPES,
                OreDictUnifier.get(dust, Iron, 4),
                OreDictUnifier.get(dust, Invar, 3),
                OreDictUnifier.get(dust, Manganese),
                OreDictUnifier.get(dust, Chrome),
                nbtCircuit);
        removeRecipesByInputs(BLENDER_RECIPES,
                OreDictUnifier.get(dust, Iron, 4),
                OreDictUnifier.get(dust, Invar, 3),
                OreDictUnifier.get(dust, Manganese),
                OreDictUnifier.get(dust, Chrome),
                nbtCircuit);

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Iron, 6)
                .input(dust, Nickel)
                .input(dustTiny, Manganese, 2)
                .fluidOutputs(CarburizedStainlessSteel.getFluid(1440))
                .blastFurnaceTemp(1400)
                .duration(800)
                .EUt(120 * 2)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Magnetite, 14)
                .input(dust, Nickel)
                .input(dustTiny, Manganese, 2)
                .fluidOutputs(CarburizedStainlessSteel.getFluid(1440))
                .blastFurnaceTemp(1400)
                .duration(800)
                .EUt(120 * 2)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, BandedIron, 15)
                .input(dust, Nickel)
                .input(dustTiny, Manganese, 2)
                .fluidOutputs(CarburizedStainlessSteel.getFluid(1440))
                .blastFurnaceTemp(1400)
                .duration(800)
                .EUt(120 * 2)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, IronIIIOxide, 15)
                .input(dust, Nickel)
                .input(dustTiny, Manganese, 2)
                .fluidOutputs(CarburizedStainlessSteel.getFluid(1440))
                .blastFurnaceTemp(1400)
                .duration(800)
                .EUt(120 * 2)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, GraniticMineralSand, 30)
                .input(dust, Nickel)
                .input(dustTiny, Manganese, 2)
                .fluidOutputs(CarburizedStainlessSteel.getFluid(1440))
                .blastFurnaceTemp(1400)
                .duration(800)
                .EUt(120 * 2)
                .buildAndRegister();

// VACUUM.recipeBuilder()
//     .fluidInputs(Oxygen.getFluid(2000))
//     .fluidInputs(CarburizedStainlessSteel.getFluid(1440))
//     .input(dustSmall, Ferrosilicon, 2)
//    .input(dust, Ferrochromium, 3)
//    .input(dustSmall, Quicklime)
//    .input(dustSmall, Fluorite)
//     .fluidOutputs(StainlessSteel.getFluid(1440))
//     .duration(400)
//     .EUt(Globals.voltAmps[3])
//     .buildAndRegister();

        for (CarbonSource highPurityCombustible : highPurityCombustibles) {
            highPurityCombustible.name.setCount(highPurityCombustible.equivalent(2));
            BLAST_RECIPES.recipeBuilder()
                    .input(dust, SiliconDioxide, 3)
                    .input(dust, Iron, 3)
                    .inputs(highPurityCombustible.name)
                    .output(dust, Ferrosilicon, 4)
                    .fluidOutputs(CarbonMonoxide.getFluid(2000))
                    .blastFurnaceTemp(1400)
                    .duration(200 * highPurityCombustible.duration)
                    .EUt(60)
                    .buildAndRegister();
        }

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Iron)
                .input(dust, Chrome, 2)
                .output(dust, Ferrochromium, 3)
                .duration(100)
                .EUt(60)
                .buildAndRegister();

// AOD Process
        ADVANCED_ARC_FURNACE.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidInputs(Argon.getFluid(500))
                .fluidInputs(CarburizedStainlessSteel.getFluid(1440))
                .input(dustSmall, Ferrosilicon, 2)
                .input(dust, Ferrochromium, 3)
                .input(dustSmall, Quicklime)
                .input(dustSmall, Fluorite)
                .fluidOutputs(StainlessSteel.getFluid(1440))
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        ADVANCED_ARC_FURNACE.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidInputs(Nitrogen.getFluid(1000))
                .fluidInputs(CarburizedStainlessSteel.getFluid(1440))
                .input(dustSmall, Ferrosilicon, 2)
                .input(dust, Ferrochromium, 3)
                .input(dustSmall, Quicklime)
                .input(dustSmall, Fluorite)
                .fluidOutputs(StainlessSteel.getFluid(1440))
                .duration(600)
                .EUt(120)
                .buildAndRegister();

// Vanadiumsteel
        removeRecipesByInputs(MIXER_RECIPES,
                OreDictUnifier.get(dust, Steel, 7),
                OreDictUnifier.get(dust, Vanadium),
                OreDictUnifier.get(dust, Chrome),
                nbtCircuit);
        removeRecipesByInputs(BLENDER_RECIPES,
                OreDictUnifier.get(dust, Steel, 7),
                OreDictUnifier.get(dust, Vanadium),
                OreDictUnifier.get(dust, Chrome),
                nbtCircuit);

        ADVANCED_ARC_FURNACE.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidInputs(Argon.getFluid(500))
                .fluidInputs(CarburizedStainlessSteel.getFluid(1440))
                .input(dust, Vanadium, 2)
                .input(dust, Ferrochromium, 3)
                .input(dust, Iron, 6)
                .input(dustSmall, Quicklime)
                .fluidOutputs(VanadiumSteel.getFluid(2592))
                .duration(600)
                .EUt(120)
                .buildAndRegister();

        removeRecipesByInputs(CENTRIFUGE_RECIPES, OreDictUnifier.get(dust, VanadiumSteel, 9));
    }
}
