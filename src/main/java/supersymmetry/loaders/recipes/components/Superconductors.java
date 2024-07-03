package supersymmetry.loaders.recipes.components;

import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.INTEGRATED_CIRCUIT;
import static gregtech.common.items.MetaItems.SHAPE_EXTRUDER_WIRE;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.item.SuSyMetaItems.*;
import static supersymmetry.common.materials.SusyMaterials.*;
import static supersymmetry.loaders.recipes.Utils.getConfiguration;

public class Superconductors {
    private static class Superconductor {
        public Material mat;
        public MetaValueItem base;
        public MetaValueItem assembly;
        public MetaValueItem canned;
        public MetaValueItem tube;
        public int criticalTemp;
        public Superconductor(Material mat, MetaValueItem base, MetaValueItem assembly, MetaValueItem canned, MetaValueItem tube, int criticalTemp) {
            this.mat = mat;
            this.base = base;
            this.assembly = assembly;
            this.canned = canned;
            this.tube = tube;
            this.criticalTemp = criticalTemp;
        }
    }
    public static void init() {
        NBTTagCompound nbt = new NBTTagCompound();
        ItemStack integratedCircuit = INTEGRATED_CIRCUIT.getStackForm();

        String[] recipesToRemove = {
                "gregtech:manganese_phosphide_wire_single",
                "gregtech:uranium_triplatinum_wire_single",
                "gregtech:indium_tin_barium_titanium_cuprate_wire_single",
                "gregtech:uranium_rhodium_dinaquadide_wire_single",
                "gregtech:enriched_naquadah_trinium_europium_duranide_wire_single",
                "gregtech:ruthenium_trinium_americium_neutronate_wire_single"
        };

        for(String name : recipesToRemove) {
            ModHandler.removeRecipeByName(name);
        }

// Mercury Barium Calcium Cuprate Dust * 16
        nbt.setInteger("Configuration", 4);
        integratedCircuit.setTagCompound(nbt);
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Barium, 2), OreDictUnifier.get(dust, Calcium, 2), OreDictUnifier.get(dust, Copper, 3), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(8000), Mercury.getFluid(1000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Barium, 2), OreDictUnifier.get(dust, Calcium, 2), OreDictUnifier.get(dust, Copper, 3), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(8000), Mercury.getFluid(1000)});
// Samarium Iron Arsenic Oxide Dust * 4
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Samarium), OreDictUnifier.get(dust, Iron), OreDictUnifier.get(dust, Arsenic), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(1000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Samarium), OreDictUnifier.get(dust, Iron), OreDictUnifier.get(dust, Arsenic), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(1000)});
// Indium Tin Barium Titanium Cuprate Dust * 16
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Indium, 4), OreDictUnifier.get(dust, Tin, 2), OreDictUnifier.get(dust, Barium, 2), OreDictUnifier.get(dust, Titanium), OreDictUnifier.get(dust, Copper, 7), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(14000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Indium, 4), OreDictUnifier.get(dust, Tin, 2), OreDictUnifier.get(dust, Barium, 2), OreDictUnifier.get(dust, Titanium), OreDictUnifier.get(dust, Copper, 7), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(14000)});
// Yttrium Barium Cuprate Dust * 13
        nbt.setInteger("Configuration", 2);
        integratedCircuit.setTagCompound(nbt);
        removeRecipesByInputs(MIXER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Yttrium), OreDictUnifier.get(dust, Barium, 2), OreDictUnifier.get(dust, Copper, 3), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(7000)});
        removeRecipesByInputs(BLENDER_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, Yttrium), OreDictUnifier.get(dust, Barium, 2), OreDictUnifier.get(dust, Copper, 3), integratedCircuit}, new FluidStack[]{Oxygen.getFluid(7000)});

