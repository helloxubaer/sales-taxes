package com.eassyshopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * The Store class contains items in store, and keeps track of available stock 
 */
public class Store {

	private final Map<String, Item> itemsInStore;
	private Scanner sc;

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
	
	public void sellItemsFromStore(String itemName, int desiredQuntity) {
		// validation (???)
		Item sellingItem = itemsInStore.get(itemName);
		sellingItem.reduceQuantity(desiredQuntity);
	}
	
	public boolean checkItemAvaibality(String itemName, int checkingQuntity) {
		Item checkingItem = itemsInStore.get(itemName);
		if ((checkingItem != null) && (checkingItem.getQuantity() >= checkingQuntity)
				&& (checkingQuntity > 0)) {
			return true;
		}else {
			return false;
		}
	}
	
	// ??? no need
	public Item getItemByName(String itemName) {
		//validate name,lowercase(???)
		Item desiredItem = itemsInStore.get(itemName);
		return desiredItem;
	}
	
	

	
	
	
	private void displayItemsInTheStore() {
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
	
	public void shopping() {
		sc = new Scanner(System.in);
		while (true) {
			displayItemsInTheStore();
			System.out.println("\nPlease enter item name: ");
			String buyingItemName = sc.nextLine().trim();
			System.out.println("Please enter quantity: ");
			int buyingQuantity = sc.nextInt();
			sc.nextLine(); // to handle enter
			//System.out.println(checkItemAvaibality(buyingItemName,buyingQuantity));
			// item key should be lower case(???) to make user friendly
			//Item buyingItem = itemsInStore.get(buyingItemName); 
			// check if item & quantity available
	
			if(checkItemAvaibality(buyingItemName,buyingQuantity)) {
				// To-do
				//****** put/add to basket****
				
				sellItemsFromStore(buyingItemName,buyingQuantity);
				
			}
			System.out.println("Continue shopping ? press y/n: ");
			String shopContinue = sc.nextLine().trim();
			if(shopContinue.toUpperCase().equalsIgnoreCase("n")) {
				System.out.println("To bill counter ===>>!");
				break;
			}
		}
		// *** to-do
		// return basket
	
	}
	
	
	
	public Map<String, Item> getItemsInStore() {
		return Collections.unmodifiableMap(itemsInStore);
	}
	
}
