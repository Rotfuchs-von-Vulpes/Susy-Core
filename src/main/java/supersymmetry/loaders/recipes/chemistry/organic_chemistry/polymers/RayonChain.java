package supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.Air;
import static gregtech.api.unification.material.Materials.DilutedSulfuricAcid;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static net.minecraft.init.Blocks.WOOL;
import static supersymmetry.api.unification.ore.SusyOrePrefix.thread;
import static supersymmetry.api.unification.ore.SusyOrePrefix.wetFiber;
import static supersymmetry.common.item.SuSyMetaItems.SPINNERET;
import static supersymmetry.common.materials.SusyMaterials.*;

public class RayonChain {
    public static void init() {
        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .input(dust, Cellulose, 4)
                .fluidInputs(ManganeseIISulfateSolution.getFluid(50))
                .fluidInputs(SodiumHydroxideSolution.getFluid(3000))
                .fluidOutputs(Wastewater.getFluid(2000))
                .output(dust, AlkaliCellulose, 4)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .fluidInputs(CarbonDisulfide.getFluid(1000))
                .input(dust, AlkaliCellulose)
                .output(dust, SodiumCelluloseXanthate)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, SodiumCelluloseXanthate)
                .fluidInputs(SodiumHydroxideSolution.getFluid(1000))
                .fluidOutputs(SodiumCelluloseXanthateSolution.getFluid(1000))
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .notConsumable(SPINNERET)
                .fluidInputs(SodiumCelluloseXanthateSolution.getFluid(2000))
                .fluidInputs(DilutedSulfuricAcid.getFluid(3000))
                .fluidInputs(Air.getFluid(1000))
                .fluidOutputs(CarbonDisulfide.getFluid(2000))
                .fluidOutputs(SodiumSulfateSolution.getFluid(1500))
                .fluidOutputs(Wastewater.getFluid(500))
                .output(wetFiber, Rayon, 8)
                .duration(200)
                .EUt(240)
                .buildAndRegister();

        COMPRESSOR_RECIPES.recipeBuilder()
                .input(thread, Rayon, 8)
                .output(WOOL)
                .duration(100)
                .EUt(30)
                .buildAndRegister();

    }
}
