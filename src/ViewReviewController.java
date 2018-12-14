import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ViewReviewController {
	
	private RestaurantReview current_review;
	
	public void setReview(RestaurantReview current_review) {
		this.current_review = current_review;
	}
	
	@FXML
	void writeNewReview(ActionEvent event) throws Exception {
		Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		next_stage.setTitle("Review a Restaurant");
		WriteAReviewGUI next_gui = new WriteAReviewGUI();
		next_gui.start(next_stage);
	}

	@FXML
    private TextArea restaurantReview;

    @FXML
    private void initialize() {
        restaurantReview.setText(current_review.toString());
    }
	
}
