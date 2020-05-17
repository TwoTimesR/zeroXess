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
    ObservableList<SellingItem> sellingItems = FXCollections.observableArrayList();

    @FXML
    void placeOffer(ActionEvent event) {
        if (amountTextField.getText().isEmpty() || priceTextField.getText().isEmpty()) {
            Utilities.showDialog(Alert.AlertType.INFORMATION, "Error", "Please complete all the fields");
            return;
        }

        int amount = Integer.parseInt(amountTextField.getText());
        double price = Double.parseDouble(priceTextField.getText());

        sellingStatusMessage.setText("Put on offer message");
    }

    public void initialize() {
        //Test data
        User user = new User();
        user.setBalance(102.00);
        sellingItems.add(new LiveStock("test"));
        offers.add(new Order(10.49, 3, new LiveStock("test"), user));
        offers.add(new Order(11.22, 1, new LiveStock("nogiets"), user));


        //Balance tonen
        userBalanceLabel.setText(user.getBalance()+"");

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
        sellableItemsListView.setItems(sellingItems);

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

    private void buyOrder(Order order) {

        buyingStatusMessage.setText("Kopen gelukt");
        offers.remove(order);
    }

}
