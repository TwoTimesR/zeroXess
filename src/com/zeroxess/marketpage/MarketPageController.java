package com.zeroxess.marketpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class MarketPageController {

    @FXML
    private ListView<?> sellableItemsListView;

    @FXML
    private Label userBalanceLabel;

    @FXML
    private Label sellingStatusMessage;

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TableView<?> buyableItemsListView;

    @FXML
    private Label buyingStatusMessage;

    @FXML
    void placeOffer(ActionEvent event) {

    }

}
