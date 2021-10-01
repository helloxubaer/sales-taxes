package com.eassyshopping;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * The ShoppingCart class contains items and calculate bills accordingly 
 */
public class ShoppingCart {
    private final String name;
    private final Map<Item, Integer> itemsInCart;
    
	public ShoppingCart(String name) {
		this.name = name;
		this.itemsInCart = new LinkedHashMap<>();
	}
	
	// add to cart method 
	public boolean addToShoppingCart(Item boughtItem,int boughtQuantity) {
		if( (boughtItem != null) && (boughtQuantity > 0)) {
			// check if already bought some
			int quantityInCart = itemsInCart.getOrDefault(boughtItem, 0);
			itemsInCart.put(boughtItem, (quantityInCart + boughtQuantity));
			return true;
		}
		else {
			return false;
		}	
	}
	
	// round up to nearest .05
	private double roundUp(double theNumber) {
		return Math.ceil(theNumber/.05)*.05;
	}
	
	// return 2 decimal places
	private String twoDecimalPlaces(double theNmber) {
		return String.format(java.util.Locale.US,"%.2f", theNmber);	
		
	}
	
	//calculate cost and print receipt
	public void calculateAndPayBillWithTax() {
		System.out.println("\n======= Receipt =======");
		double totalBill = 0.0;
		double totalSalesTaxes = 0.0;
		for(Map.Entry<Item, Integer> item : itemsInCart.entrySet()) {
			StringBuilder receipt = new StringBuilder();
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
			receipt.append("> " + item.getValue() + " " + item.getKey().getName());
			receipt.append(": " +twoDecimalPlaces(priceAfterTax));
			System.out.println(receipt);	
		}
		
		System.out.println("> Sales Taxes: " + twoDecimalPlaces(totalSalesTaxes));
		// print two decimal places
		System.out.println("> Total: " + twoDecimalPlaces(totalBill));	
	}
	
	public String getName() {
		return name;
	}

	public Map<Item, Integer> getShoppingCart() {
		return Collections.unmodifiableMap(itemsInCart);
	}
	
	
	
	

    
}
