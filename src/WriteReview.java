import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

/**
* This class defines the command to write reviews.
*/
public class WriteReview implements Command {
	private ActionEvent event;
	private MelpMember current_member;
	
	/**
	* Constructor for WriteReview instances.
	* @param the event taken by the user in the GUI
	* @param the current member writing a review
	*/

	public WriteReview(ActionEvent event, MelpMember current_member) {
		this.event = event;
		this.current_member = current_member;
	}

	/**
	* This method executes the command to write a review.
	* @throws IOException
	*/
	public void execute() throws IOException {
		Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("Write a Review");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("WriteAReviewUI.fxml"));
        WriteAReviewController controller = new WriteAReviewController();
        controller.setMember(current_member);
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	next_stage.setScene(scene);
	}

	/**
	* This method undoes the command to write a review and effectively deletes a review.
	* @throws IOException
	*/
	public void undo() throws IOException {
		if (current_member.deleteLastReview() != null) {
	    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	next_stage.setTitle("My Profile");
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("UserProfileUI.fxml"));
	        UserProfileController controller = new UserProfileController();
	        controller.setMember(current_member);
	        loader.setController(controller);
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	    	next_stage.setScene(scene);
		}
	}
	
}
