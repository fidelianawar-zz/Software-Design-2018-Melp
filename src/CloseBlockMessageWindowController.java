import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class CloseBlockMessageWindowController {

    @FXML
    void closeWindow(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("BlockedMessageUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
    }

}