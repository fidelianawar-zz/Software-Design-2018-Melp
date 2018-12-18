import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* This class creates the Melp Database.
*/
public class CreateMelpDatabase {
	
	private static final String PORT_NUMBER = "3306";
	private static final int INCORRECT_PASSWORD = 0;
	private static final int INCORRECT_USERNAME = 1;
	private static final int UNKNOWN_PASSWORD = 2;
	private Connection conn;

	public void loadDatabase() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/", "root", "root");
			Statement stmt = conn.createStatement();
			stmt.execute("create database if not exists MelpDatabase");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
			stmt = conn.createStatement();
			stmt.execute("create table users (username varchar(50), password varchar(50), primary key(username));");
			stmt.execute("create table restaurants (RestaurantName varchar(50), Owner varchar(50), Location varchar(50), TypeOfFood varchar(50), AverageRating int, primary key (RestaurantName));");
			stmt.execute("create table reviews (reviewer varchar(50), restaurant varchar(50), stars int, review varchar(500), foreign key(reviewer) references users(username), foreign key(restaurant) references restaurants(RestaurantName));");
			addRestaurant("Rastall", "Bon Apetite", "CC", "Eclectic", 2, "https://coloradocollege.cafebonappetit.com/cafe/rastall-dining-hall/");
			addRestaurant("Benjis", "Bon Apetite", "CC", "Grill", 4, "https://coloradocollege.cafebonappetit.com/cafe/benjamins/");
			addRestaurant("Preserve", "Bon Apetite", "CC", "Grill", 5, "https://coloradocollege.cafebonappetit.com/cafe/the-preserve/");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int checkUserCredentials(ActionEvent event, String username, String password) throws SQLException, IOException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where username = '" + username + "'");
		if (rs.next()) {
			String check_username = rs.getString("username");
			String check_password = rs.getString("password");
			if (check_username.equals(username)) {
				if (check_password.equals(password)) {
					MelpMember new_member = new MelpMember(username, password);
					rs = stmt.executeQuery("select * from reviews where reviewer = '" + username + "'");
					while(rs.next()) {
						String reviewer = rs.getString("reviewer");
						String restaurant = rs.getString("restaurant");
						int stars = rs.getInt("stars");
						String review = rs.getString("review");
						RestaurantReview add_review = new RestaurantReview(reviewer, review, stars, restaurant);
						new_member.addReviewToMyReviews(add_review);
					}
					Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
			    	next_stage.setTitle("My Profile");
			    	FXMLLoader loader = new FXMLLoader(getClass().getResource("UserProfileUI.fxml"));
			        UserProfileController controller = new UserProfileController();
			        controller.setMember(new_member);
			        loader.setController(controller);
			        Parent root = loader.load();
			        Scene scene = new Scene(root);
			    	next_stage.setScene(scene);
				}
				else {
					//show that password is not correct
					return INCORRECT_PASSWORD;
				}
			}
			else {
				//show that username is not correct
				return INCORRECT_USERNAME;
			}
		}
		else {
			//show that username doesn't exist
			return UNKNOWN_PASSWORD;
		}
		return 0;
	}
	
	public Restaurant getRestaurantsFromDatabase(String restaurant_name) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		String query = "select * from restaurants where RestaurantName = '" + restaurant_name + "'";
		ResultSet rs = stmt.executeQuery(query);
		rs.next();
		restaurant_name = rs.getString("RestaurantName");
		String owner = rs.getString("Owner");
		String location = rs.getString("Location");
		String type_of_food = rs.getString("TypeOfFood");
		int stars = rs.getInt("AverageRating");
		Restaurant curr_restaurant = new Restaurant(restaurant_name, owner, stars, type_of_food, location, ""); //this should be the url
		query = "select * from reviews where restaurant='" + restaurant_name + "'";
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			String reviewer = rs.getString("reviewer");
			stars = rs.getInt("stars");
			String review = rs.getString("review");
			RestaurantReview current = new RestaurantReview(reviewer, review, stars, restaurant_name);
			curr_restaurant.addReview(current);
		}
		return curr_restaurant;
	}
	
	public boolean searchRestaurants(String restaurant_name) {
		try {
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
			Statement stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery("select RestaurantName from restaurants where RestaurantName='" + restaurant_name + "'");
	    	ArrayList<String> restaurants = new ArrayList<String>();
	    	while (rs.next()) {
	    		restaurants.add(rs.getString("RestaurantName"));
	    	}
	    	if (restaurants.size() == 0) {
	    		return false;
	    	}
	    	else {
	    		return true;
	    	}
		}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
		return false;
	}
	
	public void addReview(MelpMember reviewer, RestaurantReview curr_rev) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
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
	
	public boolean userInDatabase(String input) throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		String query = "select username from users where username = '" + input + "'";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addMember(String user_name, String pass_word) {
		try {
			Statement stmt = conn.createStatement();
			String username = "'" + user_name + "', ";
			String password = "'" + pass_word + "'";
			String command = username + password;
			stmt.execute("insert into users values (" + command + ");");
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	/**
	* This class checks if a table exists.
	* @param the name of the table
	* @parm the connection
	*/
	
	public static boolean checkIfTableExists(String tablename, Connection conn) {
		try {
			DatabaseMetaData dbm = conn.getMetaData();
			ResultSet tables = dbm.getTables(null, null, tablename, null);
			if (tables.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	* This class adds a restaurant to the database.
	* @param the name of the restaurant
	* @param the owner of the restaurant
	* @param the location of the restaurant
	* @param the type of food of the restaurant
	* @param the average rating of the restaurant
	* @throws SQLException 
	*/
	public void addRestaurant(String name, String owner, String location, String type, int rating, String url) throws SQLException {
		Statement stmt = conn.createStatement();
		String concatenate = "'" + name + "', '" + owner + "', '" + location + "', '" + type + "', '" + rating + "', '" + url + "'";
		stmt.execute("insert into restaurants values (" + concatenate + ");");
	}
}
