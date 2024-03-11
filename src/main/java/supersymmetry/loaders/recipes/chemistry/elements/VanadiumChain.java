package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.api.fluids.SusyFluidStorageKeys;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.ITEM_FILTER;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.*;
import static supersymmetry.api.unification.ore.SusyOrePrefix.sifted;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.*;

public class VanadiumChain {
    public static void init() {
        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Vanadinite, 21)
                .input(dust, Salt, 6)
                .output(dust, SaltRoastedVanadinite, 27)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Vanadinite, 42)
                .input(dust, SodaAsh, 18)
                .output(dust, SodaAshRoastedVanadinite, 51)
                .fluidOutputs(CarbonDioxide.getFluid(3000))
                .duration(300)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, SodaAshRoastedVanadinite, 51)
                .fluidInputs(Water.getFluid(6000))
                .fluidOutputs(SodiumVanadateSolution.getFluid(6000))
                .output(dust, LeachedSodaAshRoastedVanadinite, 21)
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, LeachedSodaAshRoastedVanadinite, 21)
                .fluidInputs(HeatedWater.getFluid(1000))
                .fluidOutputs(LeadChlorideSolution.getFluid(1000))
                .output(dust, LeadOxide, 18)
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, SaltRoastedVanadinite, 27)
                .fluidInputs(Water.getFluid(3000))
                .fluidOutputs(SodiumVanadateSolution.getFluid(3000))
                .output(dust, LeachedSaltRoastedVanadinite, 12)
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, LeachedSaltRoastedVanadinite, 12)
                .fluidInputs(HeatedWater.getFluid(3000))
                .fluidOutputs(LeadChlorideSolution.getFluid(3000))
                .output(dust, LeadOxide, 6)
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(LeadChlorideSolution.getFluid(1000))
                .fluidOutputs(Water.getFluid(1000))
                .output(dust, LeadChloride, 3)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, AmmoniumChloride, 6)
                .fluidInputs(SodiumVanadateSolution.getFluid(1000))
                .output(dust, AmmoniumMetavanadate, 9)
                .fluidOutputs(SaltWater.getFluid(1000))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, AmmoniumMetavanadate, 18)
                .output(dust, VanadiumPentoxide, 7)
                .fluidOutputs(Steam.getFluid(1000))
                .fluidOutputs(Ammonia.getFluid(2000))
                .duration(80)
                .EUt(120)
                .buildAndRegister();

        ELECTROMAGNETIC_SEPARATOR_RECIPES.recipeBuilder()
                .input(dustImpure, VanadiferousTitanomagnetite)
                .output(dust, VanadiferousTitanomagnetite)
                .chancedOutput(dust, PegmatiteTailings, 2500, 500)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(DistilledWater.getFluid(2000))
                .input(dust, VanadiferousTitanomagnetite, 8)
                .fluidOutputs(VanadiferousTitanomagnetite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(VanadiferousTitanomagnetite.getFluid(SusyFluidStorageKeys.IMPURE_SLURRY, 2000))
                .notConsumable(MethylIsobutylCarbinol.getFluid(100))
                .notConsumable(NOctylamine.getFluid(100))
                .fluidOutputs(VanadiferousTitanomagnetite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(PegmatiteTailingSlurry.getFluid(1000))
                .EUt(480)
                .duration(800)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(VanadiferousTitanomagnetite.getFluid(SusyFluidStorageKeys.SLURRY, 1000))
                .fluidOutputs(Wastewater.getFluid(1000))
                .output(flotated, VanadiferousTitanomagnetite, 16)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Magnesite)
                .output(dust, MagnesiumCarbonate)
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, MagnesiumChloride, 3)
                .fluidInputs(SodiumBicarbonateSolution.getFluid(2000))
                .output(dust, MagnesiumCarbonate, 5)
                .fluidOutputs(SaltWater.getFluid(2000))
                .fluidOutputs(CarbonDioxide.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, MagnesiumHydroxide, 5)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, MagnesiumCarbonate, 5)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, Calcite, 5)
                .input(dust, MagnesiumCarbonate, 5)
                .output(dust, Dolomite, 10)
                .EUt(120)
                .duration(300)
                .buildAndRegister();

        for (Utils.Combustible fuel : sintering_fuels) {
            if (!fuel.isPlasma) {
                for (Comburent comburent : sintering_comburents) {
                    ROTARY_KILN.recipeBuilder()
                            .input(flotated, VanadiferousTitanomagnetite, 11)
                            .input(dust, Coke, 7)
                            .input(dust, Dolomite)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .output(VTI_RICH_PIG_IRON, 4)
                            .fluidOutputs(CarbonMonoxide.getFluid(7000))
                            .duration(fuel.duration + comburent.duration)
                            .EUt(120)
                            .buildAndRegister();

                    ROTARY_KILN.recipeBuilder()
                            .input(flotated, VanadiferousTitanomagnetite, 11)
                            .input("dustAnyPurityCarbon", 7)
                            .input(dust, Dolomite)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .output(VTI_RICH_PIG_IRON, 4)
                            .fluidOutputs(CarbonMonoxide.getFluid(7000))
                            .duration(fuel.duration + comburent.duration)
                            .EUt(120)
                            .buildAndRegister();

                    ROTARY_KILN.recipeBuilder()
                            .input(dust, VTSlag)
                            .input(dust, SodaAsh, 5)
                            .fluidInputs(fuel.fluid)
                            .fluidInputs(comburent.fluid)
                            .output(dust, AlkaliVTSlag)
                            .fluidOutputs(CarbonDioxide.getFluid(1000))
                            .duration(fuel.duration + comburent.duration)
                            .EUt(120)
                            .buildAndRegister();
                }
            }
        }

        ADVANCED_ARC_FURNACE.recipeBuilder()
                .input(VTI_RICH_PIG_IRON, 2)
                .fluidInputs(Oxygen.getFluid(2700))
                .output(ingot, Steel, 2)
                .output(VT_SLAG)
                .EUt(240)
                .duration(300)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(VT_SLAG)
                .output(dust, VTSlag)
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, AlkaliVTSlag, 7)
                .fluidInputs(DistilledWater.getFluid(1000))
                .output(dust, TitaniaSlag, 6)
                .fluidOutputs(SodiumVanadateSolution.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, TitaniaSlag)
                .fluidInputs(Oleum.getFluid(1000))
                .output(dust, SiliconDioxide)
                .fluidOutputs(TitanylSulfateSolution.getFluid(1000))
                .EUt(120)
                .duration(200)
                .buildAndRegister();

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, HighPurityCalcium, 5)
                .input(dust, VanadiumPentoxide, 7)
                .output(dust, Vanadium, 2)
                .output(dust, Quicklime, 10)
                .EUt(120)
                .duration(100)
                .buildAndRegister();
    }
}
