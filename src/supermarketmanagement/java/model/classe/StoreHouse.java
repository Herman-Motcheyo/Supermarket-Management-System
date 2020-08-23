package supermarketmanagement.java.model.classe;
/*
 * using this class to store product
 * storehouse means magasin in french
 * */
public class StoreHouse {

	public StoreHouse() {}

	public StoreHouse(String nameStore) {
		this.nameStore = nameStore;
	}

	private String nameStore;

	public String getNameStore() {
		return nameStore;
	}

	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}
}
