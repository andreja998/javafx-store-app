/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cs102.pz.andrejazubac3511.MainApp;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import models.Customer;
import views.Account;

/**
 *
 * @author andre
 */
public class AccountController {
    
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/gamestore_fx_db?zeroDateTimeBehavior=convertToNull";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";    
    private Connection connection;
    private Statement statement;
    
    private MainApp application;
    private Account account;
    
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    
    public AccountController(Account account) {
        this.account = account;
        account.button.setOnAction((ActionEvent e) -> {
            try {
                cancelButton();
            } catch (Exception ex) {
                Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        account.button0.setOnAction((ActionEvent e) -> {
            saveProfile();
        });
    }
    
    public void setApp(MainApp application) {
        this.application = application;
        Customer loggedCustomer = application.getLoggedCustomer();
        account.userTextField.setText(loggedCustomer.getUserName());
        account.emailTextField.setText(loggedCustomer.getEmail());
        account.passwordTextField.setText(loggedCustomer.getPassword());
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            String SELECT_BALANCE = "SELECT Balance FROM customers WHERE CustomerID = " + loggedCustomer.getCustomerID();
            ResultSet resultSet = statement.executeQuery(SELECT_BALANCE);
            while (resultSet.next()) {
                Double customerBalance = resultSet.getDouble("Balance");
                String currencyBalance = currencyFormatter.format(customerBalance);
                account.balanceLabel.setText(currencyBalance);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        account.ccNumberLabel.setText(loggedCustomer.getCCNumber());
        //balanceTextField.setText(String.valueOf(loggedCustomer.getBalance()) + " €");
        account.successLabel.setOpacity(0);
    }  
    
    public void saveProfile() {
        if(application == null) {
            animateMessage();
            return;
        }
        Customer loggedCustomer = application.getLoggedCustomer();
        
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            
            final String UPDATE_ACCOUNT = "UPDATE customers SET UserName = '" + account.userTextField.getText() + "', Password ='" + account.passwordTextField.getText() + "' WHERE CustomerID=" + loggedCustomer.getCustomerID();
            final String UPDATE_EMAIL = "UPDATE customers SET Email = '" + account.emailTextField.getText() + "' WHERE CustomerID=" + loggedCustomer.getCustomerID();
            statement.executeUpdate(UPDATE_ACCOUNT);
            loggedCustomer.setUserName(account.userTextField.getText());
            account.userTextField.setText(account.userTextField.getText());
            loggedCustomer.setPassword(account.passwordTextField.getText());
            account.passwordTextField.setText(account.passwordTextField.getText());
            
            if(account.emailTextField.getText().matches("\\b[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,}\\b")) {
                statement.executeUpdate(UPDATE_EMAIL);
                loggedCustomer.setEmail(account.emailTextField.getText());
                account.emailTextField.setText(account.emailTextField.getText());
                account.successLabel.setText("Profile successfully updated!");
                animateMessage();
            } else {
                account.successLabel.setText("Enter a valid email address (example@example.com).");
                animateMessage();
            }
        } catch(SQLException sqlException) {
            sqlException.printStackTrace();
        }   
    }
    
    public void cancelButton() throws Exception {
        MainApp.getInstance().gotoGameStore();
    }
    
    private void animateMessage() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), account.successLabel);
        ft.setFromValue(0.0);
        ft.setToValue(1);
        ft.play();
    }
    
}
