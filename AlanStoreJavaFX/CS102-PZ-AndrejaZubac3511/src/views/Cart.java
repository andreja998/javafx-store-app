/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Product;

/**
 *
 * @author andre
 */
public class Cart extends VBox {
    public Label label;
    public Separator separator;
    public TableView<Product> cartTable;
    public TableColumn<Product, Product> coverCol;
    public TableColumn<Product, String> titleCol;
    public TableColumn<Product, Double> priceCol;
    public TableColumn<Product, Product> removeCol;
    public HBox hBox;
    public Button button;
    public Button button0;
    public Pane pane;
    public Label label0;
    public Label subtotalLabel;

    public Cart() {

        label = new Label();
        separator = new Separator();
        cartTable = new TableView();
        coverCol = new TableColumn();
        titleCol = new TableColumn();
        priceCol = new TableColumn();
        removeCol = new TableColumn();
        hBox = new HBox();
        button = new Button();
        button0 = new Button();
        pane = new Pane();
        label0 = new Label();
        subtotalLabel = new Label();

        setFillWidth(false);
        setSpacing(8.0);
        getStylesheets().add("/views/style.css");
        setPadding(new Insets(0.0, 16.0, 0.0, 16.0));

        label.setPrefWidth(610.0);
        label.setText("Your Shopping Cart:");
        label.setFont(new Font("System Bold", 14.0));
        label.setPadding(new Insets(8.0, 8.0, 0.0, 0.0));

        separator.setPrefHeight(11.0);
        separator.setPrefWidth(610.0);
        separator.setPadding(new Insets(0.0, 0.0, 8.0, 0.0));

        cartTable.setPrefHeight(300.0);
        cartTable.setPrefWidth(610.0);

        coverCol.setEditable(false);
        coverCol.setPrefWidth(110.0);
        coverCol.setResizable(false);
        coverCol.setSortable(false);
        coverCol.setStyle("-fx-alignment: center;");

        titleCol.setEditable(false);
        titleCol.setPrefWidth(240.0);
        titleCol.setResizable(false);
        titleCol.setSortable(false);
        titleCol.setStyle("-fx-alignment: center-left;");
        titleCol.setText("TITLE");

        priceCol.setEditable(false);
        priceCol.setPrefWidth(100.0);
        priceCol.setResizable(false);
        priceCol.setSortable(false);
        priceCol.setStyle("-fx-alignment: center;");
        priceCol.setText("PRICE");

        removeCol.setEditable(false);
        removeCol.setPrefWidth(150.0);
        removeCol.setResizable(false);
        removeCol.setSortable(false);
        removeCol.setText("QUANTITY");
        cartTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        hBox.setSpacing(8.0);
        hBox.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        button.setMnemonicParsing(false);
        button.getStyleClass().add("my-button");
        button.setText("Continue Shopping");

        button0.setLayoutX(18.0);
        button0.setLayoutY(18.0);
        button0.setMnemonicParsing(false);
        button0.getStyleClass().add("my-button");
        button0.setText("Checkout");

        HBox.setHgrow(pane, javafx.scene.layout.Priority.ALWAYS);
        pane.setPrefWidth(250.0);

        label0.setMaxHeight(Double.MAX_VALUE);
        label0.setMaxWidth(Double.MAX_VALUE);
        label0.setText("Subtotal:");
        label0.setFont(new Font("System Bold", 12.0));

        subtotalLabel.setMaxHeight(Double.MAX_VALUE);
        subtotalLabel.setMaxWidth(Double.MAX_VALUE);
        subtotalLabel.setText("Label");
        subtotalLabel.setFont(new Font("System Bold", 12.0));

        getChildren().add(label);
        getChildren().add(separator);
        cartTable.getColumns().add(coverCol);
        cartTable.getColumns().add(titleCol);
        cartTable.getColumns().add(priceCol);
        cartTable.getColumns().add(removeCol);
        getChildren().add(cartTable);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        hBox.getChildren().add(pane);
        hBox.getChildren().add(label0);
        hBox.getChildren().add(subtotalLabel);
        getChildren().add(hBox);

    }

}
