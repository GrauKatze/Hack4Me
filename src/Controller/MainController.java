package Controller;

import org.w3c.dom.Text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
 
public class MainController {
     
    @FXML
    private Button btn;

    @FXML
    private TextField userNick;

    @FXML
    private TextArea loftext;
     
    @FXML
    private void click(ActionEvent event) {
            loftext.appendText(userNick.getText());
        }
    }
