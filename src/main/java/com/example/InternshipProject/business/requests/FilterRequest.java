package com.example.InternshipProject.business.requests;

import java.util.List;

import com.example.InternshipProject.business.concretes.ProductManager;
import com.example.InternshipProject.entities.Product;

// This class handles the filtering operations
// Interacts with the ProductManager class
public class FilterRequest {

	ProductManager productManager;
	
	private String category;
	private double price;
	
	
	public String getCategory() {
		return category;
	}
	public double getPrice() {
		return price;
	}
	
	public List<Product> filterByCategory(String category) {
		return productManager.filterByCategory(category);
	}
	
	public List<Product> filterByPrice(double price) {
		return productManager.filterByPrice(price);
	}
	
	

}
