import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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


public class LogInController {
	
	public static final String PORT_NUMBER = "3306";
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
    void logIn(ActionEvent event) throws SQLException, IOException {
    	username = username_field.getText();
    	password = password_field.getText();
    	int check_user_credentials = db.checkUserCredentials(event, username, password);
    	switch (check_user_credentials) {
    	case 0:
    		header.setText("Incorrect Password");
    		break;
    	case 1:
    		header.setText("Incorrect Username");
    		break;
    	case 2:
    		header.setText("Unknown Username");
    		break;
    	}
    }

    @FXML
    void initialize() {
    	header.setText("Log In to MELP");
    }

}
