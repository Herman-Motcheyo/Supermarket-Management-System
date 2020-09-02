package supermarketmanagement.java.model.classe;

import supermarketmanagement.java.utility.Date;
/*
 * this class is using to manage enter product in storehouse
 * */
public class EnterStock {
    
	private int   idEnter  ;
    private int quantityEnter ;
    private float priceEnter ;
    private Date dateEnter  ;
    private String codeP ; /*come from product it means 'code product'*/
    
	public int getIdEnter() {
		return idEnter;
	}
	
	public void setIdEnter(int idEnter) {
		this.idEnter = idEnter;
	}
	
	public int getQuantityEnter() {
		return quantityEnter;
	}
	
	public void setQuantityEnter(int quantityEnter) {
		this.quantityEnter = quantityEnter;
	}
	
	public float getPriceEnter() {
		return priceEnter;
	}
	
	public void setPriceEnter(float priceEnter) {
		this.priceEnter = priceEnter;
	}
	
	public Date getDateEnter() {
		return dateEnter;
	}
	
	public void setDateEnter(Date dateEnter) {
		this.dateEnter = dateEnter;
	}
	
	public String getCodeP() {
		return codeP;
	}
	
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}

}