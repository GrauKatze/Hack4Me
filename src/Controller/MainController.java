package Controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Model.Building.Build;
import Model.Client.User;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
 
public class MainController implements Initializable{

    @FXML
    private Button userInputBtn;

    public ArrayList<Build> baseList = new ArrayList<Build>();

    @FXML
    public Button myButton;

    @FXML
    private Label userNick;

    @FXML
    private Canvas battle;
     
    @FXML
    private void userInputBtnClick(ActionEvent event) {
       
    }

    @FXML
    private void canvasClick(MouseEvent mEvent){

        Double canvasX = mEvent.getX();
        Double canvasY = mEvent.getY();
        
        if( (canvasX > baseList.get(0).getX()-24) && (canvasX<baseList.get(0).getX()+24) && (canvasY > baseList.get(0).getY()-24) && (canvasY<baseList.get(0).getY()+24) ){
            userNick.setText("yes");
        }else
            userNick.setText("No");
            NewBuild(canvasX, canvasY);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //AddUser();

        baseList.add(new Build("basa", 0, "../../Resource/base.png", battle.getWidth()/2, battle.getHeight()/2 ));
                 
        GraphicsContext gc = battle.getGraphicsContext2D();
        gc.clearRect(0, 0, battle.getWidth(), battle.getHeight());
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, battle.getWidth(), battle.getHeight());
        gc.drawImage(baseList.get(0).getImageView().getImage(), baseList.get(0).getX()-24, baseList.get(0).getY()-24);

        ImageView imageView = new ImageView(baseList.get(0).getImageView().getImage());

        myButton.setText("pipi");
        myButton.setStyle("-fx-background-color: transparent;");
        myButton.setGraphic(imageView);

        myButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("You clicked: " + ((Button)event.getSource()).getId());
            }                
        });
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

    private void Build(String name, int ID, String path, double X, double Y) {
        baseList.add(new Build(name, ID, path, X, Y));

        GraphicsContext gc = battle.getGraphicsContext2D();
        gc.drawImage(baseList.get(baseList.size()-1).getImageView().getImage(), baseList.get(baseList.size()-1).getX()-12, baseList.get(baseList.size()-1).getY()-12);

    }

    private void NewBuild(double X, double Y){

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        ObservableList<String> langs = FXCollections.observableArrayList("dataCraft", "dataSave", "Protecter");
        ListView<String> langsListView = new ListView<String>(langs);

        MultipleSelectionModel<String> langsSelectionModel = langsListView.getSelectionModel();
        langsSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> changed, String oldValue, String newValue){
                int ID = 0;
                switch (newValue) {
                    case "dataCraft":
                        ID = 1;
                        break;
                    case "dataSave":
                        ID = 2;
                        break;
                    case "Protecter":
                        ID = 3;
                        break;
                    default:
                        break;
                    }
                Build(newValue, ID, "../../Resource/"+newValue+".png", X, Y);
                stage.close();
            }
        });
        
        Group root = new Group(langsListView);
        Scene scene = new Scene(root, 250, 200);
          
        stage.setScene(scene);
        stage.show();
    }

}
