package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supermarketmanagement.java.control.AlertBox;
import supermarketmanagement.java.model.classe.Provider;
import supermarketmanagement.java.utility.Utility;

public class ProviderDAO extends DAO <Provider,String>{

	public ProviderDAO(Connection connect) {
		super(connect);

	}
	PreparedStatement pst = null;
	Provider p =null;
	ResultSet result = null;

	@Override
	public boolean create(Provider p) {
	     try {
	    	 
			String query = "INSERT INTO provider (codePro,namePro,numberPro,adressePro,mailPro) VALUES (?,?,?,?,?)";
			connect.setAutoCommit(false);
			pst = connect.prepareStatement(query);
			pst.setString(1,p.getCodePro() );
			pst.setString(2,p.getNamePro() );
			pst.setString(3,p.getNumberPro());
			pst.setString(4,p.getAdressePro() );
			pst.setString(5,p.getMailPro());
			
	 //       if(!findString(p.getCodePro())){
	  //      	Utility.printError(); 
	  //      }
	   //    else {
	        ///	System.out.println(" test enter");
				pst.execute();
				connect.commit();;
				
			//s	System.out.println(" test execuute");
				Utility.printSucess();
	    //   }
	        	
	   

		} catch (SQLException e) {
			AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Provider p) {
          String querry = "DELETE FROM provider WHERE codepro = ?";
	       try {
			pst =  connect.prepareStatement(querry);
			pst.setString(1, p.getCodePro());
			pst.executeUpdate();
			Utility.printSucess();
		} catch (SQLException e) {
			AlertBox.display("Error", "Problem accout during delete");
			e.printStackTrace();
		}
			return true;
			}

	@Override
	public boolean update(Provider  p) {
       String querry = "UPDATE provider SET codePro = ? ,namePro = ? ,adressePro = ? ,numberPro = ? ,mailPro= ?  ";
          querry +=  "WHERE codePro = ?"; 
       try {
		pst =  connect.prepareStatement(querry);
		pst.setString(1, p.getCodePro());
		pst.setString(2, p.getNamePro());
		pst.setString(3, p.getAdressePro());
		pst.setString(4, p.getNumberPro());
		pst.setString(5, p.getMailPro());
		pst.setString(6, p.getCodePro());
		pst.executeUpdate();
		Utility.printSucess();
	} catch (SQLException e) {
		AlertBox.display("Error", "Problem accout during Upadate");
		e.printStackTrace();
	}
		return true;
	}

	@Override
	public Provider find(String code) {
		Provider pr = null;
	  String sql = "SELECT * FROM provider WHERE codePro = ?";
	//  String sql = "SELECT * FROM provider ";
	  try {
		pst = connect.prepareStatement(sql);
		pst.setString(1, code);
		result = pst.executeQuery();
		  System.out.println("dans find apres resultset");
		if( result.next()) {
		/**	ResultSetMetaData rsm = result.getMetaData();
			  System.out.println(" trouvé");
			  for(int i = 1; i <= rsm.getColumnCount(); i++)
				  System.out.print("\t" + rsm.getColumnName(i).toUpperCase() + "\t *");
			  System.out.println("\n");
			  for(int i = 1; i <= rsm.getColumnCount(); i++)
				  System.out.print("\t" + result.getObject(i).toString() + "\t |");*/
			//  while(result.next()) {

				  System.out.println("dans find code trouvé");

	        	  pr = new Provider();
	        	  pr.setCodePro(result.getString("codePro"));
	        	  pr.setAdressePro(result.getString("adressePro"));
	        	  pr.setMailPro(result.getString("mailPro"));
	        	  pr.setNumberPro(result.getString("numberPro"));
	        	  pr.setNamePro(result.getString("namePro"));
	        //  }
	          return pr;
		}
		else {
			AlertBox.display("Error", "Not found Provider for this code");	

		}
	} catch (SQLException e) {
		AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
		e.printStackTrace();
	}
		return pr;
	}
	
	public boolean findString(String name) throws SQLException {
		
    	 String query = "SELECT codePro FROM provider WHERE codePro =? ";
    	 
   	 pst = connect.prepareStatement(query);
   	 pst.setString(1,name);

         result = pst.executeQuery();
       
      		 if(result.next() ) {
      			 System.out.println(",est pas vide");
      	          return false;
      		 }
       else {
    	   System.out.println("videazd");
      	 return true;
       }
	}

}
