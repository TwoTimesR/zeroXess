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

    public void placeOrder(Order target) {
        //hasEnoughSellingItem incomplete
        getOrders().add(target);
    }

    public void buyOrder(Order target) {
        //hasEnoughMoney incomplete
        getOrders().remove(target);
    }

    public void removeOrder(Order target) {
        //in case the seller no longer wants to sell
        getOrders().remove(target);
    }

    private Boolean hasEnoughSellingItem(/*unsure who to put here*/) {
        //checks weather the seller has the right amount to sell
        return true;
    }

    private void removeSoldItemsFromSeller(/*unsure who to put here*/) {
        //removes selling item from seller
    }

    private void addProfitToSeller(/*unsure who to put here*/) {
        //adds money to sellers
    }

    private Boolean hasEnoughMoney(/*unsure who to put here*/) {
        //checks weather the buyer has enough money to buy
        return true;
    }

    private void removeSpentMoneyFromBuyer(/*unsure who to put here*/) {
        //removes money from buyer
    }

    private void addBoughtItemToBuyer(/*unsure who to put here*/) {
        //adds selling item to buyer
    }
}
