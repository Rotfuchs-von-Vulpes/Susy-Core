package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.FBlock.actinides;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class UraniumChain {
    public static void init() {
        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(HotSulfuricAcid.getFluid(2000))
                .fluidInputs(DistilledWater.getFluid(4000))
                .input(dust, Carnotite)
                .fluidOutputs(CarnotiteLeach.getFluid(6000))
                .EUt(120)
                .duration(300)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(CarnotiteLeach.getFluid(6000))
                .input("dustAnyPurityIron")
                .input(dust, Calcite, 3)
                .fluidOutputs(ReducedCarnotiteLeach.getFluid(6000))
                .EUt(120)
                .duration(300)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Kerosene.getFluid(900))
                .fluidInputs(TributylPhosphate.getFluid(40))
                .fluidInputs(DiTwoEthylhexylPhosphoricAcid.getFluid(60))
                .fluidOutputs(UraniumVanadiumExtractionMixture.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UraniumVanadiumExtractionMixture.getFluid(1000))
                .fluidInputs(ReducedCarnotiteLeach.getFluid(1000))
                .fluidOutputs(UraniumVanadiumExtract.getFluid(1000))
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(240)
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UraniumVanadiumExtract.getFluid(3000))
                .fluidInputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(UraniumExtract.getFluid(3000))
                .fluidOutputs(AcidicVanadylSolution.getFluid(2000))
                .EUt(240)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(AcidicVanadylSolution.getFluid(6000))
                .fluidInputs(Ammonia.getFluid(1000))
                .inputs(SodiumChlorate.getItemStack(5))
        .fluidOutputs(Wastewater.getFluid(6000))
                .output(dust, VanadiumPentoxide, 7)
                .EUt(240)
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UraniumExtract.getFluid(3000))
                .fluidInputs(SodaAshSolution.getFluid(1000))
                .fluidOutputs(UraniumVanadiumExtractionMixture.getFluid(3000))
                .fluidOutputs(ImpureUranylCarbonateSolution.getFluid(1000))
                .EUt(720)
                .duration(160)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .fluidInputs(ImpureUranylCarbonateSolution.getFluid(6000))
                .chancedOutput(dust, AluminiumCarbonate, 14, 1000, 1000)
                .chancedOutput(dust, IronCarbonate, 5, 4000, 1000)
                .fluidOutputs(UranylCarbonateSolution.getFluid(6000))
                .EUt(240)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AluminiumCarbonate, 14)
                .output(dust, Alumina, 5)
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, IronCarbonate, 5)
                .output(dust, IronIIOxide, 2)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(UranylCarbonateSolution.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(UranylSulfateSolution.getFluid(100))
                .fluidOutputs(CarbonDioxide.getFluid(50))
                .EUt(240)
                .duration(5)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(UranylSulfateSolution.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidOutputs(AmmoniumSulfateSolution.getFluid(1000))
                .output(dust, AmmoniumDiuranate, 19)
                .EUt(720)
                .duration(200)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, AmmoniumDiuranate, 19)
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, UraniumDioxide, 6)
                .fluidOutputs(Ammonia.getFluid(2000))
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(3840)
                .duration(600)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, UraniumDioxide, 3)
                .input("dustAnyPurityMagnesium", 2)
                .output(dust, Uranium238) // Uranium
                .output(dust, Magnesia, 4)
                .EUt(3840)
                .duration(300)
                .buildAndRegister();

        ROTARY_KILN.recipeBuilder()
                .input(dust, UraniumDioxide, 3)
                .fluidInputs(HydrogenFluoride.getFluid(4000))
                .output(dust, UraniumTetrafluoride, 5)
                .fluidOutputs(Steam.getFluid(2000))
                .EUt(1920)
                .duration(80)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, UraniumTetrafluoride, 5)
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidOutputs(UraniumHexafluoride.getFluid(1000))
                .EUt(240)
                .duration(80)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(UraniumHexafluoride.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(2000))
                .output(dust, UraniumTetrafluoride, 5)
                .fluidOutputs(HydrogenFluoride.getFluid(2000))
                .EUt(240)
                .duration(80)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, UraniumTetrafluoride, 5)
                .input(dust, Magnesium, 2)
                .output(dust, Uranium238)
                .output(dust, MagnesiumFluoride, 6)
                .EUt(3840)
                .duration(80)
                .buildAndRegister();
    }
}
