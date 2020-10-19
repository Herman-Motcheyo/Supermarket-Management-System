package supermarketmanagement.java.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import supermarketmanagement.java.model.DAO.AdministratorDAO;
import supermarketmanagement.java.model.DAO.ConnectDatabase;
import supermarketmanagement.java.model.DAO.DAO;
import supermarketmanagement.java.model.classe.Administrator;
import supermarketmanagement.java.utility.Utility;
import javafx.animation.FadeTransition;
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
			       if (Utility.isEmptyTextbox(fname)  || Utility.isEmptyTextbox(lname) || Utility.isEmptyTextbox(uname)  || Utility.isEmptyTextbox(femail) || Utility.isEmptyTextbox(fpassword) || Utility.isEmptyTextbox(number)) {
			    	    
			    	   Alert sucess = new Alert(AlertType.ERROR);
			    	      sucess.setContentText("Only attributes are required");
			    	      sucess.setResizable(true);
			    	      sucess.showAndWait();
			       }else {
			           n =Utility.verifyNumber(phone_number, number);
				       if (n) {

				    	      long nb = Long.parseLong(number);
				    	      saveAdmin(fname, femail, lname, fpassword, uname, nb);
				    	      Utility.cleanTextfied(username,phone_number, lastname, firstname, email,password);
				    	      Alert sucess = new Alert(AlertType.CONFIRMATION);
				    	      sucess.setContentText("Operations are good execute");
				    	      sucess.setResizable(true);
				    	      sucess.showAndWait();

					}
			       }
			         
		}else if(event.getSource().equals(btn_login)) {
            FadeTransition transition = new FadeTransition(Duration.seconds(10 ));
     
            transition.setToValue(1);
            transition.setFromValue(0);
            transition.setOnFinished(event1 -> {

		     Node node = (Node) event.getSource();

             Stage login = (Stage) node.getScene().getWindow();

                login.close();
 
 	        StackPane root = null;
		          try {
			           root = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/loginb.fxml"));
		              } catch (IOException e) {
		        	e.printStackTrace();
	   	          }
		    /*  	Timeline t = new Timeline();
		    	t.getKeyFrames().add(
		                new KeyFrame(Duration.seconds(5), new javafx.animation.KeyValue(root.layoutXProperty(), 300))
		    	);
		    	t.play();*/
		    	
		    	
  	        Scene scene =new Scene(root);
         	login.setScene(scene);
         	login.setResizable(true);
         	login.show();
    
            });
            transition.play();
		
        }
      
		
	}


    
    private void  saveAdmin(String fname,String femail,String lname,String fpassword,String uname,long number) {
 
    	DAO <Administrator, String> ad= new AdministratorDAO(ConnectDatabase.getInstance());

    	Administrator admin = new Administrator() ;
    	admin.setUsername(uname);
    	admin.setFirstname(fname);
    	admin.setLastname(lname);
    	admin.setEmail(femail);
    	admin.setNumber_phone(number);
    	admin.setPassword(fpassword);
    	 ad.create(admin);
    }
    
    public  void validator( JFXTextField name) {
    	
    if (!name.equals(phone_number)) {
    	Utility.TextfieldValid(name);   	

    }else {
    	Utility.validNumber(name);
    }
    
	}	

    
}


