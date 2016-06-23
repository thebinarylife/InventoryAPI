package us.legioncraft.inventorygui.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import us.legioncraft.inventorygui.InventoryGUI;
import us.legioncraft.inventorygui.inventory.event.InvEvent;

public class InventoryManager implements Listener{
	private InventoryGUI plugin;
	/** Array of all inventories */
	private ArrayList<GUI> invs = new ArrayList<>();
	/** ArrayList of all events */
	private ArrayList<InvEvent> events = new ArrayList<>();
	/** HashMap of inventories and their corresponding events */
	private HashMap<GUI, ArrayList<InvEvent>> invEvents = new HashMap<>();
	
	/** Creates manager variable in main class and registers events  
	 * 
	 * @param plugin instance of main class
	 * 
	 */
	public InventoryManager(InventoryGUI plugin){
		this.plugin = plugin;
		
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	/** Adds GUI and events to manager
	 * 
	 * @param inv Inventory being added to the class
	 *  
	 */
	public void addGUI(GUI inv){
		invs.add(inv);
		System.out.println(inv.toString());
		System.out.println(inv.getEvents());
		invEvents.put(inv, inv.getEvents());
		
		for(InvEvent event : inv.getEvents()){
			events.add(event);
		}
	}
	
	/**
	 * 
	 * @param name name of inventory
	 * @return inventory (if the inventory with the specified name doesn't exist, returns null)
	 */
	public GUI getInventory(String name){
		for(GUI inv : invs){
			if(inv.getName() == name){
				return inv;
			}
		}
		return null;
	}
	
	/** 
	 * 
	 * @param inv inventory that you are getting the events of
	 * @return events of a certain inventory (if none exist it returns null)
	 * 
	 */
	public ArrayList<InvEvent> getInventoryEvents(GUI inv){
		if(invEvents.containsKey(inv)){
			return invEvents.get(inv);
		}
		
		return null;
	}
	
	/** @return all GUIs */
	public ArrayList<GUI> getGUIs(){
		return invs;
	}
	
	/** @return all events */
	public ArrayList<InvEvent> getEvents(){
		return events;
	}
	
	/** Checks to see if the inventory is one used by a plugin, if it is, the react() method is called by the corresponding event
	 * 
	 *  @param event - Bukkit event
	 *  
	 */
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		for (GUI inv : invs){
			if(inv.getInventory().getName() == event.getInventory().getName()){
				for(InvEvent invEvent : invEvents.get(inv)){
					if(event.getSlot() == invEvent.getSlot()){
						invEvent.react(event, event.getCurrentItem(), (Player) event.getWhoClicked());
					}
				}
				
			}
		}
	}
	

}
