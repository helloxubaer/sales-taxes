package com.eassyshopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/*
 * The Store class contains items in store, and keeps track of available stock 
 */
public class Store {

	private final Map<String, Item> itemsInStore;

	public Store() {
		this.itemsInStore = new LinkedHashMap<String, Item>();
	}
	
	public boolean addItemInStore(Item theItem) {
		// Need to verify if theItem is already exists and not null
		// update current item if exists 
		if(theItem != null) {
			Item checkItem = itemsInStore.get(theItem.getName());
			if (checkItem != null) {
				// item found, update the item's quantity only
				theItem.updateQuantity(checkItem.getQuantity());				
			}
			// not found, add the item
			itemsInStore.put(theItem.getName(), theItem);
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean sellItemsFromStore(String itemName, int desiredQuntity) {
		Item sellingItem = getItemByName(itemName);
		if ((sellingItem.getQuantity() >= desiredQuntity) && (desiredQuntity > 0)) {
			sellingItem.reduceQuantity(desiredQuntity);
			return true;
		}else {
			return false;
		} 
	}
	
	public Item getItemByName(String itemName) {
		//validate name,lowercase(???)
		Item desiredItem = itemsInStore.get(itemName);
		return desiredItem;
	}
	
	public void displayItemsInTheStore() {
		System.out.println("*** Available products ***\n");
		String itemDescription;
		int itemNr = 1;
		
		for(Map.Entry<String, Item> item : itemsInStore.entrySet()) {
			Item tempItem = item.getValue();
			itemDescription = itemNr +"# " + tempItem.getName() + " at €" +
			tempItem.getPrice() + ", available stock: " + tempItem.getQuantity();
			System.out.println(itemDescription);
			itemNr++;
		}
	}	
	public Map<String, Item> getItemsInStore() {
		return Collections.unmodifiableMap(itemsInStore);
	}
	
}
