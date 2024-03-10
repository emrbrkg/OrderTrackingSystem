package com.example.InternshipProject.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.InternshipProject.dataAccess.abstracts.OrderRepository;
import com.example.InternshipProject.dataAccess.abstracts.ProductRepository;
import com.example.InternshipProject.entities.Order;
import com.example.InternshipProject.entities.Product;


// Here is the business layer. 
// We declare business rules here. 
// We interact databases via repositories.
// if we implement a business interface then we need to create interface in the business.abstracts package and we will implement it in this class.

@Service
public class OrderManager {
	private Product productInOrder;
	private LocalDate orderDate;
	private LocalDate today = LocalDate.now();
	
	
	// Getters setters:
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getToday() {
		return today;
	}
	public void setToday(LocalDate today) {
		this.today = today;
	}

	public Product getProductInOrder() {
		return productInOrder;
	}
	
	// We have layered structure and in order to interact with bottom layer which is data access layer, we create instances of repositories.
	// Also we need to interact with productManager class (Another business layer class) we create an instance of it.
	private OrderRepository orderRepository;
	ProductManager productManager;
	ProductRepository productRepository;

	@Autowired
	public OrderManager(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	// in my project's business rules customer can have one product in an order. So we check their ids and if the product exists in the repository.
	// Then we make repository update operations.
	public void addNewOrder(Order order) {
		if (productInOrder.getId() == order.getProductId() && productRepository.existsById(productInOrder.getId())) {
			// in here payment operations are supposed to be checked firstly if it is okay then we will update repositories.
			orderRepository.save(order);
			productRepository.delete(productInOrder); 
			orderDate = LocalDate.now();
		}
	}
	
	// An order can be deleted if it exists in the order repository.
	public void deleteOrder(int orderId) throws Exception {
		
		if (orderRepository.existsById(orderId)) {
			orderRepository.deleteById(orderId);
			productManager.addNewProduct(productInOrder);;
		}
		else
			throw new Exception("Order you want to delete does not exist in Order repository!");
	}
	
	// Updating order price operation:
	public void updateOrderPrice(double newPrice, int orderId) throws Exception {
		Order order = orderRepository.getById(orderId);
		order.setOrderPrice(newPrice);
		
	}
	
	// in this project's business rule an order will be shipped on the third day after order recieved.
	// And the order will be delivered to the customer on the fifth day after order recieved.
	// We check this rules and updating the status accordingly.
	public String updateOrderStatus(int orderId, LocalDate today, LocalDate orderDate) {
		Order order = orderRepository.getById(orderId);
		if (today.getDayOfMonth() <= orderDate.getDayOfMonth() + 3) {
			int remainedDays = orderDate.getDayOfMonth() + 5 - today.getDayOfMonth();
			String status = "Order is on the way. Your order will be delivered to you in %d "+remainedDays;
			order.setStatus(status);
		} else if (today.getDayOfMonth() <= orderDate.getDayOfMonth() + 5) {
			int remainedDays = orderDate.getDayOfMonth() + 5 - today.getDayOfMonth();
			String status = "Order is on the way. Your order will be delivered to you in %d "+remainedDays;
			order.setStatus(status);
			
		}
		else {
			order.setStatus("Order has been delivered.");
		}
		return order.getStatus();
		
		
	}
	
	// When the customer wants to learn his/her orders status this method will be executed.
	public String informOrderStatus(int orderId) {
		Order order = orderRepository.getById(orderId);
		return updateOrderStatus(orderId, today, orderDate);
		
	}
	
	
	// Updating the whole order operation can be considered the deleting existing order and adding new order.
	
}









