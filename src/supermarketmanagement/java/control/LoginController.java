package supermarketmanagement.java.control;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import supermarketmanagement.java.model.DAO.AdministratorDAO;
import supermarketmanagement.java.model.DAO.ConnectDatabase;
import supermarketmanagement.java.model.DAO.DAO;
import supermarketmanagement.java.model.classe.Administrator;
import supermarketmanagement.java.utility.Utility;

public class LoginController implements Initializable, EventHandler<ActionEvent> {

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
	         private Stage home =null;
	    @FXML
	    protected void loginconnection(ActionEvent event) {
           String user ,passw;
           user= txtf_username.getText(); passw = txf_password.getText();
           if (Utility.isEmptyTextbox(user)== true  || Utility.isEmptyTextbox(passw) == true) {
        	   AlertBox.display("Error", "Attributes are required!!");
		      }
           else {
               if (logAdmini(user,passw)) {
            	   Node node = (Node) event.getSource();
            	   home = (Stage) node.getScene().getWindow();
            	   home.close();
       			   goToMain();
       			   
       		     }else {
       			  AlertBox.display("Bad", "No find identification to DAtabase");
       		   }
           }


	    }
	    
	    
            
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	sigupbtn.setOnAction(this);
    	Utility.TextfieldValid(txtf_username);
    	Utility.TextfieldValid(txf_password);
    	
    }

	@Override
	public void handle(ActionEvent event) {
	
		if(event.getSource().equals(sigupbtn)) {
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
           	sigupfx.setResizable(true);
           	sigupfx.show();
		}
		
	}
	/*
	 * permet de charger la fenetre principale
	 * Principe : Recupere le noeud courant  qui est mon stage par un ActionEvent , je le ferme , puis je charge mon xml
	 * pour creer une nouvelle scene et l'ajouter à mon stage
	 *  */
	public void goToMain() {
		try {	  
			AnchorPane root = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/Home.fxml"));
			Scene scene = new Scene(root);
		    home.setScene(scene);
			home.setTitle("Home");
			home.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	 * cette methode recupere les le username et le password de l'admin
	 * puis   si ce couple est present en bd et si c,est le cas il 
	 * @return response ( true ou false )
	 * */
    public boolean logAdmini(String user,String pass) {
		DAO<Administrator, String> admin = new AdministratorDAO(ConnectDatabase.getInstance());
		boolean response=false;
		try {
		    response=admin.find(user,pass);
		} catch (SQLException e) {
		       e.printStackTrace();
		}
		return response;
	}
}