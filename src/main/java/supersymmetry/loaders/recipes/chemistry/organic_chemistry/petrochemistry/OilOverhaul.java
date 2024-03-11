package supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.apache.logging.log4j.Level;
import supersymmetry.api.SusyLog;
import supersymmetry.loaders.recipes.Utils;

import java.util.LinkedHashMap;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.recipes.RecipeMaps.EXTRACTOR_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustTiny;
import static gregtech.common.blocks.MetaBlocks.ASPHALT;
import static gregtech.common.blocks.MetaBlocks.PLANKS;
import static gregtech.common.items.MetaItems.EMITTER_LV;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.catalystBed;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.sintering_comburents;
import static supersymmetry.loaders.recipes.Utils.sintering_fuels;

public class OilOverhaul {
    private static class FluidSimple {
        public Material material;
        FluidStack get(int amount) {
            return this.material.getFluid(amount);
        }
        public FluidSimple(Material material) {
            this.material = material;
        }
    }

    private static class Oil extends FluidSimple {
        private final Material diluted;
        private final Material desalted;

        public Oil(Material material, Material diluted, Material desalted) {
            super(material);
            this.diluted = diluted;
            this.desalted = desalted;
        }

        public FluidStack getDiluted(int amount) {
            return this.diluted.getFluid(amount);
        }

        public FluidStack getDesalted(int amount) {
            return this.desalted.getFluid(amount);
        }
    }

    private static class OilFraction extends FluidSimple {
        Material treatedSulfuric;
        Material sulfuric;
        Boolean isUpgradable = false;
        Material upgradeName;
        Material upgradedMix;

        OilFraction(Material material, Material sulfuric, Material treatedSulfuric) {
            super(material);
            this.sulfuric = sulfuric;
            this.treatedSulfuric = treatedSulfuric;
        }

        OilFraction(Material material, Material upgradeName, Material upgradedMix, Material sulfuric, Material treatedSulfuric) {
            super(material);
            this.isUpgradable = true;
            this.upgradeName = upgradeName;
            this.upgradedMix = upgradedMix;
            this.sulfuric = sulfuric;
            this.treatedSulfuric = treatedSulfuric;
        }

        FluidStack getTreatedSulfuric(int amount) {
            return treatedSulfuric.getFluid(amount);
        }

        FluidStack getSulfuric(int amount) {
            return this.sulfuric.getFluid(amount);
        }

        FluidStack getUpgraded(int amount) {
            return this.upgradeName.getFluid(amount);
        }

        FluidStack getUpgradedMix(int amount) {
            return this.upgradedMix.getFluid(amount);
        }
    }

    private static class OilFractionCrackable {
        public Material material;
        private final Material lightlyHydrocracked;
        private final Material severelyHydrocracked;
        private final Material lightlySteamcracked;
        private final Material severelySteamcracked;

        public OilFractionCrackable(Material material, Material lightlyHydrocracked, Material severelyHydrocracked, Material lightlySteamcracked, Material severelySteamcracked) {
            SusyLog.logger.log(Level.INFO, material.getLocalizedName());
            if (lightlyHydrocracked == null) SusyLog.logger.log(Level.ERROR, "AAAAAAAAAAAAAH2");
            this.material = material;
            this.lightlyHydrocracked = lightlyHydrocracked;
            this.severelyHydrocracked = severelyHydrocracked;
            this.lightlySteamcracked = lightlySteamcracked;
            this.severelySteamcracked = severelySteamcracked;
        }

        public FluidStack getLightlyHydro(int amount) {
            if (lightlyHydrocracked == null) SusyLog.logger.log(Level.ERROR, "AAAAAAAAAAAAAAH2");

            return this.lightlyHydrocracked.getFluid(amount);
        }

        public FluidStack getSeverelyHydro(int amount) {
            return this.severelyHydrocracked.getFluid(amount);
        }

        public FluidStack getLightlySteam(int amount) {
            return this.lightlySteamcracked.getFluid(amount);
        }

        public FluidStack getSeverelySteam(int amount) {
            return this.severelySteamcracked.getFluid(amount);
        }

        FluidStack get(int amount) {
            return this.material.getFluid(amount);
        }
    }

    private static class LinkedMapHandler<T extends FluidSimple> extends LinkedHashMap<Material, T> {
        public void add(T toAdd) {
            this.put(toAdd.material, toAdd);
        }
    }

