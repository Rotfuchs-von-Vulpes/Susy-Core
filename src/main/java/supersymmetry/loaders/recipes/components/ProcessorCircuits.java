package supersymmetry.loaders.recipes.components;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class ProcessorCircuits {
    public static void init() {
// Workstation * 1
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{
                PLASTIC_CIRCUIT_BOARD.getStackForm(),
                PROCESSOR_ASSEMBLY_HV.getStackForm(2),
                DIODE.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                OreDictUnifier.get(wireFine, Electrum, 16),
                OreDictUnifier.get(bolt, BlueAlloy, 16)
        }, new FluidStack[]{SolderingAlloy.getFluid(144)});
        removeRecipesByInputs(CIRCUIT_ASSEMBLER_RECIPES, new ItemStack[]{
                PLASTIC_CIRCUIT_BOARD.getStackForm(),
                PROCESSOR_ASSEMBLY_HV.getStackForm(2),
                DIODE.getStackForm(4),
                RANDOM_ACCESS_MEMORY.getStackForm(4),
                OreDictUnifier.get(wireFine, Electrum, 16),
                OreDictUnifier.get(bolt, BlueAlloy, 16)
        }, new FluidStack[]{Tin.getFluid(288)});

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium)
                .input(PROCESSOR_ASSEMBLY_HV, 2)
                .input("componentDiode", 4)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(NAND_MEMORY_CHIP, 4)
                .input(cableGtSingle, Electrum, 4)
                .fluidInputs(Tin.getFluid(288))
                .output(WORKSTATION_EV)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(250)
                .EUt(120)
                .buildAndRegister();

        CIRCUIT_ASSEMBLER_RECIPES.recipeBuilder()
                .input(frameGt, Aluminium)
                .input(PROCESSOR_ASSEMBLY_HV, 2)
                .input("componentDiode", 4)
                .input(RANDOM_ACCESS_MEMORY, 4)
                .input(NAND_MEMORY_CHIP, 4)
                .input(cableGtSingle, Electrum, 4)
                .fluidInputs(SolderingAlloy.getFluid(144))
                .output(WORKSTATION_EV)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(250)
                .EUt(120)
                .buildAndRegister();
    }
}
