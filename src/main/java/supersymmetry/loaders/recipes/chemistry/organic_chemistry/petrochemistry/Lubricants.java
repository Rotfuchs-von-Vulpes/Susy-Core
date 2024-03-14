package supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry;

import gregtech.api.unification.material.Material;

import java.util.HashMap;
import java.util.Map;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.api.unification.ore.SusyOrePrefix.flotated;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Lubricants {
    public static void init() {
        // Lubricant base oils

        // Straight run lubricating oil

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Dichloroethane.getFluid(1000))
                .fluidInputs(Dichloromethane.getFluid(1000))
                .fluidOutputs(DewaxingSolvent.getFluid(2000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(CrudeLubricatingOil.getFluid(850))
                .fluidInputs(DewaxingSolvent.getFluid(2000))
                .fluidOutputs(SolventLubricantMixture.getFluid(2850))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        HEAT_EXCHANGER_RECIPES.recipeBuilder()
                .fluidInputs(Ice.getFluid(500))
                .fluidInputs(SolventLubricantMixture.getFluid(2850))
                .fluidOutputs(Water.getFluid(500))
                .fluidOutputs(ColdSolventLubricantMixture.getFluid(2850))
                .duration(5)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(ColdSolventLubricantMixture.getFluid(2850))
                .fluidOutputs(SlackWax.getFluid(350))
                .fluidOutputs(DewaxedLubricantMixture.getFluid(2500))
                .duration(5)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DewaxedLubricantMixture.getFluid(2500))
                .fluidOutputs(SulfuricLubricatingOil.getFluid(500))
                .fluidOutputs(DewaxingSolvent.getFluid(2000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricLubricatingOil.getFluid(180))
                .fluidInputs(Hydrogen.getFluid(45))
                .notConsumable(catalystBed, Alumina)
                .fluidOutputs(LubricatingOil.getFluid(180))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        // Hydrodewaxing catalyst

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, Alumina, 5)
                .fluidInputs(Diisopropylamine.getFluid(1200))
                .fluidInputs(PhosphoricAcid.getFluid(1000))
                .fluidInputs(TetraethylOrthosilicate.getFluid(200))
                .fluidInputs(DemineralizedWater.getFluid(5000))
                .output(dust, SAPOEleven)
                .duration(600)
                .EUt(1920)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Platinum)
                .fluidInputs(AquaRegia.getFluid(8000))
                .fluidInputs(NitricAcid.getFluid(2000))
                .fluidOutputs(ChloroplatinicAcidSolution.getFluid(4000))
                .fluidOutputs(NitrogenDioxide.getFluid(4000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SAPOEleven)
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(EthyleneGlycol.getFluid(500))
                .fluidInputs(ChloroplatinicAcidSolution.getFluid(1000))
                .output(dust, PlatinumSAPOEleven)
                .fluidOutputs(Wastewater.getFluid(1500))
                .duration(600)
                .EUt(1920)
                .buildAndRegister();

        // Hydrodewaxing

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CrudeLubricatingOil.getFluid(850))
                .fluidInputs(Hydrogen.getFluid(315))
                .notConsumable(catalystBed, PlatinumSAPOEleven)
                .fluidOutputs(LubricatingOil.getFluid(850))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        // Silicone oil

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Methyldichlorosilane.getFluid(50))
                .fluidInputs(Chlorobenzene.getFluid(50))
                .fluidOutputs(Methylphenyldichlorosilane.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(50))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Methyldichlorosilane.getFluid(900))
                .fluidInputs(Methylphenyldichlorosilane.getFluid(100))
                .fluidInputs(Water.getFluid(3000))
                .fluidOutputs(SiliconeOilMixture.getFluid(3000))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(SiliconeOilMixture.getFluid(3000))
                .fluidOutputs(SiliconeOil.getFluid(1000))
                .fluidOutputs(HydrochloricAcid.getFluid(2000))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        // Polyalphaolefins

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(BoronTrifluoride.getFluid(750))
                .fluidInputs(NButanol.getFluid(250))
                .fluidOutputs(OlefinPolymerizationInitiator.getFluid(1000))
                .duration(50)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(OneDodecene.getFluid(600))
                .fluidInputs(OlefinPolymerizationInitiator.getFluid(100))
                .fluidOutputs(CrudePolyalphaolefinMixture.getFluid(225))
                .duration(2)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(OneDecene.getFluid(600))
                .fluidInputs(OlefinPolymerizationInitiator.getFluid(100))
                .fluidOutputs(CrudePolyalphaolefinMixture.getFluid(225))
                .duration(2)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(CrudePolyalphaolefinMixture.getFluid(225))
                .fluidInputs(Water.getFluid(100))
                .fluidOutputs(UnsaturatedPolyalphaolefin.getFluid(200))
                .fluidOutputs(BoronTrifluorideMixture.getFluid(125))
                .duration(2)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(BoronTrifluorideMixture.getFluid(1250))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(BoronTrifluoride.getFluid(500))
                .fluidOutputs(NButanolWaste.getFluid(1250))
                .duration(40)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(NButanolWaste.getFluid(1250))
                .fluidOutputs(NButanol.getFluid(250))
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(40)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, PalladiumChloride, 3)
                .fluidInputs(PhosphoricAcid.getFluid(1000))
                .fluidOutputs(PalladiumPrecursorSolution.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        SINTERING_RECIPES.recipeBuilder()
                .input(dust, Alumina, 5)
                .fluidInputs(PalladiumPrecursorSolution.getFluid(1000))
                .output(dust, SupportedPalladium)
                .fluidOutputs(PhosphoricAcid.getFluid(1000))
                .duration(100)
                .EUt(480)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(UnsaturatedPolyalphaolefin.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .notConsumable(catalystBed, SupportedPalladium)
                .fluidOutputs(Polyalphaolefin.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

        // Polybutenes

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(Butene.getFluid(4000))
                .fluidInputs(OlefinPolymerizationInitiator.getFluid(500))
                .fluidOutputs(PolybuteneMixture.getFluid(4125))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(PolybuteneMixture.getFluid(4125))
                .fluidInputs(Water.getFluid(500))
                .fluidOutputs(Polybutene.getFluid(4000))
                .fluidOutputs(BoronTrifluorideMixture.getFluid(625))
                .duration(4)
                .EUt(120)
                .buildAndRegister();

        // Esters

        Material[] alcoholTab = {NOctanol, NDecanol, NDodecanol};

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(Pseudocumene.getFluid(1000))
                .fluidInputs(HotHighPressureAir.getFluid(12000))
                .fluidInputs(AceticAcid.getFluid(1000))
                .notConsumable(dust, AmocoProcessCatalyst)
                .fluidOutputs(TrimelliticAcidSlurry.getFluid(2000))
                .EUt(1920)
                .duration(200)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(TrimelliticAcidSlurry.getFluid(2000))
                .output(dust, TrimelliticAcid, 21)
                .fluidOutputs(DilutedAceticAcid.getFluid(2000))
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, TrimelliticAcid, 21)
                .fluidOutputs(Steam.getFluid(1000))
                .output(dust, TrimelliticAnhydride, 18)
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        for (Material alcohol : alcoholTab) {
            BATCH_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, PhthalicAnhydride, 15)
                    .fluidInputs(alcohol.getFluid(1000))
                    .fluidOutputs(EsterBaseOil.getFluid(1000))
                    .EUt(120)
                    .duration(100)
                    .buildAndRegister();

            BATCH_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, TrimelliticAnhydride, 18)
                    .fluidInputs(alcohol.getFluid(1000))
                    .fluidOutputs(EsterBaseOil.getFluid(1500))
                    .EUt(120)
                    .duration(100)
                    .buildAndRegister();

            BATCH_REACTOR_RECIPES.recipeBuilder()
                    .input(dust, PyromelliticDianhydride, 18)
                    .fluidInputs(alcohol.getFluid(2000))
                    .fluidOutputs(EsterBaseOil.getFluid(3000))
                    .EUt(120)
                    .duration(100)
                    .buildAndRegister();
        }

