package com.zeroxess;

import java.util.ArrayList;

public class Market {
    private ArrayList<Order> orders = new ArrayList<>();

    public Market() {
        //purely exists out of orders
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public void buyOrder(Order target) {
        //hasEnoughMoney incomplete
        getOrders().remove(target);
    }

    public void placeOrder(Order target) {
        //hasEnoughSellingItem incomplete
        getOrders().add(target);
    }

    public void removeOrder(Order target) {
        //in case the seller no longer wants to sell
        getOrders().remove(target);
    }

    private Boolean hasEnoughSellingItem(/*unsure who to put here*/) {
        /*
        checks weather the seller has the right amount to sell
        e.g. cant sell 10 items if you only have 3
        */
        return true;
    }

    private Boolean hasEnoughMoney(/*unsure who to put here*/) {
        /*
        checks weather the buyer has enough money to buy
        e.g. cant buy an order of 69.99 if you only have 30.00
        */
        return true;
    }
}
