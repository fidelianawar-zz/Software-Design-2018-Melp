import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class sets up the GUI for a user to sign up for an account.
 */
public class SignUpForAccountGUI extends Application {

	/**
	 * Puts forth the page in which users can sign up for an account.
	 * @param the primary stage
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// just load fxml file and display it in the stage:
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUpForAccountUI.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sign Up");
		primaryStage.show();
	}

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
	 * Main method to support non-JavaFX-aware environments
	 * @param args
	 */
	public static void main(String[] args) {
		// starts the FX toolkit, instantiates this class, 
		// and calls start(...) on the FX Application thread:
		launch(args); 
	}
} 