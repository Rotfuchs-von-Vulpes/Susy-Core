package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.unification.OreDictUnifier;
import gregtechfoodoption.item.GTFOMetaItem;
import net.minecraft.item.ItemStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_BALL;
import static gregtechfoodoption.GTFOMaterialHandler.*;
import static net.minecraft.init.Items.CLAY_BALL;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class PhosphorusChain {
    public static void init() {
        //PRIMITIVE (LV)
        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Bone)
                .fluidInputs(Water.getFluid(250))
                .output(dust, TricalciumPhosphate, 13)
                .outputs(Fat.getItemStack())
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, TricalciumPhosphate, 13)
                .fluidInputs(SulfuricAcid.getFluid(2000))
                .output(dust, MonocalciumPhosphate, 15)
                .output(dust, CalciumSulfate, 12)
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, MonocalciumPhosphate, 15)
                .output(dust, CalciumPhosphite, 11)
                .fluidOutputs(Steam.getFluid(2000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, CalciumPhosphite, 33)
                .input("dustAnyPurityCarbon", 10)
                .output(dust, TricalciumPhosphate, 13)
                .output(dust, Phosphorus, 4)
                .duration(360)
                .EUt(30)
                .buildAndRegister();

//UNIVERSAL (MV)
//REMOVE APATITE RECIPES
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack(CLAY_BALL), OreDictUnifier.get(dust, Stone), OreDictUnifier.get(dust, Apatite));
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack(CLAY_BALL), OreDictUnifier.get(dust, Stone), OreDictUnifier.get(dust, Apatite));

        ItemStack[] apatites = {
                OreDictUnifier.get(dust, Chlorapatite, 2),
                OreDictUnifier.get(dust, Hydroxyapatite, 2),
                OreDictUnifier.get(dust, Fluorapatite, 2),
        };

        for (ItemStack apatite : apatites) {
            MIXER_RECIPES.recipeBuilder()
                    .inputs(apatite)
                    .inputs(new ItemStack(CLAY_BALL))
                    .input(dust, Stone)
                    .outputs(BoneChinaClay.getItemStack(4))
                    .duration(40)
                    .EUt(7)
                    .buildAndRegister();
        }

