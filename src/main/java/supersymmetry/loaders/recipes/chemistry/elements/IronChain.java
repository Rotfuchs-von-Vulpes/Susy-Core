package supersymmetry.loaders.recipes.chemistry.elements;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;
import supersymmetry.loaders.recipes.Utils.CarbonSource;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.INTEGRATED_CIRCUIT;
import static net.minecraft.init.Items.COAL;
import static net.minecraft.init.Items.IRON_INGOT;
import static supersymmetry.api.recipes.SuSyRecipeMaps.REACTION_FURNACE_RECIPES;
import static supersymmetry.api.recipes.SuSyRecipeMaps.ROASTER_RECIPES;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.combustibles;

public class IronChain {
    private static class Blastable {
        private final ItemStack name;
        private final int amount_produced;
        //In liters
        private final int reductant_required;
        private final int duration;

        public Blastable(ItemStack name, int amount_produced, int reductant_required, int duration) {
            this.name = name;
            this.amount_produced = amount_produced;
            this.reductant_required = reductant_required;
            this.duration = duration;
        }
    }

    private static class Reductant {
        private final FluidStack name;
        private final FluidStack byproduct;
        public Reductant(FluidStack name, FluidStack byproduct) {
            this.name = name;
            this.byproduct = byproduct;
        }
    }

