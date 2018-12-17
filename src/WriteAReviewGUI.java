import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* This class sets up the GUI that allows a user to write a review.
*/
public class WriteAReviewGUI extends Application {
	
	/**
	* Puts forth the page in which users can view the title of the system in order to write a review.
	* @param the primary stage
	* @throws Exception
	*/
     @Override
    public void start(Stage primaryStage) throws Exception {
         // just load fxml file and display it in the stage:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WriteAReviewUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Melp: Review a Restaurant");
        primaryStage.show();
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