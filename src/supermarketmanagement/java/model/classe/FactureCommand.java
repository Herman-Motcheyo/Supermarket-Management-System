package supermarketmanagement.java.model.classe;

public class FactureCommand extends Commande {
	
   public FactureCommand(int indexCommand, int qtycommander, float priceCommand, float montantcommand, String codeP) {
		super();
		this.indexCommand = indexCommand;
		this.qtycommander = qtycommander;
		this.priceCommand = priceCommand;
		this.montantcommand = montantcommand;
		this.codeP = codeP;
	}
   public FactureCommand() {}
   
   private int indexCommand  ;
   private int  qtycommander   ;
   private float  priceCommand ;
   private float  montantcommand ;
   private String codeP ;
   
   
public int getIndexCommand() {
	return indexCommand;
}
public void setIndexCommand(int indexCommand) {
	this.indexCommand = indexCommand;
}
public int getQtycommander() {
	return qtycommander;
}
public void setQtycommander(int qtycommander) {
	this.qtycommander = qtycommander;
}
public float getPriceCommand() {
	return priceCommand;
}
public void setPriceCommand(float priceCommand) {
	this.priceCommand = priceCommand;
}
public float getMontantcommand() {
	return montantcommand;
}
public void setMontantcommand(float montantcommand) {
	this.montantcommand = montantcommand;
}
public String getCodeP() {
	return codeP;
}
public void setCodeP(String codeP) {
	this.codeP = codeP;
}
}
