package supermarketmanagement.java.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
	launch();

	}

	@Override
	public void start(Stage login) throws Exception {
	 AnchorPane root=  FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/Home.fxml")) ;
	//  StackPane root = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/loginb.fxml"));
		Scene scene =new Scene(root); 
	 login.setScene(scene);
	 login.setResizable(true);
	 login.show();
		
	}

}
