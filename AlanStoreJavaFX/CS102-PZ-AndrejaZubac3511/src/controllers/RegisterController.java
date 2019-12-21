/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cs102.pz.andrejazubac3511.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.CustomerQueries;
import views.Register;

/**
 *
 * @author andre
 */
public class RegisterController {
    private CustomerQueries customerQueries;
    private MainApp application; 
    private Alert.AlertType type = Alert.AlertType.INFORMATION;
    private Stage stage;
    private Register register;
    
    public RegisterController(Register register) {
        this.register = register;
        initialize();
        register.button.setOnAction((ActionEvent e) -> {
            try {
                processRegister();
            } catch (IOException ex) {
                Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void setAlertType(Alert.AlertType at) {
        type = at;
    }
    
    protected Alert createAlert() {
        Alert alert = new Alert(type, "");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);
        alert.getDialogPane().setContentText(type + " You successfully registered into Alan Store. Please sign in.");
        alert.getDialogPane().setHeaderText(null);
        alert.showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> System.out.println("The alert was approved"));
        return alert;
    }
    
    public void setApp(MainApp application) {
        this.application = application;
    }
    
    public void initialize() {
        register.registerUserName.setPromptText("Enter username");
        register.registerPassword.setPromptText("Enter password");
        register.registerEmail.setPromptText("example@example.com");
        register.registerCreditCard.setPromptText("16 digits");
    }    
    
    public void processRegister() throws IOException {
        customerQueries = new CustomerQueries();
        
        if(register.registerUserName.getText().trim().isEmpty() || register.registerPassword.getText().trim().isEmpty() || register.registerEmail.getText().trim().isEmpty() || register.registerCreditCard.getText().trim().isEmpty() || register.registerCreditCard.getText().length() != 16 || !(register.registerCreditCard.getText().matches("[0-9]+")) || !(register.registerEmail.getText().matches("\\b[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,}\\b"))) {
            register.errorLabel.setText("Please enter your credentials correctly.");
        } else {
            customerQueries.addCustomer(register.registerUserName.getText(), register.registerPassword.getText(), register.registerEmail.getText(), register.registerCreditCard.getText());
            createAlert();
            application.gotoLogin();
        }
    }
}