    public static void init() {
        LinkedMapHandler<OilFraction> fractions = new LinkedMapHandler<>();
        fractions.add(new OilFraction(FuelOil, Diesel, UpgradedFuelOilMix, SulfuricFuelOil, TreatedSulfuricFuelOil));
        fractions.add(new OilFraction(Diesel, Kerosene, UpgradedDieselMix, SulfuricDiesel, TreatedSulfuricDiesel));
        fractions.add(new OilFraction(Kerosene, Naphtha, UpgradedKeroseneMix, SulfuricKerosene, TreatedSulfuricKerosene));
        fractions.add(new OilFraction(Naphtha, Gasoline, UpgradedNaphthaMix, SulfuricNaphtha, TreatedSulfuricNaphtha));
        fractions.add(new OilFraction(Gasoline, SulfuricGasoline, TreatedSulfuricGasoline));
        fractions.add(new OilFraction(RefineryGas, SulfuricRefineryGas, TreatedSulfuricRefineryGas));
        fractions.add(new OilFraction(NaturalGas, SulfuricNaturalGas, TreatedSulfuricNaturalGas));

        LinkedHashMap<Material, OilFractionCrackable> crackFractions = new LinkedHashMap<>();
        crackFractions.put(Kerosene, new OilFractionCrackable(Kerosene, LightlySteamCrackedNaphtha, SeverelyHydrocrackedKerosene, LightlySteamcrackedKerosene, SeverelySteamcrackedKerosene));
        crackFractions.put(Naphtha, new OilFractionCrackable(Naphtha, LightlyHydroCrackedNaphtha, SeverelyHydroCrackedNaphtha, LightlySteamCrackedNaphtha, SeverelySteamCrackedNaphtha));
        crackFractions.put(Gasoline, new OilFractionCrackable(Gasoline, LightlyHydrocrackedGasoline, SeverelyHydrocrackedGasoline, LightlySteamcrackedGasoline, SeverelySteamcrackedGasoline));

        LinkedMapHandler<Oil> oils = new LinkedMapHandler<>();
        oils.add(new Oil(Oil, DilutedOil, DesaltedOil));
        oils.add(new Oil(OilLight, DilutedOilLight, DesaltedOilLight));
        oils.add(new Oil(OilHeavy, DilutedOilHeavy, DesaltedOilHeavy));

        for (Oil oil : oils.values()) {
            MIXER_RECIPES.recipeBuilder()
                    .fluidInputs(Water.getFluid(100))
                    .fluidInputs(oil.get(1000))
                    .fluidOutputs(oil.getDiluted(1000))
                    .duration(200)
                    .EUt(30)
                    .buildAndRegister();
        }
        ELECTROSTATIC_SEPARATOR.recipeBuilder()
                .fluidInputs(DilutedOil.getFluid(1000))
                .fluidOutputs(OilyBrine.getFluid(100))
                .fluidOutputs(DesaltedOil.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ELECTROSTATIC_SEPARATOR.recipeBuilder()
                .fluidInputs(DilutedOilLight.getFluid(1000))
                .fluidOutputs(LightOilyBrine.getFluid(100))
                .fluidOutputs(DesaltedOilLight.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        ELECTROSTATIC_SEPARATOR.recipeBuilder()
                .fluidInputs(DilutedOilHeavy.getFluid(1000))
                .fluidOutputs(HeavyOilyBrine.getFluid(100))
                .fluidOutputs(DesaltedOilHeavy.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(OilyBrine.getFluid(1000))
                .fluidOutputs(DesaltedOil.getFluid(200))
                .fluidOutputs(SaltWater.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightOilyBrine.getFluid(1000))
                .fluidOutputs(DesaltedOilLight.getFluid(200))
                .fluidOutputs(SaltWater.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyOilyBrine.getFluid(1000))
                .fluidOutputs(DesaltedOilHeavy.getFluid(200))
                .fluidOutputs(SaltWater.getFluid(1000))
                .duration(160)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(oils.get(Oil).getDesalted(1000))
                .fluidOutputs(SulfuricOilResidue.getFluid(150))
                .fluidOutputs(fractions.get(FuelOil).getSulfuric(150))
                .fluidOutputs(fractions.get(Diesel).getSulfuric(200))
                .fluidOutputs(fractions.get(Kerosene).getSulfuric(100))
                .fluidOutputs(fractions.get(Naphtha).getSulfuric(200))
                .fluidOutputs(fractions.get(Gasoline).getSulfuric(100))
                .fluidOutputs(fractions.get(RefineryGas).getSulfuric(500))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(oils.get(OilLight).getDesalted(1000))
                .fluidOutputs(SulfuricOilResidue.getFluid(50))
                .fluidOutputs(fractions.get(FuelOil).getSulfuric(100))
                .fluidOutputs(fractions.get(Diesel).getSulfuric(150))
                .fluidOutputs(fractions.get(Kerosene).getSulfuric(100))
                .fluidOutputs(fractions.get(Naphtha).getSulfuric(250))
                .fluidOutputs(fractions.get(Gasoline).getSulfuric(150))
                .fluidOutputs(fractions.get(RefineryGas).getSulfuric(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(oils.get(OilHeavy).getDesalted(1000))
                .fluidOutputs(SulfuricOilResidue.getFluid(300))
                .fluidOutputs(fractions.get(FuelOil).getSulfuric(200))
                .fluidOutputs(fractions.get(Diesel).getSulfuric(150))
                .fluidOutputs(fractions.get(Kerosene).getSulfuric(100))
                .fluidOutputs(fractions.get(Naphtha).getSulfuric(100))
                .fluidOutputs(fractions.get(Gasoline).getSulfuric(50))
                .fluidOutputs(fractions.get(RefineryGas).getSulfuric(250))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        for (OilFraction fraction : fractions.values()) {
            FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                    .fluidInputs(fraction.getSulfuric(180))
                    .fluidInputs(Hydrogen.getFluid(45))
                    .notConsumable(catalystBed, Alumina)
                    .fluidOutputs(fraction.getTreatedSulfuric(180))
                    .duration(30)
                    .EUt(30)
                    .buildAndRegister();

            DISTILLATION_RECIPES.recipeBuilder()
                    .fluidInputs(fraction.getTreatedSulfuric(1000))
                    .fluidOutputs(fraction.get(1000))
                    .fluidOutputs(SourGas.getFluid(250))
                    .duration(100)
                    .EUt(30)
                    .buildAndRegister();
        }

// Sour gas Processing

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(SourGas.getFluid(3000))
                .fluidInputs(EthanolamineMix.getFluid(1000))
                .fluidOutputs(Hydrogen.getFluid(1000))
                .fluidOutputs(RichAmine.getFluid(1000))
                .duration(120)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(RichAmine.getFluid(1000))
                .fluidOutputs(HydrogenSulfide.getFluid(1000))
                .fluidOutputs(EthanolamineMix.getFluid(1000))
                .duration(160)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenSulfide.getFluid(3000))
                .fluidInputs(Oxygen.getFluid(3000))
                .fluidOutputs(UncatalyzedSulfurousGases.getFluid(3000))
                .output(dust, Sulfur)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .fluidInputs(HydrogenSulfide.getFluid(3000))
                .fluidInputs(Air.getFluid(9000))
                .fluidOutputs(UncatalyzedSulfurousGases.getFluid(3000))
                .output(dust, Sulfur)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Alumina)
                .fluidInputs(UncatalyzedSulfurousGases.getFluid(3000))
                .fluidOutputs(Steam.getFluid(2000))
                .output(dust, Sulfur, 2)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

// Natural Gas Processing

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(CrudeNaturalGas.getFluid(1000))
                .fluidOutputs(Oil.getFluid(50))
                .fluidOutputs(SulfuricNaturalGas.getFluid(1000))
                .duration(400)
                .EUt(30)
                .buildAndRegister();

// Sulfuric Oil Residue Processing

        // Solvent Dewaxing
        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricOilResidue.getFluid(1000))
                .output(BITUMINOUS_RESIDUE)
                .fluidOutputs(CrudeLubricatingOil.getFluid(850))
                .fluidOutputs(fractions.get(FuelOil).getSulfuric(200))
                .fluidOutputs(fractions.get(Diesel).getSulfuric(200))
                .fluidOutputs(fractions.get(Gasoline).getSulfuric(150))
                .fluidOutputs(fractions.get(Naphtha).getSulfuric(100))
                .duration(600)
                .EUt(30)
                .buildAndRegister();

// Slack wax Processing

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(SlackWax.getFluid(1000))
                .fluidOutputs(LubricatingOil.getFluid(250))
                .outputs(PARAFFIN_WAX.getStackForm(4))
                .duration(600)
                .EUt(30)
                .buildAndRegister();

        ModHandler.addShapedRecipe("treated_wood_planks_paraffin", new ItemStack(PLANKS, 8, 1),
                "PPP", "PWP", "PPP",
                'P', "plankWood", 'W', PARAFFIN_WAX);

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(PARAFFIN_WAX)
                .circuitMeta(1)
                .fluidOutputs(LubricatingOil.getFluid(250))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(PARAFFIN_WAX)
                .circuitMeta(2)
                .fluidOutputs(Resin.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

// Bituminous Residue Processing

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Oil.getFluid(500))
                .input(BITUMEN)
                .fluidOutputs(BitumenSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BitumenSolution.getFluid(1000))
                .fluidOutputs(Oil.getFluid(650))
                .output(dust, Asphalt, 4)
                .duration(300)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(OilLight.getFluid(500))
                .input(BITUMEN)
                .fluidOutputs(LightBitumenSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(LightBitumenSolution.getFluid(1000))
                .fluidOutputs(OilLight.getFluid(650))
                .output(dust, Asphalt, 4)
                .duration(300)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(OilHeavy.getFluid(500))
                .input(BITUMEN)
                .fluidOutputs(HeavyBitumenSolution.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(HeavyBitumenSolution.getFluid(1000))
                .fluidOutputs(OilHeavy.getFluid(650))
                .output(dust, Asphalt, 4)
                .duration(300)
                .EUt(7)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Asphalt)
                .fluidInputs(Concrete.getFluid(144))
                .outputs(new ItemStack(ASPHALT, 2))
                .duration(30)
                .EUt(16)
                .buildAndRegister();

// Bituminous Residue -> Coke

        COKING_RECIPES.recipeBuilder()
                .fluidInputs(Steam.getFluid(1000))
                .input(BITUMINOUS_RESIDUE)
                .fluidOutputs(SulfuricOilResidue.getFluid(150))
                .output(dust, GreenCoke, 4)
                .duration(600)
                .EUt(60)
                .buildAndRegister();

        for (Utils.Combustible fuel : sintering_fuels) {
            if (!fuel.isPlasma) {
                for (Utils.Comburent comburent : sintering_comburents) {
                    ROTARY_KILN.recipeBuilder()
                            .input(dust, GreenCoke)
                            .output(dust, Coke)
                            .fluidInputs(fuel.getFluid())
                            .fluidInputs(comburent.getFluid())
                            .fluidOutputs(fuel.getByproduct())
                            .duration(fuel.getDuration() + comburent.getDuration())
                            .EUt(120)
                            .buildAndRegister();

                    ROTARY_KILN.recipeBuilder()
                            .input(BITUMINOUS_RESIDUE)
                            .fluidInputs(fuel.getFluid())
                            .fluidInputs(comburent.getFluid())
                            .output(BITUMEN)
                            .fluidOutputs(fuel.getByproduct())
                            .duration(fuel.getDuration() + comburent.getDuration())
                            .EUt(120)
                            .buildAndRegister();
                }
            }
        }


// Cracking: Ethane, Propane Butane

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Ethane.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(SteamCrackedEthane.getFluid(700))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Propane.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(SteamCrackedPropane.getFluid(700))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Butane.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(SteamCrackedButane.getFluid(700))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(Ethane.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(SteamCrackedEthane.getFluid(1000))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(Propane.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(SteamCrackedPropane.getFluid(1000))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(Butane.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(SteamCrackedButane.getFluid(1000))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SteamCrackedEthane.getFluid(1000))
                .fluidOutputs(Butadiene.getFluid(50))
                .fluidOutputs(Propene.getFluid(50))
                .fluidOutputs(Ethylene.getFluid(800))
                .fluidOutputs(Methane.getFluid(50))
                .fluidOutputs(Hydrogen.getFluid(50))
                .duration(150)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SteamCrackedPropane.getFluid(1000))
                .fluidOutputs(Butadiene.getFluid(50))
                .fluidOutputs(Propene.getFluid(150))
                .fluidOutputs(Ethylene.getFluid(500))
                .fluidOutputs(Methane.getFluid(150))
                .fluidOutputs(Hydrogen.getFluid(150))
                .duration(150)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(SteamCrackedButane.getFluid(1000))
                .fluidOutputs(Butadiene.getFluid(150))
                .fluidOutputs(Propene.getFluid(250))
                .fluidOutputs(Ethylene.getFluid(350))
                .fluidOutputs(Methane.getFluid(150))
                .fluidOutputs(Hydrogen.getFluid(100))
                .duration(150)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(FuelOil.getFluid(1000))
                .fluidOutputs(Hexane.getFluid(300))
                .fluidOutputs(Pentane.getFluid(250))
                .fluidOutputs(Butane.getFluid(200))
                .fluidOutputs(Propane.getFluid(150))
                .fluidOutputs(Ethane.getFluid(100))
                .fluidOutputs(Methane.getFluid(100))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Diesel.getFluid(1000))
                .fluidOutputs(Hexane.getFluid(150))
                .fluidOutputs(Pentane.getFluid(200))
                .fluidOutputs(Butane.getFluid(300))
                .fluidOutputs(Propane.getFluid(200))
                .fluidOutputs(Ethane.getFluid(100))
                .fluidOutputs(Methane.getFluid(100))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Kerosene.getFluid(1000))
                .fluidOutputs(Hexane.getFluid(100))
                .fluidOutputs(Pentane.getFluid(150))
                .fluidOutputs(Butane.getFluid(250))
                .fluidOutputs(Propane.getFluid(250))
                .fluidOutputs(Ethane.getFluid(200))
                .fluidOutputs(Methane.getFluid(100))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidOutputs(Hexane.getFluid(100))
                .fluidOutputs(Pentane.getFluid(150))
                .fluidOutputs(Butane.getFluid(200))
                .fluidOutputs(Propane.getFluid(300))
                .fluidOutputs(Ethane.getFluid(250))
                .fluidOutputs(Methane.getFluid(150))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Gasoline.getFluid(1000))
                .fluidOutputs(Hexane.getFluid(100))
                .fluidOutputs(Pentane.getFluid(100))
                .fluidOutputs(Butane.getFluid(150))
                .fluidOutputs(Propane.getFluid(200))
                .fluidOutputs(Ethane.getFluid(300))
                .fluidOutputs(Methane.getFluid(250))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

// Natural / Refinery -> Gasoline

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(250))
                .fluidInputs(NaturalGas.getFluid(50))
                .fluidOutputs(AlkylatedNaturalGas.getFluid(300))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(250))
                .fluidInputs(RefineryGas.getFluid(50))
                .fluidOutputs(AlkylatedRefineryGas.getFluid(300))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AlkylatedNaturalGas.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(2500))
                .fluidOutputs(Gasoline.getFluid(500))
                .duration(200)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AlkylatedRefineryGas.getFluid(3000))
                .fluidOutputs(SulfuricAcid.getFluid(2500))
                .fluidOutputs(Gasoline.getFluid(500))
                .duration(200)
                .EUt(30 * 2)
                .buildAndRegister();

