package net.pixeldepth.higher_gamma;

import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

@Mod(Higher_Gamma.MODID)
public class Higher_Gamma {

	public static final String MODID = "higher_gamma";

	private KeyBinding toggle;
	private KeyBinding increase;
	private KeyBinding decrease;

	public static Higher_Gamma instance;

	public Higher_Gamma(){
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this :: setup);
	}

	private void setup(final FMLClientSetupEvent event){
		this.toggle = new KeyBinding("Toggle", GLFW.GLFW_KEY_G, "Higher Gamma");
		this.increase = new KeyBinding("Increase", GLFW.GLFW_KEY_RIGHT_BRACKET, "Higher Gamma");
		this.decrease = new KeyBinding("Decrease", GLFW.GLFW_KEY_LEFT_BRACKET, "Higher Gamma");

		ClientRegistry.registerKeyBinding(this.toggle);
		ClientRegistry.registerKeyBinding(this.increase);
		ClientRegistry.registerKeyBinding(this.decrease);

		MinecraftForge.EVENT_BUS.register(this);

		instance = this;
	}

	@SubscribeEvent
	public void onKeyInputEvent(InputEvent.KeyInputEvent event){

		GameSettings settings = Minecraft.getInstance().gameSettings;

		double gamma = settings.gamma;

		if(this.toggle.isPressed()){
			if(gamma <= 1){
				settings.gamma = 15;
			} else {
				settings.gamma = 1;
			}
		}

		if(this.increase.isPressed()){
			if(settings.gamma < 15){
				settings.gamma += 1;
			}
		}

		if(this.decrease.isPressed()){
			settings.gamma -= 1;

			if(settings.gamma < 0){
				settings.gamma = 0;
			}
		}

		System.out.println(settings.gamma);
	}
}
