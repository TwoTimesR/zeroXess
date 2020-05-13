package com.zeroxess;

public class Order {
    private Double price;
    private Integer amount;
    private LiveStock animal;
    /*
    the buy price on the order
    the amount of animals being sold
    what type of animal is being sold
    */

    public Order(Double price, Integer amount, LiveStock animal) {
        this.price = price;
        this.amount = amount;
        this.animal = animal;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LiveStock getAnimal() {
        return animal;
    }

    public void setAnimal(LiveStock animal) {
        this.animal = animal;
    }

    private boolean hasEnoughLiveStock() {
        /*
        checks weather the seller has the right amount to sell
        e.g. cant sell 10 chickens if you only have 3
        */
        return true;
    }
}
