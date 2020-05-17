package com.zeroxess;

import java.util.ArrayList;

public class Order {
    private Double price;
    private Integer amountForSale;
    private SellingItem sellingItem;
    private User seller;
    /**
     * the buy price on the order
     * the amount of items being sold
     * what item is being sold
     * the person who is selling the item
     */

    public Order(Double price, Integer amountForSale, SellingItem sellingItem, User seller) {
        this.price = price;
        this.amountForSale = amountForSale;
        this.sellingItem = sellingItem;
        this.seller = seller;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmountForSale() {
        return amountForSale;
    }

    public void setAmountForSale(Integer amount) {
        this.amountForSale = amount;
    }

    public SellingItem getSellingItem() {
        return sellingItem;
    }

    public void setSellingItem(SellingItem sellingItem) {
        this.sellingItem = sellingItem;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
}
