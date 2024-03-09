package supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry;

import static gregtech.api.recipes.RecipeMaps.DISTILLERY_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BATCH_REACTOR_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.CSTR_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Surfactants {
    public static void init() {
        CSTR_RECIPES.recipeBuilder()
                .notConsumable(plate, Polytetrafluoroethylene, 6)
                .fluidInputs(SulfurTrioxide.getFluid(50))
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidOutputs(ChlorosulfuricAcid.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(plate, Polytetrafluoroethylene, 6)
                .fluidInputs(ChlorosulfuricAcid.getFluid(1000))
                .fluidInputs(NDodecanol.getFluid(1000))
                .output(dust, HydrogenDodecylSulfate)
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(NDodecanol.getFluid(1000))
                .fluidInputs(Oleum.getFluid(11000))
                .output(dust, HydrogenDodecylSulfate)
                .fluidOutputs(SulfuricAcid.getFluid(10000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, HydrogenDodecylSulfate)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(SodiumDodecylSulfateSolution.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumDodecylSulfateSolution.getFluid(1000))
                .output(dust, SodiumDodecylSulfate)
                .fluidOutputs(Water.getFluid(2000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dustTiny, SodiumHydroxide)
                .fluidInputs(EthyleneOxide.getFluid(1000))
                .fluidInputs(NButanol.getFluid(1000))
                .fluidOutputs(TwoButoxyethanol.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

// Antistatic surfactant (dinonylnaphthalene sulfonate)

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Naphthalene.getFluid(1000))
                .fluidInputs(Tripropylene.getFluid(2000))
                .notConsumable(HydrofluoricAcid.getFluid(100))
                .output(dust, Dinonylnaphthalene)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Dinonylnaphthalene)
                .fluidInputs(Oleum.getFluid(11000))
                .output(dust, DinonylnaphthaleneSulfonicAcid)
                .fluidOutputs(SulfuricAcid.getFluid(10000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(plate, Polytetrafluoroethylene, 6)
                .input(dust, Dinonylnaphthalene)
                .fluidInputs(ChlorosulfuricAcid.getFluid(1000))
                .output(dust, DinonylnaphthaleneSulfonicAcid)
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();
    }
}
