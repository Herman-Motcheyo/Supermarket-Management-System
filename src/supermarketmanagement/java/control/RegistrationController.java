package supermarketmanagement.java.control;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

public class RegistrationController {

    @FXML
    private JFXTextField firstnameUser;

    @FXML
    private JFXTextField lastnameUser;

    @FXML
    private JFXTextField mobileUser;

    @FXML
    private JFXTextField emailUser;

    @FXML
    private JFXCheckBox checkboxmaleUser;

    @FXML
    private JFXCheckBox checkboxfemaleUser;

    @FXML
    private JFXButton saveUser;

    @FXML
    private DatePicker dateUserregistration;

    @FXML
    private AnchorPane checkboxfemalecustomer;

    @FXML
    private JFXTextField customerfirstname;

    @FXML
    private JFXTextField customerlastname;

    @FXML
    private JFXTextField mobilecustomer;

    @FXML
    private JFXTextField custromeremail;

    @FXML
    private JFXCheckBox checkboxmaleCustomer;

    @FXML
    private JFXButton saveCustomer;

    @FXML
    private DatePicker dateCustomerregistration;

}
