package supersymmetry.loaders.recipes;

import gregtech.api.GTValues;
import gregtech.api.unification.stack.UnificationEntry;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.recipe.CraftingComponent.Component;
import static supersymmetry.common.item.SuSyMetaItems.GRAPHITE_ELECTRODE;
import static supersymmetry.common.materials.SusyMaterials.NeodymiumAlloyMagnetic;
import static supersymmetry.common.materials.SusyMaterials.SamariumAlloyMagnetic;

public class SuSyCraftingComponent {
    public static Component TOOL_HEAD_DRILL;
    public static Component CHEMICAL_PARTS;
    public static Component MAGNETS;
    public static Component ELECTRODES;

    public static void init() {
        TOOL_HEAD_DRILL = new Component(Stream.of(new Object[][] {
                { 0, new UnificationEntry(toolHeadDrill, Steel) },
                { 1, new UnificationEntry(toolHeadDrill, Steel) },
                { 2, new UnificationEntry(toolHeadDrill, Aluminium) },
                { 3, new UnificationEntry(toolHeadDrill, StainlessSteel) },
                { 4, new UnificationEntry(toolHeadDrill, Titanium) },
                { 5, new UnificationEntry(toolHeadDrill, TungstenSteel) },
                { 6, new UnificationEntry(toolHeadDrill, RhodiumPlatedPalladium) },
                { 7, new UnificationEntry(toolHeadDrill, NaquadahAlloy) },
                { 8, new UnificationEntry(toolHeadDrill, Darmstadtium) },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
        CHEMICAL_PARTS = new Component(Stream.of(new Object[][] {
                { 0, "blockGlass" },
                { 1, "blockGlass" },
                { 2, "blockGlass" },
                { 3, new UnificationEntry(pipeNormalFluid, Polyethylene) },
                { 4, new UnificationEntry(pipeLargeFluid, Polyethylene) },
                { 5, new UnificationEntry(pipeHugeFluid, Polyethylene) },
                { 6, new UnificationEntry(pipeNormalFluid, Polytetrafluoroethylene) },
                { 7, new UnificationEntry(pipeLargeFluid, Polytetrafluoroethylene) },
                { 8, new UnificationEntry(pipeHugeFluid, Polytetrafluoroethylene) },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
        MAGNETS = new Component(Stream.of(new Object[][] {
                { 0, new UnificationEntry(stick, IronMagnetic) },
                { 1, new UnificationEntry(stick, IronMagnetic) },
                { 2, new UnificationEntry(stick, SteelMagnetic) },
                { 3, new UnificationEntry(stick, SteelMagnetic) },
                { 4, new UnificationEntry(stick, NeodymiumAlloyMagnetic) },
                { 5, new UnificationEntry(stick, NeodymiumAlloyMagnetic) },
                { 6, new UnificationEntry(stick, SamariumAlloyMagnetic) },
                { 7, new UnificationEntry(stick, SamariumAlloyMagnetic) },
                { 8, new UnificationEntry(stick, SamariumAlloyMagnetic) },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
        ELECTRODES = new Component(Stream.of(new Object[][] {
                { 0, new UnificationEntry(wireFine, RedAlloy) },
                { 1, new UnificationEntry(wireFine, Steel) },
                { 2, GRAPHITE_ELECTRODE },
                { 3, new UnificationEntry(wireFine, Platinum) },
                { 4, new UnificationEntry(wireFine, Titanium) },
                { 5, new UnificationEntry(wireFine, Tungsten) },
                { 6, new UnificationEntry(wireFine, Osmiridium) },
                { 7, new UnificationEntry(wireFine, NiobiumTitanium) },
                { 8, new UnificationEntry(wireFine, Naquadah) },
                { 9, new UnificationEntry(wireFine, NaquadahAlloy) },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
