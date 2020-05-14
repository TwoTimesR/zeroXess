package com.zeroxess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    public void baseTest() {
        LiveStock cow = new LiveStock();
        Order order= new Order(29.99, 2, cow);

        assertEquals(29.99, order.getPrice(), 0.001);
        assertEquals(2, order.getAmountForSale());
        assertTrue(order.getSellingItem() instanceof LiveStock);
    }
}