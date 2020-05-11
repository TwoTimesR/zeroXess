package com.zeroxess;

import java.util.ArrayList;

public class LiveStock {
    private String name;
    private Integer amount;
    ArrayList<LiveStock> liveStocks = new ArrayList<>();

    public LiveStock(String name, Integer amount){
        this.name = name;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
