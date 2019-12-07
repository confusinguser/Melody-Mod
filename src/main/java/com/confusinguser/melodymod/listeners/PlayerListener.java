package com.confusinguser.melodymod.listeners;

import org.lwjgl.input.Keyboard;

import com.confusinguser.melodymod.MelodyMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class PlayerListener {

	Minecraft mc;
	MelodyMod main;

	public PlayerListener(MelodyMod main) {
		this.main = main;
		mc = Minecraft.getMinecraft();
	}

	@SubscribeEvent(receiveCanceled = true)
	public void onGuiScreenKeyInput(GuiScreenEvent.KeyboardInputEvent e) {
		System.out.println(Keyboard.getEventKey());
		if (!(mc.currentScreen instanceof GuiChest)) {
			return;
		} else {
			if (main.getUtils().harpGuiIsOpen()) {
				if (main.getNoteOneKey().getKeyCode() == Keyboard.getEventKey()) {
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 37, 0, 4, mc.thePlayer);
				}

				else if (main.getNoteTwoKey().getKeyCode() == Keyboard.getEventKey()) {
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 38, 0, 4, mc.thePlayer);
				}

				else if (main.getNoteThreeKey().getKeyCode() == Keyboard.getEventKey()) {
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 39, 0, 4, mc.thePlayer);
				}

				else if (main.getNoteFourKey().getKeyCode() == Keyboard.getEventKey()) {
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 40, 0, 4, mc.thePlayer);
				}

				else if (main.getNoteFiveKey().getKeyCode() == Keyboard.getEventKey()) {
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 41, 0, 4, mc.thePlayer);
				}

				else if (main.getNoteSixKey().getKeyCode() == Keyboard.getEventKey()) {
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 42, 0, 4, mc.thePlayer);
				}

				else if (main.getNoteSevenKey().getKeyCode() == Keyboard.getEventKey()) {
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 43, 0, 4, mc.thePlayer);
				}
			}
		}
	}
}
