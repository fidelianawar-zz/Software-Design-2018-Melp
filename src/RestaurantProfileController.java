import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
	private CreateMelpDatabase db = new CreateMelpDatabase();

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
		curr_restaurant = db.getRestaurantsFromDatabase(restaurant_name);
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
