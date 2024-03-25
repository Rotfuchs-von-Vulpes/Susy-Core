package supersymmetry.loaders.recipes;

import gregtech.api.GTValues;
import gregtech.api.unification.stack.UnificationEntry;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.loaders.recipe.CraftingComponent.Component;

public class SuSyCraftingComponent {
    public static Component TOOL_HEAD_DRILL;
    public static Component CHEMICAL_PARTS;

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
    }
}
