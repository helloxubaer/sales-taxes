package com.eassyshopping;


/*
 * The Item class specify the definition of an item in the store 
 */
public class Item {
	private String name;
	private int price;
	private boolean isImported;
	private boolean isFood;
	private int quantity;
	
	public Item(String name, int price, boolean isImported, boolean isFood,
			int quantity) {
		this.name = name;
		this.price = price;
		this.isImported = isImported;
		this.isFood = isFood; //(is exempt ??? medicine, books also
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public boolean isImported() {
		return isImported;
	}

	public boolean isFood() {
		return isFood;
	}

	public int getQuantity() {
		return quantity;
	}

	public void updateQuantity(int quantityAdded) {
		if (quantityAdded > 0) {
			this.quantity = this.quantity + quantityAdded;
		}
	}
	
	
	// will reduce this part of code(???)
	public void reduceQuantity(int quantityBought) {
		if (quantityBought > 0) {
			this.quantity = this.quantity - quantityBought;
		}	
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", isImported=" + isImported + ", isFood=" + isFood
				+ ", quantity=" + quantity + "]";
	}
	
	
	
}