// Natural Gas Distillation

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(NaturalGas.getFluid(1000))
                .fluidOutputs(Butane.getFluid(100))
                .fluidOutputs(Propane.getFluid(100))
                .fluidOutputs(Ethane.getFluid(100))
                .fluidOutputs(Methane.getFluid(750))
                .duration(100)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(LiquidNaturalGas.getFluid(20))
                .fluidOutputs(Butane.getFluid(128))
                .fluidOutputs(Propane.getFluid(128))
                .fluidOutputs(Ethane.getFluid(128))
                .fluidOutputs(Methane.getFluid(960))
                .fluidOutputs(Helium.getFluid(25))
                .duration(100)
                .EUt(120 * 2)
                .buildAndRegister();

// Refinery Gas Distillation

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(RefineryGas.getFluid(1000))
                .fluidOutputs(Butane.getFluid(100))
                .fluidOutputs(Propane.getFluid(100))
                .fluidOutputs(Ethane.getFluid(100))
                .fluidOutputs(Methane.getFluid(750))
                .duration(100)
                .EUt(30 * 2)
                .buildAndRegister();

// Kerosene, naphtha and gasoline cracking

// Cracking
        for (OilFractionCrackable fraction : crackFractions.values()) {
            CRACKING_RECIPES.recipeBuilder()
                    .fluidInputs(fraction.get(1000))
                    .fluidInputs(Hydrogen.getFluid(1000))
                    .fluidOutputs(fraction.getLightlyHydro(1000))
                    .duration(260)
                    .EUt(30 * 2)
                    .buildAndRegister();

            CRACKING_RECIPES.recipeBuilder()
                    .fluidInputs(fraction.get(1000))
                    .fluidInputs(HotHighPressureHydrogen.getFluid(1000))
                    .fluidOutputs(fraction.getSeverelyHydro(1000))
                    .duration(260)
                    .EUt(30 * 2)
                    .buildAndRegister();

            CRACKING_RECIPES.recipeBuilder()
                    .fluidInputs(fraction.get(1000))
                    .fluidInputs(Steam.getFluid(1000))
                    .fluidOutputs(fraction.getLightlySteam(1000))
                    .duration(260)
                    .EUt(30 * 2)
                    .buildAndRegister();

            CRACKING_RECIPES.recipeBuilder()
                    .fluidInputs(fraction.get(1000))
                    .fluidInputs(HotHighPressureSteam.getFluid(1000))
                    .fluidOutputs(fraction.getSeverelySteam(1000))
                    .duration(260)
                    .EUt(30 * 2)
                    .buildAndRegister();
        }

        BLAST_RECIPES.recipeBuilder()
                .fluidInputs(Oxygen.getFluid(1000))
                .input(SPENT_CRACKING_CATALYST, 4)
                .fluidOutputs(FlueGas.getFluid(1000))
                .output(CRACKING_CATALYST, 4)
                .blastFurnaceTemp(1200)
                .duration(100)
                .EUt(30 * 2)
                .buildAndRegister();

