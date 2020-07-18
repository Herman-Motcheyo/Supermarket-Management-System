package supermarketmanagement.java.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

public class SignupController {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField firstname;

    @FXML
    private JFXTextField email;

    @FXML
    private JFXTextField lastname;

    @FXML
    private JFXTextField phone_number;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton btn_signup;

    @FXML
    private JFXButton btn_login;
    
    @FXML
    void signRegistration(KeyEvent event) {

    }

}
