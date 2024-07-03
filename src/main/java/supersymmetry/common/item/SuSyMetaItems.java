package supersymmetry.common.item;

import gregtech.api.GTValues;
import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.api.items.metaitem.MetaOreDictItem;
import gregtech.api.items.metaitem.MetaOreDictItem.OreDictValueItem;
import gregtech.api.items.metaitem.StandardMetaItem;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.behaviors.TooltipBehavior;
import net.minecraft.client.resources.I18n;
import supersymmetry.SuSyValues;
import gregtech.api.GregTechAPI;
import gregtech.api.items.metaitem.*;
import gregtech.api.unification.material.MarkerMaterials;

public class SuSyMetaItems {
    private static StandardMetaItem metaItem;

    private static StandardMetaItem customMetaItems;
    public static MetaOreDictItem oreDictItem;
    public static MetaValueItem CATALYST_BED_SUPPORT_GRID;
    public static MetaValueItem CONVEYOR_STEAM;
    public static MetaValueItem PUMP_STEAM;
    public static MetaValueItem AIR_VENT;

    public static MetaValueItem ROCK_ORTHOMAGMATIC;
    public static MetaValueItem ROCK_METAMORPHIC;
    public static MetaValueItem ROCK_MAGMATIC_HYDROTHERMAL;
    public static MetaValueItem ROCK_SEDIMENTARY;
    public static MetaValueItem ROCK_HYDROTHERMAL;
    public static MetaValueItem ROCK_ALLUVIAL;

    public static MetaValueItem CEMENT_CLINKER;
    public static MetaValueItem HOT_CEMENT_CLINKER;
    public static MetaValueItem CEMENT_DUST;
    public static MetaValueItem LIMESTONE_DUST;
    public static MetaValueItem SHAPE_MOLD_ROD;
    public static MetaValueItem SHAPE_MOLD_CRUCIBLE;
    public static MetaValueItem CRUCIBLE_BORON_NITRIDE;
    public static MetaValueItem CRUCIBLE_QUARTZ;
    public static MetaValueItem CRUCIBLE_GRAPHITE;
    public static MetaValueItem SHAPE_MOLD_LONG_ROD;
    public static MetaValueItem SHAPE_MOLD_RING;

    public static MetaValueItem MUDBRICK_MIX;
    public static MetaValueItem SLAKED_LIME;
    public static MetaValueItem SAND_DUST;
    public static MetaValueItem STRAW;

    public static MetaValueItem WASHED_ROTTEN_FLESH;

    public static MetaValueItem SUGAR_CANE_DUST;

    public static MetaValueItem BITUMEN;
    public static MetaValueItem BITUMINOUS_RESIDUE;
    public static MetaValueItem PARAFFIN_WAX;
    public static MetaValueItem SPENT_CRACKING_CATALYST;

    public static MetaValueItem RED_MUD_SLAG;
    public static MetaValueItem LEACHED_RED_MUD_SLAG;

    public static MetaValueItem PITCH_BINDER;
    public static MetaValueItem RAW_ELECTRODE;
    public static MetaValueItem GRAPHITE_ELECTRODE;

    public static MetaValueItem RYDBERG_ATOM_ARRAY;

    public static MetaValueItem MALTED_GRAIN;

    public static MetaValueItem MINERAL_WOOL;

    public static MetaValueItem HEPA_FILTER;

    public static MetaValueItem CRACKING_CATALYST;

    public static MetaValueItem RAW_DIAMOND;

    public static MetaValueItem CELLULOSE_ACETATE_MESH;

    public static MetaValueItem ANODE_SLIME_GOLD;
    public static MetaValueItem ANODE_SLIME_SILVER;
    public static MetaValueItem ANODE_SLIME_LEAD;
    public static MetaValueItem ANODE_SLIME_COPPER;

    public static MetaValueItem ZEOLITE_MEMBRANE_SUPPORT;
    public static MetaValueItem ZEOLITE_MEMBRANE;

    public static MetaValueItem PATTERNED_THICK_FILM_SUBSTRATE_WAFER;
    public static MetaValueItem THICK_FILM_RESISTOR_WAFER;
    public static MetaValueItem METALLIZED_PLASTIC_FILM;
    public static MetaValueItem METALLIZED_PLASTIC_SQUARE;
    public static MetaValueItem RAW_SMD_CAPACITOR;
    public static MetaValueItem RAW_CAPACITOR_ROLL;
    public static MetaValueItem ALUMINIUM_ELECTROLYTIC_CAPACITOR;
    public static MetaValueItem TANTALUM_CHIP;
    public static MetaValueItem ANODIZED_TANTALUM_CHIP;
    public static MetaValueItem MANGANIZED_TANTALUM_CHIP;
    public static MetaValueItem FERROELECTRIC_CERAMIC_FOIL;
    public static MetaValueItem STACKED_CERAMIC_CAPACITOR;
    public static MetaValueItem RAW_CERAMIC_CAPACITOR;

    public static MetaValueItem CHIP_INSULATED_SILICON;
    public static MetaValueItem CHIP_INSULATED_SILICON_GERMANIUM;
    public static MetaValueItem CHIP_N_DOPED_SILICON;
    public static MetaValueItem CHIP_SILICON_DIOXIDE;

    public static MetaValueItem FUSED_QUARTZ;

    public static MetaValueItem THICK_FILM_SUBSTRATE_WAFER;

    public static MetaValueItem VTI_RICH_PIG_IRON;
    public static MetaValueItem VT_SLAG;

    public static MetaValueItem SPONGE_TITANIUM;
    public static MetaValueItem SPONGE_TITANIUM_CRUDE;
    public static MetaValueItem SPONGE_ZIRCONIUM;
    public static MetaValueItem SPONGE_ZIRCONIUM_CRUDE;
    public static MetaValueItem SPONGE_HAFNIUM;
    public static MetaValueItem SPONGE_HAFNIUM_CRUDE;
    public static MetaValueItem SPONGE_PLATINUM;
    public static MetaValueItem SPONGE_CADMIUM;
    public static MetaValueItem SPONGE_INDIUM;

