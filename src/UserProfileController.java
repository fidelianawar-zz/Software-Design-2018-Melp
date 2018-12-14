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

    /**
	 * This is the "Write New Review" button on the user profile page. It takes the user to the WriteANewReview page
	 * @param event - this is the button press action
	 * @throws Exception - in case the gui being created doesn't exist (which is impossible)
	 */
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
