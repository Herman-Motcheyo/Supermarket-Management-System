package supermarketmanagement.java.control;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import supermarketmanagement.java.model.DAO.ConnectDatabase;
import supermarketmanagement.java.model.DAO.DAO;
import supermarketmanagement.java.model.DAO.ProviderDAO;
import supermarketmanagement.java.model.classe.Provider;
import supermarketmanagement.java.utility.Utility;

public class ProviderController implements Initializable{
    
    @FXML
     private AnchorPane rootPane;
    
	  @FXML
	    private JFXButton newP;

	    @FXML
	    private JFXButton modifyP;

	    @FXML
	    private JFXButton searchP;

	    @FXML
	    private JFXButton deleteP;

	    @FXML
	    private JFXButton dashbord;
	    
	    @FXML
        private JFXButton submit;
	    
	    @FXML
	    private JFXTextField codeP;

	    @FXML
	    private JFXButton refresh;

	    @FXML
	    private JFXButton excel;

	    @FXML
	    private JFXButton word;

	    @FXML
	    private JFXTextField nameP;

	    @FXML
	    private JFXTextField adresseP;

	    @FXML
	    private JFXTextField emailP;

	    @FXML
	    private JFXTextField mobileP;

	    @FXML
	    private JFXTextField nameOperation;

	    @FXML
	    private TableView<Provider> col_tablle;

	    @FXML
	    private TableColumn<Provider, String> col_code;

	    @FXML
	    private TableColumn<Provider, String> col_name;

	    @FXML
	    private TableColumn<Provider, String> col_adresse;

	    @FXML
	    private TableColumn<Provider, String> col_email;

	    @FXML
	    private TableColumn<Provider, String> col_mobile;

        //ObservableList : A list that enables listeners to track changes when they occur
	    //ListChangeListener: An interface that receives notifications of changes to an  ObservableList
        ObservableList<Provider> ob =  FXCollections.observableArrayList(); 
        
		DAO <Provider , String > pro = new ProviderDAO(ConnectDatabase.getInstance());  
		Provider p = null;
		String np,ap,cp,ep,mp,nOp;
    
	@FXML
    void deleteProvider(ActionEvent event) {
        nOp = nameOperation.getText();
        if(Utility.isEmptyTextbox(nOp)) {
     	  AlertBox.display("Error", "We required name of code"); 
        }else {
  		  p =new Provider();
  		  p= pro.find(nOp);
  		  if(p != null) {
                 pro.delete(p); 
  		  }

        }

    }

    @FXML
    void exportExcel(ActionEvent event) {

    }

    @FXML
    void exportWord(ActionEvent event) {

    }

    @FXML
    void UpdateProvider(ActionEvent event) {
    	boolean rep ;
        np = nameP.getText();cp = codeP.getText(); ap = adresseP.getText(); ep = emailP.getText(); mp= mobileP.getText();
     if(Utility.isEmptyTextbox(ap)||Utility.isEmptyTextbox(cp) || Utility.isEmptyTextbox(ep)|| Utility.isEmptyTextbox(mp) || Utility.isEmptyTextbox(np)) {
     	   AlertBox.display("Error", "Attributes are required!!");
     }
     else {
     	rep = Utility.verifyNumber(mobileP, mp);
     	if(rep) {
   		    p = new Provider(cp, np, ap, mp, ep);
   		    pro.update(p);
   		    col_tablle.refresh();
          	Utility.cleanTextfied(nameP,codeP,adresseP,emailP,mobileP);
     	}
     }
    }
    @FXML
    void submitCode(ActionEvent event) {
        nOp = nameOperation.getText();
        if(Utility.isEmptyTextbox(nOp)) {
     	  AlertBox.display("Error", "We required name of code"); 
        }else {
        	setInfoProvider(nOp);
            System.out.println("c,est sas");
        }
    }
/*
 * this method is use to create provider when ActionEvent is call */
    @FXML
    void newProvider(ActionEvent event) {
    	boolean rep ;
        np = nameP.getText();cp = codeP.getText(); ap = adresseP.getText(); ep = emailP.getText(); mp= mobileP.getText();
     if(Utility.isEmptyTextbox(ap)||Utility.isEmptyTextbox(cp) || Utility.isEmptyTextbox(ep)|| Utility.isEmptyTextbox(mp) || Utility.isEmptyTextbox(np)) {
     	   AlertBox.display("Error", "Attributes are required!!");
     }
     else {
     	rep = Utility.verifyNumber(mobileP, mp);
     	if(rep) {
         	createProvider(np,cp,ap,ep,mp);
         	Utility.cleanTextfied(nameP,codeP,adresseP,emailP,mobileP);
         	col_tablle.refresh();
     	}
     }
    }


