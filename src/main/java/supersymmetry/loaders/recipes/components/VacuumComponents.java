package supersymmetry.loaders.recipes.components;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.VACUUM_CHAMBER;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.loaders.recipes.Utils.getConfiguration;

public class VacuumComponents {
    public static void init() {
        ModHandler.removeRecipeByName("gregtech:vacuum_tube");

// Vacuum Tube * 4
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{
                GLASS_TUBE.getStackForm(),
                OreDictUnifier.get(bolt, Steel, 2),
                OreDictUnifier.get(wireGtSingle, AnnealedCopper, 2)
        }, new FluidStack[]{RedAlloy.getFluid(18)});
// Vacuum Tube * 3
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{
                GLASS_TUBE.getStackForm(),
                OreDictUnifier.get(bolt, Steel, 2),
                OreDictUnifier.get(wireGtSingle, Copper, 2)
        }, new FluidStack[]{RedAlloy.getFluid(18)});
// Vacuum Tube * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES,
                GLASS_TUBE.getStackForm(),
                OreDictUnifier.get(bolt, Steel, 2),
                OreDictUnifier.get(wireGtSingle, Copper, 2),
                getConfiguration(1));

        ModHandler.addShapedRecipe(true, "vacuum_tube_components",
                VACUUM_TUBE_COMPONENTS.getStackForm(4), " F ", "WRW", " B ",
                'F', new UnificationEntry(wireFine, RedAlloy),
                'W', new UnificationEntry(wireGtSingle, Copper),
                'R', new UnificationEntry(ring, Steel),
                'B', new UnificationEntry(bolt, Steel));

        ModHandler.addShapedRecipe(true, "vacuum_tube_components_annealed",
                VACUUM_TUBE_COMPONENTS.getStackForm(6), " F ", "WRW", " B ",
                'F', new UnificationEntry(wireFine, RedAlloy),
                'W', new UnificationEntry(wireGtSingle, AnnealedCopper),
                'R', new UnificationEntry(ring, Steel),
                'B', new UnificationEntry(bolt, Steel));

        VACUUM_CHAMBER.recipeBuilder()
                .input(GLASS_TUBE)
                .input(VACUUM_TUBE_COMPONENTS)
                .input(ring, Steel)
                .output(VACUUM_TUBE)
                .EUt(7)
                .duration(200)
                .buildAndRegister();
    }
}
