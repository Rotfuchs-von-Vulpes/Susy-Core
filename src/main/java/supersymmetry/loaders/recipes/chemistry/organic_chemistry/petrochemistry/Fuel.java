package supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry;

import gregtech.api.unification.material.Material;
import groovy.util.MapEntry;
import net.minecraft.util.Tuple;

import java.util.*;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Fuel {
    private static class InertGas {
        Material name;
        int amount_required;
        int duration;
        InertGas(Material name, int amount_required, int duration) {
            this.name = name;
            this.amount_required = amount_required;
            this.duration = duration;
        }
    }
    private static InertGas[] inertGases = {
            new InertGas(Nitrogen, 8000, 4),
            new InertGas(Helium, 4000, 2),
            new InertGas(Argon, 1000, 1)
    };
    private static List<Tuple<Map.Entry<Material, Integer>, Map.Entry<Material, Integer>>> getUniquePairs(Map<Material, Integer> materialsMap) {
        List<Tuple<Map.Entry<Material, Integer>, Map.Entry<Material, Integer>>> pairs = new ArrayList<>();

        // Convert map entries to a list for easier iteration
        List<Map.Entry<Material, Integer>> materialList = new ArrayList<>(materialsMap.entrySet());

        for (int i = 0; i < materialList.size() - 1; i++) {
            Map.Entry<Material, Integer> material1 = materialList.get(i);
            for (int j = i + 1; j < materialList.size(); j++) {
                Map.Entry<Material, Integer> material2 = materialList.get(j);

                pairs.add(new Tuple<>(material1, material2));
            }
        }

        return pairs;
    }
    public static void init() {

        Material[] majorSolvents = {Xylene, Naphtha, Toluene};
        Material[] minorSolvents = {Naphthalene, IsopropylAlcohol, Ethylbenzene};

// Oxygenates

// Methyl-tert-butyl ether

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Butane.getFluid(50))
                .notConsumable(dust, AluminiumChloride)
                .fluidOutputs(Isobutane.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutane.getFluid(50))
                .notConsumable(dust, ChromiumTrioxide)
                .fluidOutputs(Isobutylene.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Methanol.getFluid(50))
                .fluidInputs(Isobutylene.getFluid(50))
                .fluidOutputs(MethylTertButylEther.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

// Antioxidant active ingredients

        // 2,6-Di-tert-butylphenol

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutylene.getFluid(50))
                .fluidInputs(Water.getFluid(50))
                .notConsumable(SulfuricAcid.getFluid(50))
                .fluidOutputs(TertButylAlcohol.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        // 2,4,6-tri-tert-butylphenol (BHT)

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutylene.getFluid(100))
                .fluidInputs(Cresol.getFluid(50))
                .notConsumable(SulfuricAcid.getFluid(50))
                .fluidOutputs(ButylatedHydroxytoluene.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        // 2,4-Dimethyl-6-tert-butylphenol

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutylene.getFluid(50))
                .fluidInputs(Xylenol.getFluid(50))
                .notConsumable(SulfuricAcid.getFluid(50))
                .fluidOutputs(DimethylTertButylphenol.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        // 2,6-Di-tert-butylphenol

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input("dustAnyPurityAluminium")
                .fluidInputs(Phenol.getFluid(3000))
                .output(dust, AluminiumPhenolate)
                .fluidOutputs(Hydrogen.getFluid(3000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .notConsumable(dust, AluminiumPhenolate)
                .fluidInputs(Isobutylene.getFluid(100))
                .fluidInputs(Phenol.getFluid(50))
                .fluidOutputs(DiTertButylphenol.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        // N-substituted p-Phenylenediamine

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ParaPhenylenediamine, 16)
                .input(dust, SodiumCyanoborohydride, 14)
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Acetone.getFluid(2000))
                .fluidOutputs(DiisopropylParaPhenylenediamineSolution.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DiisopropylParaPhenylenediamineSolution.getFluid(1000))
                .output(dust, DiisopropylParaPhenylenediamine, 36)
                .fluidOutputs(Wastewater.getFluid(2000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

// Fuel system icing inhibitor & diglyme

        CSTR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidInputs(DiethyleneGlycol.getFluid(50))
                .fluidInputs(Methanol.getFluid(100))
                .fluidOutputs(Diglyme.getFluid(50))
                .fluidOutputs(VeryDilutedSulfuricAcid.getFluid(150))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidInputs(DiethyleneGlycol.getFluid(50))
                .fluidInputs(Methanol.getFluid(50))
                .fluidOutputs(MethylCarbitol.getFluid(50))
                .fluidOutputs(DilutedSulfuricAcid.getFluid(100))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

// Antiknock active ingredients

        // IsoOctane

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Isobutylene.getFluid(50))
                .fluidInputs(Isobutane.getFluid(50))
                .notConsumable(SulfuricAcid.getFluid(50))
                .fluidOutputs(IsoOctane.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        // Ferrocene

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(IronPentacarbonyl.getFluid(1000))
                .fluidInputs(Cyclopentadiene.getFluid(2000))
                .output(dust, Ferrocene, 11)
                .fluidOutputs(CarbonMonoxide.getFluid(5000))
                .fluidOutputs(Hydrogen.getFluid(2000))
                .duration(300)
                .EUt(120)
                .buildAndRegister();

        // Methylcyclopentadienylmanganese tricarbonyl

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumCyclopentadienideSolution.getFluid(50))
                .fluidInputs(Chloromethane.getFluid(50))
                .fluidOutputs(MethylcyclopentadieneSolution.getFluid(100))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(MethylcyclopentadieneSolution.getFluid(2000))
                .output(dust, Salt, 2)
                .fluidOutputs(Methylcyclopentadiene.getFluid(1000))
                .fluidOutputs(Tetrahydrofuran.getFluid(1000))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ManganeseIIChloride, 3)
                .fluidInputs(Sodium.getFluid(288))
                .fluidInputs(Methylcyclopentadiene.getFluid(2000))
                .fluidInputs(Diglyme.getFluid(1000))
                .fluidOutputs(BismethylcyclopentadienylmanganeseSolution.getFluid(2000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(BismethylcyclopentadienylmanganeseSolution.getFluid(1000))
                .output(dust, Salt, 4)
                .fluidOutputs(Diglyme.getFluid(1000))
                .fluidOutputs(Bismethylcyclopentadienylmanganese.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(spring, Cupronickel)
                .fluidInputs(HotHighPressureCarbonMonoxide.getFluid(3000))
                .fluidInputs(Bismethylcyclopentadienylmanganese.getFluid(1000))
                .fluidOutputs(MethylcyclopentadienylmanganeseTricarbonyl.getFluid(1000))
                .fluidOutputs(Methylcyclopentadiene.getFluid(1000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        // Tetraethyl Lead

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input("dustAnyPuritySodium")
                .input("dustAnyPurityLead")
                .output(ingot, SodiumLeadAlloy, 2)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input("dustAnyPuritySodium")
                .input(ingot, Lead)
                .output(ingot, SodiumLeadAlloy, 2)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenChloride.getFluid(50))
                .fluidInputs(Ethylene.getFluid(50))
                .fluidOutputs(Chloroethane.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Chloroethane.getFluid(4000))
                .input(dust, SodiumLeadAlloy, 8)
                .fluidOutputs(TetraethylleadSludge.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(TetraethylleadSludge.getFluid(2000))
                .output(dust, Salt, 8)
                .fluidOutputs(Lead.getFluid(432))
                .fluidOutputs(Tetraethyllead.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Cetane improver (2-ethylhexyl nitrate)

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(TwoEthylhexanol.getFluid(50))
                .fluidInputs(NitrationMixture.getFluid(100))
                .fluidOutputs(DilutedTwoEthylhexylNitrate.getFluid(150))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedTwoEthylhexylNitrate.getFluid(3000))
                .fluidOutputs(TwoEthylhexylNitrate.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Metal deactivator (N,N’-Disalicylidene-1,2-propanediamine, SALPN)

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(PropyleneOxide.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(PropanolamineMix.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Alumina)
                .fluidInputs(PropanolamineMix.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(OneTwoDiaminopropaneSolution.getFluid(100))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxide, 9)
                .fluidInputs(Phenol.getFluid(1000))
                .fluidInputs(Chloroform.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Salicylaldehyde.getFluid(1000))
                .fluidOutputs(PotassiumChlorideSolution.getFluid(3000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumCyanoborohydride, 14)
                .fluidInputs(OneTwoDiaminopropaneSolution.getFluid(2000))
                .fluidInputs(HydrochloricAcid.getFluid(2000))
                .fluidInputs(Salicylaldehyde.getFluid(2000))
                .output(dust, SalicylideneOneTwoPropanediamine)
                .fluidOutputs(Wastewater.getFluid(3000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Cold flow improvers

        // EVA-isobutylene terpolymer for cold flow additives

        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidInputs(Isobutylene.getFluid(1000))
                .fluidInputs(VinylAcetateSuspension.getFluid(1000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(EthyleneIsobutyleneVinylAcetateSuspension.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        PHASE_SEPARATOR.recipeBuilder()
                .fluidInputs(EthyleneIsobutyleneVinylAcetateSuspension.getFluid(2000))
                .output(dust, EthyleneIsobutyleneVinylAcetate, 3)
                .fluidOutputs(Methanol.getFluid(1000))
                .duration(50)
                .buildAndRegister();

        // Wax antisetlling agent (N,N-dihexadecyl phthalic acid amide)

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Alumina)
                .fluidInputs(NHexadecanol.getFluid(100))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(Dihexadecylamine.getFluid(50))
                .fluidOutputs(Water.getFluid(100))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhthalicAnhydride, 13)
                .fluidInputs(Dihexadecylamine.getFluid(2000))
                .notConsumable(SulfuricAcid.getFluid(50))
                .output(dust, DihexadecylaminePhthalateAmide)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Corrosion inhibitors
        for (InertGas inertGas : inertGases) {
            REACTION_FURNACE_RECIPES.recipeBuilder()
                    .notConsumable(dust, AluminiumSilicate)
                    .notConsumable(inertGas.name.getFluid(inertGas.amount_required))
                    .fluidInputs(LinoleicAcid.getFluid(2000))
                    .fluidOutputs(CorrosionInhibitor.getFluid(2000))
                    .duration(200 * inertGas.duration)
                    .EUt(120)
                    .buildAndRegister();

            REACTION_FURNACE_RECIPES.recipeBuilder()
                    .notConsumable(dust, AluminiumSilicate)
                    .notConsumable(inertGas.name.getFluid(inertGas.amount_required))
                    .fluidInputs(OleicAcid.getFluid(2000))
                    .fluidOutputs(CorrosionInhibitor.getFluid(2000))
                    .duration(200 * inertGas.duration)
                    .EUt(120)
                    .buildAndRegister();
        }

        Map<Material, Integer> oxygenateMap = new HashMap<>();
        oxygenateMap.put(Methanol, 1000);
        oxygenateMap.put(Ethanol, 1000);
        oxygenateMap.put(NPropanol, 750);
        oxygenateMap.put(IsopropylAlcohol, 750);
        oxygenateMap.put(NButanol, 500);
        oxygenateMap.put(IsopropylAlcohol, 500);
        oxygenateMap.put(TertButylAlcohol, 250);
        oxygenateMap.put(MethylTertButylEther, 125);

        Map<Material, Integer> antioxidantMap = new HashMap<>();
        antioxidantMap.put(ButylatedHydroxytoluene, 200);
        antioxidantMap.put(DimethylTertButylphenol, 200);
        antioxidantMap.put(DiTertButylphenol, 200);

        Map<Material, Integer> antiknockMap = new HashMap<>();
        antiknockMap.put(IsoOctane, 250);
        antiknockMap.put(Tetraethyllead, 100);
        antiknockMap.put(MethylcyclopentadienylmanganeseTricarbonyl, 50);

// Returns an array of unique material pairs

// Cetane-Boosted Diesel * 750
        removeRecipesByInputs(MIXER_RECIPES, BioDiesel.getFluid(1000), Tetranitromethane.getFluid(40));
        removeRecipesByInputs(BLENDER_RECIPES, BioDiesel.getFluid(1000), Tetranitromethane.getFluid(40));
// Cetane-Boosted Diesel * 1000
        removeRecipesByInputs(MIXER_RECIPES, Diesel.getFluid(1000), Tetranitromethane.getFluid(40));
        removeRecipesByInputs(BLENDER_RECIPES, Diesel.getFluid(1000), Tetranitromethane.getFluid(40));
        for (Material majorSolvent : majorSolvents) {
            for (Material minorSolvent : minorSolvents) {
                BLENDER_RECIPES.recipeBuilder()
                        .input(dustSmall, SodiumDodecylSulfate)
                        .fluidInputs(TwoButoxyethanol.getFluid(250))
                        .fluidInputs(majorSolvent.getFluid(1500))
                        .fluidInputs(minorSolvent.getFluid(250))
                        .fluidOutputs(LubricityAdditive.getFluid(2000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                BLENDER_RECIPES.recipeBuilder()
                        .input(dustSmall, DinonylnaphthaleneSulfonicAcid)
                        .fluidInputs(majorSolvent.getFluid(1500))
                        .fluidInputs(minorSolvent.getFluid(500))
                        .fluidOutputs(AntistaticAdditive.getFluid(2000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                BLENDER_RECIPES.recipeBuilder()
                        .input(dustSmall, SalicylideneOneTwoPropanediamine)
                        .fluidInputs(majorSolvent.getFluid(1500))
                        .fluidInputs(minorSolvent.getFluid(500))
                        .fluidOutputs(MetalDeactivator.getFluid(2000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                BLENDER_RECIPES.recipeBuilder()
                        .fluidInputs(TwoEthylhexylNitrate.getFluid(250))
                        .fluidInputs(majorSolvent.getFluid(1500))
                        .fluidInputs(minorSolvent.getFluid(250))
                        .fluidOutputs(IgnitionImprover.getFluid(2000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                BLENDER_RECIPES.recipeBuilder()
                        .circuitMeta(1)
                        .input(dustSmall, EthyleneIsobutyleneVinylAcetate)
                        .fluidInputs(majorSolvent.getFluid(1500))
                        .fluidInputs(minorSolvent.getFluid(500))
                        .fluidOutputs(ColdFlowImprover.getFluid(2000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                BLENDER_RECIPES.recipeBuilder()
                        .fluidInputs(Polydimethylsiloxane.getFluid(250))
                        .fluidInputs(majorSolvent.getFluid(1500))
                        .fluidInputs(minorSolvent.getFluid(250))
                        .fluidOutputs(AntifoamingAdditive.getFluid(2000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                BLENDER_RECIPES.recipeBuilder()
                        .input(dustSmall, EthyleneIsobutyleneVinylAcetate)
                        .input(dustSmall, DihexadecylaminePhthalateAmide)
                        .fluidInputs(majorSolvent.getFluid(6000))
                        .fluidInputs(minorSolvent.getFluid(2000))
                        .fluidOutputs(ColdFlowImprover.getFluid(8000))
                        .duration(200)
                        .EUt(120)
                        .buildAndRegister();

                antiknockMap.forEach((Material mat, Integer num) -> {
                    BLENDER_RECIPES.recipeBuilder()
                            .fluidInputs(mat.getFluid(num))
                            .fluidInputs(majorSolvent.getFluid(1500))
                            .fluidInputs(minorSolvent.getFluid(500 - num))
                            .fluidOutputs(Antiknock.getFluid(1000))
                            .duration(200)
                            .EUt(120)
                            .buildAndRegister();
                });

                List<Tuple<Map.Entry<Material, Integer>, Map.Entry<Material, Integer>>> antioxidantPairs = getUniquePairs(antioxidantMap);

                for (Tuple<Map.Entry<Material, Integer>, Map.Entry<Material, Integer>> pair : antioxidantPairs) {
                    BLENDER_RECIPES.recipeBuilder()
                            .fluidInputs(pair.getFirst().getKey().getFluid(pair.getFirst().getValue()))
                            .fluidInputs(pair.getSecond().getKey().getFluid(pair.getSecond().getValue()))
                            .fluidInputs(majorSolvent.getFluid(1400))
                            .fluidInputs(minorSolvent.getFluid(200))
                            .fluidOutputs(Antioxidants.getFluid(2000))
                            .duration(200)
                            .EUt(120)
                            .buildAndRegister();
                }

                antioxidantMap.forEach((Material antioxidant, Integer num) -> {
                    BLENDER_RECIPES.recipeBuilder()
                            .input(dust, DiisopropylParaPhenylenediamine, 4)
                            .fluidInputs(antioxidant.getFluid(200))
                            .fluidInputs(majorSolvent.getFluid(3400))
                            .fluidInputs(minorSolvent.getFluid(400))
                            .fluidOutputs(Antioxidants.getFluid(4000))
                            .duration(200)
                            .EUt(120)
                            .buildAndRegister();
                });
            }
        }

        List<Tuple<Map.Entry<Material, Integer>, Map.Entry<Material, Integer>>> oxygenatePairs = getUniquePairs(oxygenateMap);

        for (Tuple<Map.Entry<Material, Integer>, Map.Entry<Material, Integer>> pair : oxygenatePairs) {
            BLENDER_RECIPES.recipeBuilder()
                    .fluidInputs(pair.getFirst().getKey().getFluid(pair.getFirst().getValue()))
                    .fluidInputs(pair.getSecond().getKey().getFluid(pair.getSecond().getValue()))
                    .fluidOutputs(Oxygenates.getFluid(2000))
                    .duration(200)
                    .EUt(120)
                    .buildAndRegister();
        }

// Gasoline final blending

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(Gasoline.getFluid(1000))
                .fluidInputs(Oxygenates.getFluid(100))
                .fluidInputs(Antiknock.getFluid(100))
                .fluidOutputs(MidgradeGasoline.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(MidgradeGasoline.getFluid(1000))
                .fluidInputs(MethylCarbitol.getFluid(100))
                .fluidInputs(CorrosionInhibitor.getFluid(100))
                .fluidOutputs(PremiumGasoline.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(PremiumGasoline.getFluid(1000))
                .fluidInputs(Antioxidants.getFluid(100))
                .fluidInputs(MetalDeactivator.getFluid(100))
                .fluidOutputs(SupremeGasoline.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

// Diesel final blending

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(Diesel.getFluid(1000))
                .fluidInputs(IgnitionImprover.getFluid(100))
                .fluidInputs(ColdFlowImprover.getFluid(100))
                .fluidOutputs(MidgradeDiesel.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(MidgradeDiesel.getFluid(1000))
                .fluidInputs(AntistaticAdditive.getFluid(100))
                .fluidInputs(LubricityAdditive.getFluid(100))
                .fluidOutputs(PremiumDiesel.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(PremiumDiesel.getFluid(1000))
                .fluidInputs(Antioxidants.getFluid(100))
                .fluidInputs(AntifoamingAdditive.getFluid(100))
                .fluidOutputs(SupremeDiesel.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

// Kerosene final blending

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(Kerosene.getFluid(1000))
                .fluidInputs(MethylCarbitol.getFluid(100))
                .fluidInputs(AntistaticAdditive.getFluid(100))
                .fluidOutputs(MidgradeKerosene.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(MidgradeKerosene.getFluid(1000))
                .fluidInputs(LubricityAdditive.getFluid(100))
                .fluidInputs(Antioxidants.getFluid(100))
                .fluidOutputs(PremiumKerosene.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();

        BLENDER_RECIPES.recipeBuilder()
                .fluidInputs(PremiumKerosene.getFluid(1000))
                .fluidInputs(CorrosionInhibitor.getFluid(100))
                .fluidInputs(MetalDeactivator.getFluid(100))
                .fluidOutputs(SupremeKerosene.getFluid(1000))
                .duration(10)
                .EUt(120)
                .buildAndRegister();
    }
}
