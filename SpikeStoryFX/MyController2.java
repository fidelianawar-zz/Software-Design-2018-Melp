import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


public class MyController2 {
	
	private String user_choice;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void onButtonPress(ActionEvent event) {
    	System.out.println(user_choice);
    }

    @FXML
    void recordValue1(ActionEvent event) {    	
    	user_choice = "Action 1";
    }

    @FXML
    void recordValue2(ActionEvent event) {
       	user_choice = "Action 2";
    }

    @FXML
    void initialize() {


    }

}
