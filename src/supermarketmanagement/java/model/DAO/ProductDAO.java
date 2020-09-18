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
    String  sql1 = "select codeP from product where codeP = ?";
	public ProductDAO(Connection connect) {
		super(connect);
		
	}

	@Override
	public boolean create(Product p) {
	//  String query1 = "select codeP from product where codeP = ?";
	  String query2 = "insert into product(codeP,designationP,unityP,priceP,qteP,codePro,nameCat,nameStore,minquantity)values(?,?,?,?,?,?,?,?,?)";
	  
	  try {
		pst = connect.prepareStatement(sql1);
		pst.setString(1, p.getCodeP());
		rs = pst.executeQuery();
		if(rs.next()) {
			Utility.printErrorDataBase();
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
	  
		return true;
	}

	@Override
	public boolean delete(Product p) {
      String sql2;
      sql2 = "delete from product where codeP = ?";
      try {
		pst = connect.prepareStatement(sql1);
		pst.setString(1, p.getCodeP());
		rs =pst.executeQuery();
		if(rs.next()) {
			pst= connect.prepareStatement(sql2);
			pst.setString(1,p.getCodeP());
			pst.executeUpdate();
			Utility.printSucess();
		}
		else {
			AlertBox.display("Error", "Not found Product for this code");	
		}
	} catch (SQLException e) {
		AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
		e.printStackTrace();
	}
		return false;
	}

	@Override
	public boolean update(Product p) {
		   String querry = "UPDATE product SET codeP = ? ,designationP = ? ,unityP = ? ,priceP = ? ,qteP= ? ,codePro = ? ,nameStore = ? ,minquantity= ? ";
	          querry +=  ", nameCat=?   WHERE codeP = ?"; 
	       try {
	    	   pst = connect.prepareStatement(querry);
				pst.setString(1, p.getCodeP());
				pst.setString(2, p.getDesignationP());
				pst.setInt(3, p.getUnityP());
				pst.setFloat(4, p.getPriceP());
				pst.setInt(5, p.getQteP());
				pst.setString(6, p.getCodePro());
				pst.setString(7, p.getNameStore());
				pst.setInt(8, p.getMinquantity());
				pst.setString(9, p.getNameCat());
				pst.setString(10,p.getCodeP());
				pst.executeUpdate();
				Utility.printSucess();
		} catch (SQLException e) {
			AlertBox.display("Error", "Problem account during Upadate");
			e.printStackTrace();
		}
			return true;
		}	
	
	@Override
	public Product find(String  code) {
		
		Product pr = null;
		  String sql = "SELECT * FROM product WHERE codeP = ?";
		  try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, code);
			rs = pst.executeQuery();
			if( rs.next()) {

		        	  pr = new Product();
		        	pr.setCodeP(rs.getString("codeP"));
		        	pr.setDesignationP(rs.getString("designationP"));
		        	pr.setUnityP(rs.getInt("unityP"));
		        	pr.setPriceP(rs.getFloat("priceP"));
		        	pr.setQteP(rs.getInt("qteP"));
		        	pr.setCodePro(rs.getString("codePro"));
		        	pr.setNameCat(rs.getString("nameCat"));
		        	pr.setNameStore(rs.getString("nameStore"));
		        	pr.setMinquantity(rs.getInt("minquantity"));
		     
		          return pr;
			}
			else {
				AlertBox.display("Error", "Not found Product for this code");	

			}
		} catch (SQLException e) {
			AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
			e.printStackTrace();
		}
			return pr;
	}

}
