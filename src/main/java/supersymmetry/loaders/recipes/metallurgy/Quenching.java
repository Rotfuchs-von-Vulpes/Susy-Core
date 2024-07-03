package supersymmetry.loaders.recipes.metallurgy;

import gregicality.multiblocks.api.fluids.GCYMFluidStorageKeys;
import gregtech.api.fluids.store.FluidStorageKey;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static gregicality.multiblocks.api.unification.GCYMMaterials.*;
import static gregtech.api.recipes.GTRecipeHandler.removeRecipesByInputs;
import static gregtech.api.recipes.RecipeMaps.CHEMICAL_BATH_RECIPES;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.ingot;
import static gregtech.api.unification.ore.OrePrefix.ingotHot;
import static gregtech.common.items.MetaItems.SHAPE_MOLD_INGOT;
import static supersymmetry.api.recipes.SuSyRecipeMaps.*;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Quenching {
    private static class QuenchingFluid {

        public FluidStack hot_fluid;
        public FluidStack cold_fluid;
        public int time;
        public boolean inert;

        public QuenchingFluid(FluidStack ColdFluid2, FluidStack HotFluid2, int time, boolean inert){
            this.cold_fluid = ColdFluid2;
            this.hot_fluid = HotFluid2;
            this.time = time;
            this.inert = inert;
        }

        public FluidStack getColdFluid(){
            return this.cold_fluid;
        }

        public FluidStack getHotFluid(){
            return this.hot_fluid;
        }

        public int getDuration(){
            return this.time;
        }

        public boolean isInert(){
            return this.inert;
        }
    }
    public static void init() {
        QuenchingFluid[] quenchingFluids = {
                new QuenchingFluid(Water.getFluid(1000), WarmWater.getFluid(1000), 100, false),
                new QuenchingFluid(Air.getFluid(10000), HotAir.getFluid(10000), 500, false),
                new QuenchingFluid(HighPressureAir.getFluid(5000), HotHighPressureAir.getFluid(5000), 500, false),
                new QuenchingFluid(Nitrogen.getFluid(10000), HotNitrogen.getFluid(10000), 500, true),
                new QuenchingFluid(HighPressureNitrogen.getFluid(5000), HotHighPressureNitrogen.getFluid(5000), 500, true),
                new QuenchingFluid(SaltWater.getFluid(1000), WarmSaltWater.getFluid(1000), 150, false),
                new QuenchingFluid(Brine.getFluid(1000), WarmBrine.getFluid(1000), 150, false),
        };

        Map<Material, Integer> ingotMap = new HashMap<>();

        ingotMap.put(Europium, 6000);
        ingotMap.put(Iridium, 4500);
        ingotMap.put(Molybdenum, 2890);
        ingotMap.put(Niobium, 2750);
        ingotMap.put(Osmium, 4500);
        ingotMap.put(Palladium, 1828);
        ingotMap.put(Platinum, 2045);
        ingotMap.put(Rhodium, 2237);
        ingotMap.put(Ruthenium, 2607);
        ingotMap.put(Samarium, 5400);
        ingotMap.put(Tantalum, 3293);
        ingotMap.put(Thorium, 2028);
        ingotMap.put(Titanium, 2141);
        ingotMap.put(Tungsten, 3600);
        ingotMap.put(Vanadium, 2183);
        ingotMap.put(Yttrium, 1799);
        ingotMap.put(Naquadah, 5000);
        ingotMap.put(NaquadahEnriched, 7000);
        ingotMap.put(Naquadria, 9000);
        ingotMap.put(Trinium, 7200);
        ingotMap.put(Kanthal, 1800);
        ingotMap.put(Nichrome, 2700);
        ingotMap.put(NiobiumNitride, 2846);
        ingotMap.put(NiobiumTitanium, 4500);
        ingotMap.put(BlackBronze, 2000);
        ingotMap.put(Ruridit, 4500);
        ingotMap.put(Ultimet, 2700);
        ingotMap.put(VanadiumGallium, 4500);
        ingotMap.put(YttriumBariumCuprate, 4500);
        ingotMap.put(Osmiridium, 4500);
        ingotMap.put(TungstenCarbide, 3068);
        ingotMap.put(MagnesiumDiboride, 2500);
        ingotMap.put(MercuryBariumCalciumCuprate, 3300);
        ingotMap.put(UraniumTriplatinum, 4400);
        ingotMap.put(SamariumIronArsenicOxide, 5200);
        ingotMap.put(IndiumTinBariumTitaniumCuprate, 6000);
        ingotMap.put(UraniumRhodiumDinaquadide, 9000);
        ingotMap.put(EnrichedNaquadahTriniumEuropiumDuranide, 9900);
        ingotMap.put(RutheniumTriniumAmericiumNeutronate, 10800);
        ingotMap.put(TungstenSteel, 3000);
        ingotMap.put(RTMAlloy,  3200);
        ingotMap.put(NaquadahAlloy, 7200);
        ingotMap.put(RhodiumPlatedPalladium, 4500);
        ingotMap.put(HSSG, 4200);
        ingotMap.put(HSSE, 5000);
        ingotMap.put(HSSS, 5000);
        ingotMap.put(Stellite100, 3790);
        ingotMap.put(WatertightSteel, 3850);
        ingotMap.put(MaragingSteel300, 4000);
        ingotMap.put(HastelloyC276, 4625);
        ingotMap.put(HastelloyX, 4200);
        ingotMap.put(Trinaquadalloy, 8747);
        ingotMap.put(Zeron100, 3693);
        ingotMap.put(TitaniumCarbide, 3430);
        ingotMap.put(TantalumCarbide, 4120);
        ingotMap.put(MolybdenumDisilicide, 2300);
        ingotMap.put(TitaniumTungstenCarbide, 3800);
        ingotMap.put(IncoloyMA956, 3625);

        Material[] fluidList = {
                Kanthal,
                Nichrome,
                NiobiumNitride,
                NiobiumTitanium,
                BlackBronze,
                Ruridit,
                Ultimet,
                VanadiumGallium,
                YttriumBariumCuprate,
                Osmiridium,
                TungstenCarbide,
                MagnesiumDiboride,
                MercuryBariumCalciumCuprate,
                UraniumTriplatinum,
                SamariumIronArsenicOxide,
                IndiumTinBariumTitaniumCuprate,
                UraniumRhodiumDinaquadide,
                EnrichedNaquadahTriniumEuropiumDuranide,
                RutheniumTriniumAmericiumNeutronate,
                TungstenSteel,
                NaquadahAlloy,
                RhodiumPlatedPalladium,
                HSSG,
                HSSE,
                HSSS,
                Stellite100,
                WatertightSteel,
                MaragingSteel300,
                HastelloyC276,
                HastelloyX,
                Trinaquadalloy,
                Zeron100,
                TitaniumCarbide,
                TantalumCarbide,
                MolybdenumDisilicide,
                TitaniumTungstenCarbide,
                IncoloyMA956
        };

//MV Tweaks (from CEu #1724)

// Kanthal Ingot * 1
        removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(ingotHot, Kanthal)}, new FluidStack[]{Water.getFluid(100)});
