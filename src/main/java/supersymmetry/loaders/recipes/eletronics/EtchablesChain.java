package supersymmetry.loaders.recipes.eletronics;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.metatileentity.multiblock.CleanroomType;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class EtchablesChain {
    private static class Photoresist {
        public Material fluidName;
        public int amountUsed;
        public int timeUsed;
        public Photoresist(Material fluidName, int amountUsed, int timeUsed) {
            this.fluidName = fluidName;
            this.amountUsed = amountUsed;
            this.timeUsed = timeUsed;
        }
    }

    private static class Etchant {
        public Material fluidName;
        public Material materialEtched;
        public int amountUsed;
        public int timeUsed;
        public boolean isPlasma;
        public Etchant(Material fluidName, Material materialEtched, int amountUsed, int timeUsed, boolean isPlasma) {
            this.fluidName = fluidName;
            this.materialEtched = materialEtched;
            this.amountUsed = amountUsed;
            this.timeUsed = timeUsed;
            this.isPlasma = isPlasma;
        }
    }

    private static class PDopant {
        public ItemStack metaItemName;
        public int efficiency;
        public PDopant(ItemStack metaItemName, int efficiency) {
            this.metaItemName = metaItemName;
            this.efficiency = efficiency;
        }
    }

    private static class NDopant {
        public ItemStack metaItemName;
        public int efficiency;
        public NDopant(ItemStack metaItemName, int efficiency) {
            this.metaItemName = metaItemName;
            this.efficiency = efficiency;
        }
    }
    private static final Photoresist[] photoresists = {
            new Photoresist(Novolacs, 50, 300),
            new Photoresist(HydrogenSilsesquioxanePhotoresist, 25, 200),
            new Photoresist(PMMA, 16, 150),
            new Photoresist(SuEight, 16, 50),
    };
    private static final Etchant[] etchants = {
            new Etchant(Chlorine, Aluminium, 10, 80, true),
            new Etchant(CarbonTetrafluoride, Aluminium, 10, 60, true),
            new Etchant(BoronTrichloride, Aluminium, 10, 60, true),
            new Etchant(Chlorine, GalliumArsenide, 10, 80, true),
            new Etchant(CarbonTetrafluoride, GalliumArsenide, 10, 60, true),
            new Etchant(BoronTrichloride, GalliumArsenide, 10, 60, true),
            //        new Etchant(Oxygen, Photoresist, 10, 60, true),
            new Etchant(Chlorine, Silicon, 10, 80, true),
            new Etchant(CarbonTetrafluoride, Silicon, 10, 60, true),
            new Etchant(CarbonTetrafluoride, SiliconDioxide, 10, 60, true),
            new Etchant(NitrogenTrifluoride, SiliconDioxide, 10, 60, true),
//            new Etchant(CarbonTetrafluoride, SiliconNitride, 10, 60, true),
//            new Etchant(NitrogenTrifluoride, SiliconNitride, 10, 60, true),
            new Etchant(BoronTrichloride, Titanium, 10, 60, true),
            new Etchant(BoronTrichloride, Nickel, 10, 60, true),
            new Etchant(CarbonTetrafluoride, Tungsten, 10, 60, true),

            new Etchant(IronIIIChlorideSolution, Copper, 100, 100, false),
            new Etchant(SodiumBisulfateSolution, Copper, 100, 100, false),

            new Etchant(EthylenediaminePyrocatechol, Silicon, 40, 80, false),
            new Etchant(TetramethylammoniumHydroxideSolution, Silicon, 40, 80, false),
            //        new Etchant(EthylenediaminePyrocatechol, SiliconAdvanced, 40, 80, false),
            //        new Etchant(TetramethylammoniumHydroxideSolution, SiliconAdvanced, 40, 80, false),
            new Etchant(PhosphoricAcid, Aluminium, 50, 700, false),
            //        new Etchant(NitrationMixture, IndiumTinOxide, 50, 700, false),
            new Etchant(HydrochloricAcid, Chrome, 50, 700, false),
            new Etchant(HydrogenPeroxide, GalliumArsenide, 50, 700, false),
            new Etchant(AquaRegia, Gold, 50, 700, false),
            new Etchant(AquaRegia, Platinum, 50, 700, false),
            //        new Etchant(HydrogenPeroxide, Photoresist, 50, 500, false),
            new Etchant(HydrofluoricAcid, SiliconDioxide, 40, 600, false),
//            new Etchant(PhosphoricAcid, SiliconNitride, 40, 600, false),
            new Etchant(HydrofluoricAcid, Titanium, 50, 700, false),
            new Etchant(HydrofluoricAcid, Nickel, 50, 700, false),
            new Etchant(HydrogenPeroxide, Tungsten, 50, 700, false),
//            new Etchant(NitricAcid, TitaniumNitride, 50, 700, false),
//            new Etchant(HydrofluoricAcid, TitaniumNitride, 50, 700, false),
            new Etchant(NitricAcid, Silicon, 80, 700, false),
            new Etchant(HydrofluoricAcid, Silicon, 40, 500, false),
    };
    private static final NDopant[] nDopants = {
            new NDopant(OreDictUnifier.get(dust, HighPurityBoron), 1),
            new NDopant(OreDictUnifier.get(dust, HighPurityGallium), 2),
            new NDopant(OreDictUnifier.get(dust, HighPurityAluminium), 2),
            new NDopant(OreDictUnifier.get(dustTiny, HighPurityIndium), 1)
    };
    private static final PDopant[] pDopants = {
            new PDopant(OreDictUnifier.get(dust, HighPurityAntimony), 1),
            new PDopant(OreDictUnifier.get(dust, HighPurityPhosphorus), 2),
            new PDopant(OreDictUnifier.get(dust, HighPurityArsenic), 2)
    };
    public static void generatePatterningRecipes(MetaItem.MetaValueItem  input, MetaItem.MetaValueItem  product, ItemStack mask, int voltageTier, int timeMultiplier, int outputMultiplier, int circ, boolean cleanroom) {
        for (Photoresist photoresist : photoresists) {
            if (cleanroom) {
                UV_RECIPES.recipeBuilder()
                        .input(input)
                        .notConsumable(mask)
                        .fluidInputs(photoresist.fluidName.getFluid(photoresist.amountUsed))
                        .output(product, outputMultiplier)
                        .duration(photoresist.timeUsed * timeMultiplier)
                        .cleanroom(CleanroomType.CLEANROOM)
                        .EUt(voltageTier)
                        .buildAndRegister();

                LASER_ENGRAVER_RECIPES.recipeBuilder()
                        .input(input)
                        .circuitMeta(circ)
                        .fluidInputs(photoresist.fluidName.getFluid(photoresist.amountUsed / 4))
                        .output(product, outputMultiplier)
                        .duration(photoresist.timeUsed * timeMultiplier / 10)
                        .cleanroom(CleanroomType.CLEANROOM)
                        .EUt(voltageTier)
                        .buildAndRegister();
            } else {
                UV_RECIPES.recipeBuilder()
                        .input(input)
                        .notConsumable(mask)
                        .fluidInputs(photoresist.fluidName.getFluid(photoresist.amountUsed))
                        .output(product, outputMultiplier)
                        .duration(photoresist.timeUsed * timeMultiplier)
                        .EUt(voltageTier)
                        .buildAndRegister();

                LASER_ENGRAVER_RECIPES.recipeBuilder()
                        .input(input)
                        .circuitMeta(circ)
                        .fluidInputs(photoresist.fluidName.getFluid(photoresist.amountUsed / 4))
                        .output(product, outputMultiplier)
                        .duration(photoresist.timeUsed * timeMultiplier / 10)
                        .EUt(voltageTier)
                        .buildAndRegister();
            }
        }
    }
    private static void generateEtchingRecipes(MetaItem.MetaValueItem  input, MetaItem.MetaValueItem  product, Material materialEtched, int voltageTier, int timeMultiplier, boolean cleanroom) {
        for (Etchant etchant : etchants) {
            if (etchant.materialEtched == materialEtched) {
                if (cleanroom) {
                    CHEMICAL_BATH_RECIPES.recipeBuilder()
                            .input(input)
                            .fluidInputs(etchant.fluidName.getFluid(etchant.amountUsed))
                            .output(product)
                            .duration(etchant.timeUsed * timeMultiplier)
                            .cleanroom(CleanroomType.CLEANROOM)
                            .EUt(voltageTier)
                            .buildAndRegister();
                } else {
                    CHEMICAL_BATH_RECIPES.recipeBuilder()
                            .input(input)
                            .fluidInputs(etchant.fluidName.getFluid(etchant.amountUsed))
                            .output(product)
                            .duration(etchant.timeUsed * timeMultiplier)
                            .EUt(voltageTier)
                            .buildAndRegister();
                }
            }
        }
    }
    private static void generateCuttingRecipes(MetaItem.MetaValueItem input, MetaItem.MetaValueItem  product, int productMultiplier, int voltageTier, boolean cleanroom) {
        if (cleanroom) {
            CUTTER_RECIPES.recipeBuilder()
                    .fluidInputs(UltrapureWater.getFluid(100))
                    .input(input)
                    .output(product, productMultiplier)
                    .duration(450)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .EUt(voltageTier)
                    .buildAndRegister();

            LASER_ENGRAVER_RECIPES.recipeBuilder()
                    .input(input)
                    .output(product, productMultiplier)
                    .duration(60)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .EUt(voltageTier)
                    .buildAndRegister();
        } else {
            CUTTER_RECIPES.recipeBuilder()
                    .fluidInputs(UltrapureWater.getFluid(100))
                    .input(input)
                    .output(product, productMultiplier)
                    .duration(450)
                    .EUt(voltageTier)
                    .buildAndRegister();

            LASER_ENGRAVER_RECIPES.recipeBuilder()
                    .input(input)
                    .output(product, productMultiplier)
                    .duration(60)
                    .EUt(voltageTier)
                    .buildAndRegister();
        }
    }
    public static void init() {
        //REMOVALS

// CPU * 8
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[] {CENTRAL_PROCESSING_UNIT_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[] {CENTRAL_PROCESSING_UNIT_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[] {CENTRAL_PROCESSING_UNIT_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});
// RAM * 32
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{RANDOM_ACCESS_MEMORY_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{RANDOM_ACCESS_MEMORY_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{RANDOM_ACCESS_MEMORY_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});
// ULPIC * 6
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});
// LPIC * 4
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{LOW_POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{LOW_POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{LOW_POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});
// Integrated Circuit * 8
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{INTEGRATED_LOGIC_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{INTEGRATED_LOGIC_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{INTEGRATED_LOGIC_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});
// PIC * 4
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{POWER_INTEGRATED_CIRCUIT_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});
// NAND * 32
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{NAND_MEMORY_CHIP_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{NAND_MEMORY_CHIP_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{NAND_MEMORY_CHIP_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});
// NOR * 16
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{NOR_MEMORY_CHIP_WAFER.getStackForm()}, new FluidStack[]{Lubricant.getFluid(84)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{NOR_MEMORY_CHIP_WAFER.getStackForm()}, new FluidStack[]{DistilledWater.getFluid(253)});
        removeRecipesByInputs(CUTTER_RECIPES, new ItemStack[]{NOR_MEMORY_CHIP_WAFER.getStackForm()}, new FluidStack[]{Water.getFluid(337)});

        MIXER_RECIPES.recipeBuilder()
                .input(dustTiny, PotassiumHydroxide)
                .input(dust, SiliconDioxide, 30)
                .fluidInputs(DemineralizedWater.getFluid(10000))
                .fluidOutputs(SiliconDioxideSlurry.getFluid(10000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

//NOVOLACS

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Formaldehyde.getFluid(50))
                .fluidInputs(Phenol.getFluid(50))
                .fluidOutputs(Novolacs.getFluid(100))
                .duration(10)
                .EUt(7)
                .buildAndRegister();

//DOPING

        for (NDopant ndopant : nDopants) {
            ION_IMPLANTATION_RECIPES.recipeBuilder()
                    .input(SILICON_WAFER, 16 * ndopant.efficiency)
                    .circuitMeta(1)
                    .inputs(ndopant.metaItemName)
                    .output(WAFER_N_DOPED_SILICON, 16 * ndopant.efficiency)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(300)
                    .EUt(60)
                    .buildAndRegister();

            ION_IMPLANTATION_RECIPES.recipeBuilder()
                    .input(ETCHED_SILICON_DIOXIDE, 16 * ndopant.efficiency)
                    .circuitMeta(1)
                    .inputs(ndopant.metaItemName)
                    .output(WAFER_DOPED_SILICON_DIOXIDE, 16 * ndopant.efficiency)
                    .cleanroom(CleanroomType.CLEANROOM)
                    .duration(300)
                    .EUt(240)
                    .buildAndRegister();

            for (PDopant pdopant : pDopants) {
                int batchSize = pdopant.efficiency * ndopant.efficiency;

                ION_IMPLANTATION_RECIPES.recipeBuilder()
                        .input(SILICON_WAFER, 16 * batchSize)
                        .inputs(pdopant.metaItemName)
                        .inputs(ndopant.metaItemName)
                        .output(WAFER_DOPED_SILICON, 16 * batchSize)
                        .duration(200)
                        .EUt(60)
                        .buildAndRegister();

                ION_IMPLANTATION_RECIPES.recipeBuilder()
                        .input(ETCHED_POLYSILICON, 16 * batchSize)
                        .inputs(pdopant.metaItemName)
                        .inputs(ndopant.metaItemName)
                        .output(WAFER_DOPED_POLYSILICON, 16 * batchSize)
                        .cleanroom(CleanroomType.CLEANROOM)
                        .duration(200)
                        .EUt(240)
                        .buildAndRegister();
            }
        }

//WAFERS


        generatePatterningRecipes(SILICON_WAFER, PATTERNED_RAM, MASK_RAM.getStackForm(), 120, 4, 1, 1, false);
        generatePatterningRecipes(SILICON_WAFER, PATTERNED_ULPIC, MASK_ULPIC.getStackForm(), 120, 4, 1, 2, false);
        generatePatterningRecipes(SILICON_WAFER, PATTERNED_IC, MASK_IC.getStackForm(), 120, 4, 1, 3, false);

        generatePatterningRecipes(WAFER_DOPED_SILICON, PATTERNED_RAM, MASK_RAM.getStackForm(), 120, 4, 2, 1, false);
        generatePatterningRecipes(WAFER_DOPED_SILICON, PATTERNED_CPU, MASK_CPU.getStackForm(), 120, 4, 1, 2, false);
        generatePatterningRecipes(WAFER_DOPED_SILICON, PATTERNED_ULPIC, MASK_ULPIC.getStackForm(), 120, 4, 2, 3, false);
        generatePatterningRecipes(WAFER_DOPED_SILICON, PATTERNED_LPIC, MASK_LPIC.getStackForm(), 3, 4, 1, 4, false);
        generatePatterningRecipes(WAFER_DOPED_SILICON, PATTERNED_IC, MASK_IC.getStackForm(), 120, 4, 2, 5, false);

        generatePatterningRecipes(WAFER_SILICON_DIOXIDE, PATTERNED_SILICON_DIOXIDE, MASK_ADVANCED.getStackForm(), 480, 4, 1, 1, true);
        generatePatterningRecipes(WAFER_POLYSILICON, PATTERNED_POLYSILICON, MASK_ADVANCED.getStackForm(), 480, 4, 1, 1, true);
        generatePatterningRecipes(WAFER_SILICON_NITRIDE, PATTERNED_SILICON_NITRIDE, MASK_ADVANCED.getStackForm(), 480, 4, 1, 1, true);
        generatePatterningRecipes(WAFER_NICKEL, PATTERNED_NAND, MASK_NAND.getStackForm(), 480, 4, 1, 1, true);
        generatePatterningRecipes(WAFER_NICKEL, PATTERNED_NOR, MASK_NOR.getStackForm(), 480, 4, 1, 2, true);

        generateEtchingRecipes(PATTERNED_IC, ETCHED_IC, Silicon, 30, 1, false);
        generateEtchingRecipes(PATTERNED_CPU, ETCHED_CPU, Silicon, 30, 1,false);
        generateEtchingRecipes(PATTERNED_RAM, ETCHED_RAM, Silicon, 30, 1, false);
        generateEtchingRecipes(PATTERNED_ULPIC, ETCHED_ULPIC, Silicon, 30, 1, false);
        generateEtchingRecipes(PATTERNED_LPIC, ETCHED_LPIC, Silicon, 30, 1, false);

        generateEtchingRecipes(PATTERNED_SILICON_DIOXIDE, ETCHED_SILICON_DIOXIDE, SiliconDioxide, 120, 1, true);
        generateEtchingRecipes(PATTERNED_POLYSILICON, ETCHED_POLYSILICON, Silicon, 120, 1, true);
//        generateEtchingRecipes(PATTERNED_SILICON_NITRIDE, ETCHED_SILICON_NITRIDE, SiliconNitride, 120, 1, true);
        generateEtchingRecipes(PATTERNED_NAND, NAND_MEMORY_CHIP_WAFER, Nickel, 120, 1, true);
        generateEtchingRecipes(PATTERNED_NOR, NOR_MEMORY_CHIP_WAFER, Nickel, 120, 1, true);

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(ETCHED_IC)
                .input(foil, Copper)
                .fluidInputs(SulfuricAcid.getFluid(100))
                .output(INTEGRATED_LOGIC_CIRCUIT_WAFER)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(ETCHED_CPU)
                .input(foil, Copper)
                .fluidInputs(SulfuricAcid.getFluid(100))
                .output(CENTRAL_PROCESSING_UNIT_WAFER)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(ETCHED_RAM)
                .input(foil, Copper)
                .fluidInputs(SulfuricAcid.getFluid(100))
                .output(RANDOM_ACCESS_MEMORY_WAFER)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(ETCHED_ULPIC)
                .input(foil, Copper)
                .fluidInputs(SulfuricAcid.getFluid(100))
                .output(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .input(ETCHED_LPIC)
                .input(foil, Copper)
                .fluidInputs(SulfuricAcid.getFluid(100))
                .output(LOW_POWER_INTEGRATED_CIRCUIT_WAFER)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        generateCuttingRecipes(CENTRAL_PROCESSING_UNIT_WAFER, CENTRAL_PROCESSING_UNIT, 8, 120, false);
        generateCuttingRecipes(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT_WAFER, ULTRA_LOW_POWER_INTEGRATED_CIRCUIT, 6, 120, false);
        generateCuttingRecipes(INTEGRATED_LOGIC_CIRCUIT_WAFER, INTEGRATED_LOGIC_CIRCUIT, 8, 120, false);
        generateCuttingRecipes(RANDOM_ACCESS_MEMORY_WAFER, RANDOM_ACCESS_MEMORY, 32, 120, false);
        generateCuttingRecipes(LOW_POWER_INTEGRATED_CIRCUIT_WAFER, LOW_POWER_INTEGRATED_CIRCUIT, 4, 480, true);
        generateCuttingRecipes(POWER_INTEGRATED_CIRCUIT_WAFER, POWER_INTEGRATED_CIRCUIT, 4, 1920, true);
        generateCuttingRecipes(NAND_MEMORY_CHIP_WAFER, NAND_MEMORY_CHIP, 32, 480, true);
        generateCuttingRecipes(NOR_MEMORY_CHIP_WAFER, NOR_MEMORY_CHIP, 16, 480, true);//PHENOLIC BOARD (TIER 2)

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(PHENOLIC_BOARD)
                .input(foil, Copper)
                .output(LAMINATED_BOARD_PHENOLIC)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        generatePatterningRecipes(LAMINATED_BOARD_PHENOLIC, PATTERNED_BOARD_PHENOLIC, MASK_PCB.getStackForm(), 30, 1, 1, 0, false);
        generateEtchingRecipes(PATTERNED_BOARD_PHENOLIC, GOOD_CIRCUIT_BOARD, Copper, 30, 1, false);

//PLASTIC CIRCUIT BOARD (TIER 3)

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, Polyethylene)
                .input(foil, Copper)
                .output(PLASTIC_BOARD)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, PolyvinylChloride)
                .input(foil, Copper)
                .output(PLASTIC_BOARD, 2)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, Polytetrafluoroethylene)
                .input(foil, Copper)
                .output(PLASTIC_BOARD, 4)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(plate, Polybenzimidazole)
                .input(foil, Copper)
                .output(PLASTIC_BOARD, 8)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        generatePatterningRecipes(PLASTIC_BOARD, PATTERNED_BOARD_PLASTIC, MASK_PCB.getStackForm(), 120, 1, 1, 0, false);
        generateEtchingRecipes(PATTERNED_BOARD_PLASTIC, PLASTIC_CIRCUIT_BOARD, Copper, 480, 1, false);

//NAND AND NOR

        CVD_RECIPES.recipeBuilder()
                .input(WAFER_DOPED_SILICON_DIOXIDE)
                .fluidInputs(Silane.getFluid(250))
                .output(WAFER_POLYSILICON)
                .fluidOutputs(Hydrogen.getFluid(1000))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(100)
                .EUt(240)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(WAFER_DOPED_POLYSILICON)
                .fluidInputs(Silane.getFluid(750))
                .fluidInputs(Ammonia.getFluid(1000))
                .output(WAFER_SILICON_NITRIDE)
                .fluidOutputs(Hydrogen.getFluid(3000))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        CVD_RECIPES.recipeBuilder()
                .input(ETCHED_SILICON_NITRIDE)
                .fluidInputs(NickelCarbonyl.getFluid(500))
                .output(WAFER_NICKEL)
                .fluidOutputs(CarbonMonoxide.getFluid(2000))
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

//PIC

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_DOPED_POLYSILICON)
                .input(WAFER_ALUMINA)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(WAFER_DOPED_POLYSILICON)
                .input(WAFER_BERYLLIUM_OXIDE)
                .output(POWER_INTEGRATED_CIRCUIT_WAFER)
                .cleanroom(CleanroomType.CLEANROOM)
                .duration(200)
                .EUt(120)
                .buildAndRegister();
    }
}
