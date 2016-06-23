package us.legioncraft.inventorygui.inventory;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import us.legioncraft.inventorygui.inventory.event.InvEvent;

public class GUI {
	private String name;
	private Inventory inv;
	private int slots;
	private HashMap<Integer, ItemStack> items;
	private ArrayList<InvEvent> events;
	
	public GUI(String name, int slots, Inventory inv, HashMap<Integer, ItemStack> items){
		this.name = name;
		this.inv = inv;
		this.slots = slots;
		this.items = items;
		events = new ArrayList<>();
		
		createInventory();
	}
	
	public String getName(){
		return name;
	}
	
	public int getSlots(){
		return slots;
	}
	
	public Inventory getInventory(){
		return inv;
	}
	
	public HashMap<Integer, ItemStack> getItems(){
		return items;
	}
	
	public void createInventory(){
		Bukkit.getServer().createInventory(null, slots, name);
		addItems();
	}
		
	public void addItems(){
		System.out.println(items.keySet());
		System.out.println(items.values());
		for(int i : items.keySet()){
			System.out.println(items.get(i).getType().toString());
			inv.setItem(i, items.get(i));
		}
	}
	
	public ArrayList<InvEvent> getEvents(){
		return events;
	}
	
	public void addEvent(InvEvent event){
		events.add(event);
	}
	
}