// Kanthal Ingot * 1
        removeRecipesByInputs(CHEMICAL_BATH_RECIPES, new ItemStack[]{OreDictUnifier.get(ingotHot, Kanthal)}, new FluidStack[]{DistilledWater.getFluid(100)});

        for (QuenchingFluid fluid : quenchingFluids) {
           CHEMICAL_BATH_RECIPES.recipeBuilder()
                    .input(ingotHot, Kanthal)
                    .fluidInputs(fluid.getColdFluid())
                    .output(ingot, Kanthal)
                    .fluidOutputs(fluid.getHotFluid())
                    .duration(fluid.getDuration() * 4)
                    .EUt(120)
                    .buildAndRegister();
        }

        ingotMap.forEach((Material material, Integer temp) -> {
            for (QuenchingFluid fluid : quenchingFluids) {
                QUENCHER_RECIPES.recipeBuilder()
                        .input(ingotHot, material)
                        .fluidInputs(fluid.getColdFluid())
                        .output(ingot, material)
                        .fluidOutputs(fluid.getHotFluid())
                        .duration(fluid.getDuration() * temp / 2000)
                        .EUt(120)
                        .buildAndRegister();
            }
        });

        for (Material material : fluidList) {
            for (QuenchingFluid fluid : quenchingFluids) {
                QUENCHER_RECIPES.recipeBuilder()
                        .notConsumable(SHAPE_MOLD_INGOT)
                        .fluidInputs(material.getFluid(GCYMFluidStorageKeys.MOLTEN, 144))
                        .fluidInputs(fluid.getColdFluid())
                        .output(ingot, material)
                        .fluidOutputs(fluid.getHotFluid())
                        .duration(fluid.getDuration() * 2)
                        .EUt(120)
                        .buildAndRegister();
            }
        }

// Air cooling
        HEAT_RADIATOR_RECIPES.recipeBuilder()
                .fluidInputs(HotAir.getFluid(1000))
                .fluidOutputs(Air.getFluid(1000))
                .duration(100)
                .buildAndRegister();

        COOLING_UNIT_RECIPES.recipeBuilder()
                .fluidInputs(HotAir.getFluid(1000))
                .fluidOutputs(Air.getFluid(1000))
                .duration(50)
                .EUt(480)
                .buildAndRegister();
    }
}
