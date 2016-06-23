package us.legioncraft.inventorygui;

import org.bukkit.plugin.java.JavaPlugin;

import us.legioncraft.inventorygui.inventory.InventoryManager;

/** Main class, enables manager, and returns manager instance
 * 
 * @author TheBinaryLife
 * @version Beta
 */

public class InventoryGUI extends JavaPlugin{
	
	/** Inventory Manager */
	private static InventoryManager manager;
	
	/** Starts plugin */
	public void onEnable(){
		manager = new InventoryManager(this);
	}
	
	/** @return inventory manager */
	public static InventoryManager getManager(){
		return manager;
	}
}
