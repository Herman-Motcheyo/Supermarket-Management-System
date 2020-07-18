package supermarketmanagement.java.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	 @FXML
	    private JFXPasswordField txf_password;

	    @FXML
	    private JFXTextField txtf_username;

	    @FXML
	    private JFXButton loginbtn;

	    @FXML
	    private JFXButton sigupbtn;

	    @FXML
	    void callSignup(KeyEvent event) {
          
     
	    }

	    @FXML
	    void createAccout(ActionEvent event) {

	    }

	    @FXML
	    protected void loginconnection(ActionEvent event) {
           
              
	    	if (txtf_username.getText().isEmpty() && txf_password.getText().isEmpty()) {
				
	    		txtf_username.setText(" case vide");
	    		txtf_username.setText("bien");
	    		txtf_username.clear();
			}else {
                    Node node = (Node) event.getSource();

                    Stage sigupfx = (Stage) node.getScene().getWindow();

                       sigupfx.close();
	    
	    	        StackPane root = null;
			          try {
				           root = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/signup.fxml"));
			              } catch (IOException e) {
			        	e.printStackTrace();
		   	          }
	     	    Scene scene =new Scene(root);
	            	sigupfx.setScene(scene);
	            	sigupfx.setResizable(false);
	            	sigupfx.show();
			}

	    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //To change body of generated methods, choose Tools | Templates.
    }
    
}