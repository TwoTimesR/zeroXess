package com.zeroxess.livestockpage;

import com.zeroxess.homepage.HomePageController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LiveStockController {
    Stage liveStock;
    TableView<Animal> animalTableView;
    Scene overview;

    TextField nameCompany;
    TextField typeAnimal;
    TextField nameAnimal;
    TextField weight;
    TextField age;
    TextField price;

    public void start(Stage primaryStage) {
        liveStock = primaryStage;
        liveStock.setTitle("Livestock");



        //nameCompany colum
        TableColumn<Animal, String> nameCColumn = new TableColumn<>("Name of Company");
        nameCColumn.setCellValueFactory(new PropertyValueFactory<>("nameCompany"));


        //Type of animal colum
        TableColumn<Animal, String> typeAColumn = new TableColumn<>("Type of animal");
        typeAColumn.setCellValueFactory(new PropertyValueFactory<>("typeAnimal"));

        //name of animal colum
        TableColumn<Animal, String> nameAColumn = new TableColumn<>("name of Animal");
        nameAColumn.setCellValueFactory(new PropertyValueFactory<>("nameAnimal"));

        //weight colum
        TableColumn<Animal, Double> weightColumn = new TableColumn<>("weight of Animal");
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));

        //age colum
        TableColumn<Animal, Integer> ageColumn = new TableColumn<>("age of Animal");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        //price colum
        TableColumn<Animal, Double> priceColumn = new TableColumn<>("price of Animal");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //input nameC
        nameCompany = new TextField();
        nameCompany.setPromptText("name of company");
        nameCompany.setMinWidth(100);

        //etc
        typeAnimal = new TextField();
        typeAnimal.setPromptText("Type of animal");

        nameAnimal = new TextField();
        nameAnimal.setPromptText("Name of animal");

        weight = new TextField();
        weight.setPromptText("Weight of animal");

        age = new TextField();
        age.setPromptText("Age of animal");

        price= new TextField();
        price.setPromptText("Price of animal");


        //Button
        Button addButton = new Button("add");
        addButton.setOnAction(e -> onAddButtonCLicked());

        Button delButton = new Button("delete");
        delButton.setOnAction(e -> onDelButtonClicked());

        Button backButton = new Button("Back");
        backButton.setOnAction(e -> liveStock.setScene(//insert name of homepage scene));


        animalTableView = new TableView<>();
        animalTableView.setItems(getGraphic());
        animalTableView.getColumns().addAll(nameCColumn,typeAColumn,nameAColumn,weightColumn,ageColumn,priceColumn);



        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10,10,10,10));
        hBox1.setSpacing(10);

        hBox1.getChildren().addAll(nameCompany,typeAnimal,nameAnimal,addButton);

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10,10,10,10));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(weight,age,price,backButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(animalTableView,delButton);

        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10,10,10,10));
        grid1.setVgap(8);
        grid1.setHgap(10);
        grid1.add(vBox, 1, 0);
        grid1.add(hBox1, 1, 1);
        grid1.add(hBox2, 1, 2);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);

        grid.getChildren().addAll(grid1);

        overview = new Scene(grid,800,600);
        liveStock.setMinWidth(800);
        liveStock.setMinHeight(600);
        liveStock.setScene(overview);
        liveStock.show();

    }

    public ObservableList<Animal> getGraphic(){
        ObservableList<Animal> animals = FXCollections.observableArrayList();
        animals.add(new Animal("Project1","pig","Frank",55,4,440.69));
        return animals;
    }

    public void onAddButtonCLicked(){
        Animal animal = new Animal();
        animal.setNameCompany(nameCompany.getText());
        animal.setTypeAnimal(typeAnimal.getText());
        animal.setNameAnimal(nameAnimal.getText());
        animal.setWeight(Double.parseDouble(weight.getText()));
        animal.setAge(Integer.parseInt(age.getText()));
        animal.setPrice(Double.parseDouble(price.getText()));
        animalTableView.getItems().add(animal);
        nameCompany.clear();
        typeAnimal.clear();
        nameAnimal.clear();
        weight.clear();
        age.clear();
        price.clear();
    }

    public void onDelButtonClicked(){
        ObservableList<Animal> selected, allGraph;
        allGraph = animalTableView.getItems();
        selected = animalTableView.getSelectionModel().getSelectedItems();
        selected.forEach(allGraph::remove);

    }




}




