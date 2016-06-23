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
	private ArrayList<GUI> invs = new ArrayList<>();
	private ArrayList<InvEvent> events = new ArrayList<>();
	private HashMap<GUI, ArrayList<InvEvent>> invEvents = new HashMap<>();
	
	public InventoryManager(InventoryGUI plugin){
		this.plugin = plugin;
		
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	public void addGUI(GUI inv){
		invs.add(inv);
		System.out.println(inv.toString());
		System.out.println(inv.getEvents());
		invEvents.put(inv, inv.getEvents());
		
		for(InvEvent event : inv.getEvents()){
			events.add(event);
		}
	}

	public GUI getInventory(String name){
		for(GUI inv : invs){
			if(inv.getName() == name){
				return inv;
			}
		}
		return null;
	}
	
	public ArrayList<InvEvent> getInventoryEvents(GUI inv){
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
	
//	public HashMap<GUI, InvEvent> getCorrespondents(){
//		return invEvents;
//	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event){
		for (GUI inv : invs){
			if(inv.getInventory().getName() == event.getInventory().getName()){
				System.out.println("hi");
				System.out.println(invEvents.size());
				for(InvEvent invEvent : invEvents.get(inv)){
					
					System.out.println("ok???");
					if(event.getSlot() == invEvent.getSlot()){
						System.out.println("3");
						invEvent.react(event, event.getCurrentItem(), (Player) event.getWhoClicked());
						System.out.println("hi");
					}
				}
				
				System.out.println("hi");
				// invEvents.get(inv).react(event, event.getCurrentItem(),(Player) event.getWhoClicked(), event.getSlot());
			}
		}
	}
	

}
