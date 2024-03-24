package supersymmetry.loaders.recipes.eletronics;

import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static net.minecraft.init.Items.PAPER;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.sintering_comburents;
import static supersymmetry.loaders.recipes.Utils.sintering_fuels;

public class SMDComponents {
    public static void init() {
// Inductor * 2
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(ring, Steel), OreDictUnifier.get(wireFine, Copper, 2)}, new FluidStack[]{Polyethylene.getFluid(36)});
// Inductor * 4
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(ring, Steel), OreDictUnifier.get(wireFine, AnnealedCopper, 2)}, new FluidStack[]{Polyethylene.getFluid(36)});

// SMD Inductor * 16
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(ring, NickelZincFerrite), OreDictUnifier.get(wireFine, Cupronickel, 4)}, new FluidStack[]{Polyethylene.getFluid(144)});

// SMD Resistor * 16
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Carbon), OreDictUnifier.get(wireFine, Electrum, 4)}, new FluidStack[]{Polyethylene.getFluid(288)});

// SMD Capacitor * 8
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, SiliconeRubber), OreDictUnifier.get(foil, Aluminium)}, new FluidStack[]{Polyethylene.getFluid(72)});
// SMD Capacitor * 12
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, PolyvinylChloride, 2), OreDictUnifier.get(foil, Aluminium)}, new FluidStack[]{Polyethylene.getFluid(72)});
// SMD Capacitor * 16
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, SiliconeRubber), OreDictUnifier.get(foil, Tantalum)}, new FluidStack[]{Polyethylene.getFluid(72)});
// SMD Capacitor * 24
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, PolyvinylChloride), OreDictUnifier.get(foil, Tantalum)}, new FluidStack[]{Polyethylene.getFluid(72)});

// SMD Transistor * 16
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, Gallium), OreDictUnifier.get(wireFine, AnnealedCopper, 8)}, new FluidStack[]{Polyethylene.getFluid(144)});
// SMD Transistor * 32
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, Gallium), OreDictUnifier.get(wireFine, Tantalum, 8)}, new FluidStack[]{Polyethylene.getFluid(144)});

// SMD Resistor * 32
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Carbon), OreDictUnifier.get(wireFine, Tantalum, 4)}, new FluidStack[]{Polyethylene.getFluid(288)});

// SMD Diode * 32
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, GalliumArsenide), OreDictUnifier.get(wireFine, Platinum, 8)}, new FluidStack[]{Polyethylene.getFluid(288)});

// Ferrite Mixture Dust * 6
        NBTTagCompound nbt = new NBTTagCompound();
        ItemStack integratedCircuit = INTEGRATED_CIRCUIT.getStackForm();

        nbt.setInteger("Configuration", 2);
        integratedCircuit.setTagCompound(nbt);

        removeRecipesByInputs(MIXER_RECIPES, OreDictUnifier.get(dust, Nickel), OreDictUnifier.get(dust, Zinc), OreDictUnifier.get(dust, Iron, 4), integratedCircuit);
        removeRecipesByInputs(BLENDER_RECIPES, OreDictUnifier.get(dust, Nickel), OreDictUnifier.get(dust, Zinc), OreDictUnifier.get(dust, Iron, 4), integratedCircuit);

// Nickel Zinc Ferrite Ingot * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, FerriteMixture)}, new FluidStack[]{Oxygen.getFluid(2000)});

// Alumina Plate * 1
        removeRecipesByInputs(FLUID_SOLIDFICATION_RECIPES, new ItemStack[]{SHAPE_MOLD_PLATE.getStackForm()}, new FluidStack[]{Alumina.getFluid(144)});
// Alumina Plate * 1
        removeRecipesByInputs(COMPRESSOR_RECIPES, OreDictUnifier.get(dust, Alumina));

// Advanced SMD Transistor * 16
        removeRecipesByInputs(ASSEMBLER_RECIPES, new ItemStack[]{OreDictUnifier.get(foil, VanadiumGallium), OreDictUnifier.get(wireFine, HSSG)}, new FluidStack[]{Polybenzimidazole.getFluid(144)});


//SMD Diodes

//n-doped silicon