// Cracked Distillation

// Kerosene

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Kerosene).getLightlyHydro(1000))
                .fluidOutputs(Gasoline.getFluid(600))
                .fluidOutputs(Naphtha.getFluid(100))
                .fluidOutputs(Butane.getFluid(100))
                .fluidOutputs(Propane.getFluid(100))
                .fluidOutputs(Ethane.getFluid(75))
                .fluidOutputs(Methane.getFluid(75))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Kerosene).getSeverelyHydro(1000))
                .fluidOutputs(Gasoline.getFluid(200))
                .fluidOutputs(Naphtha.getFluid(250))
                .fluidOutputs(Butane.getFluid(300))
                .fluidOutputs(Propane.getFluid(300))
                .fluidOutputs(Ethane.getFluid(175))
                .fluidOutputs(Methane.getFluid(175))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Kerosene).getLightlySteam(1000))
                .fluidOutputs(Gasoline.getFluid(300))
                .fluidOutputs(Naphtha.getFluid(50))
                .fluidOutputs(Toluene.getFluid(25))
                .fluidOutputs(Benzene.getFluid(125))
                .fluidOutputs(Butene.getFluid(25))
                .fluidOutputs(Butadiene.getFluid(15))
                .fluidOutputs(Propane.getFluid(3))
                .fluidOutputs(Propene.getFluid(30))
                .fluidOutputs(Ethane.getFluid(5))
                .fluidOutputs(Ethylene.getFluid(50))
                .fluidOutputs(Methane.getFluid(50))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Kerosene).getSeverelySteam(1000))
                .fluidOutputs(Gasoline.getFluid(100))
                .fluidOutputs(Naphtha.getFluid(125))
                .fluidOutputs(Toluene.getFluid(80))
                .fluidOutputs(Benzene.getFluid(125))
                .fluidOutputs(Butene.getFluid(80))
                .fluidOutputs(Butadiene.getFluid(50))
                .fluidOutputs(Propane.getFluid(10))
                .fluidOutputs(Propene.getFluid(100))
                .fluidOutputs(Ethane.getFluid(15))
                .fluidOutputs(Ethylene.getFluid(150))
                .fluidOutputs(Methane.getFluid(150))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

