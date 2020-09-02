package supermarketmanagement.java.model.DAO;

import java.sql.Connection;

import supermarketmanagement.java.model.classe.Receive;

public class ReceiveDAO extends DAO<Receive,String>{

	public ReceiveDAO(Connection connect) {
		super(connect);
		
	}

	@Override
	public boolean create(Receive object_) {
	
		return false;
	}

	@Override
	public boolean delete(Receive object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Receive object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Receive find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
