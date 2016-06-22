package us.legioncraft.inventorygui.example;

import org.bukkit.plugin.java.JavaPlugin;

import us.legioncraft.inventorygui.inventory.InventoryManager;

public class ExampleMain extends JavaPlugin{
	
	public void onEnable(){
			
	    getCommand("invexample").setExecutor(new ExampleCommand(this));
	    InventoryManager.getInstance().addGUI(new ExampleGUI(this), new ExampleEvent());
	}
	
}
