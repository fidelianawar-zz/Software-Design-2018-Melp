import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
* This class controls the GUI for a blocked message.
*/
public class BlockedMessageController {

	/**
	* Closes the window
	* @param the event of the user
	* @throws IOException
	*/
    @FXML
    void closeWindow(ActionEvent event) throws IOException {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.close();
    }

}