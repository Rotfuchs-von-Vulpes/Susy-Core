package supersymmetry.loaders.recipes.chemistry;

import com.cleanroommc.groovyscript.compat.vanilla.OreDict;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static gregtech.common.metatileentities.MetaTileEntities.*;
import static gregtech.common.metatileentities.MetaTileEntities.POLARIZER;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static gregicality.multiblocks.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;

public class Magnets {
    public static void init() {
        //NEODYMIUM MAGNETS
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Neodymium, 2)
                .input(dust, Iron, 14)
                .input(dust, Boron, 1)
                .output(dust, NeodymiumAlloy, 17)
                .duration(400)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(ingot, NeodymiumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(ingot, TreatedNeodymiumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(plate, NeodymiumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(plate, TreatedNeodymiumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(stick, NeodymiumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(stick, TreatedNeodymiumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(stickLong, NeodymiumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(stickLong, TreatedNeodymiumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(ring, NeodymiumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(ring, TreatedNeodymiumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

//SAMARIUM MAGNETS
        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Samarium)
                .input(dust, Cobalt, 5)
                .fluidInputs(Argon.getFluid(300))
                .fluidOutputs(SamariumAlloy.getFluid(864))
                .blastFurnaceTemp(1800)
                .duration(300)
                .EUt(1920)
                .buildAndRegister();;

        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_LONG_ROD)
                .input(dust, SamariumAlloy)
                .output(stickLong, SamariumAlloy)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_RING)
                .input(dust, SamariumAlloy)
                .output(ring, SamariumAlloy, 4)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_ROD)
                .input(dust, SamariumAlloy)
                .output(stick, SamariumAlloy, 2)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_PLATE)
                .input(dust, SamariumAlloy)
                .output(plate, SamariumAlloy)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        FORMING_PRESS_RECIPES.recipeBuilder()
                .notConsumable(SHAPE_MOLD_INGOT)
                .input(dust, SamariumAlloy)
                .output(ingot, SamariumAlloy)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(ingot, SamariumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(ingot, TreatedSamariumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(plate, SamariumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(plate, TreatedSamariumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(stick, SamariumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(stick, TreatedSamariumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(stickLong, SamariumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(stickLong, TreatedSamariumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

        ELECTROLYZER_RECIPES.recipeBuilder()
                .fluidInputs(SulfuricAcid.getFluid(100))
                .input(ring, SamariumAlloy)
                .input(dustSmall, Nickel, 1)
                .input(dustTiny, BoricAcid, 1)
                .output(ring, TreatedSamariumAlloy)
                .duration(120)
                .EUt(256)
                .buildAndRegister();;

//REPLACE MAGNETIC STUFF IN RECIPES

        ItemStack integratedCircuit = INTEGRATED_CIRCUIT.getStackForm();
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setInteger("Configuration", 1);
        integratedCircuit.setTagCompound(nbt);
// IV Electric Motor * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtDouble, Tungsten, 2), OreDictUnifier.get(stick, TungstenSteel, 2), OreDictUnifier.get(stick, NeodymiumMagnetic), OreDictUnifier.get(wireGtDouble, Graphene, 4));
// EV Electric Motor * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(cableGtDouble, Aluminium, 2), OreDictUnifier.get(stick, Titanium, 2), OreDictUnifier.get(stick, NeodymiumMagnetic), OreDictUnifier.get(wireGtDouble, Kanthal, 4));
// Extreme Voltage Coil * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(stick, NeodymiumMagnetic), OreDictUnifier.get(wireFine, TungstenSteel, 16), integratedCircuit);
// Insane Voltage Coil * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(stick, NeodymiumMagnetic), OreDictUnifier.get(wireFine, Iridium, 16), integratedCircuit);
// Ludicrous Voltage Coil * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(stick, SamariumMagnetic), OreDictUnifier.get(wireFine, Osmiridium, 16), integratedCircuit);
// Zero Point Module Voltage Coil * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(stick, SamariumMagnetic), OreDictUnifier.get(wireFine, Europium, 16), integratedCircuit);
// Ultimate Voltage Coil * 1
        removeRecipesByInputs(ASSEMBLER_RECIPES, OreDictUnifier.get(stick, SamariumMagnetic), OreDictUnifier.get(wireFine, Tritanium, 16), integratedCircuit);
// LuV Electric Motor * 1
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[]{
                OreDictUnifier.get(stickLong, SamariumMagnetic),
                OreDictUnifier.get(stickLong, HSSS, 2),
                OreDictUnifier.get(ring, HSSS, 2),
                OreDictUnifier.get(round, HSSS, 4),
                OreDictUnifier.get(wireFine, Ruridit, 64),
                OreDictUnifier.get(cableGtSingle, NiobiumTitanium, 2)
        }, new FluidStack[]{SolderingAlloy.getFluid(144), Lubricant.getFluid(250)});
// ZPM Electric Motor * 1
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[]{
                OreDictUnifier.get(stickLong, SamariumMagnetic),
                OreDictUnifier.get(stickLong, Osmiridium, 4),
                OreDictUnifier.get(ring, Osmiridium, 4),
                OreDictUnifier.get(round, Osmiridium, 8),
                OreDictUnifier.get(wireFine, Europium, 64),
                OreDictUnifier.get(wireFine, Europium, 32),
                OreDictUnifier.get(cableGtSingle, VanadiumGallium, 2)
        }, new FluidStack[]{SolderingAlloy.getFluid(288), Lubricant.getFluid(500)});
        // ZPM Electric Motor * 1
// UV Electric Motor * 1
        removeRecipesByInputs(ASSEMBLY_LINE_RECIPES, new ItemStack[]{
                OreDictUnifier.get(stickLong, SamariumMagnetic),
                OreDictUnifier.get(stickLong, Tritanium, 4),
                OreDictUnifier.get(ring, Tritanium, 4),
                OreDictUnifier.get(round, Tritanium, 8),
                OreDictUnifier.get(wireFine, Americium, 64),
                OreDictUnifier.get(wireFine, Americium, 64),
                OreDictUnifier.get(cableGtSingle, YttriumBariumCuprate, 2)
        }, new FluidStack[]{SolderingAlloy.getFluid(576), Lubricant.getFluid(1000), Naquadria.getFluid(576)});

        ModHandler.removeRecipeByName("gregtech:electric_motor_ev");
        ModHandler.addShapedRecipe(true, "gregtech:electric_motor_ev",
                ELECTRIC_MOTOR_EV.getStackForm(), "CWS", "WMW", "SWC",
                'C', new UnificationEntry(cableGtDouble, Aluminium),
                'W', new UnificationEntry(wireGtDouble, Kanthal),
                'S', new UnificationEntry(stick, Titanium),
                'M', new UnificationEntry(stick, SteelMagnetic));

        ModHandler.removeRecipeByName("gregtech:electric_motor_iv");
        ModHandler.addShapedRecipe(true, "gregtech:electric_motor_iv",
                ELECTRIC_MOTOR_IV.getStackForm(), "CWS", "WMW", "SWC",
                'C', new UnificationEntry(cableGtDouble, Tungsten),
                'W', new UnificationEntry(wireGtDouble, Graphene),
                'S', new UnificationEntry(stick, Steel),
                'M', new UnificationEntry(stick, NeodymiumAlloyMagnetic));

        ModHandler.removeRecipeByName("gregtech:magnet_hv_battery.re.hv.sodium");
        ModHandler.addShapedRecipe(true, "gregtech:magnet_hv_battery.re.hv.sodium",
                ITEM_MAGNET_HV.getStackForm(), "SwS", "SBS", "WPW",
                'S', new UnificationEntry(stick, NeodymiumAlloyMagnetic),
                'B', BATTERY_HV_SODIUM,
                'W', new UnificationEntry(wireGtSingle, Gold),
                'P', new UnificationEntry(plate, StainlessSteel));

        ModHandler.removeRecipeByName("gregtech:magnet_hv_battery.re.hv.lithium");
        ModHandler.addShapedRecipe(true, "gregtech:magnet_hv_battery.re.hv.lithium",
                ITEM_MAGNET_HV.getStackForm(), "SwS", "SBS", "WPW",
                'S', new UnificationEntry(stick, NeodymiumAlloyMagnetic),
                'B', BATTERY_HV_LITHIUM,
                'W', new UnificationEntry(wireGtSingle, Gold),
                'P', new UnificationEntry(plate, StainlessSteel));

        ModHandler.removeRecipeByName("gregtech:magnet_hv_battery.re.hv.cadmium");
        ModHandler.addShapedRecipe(true, "gregtech:magnet_hv_battery.re.hv.cadmium",
                ITEM_MAGNET_HV.getStackForm(), "SwS", "SBS", "WPW",
                'S', new UnificationEntry(stick, NeodymiumAlloyMagnetic),
                'B', BATTERY_HV_CADMIUM,
                'W', new UnificationEntry(wireGtSingle, Gold),
                'P', new UnificationEntry(plate, StainlessSteel));

        ModHandler.removeRecipeByName("gregtech:magnet_hv_energy_crystal");
        ModHandler.addShapedRecipe(true, "gregtech:magnet_hv_energy_crystal",
                ITEM_MAGNET_HV.getStackForm(), "SwS", "SBS", "WPW",
                'S', new UnificationEntry(stick, NeodymiumAlloyMagnetic),
                'B', ENERGIUM_CRYSTAL,
                'W', new UnificationEntry(wireGtSingle, Gold),
                'P', new UnificationEntry(plate, StainlessSteel));

        ModHandler.removeRecipeByName("gregtech:gregtech.machine.electromagnetic_separator.ev");
        ModHandler.addShapedRecipe(true, "gregtech:gregtech.machine.electromagnetic_separator.ev",
                ELECTROMAGNETIC_SEPARATOR[EV].getStackForm(), "MCW", "CXS", "ECW",
                'M', CONVEYOR_MODULE_EV,
                'C', new UnificationEntry(cableGtSingle, Aluminium),
                'W', new UnificationEntry(wireGtQuadruple, Nichrome),
                'X', HULL[EV].getStackForm(),
                'S', new UnificationEntry(stick, Steel),
                'E', new UnificationEntry(circuit, MarkerMaterials.Tier.EV));

        ModHandler.removeRecipeByName("gregtech:gregtech.machine.electromagnetic_separator.iv");
        ModHandler.addShapedRecipe(true, "gregtech:gregtech.machine.electromagnetic_separator.iv",
                ELECTROMAGNETIC_SEPARATOR[IV].getStackForm(), "MCW", "CXS", "ECW",
                'M', CONVEYOR_MODULE_IV,
                'C', new UnificationEntry(cableGtSingle, Platinum),
                'W', new UnificationEntry(wireGtQuadruple, TungstenSteel),
                'X', HULL[IV].getStackForm(),
                'S', new UnificationEntry(stick, NeodymiumAlloy),
                'E', new UnificationEntry(circuit, MarkerMaterials.Tier.IV));

        ModHandler.removeRecipeByName("gregtech:gregtech.machine.polarizer.ev");
        ModHandler.addShapedRecipe(true, "gregtech:gregtech.machine.polarizer.ev",
                POLARIZER[EV].getStackForm(), "WSW", "CXC", "WSW",
                'C', new UnificationEntry(cableGtSingle, Aluminium),
                'W', new UnificationEntry(wireGtQuadruple, Nichrome),
                'X', HULL[EV].getStackForm(),
                'S', new UnificationEntry(stick, Steel));

        ModHandler.removeRecipeByName("gregtech:gregtech.machine.polarizer.iv");
        ModHandler.addShapedRecipe(true, "gregtech:gregtech.machine.polarizer.iv",
                POLARIZER[IV].getStackForm(), "WSW", "CXC", "WSW",
                'C', new UnificationEntry(cableGtSingle, Aluminium),
                'W', new UnificationEntry(wireGtQuadruple, TungstenSteel),
                'X', HULL[IV].getStackForm(),
                'S', new UnificationEntry(stick, NeodymiumAlloy));

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtDouble, Aluminium, 2)
                .input(stick, Titanium, 2)
                .input(stick, SteelMagnetic, 1)
                .input(wireGtDouble, Kanthal, 4)
                .output(ELECTRIC_MOTOR_EV)
                .duration(100)
                .EUt(30)
                .buildAndRegister();;

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(cableGtDouble, Tungsten, 2)
                .input(stick, TungstenSteel, 2)
                .input(stick, NeodymiumAlloyMagnetic, 1)
                .input(wireGtDouble, Graphene, 4)
                .output(ELECTRIC_MOTOR_IV)
                .duration(100)
                .EUt(30)
                .buildAndRegister();;

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, SteelMagnetic, 1)
                .input(wireFine, TungstenSteel, 16)
                .output(VOLTAGE_COIL_EV)
                .duration(200)
                .EUt(1920)
                .buildAndRegister();;

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, NeodymiumAlloyMagnetic, 1)
                .input(wireFine, Iridium, 16)
                .output(VOLTAGE_COIL_IV)
                .duration(200)
                .EUt(7680)
                .buildAndRegister();;

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, SamariumAlloyMagnetic, 1)
                .input(wireFine, Osmiridium, 16)
                .output(VOLTAGE_COIL_LuV)
                .duration(200)
                .EUt(30720)
                .buildAndRegister();;

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, SamariumAlloyMagnetic, 1)
                .input(wireFine, Europium, 16)
                .output(VOLTAGE_COIL_ZPM)
                .duration(200)
                .EUt(122880)
                .buildAndRegister();;

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stick, SamariumAlloyMagnetic, 1)
                .input(wireFine, Tritanium,  16)
                .output(VOLTAGE_COIL_UV)
                .duration(200)
                .EUt(491520)
                .buildAndRegister();;

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumAlloyMagnetic)
                .input(stickLong, HSSS, 2)
                .input(ring, HSSS, 2)
                .input(round, HSSS, 4)
                .input(wireFine, Ruridit, 64)
                .input(cableGtSingle, NiobiumTitanium, 2)
                .fluidInputs(SolderingAlloy.getFluid(144))
                .fluidInputs(Lubricant.getFluid(250))
                .output(ELECTRIC_MOTOR_LuV)
                .scannerResearch(ELECTRIC_MOTOR_IV.getStackForm())
                .duration(600)
                .EUt(6000)
                .buildAndRegister();;

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumAlloyMagnetic)
                .input(stickLong, Osmiridium, 4)
                .input(ring, Osmiridium, 4)
                .input(round, Osmiridium, 8)
                .input(wireFine, Europium, 64)
                .input(wireFine, Europium, 32)
                .input(cableGtSingle, VanadiumGallium, 2)
                .fluidInputs(SolderingAlloy.getFluid(288))
                .fluidInputs(Lubricant.getFluid(500))
                .output(ELECTRIC_MOTOR_ZPM)
                .scannerResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_LuV.getStackForm())
                        .duration(1200)
                        .EUt(VA[IV]))
                .duration(600)
                .EUt(24000)
                .buildAndRegister();;

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, SamariumAlloyMagnetic)
                .input(stickLong, Tritanium, 4)
                .input(ring, Tritanium, 4)
                .input(round, Tritanium, 8)
                .input(wireFine, Americium, 64)
                .input(wireFine, Americium, 64)
                .input(cableGtSingle, YttriumBariumCuprate, 2)
                .fluidInputs(SolderingAlloy.getFluid(576))
                .fluidInputs(Lubricant.getFluid(1000))
                .fluidInputs(Naquadria.getFluid(576))
                .output(ELECTRIC_MOTOR_UV)
                .stationResearch(b -> b
                        .researchStack(ELECTRIC_MOTOR_ZPM.getStackForm())
                        .CWUt(32)
                        .EUt(VA[ZPM]))
                .duration(600)
                .EUt(100000)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(stickLong, TreatedSamariumAlloy)
                .output(stickLong, SamariumAlloyMagnetic)
                .duration(150)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(stick, TreatedSamariumAlloy)
                .output(stick, SamariumAlloyMagnetic)
                .duration(75)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(ring, TreatedSamariumAlloy)
                .output(ring, SamariumAlloyMagnetic)
                .duration(40)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(ingot, TreatedSamariumAlloy)
                .output(ingot, SamariumAlloyMagnetic)
                .duration(150)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(plate, TreatedSamariumAlloy)
                .output(plate, SamariumAlloyMagnetic)
                .duration(150)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(stickLong, TreatedNeodymiumAlloy)
                .output(stickLong, NeodymiumAlloyMagnetic)
                .duration(150)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(stick, TreatedNeodymiumAlloy)
                .output(stick, NeodymiumAlloyMagnetic)
                .duration(75)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(ring, TreatedNeodymiumAlloy)
                .output(ring, NeodymiumAlloyMagnetic)
                .duration(40)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(ingot, TreatedNeodymiumAlloy)
                .output(ingot, NeodymiumAlloyMagnetic)
                .duration(150)
                .EUt(240)
                .buildAndRegister();;

        POLARIZER_RECIPES.recipeBuilder()
                .input(plate, TreatedNeodymiumAlloy)
                .output(plate, NeodymiumAlloyMagnetic)
                .duration(150)
                .EUt(240)
                .buildAndRegister();;
    }
}
