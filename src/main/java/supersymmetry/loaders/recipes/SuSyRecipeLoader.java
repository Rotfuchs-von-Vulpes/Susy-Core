package supersymmetry.loaders.recipes;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.Materials;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.StoneVariantBlock;
import net.minecraft.item.ItemStack;
import supersymmetry.common.blocks.SuSyBlocks;
import supersymmetry.common.blocks.SusyStoneVariantBlock;
import supersymmetry.common.materials.SusyMaterials;
import supersymmetry.loaders.recipes.biology.FermentingChain;
import supersymmetry.loaders.recipes.biology.GreenhouseChain;
import supersymmetry.loaders.recipes.biology.ResinChain;
import supersymmetry.loaders.recipes.chemistry.*;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.Dyes;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.ElectrolysisOverhaul;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.GemChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.WaterPurificationChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group10.NickelChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group10.PlatinumGroupChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group11.CopperChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group11.GoldChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group11.SilverChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group12.CadmiumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group12.MercuryChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group12.ZincChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group4.HafniumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group4.TitaniumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group4.ZirconiumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group5.NiobiumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group5.TantalumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group5.VanadiumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group6.ChromiumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group6.MolybdenumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group6.TungstenChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group7.ManganeseChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group7.RheniumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group8.IronChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.DBlock.group9.CobaltChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.FBlock.actinides.UraniumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group13.*;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group14.GermaniumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group14.LeadChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group14.SiliconChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group14.TinChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group15.AntimonyChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group15.ArsenicChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group15.BismuthChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group15.PhosphorusChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group16.OxygenChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group16.SeleniumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group16.SulfurChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group16.TelluriumChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group17.FluorineChain;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.PBock.group18.AirDistillation;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group1.*;
import supersymmetry.loaders.recipes.chemistry.inorganicChemistry.elements.SBlock.group2.*;
import supersymmetry.loaders.recipes.chemistry.organic_chemistry.*;
import supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry.Fuel;
import supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry.Lubricants;
import supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry.OilOverhaul;
import supersymmetry.loaders.recipes.chemistry.organic_chemistry.petrochemistry.Surfactants;
import supersymmetry.loaders.recipes.chemistry.organic_chemistry.polymers.*;
import supersymmetry.loaders.recipes.components.*;
import supersymmetry.loaders.recipes.gameplay.Smelting;
import supersymmetry.loaders.recipes.gameplay.StartingAge;
import supersymmetry.loaders.recipes.metallurgy.*;
import supersymmetry.loaders.recipes.miscChains.*;
import supersymmetry.loaders.recipes.others.Machines;
import supersymmetry.loaders.recipes.others.Mining;
import supersymmetry.loaders.recipes.others.ModifyRecipeMaps;

import java.util.*;
import java.util.stream.Collectors;

import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.SHAPE_EXTRUDER_BLOCK;

