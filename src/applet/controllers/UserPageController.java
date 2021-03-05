import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPageController implements Initializable {
    @FXML
    private JFXButton homeButton;
    @FXML
    private JFXButton myGamesButton;
    @FXML
    private JFXButton myRequestsButton;
    @FXML
    private JFXButton searchButton;
    @FXML
    private AnchorPane infoPane;
    @FXML
    private Label titleLabel;

    private AnchorPane currentPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleHomeButtonAction(ActionEvent event) {
        try {
            infoPane.getChildren().removeAll(currentPane);
            currentPane = FXMLLoader.load(getClass().getResource("homePane.fxml"));
            infoPane.getChildren().add(currentPane);
            titleLabel.setText("Home");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleMyGamesButtonAction(ActionEvent event) {
        try {
            infoPane.getChildren().removeAll(currentPane);
            currentPane = FXMLLoader.load(getClass().getResource("myGamesPane.fxml"));
            infoPane.getChildren().add(currentPane);
            titleLabel.setText("My Games");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
