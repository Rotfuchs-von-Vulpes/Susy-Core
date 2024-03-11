package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.loaders.recipes.Utils;
import supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry.Lubricants;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.loaders.recipes.Utils.sintering_comburents;
import static supersymmetry.loaders.recipes.Utils.sintering_fuels;

public class SiliconChain {
    public static void init() {
        // Silicon Carbide Plate * 1
        removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(dust, SiliconCarbide));
// Phosphorus-doped Monocrystalline Silicon Boule * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{
                OreDictUnifier.get(dust, Silicon, 64),
                OreDictUnifier.get(dust, Phosphorus, 8),
                OreDictUnifier.get(dustSmall, GalliumArsenide, 2)
        }, new FluidStack[]{Nitrogen.getFluid(8000)});
// Naquadah-doped Monocrystalline Silicon Boule * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{
                OreDictUnifier.get(block, Silicon, 16),
                OreDictUnifier.get(ingot, Naquadah),
                OreDictUnifier.get(dust, GalliumArsenide)
        }, new FluidStack[]{Argon.getFluid(8000)});
// Neutronium-doped Monocrystalline Silicon Boule * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{
                OreDictUnifier.get(block, Silicon, 32),
                OreDictUnifier.get(ingot, Neutronium, 4),
                OreDictUnifier.get(dust, GalliumArsenide, 2)
        }, new FluidStack[]{Xenon.getFluid(8000)});
