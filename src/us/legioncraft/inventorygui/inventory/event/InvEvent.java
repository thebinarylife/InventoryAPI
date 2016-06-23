package us.legioncraft.inventorygui.inventory.event;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public interface InvEvent{
	
	// String getName();
	
	// String toString();
	
	int getSlot();
	
	void react(InventoryClickEvent event, ItemStack stack, Player player);
	
	String getInventoryName();
}

//public class InvEvent {
//	private String name;
//	private String invName;
//	
//	public InvEvent(String name, String invName){
//		this.name = name;
//		this.invName = invName;
//	}
//	
//	public String getName(){
//		return name;
//	}
//	
//	public String toString(){
//		return name;
//	}
//	
//	public String getInventoryName(){
//		return invName;
//	}
//	
//	public void react(InventoryClickEvent event, ItemStack stack, Player player, int slot){}
//}
