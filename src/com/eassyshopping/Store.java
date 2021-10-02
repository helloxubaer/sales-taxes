package com.eassyshopping;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * The Store class contains items in store, and keeps track of available stock 
 */
public class Store {

	private final Map<String, Item> itemsInStore;
	private Scanner sc;

	public Store() {
		this.itemsInStore = new LinkedHashMap<>();
	}
	
	// add item to a store by store manager
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
			itemsInStore.put(theItem.getName().toLowerCase(), theItem);
			return true;
		}else {
			return false;
		}		
	}
	
	// display available items in store
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

	// verify item name provided by user
	public boolean verifyItemName(String itemName) {
		Item checkingItem = itemsInStore.get(itemName);
		return(checkingItem != null);		
	}
		
	// get item name, check if it is in store
	private String getItemNameFromUser() {
		while(true) {
			String theName = sc.nextLine().trim().toLowerCase();
			if(!verifyItemName(theName)) {
				System.out.println("invalid name! Enter again: ");
			}else {
				return theName;
			}
		}
	}
	
	//get available quantity
	public int getQuantity(String itemName) {
		Item checkingItem = itemsInStore.get(itemName);
		return checkingItem.getQuantity();	
	}
	
	// get valid quantity from user
	private int getQuantityFromUser(String itemName) {
		int inputQuantity;
		int counter = 0;
		do {
			if(counter == 0) {
				System.out.println("Please enter quantity: ");
				counter++;
			}else {
				System.out.println(
						 "Invalid!"
						+"Max available quantity: "
						+ itemsInStore.get(itemName).getQuantity());
				System.out.println("Enter again: ");	
			}
			
			while(!sc.hasNextInt()) {
				System.out.println("Please enter an integer!");
				sc.nextLine();
			}
			inputQuantity = sc.nextInt();
			sc.nextLine();
		}while(inputQuantity > getQuantity(itemName) || inputQuantity<0 );
		
		return inputQuantity;
	}
		
	// reduce sold quantity from available store
	public void sellItemsFromStore(String itemName, int desiredQuntity) {
		Item sellingItem = itemsInStore.get(itemName);
		sellingItem.reduceQuantity(desiredQuntity);
	}
	
	// continue shopping? take user input
	public boolean isShoppingContinue() {
		while(true) {
			System.out.println("Continue shopping ? press y/n: ");
			String theName = sc.nextLine().trim();
			if(theName.equalsIgnoreCase("n")) {
				return false;
			}else if(theName.equalsIgnoreCase("y")) {
				return true;
			}
		}
	}
		
	// if item available, add to cart>>> print calculated receipt
	public void shopping(ShoppingCart theCart) {
		sc = new Scanner(System.in);
		while (true) {
			displayItemsInTheStore();
			
			System.out.println("\nPlease enter item name: ");
			String buyingItemName = getItemNameFromUser().trim();
			int buyingQuantity = getQuantityFromUser(buyingItemName);
			
			Item buyingtItem = itemsInStore.get(buyingItemName); // fetch item
			theCart.addToShoppingCart(buyingtItem, buyingQuantity);
			sellItemsFromStore(buyingItemName,buyingQuantity);			
			
			if(!isShoppingContinue()) {
				break;
			}
		}
		sc.close();
	}
		
	public Map<String, Item> getItemsInStore() {
		return Collections.unmodifiableMap(itemsInStore);
	}	
}