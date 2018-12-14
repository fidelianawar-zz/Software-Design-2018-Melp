import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


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
    void submitRestaurantReview(ActionEvent event) {
    	restaurant_name = restaurant.getText();
    	restaurant_review = review.getText();
    	// create restaurant review
    	System.out.println("Restaurant is: " + restaurant_name);
    	System.out.println("Number of Stars is: " + Integer.toString(number_of_stars));
    	System.out.println("Review is: " + restaurant_review);
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
