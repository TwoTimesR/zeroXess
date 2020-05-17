package com.zeroxess.marketpage;

abstract public class SellingItem {
    private String itemName;
    private Integer amountOwned;

    public SellingItem(String itemName) {
        this.itemName = itemName;
        this.amountOwned = 0;
    }

    public Integer getAmountOwned() {
        return amountOwned;
    }

    public void setAmountOwned(Integer amountOwned) {
        this.amountOwned = amountOwned;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }
}
