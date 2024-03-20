package supersymmetry.loaders.recipes.eletronics;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static net.minecraft.init.Items.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class FieldGenerators {
    private static FluidStack getLiquid(Material mat, int amount) {
        if (mat == Oxygen || mat == Helium) {
            return mat.getFluid(FluidStorageKeys.LIQUID, amount);
        }

        return mat.getFluid(amount);
    }
    public static void init() {
//REMOVALS

        String[] name_removals = {
                "gregtech:field_generator_lv",
                "gregtech:field_generator_mv",
                "gregtech:field_generator_hv",
                "gregtech:field_generator_ev",
                "gregtech:field_generator_iv"
        };

        for (String name : name_removals) {
            ModHandler.removeRecipeByName(name);
        }

// LV Field Generator * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack(ENDER_PEARL),
                OreDictUnifier.get(plate, Steel, 2),
                MICROPROCESSOR_LV.getStackForm(2),
                OreDictUnifier.get(wireGtQuadruple, ManganesePhosphide, 4));
// MV Field Generator * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack(ENDER_EYE),
                OreDictUnifier.get(plate, Aluminium, 2),
                PROCESSOR_MV.getStackForm(2),
                OreDictUnifier.get(wireGtQuadruple, MagnesiumDiboride, 4));
// HV Field Generator * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES,
                QUANTUM_EYE.getStackForm(),
                OreDictUnifier.get(plate, StainlessSteel, 2),
                PROCESSOR_ASSEMBLY_HV.getStackForm(2),
                OreDictUnifier.get(wireGtQuadruple, MercuryBariumCalciumCuprate, 4));
// EV Field Generator * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES,
                new ItemStack(NETHER_STAR),
                OreDictUnifier.get(plateDouble, Titanium, 2),
                NANO_PROCESSOR_ASSEMBLY_EV.getStackForm(2),
                OreDictUnifier.get(wireGtQuadruple, UraniumTriplatinum, 4));
// IV Field Generator * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES,
                QUANTUM_STAR.getStackForm(),
                OreDictUnifier.get(plateDouble, TungstenSteel, 2),
                QUANTUM_ASSEMBLY_IV.getStackForm(2),
                OreDictUnifier.get(wireGtQuadruple, SamariumIronArsenicOxide, 4));
// LuV Field Generator * 1
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[]{
                OreDictUnifier.get(frameGt, HSSS),
                OreDictUnifier.get(plate, HSSS, 6),
                QUANTUM_STAR.getStackForm(),
                EMITTER_LuV.getStackForm(2),
                CRYSTAL_ASSEMBLY_LUV.getStackForm(2),
                OreDictUnifier.get(wireFine, IndiumTinBariumTitaniumCuprate, 64),
                OreDictUnifier.get(wireFine, IndiumTinBariumTitaniumCuprate, 64),
                OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 4)
        }, new FluidStack[]{SolderingAlloy.getFluid(576)});
// ZPM Field Generator * 1
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[]{
                OreDictUnifier.get(frameGt, NaquadahAlloy),
                OreDictUnifier.get(plate, NaquadahAlloy, 6),
                QUANTUM_STAR.getStackForm(),
                EMITTER_ZPM.getStackForm(2),
                WETWARE_PROCESSOR_ASSEMBLY_ZPM.getStackForm(2),
                OreDictUnifier.get(wireFine, UraniumRhodiumDinaquadide, 64),
                OreDictUnifier.get(wireFine, UraniumRhodiumDinaquadide, 64),
                OreDictUnifier.get(cableGtSingle, VanadiumGallium, 4)
        }, new FluidStack[]{SolderingAlloy.getFluid(1152)});
// UV Field Generator * 1
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[]{
                OreDictUnifier.get(frameGt, Tritanium),
                OreDictUnifier.get(plate, Tritanium, 6),
                GRAVI_STAR.getStackForm(),
                EMITTER_UV.getStackForm(2),
                WETWARE_SUPER_COMPUTER_UV.getStackForm(2),
                OreDictUnifier.get(wireFine, EnrichedNaquadahTriniumEuropiumDuranide, 64),
                OreDictUnifier.get(wireFine, EnrichedNaquadahTriniumEuropiumDuranide, 64),
                OreDictUnifier.get(cableGtSingle, YttriumBariumCuprate, 4)
        }, new FluidStack[]{SolderingAlloy.getFluid(1728), Naquadria.getFluid(576)});


