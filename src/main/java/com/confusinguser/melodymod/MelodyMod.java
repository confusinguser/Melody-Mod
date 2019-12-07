package com.confusinguser.melodymod;

import org.lwjgl.input.Keyboard;

import com.confusinguser.melodymod.listeners.PlayerListener;
import com.confusinguser.melodymod.utils.Utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;

@Mod(modid = MelodyMod.MODID, version = MelodyMod.VERSION, name = MelodyMod.MOD_NAME, clientSideOnly = true, acceptedMinecraftVersions = "[1.8.9]")
public class MelodyMod
{
    public static final String MODID = "melodymod";
    public static final String VERSION = "1.0";
    public static final String MOD_NAME = "Melody Mod";

    private KeyBinding noteOneKeyBind;
    private KeyBinding noteTwoKeyBind;
    private KeyBinding noteThreeKeyBind;
    private KeyBinding noteFourKeyBind;
    private KeyBinding noteFiveKeyBind;
    private KeyBinding noteSixKeyBind;
    private KeyBinding noteSevenKeyBind;

    private PlayerListener playerListener = new PlayerListener(this);
    private Utils utils = new Utils(this);

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {

    	MinecraftForge.EVENT_BUS.register(playerListener);

    	noteOneKeyBind = new KeyBinding("Note 1", Keyboard.KEY_Z, MOD_NAME);
    	noteTwoKeyBind = new KeyBinding("Note 2", Keyboard.KEY_X, MOD_NAME);
    	noteThreeKeyBind = new KeyBinding("Note 3", Keyboard.KEY_C, MOD_NAME);
    	noteFourKeyBind = new KeyBinding("Note 4", Keyboard.KEY_V, MOD_NAME);
    	noteFiveKeyBind = new KeyBinding("Note 5", Keyboard.KEY_B, MOD_NAME);
    	noteSixKeyBind = new KeyBinding("Note 6", Keyboard.KEY_N, MOD_NAME);
    	noteSevenKeyBind = new KeyBinding("Note 7", Keyboard.KEY_M, MOD_NAME);

        ClientRegistry.registerKeyBinding(noteOneKeyBind);
        ClientRegistry.registerKeyBinding(noteTwoKeyBind);
        ClientRegistry.registerKeyBinding(noteThreeKeyBind);
        ClientRegistry.registerKeyBinding(noteFourKeyBind);
        ClientRegistry.registerKeyBinding(noteFiveKeyBind);
        ClientRegistry.registerKeyBinding(noteSixKeyBind);
        ClientRegistry.registerKeyBinding(noteSevenKeyBind);
    }

    public KeyBinding getNoteOneKey() {
    	return noteOneKeyBind;
    }

    public KeyBinding getNoteTwoKey() {
    	return noteTwoKeyBind;
    }

    public KeyBinding getNoteThreeKey() {
    	return noteThreeKeyBind;
    }

    public KeyBinding getNoteFourKey() {
    	return noteFourKeyBind;
    }

    public KeyBinding getNoteFiveKey() {
    	return noteFiveKeyBind;
    }

    public KeyBinding getNoteSixKey() {
    	return noteSixKeyBind;
    }

    public KeyBinding getNoteSevenKey() {
    	return noteSevenKeyBind;
    }

    public Utils getUtils() {
    	return utils;
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent e) {

    }
}
