/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 *
 * @author andre
 */
public class Login extends AnchorPane{
    
    public ImageView imageView;
    public Label label;
    public Label label0;
    public TextField loginUsername;
    public PasswordField loginPassword;
    public Button loginButton;
    public Hyperlink hyperlink;
    public Label errorMessage;
    public Label label1;

    public Login() {

        imageView = new ImageView();
        label = new Label();
        label0 = new Label();
        loginUsername = new TextField();
        loginPassword = new PasswordField();
        loginButton = new Button();
        hyperlink = new Hyperlink();
        errorMessage = new Label();
        label1 = new Label();

        setId("AnchorPane");
        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        setPrefHeight(320.0);
        setPrefWidth(370.0);
        setStyle("-fx-background-color: #555;");
        getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        imageView.setFitHeight(64.0);
        imageView.setFitWidth(128.0);
        imageView.setLayoutX(31.0);
        imageView.setLayoutY(16.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/images/MetBack.jpg").toExternalForm()));

        label.setLayoutX(35.0);
        label.setLayoutY(115.0);
        label.setText("Username:");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 12.0));

        label0.setLayoutX(34.0);
        label0.setLayoutY(148.0);
        label0.setText("Password:");
        label0.setTextFill(javafx.scene.paint.Color.WHITE);
        label0.setFont(new Font("System Bold", 12.0));

        loginUsername.setLayoutX(119.0);
        loginUsername.setLayoutY(111.0);
        loginUsername.setPrefHeight(25.0);
        loginUsername.setPrefWidth(215.0);
        loginUsername.setStyle("-fx-background-radius: 0;");

        loginPassword.setLayoutX(119.0);
        loginPassword.setLayoutY(144.0);
        loginPassword.setPrefHeight(25.0);
        loginPassword.setPrefWidth(215.0);
        loginPassword.setStyle("-fx-background-radius: 0;");

        loginButton.setLayoutX(214.0);
        loginButton.setLayoutY(177.0);
        loginButton.setMnemonicParsing(false);
        loginButton.getStyleClass().add("my-button");
        loginButton.setText("Login");

        hyperlink.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hyperlink.setLayoutX(119.0);
        hyperlink.setLayoutY(213.0);
        hyperlink.setPrefHeight(23.0);
        hyperlink.setPrefWidth(215.0);
        hyperlink.setText("Create a new account for free");
        hyperlink.setTextFill(javafx.scene.paint.Color.WHITE);
        hyperlink.setFont(new Font("System Bold", 12.0));

        errorMessage.setLayoutX(35.0);
        errorMessage.setLayoutY(264.0);
        errorMessage.setText("Error ");
        errorMessage.setTextFill(javafx.scene.paint.Color.RED);

        label1.setLayoutX(170.0);
        label1.setLayoutY(38.0);
        label1.setText("AlanStore Login");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 14.0));
        setPadding(new Insets(8.0));

        getChildren().add(imageView);
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(loginUsername);
        getChildren().add(loginPassword);
        getChildren().add(loginButton);
        getChildren().add(hyperlink);
        getChildren().add(errorMessage);
        getChildren().add(label1);

    }
}