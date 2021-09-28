package com.eassyshopping;

import static org.junit.jupiter.api.Assertions.*;




import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {
	
	private Item theItem;
	private Store theStore;
	//@Before
	//public void init() {
	////	System.out.println("at the begining..");
	//	itemsInStore = new HashMap<String, Item>();	
	//}

	@Test
	@DisplayName("addItemInStore: Method should add items to store list")
	void addItemInStore() {	
		theStore = new Store();
		theItem = new Item("Chocolate", 10, false, false, 30);
		theStore.addItemInStore(theItem);
		theItem = new Item("Chocolate", 10, false, false, 3);
		theStore.addItemInStore(theItem);
		assertEquals(1,theStore.getItemsInStore().size(),"Should match list size"
				+ " after first entry");
	}
	
	@Test
	@DisplayName("addItemInStore: Method should only update quantity if already"
			+ " there")
	void addItemInStoreAdjustQuantity() {	
		theStore = new Store();
		theItem = new Item("Chocolate", 10, false, false, 30);
		theStore.addItemInStore(theItem);
		theItem = new Item("Chocolate", 10, false, false, 3);
		theStore.addItemInStore(theItem);
		assertEquals(33,theStore.getItemsInStore().get("Chocolate").getQuantity(),"Should "
				+ "only update quantity");
	}
	
	@Test
	@DisplayName("addItemInStore: Method shouldn't add null items to store list")
	void addItemInStoreNotNull() {
		theStore = new Store();
		theItem = new Item("Chocolate", 10, false, false, 30);
		theStore.addItemInStore(theItem);
		theStore.addItemInStore(null);
		assertEquals(1,theStore.getItemsInStore().size(),"Should match list size,"
				+ "null entry shoulb be ignored");
	}
	
	@Test
	@DisplayName("getItemByName: get an item by it's name")
	void getItemByName() {
		theStore = new Store();
		theItem = new Item("Chocolate", 10, false, false, 30);
		theStore.addItemInStore(theItem);
		//theStore.sellItemsFromStore("Chocolate");
		assertEquals(theItem,theStore.getItemByName("Chocolate"),
				"Should return " + "the Chocholate item");
	}
	
	@Test
	@DisplayName("sellItemsFromStore: Sold quantity reduced")
	void sellItemsFromStore() {
		theStore = new Store();
		theItem = new Item("Chocolate", 10, false, false, 30);
		theStore.addItemInStore(theItem);
		
		int beforSell = theItem.getQuantity();
		theStore.sellItemsFromStore("Chocolate", 30);
		int afterSell = theStore.getItemsInStore().get("Chocolate").getQuantity();
		
		//theStore.sellItemsFromStore("Chocolate");
		assertEquals(0,afterSell," Should reduce from item's quantity");
	}
	
	@Test
	@DisplayName("sellItemsFromStore: Sold quantity reduced")
	void sellItemsFromStoreNotMoreThanStock() {
		theStore = new Store();
		theItem = new Item("Chocolate", 10, false, false, 30);
		theStore.addItemInStore(theItem);
		
		int beforSell = theItem.getQuantity();
		theStore.sellItemsFromStore("Chocolate", 300);
		int afterSell = theStore.getItemsInStore().get("Chocolate").getQuantity();
		
		//theStore.sellItemsFromStore("Chocolate");
		assertEquals(30,afterSell," Should reduce from item's quantity");
	}

}