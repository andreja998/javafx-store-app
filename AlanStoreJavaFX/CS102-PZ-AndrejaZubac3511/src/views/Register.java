/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 *
 * @author andre
 */
public class Register extends AnchorPane {
    public ImageView imageView;
    public Label label;
    public Label label0;
    public Label label1;
    public Label label2;
    public Button button;
    public TextField registerUserName;
    public TextField registerPassword;
    public TextField registerEmail;
    public TextField registerCreditCard;
    public Label errorLabel;
    public Label label3;

    public Register() {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        button = new Button();
        registerUserName = new TextField();
        registerPassword = new TextField();
        registerEmail = new TextField();
        registerCreditCard = new TextField();
        errorLabel = new Label();
        label3 = new Label();

        setId("AnchorPane");
        setPrefHeight(320.0);
        setPrefWidth(370.0);
        setStyle("-fx-background-color: #555;");
        getStylesheets().add("/views/style.css");

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(128.0);
        imageView.setLayoutX(23.0);
        imageView.setLayoutY(14.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/images/MetBack.jpg").toExternalForm()));

        label.setLayoutX(28.0);
        label.setLayoutY(101.0);
        label.setText("Username:");
        label.setTextFill(javafx.scene.paint.Color.WHITE);

        label0.setLayoutX(28.0);
        label0.setLayoutY(136.0);
        label0.setText("Password:");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);

        label1.setLayoutX(28.0);
        label1.setLayoutY(175.0);
        label1.setText("Email:");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);

        label2.setLayoutX(28.0);
        label2.setLayoutY(213.0);
        label2.setText("Credit Card:");
        label2.setTextFill(javafx.scene.paint.Color.WHITE);

        button.setLayoutX(226.0);
        button.setLayoutY(253.0);
        button.setMnemonicParsing(false);
        button.setPrefWidth(231.0);
        button.setStyle("-fx-background-radius: 0;");
        button.getStyleClass().add("my-button");
        button.setText("Register");

        registerUserName.setLayoutX(115.0);
        registerUserName.setLayoutY(97.0);
        registerUserName.setPrefHeight(25.0);
        registerUserName.setPrefWidth(231.0);
        registerUserName.setStyle("-fx-background-radius: 0;");

        registerPassword.setLayoutX(115.0);
        registerPassword.setLayoutY(132.0);
        registerPassword.setPrefHeight(25.0);
        registerPassword.setPrefWidth(231.0);
        registerPassword.setStyle("-fx-background-radius: 0;");

        registerEmail.setLayoutX(115.0);
        registerEmail.setLayoutY(171.0);
        registerEmail.setPrefHeight(25.0);
        registerEmail.setPrefWidth(231.0);
        registerEmail.setStyle("-fx-background-radius: 0;");

        registerCreditCard.setLayoutX(115.0);
        registerCreditCard.setLayoutY(209.0);
        registerCreditCard.setPrefHeight(25.0);
        registerCreditCard.setPrefWidth(231.0);
        registerCreditCard.setStyle("-fx-background-radius: 0;");

        errorLabel.setLayoutX(29.0);
        errorLabel.setLayoutY(283.0);
        errorLabel.setTextFill(javafx.scene.paint.Color.RED);

        label3.setLayoutX(115.0);
        label3.setLayoutY(36.0);
        label3.setText("AlanStore Registration");
        label3.setTextFill(javafx.scene.paint.Color.WHITE);
        label3.setFont(new Font("System Bold", 14.0));
        setPadding(new Insets(8.0));

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(label2);
        getChildren().add(button);
        getChildren().add(registerUserName);
        getChildren().add(registerPassword);
        getChildren().add(registerEmail);
        getChildren().add(registerCreditCard);
        getChildren().add(errorLabel);
        getChildren().add(label3);
    }
}
