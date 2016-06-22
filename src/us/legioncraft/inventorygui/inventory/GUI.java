package us.legioncraft.inventorygui.inventory;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GUI {
	private String name;
	private Inventory inv;
	private int slots;
	private HashMap<Integer, ItemStack> items;
	
	public GUI(String name, int slots, Inventory inv, HashMap<Integer, ItemStack> items){
		this.name = name;
		this.inv = inv;
		this.slots = slots;
		this.items = items;
		
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
		for(int i : items.keySet()){
			inv.setItem(i, items.get(i));
		}
	}
}
