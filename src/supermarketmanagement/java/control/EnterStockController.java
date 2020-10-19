package supermarketmanagement.java.control;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import supermarketmanagement.java.model.DAO.ConnectDatabase;
import supermarketmanagement.java.model.DAO.DAO;
import supermarketmanagement.java.model.DAO.EnterStockDAO;
import supermarketmanagement.java.model.DAO.Service;
import supermarketmanagement.java.model.classe.EnterStock;

import supermarketmanagement.java.utility.Utility;

public class EnterStockController implements Initializable {

    @FXML
    private DatePicker dateEnter;

    @FXML
    private TextField price;

    @FXML
    private TextField quantity;

    @FXML
    private Button word;

    @FXML
    private Button excel;

    @FXML
    private TableView<EnterStock> table;

    @FXML
    private TableColumn<EnterStock,Integer> col_id;

    @FXML
    private TableColumn<EnterStock,Integer>  col_quantity;

    @FXML
    private TableColumn<EnterStock,Float> col_price;

    @FXML
    private TableColumn<EnterStock,String>  col_date;

    @FXML
    private TableColumn<EnterStock,String>col_codeProduct;

    @FXML
    private ComboBox<String> codeArt;
       
    EnterStock enterStock;
    
    DAO<EnterStock, Integer> enter = new EnterStockDAO(ConnectDatabase.getInstance());  
    ObservableList< EnterStock> ob = FXCollections.observableArrayList();
    
    @FXML
    void saveEnterStock(ActionEvent event) {
      float priceE = 0;
      int qte = 0;
      
    	if(Utility.isEmptyTextbox(price.getText()) || Utility.isEmptyTextbox(quantity.getText()) || codeArt.getValue() == null
    		  || dateEnter.getValue() == null)
    	  AlertBox.display("Error ", "Attribues are empty");
      else {
    	  if(Utility.verifyNumber(price.getText()) || Utility.verifyNumber(quantity.getText())) {
    		  try {
				priceE = Float.parseFloat(price.getText());
				qte = Integer.parseInt(quantity.getText());
		    	  enterStock = new EnterStock();
		    	  LocalDate ld = dateEnter.getValue();
		          enterStock.setCodeP(codeArt.getValue());
		          enterStock.setDateEnter(ld);
		          enterStock.setPriceEnter(priceE);
		          enterStock.setQuantityEnter(qte);
		//        System.out.println(ld);
                 enter.create(enterStock);
			
			} catch (NumberFormatException e) {
				  AlertBox.display("Error", "We required number to price  and quantity  ");			}
    	  }

    	  
      }
    }

    private void loadComboProduct() {
    	try {
			Service se = new Service();
			ResultSet rs = (ResultSet) se.loadcombobos("product");
			while(((ResultSet) rs).next()) {
				codeArt.getItems().add(((ResultSet) rs).getString("codeP") );
			}
		} catch (SQLException e) {
			AlertBox.display("Error", "Failed to load combo product");
			e.printStackTrace();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadComboProduct() ;
		loadTable() ;
	}
	
	private void loadTable() {
		try {

			ResultSet rt = ConnectDatabase.getInstance().createStatement().executeQuery("SELECT * FROM EnterStock");
			while(rt.next()) {
				ob.add(new EnterStock(rt.getInt("idEnter"), rt.getInt("quantityEnter"),rt.getFloat("priceEnter"), rt.getDate("dateEnter").toLocalDate(),rt.getString("codeP") ));
			}
		} catch (SQLException e) {
		AlertBox.display("Error", "Do not load table view");
			e.printStackTrace();
		} 
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("idEnter"));
		col_codeProduct.setCellValueFactory(new PropertyValueFactory<>("codeP"));
		col_date.setCellValueFactory(new PropertyValueFactory<>("dateEnter"));
		col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantityEnter"));
		col_price.setCellValueFactory(new PropertyValueFactory<>("priceEnter"));
		table.setItems(ob);
	}

    @FXML
    void refreshProduct(ActionEvent event) {
         table.getItems().clear();
         loadTable();
    }
}
