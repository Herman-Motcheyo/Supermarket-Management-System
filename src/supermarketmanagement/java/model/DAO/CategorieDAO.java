package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import supermarketmanagement.java.control.AlertBox;
import supermarketmanagement.java.model.classe.Categorie;
import supermarketmanagement.java.utility.Utility;

public class CategorieDAO extends DAO<Categorie,String>{

	public CategorieDAO(Connection connect) {
		super(connect);

	}
     PreparedStatement pst =null;
	@Override
	public boolean create(Categorie c) {
    	String query = "INSERT INTO `categorie` (nameCat,descriptionCat) Values(?,?)";
    	try {
			pst = connect.prepareStatement(query);
			pst.setString(1, c.getNameCat() );
			pst.setString(2, c.getDescriptionCat());
			if(findString(c.getNameCat())) {
			    pst.execute();
			    Utility.printSucess();
			}else {
				Utility.printError();
			}

;
		} catch (SQLException e) {
			AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Categorie c) {
		
			String sql = "DELETE FROM categorie WHERE nameCat = ? ";
			try {
				pst= connect.prepareStatement(sql);
				pst.setString(1, c.getNameCat());
		        pst.executeUpdate();
		        Utility.printSucess();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return true;
	}

	@Override
	public boolean update(Categorie object_) {
	
		return false;
	}

	@Override
	public Categorie find(String id) {
		Categorie c=null;
        String r = null ;
		String sql = "SELECT * FROM `categorie` WHERE 	nameCat =? ";
	 try {
		pst = connect.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet result = pst.executeQuery();
		 if(result.next() ){
		    	 c= new Categorie();
				r =result.getString("nameCat");
				c.setNameCat(r);
		 }else {
		          AlertBox.display("ERROR", "' "+ id +" ' not found in database"); 
        }
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return c;
	}
	public boolean findString(String name) throws SQLException {
		
     	 String query = "SELECT nameCat FROM categorie WHERE nameCat =? ";
     	 
    	 pst = connect.prepareStatement(query);
    	 pst.setString(1,name);

        ResultSet  result = pst.executeQuery();
        
       		 if(result.next() )/*teste si resulset vide*/
       	 return false;
        else
       	 return true;
	}

}
