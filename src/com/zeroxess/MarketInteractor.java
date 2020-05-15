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
            removeToBeSoldItemFromSeller(newOrder);
            getMarket().getOrders().add(newOrder);
            System.out.println("Your order has been created and placed on the market.");
        }
        else {
            System.out.println("You don't have enough of this item to sell.");
        }
    }

    /**
     * complete transaction process between buyer and seller if an order is bought through the placed order if criteria are met
     */
    public void buyOrder(Order target) {
        if (buyerHasEnoughMoney(target) == true) {
            removeSpentMoneyFromBuyer(target);
            addBoughtItemToBuyer(target);
            addProfitToSeller(target);
            deleteOrder(target);
        }
        else {
            System.out.println("Your balance is too low to buy this order.");
        }
    }

    public void deleteOrder(Order target) {
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
    private Boolean buyerHasEnoughMoney(Order toBeBought) {
        Double currentBalance = getUser().getBalance();
        Double price = toBeBought.getPrice();
        Boolean hasEnough;
        Double significance = -0.001;
        if (currentBalance - price >= significance) {
            hasEnough = true;
        }
        else {
            hasEnough = false;
        }
        return hasEnough;
    }

    /**
     * removes sold item amount from seller
     */
    private void removeToBeSoldItemFromSeller(Order toBeCreated) {
        Integer indexOfSellingItem = toBeCreated.getSeller().getSellingItems().indexOf(toBeCreated.getSellingItem());
        Integer currentAmountOwned = toBeCreated.getSeller().getSellingItems().get(indexOfSellingItem).getAmountOwned();
        Integer amountForSale = toBeCreated.getAmountForSale();
        Integer newAmountOwned = currentAmountOwned - amountForSale;
        toBeCreated.getSeller().getSellingItems().get(indexOfSellingItem).setAmountOwned(newAmountOwned);
    }

    /**
     * adds profit to seller
     */
    private void addProfitToSeller(Order boughtOrder) {
        Double currentBalance = boughtOrder.getSeller().getBalance();
        Double profit = boughtOrder.getPrice();
        Double newBalance = currentBalance + profit;
        boughtOrder.getSeller().setBalance(newBalance);
    }

    /**
     * removes money from buyer
     */
    private void removeSpentMoneyFromBuyer(Order boughtOrder) {
        Double currentBalance = getUser().getBalance();
        Double price = boughtOrder.getPrice();
        Double newBalance = currentBalance - price;
        getUser().setBalance(newBalance);
    }

    /**
     * adds sold item amount to buyer
     */
    private void addBoughtItemToBuyer(Order boughtOrder) {
        Integer indexOfSellingItem = boughtOrder.getSeller().getSellingItems().indexOf(boughtOrder.getSellingItem());
        Integer currentAmountOwned = getUser().getSellingItems().get(indexOfSellingItem).getAmountOwned();
        Integer amountBought = boughtOrder.getAmountForSale();
        Integer newAmountOwned = currentAmountOwned + amountBought;
        getUser().getSellingItems().get(indexOfSellingItem).setAmountOwned(newAmountOwned);
    }
}
