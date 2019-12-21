/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import models.Customer;
import models.Product;
import views.Cart;
import views.Checkout;

/**
 *
 * @author andre
 */
public class CartController {
    private MainController mainController;
    private Cart cart;
    double total = 0 ;
    public Hyperlink updatedCartButton;
    public BorderPane mainBorderPaneForCheckoutUse;
    
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
       
    public CartController(Cart cart) {
        this.cart = cart;
        initialize();
        cart.button.setOnAction((ActionEvent e) -> {
            try {
                continueShopping();
            } catch (Exception ex) {
                Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cart.button0.setOnAction((ActionEvent e) -> {
            try {
                proceedToCheckout();
            } catch (IOException ex) {
                Logger.getLogger(CartController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void initialize() {
        cart.cartTable.setPlaceholder(new Label("Your shopping cart is empty..."));
    }
    
    public void setCart(MainController mainController) {
        this.mainController = mainController;
        cart.cartTable.setItems(mainController.getCartItems());
        
        for (Product product : cart.cartTable.getItems()) {
            total = total + product.getPrice();
        }
        String currencyPrice = currencyFormatter.format(total);
        cart.subtotalLabel.setText(currencyPrice);    
        
        cart.coverCol.setCellValueFactory(img -> new ReadOnlyObjectWrapper<>(img.getValue()));
        cart.coverCol.setCellFactory(img -> new TableCell<Product, Product>(){
            private final ImageView coverImageView = new ImageView();
            @Override 
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if(product == null) {
                    setGraphic(null);
                    return;
                }
                coverImageView.setImage(new Image(product.getCover()));
                coverImageView.setFitHeight(50);
                coverImageView.setFitWidth(100);
                setGraphic(coverImageView);
            }
        });
        
        cart.titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        cart.priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        cart.priceCol.setCellFactory(col -> new TableCell<Product, Double>(){
            @Override
            public void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                if(empty) {
                    setGraphic(null);
                } else {
                    String currencyPrice = currencyFormatter.format(price);
                    Label priceLabel = new Label(currencyPrice);
                    setGraphic(priceLabel);
                }
            }
        });
        
        cart.removeCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        cart.removeCol.setCellFactory(param -> new TableCell<Product,Product>(){
            private final Hyperlink removeFromCart = new Hyperlink("");
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if(product == null) {
                    setGraphic(null);
                    return;
                }
                HBox removeHBox = new HBox();
                TextField quantity = new TextField("1");
                quantity.setPrefWidth(35.0);
                quantity.setAlignment(Pos.CENTER_RIGHT);
                quantity.setEditable(false);
                quantity.setStyle("-fx-background-radius: 0;");
                removeHBox.setAlignment(Pos.CENTER);
                removeHBox.getChildren().addAll(quantity, removeFromCart);
                setGraphic(removeHBox);
                Image deleteIcon = new Image(getClass().getResourceAsStream("/resources/images/icons/ic_delete_black_18dp_1x.png"));
                removeFromCart.setGraphic(new ImageView(deleteIcon));
                removeFromCart.setStyle("-fx-text-fill: black;");
                removeFromCart.setOnAction(e -> {
                    getTableView().getItems().remove(product);
                    total = total - product.getPrice();
                    String currencyPrice = currencyFormatter.format(total);
                    cart.subtotalLabel.setText(currencyPrice);
                    updatedCartButton.setText("Cart (" + String.valueOf(mainController.getCartItems().size()) + ")");
                });
            }
        });        
    }
    
    public void continueShopping() throws Exception {
        mainController.gotoStore();
    }
    
    public void proceedToCheckout() throws IOException {
        if(!mainController.getCartItems().isEmpty()) {
            Checkout checkout = new Checkout();
            CheckoutController checkoutController = new CheckoutController(checkout);
            checkoutController.setCheckoutPage(this);
            checkoutController.checkoutCartButton = updatedCartButton;
            mainBorderPaneForCheckoutUse.setCenter(checkout);
        }
    }
    
    public ObservableList<Product> getCartItemsForCheckout() {
        return cart.cartTable.getItems();
    }
    
    public Customer getLoggedCustomer() {
        return mainController.getLoggedCustomer();
    }
}
