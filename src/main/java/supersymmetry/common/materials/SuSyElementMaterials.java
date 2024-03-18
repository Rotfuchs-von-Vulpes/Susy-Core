package supersymmetry.common.materials;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.unification.Element;
import gregtech.api.unification.Elements;
import gregtech.api.unification.material.Material;
import supersymmetry.api.util.SuSyUtility;

import static supersymmetry.common.materials.SusyMaterials.Uwunium;

public class SuSyElementMaterials {
    public static Element Uwu;
    public static void init() {
        Uwu = Elements.add(0, 1, -1, null, "UwUnium", "Uwu", false);

        Uwunium = new Material.Builder(28000, SuSyUtility.susyId("uwunium"))
                .ingot()
                .element(Uwu)
                .liquid(new FluidBuilder().temperature(1449))
                .color(0xffa3fb)
                .build();
    }
}
