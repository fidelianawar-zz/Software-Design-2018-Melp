import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WriteAReviewController {

	private String restaurant_name;
	private int number_of_stars = 0;
	private String restaurant_review;
	private MelpMember reviewer;
	private static final int PORT_NUMBER = 3306;

	@FXML
	private ResourceBundle resources;

	@FXML
	private Label headerLabel;

	@FXML
	private MenuButton star_list;

	@FXML
	private URL location;

	@FXML
	private TextField restaurant;

	@FXML
	private TextArea review;

	public void addReviewToDatabase(RestaurantReview curr_rev) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
			Statement stmt = conn.createStatement();
			String member = "'" + reviewer.getName() + "', ";
			String restaurant = "'" + curr_rev.getRestaurantUnderReview() + "', ";
			String stars = "'" + Integer.toString(curr_rev.getRating()) + "', ";
			String review = "'" + curr_rev.getContent() + "'";
			String command = member + restaurant + stars + review;
			stmt.execute("insert into reviews values (" + command + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void restaurantInDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select RestaurantName from restaurants");
		ArrayList<String> restaurant_names = new ArrayList<String>();
	}

	/**
	 * This is the "Submit review" button. It makes sure the review isn't vulgar, then moves to the ViewReview page
	 * @param event - this is the button press action
	 * @throws Exception - in case the gui being created doesn't exist (which is impossible)
	 */
	@FXML
	void submitRestaurantReview(ActionEvent event) throws IOException {
		restaurant_name = restaurant.getText();
		restaurant_review = review.getText();
		//String value = ((Button)event.getSource()).getText();

		Command write_review_command = new WriteReview(restaurant_review, number_of_stars, restaurant_name);
		//RestaurantReview default_review = new RestaurantReview("Review no longer exists.", 0, restaurant_name);
		//RestaurantReview new_review = new RestaurantReview(restaurant_review, number_of_stars, restaurant_name);
		RestaurantReview review = write_review_command.execute();
		//if (review.approveRequest()) {
		RestaurantReview new_review = new RestaurantReview(restaurant_review, number_of_stars, restaurant_name);
		if (number_of_stars != 0) {
			if (new_review.approveRequest()) {
				reviewer.addReviewToMyReviews(new_review);
				addReviewToDatabase(new_review);
				Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
				next_stage.setTitle("View Review");
				FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewReviewUI.fxml"));
				ViewReviewController controller = new ViewReviewController();
				controller.setReview(new_review);
				controller.setMember(reviewer);
				loader.setController(controller);
				Parent root = loader.load();
				Scene scene = new Scene(root);
				next_stage.setScene(scene);
			}
			else {
				headerLabel.setText("Your review was vulgar. Try again");
				reviewer.incrementVulgarPosts();
				if(reviewer.maxVulgarPosts()) {
					reviewer.blockUser();
				}
			}
		}

		else {

			headerLabel.setText("You must give the restaurant a number of stars (1-5)");
		}
	}

	public static void showStage(){
		Stage newStage = new Stage();
		VBox cancelButton = new VBox();
		TextField blockMessage = new TextField("Sorry, you have attempted to post too many vulgar messages. You are now blocked from Melp.");
		cancelButton.getChildren().add(blockMessage);
		Scene stageScene = new Scene(cancelButton, 300, 300);
		newStage.setScene(stageScene);
		newStage.show();
	}

	@FXML
	void OneStarReview(ActionEvent event) {
		number_of_stars = 1;
		star_list.setText("1 Star");
	}

	@FXML
	void TwoStarReview(ActionEvent event) {
		number_of_stars = 2;
		star_list.setText("2 Stars");
	}

	@FXML
	void ThreeStarReview(ActionEvent event) {
		number_of_stars = 3;
		star_list.setText("3 Stars");
	}

	@FXML
	void FourStarReview(ActionEvent event) {
		number_of_stars = 4;
		star_list.setText("4 Stars");
	}

	@FXML
	void FiveStarReview(ActionEvent event) {
		number_of_stars = 5;
		star_list.setText("5 Stars");
	}

	@FXML
	void initialize() {
		headerLabel.setText("Melp: Review a Restaurant");
		star_list.setText("Number of Stars");
	}

	public void setMember(MelpMember current_member) {
		reviewer = current_member;
	}

}
