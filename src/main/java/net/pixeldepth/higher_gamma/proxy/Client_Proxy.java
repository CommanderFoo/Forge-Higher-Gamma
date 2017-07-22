package net.pixeldepth.higher_gamma.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.pixeldepth.higher_gamma.client.Key_Bindings;
import net.pixeldepth.higher_gamma.client.Key_Input_Handler;

public class Client_Proxy extends Common_Proxy {

	@Override
	public void pre_init(FMLPreInitializationEvent event){
		super.pre_init(event);

		ClientRegistry.registerKeyBinding(Key_Bindings.TOGGLE);
	}

	@Override
	public void init(FMLInitializationEvent event){
		super.init(event);

		MinecraftForge.EVENT_BUS.register(new Key_Input_Handler());
	}

	@Override
	public void post_init(FMLPostInitializationEvent event){
		super.post_init(event);
	}

}