    public static void init() {
        ItemStack circuitNBT = INTEGRATED_CIRCUIT.getStackForm();
        NBTTagCompound nbt = new NBTTagCompound();

        nbt.setInteger("Configuration", 2);
        circuitNBT.setTagCompound(nbt);

        //RECIPE REMOVALS
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, OreDictUnifier.get(ingot, WroughtIron), OreDictUnifier.get(dust, Coke));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, OreDictUnifier.get(ingot, WroughtIron),OreDictUnifier.get(gem, Coke));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, OreDictUnifier.get(ingot, WroughtIron), new ItemStack(COAL, 2));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, OreDictUnifier.get(ingot, WroughtIron), OreDictUnifier.get(dust, Coal, 2));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, OreDictUnifier.get(ingot, WroughtIron), OreDictUnifier.get(dust, Charcoal, 2));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, OreDictUnifier.get(ingot, WroughtIron), new ItemStack(COAL, 2, 1));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, new ItemStack(IRON_INGOT), OreDictUnifier.get(dust, Coke));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, new ItemStack(IRON_INGOT), OreDictUnifier.get(gem, Coke));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, new ItemStack(IRON_INGOT), OreDictUnifier.get(dust, Coal, 2));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, new ItemStack(IRON_INGOT), OreDictUnifier.get(dust, Charcoal, 2));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, new ItemStack(IRON_INGOT), new ItemStack(COAL, 2));
        removeRecipesByInputs(PRIMITIVE_BLAST_FURNACE_RECIPES, new ItemStack(IRON_INGOT), new ItemStack(COAL, 2, 1));

        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{new ItemStack(IRON_INGOT)}, new FluidStack[]{Oxygen.getFluid(200)});
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Iron), circuitNBT}, new FluidStack[]{Oxygen.getFluid(200)});
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(ingot, WroughtIron)}, new FluidStack[]{Oxygen.getFluid(200)});
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, WroughtIron), circuitNBT}, new FluidStack[]{Oxygen.getFluid(200)});
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Iron, 4), OreDictUnifier.get(dust, Carbon));
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, WroughtIron, 4), OreDictUnifier.get(dust, Carbon));

        Blastable[] blastables = {
                new Blastable(OreDictUnifier.get(dust, Magnetite, 2), 6, 4, 80),
                new Blastable(OreDictUnifier.get(dust, BandedIron, 2), 4, 3, 80),
                new Blastable(OreDictUnifier.get(dust, Hematite, 2), 4, 3, 80),
                new Blastable(OreDictUnifier.get(dust, IronIIIOxide, 5), 2, 3, 20),
                new Blastable(OreDictUnifier.get(dust, IronIIOxide, 2), 1, 1, 20),
                new Blastable(OreDictUnifier.get(dust, GraniticMineralSand, 2), 6, 4, 80),
                new Blastable(OreDictUnifier.get(ore, Iron, 2), 2, 2, 60),
                new Blastable(OreDictUnifier.get(ore, Magnetite, 1), 3, 4, 60),
                new Blastable(OreDictUnifier.get(ore, BandedIron, 1), 2, 3, 60),
                new Blastable(OreDictUnifier.get(oreNetherrack, Magnetite, 1), 6, 4, 60),
                new Blastable(OreDictUnifier.get(oreNetherrack, BandedIron, 1), 4, 3, 60),
                new Blastable(OreDictUnifier.get(oreEndstone, Magnetite, 1), 6, 4, 60),
                new Blastable(OreDictUnifier.get(oreEndstone, BandedIron, 1), 4, 3, 60)
        };

        Reductant[] reductants = {
                new Reductant(CarbonMonoxide.getFluid(1000), CarbonDioxide.getFluid(1000)),
                new Reductant(Hydrogen.getFluid(2000), Steam.getFluid(1000))
        };

        for (Blastable blastable : blastables) {
            for (CarbonSource combustible : combustibles) {
                int amount = combustible.equivalent(1) * blastable.reductant_required;

                combustible.name.setCount(amount);
                combustible.byproduct.setCount(amount);

                ItemStack output = OreDictUnifier.get(ingot, PigIron, blastable.amount_produced);

                //BESSEMER PROCESS
                PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                        .inputs(blastable.name)
                        .inputs(combustible.name)
                        .outputs(output)
                        .outputs(combustible.byproduct)
                        .duration(combustible.duration * blastable.amount_produced * blastable.duration)
                        .buildAndRegister();

                //MODERN BLAST FURNACE
                BLAST_RECIPES.recipeBuilder()
                        .inputs(blastable.name)
                        .inputs(combustible.name)
                        .outputs(output)
                        .outputs(combustible.byproduct)
                        .duration(combustible.duration * blastable.amount_produced * blastable.duration / 2)
                        .blastFurnaceTemp(1750)
                        .EUt(30)
                        .buildAndRegister();
            }

            // DIRECT REDUCED IRON
            for (Reductant reductant : reductants) {
                FluidStack reductantInput = new FluidStack(reductant.name.getFluid(), reductant.name.amount * blastable.reductant_required);
                ItemStack output = OreDictUnifier.get(ingot, PigIron, blastable.amount_produced);
                FluidStack byproduct = new FluidStack(reductant.byproduct.getFluid(), reductant.byproduct.amount * blastable.reductant_required);

                BLAST_RECIPES.recipeBuilder()
                        .inputs(blastable.name)
                        .fluidInputs(reductantInput)
                        .output(IRON_INGOT, blastable.amount_produced)
                        .chancedOutput(OreDictUnifier.get(dust, SiliconDioxide), 5000, 0)
                        .fluidOutputs(byproduct)
                        .duration(blastable.amount_produced * blastable.duration / 4)
                        .circuitMeta(1)
                        .blastFurnaceTemp(1750)
                        .EUt(400)
                        .buildAndRegister();

                BLAST_RECIPES.recipeBuilder()
                        .inputs(blastable.name)
                        .fluidInputs(reductantInput)
                        .outputs(output)
                        .fluidOutputs(byproduct)
                        .duration((blastable.amount_produced * blastable.duration / 4))
                        .blastFurnaceTemp(1750)
                        .circuitMeta(2)
                        .EUt(400)
                        .buildAndRegister();
            }
        }

        ModHandler.addSmeltingRecipe(OreDictUnifier.get(dust, BrownLimonite), OreDictUnifier.get(dust, BandedIron));
        ModHandler.addSmeltingRecipe(OreDictUnifier.get(dust, YellowLimonite), OreDictUnifier.get(dust, BandedIron));
        ModHandler.addSmeltingRecipe(OreDictUnifier.get(ingot, WroughtIron), new ItemStack(IRON_INGOT));

        //Deleting old Steel Dust -> Steel Ingot recipe
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, Steel));
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, SteelMagnetic));

        //Readding Steel Dust -> Steel Ingot recipe

        BLAST_RECIPES.recipeBuilder()
                .input(dust, Steel)
                .output(ingot, Steel)
                .duration(60)
                .blastFurnaceTemp(1750)
                .EUt(60)
                .buildAndRegister();
        BLAST_RECIPES.recipeBuilder()
                .input(dust, SteelMagnetic)
                .output(ingot, Steel)
                .duration(60)
                .blastFurnaceTemp(1750)
                .EUt(60)
                .buildAndRegister();

        ModHandler.addShapelessRecipe("pig_iron_shearing", OreDictUnifier.get(ingot, WroughtIron), OreDictUnifier.get(ingot, PigIron), 'h');

        FORGE_HAMMER_RECIPES.recipeBuilder()
                .input(ingot, PigIron)
                .output(ingot, WroughtIron)
                .duration(20)
                .EUt(7)
                .buildAndRegister();

        //BASIC OXYGEN PROCESS
        BLAST_RECIPES.recipeBuilder()
                .input(ingot, PigIron)
                .fluidInputs(Oxygen.getFluid(50))
                .output(ingot, Steel)
                .blastFurnaceTemp(1750)
                .EUt(30)
                .duration(10)
                .circuitMeta(1)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .input(ingot, PigIron)
                .fluidInputs(Oxygen.getFluid(50))
                .output(IRON_INGOT)
                .blastFurnaceTemp(1750)
                .EUt(30)
                .duration(10)
                .circuitMeta(2)
                .buildAndRegister();

        //CEMENTED STEEL

        for (CarbonSource combustible : combustibles) {
            combustible.name.setCount(combustible.equivalent(1));
            combustible.byproduct.setCount(combustible.equivalent(1));

            PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                    .inputs(new ItemStack(IRON_INGOT))
                    .inputs(combustible.name)
                    .output(ingot, Steel)
                    .outputs(combustible.byproduct)
                    .duration(combustible.duration * 120)
                    .buildAndRegister();

            PRIMITIVE_BLAST_FURNACE_RECIPES.recipeBuilder()
                    .input(ingot, WroughtIron)
                    .inputs(combustible.name)
                    .output(ingot, Steel)
                    .outputs(combustible.byproduct)
                    .duration(combustible.duration * 60)
                    .buildAndRegister();
        }

        REACTION_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Iron)
                .fluidInputs(CarbonMonoxide.getFluid(5000))
                .fluidOutputs(CrudeIronPentacarbonyl.getFluid(1000))
                .duration(200)
                .EUt(60)
                .buildAndRegister();

        DISTILLERY_RECIPES.recipeBuilder()
                .fluidInputs(CrudeIronPentacarbonyl.getFluid(1000))
                .fluidOutputs(IronPentacarbonyl.getFluid(1000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(IronPentacarbonyl.getFluid(1000))
                .output(dust, HighPurityIron)
                .fluidOutputs(CarbonMonoxide.getFluid(5000))
                .duration(300)
                .EUt(30)
                .buildAndRegister();

        BLAST_RECIPES.recipeBuilder()
                .circuitMeta(1)
                .input(dust, HighPurityIron)
                .outputs(new ItemStack(IRON_INGOT))
                .duration(60)
                .blastFurnaceTemp(1750)
                .EUt(60)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, IronIIIHydroxide, 14)
                .output(dust, IronIIIOxide, 5)
                .fluidOutputs(Steam.getFluid(3000))
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, IronIIHydroxide, 5)
                .output(dust, IronIIOxide, 2)
                .fluidOutputs(Steam.getFluid(1000))
                .EUt(30)
                .duration(200)
                .buildAndRegister();
    }
}
