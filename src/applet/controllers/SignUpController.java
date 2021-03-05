import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {
    @FXML
    private JFXTextField username;
    @FXML
    private JFXTextField firstname;
    @FXML
    private JFXTextField lastname;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password1;
    @FXML
    private JFXPasswordField password2;

    @FXML
    private void handleSignUpButtonAction(ActionEvent event) {
        String username = this.username.getText();
        String firstname = this.firstname.getText();
        String lastname = this.lastname.getText();
        String email = this.email.getText();
        String password1 = this.password1.getText();
        String password2 = this.password2.getText();
        if (username != null &&
                firstname != null &&
                lastname != null &&
                email != null &&
                password1 != null &&
                (password1.equals(password2))) {

        }
    }
}
