package supermarketmanagement.java.model.classe;

/* 
 * verifie if provider has receive commande of admin
 * permet de verifier si le fournisseur a recu la commande
 * */
public class Receive {
   
   public Receive () {}
   private int numCom  ;
   private String  codePro ;
   
public int getNumCom() {
	return numCom;
}
public void setNumCom(int numCom) {
	this.numCom = numCom;
}
public String getCodePro() {
	return codePro;
}
public void setCodePro(String codePro) {
	this.codePro = codePro;
}
}
