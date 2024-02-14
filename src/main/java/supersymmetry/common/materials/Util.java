package supersymmetry.common.materials;

import com.typesafe.config.ConfigException;
import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.store.FluidStorageKeys;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.properties.BlastProperty;
import gregtech.api.unification.material.properties.PropertyKey;
import net.minecraftforge.fluids.Fluid;

import java.lang.reflect.Field;
import java.util.Objects;

import static gregtech.api.fluids.FluidConstants.*;

public class Util {
    public static int determineTemperatureGas(Material material) {
        if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.GAS) != null) {
            Fluid fluid = material.getFluid();
            if (fluid != null) {
                int current = fluid.getTemperature();
                if (current > 0) {
                    return current;
                }
            }
        }
        BlastProperty property = material.getProperty(PropertyKey.BLAST);
        if (property == null) {
            return ROOM_TEMPERATURE;
        } else {
            return property.getBlastTemperature() + GAS_TEMPERATURE_OFFSET;
        }
    }

    public static int determineTemperatureLiquid(Material material) {
        if (material.getProperty(PropertyKey.FLUID) != null && material.getProperty(PropertyKey.FLUID).getStorage().getQueuedBuilder(FluidStorageKeys.LIQUID) != null) {
            Fluid fluid = material.getFluid();
            if (fluid != null) {
                int current = fluid.getTemperature();
                if (current > 0) {
                    return current;
                }
            }
        }
        BlastProperty property = material.getProperty(PropertyKey.BLAST);
        if (property == null) {
            if (material.hasProperty(PropertyKey.DUST)) {
                return SOLID_LIQUID_TEMPERATURE;
            }
            return ROOM_TEMPERATURE;
        } else {
            return property.getBlastTemperature() + LIQUID_TEMPERATURE_OFFSET;
        }
    }
}
