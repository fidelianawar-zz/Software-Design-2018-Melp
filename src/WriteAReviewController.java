import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WriteAReviewController {
	
	private String restaurant_name;
	private int number_of_stars;
	private String restaurant_review;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField restaurant;
    
    @FXML
    private TextArea review;


    @FXML
    void submitRestaurantReview(ActionEvent event) throws IOException {
    	restaurant_name = restaurant.getText();
    	restaurant_review = review.getText();
    	//String value = ((Button)event.getSource()).getText();
    	RestaurantReview new_review = new RestaurantReview(restaurant_review, number_of_stars, restaurant_name);
    	if (new_review.approveRequest()) {
    		System.out.println("Review Accepted");
	    	System.out.println("Restaurant is: " + restaurant_name);
	    	System.out.println("Number of Stars is: " + Integer.toString(number_of_stars));
	    	System.out.println("Review is: " + restaurant_review);
	    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewReviewUI.fxml"));
	        Parent root = loader.load();
	        ViewReviewController controller = new ViewReviewController();
	        controller.setReview(new_review);
	        Scene scene = new Scene(root);
	    	next_stage.setScene(scene);
    	}
    	else {
    		System.out.println("Review Denied");
    	}
    }
    
    @FXML
    void OneStarReview(ActionEvent event) {
    	number_of_stars = 1;
    }
    
    @FXML
    void TwoStarReview(ActionEvent event) {
    	number_of_stars = 2;
    }
    
    @FXML
    void ThreeStarReview(ActionEvent event) {
    	number_of_stars = 3;
    }
    
    @FXML
    void FourStarReview(ActionEvent event) {
    	number_of_stars = 4;
    }
    
    @FXML
    void FiveStarReview(ActionEvent event) {
    	number_of_stars = 5;
    }

    @FXML
    void initialize() {


    }

}
