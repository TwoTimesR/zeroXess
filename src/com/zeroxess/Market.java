package com.zeroxess;

import java.util.ArrayList;

public class Market {
    private static ArrayList<Order> orders = new ArrayList<>();

    public Market() {
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static void setOrders(ArrayList<Order> orders) {
        Market.orders = orders;
    }
}
