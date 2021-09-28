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
	// calculate cost calculation
	//to-do

	
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
