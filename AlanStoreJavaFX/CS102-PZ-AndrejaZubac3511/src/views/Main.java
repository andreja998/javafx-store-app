/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import models.Product;

/**
 *
 * @author andre
 */
public class Main extends BorderPane{
    public VBox vBox;
    public Hyperlink hyperlink;
    public ImageView imageView;
    public Hyperlink hyperlink0;
    public ImageView imageView0;
    public Hyperlink hyperlink1;
    public ImageView imageView1;
    public Hyperlink cartButton;
    public ImageView imageView2;
    public VBox gamesVBox;
    public ListView<Product> gamesListView;
    public Label label;
    public Separator separator;
    public HBox hBox;
    public Label descriptionLabel;
    public ImageView coverImageView;
    public Separator separator0;
    public HBox hBox0;
    public Label label0;
    public Hyperlink videoHyperlink;
    public HBox hBox1;
    public Button addToCartButton;
    public VBox imagesVBox;
    public ImageView firstImageView;
    public ImageView secondImageView;
    public ImageView thirdImageView;
    public ImageView fourthImageView;
    public HBox hBox2;
    public ImageView imageView3;
    public Label label1;
    public Region region;
    public Button button;
    public Button button0;

    public Main() {

        vBox = new VBox();
        hyperlink = new Hyperlink();
        imageView = new ImageView();
        hyperlink0 = new Hyperlink();
        imageView0 = new ImageView();
        hyperlink1 = new Hyperlink();
        imageView1 = new ImageView();
        cartButton = new Hyperlink();
        imageView2 = new ImageView();
        gamesVBox = new VBox();
        gamesListView = new ListView();
        label = new Label();
        separator = new Separator();
        hBox = new HBox();
        descriptionLabel = new Label();
        coverImageView = new ImageView();
        separator0 = new Separator();
        hBox0 = new HBox();
        label0 = new Label();
        videoHyperlink = new Hyperlink();
        hBox1 = new HBox();
        addToCartButton = new Button();
        imagesVBox = new VBox();
        firstImageView = new ImageView();
        secondImageView = new ImageView();
        thirdImageView = new ImageView();
        fourthImageView = new ImageView();
        hBox2 = new HBox();
        imageView3 = new ImageView();
        label1 = new Label();
        region = new Region();
        button = new Button();
        button0 = new Button();

        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setStyle("-fx-background-color: #eee;");
        getStylesheets().add("/views/style.css");

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.TOP_CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefWidth(120.0);
        vBox.setSpacing(2.0);
        vBox.setStyle("-fx-background-color: #666;");

        hyperlink.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hyperlink.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        hyperlink.setMaxWidth(Double.MAX_VALUE);
        hyperlink.getStyleClass().add("navigation-hyperlink");
        hyperlink.getStylesheets().add("/views/style.css");
        hyperlink.setText("Store");
        hyperlink.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        hyperlink.setTextFill(javafx.scene.paint.Color.WHITE);
        hyperlink.setPadding(new Insets(8.0));

        imageView.setFitHeight(48.0);
        imageView.setFitWidth(48.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/images/icons/ic_store_white_48dp_2x.png").toExternalForm()));
        hyperlink.setGraphic(imageView);
        hyperlink.setCursor(Cursor.DEFAULT);

        hyperlink0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hyperlink0.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        hyperlink0.setLayoutX(10.0);
        hyperlink0.setLayoutY(10.0);
        hyperlink0.setMaxWidth(Double.MAX_VALUE);
        hyperlink0.getStyleClass().add("navigation-hyperlink");
        hyperlink0.getStylesheets().add("/views/style.css");
        hyperlink0.setText("Library");
        hyperlink0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        hyperlink0.setTextFill(javafx.scene.paint.Color.WHITE);
        hyperlink0.setPadding(new Insets(8.0));

        imageView0.setFitHeight(48.0);
        imageView0.setFitWidth(48.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/resources/images/icons/ic_video_library_white_48dp_2x.png").toExternalForm()));
        hyperlink0.setGraphic(imageView0);
        hyperlink0.setCursor(Cursor.DEFAULT);

        hyperlink1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        hyperlink1.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        hyperlink1.setLayoutX(10.0);
        hyperlink1.setLayoutY(33.0);
        hyperlink1.setMaxWidth(Double.MAX_VALUE);
        hyperlink1.getStyleClass().add("navigation-hyperlink");
        hyperlink1.getStylesheets().add("/views/style.css");
        hyperlink1.setText("Account");
        hyperlink1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        hyperlink1.setTextFill(javafx.scene.paint.Color.WHITE);
        hyperlink1.setPadding(new Insets(8.0));

        imageView1.setFitHeight(48.0);
        imageView1.setFitWidth(48.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/resources/images/icons/ic_account_box_white_48dp_2x.png").toExternalForm()));
        hyperlink1.setGraphic(imageView1);
        hyperlink1.setCursor(Cursor.DEFAULT);

        cartButton.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        cartButton.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        cartButton.setLayoutX(10.0);
        cartButton.setLayoutY(56.0);
        cartButton.setMaxWidth(Double.MAX_VALUE);
        cartButton.setStyle("-fx-border-width: 1 0 1 0;");
        cartButton.getStyleClass().add("navigation-hyperlink");
        cartButton.getStylesheets().add("/views/style.css");
        cartButton.setText("Cart");
        cartButton.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cartButton.setTextFill(javafx.scene.paint.Color.WHITE);
        cartButton.setPadding(new Insets(8.0));

        imageView2.setFitHeight(48.0);
        imageView2.setFitWidth(48.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("/resources/images/icons/ic_shopping_cart_white_48dp_2x.png").toExternalForm()));
        cartButton.setGraphic(imageView2);
        cartButton.setCursor(Cursor.DEFAULT);
        setLeft(vBox);

        gamesVBox.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        gamesVBox.setStyle("-fx-background-color: #eee;");

        gamesListView.setPrefHeight(220.0);
        gamesListView.setStyle("-fx-background-radius: 0;");
        gamesListView.setPadding(new Insets(8.0));

        label.setMaxHeight(Double.MAX_VALUE);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setText("Description");
        label.setFont(new Font("System Bold", 12.0));
        label.setPadding(new Insets(8.0, 0.0, 0.0, 0.0));

        separator.setPrefWidth(200.0);
        VBox.setMargin(separator, new Insets(0.0, 0.0, 8.0, 0.0));

        hBox.setMaxHeight(Double.MAX_VALUE);
        hBox.setMaxWidth(Double.MAX_VALUE);
        hBox.setSpacing(8.0);

        descriptionLabel.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        descriptionLabel.setMaxHeight(Double.MAX_VALUE);
        descriptionLabel.setMaxWidth(Double.MAX_VALUE);
        descriptionLabel.setText("Description");
        descriptionLabel.setTextAlignment(javafx.scene.text.TextAlignment.JUSTIFY);
        descriptionLabel.setWrapText(true);

        coverImageView.setFitHeight(180.0);
        coverImageView.setFitWidth(150.0);
        coverImageView.setPickOnBounds(true);
        HBox.setMargin(coverImageView, new Insets(0.0, 0.0, 0.0, 25.0));

        separator0.setPrefWidth(200.0);
        separator0.setPadding(new Insets(8.0, 0.0, 8.0, 0.0));

        hBox0.setSpacing(8.0);

        label0.setMaxHeight(Double.MAX_VALUE);
        label0.setText("Video:");
        label0.setFont(new Font("System Bold", 12.0));

        videoHyperlink.setText("Hyperlink");

        hBox1.setAlignment(javafx.geometry.Pos.TOP_RIGHT);
        VBox.setMargin(hBox1, new Insets(0.0));

        addToCartButton.setMnemonicParsing(false);
        addToCartButton.getStyleClass().add("my-button");
        addToCartButton.setText("Add To Cart");
        gamesVBox.setPadding(new Insets(8.0));
        setCenter(gamesVBox);

        BorderPane.setAlignment(imagesVBox, javafx.geometry.Pos.CENTER);
        imagesVBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        imagesVBox.setFillWidth(false);
        imagesVBox.setSpacing(8.0);
        imagesVBox.setStyle("-fx-background-color: #eee;");

        firstImageView.setFitHeight(130.0);
        firstImageView.setFitWidth(170.0);
        firstImageView.setPickOnBounds(true);
        VBox.setMargin(firstImageView, new Insets(0.0));

        secondImageView.setFitHeight(130.0);
        secondImageView.setFitWidth(170.0);
        secondImageView.setLayoutX(10.0);
        secondImageView.setLayoutY(10.0);
        secondImageView.setPickOnBounds(true);
        VBox.setMargin(secondImageView, new Insets(0.0));

        thirdImageView.setFitHeight(130.0);
        thirdImageView.setFitWidth(170.0);
        thirdImageView.setLayoutX(10.0);
        thirdImageView.setLayoutY(168.0);
        thirdImageView.setPickOnBounds(true);
        VBox.setMargin(thirdImageView, new Insets(0.0));

        fourthImageView.setFitHeight(130.0);
        fourthImageView.setFitWidth(170.0);
        fourthImageView.setLayoutX(10.0);
        fourthImageView.setLayoutY(326.0);
        fourthImageView.setPickOnBounds(true);
        VBox.setMargin(fourthImageView, new Insets(0.0));
        imagesVBox.setPadding(new Insets(8.0, 12.0, 0.0, 8.0));
        setRight(imagesVBox);

        BorderPane.setAlignment(hBox2, javafx.geometry.Pos.CENTER);
        hBox2.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox2.setSpacing(8.0);
        hBox2.setStyle("-fx-background-color: #555;");
        hBox2.setPadding(new Insets(8.0));

        imageView3.setFitHeight(100.0);
        imageView3.setFitWidth(100.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("/resources/images/MetBack.jpg").toExternalForm()));

        label1.setText("AlanStore");
        label1.setTextFill(javafx.scene.paint.Color.WHITE);
        label1.setFont(new Font("System Bold", 17.0));

        region.setPrefWidth(500.0);

        button.setMnemonicParsing(false);
        button.getStyleClass().add("my-button");
        button.setText("Help");

        button0.setMnemonicParsing(false);
        button0.getStyleClass().add("my-button");
        button0.setText("Logout");
        setTop(hBox2);

        vBox.getChildren().add(hyperlink);
        vBox.getChildren().add(hyperlink0);
        vBox.getChildren().add(hyperlink1);
        vBox.getChildren().add(cartButton);
        gamesVBox.getChildren().add(gamesListView);
        gamesVBox.getChildren().add(label);
        gamesVBox.getChildren().add(separator);
        hBox.getChildren().add(descriptionLabel);
        hBox.getChildren().add(coverImageView);
        gamesVBox.getChildren().add(hBox);
        gamesVBox.getChildren().add(separator0);
        hBox0.getChildren().add(label0);
        hBox0.getChildren().add(videoHyperlink);
        gamesVBox.getChildren().add(hBox0);
        hBox1.getChildren().add(addToCartButton);
        gamesVBox.getChildren().add(hBox1);
        imagesVBox.getChildren().add(firstImageView);
        imagesVBox.getChildren().add(secondImageView);
        imagesVBox.getChildren().add(thirdImageView);
        imagesVBox.getChildren().add(fourthImageView);
        hBox2.getChildren().add(imageView3);
        hBox2.getChildren().add(label1);
        hBox2.getChildren().add(region);
        hBox2.getChildren().add(button);
        hBox2.getChildren().add(button0);

    }
    
    public BorderPane getBorderPane() {
        return this;
    }
}
