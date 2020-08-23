package supermarketmanagement.java.model.classe;

public class Person {

	  public Person(String firstname, String username, String lastname, String email, long number_phone) {
		
		this.firstname = firstname;
		this.username = username;
		this.lastname = lastname;
		this.email = email;
		this.number_phone = number_phone;
	}
	  public Person() {}
	  
	  protected String firstname;
	  protected String username;
	  protected String lastname;
	  protected String email;
	  protected long number_phone;
	  
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastname() {
		return 	lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getNumber_phone() {
		return number_phone;
	}
	public void setNumber_phone(long number_phone) {
		this.number_phone = number_phone;
	}
	

	 
}
