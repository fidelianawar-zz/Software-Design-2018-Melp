import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateMelpDatabase {
	
	private static final String PORT_NUMBER = "3306";

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
	
	public static void main(String[] args) {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/", "root", "root");
			Statement stmt = conn.createStatement();
			stmt.execute("create database if not exists MelpDatabase");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
			stmt = conn.createStatement();
			stmt.execute("create table users (username varchar(50), password varchar(50), primary key(username));");
			stmt.execute("create table restaurants (RestaurantName varchar(50), Owner varchar(50), Location varchar(50), TypeOfFood varchar(50), AverageRating int, primary key (RestaurantName));");
			stmt.execute("create table reviews (reviewer varchar(50), restaurant varchar(50), stars int, review varchar(500), foreign key(reviewer) references users(username));");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
