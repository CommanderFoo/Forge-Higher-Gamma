package net.pixeldepth.higher_gamma.client;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.settings.KeyBinding;

@SideOnly(Side.CLIENT)

public class Key_Bindings {

	public static KeyBinding TOGGLE = new KeyBinding("Toggle gamma brightness", Keyboard.KEY_G, "Gamma Brightness");

}