// Hot Mercury Barium Calcium Cuprate Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, MercuryBariumCalciumCuprate), integratedCircuit}, new FluidStack[]{Nitrogen.getFluid(1000)});
// Hot Samarium Iron Arsenic Oxide Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, SamariumIronArsenicOxide), integratedCircuit}, new FluidStack[]{Helium.getFluid(100)});
// Hot Magnesium Diboride Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, new ItemStack[]{OreDictUnifier.get(dust, MagnesiumDiboride), integratedCircuit}, new FluidStack[]{Nitrogen.getFluid(1000)});

        nbt.setInteger("Configuration", 1);
        integratedCircuit.setTagCompound(nbt);
// Hot Mercury Barium Calcium Cuprate Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, MercuryBariumCalciumCuprate), integratedCircuit);
// Hot Samarium Iron Arsenic Oxide Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, SamariumIronArsenicOxide), integratedCircuit);
// Hot Magnesium Diboride Ingot * 1
        removeRecipesByInputs(BLAST_RECIPES, OreDictUnifier.get(dust, MagnesiumDiboride), integratedCircuit);

        Superconductor[] allSuperconductors = {
                new Superconductor(ManganesePhosphide, BASEMANGANESEPHOSPHIDE, ASSEMBLYMANGANESEPHOSPHIDE, null, null, 100),
                new Superconductor(MagnesiumDiboride, BASEMAGNESIUMDIBORIDE, null, CANNEDMAGNESIUMDIBORIDE, TUBEMAGNESIUMDIBORIDE, 80),
                new Superconductor(MercuryBariumCalciumCuprate, BASEMERCURYBARIUMCALCIUMCUPRATE, null, CANNEDMERCURYBARIUMCALCIUMCUPRATE, TUBEMERCURYBARIUMCALCIUMCUPRATE, 50),
                new Superconductor(UraniumTriplatinum, BASEURANIUMTRIPLATINUM, ASSEMBLYURANIUMTRIPLATINUM, null, null, 5),
                new Superconductor(SamariumIronArsenicOxide, BASESAMARIUMIRONARSENICOXIDE, null, CANNEDSAMARIUMIRONARSENICOXIDE, TUBESAMARIUMIRONARSENICOXIDE, 5),
                new Superconductor(IndiumTinBariumTitaniumCuprate, BASEINDIUMTINBARIUMTITANIUMCUPRATE, ASSEMBLYINDIUMTINBARIUMTITANIUMCUPRATE, null, null, 5),
                new Superconductor(UraniumRhodiumDinaquadide, BASEURANIUMRHODIUMDINAQUADIDE, ASSEMBLYURANIUMRHODIUMDINAQUADIDE, null, null, 5),
                new Superconductor(EnrichedNaquadahTriniumEuropiumDuranide, BASEENRICHEDNAQUADAHTRINIUMEUROPIUMDURANIDE, ASSEMBLYENRICHEDNAQUADAHTRINIUMEUROPIUMDURANIDE, null, null, 5),
                new Superconductor(RutheniumTriniumAmericiumNeutronate, BASERUTHENIUMTRINIUMAMERICIUMNEUTRONATE, ASSEMBLYRUTHENIUMTRINIUMAMERICIUMNEUTRONATE, null, null, 5)
        };
        Superconductor[] lowTempSuperconductors = {
                allSuperconductors[0],
                allSuperconductors[3],
                allSuperconductors[5],
                allSuperconductors[6],
                allSuperconductors[7],
                allSuperconductors[8],
        };
        Superconductor[] highTempSuperconductors = {
                allSuperconductors[1],
                allSuperconductors[2],
                allSuperconductors[4]
        };

        int[] criticalTemperatures = {100, 80, 50, 5, 5, 5, 5, 5, 5};

        nbt.setInteger("Configuration", 1);
        integratedCircuit.setTagCompound(nbt);
        for (Superconductor superconductor : lowTempSuperconductors) {
            removeRecipesByInputs(WIREMILL_RECIPES, OreDictUnifier.get(wireGtSingle, superconductor.mat), integratedCircuit);

            ASSEMBLER_RECIPES.recipeBuilder()
                    .input(wireGtSingle, Copper)
                    .input(wireFine, superconductor.mat, 8)
                    .input(foil, Copper)
                    .output(superconductor.assembly)
                    .duration(200)
                    .EUt(30)
                    .buildAndRegister();

            EXTRUDER_RECIPES.recipeBuilder()
                    .input(superconductor.assembly)
                    .notConsumable(SHAPE_EXTRUDER_WIRE)
                    .output(superconductor.base, 16)
                    .duration(200)
                    .EUt(30)
                    .buildAndRegister();
        }

