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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Product;

/**
 *
 * @author andre
 */
public class Checkout extends GridPane{
    
    public ColumnConstraints columnConstraints;
    public ColumnConstraints columnConstraints0;
    public RowConstraints rowConstraints;
    public VBox vBox;
    public Label label;
    public Separator separator;
    public TableView<Product> checkoutTable;
    public TableColumn<Product, String> checkoutTitleCol;
    public TableColumn<Product, Double> checkoutPriceCol;
    public VBox vBox0;
    public Label label0;
    public Separator separator0;
    public Label label1;
    public Label label2;
    public Separator separator1;
    public HBox hBox;
    public Label label3;
    public Label checkoutCCNumber;
    public HBox hBox0;
    public Label label4;
    public Label checkoutBalance;
    public HBox hBox1;
    public Label label5;
    public Label checkoutUserName;
    public HBox hBox2;
    public Label label6;
    public Label checkoutTotal;
    public HBox hBox3;
    public Button button;

    public Checkout() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        vBox = new VBox();
        label = new Label();
        separator = new Separator();
        checkoutTable = new TableView();
        checkoutTitleCol = new TableColumn();
        checkoutPriceCol = new TableColumn();
        vBox0 = new VBox();
        label0 = new Label();
        separator0 = new Separator();
        label1 = new Label();
        label2 = new Label();
        separator1 = new Separator();
        hBox = new HBox();
        label3 = new Label();
        checkoutCCNumber = new Label();
        hBox0 = new HBox();
        label4 = new Label();
        checkoutBalance = new Label();
        hBox1 = new HBox();
        label5 = new Label();
        checkoutUserName = new Label();
        hBox2 = new HBox();
        label6 = new Label();
        checkoutTotal = new Label();
        hBox3 = new HBox();
        button = new Button();

        setHgap(16.0);
        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(700.0);
        getStylesheets().add("/views/style.css");
        setVgap(8.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setRowSpan(vBox, 2147483647);

        label.setMaxHeight(Double.MAX_VALUE);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setText("Order Summary");
        label.setFont(new Font("System Bold", 14.0));
        label.setPadding(new Insets(0.0, 0.0, 8.0, 0.0));

        separator.setPrefWidth(200.0);

        checkoutTable.setPrefHeight(270.0);

        checkoutTitleCol.setEditable(false);
        checkoutTitleCol.setPrefWidth(75.0);
        checkoutTitleCol.setText("TITLE");

        checkoutPriceCol.setEditable(false);
        checkoutPriceCol.setPrefWidth(75.0);
        checkoutPriceCol.setText("PRICE");
        checkoutTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setMargin(checkoutTable, new Insets(8.0, 0.0, 0.0, 0.0));

        GridPane.setColumnIndex(vBox0, 1);
        GridPane.setRowSpan(vBox0, 2147483647);

        label0.setMaxHeight(Double.MAX_VALUE);
        label0.setMaxWidth(Double.MAX_VALUE);
        label0.setText("Purchasing in AlanStore");
        label0.setFont(new Font("System Bold", 14.0));
        label0.setPadding(new Insets(0.0, 0.0, 8.0, 0.0));

        separator0.setPrefWidth(200.0);

        label1.setMaxHeight(Double.MAX_VALUE);
        label1.setMaxWidth(Double.MAX_VALUE);
        label1.setText("When you purchase a product from AlanStore it will automatically be added in your games library. Then you can install and play it by pressing the tile in Library.");
        label1.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        label1.setWrapText(true);
        label1.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        label2.setMaxHeight(Double.MAX_VALUE);
        label2.setMaxWidth(Double.MAX_VALUE);
        label2.setText("Your Credentials");
        label2.setFont(new Font("System Bold", 14.0));
        label2.setPadding(new Insets(0.0, 0.0, 8.0, 0.0));

        separator1.setPrefWidth(200.0);

        hBox.setSpacing(99.0);

        label3.setText("Credit Card Number:");

        checkoutCCNumber.setLayoutX(10.0);
        checkoutCCNumber.setLayoutY(10.0);
        checkoutCCNumber.setText("Number");
        hBox.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        hBox0.setLayoutX(10.0);
        hBox0.setLayoutY(139.0);
        hBox0.setSpacing(165.0);

        label4.setText("Balance:");

        checkoutBalance.setText("Money");
        hBox0.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        hBox1.setLayoutX(10.0);
        hBox1.setLayoutY(239.0);
        hBox1.setSpacing(127.0);

        label5.setText("Account Name:");

        checkoutUserName.setText("Name");
        hBox1.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        hBox2.setLayoutX(10.0);
        hBox2.setLayoutY(306.0);
        hBox2.setSpacing(181.0);

        label6.setText("Total:");

        checkoutTotal.setText("Total");
        hBox2.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        hBox3.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);

        button.setMnemonicParsing(false);
        button.getStyleClass().add("my-button");
        button.setText("Purchase");
        HBox.setMargin(button, new Insets(0.0));
        hBox3.setPadding(new Insets(8.0, 0.0, 8.0, 5.0));
        setPadding(new Insets(8.0, 16.0, 8.0, 16.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getRowConstraints().add(rowConstraints);
        vBox.getChildren().add(label);
        vBox.getChildren().add(separator);
        checkoutTable.getColumns().add(checkoutTitleCol);
        checkoutTable.getColumns().add(checkoutPriceCol);
        vBox.getChildren().add(checkoutTable);
        getChildren().add(vBox);
        vBox0.getChildren().add(label0);
        vBox0.getChildren().add(separator0);
        vBox0.getChildren().add(label1);
        vBox0.getChildren().add(label2);
        vBox0.getChildren().add(separator1);
        hBox.getChildren().add(label3);
        hBox.getChildren().add(checkoutCCNumber);
        vBox0.getChildren().add(hBox);
        hBox0.getChildren().add(label4);
        hBox0.getChildren().add(checkoutBalance);
        vBox0.getChildren().add(hBox0);
        hBox1.getChildren().add(label5);
        hBox1.getChildren().add(checkoutUserName);
        vBox0.getChildren().add(hBox1);
        hBox2.getChildren().add(label6);
        hBox2.getChildren().add(checkoutTotal);
        vBox0.getChildren().add(hBox2);
        hBox3.getChildren().add(button);
        vBox0.getChildren().add(hBox3);
        getChildren().add(vBox0);
    
    }
}