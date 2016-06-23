package us.legioncraft.inventorygui.inventory.event;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public interface InvEvent{
	
	/** @return slot in which the event takes place */
	int getSlot();
	
	/** Called when an action is clicked in the slot specified
	 * 
	 * @param event  Bukkit event
	 * @param stack Item clicked
	 * @param player Player who clicked the slot
	 *  
	 */
	void react(InventoryClickEvent event, ItemStack stack, Player player);
	
	/**
	 * 
	 * @return Name of the Inventory the event occurs on
	 * 
	 */
	String getInventoryName();
}