package supersymmetry.loaders;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.StoneVariantBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.oredict.OreDictionary;
import supersymmetry.common.blocks.BlockDeposit;
import supersymmetry.common.blocks.BlockResource;
import supersymmetry.common.blocks.SuSyBlocks;
import supersymmetry.common.blocks.SusyStoneVariantBlock;

import java.util.HashMap;
import java.util.Map;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.dust;
import static gregtechfoodoption.GTFOMaterialHandler.CupricHydrogenArsenite;
import static net.minecraft.init.Items.DYE;
import static supersymmetry.common.blocks.SuSyBlocks.DEPOSIT_BLOCK;
import static supersymmetry.common.blocks.SuSyBlocks.RESOURCE_BLOCK;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;


public class SusyOreDictionaryLoader {
    public static void init(){
        loadStoneOredict();
    }

    public static void loadStoneOredict(){

        for (SusyStoneVariantBlock.StoneType type : SusyStoneVariantBlock.StoneType.values()) {
            ItemStack smooth = SuSyBlocks.SUSY_STONE_BLOCKS.get(SusyStoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(type);
            ItemStack cobble = SuSyBlocks.SUSY_STONE_BLOCKS.get(SusyStoneVariantBlock.StoneVariant.COBBLE).getItemVariant(type);
            OreDictUnifier.registerOre(smooth, type.getOrePrefix(), type.getMaterial());
            OreDictionary.registerOre("stone", smooth);
            OreDictionary.registerOre("cobblestone", cobble);
        }

        for (StoneVariantBlock.StoneType type : StoneVariantBlock.StoneType.values()) {
            ItemStack smooth = MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(type);
            ItemStack cobble = MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.COBBLE).getItemVariant(type);
            OreDictionary.registerOre("stone", smooth);
            OreDictionary.registerOre("cobblestone", cobble);
        }

        OreDictionary.registerOre("gtLight", CARBON_ARC_LAMP.getMetaItem());
        OreDictionary.registerOre("gtLight", INCANDESCENT_LIGHT.getMetaItem());
        OreDictionary.registerOre("gtLight", HALOGEN_LIGHT.getMetaItem());
        OreDictionary.registerOre("gtLight", FLUORESCENT_LIGHT.getMetaItem());
        OreDictionary.registerOre("gtLight", LED_LIGHT.getMetaItem());

        // dyes
        OreDictionary.registerOre("dyeBrown", OreDictUnifier.get(dust, Sienna));
        OreDictionary.registerOre("dyeRed", OreDictUnifier.get(dust, BurntSienna));
        OreDictionary.registerOre("dyeRed", OreDictUnifier.get(dust, Cinnabar));
        OreDictionary.registerOre("dyeYellow", OreDictUnifier.get(dust, LeadChromate));
        OreDictionary.registerOre("dyeGreen", OreDictUnifier.get(dust, Malachite));
        OreDictionary.registerOre("dyeBlue", OreDictUnifier.get(dust, CobaltAluminate));
        OreDictionary.registerOre("dyeWhite", OreDictUnifier.get(dust, LeadNitrate));
        OreDictionary.registerOre("dyeBlack", OreDictUnifier.get(dust, Carbon));
        OreDictionary.registerOre("dyeGreen", CupricHydrogenArsenite.getItemStack());

        // Add non traditional ore blocks to scanner
        OreDictionary.registerOre("oreBauxite", RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.BAUXITE));
        OreDictionary.registerOre("oreSulfur", RESOURCE_BLOCK.getItemVariant(BlockResource.ResourceBlockType.SULFUR));

        OreDictionary.registerOre("oreOrthomagmaticDeposit", DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.ORTHOMAGMATIC));
        OreDictionary.registerOre("oreMetamorphicDeposit", DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.METAMORPHIC));
        OreDictionary.registerOre("oreSedimentaryDeposit", DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.SEDIMENTARY));
        OreDictionary.registerOre("oreHydrothermalDeposit", DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.HYDROTHERMAL));
        OreDictionary.registerOre("oreAlluvialDeposit", DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.ALLUVIAL));
        OreDictionary.registerOre("oreMagmaticHydrothermalDeposit", DEPOSIT_BLOCK.getItemVariant(BlockDeposit.DepositBlockType.MAGMATIC_HYDROTHERMAL));

        // remove Ore dicts
