package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.sifted;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.*;
public class ZincChain {
    public static void init() {
        // Zincite Dust * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Sphalerite)}, new FluidStack[]{Oxygen.getFluid(3000)});

        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Sphalerite, 4)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(Sphalerite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Sphalerite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 16000))
                .notConsumable(dust, SodiumEthylXanthate)
                .notConsumable(Cresol.getFluid(100))
                .notConsumable(SodaAshSolution.getFluid(1000))
                .fluidOutputs(Galena.getFluid(SusyFluidStorageKeys.SLURRY, 3000))
                .fluidOutputs(UnprocessedSphaleriteSlurry.getFluid(16000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(UnprocessedSphaleriteSlurry.getFluid(16000))
                .notConsumable(dust, PotassiumAmylXanthate)
                .notConsumable(SodaAshSolution.getFluid(1000))
                .fluidOutputs(Sphalerite.getFluid(SusyFluidStorageKeys.SLURRY, 16000))
                .output(dust, GraniteTailings, 16)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Sphalerite.getFluid(SusyFluidStorageKeys.SLURRY, 16000))
                .fluidOutputs(Wastewater.getFluid(16000))
                .output(dust, Sphalerite, 64)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dustImpure, Smithsonite, 4)
                .fluidInputs(Water.getFluid(2000))
                .fluidOutputs(Smithsonite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(Smithsonite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 16000))
                .notConsumable(dust, SodiumEthylXanthate)
                .notConsumable(Cresol.getFluid(100))
                .notConsumable(SodaAshSolution.getFluid(1000))
                .fluidOutputs(Smithsonite.getFluid(SusyFluidStorageKeys.SLURRY, 16000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(Smithsonite.getFluid(SusyFluidStorageKeys.SLURRY, 16000))
                .fluidOutputs(Wastewater.getFluid(16000))
                .output(dust, Smithsonite, 64)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Sphalerite, 1)
                .fluidInputs(Oxygen.getFluid(2000))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .output(dust, Zincite, 2)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Sphalerite, 1)
                .fluidInputs(Oxygen.getFluid(3000))
                .fluidOutputs(ThalliumRichFlueGas.getFluid(1000))
                .output(dust, Zincite, 2)
                .output(dust, ZincRichSlag, 1)
                .EUt(120)
                .duration(20)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .notConsumable(ITEM_FILTER)
                .fluidInputs(ThalliumRichFlueGas.getFluid(1000))
                .chancedOutput(dust, ThalliumRichFlue, 1000, 250)
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .EUt(120)
                .duration(20)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Smithsonite, 1)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .output(dust, Zincite, 2)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Smithsonite, 10)
                .fluidOutputs(CarbonDioxide.getFluid(10000))
                .output(dust, Zincite, 20)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        for (CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, Zincite, 2)
                    .inputs(combustible.name)
                    .outputs(combustible.byproduct)
                    .fluidOutputs(CrudeZinc.getFluid(216))
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .EUt(30)
                    .duration(160 * combustible.duration)
                    .buildAndRegister();
        }

        for (CarbonSource combustible : highPurityCombustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            ROASTER_RECIPES.recipeBuilder()
                    .input(dust, ZincOxide, 2)
                    .inputs(combustible.name)
                    .output(dust, Zinc)
                    .fluidOutputs(CarbonMonoxide.getFluid(1000))
                    .EUt(30)
                    .duration(160 * combustible.duration)
                    .buildAndRegister();
        }

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(CrudeZinc.getFluid(216))
                .output(ingot, Zinc)
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .fluidInputs(CadmiumRichZinc.getFluid(180))
                .output(ingot, Zinc)
                .EUt(7)
                .duration(20)
                .buildAndRegister();

        HIGH_TEMPERATURE_DISTILLATION.recipeBuilder()
                .fluidInputs(CrudeZinc.getFluid(2160))
                .chancedOutput(dust, Iron, 200, 100)
                .fluidOutputs(CadmiumRichZinc.getFluid(2160))
                .fluidOutputs(Copper.getFluid(36))
                .fluidOutputs(Lead.getFluid(72))
                .fluidOutputs(Tin.getFluid(36))
                .EUt(120)
                .duration(300)
                .buildAndRegister();

        HIGH_TEMPERATURE_DISTILLATION.recipeBuilder()
                .fluidInputs(CadmiumRichZinc.getFluid(2160))
                .fluidOutputs(Zinc.getFluid(2160))
                .fluidOutputs(Cadmium.getFluid(144))
                .EUt(480)
                .duration(300)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Zincite, 2)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(ZincLeach.getFluid(1000))
                .output(dust, ZincLeachResidue)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(HotSulfuricAcid.getFluid(1000))
                .EUt(7)
                .duration(50)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, ZincLeachResidue)
                .fluidInputs(HotSulfuricAcid.getFluid(100))
                .fluidOutputs(HotZincLeach.getFluid(100))
                .chancedOutput(dust, HotZincLeachResidue, 500, 500)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, HotZincLeachResidue)
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .output(dust, SoftenedLead)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Sphalerite, 2)
                .fluidInputs(HotZincLeach.getFluid(16000))
                .fluidOutputs(ReducedZincLeach.getFluid(16000))
                .EUt(30)
                .duration(400)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(1000))
                .fluidInputs(ReducedZincLeach.getFluid(16000))
                .fluidOutputs(ZincLeach.getFluid(16000))
                .output(dust, IronIIIOxide, 5)
                .EUt(30)
                .duration(400)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, ZincRichSlag, 10)
                .input("dustAnyPurityCarbon", 2)
                .output(dust, WaelzOxide, 7)
                .output(dust, GermaniumRichSlag, 3)
                .blastFurnaceTemp(1400)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        HIGH_TEMPERATURE_DISTILLATION.recipeBuilder()
                .fluidInputs(WaelzOxide.getFluid(1440))
                .chancedOutput(dust, Lead, 500, 300)
                .fluidOutputs(CadmiumRichZinc.getFluid(1440))
                .fluidOutputs(Cadmium.getFluid(72))
                .EUt(120)
                .duration(300)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(1000))
                .input(dust, Zinc, 1)
                .fluidOutputs(ZincCementationSlurry.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(ZincLeach.getFluid(1000))
                .fluidInputs(ZincCementationSlurry.getFluid(100))
                .fluidOutputs(PrecipitatedZincLeach.getFluid(1000))
                .output(dust, CopperCadmiumResidue, 1)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .input(dust, CopperCadmiumResidue, 20)
                .fluidOutputs(CadmiumSulfateSolution.getFluid(1000))
                .output(dust, Copper, 2)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(PrecipitatedZincLeach.getFluid(1000))
                .fluidOutputs(HotPrecipitatedZincLeach.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(HotPrecipitatedZincLeach.getFluid(1000))
                .fluidInputs(ZincCementationSlurry.getFluid(40))
                .fluidOutputs(ReprecipitatedZincLeach.getFluid(1000))
                .output(dust, CobaltResidue, 1)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .input(dust, CobaltResidue, 20)
                .fluidOutputs(ZincLeach.getFluid(1000))
                .output(dust, Cobalt, 1)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(plate, Lead, 4)
                .notConsumable(plate, Aluminium, 4)
                .circuitMeta(1)
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidInputs(DistilledWater.getFluid(50))
                .fluidInputs(ReprecipitatedZincLeach.getFluid(1000))
                .output(dust, Zinc)
                .chancedOutput(dust, Zinc, 2500, 500)
                .fluidOutputs(Hydrogen.getFluid(100))
                .fluidOutputs(Oxygen.getFluid(1050))
                .fluidOutputs(SulfuricAcid.getFluid(1050))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(plate, Lead, 4)
                .notConsumable(plate, Aluminium, 4)
                .circuitMeta(2)
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidInputs(DistilledWater.getFluid(50))
                .fluidInputs(ReprecipitatedZincLeach.getFluid(1000))
                .output(dust, HighPurityZinc)
                .fluidOutputs(Hydrogen.getFluid(100))
                .fluidOutputs(Oxygen.getFluid(1050))
                .fluidOutputs(SulfuricAcid.getFluid(1050))
                .EUt(120)
                .duration(200)
                .buildAndRegister();
    }
}
