package com.example.InternshipProject.business.requests;

import com.example.InternshipProject.business.concretes.OrderManager;
import com.example.InternshipProject.entities.Order;

// This class represents the user's canceling order operation
public class CancelOrderRequest {
	OrderManager orderManager;
	
	private Order currentOrder;
	
	public Order getOrder() {
		return currentOrder;
	}
	
	public void cancelOrder(Order currentOrder) throws Exception {
		orderManager.deleteOrder(currentOrder.getId());
	}
	
	// Update operation can be considered canceling current order and creating new order.
}
