package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.CARBON_FIBERS;
import static gregtechfoodoption.GTFOMaterialHandler.Acetaldehyde;
import static gregtechfoodoption.GTFOMaterialHandler.Glyoxal;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.fiber;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.item.SuSyMetaItems.*;

public class EpoxyChain {
    // Curing agents
    private static class CuringAgent {
        Material name;
        boolean liquid;
        int amount_required;
        double duration;
        CuringAgent(Material name, Boolean liquid, int amount_required, double duration) {
            this.name = name;
            this.liquid = liquid;
            this.amount_required = amount_required;
            this.duration = duration;
        }
    }

    public static void init() {
// Fiber-Reinforced Epoxy Resin Sheet * 1
        removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(wireFine, BorosilicateGlass)}, new FluidStack[]{Epoxy.getFluid(144)});
// Fiber-Reinforced Epoxy Resin Sheet * 1
        removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{CARBON_FIBERS.getStackForm()}, new FluidStack[]{Epoxy.getFluid(144)});

        CuringAgent[] curingAgents = {
                new CuringAgent(Diethylenetriamine, true, 100, 1f),
                new CuringAgent(Triethylenetetramine, true, 50, 1f),
                new CuringAgent(Aminoethylpiperazine, true, 50, 1f),
                new CuringAgent(Dicyandiamide, false, 2, 2f),
                new CuringAgent(PhthalicAnhydride, false, 1, 2f),
                new CuringAgent(EpoxyCuringMixture, false, 1, 0.25f)
        };

        // BPA

        ION_EXCHANGE_COLUMN_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(2000))
                .fluidInputs(Acetone.getFluid(1000))
                .notConsumable(BEADS_AG_FIFTY_W_X_EIGHT)
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, BisphenolA)
                .EUt(480)
                .duration(100)
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(dust, BisphenolA)
                .fluidOutputs(BisphenolA.getFluid(1000))
                .EUt(30)
                .duration(100)
                .buildAndRegister();

// Epichlorohydrin

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Glycerol.getFluid(50))
                .fluidInputs(HydrogenChloride.getFluid(100))
                .fluidInputs(AceticAcid.getFluid(10))
                .fluidOutputs(ChlorinatedGlycerol.getFluid(160))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(ChlorinatedGlycerol.getFluid(3200))
                .input(dust, SodiumHydroxide, 3)
                .fluidOutputs(EpichlorohydrinSolution.getFluid(4200))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(EpichlorohydrinSolution.getFluid(4200))
                .fluidOutputs(AceticAcid.getFluid(200))
                .fluidOutputs(Epichlorohydrin.getFluid(1000))
                .fluidOutputs(Water.getFluid(3000))
                .output(dust, Salt, 2)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AllylChloride.getFluid(50))
                .fluidInputs(HypochlorousAcid.getFluid(50))
                .fluidOutputs(AllylAlcoholMix.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AllylAlcoholMix.getFluid(1000))
                .input(dust, SodiumHydroxide, 3)
                .fluidOutputs(DilutedEpichlorohydrin.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedEpichlorohydrin.getFluid(2000))
                .fluidOutputs(Epichlorohydrin.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, Salt, 2)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// Unmodified DGEBPA

        for (CuringAgent curingAgent : curingAgents) {
            if (curingAgent.liquid) {
                POLYMERIZATION_RECIPES.recipeBuilder()
                        .input(dust, BisphenolA)
                        .fluidInputs(Epichlorohydrin.getFluid(1200)) //excess epichlorohydrin to control degree of polymerization
                        .fluidInputs(curingAgent.name.getFluid(curingAgent.amount_required))
                        .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                        .output(dust, WetEpoxy, 2)
                        .fluidOutputs(DilutedSaltwater.getFluid(2000))
                        .duration((int) (100 * curingAgent.duration))
                        .EUt(480)
                        .buildAndRegister();
            } else {
                POLYMERIZATION_RECIPES.recipeBuilder()
                        .input(dust, BisphenolA, 4)
                        .fluidInputs(Epichlorohydrin.getFluid(4800))
                        .input(dust, curingAgent.name, curingAgent.amount_required)
                        .fluidInputs(SodiumHydroxideSolution.getFluid(4000))
                        .output(dust, WetEpoxy, 8)
                        .fluidOutputs(DilutedSaltwater.getFluid(8000))
                        .duration((int) (100 * curingAgent.duration))
                        .EUt(480)
                        .buildAndRegister();
            }
        }

        VACUUM_CHAMBER.recipeBuilder()
                .input(dust, WetEpoxy, 7)
                .notConsumable(spring, Nichrome)
                .output(dust, Epoxy, 7)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Flame retardant DGEBA

