package supermarketmanagement.java.control;

import java.net.URL;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import supermarketmanagement.java.model.DAO.CategorieDAO;
import supermarketmanagement.java.model.DAO.ConnectDatabase;
import supermarketmanagement.java.model.DAO.DAO;
import supermarketmanagement.java.model.classe.Categorie;
import supermarketmanagement.java.utility.Utility;

public class CategoryController implements Initializable {
    @FXML
	private JFXTextField  nameCat;
    @FXML
    private TextArea descriptionCat;
    @FXML
    private Button saveCat;
    @FXML
    private Button delete;
    @FXML
    private Label visibleLa;
    private String description,name;
    Categorie c ;
    
    /* 
     * this method is used to add Category to product
     * */
    @FXML
    public void saveCategoryHandle( ActionEvent event) {
    	 name = nameCat.getText();
    	 description = descriptionCat.getText();
    	 
    	 if (Utility.isEmptyTextbox(name) || Utility.isEmptyTextbox(description) ) {
			nameCat.setPromptText("Name are required");
			visibleLa.setVisible(true);
		}else {
			saveCategory(name,description);
			descriptionCat.clear();nameCat.clear();
		}
    }
    /*
     * this method is used to delete category
     * when user enter name of category
     * i will search then in database and i will delete it
     * */
    @FXML
    public void deleteCategoryHandle(ActionEvent event) {
    	 name = nameCat.getText();	 
    	 if (Utility.isEmptyTextbox(name) ) {
			nameCat.setPromptText("Name are required");
		}else {
			 deleteCategory(name);
			descriptionCat.clear();nameCat.clear();
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	   Utility.TextfieldValid(nameCat);
	   visibleLa.setVisible(false);
	}
	
    private void saveCategory(String name , String description) {
	
	 DAO <Categorie,String> cat= new CategorieDAO(ConnectDatabase.getInstance());
	 c = new Categorie(name,description);
	 cat.create(c);
 }
    private void deleteCategory(String name) {
    	DAO <Categorie,String> cat= new CategorieDAO(ConnectDatabase.getInstance());
    	c=cat.find(name);
    	if(c != null) {
    	   cat.delete(c);
    	}

   }

}
