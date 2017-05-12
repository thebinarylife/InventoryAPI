package us.legioncraft.inventorygui.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.legioncraft.inventorygui.inventory.event.InvEvent;

/** GUI Class, super class for all GUIS
 * 
 * @author TheBinaryLife
 * @version Beta
 * 
 */

public class GUI {
	/** Name of inventory */
	private String name;
	/** Bukkit inventory variable */
	private Inventory inv;
	/** Amount of slots in the inventory */
	private int slots;
	/** Items in the inventory */
	private HashMap<Integer, ItemStack> items;
	/** Events when each item is clicked */
	private ArrayList<InvEvent> events;
	
	/** Creates the inventory and intializes varables
	 * 
	 * @param name Name of inventory
	 * @param slots number of slots in the inventory
	 * @param inv Inventory object bing used
	 * @param items items in the inventory
	 *  
	 */
	public GUI(String name, int slots, Inventory inv, HashMap<Integer, ItemStack> items){
		this.name = name;
		this.inv = inv;
		this.slots = slots;
		this.items = items;
		events = new ArrayList<>();
		
		createInventory();
	}
	
	/** @return Inventory name */
	public String getName(){
		return name;
	}
	
	/** @return Number of slots */
	public int getSlots(){
		return slots;
	}
	
	/** @return Inventory object */
	public Inventory getInventory(){
		return inv;
	}
	
	/** @return Items in the inventory and their slots */
	public HashMap<Integer, ItemStack> getItems(){
		return items;
	}
	
	/** Creates inventory */
	public void createInventory(){
		Bukkit.getServer().createInventory(null, slots, name);
		addItems();
	}
		
	/** Adds items to inventory */
	public void addItems(){
		for(int i : items.keySet()){
			inv.setItem(i, items.get(i));
		}
	}
	
	
	/** @return Inventory's events */
	public ArrayList<InvEvent> getEvents(){
		return events;
	}
	
	/** @param event event being added */
	public void addEvent(InvEvent event){
		events.add(event);
	}
	
}
