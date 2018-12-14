import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ViewReviewController {
	
	private RestaurantReview current_review;
	
	public void setReview(RestaurantReview current_review) {
		this.current_review = current_review;
	}

	@FXML
    private Label lblTest;

    @FXML
    private void initialize() {
        lblTest.setText("I'm a Label.");
    }
	
}
