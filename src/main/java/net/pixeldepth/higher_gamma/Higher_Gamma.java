package net.pixeldepth.higher_gamma;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.pixeldepth.higher_gamma.client.Key_Bindings;
import net.pixeldepth.higher_gamma.client.Key_Input_Handler;
import net.pixeldepth.higher_gamma.proxy.Common_Proxy;
import org.apache.logging.log4j.Logger;

@Mod(modid = Higher_Gamma.MODID, name = "Higher Gammar", version = Higher_Gamma.VERSION)

public class Higher_Gamma {

	public static final String MODID = "higher_gamma";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "net.pixeldepth.higher_gamma.proxy.Client_Proxy", serverSide = "net.pixeldepth.higher_gamma.proxy.Client_Proxy.Server_Proxy")

	public static Common_Proxy proxy;

	@Mod.Instance
	public static Higher_Gamma instance;

	public static Logger logger;

	@EventHandler
	public void pre_init(FMLPreInitializationEvent event){
		proxy.pre_init(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event){
		proxy.init(event);
	}

}