// Friction Modifiers

    /*Mechanically working FMs: molybdenum disulfide,
    graphite, PTFE, polyamide, fluorinated
    graphite*/

        // Molybdenum disulfide

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(flotated, Molybdenite)
                .output(dust, MolybdenumDisulfide)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .notConsumable(Nitrogen.getFluid(8000))
                .input(dust, MolybdenumTrisulfide)
                .output(dust, MolybdenumDisulfide)
                .output(dust, Sulfur)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // Fluorinated graphite

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Graphite)
                .fluidInputs(Fluorine.getFluid(1000))
                .output(dust, FluorinatedGraphite)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

    /*Adsoprtion layer FMs:
    long-chain carboxylic acids, fatty acid esters,
    ethers, alcohols, amides*/

        // Oleomide

        CSTR_RECIPES.recipeBuilder()
                .notConsumable(spring, Kanthal)
                .fluidInputs(OleicAcid.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(Oleylamide.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .duration(10)
                .EUt(240)
                .buildAndRegister();

        // Monoglycerides

        CSTR_RECIPES.recipeBuilder()
                .notConsumable(spring, Kanthal)
                .fluidInputs(SeedOil.getFluid(50))
                .fluidInputs(Glycerol.getFluid(100))
                .fluidOutputs(Monoglycerides.getFluid(150))
                .duration(10)
                .EUt(240)
                .buildAndRegister();

    /*Tribochemical FMs:
    saturated fatty acids, phosphoric and thiophosphoric
    acid esters, xanthates, sulfurized fatty
    acids*/

        // Stearic acid

        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(3000))
                .fluidInputs(Stearin.getFluid(1000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .fluidOutputs(StearicAcid.getFluid(3000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        // Palmitic acid

        // ADD PALM OIL WHEN READY

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, ChromiumTrioxide, 16)
                .fluidInputs(SulfuricAcid.getFluid(6000))
                .fluidInputs(DistilledWater.getFluid(15000))
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(NHexadecanol.getFluid(3000))
                .fluidOutputs(ChromiumSulfateSolution.getFluid(1000))
                .fluidOutputs(PalmiticAcid.getFluid(3000))
                .duration(200)
                .EUt(200)
                .buildAndRegister();

    /*Friction polymer FMs:
    ethoxylated dicarboxylic acid monoesters, dialkyl phthalates,
    methacrylates, unsaturated fatty acids, sulfurized olefins*/

// Lubricant antioxidants

        // N-phenyl-1-naphthylamine

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Naphthalene.getFluid(1000))
                .fluidInputs(NitrationMixture.getFluid(2000))
                .output(dust, CrudeOneNitronaphthalene)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .input(dust, CrudeOneNitronaphthalene)
                .output(dust, OneNitronaphthalene)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .input(dust, OneNitronaphthalene)
                .notConsumable(catalystBed, Nickel)
                .fluidInputs(Hydrogen.getFluid(6000))
                .output(dust, OneNaphthylamine)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(OneNaphthylamine.getFluid(144))
                .fluidInputs(Aniline.getFluid(1000))
                .output(dust, NPhenylOneNaphthylamine)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Pour point depressants

        // Polyisobutene
        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(Isobutylene.getFluid(4000))
                .fluidInputs(OlefinPolymerizationInitiator.getFluid(500))
                .fluidOutputs(PolyisobuteneMixture.getFluid(4125))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(PolyisobuteneMixture.getFluid(4125))
                .fluidInputs(Water.getFluid(500))
                .output(dust, Polyisobutene)
                .fluidOutputs(BoronTrifluorideMixture.getFluid(625))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // Ethylene propylene copolymer

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(dust, KaminskyCatalyst)
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Propene.getFluid(1000))
                .output(dust, EthylenePropyleneCopolymer, 2)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        // Polyalkyl methacrylate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, MethacrylamideSulfate)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(MethacrylicAcid.getFluid(1000))
                .output(dust, AmmoniumBisulfate, 11)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(MethacrylicAcid.getFluid(50))
                .fluidInputs(NDodecanol.getFluid(50))
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidOutputs(AlkylMethacrylate.getFluid(50))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(AlkylMethacrylate.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidInputs(SodiumStearate.getFluid(100))
                .fluidOutputs(AlkylMethacrylateEmulsion.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(AlkylMethacrylateEmulsion.getFluid(2000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(PolyalkylMethacrylateSolution.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PolyalkylMethacrylateSolution.getFluid(2000))
                .output(dust, Pama)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        // Hydrogenated styrene-butadiene rubber

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RawStyreneIsopreneRubber, 16)
                .fluidInputs(Hydrogen.getFluid(6000))
                .notConsumable(catalystBed, SupportedPalladium)
                .output(dust, HydrogenatedStyreneIsopreneRubber, 16)
                .fluidOutputs(Water.getFluid(3000))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

        // Hydrogenated styrene-isoprene rubber

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RawStyreneButadieneRubber, 16)
                .fluidInputs(Hydrogen.getFluid(6000))
                .notConsumable(catalystBed, SupportedPalladium)
                .output(dust, HydrogenatedStyreneButadieneRubber, 16)
                .fluidOutputs(Water.getFluid(3000))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

// Detergents/dispersants

        // Calcium phenate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(OneDodecene.getFluid(1000))
                .notConsumable(HydrofluoricAcid.getFluid(100))
                .output(dust, Dodecylphenol)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Dodecylphenol)
                .input(dust, Calcite, 5)
                .fluidInputs(SulfurDichloride.getFluid(1000))
                .fluidOutputs(CalciumPhenate.getFluid(1000))
                .fluidOutputs(HydrogenChloride.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        // Calcium dodecylbenzene sulfonate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Benzene.getFluid(1000))
                .fluidInputs(OneDodecene.getFluid(1000))
                .notConsumable(HydrofluoricAcid.getFluid(100))
                .output(dust, Dodecylbenzene)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Dodecylbenzene)
                .fluidInputs(Oleum.getFluid(11000))
                .output(dust, DodecylbenzenesulfonicAcid)
                .fluidOutputs(SulfuricAcid.getFluid(10000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(plate, Polytetrafluoroethylene, 6)
                .input(dust, Dodecylbenzene)
                .fluidInputs(ChlorosulfuricAcid.getFluid(1000))
                .output(dust, DodecylbenzenesulfonicAcid)
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, DodecylbenzenesulfonicAcid, 2)
                .fluidInputs(CalciumHydroxideSolution.getFluid(1000))
                .output(dust, CalciumDodecylbenzeneSulfonate)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // Calcium salicylate

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .input(dust, Calcite)
                .fluidInputs(Phenol.getFluid(2000))
                .fluidInputs(CarbonDioxide.getFluid(2000))
                .fluidInputs(DiethyleneGlycol.getFluid(1000))
                .notConsumable(HighPressureNitrogen.getFluid(6400))
                .fluidOutputs(CalciumSalicylateSolution.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(CalciumSalicylateSolution.getFluid(1000))
                .output(dust, CalciumSalicylate)
                .fluidOutputs(DiethyleneGlycol.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        // Polyisobutene succinic anhydride

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butane.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(7000))
                .notConsumable(dust, VanadiumPentoxide)
                .fluidOutputs(Steam.getFluid(4000))
                .output(dust, MaleicAnhydride, 9)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, MaleicAnhydride, 9)
                .input(dust, Polyisobutene)
                .output(dust, PolyisobuteneSuccinicAnhydride)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

// Demulsifiers

        // Calcium dinonylnaphthalene sulfonate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, DinonylnaphthaleneSulfonicAcid, 2)
                .fluidInputs(CalciumHydroxideSolution.getFluid(1000))
                .output(dust, CalciumDinonylnaphthaleneSulfonate)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // Polyethylene glycol

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneOxide.getFluid(1000))
                .notConsumable(BoronTrifluoride.getFluid(50))
                .fluidOutputs(PolyethyleneGlycol.getFluid(1000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

// Antiwear

        // Tri-(m/p)-cresylphosphate

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Cresol.getFluid(1000))
                .fluidOutputs(MetaParaCresolMixture.getFluid(700)) // needs to be slightly higher than SATP
                .fluidOutputs(OrthoCresol.getFluid(300))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(MetaParaCresolMixture.getFluid(150))
                .fluidInputs(PhosphorylChloride.getFluid(50))
                .fluidOutputs(AcidicTricresylPhosphate.getFluid(200))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 9)
                .fluidInputs(AcidicTricresylPhosphate.getFluid(4000))
                .fluidOutputs(TricresylPhosphate.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(3000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // Zinc/Molybdenum dialkyldithiophosphate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhosphorusPentasulfide, 7)
                .fluidInputs(IsopropylAlcohol.getFluid(4000))
                .fluidOutputs(DiisopropyldithiophosphoricAcid.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhosphorusPentasulfide, 7)
                .fluidInputs(NButanol.getFluid(4000))
                .fluidOutputs(DibutyldithiophosphoricAcid.getFluid(2000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZincOxide, 2)
                .fluidInputs(DiisopropyldithiophosphoricAcid.getFluid(2000))
                .fluidOutputs(ZincDialkyldithiophospate.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZincOxide, 2)
                .fluidInputs(DibutyldithiophosphoricAcid.getFluid(2000))
                .fluidOutputs(ZincDialkyldithiophospate.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AmmoniumDimolybdate, 19)
                .fluidInputs(DiisopropyldithiophosphoricAcid.getFluid(4000))
                .output(dust, MolybdenumDialkyldithiophosphate)
                .fluidOutputs(DilutedAmmoniaSolution.getFluid(4000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AmmoniumDimolybdate, 19)
                .fluidInputs(DibutyldithiophosphoricAcid.getFluid(4000))
                .output(dust, MolybdenumDialkyldithiophosphate)
                .fluidOutputs(DilutedAmmoniaSolution.getFluid(4000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // Zinc-bis(diethyldithiocarbamate)

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Alumina)
                .fluidInputs(NPentanol.getFluid(100))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(Diamylamine.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidInputs(Diamylamine.getFluid(1000))
                .fluidOutputs(SodiumDiamylthiocarbamateSolution.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZincChloride, 3)
                .fluidInputs(SodiumDiamylthiocarbamateSolution.getFluid(2000))
                .output(dust, ZincBisdiamyldithiocarbamate)
                .fluidOutputs(SaltWater.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Antirust

        // Calcium didodecylbenzene sulfonate

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Benzene.getFluid(1000))
                .fluidInputs(OneDodecene.getFluid(2000))
                .notConsumable(HydrofluoricAcid.getFluid(100))
                .output(dust, Didodecylbenzene)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(dust, Dodecylbenzene)
                .fluidInputs(OneDodecene.getFluid(1000))
                .notConsumable(HydrofluoricAcid.getFluid(100))
                .output(dust, Didodecylbenzene)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Didodecylbenzene)
                .fluidInputs(Oleum.getFluid(11000))
                .output(dust, DidodecylbenzenesulfonicAcid)
                .fluidOutputs(SulfuricAcid.getFluid(10000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(plate, Polytetrafluoroethylene, 6)
                .input(dust, Didodecylbenzene)
                .fluidInputs(ChlorosulfuricAcid.getFluid(1000))
                .output(dust, DidodecylbenzenesulfonicAcid)
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, DidodecylbenzenesulfonicAcid, 2)
                .fluidInputs(CalciumHydroxideSolution.getFluid(1000))
                .output(dust, CalciumDidodecylbenzeneSulfonate)
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        // 4-nonylphenoxyacetic acid

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(Tripropylene.getFluid(1000))
                .notConsumable(HydrofluoricAcid.getFluid(100))
                .fluidOutputs(Nonylphenol.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .notConsumable(spring, Kanthal)
                .fluidInputs(Dichloroethane.getFluid(50))
                .fluidInputs(Chlorine.getFluid(200))
                .fluidOutputs(Trichloroethylene.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(150))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Trichloroethylene.getFluid(50))
                .fluidInputs(DilutedSulfuricAcid.getFluid(200))
                .fluidOutputs(ChloroaceticAcidSolution.getFluid(150))
                .fluidOutputs(HydrogenChloride.getFluid(100))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ChloroaceticAcidSolution.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(2000))
                .fluidOutputs(ChloroaceticAcid.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Nonylphenol.getFluid(1000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidInputs(ChloroaceticAcid.getFluid(1000))
                .output(dust, FourNonylphenoxyaceticAcid)
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

// Corrosion inhibitors

        // Benzotriazole

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TwoChloronitrobenzene)
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(2000))
                .output(dust, AmmoniumChloride, 6)
                .fluidOutputs(TwoNitroanilineSolution.getFluid(1000))
                .duration(600)
                .EUt(120)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Palladium)
                .fluidInputs(TwoNitroanilineSolution.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(300))
                .fluidOutputs(OrthoPhenylenediamineSlurry.getFluid(150))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(OrthoPhenylenediamineSlurry.getFluid(3000))
                .fluidOutputs(Toluene.getFluid(1000))
                .fluidOutputs(Water.getFluid(2000))
                .output(dust, OrthoPhenylenediamine, 16)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, OrthoPhenylenediamine, 16)
                .input(dust, SodiumNitrite, 4)
                .fluidInputs(HydrogenChloride.getFluid(1000))
                .output(dust, Benzotriazole)
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        // Mercaptobenzothiazole

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Sulfur)
                .fluidInputs(Aniline.getFluid(1000))
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .output(dust, Mercaptobenzothiazole)
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Chelates: SALEN

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumCyanoborohydride, 14)
                .fluidInputs(Ethylenediamine.getFluid(1000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Salicylaldehyde.getFluid(2000))
                .output(dust, SalicylideneEthylenediamine)
                .fluidOutputs(Wastewater.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Final blending

        Map<Material, Double> baseOilMap = new HashMap<>();
        baseOilMap.put(SeedOil, 0.5);
        baseOilMap.put(LubricatingOil, 1.0);
        baseOilMap.put(Polybutene, 1.5);
        baseOilMap.put(Polyalphaolefin, 2.5);
        baseOilMap.put(EsterBaseOil, 2.5);

        Map<Material, Double> solidFrictionModifierMap = new HashMap<>();
        solidFrictionModifierMap.put(Talc, 0.5);
        solidFrictionModifierMap.put(Soapstone, 0.5);
        solidFrictionModifierMap.put(Graphite, 1.0);
        solidFrictionModifierMap.put(FluorinatedGraphite, 2.0);
        solidFrictionModifierMap.put(Polycaprolactam, 3.0);
        solidFrictionModifierMap.put(Polytetrafluoroethylene, 4.0);
        solidFrictionModifierMap.put(MolybdenumDisulfide, 4.0);

        Map<Material, Double> liquidFrictionModifierMap = new HashMap<>();
        liquidFrictionModifierMap.put(OleicAcid, 1.0);
        liquidFrictionModifierMap.put(StearicAcid, 1.0);
        liquidFrictionModifierMap.put(LinoleicAcid, 1.0);
        liquidFrictionModifierMap.put(PalmiticAcid, 1.0);
        liquidFrictionModifierMap.put(Oleylamide, 1.0);
        liquidFrictionModifierMap.put(Monoglycerides, 1.0);

        Map<Material, Double> solidAntiwearMap = new HashMap<>();
        solidAntiwearMap.put(MolybdenumDialkyldithiophosphate, 4.0);
        solidAntiwearMap.put(ZincBisdiamyldithiocarbamate, 2.0);

        Map<Material, Double> liquidAntiwearMap = new HashMap<>();
        liquidAntiwearMap.put(TricresylPhosphate, 1.0);
        liquidAntiwearMap.put(ZincDialkyldithiophospate, 1.5);

        Map<Material, Double> pourPointDepressantMap = new HashMap<>();
        pourPointDepressantMap.put(EthylenePropyleneCopolymer, 1.0);
        pourPointDepressantMap.put(HydrogenatedStyreneIsopreneRubber, 2.0);
        pourPointDepressantMap.put(HydrogenatedStyreneButadieneRubber, 2.0);
        pourPointDepressantMap.put(Polyisobutene, 2.0);
        pourPointDepressantMap.put(Pama, 4.0);

// calcium_phenate: 3

        Map<Material, Double> detergentMap = new HashMap<>();
        detergentMap.put(CalciumDodecylbenzeneSulfonate, 1.0);
        detergentMap.put(CalciumSalicylate, 2.0);
        detergentMap.put(PolyisobuteneSuccinicAnhydride, 4.0);

        Material[] chelates = {SalicylideneEthylenediamine, SalicylideneOneTwoPropanediamine};
        Material[] corrosionInhibitors = {Benzotriazole, Mercaptobenzothiazole};

// dustNPhenylOneNaphthylamine: 2

        Map<Material, Double> antioxidantMap = new HashMap<>();
        antioxidantMap.put(ButylatedHydroxytoluene, 1.5);
        antioxidantMap.put(DimethylTertButylphenol, 1.0);
        antioxidantMap.put(DiTertButylphenol, 1.0);


// Base
        baseOilMap.forEach((Material oil, Double multiplier1) -> {
            solidFrictionModifierMap.forEach((Material sfm, Double multiplier2) -> {
                MIXER_RECIPES.recipeBuilder()
                        .input(dust, sfm)
                        .fluidInputs(Oil.getFluid((int) (1000 * multiplier2 * 4)))
                        .fluidOutputs(Lubricant.getFluid((int) (1000 * multiplier1 * multiplier2 * 4)))
                        .duration(200)
                        .EUt(7)
                        .buildAndRegister();
            });

            liquidFrictionModifierMap.forEach((Material lfm, Double multiplier3) -> {
                MIXER_RECIPES.recipeBuilder()
                        .fluidInputs(Oil.getFluid((int) (1000 * multiplier3)))
                        .fluidInputs(lfm.getFluid(250))
                        .fluidOutputs(Lubricant.getFluid((int) (1000 * multiplier1 * multiplier3)))
                        .duration(200)
                        .EUt(7)
                        .buildAndRegister();
            });
        });

// Midgrade
        solidAntiwearMap.forEach((Material saw, Double multiplier) -> {
            BLENDER_RECIPES.recipeBuilder()
                    .input(dust, saw)
                    .fluidInputs(Lubricant.getFluid((int) (1000 * multiplier * 4)))
                    .fluidInputs(PolyethyleneGlycol.getFluid(1000))
                    .fluidInputs(AntifoamingAdditive.getFluid(1000))
                    .fluidOutputs(MidgradeLubricant.getFluid((int) (1000 * multiplier * 4)))
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister();

            BLENDER_RECIPES.recipeBuilder()
                    .input(dust, saw)
                    .input(dust, CalciumDinonylnaphthaleneSulfonate)
                    .fluidInputs(Lubricant.getFluid((int) (1000 * multiplier * 4)))
                    .fluidInputs(AntifoamingAdditive.getFluid(1000))
                    .fluidOutputs(MidgradeLubricant.getFluid((int) (1000 * multiplier * 4)))
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister();
        });

        liquidAntiwearMap.forEach((Material law, Double multiplier) -> {
            BLENDER_RECIPES.recipeBuilder()
                    .fluidInputs(Lubricant.getFluid((int) (1000 * multiplier)))
                    .fluidInputs(PolyethyleneGlycol.getFluid(250))
                    .fluidInputs(AntifoamingAdditive.getFluid(250))
                    .fluidInputs(law.getFluid(250))
                    .fluidOutputs(MidgradeLubricant.getFluid((int) (1000 * multiplier)))
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister();

            BLENDER_RECIPES.recipeBuilder()
                    .input(dust, CalciumDinonylnaphthaleneSulfonate)
                    .fluidInputs(Lubricant.getFluid((int) (1000 * multiplier)))
                    .fluidInputs(AntifoamingAdditive.getFluid(1000))
                    .fluidInputs(law.getFluid(1000))
                    .fluidOutputs(MidgradeLubricant.getFluid((int) (1000 * multiplier)))
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister();
        });

// Premium
        pourPointDepressantMap.forEach((Material ppd, Double multiplier1) -> {
            BLENDER_RECIPES.recipeBuilder()
                .input(dust, ppd)
                .fluidInputs(CalciumPhenate.getFluid(1000))
                .input(dust, CalciumDidodecylbenzeneSulfonate)
                .fluidInputs(MidgradeLubricant.getFluid((int) (1000 * multiplier1 * 3 * 4)))
                .fluidOutputs(PremiumLubricant.getFluid((int) (1000 * multiplier1 * 3 * 4)))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

            BLENDER_RECIPES.recipeBuilder()
                    .input(dust, ppd)
                    .fluidInputs(CalciumPhenate.getFluid(1000))
                    .input(dust, FourNonylphenoxyaceticAcid)
                    .fluidInputs(MidgradeLubricant.getFluid((int) (1000 * multiplier1 * 3 * 4 * 1.5)))
                    .fluidOutputs(PremiumLubricant.getFluid((int) (1000 * multiplier1 * 3 * 4 * 1.5)))
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister();

            detergentMap.forEach((Material det, Double multiplier2) -> {
                BLENDER_RECIPES.recipeBuilder()
                        .input(dust, det)
                        .input(dust, ppd)
                        .input(dust, CalciumDidodecylbenzeneSulfonate)
                        .fluidInputs(MidgradeLubricant.getFluid((int) (1000 * multiplier1 * multiplier2 * 4)))
                        .fluidOutputs(PremiumLubricant.getFluid((int) (1000 * multiplier1 * multiplier2 * 4)))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                BLENDER_RECIPES.recipeBuilder()
                        .input(dust, det)
                        .input(dust, ppd)
                        .input(dust, FourNonylphenoxyaceticAcid)
                        .fluidInputs(MidgradeLubricant.getFluid((int) (1000 * multiplier1 * multiplier2 * 4)))
                        .fluidOutputs(PremiumLubricant.getFluid((int) (1000 * multiplier1 * multiplier2 * 4)))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();
            });
        });


// Supreme

        for (Material chelate : chelates) {
            for (Material ci : corrosionInhibitors) {
                BLENDER_RECIPES.recipeBuilder()
                        .input(dust, chelate)
                        .input(dust, ci)
                        .input(dust, NPhenylOneNaphthylamine)
                        .fluidInputs(PremiumLubricant.getFluid(4000))
                        .fluidOutputs(SupremeLubricant.getFluid(4000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                antioxidantMap.forEach((Material ant, Double multiplier) -> {
                    BLENDER_RECIPES.recipeBuilder()
                            .input(dust, chelate)
                            .input(dust, ci)
                            .fluidInputs(ant.getFluid(1000))
                            .fluidInputs(PremiumLubricant.getFluid((int) (1000 * multiplier * 4)))
                            .fluidOutputs(SupremeLubricant.getFluid((int) (1000 * multiplier * 4)))
                            .duration(200)
                            .EUt(120)
                            .buildAndRegister();
                });
            }
        }
    }
}
