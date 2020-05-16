package com.zeroxess;

import java.util.ArrayList;

public class User {
    private Double balance;
    private ArrayList<SellingItem> sellingItems;
    private MarketInteractor marketInteractor;

    public User() {
        this.balance = 0.00;
        this.marketInteractor = new MarketInteractor(this);
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

    public MarketInteractor getMarketInteractor() {
        return marketInteractor;
    }

    public void setMarketInteractor(MarketInteractor marketInteractor) {
        this.marketInteractor = marketInteractor;
    }
}
