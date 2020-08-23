package supermarketmanagement.java.model.classe;

import java.util.HashSet;
import java.util.Set;
/*
 * it is create to give categorie  to product
 * 
 * */
public class Categorie {
	
	 public Categorie(String nameCat, String descriptionCat) {

		this.nameCat = nameCat;
		this.descriptionCat = descriptionCat;
	}
    
	 public Categorie() {}
	 
	private String  nameCat,descriptionCat ; 
	 
	 /*
	  * @ensembleCat for listing categorie //ensembleCat pour lister les categories
	  */
	 private Set<Categorie> ensembleCat = new HashSet<Categorie>();
	
	 public String getNameCat() {
		return nameCat;
	}
	 
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	public String getDescriptionCat() {
		return descriptionCat;
	}
	
	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}
	
	public Set<Categorie> getEnsembleCat() {
		return ensembleCat;
	}
	
	public void setEnsembleCat(Set<Categorie> ensembleCat) {
		this.ensembleCat = ensembleCat;
	}
	     
}
