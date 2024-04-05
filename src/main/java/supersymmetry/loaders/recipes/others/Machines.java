package supersymmetry.loaders.recipes.others;

import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.*;
import gregtech.common.blocks.wood.BlockGregPlanks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import supersymmetry.common.blocks.*;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.ASSEMBLER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.FORMING_PRESS_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.BlockSteamCasing.SteamCasingType.*;
import static gregtech.common.blocks.MetaBlocks.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.loaders.recipe.CraftingComponent.PUMP;
import static gregtech.loaders.recipe.CraftingComponent.HULL;
import static gregtech.loaders.recipe.CraftingComponent.PISTON;
import static gregtech.loaders.recipe.CraftingComponent.GLASS;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;
import static net.minecraft.init.Blocks.*;
import static supersymmetry.common.blocks.SuSyBlocks.*;
import static supersymmetry.common.blocks.SuSyBlocks.TURBINE_ROTOR;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.SiliconCarbide;
import static supersymmetry.common.materials.SusyMaterials.Stannite;
import static supersymmetry.common.metatileentities.SuSyMetaTileEntities.*;
import static supersymmetry.loaders.recipes.SuSyCraftingComponent.*;
import static supersymmetry.loaders.recipes.Utils.getConfiguration;

public class Machines {
    public static void init() {
        // Steam machines
        ModHandler.addShapedRecipe(true, "susy:vulcanizing_press_bronze",
                STEAM_VULCANIZING_PRESS[0].getStackForm(), "SKS", "PTP", "PMP",
                'S', new UnificationEntry(springSmall, Steel),
                'K', new UnificationEntry(stick, Steel),
                'T', new UnificationEntry(plate, Steel),
                'P', new UnificationEntry(pipeSmallFluid, Bronze),
                'M', STEAM_CASING.getItemVariant(BRONZE_BRICKS_HULL));

        ModHandler.addShapedRecipe(true, "susy:vulcanizing_press_steel",
                STEAM_VULCANIZING_PRESS[1].getStackForm(), "XXX", "PTP", "PMP",
                'X', new UnificationEntry(plate, WroughtIron),
                'T', new UnificationEntry(plate, Steel),
                'P', new UnificationEntry(pipeSmallFluid, TinAlloy),
                'M', STEAM_VULCANIZING_PRESS[0].getStackForm());

        ModHandler.addShapedRecipe(true, "susy:roaster_bronze",
                STEAM_ROASTER[0].getStackForm(), "PRP", "PMP", "PFP",
                'R', new UnificationEntry(rotor, Bronze),
                'P', new UnificationEntry(pipeSmallFluid, Bronze),
                'M', STEAM_CASING.getItemVariant(BRONZE_BRICKS_HULL),
                'F', new ItemStack(FURNACE));

        ModHandler.addShapedRecipe(true, "susy:roaster_steel",
                STEAM_ROASTER[1].getStackForm(), "PXP", "PMP", "PTP",
                'X', new UnificationEntry(plate, WroughtIron),
                'T', new UnificationEntry(plate, Steel),
                'P', new UnificationEntry(pipeSmallFluid, TinAlloy),
                'M', STEAM_ROASTER[0].getStackForm());

        ModHandler.addShapedRecipe(true, "susy:latex_collector_bronze",
                STEAM_LATEX_COLLECTOR[0].getStackForm(), " D ", "GRG", "PMP",
                'D', new UnificationEntry(toolHeadDrill, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'G', "blockGlass",
                'P', new UnificationEntry(pipeSmallFluid, Bronze),
                'M', STEAM_CASING.getItemVariant(BRONZE_HULL));

        ModHandler.addShapedRecipe(true, "susy:latex_collector_steel",
                STEAM_LATEX_COLLECTOR[1].getStackForm(), " X ", "XMX", "PTP",
                'X', new UnificationEntry(plate, WroughtIron),
                'T', new UnificationEntry(plate, Steel),
                'P', new UnificationEntry(pipeSmallFluid, TinAlloy),
                'M', STEAM_LATEX_COLLECTOR[0].getStackForm());

        ModHandler.addShapedRecipe(true, "susy:mixer_bronze",
                STEAM_MIXER[0].getStackForm(), "GRG", "GSG", "PMP",
                'R', new UnificationEntry(rotor, Bronze),
                'S', new UnificationEntry(stick, Bronze),
                'G', "blockGlass",
                'P', new UnificationEntry(pipeSmallFluid, Bronze),
                'M', STEAM_CASING.getItemVariant(BRONZE_HULL));

        ModHandler.addShapedRecipe(true, "susy:mixer_steel",
                STEAM_MIXER[1].getStackForm(), "XTX", "XTX", "PMP",
                'X', new UnificationEntry(plate, WroughtIron),
                'T', new UnificationEntry(plate, Steel),
                'P', new UnificationEntry(pipeSmallFluid, TinAlloy),
                'M', STEAM_MIXER[0].getStackForm());

        ModHandler.addShapedRecipe(true, "susy:vulcanizing_press_bronze",
                STEAM_VULCANIZING_PRESS[0].getStackForm(), "GSG", "PTP", "PHP",
                'G', new UnificationEntry(springSmall, Steel),
                'S', new UnificationEntry(stick, Steel),
                'T', new UnificationEntry(plate, Steel),
                'P', new UnificationEntry(pipeSmallFluid, Bronze),
                'H', STEAM_CASING.getItemVariant(BRONZE_BRICKS_HULL));

        ModHandler.addShapedRecipe(true, "susy:vulcanizing_press_steel",
                STEAM_VULCANIZING_PRESS[1].getStackForm(), "TTT", "PXP", "PHP",
                'X', new UnificationEntry(plate, WroughtIron),
                'T', new UnificationEntry(plate, Steel),
                'P', new UnificationEntry(pipeSmallFluid, TinAlloy),
                'H', STEAM_VULCANIZING_PRESS[0].getStackForm());

        /*
        */

        // electric machines
        registerMachineRecipe(VULCANIZING_PRESS, "UPU", "LML", "UCU",
                'M', HULL,
                'P', PISTON,
                'C', CIRCUIT,
                'U', CABLE,
                'L', COIL_HEATING_DOUBLE);

        registerMachineRecipe(ROASTER, "CRC", "UMU", "WUW",
                'M', HULL,
                'R', ROTOR,
                'C', CIRCUIT,
                'U', CABLE,
                'W', WIRE_ELECTRIC);

        registerMachineRecipe(LATEX_COLLECTOR, "CDC", "GFG", "UMU",
                'M', HULL,
                'C', CIRCUIT,
                'U', CABLE,
                'F', PUMP,
                'G', GLASS,
                'D', TOOL_HEAD_DRILL);

        registerMachineRecipe(ARC_FURNACE, "WGW", "CMC", "PPP",
                'M', HULL,
                'P', PLATE,
                'C', CIRCUIT,
                'W', CABLE_QUAD,
                'G', GRAPHITE_ELECTRODE);

        registerMachineRecipe(TRICKLE_BED_REACTOR, "UFU", "PMP", "CFC",
                'U', CABLE,
                'P', PIPE_NORMAL,
                'M', HULL,
                'C', CIRCUIT,
                'F', PUMP);

        registerMachineRecipe(CRYSTALLIZER, "TGT", "HMH", "CFC",
                'T', PLATE,
                'G', GLASS,
                'M', HULL,
                'C', CIRCUIT,
                'F', PUMP,
                'H', CHEMICAL_PARTS);

        registerMachineRecipe(FIXED_BED_REACTOR, " C ", "PFP", "UMU",
                'M', HULL,
                'C', CIRCUIT,
                'F', PUMP,
                'P', PIPE_NORMAL,
                'U', CABLE);

        registerMachineRecipe(BUBBLE_COLUMN_REACTOR, "HPH", "UFU", "CMC",
                'P', PIPE_NORMAL,
                'M', HULL,
                'C', CIRCUIT,
                'F', PUMP,
                'U', CABLE,
                'H', CHEMICAL_PARTS);

        registerMachineRecipe(BATCH_REACTOR, "UFU", "HMH", "CUC",
                'M', HULL,
                'C', CIRCUIT,
                'F', PUMP,
                'U', CABLE,
                'H', CHEMICAL_PARTS);

        registerMachineRecipe(CONTINUOUS_STIRRED_TANK_REACTOR, "HRH", "UTU", "CMC",
                'T', MOTOR,
                'M', HULL,
                'C', CIRCUIT,
                'U', CABLE,
                'R', ROTOR,
                'H', CHEMICAL_PARTS);

        registerMachineRecipe(DRYER, "UCU", "SHS", "UCU",
                'H', HULL,
                'C', CIRCUIT,
                'S', SPRING,
                'U', CABLE);

        registerMachineRecipe(WEAPONS_FACTORY, "CAC", "YHY", "UCU",
                'H', HULL,
                'C', CIRCUIT,
                'A', ROBOT_ARM,
                'Y', CONVEYOR,
                'U', CABLE);

        registerMachineRecipe(FLUID_DECOMPRESSOR, "GTG", "PHP", "CUC",
                'G', GLASS,
                'H', HULL,
                'C', CIRCUIT,
                'P', PUMP,
                'T', PISTON,
                'U', CABLE);

        registerMachineRecipe(FLUID_COMPRESSOR, "GTG", "FHP", "CUC",
                'G', GLASS,
                'H', HULL,
                'C', CIRCUIT,
                'F', PIPE_NORMAL,
                'P', PUMP,
                'T', PISTON,
                'U', CABLE);

        registerMachineRecipe(POLARIZER, "WMW", "UHU", "WMW",
                'H', HULL,
                'U', CABLE,
                'W', COIL_HEATING_DOUBLE,
                'M', MAGNETS);

        registerMachineRecipe(ELECTROMAGNETIC_SEPARATOR, "YUY", "UHM", "CUW",
                'H', HULL,
                'C', CIRCUIT,
                'Y', CONVEYOR,
                'U', CABLE,
                'W', COIL_HEATING_DOUBLE,
                'M', MAGNETS);

        registerMachineRecipe(ELECTROSTATIC_SEPARATOR, "WEW", "UHU", "WEW",
                'H', HULL,
                'E', ELECTRODES,
                'W', COIL_HEATING_DOUBLE,
                'U', CABLE);

        registerMachineRecipe(VACUUM_CHAMBER, "TTT", "PHP", "UCU",
                'H', HULL,
                'T', PLATE,
                'P', PUMP,
                'C', CIRCUIT,
                'U', CABLE);

        registerMachineRecipe(LASER_ENGRAVER, "PWP", "CHC", "UCU",
                'H', HULL,
                'W', new UnificationEntry(wireFine, Tungsten),
                'P', PISTON,
                'C', CIRCUIT,
                'U', CABLE);

        registerMachineRecipe(UV_LIGHT_BOX, "URU", "CHC", "PPP",
                'H', HULL,
                'R', CARBON_ARC_LAMP,
                'P', PLATE,
                'C', CIRCUIT,
                'U', CABLE);

        registerMachineRecipe(ION_IMPLANTER, "CGC", "MHM", "USU",
                'H', HULL,
                'M', MAGNETS,
                'G', GLASS,
                'S', SPRING,
                'C', CIRCUIT,
                'U', CABLE);

        registerMachineRecipe(ION_EXCHANGE_COLUMN, " P ", "GFG", "CHC",
                'H', HULL,
                'P', PUMP,
                'G', GLASS,
                'F', PIPE_NORMAL,
                'C', CIRCUIT);

        registerMachineRecipe(CVD, "PGG", "HSF", "CUU",
                'H', HULL,
                'P', PUMP,
                'G', GLASS,
                'S', SPRING,
                'F', PIPE_NORMAL,
                'C', CIRCUIT,
                'U', CABLE);

        registerMachineRecipe(ZONE_REFINER, "SFS", "UHU", "CYC",
                'H', HULL,
                'S', SPRING,
                'F', PIPE_NORMAL,
                'C', CIRCUIT,
                'Y', CONVEYOR,
                'U', CABLE_QUAD);

        registerMachineRecipe(TUBE_FURNACE, "CGG", "HSF", "UYU",
                'H', HULL,
                'G', GLASS,
                'S', SPRING,
                'F', PIPE_NORMAL,
                'C', CIRCUIT,
                'Y', CONVEYOR,
                'U', CABLE);

        registerMachineRecipe(POLISHING_MACHINE, "ACP", "GHG", "UMU",
                'H', HULL,
                'G', GLASS,
                'A', ROBOT_ARM,
                'C', CIRCUIT,
                'P', PUMP,
                'M', MOTOR,
                'U', CABLE);

        ModHandler.addShapedRecipe(true, "susy:polymerization_tank",
                POLYMERIZATION_TANK.getStackForm(), "UMU", "PRP", "CHC",
                'U', CABLE.getIngredient(LV),
                'M', MOTOR.getIngredient(LV),
                'P', PUMP.getIngredient(LV),
                'R', ROTOR.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV),
                'H', HULL.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:fluidized_bed_reactor",
                FLUIDIZED_BED_REACTOR.getStackForm(), "UPU", "LHL", "CMC",
                'U', CABLE.getIngredient(HV),
                'P', PUMP.getIngredient(HV),
                'L', new UnificationEntry(pipeLargeFluid, Polytetrafluoroethylene),
                'H', HULL.getIngredient(HV),
                'C', CIRCUIT.getIngredient(HV),
                'M', MOTOR.getIngredient(HV));

        // others
        ModHandler.addShapedRecipe(true, "susy:coagulation_tank",
                COAGULATION_TANK.getStackForm(), "PRP", "sFh", "PBP",
                'P', MetaBlocks.PLANKS.getItemVariant(BlockGregPlanks.BlockType.TREATED_PLANK),
                'R', new UnificationEntry(rotor, Steel),
                'F', new UnificationEntry(pipeLargeFluid, TreatedWood),
                'B', new UnificationEntry(bolt, Steel));

        ModHandler.addShapedRecipe(true, "susy:coagulation_tank_wall",
                COAGULATION_TANK_WALL.getItemVariant(BlockCoagulationTankWall.CoagulationTankWallType.WOODEN_COAGULATION_TANK_WALL, 4),
                "PBP", "sFh", "PBP",
                'P', MetaBlocks.PLANKS.getItemVariant(BlockGregPlanks.BlockType.TREATED_PLANK),
                'F', new UnificationEntry(frameGt, TreatedWood),
                'B', new UnificationEntry(bolt, Steel));

        ModHandler.addShapedRecipe(true, "susy:brick_sintering_block",
                SINTERING_BRICK.getItemVariant(BlockSinteringBrick.SinteringBrickType.BRICK),
                " h ", "FHF", "   ",
                'F', new UnificationEntry(foil, Steel),
                'H', METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.PRIMITIVE_BRICKS));

