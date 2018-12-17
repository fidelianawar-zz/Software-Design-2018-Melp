import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
* This class runs the application. It is the framework upon which all of our User Interface depends.
*/
public class RunApplication extends Application {
	
	/**
	* Puts forth the Melp home page
	* @param the primary stage
	* @throws Exception
	*/
     @Override
    public void start(Stage primaryStage) throws Exception {
         // just load fxml file and display it in the stage:
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MELP!");
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