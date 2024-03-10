package com.example.InternshipProject.business.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.InternshipProject.dataAccess.abstracts.ProductRepository;
import com.example.InternshipProject.entities.Product;

@Service
public class ProductManager {

	private ProductRepository productRepository;

	@Autowired
	public ProductManager(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> getProduct() {
		return productRepository.findAll();
	}
	
	@PostMapping("/addNewProduct")
	public void addNewProduct(@RequestBody Product product) {
		productRepository.save(product);
	}
	
	// Checks if the product exists in the repository before deleting it.
	public void deleteProduct(int productId) throws Exception {
		if (productRepository.existsById(productId))
			productRepository.deleteById(productId);
		else {
			throw new Exception("Product you want to delete does not exist in product inventory!");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void updateProductPrice(double newPrice, int productId) throws Exception {
		Product product = productRepository.getById(productId);
		product.setProductPrice(newPrice);	
	}
	
	// Updating the product operation can be considered the deleting existing product and adding new product.
	
	
	// Filtering according to category method: 
	public List<Product> filterByCategory(String category) {
		List<Product> resultList = new ArrayList<Product>();
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			if (product.getCategory().equals(category))
				resultList.add(product);
		}
		return resultList;
		
	}
	
	// Filtering according to price method:
	public List<Product> filterByPrice(double price) {
		List<Product> resultList = new ArrayList<Product>();
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			if (product.getProductPrice() <= price)
				resultList.add(product);
		}
		return resultList;
		
	}	
	
	
	
	
	
	
}
