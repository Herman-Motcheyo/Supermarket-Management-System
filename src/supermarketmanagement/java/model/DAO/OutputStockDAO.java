package supermarketmanagement.java.model.DAO;

import java.sql.Connection;

import supermarketmanagement.java.model.classe.OutputStock;

public class OutputStockDAO  extends DAO<OutputStock,Integer>{

	public OutputStockDAO(Connection connect) {
		super(connect);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(OutputStock object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(OutputStock object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(OutputStock object_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OutputStock find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
