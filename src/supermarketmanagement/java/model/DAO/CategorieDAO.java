package supermarketmanagement.java.model.DAO;

import java.sql.Connection;

import supermarketmanagement.java.model.classe.Categorie;

public class CategorieDAO extends DAO<Categorie,String>{

	public CategorieDAO(Connection connect) {
		super(connect);

	}

	@Override
	public boolean create(Categorie object_) {
	
		return false;
	}

	@Override
	public boolean delete(Categorie object_) {
		 
		return false;
	}

	@Override
	public boolean update(Categorie object_) {
	
		return false;
	}

	@Override
	public Categorie find(String id) {
	
		return null;
	}

}
