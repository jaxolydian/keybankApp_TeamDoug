package keybankApp.app;

import java.util.ArrayList;

public class Account {

	private final String ccn = "1234123412341234";
	private String firstName;
	private String lastName;
	private int accAmt;
	private int L4Dig;
	private int cvv;
	
	public Account(int l, String fn, String ln, int cvv) {
		L4Dig = Integer.parseInt(ccn.substring(ccn.length()-4));
		if (accAmt >= 0 && accAmt <= 10) {
			this.setAccAmt(accAmt);
		} else {
			System.out.println("You cannot have more than 10 open bank accounts at once");
		}
		this.setCvv(cvv);
		
	}
	public int getL4Dig() {
		return L4Dig;
	}
	public int getAccAmt() {
		return accAmt;
	}
	public void setAccAmt(int accAmt) {
		this.accAmt = accAmt;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
}
