package com.confusinguser.melodymod;

import org.lwjgl.input.Keyboard;

import com.confusinguser.melodymod.listeners.PlayerListener;
import com.confusinguser.melodymod.utils.Utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = MelodyMod.MODID, version = MelodyMod.VERSION, name = MelodyMod.MOD_NAME, clientSideOnly = true, acceptedMinecraftVersions = "[1.8.9]")
public class MelodyMod
{
    public static final String MODID = "melodymod";
    public static final String VERSION = "1.1";
    public static final String MOD_NAME = "Melody Mod";

    private KeyBinding[] keyBindings = new KeyBinding[7];

    private PlayerListener playerListener = new PlayerListener(this);
    private Utils utils = new Utils(this);

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {

    	MinecraftForge.EVENT_BUS.register(playerListener);

    	keyBindings[0] = new KeyBinding("Note 1", Keyboard.KEY_Z, MOD_NAME);
    	keyBindings[1] = new KeyBinding("Note 2", Keyboard.KEY_X, MOD_NAME);
    	keyBindings[2] = new KeyBinding("Note 3", Keyboard.KEY_C, MOD_NAME);
    	keyBindings[3] = new KeyBinding("Note 4", Keyboard.KEY_V, MOD_NAME);
    	keyBindings[4] = new KeyBinding("Note 5", Keyboard.KEY_B, MOD_NAME);
    	keyBindings[5] = new KeyBinding("Note 6", Keyboard.KEY_N, MOD_NAME);
    	keyBindings[6] = new KeyBinding("Note 7", Keyboard.KEY_M, MOD_NAME);

    	for (int i = 0; i < keyBindings.length; i++) {
    		ClientRegistry.registerKeyBinding(keyBindings[i]);
    	}
    }

    public KeyBinding[] getKeyBindings() {
    	return keyBindings;
    }

    public Utils getUtils() {
    	return utils;
    }
}
