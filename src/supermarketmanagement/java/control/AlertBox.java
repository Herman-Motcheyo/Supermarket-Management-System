package supermarketmanagement.java.control;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.Scene;

public class AlertBox {

	 public static void display(String title , String message) {
		 
		 Stage window = new Stage();
         window.initModality(Modality.APPLICATION_MODAL);
         window.setTitle(title);
         window.setMinWidth(100);
         
         Label label = new Label();
         label.setText(message);
         
         Button btnclose = new Button("Close Windows");
         btnclose.setOnAction(e->window.close());
         
         VBox v = new VBox(100);
         v.getChildren().addAll(label,btnclose);
         v.setAlignment(Pos.CENTER);
         
         Scene scene =new Scene(v);
         window.setScene(scene);
         window.showAndWait();
	 }
}
