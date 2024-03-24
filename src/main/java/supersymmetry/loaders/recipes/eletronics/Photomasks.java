package supersymmetry.loaders.recipes.eletronics;

import gregtech.api.recipes.ModHandler;

import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.MIXER_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_PLATE;
import static gregtechfoodoption.GTFOMaterialHandler.Aniline;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Photomasks {
    public static void init() {
        // Acrylic Acid

        // Reppe route
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butyraldehyde.getFluid(1000))
                .fluidInputs(Formaldehyde.getFluid(3000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .output(dust, Trimethylolpropane)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Copper)
                .input(dust, Nickel)
                .fluidInputs(Bromine.getFluid(4000))
                .output(dust, AcrylicCatalyst)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .notConsumable(dust, AcrylicCatalyst)
                .fluidInputs(Acetylene.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(AcrylicAcid.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // Propene route

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, MolybdenumTrioxide, 4)
                .input(dust, VanadiumPentoxide, 7)
                .input(dust, Alumina, 5)
                .output(dust, SupportedMolybdenumVanadium)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, PhosphomolybdicAcid)
                .fluidInputs(Propene.getFluid(50))
                .fluidInputs(Oxygen.getFluid(100))
                .fluidOutputs(Acrolein.getFluid(50))
                .fluidOutputs(Steam.getFluid(50))
                .duration(8)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, SupportedMolybdenumVanadium)
                .fluidInputs(Acrolein.getFluid(50))
                .fluidInputs(Oxygen.getFluid(50))
                .fluidOutputs(AcrylicAcid.getFluid(50))
                .duration(8)
                .EUt(120)
                .buildAndRegister();

// TMPTA

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(spring, Cupronickel)
                .notConsumable(SulfuricAcid.getFluid(1000))
                .input(dust, Trimethylolpropane)
                .fluidInputs(AcrylicAcid.getFluid(3000))
                .fluidOutputs(TrimethylolpropaneTriacrylate.getFluid(1000))
                .fluidOutputs(Steam.getFluid(3000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// UV initiator, Benzenediazonium tetrafluoroborate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, SodiumNitrite, 4)
                .fluidInputs(HydrogenChloride.getFluid(2000))
                .fluidInputs(Aniline.getFluid(1000))
                .output(dust, BenzenediazoniumChloride)
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, BenzenediazoniumChloride)
                .input(dust, Gelatin, 8)
                .fluidInputs(TrimethylolpropaneTriacrylate.getFluid(8000))
                .fluidOutputs(AcrylicPhotoemulsion.getFluid(8000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(foil, Polyethylene)
                .fluidInputs(DyeRed.getFluid(100))
                .fluidInputs(AcrylicPhotoemulsion.getFluid(500))
                .output(RUBYLITH_FILM)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MYLAR)
                .input(RUBYLITH_FILM)
                .fluidInputs(Glue.getFluid(100))
                .output(RUBYLITH)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Early lithography masks

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Silver)
                .fluidInputs(Chlorine.getFluid(1000))
                .output(dust, SilverChloride, 2)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(plate, Glass)
                .input(dust, Gelatin)
                .input(dust, SilverChloride)
                .output(MASK_BLANK)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "rubylith_ram",
                STENCIL_RAM.getStackForm(), "k  ", " R ", "   ",
                'R', RUBYLITH);

        UV_RECIPES.recipeBuilder()
                .input(STENCIL_RAM)
                .input(MASK_BLANK)
                .output(MASK_RAM)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "rubylith_ic",
                STENCIL_IC.getStackForm(), " k ", " R ", "   ",
                'R', RUBYLITH);

        UV_RECIPES.recipeBuilder()
                .input(STENCIL_IC)
                .input(MASK_BLANK)
                .output(MASK_IC)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "stencil_pcb",
                STENCIL_PCB.getStackForm(), "  k", " R ", "   ",
                'R', RUBYLITH);

        UV_RECIPES.recipeBuilder()
                .input(STENCIL_PCB)
                .input(MASK_BLANK)
                .output(MASK_PCB)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "rubylith_ulpic",
                STENCIL_ULPIC.getStackForm(), "   ", "kR ", "   ",
                'R', RUBYLITH);

        UV_RECIPES.recipeBuilder()
                .input(STENCIL_ULPIC)
                .input(MASK_BLANK)
                .output(MASK_ULPIC)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "rubylith_lpic",
                STENCIL_LPIC.getStackForm(), "   ", " Rk", "   ",
                'R', RUBYLITH);

        UV_RECIPES.recipeBuilder()
                .input(STENCIL_LPIC)
                .input(MASK_BLANK)
                .output(MASK_LPIC)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "rubylith_cpu",
                STENCIL_CPU.getStackForm(), "   ", " R ", "k  ",
                'R', RUBYLITH);

        UV_RECIPES.recipeBuilder()
                .input(STENCIL_CPU)
                .input(MASK_BLANK)
                .output(MASK_CPU)
                .duration(200)
                .EUt(7)
                .buildAndRegister();

// CrO3 photomasks

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .fluidInputs(SiliconTetrachloride.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(3000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(FUSED_QUARTZ)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FUSED_QUARTZ)
                .input(dustTiny, ChromiumTrioxide)
                .circuitMeta(1)
                .output(MASK_ADVANCED)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FUSED_QUARTZ)
                .input(dustTiny, ChromiumTrioxide)
                .circuitMeta(2)
                .output(MASK_NAND)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(FUSED_QUARTZ)
                .input(dustTiny, ChromiumTrioxide)
                .circuitMeta(3)
                .output(MASK_NOR)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

    }
}
