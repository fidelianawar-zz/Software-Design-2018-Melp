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

/**
* This class controls the GUI for the user profile.
*/
public class UserProfileController {
	
	private MelpMember current_member;
	private Label headerLabel;
	
	/**
	* Sets a member to the current member
	* @param the current member
	*/
	public void setMember(MelpMember current_member) {
		this.current_member = current_member;
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView user_image;
    
    @FXML
    private TextArea reviews;
    
    @FXML
    private Label username_field;
    
    @FXML
    private Label password_field;
    
    /**
    * Initializes the restaurant reviews
    */
    public void initializeReviews() {
    	String all_reviews = "";
    	ArrayList<RestaurantReview> member_reviews = current_member.getMy_reviews();
		for (int i = 0; i < member_reviews.size(); i++) {
			all_reviews += member_reviews.get(i);
			all_reviews += "\n\n";
		}
    	reviews.setText(all_reviews);
    }

    /**
	 * This is the "Write New Review" button on the user profile page. It takes the user to the WriteANewReview page
	 * @param event - this is the button press action
	 * @throws Exception - in case the gui being created doesn't exist (which is impossible)
	 */
    @FXML
    void writeNewReview(ActionEvent event) throws Exception {
    	Command write_review_command = new WriteReview(event, current_member);
    	write_review_command.execute();
    }
    
    /**
    * Deletes a review
    * @param the event of the user
    * @throws Exception
    */
    @FXML
    void deleteReview(ActionEvent event) throws Exception {
    	Command write_review_command = new WriteReview(event, current_member);
    	write_review_command.undo();
    }
    
    /**
    * Logs out of an account
    * @param the event of the user
    */
    @FXML
    void logOut(ActionEvent event) throws Exception {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("MELP!");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	next_stage.setScene(scene);
    }

    /**
    * Initializes the restaurant reviews
    */
    @FXML
    void initialize() {
    	initializeReviews();
    	File file = new File(current_member.getImage_path());
    	Image image = new Image(file.toURI().toString());
    	user_image.setImage(image);
    	username_field.setText("Current Username: " + current_member.getName());
    	password_field.setText("Current Password: " + current_member.getPassword());
    }

}

