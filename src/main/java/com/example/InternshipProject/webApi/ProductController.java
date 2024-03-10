package com.example.InternshipProject.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.InternshipProject.business.concretes.ProductManager;
import com.example.InternshipProject.entities.Product;


// The api level for the Product and its operations:


@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductManager productManager;

	@Autowired
	public ProductController(ProductManager productManager) {
		this.productManager = productManager;
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts() {
		return productManager.getProduct();
	}
	
	@PostMapping
	@GetMapping("/addNewProduct")
	public void addNewProduct(@RequestBody Product product) {
		productManager.addNewProduct(product);
	}
	
	@PostMapping
	@GetMapping("/deleteProduct")
	public  void deleteProduct(@PathVariable int productId) throws Exception {
		productManager.deleteProduct(productId);
	}
	
	@PostMapping
	@GetMapping("/updateProductPrice")
	public void updateProductPrice(double newPrice, int productId) throws Exception {
		productManager.updateProductPrice(newPrice, productId);
	}
	
	
	// Filtering operations in api level:
	@PostMapping
	@GetMapping("/filterByCategory")
	public List<Product> filterByCategory(String category) {
		return productManager.filterByCategory(category);
	}
	
	@GetMapping("/filterByPrice")
	@PostMapping
	public List<Product> filterByPrice(double price) {
		return productManager.filterByPrice(price);
	}
	
}
