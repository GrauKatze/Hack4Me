package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Client.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
 
public class MainController implements Initializable{
     
    @FXML
    private Button userInputBtn;

    @FXML
    private Label userNick;

    @FXML
    private Canvas battle;
     
    @FXML
    private void userInputBtnClick(ActionEvent event) {
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AddUser();
                 
        GraphicsContext gc = battle.getGraphicsContext2D();
        gc.clearRect(0, 0, battle.getWidth(), battle.getHeight());
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, battle.getWidth(), battle.getHeight());
        
    }

    private void AddUser() {
        Stage stage = new Stage();        

        VBox root = new VBox();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(10);
        Label userInputLabel = new Label("Your Name");
        TextField userInputNickTextField = new TextField();
        Button userInputNickButton = new Button("Bottom");

        userInputNickButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
              
            @Override
            public void handle(ActionEvent event) {
                if(!(userInputNickTextField.getText().isBlank())){
                    User user = new User(userInputNickTextField.getText());
                    userNick.setText(user.getName());
                    stage.close();
                }
            }
        });

        root.getChildren().addAll(userInputLabel, userInputNickTextField, userInputNickButton);
        Scene scene = new Scene(root, 300, 200);

        stage.setScene(scene);         
        stage.setTitle("New User");
        stage.showAndWait();

    }
}
