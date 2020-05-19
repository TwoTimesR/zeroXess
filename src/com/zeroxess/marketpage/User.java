package com.zeroxess.marketpage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class User {
    private Double balance;
    private ArrayList<SellingItem> sellingItems;
    private MarketInteractor marketInteractor;

    public User() {
        this.balance = 0.00;
        this.marketInteractor = new MarketInteractor(this);
        this.sellingItems = new ArrayList<>();
        initializeSellingItems();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public ObservableList<SellingItem> getSellingItems() {
        return FXCollections.observableArrayList(sellingItems);
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

    /**
     * sellingItems index list, can easily be expanded!
     * 0 = Sheep
     * 1 = Goat
     * 2 = Cow
     * 3 = Pig
     * 4 = Bird
     */
    private void initializeSellingItems() {
        LiveStock liveStock0 = new LiveStock("Sheep");
        addSellingItem(liveStock0);

        LiveStock liveStock1 = new LiveStock("Goat");
        addSellingItem(liveStock1);

        LiveStock liveStock2 = new LiveStock("Cow");
        addSellingItem(liveStock2);

        LiveStock liveStock3 = new LiveStock("Pig");
        addSellingItem(liveStock3);

        LiveStock liveStock4 = new LiveStock("Bird");
        addSellingItem(liveStock4);
    }
}
