package supermarketmanagement.java.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
//import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Loginform extends Application {

	public static void main(String[] args) {
	launch();

	}

	@Override
	public void start(Stage login) throws Exception {
	 // FXMLLoader loader =new FXMLLoader(getClass().getResource("/supermarketmanagement/ressource/fxml/login.fxml"));
		AnchorPane root=  FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/user.fxml")) ;
	   // StackPane root = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/signup.fxml"));
		Scene scene =new Scene(root);
	 login.setScene(scene);
	 login.setResizable(true);
	 login.show();
		
	}

}