        ModHandler.addShapedRecipe(true, "susy:sintering_oven",
                SINTERING_OVEN.getStackForm(), "MRW", "CHC", "PWP",
                'P', PUMP.getIngredient(LV),
                'W', COIL_HEATING_DOUBLE.getIngredient(MV),
                'H', HULL.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV),
                'R', ROTOR.getIngredient(LV),
                'M', MOTOR.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:pyrolyse_oven",
                PYROLYSE_OVEN.getStackForm(), "TCW", "CHC", "TPW",
                'P', PUMP.getIngredient(LV),
                'W', COIL_HEATING_DOUBLE.getIngredient(MV),
                'H', HULL.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV),
                'T', PISTON.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:fermentation_vat",
                FERMENTATION_VAT.getStackForm(), "UPU", "GHG", "UCU",
                'P', PUMP.getIngredient(LV),
                'H', HULL.getIngredient(LV),
                'G', "blockGlass",
                'U', CABLE.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:pressure_swing_adsorber",
                PRESSURE_SWING_ADSORBER.getStackForm(), "FMF", "PHP", "CFC",
                'P', PUMP.getIngredient(MV),
                'H', HULL.getIngredient(MV),
                'F', new UnificationEntry(pipeLargeFluid, Aluminium),
                'M', MOTOR.getIngredient(MV),
                'C', CIRCUIT.getIngredient(MV));

        ModHandler.addShapedRecipe(true, "susy:alternator_coil",
                ALTERNATOR_COIL.getItemVariant(BlockAlternatorCoil.AlternatorCoilType.COPPER), "hMs", "MPM", "CUC",
                'P', PLATE.getIngredient(LV),
                'M', MOTOR.getIngredient(LV),
                'U', CABLE.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:steel_turbine_rotor",
                TURBINE_ROTOR.getItemVariant(BlockTurbineRotor.BlockTurbineRotorType.STEEL), "PWP", "hSs", "PRP",
                'P', PLATE.getIngredient(LV),
                'W', new UnificationEntry(screw, Steel),
                'S', new UnificationEntry(stickLong, Steel),
                'R', ROTOR.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:steel_turbine_controller",
                BASIC_STEAM_TURBINE.getStackForm(), "PUP", "CHC", "UCU",
                'P', PLATE.getIngredient(LV),
                'U', CABLE.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV),
                'H', HULL.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:casing_steel_turbine_casing",
                TURBINE_CASING.getItemVariant(BlockTurbineCasing.TurbineCasingType.STEEL_TURBINE_CASING, 4),
                "PhP", "STS", "PwP",
                'P', PLATE.getIngredient(LV),
                'S', new UnificationEntry(stickLong, Steel),
                'T', MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(StoneVariantBlock.StoneType.CONCRETE_LIGHT));

        ModHandler.addShapedRecipe(true, "susy:gas_turbine_controller",
                BASIC_GAS_TURBINE.getStackForm(), "PUP", "CHC", "UCU",
                'P', PLATE.getIngredient(LV),
                'U', CABLE.getIngredient(MV),
                'C', CIRCUIT.getIngredient(MV),
                'H', HULL.getIngredient(MV));

        ModHandler.addShapedRecipe(true, "susy:silicon_carbide_casing",
                SuSyBlocks.MULTIBLOCK_CASING.getItemVariant(BlockSuSyMultiblockCasing.CasingType.SILICON_CARBIDE_CASING, 2),
                "PhP", "PCP", "PwP",
                'P', PLATE.getIngredient(LV),
                'C', METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN));

        ModHandler.addShapedRecipe(true, "susy:ore_sorter",
                ORE_SORTER.getStackForm(), "RCR", "PHP", "RCR",
                'R', ROBOT_ARM.getIngredient(LV),
                'C', CIRCUIT.getIngredient(MV),
                'P', PUMP.getIngredient(LV),
                'H', HULL.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:primitive_mud_pump",
                PRIMITIVE_MUD_PUMP.getStackForm(), "GFW", "RHw", "BLB",
                'G', new UnificationEntry(ring, Bronze),
                'F', new UnificationEntry(pipeNormalFluid, Wood),
                'L', new UnificationEntry(pipeLargeFluid, Wood),
                'R', new UnificationEntry(rotor, Bronze),
                'W', new UnificationEntry(screw, Bronze),
                'H', BRONZE_HULL,
                'B', new ItemStack(STONE_SLAB, 1, 4));

        ModHandler.addShapedRecipe(true, "susy:condenser",
                CONDENSER.getStackForm(), " P ", "FBF", " P ",
                'F', new UnificationEntry(frameGt, Steel),
                'P', PUMP.getIngredient(LV),
                'B', BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.BRONZE_PIPE));

        ModHandler.addShapedRecipe(true, "susy:heat_exchanger",
                HEAT_EXCHANGER.getStackForm(), " F ", "PBP", " F ",
                'F', new UnificationEntry(frameGt, Steel),
                'P', PUMP.getIngredient(LV),
                'B', BOILER_CASING.getItemVariant(BlockBoilerCasing.BoilerCasingType.STEEL_PIPE));

        ModHandler.addShapedRecipe(true, "susy:mining_drill",
                MINING_DRILL.getStackForm(), "CMC", "YHY", "UMU",
                'C', CIRCUIT.getIngredient(LV),
                'Y', CONVEYOR.getIngredient(LV),
                'U', CABLE.getIngredient(LV),
                'M', MOTOR.getIngredient(LV),
                'H', HULL.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:casing_grate_casing",
                MetaBlocks.MULTIBLOCK_CASING.getItemVariant(BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING, 2),
                "IRI", "IFI", "IMI",
                'M', MOTOR.getIngredient(LV),
                'F', new UnificationEntry(frameGt, Steel),
                'R', new UnificationEntry(rotor, Steel),
                'I', new ItemStack(IRON_BARS));

        ModHandler.addShapedRecipe(true, "susy:drill_head",
                DRILL_HEAD.getItemVariant(BlockDrillHead.DrillHeadType.STEEL), "PYP", "GHG", " G ",
                'P', PUMP.getIngredient(LV),
                'G', COMPONENT_GRINDER_DIAMOND,
                'H', METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STEEL_SOLID),
                'Y', CONVEYOR.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:heat_radiator",
                HEAT_RADIATOR.getStackForm(), "RFR", "PHP", "RFR",
                'R', new UnificationEntry(frameGt, Steel),
                'F', new UnificationEntry(pipeLargeFluid, Steel),
                'H', HULL.getIngredient(LV),
                'P', PUMP.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:large_weapons_factory",
                LARGE_WEAPONS_FACTORY.getStackForm(), "SAE", "YHY", "CAC",
                'S', SENSOR.getIngredient(LV),
                'E', EMITTER.getIngredient(LV),
                'A', ROBOT_ARM.getIngredient(LV),
                'Y', CONVEYOR.getIngredient(LV),
                'H', HULL.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:gravity_separator",
                GRAVITY_SEPARATOR.getStackForm(), "GCG", "YHY", "CUC",
                'G', COMPONENT_GRINDER_DIAMOND,
                'U', CABLE.getIngredient(MV),
                'Y', CONVEYOR.getIngredient(MV),
                'H', HULL.getIngredient(MV),
                'C', CIRCUIT.getIngredient(MV));

        ModHandler.addShapedRecipe(true, "susy:reaction_furnace",
                REACTION_FURNACE.getStackForm(), "USU", "CHC", "TTT",
                'T', PLATE.getIngredient(MV),
                'S', SPRING.getIngredient(MV),
                'U', CABLE_QUAD.getIngredient(MV),
                'H', HULL.getIngredient(MV),
                'C', CIRCUIT.getIngredient(MV));

        ModHandler.addShapedRecipe(true, "susy:advanced_arc_furnace",
                ADVANCED_ARC_FURNACE.getStackForm(), "UEU", "CHC", "TTT",
                'T', PLATE.getIngredient(LV),
                'E', ELECTRODE_ASSEMBLY.getItemVariant(BlockElectrodeAssembly.ElectrodeAssemblyType.CARBON),
                'U', CABLE_HEX.getIngredient(LV),
                'H', HULL.getIngredient(LV),
                'C', CIRCUIT.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:electrode_assembly",
                ELECTRODE_ASSEMBLY.getItemVariant(BlockElectrodeAssembly.ElectrodeAssemblyType.CARBON),
                "TUT", "EFE", "TUT",
                'T', PLATE.getIngredient(LV),
                'E', GRAPHITE_ELECTRODE,
                'U', CABLE.getIngredient(MV),
                'F', new UnificationEntry(frameGt, Steel));

        ModHandler.addShapedRecipe(true, "susy:evaporation_pool",
                EVAPORATION_POOL.getStackForm(), "SFS", "PHP", "SFS",
                'S', MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(StoneVariantBlock.StoneType.CONCRETE_LIGHT),
                'H', HULL.getIngredient(MV),
                'P', PUMP.getIngredient(MV),
                'F', new UnificationEntry(pipeHugeFluid, Aluminium));

        ModHandler.addShapedRecipe(true, "susy:evaporation_bed",
                EVAPORATION_BED.getItemVariant(BlockEvaporationBed.EvaporationBedType.DIRT, 9),
                "SDS", "DGD", "SDS",
                'S', new ItemStack(SAND),
                'D', new ItemStack(DIRT),
                'G', new ItemStack(GRAVEL));

        ModHandler.addShapedRecipe(true, "susy:clarifier",
                CLARIFIER.getStackForm(), "URU", "PHP", "CMC",
                'H', HULL.getIngredient(MV),
                'P', PUMP.getIngredient(MV),
                'C', CIRCUIT.getIngredient(MV),
                'U', CABLE.getIngredient(MV),
                'R', new UnificationEntry(rotor, Steel),
                'M', MOTOR.getIngredient(MV));

        ModHandler.addShapedRecipe(true, "susy:clarifier_vat",
                MULTIBLOCK_TANK.getItemVariant(BlockMultiblockTank.MultiblockTankType.CLARIFIER, 9),
                "   ", "THT", "FFF",
                'T', PLATE.getIngredient(LV),
                'H', new ItemStack(CAULDRON),
                'F', new UnificationEntry(pipeSmallFluid, Steel));

        ModHandler.addShapedRecipe(true, "susy:multi_stage_flash_distillater",
                MULTI_STAGE_FLASH_DISTILLER.getStackForm(), "TUT", "PHP", "CSC",
                'H', HULL.getIngredient(HV),
                'P', PUMP.getIngredient(HV),
                'C', CIRCUIT.getIngredient(HV),
                'U', CABLE.getIngredient(HV),
                'T', PLATE.getIngredient(HV),
                'S', SPRING.getIngredient(HV));

        ModHandler.addShapedRecipe(true, "susy:smoke_stack",
                SMOKE_STACK.getStackForm(), " R ", "FHF", " R ",
                'H', HULL.getIngredient(LV),
                'R', new UnificationEntry(rotor, Steel),
                'F', new UnificationEntry(pipeSmallFluid, Steel));

        ModHandler.addShapedRecipe(true, "susy:flare_stack",
                FLARE_STACK.getStackForm(), " R ", "SHS", " R ",
                'H', HULL.getIngredient(LV),
                'R', new UnificationEntry(rotor, Steel),
                'S', new UnificationEntry(stick, Steel));

        ModHandler.addShapedRecipe(true, "susy:froth_flotation_tank",
                FROTH_FLOTATION_TANK.getStackForm(), "URU", "PHP", "CMC",
                'H', HULL.getIngredient(HV),
                'P', PUMP.getIngredient(HV),
                'C', CIRCUIT.getIngredient(HV),
                'R', new UnificationEntry(rotor, StainlessSteel),
                'U', CABLE.getIngredient(HV),
                'M', MOTOR.getIngredient(HV));

        ModHandler.addShapedRecipe(true, "susy:fotation_vat",
                MULTIBLOCK_TANK.getItemVariant(BlockMultiblockTank.MultiblockTankType.FLOTATION, 9),
                "   ", "THT", "FFF",
                'T', PLATE.getIngredient(HV),
                'H', new ItemStack(CAULDRON),
                'F', new UnificationEntry(pipeSmallFluid, StainlessSteel));

        ModHandler.addShapedRecipe(true, "susy:vacuum_distillation_tower",
                VACUUM_DISTILLATION_TOWER.getStackForm(), "RCR", "PHP", "FCF",
                'H', HULL.getIngredient(MV),
                'P', PUMP.getIngredient(MV),
                'C', CIRCUIT.getIngredient(MV),
                'R', new UnificationEntry(rotor, Steel),
                'F', new UnificationEntry(pipeHugeFluid, Steel));

        ModHandler.addShapedRecipe(true, "susy:vacuum_freezer",
                VACUUM_FREEZER.getStackForm(), "PPP", "CHC", "UCU",
                'H', METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.ALUMINIUM_FROSTPROOF),
                'P', PUMP.getIngredient(HV),
                'C', CIRCUIT.getIngredient(HV),
                'U', new UnificationEntry(cableGtSingle, Gold));

        ModHandler.addShapedRecipe(true, "susy:cooling_unit",
                COOLING_UNIT.getStackForm(), "RRR", "MHM", "PCP",
                'H', HULL.getIngredient(HV),
                'P', PUMP.getIngredient(HV),
                'C', CIRCUIT.getIngredient(HV),
                'M', MOTOR.getIngredient(HV),
                'R', new UnificationEntry(rotor, StainlessSteel));

        ModHandler.addShapedRecipe(true, "susy:quencher",
                QUENCHER.getStackForm(), "PAP", "CHC", "FCF",
                'H', METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN),
                'P', PUMP.getIngredient(HV),
                'C', CIRCUIT.getIngredient(HV),
                'A', ROBOT_ARM.getIngredient(HV),
                'F', new UnificationEntry(pipeLargeFluid, StainlessSteel));

        ModHandler.addShapedRecipe(true, "susy:dumper",
                DUMPER.getStackForm(), "TTT", "PHP", "TTT",
                'H', HULL.getIngredient(LV),
                'P', PUMP.getIngredient(LV),
                'T', PLATE.getIngredient(LV));

        ModHandler.addShapedRecipe(true, "susy:ocean_pumper",
                OCEAN_PUMPER.getStackForm(), "SPS", "CHC", "UPU",
                'H', HULL.getIngredient(MV),
                'P', PUMP.getIngredient(MV),
                'S', new UnificationEntry(stickLong, Aluminium),
                'C', CIRCUIT.getIngredient(MV),
                'U', CABLE.getIngredient(MV));

        ModHandler.addShapedRecipe(true, "susy:coking_tower",
                COKING_TOWER.getStackForm(), "FPF", "CHC", "FPF",
                'H', HULL.getIngredient(HV),
                'P', PUMP.getIngredient(HV),
                'F', new UnificationEntry(pipeHugeFluid, Steel),
                'C', CIRCUIT.getIngredient(HV));

        ModHandler.addShapedRecipe(true, "susy:rotary_kiln",
                ROTARY_KILN.getStackForm(), "C U", "FHF", "CMU",
                'H', HULL.getIngredient(MV),
                'M', MOTOR.getIngredient(MV),
                'U', CABLE.getIngredient(MV),
                'F', new UnificationEntry(pipeHugeFluid, Steel),
                'C', CIRCUIT.getIngredient(MV));

        ModHandler.addShapedRecipe(true, "susy:high_temperature_distillation_tower",
                HIGH_TEMPERATURE_DISTILLATION_TOWER.getStackForm(), "CWC", "PHP", "CWC",
                'H', HULL.getIngredient(HV),
                'P', PUMP.getIngredient(HV),
                'W', WIRE_COIL.getItemVariant(BlockWireCoil.CoilType.CUPRONICKEL),
                'C', CIRCUIT.getIngredient(HV));

        ModHandler.addShapedRecipe(true, "susy:bath_condenser",
                BATH_CONDENSER[ULV].getStackForm(), "FFF", "FHF", "FFF",
                'H', HULL.getIngredient(HV),
                'F', new UnificationEntry(pipeSmallFluid, StainlessSteel));

        ModHandler.addShapedRecipe(true, "susy:phase_separator",
                PHASE_SEPARATOR[ULV].getStackForm(), "FDP", "PHP", "   ",
                'H', HULL.getIngredient(HV),
                'P', new UnificationEntry(pipeSmallFluid, StainlessSteel),
                'D', STAINLESS_STEEL_DRUM.getStackForm(),
                'F', new UnificationEntry(frameGt, StainlessSteel));

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(6)
                .input(plate, SiliconCarbide, 6)
                .inputs(METAL_CASING.getItemVariant(BlockMetalCasing.MetalCasingType.STAINLESS_CLEAN, 5))
                .outputs(SuSyBlocks.MULTIBLOCK_CASING.getItemVariant(BlockSuSyMultiblockCasing.CasingType.SILICON_CARBIDE_CASING, 2))
                .EUt(16)
                .duration(50)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.TRANSFORMER[LV])
                .input(ENERGY_OUTPUT_HATCH[LV])
                .input(VOLTAGE_COIL_LV)
                .input(wireGtQuadruple, Tin, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[LV])
                .EUt(7)
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[LV])
                .input(ENERGY_OUTPUT_HATCH_4A[LV])
                .input(VOLTAGE_COIL_LV)
                .input(wireGtOctal, Tin, 2)
                .output(ENERGY_OUTPUT_HATCH_16A[LV])
                .EUt(7)
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.TRANSFORMER[2])
                .input(ENERGY_OUTPUT_HATCH[MV])
                .input(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT)
                .input(VOLTAGE_COIL_MV)
                .input(wireGtQuadruple, Copper, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[MV])
                .EUt(30)
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[MV])
                .input(ENERGY_OUTPUT_HATCH_4A[MV])
                .input(ULTRA_LOW_POWER_INTEGRATED_CIRCUIT, 2)
                .input(VOLTAGE_COIL_MV)
                .input(wireGtOctal, Copper, 2)
                .output(ENERGY_OUTPUT_HATCH_16A[MV])
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.TRANSFORMER[3])
                .input(ENERGY_OUTPUT_HATCH[HV])
                .input(LOW_POWER_INTEGRATED_CIRCUIT)
                .input(VOLTAGE_COIL_HV)
                .input(wireGtQuadruple, Gold, 2)
                .output(ENERGY_OUTPUT_HATCH_4A[HV])
                .EUt(120)
                .duration(100)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[HV])
                .input(ENERGY_OUTPUT_HATCH_4A[HV])
                .input(LOW_POWER_INTEGRATED_CIRCUIT, 2)
                .input(VOLTAGE_COIL_HV)
                .input(wireGtOctal, Gold, 2)
                .output(ENERGY_OUTPUT_HATCH_16A[HV])
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(POWER_TRANSFORMER[EV])
                .input(ENERGY_OUTPUT_HATCH_4A[EV])
                .input(POWER_INTEGRATED_CIRCUIT, 2)
                .input(VOLTAGE_COIL_EV)
                .input(wireGtOctal, Aluminium, 2)
                .output(ENERGY_OUTPUT_HATCH_16A[EV])
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        removeRecipesByInputs(ASSEMBLER_RECIPES,
                MetaTileEntities.HULL[EV].getStackForm(),
                OreDictUnifier.get(frameGt, Steel, 4),
                INTEGRATED_CIRCUIT_MV.getStackForm(4),
                ELECTRIC_MOTOR_MV.getStackForm(4),
                ELECTRIC_PUMP_MV.getStackForm(4),
                OreDictUnifier.get(gear, VanadiumSteel, 4),
                getConfiguration(2)
        );

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[LV])
                .input(frameGt, Steel, 4)
                .input("circuitLv", 4)
                .input(ELECTRIC_MOTOR_LV, 4)
                .input(ELECTRIC_PUMP_LV, 4)
                .input(gear, Steel, 4)
                .circuitMeta(2)
                .output(FLUID_DRILLING_RIG)
                .EUt(30)
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(MetaTileEntities.HULL[EV])
                .input(frameGt, Titanium, 4)
                .input(ELECTRIC_PUMP_EV, 2)
                .input(pipeHugeFluid, Titanium)
                .input(rotor, Titanium)
                .input("circuitEv")
                .output(CATALYTIC_REFORMER)
                .circuitMeta(3)
                .EUt(480)
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(gear, Steel, 2)
                .input(bolt, Steel, 2)
                .input(ELECTRIC_MOTOR_LV, 2)
                .input("batteryLv")
                .output(POWER_UNIT_LV)
                .EUt(30)
                .duration(150)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(gearSmall, Aluminium, 2)
                .input(bolt, Aluminium, 2)
                .input(ELECTRIC_MOTOR_MV, 2)
                .input("batteryMv")
                .output(POWER_UNIT_MV)
                .EUt(120)
                .duration(150)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(gearSmall, StainlessSteel, 2)
                .input(bolt, StainlessSteel, 2)
                .input(ELECTRIC_MOTOR_HV, 2)
                .input("batteryHv")
                .output(POWER_UNIT_HV)
                .EUt(480)
                .duration(150)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(gearSmall, StainlessSteel, 2)
                .input(bolt, StainlessSteel, 2)
                .input(ELECTRIC_MOTOR_EV, 2)
                .input("batteryEv")
                .output(POWER_UNIT_EV)
                .EUt(1920)
                .duration(150)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(gearSmall, TungstenSteel, 2)
                .input(bolt, TungstenSteel, 2)
                .input(ELECTRIC_MOTOR_IV, 2)
                .input("batteryIv")
                .output(POWER_UNIT_IV)
                .EUt(7680)
                .duration(150)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(MetaTileEntities.HULL[HV])
                .input(frameGt, Aluminium, 3)
                .input("circuitHv", 4)
                .input(ELECTRIC_PUMP_HV, 4)
                .input(plate, Aluminium, 4)
                .inputs(new ItemStack(WOOL, 64))
                .output(SINGLE_COLUMN_CRYOGENIC_DISTILLATION_PLANT)
                .EUt(30)
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(MetaTileEntities.HULL[HV])
                .input(frameGt, Aluminium, 3)
                .input("circuitHv", 2)
                .input(ELECTRIC_PUMP_HV, 4)
                .input(plate, Aluminium, 4)
                .input(SERPENTINE, 6)
                .input(MINERAL_WOOL, 64)
                .output(LOW_PRESSURE_CRYOGENIC_DISTILLATION_PLANT)
                .EUt(30)
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(4)
                .input(MetaTileEntities.HULL[HV])
                .input(frameGt, Aluminium, 12)
                .input("circuitHv", 6)
                .input(ELECTRIC_PUMP_HV, 8)
                .input(plate, Aluminium, 4)
                .input(MINERAL_WOOL, 64)
                .output(HIGH_PRESSURE_CRYOGENIC_DISTILLATION_PLANT)
                .EUt(30)
                .duration(600)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .circuitMeta(3)
                .input(MetaTileEntities.HULL[HV])
                .input(frameGt, StainlessSteel)
                .input(plate, Polytetrafluoroethylene, 4)
                .input("circuitHv", 2)
                .input(ELECTRIC_MOTOR_HV)
                .input(ELECTRIC_PUMP_HV, 4)
                .output(BLENDER)
                .EUt(30)
                .duration(600)
                .buildAndRegister();

        ModHandler.addShapedRecipe(true, "mold_rod",
                SHAPE_MOLD_ROD.getStackForm(), "Sh ", "   ", "   ",
                'S', SHAPE_EMPTY);

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(SHAPE_EMPTY)
                .notConsumable(SHAPE_MOLD_ROD)
                .output(SHAPE_MOLD_ROD)
                .duration(120)
                .EUt(22)
                .buildAndRegister();

////CRUCIBLE MOLD
//        crafting.addShaped("mold_crucible", metaitem('shape.mold.crucible'), [
//    [metaitem('shape.empty'), null, null],
//    [null, null, null],
//    [null, null, item('gregtech:hammer')]
//])
        ModHandler.addShapedRecipe(true, "mold_crucible",
                SHAPE_MOLD_CRUCIBLE.getStackForm(), "S  ", "   ", "  h",
                'S', SHAPE_EMPTY);

        FORMING_PRESS_RECIPES.recipeBuilder()
                .input(SHAPE_EMPTY)
                .notConsumable(SHAPE_MOLD_CRUCIBLE)
                .output(SHAPE_MOLD_CRUCIBLE)
                .duration(120)
                .EUt(22)
                .buildAndRegister();
    }
}
