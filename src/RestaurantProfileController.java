import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class RestaurantProfileController {
	
	@FXML
	private TextArea description;
	
	@FXML
	private TextArea reviews_area;
	
	private String restaurant_name;
	private Restaurant curr_restaurant;
	private static String PORT_NUMBER = "3306";
	
	public RestaurantProfileController(String restaurant_name) throws SQLException {
		this.restaurant_name = restaurant_name;
		getRestaurantFromDatabase();
	}
	
	private void getRestaurantFromDatabase() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		String query = "select * from restaurants where RestaurantName = '" + restaurant_name + "'";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		String restaurant_name = rs.getString("RestaurantName");
		String owner = rs.getString("Owner");
		String location = rs.getString("Location");
		String type_of_food = rs.getString("TypeOfFood");
		int stars = rs.getInt("AverageRating");
		curr_restaurant = new Restaurant(restaurant_name, owner, stars, type_of_food, location);
		
		query = "select * from reviews where restaurant='" + restaurant_name + "'";
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			String reviewer = rs.getString("reviewer");
			String restaurant = rs.getString("restaurant");
			stars = rs.getInt("stars");
			String review = rs.getString("review");
			RestaurantReview current = new RestaurantReview(reviewer, review, stars, restaurant_name);
			System.out.println(current);
			curr_restaurant.addReview(current);
		}
	}
	
	public void getName(String restaurant_name) throws SQLException {
		this.restaurant_name = restaurant_name;
		getRestaurantFromDatabase();
	}

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void initialize() {
		description.setText(curr_restaurant.toString());
		reviews_area.setText(curr_restaurant.getReviews());
    }

}
