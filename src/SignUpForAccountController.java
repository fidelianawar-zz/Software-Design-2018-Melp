import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpForAccountController {
	
	private static final int PORT_NUMBER = 3306;
	
	private String account_type = "";
	private String user_name;
	private String pass_word;

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

    public void addMemberToDatabase() {
    	try {
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/MelpDatabase?user=root&password=root");
    		Statement stmt = conn.createStatement();
    		String username = "'" + user_name + "',";
    		String password = "'" + pass_word + "'";
    		String command = username + password;
    		stmt.execute("insert into users values (" + command + ");");
    	}
    	catch (SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void createUser(ActionEvent event) throws IOException {
    	if (!account_type.equals("")) {
	    	user_name = username.getText();
	    	pass_word = password.getText();
    		addMemberToDatabase();
	    	MelpMember newmember = new MelpMember(user_name, pass_word);
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
    		error_check.setText("You must choose an account type");
    	}
    }

    @FXML
    void selectAccountTypeAdmin(ActionEvent event) {
    	account_type = "Administrator";
    	account_types.setText(account_type);
    }
    
    @FXML
    void selectAccountTypeOwner(ActionEvent event) {
    	account_type = "Owner";
    	account_types.setText(account_type);
    }
    
    @FXML
    void selectAccountTypeMember(ActionEvent event) {
    	account_type = "Member";
    	account_types.setText(account_type);
    }

    @FXML
    void initialize() {
    	account_types.setText("Account Type");
    	error_check.setText("Create Your Account");
    }

}
