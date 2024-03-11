package supersymmetry.loaders.recipes;

import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.api.unification.ore.OrePrefix.gem;
import static supersymmetry.common.materials.SusyMaterials.*;

public class Utils {
    public static class Carbon {
        public final ItemStack name;
        public final int carbon;
        public Carbon(ItemStack name, int carbon) {
            this.name = name;
            this.carbon = carbon;
        }

        protected int numItemByProvider(int required, int provider) {
            int result = required / provider;
            if (required % provider > 0) {
                result += 1;
            }
            return result;
        }
    }
    public static class CarbonSource extends Carbon {
        public final ItemStack byproduct;
        public final int duration;

        // Return the number of CarbonSource items with summary carbon content
        // equal to carbon content of %required_carbon_items% anthracite items
        public int equivalent(int required_carbon_items) {
            return numItemByProvider(required_carbon_items * 90, carbon);
        }

        public CarbonSource(ItemStack name, int carbon, ItemStack byproduct, int duration) {
            super(name, carbon);
            this.byproduct = byproduct;
            this.duration = duration;
        }
    }
    public static final CarbonSource[] highPurityCombustibles = {
            new CarbonSource(OreDictUnifier.get(dust, HighPurityCarbon), 100, OreDictUnifier.get(dustTiny, Ash), 1),
            new CarbonSource(OreDictUnifier.get(dust, Carbon), 100, OreDictUnifier.get(dustTiny, Ash), 1),
            new CarbonSource(OreDictUnifier.get(dust, Coke), 100, OreDictUnifier.get(dustTiny, Ash), 2),
    };
    public static final CarbonSource[] combustibles = {
            new CarbonSource(OreDictUnifier.get(gem, Coke), 100, OreDictUnifier.get(dustTiny, Ash), 2),
            new CarbonSource(OreDictUnifier.get(gem, Anthracite), 90, OreDictUnifier.get(dustTiny, Ash), 2),
            new CarbonSource(OreDictUnifier.get(dust, Anthracite), 90, OreDictUnifier.get(dustTiny, Ash), 2),
            new CarbonSource(OreDictUnifier.get(gem, LigniteCoke), 75, OreDictUnifier.get(dustTiny, Ash), 3),
            new CarbonSource(OreDictUnifier.get(dust, LigniteCoke), 75, OreDictUnifier.get(dustTiny, Ash), 3),
            new CarbonSource(OreDictUnifier.get(gem, Coal), 75, OreDictUnifier.get(dustTiny, DarkAsh), 4),
            new CarbonSource(OreDictUnifier.get(dust, Coal), 75, OreDictUnifier.get(dustTiny, DarkAsh), 4),
            new CarbonSource(OreDictUnifier.get(gem, Charcoal), 60, OreDictUnifier.get(dustTiny, DarkAsh), 4),
            new CarbonSource(OreDictUnifier.get(dust, Charcoal), 60, OreDictUnifier.get(dustTiny, DarkAsh), 4),
    };
    public static final CarbonSource[] sources = {
            new CarbonSource(OreDictUnifier.get(gem, Coke), 100, OreDictUnifier.get(dustTiny, Ash), 2),
            new CarbonSource(OreDictUnifier.get(gem, Anthracite), 90, OreDictUnifier.get(dustTiny, Ash), 2),
            new CarbonSource(OreDictUnifier.get(dust, Anthracite), 90, OreDictUnifier.get(dustTiny, Ash), 2),
            new CarbonSource(OreDictUnifier.get(gem, LigniteCoke), 75, OreDictUnifier.get(dustTiny, Ash), 3),
            new CarbonSource(OreDictUnifier.get(dust, LigniteCoke), 75, OreDictUnifier.get(dustTiny, Ash), 3),
            new CarbonSource(OreDictUnifier.get(gem, Coal), 75, OreDictUnifier.get(dustTiny, DarkAsh), 4),
            new CarbonSource(OreDictUnifier.get(dust, Coal), 75, OreDictUnifier.get(dustTiny, DarkAsh), 4),
            new CarbonSource(OreDictUnifier.get(gem, Charcoal), 60, OreDictUnifier.get(dustTiny, DarkAsh), 4),
            new CarbonSource(OreDictUnifier.get(dust, Charcoal), 60, OreDictUnifier.get(dustTiny, DarkAsh), 4),
            new CarbonSource(OreDictUnifier.get(gem, Lignite), 25, OreDictUnifier.get(dustTiny, Ash), 0),
            new CarbonSource(OreDictUnifier.get(gem, Lignite), 25, OreDictUnifier.get(dustTiny, Ash), 0),
    };
    public static class Combustible {
        public final FluidStack fluid;
        public final boolean isPlasma;
        public final int duration;
        public final FluidStack byproduct;

        public FluidStack getFluid() {
            return fluid;
        }

        public FluidStack getByproduct() {
            return byproduct;
        }

        public int getDuration() {
            return duration;
        }

        public Combustible(FluidStack fluid, boolean isPlasma, int duration, FluidStack byproduct) {
            this.fluid = fluid;
            this.isPlasma = isPlasma;
            this.duration = duration;
            this.byproduct = byproduct;
        }
    }

    public static class Comburent {
        public final FluidStack fluid;
        public final int duration;

        public FluidStack getFluid() {
            return fluid;
        }

        public int getDuration() {
            return duration;
        }

        Comburent(FluidStack fluid, int duration) {
            this.fluid = fluid;
            this.duration = duration;
        }
    }

    public static class Blanket {
        public FluidStack fluid;
        public int amountRequired;
        public int duration;

        Blanket(FluidStack fluid, int amountRequired, int duration) {
            this.fluid = fluid;
            this.amountRequired = amountRequired;
            this.duration = duration;
        }
    }

    public static Combustible[] sintering_fuels = {
        new Combustible(Methane.getFluid(10), false, 50, CarbonDioxide.getFluid(5)),
        new Combustible(Syngas.getFluid(10), false, 50, CarbonDioxide.getFluid(5)),
        new Combustible(NaturalGas.getFluid(10), false, 50, CarbonDioxide.getFluid(5)),
        new Combustible(RefineryGas.getFluid(10), false, 50, CarbonDioxide.getFluid(5)),
        new Combustible(Helium.getPlasma(10), true, 5, Helium.getFluid(10))
    };

    public static Comburent[] sintering_comburents = {
        new Comburent(Air.getFluid(10), 50),
        new Comburent(Oxygen.getFluid(8), 30)
    };

    public static Blanket[] sintering_blankets = {
        new Blanket(Argon.getFluid(1), 100, 300)
    };

    public static Combustible[] rotary_kiln_fuels = {
        new Combustible(Methane.getFluid(10), false, 50, CarbonDioxide.getFluid(5)),
        new Combustible(NaturalGas.getFluid(10), false, 50, CarbonDioxide.getFluid(5)),
        new Combustible(RefineryGas.getFluid(10), false, 50, CarbonDioxide.getFluid(5)),
        new Combustible(FuelOil.getFluid(4), false, 50, CarbonDioxide.getFluid(25))
    };

    public static Comburent[] rotary_kiln_comburents = {
        new Comburent(Air.getFluid(250), 50),
        new Comburent(Oxygen.getFluid(50), 30)
    };

    public static class InertGas {
        public FluidStack name;
        public int duration;
        InertGas(Material name, int amount_required, int duration) {
            this.name = name.getFluid(amount_required);
            this.duration = duration;
        }
    }

    public static InertGas[] inertGases =
    {
            new InertGas(Nitrogen, 8000, 4),
            new InertGas(Helium, 4000, 2),
            new InertGas(Argon, 1000, 1)
    };
}
