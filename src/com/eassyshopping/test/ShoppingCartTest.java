package com.eassyshopping.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.eassyshopping.Item;
import com.eassyshopping.ShoppingCart;
import com.eassyshopping.Store;

class ShoppingCartTest {
	private Item theItem;
	private Store theStore;
	private ShoppingCart theCart;
	
	
	@Test
	void addToShoppingCart() {
		theCart = new ShoppingCart("customer");
		theItem = new Item("Chocolate", 10, false, false, 30);
		theCart.addToShoppingCart(theItem, 10);
		
		//theItem = new Item("Chocolate", 10, false, false, 30);
		theCart.addToShoppingCart(theItem, 25);
		
		theCart.getShoppingCart().get(theItem);	
		assertEquals(35,theCart.getShoppingCart().get(theItem),"should "
				+ "return item quantity in basket");
	}

}