//WET PROCESS
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Hydroxyapatite)
                .fluidInputs(SulfuricAcid.getFluid(5000))
                .output(dust, CalciumSulfate, 6)
                .fluidOutputs(DilutedPhosphoricAcid.getFluid(4000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Fluorapatite)
                .fluidInputs(SulfuricAcid.getFluid(5000))
                .output(dust, CalciumSulfate, 6)
                .fluidOutputs(PhosphoricAcid.getFluid(3000))
                .fluidOutputs(HydrogenFluoride.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Chlorapatite)
                .fluidInputs(SulfuricAcid.getFluid(5000))
                .output(dust, CalciumSulfate, 6)
                .fluidOutputs(PhosphoricAcid.getFluid(3000))
                .fluidOutputs(HydrogenChloride.getFluid(1000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(DilutedPhosphoricAcid.getFluid(4000))
                .fluidOutputs(PhosphoricAcid.getFluid(3000))
                .fluidOutputs(Water.getFluid(1000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//CONVERSION TO WHITE PHOSPHORUS
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumHydroxide, 5)
                .fluidInputs(PhosphoricAcid.getFluid(2000))
                .output(dust, MonocalciumPhosphate, 15)
                .fluidOutputs(Water.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

//SULFURIC ACID REGENERATION
        ROASTER_RECIPES.recipeBuilder()
                .input(dust, CalciumSulfate, 6)
                .input(dust, SiliconDioxide, 3)
                .output(dust, CalciumMetasilicate, 5)
                .fluidOutputs(SulfurTrioxideReactionMixture.getFluid(2000))
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(SulfurTrioxideReactionMixture.getFluid(1000))
                .notConsumable(dust, VanadiumPentoxide)
                .fluidOutputs(SulfurTrioxide.getFluid(1000))
                .duration(200)
                .EUt(7)
                .buildAndRegister();

//THERMAL PROCESS
        BLAST_RECIPES.recipeBuilder()
                .input(dust, Fluorapatite, 2)
                .input(dust, SiliconDioxide, 27)
                .input("dustAnyPurityCarbon", 15)
                .output(dust, Phosphorus, 6)
                .output(dust, CalciumMetasilicate, 45)
                .output(dust, Fluorite, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(15000))
                .blastFurnaceTemp(1200)
                .duration(720)
                .EUt(120)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Chlorapatite, 2)
                .input(dust, SiliconDioxide, 27)
                .input("dustAnyPurityCarbon", 15)
                .output(dust, Phosphorus, 6)
                .output(dust, CalciumMetasilicate, 45)
                .output(dust, CalciumChloride, 3)
                .fluidOutputs(CarbonMonoxide.getFluid(15000))
                .blastFurnaceTemp(1200)
                .duration(720)
                .EUt(120)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Hydroxyapatite, 2)
                .input(dust, SiliconDioxide, 27)
                .input("dustAnyPurityCarbon", 15)
                .output(dust, Phosphorus, 6)
                .output(dust, CalciumMetasilicate, 45)
                .output(dust, CalciumHydroxide, 5)
                .blastFurnaceTemp(1200)
                .duration(720)
                .EUt(120)
                .buildAndRegister();

//SPECIALIZED (HV)
        MIXER_RECIPES.recipeBuilder()
                .input(dust, Phosphorite, 2)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(PhosphoriteSlurry.getFluid(1000))
                .duration(40)
                .EUt(480)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(PhosphoriteSlurry.getFluid(1000))
                .output(dust, PhosphatePulp, 2)
                .chancedOutput(dust, Clay, 5000, 0)
                .chancedOutput(dust, SiliconDioxide, 3, 5000, 0)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(40)
                .EUt(480)
                .buildAndRegister();

        SIFTER_RECIPES.recipeBuilder()
                .input(dust, PhosphatePulp)
                .output(dust, FilteredPhosphatePulp)
                .chancedOutput(dust, SiliconDioxide, 2500, 0)
                .duration(20)
                .EUt(480)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, FilteredPhosphatePulp, 8)
                .fluidInputs(DistilledWater.getFluid(2000))
                .fluidOutputs(FilteredPhosphateSlurry.getFluid(2000))
                .EUt(480)
                .duration(80)
                .buildAndRegister();

        FROTH_FLOTATION.recipeBuilder()
                .fluidInputs(FilteredPhosphateSlurry.getFluid(2000))
                .notConsumable(AlkalineSodiumOleateSolution.getFluid(1000))
                .notConsumable(FuelOil.getFluid(100))
                .fluidOutputs(PhosphateConcentrateSlurry.getFluid(1000))
                .fluidOutputs(LimestoneTailingSlurry.getFluid(1000))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

        CLARIFIER.recipeBuilder()
                .fluidInputs(PhosphateConcentrateSlurry.getFluid(1000))
                .output(dust, PhosphateConcentrate, 16)
                .fluidOutputs(Wastewater.getFluid(1000))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, PhosphateConcentrate)
                .fluidInputs(SulfuricAcid.getFluid(1000))
                .output(dust, Gypsum, 4)
                .fluidOutputs(PhosphoricAcid.getFluid(1000))
                .duration(20)
                .EUt(480)
                .buildAndRegister();

//HIGH PURITY
        COMPRESSOR_RECIPES.recipeBuilder()
                .input(dust, Phosphorus)
                .output(ingot, Phosphorus)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        ZONE_REFINER_RECIPES.recipeBuilder()
                .input(ingot, Phosphorus)
                .output(ingot, HighPurityPhosphorus)
                .duration(400)
                .EUt(30)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .input(dust, Phosphorus)
                .fluidInputs(Water.getFluid(250))
                .chancedOutput(dust, Arsenic, 500, 50)
                .fluidOutputs(HighPurityPhosphorusVaporMixture.getFluid(250))
                .duration(60)
                .EUt(30)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(HighPurityPhosphorusVaporMixture.getFluid(1000))
                .fluidOutputs(HighPurityPhosphorus.getFluid(576))
                .duration(240)
                .EUt(30)
                .buildAndRegister();

        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
                .fluidInputs(HighPurityPhosphorus.getFluid(144))
                .notConsumable(SHAPE_MOLD_BALL)
                .output(dust, HighPurityPhosphorus)
                .duration(60)
                .EUt(30)
                .buildAndRegister();

//CALCIUM METASILICATE-SILICA RECYCLING
        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CalciumMetasilicate, 5)
                .fluidInputs(CarbonDioxide.getFluid(1000))
                .output(dust, Calcite, 5)
                .output(dust, SiliconDioxide, 3)
                .duration(120)
                .EUt(30)
                .buildAndRegister();
    }
}
