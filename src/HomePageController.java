import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TextField user_query;
    
    @FXML
    private TextField restaurant_query;

    @FXML
    private Label title;

    @FXML
	private ImageView header_image;

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
    		title.setStyle("-fx-text-fill: red");
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
    
    @FXML
    void searchUsers(ActionEvent event) throws IOException, SQLException {
    	String user_name = user_query.getText();
    	if (db.userInDatabase(user_name)) {
    		MelpMember next_member = db.getMember(user_name);
    		Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	next_stage.setTitle("User Profile");
	    	FXMLLoader loader = new FXMLLoader(getClass().getResource("ViewUserProfileUI.fxml"));
	        ViewUserProfileController controller = new ViewUserProfileController();
	        controller.setMember(next_member);
	        loader.setController(controller);
	        Parent root = loader.load();
	        Scene scene = new Scene(root);
	    	next_stage.setScene(scene);
    	}
    	else {
    		title.setText("That user doesn't exist");
    		title.setStyle("-fx-text-fill: red");
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
    	String imageSource = "https://pbs.twimg.com/profile_images/491531991255244800/SfWumxJP.png";
    	Image image = new Image(imageSource);
    	header_image.setImage(image);
    	title.setText("Welcome to Melp!");
    }

}