//All the arc furnace ones need to be done by hand

// Manganese Phosphide Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, ManganesePhosphide)}, new FluidStack[]{Oxygen.getFluid(18)});
// Magnesium Diboride Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, MagnesiumDiboride)}, new FluidStack[]{Oxygen.getFluid(6)});
// Mercury Barium Calcium Cuprate Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, MercuryBariumCalciumCuprate)}, new FluidStack[]{Oxygen.getFluid(24)});
// Uranium Triplatinum Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, UraniumTriplatinum)}, new FluidStack[]{Oxygen.getFluid(91)});
// Samarium Iron Arsenic Oxide Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, SamariumIronArsenicOxide)}, new FluidStack[]{Oxygen.getFluid(32)});
// Indium Tin Barium Titanium Cuprate Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, IndiumTinBariumTitaniumCuprate)}, new FluidStack[]{Oxygen.getFluid(24)});
// Uranium Rhodium Dinaquadide Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, UraniumRhodiumDinaquadide)}, new FluidStack[]{Oxygen.getFluid(154)});
// Enriched Naquadah Trinium Europium Duranide Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide)}, new FluidStack[]{Oxygen.getFluid(163)});
// Ruthenium Trinium Americium Neutronate Nugget * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtSingle, RutheniumTriniumAmericiumNeutronate)}, new FluidStack[]{Oxygen.getFluid(98)});

// Manganese Phosphide Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, ManganesePhosphide)}, new FluidStack[]{Oxygen.getFluid(42)});
// Magnesium Diboride Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, MagnesiumDiboride)}, new FluidStack[]{Oxygen.getFluid(14)});
// Mercury Barium Calcium Cuprate Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, MercuryBariumCalciumCuprate)}, new FluidStack[]{Oxygen.getFluid(54)});
// Uranium Triplatinum Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, UraniumTriplatinum)}, new FluidStack[]{Oxygen.getFluid(205)});
// Samarium Iron Arsenic Oxide Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, SamariumIronArsenicOxide)}, new FluidStack[]{Oxygen.getFluid(74)});
// Indium Tin Barium Titanium Cuprate Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, IndiumTinBariumTitaniumCuprate)}, new FluidStack[]{Oxygen.getFluid(55)});
// Uranium Rhodium Dinaquadide Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, UraniumRhodiumDinaquadide)}, new FluidStack[]{Oxygen.getFluid(1348)});
// Enriched Naquadah Trinium Europium Duranide Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, EnrichedNaquadahTriniumEuropiumDuranide)}, new FluidStack[]{Oxygen.getFluid(1368)});
// Ruthenium Trinium Americium Neutronate Ingot * 1
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtDouble, RutheniumTriniumAmericiumNeutronate)}, new FluidStack[]{Oxygen.getFluid(222)});

