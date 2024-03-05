package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PolybenzimidazoleChain {
    public static void init() {
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .input(dust, SodiumHydroxide, 3)
                .fluidOutputs(SodiumPhenoxideSolution.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(IsophthaloylChlorideSolution.getFluid(50))
                .fluidInputs(SodiumPhenoxideSolution.getFluid(100))
                .fluidOutputs(DiphenylIsophthalateSolution.getFluid(50))
                .fluidOutputs(SaltWater.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

// 3,3'-Dichlorobenzidine

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TwoChloronitrobenzene.getFluid(288))
                .fluidInputs(HotHighPressureHydrogen.getFluid(10000))
                .notConsumable(dust, PalladiumOnCarbon)
                .output(dust, TwoTwoDichlorohydrazobenzene)
                .fluidOutputs(Water.getFluid(4000))
                .duration(300)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TwoTwoDichlorohydrazobenzene)
                .fluidInputs(Toluene.getFluid(1000))
                .notConsumable(SulfuricAcid.getFluid(50))
                .fluidOutputs(DichlorobenzidineSolution.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// 3,3-Diaminobenzidine

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(DichlorobenzidineSolution.getFluid(100))
                .fluidInputs(HotCompressedAmmonia.getFluid(200))
                .notConsumable(dust, Copper)
                .fluidOutputs(DiaminobenzidineSolution.getFluid(100))
                .fluidOutputs(HydrogenChloride.getFluid(200))
                .duration(20)
                .EUt(60)
                .buildAndRegister();

// PBI

        POLYMERIZATION_RECIPES.recipeBuilder()
                .notConsumable(Nitrogen.getFluid(8000))
                .fluidInputs(DiaminobenzidineSolution.getFluid(1000))
                .fluidInputs(DiphenylIsophthalateSolution.getFluid(1000))
                .output(dust, PBIFoam, 2)
                .fluidOutputs(PBIWaste.getFluid(4000))
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, PBIFoam)
                .output(dust, PBIPrepolymer)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Dimethylacetamide.getFluid(1000))
                .input(dust, PBIPrepolymer)
                .fluidOutputs(PBISolution.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .fluidInputs(PBISolution.getFluid(1000))
                .fluidOutputs(Dimethylacetamide.getFluid(1000))
                .output(dust, Polybenzimidazole)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(PBIWaste.getFluid(4000))
                .fluidOutputs(Toluene.getFluid(1000))
                .fluidOutputs(Phenol.getFluid(2000))
                .fluidOutputs(Dichloroethane.getFluid(1000))
                .duration(300)
                .EUt(240)
                .buildAndRegister();
    }
}
