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
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

    Random rnd = new Random();

    private User user = new User();

    private ArrayList<Build> buildList = new ArrayList<Build>();

    public ArrayList<Build> getBuildList() {
        return buildList;
    }

    @FXML
    private Button userInputBtn;

    @FXML
    private Pane battle;

    @FXML
    private Label userNick, userData;

    @FXML
    private void ShowBildList(ActionEvent craftBuildEvent) {
        Stage stage = new Stage();
        TextArea root = new TextArea();

        for (Build build : buildList) {
            root.appendText(build.getID() + " - " + build.getName() + "\n");
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

        X = 150 * Math.cos(grad);
        Y = 150 * Math.sin(grad);

        ImageView iDataCraft = new ImageView(new Image(getClass().getResourceAsStream("../Resource/dataCraft.png")));
        ImageView iDataSave = new ImageView(new Image(getClass().getResourceAsStream("../Resource/dataSave.png")));
        ImageView iProtector = new ImageView(new Image(getClass().getResourceAsStream("../Resource/Protector.png")));

        Button DataCraft = new Button("DataCraft");
        DataCraft.setGraphic(iDataCraft);
        DataCraft.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (user.getDataResources() >= 250) {
                    buildList.add(new Build("DataCraft", buildList.size(), "../../Resource/dataCraft.png"));

                    user.changeDataResource(-250);
                    user.dataUp += 30;
                    userData.setText(String.valueOf(user.getDataResources()));

                    DataCraft.setStyle("-fx-background-color: transparent;");
                    DataCraft.setText("");
                    DataCraft.setLayoutX(eventButton.getLayoutX() + X);
                    DataCraft.setLayoutY(eventButton.getLayoutY() + Y);

                    DataCraft.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            CraftBuild(event);
                        }
                    });
                    ;

                    DataCraft.setPrefHeight(24);
                    DataCraft.setPrefWidth(24);

                    Line line = new Line(eventButton.getLayoutX() + eventButton.getWidth()/2,eventButton.getLayoutY()+eventButton.getHeight()/2,
                    DataCraft.getLayoutX()+16,DataCraft.getLayoutY()+16);

                    line.setStrokeWidth(5);
                    line.setStroke(Color.BLUE);

                    battle.getChildren().addAll(DataCraft,line);

                    stage.close();
                }
            }
        });

        Button DataSave = new Button("DataSave");
        DataSave.setGraphic(iDataSave);
        DataSave.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (user.getDataResources() >= 350) {
                    buildList.add(new Build("DataSave", buildList.size(), "../../Resource/dataSave.png"));

                    user.changeDataResource(-350);
                    userData.setText(String.valueOf(user.getDataResources()));

                    DataSave.setStyle("-fx-background-color: transparent;");
                    DataSave.setText("");
                    DataSave.setLayoutX(eventButton.getLayoutX() + X);
                    DataSave.setLayoutY(eventButton.getLayoutY() + Y);

                    DataSave.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            CraftBuild(event);
                        }
                    });
                    ;

                    Line line = new Line(eventButton.getLayoutX() + eventButton.getWidth()/2,eventButton.getLayoutY()+eventButton.getHeight()/2,
                    DataSave.getLayoutX()+16,DataSave.getLayoutY()+16);

                    line.setStrokeWidth(5);
                    line.setStroke(Color.BLUE);

                    battle.getChildren().addAll(DataSave,line);
                    stage.close();
                }
            }
        });

        Button Protector = new Button("Protector");
        Protector.setGraphic(iProtector);
        Protector.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (user.getDataResources() >= 150) {
                    buildList.add(new Build("Protector", buildList.size(), "../../Resource/Protector.png"));
                    user.changeDataResource(-150);

                    Protector.setStyle("-fx-background-color: transparent;");
                    Protector.setText("");
                    Protector.setLayoutX(eventButton.getLayoutX() + X);
                    Protector.setLayoutY(eventButton.getLayoutY() + Y);

                    Protector.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
                        public void handle(ActionEvent event) {
                            CraftBuild(event);
                        }
                    });
                    ;
                    Protector.setPrefHeight(24);
                    Protector.setPrefWidth(24);

                    Line line = new Line(eventButton.getLayoutX() + eventButton.getWidth()/2,eventButton.getLayoutY()+eventButton.getHeight()/2,
                    Protector.getLayoutX()+16,Protector.getLayoutY()+16);

                    line.setStrokeWidth(5);
                    line.setStroke(Color.BLUE);

                    battle.getChildren().addAll(Protector,line);
                    stage.close();
                }
            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(DataCraft, DataSave, Protector);
        Scene scene = new Scene(root);
        stage.setScene(scene);
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
                    user.setUserName(userInputNickTextField.getText());
                    userNick.setText(user.getUserName());
                    userData.setText(String.valueOf(user.getDataResources()));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        AddUser();

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

    public void update() {
        userData.setText(String.valueOf(user.getDataResources()));
    }
}