public class SuSyRecipeLoader {
    public static void init() {
        ModifyRecipeMaps.init();
        Machines.init();

        FermentingChain.init();
        GreenhouseChain.init();
        ResinChain.init();

        AluminiumChain.init();
        AntimonyChain.init();
        ArsenicChain.init();
        BariumChain.init();
        BerylliumChain.init();
        BismuthChain.init();
        BoronChain.init();
        CadmiumChain.init();
        CaesiumChain.init();
        CalciumChain.init();
        ChromiumChain.init();
        CobaltChain.init();
        CopperChain.init();
        FluorineChain.init();
        GalliumChain.init();
        GermaniumChain.init();
        GoldChain.init();
        HafniumChain.init();
        HydrogenChein.init();
        IndiumChain.init();
        IronChain.init();
        LeadChain.init();
        LithiumChain.init();
        MagnesiumChain.init();
        ManganeseChain.init();
        MercuryChain.init();
        MolybdenumChain.init();
        NickelChain.init();
        NiobiumChain.init();
        OxygenChain.init();
        PhosphorusChain.init();
        PlatinumGroupChain.init();
        RheniumChain.init();
        RubidiumChain.init();
        SeleniumChain.init();
        SiliconChain.init();
        SilverChain.init();
        SodiumChain.init();
        StrontiumChain.init();
        SulfurChain.init();
        TantalumChain.init();
        TelluriumChain.init();
        TinChain.init();
        ThaliumChain.init();
        TitaniumChain.init();
        TungstenChain.init();
        UraniumChain.init();
        VanadiumChain.init();
        ZincChain.init();
        ZirconiumChain.init();

        Fuel.init();
        Lubricants.init();
        OilOverhaul.init();
        Surfactants.init();

        AramidChain.init();
        EpoxyChain.init();
        NylonChain.init();
        PolybenzimidazoleChain.init();
        PolycarbonateChain.init();
        PolydimethylsiloxaneChain.init();
        PolyesterChain.init();
        PolymethacrylateChain.init();
        PolyolefinChain.init();
        PolystyreneChain.init();
        PolytetrafluoroethyleneChain.init();
        PolyurethaneChain.init();
        PolyvinylChain.init();
        RayonChain.init();
        RubberChain.init();

        CoalPyrolysisChain.init();
        ExplosivesChain.init();
        Extractants.init();
        PhthalateDerivatives.init();
        WoodPyrolysisChain.init();

        AirDistillation.init();
        ChemistryOverhaul.init();
        DeuteriumChain.init();
        Dyes.init();
        ElectrolysisOverhaul.init();
        GemChain.init();
        MagneticIronRodChain.init();
        Magnets.init();
        OreSorting.init();
        PaperChain.init();
        Quenching.init();
        StainlessSteelChain.init();
        WaterPurificationChain.init();

        Batteries.init();
        EletronicCircuits.init();
        EtchablesChain.init();
        FieldGenerators.init();
        IntegratedCircuit.init();
        Photomasks.init();
        ProcessorCircuits.init();
        SMDComponents.init();
        Superconductors.init();
        VacuumComponents.init();

        Smelting.init();
        StartingAge.init();

        BrickChain.init();
        CementChain.init();
        GraphiteElectrodeChain.init();
        PollutionChain.init();
        Thermodynamics.init();

        Mining.init();

        // ModHandler.addShapelessRecipe("convert_old_slaked_lime", OreDictUnifier.get(dust, CalciumHydroxide), OreDictUnifier.get(dust, Quicklime));

//        SuSyMetaTileEntityLoader.init();
//        FridgeRecipes.init();
//        CoagulationRecipes.init();
//        VulcanizationRecipes.init();
//        SusyOreRecipeHandler.init();
//        SuSyMaterialRecipeHandler.init();
//        registerStoneRecipes();

        // make more loaders to categorize recipes and what is added

        //RES Example Recipe

        /*
        TagCompound tag = new TagCompound();

        tag.setString("defID", "rolling_stock/locomotives/k4_pacific.json");
        tag.setFloat("gauge", (float) Gauges.STANDARD);

        cam72cam.mod.item.ItemStack is = new cam72cam.mod.item.ItemStack(IRItems.ITEM_ROLLING_STOCK, 1);
        is.setTagCompound(tag);
        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
                .input(plate, Materials.Steel)
                .input(plate, Materials.Iron)
                .outputs(is.internal)
                .EUt(GTValues.VA[4])
                .duration(1000)
                .buildAndRegister();

        SuSyRecipeMaps.RAILROAD_ENGINEERING_STATION_RECIPES.recipeBuilder()
                .inputNBT(IRItems.ITEM_ROLLING_STOCK.internal, NBTMatcher.EQUAL_TO, NBTCondition.create(NBTTagType.STRING, "defID", "rolling_stock/locomotives/black_mesa_tram.json"))
                .outputs(is.internal)
                .EUt(GTValues.VA[4])
                .duration(4000)
                .buildAndRegister();


        SuSyRecipeMaps.DRONE_PAD.recipeBuilder()
                .input(ingot, Materials.Iron)
                .output(Items.BEEF, 16)
                .duration(10)
                .dimension(0)
                .EUt(2)
                .buildAndRegister();
        */
    }

