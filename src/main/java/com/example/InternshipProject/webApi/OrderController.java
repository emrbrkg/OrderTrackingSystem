package com.example.InternshipProject.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternshipProject.business.concretes.OrderManager;
import com.example.InternshipProject.entities.Order;


// This is a Rest api class. The top layer.
// This layer can interact with business layer via OrderManager class.
// We don't interact with the data access layer directly. This is not something we want in an layered architecture system.


// RestController represents the level that will interact with the api.
@RestController
@RequestMapping(path = "/api/orders")
public class OrderController {
	private OrderManager orderManager;

	@Autowired
	public OrderController(OrderManager orderManager) {
		this.orderManager = orderManager;
	}
	
	public List<Order> getOrders() {
		return orderManager.getOrders();
	}
	
	@PostMapping
	@GetMapping("/addNewOrder")
	public void addNewOrder(@RequestBody Order order) {
		orderManager.addNewOrder(order);
	}
	
	@PostMapping
	@GetMapping("/deleteNewOrder")
	public  void deleteOrder(@PathVariable int orderId) throws Exception {
		orderManager.deleteOrder(orderId);
	}
	
	@PostMapping
	@GetMapping("/updateOrderPrice")
	public void updateOrderPrice(double newPrice, int orderId) throws Exception {
		orderManager.updateOrderPrice(newPrice, orderId);
	}
	
	@PostMapping
	@GetMapping("/learnOrderStatus")
	public String learnOrderStatus(int orderId) {
		return orderManager.informOrderStatus(orderId);
	}
	
}
