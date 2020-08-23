package supermarketmanagement.java.utility;

public class Date {
	
  public Date(int day, String month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
 public Date() {}
  
  protected int day;
  protected String month;
  protected int year;
  
public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}

public String getMonth() {
	return month;
}

public void setMonth(String month) {
	this.month = month;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}
}
