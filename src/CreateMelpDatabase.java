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
			if (!checkIfTableExists("reviews", conn)) {
				stmt.execute("create table Reviews (restaurant varchar(50), stars int, review varchar(500));");
			}
			if (checkIfTableExists("users", conn)) {
				stmt.execute("create table Users (username varchar(50), password varchar(50), primary key(username));");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