    public static MetaValueItem BOUND_LEATHER;

    public static MetaValueItem GLASS_FIBERS;
    public static MetaValueItem EPOXY_LAMINA;

    public static MetaValueItem BEADS_AMBERLYST_CH;
    public static MetaValueItem BEADS_AG_FIFTY_W_X_EIGHT;
    public static MetaValueItem BEADS_RHENIUM_ION_EXCHANGE;
    public static MetaValueItem BEADS_LOADED_RHENIUM_ION_EXCHANGE;

    public static MetaValueItem MYLAR;
    public static MetaValueItem SPINNERET;

    public static MetaValueItem CHUNK_MAGNETITE;
    public static MetaValueItem HOT_IRON_ROD;
    public static MetaValueItem VOLTAIC_PILE;
    public static MetaValueItem ELECTROLYTE_PAPER;

    public static MetaValueItem STEAM_PISTON;
    public static MetaValueItem STEAM_MOTOR;

    public static MetaValueItem WAFER_PATTERN_PROCESSOR;
    public static MetaValueItem WAFER_PATTERN_MEMORY;

    public static MetaValueItem PLATE_PATTERN_PROCESSOR;
    public static MetaValueItem PLATE_PATTERN_MEMORY;

    public static MetaValueItem PATTERN_PROCESSOR;
    public static MetaValueItem PATTERN_MEMORY;

    public static MetaValueItem STORAGE_SEGMENT;
    public static MetaValueItem GUN_BARREL_STEEL;

    public static MetaValueItem CIRCUIT_GOOWARE_PROCESSOR;
    public static MetaValueItem CIRCUIT_GOOWARE_ASSEMBLY;
    public static MetaValueItem CIRCUIT_GOOWARE_COMPUTER;
    public static MetaValueItem CIRCUIT_GOOWARE_MAINFRAME;

    public static MetaValueItem CIRCUIT_OPTICAL_PROCESSOR;
    public static MetaValueItem CIRCUIT_OPTICAL_ASSEMBLY;
    public static MetaValueItem CIRCUIT_OPTICAL_COMPUTER;
    public static MetaValueItem CIRCUIT_OPTICAL_MAINFRAME;

    public static MetaValueItem CIRCUIT_SPINTRONIC_PROCESSOR;
    public static MetaValueItem CIRCUIT_SPINTRONIC_ASSEMBLY;
    public static MetaValueItem CIRCUIT_SPINTRONIC_COMPUTER;
    public static MetaValueItem CIRCUIT_SPINTRONIC_MAINFRAME;

    public static MetaValueItem CIRCUIT_COSMIC_PROCESSOR;
    public static MetaValueItem CIRCUIT_COSMIC_ASSEMBLY;
    public static MetaValueItem CIRCUIT_COSMIC_COMPUTER;
    public static MetaValueItem CIRCUIT_COSMIC_MAINFRAME;

    public static MetaValueItem CIRCUIT_SUPRACAUSAL_PROCESSOR;
    public static MetaValueItem CIRCUIT_SUPRACAUSAL_ASSEMBLY;
    public static MetaValueItem CIRCUIT_SUPRACAUSAL_COMPUTER;
    public static MetaValueItem CIRCUIT_SUPRACAUSAL_MAINFRAME;

    public static MetaValueItem CIRCUIT_SUPRACHRONAL_ULV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_LV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_MV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_HV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_EV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_IV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_LUV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_ZPM;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_UV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_UHV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_UEV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_UIV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_UXV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_OPV;
    public static MetaValueItem CIRCUIT_SUPRACHRONAL_MAX;

    public static MetaValueItem BATTERY_LEAD_ACID;
    public static MetaValueItem CATHODE_LEAD;
    public static MetaValueItem ANODE_LEAD;

    public static MetaValueItem VACUUM_TUBE_COMPONENTS;

    public static MetaValueItem RUBYLITH;
    public static MetaValueItem RUBYLITH_FILM;
    public static MetaValueItem STENCIL_IC;
    public static MetaValueItem STENCIL_CPU;
    public static MetaValueItem STENCIL_RAM;
    public static MetaValueItem STENCIL_PCB;
    public static MetaValueItem STENCIL_ULPIC;
    public static MetaValueItem STENCIL_LPIC;
    public static MetaValueItem MASK_BLANK;
    public static MetaValueItem MASK_IC;
    public static MetaValueItem MASK_CPU;
    public static MetaValueItem MASK_RAM;
    public static MetaValueItem MASK_PCB;
    public static MetaValueItem MASK_ULPIC;
    public static MetaValueItem MASK_LPIC;
    public static MetaValueItem MASK_NAND;
    public static MetaValueItem MASK_NOR;
    public static MetaValueItem MASK_ADVANCED;
    public static MetaValueItem PATTERNED_IC;
    public static MetaValueItem PATTERNED_CPU;
    public static MetaValueItem PATTERNED_RAM;
    public static MetaValueItem PATTERNED_ULPIC;
    public static MetaValueItem PATTERNED_LPIC;
    public static MetaValueItem PATTERNED_SILICON_DIOXIDE;
    public static MetaValueItem PATTERNED_POLYSILICON;
    public static MetaValueItem PATTERNED_SILICON_NITRIDE;
    public static MetaValueItem PATTERNED_NAND;
    public static MetaValueItem PATTERNED_NOR;
    public static MetaValueItem PATTERNED_BOARD_PHENOLIC;
    public static MetaValueItem PATTERNED_BOARD_PLASTIC;
    public static MetaValueItem LAMINATED_BOARD_PHENOLIC;
    public static MetaValueItem ETCHED_IC;
    public static MetaValueItem ETCHED_CPU;
    public static MetaValueItem ETCHED_RAM;
    public static MetaValueItem ETCHED_ULPIC;
    public static MetaValueItem ETCHED_LPIC;
    public static MetaValueItem ETCHED_SILICON_DIOXIDE;
    public static MetaValueItem ETCHED_POLYSILICON;
    public static MetaValueItem ETCHED_SILICON_NITRIDE;

