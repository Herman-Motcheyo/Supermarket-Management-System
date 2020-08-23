package supermarketmanagement.java.model.DAO;

import java.sql.Connection;

import supermarketmanagement.java.model.classe.StoreHouse;

public class StoreHouseDAO extends DAO<StoreHouse,String>{

	public StoreHouseDAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(StoreHouse object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(StoreHouse object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(StoreHouse object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public StoreHouse find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
