import Model.Client.Client;
import Model.Server.Server;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
          
        Parent root = FXMLLoader.load(getClass().getResource("View/Main.fxml")); 
        Scene scene = new Scene(root);
         
        stage.setScene(scene);
        stage.setTitle("Hello JavaFX");
        stage.show();
    }

    @Override
    public void init() throws Exception {
        Server srv = new Server();
        Client cln = new Client();
        srv.start();
        cln.start();
        super.init();
    }

    @Override
    public void stop() throws Exception {
        Server srv = new Server();
        Client cln = new Client();
        srv.stop();
        cln.stop();

        super.stop();
    }
}