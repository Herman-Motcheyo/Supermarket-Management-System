package supermarketmanagement.java.utility;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Utility {

	public void TextfieldValid(JFXTextField name) {
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
}
