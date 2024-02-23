package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.blocks.MetaBlocks.*;
import static gregtech.common.items.MetaItems.*;
import static net.minecraft.init.Items.SLIME_BALL;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class RubberChain {
    private static class Catalyser {
        ItemStack name;
        int speed_bonus;

        Catalyser(ItemStack name, int speed_bonus) {
            this.name = name;
            this.speed_bonus = speed_bonus;
        }
    }

    private static class SulfurSource {
        Material name;
        int amount_required;

        SulfurSource(Material name, int amount_required) {
            this.name = name;
            this.amount_required = amount_required;
        }
    }

    private static class Rubber {
        Material name;
        Material output;
        int amount_required;
        int duration;
        int yield;
        boolean isFluid;

        Rubber(Material name, Material output, int amount_required, int duration, int yield, boolean isFluid){
            this.name = name;
            this.output = output;
            this.amount_required = amount_required;
            this.duration = duration;
            this.yield = yield;
            this.isFluid = isFluid;
        }
    }

    private static class Coagulant {
        Material name;
        int amount_required;
        int speed_bonus;
        int yield_bonus;
        boolean isFluid;

        Coagulant(Material name, int amount_required, int speed_bonus, int yield_bonus, boolean isFluid){
            this.name = name;
            this.amount_required = amount_required;
            this.speed_bonus = speed_bonus;
            this.yield_bonus = yield_bonus;
            this.isFluid = isFluid;
        }
    }

    private static class Shape {
        ItemStack name;
        int yield;
        OrePrefix format;

        Shape(ItemStack name, int yield, OrePrefix format){
            this.name = name;
            this.yield = yield;
            this.format = format;
        }
    }

    private static void CoagulationRecipe(Coagulant coagulant, int amount, int duration, int circ){
        if(coagulant.isFluid){
            COAGULATION_RECIPES.recipeBuilder()
                    .fluidInputs(Latex.getFluid(1000 * amount))
                    .notConsumable(coagulant.name.getFluid(coagulant.amount_required * amount))
                    .circuitMeta(circ)
                    .output(dust, Latex, coagulant.yield_bonus * amount)
                    .duration(duration / coagulant.speed_bonus)
                    .buildAndRegister();
        } else {
            COAGULATION_RECIPES.recipeBuilder()
                    .fluidInputs(Latex.getFluid(1000 * amount))
                    .notConsumable(dust, coagulant.name, coagulant.amount_required * amount)
                    .circuitMeta(circ)
                    .output(dust, Latex, coagulant.yield_bonus * amount)
                    .duration(duration / coagulant.speed_bonus)
                    .buildAndRegister();
        }
    }

    private static void CoagulationRecipe(int amount, int duration, int circ){
        COAGULATION_RECIPES.recipeBuilder()
                .circuitMeta(circ)
                .fluidInputs(Latex.getFluid(1000 * amount))
                .notConsumable(stick, Iron)
                .output(dust, Latex, amount)
                .duration(duration)
                .buildAndRegister();
    }
    public static void init() {
//REMOVALS
// Raw Rubber Pulp * 2
        removeRecipesByInputs(EXTRACTOR_RECIPES, new ItemStack(SLIME_BALL));
// Raw Rubber Pulp * 3
        removeRecipesByInputs(EXTRACTOR_RECIPES, STICKY_RESIN.getStackForm());
// Raw Rubber Pulp * 1
        removeRecipesByInputs(EXTRACTOR_RECIPES, new ItemStack(RUBBER_SAPLING));
// Raw Rubber Pulp * 1
        removeRecipesByInputs(EXTRACTOR_RECIPES, new ItemStack(RUBBER_LEAVES, 16));
// Raw Rubber Pulp * 1
        removeRecipesByInputs(EXTRACTOR_RECIPES, new ItemStack(RUBBER_LOG));
// Rubber Ingot * 1
        removeRecipesByInputs(ALLOY_SMELTER_RECIPES, OreDictUnifier.get(dust, Sulfur), OreDictUnifier.get(dust, RawRubber, 3));

        Rubber[] rubbers = {
                new Rubber(Latex, Materials.Rubber, 16, 10 * 20, 4, false),
                new Rubber(Latex, Materials.Rubber, 32, 20 * 20, 1, true),
                new Rubber(Polyisoprene, Materials.Rubber, 8, 225, 8, false),
                new Rubber(RawStyreneIsopreneRubber, StyreneIsopreneRubber, 4, 30 * 20, 4, false),
                new Rubber(RawStyreneButadieneRubber, StyreneButadieneRubber, 4, 30 * 20, 4, false)
        };

        SulfurSource[] sulfurSources = {
                new SulfurSource(Sulfur, 1)
        };

        Catalyser[] catalysers = {
                new Catalyser(OreDictUnifier.get(dust, Zincite), 2),
                new Catalyser(OreDictUnifier.get(dust, Magnesia), 2),
        };

        Coagulant[] coagulants = {
                new Coagulant(CalciumChloride, 2, 1, 4, false),
                new Coagulant(AceticAcid, 250, 4, 1, true),
                new Coagulant(SulfuricAcid, 125, 2, 1, true)
        };

        Shape[] shapes = {
                new Shape(SHAPE_EXTRUDER_PLATE.getStackForm(), 1, plate),
                new Shape(SHAPE_EXTRUDER_RING.getStackForm(), 4, ring),
                new Shape(SHAPE_EXTRUDER_FOIL.getStackForm(), 4, foil),
                new Shape(SHAPE_EXTRUDER_INGOT.getStackForm(), 1, ingot),
        };

        for (Rubber rubber : rubbers) {
            for (SulfurSource sulfurSource : sulfurSources) {
                for(Shape shape : shapes) {
                    for (Catalyser catalyser : catalysers) {
                        if (rubber.isFluid) {
                            VULCANIZATION_RECIPES.recipeBuilder()
                                    .fluidInputs(rubber.name.getFluid(rubber.amount_required * 1000))
                                    .input(dust, sulfurSource.name, sulfurSource.amount_required)
                                    .notConsumable(catalyser.name)
                                    .notConsumable(shape.name)
                                    .output(shape.format, rubber.output, rubber.yield * shape.yield)
                                    .duration(rubber.duration / catalyser.speed_bonus)
                                    .EUt(7)
                                    .buildAndRegister();
                        } else {
                            VULCANIZATION_RECIPES.recipeBuilder()
                                    .input(dust, rubber.name, rubber.amount_required)
                                    .input(dust, sulfurSource.name, sulfurSource.amount_required)
                                    .notConsumable(catalyser.name)
                                    .notConsumable(shape.name)
                                    .output(shape.format, rubber.output, rubber.yield * shape.yield)
                                    .duration(rubber.duration / catalyser.speed_bonus)
                                    .EUt(7)
                                    .buildAndRegister();
                        }
                    }

                    if (rubber.isFluid) {
                        VULCANIZATION_RECIPES.recipeBuilder()
                                .fluidInputs(rubber.name.getFluid(rubber.amount_required * 1000))
                                .input(dust, sulfurSource.name, sulfurSource.amount_required)
                                .notConsumable(shape.name)
                                .circuitMeta(2)
                                .output(shape.format, rubber.output, rubber.yield * shape.yield)
                                .duration(rubber.duration)
                                .EUt(7)
                                .buildAndRegister();
                    } else {
                        VULCANIZATION_RECIPES.recipeBuilder()
                                .input(dust, rubber.name, rubber.amount_required)
                                .input(dust, sulfurSource.name, sulfurSource.amount_required)
                                .notConsumable(shape.name)
                                .circuitMeta(2)
                                .output(shape.format, rubber.output, rubber.yield * shape.yield)
                                .duration(rubber.duration)
                                .EUt(7)
                                .buildAndRegister();
                    }
                }
            }
        }

        CoagulationRecipe(1, 400, 0);
        CoagulationRecipe(4, 1000, 1);
        CoagulationRecipe(16, 2500, 2);

        for (Coagulant coagulant : coagulants) {
            CoagulationRecipe(coagulant, 1, 400, 3);
            CoagulationRecipe(coagulant, 4, 1000, 4);
            CoagulationRecipe(coagulant, 16, 2500, 5);
        }

        removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(dust, Latex));

        EXTRACTOR_RECIPES.recipeBuilder()
                .input(dust, Latex)
                .fluidOutputs(Latex.getFluid(1000))
                .duration(98)
                .EUt(30)
                .buildAndRegister();

// Polyisoprene
        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(Isoprene.getFluid(1000))
                .output(dust, Polyisoprene, 4)
                .notConsumable(dust, ZieglerNattaCatalyst)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(Isoprene.getFluid(1000))
                .output(dust, Polyisoprene, 6)
                .notConsumable(Butyllithium.getFluid(100))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedIsoprene.getFluid(1000))
                .output(dust, Polyisoprene, 6)
                .notConsumable(dust, ZieglerNattaCatalyst)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedIsoprene.getFluid(1000))
                .output(dust, Polyisoprene, 8)
                .notConsumable(Butyllithium.getFluid(100))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

