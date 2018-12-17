import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class HomePageController {
	
	public static final String PORT_NUMBER = "3306";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField restaurant_query;

    @FXML
    private Label title;

    @FXML
    void logIn(ActionEvent event) {
    }

    @FXML
    void searchRestaurants(ActionEvent event) throws IOException {
    	String restaurant_name = restaurant_query.getText();
    	try {
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
			Statement stmt = conn.createStatement();
	    	ResultSet rs = stmt.executeQuery("select RestaurantName from restaurants where RestaurantName='" + restaurant_name + "'");
	    	ArrayList<String> restaurants = new ArrayList<String>();
	    	while (rs.next()) {
	    		restaurants.add(rs.getString("RestaurantName"));
	    	}
	    	if (restaurants.size() == 0) {
	    		title.setText("We don't know about that restaurant");
	    	}
	    	else {
	    		Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		    	next_stage.setTitle("Restaurant Profile");
		    	FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantProfileUI.fxml"));
		        RestaurantProfileController controller = new RestaurantProfileController(restaurant_name);
		        loader.setController(controller);
		        Parent root = loader.load();
		        Scene scene = new Scene(root);
		    	next_stage.setScene(scene);
	    	}
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    @FXML
    void signUp(ActionEvent event) throws IOException {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("Sign Up");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpForAccountUI.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	next_stage.setScene(scene);
    }

    @FXML
    void initialize() {
    	title.setText("Welcome to Melp!");
    }

}
