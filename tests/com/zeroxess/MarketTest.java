package com.zeroxess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketTest {
    @Test
    public void baseTest() {
        LiveStock cow = new LiveStock();
        LiveStock sheep = new LiveStock();
        LiveStock pig = new LiveStock();

        Order order1= new Order(29.99, 2, cow);
        Order order2= new Order(45.29, 4, sheep);
        Order order3= new Order(11.59, 1, pig);

        Market market = new Market();
        market.addOrder(order1); // index 0
        market.addOrder(order2); // index 1
        market.addOrder(order3); // index 2

        assertEquals(3, market.getOrders().size());
    }
}