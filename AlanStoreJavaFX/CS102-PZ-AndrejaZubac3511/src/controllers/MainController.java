/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cs102.pz.andrejazubac3511.MainApp;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Customer;
import models.ImageTextCell;
import models.Product;
import models.ProductQueries;
import views.Account;
import views.Cart;
import views.Library;
import views.Main;

/**
 *
 * @author andre
 */
public class MainController {
    
    private Stage warningStage;
    private Stage helpStage;
    private Main mainView;
    private BorderPane mainBorderPane;
    private Product currentProduct;
    private ProductQueries productQueries;
    private List<Product> results;
    private List<Integer> alreadyPurchasedProducts;
    private ObservableList<Product> products = FXCollections.observableArrayList();
    private ObservableList<Product> cartItems = FXCollections.observableArrayList();
    private MainApp application;
    
    int userID = MainApp.getInstance().getLoggedCustomer().getCustomerID();
    
    public MainController(Main mainView) {
        this.mainView = mainView;
        initialize();
        mainBorderPane = mainView.getBorderPane();
        mainView.hyperlink.setOnAction((ActionEvent e) -> {
            try {
                gotoStore();
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mainView.hyperlink0.setOnAction((ActionEvent e) -> {
            try { 
                gotoLibrary();
            } catch (IOException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mainView.hyperlink1.setOnAction((ActionEvent e) -> {
            try {
                gotoAccount();
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mainView.cartButton.setOnAction((ActionEvent e) -> {
            try {
                showCart();
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mainView.addToCartButton.setOnAction((ActionEvent e) -> {
            try {
                addToCartButtonClicked();
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mainView.button.setOnAction((ActionEvent e) -> {
            showHelp();
        });
        mainView.button0.setOnAction((ActionEvent e) -> {
            try {
                proccessLogout();
            } catch (Exception ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void setApp(MainApp application) {
        this.application = application;
    }
    
    public void initialize() {
        productQueries = new ProductQueries();
        alreadyPurchasedProducts = productQueries.getAlreadyPurchasedProducts(userID);
        results = productQueries.getAllProducts();

        products.addAll(results);
        
        mainView.gamesListView.setItems(products);
        
        mainView.gamesListView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                        mainView.descriptionLabel.setText(newValue.getDescription());
                        mainView.videoHyperlink.setText(newValue.getVideo());
                        mainView.videoHyperlink.setOnAction((ActionEvent e) -> {
                            try {
                                Desktop.getDesktop().browse(new URI(mainView.videoHyperlink.getText()));
                            } catch (URISyntaxException | IOException ex) {
                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                        mainView.coverImageView.setImage(new Image(newValue.getCover()));
                        mainView.firstImageView.setImage(new Image(newValue.getImage1()));
                        mainView.secondImageView.setImage(new Image(newValue.getImage2()));
                        mainView.thirdImageView.setImage(new Image(newValue.getImage3()));
                        mainView.fourthImageView.setImage(new Image(newValue.getImage4()));
                        if(alreadyPurchasedProducts.contains(newValue.getProductID())) {
                            mainView.addToCartButton.setText("Already Purchased");
                            mainView.addToCartButton.setDisable(true);
                        } else {
                            mainView.addToCartButton.setText("Add To Cart");
                            mainView.addToCartButton.setDisable(false);
                        };
                }        
        );
        mainView.gamesListView.getSelectionModel().select(0);
        mainView.gamesListView.setCellFactory((listview) -> new ImageTextCell());
                
    }
    
    public void proccessLogout() throws Exception {
        if (application == null){
            return;
        }
        application.userLogout();
    }

    public void gotoAccount() throws Exception {
        Account account = new Account();
        AccountController accountController = new AccountController(account);
        accountController.setApp(application);
        mainBorderPane.setCenter(account);
        mainBorderPane.setRight(null);
        BorderPane.setAlignment(account, Pos.TOP_LEFT);
    }
    
    public void gotoStore() throws Exception {
        // null pointer exception
        productQueries = new ProductQueries();
        alreadyPurchasedProducts = productQueries.getAlreadyPurchasedProducts(userID);
        if(alreadyPurchasedProducts.contains(mainView.gamesListView.getSelectionModel().getSelectedItem().getProductID())) {
            mainView.addToCartButton.setText("Already Purchased");
            mainView.addToCartButton.setDisable(true);
        } else {
            mainView.addToCartButton.setText("Add To Cart");
            mainView.addToCartButton.setDisable(false);
        }
        mainBorderPane.setCenter(mainView.gamesVBox);
        mainBorderPane.setRight(mainView.imagesVBox);
    }
    
    public void gotoLibrary() throws IOException {
        Library library = new Library();
        LibraryController libraryController = new LibraryController(library);
        mainBorderPane.setCenter(library);
        mainBorderPane.setRight(null);
    }
    
    public Product getSelectedProduct() {
        currentProduct = mainView.gamesListView.getSelectionModel().getSelectedItem();
        return currentProduct;
    }
    
    public void addToCartButtonClicked() throws Exception {
        
        if(cartItems.contains(getSelectedProduct())) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(warningStage);
            alert.getDialogPane().setContentText("Each digital purchase is automatically linked to your account. You cannot buy the same digital item twice.");
            alert.getDialogPane().setHeaderText(null);
            alert.showAndWait().filter(response -> response == ButtonType.OK);
        } else {
            cartItems.add(getSelectedProduct());
            mainView.cartButton.setText("Cart (" + String.valueOf(cartItems.size()) + ")");
        }
    }
    
    public void showCart() throws Exception {
        Cart cart = new Cart();
        CartController cartController = new CartController(cart);
        cartController.updatedCartButton = mainView.cartButton;
        cartController.mainBorderPaneForCheckoutUse = mainBorderPane;
        cartController.setCart(this);
        mainBorderPane.setCenter(cart);
        mainBorderPane.setRight(null);
    }
    
    public ObservableList<Product> getCartItems() {
        return cartItems;
    }
    
    public Customer getLoggedCustomer() {
        return application.getLoggedCustomer();
    }
    
    public void showHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(helpStage);
        alert.getDialogPane().setContentText("Alan Store is an e-store where a user can buy games digitally and then play them from the Games Library. The user can browse through the available games clicking each item on the list. Then he can add the selected game to the Shopping Cart and proceed to Payment. Each game can be purchased only once due to its linking with the user's account.");
        alert.getDialogPane().setHeaderText(null);
        alert.showAndWait().filter(response -> response == ButtonType.CLOSE);        
    }
    
}
