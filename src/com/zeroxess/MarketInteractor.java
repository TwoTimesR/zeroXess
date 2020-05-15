package com.zeroxess;

public class MarketInteractor {
    private User user;
    private static Market market = new Market();

    public MarketInteractor(User user) {
        this.user = user;
    }

    public static Market getMarket() {
        return market;
    }

    public static void setMarket(Market market) {
        MarketInteractor.market = market;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * user creates and places a newly made order on the market if criteria are met
     */
    public void createOrder(Double price, Integer amountForSale, SellingItem sellingItem) {
        Order newOrder = new Order(price, amountForSale, sellingItem, getUser());
        if (sellerHasEnoughSellingItem(sellingItem, newOrder) == true) {
            getMarket().getOrders().add(newOrder);
            System.out.println("Your order has been placed on the market.");
        }
        else {
            System.out.println("You don't have enough of this item to sell.");
        }
    }

    /**
     * complete transaction process between buyer and seller if an order is bought through the placed order if criteria are met
     */
    public void buyOrder(Order target) {
        /* complete the following methods
        hasEnoughMoney
        removeSpentMoneyFromBuyer
        removeSoldItemsFromSeller
        addProfitToSeller
        addBoughtItemToBuyer
        */
        getMarket().getOrders().remove(target);
    }

    public void removeOrder(Order target) {
        getMarket().getOrders().remove(target);
    }

    /**
     * checks weather the seller owns enough of the amount to sell
     */
    private Boolean sellerHasEnoughSellingItem(SellingItem sellingItem, Order newOrder) {
        Integer owns = sellingItem.getAmountOwned();
        Integer toBeSold = newOrder.getAmountForSale();
        Boolean hasEnough;
        if (owns >= toBeSold) {
            hasEnough = true;
        }
        else {
            hasEnough = false;
        }
        return hasEnough;
    }

    /**
     * checks weather the buyer has enough money to buy
     */
    private Boolean BuyerHasEnoughMoney() {
        //getUser()
        return true;
    }

    /**
     * removes sold item amount from seller
     */
    private void removeSoldItemsFromSeller(Order boughtOrder) {
        //
    }

    /**
     * adds profit to seller
     */
    private void addProfitToSeller(Order boughtOrder) {
        //
    }

    /**
     * removes money from buyer
     */
    private void removeSpentMoneyFromBuyer() {
        //getUser()
    }

    /**
     * adds sold item amount to buyer
     */
    private void addBoughtItemToBuyer() {
        //getUser()
    }
}
