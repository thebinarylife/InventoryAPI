package us.legioncraft.inventorygui;

import org.bukkit.plugin.java.JavaPlugin;

import us.legioncraft.inventorygui.inventory.InventoryManager;

public class InventoryGUI extends JavaPlugin{
	private static InventoryManager manager;
	
	
	public void onEnable(){
		manager = new InventoryManager(this);
	}
	
	public static InventoryManager getManager(){
		return manager;
	}
}
