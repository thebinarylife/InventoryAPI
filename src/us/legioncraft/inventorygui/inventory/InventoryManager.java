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
	private static InventoryManager instance = new InventoryManager();
	
	public InventoryManager() {};
	
	private InventoryGUI plugin;
	private ArrayList<GUI> invs;
	private ArrayList<InvEvent> events;
	private HashMap<GUI, InvEvent> invEvents;
	
	public InventoryManager(InventoryGUI plugin){
		this.plugin = plugin;
		
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	public void addGUI(GUI inv, InvEvent event){
		invs.add(inv);
		events.add(event);
		invEvents.put(inv, event);
	}

	public GUI getInventory(String name){
		for(GUI inv : invs){
			if(inv.getName() == name){
				return inv;
			}
		}
		return null;
	}
	
	public static InventoryManager getInstance(){
		return instance;
	}
	
	public InvEvent getInventoryEvent(GUI inv){
		if(invEvents.containsKey(inv)){
			return invEvents.get(inv);
		}
		
		return null;
	}
	
	public ArrayList<GUI> getGUIs(){
		return invs;
	}
	
	public ArrayList<InvEvent> getEvents(){
		return events;
	}
	
	public HashMap<GUI, InvEvent> getCorrespondents(){
		return invEvents;
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		for (GUI inv : invs){
			if(inv.getInventory() == event.getInventory()){
				invEvents.get(inv).react(event.getCurrentItem(),(Player) event.getWhoClicked(), event.getSlot());
			}
		}
	}
	

}
