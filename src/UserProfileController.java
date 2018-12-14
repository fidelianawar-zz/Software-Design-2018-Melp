import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;


public class UserProfileController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void writeNewReview(ActionEvent event) throws Exception {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		next_stage.setTitle("Review a Restaurant");
		WriteAReviewGUI next_gui = new WriteAReviewGUI();
		next_gui.start(next_stage);
    }

    @FXML
    void initialize() {


    }

}