    public static MetaValueItem CARBON_ARC_LAMP;
    public static MetaValueItem INCANDESCENT_LIGHT;
    public static MetaValueItem HALOGEN_LIGHT;
    public static MetaValueItem FLUORESCENT_LIGHT;
    public static MetaValueItem LED_LIGHT;

    public static MetaValueItem ASSEMBLYMANGANESEPHOSPHIDE;
    public static MetaValueItem BASEMANGANESEPHOSPHIDE;
    public static MetaValueItem CANNEDMAGNESIUMDIBORIDE;
    public static MetaValueItem TUBEMAGNESIUMDIBORIDE;
    public static MetaValueItem BASEMAGNESIUMDIBORIDE;
    public static MetaValueItem CANNEDMERCURYBARIUMCALCIUMCUPRATE;
    public static MetaValueItem TUBEMERCURYBARIUMCALCIUMCUPRATE;
    public static MetaValueItem BASEMERCURYBARIUMCALCIUMCUPRATE;
    public static MetaValueItem ASSEMBLYURANIUMTRIPLATINUM;
    public static MetaValueItem BASEURANIUMTRIPLATINUM;
    public static MetaValueItem CANNEDSAMARIUMIRONARSENICOXIDE;
    public static MetaValueItem TUBESAMARIUMIRONARSENICOXIDE;
    public static MetaValueItem BASESAMARIUMIRONARSENICOXIDE;
    public static MetaValueItem ASSEMBLYINDIUMTINBARIUMTITANIUMCUPRATE;
    public static MetaValueItem BASEINDIUMTINBARIUMTITANIUMCUPRATE;
    public static MetaValueItem ASSEMBLYURANIUMRHODIUMDINAQUADIDE;
    public static MetaValueItem BASEURANIUMRHODIUMDINAQUADIDE;
    public static MetaValueItem ASSEMBLYENRICHEDNAQUADAHTRINIUMEUROPIUMDURANIDE;
    public static MetaValueItem BASEENRICHEDNAQUADAHTRINIUMEUROPIUMDURANIDE;
    public static MetaValueItem ASSEMBLYRUTHENIUMTRINIUMAMERICIUMNEUTRONATE;
    public static MetaValueItem BASERUTHENIUMTRINIUMAMERICIUMNEUTRONATE;

    public static MetaValueItem SEED_CRYSTAL_SILICON;
    public static MetaValueItem SEED_CRYSTAL_GALLIUM_ARSENIDE;
    public static MetaValueItem SEED_CRYSTAL_ALUMINA;
    public static MetaValueItem SEED_CRYSTAL_BERYLLIUM_OXIDE;
    public static MetaValueItem SEED_CRYSTAL_EMERALD;
    public static MetaValueItem SEED_CRYSTAL_LITHIUM_NIOBATE;

    public static MetaValueItem UNREFINED_BOULE_SILICON;
    public static MetaValueItem BOULE_GALLIUM_ARSENIDE;
    public static MetaValueItem UNREFINED_BOULE_GALLIUM_ARSENIDE;
    public static MetaValueItem BOULE_ALUMINA;
    public static MetaValueItem BOULE_BERYLLIUM_OXIDE;
    public static MetaValueItem BOULE_EMERALD;
    public static MetaValueItem BOULE_SAPPHIRE;
    public static MetaValueItem BOULE_RUBY;
    public static MetaValueItem BOULE_SILICON_GERMANIUM;
    public static MetaValueItem BOULE_LITHIUM_NIOBATE;
    public static MetaValueItem WAFER_DOPED_SILICON;
    public static MetaValueItem WAFER_N_DOPED_SILICON;
    public static MetaValueItem WAFER_SILICON_DIOXIDE;
    public static MetaValueItem WAFER_ALUMINA;
    public static MetaValueItem WAFER_BERYLLIUM_OXIDE;
    public static MetaValueItem WAFER_SILICON_GERMANIUM;
    public static MetaValueItem WAFER_INSULATED_SILICON;
    public static MetaValueItem WAFER_INSULATED_SILICON_GERMANIUM;
    public static MetaValueItem WAFER_DOPED_SILICON_DIOXIDE;
    public static MetaValueItem WAFER_POLYSILICON;
    public static MetaValueItem WAFER_DOPED_POLYSILICON;
    public static MetaValueItem WAFER_SILICON_NITRIDE;
    public static MetaValueItem WAFER_NICKEL;
    public static MetaValueItem WAFER_GALLIUM_ARSENIDE;
    public static MetaValueItem WAFER_RAW_SILICON;
    public static MetaValueItem WAFER_TREATED_SILICON;

    public static MetaValueItem SEED_COTTON;
    public static MetaValueItem CROP_COTTON;
    public static MetaValueItem STEM_COTTON;

    public static void initMetaItems() {
        metaItem = new StandardMetaItem();
        metaItem.setRegistryName("meta_item");
        oreDictItem = new MetaOreDictItem((short) 0);
        oreDictItem.setRegistryName("susy_oredict_item");
        customMetaItems = new StandardMetaItem((short)2);
        customMetaItems.setRegistryName("meta_item_2");

        CatalystItems.init();
    }

    public static void initSubItems() {
        initMetaItem();
        CatalystItems.initCatalysts();
    }

