package net.pixeldepth.higher_gamma.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class Key_Input_Handler {

	@SubscribeEvent
	public void key_input(InputEvent.KeyInputEvent event){
		if(Key_Bindings.TOGGLE.isPressed()){
			double gamma = Minecraft.getMinecraft().gameSettings.gammaSetting;

			if(gamma <= 1){
				Minecraft.getMinecraft().gameSettings.gammaSetting = 10000;
			} else {
				Minecraft.getMinecraft().gameSettings.gammaSetting = 1;
			}
		}
	}

}
