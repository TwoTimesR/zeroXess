package com.zeroxess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarketComponentTest {
    @Test
    public void CompleteMarketTest() {
        User user0 = new User(); // seller
        User user1 = new User(); // buyer
        assertEquals(0.00, user0.getBalance(), 0.001);
        assertEquals(0.00, user1.getBalance(), 0.001);

        user0.setBalance(9.99);
        user1.setBalance(70.00);
        assertEquals(9.99, user0.getBalance(), 0.001);
        assertEquals(70.00, user1.getBalance(), 0.001);

        Market market0 = new Market();
        Market market1 = new Market();
        assertEquals(0, market0.getOrders().size());
        assertEquals(0, market1.getOrders().size());

        /*
        sellingItems index list
        0 = Sheep
        1 = Goat
        2 = Cow
        3 = Pig
        4 = Bird
        */

        user0.getSellingItems().get(0).setAmountOwned(5);
        user0.getMarketInteractor().createOrder(79.59, 6, user0.getSellingItems().get(0)); // 5 sheep, wants to sell 6, unable to place order
        assertEquals(0, market0.getOrders().size());
        assertEquals(0, market1.getOrders().size());

        user0.getSellingItems().get(0).setAmountOwned(6);
        user0.getMarketInteractor().createOrder(79.59, 6, user0.getSellingItems().get(0)); // 6 sheep, wants to sell 6, able to place order
        assertEquals(0, user0.getSellingItems().get(0).getAmountOwned()); // 6 sheep owned - 6 sheep up for sale = 0 owned sheep for seller
        assertEquals(1, market0.getOrders().size()); // all market instances share the same order list
        assertEquals(1, market1.getOrders().size());

        user1.getMarketInteractor().buyOrder(0); // has 70.00, costs 79.59, can't buy
        assertEquals(70.00 , user1.getBalance()); // balance didn't change

        user1.setBalance(79.59);
        user1.getMarketInteractor().buyOrder(0); // has exactly enough money to buy
        assertEquals(0.00, user1.getBalance(), 0.001); // 79.59 balance - 79.59 price = 0.00 balance for buyer
        assertEquals(89.58, user0.getBalance(), 0.001); // 9.99 balance + 79.59 price = 89.58 balance for seller

        assertEquals(6, user1.getSellingItems().get(0).getAmountOwned()); // buyer received 6 sheep

        assertEquals(0, market0.getOrders().size()); // all market instances changed alongside the buy-sell process
        assertEquals(0, market1.getOrders().size());
    }
}