    private static void initMetaItem() {
        // initialize metaitems here
        CATALYST_BED_SUPPORT_GRID = metaItem.addItem(1, "catalyst_bed_support_grid");
        CONVEYOR_STEAM = metaItem.addItem(2, "conveyor.steam").addComponents(new TooltipBehavior((lines) -> {
            lines.add(I18n.format("metaitem.conveyor.module.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.item_transfer_rate", new Object[]{4}));
        }));
        PUMP_STEAM = metaItem.addItem(3, "pump.steam").addComponents(new TooltipBehavior((lines) -> {
            lines.add(I18n.format("metaitem.electric.pump.tooltip"));
            lines.add(I18n.format("gregtech.universal.tooltip.fluid_transfer_rate", new Object[]{32}));
        }));
        AIR_VENT = metaItem.addItem(4, "air_vent").addComponents(new TooltipBehavior((lines) -> {
            lines.add(I18n.format("metaitem.air_vent.tooltip.1", 100));
        }));

        ROCK_ORTHOMAGMATIC = customMetaItems.addItem(1, "rock.orthomagmatic");
        ROCK_METAMORPHIC = customMetaItems.addItem(2, "rock.metamorphic");
        ROCK_MAGMATIC_HYDROTHERMAL = customMetaItems.addItem(3, "rock.magmatic_hydrothermal");
        ROCK_SEDIMENTARY = customMetaItems.addItem(4, "rock.sedimentary");
        ROCK_HYDROTHERMAL = customMetaItems.addItem(5, "rock.hydrothermal");
        ROCK_ALLUVIAL = customMetaItems.addItem(6, "rock.alluvial");

        CEMENT_CLINKER = customMetaItems.addItem(100, "cement.clinker");
        HOT_CEMENT_CLINKER = customMetaItems.addItem(101, "hot.cement.clinker");
        CEMENT_DUST = customMetaItems.addItem(102, "cement.dust");
        LIMESTONE_DUST = customMetaItems.addItem(103, "limestone.dust");
        SHAPE_MOLD_ROD = customMetaItems.addItem(104, "shape.mold.rod");
        SHAPE_MOLD_CRUCIBLE = customMetaItems.addItem(105, "shape.mold.crucible");
        CRUCIBLE_BORON_NITRIDE = customMetaItems.addItem(106, "crucible.boron.nitride");
        CRUCIBLE_QUARTZ = customMetaItems.addItem(107, "crucible.quartz");
        CRUCIBLE_GRAPHITE = customMetaItems.addItem(108, "crucible.graphite");
        SHAPE_MOLD_LONG_ROD = customMetaItems.addItem(109, "shape.mold.long_rod");
        SHAPE_MOLD_RING = customMetaItems.addItem(110, "shape.mold.ring");

        MUDBRICK_MIX = customMetaItems.addItem(150, "mudbrick_mix");
        SLAKED_LIME = customMetaItems.addItem(151, "slaked_lime");
        SAND_DUST = customMetaItems.addItem(152, "sand.dust");
        STRAW = customMetaItems.addItem(153, "straw");

        WASHED_ROTTEN_FLESH = customMetaItems.addItem(154, "washed_rotten_flesh");

        SUGAR_CANE_DUST = customMetaItems.addItem(155, "sugar_cane_dust");

        BITUMEN = customMetaItems.addItem(156, "bitumen");
        BITUMINOUS_RESIDUE = customMetaItems.addItem(157, "bituminous_residue");
        PARAFFIN_WAX = customMetaItems.addItem(158, "paraffin_wax");
        SPENT_CRACKING_CATALYST = customMetaItems.addItem(159, "spent_cracking_catalyst");

        RED_MUD_SLAG = customMetaItems.addItem(160, "red_mud_slag");
        LEACHED_RED_MUD_SLAG = customMetaItems.addItem(161, "leached_red_mud_slag");

        PITCH_BINDER = customMetaItems.addItem(162, "pitch_binder");
        RAW_ELECTRODE = customMetaItems.addItem(163, "raw_electrode");
        GRAPHITE_ELECTRODE = customMetaItems.addItem(164, "graphite_electrode");

        RYDBERG_ATOM_ARRAY = customMetaItems.addItem(165, "rydberg_atom_array");

        MALTED_GRAIN = customMetaItems.addItem(166, "malted_grain");

        MINERAL_WOOL = customMetaItems.addItem(167, "mineral_wool");

        HEPA_FILTER = customMetaItems.addItem(168, "hepa_filter");

        CRACKING_CATALYST = customMetaItems.addItem(169, "cracking_catalyst");

        RAW_DIAMOND = customMetaItems.addItem(170, "raw_diamond");

        CELLULOSE_ACETATE_MESH = customMetaItems.addItem(171, "cellulose_acetate_mesh");

        ANODE_SLIME_GOLD = customMetaItems.addItem(175, "anode_slime.gold");
        ANODE_SLIME_SILVER = customMetaItems.addItem(176, "anode_slime.silver");
        ANODE_SLIME_LEAD = customMetaItems.addItem(179, "anode_slime.lead");
        ANODE_SLIME_COPPER = customMetaItems.addItem(211, "anode_slime.copper");

        ZEOLITE_MEMBRANE_SUPPORT = customMetaItems.addItem(177, "zeolite_membrane_support");
        ZEOLITE_MEMBRANE = customMetaItems.addItem(178, "zeolite_membrane");

        PATTERNED_THICK_FILM_SUBSTRATE_WAFER = customMetaItems.addItem(180, "patterned_thick_film_substrate_wafer");
        THICK_FILM_RESISTOR_WAFER = customMetaItems.addItem(181, "thick_film_resistor_wafer");
        METALLIZED_PLASTIC_FILM = customMetaItems.addItem(182, "metallized_plastic_film");
        METALLIZED_PLASTIC_SQUARE = customMetaItems.addItem(183, "metallized_plastic_square");
        RAW_SMD_CAPACITOR = customMetaItems.addItem(184, "raw_smd_capacitor");
        RAW_CAPACITOR_ROLL = customMetaItems.addItem(185, "raw_capacitor_roll");
        ALUMINIUM_ELECTROLYTIC_CAPACITOR = customMetaItems.addItem(186, "aluminium_electrolytic_capacitor");
        TANTALUM_CHIP = customMetaItems.addItem(187, "tantalum_chip");
        ANODIZED_TANTALUM_CHIP = customMetaItems.addItem(188, "anodized_tantalum_chip");
        MANGANIZED_TANTALUM_CHIP = customMetaItems.addItem(189, "manganized_tantalum_chip");
        FERROELECTRIC_CERAMIC_FOIL = customMetaItems.addItem(190, "ferroelectric_ceramic_foil");
        STACKED_CERAMIC_CAPACITOR = customMetaItems.addItem(191, "stacked_ceramic_capacitor");
        RAW_CERAMIC_CAPACITOR = customMetaItems.addItem(192, "raw_ceramic_capacitor");

        CHIP_INSULATED_SILICON = customMetaItems.addItem(193, "chip.insulated_silicon");
        CHIP_INSULATED_SILICON_GERMANIUM = customMetaItems.addItem(194, "chip.insulated_silicon_germanium");
        CHIP_N_DOPED_SILICON = customMetaItems.addItem(195, "chip.n_doped_silicon");
        CHIP_SILICON_DIOXIDE = customMetaItems.addItem(196, "chip.silicon_dioxide");

        FUSED_QUARTZ = customMetaItems.addItem(197, "fused_quartz");

        THICK_FILM_SUBSTRATE_WAFER = customMetaItems.addItem(200, "thick_film_substrate_wafer");

        VTI_RICH_PIG_IRON = customMetaItems.addItem(201, "vti_rich_pig_iron");
        VT_SLAG = customMetaItems.addItem(202, "vt_slag");

        // metal sponges 6200 - 6300
        SPONGE_TITANIUM = customMetaItems.addItem(6200, "sponge.titanium");
        SPONGE_TITANIUM_CRUDE = customMetaItems.addItem(6201, "sponge.titanium.crude");
        SPONGE_ZIRCONIUM = customMetaItems.addItem(6202, "sponge.zirconium");
        SPONGE_ZIRCONIUM_CRUDE = customMetaItems.addItem(6203, "sponge.zirconium.crude");
        SPONGE_HAFNIUM = customMetaItems.addItem(6204, "sponge.hafnium");
        SPONGE_HAFNIUM_CRUDE = customMetaItems.addItem(6205, "sponge.hafnium.crude");
        SPONGE_PLATINUM = customMetaItems.addItem(6206, "sponge.platinum");
        SPONGE_CADMIUM = customMetaItems.addItem(6207, "sponge.cadmium");
        SPONGE_INDIUM = customMetaItems.addItem(6208, "sponge.indium");

        BOUND_LEATHER = customMetaItems.addItem(210, "bound_leather");

        GLASS_FIBERS = customMetaItems.addItem(213, "glass_fibers");
        EPOXY_LAMINA = customMetaItems.addItem(214, "epoxy_lamina");

        BEADS_AMBERLYST_CH = customMetaItems.addItem(250, "beads.amberlyst_ch");
        BEADS_AG_FIFTY_W_X_EIGHT = customMetaItems.addItem(251, "beads.ag_fifty_w_x_eight");
        BEADS_RHENIUM_ION_EXCHANGE = customMetaItems.addItem(252, "beads.rhenium_ion_exchange");
        BEADS_LOADED_RHENIUM_ION_EXCHANGE = customMetaItems.addItem(253, "beads.loaded_rhenium_ion_exchange");

        MYLAR = customMetaItems.addItem(300, "mylar");
        SPINNERET = customMetaItems.addItem(301, "spinneret");

        CHUNK_MAGNETITE = customMetaItems.addItem(1000, "chunk.magnetite");
        HOT_IRON_ROD = customMetaItems.addItem(1001, "hot_iron_rod");
        VOLTAIC_PILE = customMetaItems.addItem(1002, "voltaic_pile").setMaxStackSize(1);
        ELECTROLYTE_PAPER = customMetaItems.addItem(1003, "electrolyte_paper");

        STEAM_PISTON = customMetaItems.addItem(1100, "steam.piston");
        STEAM_MOTOR = customMetaItems.addItem(1101, "steam.motor");

        // SPACESHIP_ME_SCRAP = customMetaItems.addItem(2000, "spaceship.me.scrap");

        WAFER_PATTERN_PROCESSOR = customMetaItems.addItem(2001, "wafer.pattern.processor");
        WAFER_PATTERN_MEMORY = customMetaItems.addItem(2002, "wafer.pattern.memory");

        PLATE_PATTERN_PROCESSOR = customMetaItems.addItem(2003, "plate.pattern.processor");
        PLATE_PATTERN_MEMORY = customMetaItems.addItem(2004, "plate.pattern.memory");

        PATTERN_PROCESSOR = customMetaItems.addItem(2005, "pattern.processor");
        PATTERN_MEMORY = customMetaItems.addItem(2006, "pattern.memory");

        STORAGE_SEGMENT = customMetaItems.addItem(2007, "storage.segment");
        GUN_BARREL_STEEL = customMetaItems.addItem(2500, "gun.barrel.steel");
        // Placeholders until GCYS is availablecustom
        CIRCUIT_GOOWARE_PROCESSOR = customMetaItems.addItem(3000, "circuit.gooware_processor");
        CIRCUIT_GOOWARE_ASSEMBLY = customMetaItems.addItem(3001, "circuit.gooware_assembly");
        CIRCUIT_GOOWARE_COMPUTER = customMetaItems.addItem(3002, "circuit.gooware_computer");
        CIRCUIT_GOOWARE_MAINFRAME = customMetaItems.addItem(3003, "circuit.gooware_mainframe");

        CIRCUIT_OPTICAL_PROCESSOR = customMetaItems.addItem(3004,"circuit.optical_processor");
        CIRCUIT_OPTICAL_ASSEMBLY = customMetaItems.addItem(3005,"circuit.optical_assembly");
        CIRCUIT_OPTICAL_COMPUTER = customMetaItems.addItem(3006,"circuit.optical_computer");
        CIRCUIT_OPTICAL_MAINFRAME = customMetaItems.addItem(3007,"circuit.optical_mainframe");

        CIRCUIT_SPINTRONIC_PROCESSOR = customMetaItems.addItem(3008, "circuit.spintronic_processor");
        CIRCUIT_SPINTRONIC_ASSEMBLY = customMetaItems.addItem(3009, "circuit.spintronic_assembly");
        CIRCUIT_SPINTRONIC_COMPUTER = customMetaItems.addItem(3010, "circuit.spintronic_computer");
        CIRCUIT_SPINTRONIC_MAINFRAME = customMetaItems.addItem(3011, "circuit.spintronic_mainframe");

        CIRCUIT_COSMIC_PROCESSOR = customMetaItems.addItem(3012, "circuit.cosmic_processor");
        CIRCUIT_COSMIC_ASSEMBLY = customMetaItems.addItem(3013, "circuit.cosmic_assembly");
        CIRCUIT_COSMIC_COMPUTER = customMetaItems.addItem(3014, "circuit.cosmic_computer");
        CIRCUIT_COSMIC_MAINFRAME = customMetaItems.addItem(3015, "circuit.cosmic_mainframe");

        CIRCUIT_SUPRACAUSAL_PROCESSOR = customMetaItems.addItem(3016, "circuit.supracausal_processor");
        CIRCUIT_SUPRACAUSAL_ASSEMBLY = customMetaItems.addItem(3017, "circuit.supracausal_assembly");
        CIRCUIT_SUPRACAUSAL_COMPUTER = customMetaItems.addItem(3018, "circuit.supracausal_computer");
        CIRCUIT_SUPRACAUSAL_MAINFRAME = customMetaItems.addItem(3019, "circuit.supracausal_mainframe");

        CIRCUIT_SUPRACHRONAL_ULV = customMetaItems.addItem(3020, "circuit.suprachronal.ulv");
        CIRCUIT_SUPRACHRONAL_LV = customMetaItems.addItem(3021, "circuit.suprachronal.lv");
        CIRCUIT_SUPRACHRONAL_MV = customMetaItems.addItem(3022, "circuit.suprachronal.mv");
        CIRCUIT_SUPRACHRONAL_HV = customMetaItems.addItem(3023, "circuit.suprachronal.hv");
        CIRCUIT_SUPRACHRONAL_EV = customMetaItems.addItem(3024, "circuit.suprachronal.ev");
        CIRCUIT_SUPRACHRONAL_IV = customMetaItems.addItem(3025, "circuit.suprachronal.iv");
        CIRCUIT_SUPRACHRONAL_LUV = customMetaItems.addItem(3026, "circuit.suprachronal.luv");
        CIRCUIT_SUPRACHRONAL_ZPM = customMetaItems.addItem(3027, "circuit.suprachronal.zpm");
        CIRCUIT_SUPRACHRONAL_UV = customMetaItems.addItem(3028, "circuit.suprachronal.uv");
        CIRCUIT_SUPRACHRONAL_UHV = customMetaItems.addItem(3029, "circuit.suprachronal.uhv");
        CIRCUIT_SUPRACHRONAL_UEV = customMetaItems.addItem(3030, "circuit.suprachronal.uev");
        CIRCUIT_SUPRACHRONAL_UIV = customMetaItems.addItem(3031, "circuit.suprachronal.uiv");
        CIRCUIT_SUPRACHRONAL_UXV = customMetaItems.addItem(3032, "circuit.suprachronal.uxv");
        CIRCUIT_SUPRACHRONAL_OPV = customMetaItems.addItem(3033, "circuit.suprachronal.opv");
        CIRCUIT_SUPRACHRONAL_MAX = customMetaItems.addItem(3034, "circuit.suprachronal.max");

        // WAFER_ADVANCED_RANDOM_ACCESS_MEMORY = customMetaItems.addItem(3035, "wafer.advanced_random_access_memory");
        // PLATE_ADVANCED_RANDOM_ACCESS_MEMORY = customMetaItems.addItem(3036, "plate.advanced_random_access_memory");

        // Batteries 4000-4100
        BATTERY_LEAD_ACID = customMetaItems.addItem(4000, "battery.lead_acid").addComponents(ElectricStats.createRechargeableBattery(120000, GTValues.LV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.LV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        CATHODE_LEAD = customMetaItems.addItem(4001, "cathode.lead");
        ANODE_LEAD = customMetaItems.addItem(4002, "anode.lead");

        // BATTERY_MV_LEAD_ACID = customMetaItems.addItem(4003, "battery.mv.lead_acid").addComponents(ElectricStats.createRechargeableBattery(480000, GTValues.MV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        // BATTERY_HV_LEAD_ACID = customMetaItems.addItem(4004, "battery.hv.lead_acid").addComponents(ElectricStats.createRechargeableBattery(1440000, GTValues.HV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.HV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        // BATTERY_MV_LITHIUM_ION = customMetaItems.addItem(4005, "battery.mv.lithium_ion").addComponents(ElectricStats.createRechargeableBattery(600000, GTValues.MV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.MV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        // BATTERY_HV_LITHIUM_ION = customMetaItems.addItem(4006, "battery.hv.lithium_ion").addComponents(ElectricStats.createRechargeableBattery(2400000, GTValues.HV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.HV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);
        // BATTERY_EV_LITHIUM_ION = customMetaItems.addItem(4007, "battery.ev.lithium_ion").addComponents(ElectricStats.createRechargeableBattery(9600000, GTValues.EV)).setUnificationData(OrePrefix.battery, MarkerMaterials.Tier.EV).setModelAmount(8).setCreativeTabs(GregTechAPI.TAB_GREGTECH_TOOLS);

        VACUUM_TUBE_COMPONENTS = customMetaItems.addItem(4101, "vacuum_tube_components");

        // Dusts & Pulps 4500-4999

        // Circuit Stuff 5000-6000
        // Photomasks 5000-5099
        RUBYLITH = customMetaItems.addItem(5000, "rubylith");
        RUBYLITH_FILM = customMetaItems.addItem(5001, "rubylith_film");
        STENCIL_IC = customMetaItems.addItem(5002, "stencil.ic");
        STENCIL_CPU = customMetaItems.addItem(5003, "stencil.cpu");
        STENCIL_RAM = customMetaItems.addItem(5004, "stencil.ram");
        STENCIL_PCB = customMetaItems.addItem(5005, "stencil.pcb");
        STENCIL_ULPIC = customMetaItems.addItem(5006, "stencil.ulpic");
        STENCIL_LPIC = customMetaItems.addItem(5007, "stencil.lpic");
        MASK_BLANK = customMetaItems.addItem(5020, "mask.blank");
        MASK_IC = customMetaItems.addItem(5021, "mask.ic");
        MASK_CPU = customMetaItems.addItem(5022, "mask.cpu");
        MASK_RAM = customMetaItems.addItem(5023, "mask.ram");
        MASK_PCB = customMetaItems.addItem(5024, "mask.pcb");
        MASK_ULPIC = customMetaItems.addItem(5025, "mask.ulpic");
        MASK_LPIC = customMetaItems.addItem(5026, "mask.lpic");
        MASK_NAND = customMetaItems.addItem(5027, "mask.nand");
        MASK_NOR = customMetaItems.addItem(5028, "mask.nor");
        MASK_ADVANCED = customMetaItems.addItem(5029, "mask.advanced");
        PATTERNED_IC = customMetaItems.addItem(5100, "patterned.ic");
        PATTERNED_CPU = customMetaItems.addItem(5101, "patterned.cpu");
        PATTERNED_RAM = customMetaItems.addItem(5102, "patterned.ram");
        PATTERNED_ULPIC = customMetaItems.addItem(5103, "patterned.ulpic");
        PATTERNED_LPIC = customMetaItems.addItem(5104, "patterned.lpic");
        PATTERNED_SILICON_DIOXIDE = customMetaItems.addItem(5105, "patterned.silicon_dioxide");
        PATTERNED_POLYSILICON = customMetaItems.addItem(5106, "patterned.polysilicon");
        PATTERNED_SILICON_NITRIDE = customMetaItems.addItem(5107, "patterned.silicon_nitride");
        PATTERNED_NAND = customMetaItems.addItem(5108, "patterned.nand");
        PATTERNED_NOR = customMetaItems.addItem(5109, "patterned.nor");
        PATTERNED_BOARD_PHENOLIC = customMetaItems.addItem(5150, "patterned.board.phenolic");
        PATTERNED_BOARD_PLASTIC = customMetaItems.addItem(5151, "patterned.board.plastic");
        LAMINATED_BOARD_PHENOLIC = customMetaItems.addItem(5200, "laminated.board.phenolic");
        ETCHED_IC = customMetaItems.addItem(5300, "etched.ic");
        ETCHED_CPU = customMetaItems.addItem(5301, "etched.cpu");
        ETCHED_RAM = customMetaItems.addItem(5302, "etched.ram");
        ETCHED_ULPIC = customMetaItems.addItem(5303, "etched.ulpic");
        ETCHED_LPIC = customMetaItems.addItem(5304, "etched.lpic");
        ETCHED_SILICON_DIOXIDE = customMetaItems.addItem(5305, "etched.silicon_dioxide");
        ETCHED_POLYSILICON = customMetaItems.addItem(5306, "etched.polysilicon");
        ETCHED_SILICON_NITRIDE = customMetaItems.addItem(5307, "etched.silicon_nitride");

        // Light Sources 6000-6100
        CARBON_ARC_LAMP = customMetaItems.addItem(6000, "carbon_arc_lamp");
        INCANDESCENT_LIGHT = customMetaItems.addItem(6001, "incandescent_light");
        HALOGEN_LIGHT = customMetaItems.addItem(6002, "halogen_light");
        FLUORESCENT_LIGHT = customMetaItems.addItem(6003, "fluorescent_light");
        LED_LIGHT = customMetaItems.addItem(6004, "led_light");

        // Superconductors 6100-6200
        ASSEMBLYMANGANESEPHOSPHIDE = customMetaItems.addItem(6100, "assemblymanganesephosphide");
        BASEMANGANESEPHOSPHIDE = customMetaItems.addItem(6101, "basemanganesephosphide");
        CANNEDMAGNESIUMDIBORIDE = customMetaItems.addItem(6102, "cannedmagnesiumdiboride");
        TUBEMAGNESIUMDIBORIDE = customMetaItems.addItem(6103, "tubemagnesiumdiboride");
        BASEMAGNESIUMDIBORIDE = customMetaItems.addItem(6104, "basemagnesiumdiboride");
        CANNEDMERCURYBARIUMCALCIUMCUPRATE = customMetaItems.addItem(6105, "cannedmercurybariumcalciumcuprate");
        TUBEMERCURYBARIUMCALCIUMCUPRATE = customMetaItems.addItem(6106, "tubemercurybariumcalciumcuprate");
        BASEMERCURYBARIUMCALCIUMCUPRATE = customMetaItems.addItem(6107, "basemercurybariumcalciumcuprate");
        ASSEMBLYURANIUMTRIPLATINUM = customMetaItems.addItem(6108, "assemblyuraniumtriplatinum");
        BASEURANIUMTRIPLATINUM = customMetaItems.addItem(6109, "baseuraniumtriplatinum");
        CANNEDSAMARIUMIRONARSENICOXIDE = customMetaItems.addItem(6110, "cannedsamariumironarsenicoxide");
        TUBESAMARIUMIRONARSENICOXIDE = customMetaItems.addItem(6111, "tubesamariumironarsenicoxide");
        BASESAMARIUMIRONARSENICOXIDE = customMetaItems.addItem(6112, "basesamariumironarsenicoxide");
        ASSEMBLYINDIUMTINBARIUMTITANIUMCUPRATE = customMetaItems.addItem(6113, "assemblyindiumtinbariumtitaniumcuprate");
        BASEINDIUMTINBARIUMTITANIUMCUPRATE = customMetaItems.addItem(6114, "baseindiumtinbariumtitaniumcuprate");
        ASSEMBLYURANIUMRHODIUMDINAQUADIDE = customMetaItems.addItem(6115, "assemblyuraniumrhodiumdinaquadide");
        BASEURANIUMRHODIUMDINAQUADIDE = customMetaItems.addItem(6116, "baseuraniumrhodiumdinaquadide");
        ASSEMBLYENRICHEDNAQUADAHTRINIUMEUROPIUMDURANIDE = customMetaItems.addItem(6117, "assemblyenrichednaquadahtriniumeuropiumduranide");
        BASEENRICHEDNAQUADAHTRINIUMEUROPIUMDURANIDE = customMetaItems.addItem(6118, "baseenrichednaquadahtriniumeuropiumduranide");
        ASSEMBLYRUTHENIUMTRINIUMAMERICIUMNEUTRONATE = customMetaItems.addItem(6119, "assemblyrutheniumtriniumamericiumneutronate");
        BASERUTHENIUMTRINIUMAMERICIUMNEUTRONATE = customMetaItems.addItem(6120, "baserutheniumtriniumamericiumneutronate");

        // Seed crystals 7000-7500
        SEED_CRYSTAL_SILICON = customMetaItems.addItem(7000, "seed_crystal.silicon");
        SEED_CRYSTAL_GALLIUM_ARSENIDE = customMetaItems.addItem(7001, "seed_crystal.gallium_arsenide");
        SEED_CRYSTAL_ALUMINA = customMetaItems.addItem(7002, "seed_crystal.alumina");
        SEED_CRYSTAL_BERYLLIUM_OXIDE = customMetaItems.addItem(7003, "seed_crystal.beryllium_oxide");
        SEED_CRYSTAL_EMERALD = customMetaItems.addItem(7004, "seed_crystal.emerald");
        SEED_CRYSTAL_LITHIUM_NIOBATE = customMetaItems.addItem(7005, "seed_crystal.lithium_niobate");

        // Boules 7500-8000
        UNREFINED_BOULE_SILICON = customMetaItems.addItem(7500, "unrefined_boule.silicon");
        BOULE_GALLIUM_ARSENIDE = customMetaItems.addItem(7501, "boule.gallium_arsenide");
        UNREFINED_BOULE_GALLIUM_ARSENIDE = customMetaItems.addItem(7502, "unrefined_boule.gallium_arsenide");
        BOULE_ALUMINA = customMetaItems.addItem(7503, "boule.alumina");
        BOULE_BERYLLIUM_OXIDE = customMetaItems.addItem(7504, "boule.beryllium_oxide");
        BOULE_EMERALD = customMetaItems.addItem(7505, "boule.emerald");
        BOULE_SAPPHIRE = customMetaItems.addItem(7506, "boule.sapphire");
        BOULE_RUBY = customMetaItems.addItem(7507, "boule.ruby");
        BOULE_SILICON_GERMANIUM = customMetaItems.addItem(7508, "boule.silicon_germanium");
        BOULE_LITHIUM_NIOBATE = customMetaItems.addItem(7509, "boule.lithium_niobate");
        WAFER_DOPED_SILICON = customMetaItems.addItem(8000, "wafer.doped.silicon");
        WAFER_N_DOPED_SILICON = customMetaItems.addItem(8001, "wafer.n_doped.silicon");
        WAFER_SILICON_DIOXIDE = customMetaItems.addItem(8002, "wafer.silicon_dioxide");
        WAFER_ALUMINA = customMetaItems.addItem(8003, "wafer.alumina");
        WAFER_BERYLLIUM_OXIDE = customMetaItems.addItem(8004, "wafer.beryllium_oxide");
        WAFER_SILICON_GERMANIUM = customMetaItems.addItem(8005, "wafer.silicon_germanium");
        WAFER_INSULATED_SILICON = customMetaItems.addItem(8006, "wafer.insulated_silicon");
        WAFER_INSULATED_SILICON_GERMANIUM = customMetaItems.addItem(8007, "wafer.insulated_silicon_germanium");
        WAFER_DOPED_SILICON_DIOXIDE = customMetaItems.addItem(8008, "wafer.doped.silicon_dioxide");
        WAFER_POLYSILICON = customMetaItems.addItem(8009, "wafer.polysilicon");
        WAFER_DOPED_POLYSILICON = customMetaItems.addItem(8010, "wafer.doped.polysilicon");
        WAFER_SILICON_NITRIDE = customMetaItems.addItem(8011, "wafer.silicon_nitride");
        WAFER_NICKEL = customMetaItems.addItem(8012, "wafer.nickel");
        WAFER_GALLIUM_ARSENIDE = customMetaItems.addItem(8013, "wafer.gallium_arsenide");
        WAFER_RAW_SILICON = customMetaItems.addItem(8014, "wafer.raw.silicon");
        WAFER_TREATED_SILICON = customMetaItems.addItem(8015, "wafer.treated.silicon");

        // Crops 9000-10000
        SEED_COTTON = customMetaItems.addItem(9000, "seed.cotton");
        CROP_COTTON = customMetaItems.addItem(9001, "crop.cotton");
        STEM_COTTON = customMetaItems.addItem(9002, "stem.cotton");
    }

    private static void addTieredOredictItem (OreDictValueItem[] items, int id, int RGB, OrePrefix prefix) {

        for (int i = 0; i < items.length; i++) {
            items[i] = oreDictItem.addOreDictItem(id + i, SuSyValues.TierMaterials[i + 1].toString(), RGB, MaterialIconSet.DULL, prefix, I18n.format("gregtech.universal.catalysts.tooltip.tier", GTValues.V[i], GTValues.VN[i]));
        }

    }
}
