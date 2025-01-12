package keybankApp.app;

import java.util.ArrayList;

public class Account {
	private boolean isActive;
	private final String ccn = "1234123412341234";
	private String firstName;
	private String lastName;
	private int accAmt;
	private String L4Dig;
	private int cvv;
	
	public Account(boolean isActive, String ccn, String fn, String ln, int cvv) {
		L4Dig = (ccn.substring(ccn.length()-4));
		if (accAmt >= 0 && accAmt <= 10) {
			this.setAccAmt(accAmt);
		} else {
			System.out.println("You cannot have more than 10 open bank accounts at once");
		}
		this.setCvv(cvv);
		this.setActive(isActive);
		
	}
	public String getL4Dig() {
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
