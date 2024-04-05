package supersymmetry.loaders;

import gregtech.api.recipes.ModHandler;

public class SuSyRemoves {
    public static void init() {
        String[] name_removals = {
                "gregtech:cover_fluid_voiding",
                "gregtech:cover_item_voiding",
                "gregtech:fluid_filter_lapis",
                "gregtech:fluid_filter_sodalite",
                "gregtech:fluid_filter_lazurite",
                "gregtech:comparator_certus",
//                "gregtech:gregtech.machine.world_accelerator.lv",
//                "gregtech:gregtech.machine.world_accelerator.mv",
//                "gregtech:gregtech.machine.world_accelerator.hv",
//                "gregtech:gregtech.machine.world_accelerator.ev",
//                "gregtech:gregtech.machine.world_accelerator.iv",
//                "gregtech:gregtech.machine.world_accelerator.luv",
//                "gregtech:gregtech.machine.world_accelerator.zpm",
//                "gregtech:gregtech.machine.world_accelerator.uv",
                "gregtech:nano_helmet",
                "gregtech:nano_chestplate",
                "gregtech:nano_leggings",
                "gregtech:nano_boots",
//                "gregtech:super_chest_lv",
//                "gregtech:super_chest_mv",
//                "gregtech:super_chest_hv",
//                "gregtech:super_chest_ev",
//                "gregtech:super_tank_lv",
//                "gregtech:super_tank_mv",
//                "gregtech:super_tank_hv",
//                "gregtech:super_tank_ev",
//                "gregtech:quantum_chest_iv",
//                "gregtech:quantum_chest_luv",
//                "gregtech:quantum_chest_zpm",
//                "gregtech:quantum_chest_uv",
//                "gregtech:quantum_chest_uhv",
//                "gregtech:quantum_tank_iv",
//                "gregtech:quantum_tank_luv",
//                "gregtech:quantum_tank_zpm",
//                "gregtech:quantum_tank_uv",
//                "gregtech:quantum_tank_uhv",
                "gregtech:casing_grate_casing"
        };

        String[] tiered_removals = {
                "gregtech:gregtech.machine.polarizer.",
                "gregtech:gregtech.machine.electromagnetic_separator.",
                "gregtech:gregtech.machine.chemical_reactor.",
                "gregtech:gregtech.machine.arc_furnace.",
                "gregtech:gregtech.machine.laser_engraver.",
                "gregtech:gregtech.machine.fermenter.",
        };

        for (String name : name_removals) {
            ModHandler.removeRecipeByName(name);
        }

        for (String name : tiered_removals) {
            ModHandler.removeTieredRecipeByName(name, 0, 8);
        }
    }
}
