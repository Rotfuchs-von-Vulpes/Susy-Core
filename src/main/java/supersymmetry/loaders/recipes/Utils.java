package supersymmetry.loaders.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import static gregtech.api.unification.material.Materials.*;
import static supersymmetry.common.materials.SusyMaterials.FuelOil;
import static supersymmetry.common.materials.SusyMaterials.Syngas;

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
    public static class Combustible {
        private final FluidStack fluid;
        private final boolean isPlasme;
        private final int duration;
        private final Fluid byproduct;
        int byproductAmount;

        public FluidStack getFluid() {
            return fluid;
        }

        public FluidStack getByproduct() {
            return new FluidStack(byproduct, byproductAmount);
        }

        public int getDuration() {
            return duration;
        }

        public boolean isPlasme() {
            return this.isPlasme;
        }

        public Combustible(FluidStack fluid, boolean isPlasma, int amountRequired, int duration, Fluid byproduct, int byproductAmount) {
            this.fluid = fluid;
            this.isPlasme = isPlasma;
            this.fluid.amount = amountRequired;
            this.duration = duration;
            this.byproduct = byproduct;
            this.byproductAmount = byproductAmount;
        }
    }

    public static class Comburent {
        private final FluidStack fluid;
        private final int duration;

        public FluidStack getFluid() {
            return fluid;
        }

        public int getDuration() {
            return duration;
        }

        Comburent(FluidStack fluid, int amountRequired, int duration) {
            this.fluid = fluid;
            this.fluid.amount = amountRequired;
            this.duration = duration;
        }
    }

    public static class Blanket {
        FluidStack fluid;
        int amountRequired;
        int duration;

        Blanket(FluidStack fluid, int amountRequired, int duration) {
            this.fluid = fluid;
            this.amountRequired = amountRequired;
            this.duration = duration;
        }
    }

    public static Combustible[] sintering_fuels = {
        new Combustible(Methane.getFluid(1), false, 10, 50, CarbonDioxide.getFluid(), 5),
        new Combustible(Syngas.getFluid(1), false, 10, 50, CarbonDioxide.getFluid(), 5),
        new Combustible(NaturalGas.getFluid(1), false, 10, 50, CarbonDioxide.getFluid(), 5),
        new Combustible(RefineryGas.getFluid(1), false, 10, 50, CarbonDioxide.getFluid(), 5),
        new Combustible(Helium.getPlasma(1), true, 10, 5, Helium.getFluid(), 10)
    };

    public static Comburent[] sintering_comburents = {
        new Comburent(Air.getFluid(1), 10, 50),
        new Comburent(Oxygen.getFluid(1), 8, 30)
    };

    public static Blanket[] sintering_blankets = {
        new Blanket(Argon.getFluid(1), 100, 300)
    };

    public static Combustible[] rotary_kiln_fuels = {
        new Combustible(Methane.getFluid(1), false, 10, 50, CarbonDioxide.getFluid(), 5),
        new Combustible(NaturalGas.getFluid(1), false, 10, 50, CarbonDioxide.getFluid(), 5),
        new Combustible(RefineryGas.getFluid(1), false, 10, 50, CarbonDioxide.getFluid(), 5),
        new Combustible(FuelOil.getFluid(1), false, 4, 50, CarbonDioxide.getFluid(), 25)
    };

    public static Comburent[] rotary_kiln_comburents = {
        new Comburent(Air.getFluid(1), 250, 50),
        new Comburent(Oxygen.getFluid(1), 50, 30)
    };
}
