package supermarketmanagement.java.model.DAO;

import java.sql.Connection;

import supermarketmanagement.java.model.classe.Product;

public class ProductDAO extends DAO<Product,String>{

	public ProductDAO(Connection connect) {
		super(connect);
		
	}

	@Override
	public boolean create(Product object) {
	
		return false;
	}

	@Override
	public boolean delete(Product object_) {

		return false;
	}

	@Override
	public boolean update(Product object_) {
		return false;
	}

	@Override
	public Product find(String  id) {
		return null;
	}

}
