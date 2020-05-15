package com.zeroxess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketTest {
    @Test
    public void baseTest() {
        User user = new User();
        MarketInteractor MarketInteractor = new MarketInteractor(user);
        Market market = new Market();

        LiveStock cow = new LiveStock();
        LiveStock sheep = new LiveStock();
        LiveStock pig = new LiveStock();

        Order order1= new Order(29.99, 2, cow, user.getID());
        Order order2= new Order(45.29, 4, sheep, user.getID());
        Order order3= new Order(11.59, 1, pig, user.getID());

        assertEquals(29.99, order1.getPrice(), 0.001);
    }
}