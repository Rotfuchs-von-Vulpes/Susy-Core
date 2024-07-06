package supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group13;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class IndiumChain {
    public static void init() {
        // From zinc calcine (zincite) or zinc oxide fume from lead

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, ZincLeachResidue, 8)
                .fluidInputs(DilutedHydrochloricAcid.getFluid(2000))
                .output(dust, ZincHydrochloricLeachResidue, 8)
                .fluidOutputs(IndiumLeach.getFluid(2000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, SodaAsh, 3)
                .fluidInputs(IndiumLeach.getFluid(2000))
                .chancedOutput(dust, IndiumResidue, 8000, 0)
                .fluidOutputs(CarbonDioxide.getFluid(500))
                .fluidOutputs(Wastewater.getFluid(2000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, IndiumResidue)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .output(dust, CrudeIndiumIIIHydroxide, 7)
                .fluidOutputs(Wastewater.getFluid(1000))
                .EUt(30)
                .duration(160)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, CrudeIndiumIIIHydroxide, 14)
                .fluidInputs(SulfuricAcid.getFluid(3000))
                .fluidOutputs(CrudeIndiumIIISulfateSolution.getFluid(6000))
                .EUt(30)
                .duration(320)
                .buildAndRegister();

        BUBBLE_COLUMN_REACTOR_RECIPES.recipeBuilder()
                .fluidInputs(CrudeIndiumIIISulfateSolution.getFluid(300))
                .fluidInputs(HydrogenSulfide.getFluid(5))
                .fluidOutputs(IndiumIIISulfateSolution.getFluid(300))
                .EUt(30)
                .duration(16)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Zinc, 3)
                .fluidInputs(IndiumIIISulfateSolution.getFluid(6000))
                .output(SPONGE_INDIUM, 2)
                .fluidOutputs(ZincSulfateSolution.getFluid(6000))
                .EUt(30)
                .duration(320)
                .buildAndRegister();

        ELECTROLYZER_RECIPES.recipeBuilder()
                .notConsumable(GRAPHITE_ELECTRODE)
                .notConsumable(stick, Zinc)
                .fluidInputs(ZincSulfateSolution.getFluid(2000))
                .output(dust, Zinc)
                .fluidOutputs(DilutedSulfuricAcid.getFluid(2000))
                .fluidOutputs(Oxygen.getFluid(1000))
                .EUt(30)
                .duration(320)
                .buildAndRegister();

// From lead electrorefining

        ROASTER_RECIPES.recipeBuilder()
                .circuitMeta(2)
                .input(ANODE_SLIME_LEAD)
                .fluidInputs(SulfuricAcid.getFluid(150))
                .output(dust, SulfatizedLeadSlime)
                .EUt(480)
                .duration(200)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, SulfatizedLeadSlime)
                .fluidInputs(DistilledWater.getFluid(300))
                .output(dust, BlackMetal)
                .fluidOutputs(ImpureIndiumLeach.getFluid(300))
                .EUt(30)
                .duration(320)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, Indium, 2)
                .fluidInputs(ImpureIndiumLeach.getFluid(12000))
                .output(dust, Copper, 3)
                .fluidOutputs(IndiumIIISulfateSolution.getFluid(12000))
                .EUt(30)
                .duration(320)
                .buildAndRegister();

// Purification

        MACERATOR_RECIPES.recipeBuilder()
                .input(SPONGE_INDIUM)
                .output(dust, Indium)
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        VACUUM_DISTILLATION_RECIPES.recipeBuilder()
                .input(dust, Indium)
                .chancedOutput(dust, HighPurityIndium, 9900, 0)
                .EUt(120)
                .duration(1000)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, IndiumChloride, 4)
                .fluidInputs(DistilledWater.getFluid(1000))
                .fluidOutputs(IndiumChlorideSolution.getFluid(1000))
                .EUt(30)
                .duration(20)
                .buildAndRegister();

        ELECTROLYTIC_CELL_RECIPES.recipeBuilder()
                .notConsumable(plate, HighPurityIndium)
                .notConsumable(IndiumChlorideSolution.getFluid(1000))
                .input(plate, Indium)
                .chancedOutput(dust, HighPurityIndium, 9900, 0)
                .EUt(120)
                .duration(100)
                .buildAndRegister();
    }
}
