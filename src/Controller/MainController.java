package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import Model.Building.Build;
import Model.User.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

    Random rnd = new Random();


    private User user = new User();

    public User getUser() {
        return user;
    }

    private ArrayList<Build> buildList = new ArrayList<Build>();

    public ArrayList<Build> getBuildList() {
        return buildList;
    }

    @FXML
    private Button userInputBtn;

    @FXML
    private Pane battle;

    @FXML
    private Label userNick;

    @FXML
    private void ShowBildList(ActionEvent craftBuildEvent) {
        Stage stage = new Stage();
        TextArea root = new TextArea();

        for (Build build : buildList) {
            root.appendText(build.getID() + " - " + build.getName()+"\n");
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BuildList");
        stage.show();
    }

    @FXML
    private void CraftBuild(ActionEvent craftBuildEvent) {

        Button eventButton = (Button) craftBuildEvent.getSource();

        Stage stage = new Stage();

        double grad = rnd.nextInt(360);
        double X, Y;

        System.out.println(grad);

        X = 150*Math.cos(grad);
        Y = 150*Math.sin(grad);

        ImageView iDataCraft = new ImageView(new Image(getClass().getResourceAsStream("../Resource/dataCraft.png")));
        ImageView iDataSave = new ImageView(new Image(getClass().getResourceAsStream("../Resource/dataSave.png")));
        ImageView iProtector = new ImageView(new Image(getClass().getResourceAsStream("../Resource/Protector.png")));

        Button DataCraft = new Button("DataCraft");
        DataCraft.setGraphic(iDataCraft);
        DataCraft.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                buildList.add(new Build("DataCraft", buildList.size(), "../../Resource/dataCraft.png"));
                DataCraft.setStyle("-fx-background-color: transparent;");
                DataCraft.setText("");
                DataCraft.setLayoutX(eventButton.getLayoutX()+ X);
                DataCraft.setLayoutY(eventButton.getLayoutY() + Y);

                battle.getChildren().add(DataCraft);
                stage.close();
            }
        });

        Button DataSave = new Button("DataSave");
        DataSave.setGraphic(iDataSave);
        DataSave.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                buildList.add(new Build("DataSave", buildList.size(), "../../Resource/dataSave.png"));

                DataSave.setStyle("-fx-background-color: transparent;");
                DataSave.setText("");
                DataSave.setLayoutX(eventButton.getLayoutX()+ X);
                DataSave.setLayoutY(eventButton.getLayoutY() + Y);

                battle.getChildren().add(DataSave);
                stage.close();
            }
        });

        Button Protector = new Button("Protector");
        Protector.setGraphic(iProtector);
        Protector.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                buildList.add(new Build("Protector", buildList.size(), "../../Resource/Protector.png"));

                Protector.setStyle("-fx-background-color: transparent;");
                Protector.setText("");
                Protector.setLayoutX(eventButton.getLayoutX()+ X);
                Protector.setLayoutY(eventButton.getLayoutY() + Y);

                battle.getChildren().add(Protector);
                stage.close();
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(DataCraft, DataSave, Protector);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        // stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("New User");
        stage.showAndWait();
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
                if (!(userInputNickTextField.getText().isBlank())) {
                    user.setName(userInputNickTextField.getText());
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

    private void AddBuild() {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // AddUser();

        buildList.add(new Build("basa", 0, "../../Resource/base.png"));

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("../Resource/base.png")));

        Button myButton = new Button();

        myButton.setStyle("-fx-background-color: transparent;");
        myButton.setGraphic(imageView);

        myButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CraftBuild(event);
            }
        });
        myButton.setLayoutX(350);
        myButton.setLayoutY(400);
        battle.getChildren().addAll(myButton);
    }

}
