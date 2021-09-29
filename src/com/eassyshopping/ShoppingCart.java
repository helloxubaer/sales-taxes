package com.eassyshopping;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * The ShoppingCart class contains items and calculate bills accordingly 
 */
public class ShoppingCart {
    private final String name;
    private final Map<Item, Integer> shoppingCart;
    
	public ShoppingCart(String name) {
		this.name = name;
		this.shoppingCart = new HashMap<Item, Integer>();
	}
	
	// add to cart method 
	public boolean addToShoppingCart(Item boughtItem,int boughtQuantity) {
		if( (boughtItem != null) && (boughtQuantity > 0)) {
			// check if already bought some
			int quantityInCart = shoppingCart.getOrDefault(boughtItem, 0);
			shoppingCart.put(boughtItem, (quantityInCart + boughtQuantity));
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	// print basket, remove later (???)
	//to-do
	//public void calculateTax() {
		//for(Map.Entry<Item, Integer> item : shoppingCart.entrySet()) {
			//System.out.println(item.getKey());
			//System.out.println("quantity: "+item.getValue());
			//System.out.println("before tax price: "
			//				+ item.getValue()*item.getKey().getPrice());
		//}
		
	//}
	
	// round up to nearest .05
	private double roundUp(double theNumber) {
		return Math.ceil(theNumber/.05)*.05;
	}
	// return 2 decimal places
	private double twoDecimalPlaces(double theNmber) {
		//String.format(java.util.Locale.US,"%.2f", theNmber)
		return Math.round(theNmber * 100.0) / 100.0;
		
	}
	//calculate cost
	public void calculatePriceWithTax() {
		System.out.println("\n ======= Receipt ======= \n");
		String receipt;
		double totalBill = 0.0;
		double totalSalesTaxes = 0.0;
		for(Map.Entry<Item, Integer> item : shoppingCart.entrySet()) {
			double priceAfterTax;
			double salesTaxes;
			double itemValue = (item.getValue()*item.getKey().getPrice());
			if(item.getKey().isExempted()) {
				salesTaxes = 0.0;
				priceAfterTax = itemValue;
			}else {
				// apply basic 10% tax. Tax rounded up to .05
				salesTaxes = roundUp(itemValue*.10);
				priceAfterTax = itemValue + salesTaxes;
			}			
			if (item.getKey().isImported()) {
				// apply import tax, no exceptions. Tax rounded up to .05
				salesTaxes = salesTaxes + roundUp(itemValue*.05);
				priceAfterTax = priceAfterTax + roundUp(itemValue*.05);
			}
			totalSalesTaxes = totalSalesTaxes + salesTaxes;
			totalBill = totalBill + priceAfterTax;		
			//<quantity> <name> at <price>
			receipt ="> " + item.getValue() + " " + item.getKey().getName();
			receipt = receipt + " at " +twoDecimalPlaces(priceAfterTax);
			System.out.println(receipt);	
		}
		System.out.println("> Sales Taxes: " + totalSalesTaxes);
		// print two decimal places
		System.out.println("> Total: " + twoDecimalPlaces(totalBill));
		
	}
	
	// no need(???)
	@Override
	public String toString() {
		
		
		return "ShoppingCart [name=" + name + ", shoppingCart=" + shoppingCart + "]";
	}

	public String getName() {
		return name;
	}

	public Map<Item, Integer> getShoppingCart() {
		return Collections.unmodifiableMap(shoppingCart);
	}
	
	
	
	

    
}
