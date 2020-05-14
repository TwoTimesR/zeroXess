package com.zeroxess;

import java.util.ArrayList;

public class Order {
    private Double price;
    private Integer amountForSale;
    private SellingItem sellingItem;
    /*
    the buy price on the order
    the amount of items being sold
    what type of item is being sold
    */

    public Order(Double price, Integer amountForSale, SellingItem sellingItem) {
        this.price = price;
        this.amountForSale = amountForSale;
        this.sellingItem = sellingItem;
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
}