// Naphtha :concernium:

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Naphtha).getLightlyHydro(1000))
                .fluidOutputs(Butane.getFluid(800))
                .fluidOutputs(Propane.getFluid(300))
                .fluidOutputs(Ethane.getFluid(250))
                .fluidOutputs(Methane.getFluid(250))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Naphtha).getSeverelyHydro(1000))
                .fluidOutputs(Butane.getFluid(125))
                .fluidOutputs(Propane.getFluid(125))
                .fluidOutputs(Ethane.getFluid(1500))
                .fluidOutputs(Methane.getFluid(1500))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Naphtha).getLightlySteam(1000))
                .fluidOutputs(Kerosene.getFluid(75))
                .fluidOutputs(Gasoline.getFluid(150))
                .fluidOutputs(Toluene.getFluid(40))
                .fluidOutputs(Benzene.getFluid(150))
                .fluidOutputs(CFiveFraction.getFluid(150))
                .fluidOutputs(Butene.getFluid(80))
                .fluidOutputs(Butadiene.getFluid(150))
                .fluidOutputs(Propane.getFluid(15))
                .fluidOutputs(Propene.getFluid(200))
                .fluidOutputs(Ethane.getFluid(35))
                .fluidOutputs(Ethylene.getFluid(200))
                .fluidOutputs(Methane.getFluid(200))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Naphtha).getSeverelySteam(1000))
                .fluidOutputs(Kerosene.getFluid(25))
                .fluidOutputs(Gasoline.getFluid(50))
                .fluidOutputs(Toluene.getFluid(20))
                .fluidOutputs(Benzene.getFluid(100))
                .fluidOutputs(CFiveFraction.getFluid(350))
                .fluidOutputs(Butene.getFluid(50))
                .fluidOutputs(Butadiene.getFluid(50))
                .fluidOutputs(Propane.getFluid(15))
                .fluidOutputs(Propene.getFluid(300))
                .fluidOutputs(Ethane.getFluid(65))
                .fluidOutputs(Ethylene.getFluid(500))
                .fluidOutputs(Methane.getFluid(500))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

