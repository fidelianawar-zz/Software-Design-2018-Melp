import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Restaurant {
	private String name;
	private String owner;
	private int averageRating;
	private String location;
	private String typeOfFood;
	public static final String PORT_NUMBER = "8889";

	public Restaurant() {

	}


	public void createReviewsTable() {
		try (
				Connection sqlConnection = DriverManager.getConnection(
						"jdbc:mysql://localhost:" + PORT_NUMBER + "/ebookshop?user=root&password=root");
				Statement stmt = sqlConnection.createStatement();
				) {
			String sql = "create table Reviews ( " +
					"RestaurantName varchar(50), " +
					"Owner varchar(50), " +
					"Location varchar(50), " +
					"TypeOfFood varchar(50), " +
					"AverageRating int, " +
					"primary key (RestaurantName));";
			stmt.execute(sql);


		} catch(SQLException e) {
			e.printStackTrace(); 
		}
	}

}
