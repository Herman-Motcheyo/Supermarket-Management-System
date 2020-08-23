package supermarketmanagement.java.model.DAO;
	/*
	 * le but de cette classe est de definir les methodes CRUD
	 * pour optimiser et travailler avec les classes
	 * @author herman
	 * */
import java.sql.Connection;

public abstract class DAO<T,O>{
	
	public DAO(Connection connect) {
		this.connect = connect;
	}

	protected Connection connect = null;
	
	/*
	 * this method create
	 * @param object_ 
	 * @return boolean
	 * 
	 * */
	public abstract boolean create(T object_);
	
	/*
	 * this method delete Object
	 * @param object
	 * @return boolean
	 */
    public abstract boolean delete(T object_);
    
    /*
     *this method update information
     *@param code or id
     *@return boolean 
     */
    public abstract boolean update(T object_);
    
    /*
     * this methode search information
     * @param id
     * @return Object
     * */
    public abstract T find(O id);
    
    
}
