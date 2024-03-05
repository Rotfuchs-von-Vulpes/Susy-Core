package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_BLOCK;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_PLATE;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static net.minecraft.init.Blocks.SPONGE;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.api.unification.ore.SusyOrePrefix.fiber;
import static supersymmetry.common.item.SuSyMetaItems.SPINNERET;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolyurethaneChain {
    public static void init() {
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Formaldehyde.getFluid(2000))
                .fluidInputs(Aniline.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(1000))
                .output(dust, Methylenedianiline, 8)
                .fluidOutputs(DilutedHydrochloricAcid.getFluid(2000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedHydrochloricAcid.getFluid(500))
                .fluidOutputs(HydrochloricAcid.getFluid(250))
                .fluidOutputs(Water.getFluid(250))
                .duration(50)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Methylenedianiline, 8)
                .fluidInputs(Phosgene.getFluid(2000))
                .output(dust, MethyleneDiphenylDiisocyanate, 10)
                .fluidOutputs(HydrogenChloride.getFluid(4000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneOxide.getFluid(150))
                .fluidInputs(Ammonia.getFluid(300))
                .fluidOutputs(EthanolamineMix.getFluid(150))
                .duration(1)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(EthanolamineMix.getFluid(3000))
                .fluidOutputs(Triethanolamine.getFluid(1000))
                .fluidOutputs(Diethanolamine.getFluid(1000))
                .fluidOutputs(Ethanolamine.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, MolecularSieve)
                .fluidInputs(Ethanolamine.getFluid(3000))
                .output(dust, Triethylenediamine, 8)
                .fluidOutputs(Ammonia.getFluid(1000))
                .fluidOutputs(Steam.getFluid(3000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .input(dust, MethyleneDiphenylDiisocyanate, 10)
                .input(dustTiny, Triethylenediamine)
                .fluidInputs(EthyleneOxide.getFluid(750))
                .fluidInputs(EthyleneGlycol.getFluid(250))
                .fluidInputs(Polydimethylsiloxane.getFluid(18))
                .fluidOutputs(PolyurethanePolymerizationMix.getFluid(1000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        FLUID_COMPRESSOR_RECIPES.recipeBuilder()
                .fluidInputs(HotCompressedCarbonDioxide.getFluid(1280))
                .fluidOutputs(SupercriticalCarbonDioxide.getFluid(20))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_BLOCK)
                .fluidInputs(PolyurethanePolymerizationMix.getFluid(9000))
                .fluidInputs(Water.getFluid(180))
                .fluidInputs(SupercriticalCarbonDioxide.getFluid(180))
                .output(block, Polyurethane)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .fluidInputs(PolyurethanePolymerizationMix.getFluid(1000))
                .fluidInputs(Water.getFluid(20))
                .fluidInputs(SupercriticalCarbonDioxide.getFluid(20))
                .output(plate, Polyurethane)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(block, Polyurethane)
                .fluidInputs(DyeYellow.getFluid(288))
                .output(SPONGE)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Adipic acid for Spandex

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Palladium)
                .notConsumable(HydrogenIodide.getFluid(1000))
                .fluidInputs(Butadiene.getFluid(1000))
                .fluidInputs(CarbonMonoxide.getFluid(2000))
                .fluidInputs(Water.getFluid(2000))
                .output(dust, AdipicAcid, 20)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .input(dust, MethyleneDiphenylDiisocyanate, 10)
                .input(dust, AdipicAcid, 15)
                .input(dustTiny, Triethylenediamine, 1)
                .fluidInputs(Dimethylacetamide.getFluid(4000))
                .fluidOutputs(SpandexPrepolymer.getFluid(4000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(SpandexPrepolymer.getFluid(4000))
                .fluidInputs(Ethylenediamine.getFluid(250))
                .fluidInputs(Diethylamine.getFluid(10))
                .fluidOutputs(SpandexPolymerizationMix.getFluid(4000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(SpandexPolymerizationMix.getFluid(4000))
                .fluidInputs(HotAir.getFluid(1000))
                .notConsumable(SPINNERET)
                .output(fiber, Spandex, 8)
                .fluidOutputs(Air.getFluid(1000))
                .fluidOutputs(Dimethylacetamide.getFluid(3500))
                .EUt(480)
                .duration(100)
                .buildAndRegister();
    }
}
