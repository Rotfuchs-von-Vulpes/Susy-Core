package supersymmetry.loaders.recipes.metallurgy;

import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtechfoodoption.integration.appleskin.GTFOMetaFoodHelper;
import gregtechfoodoption.item.GTFOFoodStats;
import gregtechfoodoption.item.GTFOMetaItem;
import gregtechfoodoption.item.food.GTFOFoodUseManager;
import net.minecraftforge.fluids.FluidUtil;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static net.minecraft.init.Items.PAPER;
import static supersymmetry.common.item.SuSyMetaItems.*;

public class MagneticIronRodChain {
    public static void init() {
//        def voltaic_pile_ingredients = [
//    [null, metaitem("electrolyte_paper"), null],
//    [null, metaitem("plateZinc"), null],
//    [null, metaitem("plateCopper"), null]
//]

//        def magnetic_rod_ingredients = [
//    [metaitem("voltaic_pile").reuse(), metaitem("wireGtSingleCopper").reuse(), metaitem("springCopper").reuse()],
//    [null, null, metaitem("hot_iron_rod")],
//    [null, null, null]
//]
        OreDictUnifier.registerOre(GTFOMetaItem.LIME.getStackForm(), "electrolyteFruit");
        OreDictUnifier.registerOre(GTFOMetaItem.LEMON.getStackForm(), "electrolyteFruit");
        OreDictUnifier.registerOre(GTFOMetaItem.ORANGE.getStackForm(), "electrolyteFruit");

        ModHandler.removeRecipeByName("gregtech:iron_magnetic_stick");

        ModHandler.addSmeltingRecipe(new UnificationEntry(stick, Iron), HOT_IRON_ROD.getStackForm());

        ModHandler.addShapelessRecipe("ElectrolytePaperSalt", ELECTROLYTE_PAPER.getStackForm(),
                PAPER, FluidUtil.getFilledBucket(SaltWater.getFluid(1000)));
        ModHandler.addShapelessRecipe("ElectrolytePaperFruit", ELECTROLYTE_PAPER.getStackForm(),
                "electrolyteFruit", PAPER, 'm');

        ModHandler.addShapelessRecipe("MagneticIronDuplication", OreDictUnifier.get(stick, IronMagnetic),
                HOT_IRON_ROD, new UnificationEntry(stick, IronMagnetic));
        ModHandler.addShapelessRecipe("MagneticIronMagentite", OreDictUnifier.get(stick, IronMagnetic),
                HOT_IRON_ROD, CHUNK_MAGNETITE);
        ModHandler.addShapedRecipe(true, "MagneticRodVoltaic", OreDictUnifier.get(stick, IronMagnetic),
                "VSS", " H ", "   ",
                'V', VOLTAIC_PILE,
                'S', new UnificationEntry(spring, Copper),
                'H', HOT_IRON_ROD);

        ModHandler.addShapedRecipe(true, "VoltaicPileCrafting", VOLTAIC_PILE.getStackForm(),
                " P ", " C ", " Z ",
                'P', ELECTROLYTE_PAPER,
                'C', new UnificationEntry(plate, Copper),
                'Z', new UnificationEntry(plate, Zinc));
    }
}
