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
	
	private String username;
	private String password;

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
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + CreateMelpDatabase.PORT_NUMBER + "/MelpDatabase?user=root&password=root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from users where username = '" + username + "'");
		rs.next();
		String check_username = rs.getString("username");
		String check_password = rs.getString("password");
		if (check_username.equals(username)) {
			if (check_password.equals(password)) {
				MelpMember new_member = new MelpMember(username, password);
				rs = stmt.executeQuery("select * from reviews where reviewer = '" + username + "'");
				while(rs.next()) {
					String reviewer = rs.getString("reviewer");
					String restaurant = rs.getString("restaurant");
					int stars = rs.getInt("stars");
					String review = rs.getString("review");
					RestaurantReview add_review = new RestaurantReview(reviewer, review, stars, restaurant);
					new_member.addReviewToMyReviews(add_review);
				}
				Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
		    	next_stage.setTitle("My Profile");
		    	FXMLLoader loader = new FXMLLoader(getClass().getResource("UserProfileUI.fxml"));
		        UserProfileController controller = new UserProfileController();
		        controller.setMember(new_member);
		        loader.setController(controller);
		        Parent root = loader.load();
		        Scene scene = new Scene(root);
		    	next_stage.setScene(scene);
			}
			else {
				header.setText("Incorrect Password");
			}
		}
		else {
			header.setText("Incorrect Username");
		}
    }

    @FXML
    void initialize() {
    	header.setText("Log In to MELP");
    }

}
