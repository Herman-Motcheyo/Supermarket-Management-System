package supermarketmanagement.java.model.classe;

import supermarketmanagement.java.utility.Date;

public class Commande {
	
  public Commande() {
	
	}
public Commande(int numCom, Date dateCom, boolean statutCom) {
		this.numCom = numCom;
		this.dateCom = dateCom;
		this.statutCom = statutCom;
	}
  protected int  numCom;
  protected Date  dateCom;
  protected boolean   statutCom;
  
public int getNumCom() {
	return numCom;
}
public void setNumCom(int numCom) {
	this.numCom = numCom;
}
public Date getDateCom() {
	return dateCom;
}
public void setDateCom(Date dateCom) {
	this.dateCom = dateCom;
}
public boolean isStatutCom() {
	return statutCom;
}
public void setStatutCom(boolean statutCom) {
	this.statutCom = statutCom;
}
}
