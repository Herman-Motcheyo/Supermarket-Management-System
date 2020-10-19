package supermarketmanagement.java.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import supermarketmanagement.java.control.AlertBox;
import supermarketmanagement.java.model.classe.EnterStock;
import supermarketmanagement.java.utility.Utility;

public class EnterStockDAO extends DAO<EnterStock,Integer> {

	public EnterStockDAO(Connection connect) {
		super(connect);
	}
	PreparedStatement pst =null;
	String query ;

	@Override
	public boolean create(EnterStock enter) {
		//default time zone
		//ZoneId defaultZoneId = ZoneId.systemDefault();
		//date = localDate + atStartOfDay() + default time zone + toInstant()
	//	Date date = Date.from(enter.getDateEnter().atStartOfDay(defaultZoneId).toInstant());
	    try {
			query = "INSERT INTO  EnterStock (quantityEnter,priceEnter,dateEnter,codeP) VALUES (?,?,?,?)";

				pst = connect.prepareStatement(query);
				pst.setInt(1,enter.getQuantityEnter() );
				pst.setFloat(2,enter.getPriceEnter() );
				pst.setDate(3, java.sql.Date.valueOf(enter.getDateEnter()));
				pst.setString(4,enter.getCodeP() );;
				pst.execute();
				Utility.printSucess();

		} catch (SQLException e) {
			AlertBox.display("ERROR","DO NOT CONNECT TO DATABASE");
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean delete(EnterStock object_) {
		return false;
	}

	@Override
	public boolean update(EnterStock object_) {
		return false;
	}

	@Override
	public EnterStock find(Integer id) {
		return null;
	}

	

}
