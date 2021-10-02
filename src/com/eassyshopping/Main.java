package com.eassyshopping;
/*
 * The Main class calls Store class's method to add items in store
 * Provide the functionality to user
 */
public class Main {

	// ## Create a store object ## //
	private static Store theFirstStore = new Store();
	// ## Create a shopping cart for a customer ## //
	private static ShoppingCart firstCustomer = new ShoppingCart("first Customer");
	
	public static void main(String[] args) {

//============================================================================//
        /** Adding item in store manually can be replaced with database
         *  or other static sources
         */
		//Item(String name, double price, boolean isImported, 
		//boolean isExempted, int quantity)

		Item theItem = new Item("Book", 12.49, false, true, 10);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("Music cd", 14.99, false, false, 10);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("chocolate bar", .85, false, true, 10);
		theFirstStore.addItemInStore(theItem);
		
		
		theItem = new Item("imported box of chocolates", 10.00, true, true, 10);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("imported bottle of perfume", 47.50, true, false, 10);
		theFirstStore.addItemInStore(theItem);
		
		theItem = new Item("Another imported bottle of perfume", 27.99, true, false, 10);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("bottle of perfume", 18.99, false, false, 10);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("packet of headache pills", 9.75, false, true, 10);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("box of imported chocolates", 11.25, true, true, 10);
		theFirstStore.addItemInStore(theItem);
//============================================================================//		
	
		theFirstStore.shopping(firstCustomer); //start shopping for 'firstCustomer'
		firstCustomer.calculateAndPayBillWithTax(); // 'firstCustomer'
	
	}	
}
