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
import java.sql.SQLException;

/**
* This class controls the GUI for the home page.
*/
public class HomePageController {

	private CreateMelpDatabase db = new CreateMelpDatabase();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField restaurant_query;

    @FXML
    private Label title;

    @FXML
    void logIn(ActionEvent event) throws IOException {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("Log In");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInUI.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	next_stage.setScene(scene);
    }

    /**
    * Searches the restaurants
    * @param the event of the user
    * @throws IOException
     * @throws SQLException 
    */
    @FXML
    void searchRestaurants(ActionEvent event) throws IOException, SQLException {
    	String restaurant_name = restaurant_query.getText();
    	if (!db.searchRestaurants(restaurant_name)) {
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

    /**
    * Signs up on Melp
    * @param the event of the user
    * @throws IOException
    */
    @FXML
    void signUp(ActionEvent event) throws IOException {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("Sign Up");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpForAccountUI.fxml"));
    	Parent root = loader.load();
    	Scene scene = new Scene(root);
    	next_stage.setScene(scene);
    }

    /**
    * Initializes the Welcome to Melp screen
    */
    @FXML
    void initialize() {
    	title.setText("Welcome to Melp!");
    }

}
