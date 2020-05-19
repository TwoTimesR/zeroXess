package com.zeroxess.marketpage;

import com.zeroxess.Utilities;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class MarketPageController {

    @FXML
    private ListView<SellingItem> sellableItemsListView;

    @FXML
    private Label userBalanceLabel;

    @FXML
    private Label sellingStatusMessage;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TableView<Order> buyableItemsListView;

    @FXML
    private Label buyingStatusMessage;

    ObservableList<Order> offers = FXCollections.observableArrayList();

    // for run purposes
    static User myUser = new User();
    static {
        myUser.setBalance(102.00);

        LiveStock liveStock5 = new LiveStock("Horse");
        myUser.addSellingItem(liveStock5); // selling item horse created and added to index 5

        for (int i = 0; i < myUser.getSellingItems().size(); i++) {
            myUser.getSellingItems().get(i).setAmountOwned(3); // all selling items amount owned set to 3 (initialized with 0 in SellingItem.java)
        }
    }

    @FXML
    void placeOffer(ActionEvent event) {
        if (amountTextField.getText().isEmpty() || priceTextField.getText().isEmpty() || sellableItemsListView.getSelectionModel().getSelectedItem() == null) {
            Utilities.showDialog(Alert.AlertType.INFORMATION, "Error", "Please complete all the fields");
            return;
        }

        int amount = Integer.parseInt(amountTextField.getText());
        double price = Double.parseDouble(priceTextField.getText());
        SellingItem chosenToSell = sellableItemsListView.getSelectionModel().getSelectedItem();

        Order newOrder = new Order(price, amount, chosenToSell, myUser);
        if (sellerHasEnoughSellingItem(chosenToSell, newOrder)) {
            removeToBeSoldItemFromSeller(newOrder);
            offers.add(newOrder);
            sellingStatusMessage.setText("Your order has been created and placed on the market."); // Sell outcome 1
        }
        else {
            sellingStatusMessage.setText("You don't have enough of this item to sell."); // Sell outcome 2
        }

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
     * checks weather the seller owns enough of the amount to sell
     */
    private Boolean sellerHasEnoughSellingItem(SellingItem sellingItem, Order newOrder) {
        Integer indexOfSellingItem = myUser.getSellingItems().indexOf(sellingItem);
        Integer owns =  myUser.getSellingItems().get(indexOfSellingItem).getAmountOwned();
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

    public void initialize() {
        //Test data
        User otherUser = new User();
        otherUser.setBalance(102.00);
        offers.add(new Order(10.49, 3, new LiveStock("test"), otherUser));
        offers.add(new Order(11.22, 1, new LiveStock("nogiets"), otherUser));


        //Balance tonen
        userBalanceLabel.setText(myUser.getBalance()+"");

        //Kan alleen getallen invoeren
        Pattern pattern = Pattern.compile("\\d*"); //getal
        TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return pattern.matcher(change.getControlNewText()).matches() ? change : null;
        });
        amountTextField.setTextFormatter(formatter);

        Pattern patternGetal = Pattern.compile("\\d*|\\d+\\.\\d*"); //double
        TextFormatter formatterDouble = new TextFormatter((UnaryOperator<TextFormatter.Change>) change -> {
            return patternGetal.matcher(change.getControlNewText()).matches() ? change : null;
        });
        priceTextField.setTextFormatter(formatterDouble);

        //Zet de lijst met verkoopbare items vast aan de listview
        sellableItemsListView.setItems(myUser.getSellingItems());

        //Tabel configureren voor koopbare items
        TableColumn itemName = new TableColumn("Name");
        itemName.setPrefWidth(150);
        TableColumn amount = new TableColumn("Amount");
        TableColumn price = new TableColumn("Price");
        TableColumn colBtn = new TableColumn("Buy");
        amount.setCellValueFactory(
                new PropertyValueFactory<Order,Integer>("amountForSale")
        );
        price.setCellValueFactory(
                new PropertyValueFactory<Order,Double>("price")
        );
        itemName.setCellValueFactory(
                new PropertyValueFactory<Order,Double>("itemName")
        );


        Callback<TableColumn<Order, Void>, TableCell<Order, Void>> cellFactory = new Callback<TableColumn<Order, Void>, TableCell<Order, Void>>() {
            @Override
            public TableCell<Order, Void> call(final TableColumn<Order, Void> param) {
                final TableCell<Order, Void> cell = new TableCell<Order, Void>() {

                    private final Button btn = new Button("Buy");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Order order = getTableView().getItems().get(getIndex());
                            buyOrder(order);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        buyableItemsListView.getColumns().addAll(itemName, amount, price, colBtn);

        //Offers vastbinden aan de tabel
        buyableItemsListView.setItems(offers);


    }

    /**
     * checks weather the buyer has enough money to buy
     */
    private Boolean buyerHasEnoughBalance(Order toBeBought) {
        Double currentBalance = myUser.getBalance();
        Double price = toBeBought.getPrice();
        Boolean hasEnough;
        Double significance = -0.009;
        if (currentBalance - price >= significance) {
            hasEnough = true;
        }
        else {
            hasEnough = false;
        }
        return hasEnough;
    }


    private void buyOrder(Order target) {
        if (buyerHasEnoughBalance(target) == true) {
            removeSpentBalanceFromBuyer(target);
            addProfitToSeller(target);
            addBoughtItemToBuyer(target);
            buyingStatusMessage.setText("You have successfully bought this order"); // Buy outcome 1
            userBalanceLabel.setText(myUser.getBalance()+"");
            deleteOrder(target);
        }
        else {
            buyingStatusMessage.setText("Your balance is too low to buy this order."); // Buy outcome 2
        }
    }


    /**
     * deletes the order from the market
     */
    private void deleteOrder(Order target) {
        offers.remove(target);
    }

    /**
     * removes money from buyer
     */
    private void removeSpentBalanceFromBuyer(Order boughtOrder) {
        Double currentBalance = myUser.getBalance();
        Double price = boughtOrder.getPrice();
        Double newBalance = currentBalance - price;
        myUser.setBalance(newBalance);
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
     * adds sold item amount to buyer
     */
    private void addBoughtItemToBuyer(Order boughtOrder) {
        Integer indexOfSellingItem = boughtOrder.getSeller().getSellingItems().indexOf(boughtOrder.getSellingItem());
        Integer currentAmountOwned = myUser.getSellingItems().get(indexOfSellingItem).getAmountOwned();
        Integer amountBought = boughtOrder.getAmountForSale();
        Integer newAmountOwned = currentAmountOwned + amountBought;
        myUser.getSellingItems().get(indexOfSellingItem).setAmountOwned(newAmountOwned);
    }

}
