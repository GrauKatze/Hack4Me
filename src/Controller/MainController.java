package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
 
public class MainController {
     
    @FXML
    private Button btn;

    @FXML
    private TextField userNick;
     
    @FXML
    private void click(ActionEvent event) {
            btn.setText(userNick.getText());
        }
    }
