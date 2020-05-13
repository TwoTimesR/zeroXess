package com.zeroxess;

import java.util.ArrayList;

public class Market {
    private ArrayList<Order> orders = new ArrayList<>();

    public Market() {
        /*
        purely exists out of orders
        */
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void addOrder(Order target) {
        getOrders().add(target);
    }

    public void removeOrder(Order target) {
        getOrders().remove(target);
    }
}
