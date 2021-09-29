package com.eassyshopping;


/*
 * The Item class specify the definition of an item in the store 
 */
public class Item {
	private String name;
	private double price;
	private boolean isImported;
	private boolean isExempted;
	private int quantity;
	
	public Item(String name, double price, boolean isImported, boolean isExempted,
			int quantity) {
		this.name = name;
		this.price = price;
		this.isImported = isImported;
		this.isExempted = isExempted; //(is exempt ??? medicine, books also
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean isImported() {
		return isImported;
	}

	public boolean isExempted() {
		return isExempted;
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
		return "Item [name=" + name + ", price=" + price + ", isImported=" + 
				isImported + ", isExempted=" + isExempted
				+ ", quantity=" + quantity + "]";
	}
	
	
	
}
