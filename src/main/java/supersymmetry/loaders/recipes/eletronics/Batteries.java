package supersymmetry.loaders.recipes.eletronics;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraftforge.fluids.FluidUtil;
import supersymmetry.common.item.SuSyMetaItems;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.common.metatileentities.SuSyMetaTileEntities.BRASS_DRUM;
import static supersymmetry.common.metatileentities.SuSyMetaTileEntities.LEAD_DRUM;

public class Batteries {
    public static void init() {
        //REMOVALS
// Small Sodium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_LV.getStackForm(), OreDictUnifier.get(dust, Sodium, 2));
// Medium Sodium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_MV.getStackForm(), OreDictUnifier.get(dust, Sodium, 8));
// Large Sodium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_HV.getStackForm(), OreDictUnifier.get(dust, Sodium, 16));
// Small Lithium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_LV.getStackForm(), OreDictUnifier.get(dust, Lithium, 2));
// Medium Lithium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_MV.getStackForm(), OreDictUnifier.get(dust, Lithium, 8));
// Large Lithium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_HV.getStackForm(), OreDictUnifier.get(dust, Lithium, 16));
// Small Cadmium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_LV.getStackForm(), OreDictUnifier.get(dust, Cadmium, 2));
// Medium Cadmium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_MV.getStackForm(), OreDictUnifier.get(dust, Cadmium, 8));
// Large Cadmium Battery * 1
        removeRecipesByInputs(CANNER_RECIPES, BATTERY_HULL_HV.getStackForm(), OreDictUnifier.get(dust, Cadmium, 16));

        ModHandler.addShapedRecipe(true, "battery_lead_acid", BATTERY_LEAD_ACID.getStackForm(),
                "PWP", "CBA", "PPP",
                'P', new UnificationEntry(plate, BatteryAlloy),
                'C', CATHODE_LEAD,
                'A', ANODE_LEAD,
                'W', new UnificationEntry(cableGtSingle, Tin),
                'B', FluidUtil.getFilledBucket(SulfuricAcid.getFluid(1000)));

        ModHandler.addShapedRecipe(true, "anode_lead", ANODE_LEAD.getStackForm(),
                "   ", " PC", "   ",
                'P', new UnificationEntry(plate, Lead),
                'C', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "cathode_lead", CATHODE_LEAD.getStackForm(),
                "   ", "CP ", "   ",
                'P', new UnificationEntry(plate, Lead),
                'C', new UnificationEntry(cableGtSingle, Tin));

        ModHandler.addShapedRecipe(true, "drum_lead", LEAD_DRUM.getStackForm(),
                " h ", "PSP", "PSP",
                'P', new UnificationEntry(plate, Lead),
                'S', new UnificationEntry(stickLong, Lead));

        ModHandler.addShapelessNBTClearingRecipe("drum_nbt_lead", LEAD_DRUM.getStackForm(), LEAD_DRUM.getStackForm());
        ModHandler.addShapelessNBTClearingRecipe("drum_nbt_brass", BRASS_DRUM.getStackForm(), BRASS_DRUM.getStackForm());

// Note: this is a temporary fix to clear brass drum.

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_LV)
                .input(plate, Lead, 2)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(BATTERY_LEAD_ACID)
                .duration(100)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(stickLong, Lead, 2)
                .input(plate, Lead, 4)
                .output(LEAD_DRUM)
                .duration(200)
                .EUt(16)
                .circuitMeta(2)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(SulfurTrioxide.getFluid(1000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(SulfuricAcid.getFluid(1000))
                .EUt(7)
                .duration(40)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Sodium, 4)
                .input(dust, Iron, 3)
                .input(dust, Manganese, 3)
                .fluidInputs(Oxygen.getFluid(12000))
                .output(dust, SodiumCathodeAlloy, 10)
                .blastFurnaceTemp(1250)
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(Phosgene.getFluid(50))
                .fluidInputs(Methanol.getFluid(100))
                .fluidOutputs(DimethylCarbonate.getFluid(50))
                .fluidOutputs(HydrogenChloride.getFluid(100))
                .duration(1)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, LithiumCarbonate, 6)
                .fluidInputs(HydrogenFluoride.getFluid(2000))
                .fluidOutputs(Steam.getFluid(1000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .output(dust, LithiumFluoride, 4)
                .duration(140)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, LithiumFluoride, 2)
                .input(dust, PhosphorusPentachloride, 6)
                .fluidInputs(HydrogenFluoride.getFluid(5000))
                .fluidOutputs(HydrogenChloride.getFluid(5000))
                .output(dust, LithiumHexafluorophosphate, 8)
                .duration(140)
                .EUt(30)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(EthyleneOxide.getFluid(50))
                .fluidInputs(CarbonDioxide.getFluid(50))
                .fluidOutputs(EthyleneCarbonate.getFluid(50))
                .duration(5)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, LithiumHexafluorophosphate, 8)
                .fluidInputs(EthyleneCarbonate.getFluid(1000))
                .fluidOutputs(LithiumHexafluorophosphateElectrolyte.getFluid(1000))
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, LithiumCarbonate, 6)
                .input(dust, CobaltOxide, 4)
                .fluidOutputs(CarbonMonoxide.getFluid(1000))
                .output(dust, LithiumCobaltOxide, 8)
                .duration(140)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Nickel, 1)
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, NickelChloride, 3)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelChloride, 3)
                .fluidInputs(PotassiumHydroxideSolution.getFluid(2000))
                .output(dust, NickelHydroxide, 5)
                .fluidOutputs(PotassiumChlorideSolution.getFluid(2000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, NickelHydroxide, 10)
                .fluidInputs(PotassiumHydroxideSolution.getFluid(2000))
                .fluidInputs(Chlorine.getFluid(2000))
                .output(dust, NickelOxideHydroxide, 8)
                .fluidOutputs(DilutedRockSaltSolution.getFluid(4000))
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_LV)
                .input(dust, Carbon)
                .input(dust, SodiumCathodeAlloy)
                .fluidInputs(DimethylCarbonate.getFluid(100))
                .output(BATTERY_LV_LITHIUM)
                .duration(100)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_MV)
                .input(dust, Carbon, 2)
                .input(dust, SodiumCathodeAlloy, 2)
                .fluidInputs(DimethylCarbonate.getFluid(200))
                .output(BATTERY_MV_SODIUM)
                .duration(200)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_HV)
                .input(dust, Carbon, 4)
                .input(dust, SodiumCathodeAlloy, 4)
                .fluidInputs(DimethylCarbonate.getFluid(500))
                .output(BATTERY_HV_SODIUM)
                .duration(400)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_LV)
                .input(dust, Graphite)
                .input(dust, LithiumCobaltOxide)
                .fluidInputs(LithiumHexafluorophosphateElectrolyte.getFluid(100))
                .output(BATTERY_LV_LITHIUM)
                .duration(100)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_MV)
                .input(dust, Graphite, 2)
                .input(dust, LithiumCobaltOxide, 2)
                .fluidInputs(LithiumHexafluorophosphateElectrolyte.getFluid(200))
                .output(BATTERY_MV_LITHIUM)
                .duration(200)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_HV)
                .input(dust, Graphite, 4)
                .input(dust, LithiumCobaltOxide, 4)
                .fluidInputs(LithiumHexafluorophosphateElectrolyte.getFluid(500))
                .output(BATTERY_HV_LITHIUM)
                .duration(400)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_LV)
                .input(dust, Cadmium)
                .input(dust, NickelOxideHydroxide)
                .fluidInputs(PotassiumHydroxideSolution.getFluid(100))
                .output(BATTERY_LV_CADMIUM)
                .duration(100)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_MV)
                .input(dust, Cadmium, 2)
                .input(dust, NickelOxideHydroxide, 2)
                .fluidInputs(PotassiumHydroxideSolution.getFluid(200))
                .output(BATTERY_MV_CADMIUM)
                .duration(200)
                .EUt(16)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .input(BATTERY_HULL_HV)
                .input(dust, Cadmium, 4)
                .input(dust, NickelOxideHydroxide, 4)
                .fluidInputs(PotassiumHydroxideSolution.getFluid(500))
                .output(BATTERY_HV_CADMIUM)
                .duration(400)
                .EUt(16)
                .buildAndRegister();

