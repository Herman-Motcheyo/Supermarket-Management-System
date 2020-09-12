package supermarketmanagement.java.control;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import supermarketmanagement.java.model.DAO.ConnectDatabase;
import supermarketmanagement.java.model.DAO.DAO;
import supermarketmanagement.java.model.DAO.StoreHouseDAO;
import supermarketmanagement.java.model.classe.StoreHouse;
import supermarketmanagement.java.utility.Utility;

public class StorehouseController implements Initializable {

    @FXML
    private JFXButton submitS;

    @FXML
    private JFXButton deleteS;

    @FXML
    private JFXTextField nameS;

    @FXML
    private JFXTextArea descriptionS;

    @FXML
    private TableView<StoreHouse> table;

    @FXML
    private TableColumn<StoreHouse, String> col_name;

    @FXML
    private TableColumn<StoreHouse, String> col_description;

    @FXML
    private JFXButton refresh;
     
    
    ObservableList<StoreHouse> obs = FXCollections.observableArrayList();
    DAO<StoreHouse, String> store = new StoreHouseDAO(ConnectDatabase.getInstance());
    String nameStr,descrStr;
    StoreHouse sth;
    
    
    @FXML
    void delete(ActionEvent event) {
    	nameStr = nameS.getText();
        if(Utility.isEmptyTextbox(nameStr)) {
     	  AlertBox.display("Error", "We required name of code"); 
        }else {
        	sth =new StoreHouse();
        	sth= store.find(nameStr);
  		  if(sth != null) {
  			store.delete(sth); 
  			nameS.clear();
  		  }

        }
    }

    @FXML
    void refreshStore(ActionEvent event) {
    	table.getItems().clear();;
    	loadTable();
    }

    @FXML
    void submit(ActionEvent event) {

    	nameStr = nameS.getText();descrStr = descriptionS.getText(); 
     if(Utility.isEmptyTextbox(nameStr)||Utility.isEmptyTextbox(descrStr) ) {
     	   AlertBox.display("Error", "Attributes are required!!");
     }
     else {
		 sth= new StoreHouse(nameStr, descrStr);
		 store.create(sth);
    	 nameS.clear();descriptionS.clear();
    	 table.refresh();
     }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	Utility.TextfieldValid(nameS);
	loadTable();
		
	}
	 void loadTable() {
			try {

				ResultSet rt = ConnectDatabase.getInstance().createStatement().executeQuery("SELECT * FROM storehouse");
				while(rt.next()) {
					obs.add(new StoreHouse(rt.getString("nameStore"),  rt.getString("descriptionStore") ));
				}
			} catch (SQLException e) {
			AlertBox.display("Error", "Do not load table view");
				e.printStackTrace();
			}
			col_name.setCellValueFactory(new PropertyValueFactory<>("nameStore"));
			col_description.setCellValueFactory(new PropertyValueFactory<>("descriptionStore"));
			table.setItems(obs);
		 
	 }

}
