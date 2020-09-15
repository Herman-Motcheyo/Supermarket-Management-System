package supermarketmanagement.java.model.classe;
/*
 * using this class to store product
 * storehouse means magasin in french
 * */
public class StoreHouse {

	public StoreHouse(String nameStore, String descriptionStore) {
		this.nameStore = nameStore;
		this.descriptionStore = descriptionStore;
	}
	public StoreHouse() {}

	private String nameStore;
	private  String descriptionStore;

	public String getNameStore() {
		return nameStore;
	}

	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}
	public String getDescriptionStore() {
		return descriptionStore;
	}
	public void setDescriptionStore(String descriptionStore) {
		this.descriptionStore = descriptionStore;
	}
}
