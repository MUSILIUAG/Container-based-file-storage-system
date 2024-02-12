/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javafxapplication1;
import com.mycompany.javafxapplication1.Handler;
import static com.mycompany.javafxapplication1.PrimaryController.username_;
import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author ntu-user
 */
public class terminalController {
    
   @FXML
    private TextField commandInput;
    
   @FXML
   private Button enterbtn;
   
   @FXML
   private TextArea commandDisplay;
   
   @FXML
   private Button backButton;
   
   
    @FXML
    private void onEnterButtonClicked(ActionEvent event) {
        
        Handler hand= new Handler();
        
        String userCommand = commandInput.getText();
        String output = hand.terminal(userCommand);
        commandDisplay.setText(output);
    }
    
    
      @FXML
    private void Backbuttonahndler(ActionEvent event){
        String getuser_ = username_.getUser();
        String getpass = username_.getPass();
        Stage secondaryStage = new Stage();
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        try {
            String[] credentials = new String[2];
            credentials[0] = getuser_;
            credentials[1] = getpass;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("secondary.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 640, 480);
            secondaryStage.setScene(scene);
            SecondaryController controller = loader.getController();
            controller.initialise(credentials);
            secondaryStage.setTitle("Secondary view");
            secondaryStage.show();
            primaryStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


   
   
    
    
    
    
    

