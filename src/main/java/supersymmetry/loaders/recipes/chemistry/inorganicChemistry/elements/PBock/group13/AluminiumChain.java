package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group13;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.INTEGRATED_CIRCUIT;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class AluminiumChain {
    public static void init() {
        // Aluminium Nugget * 3
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Ruby));
//Remove EBF recipe with Aluminium Dust:
        ItemStack integratedCircuit = INTEGRATED_CIRCUIT.getStackForm();
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("Configuration", 2);
        integratedCircuit.setTagCompound(nbt);
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Aluminium), integratedCircuit}, new FluidStack[]{Nitrogen.getFluid(1000)});
        nbt.setInteger("Configuration", 1);
        integratedCircuit.setTagCompound(nbt);
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Aluminium), integratedCircuit);
//EBF recipe with Al dust re-enabled:
        BLAST_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium")
                .output(ingot, Aluminium)
                .duration(240)
                .blastFurnaceTemp(933)
                .EUt(120)
                .buildAndRegister();



// Ruby Slurry * 3000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, Ruby, 2)}, new FluidStack[]{AquaRegia.getFluid(3000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, Ruby, 2)}, new FluidStack[]{AquaRegia.getFluid(3000)});
// Sapphire Slurry * 3000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, Sapphire, 2)}, new FluidStack[]{AquaRegia.getFluid(3000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, Sapphire, 2)}, new FluidStack[]{AquaRegia.getFluid(3000)});
// Green Sapphire Slurry * 3000
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, GreenSapphire, 2)}, new FluidStack[]{AquaRegia.getFluid(3000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(crushed, GreenSapphire, 2)}, new FluidStack[]{AquaRegia.getFluid(3000)});

// Bauxite -> Red Mud

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .input(dust, Bauxite, 5)
                .fluidOutputs(ImpureSodiumAluminateSolution.getFluid(3000))
                .duration(200)
                .EUt(16)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ImpureSodiumAluminateSolution.getFluid(3000))
                .fluidOutputs(SodiumAluminateSolution.getFluid(3000))
                .fluidOutputs(RedMud.getFluid(500))
                .duration(200)
                .EUt(16)
                .buildAndRegister();

// Carbon dioxide bubbling

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(SodiumAluminateSolution.getFluid(3000))
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .fluidOutputs(ImpureSodaAshSolution.getFluid(1000))
                .output(dust, AluminiumHydroxide, 14)
                .duration(300)
                .EUt(20)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(SodiumAluminateSolution.getFluid(1500))
                .fluidInputs(Water.getFluid(1500))
                .notConsumable(dust, AluminiumHydroxide)
                .fluidOutputs(ImpureSodiumHydroxideSolution.getFluid(1000)) //TO GALLIUM PROCESSING
                .output(dust, AluminiumHydroxide, 7)
                .duration(300)
                .EUt(16)
                .buildAndRegister();

// Alumina from Al(OH)3

        BLAST_RECIPES.recipeBuilder()
                .input(dust, AluminiumHydroxide, 14)
                .fluidOutputs(Steam.getFluid(3000))
                .output(dust, Alumina, 5)
                .duration(100)
                .blastFurnaceTemp(1400)
                .EUt(40)
                .buildAndRegister();

// Electrolysis

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(Cryolite.getFluid(2592))
                .input(dust, Alumina, 10)
                .input(dust, AluminiumTrifluoride)
                .input(dust, Coke, 3)
                .fluidOutputs(HydrogenFluoride.getFluid(750))
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .output(ingot, Aluminium, 4)
                .duration(300)
                .EUt(40)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(Cryolite.getFluid(2592))
                .input(dust, Alumina, 10)
                .input(dust, AluminiumTrifluoride)
                .input("dustAnyPurityCarbon", 3)
                .fluidOutputs(HydrogenFluoride.getFluid(750))
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .output(ingot, Aluminium, 4)
                .duration(100)
                .EUt(40)
                .buildAndRegister();

// Production of cryolite

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(HydrofluoricAcid.getFluid(6000))
                .input(dust, Alumina, 5)
                .fluidOutputs(Steam.getFluid(9000))
                .output(dust, AluminiumTrifluoride, 8)
                .duration(300)
                .EUt(16)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenFluoride.getFluid(50))
                .fluidInputs(SodiumHydroxideSolution.getFluid(50))
                .fluidOutputs(SodiumFluorideSolution.getFluid(50))
                .duration(5)
                .EUt(16)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumFluorideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, SodiumFluoride, 2)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AluminiumTrifluoride, 4)
                .input(dust, SodiumFluoride, 6)
                .output(dust, Cryolite, 10)
                .duration(180)
                .EUt(16)
                .buildAndRegister();

// Red mud processing

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .fluidInputs(RedMud.getFluid(2000))
                .chancedOutput(dust, IronIIIOxide, 5000, 0)
                .fluidOutputs(ConcentratedRedMud.getFluid(1000))
                .duration(200)
                .EUt(96)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .fluidInputs(ConcentratedRedMud.getFluid(2000))
                .output(ingot, Iron)
                .output(RED_MUD_SLAG)
                .blastFurnaceTemp(1600)
                .duration(300)
                .EUt(120 * 2)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(250))
                .input(RED_MUD_SLAG)
                .output(dustTiny, Rutile, 3)
                .output(LEACHED_RED_MUD_SLAG)
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .input(dust, AluminiumHydroxide, 14)
                .fluidOutputs(AluminiumSulfateSolution.getFluid(1000))
                .duration(100)
                .EUt(96)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .fluidInputs(Water.getFluid(3000))
                .input(dust, Alumina, 5)
                .fluidOutputs(AluminiumSulfateSolution.getFluid(1000))
                .duration(100)
                .EUt(96)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(AluminiumSulfateSolution.getFluid(1000))
                .output(dust, AluminiumSulfate, 17)
                .fluidOutputs(Water.getFluid(6000))
                .duration(100)
                .EUt(96)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .input("dustAnyPurityAluminium", 2)
                .output(dust, AluminiumSulfate, 17)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

//        CENTRIFUGE_RECIPES.recipeBuilder()
//                .fluidInputs(HydrochloricAcid.getFluid(500))
//                .input(LEACHED_RED_MUD_SLAG)
//                .fluidOutputs(RedMud.getFluid(500))
//                .duration(100)
//                .EUt(1920)
//                .buildAndRegister();
    }
}