// Catalyst preparation
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AluminiumHydroxide, 7)
                .fluidInputs(HydrochloricAcid.getFluid(3000))
                .fluidOutputs(AluminiumChlorideSolution.getFluid(3000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelChloride, 9)
                .input(dust, AluminiumChloride, 4)
                .fluidInputs(DemineralizedWater.getFluid(4000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(8000))
                .output(dust, NickelHydrotalcite)
                .fluidOutputs(SaltWater.getFluid(8000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelHydrotalcite)
                .fluidInputs(SodiumTungstateSolution.getFluid(100))
                .output(dust, BisphenolBrominationCatalyst)
                .fluidOutputs(Wastewater.getFluid(100))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Bromination

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BisphenolA)
                .notConsumable(dust, BisphenolBrominationCatalyst)
                .fluidInputs(Dichloroethane.getFluid(6000))
                .fluidInputs(HydrogenPeroxideSolution.getFluid(2000))
                .fluidInputs(Bromine.getFluid(4000))
                .fluidOutputs(ImpureBrominatedBisphenolEmulsion.getFluid(10000))
                .duration(160)
                .EUt(1920)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(ImpureBrominatedBisphenolEmulsion.getFluid(10000))
                .fluidOutputs(ImpureBrominatedBisphenolSolution.getFluid(6000))
                .fluidOutputs(Water.getFluid(4000))
                .duration(160)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Water.getFluid(6500))
                .fluidInputs(SodiumSulfiteSolution.getFluid(500))
                .fluidOutputs(DilutedSodiumSulfiteSolution.getFluid(7000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(ImpureBrominatedBisphenolSolution.getFluid(6000))
                .fluidInputs(DilutedSodiumSulfiteSolution.getFluid(7000))
                .fluidOutputs(TetrabromobisphenolASolution.getFluid(6000))
                .fluidOutputs(Water.getFluid(7000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(TetrabromobisphenolASolution.getFluid(6000))
                .output(dust, TetrabromobisphenolA)
                .fluidOutputs(Dichloroethane.getFluid(6000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// Curing agents
// Dicyanimide
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumCyanamide, 4)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, Calcite, 5)
                .output(dust, Cyanamide, 5)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Cyanamide, 10)
                .notConsumable(SodiumHydroxideSolution.getFluid(1000))
                .output(dust, Dicyandiamide, 10)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// 2-methylimidazole (Debus–Radziszewski imidazole synthesis)
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Glyoxal.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(Acetaldehyde.getFluid(1000))
                .output(dust, TwoMethylimidazole, 12)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, TwoMethylimidazole)
                .input(dust, Dicyandiamide, 2)
                .input(dust, PhthalicAnhydride)
                .output(dust, EpoxyCuringMixture)
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .input(dust, TetrabromobisphenolA, 4)
                .fluidInputs(Epichlorohydrin.getFluid(4800))
                .input(dust, EpoxyCuringMixture)
                .fluidInputs(SodiumHydroxideSolution.getFluid(4000))
                .output(dust, WetFlameRetardantEpoxy, 8)
                .fluidOutputs(DilutedSaltwater.getFluid(8000))
                .duration(100)
                .EUt(1920)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .input(dust, WetFlameRetardantEpoxy, 7)
                .notConsumable(spring, Nichrome)
                .output(dust, FlameRetardantEpoxy, 7)
                .duration(25)
                .EUt(30)
                .buildAndRegister();

// Fiber reinforced epoxy

// E glass
        MIXER_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 3)
                .fluidInputs(SulfuricAcid.getFluid(10))
                .output(dust, AcidWashedSiliconDioxide, 3)
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, AcidWashedSiliconDioxide, 18)
                .input(dust, Alumina, 5)
                .input(dust, BoronTrioxide, 5)
                .input(dust, Quicklime, 4)
                .output(dust, EGlass, 10)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, EGlass)
                .fluidOutputs(EGlass.getFluid(144))
                .blastFurnaceTemp(1000)
                .EUt(120)
                .duration(10)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .notConsumable(stick, Steel)
                .input(fiber, Kevlar)
                .fluidInputs(EGlass.getFluid(144))
                .output(GLASS_FIBERS)
                .EUt(120)
                .duration(10)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(GLASS_FIBERS)
                .fluidInputs(FlameRetardantEpoxy.getFluid(144))
                .output(EPOXY_LAMINA)
                .EUt(120)
                .duration(10)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .input(EPOXY_LAMINA)
                .output(plate, ReinforcedEpoxyResin)
                .EUt(120)
                .duration(100)
                .buildAndRegister();

