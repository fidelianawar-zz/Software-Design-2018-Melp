import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

/**
* The LogInController class controls the GUI for the LogIn for Melp. 
*/
public class LogInController {
	
	private String username;
	private String password;
	private CreateMelpDatabase db = new CreateMelpDatabase();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Label header;

    @FXML
    private TextField password_field;

    @FXML
    private TextField username_field;
    
    /**
    * Signs up a user
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
    * Logs a user in
    * @param the event of the user
    * @throws SQLException
    * @throws IOException 
    */
    @FXML
    void logIn(ActionEvent event) throws SQLException, IOException {
    	username = username_field.getText();
    	password = password_field.getText();
    	int check_user_credentials = db.checkUserCredentials(event, username, password);
    	switch (check_user_credentials) {
    	case 0:
    		header.setText("Incorrect Password");
    		header.setStyle("-fx-text-fill: red");
    		break;
    	case 1:
    		header.setText("Incorrect Username");
    		header.setStyle("-fx-text-fill: red");
    		break;
    	case 2:
    		header.setText("Unknown Username");
    		header.setStyle("-fx-text-fill: red");
    		break;
    	}
    }

    /**
    * Returns a user home
    * @param the event of the user
    * @throws IOException
    */
    @FXML
    void returnHome(ActionEvent event) throws IOException {
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	next_stage.setTitle("MELP!");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	next_stage.setScene(scene);
    }
    
    /**
    * Initializes the Melp LogIn
    */
    @FXML
    void initialize() {
    	header.setText("Log In to MELP");
    }

}
