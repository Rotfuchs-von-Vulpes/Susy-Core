package supersymmetry.loaders.recipes.chemistry.elements;

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

public class GalliumChain {
    public static void init() {
        //FROM BAUXITE
        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(ImpureSodaAshSolution.getFluid(1000))
                .notConsumable(stick, Steel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidOutputs(SodaAshSolution.getFluid(1000))
                .chancedOutput(dust, Gallium, 500, 0)
                .duration(300)
                .EUt(7)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(ImpureSodiumHydroxideSolution.getFluid(1000))
                .notConsumable(stick, Steel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidOutputs(SodiumHydroxideSolution.getFluid(1000))
                .chancedOutput(dust, Gallium, 500, 0)
                .duration(300)
                .EUt(7)
                .buildAndRegister();

//FROM SPHALERITE (WILL ADD LATER)

//FROM COAL FLY ASH (WILL ADD LATER)

//HIGH PURITY GALLIUM
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Gallium)
                .fluidInputs(Chlorine.getFluid(3500))
                .output(dust, CrudeGalliumTrichloride, 3)
                .duration(120)
                .EUt(7)
                .buildAndRegister();

//CHLORIDE ROUTE (75%)
        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(CrudeGalliumTrichloride.getFluid(432))
                .fluidOutputs(GalliumTrichloride.getFluid(750))
                .duration(120)
                .EUt(7)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(CrudeGalliumTrichloride.getFluid(432))
                .fluidOutputs(GalliumTrichloride.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

// Small Pile of Mercury II Chloride Dust * 1
        ItemStack integratedCircuit = INTEGRATED_CIRCUIT.getStackForm();
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("Configuration", 1);
        integratedCircuit.setTagCompound(nbt);
        removeRecipesByInputs(DISTILLERY_RECIPES, new ItemStack[]{integratedCircuit}, new FluidStack[]{CrudeGalliumTrichloride.getFluid(432)});

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(GalliumTrichloride.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(3000))
                .output(dust, HighPurityGallium)
                .fluidOutputs(HydrogenChloride.getFluid(3000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(stick, Iron)
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(Water.getFluid(1000))
                .input(dust, MercuryIIChloride, 3)
                .fluidOutputs(Chlorine.getFluid(2000))
                .fluidOutputs(Mercury.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//VACUUM ROUTE
        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .input(dust, Gallium)
                .output(dust, HighPurityGallium)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//GALLIUM ARSENIDE PRODUCTION (LIQUID ENCAPSULATED CZOCHIRALSKI PROCESS)
        removeRecipesByInputs(MIXER_RECIPES, OreDictUnifier.get(dust, Gallium), OreDictUnifier.get(dust, Arsenic), integratedCircuit);
        removeRecipesByInputs(BLENDER_RECIPES, OreDictUnifier.get(dust, Gallium), OreDictUnifier.get(dust, Arsenic), integratedCircuit);
//SEED CRYSTAL
        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(dustSmall, HighPurityArsenic)
                .fluidInputs(HighPurityGallium.getFluid(36))
                .chancedOutput(SEED_CRYSTAL_GALLIUM_ARSENIDE, 2500, 0)
                .duration(500)
                .EUt(7)
                .buildAndRegister();

//PBN CRUCIBLE
        CVD_RECIPES.recipeBuilder()
                .fluidInputs(BoronTrichloride.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, BoronNitride, 2)
                .fluidOutputs(HydrogenChloride.getFluid(3000))
                .duration(120)
                .EUt(7)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(dust, BoronNitride, 14)
                .notConsumable(SHAPE_MOLD_CRUCIBLE)
                .output(CRUCIBLE_BORON_NITRIDE)
                .duration(500)
                .EUt(7)
                .buildAndRegister();

//CRYSTALLIZATION
        CRYSTALLIZER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(HighPurityGallium.getFluid(144))
                .fluidInputs(HighPurityArsenic.getFluid(144))
                .notConsumable(BoronTrioxide.getFluid(720))
                .input(SEED_CRYSTAL_GALLIUM_ARSENIDE)
                .notConsumable(CRUCIBLE_BORON_NITRIDE)
                .output(UNREFINED_BOULE_GALLIUM_ARSENIDE)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(HighPurityGallium.getFluid(144))
                .fluidInputs(HighPurityArsenic.getFluid(144))
                .notConsumable(BoronTrioxide.getFluid(720))
                .notConsumable(SEED_CRYSTAL_GALLIUM_ARSENIDE)
                .notConsumable(CRUCIBLE_BORON_NITRIDE)
                .output(ingot, GalliumArsenide)
                .duration(240)
                .EUt(7)
                .buildAndRegister();

        ZONE_REFINER_RECIPES.recipeBuilder()
                .input(UNREFINED_BOULE_GALLIUM_ARSENIDE)
                .output(BOULE_GALLIUM_ARSENIDE)
                .duration(120)
                .EUt(7)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .fluidInputs(UltrapureWater.getFluid(100))
                .input(BOULE_GALLIUM_ARSENIDE)
                .output(WAFER_GALLIUM_ARSENIDE, 16)
                .output(SEED_CRYSTAL_GALLIUM_ARSENIDE)
                .duration(400)
                .EUt(64)
                .buildAndRegister();
    }
}