// SU-8 photoresist

// Bisphenol A Novolac Epoxy
        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(Epoxy.getFluid(1008))
                .fluidInputs(Formaldehyde.getFluid(3000))
                .output(dust, BisphenolANovolacEpoxy, 7)
                .duration(100)
                .EUt(1920)
                .buildAndRegister();

// Propylene Carbonate
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Propene.getFluid(100))
                .fluidInputs(Chlorine.getFluid(100))
                .fluidInputs(Water.getFluid(50))
                .fluidOutputs(PropyleneChlorohydrin.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(PropyleneChlorohydrin.getFluid(2000))
                .fluidOutputs(PropyleneOxideSolution.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(PropyleneOxideSolution.getFluid(2000))
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(Water.getFluid(2000))
                .fluidOutputs(PropyleneOxide.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PropyleneOxide.getFluid(50))
                .fluidInputs(CarbonDioxide.getFluid(50))
                .fluidOutputs(PropyleneCarbonate.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

// Triarylsulfonium Hexafluoroantimonate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(AntimonyTrifluoride.getFluid(576))
                .fluidInputs(Fluorine.getFluid(2000))
                .fluidOutputs(AntimonyPentafluoride.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumFluoride, 2)
                .fluidInputs(AntimonyPentafluoride.getFluid(1000))
                .output(dust, SodiumHexafluoroantimonate, 8)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Sulfur, 2)
                .fluidInputs(Chlorine.getFluid(2000))
                .fluidOutputs(DisulfurDichloride.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Benzene.getFluid(2000))
                .fluidInputs(DisulfurDichloride.getFluid(1000))
                .output(dust, Sulfur)
                .output(dust, DiphenylSulfide)
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, AluminiumChloride)
                .fluidInputs(Benzene.getFluid(2000))
                .fluidInputs(SulfurDioxide.getFluid(1000))
                .output(dust, DiphenylSulfoxide)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dustTiny, PotassiumPersulfate)
                .fluidInputs(Methane.getFluid(1000))
                .fluidInputs(Oleum.getFluid(11000))
                .fluidOutputs(MethanesulfonicAcid.getFluid(1000))
                .fluidOutputs(SulfuricAcid.getFluid(10000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, PhosphorusPentoxide)
                .fluidInputs(MethanesulfonicAcid.getFluid(4000))
                .fluidOutputs(SulfoniumPreparationMixture.getFluid(4000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, DiphenylSulfoxide)
                .input(dust, DiphenylSulfide)
                .input(dust, SodiumHexafluoroantimonate, 8)
                .notConsumable(SulfoniumPreparationMixture.getFluid(28000))
                .output(dust, TriarylsulfoniumHexafluoroantimonate, 52)
                .duration(100)
                .EUt(480)
                .buildAndRegister();

/*
Bisphenol-A Novolac Epoxy
    Average Molar Mass: "430" g/mol (not real)
    Percent Weight: 50%
Gamma-Butyrolactone
    Molar Mass: 86.090 g/mol
    Percent Weight: 45%
Propylene Carbonate
    Molar Mass: 102.089 g/mol
    Percent Weight: 2.5%
Triarylsulfonium Hexafluoroantimonate
    Molar Mass: 607.29 g/mol
    Percent Weight: 2.5%

Assume 100g of material.
    50g Novolac
    45g Gamma Butyrolactone
    2.5g Propylene Carbonate
    2.5g Triarylsulfonium Hexafluoroantimonate

    116 mmol Bisphenol-A Novolac Epoxy
    523 mmol Gamma-Butyrolactone
    24.5 mmol Propylene Carbonate
    4.12 mmol Triarylsulfonium Hexafluoroantimonate

Total: 667.62 mmol.
    17.4% Bisphenol-A Novolac Epoxy
    78.3% Gamma-Butyrolactone
    3.67% Propylene Carbonate
    0.617% Triarylsulfonium Hexafluoroantimonate
*/

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, TriarylsulfoniumHexafluoroantimonate)
                .input(dust, BisphenolANovolacEpoxy, 7)
                .fluidInputs(PropyleneCarbonate.getFluid(200))
                .fluidInputs(GammaButyrolactone.getFluid(4800))
                .fluidOutputs(SuEight.getFluid(5000))
                .duration(670)
                .EUt(1920)
                .buildAndRegister();

    }
}
