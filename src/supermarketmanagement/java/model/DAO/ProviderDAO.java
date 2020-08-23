package supermarketmanagement.java.model.DAO;

import java.sql.Connection;

import supermarketmanagement.java.model.classe.Provider;

public class ProviderDAO extends DAO <Provider,String>{

	public ProviderDAO(Connection connect) {
		super(connect);

	}

	@Override
	public boolean create(Provider object_) {

		return false;
	}

	@Override
	public boolean delete(Provider object_) {

		return false;
	}

	@Override
	public boolean update(Provider object_) {

		return false;
	}

	@Override
	public Provider find(String id) {
	
		return null;
	}

}