//REPLACEMENTS

        Map<Material, Integer> cryoFluids = new HashMap<>();
        cryoFluids.put(LiquidHydrogen, 14);
        cryoFluids.put(Oxygen, 90);
        cryoFluids.put(Helium, 4);
        cryoFluids.put(LiquidNeon, 27);
        cryoFluids.put(LiquidArgon, 87);
        cryoFluids.put(LiquidKrypton, 120);
        cryoFluids.put(LiquidXenon, 165);
        cryoFluids.put(LiquidNitrogen, 77);
        cryoFluids.put(LiquidRefineryGas, 80);
        cryoFluids.put(LiquidNaturalGas, 80);

        cryoFluids.forEach((Material key, Integer val) -> {
            if(100 > val) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(ELECTRIC_MOTOR_LV)
                        .input(FLUID_CELL_LARGE_STEEL)
                        .input(wireGtQuadruple, ManganesePhosphide, 4)
                        .input(circuit, MarkerMaterials.Tier.LV, 2)
                        .fluidInputs(getLiquid(key, 250))
                        .output(FIELD_GENERATOR_LV)
                        .duration(100)
                        .EUt(30)
                        .buildAndRegister();
            }
            if(45 > val) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(ELECTRIC_MOTOR_MV)
                        .input(FLUID_CELL_LARGE_ALUMINIUM)
                        .input(wireGtQuadruple, MagnesiumDiboride, 4)
                        .input(circuit, MarkerMaterials.Tier.MV, 2)
                        .fluidInputs(getLiquid(key, 500))
                        .output(FIELD_GENERATOR_MV)
                        .duration(100)
                        .EUt(120)
                        .buildAndRegister();
            }
            if(25 > val) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(ELECTRIC_MOTOR_HV)
                        .input(FLUID_CELL_LARGE_STAINLESS_STEEL)
                        .input(wireGtQuadruple, MercuryBariumCalciumCuprate, 4)
                        .input(circuit, MarkerMaterials.Tier.HV, 2)
                        .fluidInputs(getLiquid(key, 1000))
                        .output(FIELD_GENERATOR_HV)
                        .duration(100)
                        .EUt(480)
                        .buildAndRegister();
            }
            if(5 > val) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(ELECTRIC_MOTOR_EV)
                        .input(FLUID_CELL_LARGE_TITANIUM)
                        .input(wireGtQuadruple, UraniumTriplatinum, 4)
                        .input(circuit, MarkerMaterials.Tier.EV, 2)
                        .fluidInputs(getLiquid(key, 1500))
                        .output(FIELD_GENERATOR_EV)
                        .duration(100)
                        .EUt(1920)
                        .buildAndRegister();
            }
            if(5 > val) {
                ASSEMBLER_RECIPES.recipeBuilder()
                        .input(ELECTRIC_MOTOR_IV)
                        .input(FLUID_CELL_LARGE_TUNGSTEN_STEEL)
                        .input(wireGtQuadruple, SamariumIronArsenicOxide, 4)
                        .input(circuit, MarkerMaterials.Tier.IV, 2)
                        .fluidInputs(getLiquid(key, 2000))
                        .output(FIELD_GENERATOR_IV)
                        .duration(100)
                        .EUt(7680)
                        .buildAndRegister();
            }
            if(5 > val) {
                ASSEMBLY_LINE_RECIPES.recipeBuilder()
                        .input(frameGt, HSSS)
                        .input(plate, HSSS, 6)
                        .input(EMITTER_LuV, 2)
                        .input(circuit, MarkerMaterials.Tier.LuV, 2)
                        .input(wireFine, IndiumTinBariumTitaniumCuprate, 64)
                        .input(wireFine, IndiumTinBariumTitaniumCuprate, 64)
                        .input(cableGtSingle, NiobiumTitanium, 4)
                        .fluidInputs(SolderingAlloy.getFluid(576))
                        .fluidInputs(getLiquid(key, 4000))
                        .output(FIELD_GENERATOR_LuV)
                        .duration(600)
                        .EUt(7680)
                        .buildAndRegister();
            }
            if(5 > val) {
                ASSEMBLY_LINE_RECIPES.recipeBuilder()
                        .input(frameGt, NaquadahAlloy)
                        .input(plate, NaquadahAlloy, 6)
                        .input(EMITTER_ZPM, 2)
                        .input(circuit, MarkerMaterials.Tier.ZPM, 2)
                        .input(wireFine, UraniumRhodiumDinaquadide, 64)
                        .input(wireFine, UraniumRhodiumDinaquadide, 64)
                        .input(cableGtSingle, VanadiumGallium, 4)
                        .fluidInputs(SolderingAlloy.getFluid(1152))
                        .fluidInputs(getLiquid(key, 8000))
                        .output(FIELD_GENERATOR_ZPM)
                        .duration(600)
                        .EUt(24000)
                        .buildAndRegister();
            }
            if(5 > val) {
                ASSEMBLY_LINE_RECIPES.recipeBuilder()
                        .input(frameGt, Tritanium)
                        .input(plate, Tritanium, 6)
                        .input(EMITTER_UV, 2)
                        .input(circuit, MarkerMaterials.Tier.UV, 2)
                        .input(wireFine, EnrichedNaquadahTriniumEuropiumDuranide, 64)
                        .input(wireFine, EnrichedNaquadahTriniumEuropiumDuranide, 64)
                        .input(cableGtSingle, YttriumBariumCuprate, 4)
                        .fluidInputs(SolderingAlloy.getFluid(1728))
                        .fluidInputs(Naquadria.getFluid(576))
                        .fluidInputs(getLiquid(key, 16000))
                        .output(FIELD_GENERATOR_UV)
                        .duration(600)
                        .EUt(100000)
                        .buildAndRegister();
            }
        });
    }
}
