package supermarketmanagement.java.model.classe;

import supermarketmanagement.java.utility.Date;
/*
 * this class is using to manage output product in storehouse
 * */
public class OutputStock {
	
	public OutputStock() {
		
	}
	public OutputStock(int idOut, int quantityOut, float priceOut, Date dateOut, String codeP) {
	
		this.idOut = idOut;
		this.quantityOut = quantityOut;
		this.priceOut = priceOut;
		this.dateOut = dateOut;
		this.codeP = codeP;
	}
	private int    idOut   ;
    private int   quantityOut ;
    private float priceOut ;
    private Date dateOut  ;
    private String codeP ; /*come from product it means 'code product'*/
	public int getIdOut() {
		return idOut;
	}
	public void setIdOut(int idOut) {
		this.idOut = idOut;
	}
	public int getQuantityOut() {
		return quantityOut;
	}
	public void setQuantityOut(int quantityOut) {
		this.quantityOut = quantityOut;
	}
	public float getPriceOut() {
		return priceOut;
	}
	public void setPriceOut(float priceOut) {
		this.priceOut = priceOut;
	}
	public Date getDateOut() {
		return dateOut;
	}
	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}
	public String getCodeP() {
		return codeP;
	}
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}
 
}
