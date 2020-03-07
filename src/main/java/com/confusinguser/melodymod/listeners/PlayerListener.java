package com.confusinguser.melodymod.listeners;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.confusinguser.melodymod.MelodyMod;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;


public class PlayerListener {

	Minecraft mc;
	MelodyMod main;

	private boolean[] keyDownLastTick = {false, false, false, false, false, false, false};

	public PlayerListener(MelodyMod main) {
		this.main = main;
		mc = Minecraft.getMinecraft();
	}


	@SubscribeEvent
	public void onGuiClick(GuiScreenEvent.MouseInputEvent e) {
		if (mc.currentScreen instanceof GuiChest && main.getUtils().harpGuiIsOpen()) {
			if (Mouse.getEventButton() == 1) {
				e.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void onTick(TickEvent e) {
		if (e.phase == Phase.START && mc.currentScreen instanceof GuiChest && main.getUtils().harpGuiIsOpen()) {
			boolean hasPressedOtherKeys = false; // So that you don't press multiple notes at the same time (impossible in vanilla)
			for (int i = 0; i < main.getKeyBindings().length; i++) {
				if (Keyboard.isKeyDown(main.getKeyBindings()[i].getKeyCode()) && !keyDownLastTick[i] && !hasPressedOtherKeys) {
					hasPressedOtherKeys = true;
					mc.playerController.windowClick(mc.thePlayer.openContainer.windowId, 37 + i, 0, 4, mc.thePlayer);
				}
				keyDownLastTick[i] = Keyboard.isKeyDown(main.getKeyBindings()[i].getKeyCode());
			}
		}
	}
}