// Manganese Phosphide Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, ManganesePhosphide)}, new FluidStack[]{Oxygen.getFluid(84)});
// Magnesium Diboride Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, MagnesiumDiboride)}, new FluidStack[]{Oxygen.getFluid(28)});
// Mercury Barium Calcium Cuprate Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, MercuryBariumCalciumCuprate)}, new FluidStack[]{Oxygen.getFluid(108)});
// Uranium Triplatinum Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, UraniumTriplatinum)}, new FluidStack[]{Oxygen.getFluid(410)});
// Samarium Iron Arsenic Oxide Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, SamariumIronArsenicOxide)}, new FluidStack[]{Oxygen.getFluid(148)});
// Indium Tin Barium Titanium Cuprate Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, IndiumTinBariumTitaniumCuprate)}, new FluidStack[]{Oxygen.getFluid(110)});
// Uranium Rhodium Dinaquadide Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, UraniumRhodiumDinaquadide)}, new FluidStack[]{Oxygen.getFluid(696)});
// Enriched Naquadah Trinium Europium Duranide Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, EnrichedNaquadahTriniumEuropiumDuranide)}, new FluidStack[]{Oxygen.getFluid(736)});
// Ruthenium Trinium Americium Neutronate Ingot * 2
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtQuadruple, RutheniumTriniumAmericiumNeutronate)}, new FluidStack[]{Oxygen.getFluid(444)});

// Manganese Phosphide Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, ManganesePhosphide)}, new FluidStack[]{Oxygen.getFluid(168)});
// Magnesium Diboride Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, MagnesiumDiboride)}, new FluidStack[]{Oxygen.getFluid(56)});
// Mercury Barium Calcium Cuprate Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, MercuryBariumCalciumCuprate)}, new FluidStack[]{Oxygen.getFluid(216)});
// Uranium Triplatinum Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, UraniumTriplatinum)}, new FluidStack[]{Oxygen.getFluid(820)});
// Samarium Iron Arsenic Oxide Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, SamariumIronArsenicOxide)}, new FluidStack[]{Oxygen.getFluid(296)});
// Indium Tin Barium Titanium Cuprate Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, IndiumTinBariumTitaniumCuprate)}, new FluidStack[]{Oxygen.getFluid(220)});
// Uranium Rhodium Dinaquadide Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, UraniumRhodiumDinaquadide)}, new FluidStack[]{Oxygen.getFluid(1392)});
// Enriched Naquadah Trinium Europium Duranide Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, EnrichedNaquadahTriniumEuropiumDuranide)}, new FluidStack[]{Oxygen.getFluid(1472)});
// Ruthenium Trinium Americium Neutronate Ingot * 4
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtOctal, RutheniumTriniumAmericiumNeutronate)}, new FluidStack[]{Oxygen.getFluid(888)});

