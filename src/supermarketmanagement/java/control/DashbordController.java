package supermarketmanagement.java.control;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import supermarketmanagement.java.model.DAO.Service;
import supermarketmanagement.java.model.classe.Provider;
import supermarketmanagement.java.utility.Utility;

public class DashbordController implements Initializable{

    @FXML
    private TextField code;

    @FXML
    private TextField price;

    @FXML
    private ComboBox<String> provider;

    @FXML
    private ComboBox<String> category;
    
    @FXML
    private ComboBox<String> storehouse;

    @FXML
    private TextField quantity;

    @FXML
    private TextField minqty;

    @FXML
    private JFXTextField codeforOperation;

    @FXML
    private JFXButton update;

    @FXML
    private JFXButton search;

    @FXML
    private JFXButton dalete;

    @FXML
    private JFXButton save;

    @FXML
    private TextArea designation;

    @FXML
    private TextField unity;

    @FXML
    private JFXButton refresh;

    @FXML
    private MenuItem roolback;

    @FXML
    private MenuItem men_exit;

    @FXML
    private MenuItem men_input;

    @FXML
    private MenuItem men_output;

    @FXML
    private MenuItem men_command;

    @FXML
    private MenuItem men_reception;

    @FXML
    private MenuItem men_storehouse;

    @FXML
    private MenuItem men_provider;

    @FXML
    private MenuItem men_cat;

    @FXML
    private TableView<Provider> table;

    @FXML
    private TableColumn<Provider, String> col_code;

    @FXML
    private TableColumn<Provider, String> col_designation;

    @FXML
    private TableColumn<Provider, String> col_category;

    @FXML
    private TableColumn<Provider, Integer> col_unity;

    @FXML
    private TableColumn<Provider, Integer> col_quantity;

    @FXML
    private TableColumn<Provider, String>col_minqty;

    @FXML
    private TableColumn<Provider, Float> col_price;

    @FXML
    private TableColumn<Provider, String> col_provider;

    @FXML
    private TableColumn<Provider, String> col_storehouse;

    boolean rep ;
    ResultSet rs  = null; 
    Service se = new Service();
    String codeP = code.getText();String designationP = designation.getText();
    String storehouseP = storehouse.getValue(); String categoryP = category.getValue();
    String providerP = provider.getValue();
    String unityP = unity.getText(); String priceP = price.getText(); String qty = quantity.getText();String mqty = minqty.getText();
    
    
    @FXML
    void addProduct(ActionEvent e) {
          if(Utility.isEmptyTextbox(categoryP) || Utility.isEmptyTextbox(codeP)|| Utility.isEmptyTextbox(designationP) || Utility.isEmptyTextbox(mqty)
        		  || Utility.isEmptyTextbox(priceP) || Utility.isEmptyTextbox(providerP) || Utility.isEmptyTextbox(qty) || Utility.isEmptyTextbox(storehouseP)
        		  || Utility.isEmptyTextbox(unityP)) {
        	  AlertBox.display("Error ", "One or many attribues are empty");
        	  
          }else {
        	  if(Utility.verifyNumber(mqty) || Utility.verifyNumber(priceP) || Utility.verifyNumber(qty) || Utility.verifyNumber(unityP)) {
        		  System.out.println("good");
        	  }else {
        		  AlertBox.display("Error", "We required number to price,quantity,minqty and unity ");
        	  }
          }
    }

    @FXML
    void deleteProduct(ActionEvent event) {

    }

    @FXML
    void refreshProvider(ActionEvent event) {

    }

    @FXML
    void roolbackMenu(ActionEvent event) {

    }

    @FXML
    void searchProduct(ActionEvent event) {

    }

    @FXML
    void showCommand(ActionEvent event) {

    }

    @FXML
    void showExit(ActionEvent event) {

    }

    @FXML
    void showInput(ActionEvent event) {

    }

    @FXML
    void showOutput(ActionEvent event) {

    }

    @FXML
    void showProvider(ActionEvent event) {

    }

    @FXML
    void showRecepton(ActionEvent event) {

    }

    @FXML
    void showStorehouse(ActionEvent event) {

    }

    @FXML
    void showcategory(ActionEvent event) {

    }

    @FXML
    void updateProduct(ActionEvent event) {

    }
    public void loadComboProvider() {
    	try {
			rs =(ResultSet) se.loadcombobos("provider");
			while(((ResultSet) rs).next()) {
				provider.getItems().addAll(((ResultSet) rs).getString("namepro") );
			}
		} catch (SQLException e) {
			AlertBox.display("Error", "Failed to load combo provider");
			e.printStackTrace();
		}
    }
    public void loadComboStorehouse() {
    	try {
			rs =(ResultSet) se.loadcombobos("storehouse");
			while(((ResultSet) rs).next()) {
				storehouse.getItems().addAll(((ResultSet) rs).getString("nameStore") );
			}
		} catch (SQLException e) {
			AlertBox.display("Error", "Failed to load combo storehouse");
			e.printStackTrace();
		}
    }
    
    public void loadCombocategory() {
    	try {
			rs =(ResultSet) se.loadcombobos("category");
			while(((ResultSet) rs).next()) {
			  category.getItems().add(((ResultSet) rs).getString("nameCat"));
			}
		} catch (SQLException e) {
			AlertBox.display("Error", "Failed to load combo category");
			e.printStackTrace();
		}
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadComboProvider();
		 loadCombocategory();
		 loadComboStorehouse();
	}

}
