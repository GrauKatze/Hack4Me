import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Program extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text("Hello from JavaFX!");
        text.setLayoutY(100);  
        text.setLayoutX(250); 
         
        Group group = new Group(text);
         
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Hack4Me");
        stage.setWidth(600);
        stage.setHeight(500);
        stage.show();
        
    }

}