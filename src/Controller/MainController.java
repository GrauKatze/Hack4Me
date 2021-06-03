package Controller;

import Model.Client.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
 
public class MainController {
     
    @FXML
    private Button userInputBtn;

    @FXML
    private Label userNick;
     
    @FXML
    private void userInputBtnClick(ActionEvent event) {
        Stage stage = new Stage();

        TextField userInputNickTextField = new TextField();
        AnchorPane.setTopAnchor(userInputNickTextField, 10.0);
        AnchorPane.setLeftAnchor(userInputNickTextField, 60.0);
        AnchorPane.setRightAnchor(userInputNickTextField, 60.0);
      
        Button userInputNickButton = new Button("Bottom");
        AnchorPane.setBottomAnchor(userInputNickButton, 10.0);
        AnchorPane.setLeftAnchor(userInputNickButton, 30.0);
        AnchorPane.setRightAnchor(userInputNickButton, 30.0);


        userInputNickButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
              
            @Override
            public void handle(ActionEvent event) {
                if(!(userInputNickTextField.getText().isBlank())){
                    userNick.setText(userInputNickTextField.getText());
                    stage.close();
                }
            }
        });

        AnchorPane root = new AnchorPane(userInputNickTextField, userInputNickButton);
        Scene scene = new Scene(root, 300, 200);
       

        stage.setScene(scene);         
        stage.setTitle("AnchorPane in JavaFX");
        stage.show();

    }
}