// Remove Batteries

//        mods.gregtech.autoclave.removeByInput(480, [metaitem('energium_dust') * 9], [fluid('water') * 1000])
//        mods.gregtech.autoclave.removeByInput(320, [metaitem('energium_dust') * 9], [fluid('distilled_water') * 1000])
//        mods.gregtech.autoclave.removeByInput(256, [metaitem('energium_dust') * 9], [fluid('black_steel') * 288])
//        mods.gregtech.autoclave.removeByInput(192, [metaitem('energium_dust') * 9], [fluid('blue_steel') * 72])
//
//        mods.gregtech.autoclave.removeByInput(480, [metaitem('dustLapotron') * 15], [fluid('water') * 1000])
//        mods.gregtech.autoclave.removeByInput(320, [metaitem('dustLapotron') * 15], [fluid('distilled_water') * 1000])
//        mods.gregtech.autoclave.removeByInput(256, [metaitem('dustLapotron') * 15], [fluid('blue_steel') * 288])
//        mods.gregtech.autoclave.removeByInput(192, [metaitem('dustLapotron') * 15], [fluid('red_steel') * 72])
//
//        mods.jei.removeAndHide(ENERGY_CRYSTAL);
//        mods.jei.removeAndHide(LAPOTRON_CRYSTAL);
//
//        mods.jei.removeAndHide(ENERGY_LAPOTRONIC_ORB);
//        mods.jei.removeAndHide(ENERGY_LAPOTRONIC_ORB_CLUSTER);
//        mods.jei.removeAndHide(ENERGY_MODULE);
//        mods.jei.removeAndHide(ENERGY_CLUSTER);
//        mods.jei.removeAndHide(MAX_BATTERY);
    }
}
