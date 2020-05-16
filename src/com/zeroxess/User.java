package com.zeroxess;

import java.util.ArrayList;

public class User {
    private Double balance;
    private ArrayList<SellingItem> sellingItems;
    private MarketInteractor marketInteractor;

    public User() {
        this.balance = 0.00;
        this.marketInteractor = new MarketInteractor(this);
        this.sellingItems = listOfSaleableItems();
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

    private ArrayList<SellingItem> listOfSaleableItems() {
        /*
        sellingItems index list, can be expanded
        0 = Sheep
        1 = Goat
        2 = Cow
        3 = Pig
        4 = Bird
        */
        ArrayList<SellingItem> sellingItems = new ArrayList<>();

        LiveStock liveStock0 = new LiveStock("Sheep");
        sellingItems.add(liveStock0);

        LiveStock liveStock1 = new LiveStock("Goat");
        sellingItems.add(liveStock1);

        LiveStock liveStock2 = new LiveStock("Cow");
        sellingItems.add(liveStock2);

        LiveStock liveStock3 = new LiveStock("Pig");
        sellingItems.add(liveStock3);

        LiveStock liveStock4 = new LiveStock("Bird");
        sellingItems.add(liveStock4);

        return sellingItems;
    }
}
