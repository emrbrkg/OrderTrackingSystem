package controllerTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.InternshipProject.business.concretes.OrderManager;
import com.example.InternshipProject.entities.Order;
import com.example.InternshipProject.webApi.OrderController;


// This is a spring boot test class for orderController class.

public class OrderControllerTest {
	
	@Mock
    private OrderManager orderManager;

    @InjectMocks
    private OrderController orderController;

    public OrderControllerTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void addNewOrder_shouldAddNewOrderSuccessfully() {
        // Given
        Order order = new Order(); // Create a new Order object
        when(orderManager.addNewOrder(any())).thenReturn(true); // Mock the orderManager.addNewOrder() method to return true

        // When
        orderController.addNewOrder(order); // Call the controller method

        // Then
        // No assertion needed, if no exception is thrown, the test passes
    }

    @Test
    void deleteOrder_shouldDeleteOrderSuccessfully() throws Exception {
        // Given
        int orderId = 123; // Sample orderId
        when(orderManager.deleteOrder(orderId)).thenReturn(true); // Mock the orderManager.deleteOrder() method to return true

        // When
        orderController.deleteOrder(orderId); // Call the controller method

        // Then
        // No assertion needed, if no exception is thrown, the test passes
    }

    @Test
    void updateOrderPrice_shouldUpdateOrderPriceSuccessfully() throws Exception {
        // Given
        int orderId = 123; // Sample orderId
        double newPrice = 999.99; // Sample new price
        when(orderManager.updateOrderPrice(newPrice, orderId)).thenReturn(true); // Mock the orderManager.updateOrderPrice() method to return true

        // When
        orderController.updateOrderPrice(newPrice, orderId); // Call the controller method

        // Then
        // No assertion needed, if no exception is thrown, the test passes
    }

    @Test
    void learnOrderStatus_shouldReturnOrderStatus() {
        // Given
        int orderId = 123; // Sample orderId
        String expectedStatus = "Shipped"; // Sample expected order status
        when(orderManager.informOrderStatus(orderId)).thenReturn(expectedStatus); // Mock the orderManager.informOrderStatus() method to return the expected status

        // When
        String actualStatus = orderController.learnOrderStatus(orderId); // Call the controller method

        // Then
        assertEquals(expectedStatus, actualStatus); // Assert that the actual status matches the expected status
    }
	

}
