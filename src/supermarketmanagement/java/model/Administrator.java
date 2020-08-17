package supermarketmanagement.java.model;

public class Administrator extends Person {
	

	public Administrator(String firstname, String username, String lastname, String email, long number_phone,String password ) {
		super(firstname, username, lastname, email, number_phone);
		this.password = password;
	}
	
	private String password;

}
