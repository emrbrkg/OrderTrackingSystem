package com.example.InternshipProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// This class represents another entity which we store products.

@Entity
@Table(name="products")
@Data
public class Product {
	@Id
	private int id;
	private double productPrice;
	private String category;
	private String productName;	
	
	// Constructors: 
	public Product(int id, double productPrice, String category, String productName) {
		super();
		this.id = id;
		this.productPrice = productPrice;
		this.category = category;
		this.productName = productName;
	}
	public Product() {
		
	}
	
	// Getters setter:
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public double getProductPrice() {
		return productPrice;
	}
	// We should not allow to set price to a negative price.
	public void setProductPrice(double productPrice) throws Exception {
		if (productPrice >= 0)
			this.productPrice = productPrice;
		else
			throw new Exception("Product price can not be less than zero");
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}



	@Override
	public String toString() {
		return "Product id: " + id +
		'\'' + "Product price: " + productPrice +
		'\'' + "Product category: " + category +
		'\'' +"Product name: " + productName;
	}

}