// Gasoline

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Gasoline).getLightlyHydro(1000))
                .fluidOutputs(Naphtha.getFluid(800))
                .fluidOutputs(Butane.getFluid(150))
                .fluidOutputs(Propane.getFluid(200))
                .fluidOutputs(Ethane.getFluid(125))
                .fluidOutputs(Methane.getFluid(125))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Gasoline).getSeverelyHydro(1000))
                .fluidOutputs(Naphtha.getFluid(200))
                .fluidOutputs(Butane.getFluid(125))
                .fluidOutputs(Propane.getFluid(125))
                .fluidOutputs(Ethane.getFluid(1500))
                .fluidOutputs(Methane.getFluid(1500))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Gasoline).getLightlySteam(1000))
                .fluidOutputs(Kerosene.getFluid(150))
                .fluidOutputs(Naphtha.getFluid(400))
                .fluidOutputs(Toluene.getFluid(40))
                .fluidOutputs(Benzene.getFluid(200))
                .fluidOutputs(Butene.getFluid(75))
                .fluidOutputs(Butadiene.getFluid(60))
                .fluidOutputs(Propane.getFluid(20))
                .fluidOutputs(Propene.getFluid(150))
                .fluidOutputs(Ethane.getFluid(10))
                .fluidOutputs(Ethylene.getFluid(50))
                .fluidOutputs(Methane.getFluid(50))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(crackFractions.get(Gasoline).getSeverelySteam(1000))
                .fluidOutputs(Kerosene.getFluid(50))
                .fluidOutputs(Naphtha.getFluid(100))
                .fluidOutputs(Toluene.getFluid(30))
                .fluidOutputs(Benzene.getFluid(150))
                .fluidOutputs(Butene.getFluid(65))
                .fluidOutputs(Butadiene.getFluid(50))
                .fluidOutputs(Propane.getFluid(50))
                .fluidOutputs(Propene.getFluid(250))
                .fluidOutputs(Ethane.getFluid(50))
                .fluidOutputs(Ethylene.getFluid(250))
                .fluidOutputs(Methane.getFluid(250))
                .duration(600)
                .EUt(30 * 2)
                .buildAndRegister();

        for (OilFraction fraction : fractions.values()) {
            if (fraction.isUpgradable) {
                CRACKING_RECIPES.recipeBuilder()
                        .fluidInputs(fraction.get(1000))
                        .input(CRACKING_CATALYST)
                        .fluidOutputs(fraction.getUpgradedMix(1000))
                        .duration(260)
                        .EUt(30 * 2)
                        .buildAndRegister();

                CENTRIFUGE_RECIPES.recipeBuilder()
                        .fluidInputs(fraction.getUpgradedMix(1000))
                        .fluidOutputs(fraction.getUpgraded(1000))
                        .output(SPENT_CRACKING_CATALYST)
                        .duration(160)
                        .EUt(30)
                        .buildAndRegister();
            }
        }

        CRACKING_RECIPES.recipeBuilder()
                .fluidInputs(LubricatingOil.getFluid(1000))
                .input(CRACKING_CATALYST)
                .fluidOutputs(UpgradedLubricatingOilMix.getFluid(1000))
                .duration(260)
                .EUt(30 * 2)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(UpgradedLubricatingOilMix.getFluid(1000))
                .fluidOutputs(SulfuricFuelOil.getFluid(1000))
                .output(SPENT_CRACKING_CATALYST)
                .duration(160)
                .EUt(30)
                .buildAndRegister();

