package supermarketmanagement.java.model.classe;

import java.time.LocalDate;
/*
 * this class is using to manage enter product in storehouse
 * */
public class EnterStock {
    
	public EnterStock(int idEnter, int quantityEnter, float priceEnter, LocalDate dateEnter, String codeP) {
		this.idEnter = idEnter;
		this.quantityEnter = quantityEnter;
		this.priceEnter = priceEnter;
		this.dateEnter = dateEnter;
		this.codeP = codeP;
	}
	public EnterStock() {
	}

	private int   idEnter  ;
    private int quantityEnter ;
    private float priceEnter ;
    private LocalDate dateEnter  ;
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
	
	public LocalDate getDateEnter() {
		return dateEnter;
	}
	
	public void setDateEnter(LocalDate dateEnter) {
		this.dateEnter = dateEnter;
	}
	
	public String getCodeP() {
		return codeP;
	}
	
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}

}
