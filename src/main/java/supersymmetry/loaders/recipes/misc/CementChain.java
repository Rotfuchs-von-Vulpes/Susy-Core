package supersymmetry.loaders.recipes.misc;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.loaders.recipe.chemistry.MixerRecipes;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.dustTiny;
import static supersymmetry.api.recipes.SuSyRecipeMaps.BLENDER_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.SINTERING_RECIPES;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class CementChain {
    static class CoolantGases {
        private final FluidStack fluid;
        private final FluidStack byproduct;
        private final int duration;

        public FluidStack getFluid() {
            return fluid;
        }

        public FluidStack getByproduct() {
            return byproduct;
        }

        public int getDuration() {
            return duration;
        }

        public CoolantGases(FluidStack fluid, FluidStack byproduct, int amount, int duration) {
            this.fluid = fluid;
            this.byproduct = byproduct;
            this.fluid.amount = amount;
            this.byproduct.amount = amount;
            this.duration = duration;
        }
    }

    public static void init() {
        for (Utils.Combustible fuel : Utils.sintering_fuels) {
            if (fuel.isPlasme()) {
                SINTERING_RECIPES.recipeBuilder()
                        .inputs(OreDictUnifier.get(dust, Clay))
                        .inputs(OreDictUnifier.get(dust, Limestone))
                        .circuitMeta(1)
                        .fluidInputs(fuel.getFluid())
                        .outputs(HOT_CEMENT_CLINKER.getStackForm())
                        .fluidOutputs(fuel.getByproduct())
                        .duration(fuel.getDuration())
                        .EUt(480)
                        .buildAndRegister();

                SINTERING_RECIPES.recipeBuilder()
                        .inputs(OreDictUnifier.get(dust, Clay))
                        .inputs(OreDictUnifier.get(dust, Limestone))
                        .inputs(OreDictUnifier.get(dustTiny, Gypsum))
                        .circuitMeta(2)
                        .fluidInputs(fuel.getFluid())
                        .outputs(HOT_CEMENT_CLINKER.getStackForm())
                        .chancedOutput(HOT_CEMENT_CLINKER.getStackForm(), 5000, 0)
                        .fluidOutputs(fuel.getByproduct())
                        .duration(fuel.getDuration())
                        .EUt(480)
                        .buildAndRegister();
            } else {
                for (Utils.Comburent comburent : Utils.sintering_comburents) {
                    SINTERING_RECIPES.recipeBuilder()
                            .inputs(OreDictUnifier.get(dust, Clay))
                            .inputs(OreDictUnifier.get(dust, Limestone))
                            .circuitMeta(1)
                            .fluidInputs(fuel.getFluid())
                            .fluidInputs(comburent.getFluid())
                            .outputs(HOT_CEMENT_CLINKER.getStackForm())
                            .fluidOutputs(fuel.getByproduct())
                            .duration(fuel.getDuration() + comburent.getDuration())
                            .EUt(7)
                            .buildAndRegister();

                    SINTERING_RECIPES.recipeBuilder()
                            .inputs(OreDictUnifier.get(dust, Clay))
                            .inputs(OreDictUnifier.get(dust, Limestone))
                            .inputs(OreDictUnifier.get(dustTiny, Gypsum))
                            .circuitMeta(2)
                            .fluidInputs(fuel.getFluid())
                            .fluidInputs(comburent.getFluid())
                            .outputs(HOT_CEMENT_CLINKER.getStackForm())
                            .chancedOutput(HOT_CEMENT_CLINKER.getStackForm(), 5000, 0)
                            .fluidOutputs(fuel.getByproduct())
                            .duration(fuel.getDuration() + comburent.getDuration())
                            .EUt(7)
                            .buildAndRegister();
                }
            }
        }

        CoolantGases[] gases = {new CoolantGases(Air.getFluid(1), HotAir.getFluid(1), 100, 40)};

        for (CoolantGases gas : gases) {
            MIXER_RECIPES.recipeBuilder()
                    .inputs(HOT_CEMENT_CLINKER.getStackForm())
                    .fluidInputs(gas.getFluid())
                    .outputs(CEMENT_CLINKER.getStackForm())
                    .fluidOutputs(gas.getByproduct())
                    .duration(gas.duration)
                    .EUt(7)
                    .buildAndRegister();
        }

        MACERATOR_RECIPES.recipeBuilder()
                .inputs(CEMENT_CLINKER.getStackForm())
                .outputs(CEMENT_DUST.getStackForm(16))
                .duration(20)
                .EUt(7)
                .buildAndRegister();
        String[] stones = {"dustStone", "dustMarble", "gravel", "sand"};

        for (String stone : stones) {
            MIXER_RECIPES.recipeBuilder()
                    .inputs(OreDictUnifier.get(stone))
                    .inputs(CEMENT_DUST.getStackForm())
                    .fluidInputs(Water.getFluid(500))
                    .fluidOutputs(Concrete.getFluid(576))
                    .duration(20)
                    .EUt(7)
                    .buildAndRegister();
        }

//        def dyes = [
//                "dye_white",
//                "dye_orange",
//                "dye_magenta",
//                "dye_light_blue",
//                "dye_yellow",
//                "dye_lime",
//                "dye_pink",
//                "dye_gray",
//                "dye_light_gray",
//                "dye_cyan",
//                "dye_purple",
//                "dye_blue",
//                "dye_brown",
//                "dye_green",
//                "dye_red",
//                "dye_black"
//        ];

        {
            int i = 0;
            for (Material dye : CHEMICAL_DYES) {
                MIXER_RECIPES.recipeBuilder()
                        .inputs(OreDictUnifier.get("dustConcrete"))
                        .fluidInputs(dye.getFluid(18))
                        .outputs(new ItemStack(Blocks.CONCRETE_POWDER, 1, i))
                        .duration(20)
                        .EUt(30)
                        .buildAndRegister();

                CHEMICAL_BATH_RECIPES.recipeBuilder()
                        .inputs(OreDictUnifier.get("blockConcrete"))
                        .fluidInputs(dye.getFluid(18))
                        .outputs(new ItemStack(Blocks.CONCRETE, 1, i))
                        .duration(20)
                        .EUt(30)
                        .buildAndRegister();
                i++;
            }
        }


        //REMOVALS OF DEFAULT RECIPES
        // Concrete * 576
        removeRecipesByInputs(MIXER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Clay), OreDictUnifier.get(dust, Stone, 3)},
                new FluidStack[]{Water.getFluid(500)});
        removeRecipesByInputs(BLENDER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Clay), OreDictUnifier.get(dust, Stone, 3)},
                new FluidStack[]{Water.getFluid(500)});
        // Concrete * 1152
        removeRecipesByInputs(MIXER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Stone, 2), OreDictUnifier.get(dust, Calcite), OreDictUnifier.get(dust, Gypsum)},
                new FluidStack[]{Water.getFluid(1000)});
        removeRecipesByInputs(BLENDER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Stone, 2), OreDictUnifier.get(dust, Calcite), OreDictUnifier.get(dust, Gypsum)},
                new FluidStack[]{Water.getFluid(1000)});
        // Concrete * 1152
        removeRecipesByInputs(MIXER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Stone, 2), OreDictUnifier.get(dust, Marble), OreDictUnifier.get(dust, Gypsum)},
                new FluidStack[]{Water.getFluid(1000)});
        removeRecipesByInputs(BLENDER_RECIPES,
                new ItemStack[]{OreDictUnifier.get(dust, Stone, 2), OreDictUnifier.get(dust, Marble), OreDictUnifier.get(dust, Gypsum)},
                new FluidStack[]{Water.getFluid(1000)});

        String[] name_removals = {
                "minecraft:white_concrete_powder",
                "minecraft:orange_concrete_powder",
                "minecraft:magenta_concrete_powder",
                "minecraft:light_blue_concrete_powder",
                "minecraft:yellow_concrete_powder",
                "minecraft:lime_concrete_powder",
                "minecraft:pink_concrete_powder",
                "minecraft:gray_concrete_powder",
                "minecraft:light_gray_concrete_powder",
                "minecraft:cyan_concrete_powder",
                "minecraft:purple_concrete_powder",
                "minecraft:blue_concrete_powder",
                "minecraft:brown_concrete_powder",
                "minecraft:green_concrete_powder",
                "minecraft:red_concrete_powder",
                "minecraft:black_concrete_powder",
                //"gregtech:bucket_of_concrete"
        };

        for (String name : name_removals) {
            ModHandler.removeRecipeByName(name);
        }
        for (Material dye : CHEMICAL_DYES) {
            // Concrete Powder * 8
            removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{new ItemStack(Blocks.SAND, 4), new ItemStack(Blocks.GRAVEL, 4)}, new FluidStack[]{dye.getFluid(144)});
            removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{new ItemStack(Blocks.SAND, 4), new ItemStack(Blocks.GRAVEL, 4)}, new FluidStack[]{dye.getFluid(144)});
        }

        for (int i = 0; i < 16; i++) {
            // Colour Concrete * 1
            removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{new ItemStack(Blocks.CONCRETE_POWDER, 1, i)}, new FluidStack[]{Water.getFluid(1000)});
        }
    }
}
