package supersymmetry;

import gregtech.GTInternalTags;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;
import supersymmetry.api.SusyLog;
import supersymmetry.api.sound.SusySounds;
import supersymmetry.common.CommonProxy;
import supersymmetry.common.blocks.SuSyBlocks;
import supersymmetry.common.blocks.SuSyMetaBlocks;
import supersymmetry.common.covers.SuSyCoverBehaviors;
import supersymmetry.common.item.SuSyMetaItems;
import supersymmetry.common.metatileentities.SuSyMetaTileEntities;
import supersymmetry.common.world.SuSyInitWorldGen;
import supersymmetry.worldGen.SuSyWorldGen;

import java.io.IOException;

@Mod(name = Supersymmetry.NAME, modid = Supersymmetry.MODID, version = "0.1.12", dependencies = GTInternalTags.DEP_VERSION_STRING + ";required-after:gcym;required-after:gregtechfoodoption")

public class Supersymmetry {

    public static final String NAME = "Supersymmetry";
    public static final String MODID = "susy";

    @SidedProxy(modId = MODID, clientSide = "supersymmetry.client.ClientProxy", serverSide = "supersymmetry.common.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(Supersymmetry.MODID)
    public static Supersymmetry instance;

    @Mod.EventHandler
    public void onModConstruction(FMLConstructionEvent event) {
        //This is now a config option I think
        //GTValues.HT = true;
    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SuSyInitWorldGen.registerWorldGenerators();
    }

    @Mod.EventHandler
    public void onPreInit(@NotNull FMLPreInitializationEvent event) {
        proxy.preLoad();

        SuSyMetaBlocks.init();
        SuSyMetaItems.initMetaItems();
        SuSyBlocks.init();

        SusySounds.registerSounds();

        SuSyMetaTileEntities.init();

//        try {
//            SuSyWorldGen.init();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Mod.EventHandler
    public void onInit(@NotNull FMLInitializationEvent event) {
        boolean doesDummyFileExist = SuSyWorldGen.INSTANCE.doesDummyFileExist();

        try {
            if (!doesDummyFileExist) {
                SusyLog.logger.info("Dummy file not exists");
                SuSyWorldGen.INSTANCE.addRemoveVeins();
                SuSyWorldGen.INSTANCE.createDummyFile();
            } else {
                SusyLog.logger.info("Dummy file exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SuSyCoverBehaviors.init();
    }
}
