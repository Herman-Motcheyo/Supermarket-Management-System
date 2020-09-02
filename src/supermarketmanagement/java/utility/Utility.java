package supermarketmanagement.java.utility;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

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
	
    public static boolean  isEmptyTextbox(String value) {
    	if(value.isEmpty()) {
    		return true;
    	}
    	
		return false;
    }
}
