import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* This class sets up the GUI for a restaurant profile.
*/
public class RestaurantProfileGUI extends Application {
	
	/**
	* Puts forth the page for a restaurant profile.
	* @param the primary stage
	* @throws Exception
	*/
     @Override
    public void start(Stage primaryStage) throws Exception {
         // just load fxml file and display it in the stage:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("RestaurantProfileUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Restaurant Name");
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