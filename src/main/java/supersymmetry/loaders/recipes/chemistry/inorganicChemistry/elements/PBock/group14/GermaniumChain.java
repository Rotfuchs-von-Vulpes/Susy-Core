package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group14;

import gregtech.api.recipes.ingredients.GTRecipeItemInput;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.rotary_kiln_comburents;
import static supersymmetry.loaders.recipes.Utils.rotary_kiln_fuels;

public class GermaniumChain {
    public static void init() {
        // Tannic acid for Ge precipitation

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input("logWood")
                .fluidInputs(DistilledWater.getFluid(100))
                .fluidOutputs(TannicAcidSolution.getFluid(100))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Zinc hydrometallurgy route (primitive)
        OreDictionary.registerOre("dustZincResidues", OreDictUnifier.get(dust, ZincHydrochloricLeachResidue));
        OreDictionary.registerOre("dustZincResidues", OreDictUnifier.get(dust, ZincLeachResidue));

        var carbons = new ItemStack[]{
                OreDictUnifier.get(dust, Carbon),
                OreDictUnifier.get(dust, HighPurityCarbon),
                OreDictUnifier.get(dust, Coke)
        };

        for (var fuel : rotary_kiln_fuels) {
            for (var comburent : rotary_kiln_comburents) {
                ROTARY_KILN.recipeBuilder()
                        .input("dustZincResidues", 8)
                        .input(new GTRecipeItemInput(carbons, 1))
                        .output(dust, GermaniumRichOxide)
                        .output(dust, WaelzSlag)
                        .fluidInputs(fuel.fluid)
                        .fluidInputs(comburent.fluid)
                        .fluidOutputs(fuel.byproduct)
                        .duration(fuel.duration + comburent.duration)
                        .EUt(120)
                        .buildAndRegister();
            }
        }

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, GermaniumRichOxide)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(GermaniumLeach.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, WaelzOxide)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidOutputs(GermaniumLeach.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(TannicAcidSolution.getFluid(100))
                .fluidInputs(GermaniumLeach.getFluid(1000))
                .chancedOutput(dust, GermaniumConcentrate, 8000, 0)
                .fluidOutputs(ZincLeach.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Oxalate SX route (universal)

        MIXER_RECIPES.recipeBuilder()
                .input(dust, OxalicAcid)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(OxalicAcidSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, GermaniumRichOxide, 2)
                .fluidInputs(OxalicAcidSolution.getFluid(1000))
                .output(dust, LeadSilicaResidue)
                .fluidOutputs(GermaniumOxalateLeach.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dustSmall, Iron, 2)
                .fluidInputs(GermaniumOxalateLeach.getFluid(8000))
                .output(dust, IronOxalateDihydrate, 9)
                .fluidOutputs(PurifiedGermaniumOxalateLeach.getFluid(6000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, IronOxalateDihydrate, 9)
                .output(dust, IronIIOxide, 2)
                .fluidOutputs(Steam.getFluid(2000))
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(Kerosene.getFluid(700))
                .fluidInputs(SulfuricAcid.getFluid(200))
                .fluidInputs(TriOctylDecylAmine.getFluid(200))
                .fluidInputs(TributylPhosphate.getFluid(100))
                .fluidOutputs(GermaniumGalliumExtractionMixture.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumGalliumExtractionMixture.getFluid(1000))
                .fluidInputs(PurifiedGermaniumOxalateLeach.getFluid(1000))
                .fluidOutputs(GermaniumGalliumExtract.getFluid(1000))
                .fluidOutputs(OxalicAcidSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumGalliumExtract.getFluid(1000))
                .fluidInputs(DilutedSulfuricAcid.getFluid(600))
                .fluidOutputs(GermaniumExtract.getFluid(1000))
                .fluidOutputs(GalliumSulfateSolution.getFluid(300))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// 1 Ga2(SO4)3, 3 H2O, 6 oxalic acid
        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(stick, Steel)
                .notConsumable(GRAPHITE_ELECTRODE)
                .fluidInputs(GalliumSulfateSolution.getFluid(3000))
                .output(dust, Gallium, 2)
                .output(dust, OxalicAcid, 6)
                .fluidOutputs(Oxygen.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(3000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumExtract.getFluid(1000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(200))
                .fluidOutputs(GermaniumGalliumExtractionMixture.getFluid(1000))
                .fluidOutputs(GermaniumOxalateSolution.getFluid(400))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(spring, Cupronickel)
                .fluidInputs(GermaniumOxalateSolution.getFluid(400))
                .fluidInputs(HydrochloricAcid.getFluid(400))
                .fluidInputs(Chlorine.getFluid(50))
                .fluidOutputs(ImpureGermaniumTetrachloride.getFluid(100))
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Concentrate purification

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(spring, Cupronickel)
                .input(dust, GermaniumConcentrate)
                .fluidInputs(HydrochloricAcid.getFluid(400))
                .fluidInputs(Chlorine.getFluid(60))
                .fluidOutputs(ImpureGermaniumTetrachloride.getFluid(100))
                .fluidOutputs(Wastewater.getFluid(600))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureGermaniumTetrachloride.getFluid(1000))
                .fluidOutputs(ArsenicTrichloride.getFluid(100))
                .fluidOutputs(GermaniumTetrachloride.getFluid(900))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(GermaniumTetrachloride.getFluid(1000))
                .fluidInputs(UltrapureWater.getFluid(6000))
                .output(dust, GermaniumDioxide, 3)
                .fluidOutputs(HydrochloricAcid.getFluid(4000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(dust, GermaniumDioxide, 3)
                .fluidInputs(Hydrogen.getFluid(4000))
                .output(dust, Germanium)
                .fluidOutputs(Steam.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ZONE_REFINER_RECIPES.recipeBuilder()
                .input(ingot, Germanium)
                .output(ingot, HighPurityGermanium)
                .duration(200)
                .EUt(30)
                .buildAndRegister();
    }
}
