package com.example.InternshipProject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// This class represents an entity.
// We record the order operations by this entity.
// This class is connected to PostgreSQL. I made connection in the application properties page


@Entity
@Table(name="orders")
public class Order {
	
	// Fields of the orders table
	@Id
	private int id;    // primary key
	private String description;
	private double orderPrice;
	private int productId;	// This field is foreign key that references to product's primary key;
	private String status;
	
	// Contructors:
	public Order() {
		
	}

	public Order(String description, double orderPrice, int productId) {
		this.id = (int) Math.random();
		this.description = description;
		this.orderPrice = orderPrice;
		this.productId = productId;
		this.status = "Order  has been received";
	}

	public Order(int id, String description, double orderPrice, int productId) {
		this.id = id;
		this.description = description;
		this.orderPrice = orderPrice;
		this.productId = productId;
		this.status = "Order  has been received";
	}
	
	// Getters setters:
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) throws Exception {
		if (orderPrice >= 0)
			this.orderPrice = orderPrice;
		else
			throw new Exception("Order price can not be less than zero");
	}

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "Order{" +
					"id=" + id +
					", orderDescription= '" + description+ '\'' +
					", orderPrice= " + orderPrice + '\'' +
					", productId: " + productId + '\'' + 
					", order status: " + status +
					'}';
	}
	
}
