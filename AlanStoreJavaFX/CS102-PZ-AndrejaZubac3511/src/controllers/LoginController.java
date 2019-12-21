/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cs102.pz.andrejazubac3511.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Customer;
import models.CustomerQueries;
import views.Login;
import views.Main;
import views.Register;

/**
 *
 * @author andre
 */
public class LoginController {
    
    private Login login;
    private Main mainWindow = new Main();
    private static Customer loggedCustomer;
    private CustomerQueries customerQueries;
    private List<Customer> userNameResults;
    private List<Customer> passwordResults;
    private int numberOfCustomersByUserName = 0;
    private int numberOfCustomersByPassword = 0;
    private int currentCustomerIndex;
    
    private MainApp application; 
    
    public LoginController(Login login) {
        this.login = login;
        initialize();
        login.loginButton.setOnAction((ActionEvent event) -> {
            try {
                processLogin();
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        login.hyperlink.setOnAction((ActionEvent e) -> {
            application.gotoRegister();
        });
        
    }
    
    public void initialize() {
        getLogin().errorMessage.setText("");
        getLogin().loginUsername.setPromptText("Username");
        getLogin().loginPassword.setPromptText("Password");
    } 

    public void processLogin() throws Exception {
        if(application == null) {
            getLogin().errorMessage.setText("Welcome, " + getLogin().loginUsername.getText());
        } else {
            if(!application.userLogging(getLogin().loginUsername.getText(), getLogin().loginPassword.getText())) {
                getLogin().errorMessage.setText("Username/Password is Incorrect");
            }
        }
    }
    
    public void setApp(MainApp application) {
        this.application = application;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
}
