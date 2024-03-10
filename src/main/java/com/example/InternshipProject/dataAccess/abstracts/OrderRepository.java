package com.example.InternshipProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InternshipProject.entities.Order;


// it is important to express each class's role to implement CRUD operations.
// Since JpaRepository includes CRUD operations we don't need  to write extra codes.
@Repository 
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	
	
}










