package com.eassyshopping.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.eassyshopping.Item;
import com.eassyshopping.ShoppingCart;
import com.eassyshopping.Store;

class ShoppingCartTest {
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = 
					new ByteArrayOutputStream();

	@BeforeEach
	public void setUp() {
	    System.setOut(new PrintStream(outputStreamCaptor));
	}
	@AfterEach
	public void tearDown() {
	    System.setOut(standardOut);
	}
	
	
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
	void calculateBillWithTaxInput1() {
		theCart = new ShoppingCart("customer");
		
		Item theItem1 = new Item("Book", 12.49, false, true, 30);
		theCart.addToShoppingCart(theItem1, 1);
		
		Item theItem2 = new Item("Music cd", 14.99, false, false, 30);
		theCart.addToShoppingCart(theItem2, 1);
		
		Item theItem3 = new Item("chocolate bar", 0.85, false, true, 30);
		theCart.addToShoppingCart(theItem3, 1);
		
		theCart.calculateBillWithTax();
		String expectedString =
				"======= Receipt =======\r\n"
				+ "> 1 Book: 12.49\r\n"
				+ "> 1 Music cd: 16.49\r\n"
				+ "> 1 chocolate bar: 0.85\r\n"
				+ "> Sales Taxes: 1.50\r\n"
				+ "> Total: 29.83";
		
		assertEquals(expectedString,outputStreamCaptor.toString().trim()
			      ,"should match receipt format");
	}
	
	@Test
	@DisplayName("Calculate price with tax: INPUT-2")
	void calculateBillWithTaxInput2() {
		theCart = new ShoppingCart("customer");
		
		Item theItem1 = new Item("imported box of chocolates", 10.00, true, true, 10);
		theCart.addToShoppingCart(theItem1, 1);
		
		Item theItem2 = new Item("imported bottole of perfume", 47.50, true, false, 10);
		theCart.addToShoppingCart(theItem2, 1);
		
		
		theCart.calculateBillWithTax();
		String expectedString =
				"======= Receipt =======\r\n"
				+ "> 1 imported box of chocolates: 10.50\r\n"
				+ "> 1 imported bottole of perfume: 54.65\r\n"
				+ "> Sales Taxes: 7.65\r\n"
				+ "> Total: 65.15";
		
		assertEquals(expectedString,outputStreamCaptor.toString().trim()
			      ,"should match receipt format");
	}
	
	@Test
	@DisplayName("Calculate price with tax: INPUT-3")
	void calculateBillWithTaxInput3() {
		theCart = new ShoppingCart("customer");
		
		Item theItem1 = new Item("imported bottle of perfume", 27.99, true, false, 10);
		theCart.addToShoppingCart(theItem1, 1);
		
		Item theItem2 = new Item("bottle of perfume", 18.99, false, false, 10);
		theCart.addToShoppingCart(theItem2, 1);//chocolate bar
		
		Item theItem3 = new Item("packet of headache pills", 9.75, false, true, 10);
		theCart.addToShoppingCart(theItem3, 1);
		
		Item theItem4 = new Item("box of imported chocolates", 11.25, true, true, 10);
		theCart.addToShoppingCart(theItem4, 1);
		
		theCart.calculateBillWithTax();
		String expectedString =
				"======= Receipt =======\r\n"
				+ "> 1 imported bottle of perfume: 32.19\r\n"
				+ "> 1 bottle of perfume: 20.89\r\n"
				+ "> 1 packet of headache pills: 9.75\r\n"
				+ "> 1 box of imported chocolates: 11.85\r\n"
				+ "> Sales Taxes: 6.70\r\n"
				+ "> Total: 74.68";
		
		assertEquals(expectedString,outputStreamCaptor.toString().trim()
			      ,"should match receipt format");
	}

}