// Styrene - Isoprene rubber

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Styrene.getFluid(1000))
                .fluidInputs(Isoprene.getFluid(3000))
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidOutputs(StyreneIsopreneSolution.getFluid(5000))
                .EUt(60)
                .duration(200)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(StyreneIsopreneSolution.getFluid(5000))
                .notConsumable(Butyllithium.getFluid(100))
                .fluidOutputs(PolymerizedStyreneIsopreneSolution.getFluid(5000))
                .EUt(120)
                .duration(533)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PolymerizedStyreneIsopreneSolution.getFluid(5000))
                .fluidOutputs(Ethanol.getFluid(1000))
                .output(dust, RawStyreneIsopreneRubber, 16)
                .EUt(120)
                .duration(533)
                .buildAndRegister();

// Styrene - Butadiene rubber

        SIFTER_RECIPES.recipeBuilder()
                .fluidInputs(EthanolWaterAzeotrope.getFluid(1000))
                .input(dust, MolecularSieve, 4)
                .fluidOutputs(Ethanol.getFluid(900))
                .output(dust, WetMolecularSieve, 4)
                .EUt(30)
                .duration(200)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(Styrene.getFluid(1000))
                .fluidInputs(Butadiene.getFluid(3000))
                .fluidInputs(Ethanol.getFluid(1000))
                .fluidOutputs(StyreneButadieneSolution.getFluid(5000))
                .EUt(60)
                .duration(200)
                .buildAndRegister();

        POLYMERIZATION_RECIPES.recipeBuilder()
                .fluidInputs(StyreneButadieneSolution.getFluid(5000))
                .notConsumable(Butyllithium.getFluid(100))
                .fluidOutputs(PolymerizedStyreneButadieneSolution.getFluid(5000))
                .EUt(120)
                .duration(533)
                .buildAndRegister();

        DRYER_RECIPES.recipeBuilder()
                .fluidInputs(PolymerizedStyreneButadieneSolution.getFluid(5000))
                .fluidOutputs(Ethanol.getFluid(1000))
                .output(dust, RawStyreneButadieneRubber, 16)
                .EUt(120)
                .duration(533)
                .buildAndRegister();
    }
}
