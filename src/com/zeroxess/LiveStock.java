package com.zeroxess;

import java.util.ArrayList;

public class LiveStock {
    private Integer amount;
    ArrayList<LiveStock> liveStocks = new ArrayList<>();

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