//platinum
//palladium
//molybdenum
//tungsten

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(SEED_CRYSTAL_ALUMINA)
                .circuitMeta(1)
                .fluidInputs(Alumina.getFluid(4608))
                .output(BOULE_ALUMINA)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(BOULE_ALUMINA)
                .output(SEED_CRYSTAL_ALUMINA)
                .output(WAFER_ALUMINA, 32)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        for (var fuel : sintering_fuels) {

            if (fuel.isPlasma) {

                SINTERING_RECIPES.recipeBuilder()
                        .input(dust, Alumina)
                        .notConsumable(SHAPE_MOLD_PLATE)
                        .fluidInputs(fuel.fluid)
                        .output(plate, Alumina)
                        .fluidOutputs(fuel.byproduct)
                        .duration(fuel.duration)
                        .EUt(240)
                        .buildAndRegister();

                SINTERING_RECIPES.recipeBuilder()
                        .input(dust, BerylliumOxide)
                        .notConsumable(SHAPE_MOLD_PLATE)
                        .fluidInputs(fuel.fluid)
                        .output(plate, BerylliumOxide)
                        .fluidOutputs(fuel.byproduct)
                        .duration(fuel.duration)
                        .EUt(240)
                        .buildAndRegister();

                SINTERING_RECIPES.recipeBuilder()
                        .input(dust, Tantalum)
                        .notConsumable(SHAPE_MOLD_NUGGET)
                        .fluidInputs(fuel.fluid)
                        .output(TANTALUM_CHIP, 32)
                        .fluidOutputs(fuel.byproduct)
                        .duration(fuel.duration)
                        .EUt(240)
                        .buildAndRegister();

            } else {

                for (var comburent : sintering_comburents) {

                    SINTERING_RECIPES.recipeBuilder()
                            .input(dust, Alumina)
                            .notConsumable(SHAPE_MOLD_PLATE)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .output(plate, Alumina)
                            .fluidOutputs(fuel.byproduct)
                            .duration(fuel.duration + comburent.duration)
                            .EUt(240)
                            .buildAndRegister();

                    SINTERING_RECIPES.recipeBuilder()
                            .input(dust, BerylliumOxide)
                            .notConsumable(SHAPE_MOLD_PLATE)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .output(plate, BerylliumOxide)
                            .fluidOutputs(fuel.byproduct)
                            .duration(fuel.duration + comburent.duration)
                            .EUt(240)
                            .buildAndRegister();

                    SINTERING_RECIPES.recipeBuilder()
                            .input(dust, Tantalum)
                            .notConsumable(SHAPE_MOLD_NUGGET)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .output(TANTALUM_CHIP, 32)
                            .fluidOutputs(fuel.byproduct)
                            .duration(fuel.duration + comburent.duration)
                            .EUt(240)
                            .buildAndRegister();
                }
            }
        }

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Alumina, 5)
                .fluidInputs(Glue.getFluid(500))
                .fluidOutputs(FerroelectricCeramicBinding.getFluid(1000))
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Rutile, 2)
                .fluidInputs(Glue.getFluid(500))
                .fluidOutputs(FerroelectricCeramicBinding.getFluid(2000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, BariumTitanate)
                .fluidInputs(Glue.getFluid(500))
                .fluidOutputs(FerroelectricCeramicBinding.getFluid(4000))
                .duration(20)
                .EUt(240)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_EXTRUDER_FOIL)
                .fluidInputs(FerroelectricCeramicBinding.getFluid(1000))
                .output(FERROELECTRIC_CERAMIC_FOIL, 5)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(FERROELECTRIC_CERAMIC_FOIL, 2)
                .input(foil, Aluminium, 2)
                .output(STACKED_CERAMIC_CAPACITOR)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(STACKED_CERAMIC_CAPACITOR)
                .output(RAW_CERAMIC_CAPACITOR, 16)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Lead)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, LeadOxide, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Nickel)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, NickelIIOxide, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Cobalt)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, CobaltOxide, 2)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Tantalum)
                .fluidInputs(Nitrogen.getFluid(1000))
                .output(dust, TantalumNitride, 2)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, LeadOxide, 2)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(CeramicThickFilmPaste.getFluid(1000))
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Nichrome, 2)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(CeramicThickFilmPaste.getFluid(2000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, TantalumNitride, 2)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(CeramicThickFilmPaste.getFluid(2000))
                .duration(150)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, RutheniumIVOxide)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(CeramicThickFilmPaste.getFluid(3000))
                .duration(120)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, BismuthIridate)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(CeramicThickFilmPaste.getFluid(4000))
                .duration(20)
                .EUt(240)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, BismuthIIIOxide, 5)
                .fluidInputs(SodiumHydroxideSolution.getFluid(6000))
                .fluidInputs(Chlorine.getFluid(4000))
                .output(dust, SodiumBismuthate, 10)
                .fluidOutputs(DilutedSaltwater.getFluid(8000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Iridium)
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, IridiumChloride, 4)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, SodiumBismuthate, 10)
                .input(dust, IridiumChloride, 8)
                .fluidInputs(SodiumHydroxideSolution.getFluid(2000))
                .output(dust, BismuthIridate, 11)
                .fluidOutputs(SaltWater.getFluid(1000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RAW_CERAMIC_CAPACITOR, 4)
                .input(wireFine, Tin, 2)
                .output(SMD_CAPACITOR, 4)
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RAW_CERAMIC_CAPACITOR, 4)
                .input(wireFine, Zinc, 2)
                .output(SMD_CAPACITOR, 4)
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(RAW_CERAMIC_CAPACITOR, 4)
                .input(wireFine, Aluminium)
                .output(SMD_CAPACITOR, 4)
                .duration(20)
                .EUt(240)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(Aluminium.getFluid(18))
                .input(foil, Polypropylene)
                .output(METALLIZED_PLASTIC_FILM)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(Zinc.getFluid(36))
                .input(foil, Polypropylene)
                .output(METALLIZED_PLASTIC_FILM)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(Aluminium.getFluid(18))
                .input(MYLAR)
                .output(METALLIZED_PLASTIC_FILM, 2)
                .duration(30)
                .EUt(240)
                .buildAndRegister();

        VACUUM_CHAMBER.recipeBuilder()
                .fluidInputs(Zinc.getFluid(36))
                .input(MYLAR)
                .output(METALLIZED_PLASTIC_FILM, 2)
                .duration(60)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(METALLIZED_PLASTIC_FILM)
                .output(METALLIZED_PLASTIC_SQUARE, 16)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(METALLIZED_PLASTIC_SQUARE, 4)
                .fluidInputs(Tin.getFluid(80))
                .output(RAW_SMD_CAPACITOR, 4)
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(METALLIZED_PLASTIC_SQUARE, 4)
                .fluidInputs(Zinc.getFluid(80))
                .output(RAW_SMD_CAPACITOR, 4)
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(METALLIZED_PLASTIC_SQUARE, 4)
                .fluidInputs(Aluminium.getFluid(40))
                .output(RAW_SMD_CAPACITOR, 4)
                .duration(20)
                .EUt(240)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(RAW_SMD_CAPACITOR, 16)
                .fluidInputs(Polydimethylsiloxane.getFluid(72))
                .output(SMD_CAPACITOR, 16)
                .duration(40)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_ALUMINA)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER)
                .duration(600)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_ALUMINA)
                .fluidInputs(PolyvinylChloride.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_ALUMINA)
                .fluidInputs(Polytetrafluoroethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 2)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_ALUMINA)
                .fluidInputs(Polybenzimidazole.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 3)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(plate, Alumina)
                .output(WAFER_ALUMINA)
                .duration(30)
                .EUt(240)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(BerylliumOxide.getFluid(36))
                .notConsumable(SHAPE_MOLD_BALL)
                .chancedOutput(SEED_CRYSTAL_BERYLLIUM_OXIDE, 1000, 1000)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .input(SEED_CRYSTAL_BERYLLIUM_OXIDE)
                .circuitMeta(1)
                .fluidInputs(BerylliumOxide.getFluid(3168))
                .output(BOULE_BERYLLIUM_OXIDE)
                .duration(400)
                .EUt(240)
                .buildAndRegister();


        CUTTER_RECIPES.recipeBuilder()
                .input(BOULE_BERYLLIUM_OXIDE)
                .output(SEED_CRYSTAL_BERYLLIUM_OXIDE)
                .output(WAFER_BERYLLIUM_OXIDE, 32)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(plate, BerylliumOxide)
                .output(WAFER_BERYLLIUM_OXIDE)
                .duration(30)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_BERYLLIUM_OXIDE)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 4)
                .duration(600)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_BERYLLIUM_OXIDE)
                .fluidInputs(PolyvinylChloride.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 4)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_BERYLLIUM_OXIDE)
                .fluidInputs(Polytetrafluoroethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 8)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_BERYLLIUM_OXIDE)
                .fluidInputs(Polybenzimidazole.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 12)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, StainlessSteel)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 2)
                .duration(600)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, StainlessSteel)
                .fluidInputs(PolyvinylChloride.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 2)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, StainlessSteel)
                .fluidInputs(Polytetrafluoroethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 4)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(plate, StainlessSteel)
                .fluidInputs(Polybenzimidazole.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 6)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_SILICON_DIOXIDE)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 2)
                .duration(600)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_SILICON_DIOXIDE)
                .fluidInputs(PolyvinylChloride.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 2)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_SILICON_DIOXIDE)
                .fluidInputs(Polytetrafluoroethylene.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 4)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_SILICON_DIOXIDE)
                .fluidInputs(Polybenzimidazole.getFluid(144))
                .output(THICK_FILM_SUBSTRATE_WAFER, 6)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(THICK_FILM_SUBSTRATE_WAFER)
                .output(PATTERNED_THICK_FILM_SUBSTRATE_WAFER)
                .duration(600)
                .EUt(240)
                .buildAndRegister();

        LASER_ENGRAVER_RECIPES.recipeBuilder()
                .input(THICK_FILM_SUBSTRATE_WAFER)
                .output(PATTERNED_THICK_FILM_SUBSTRATE_WAFER)
                .duration(50)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(PATTERNED_THICK_FILM_SUBSTRATE_WAFER)
                .fluidInputs(CeramicThickFilmPaste.getFluid(1000))
                .output(THICK_FILM_RESISTOR_WAFER)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(THICK_FILM_RESISTOR_WAFER)
                .output(SMD_RESISTOR, 16)
                .duration(300)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(foil, Aluminium, 2)
                .input(PAPER)
                .output(RAW_CAPACITOR_ROLL, 8)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .input(RAW_CAPACITOR_ROLL, 8)
                .input(dust, ManganeseDioxide, 1)
                .output(ALUMINIUM_ELECTROLYTIC_CAPACITOR, 8)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneGlycol.getFluid(1000))
                .input(dust, BoricAcid, 3)
                .fluidOutputs(BoraxElectrolyte.getFluid(1000))
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(RAW_CAPACITOR_ROLL, 16)
                .fluidInputs(BoraxElectrolyte.getFluid(100))
                .output(ALUMINIUM_ELECTROLYTIC_CAPACITOR, 16)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ALUMINIUM_ELECTROLYTIC_CAPACITOR, 16)
                .input(ring, Rubber, 4)
                .input(foil, Aluminium, 2)
                .output(SMD_CAPACITOR, 16)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ALUMINIUM_ELECTROLYTIC_CAPACITOR, 16)
                .input(ring, SiliconeRubber, 2)
                .input(foil, Aluminium, 2)
                .output(SMD_CAPACITOR, 16)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(ALUMINIUM_ELECTROLYTIC_CAPACITOR, 16)
                .input(ring, StyreneButadieneRubber, 1)
                .input(foil, Aluminium, 2)
                .output(SMD_CAPACITOR, 16)
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(TANTALUM_CHIP, 8)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(ANODIZED_TANTALUM_CHIP, 8)
                .duration(40)
                .EUt(240)
                .buildAndRegister();

        PYROLYSE_RECIPES.recipeBuilder()
                .input(ANODIZED_TANTALUM_CHIP, 8)
                .input(dust, ManganeseIINitrate)
                .output(MANGANIZED_TANTALUM_CHIP, 8)
                .duration(40)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(MANGANIZED_TANTALUM_CHIP, 8)
                .fluidInputs(Silver.getFluid(36))
                .output(SMD_CAPACITOR, 8)
                .duration(40)
                .EUt(240)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, PurifiedIronIIIOxide, 10)
                .input(dust, ZincOxide, 2)
                .input(dust, NickelIIOxide, 2)
                .output(ingot, NickelZincFerrite, 14)
                .blastFurnaceTemp(1200)
                .duration(300)
                .EUt(60)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, PurifiedIronIIIOxide, 10)
                .input(dust, ZincOxide, 2)
                .input(dust, ManganeseIIOxide, 2)
                .output(ingot, ManganeseZincFerrite, 14)
                .blastFurnaceTemp(1200)
                .duration(300)
                .EUt(60)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, PurifiedIronIIIOxide, 30)
                .input(dust, BariumCarbonate, 5)
                .output(ingot, BariumFerrite, 32)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .blastFurnaceTemp(1200)
                .duration(100)
                .EUt(60)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, PurifiedIronIIIOxide, 30)
                .input(dust, StrontiumCarbonate, 5)
                .output(ingot, StrontiumFerrite, 32)
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .blastFurnaceTemp(1200)
                .duration(100)
                .EUt(60)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(36))
                .input(ring, ManganeseZincFerrite)
                .input(wireFine, Copper, 2)
                .output(INDUCTOR, 4)
                .duration(320)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(36))
                .input(ring, ManganeseZincFerrite)
                .input(wireFine, AnnealedCopper, 2)
                .output(INDUCTOR, 8)
                .duration(320)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(ring, ManganeseZincFerrite)
                .input(wireFine, Cupronickel, 4)
                .output(SMD_INDUCTOR, 8)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(ring, NickelZincFerrite)
                .input(wireFine, Cupronickel, 4)
                .output(SMD_INDUCTOR, 8)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(ring, CobaltFerrite)
                .input(wireFine, Cupronickel, 4)
                .output(SMD_INDUCTOR, 12)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(ring, BariumFerrite)
                .input(wireFine, Cupronickel, 4)
                .output(SMD_INDUCTOR, 16)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(ring, StrontiumFerrite)
                .input(wireFine, Cupronickel, 4)
                .output(SMD_INDUCTOR, 20)
                .duration(40)
                .EUt(240)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(SILICON_WAFER)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(WAFER_SILICON_DIOXIDE)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(SILICON_WAFER)
                .fluidInputs(ZirconiumTetrachloride.getFluid(180))
                .fluidInputs(Water.getFluid(500))
                .output(WAFER_INSULATED_SILICON)
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(WAFER_SILICON_GERMANIUM)
                .fluidInputs(ZirconiumTetrachloride.getFluid(180))
                .fluidInputs(Water.getFluid(500))
                .output(WAFER_INSULATED_SILICON_GERMANIUM)
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(80)
                .EUt(240)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(WAFER_N_DOPED_SILICON)
                .fluidInputs(UltrapureWater.getFluid(100))
                .output(CHIP_N_DOPED_SILICON, 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(WAFER_SILICON_DIOXIDE)
                .fluidInputs(UltrapureWater.getFluid(100))
                .output(CHIP_SILICON_DIOXIDE, 16)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(500)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(WAFER_INSULATED_SILICON)
                .fluidInputs(UltrapureWater.getFluid(100))
                .output(CHIP_INSULATED_SILICON, 24)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .input(WAFER_INSULATED_SILICON_GERMANIUM)
                .fluidInputs(UltrapureWater.getFluid(100))
                .output(CHIP_INSULATED_SILICON_GERMANIUM, 32)
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON_GERMANIUM, 8)
                .input(wireFine, Copper, 2)
                .output(SMD_TRANSISTOR, 8)
                .duration(300)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON_GERMANIUM, 8)
                .input(wireFine, Aluminium, 2)
                .output(SMD_TRANSISTOR, 10)
                .duration(250)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON_GERMANIUM, 8)
                .input(wireFine, Tantalum, 2)
                .output(SMD_TRANSISTOR, 12)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON_GERMANIUM, 8)
                .input(wireFine, Platinum, 2)
                .output(SMD_TRANSISTOR, 12)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON_GERMANIUM, 8)
                .input(wireFine, Titanium, 2)
                .output(SMD_TRANSISTOR, 16)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON_GERMANIUM, 8)
                .input(wireFine, Tungsten, 2)
                .output(SMD_TRANSISTOR, 20)
                .duration(50)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON, 8)
                .input(wireFine, Copper, 2)
                .output(SMD_TRANSISTOR, 8)
                .duration(300)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON, 8)
                .input(wireFine, Aluminium, 2)
                .output(SMD_TRANSISTOR, 10)
                .duration(250)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON, 8)
                .input(wireFine, Tantalum, 2)
                .output(SMD_TRANSISTOR, 12)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON, 8)
                .input(wireFine, Platinum, 2)
                .output(SMD_TRANSISTOR, 12)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON, 8)
                .input(wireFine, Titanium, 2)
                .output(SMD_TRANSISTOR, 16)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_INSULATED_SILICON, 8)
                .input(wireFine, Tungsten, 2)
                .output(SMD_TRANSISTOR, 20)
                .duration(50)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_SILICON_DIOXIDE, 8)
                .input(wireFine, Copper, 2)
                .output(SMD_TRANSISTOR, 8)
                .duration(300)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_SILICON_DIOXIDE, 8)
                .input(wireFine, Aluminium, 2)
                .output(SMD_TRANSISTOR, 10)
                .duration(250)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_SILICON_DIOXIDE, 8)
                .input(wireFine, Tantalum, 2)
                .output(SMD_TRANSISTOR, 12)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_SILICON_DIOXIDE, 8)
                .input(wireFine, Platinum, 2)
                .output(SMD_TRANSISTOR, 12)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_SILICON_DIOXIDE, 8)
                .input(wireFine, Titanium, 2)
                .output(SMD_TRANSISTOR, 16)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_SILICON_DIOXIDE, 8)
                .input(wireFine, Tungsten, 2)
                .output(SMD_TRANSISTOR, 20)
                .duration(50)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Platinum)
                .input(wireGtSingle, Copper)
                .output(SMD_DIODE, 16)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Molybdenum)
                .input(wireGtSingle, Copper)
                .output(SMD_DIODE, 16)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Palladium)
                .input(wireGtSingle, Copper)
                .output(SMD_DIODE, 32)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Tungsten)
                .input(wireGtSingle, Copper)
                .output(SMD_DIODE, 32)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Platinum)
                .input(wireGtSingle, AnnealedCopper)
                .output(SMD_DIODE, 16)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Molybdenum)
                .input(wireGtSingle, AnnealedCopper)
                .output(SMD_DIODE, 16)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Palladium)
                .input(wireGtSingle, AnnealedCopper)
                .output(SMD_DIODE, 32)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Tungsten)
                .input(wireGtSingle, AnnealedCopper)
                .output(SMD_DIODE, 32)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Gold)
                .input(wireGtSingle, AnnealedCopper)
                .output(SMD_DIODE, 12)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .fluidInputs(Polyethylene.getFluid(144))
                .input(CHIP_N_DOPED_SILICON, 8)
                .input(foil, Gold)
                .input(wireGtSingle, Copper)
                .output(SMD_DIODE, 12)
                .duration(400)
                .EUt(240)
                .buildAndRegister();

        CRYSTALLIZER_RECIPES.recipeBuilder()
                .fluidInputs(HighPuritySilicon.getFluid(2304))
                .fluidInputs(HighPurityGermanium.getFluid(2304))
                .input(SEED_CRYSTAL_SILICON)
                .output(BOULE_SILICON_GERMANIUM)
                .duration(9000)
                .EUt(120)
                .buildAndRegister();

        CUTTER_RECIPES.recipeBuilder()
                .fluidInputs(UltrapureWater.getFluid(100))
                .input(BOULE_SILICON_GERMANIUM)
                .output(WAFER_SILICON_GERMANIUM, 16)
                .output(SEED_CRYSTAL_SILICON)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(400)
                .EUt(64)
                .buildAndRegister();
    }
}
