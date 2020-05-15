package com.zeroxess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarketInteractorTest {

    @Test
    public void baseTest() {
        User user1 = new User(); // buyer
        User user2 = new User(); // seller
        MarketInteractor MarketInteractor = new MarketInteractor(user1);
        Market market = new Market();

        LiveStock cow = new LiveStock();
        LiveStock sheep = new LiveStock();
        LiveStock pig = new LiveStock();

        Order order1= new Order(29.99, 2, cow, user2);
        Order order2= new Order(45.29, 4, sheep, user2);
        Order order3= new Order(11.59, 1, pig, user2);

        assertEquals(29.99, order1.getPrice(), 0.001);
    }
}