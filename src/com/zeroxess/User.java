package com.zeroxess;

import java.util.ArrayList;

public class User {
    private Double money;
    private ArrayList<SellingItem> sellingItems;

    public User() {
        this.money = 0.00;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
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
