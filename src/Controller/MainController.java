package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Model.Building.Build;
import Model.Client.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 
public class MainController implements Initializable{

    @FXML
    private Button userInputBtn;

    public ArrayList<Build> buildList = new ArrayList<Build>();


    @FXML
    private FlowPane battle;

    @FXML
    private Label userNick;
     
    @FXML
    private void userInputBtnClick(ActionEvent event) {
       
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //AddUser();

        buildList.add(new Build("basa", 0, "../../Resource/base.png"));

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("../Resource/base.png")));

        Button myButton = new Button();

        myButton.setStyle("-fx-background-color: transparent;");
        myButton.setGraphic(imageView);

        myButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You clicked: " + ((Button)event.getSource()).getId());
            }                
        });
        battle.setAlignment(Pos.CENTER);

        battle.getChildren().addAll(myButton);
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
        stage.initStyle(StageStyle.UNDECORATED);    
        stage.setTitle("New User");
        stage.showAndWait();

    }

}