    @FXML
    void returnDashbord(ActionEvent event) {

    }
/*
 * this method is use to call refresh method of table view*/
    @FXML
    void refreshProvider(ActionEvent event) {
    	col_tablle.getItems().clear();;
    	loadDataToTable();
    }
    
/*
 * cette methode cherche les info d'un fournisseur et l'ffiche dans les textfields*/
    @FXML
    void searchProvider(ActionEvent event) {
        nOp = nameOperation.getText();
        if(Utility.isEmptyTextbox(nOp)) {
     	  AlertBox.display("Error", "We required name of code"); 
        }else {
        	setInfoProvider(nOp);

        }
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        rootPane.setOpacity(0);
        makeFAdeInTransition();
		loadDataToTable();
		
		 Utility.TextfieldValid(nameP); Utility.TextfieldValid(emailP); Utility.TextfieldValid(codeP);
		 Utility.TextfieldValid(adresseP); Utility.validNumber(mobileP);
		 Utility.TextfieldValid(nameOperation);
		
	}
	
	/*
	 * cette methode cree un fournisseur 
	 * Principe : cree un object du DAO , puis après affection des attributs
	 *             du fourisseur , appele la methode create() du patern de connection
	 *             */
	public void createProvider(String name, String code,String adresse,String email, String mobile){
		 p = new Provider(code, name, adresse, mobile, email);
		 pro.create(p);
			loadDataToTable();
	}
	/* retourn les info du fournisseur*/
	public void setInfoProvider(String code) {
		  p =new Provider();
		  p= pro.find(code);

		  if(p != null) {
			  nameP.setText(p.getNamePro());
			  adresseP.setText(p.getAdressePro());
			  codeP.setText(p.getCodePro());
			  emailP.setText(p.getMailPro());
			  mobileP.setText(p.getNumberPro());
		  }

	}
	
	/*
	 * cette methode permet de charger les données dans la table
	 */
	 
	public void loadDataToTable() {
		
		try {

			ResultSet rt = ConnectDatabase.getInstance().createStatement().executeQuery("SELECT * FROM provider");
			while(rt.next()) {
				ob.add(new Provider(rt.getString("codePro"), rt.getString("namePro"),rt.getString("adressePro"), rt.getString("numberPro"),rt.getString("mailPro") ));
//				System.out.println(rt.getString("codePro")+ rt.getString("namePro")+rt.getString("adressePro")+ rt.getString("numberPro")+rt.getString("mailPro")+"\n");
			}
		} catch (SQLException e) {
		AlertBox.display("Error", "Do not load table view");
			e.printStackTrace();
		}
		col_code.setCellValueFactory(new PropertyValueFactory<>("codePro"));//to load data
		col_name.setCellValueFactory(new PropertyValueFactory<>("namePro"));
		col_adresse.setCellValueFactory(new PropertyValueFactory<>("adressePro"));
		col_email.setCellValueFactory(new PropertyValueFactory<>("mailPro"));
		col_mobile.setCellValueFactory(new PropertyValueFactory<>("numberPro"));
		
		col_tablle.setItems(ob);
	}
	private void makeFAdeInTransition() {
		 FadeTransition fadetansition = new FadeTransition();
		 fadetansition.setDuration(Duration.millis(1000));
		 fadetansition.setNode(rootPane);
		 fadetansition.setFromValue(0);
		 fadetansition.setToValue(1);
		 fadetansition.play();
			
		
		
	}

}
