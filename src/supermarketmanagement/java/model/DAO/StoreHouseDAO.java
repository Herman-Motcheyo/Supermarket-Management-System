package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import supermarketmanagement.java.control.AlertBox;
import supermarketmanagement.java.model.classe.StoreHouse;
import supermarketmanagement.java.utility.Utility;

public class StoreHouseDAO extends DAO<StoreHouse,String>{

	public StoreHouseDAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}
	PreparedStatement pst = null;
	StoreHouse p =null;
	ResultSet result = null;
	@Override
	public boolean create(StoreHouse storehouse) {
		  try {
		    	 
				String query = "INSERT INTO storehouse (nameStore,descriptionStore) VALUES (?,?)";
				pst = connect.prepareStatement(query);
				pst.setString(1,storehouse.getNameStore()) ;
				pst.setString(2,storehouse.getDescriptionStore() );
			
				
		      //  if(findString(storehouse.getNameStore())){
					pst.execute();
				//	connect.commit();;
					Utility.printSucess();
		        	
		      //  }
		   //    else {
		    //	   Utility.printError(); 
	          //     }
		        	
		   

			} catch (SQLException e) {
				AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
				e.printStackTrace();
			}
			return false;
	}
	@Override
	public boolean delete(StoreHouse storehouse) {
          String querry = "DELETE FROM storehouse WHERE nameStore =? ";
	       try {
			pst =  connect.prepareStatement(querry);
			pst.setString(1,  storehouse.getNameStore());
			pst.executeUpdate();
			Utility.printSucess();
		} catch (SQLException e) {
			AlertBox.display("Error", "Problem accout during delete");
			e.printStackTrace();
		}
			return true;
			}
	@Override
	public boolean update(StoreHouse object_) {
		return false;
	}

	@Override
	public StoreHouse find(String namestore) {
		StoreHouse pr = null;
		  String sql = "SELECT * FROM storehouse WHERE nameStore = ?";
		  try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, namestore);
			result = pst.executeQuery();
			if( result.next()) {
		         	  pr = new StoreHouse();
		        	  pr.setNameStore(result.getString("nameStore"));
		        	  pr.setDescriptionStore(result.getString("descriptionStore"));
 
		          return pr;
			}
			else {
				AlertBox.display("Error", "Not found Storehouse for this name");	

			}
		} catch (SQLException e) {
			AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
			e.printStackTrace();
		}
			return pr;
		}

	public boolean findString(String name) throws SQLException {
   	 String query = "SELECT nameStore FROM storehouse WHERE nameStore =? ";
	 
  	 pst = connect.prepareStatement(query);
  	 pst.setString(1,name);

        result = pst.executeQuery();
      
     		 if(result.next() ) {
     	          return false;
     		 }
      else {
     	 return true;
      }
	}

}
