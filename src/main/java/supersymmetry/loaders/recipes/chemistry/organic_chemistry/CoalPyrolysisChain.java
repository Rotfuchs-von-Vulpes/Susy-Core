package supersymmetry.loaders.recipes.chemistry.organic_chemistry;

import gregtech.api.unification.OreDictUnifier;
import net.minecraft.item.ItemStack;
import supersymmetry.loaders.recipes.Utils;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtech.api.unification.ore.OrePrefix.gem;
import static gregtechfoodoption.GTFOMaterialHandler.Aniline;
import static supersymmetry.api.recipes.SuSyRecipeMaps.CSTR_RECIPES;
import static supersymmetry.common.item.SuSyMetaItems.BITUMEN;
import static supersymmetry.common.materials.SusyMaterials.*;

public class CoalPyrolysisChain {
    private static class PyrolisisCarbon extends Utils.Carbon {
        public ItemStack pyrolysisProduct;
        public int num_items_by_carbon(int required_carbon) {
            return numItemByProvider(required_carbon, this.carbon);
        }
        public PyrolisisCarbon(ItemStack name, int carbon, ItemStack pyrolysisProduct) {
            super(name, carbon);
            this.pyrolysisProduct = pyrolysisProduct;
        }
    }
    public static void init() {
        PyrolisisCarbon[] coalList = {
                new PyrolisisCarbon(OreDictUnifier.get(dust, Coal), 75, OreDictUnifier.get(dust, Coke)),
                new PyrolisisCarbon(OreDictUnifier.get(gem, Coal), 75, OreDictUnifier.get(gem, Coke)),
                new PyrolisisCarbon(OreDictUnifier.get(dust, Charcoal), 60, OreDictUnifier.get(dust, Coke)),
                new PyrolisisCarbon(OreDictUnifier.get(gem, Charcoal), 60, OreDictUnifier.get(gem, Coke))
        };
        PyrolisisCarbon[] anthraciteList = {
                new PyrolisisCarbon(OreDictUnifier.get(dust, Anthracite), 90, OreDictUnifier.get(dust, Coke)),
                new PyrolisisCarbon(OreDictUnifier.get(gem, Anthracite), 90, OreDictUnifier.get(gem, Coke))
        };
        PyrolisisCarbon[] ligniteList = {
                new PyrolisisCarbon(OreDictUnifier.get(dust, Lignite), 25, OreDictUnifier.get(dust, LigniteCoke)),
                new PyrolisisCarbon(OreDictUnifier.get(gem, Lignite), 25, OreDictUnifier.get(gem, LigniteCoke))
        };
        PyrolisisCarbon[] cokeList = {
                new PyrolisisCarbon(OreDictUnifier.get(dust, Coke), 100, OreDictUnifier.get(dust, Carbon)),
                new PyrolisisCarbon(OreDictUnifier.get(gem, Coke), 100, OreDictUnifier.get(dust, Carbon))
        };
        PyrolisisCarbon[] ligniteCokeList = {
                new PyrolisisCarbon(OreDictUnifier.get(dust, LigniteCoke), 75, OreDictUnifier.get(dust, Carbon)),
                new PyrolisisCarbon(OreDictUnifier.get(gem, LigniteCoke), 75, OreDictUnifier.get(dust, Carbon))
        };

        for (PyrolisisCarbon item : coalList) {
            int CARBON_PROCESSED = 1200;
            item.name.setCount(item.num_items_by_carbon(CARBON_PROCESSED));
            item.pyrolysisProduct.setCount(item.num_items_by_carbon(CARBON_PROCESSED));
            PYROLYSE_RECIPES.recipeBuilder()
                    .inputs(item.name)
                    .outputs(item.pyrolysisProduct)
                    .fluidOutputs(CoalGas.getFluid(2500))
                    .fluidOutputs(CoalTar.getFluid(2500))
                    .duration(320)
                    .EUt(60)
                    .buildAndRegister();
        }

        for (PyrolisisCarbon item : anthraciteList) {
            int CARBON_PROCESSED = 1400;
            item.name.setCount(item.num_items_by_carbon(CARBON_PROCESSED));
            item.pyrolysisProduct.setCount(item.num_items_by_carbon(CARBON_PROCESSED));
            PYROLYSE_RECIPES.recipeBuilder()
                    .inputs(item.name)
                    .outputs(item.pyrolysisProduct)
                    .fluidOutputs(CoalGas.getFluid(3200))
                    .fluidOutputs(CoalTar.getFluid(3200))
                    .duration(320)
                    .EUt(60)
                    .buildAndRegister();
        }

        for (PyrolisisCarbon item : ligniteList) {
            int CARBON_PROCESSED = 400;
            item.name.setCount(item.num_items_by_carbon(CARBON_PROCESSED));
            item.pyrolysisProduct.setCount(item.num_items_by_carbon(CARBON_PROCESSED));
            PYROLYSE_RECIPES.recipeBuilder()
                    .inputs(item.name)
                    .outputs(item.pyrolysisProduct)
                    .fluidOutputs(Creosote.getFluid(1600))
                    .fluidOutputs(Syngas.getFluid(2000))
                    .duration(320)
                    .EUt(60)
                    .buildAndRegister();
        }

        for (PyrolisisCarbon item : cokeList) {
            item.name.setCount(16);
            item.pyrolysisProduct.setCount(12);
            PYROLYSE_RECIPES.recipeBuilder()
                    .inputs(item.name)
                    .outputs(item.pyrolysisProduct)
                    .fluidInputs(Steam.getFluid(15000))
                    .fluidOutputs(Syngas.getFluid(12000))
                    .duration(320)
                    .EUt(60)
                    .buildAndRegister();
        }

        for (PyrolisisCarbon item : ligniteCokeList) {
            item.name.setCount(16);
            item.pyrolysisProduct.setCount(9);
            PYROLYSE_RECIPES.recipeBuilder()
                    .inputs(item.name)
                    .outputs(item.pyrolysisProduct)
                    .fluidInputs(Steam.getFluid(15000))
                    .fluidOutputs(Syngas.getFluid(12000))
                    .duration(320)
                    .EUt(60)
                    .buildAndRegister();
        }

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(CoalGas.getFluid(10000))
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(Syngas.getFluid(10000))
                .fluidOutputs(AmmoniaSolution.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .chancedOutput(BITUMEN, 5000, 0)
                .fluidInputs(CoalTar.getFluid(1000))
                .fluidOutputs(AnthraceneOil.getFluid(100))
                .fluidOutputs(NaphthaleneOil.getFluid(100))
                .fluidOutputs(Creosote.getFluid(450))
                .fluidOutputs(LightOil.getFluid(350))
                .duration(200)
                .EUt(48)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(NaphthaleneOil.getFluid(1000))
                .fluidInputs(SodiumHydroxideSolution.getFluid(100))
                .fluidOutputs(Creosote.getFluid(100))
                .fluidOutputs(AlkalineNaphthaleneOil.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(AlkalineNaphthaleneOil.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(100))
                .fluidOutputs(SodiumSulfateSolution.getFluid(100))
                .fluidOutputs(PurifiedNaphthaleneOil.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(PurifiedNaphthaleneOil.getFluid(1000))
                .fluidOutputs(AnthraceneOil.getFluid(100))
                .fluidOutputs(Naphthalene.getFluid(800))
                .fluidOutputs(LightOil.getFluid(100))
                .duration(200)
                .EUt(48)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(LightOil.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(100))
                .fluidOutputs(AcidicLightOil.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(AcidicLightOil.getFluid(1000))
                .fluidInputs(Furfural.getFluid(75))
                .fluidOutputs(BtexExtract.getFluid(750))
                .fluidOutputs(CrudePyridiniumSulfate.getFluid(250))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(CrudePyridiniumSulfate.getFluid(50))
                .fluidInputs(Ammonia.getFluid(100))
                .fluidOutputs(ImpurePyridine.getFluid(50))
                .duration(1)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpurePyridine.getFluid(1000))
                .output(dust, AmmoniumSulfate, 15)
                .fluidOutputs(Aniline.getFluid(250))
                .fluidOutputs(Pyridine.getFluid(750))
                .duration(200)
                .EUt(48)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .fluidInputs(AnthraceneOil.getFluid(1000))
                .fluidInputs(SulfuricAcid.getFluid(100))
                .fluidOutputs(AcidicAnthraceneOil.getFluid(1000))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .fluidInputs(AcidicAnthraceneOil.getFluid(1000))
                .fluidInputs(EthyleneGlycol.getFluid(75))
                .fluidOutputs(AnthraceneExtract.getFluid(750))
                .fluidOutputs(CrudeQuinoliniumSulfate.getFluid(250))
                .duration(120)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(AnthraceneExtract.getFluid(1000))
                .chancedOutput(dust, Anthracene, 8000, 0)
                .fluidOutputs(EthyleneGlycol.getFluid(100))
                .fluidOutputs(LightOil.getFluid(200))
                .duration(200)
                .EUt(48)
                .buildAndRegister();

        CSTR_RECIPES.recipeBuilder()
                .fluidInputs(CrudeQuinoliniumSulfate.getFluid(50))
                .fluidInputs(Ammonia.getFluid(100))
                .fluidOutputs(ImpureQuinoline.getFluid(50))
                .duration(1)
                .EUt(30)
                .buildAndRegister();

        DISTILLATION_RECIPES.recipeBuilder()
                .fluidInputs(ImpureQuinoline.getFluid(1000))
                .output(dust, AmmoniumSulfate, 15)
                .fluidOutputs(Quinoline.getFluid(800))
                .fluidOutputs(NaphthaleneOil.getFluid(200))
                .duration(200)
                .EUt(48)
                .buildAndRegister();

// Centrifuging Lignite to Carbon
        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, Lignite)
                .chancedOutput(dust, Carbon, 2500, 0)
                .duration(80)
                .EUt(30)
                .buildAndRegister();

        CENTRIFUGE_RECIPES.recipeBuilder()
                .input(dust, LigniteCoke)
                .chancedOutput(dust, Carbon, 7500, 0)
                .duration(80)
                .EUt(30)
                .buildAndRegister();
    }
}
