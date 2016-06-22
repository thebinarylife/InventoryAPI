package us.legioncraft.inventorygui;

import org.bukkit.plugin.java.JavaPlugin;

import us.legioncraft.inventorygui.inventory.InventoryManager;

public class InventoryGUI extends JavaPlugin{

	public void onEnable(){
		new InventoryManager(this);
	}
	
}
