package supermarketmanagement.java.control;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import supermarketmanagement.java.model.classe.OutputStock;

public class OutputStockController implements Initializable {

    @FXML
    private JFXTextField price;

    @FXML
    private JFXTextField quantity;

    @FXML
    private DatePicker dateOut;

    @FXML
    private TableView<OutputStock> table;

    @FXML
    private TableColumn<OutputStock,Integer> col_id;

    @FXML
    private TableColumn<OutputStock,Integer> col_quantity;

    @FXML
    private TableColumn<OutputStock,Float> col_price;

    @FXML
    private TableColumn<OutputStock,String> col_date;

    @FXML
    private TableColumn<OutputStock,String> col_codeProduct;

    @FXML
    private Button word;

    @FXML
    private Button excel;

    @FXML
    private ComboBox<?> code;

    @FXML
    void refreshProduct(ActionEvent event) {

    }

    @FXML
    void saveEnterStock(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
