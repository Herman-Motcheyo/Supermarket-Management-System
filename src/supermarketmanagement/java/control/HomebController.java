package supermarketmanagement.java.control;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import supermarketmanagement.java.model.DAO.ConnectDatabase;
import supermarketmanagement.java.model.DAO.DAO;
import supermarketmanagement.java.model.DAO.ProductDAO;
import supermarketmanagement.java.model.DAO.Service;
import supermarketmanagement.java.model.classe.Product;
import supermarketmanagement.java.utility.Utility;

public class HomebController implements Initializable, EventHandler<ActionEvent>{

	 @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private Button men_storehouse;

	    @FXML
	    private Button men_provider;

	    @FXML
	    private Button men_commande;

	    @FXML
	    private Button men_enter;

	    @FXML
	    private Button men_output;

	    @FXML
	    private Button men_category;

	    @FXML
	    private Button help;

	    @FXML
	    private Button men_product;

	    @FXML
	    private TextField codeforOp;

	    @FXML
	    private TextField code;

	    @FXML
	    private TextField unity;

	    @FXML
	    private TextField quantity;

	    @FXML
	    private TextField price;

	    @FXML
	    private TextField min_quantity;

	    @FXML
	    private ComboBox<String> provider;

	    @FXML
	    private ComboBox<String> category;

	    @FXML
	    private ComboBox<String> storehouse;

	    @FXML
	    private TextArea designation;

	    @FXML
	    private Button save;

	    @FXML
	    private Button delete;

	    @FXML
	    private Button update;

	    @FXML
	    private Button search;

	    @FXML
	    private JFXButton refresh;

	    @FXML
	    private TableView<Product> table;

	    @FXML
	    private TableColumn<Product, String> col_code;

	    @FXML
	    private TableColumn<Product, String> col_designation;

	    @FXML
	    private TableColumn<Product, String> col_category;

	    @FXML
	    private TableColumn<Product, Integer> col_unity;

	    @FXML
	    private TableColumn<Product, Integer> col_quantity;

	    @FXML
	    private TableColumn<Product, Integer> col_minqty;

	    @FXML
	    private TableColumn<Product, Float> col_price;

	    @FXML
	    private TableColumn<Product, String> col_provider;

	    @FXML
	    private TableColumn<Product, String> col_storehouse;

	    @FXML
	    private Button word;

	    @FXML
	    private Button excel;
	    
	    boolean rep ;
	    ResultSet rs  = null; 
	    Product P;
	    Service se = new Service();
	    DAO<Product, String> product = new ProductDAO(ConnectDatabase.getInstance());
	    String codeP; String storehouseP;String designationP; String providerP;String unityP; String priceP;
	    String qty;String mqty ;String categoryP ;int uni,q,minq;float p;
	    

    @FXML
    void addProduct(ActionEvent event) {
         codeP = code.getText(); designationP = designation.getText();
 	     storehouseP = storehouse.getValue();  categoryP = category.getValue();
 	     providerP = provider.getValue();
 	     unityP = unity.getText();  priceP = price.getText();  qty = quantity.getText(); mqty = min_quantity.getText();
 
 	    if(categoryP == null || Utility.isEmptyTextbox(codeP)|| Utility.isEmptyTextbox(designationP) || Utility.isEmptyTextbox(mqty)
      		  || Utility.isEmptyTextbox(priceP) || providerP == null|| Utility.isEmptyTextbox(qty) || storehouseP ==null
      		  || Utility.isEmptyTextbox(unityP)) {
      	  AlertBox.display("Error ", "One or many attribues are empty");
      	  
        }else {
      	  if(Utility.verifyNumber(mqty) || Utility.verifyNumber(priceP) || Utility.verifyNumber(qty) || Utility.verifyNumber(unityP)) {
      		 try {
         		  uni = Integer.parseInt(unityP); q =Integer.parseInt(qty);minq =Integer.parseInt(mqty);p =Float.parseFloat(priceP);
			} catch (NumberFormatException e) {
				  AlertBox.display("Error", "We required number to price,quantity,minqty and unity ");			}
      		  
      		 P = new Product(codeP, designationP, uni, p, minq, q, providerP, categoryP, storehouseP);
      		  product.create(P);
      		  System.out.println("good");
      	  }else {
      		  AlertBox.display("Error", "We required number to price,quantity,minqty and unity ");
      	  }
        }
  }

    

    @FXML
    void refreshProvider(ActionEvent event) {

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadComboProvider();
		 loadCombocategory();
		 loadComboStorehouse();		
		 men_provider.setOnAction(this);
	}
    public void loadComboProvider() {
    	try {
			rs =(ResultSet) se.loadcombobos("provider");
			while(((ResultSet) rs).next()) {
				provider.getItems().addAll(((ResultSet) rs).getString("codepro") );
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
	public void handle(ActionEvent e) {
		if(e.getSource().equals(men_provider)){
			anchorPane.setMouseTransparent(true);
		  try {
			  Stage stage = new Stage ();
			AnchorPane root  = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/provider.fxml")) ;
		    Scene sene= new Scene(root);
		    stage.setTitle("Provider");
		    stage.setScene(sene);
		    stage.showAndWait();
			anchorPane.setMouseTransparent(false);
		  } catch (IOException e1) {
              AlertBox.display("Error", "Filed to fxml file provider");
			e1.printStackTrace();
		}
		}
		
	}


}
