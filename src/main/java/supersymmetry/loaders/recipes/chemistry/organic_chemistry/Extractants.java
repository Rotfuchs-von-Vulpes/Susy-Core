package supersymmetry.loaders.recipes.chemistry.organic_chemistry;

import gregtech.api.unification.material.MarkerMaterials;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtechfoodoption.GTFOMaterialHandler.Aniline;
import static gregtechfoodoption.GTFOMaterialHandler.HydrogenCyanide;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBedReduction;
import static supersymmetry.common.item.CatalystItems.REDUCTION_CATALYST_BED;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Extractants {
    public static void init() {
//LIXIVANTS
//SODIUM CYANIDE
        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(50))
                .fluidInputs(HydrogenCyanide.getFluid(50))
                .fluidOutputs(SodiumCyanideSolution.getFluid(100))
                .duration(10)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumCyanideSolution.getFluid(2000))
                .output(dust, SodiumCyanide, 3)
                .fluidOutputs(Water.getFluid(2000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

//Frank-Caro process
        BLAST_RECIPES.recipeBuilder()
                .input(dust, CalciumCarbide, 3)
                .fluidInputs(Nitrogen.getFluid(2000))
                .output(dust, CalciumCyanamide, 4)
                .output(dust, Carbon)
                .blastFurnaceTemp(1200)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumCyanamide, 4)
                .input(dust, Carbon)
                .fluidInputs(Salt.getFluid(576))
                .output(dust, SodiumCyanide, 6)
                .output(dust, CalciumChloride, 3)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumCyanamide, 4)
                .fluidInputs(Water.getFluid(3000))
                .output(dust, Calcite, 5)
                .fluidOutputs(Ammonia.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//SODIUM THIOSULFATE
        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(SodaAshSolution.getFluid(50))
                .fluidInputs(SulfurDioxide.getFluid(50))
                .fluidOutputs(SodiumSulfiteSolution.getFluid(50))
                .fluidOutputs(CarbonDioxide.getFluid(50))
                .duration(6)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Sulfur)
                .fluidInputs(SodiumSulfiteSolution.getFluid(1000))
                .fluidOutputs(SodiumThiosulfateSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumThiosulfateSolution.getFluid(1000))
                .output(dust, SodiumThiosulfate, 7)
                .fluidOutputs(Water.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

//FLOTATION AGENTS
//FATTY ACIDS
        AUTOCLAVE_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(3000))
                .fluidInputs(SeedOil.getFluid(1000))
                .fluidOutputs(Glycerol.getFluid(1000))
                .fluidOutputs(FattyAcidSolution.getFluid(3000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(FattyAcidSolution.getFluid(1000))
                .fluidInputs(Methanol.getFluid(1000))
                .input(dust, Urea)
                .fluidOutputs(OleicAcidSolution.getFluid(1000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(OleicAcidSolution.getFluid(1000))
                .output(dust, OleicAcid, 18)
                .fluidOutputs(Methanol.getFluid(1000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .input(dust, OleicAcid, 18)
                .fluidOutputs(AlkalineSodiumOleateSolution.getFluid(1000))
                .EUt(30)
                .duration(80)
                .buildAndRegister();

//XANTHATES
//SODIUM ETHYL XANTHATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Sodium)
                .fluidInputs(Ethanol.getFluid(2000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .fluidOutputs(SodiumEthoxideSolution.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SodiumEthoxideSolution.getFluid(50))
                .fluidInputs(CarbonDisulfide.getFluid(50))
                .fluidOutputs(SodiumEthylXanthateSolution.getFluid(50))
                .EUt(480)
                .duration(4)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidOutputs(SodiumEthylXanthateSolution.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumEthylXanthateSolution.getFluid(1000))
                .output(dust, SodiumEthylXanthate)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

//POTASSIUM ETHYL XANTHATE

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidOutputs(PotassiumEthylXanthateSolution.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumEthylXanthateSolution.getFluid(1000))
                .output(dust, PotassiumEthylXanthate)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

//POTASSIUM BUTYL XANTHATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(NButanol.getFluid(1000))
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidOutputs(PotassiumButylXanthateSolution.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumButylXanthateSolution.getFluid(1000))
                .output(dust, PotassiumButylXanthate)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

//POTASSIUM AMYL XANTHATE
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, DicobaltOctacarbonyl, 18)
                .fluidInputs(HotHighPressureHydrogen.getFluid(2000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(OneButene.getFluid(1000))
                .fluidOutputs(PentanalMixture.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PentanalMixture.getFluid(1000))
                .output(dust, DicobaltOctacarbonyl, 18)
                .fluidOutputs(Valeraldehyde.getFluid(800))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Valeraldehyde.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .notConsumable(catalystBedReduction, MarkerMaterials.Tier.HV)
                .fluidOutputs(NPentanol.getFluid(50))
                .EUt(480)
                .duration(4)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Valeraldehyde.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(NPentanol.getFluid(50))
                .EUt(480)
                .duration(4)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(NPentanol.getFluid(1000))
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidOutputs(PotassiumAmylXanthateSolution.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumAmylXanthateSolution.getFluid(1000))
                .output(dust, PotassiumAmylXanthate)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

//SODIUM ISOBUTYL XANTHATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 3)
                .fluidInputs(IsobutylAlcohol.getFluid(1000))
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidOutputs(SodiumIsobutylXanthateSolution.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(SodiumIsobutylXanthateSolution.getFluid(1000))
                .output(dust, SodiumIsobutylXanthate)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

//POTASSIUM ISOPROPYL XANTHATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PotassiumHydroxide, 3)
                .fluidInputs(IsopropylAlcohol.getFluid(1000))
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .fluidOutputs(PotassiumIsopropylXanthateSolution.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PotassiumIsopropylXanthateSolution.getFluid(1000))
                .output(dust, PotassiumIsopropylXanthate)
                .fluidOutputs(Water.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

//HEXYLAMMONIUM ACETATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(dust, ActivatedRaneyNickel)
                .fluidInputs(NHexadecanol.getFluid(1000))
                .fluidInputs(Ammonia.getFluid(1000))
                .output(dust, NHexadecylamine)
                .fluidOutputs(Water.getFluid(1000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NHexadecylamine)
                .fluidInputs(AceticAcid.getFluid(1000))
                .output(dust, NHexadecylammoniumAcetate)
                .duration(3)
                .EUt(30)
                .buildAndRegister();

//HYDROXAMATES
//OCTYL HYDROXAMATE
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(OctanoylChloride.getFluid(1000))
                .fluidInputs(Hydroxylamine.getFluid(1000))
                .output(dust, OctylHydroxamicAcid)
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, OctylHydroxamicAcid)
                .fluidInputs(PotassiumHydroxideSolution.getFluid(1000))
                .output(dust, PotassiumOctylHydroxamate)
                .fluidOutputs(Water.getFluid(2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

//1-AMIDOETHYL-2-ALKYL-2-IMIDAZOLINE

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Diethylenetriamine.getFluid(1000))
                .fluidInputs(CaprylicAcid.getFluid(2000))
                .fluidOutputs(OneAmidoethylTwoAlkylTwoImidazoline.getFluid(1000))
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(1920)
                .duration(80)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Diethylenetriamine.getFluid(1000))
                .fluidInputs(LauricAcid.getFluid(2000))
                .fluidOutputs(OneAmidoethylTwoAlkylTwoImidazoline.getFluid(1000))
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(1920)
                .duration(80)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Diethylenetriamine.getFluid(1000))
                .fluidInputs(PalmiticAcid.getFluid(2000))
                .fluidOutputs(OneAmidoethylTwoAlkylTwoImidazoline.getFluid(1000))
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(1920)
                .duration(80)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(Diethylenetriamine.getFluid(1000))
                .fluidInputs(StearicAcid.getFluid(2000))
                .fluidOutputs(OneAmidoethylTwoAlkylTwoImidazoline.getFluid(1000))
                .fluidOutputs(Steam.getFluid(3000))
                .EUt(1920)
                .duration(80)
                .buildAndRegister();

//LIQUID-LIQUID EXTRACTANTS
//TODGA
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(DiethyleneGlycol.getFluid(50))
                .fluidInputs(NitricAcid.getFluid(400))
                .fluidInputs(Ethanol.getFluid(50))
                .fluidOutputs(DiglycolicAcidSolution.getFluid(150))
                .fluidOutputs(NitrogenDioxide.getFluid(200))
                .duration(3)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DiglycolicAcidSolution.getFluid(3000))
                .fluidOutputs(DiglycolicAcid.getFluid(1000))
                .fluidOutputs(Water.getFluid(1900))
                .fluidOutputs(NitricAcid.getFluid(4000))
                .fluidOutputs(EthanolWaterAzeotrope.getFluid(1100))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(DiglycolicAcid.getFluid(50))
                .fluidInputs(ThionylChloride.getFluid(50))
                .fluidInputs(Pyridine.getFluid(50))
                .fluidOutputs(DilutedChloroaceticAnhydride.getFluid(150))
                .fluidOutputs(SulfurDioxide.getFluid(50))
                .duration(3)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedChloroaceticAnhydride.getFluid(3000))
                .output(dust, ChloroaceticAnhydride, 13)
                .fluidOutputs(Pyridine.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Nickel)
                .fluidInputs(NOctanol.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(NOctylamine.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .duration(3)
                .EUt(30)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .notConsumable(dust, ActivatedRaneyNickel)
                .fluidInputs(NOctanol.getFluid(100))
                .fluidInputs(Ammonia.getFluid(100))
                .fluidOutputs(Dioctylamine.getFluid(50))
                .fluidOutputs(Water.getFluid(100))
                .duration(3)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 8)
                .fluidInputs(Dioctylamine.getFluid(2000))
                .input(dust, ChloroaceticAnhydride, 13)
                .fluidOutputs(TetraoctylDiglycolamide.getFluid(1000))
                .fluidOutputs(DilutedSaltwater.getFluid(2000))
                .duration(400)
                .EUt(480)
                .buildAndRegister();

//TRIOCTYLAMINE

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .notConsumable(dust, Nickel)
                .fluidInputs(NOctanol.getFluid(150))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(Trioctylamine.getFluid(50))
                .fluidOutputs(Water.getFluid(150))
                .duration(3)
                .EUt(30)
                .buildAndRegister();

//ISODECANOL

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, ZSMFive)
                .fluidInputs(Propene.getFluid(150))
                .fluidOutputs(Tripropylene.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, DicobaltOctacarbonyl, 18)
                .fluidInputs(HotHighPressureHydrogen.getFluid(2000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Tripropylene.getFluid(1000))
                .fluidOutputs(IsodecanalMixture.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(IsodecanalMixture.getFluid(1000))
                .output(dust, DicobaltOctacarbonyl, 18)
                .fluidOutputs(Isodecanal.getFluid(500))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Isodecanal.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(Isodecanol.getFluid(50))
                .EUt(480)
                .duration(4)
                .buildAndRegister();

//TBP
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(NButanol.getFluid(150))
                .fluidInputs(PhosphorylChloride.getFluid(50))
                .fluidOutputs(AcidicTributylPhosphate.getFluid(200))
                .duration(3)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodiumHydroxide, 9)
                .fluidInputs(AcidicTributylPhosphate.getFluid(4000))
                .fluidOutputs(TributylPhosphate.getFluid(1000))
                .fluidOutputs(SaltWater.getFluid(3000))
                .duration(100)
                .EUt(120)
                .buildAndRegister();

//D2EHPA
        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidInputs(Butyraldehyde.getFluid(2000))
                .fluidOutputs(TwoEthylTwoHexenal.getFluid(3000))
                .fluidOutputs(DilutedSodiumHydroxideSolution.getFluid(1000))
                .duration(60)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(DilutedSodiumHydroxideSolution.getFluid(2000))
                .fluidOutputs(Water.getFluid(2000))
                .output(dust, SodiumHydroxide, 4)
                .duration(100)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Cobalt)
                .fluidInputs(TwoEthylTwoHexenal.getFluid(100))
                .fluidInputs(Hydrogen.getFluid(200))
                .fluidOutputs(TwoEthylhexanol.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhosphorusPentoxide, 7)
                .fluidInputs(TwoEthylhexanol.getFluid(6000))
                .fluidOutputs(TwoEthylhexylPhosphoricAcidMix.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(TwoEthylhexylPhosphoricAcidMix.getFluid(2000))
                .fluidInputs(Hexane.getFluid(1000))
                .fluidOutputs(MonoTwoEthylhexylPhosphoricAcid.getFluid(1000))
                .fluidOutputs(DiTwoEthylhexylPhosphoricAcidSolution.getFluid(2000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DiTwoEthylhexylPhosphoricAcidSolution.getFluid(2000))
                .fluidOutputs(DiTwoEthylhexylPhosphoricAcid.getFluid(1000))
                .fluidOutputs(Hexane.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

//N1923
        MIXER_RECIPES.recipeBuilder()
                .input(dust, YttriumOxide, 5)
                .input(dust, NeodymiumOxide, 5)
                .input(dust, ManganeseDioxide, 3)
                .output(dust, RareEarthCatalystYNd, 13)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//C10 & 12 ACIDS
        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, ChromiumTrioxide, 16)
                .fluidInputs(SulfuricAcid.getFluid(6000))
                .fluidInputs(DistilledWater.getFluid(15000))
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(NDecanol.getFluid(3000))
                .fluidOutputs(ChromiumSulfateSolution.getFluid(1000))
                .fluidOutputs(CapricAcid.getFluid(3000))
                .duration(300)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ChromiumTrioxide, 16)
                .fluidInputs(SulfuricAcid.getFluid(6000))
                .fluidInputs(Acetone.getFluid(1000))
                .fluidInputs(NDodecanol.getFluid(3000))
                .fluidOutputs(ChromiumSulfateSolution.getFluid(1000))
                .fluidOutputs(LauricAcid.getFluid(3000))
                .duration(300)
                .EUt(480)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(dust, RareEarthCatalystYNd)
                .fluidInputs(LauricAcid.getFluid(1000))
                .fluidInputs(CapricAcid.getFluid(1000))
                .fluidInputs(Nitrogen.getFluid(2000))
                .fluidOutputs(DilutedPrimaryAmineN.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .duration(300)
                .EUt(480)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedPrimaryAmineN.getFluid(1000))
                .fluidOutputs(PrimaryAmineN.getFluid(400))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

//DBC
        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Platinum)
                .fluidInputs(Butyraldehyde.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .fluidOutputs(NButanol.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidInputs(DiethyleneGlycol.getFluid(50))
                .fluidInputs(NButanol.getFluid(100))
                .fluidOutputs(DibutylCarbitol.getFluid(50))
                .fluidOutputs(VeryDilutedSulfuricAcid.getFluid(150))
                .duration(5)
                .EUt(120)
                .buildAndRegister();
//TRI OCTYL DECYL AMINE
        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(HydrobromicAcid.getFluid(50))
                .fluidInputs(NOctanol.getFluid(50))
                .fluidOutputs(Bromooctane.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Bromooctane.getFluid(2000))
                .input(dust, Lithium)
                .input(dust, Copper)
                .fluidOutputs(LithiumDioctylcopper.getFluid(1000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CapricAcid.getFluid(1000))
                .fluidInputs(ThionylChloride.getFluid(1000))
                .fluidOutputs(DecanoylChloride.getFluid(1000))
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .fluidOutputs(SulfurDioxide.getFluid(1000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(LithiumDioctylcopper.getFluid(100))
                .fluidInputs(DecanoylChloride.getFluid(100))
                .fluidOutputs(NineOctadecene.getFluid(150))
                .duration(15)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Diborane.getFluid(500))
                .input(dust, SodiumCyanide, 6)
                .output(dust, SodiumCyanoborohydride, 14)
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SodiumCyanoborohydride, 7)
                .fluidInputs(NineOctadecene.getFluid(3000))
                .fluidInputs(AmmoniumChlorideSolution.getFluid(1000))
                .fluidOutputs(TriOctylDecylAmine.getFluid(1000))
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(300)
                .EUt(480)
                .buildAndRegister();

//ION EXCHANGE RESINS
//AG 50W-X8
        POLYMERIZATION_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .fluidInputs(Styrene.getFluid(1000))
                .fluidInputs(Divinylbenzene.getFluid(1000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(CrosslinkedPolystyrene.getFluid(288))
                .EUt(120)
                .duration(160)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .notConsumable(SulfuricAcid.getFluid(50))
                .fluidInputs(Ethylbenzene.getFluid(50))
                .fluidInputs(Ethylene.getFluid(50))
                .fluidOutputs(Diethylbenzene.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(round, CrosslinkedPolystyrene, 32)
                .fluidInputs(Oleum.getFluid(1100))
                .output(BEADS_AG_FIFTY_W_X_EIGHT)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        FLUIDIZED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Diethylbenzene.getFluid(1000))
                .notConsumable(dust, ChromiumTrioxide)
                .fluidOutputs(Divinylbenzene.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(4000))
                .duration(300)
                .EUt(120)
                .buildAndRegister();

//AMBERLYST, MIBK, AND MIBC

        POLYMERIZATION_RECIPES.recipeBuilder()
                .input(dust, Palladium)
                .fluidInputs(Styrene.getFluid(1000))
                .fluidInputs(Divinylbenzene.getFluid(1000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(PalladiumDopedCrosslinkedPolystyrene.getFluid(288))
                .EUt(120)
                .duration(160)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(50))
                .fluidInputs(SulfurTrioxide.getFluid(5))
                .fluidOutputs(Oleum.getFluid(55))
                .duration(4)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .fluidInputs(SulfurTrioxide.getFluid(100))
                .fluidOutputs(Oleum.getFluid(1100))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(round, PalladiumDopedCrosslinkedPolystyrene, 32)
                .fluidInputs(Oleum.getFluid(1100))
                .output(BEADS_AMBERLYST_CH)
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .notConsumable(BEADS_AMBERLYST_CH)
                .fluidInputs(Acetone.getFluid(2000))
                .fluidInputs(HotHighPressureHydrogen.getFluid(2000))
                .fluidOutputs(DilutedMethylIsobutylKetone.getFluid(2000))
                .duration(300)
                .EUt(480)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedMethylIsobutylKetone.getFluid(2000))
                .fluidOutputs(MethylIsobutylKetone.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Copper)
                .fluidInputs(MethylIsobutylKetone.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .fluidOutputs(MethylIsobutylCarbinol.getFluid(50))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

//RHENIUM EXTRACTION

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Alumina)
                .fluidInputs(NButanol.getFluid(50))
                .fluidInputs(Ammonia.getFluid(50))
                .fluidOutputs(NButylamine.getFluid(50))
                .fluidOutputs(Water.getFluid(50))
                .duration(3)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 6)
                .input(dust, AluminiumSulfate, 51)
                .input(dust, SodiumHydroxide)
                .fluidInputs(Ethanol.getFluid(100))
                .fluidInputs(DemineralizedWater.getFluid(1800))
                .fluidInputs(NButylamine.getFluid(100))
                .output(dust, HZSMFive)
                .duration(500)
                .EUt(480)
                .buildAndRegister();;

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, HZSMFive)
                .fluidInputs(Toluene.getFluid(50))
                .fluidInputs(Ethylene.getFluid(50))
                .fluidOutputs(Ethyltoluene.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();;

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Chlorine.getFluid(50))
                .fluidInputs(Ethyltoluene.getFluid(50))
                .notConsumable(ZincChlorideSolution.getFluid(1000))
                .notConsumable(Formaldehyde.getFluid(1000))
                .fluidOutputs(VinylbenzylChloride.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(100))
                .duration(5)
                .EUt(30)
                .buildAndRegister();;

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Aluminium.getFluid(144))
                .input(dust, Cobalt, 1)
                .input(dustTiny, Zinc, 1)
                .output(dust, RaneyCobalt, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, RaneyCobalt, 4)
                .input(dust, SodiumHydroxide, 6)
                .fluidInputs(Water.getFluid(6000))
                .output(dust, ActivatedRaneyCobalt, 2)
                .output(dust, SodiumAluminate, 20)
                .fluidOutputs(Hydrogen.getFluid(6000))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        TRICKLE_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Hydrogen.getFluid(300))
                .fluidInputs(Aniline.getFluid(50))
                .notConsumable(dust, ActivatedRaneyCobalt, 1)
                .fluidOutputs(Cyclohexylamine.getFluid(50))
                .duration(20)
                .EUt(30)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(VinylbenzylChloride.getFluid(100))
                .fluidInputs(Styrene.getFluid(900))
                .fluidInputs(Divinylbenzene.getFluid(1000))
                .input(dustTiny, PotassiumPersulfate)
                .fluidOutputs(FunctionalizableCrosslinkedPolystyrene.getFluid(288))
                .EUt(120)
                .duration(160)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(round, FunctionalizableCrosslinkedPolystyrene, 32)
                .fluidInputs(Cyclohexylamine.getFluid(100))
                .output(BEADS_RHENIUM_ION_EXCHANGE)
                .EUt(120)
                .duration(200)
                .buildAndRegister();
    }
}
