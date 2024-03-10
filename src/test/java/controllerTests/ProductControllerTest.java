package controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.InternshipProject.business.concretes.ProductManager;
import com.example.InternshipProject.entities.Product;
import com.example.InternshipProject.webApi.ProductController;
import com.fasterxml.jackson.databind.ObjectMapper;

// This is a test class for productController class.

public class ProductControllerTest {
	

    private MockMvc mockMvc;

    
    @Mock
    private ProductManager productManager;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testAddNewProduct() throws Exception {
        Product product = new Product(); // Set up your product object

        // Convert product object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String productJson = objectMapper.writeValueAsString(product);

        // Perform the POST request with the product JSON
        mockMvc.perform(post("/addNewProduct")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isOk());

        // Verify that productManager's addNewProduct method is called with the product object
        verify(productManager).addNewProduct(any(Product.class));
    }
    
    
    public ProductControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void deleteProduct_shouldDeleteSuccessfully() throws Exception {
        // Given
        int productId = 123;
        doNothing().when(productManager).deleteProduct(productId);

        // When
        ResponseEntity<Void> response = productController.deleteProduct(productId);

        // Then
        verify(productManager).deleteProduct(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    
    @Test
    void updateProductPrice_shouldUpdateSuccessfully() throws Exception {
        // Given
        double newPrice = 99.99;
        int productId = 123;

        // When
        productController.updateProductPrice(newPrice, productId);

        // Then
        verify(productManager).updateProductPrice(newPrice, productId);
    }
    
    
    @Test
    void filterByCategory_shouldReturnFilteredProducts() {
        // Given
        String category = "Electronics";
        List<Product> expectedProducts = Arrays.asList(
                new Product(1, 999.99, "Laptop", "Electronics"),
                new Product(2, 599.99, "Smartphone", "Electronics")
        );
        when(productManager.filterByCategory(category)).thenReturn(expectedProducts);

        // When
        List<Product> actualProducts = productController.filterByCategory(category);

        // Then
        assertEquals(expectedProducts, actualProducts);
    }

    @Test
    void filterByPrice_shouldReturnFilteredProducts() {
        // Given
        double price = 500.0;
        List<Product> expectedProducts = Arrays.asList(
                new Product(1, 999.99, "Laptop", "Electronics"),
                new Product(2, 599.99,  "Smartphone", "Electronics")
        );
        when(productManager.filterByPrice(price)).thenReturn(expectedProducts);

        // When
        List<Product> actualProducts = productController.filterByPrice(price);

        // Then
        assertEquals(expectedProducts, actualProducts);
    }
    
    
    
    
	
}





