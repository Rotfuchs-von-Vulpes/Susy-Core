package supersymmetry.loaders.recipes.chemistry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static supersymmetry.common.item.SuSyMetaItems.*;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class GemChain {
    public static void init() {
        CVD_RECIPES.recipeBuilder()
                .notConsumable(SILICON_WAFER)
                .fluidInputs(Methane.getFluid(100))
                .fluidInputs(Hydrogen.getFluid(9900))
                .chancedOutput(RAW_DIAMOND, 1000, 0)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(RAW_DIAMOND)
                .chancedOutput(new ItemStack(Items.DIAMOND), 8000, 0)
                .chancedOutput(gemExquisite, Diamond, 500, 0)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(Alumina.getFluid(36))
                .notConsumable(SHAPE_MOLD_BALL)
                .chancedOutput(SEED_CRYSTAL_ALUMINA, 1000, 1000)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(SEED_CRYSTAL_ALUMINA)
                .input(dust, ChromiumIIIOxide)
                .fluidInputs(Alumina.getFluid(4608))
                .output(BOULE_RUBY)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(BOULE_RUBY)
                .output(SEED_CRYSTAL_ALUMINA)
                .output(gemExquisite, Ruby, 4)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(SEED_CRYSTAL_ALUMINA)
                .input(dustTiny, IronIIOxide)
                .input(dustTiny, Rutile)
                .fluidInputs(Alumina.getFluid(4608))
                .output(BOULE_SAPPHIRE)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(BOULE_SAPPHIRE)
                .output(SEED_CRYSTAL_ALUMINA)
                .output(gemExquisite, Sapphire, 4)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        FORGE_HAMMER_RECIPES.recipeBuilder()
                .inputs(new ItemStack(Items.EMERALD))
                .output(SEED_CRYSTAL_EMERALD)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(SEED_CRYSTAL_EMERALD)
                .input(dust, SiliconDioxide, 18)
                .fluidInputs(Alumina.getFluid(720))
                .fluidInputs(BerylliumOxide.getFluid(432))
                .output(BOULE_EMERALD)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(BOULE_EMERALD)
                .output(SEED_CRYSTAL_EMERALD)
                .output(gemExquisite, Emerald, 6)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, BariumCarbonate, 5)
                .input(dust, Rutile, 3)
                .fluidInputs(Water.getFluid(1000))
                .output(gemExquisite, BariumTitanate)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Gallium Phosphate

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Gallium, 2)
                .fluidInputs(Oxygen.getFluid(3000))
                .output(dust, GalliumTrioxide, 5)
                .duration(200)
                .EUt(30)
                .buildAndRegister();;

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PhosphoricAcid.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, AmmoniumDihydrogenPhosphate, 12)
                .duration(200)
                .EUt(30)
                .buildAndRegister();;

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, GalliumTrioxide, 5)
                .input(dust, AmmoniumDihydrogenPhosphate, 24)
                .fluidOutputs(Water.getFluid(3000))
                .fluidOutputs(Ammonia.getFluid(2000))
                .output(dust, GalliumPhosphate, 12)
                .duration(200)
                .EUt(120)
                .buildAndRegister();;

// Lithium Niobate

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(dust, NiobiumOxide, 7)
                .input(dust, LithiumOxide, 32)
                .chancedOutput(SEED_CRYSTAL_LITHIUM_NIOBATE, 5000, 1000)
                .duration(200)
                .EUt(1920)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(SEED_CRYSTAL_LITHIUM_NIOBATE)
                .input(dust, NiobiumOxide, 14)
                .fluidInputs(LithiumOxide.getFluid(864))
                .output(BOULE_LITHIUM_NIOBATE)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(BOULE_LITHIUM_NIOBATE)
                .output(SEED_CRYSTAL_LITHIUM_NIOBATE)
                .output(gemExquisite, LithiumNiobate, 5)
                .duration(400)
                .EUt(120)
                .buildAndRegister();

// Lead Zirconate Titanate
    }
}
