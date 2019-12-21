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
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

/**
 *
 * @author andre
 */
public class Account extends GridPane {
    public ColumnConstraints columnConstraints;
    public ColumnConstraints columnConstraints0;
    public RowConstraints rowConstraints;
    public RowConstraints rowConstraints0;
    public RowConstraints rowConstraints1;
    public RowConstraints rowConstraints2;
    public RowConstraints rowConstraints3;
    public RowConstraints rowConstraints4;
    public RowConstraints rowConstraints5;
    public RowConstraints rowConstraints6;
    public RowConstraints rowConstraints7;
    public RowConstraints rowConstraints8;
    public Label label;
    public Separator separator;
    public Label label0;
    public Label label1;
    public TextField userTextField;
    public TextField passwordTextField;
    public Label label2;
    public TextField emailTextField;
    public Label label3;
    public Separator separator0;
    public Label label4;
    public Label label5;
    public Label ccNumberLabel;
    public Label balanceLabel;
    public HBox hBox;
    public Button button;
    public Button button0;
    public Label successLabel;

    public Account() {

        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        rowConstraints8 = new RowConstraints();
        label = new Label();
        separator = new Separator();
        label0 = new Label();
        label1 = new Label();
        userTextField = new TextField();
        passwordTextField = new TextField();
        label2 = new Label();
        emailTextField = new TextField();
        label3 = new Label();
        separator0 = new Separator();
        label4 = new Label();
        label5 = new Label();
        ccNumberLabel = new Label();
        balanceLabel = new Label();
        hBox = new HBox();
        button = new Button();
        button0 = new Button();
        successLabel = new Label();

        setHgap(20.0);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStylesheets().add("/views/style.css");
        setVgap(8.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        rowConstraints.setPrefHeight(5.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(30.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(30.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(30.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints8.setMinHeight(10.0);
        rowConstraints8.setPrefHeight(30.0);
        rowConstraints8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnSpan(label, 2147483647);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setText("Personal Information");
        label.setFont(new Font("System Bold", 14.0));

        GridPane.setColumnSpan(separator, 2147483647);
        separator.setPrefWidth(200.0);
        GridPane.setMargin(separator, new Insets(30.0, 0.0, 0.0, 0.0));

        GridPane.setRowIndex(label0, 1);
        label0.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label0.setText("Username:");
        label0.setPadding(new Insets(16.0, 0.0, 0.0, 0.0));

        GridPane.setColumnIndex(label1, 1);
        GridPane.setRowIndex(label1, 1);
        label1.setAlignment(javafx.geometry.Pos.BOTTOM_LEFT);
        label1.setText("Password:");
        label1.setPadding(new Insets(16.0, 0.0, 0.0, 0.0));

        GridPane.setRowIndex(userTextField, 2);
        userTextField.setStyle("-fx-background-radius: 0;");

        GridPane.setColumnIndex(passwordTextField, 1);
        GridPane.setRowIndex(passwordTextField, 2);
        passwordTextField.setStyle("-fx-background-radius: 0;");

        GridPane.setRowIndex(label2, 3);
        label2.setText("Email:");

        GridPane.setRowIndex(emailTextField, 4);
        emailTextField.setStyle("-fx-background-radius: 0;");

        GridPane.setRowIndex(label3, 5);
        label3.setText("Payment Details");
        label3.setFont(new Font("System Bold", 14.0));

        GridPane.setColumnSpan(separator0, 2147483647);
        GridPane.setRowIndex(separator0, 5);
        separator0.setPrefWidth(200.0);
        GridPane.setMargin(separator0, new Insets(30.0, 0.0, 0.0, 0.0));

        GridPane.setRowIndex(label4, 6);
        label4.setText("Credit Card Number:");

        GridPane.setRowIndex(label5, 7);
        label5.setText("Balance:");

        GridPane.setColumnIndex(ccNumberLabel, 1);
        GridPane.setRowIndex(ccNumberLabel, 6);
        ccNumberLabel.setText("Number");

        GridPane.setColumnIndex(balanceLabel, 1);
        GridPane.setRowIndex(balanceLabel, 7);
        balanceLabel.setText("Money");

        GridPane.setColumnIndex(hBox, 1);
        GridPane.setRowIndex(hBox, 4);
        hBox.setNodeOrientation(javafx.geometry.NodeOrientation.RIGHT_TO_LEFT);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(8.0);

        button.setMnemonicParsing(false);
        button.getStyleClass().add("my-button");
        button.setText("Cancel");

        button0.setMnemonicParsing(false);
        button0.getStyleClass().add("my-button");
        button0.setText("Save Changes");
        hBox.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        GridPane.setColumnIndex(successLabel, 1);
        GridPane.setRowIndex(successLabel, 3);
        successLabel.setText("Error Message");
        successLabel.setTextFill(javafx.scene.paint.Color.RED);
        successLabel.setFont(new Font("System Bold", 12.0));
        setPadding(new Insets(16.0));
        setOpaqueInsets(new Insets(0.0));

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getRowConstraints().add(rowConstraints5);
        getRowConstraints().add(rowConstraints6);
        getRowConstraints().add(rowConstraints7);
        getRowConstraints().add(rowConstraints8);
        getChildren().add(label);
        getChildren().add(separator);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(userTextField);
        getChildren().add(passwordTextField);
        getChildren().add(label2);
        getChildren().add(emailTextField);
        getChildren().add(label3);
        getChildren().add(separator0);
        getChildren().add(label4);
        getChildren().add(label5);
        getChildren().add(ccNumberLabel);
        getChildren().add(balanceLabel);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        getChildren().add(hBox);
        getChildren().add(successLabel);

    }
}
