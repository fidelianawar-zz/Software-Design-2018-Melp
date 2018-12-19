import java.io.IOException;
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


public class ViewUserProfileController {
	
	private MelpMember current_member;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label username_field;
    
    @FXML
    private TextArea reviews;
    
    @FXML
    private ImageView user_image;

    @FXML
    void returnHome(ActionEvent event) throws IOException {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("MELP!");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	next_stage.setScene(scene);
    }
    
    public void setMember(MelpMember current_member) {
    	this.current_member = current_member;
    }
    
    public void initializeReviews() {
    	String all_reviews = "";
    	ArrayList<RestaurantReview> member_reviews = current_member.getMy_reviews();
		for (int i = 0; i < member_reviews.size(); i++) {
			all_reviews += member_reviews.get(i).getReviewsWithoutMember();
			all_reviews += "\n\n";
		}
    	reviews.setText(all_reviews);
    }

    @FXML
    void initialize() {
    	initializeReviews();
    	String imageSource = current_member.getImage_path();
    	Image image = new Image(imageSource);
    	user_image.setImage(image);
    }

}