// Manganese Phosphide Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, ManganesePhosphide)}, new FluidStack[]{Oxygen.getFluid(336)});
// Magnesium Diboride Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, MagnesiumDiboride)}, new FluidStack[]{Oxygen.getFluid(112)});
// Mercury Barium Calcium Cuprate Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, MercuryBariumCalciumCuprate)}, new FluidStack[]{Oxygen.getFluid(432)});
// Uranium Triplatinum Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, UraniumTriplatinum)}, new FluidStack[]{Oxygen.getFluid(1640)});
// Samarium Iron Arsenic Oxide Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, SamariumIronArsenicOxide)}, new FluidStack[]{Oxygen.getFluid(592)});
// Indium Tin Barium Titanium Cuprate Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, IndiumTinBariumTitaniumCuprate)}, new FluidStack[]{Oxygen.getFluid(440)});
// Uranium Rhodium Dinaquadide Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, UraniumRhodiumDinaquadide)}, new FluidStack[]{Oxygen.getFluid(2784)});
// Enriched Naquadah Trinium Europium Duranide Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, EnrichedNaquadahTriniumEuropiumDuranide)}, new FluidStack[]{Oxygen.getFluid(2944)});
// Ruthenium Trinium Americium Neutronate Ingot * 8
        removeRecipesByInputs(ARC_FURNACE_RECIPES, new ItemStack[]{OreDictUnifier.get(wireGtHex, RutheniumTriniumAmericiumNeutronate)}, new FluidStack[]{Oxygen.getFluid(1776)});


        for (Superconductor supercon : allSuperconductors) {
            // Supercon maceration
            removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(wireGtSingle, supercon.mat));
            removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(wireGtDouble, supercon.mat));
            removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(wireGtQuadruple, supercon.mat));
            removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(wireGtOctal, supercon.mat));
            removeRecipesByInputs(MACERATOR_RECIPES, OreDictUnifier.get(wireGtHex, supercon.mat));
            // Supercon extraction
            removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(wireGtSingle, supercon.mat));
            removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(wireGtDouble, supercon.mat));
            removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(wireGtQuadruple, supercon.mat));
            removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(wireGtOctal, supercon.mat));
            removeRecipesByInputs(EXTRACTOR_RECIPES, OreDictUnifier.get(wireGtHex, supercon.mat));
        }

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(CANNEDMAGNESIUMDIBORIDE)
                .fluidInputs(Nitrogen.getFluid(500))
                .output(TUBEMAGNESIUMDIBORIDE)
                .duration(1006)
                .EUt(120)
                .buildAndRegister();

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(CANNEDMAGNESIUMDIBORIDE)
                .fluidInputs(Argon.getFluid(50))
                .output(TUBEMAGNESIUMDIBORIDE)
                .duration(670)
                .EUt(120)
                .buildAndRegister();

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(CANNEDMERCURYBARIUMCALCIUMCUPRATE)
                .fluidInputs(Nitrogen.getFluid(500))
                .output(TUBEMERCURYBARIUMCALCIUMCUPRATE)
                .duration(1500)
                .EUt(480)
                .buildAndRegister();

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(CANNEDMERCURYBARIUMCALCIUMCUPRATE)
                .fluidInputs(Argon.getFluid(50))
                .output(TUBEMERCURYBARIUMCALCIUMCUPRATE)
                .duration(1005)
                .EUt(480)
                .buildAndRegister();

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(CANNEDSAMARIUMIRONARSENICOXIDE)
                .fluidInputs(Argon.getFluid(50))
                .output(TUBESAMARIUMIRONARSENICOXIDE)
                .duration(1005)
                .EUt(3840)
                .buildAndRegister();

        for (Superconductor supercon : highTempSuperconductors) {
            CANNER_RECIPES.recipeBuilder()
                    .input(pipeTinyFluid, Silver)
                    .input(dust, supercon.mat)
                    .output(supercon.canned)
                    .duration(200)
                    .EUt(30)
                    .buildAndRegister();

            EXTRUDER_RECIPES.recipeBuilder()
                    .input(supercon.tube)
                    .notConsumable(SHAPE_EXTRUDER_WIRE)
                    .output(supercon.base, 16)
                    .duration(200)
                    .EUt(30)
                    .buildAndRegister();
        }

        {
            int[] voltAmps = {7, 30, 120, 480, 1920, 7680, 30720, 122880, 491520, 1966080, 7864320, 31457280, 125829120, 503316480, 2013265920};
            int i = 0;
            Map<FluidStack, Integer> cryoLiquids = new HashMap<>();
            cryoLiquids.put(LiquidHydrogen.getFluid(1), 14);
            cryoLiquids.put(Oxygen.getFluid(FluidStorageKeys.LIQUID, 1), 90);
            cryoLiquids.put(Helium.getFluid(FluidStorageKeys.LIQUID, 1), 4);
            cryoLiquids.put(LiquidNeon.getFluid(1), 27);
            cryoLiquids.put(LiquidArgon.getFluid(1), 87);
            cryoLiquids.put(LiquidKrypton.getFluid(1), 120);
            cryoLiquids.put(LiquidXenon.getFluid(1), 165);
            cryoLiquids.put(LiquidNitrogen.getFluid(1), 77);
            cryoLiquids.put(LiquidRefineryGas.getFluid(1), 80);
            cryoLiquids.put(LiquidNaturalGas.getFluid(1), 80);
            for (Superconductor supercon : allSuperconductors) {
                i++;
                //REMOVE AUTOGENERATED GT RECIPES FOR SUPERCONDUCTORS
                removeRecipesByInputs(EXTRUDER_RECIPES, OreDictUnifier.get(ingot, supercon.mat), SHAPE_EXTRUDER_WIRE.getStackForm());
                removeRecipesByInputs(WIREMILL_RECIPES, OreDictUnifier.get(ingot, supercon.mat), getConfiguration(1));
                removeRecipesByInputs(WIREMILL_RECIPES, OreDictUnifier.get(ingot, supercon.mat), getConfiguration(2));
                removeRecipesByInputs(WIREMILL_RECIPES, OreDictUnifier.get(ingot, supercon.mat, 2), getConfiguration(4));
                removeRecipesByInputs(WIREMILL_RECIPES, OreDictUnifier.get(ingot, supercon.mat, 4), getConfiguration(8));
                removeRecipesByInputs(WIREMILL_RECIPES, OreDictUnifier.get(ingot, supercon.mat, 6), getConfiguration(16));

                int finalI = i;
                cryoLiquids.forEach((FluidStack fluid, Integer temp) -> {
                    if (supercon.criticalTemp > temp) {
                        CHEMICAL_BATH_RECIPES.recipeBuilder()
                                .input(supercon.base)
                                .fluidInputs(fluid)
                                .output(wireGtSingle, supercon.mat)
                                .duration(50)
                                .EUt(voltAmps[finalI])
                                .buildAndRegister();
                    }
                });
            }
        }

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Barium, 1)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, BariumOxide, 2)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .fluidInputs(Mercury.getFluid(1000))
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, MercuryOxide, 2)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, MercuryOxide, 2)
                .input(dust, Quicklime, 4)
                .input(dust, BariumOxide, 4)
                .input(dust, CupricOxide, 6)
                .output(dust, MercuryBariumCalciumCuprate, 16)
                .duration(300)
                .EUt(240)
                .buildAndRegister();

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Samarium)
                .input(dust, Arsenic)
                .input(dust, Iron)
                .fluidInputs(Oxygen.getFluid(1000))
                .output(dust, SamariumIronArsenicOxide, 4)
                .duration(600)
                .EUt(1920)
                .buildAndRegister();

        TUBE_FURNACE_RECIPES.recipeBuilder()
                .input(dust, Manganese)
                .input(dust, Phosphorus)
                .fluidInputs(Nitrogen.getFluid(1000))
                .output(dust, ManganesePhosphide, 4)
                .duration(200)
                .EUt(30)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, YttriumOxide, 5)
                .input(dust, BariumOxide, 8)
                .input(dust, CupricOxide, 12)
                .output(dust, YttriumBariumCuprate, 25)
                .duration(600)
                .EUt(7680)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, Indium, 1)
                .fluidInputs(Chlorine.getFluid(3000))
                .output(dust, IndiumChloride, 4)
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        BATCH_REACTOR_RECIPES.recipeBuilder()
                .input(dust, IndiumChloride, 4)
                .fluidInputs(SodiumHydroxideSolution.getFluid(3000))
                .output(dust, IndiumHydroxide, 7)
                .fluidOutputs(SaltWater.getFluid(3000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        ROASTER_RECIPES.recipeBuilder()
                .input(dust, IndiumHydroxide, 14)
                .output(dust, IndiumOxide, 5)
                .fluidOutputs(Steam.getFluid(3000))
                .duration(200)
                .EUt(120)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .input(dust, IndiumOxide, 10)
                .input(dust, PurifiedTinIIOxide, 4)
                .input(dust, BariumOxide, 4)
                .input(dust, TitaniumDioxide, 2)
                .input(dust, CupricOxide, 14)
                .output(dust, IndiumTinBariumTitaniumCuprate, 16)
                .duration(600)
                .EUt(30720)
                .buildAndRegister();
    }
}
