package com.eassyshopping.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
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
	
	@Test
	@DisplayName("Calculate price with tax: INPUT-1")
	void calculatePriceWithTax() {
		theCart = new ShoppingCart("customer");
		
		Item theItem1 = new Item("book", 12.49, false, true, 30);//1 music CD
		theCart.addToShoppingCart(theItem1, 1);
		
		Item theItem2 = new Item("music CD", 14.99, false, true, 30);
		theCart.addToShoppingCart(theItem2, 1);//chocolate bar
		
		Item theItem3 = new Item("chocolate bar", 0.85, false, false, 30);
		theCart.addToShoppingCart(theItem3, 1);//
		
		theCart.calculatePriceWithTax();
		
		assertEquals("x",1,"should "
				+ "return price with tax");
	}

}
