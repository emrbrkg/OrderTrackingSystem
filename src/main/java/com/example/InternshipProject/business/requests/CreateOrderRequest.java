package com.example.InternshipProject.business.requests;

import java.util.List;

import com.example.InternshipProject.business.concretes.OrderManager;
import com.example.InternshipProject.business.concretes.ProductManager;
import com.example.InternshipProject.entities.Order;
import com.example.InternshipProject.entities.Product;


// The classes under the business.request represents the customer's operations.

public class CreateOrderRequest {
	
	OrderManager orderManager;
	ProductManager productManager;
	
	private String productName;
	private int amount;
	
	
	
	
	public CreateOrderRequest(OrderManager orderManager, String productName, int amount) {
		this.orderManager = orderManager;
		this.productName = productName;
		this.amount = amount;
	}



	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}



	public void createOrder(String productName) {
		
		List<Product> products = productManager.getProduct();
		for (Product product : products) {
			if (product.getProductName().equals(productName)) {
				Order newOrder = new Order(product.getProductName(), product.getProductPrice(), product.getId());
				orderManager.addNewOrder(newOrder);
				break;
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