    private static void registerStoneRecipes(){
        EnumMap<SusyStoneVariantBlock.StoneVariant, List<ItemStack>> susyVariantListMap = new EnumMap<>(SusyStoneVariantBlock.StoneVariant.class);
        for (SusyStoneVariantBlock.StoneVariant shape : SusyStoneVariantBlock.StoneVariant.values()) {
            SusyStoneVariantBlock block = SuSyBlocks.SUSY_STONE_BLOCKS.get(shape);
            susyVariantListMap.put(shape,
                    Arrays.stream(SusyStoneVariantBlock.StoneType.values())
                            .map(block::getItemVariant)
                            .collect(Collectors.toList()));
        }
        List<ItemStack> susycobbles = susyVariantListMap.get(SusyStoneVariantBlock.StoneVariant.COBBLE);
        List<ItemStack> susysmooths = susyVariantListMap.get(SusyStoneVariantBlock.StoneVariant.SMOOTH);

        EnumMap<StoneVariantBlock.StoneVariant, List<ItemStack>> variantListMap = new EnumMap<>(StoneVariantBlock.StoneVariant.class);
        for (StoneVariantBlock.StoneVariant shape : StoneVariantBlock.StoneVariant.values()) {
            StoneVariantBlock block = MetaBlocks.STONE_BLOCKS.get(shape);
            variantListMap.put(shape,
                    Arrays.stream(StoneVariantBlock.StoneType.values())
                            .map(block::getItemVariant)
                            .collect(Collectors.toList()));
        }

        List<ItemStack> cobbles = variantListMap.get(StoneVariantBlock.StoneVariant.COBBLE);
        List<ItemStack> smooths = variantListMap.get(StoneVariantBlock.StoneVariant.SMOOTH);

        registerSmoothRecipe(susycobbles, susysmooths);
        registerCobbleRecipe(susysmooths, susycobbles);
        registerCobbleSmashingRecipe(susysmooths, susycobbles);
        registerCobbleSmashingRecipe(smooths, cobbles);
        registerMacerationToStoneDustRecipe();
    }

    private static void registerCobbleRecipe(List<ItemStack> smoothStack, List<ItemStack> cobbleStack) {
        for (int i = 0; i < smoothStack.size(); i++) {
            FORGE_HAMMER_RECIPES.recipeBuilder()
                    .inputs(smoothStack.get(i))
                    .outputs(cobbleStack.get(i))
                    .duration(12).EUt(4).buildAndRegister();
        }
    }

    private static void registerSmoothRecipe(List<ItemStack> roughStack, List<ItemStack> smoothStack) {
        for (int i = 0; i < roughStack.size(); i++) {
            ModHandler.addSmeltingRecipe(roughStack.get(i), smoothStack.get(i), 0.1f);

            EXTRUDER_RECIPES.recipeBuilder()
                    .inputs(roughStack.get(i))
                    .notConsumable(SHAPE_EXTRUDER_BLOCK.getStackForm())
                    .outputs(smoothStack.get(i))
                    .duration(24).EUt(8).buildAndRegister();
        }
    }


    private static void registerCobbleSmashingRecipe(List<ItemStack> smoothStack, List<ItemStack> cobbleStack) {
        for (int i = 0; i < smoothStack.size(); i++) {

            ModHandler.addShapedRecipe(smoothStack.get(i).getDisplayName() + "_hammer_smashing", cobbleStack.get(i), new Object[]{"hS", 'S', smoothStack.get(i)});
        }
    }

    private static void registerMacerationToStoneDustRecipe() {
        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Gabbro)
                .output(dust, SusyMaterials.Gabbro)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Gneiss)
                .output(dust, SusyMaterials.Gneiss)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Limestone)
                .output(dust, SusyMaterials.Limestone)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Phyllite)
                .output(dust, SusyMaterials.Phyllite)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, Materials.Quartzite)
                .output(dust, Materials.Quartzite)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Shale)
                .output(dust, SusyMaterials.Shale)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Slate)
                .output(dust, SusyMaterials.Slate)
                .buildAndRegister();

        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, Materials.Soapstone)
                .output(dust, Materials.Soapstone)
                .buildAndRegister();


        MACERATOR_RECIPES.recipeBuilder()
                .input(stone, SusyMaterials.Kimberlite)
                .output(dust, SusyMaterials.Kimberlite)
                .buildAndRegister();

    }
}
