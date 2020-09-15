package supermarketmanagement.java.utility;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import supermarketmanagement.java.control.AlertBox;

public class Utility{

	public static void TextfieldValid(JFXPasswordField name) {
    	RequiredFieldValidator validate = new RequiredFieldValidator();
    	name.getValidators().add(validate);
    	validate.setMessage("No Input Given");
    	
    	name.focusedProperty().addListener(new ChangeListener<Boolean>() {
		 @Override
		 public void changed( ObservableValue< ? extends Boolean> observable , Boolean Oldvalue ,Boolean newValue  ) {
		         if(!newValue) {
		        	 name.validate();
		         }
		        	 
		 }
    	});
	}	
	public static void TextfieldValid(JFXTextField name) {
    	RequiredFieldValidator validate = new RequiredFieldValidator();
    	name.getValidators().add(validate);
    	validate.setMessage("No Input Given");
    	
    	name.focusedProperty().addListener(new ChangeListener<Boolean>() {
		 @Override
		 public void changed( ObservableValue< ? extends Boolean> observable , Boolean Oldvalue ,Boolean newValue  ) {
		         if(!newValue) {
		        	 name.validate();
		         }
		        	 
		 }
    	});
	}
	
	public static void cleanTextfied(JFXTextField n1,JFXTextField n2,JFXTextField n3,JFXTextField n4,JFXTextField n5,JFXPasswordField n6)
	{
         n1.clear();n2.clear();n3.clear();n4.clear();n5.clear();n6.clear();	
	}
	
	
	public static void cleanTextfied(JFXTextField n1,JFXTextField n2,JFXTextField n3,JFXTextField n4,JFXTextField n5)
	{
         n1.clear();n2.clear();n3.clear();n4.clear();n5.clear();	
	}
   
	
	public static boolean  isEmptyTextbox(String value) throws NullPointerException{
    	if(value.isEmpty()) {
    		return true;
    	}
    	
		return false;
    }
    
    public static void printSucess() {
        Alert sucess = new Alert(AlertType.INFORMATION);
        sucess.setHeaderText("Operation are good execute");
        sucess.setContentText("SUcess Operation") ;
        sucess.showAndWait();
    }
    public static void printError() {
		Alert problem =new Alert(AlertType.ERROR);
		problem.setTitle("Error");
		problem.setHeaderText("These informations are also use( email and username)");
        problem.setContentText("Ces informations ne sont pas à etre utiliser");
        problem.showAndWait();
    }
    /*
     * cette methode est  utilisée pour verifier si l'utilisateur à entrer un nombre
     * principe: on cree un objet de la class NumberValidator de Jfoenix puis on appele*
     * la methode getValidators() en l'ajoutant le type de validation
     * **/
    public  static void validNumber(JFXTextField name) {
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
    
    /*
     * cette methode verifie si le numero de téléphone est un nombre 
     * si on arrive à caster la chaine en  entier alors on retourne true sinon false
     * 
     * */
 	public static  boolean  verifyNumber( JFXTextField text, String value) {
     	
     	try {
 			@SuppressWarnings("unused")
 			long number = Long.parseLong(value);
 		      return true;	
 		} catch (NumberFormatException e) {
 			 	AlertBox.display("ERROR INPUT VALUE", " Mobile "+ value + " IS Not NUMBER ");
 		return false;
 		}
     	
     } 	
 	public static  boolean  verifyNumber(  String value) {
 		@SuppressWarnings("unused")
		long numb;
      	try {
  			 numb = Long.parseLong(value);
  		      return true;	
  		} catch (NumberFormatException e) {
  			 	AlertBox.display("ERROR INPUT VALUE", " Mobile "+ value + " IS Not NUMBER ");
  		return false;
  		}
      	
      }
      
}
