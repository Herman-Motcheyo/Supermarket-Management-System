package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supermarketmanagement.java.control.AlertBox;
import supermarketmanagement.java.model.classe.Product;
import supermarketmanagement.java.utility.Utility;

public class ProductDAO extends DAO<Product,String>{
    ResultSet rs =null;
    PreparedStatement pst = null;
    
	public ProductDAO(Connection connect) {
		super(connect);
		
	}

	@Override
	public boolean create(Product p) {
	  String query1 = "select codeP from product";
	  String query2 = "insert into product(codeP,designationP,unityP,priceP,qteP,codePro,nameCat,nameStore,minquantity)values(?,?,?,?,?,?,?,?,?)";
	  
	  try {
		pst = connect.prepareStatement(query1);
		rs = pst.executeQuery();
		if(rs.next()) {
			AlertBox.display("Error", "Code already exists");
		}else {
			pst = connect.prepareStatement(query2);
			pst.setString(1, p.getCodeP());
			pst.setString(2, p.getDesignationP());
			pst.setInt(3, p.getUnityP());
			pst.setFloat(4, p.getPriceP());
			pst.setInt(5, p.getQteP());
			pst.setString(6, p.getCodePro());
			pst.setString(7, p.getNameCat());
			pst.setString(8, p.getNameStore());
			pst.setInt(9, p.getMinquantity());
			pst.executeUpdate();
			Utility.printSucess();
			
		}
	} catch (SQLException e) {
		AlertBox.display("Error", "Do not connect to database");
		e.printStackTrace();
	}
	  
		return false;
	}

	@Override
	public boolean delete(Product object_) {

		return false;
	}

	@Override
	public boolean update(Product object_) {
		return false;
	}

	@Override
	public Product find(String  id) {
		return null;
	}

}
