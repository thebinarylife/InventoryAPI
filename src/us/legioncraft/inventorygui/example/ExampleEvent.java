package us.legioncraft.inventorygui.example;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import us.legioncraft.inventorygui.inventory.event.InvEvent;

public class ExampleEvent extends InvEvent{
	
	public ExampleEvent(){
		super("EXAMPLE_INVENTORY_EVENT", "EXAMPLE_INVENTORY");
	}
	
	public void react(ItemStack stack, Player player, int slot){
		if(stack.getType() == Material.AIR){
			// CODE HERE
		}
		
		if(slot == 0){
			// CODE HERE
		}
	}
}
