package com.eassyshopping;

import java.util.Map;
import java.util.Scanner;

/*
 * The Main class calls Store class's method to add items in store
 * Provide the functionality to user
 */
public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static Store theFirstStore = new Store();
	
	public static void main(String[] args) {
		
        /** Manual input can be replaced with database
         *  or other sources
         */

		Item theItem = new Item("Chocolate", 10, false, false, 1);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("Chocolate", 10, false, false, 10);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("Banana", 100, false, false, 30);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("Banana", 100, false, false, 3);
		theFirstStore.addItemInStore(theItem);
		theItem = new Item("Banana", 100, false, false, 10);
		theFirstStore.addItemInStore(theItem);
		//theItem = new Item("Medicine", 20, true, false, 5);
		//theFirstStore.addItemInStore(theItem);
        
		theFirstStore.shopping();
		//theFirstStore.shopping();
		

	}

}
