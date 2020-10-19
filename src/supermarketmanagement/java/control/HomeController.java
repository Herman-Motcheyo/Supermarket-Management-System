package supermarketmanagement.java.control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button stock;

    @FXML
    private Button sold;
    AnchorPane root;
    private Stage stockMana =null;
    private Node node = null;
    
    @FXML
    void goToSold(ActionEvent event) {
        node = (Node) event.getSource();
        loadFxml("category.fxml");
    }

    @FXML
    void goToStock(ActionEvent event) {
        node = (Node) event.getSource();
        loadFxml("Homeb.fxml");
    }
    
    private void loadFxml( String file) {
   
        stockMana = (Stage)node.getScene().getWindow();
        stockMana.close();
    	try {	  
			root = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/"+file));
			Scene scene = new Scene(root);
			stockMana.setScene(scene);
			stockMana.setTitle("Dashbord");
			stockMana.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
}
