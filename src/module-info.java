module supermaket {
	requires com.jfoenix;
	requires transitive  javafx.graphics;

	requires javafx.controls;
	requires transitive javafx.base;
	requires javafx.fxml;
	requires java.sql;
	requires mysql.connector.java;
	opens supermarketmanagement.java.model.classe to javafx.base;
	opens supermarketmanagement.java.main to javafx.fxml;
	opens supermarketmanagement.java.control to javafx.fxml,com.sun.javafx.scene.control.behavior.ComboBoxBaseBehavior.ComboBoxBaseBehavior ;
	exports supermarketmanagement.java.main to javafx.graphics,jfoenix.controls.behavior.JFXGenericPickerBehavior;

}