/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cs102.pz.andrejazubac3511.MainApp;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Customer;
import models.Product;
import views.Checkout;

/**
 *
 * @author andre
 */
public class CheckoutController {
    
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/gamestore_fx_db?zeroDateTimeBehavior=convertToNull";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private Alert.AlertType type = Alert.AlertType.INFORMATION;
    private Stage stage;
    public Hyperlink checkoutCartButton;
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    private Checkout checkout;
    
    public CheckoutController(Checkout checkout) {
        this.checkout = checkout;
        checkout.button.setOnAction((ActionEvent e) -> {
            try {
                purchaseButtonClicked();
            } catch (SQLException ex) {
                Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void setAlertType(Alert.AlertType at) {
        type = at;
    }
    
    protected Alert createInfoAlert() {
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("You can now play the games you bought from the AlanStore Library.");
        alert.getDialogPane().setHeaderText("Your purchase has been successful.");
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK);
        return alert;
    }
    
    protected Alert createErrorAlert() {
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText("Update your funds and try again...");
        alert.getDialogPane().setHeaderText("Your balance is not enough.");
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK);
        return alert;
    }
    
    public void setCheckoutPage(CartController cartController) {
        checkout.checkoutTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        checkout.checkoutPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        checkout.checkoutPriceCol.setCellFactory(col -> new TableCell<Product, Double>(){
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
        checkout.checkoutTable.setItems(cartController.getCartItemsForCheckout());
        
        Double orderTotal = cartController.total;
        String currencyTotal = currencyFormatter.format(orderTotal);
        checkout.checkoutTotal.setText(currencyTotal);
        
        Customer loggedCustomer = cartController.getLoggedCustomer();
        checkout.checkoutCCNumber.setText(loggedCustomer.getCCNumber());
        checkout.checkoutUserName.setText(loggedCustomer.getUserName());
        
        Double userBalance = loggedCustomer.getBalance();
        String currencyBalance = currencyFormatter.format(userBalance);
        checkout.checkoutBalance.setText(currencyBalance);
    }
    
    public void purchaseButtonClicked() throws SQLException, ParseException, IOException {
          
        DecimalFormat decimalFormat = new DecimalFormat("#");
        double total = decimalFormat.parse(checkout.checkoutTotal.getText()).doubleValue();
        double balance = decimalFormat.parse(checkout.checkoutBalance.getText()).doubleValue();
        
        String customerAccount = checkout.checkoutUserName.getText();
        
        if(total <= balance) {
            balance = balance - total;
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String UPDATE_QUERY = "UPDATE customers SET Balance = " + balance + " WHERE UserName = '" + customerAccount + "'";
            statement.executeUpdate(UPDATE_QUERY);
            checkout.checkoutBalance.setText(String.valueOf(balance));
            int userID = MainApp.getInstance().getLoggedCustomer().getCustomerID();
            Customer loggedCustomer = MainApp.getInstance().getLoggedCustomer();
            loggedCustomer.setBalance(balance);       
            
            for(Product product : checkout.checkoutTable.getItems()) {
                final String INSERT_QUERY = "INSERT INTO orders (ProductID, CustomerID) VALUES ('" + product.getProductID() + "','" + userID + "')";
                statement.executeUpdate(INSERT_QUERY);
            }
            
            setAlertType(Alert.AlertType.INFORMATION);
            createInfoAlert();
            checkout.checkoutTable.getItems().clear();
            checkoutCartButton.setText("Cart");
            
            MainApp.getInstance().gotoGameStore();
        } else {
            setAlertType(Alert.AlertType.ERROR);
            createErrorAlert();
        }
    }  
    
}