// Raw Silicon Wafer * 14
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{SILICON_BOULE.getStackForm()}, new FluidStack[]{Lubricant.getFluid(225)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{SILICON_BOULE.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(676)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{SILICON_BOULE.getStackForm()}, new FluidStack[]{Water.getFluid(900)});

// Fix Hot Silicon Ingot conflict with dust
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, SiliconDioxide, 3), OreDictUnifier.get(dust, Carbon, 2));

        BLAST_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, SiliconDioxide, 3)
                .input("dustAnyPurityCarbon", 2)
                .output(dust, Silicon)
                .output(dustTiny, Ash)
                .fluidOutputs(CarbonMonoxide.getFluid(2000))
                .blastFurnaceTemp(1200)
                .duration(240)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .fluidInputs(Chlorine.getFluid(4000))
                .fluidOutputs(SiliconTetrachloride.getFluid(1000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SiliconTetrachloride.getFluid(1000))
                .fluidOutputs(PurifiedSiliconTetrachloride.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedSiliconTetrachloride.getFluid(1000))
                .input("dustAnyPurityZinc", 2)
                .output(dust, HighPuritySilicon)
                .fluidOutputs(ZincChloride.getFluid(864))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Silicon)
                .fluidInputs(HydrogenChloride.getFluid(3000))
                .fluidOutputs(Trichlorosilane.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(Trichlorosilane.getFluid(1000))
                .fluidOutputs(PurifiedTrichlorosilane.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedTrichlorosilane.getFluid(1000))
                .input("dustAnyPurityZinc", 1)
                .output(dust, HighPuritySilicon)
                .fluidOutputs(ZincChloride.getFluid(432))
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(SiliconDioxide.getFluid(1008))
                .notConsumable(SHAPE_MOLD_CRUCIBLE)
                .output(CRUCIBLE_QUARTZ)
                .duration(1440)
                .EUt(30)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(HighPuritySilicon.getFluid(4608))
                .input(SEED_CRYSTAL_SILICON)
                .notConsumable(CRUCIBLE_QUARTZ)
                .output(UNREFINED_BOULE_SILICON)
                .duration(9000)
                .EUt(120)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(HighPuritySilicon.getFluid(4608))
                .notConsumable(Argon.getFluid(8000))
                .input(SEED_CRYSTAL_SILICON)
                .notConsumable(CRUCIBLE_QUARTZ)
                .output(UNREFINED_BOULE_SILICON)
                .duration(6750)
                .EUt(120)
                .buildAndRegister();

        ZONE_REFINER_RECIPES.recipeBuilder()
                .input(UNREFINED_BOULE_SILICON)
                .output(SILICON_BOULE)
                .duration(120)
                .EUt(7)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(SILICON_BOULE)
                .fluidInputs(UltrapureWater.getFluid(500))
                .output(WAFER_RAW_SILICON, 14)
                .chancedOutput(WAFER_RAW_SILICON, 2, 5000, 0)
                .output(SEED_CRYSTAL_SILICON)
                .duration(4500)
                .EUt(64)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(HydrochloricAcid.getFluid(500))
                .fluidInputs(HydrofluoricAcid.getFluid(500))
                .fluidOutputs(WaferTreatmentAcid.getFluid(1000))
                .duration(600)
                .EUt(64)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(HydrochloricAcid.getFluid(450))
                .fluidInputs(HydrofluoricAcid.getFluid(450))
                .fluidInputs(AceticAcid.getFluid(100))
                .fluidOutputs(WaferTreatmentAcid.getFluid(1000))
                .duration(200)
                .EUt(64)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(WAFER_RAW_SILICON)
                .fluidInputs(WaferTreatmentAcid.getFluid(50))
                .output(WAFER_TREATED_SILICON)
                .fluidOutputs(AcidicWastewater.getFluid(50))
                .duration(225)
                .EUt(64)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide)
                .input(dust, SiliconDioxide, 3)
                .fluidInputs(UltrapureWater.getFluid(1000))
                .fluidOutputs(SiliconDioxideSlurry.getFluid(1000))
                .duration(200)
                .EUt(64)
                .buildAndRegister();

        POLISHING_MACHINE.recipeBuilder()
                .input(WAFER_TREATED_SILICON)
                .fluidInputs(SiliconDioxideSlurry.getFluid(50))
                .output(SILICON_WAFER)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(1000))
                .input(dust, HighPuritySilicon)
                .chancedOutput(SEED_CRYSTAL_SILICON, 1000, 500)
                .duration(1200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(SiliconTetrachloride.getFluid(3000))
                .fluidInputs(Hydrogen.getFluid(4000))
                .input(dust, Silicon)
                .fluidOutputs(Trichlorosilane.getFluid(4000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Trichlorosilane.getFluid(2000))
                .notConsumable(catalystBed, AluminiumChloride)
                .fluidOutputs(DisproportionatedTrichlorosilane.getFluid(2000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DisproportionatedTrichlorosilane.getFluid(2000))
                .fluidOutputs(Dichlorosilane.getFluid(1000))
                .fluidOutputs(SiliconTetrachloride.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Dichlorosilane.getFluid(2000))
                .notConsumable(catalystBed, AluminiumChloride)
                .fluidOutputs(DisproportionatedDichlorosilane.getFluid(2000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DisproportionatedDichlorosilane.getFluid(2000))
                .fluidOutputs(Trichlorosilane.getFluid(1000))
                .fluidOutputs(Chlorosilane.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Chlorosilane.getFluid(2000))
                .notConsumable(catalystBed, AluminiumChloride)
                .fluidOutputs(DisproportionatedChlorosilane.getFluid(2000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DisproportionatedChlorosilane.getFluid(2000))
                .fluidOutputs(Dichlorosilane.getFluid(1000))
                .fluidOutputs(Silane.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        for (Utils.Combustible fuel : sintering_fuels) {
            if (fuel.isPlasma) {
                SINTERING_RECIPES.recipeBuilder()
                        .notConsumable(SHAPE_MOLD_PLATE)
                        .input(dust, SiliconCarbide)
                        .fluidInputs(fuel.fluid)
                        .output(plate, SiliconCarbide)
                        .fluidOutputs(fuel.byproduct)
                        .duration(fuel.duration)
                        .EUt(120)
                        .buildAndRegister();

            } else {
                for (Utils.Comburent comburent : sintering_comburents) {
                    SINTERING_RECIPES.recipeBuilder()
                            .notConsumable(SHAPE_MOLD_PLATE)
                            .input(dust, SiliconCarbide)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .output(plate, SiliconCarbide)
                            .fluidOutputs(fuel.byproduct)
                            .duration(fuel.duration + comburent.duration)
                            .EUt(7)
                            .buildAndRegister();
                }
            }
        }

// TEOS

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SiliconTetrachloride.getFluid(50))
                .fluidInputs(Ethanol.getFluid(200))
                .fluidOutputs(TetraethylOrthosilicate.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(200))
                .duration(5)
                .EUt(120)
                .buildAndRegister();
    }
}
