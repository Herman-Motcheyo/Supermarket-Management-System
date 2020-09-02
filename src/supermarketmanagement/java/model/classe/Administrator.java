package supermarketmanagement.java.model.classe;

/*
 * @Author
 *     TCHENEGHON MOTCHEYO HERMAN
 * 
 * */
public class Administrator extends Person {

	public Administrator(String firstname, String username, String lastname, String email, long number_phone,String password ) {
		super(firstname, username, lastname, email, number_phone);
		this.password = password;
	}
	
    public Administrator() {
    	super();
    }
	
	private String password;
	
	public void  setPassword( String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
 
	
    /** public void saveAdmin() {
		
		BufferedWriter file =null;
		PrintWriter p =null;
		try {
			String data =this.username +" ;" +this.firstname+ " ;"+ this.lastname +" ;"+ this.email+ " ;"+this.number_phone +" ;"+this.password+"\n";
			file = new BufferedWriter(
					         new FileWriter("src/supermarketmanagement/ressource/file/administrator.txt",true));
		 p=new PrintWriter(file);
	     p.write(data);
	     p.flush();
			
       } catch (FileNotFoundException e) {
            AlertBox.display("FILE NOT FOUND", "WE DON'T SEE FILE ADMIN");
			e.printStackTrace();
			
		} catch (IOException e) {
		AlertBox.display("Writing Error", "Error Writing in file Admin");	
			e.printStackTrace();
		}
	}*/
    
    
}

