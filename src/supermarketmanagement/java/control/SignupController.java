package supermarketmanagement.java.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
//import com.jfoenix.validation.RequiredFieldValidator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import supermarketmanagement.java.model.classe.Administrator;
import supermarketmanagement.java.utility.Utility;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SignupController implements Initializable, EventHandler<ActionEvent> {

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
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_signup.setOnAction(this);
		btn_login.setOnAction(this);
		validator(username);validator(firstname);validator(lastname);validator(email);validator(phone_number);
	}

	@Override
	public void handle(ActionEvent event) {
	 
		if( event.getSource().equals(btn_signup) ) {
			
			   String fname,femail,lname,fpassword,uname,number;
			      boolean n;
			       fname = firstname.getText();
			       lname = lastname.getText();
			       uname = username.getText();
			       femail = email.getText();
			       fpassword = password.getText();
			       number = phone_number.getText();
			       
			       n =verifyNumber(phone_number, number);
			       if (n) {

			    	      long nb = Long.parseLong(number);
			    	      saveAdmin(fname, femail, lname, fpassword, uname, nb);
			    	      AlertBox.display("SUcess", "Sucess operation");
			    	      firstname.clear();
			    	      lastname.clear();
			    	      username.clear();
			    	      email.clear();
			    	      password.clear();
			    	      phone_number.clear();
				}
			 
			         
		}else if(event.getSource().equals(btn_login)) {
		     Node node = (Node) event.getSource();

             Stage login = (Stage) node.getScene().getWindow();

                login.close();
 
 	        StackPane root = null;
		          try {
			           root = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/login.fxml"));
		              } catch (IOException e) {
		        	e.printStackTrace();
	   	          }
  	    Scene scene =new Scene(root);
         	login.setScene(scene);
         	login.setResizable(true);
         	login.show();

		}
		
	}
   
	private boolean  verifyNumber( JFXTextField text, String value) {
    	
    	try {
			@SuppressWarnings("unused")
			long number = Long.parseLong(value);
		      return true;	
		} catch (NumberFormatException e) {
			 	AlertBox.display("ERROR INPUT VALUE", " Mobile "+ value + " IS Not NUMBER ");
		return false;
		}
    	
    }
     

    
    private void  saveAdmin(String fname,String femail,String lname,String fpassword,String uname,long number) {
    	Administrator admin = new Administrator() ;
    	admin.setUsername(uname);
    	admin.setFirstname(fname);
    	admin.setLastname(lname);
    	admin.setEmail(femail);
    	admin.setNumber_phone(number);
    	admin.setPassword(fpassword);
    	
    	admin.saveAdmin();
    }
    
    public void validator( JFXTextField name) {
    	
    	Utility util =new Utility() ;
    if (!name.equals(phone_number)) {
       util.TextfieldValid(name);   	

    }else {
    	NumberValidator validate = new NumberValidator();
    	name.getValidators().add(validate);
    	validate.setMessage("Only number are required");
    	
    	name.focusedProperty().addListener(new ChangeListener<Boolean>() {
	        @Override
	        public void changed(ObservableValue<? extends Boolean> observable , Boolean OldValue , Boolean newValue) {
	        	if(!newValue)
	        		name.validate();
	        }
    	});
    }
    
	}	
    
}


