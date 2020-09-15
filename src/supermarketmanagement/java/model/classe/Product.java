package supermarketmanagement.java.model.classe;

public class Product {
	
	public Product() {	}
	
	public Product(String codeP, String designationP, int unityP, float priceP,int minquantity, int qteP, String codePro,
			String nameCat, String nameStore) {
	
		this.codeP = codeP;
		this.designationP = designationP;
		this.unityP = unityP;
		this.priceP = priceP;
		this.qteP = qteP;
		this.codePro = codePro;
		this.nameCat = nameCat;
		this.nameStore = nameStore;
		this.minquantity = minquantity;
	}
	
	private String codeP;     
    private String designationP ;
    private int unityP ; 
    private float priceP ; 
    private int qteP; 
    private int minquantity;

	private String codePro ; /* come from @Provider */
    private String nameCat  ; /*come from @Categorie */
    private String nameStore ; /*come form @nameStore*/
    public int getMinquantity() {
		return minquantity;
	}

	public void setMinquantity(int minquantity) {
		this.minquantity = minquantity;
	}

    public String getCodeP() {
		return codeP;
	}
    
	public void setCodeP(String codeP) {
		this.codeP = codeP;
	}
	public String getDesignationP() {
		return designationP;
	}
	
	public void setDesignationP(String designationP) {
		this.designationP = designationP;
	}
	
	public int getUnityP() {
		return unityP;
	}
	
	public void setUnityP(int unityP) {
		this.unityP = unityP;
	}
	public float getPriceP() {
		return priceP;
	}
	public void setPriceP(float priceP) {
		this.priceP = priceP;
	}
	public int getQteP() {
		return qteP;
	}
	
	public void setQteP(int qteP) {
		this.qteP = qteP;
	}
	
	public String getCodePro() {
		return codePro;
	}
	
	public void setCodePro(String codePro) {
		this.codePro = codePro;
	}
	
	public String getNameCat() {
		return nameCat;
	}
	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	public String getNameStore() {
		return nameStore;
	}
	
	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}
	
}
