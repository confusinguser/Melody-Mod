package com.confusinguser.melodymod.utils;

import com.confusinguser.melodymod.MelodyMod;

import net.minecraft.client.Minecraft;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;

public class Utils {

	private MelodyMod main;
	private Minecraft mc;
	private boolean harpOpen;

	String HARP_DISPLAYNAME = "Harp - ";

	public Utils(MelodyMod main) {
		this.main = main;
		this.mc = Minecraft.getMinecraft();
	}


	public boolean harpGuiIsOpen() {
		if (mc.thePlayer.openContainer instanceof ContainerChest) {
			ContainerChest chest = (ContainerChest) mc.thePlayer.openContainer;
			IInventory inv = chest.getLowerChestInventory();
			if (inv.getName().startsWith(HARP_DISPLAYNAME)) {
				return true;
			}
		}
		return false;
	}

	public void setHarpOpen(boolean b) {
		this.harpOpen = b;
	}

	public boolean getHarpOpen() {
		return harpOpen;
	}
}
