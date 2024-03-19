package supersymmetry.common.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.attribute.FluidAttributes;
import gregtech.api.unification.Element;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;
import supersymmetry.api.util.SuSyUtility;

import static gregtech.api.unification.material.Materials.Hydrogen;
import static gregtech.api.unification.material.Materials.Oxygen;
import static gregtech.api.unification.material.info.MaterialFlags.DISABLE_DECOMPOSITION;
import static supersymmetry.common.materials.SusyMaterials.*;

public class SuSyElementMaterials {
    public static Element Uwu;
    public static Element Cn;
    public static Element Ct;
    public static void init() {
        Uwu = Elements.add(2, 0, -1, null, "UwUnium", "Uwu", false);
        Cn = Elements.add(6, 8, -1, null, "Cien", "Cn", false);
        Ct = Elements.add(3, 4, -1, null, "Cacatua", "Ct", false);

        // Elements
        Uwunium = new Material.Builder(28000, SuSyUtility.susyId("uwunium"))
                .ingot()
                .element(Uwu)
                .liquid(new FluidBuilder().temperature(1449))
                .color(0xffa3fb)
                .build();

        Cien = new Material.Builder(28001, SuSyUtility.susyId("cien"))
                .ingot()
                .element(Cn)
                .liquid(new FluidBuilder().temperature(1449))
                .color(0xff5614)
                .build();

        Cacatua = new Material.Builder(28002, SuSyUtility.susyId("cacatua"))
                .ingot()
                .element(Ct)
                .liquid(new FluidBuilder().temperature(1449))
                .color(0xf08e32)
                .build();

        HydrocienicAcid = new Material.Builder(28100, SuSyUtility.susyId("hydrocienic_acid"))
                .liquid(new FluidBuilder().attribute(FluidAttributes.ACID))
                .color(0xde7952)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Cien, 1)
                .build();

        CacatuaHydroxide = new Material.Builder(28101, SuSyUtility.susyId("cacatua_hydroxide"))
                .dust()
                .color(0xf5d07f)
                .flags(DISABLE_DECOMPOSITION)
                .components(Cacatua, 1, Oxygen, 2, Hydrogen, 2)
                .build()
                .setFormula("Ct(OH)2", true);;
    }
}
