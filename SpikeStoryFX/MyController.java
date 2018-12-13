import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void clickTestButton(ActionEvent event) {
    	System.out.println("This is a test");
    }

    @FXML
    void initialize() {


    }

}