// BTEX

        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .fluidInputs(Naphtha.getFluid(1000))
                .fluidInputs(Hydrogen.getFluid(1000))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(NaphthaReformate.getFluid(1000))
                .duration(25)
                .EUt(480)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(NaphthaReformate.getFluid(1000))
                .fluidInputs(Furfural.getFluid(100))
                .fluidOutputs(BtexExtract.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(BtexExtract.getFluid(1000))
                .fluidInputs(Steam.getFluid(1000))
                .fluidOutputs(Furfural.getFluid(100))
                .fluidOutputs(BTEX.getFluid(1000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(BTEX.getFluid(1000))
                .fluidOutputs(Xylene.getFluid(400))
                .fluidOutputs(Ethylbenzene.getFluid(50))
                .fluidOutputs(Toluene.getFluid(400))
                .fluidOutputs(Benzene.getFluid(150))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

// XYLENE SEPARATION
        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(Xylene.getFluid(1000))
                .fluidOutputs(OrthoXylene.getFluid(200))
                .fluidOutputs(MetaParaXyleneMixture.getFluid(800))
                .duration(100)
                .EUt(30 * 2)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(MetaParaXyleneMixture.getFluid(4000))
                .output(dust, ParaXylene)
                .fluidOutputs(MetaXylene.getFluid(3000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(dust, ParaXylene));
        EXTRACTOR_RECIPES.recipeBuilder()
                .input(dust, ParaXylene)
                .fluidOutputs(ParaXylene.getFluid(1000))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, DicobaltOctacarbonyl, 18)
                .fluidInputs(Hydrogen.getFluid(2000))
                .fluidInputs(CarbonMonoxide.getFluid(1000))
                .fluidInputs(Ethylene.getFluid(1000))
                .fluidOutputs(PropanalMixture.getFluid(1000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(PropanalMixture.getFluid(1000))
                .output(dust, DicobaltOctacarbonyl, 18)
                .fluidOutputs(Propionaldehyde.getFluid(800))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(Propionaldehyde.getFluid(50))
                .fluidInputs(Hydrogen.getFluid(100))
                .notConsumable(catalystBed, Platinum)
                .fluidOutputs(NPropanol.getFluid(50))
                .EUt(480)
                .duration(4)
                .buildAndRegister();

        FIXED_BED_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, Alumina)
                .fluidInputs(Ammonia.getFluid(50))
                .fluidInputs(NPropanol.getFluid(150))
                .fluidOutputs(Tripropylamine.getFluid(50))
                .fluidOutputs(Water.getFluid(150))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .notConsumable(EMITTER_LV)
                .notConsumable(HydrogenPeroxideSolution.getFluid(50))
                .fluidInputs(HydrobromicAcid.getFluid(1000))
                .fluidInputs(Propene.getFluid(1000))
                .fluidOutputs(NBromopropane.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(NBromopropane.getFluid(1000))
                .fluidInputs(Tripropylamine.getFluid(1000))
                .output(dust, TetrapropylammoniumBromide)
                .duration(5)
                .EUt(120)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .input(dust, SiliconDioxide, 6)
                .input(dust, AluminiumSulfate, 51)
                .input(dust, SodiumHydroxide)
                .input(dustTiny, TetrapropylammoniumBromide)
                .fluidInputs(Ethanol.getFluid(100))
                .fluidInputs(DemineralizedWater.getFluid(1800))
                .output(dust, ZSMFive)
                .duration(500)
                .EUt(480)
                .buildAndRegister();

        CATALYTIC_REFORMER_RECIPES.recipeBuilder()
                .notConsumable(catalystBed, ZSMFive)
                .fluidInputs(MetaXylene.getFluid(1000))
                .fluidOutputs(ParaXylene.getFluid(1000))
                .duration(60)
                .EUt(30 * 2)
                .buildAndRegister();

// Steam-cracked naphtha C5-fraction separation

        // Dimerization of CPD

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(CFiveFraction.getFluid(1000))
                .fluidOutputs(DimerizedCFiveFraction.getFluid(875))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DimerizedCFiveFraction.getFluid(875))
                .fluidOutputs(Dicyclopentadiene.getFluid(125))
                .fluidOutputs(Pentane.getFluid(375))
                .fluidOutputs(Isoprene.getFluid(375))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        FLUID_HEATER_RECIPES.recipeBuilder()
                .fluidInputs(Dicyclopentadiene.getFluid(1000))
                .fluidOutputs(Cyclopentadiene.getFluid(2000))
                .duration(60)
                .EUt(30)
                .buildAndRegister();
    }
}
