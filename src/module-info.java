module supermaket {
	

	requires com.jfoenix;
	//requires javafx.fxml;
	
	requires transitive  javafx.graphics;

	requires javafx.controls;
	requires transitive javafx.base;
	requires javafx.fxml;
	//exports com.sun.javafx.scene.control.behavior.ComboBoxBaseBehavior.ComboBoxBaseBehavior to com.jfoenix;
	
	opens supermarketmanagement.java.main to javafx.fxml;
	opens supermarketmanagement.java.control to javafx.fxml,com.sun.javafx.scene.control.behavior.ComboBoxBaseBehavior.ComboBoxBaseBehavior ;
	exports supermarketmanagement.java.main to javafx.graphics,jfoenix.controls.behavior.JFXGenericPickerBehavior;
	//exports jfoenix.controls.behavior.JFXGenericPickerBehavior;// (in module com.jfoenix) cannot access class com.sun.javafx.scene.control.behavior.ComboBoxBaseBehavior 
	//exports supermarketmanagement.java.main;ComboBoxBaseBehavior
	// exports com.sun.javafx.scene.control.behavior to module com.jfoenix;
}