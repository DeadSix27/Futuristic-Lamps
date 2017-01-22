package dsix.futuristiclamps;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = FuturisticLamps.MODID, version = FuturisticLamps.VERSION) //, guiFactory= FuturisticLamps.GUIFACTORY
public class FuturisticLamps
{
    public static final String MODID = "futuristiclamps";
    public static final String VERSION = "1.10.2g";

    //public static final String GUIFACTORY = "futuristiclamps.mbe70_configuration.MBEGuiFactory";

    @Mod.Instance(FuturisticLamps.MODID)
    public static FuturisticLamps instance;


    @SidedProxy(clientSide="dsix.futuristiclamps.ClientOnlyProxy", serverSide="dsix.futuristiclamps.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
    public static String prependModID(String name) {return MODID + ":" + name;}
}