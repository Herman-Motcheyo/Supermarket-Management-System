package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import supermarketmanagement.java.control.AlertBox;
import supermarketmanagement.java.model.classe.Administrator;
import supermarketmanagement.java.utility.Utility;

public class AdministratorDAO extends DAO<Administrator,String>{

	public AdministratorDAO(Connection connect) {
		super(connect);
		
	}
    private PreparedStatement st = null;
    
	@Override
	public boolean create(Administrator object_) {
		Statement st =null;
	     try {
	    	 
			st = connect.createStatement();
			
			String query = "INSERT INTO `administrator` (username,firstname,lastname,pass,email,mobile) "
					     + "VALUES('"+object_.getUsername()+"','"+object_.getFirstname()+"','"+ object_.getLastname() +"','" +
				           object_.getPassword() + "','" +object_.getEmail() +"',"+ object_.getNumber_phone()+")";
	        if(find(object_.getUsername(), object_.getPassword(),object_.getEmail()))
				st.execute(query);
	        else {
	        	Utility.printError();
	        }
	        	
	   

		} catch (SQLException e) {
			AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Administrator object_) {	return false;}

	@Override
	public Administrator find(String id) {return null;}
	
	@Override
	public boolean update(Administrator object_) {
		return false;
	}
	
	public boolean find(String user, String password) throws SQLException {
		
		String sql ="SELECT id FROM administrator WHERE username =? and pass =? " ;
		st =connect.prepareStatement(sql);
		st.setString(1, user);
		st.setString(2, password);
		ResultSet  r =st.executeQuery();
		 if(r.next() )
	         return false;
         else
	         return true;
	}	
	
	public boolean find(String name ,String password,String mail) throws SQLException {
       	 String query = "SELECT id FROM administrator WHERE username =? or email =? ";
 
     	 PreparedStatement prepareStatement = connect.prepareStatement(query);
     	prepareStatement.setString(1,name);
    	prepareStatement.setString(2,mail);

         ResultSet  result = prepareStatement.executeQuery();
         
        		 if(result.next() )/*teste si resulset vide*/
        	 return false;
         else
        	 return true;
	
		
	}




}
