import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class MyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private void clickTestButton(ActionEvent event) throws IOException {
    	System.out.println("This is a test");
    	Stage next_stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("secondUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    	next_stage.setScene(scene);
    }

    @FXML
    void initialize() {

    }

}