//        {
//        'sgcraft:naquadahingot': 'ingotNaquadahAlloy',
//                'appliedenergistics2:material:2': 'dustCertusQuartz',
//                'appliedenergistics2:material:3': 'dustNetherQuartz',
//                'appliedenergistics2:material:8': 'dustFluix',
//                'appliedenergistics2:material:46': 'dustEnderPearl',
//                'appliedenergistics2:material:49': 'dustIron',
//                'appliedenergistics2:material:51': 'dustGold',
//                'portalgun:item_dust_ender_pearl': 'dustEnderPearl',
//        }

        //Dust oredicting
        String[] elements = {
                "Lithium", "Beryllium", "Boron", "Carbon", "Sodium", "Magnesium", "Aluminium", "Silicon",
                "Phosphorus", "Sulfur", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chrome",
                "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic",
                "Selenium", "Rubidium", "Strontium", "Yttrium", "Ruthenium", "Zirconium", "Niobium", "Molybdenum", "Technetium",
                "Rhenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium",
                "Iodine", "Caesium", "Barium", "Lanthanum", "Hafnium", "Tantalum", "Tungsten", "Osmium",
                "Iridium", "Platinum", "Gold", "Thallium", "Lead", "Bismuth", "Cerium", "Praseodymium",
                "Neodymium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium",
                "Thulium", "Ytterbium", "Lutetium", "Thorium"
        };

        Map<String, Tuple<Material, Material>> elementsMap = new HashMap<>();

        elementsMap.put("Lithium", new Tuple<>(Lithium, HighPurityLithium));
        elementsMap.put("Beryllium", new Tuple<>(Beryllium, HighPurityBeryllium));
        elementsMap.put("Boron", new Tuple<>(Boron, HighPurityBoron));
        elementsMap.put("Carbon", new Tuple<>(Carbon, HighPurityCarbon));
        elementsMap.put("Sodium", new Tuple<>(Sodium, HighPuritySodium));
        elementsMap.put("Magnesium", new Tuple<>(Magnesium, HighPurityMagnesium));
        elementsMap.put("Aluminium", new Tuple<>(Aluminium, HighPurityAluminium));
        elementsMap.put("Silicon", new Tuple<>(Silicon, HighPuritySilicon));
        elementsMap.put("Phosphorus", new Tuple<>(Phosphorus, HighPurityPhosphorus));
        elementsMap.put("Sulfur", new Tuple<>(Sulfur, HighPuritySulfur));
        elementsMap.put("Potassium", new Tuple<>(Potassium, HighPurityPotassium));
        elementsMap.put("Calcium", new Tuple<>(Calcium, HighPurityCalcium));
        elementsMap.put("Scandium", new Tuple<>(Scandium, HighPurityScandium));
        elementsMap.put("Titanium", new Tuple<>(Titanium, HighPurityTitanium));
        elementsMap.put("Vanadium", new Tuple<>(Vanadium, HighPurityVanadium));
        elementsMap.put("Chrome", new Tuple<>(Chrome, HighPurityChrome));
        elementsMap.put("Manganese", new Tuple<>(Manganese, HighPurityManganese));
        elementsMap.put("Iron", new Tuple<>(Iron, HighPurityIron));
        elementsMap.put("Cobalt", new Tuple<>(Cobalt, HighPurityCobalt));
        elementsMap.put("Nickel", new Tuple<>(Nickel, HighPurityNickel));
        elementsMap.put("Copper", new Tuple<>(Copper, HighPurityCopper));
        elementsMap.put("Zinc", new Tuple<>(Zinc, HighPurityZinc));
        elementsMap.put("Gallium", new Tuple<>(Gallium, HighPurityGallium));
        elementsMap.put("Germanium", new Tuple<>(Germanium, HighPurityGermanium));
        elementsMap.put("Arsenic", new Tuple<>(Arsenic, HighPurityArsenic));
        elementsMap.put("Selenium", new Tuple<>(Selenium, HighPuritySelenium));
        elementsMap.put("Rubidium", new Tuple<>(Rubidium, HighPurityRubidium));
        elementsMap.put("Yttrium", new Tuple<>(Yttrium, HighPurityYttrium));
        elementsMap.put("Ruthenium", new Tuple<>(Ruthenium, HighPurityRuthenium));
        elementsMap.put("Zirconium", new Tuple<>(Zirconium, HighPurityZirconium));
        elementsMap.put("Niobium", new Tuple<>(Niobium, HighPurityNiobium));
        elementsMap.put("Molybdenum", new Tuple<>(Molybdenum, HighPurityMolybdenum));
        elementsMap.put("Technetium", new Tuple<>(Technetium, HighPurityTechnetium));
        elementsMap.put("Rhenium", new Tuple<>(Rhenium, HighPurityRhenium));
        elementsMap.put("Rhodium", new Tuple<>(Rhodium, HighPurityRhodium));
        elementsMap.put("Palladium", new Tuple<>(Palladium, HighPurityPalladium));
        elementsMap.put("Silver", new Tuple<>(Silver, HighPuritySilver));
        elementsMap.put("Cadmium", new Tuple<>(Cadmium, HighPurityCadmium));
        elementsMap.put("Indium", new Tuple<>(Indium, HighPurityIndium));
        elementsMap.put("Tin", new Tuple<>(Tin, HighPurityTin));
        elementsMap.put("Antimony", new Tuple<>(Antimony, HighPurityAntimony));
        elementsMap.put("Tellurium", new Tuple<>(Tellurium, HighPurityTellurium));
        elementsMap.put("Iodine", new Tuple<>(Iodine, HighPurityIodine));
        elementsMap.put("Caesium", new Tuple<>(Caesium, HighPurityCaesium));
        elementsMap.put("Barium", new Tuple<>(Barium, HighPurityBarium));
        elementsMap.put("Lanthanum", new Tuple<>(Lanthanum, HighPurityLanthanum));
        elementsMap.put("Hafnium", new Tuple<>(Hafnium, HighPurityHafnium));
        elementsMap.put("Tantalum", new Tuple<>(Tantalum, HighPurityTantalum));
        elementsMap.put("Tungsten", new Tuple<>(Tungsten, HighPurityTungsten));
        elementsMap.put("Osmium", new Tuple<>(Osmium, HighPurityOsmium));
        elementsMap.put("Iridium", new Tuple<>(Iridium, HighPurityIridium));
        elementsMap.put("Platinum", new Tuple<>(Platinum, HighPurityPlatinum));
        elementsMap.put("Gold", new Tuple<>(Gold, HighPurityGold));
        elementsMap.put("Thallium", new Tuple<>(Thallium, HighPurityThallium));
        elementsMap.put("Lead", new Tuple<>(Lead, HighPurityLead));
        elementsMap.put("Bismuth", new Tuple<>(Bismuth, HighPurityBismuth));
        elementsMap.put("Cerium", new Tuple<>(Cerium, HighPurityCerium));
        elementsMap.put("Neodymium", new Tuple<>(Neodymium, HighPurityNeodymium));
        elementsMap.put("Samarium", new Tuple<>(Samarium, HighPuritySamarium));
        elementsMap.put("Europium", new Tuple<>(Europium, HighPurityEuropium));
        elementsMap.put("Gadolinium", new Tuple<>(Gadolinium, HighPurityGadolinium));
        elementsMap.put("Terbium", new Tuple<>(Terbium, HighPurityTerbium));
        elementsMap.put("Dysprosium", new Tuple<>(Dysprosium, HighPurityDysprosium));
        elementsMap.put("Holmium", new Tuple<>(Holmium, HighPurityHolmium));
        elementsMap.put("Erbium", new Tuple<>(Erbium, HighPurityErbium));
        elementsMap.put("Thulium", new Tuple<>(Thulium, HighPurityThulium));
        elementsMap.put("Ytterbium", new Tuple<>(Ytterbium, HighPurityYtterbium));
        elementsMap.put("Lutetium", new Tuple<>(Lutetium, HighPurityLutetium));
        elementsMap.put("Thorium", new Tuple<>(Thorium, HighPurityThorium));
        // elementsMap.put(Strontium, HighPurityStrontium);
        // elementsMap.put(Praseodymium, HighPurityPraseodymium);

        elementsMap.forEach((String name, Tuple<Material, Material> element) -> {
            String anyPurityDust = "dustAnyPurity" + name;
            ItemStack highPurityDust = OreDictUnifier.get(dust, element.getSecond());
            ItemStack normalDust = OreDictUnifier.get(dust, element.getFirst());

            // Add both high purity and normal dust to the anyPurity dust ore dictionary entry
            OreDictionary.registerOre(anyPurityDust, highPurityDust);
            OreDictionary.registerOre(anyPurityDust, normalDust);
        });

        // Nitrogen Nutrients
        OreDictionary.registerOre("nutrientNitrogen", OreDictUnifier.get(dust, AmmoniumChloride));
        OreDictionary.registerOre("nutrientNitrogen", OreDictUnifier.get(dust, AmmoniumNitrate));
        OreDictionary.registerOre("nutrientNitrogen", OreDictUnifier.get(dust, AmmoniumSulfate));
        OreDictionary.registerOre("nutrientNitrogen", OreDictUnifier.get(dust, Urea));

        // Potassium Nutrients
        OreDictionary.registerOre("nutrientPotassium", OreDictUnifier.get(dust, Ash));
        OreDictionary.registerOre("nutrientPotassium", OreDictUnifier.get(dust, Charcoal));
        OreDictionary.registerOre("nutrientPotassium", OreDictUnifier.get(dust, RockSalt));
        OreDictionary.registerOre("nutrientPotassium", OreDictUnifier.get(dust, PotassiumCarbonate));
        OreDictionary.registerOre("nutrientPotassium", OreDictUnifier.get(dust, Potash));

        // Phosphorous Nutrients
        OreDictionary.registerOre("nutrientPhosphorous", OreDictUnifier.get(dust, Chlorapatite));
        OreDictionary.registerOre("nutrientPhosphorous", OreDictUnifier.get(dust, Hydroxyapatite));
        OreDictionary.registerOre("nutrientPhosphorous", OreDictUnifier.get(dust, Fluorapatite));
        OreDictionary.registerOre("nutrientPhosphorous", OreDictUnifier.get(dust, TricalciumPhosphate));
        OreDictionary.registerOre("nutrientPhosphorous", OreDictUnifier.get(dust, Phosphorus));
        OreDictionary.registerOre("nutrientPhosphorous", OreDictUnifier.get(dust, Phosphorite));
        OreDictionary.registerOre("nutrientPhosphorous", new ItemStack(DYE, 1, 15));

        // For IR railbeds
        ItemStack concreteLightSmooth = MetaBlocks.STONE_BLOCKS.get(StoneVariantBlock.StoneVariant.SMOOTH).getItemVariant(StoneVariantBlock.StoneType.CONCRETE_LIGHT);
        OreDictionary.registerOre("railBed", concreteLightSmooth);
    }
}
