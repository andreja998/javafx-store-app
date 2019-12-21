/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs102.pz.andrejazubac3511;

import controllers.LoginController;
import controllers.MainController;
import controllers.RegisterController;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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
public class MainApp extends Application {
    // "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" --user-data-dir="C:/Chrome dev session" --disable-web-security
    private Login login = new Login();
    private Stage stage;

    private static Customer loggedCustomer;
    private CustomerQueries customerQueries;
    private List<Customer> userNameResults;
    private List<Customer> passwordResults;
    private int numberOfCustomersByUserName = 0;
    private int numberOfCustomersByPassword = 0;
    private int currentCustomerIndex;
    
    private static MainApp mainInstance;
    LoginController loginController;
    
    public MainApp() {
        mainInstance = this;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        setControllers();
        Scene scene = new Scene(login, 370, 320);
        
        primaryStage.setTitle("Alan Store");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static MainApp getInstance() {
        return mainInstance;
    }
    
    public void setControllers() {
        loginController = new LoginController(login);
        loginController.setApp(this);
    }
    
    public void gotoLogin() {
        try {
            login = new Login();
            loginController = new LoginController(login);
            loginController.setApp(mainInstance);
            stage.close();
            stage = new Stage();
            stage.setTitle("Alan Store");
            stage.setScene(new Scene(login, 370, 320));
            stage.setMinWidth(370);
            stage.setMinHeight(320);
            stage.show();
            
        } catch (Exception ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customer getLoggedCustomer() {
        return loggedCustomer;
    }
    
    public void userLogout() throws Exception {
        loggedCustomer = null;
        gotoLogin();
    } 
    
    public void gotoGameStore() throws IOException {
        Main mainWindow = new Main();
        mainWindow.prefHeightProperty().bind(stage.heightProperty());
        mainWindow.prefWidthProperty().bind(stage.widthProperty());
        MainController mainController = new MainController(mainWindow);
        mainController.setApp(this);
        stage.setScene(new Scene(mainWindow, 990, 730));
        stage.setMinWidth(990);
        stage.setMinHeight(730);
        stage.setResizable(false);
    }
    
    public void gotoRegister() {
        try {
            Register register = new Register();
            RegisterController registerController = new RegisterController(register);
            registerController.setApp(this);
            stage.setScene(new Scene(register));
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean userLogging(String userName, String password) throws IOException{
        customerQueries = new CustomerQueries();
        userNameResults = customerQueries.getCustomerByUserName(userName);
        passwordResults = customerQueries.getCustomerByPassword(password);
        numberOfCustomersByUserName = userNameResults.size();
        numberOfCustomersByPassword = passwordResults.size();
        
        if(numberOfCustomersByUserName != 0 && numberOfCustomersByPassword != 0) {
            currentCustomerIndex = 0;
            loggedCustomer = userNameResults.get(currentCustomerIndex);
            gotoGameStore();
            return true;
        } else {
            return false;
        }
    }
    
}
