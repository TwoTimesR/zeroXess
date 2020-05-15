package com.zeroxess;

abstract public class SellingItem {
    private Integer amountOwned;

    public SellingItem() {
        //
    }

    public Integer getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(Integer amountOwned) {
        this.amountOwned = amountOwned;
    }
}
