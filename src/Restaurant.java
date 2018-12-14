import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * The Restaurant class creates instances of restaurants registered on the system.
 */
public class Restaurant {
	private String name;
	private RestaurantOwner owner;
	private int averageRating;
	private String location;
	private String typeOfFood;
	public static final String PORT_NUMBER = "8889";

	/**
	 * Constructor for the Restaurant class. Initializes instance variable of name.
	 * @param the name of the restaurant
	 */
	public Restaurant(String name) {
		this.name = name;
	}
	
	/**
	 * Creates a table for the restaurant
	 */
	public void createRestaurantTable() {
		try (
				Connection sqlConnection = DriverManager.getConnection(
						"jdbc:mysql://localhost:" + PORT_NUMBER + "/ebookshop?user=root&password=root");
				Statement stmt = sqlConnection.createStatement();
				) {
			String reviewsTable = "create table Reviews ( " +
					"RestaurantName varchar(50), " +
					"Owner varchar(50), " +
					"Location varchar(50), " +
					"TypeOfFood varchar(50), " +
					"AverageRating int, " +
					"primary key (RestaurantName));";
			stmt.execute(reviewsTable);


		} catch(SQLException e) {
			e.printStackTrace(); 
		}
	}
	
	/**
	 * Creates a table for the reviewer
	 */
	public void createReviewerTable() {
		try (
				Connection sqlConnection = DriverManager.getConnection(
						"jdbc:mysql://localhost:" + PORT_NUMBER + "/ebookshop?user=root&password=root");
				Statement stmt = sqlConnection.createStatement();
				) {
			String sql = "create table Reviewers ( " +
					"RestaurantName varchar(50), " +
					"FOREIGN KEY(memberID) int REFERENCES reviewsTable(RestaurantName);";
			stmt.execute(sql);


		} catch(SQLException e) {
			e.printStackTrace(); 
		}
	}
}
