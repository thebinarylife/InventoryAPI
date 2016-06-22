package us.legioncraft.inventorygui.inventory.event;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InvEvent {
	private String name;
	private String invName;
	
	public InvEvent(String name, String invName){
		this.name = name;
		this.invName = invName;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
	
	public String getInventoryName(){
		return invName;
	}
	
	public void react(ItemStack stack, Player player, int slot){}
}
