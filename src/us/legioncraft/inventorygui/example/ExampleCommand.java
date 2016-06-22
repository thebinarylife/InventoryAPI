package us.legioncraft.inventorygui.example;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import us.legioncraft.inventorygui.inventory.InventoryManager;

public class ExampleCommand implements CommandExecutor{
	private ExampleMain plugin;
	
	public ExampleCommand(ExampleMain plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		plugin.getServer();
		if(	sender instanceof Player){
			Player player = (Player) sender;
			InventoryManager im = InventoryManager.getInstance();
			
			player.openInventory(im.getInventory("EXAMPLE_INVENTORY").getInventory());
		}
		
		return true;
	}
}
