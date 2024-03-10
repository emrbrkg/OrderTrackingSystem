package com.example.InternshipProject.business.requests;

import com.example.InternshipProject.business.concretes.OrderManager;

// This class is to handle customer's learning his/her order status

public class LearnOrderStatus {

	OrderManager orderManager;
	
	public String learnOrderStatus(int orderId) {
		return orderManager.informOrderStatus(orderId);
		
	}
}
