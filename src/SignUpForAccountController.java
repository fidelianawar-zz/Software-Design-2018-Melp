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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
* This class controls the GUI for a user to sign up for an account.
*/
public class SignUpForAccountController {
	
	private String account_type = "";
	private String user_name;
	private String pass_word;
	private CreateMelpDatabase db = new CreateMelpDatabase();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private MenuButton account_types;
    
    @FXML
    private Label error_check;
    
    @FXML
    private TextField username;
    
    @FXML
    private TextField password;
    
    /**
    * Adds a member to the database
    */
    public void addMemberToDatabase() {
    	db.addMember(user_name, pass_word);
    }
    
    /**
     * checks to see if the user is in the database
     * @param input - the user to be checked
     * @return - true if in, false if not
     * @throws SQLException
     */
    public boolean userInDatabase(String input) throws SQLException {
    	return db.userInDatabase(input);
    }

    /**
    * Creates a user
    * @param the event of the user
    * @throws IOException
    * @throws SQLException 
    */
    
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
     * Returns the user to the home page
     * @param event - the button press action
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
     * This sees if the user is in the database, and if not creates a new user and adds it to the database
     * @param event
     * @throws IOException
     * @throws SQLException
     */
    @FXML
    void createUser(ActionEvent event) throws IOException, SQLException {
    	user_name = username.getText();
    	pass_word = password.getText();
    	if (!account_type.equals("")) {
    		if (!userInDatabase(user_name)) {
		    	MelpMember newmember = new MelpMember(user_name, pass_word);
		    	db.addMember(user_name, pass_word);
		    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		    	next_stage.setTitle("My Profile");
		    	FXMLLoader loader = new FXMLLoader(getClass().getResource("UserProfileUI.fxml"));
		        UserProfileController controller = new UserProfileController();
		        controller.setMember(newmember);
		        loader.setController(controller);
		        Parent root = loader.load();
		        Scene scene = new Scene(root);
		    	next_stage.setScene(scene);
    		}
    		else {
    			error_check.setText("That username has been taken.");
    			error_check.setStyle("-fx-text-fill: red");
    		}
    	}
    	else {
    		error_check.setText("You must choose an account type");
    		error_check.setStyle("-fx-text-fill: red");
    	}
    }

    /**
    * Selects an administrative account
    * @param the event of the user
    */
    @FXML
    void selectAccountTypeAdmin(ActionEvent event) {
    	account_type = "Administrator";
    	account_types.setText(account_type);
    }
    
    /**
    * Selects a restaurant owner account
    * @param the event of the user
    */
    @FXML
    void selectAccountTypeOwner(ActionEvent event) {
    	account_type = "Owner";
    	account_types.setText(account_type);
    }
    
    /**
    * Selects a member account
    * @param the event of the user
    */
    @FXML
    void selectAccountTypeMember(ActionEvent event) {
    	account_type = "Member";
    	account_types.setText(account_type);
    }

    /**
    * Initializes the account types
    */
    @FXML
    void initialize() {
    	account_types.setText("Account Type");
    	error_check.setText("Create Your Account");
    }

}
