import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;

/**
* This class controls the GUI for the restaurant profile.
*/
public class RestaurantProfileController {
	
	private String restaurant_name;
	private static String PORT_NUMBER = "3306";
	
	/**
	* Grabs a restaurant from the database
	* @throws SQLException
	*/
	private void getRestaurantFromDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		String query = "select * from restaurants where RestaurantName = '" + restaurant_name + "'";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		String restaurant_name = rs.getString("RestaurantName");
		query = "select * from reviews where restaurant='" + restaurant_name + "'";
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			String reviewer = rs.getString("reviewer");
			String restaurant = rs.getString("restaurant");
			int stars = rs.getInt("stars");
			String review = rs.getString("review");
			RestaurantReview current = new RestaurantReview(reviewer, restaurant, stars, review);
			
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

    }

}
