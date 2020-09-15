package supermarketmanagement.java.model.classe;

/*
 * this class is use to have information about provider/fournisseur in french
 * **/
public class Provider{
	
  public Provider(String codePro, String namePro, String adressePro, String numberPro, String mailPro) {
	
		this.codePro = codePro;
		this.namePro = namePro;
		this.adressePro = adressePro;
		this.numberPro = numberPro;
		this.mailPro = mailPro;
	}
  public Provider() {}
  
  private String  codePro ;
  private String  namePro ;
  private String  adressePro ;
  private String numberPro ;
  private String mailPro;
  
public String getCodePro() {
	return codePro;
}

public void setCodePro(String codePro) {
	this.codePro = codePro;
}

public String getNamePro() {
	return namePro;
}

public void setNamePro(String namePro) {
	this.namePro = namePro;
}

public String getAdressePro() {
	return adressePro;
}

public void setAdressePro(String adressePro) {
	this.adressePro = adressePro;
}

public String getNumberPro() {
	return numberPro;
}

public void setNumberPro(String numberPro) {
	this.numberPro = numberPro;
}

public String getMailPro() {
	return mailPro;
}

public void setMailPro(String mailPro) {
	this.mailPro = mailPro;
}

}
