package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class Service {
	
	Statement st = null;
	ResultSet rs = null;
	String sql ;
	Connection  connect= ConnectDatabase.getInstance(); 
	
	public ResultSet loadcombobos(String name) throws SQLException{
		
		if(name.equalsIgnoreCase("storehouse")) {
		    sql = " select nameStore from storehouse";
				st = connect.createStatement();
				rs= st.executeQuery(sql);
				return rs;
	
		}else if (name.equalsIgnoreCase("category")) {
		     sql = " select nameCat from categorie";
				st = connect.createStatement();
				rs= st.executeQuery(sql);
				return rs;
		}
		else if (name.equalsIgnoreCase("product")) {
		     sql = " select codeP from product";
				st = connect.createStatement();
				rs= st.executeQuery(sql);
				return rs;
		}else {
		    sql = " select codePro from provider";
				st = connect.createStatement();
				rs= st.executeQuery(sql);
				return rs;
		}
	
	}
}
