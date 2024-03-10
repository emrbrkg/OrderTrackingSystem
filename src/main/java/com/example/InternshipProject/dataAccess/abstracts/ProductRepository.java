package com.example.InternshipProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.InternshipProject.entities.Product;


// A repository class to interact with database for products.
// Since we extended our interface with JpaRepository we can reach CRUD operations
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	
}
