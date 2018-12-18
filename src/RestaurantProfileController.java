import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
/**
* This class controls the GUI for the restaurant profile.
*/
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RestaurantProfileController {
	
	@FXML
	private TextArea description;
	
	@FXML
	private TextArea reviews_area;
	
	private String restaurant_name;
	private Restaurant curr_restaurant;

	@FXML
	void returnHome(ActionEvent event) throws IOException {
		Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("MELP!");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	next_stage.setScene(scene);
	}
	
	public RestaurantProfileController(String restaurant_name) throws SQLException {
		this.restaurant_name = restaurant_name;
		getRestaurantFromDatabase();
	}
	
	/**
	* Grabs a restaurant from the database 
	* @throws SQLException
	*/
	private void getRestaurantFromDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + CreateMelpDatabase.PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		String query = "select * from restaurants where RestaurantName = '" + restaurant_name + "'";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		String restaurant_name = rs.getString("RestaurantName");
		String owner = rs.getString("Owner");
		String location = rs.getString("Location");
		String type_of_food = rs.getString("TypeOfFood");
		//String restaurantURL = rs.getString("RestaurantURL");
		int stars = rs.getInt("AverageRating");
		curr_restaurant = new Restaurant(restaurant_name, owner, stars, location, type_of_food, null); //update from null later
		
		query = "select * from reviews where restaurant='" + restaurant_name + "'";
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			String reviewer = rs.getString("reviewer");
			String restaurant = rs.getString("restaurant");
			stars = rs.getInt("stars");
			String review = rs.getString("review");
			RestaurantReview current = new RestaurantReview(reviewer, review, stars, restaurant_name);
			curr_restaurant.addReview(current);
		}
	}
	
	/**
	* Gets the name of the restaurant from the database
	* @param the name of the restaurant
	* @throws SQLException
	*/
	public void getName(String restaurant_name) throws SQLException {
		this.restaurant_name = restaurant_name;
		getRestaurantFromDatabase();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


	/**
	 * Initializes
	*/
    @FXML
    void initialize() {
		description.setText(curr_restaurant.toString());
		reviews_area.setText(curr_restaurant.getReviews());
    }

}
