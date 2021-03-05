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
import java.util.prefs.Preferences;

public class LoginController implements Initializable {
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Label titleLabel;
    @FXML
    private Button loginButton;
//    @FXML
//    private Label errorLabel;

//    Preferences preference;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String username = this.username.getText();
        String password = this.password.getText();

        if (!(username.equals("") || password.equals(""))) {
            System.out.println("Login with Username=\"" + username + "\" and Password=\"" + password + "\"");
            Server sv = Server.getInstance();
            try {
//                if (sv.connectToDatabase("jdbc:mysql://localhost:3306/", username, password)) { //Local URL:jdbc:mysql://localhost:3306/
                if (sv.connectToDatabase(username, password)) {
                    System.out.println("Connected");
                    loginButton.setStyle("-fx-background-color: #37ce50;");
                    toUserPage(event);
                }

            } catch (Exception e) {
                System.out.println("Connection Failed");
                e.getMessage();
                e.getStackTrace();
//                errorLabel.setOpacity(1); errorLabel.setStyle("-fx-text-fill: red;");
//                errorLabel.setText("Check your Username, Password, and/or Connection");
//                loginButton.setStyle("-fx-background-color: #ed4928;");
            }
        }
        else {
            System.out.println("Empty Field");
            loginButton.setStyle("-fx-background-color: #ed4928;");
//            errorLabel.setOpacity(1); errorLabel.setStyle("-fx-text-fill: red;");
//            errorLabel.setText("Missing Username and/or Password");
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void handleExitButtonAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleSignUpButtonAction(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("signupPg.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Hobby Game Signup");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void toUserPage(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("userPage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("User Page");
            stage.setScene(new Scene(root));
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
