import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
* This class controls the GUI which allows a user to view a review.
*/
public class ViewReviewController {
	
	private RestaurantReview current_review;
	private MelpMember current_member;
	
	/**
	* Sets a review to the current review
	* @param the current review
	*/
	public void setReview(RestaurantReview current_review) {
		this.current_review = current_review;
	}
	
	/**
	 * This is the "View My Profile" button after submitting a review
	 * @param event - this is the button press action
	 * @throws Exception - in case the gui being created doesn't exist (which is impossible)
	 */
	@FXML
	void viewMyProfile(ActionEvent event) throws Exception {
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
	
	/**
	* Views a restaurant's profile
	* @param the event of the user
	*/
	@FXML
	void viewRestaurantProfile(ActionEvent event) throws SQLException, IOException {
		Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("Restaurant Profile");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantProfileUI.fxml"));
        RestaurantProfileController controller = new RestaurantProfileController(current_review.getRestaurantUnderReview());
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	next_stage.setScene(scene);
	}
	
	/**
	 * This is the "Write a new review" button after submitting a review
	 * @param event - this is the button press action
	 * @throws Exception - in case the gui being created doesn't exist (which is impossible)
	 */
	@FXML
	void writeNewReview(ActionEvent event) throws Exception {
		if (current_member.getStatus()) {
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
		else {
			BlockedMessageGUI block = new BlockedMessageGUI();
			Stage primaryStage = new Stage();
			block.start(primaryStage);
		}
	}

	@FXML
    private TextArea restaurantReview;

	/**
	* Initializes the current review as a String
	*/
    @FXML
    private void initialize() {
        restaurantReview.setText(current_review.toString());
    }

	/**
	 * Sets a member to the current reviewer
	 * @param the current reviewer
	 */
	public void setMember(MelpMember reviewer) {
		current_member = reviewer;
	}
	
}
