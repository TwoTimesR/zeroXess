package com.zeroxess;

import java.util.ArrayList;

public class User {
    private Double balance;
    private ArrayList<SellingItem> sellingItems;

    public User() {
        this.balance = 0.00;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ArrayList<SellingItem> getSellingItems() {
        return sellingItems;
    }

    public void setSellingItems(ArrayList<SellingItem> sellingItems) {
        this.sellingItems = sellingItems;
    }

    public void addSellingItem(SellingItem target) {
        sellingItems.add(target);
    }

    public void removeSellingItem(SellingItem target) {
        sellingItems.remove(target);
    }
}
