package com.zeroxess;

public class Order {
    private Double price;
    // animal type
    // amount of animals

    public Order(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
