package supermarketmanagement.java.control;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
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
	    private AnchorPane rigthAnchorPane;
	    
	    @FXML
	    private Button men_storehouse;

	    @FXML
	    private Button men_provider;

	    @FXML
	    private Button men_commande;
	    
	    @FXML
	    private Button roolback;
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
	    private BorderPane borderPane;

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
	    Stage stage = null;
	    Node node = null;
	    Scene scene;
	    Product P;
	    Service se = new Service();
	    
	    DAO<Product, String> product = new ProductDAO(ConnectDatabase.getInstance());
	    ObservableList<Product> ob = FXCollections.observableArrayList();
	    
	    String codeP; String storehouseP;String designationP; String providerP;String unityP; String priceP;
	    String qty;String mqty ;String categoryP ;int uni,q,minq;float p;
	    String codeForO;
	    
	    

    @FXML
    void addProduct(ActionEvent event) {
    	addAndUpdateOperation("create");
     }
	   @FXML
	    void updateProduct(ActionEvent event) {
		   addAndUpdateOperation("update");
		   cleanTextField() ;
	     }
	   
     private void addAndUpdateOperation(String operationName) {
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
       		 
       		  if(operationName.equalsIgnoreCase("create")) {
       		    product.create(P);
       			cleanTextField() ;
       		  }    
       		  else {
     			    product.update(P);
         			cleanTextField() ;
       		  }
       			  
       		 
       	  }else {
       		  AlertBox.display("Error", "We required number to price,quantity,minqty and unity ");
       	  }
         }
    }
    

    @FXML
    void refreshProduct(ActionEvent event) {
         table.getItems().clear();
         provider.getItems().clear();
         storehouse.getItems().clear();
         category.getItems().clear();
         loadDataToTable();
         loadComboProvider();
		 loadCombocategory();
		 loadComboStorehouse();	
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		loadComboProvider();
		 loadCombocategory();
		 loadComboStorehouse();		
		 loadDataToTable();
		 men_provider.setOnAction(this);men_category.setOnAction(this);men_enter.setOnAction(this);men_output.setOnAction(this);
		 men_storehouse.setOnAction(this);men_commande.setOnAction(this);roolback.setOnAction(this);
	}
	
	
    private void loadComboProvider() {
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
    private void loadComboStorehouse() {
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
    
    private void loadCombocategory() {
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
			
				try {
					viewEntityrInfo("provider.fxml");
				} catch (IOException e1) {
					e1.printStackTrace();
				}                   
	}else if (e.getSource().equals(men_category)) {
		try {
			viewEntityrInfo("category.fxml");
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
	}else if (e.getSource().equals(men_commande)) {
		try {
			viewEntityrInfo("commande.fxml");
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
	}else if (e.getSource().equals(men_enter)) {
		try {
			viewEntityrInfo("inputStock.fxml");
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
	else if (e.getSource().equals(men_output)) {
		try {
			viewEntityrInfo("outputStock.fxml");
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
	else if (e.getSource().equals(men_storehouse)) {
		try {
			viewEntityrInfo("storeHouse.fxml");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}else if (e.getSource().equals(roolback)) {
		stage = (Stage)node.getScene().getWindow();
		stage.close();
		try {
			new FXMLLoader();
			anchorPane = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/Home.fxml"));
			scene = new Scene(anchorPane);
			stage.setScene(scene);
			stage.setTitle("Home");
			stage.show();
		} catch (Exception e2) {
		AlertBox.display("Error", "Do not load fxml file");
		   e2.printStackTrace();
		}
	}
	

		}

		private void viewEntityrInfo(String screemName) throws IOException {
			anchorPane.setMouseTransparent(true);
			Stage currentStage = new Stage();
			AnchorPane secondView = FXMLLoader.load(getClass().getResource("/supermarketmanagement/ressource/fxml/" + screemName));

			scene = new Scene(secondView);
		//	currentStage.setTitle(screemName);
			currentStage.setScene(scene);
			currentStage.showAndWait();	
			anchorPane.setMouseTransparent(false);
		}
		/*
		 * this method is using to animate multiple screem
		 *  */
		
		@SuppressWarnings("unused")
		private void fadeTransitionScreem(String screemName) {
			
			FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1000), borderPane);
		        fadeTransition.setToValue(1);
		        fadeTransition.setFromValue(0);
		        fadeTransition.setNode(borderPane);
		        fadeTransition.setOnFinished((ActionEvent event) -> {	           
		        try {
					viewEntityrInfo( screemName);
				} catch (IOException e) {
					AlertBox.display("Error", "Filed to load fxml file" + screemName);					e.printStackTrace();
				}
		        });
		        fadeTransition.play();

		}
		
		/*
		 * Cette methode est utilisée pour supprimer un produit
		 * Elle prend verify si le code n'est pas vide , puis appele la methode delete() du ProductDAO
		 * */
		
		@FXML
		void deleteProduct(ActionEvent e) {
			codeForO= codeforOp.getText();
			if(Utility.isEmptyTextbox(codeForO)) {
				AlertBox.display("Error", "We required code for Operation");
			}else {
				P = new Product();
				P.setCodeP(codeForO);	
				product.delete(P);
				  cleanTextField() ;
			}
			
		}
		
		/*
		 * Use to set Information of Product to Dashbord
		 * */
		@FXML
		private void searchAndsetProductToTextField() {
			codeForO= codeforOp.getText();
			if(Utility.isEmptyTextbox(codeForO)) {
				AlertBox.display("Error", "We required code for Operation");
			}else {
				P = new Product();
				  P= product.find(codeForO);
				  if(P != null) {
					code.setText(P.getCodeP());
					unity.setText((String.valueOf(P.getUnityP())));
					quantity.setText(String.valueOf(P.getQteP()));
					price.setText(String.valueOf(P.getPriceP()));
					designation.setText(P.getDesignationP());
					min_quantity.setText(String.valueOf(P.getMinquantity()));
                    category.setValue(P.getNameCat());
                    storehouse.setValue(P.getNameStore());
                    provider.setValue(P.getCodePro());
				  }
			}
		}
		
		private void cleanTextField() {
			code.clear();quantity.clear();unity.clear();price.clear();designation.clear();
			min_quantity.clear();
		}
		
		private void  loadDataToTable() {
			
			try {
				ResultSet rs = ConnectDatabase.getInstance().createStatement().executeQuery("select * from product");
			    while(rs.next()) {
			    	ob.add(new Product(rs.getString("codeP"),rs.getString("designationP"),rs.getInt("unityP"),rs.getFloat("priceP"),rs.getInt("minquantity"),rs.getInt("qteP"),rs.getString("codePro"),rs.getString("nameCat"),rs.getString("nameStore")) );
			    }
			} catch (SQLException e) {
				AlertBox.display("Error", "Do not load table view");
				e.printStackTrace();
			}
			
			col_code.setCellValueFactory(new PropertyValueFactory<>("codeP"));//to load data
			col_category.setCellValueFactory(new PropertyValueFactory<>("nameCat"));
			col_minqty.setCellValueFactory(new PropertyValueFactory<>("minquantity"));
			col_designation.setCellValueFactory(new PropertyValueFactory<>("designationP"));
			col_provider.setCellValueFactory(new PropertyValueFactory<>("codePro"));//to load data
			col_price.setCellValueFactory(new PropertyValueFactory<>("priceP"));
			col_quantity.setCellValueFactory(new PropertyValueFactory<>("qteP"));
			col_storehouse.setCellValueFactory(new PropertyValueFactory<>("nameStore"));
			col_unity.setCellValueFactory(new PropertyValueFactory<>("unityP"));
              
			table.setItems(ob);
		}


}
