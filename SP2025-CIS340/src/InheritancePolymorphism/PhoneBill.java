package InheritancePolymorphism;

import java.util.Date;

public class PhoneBill {
	
	// data fields
	private int minutes;
	private int noOfParticipants;
	protected double value;
	private Date createdDate;
	
	final static double BASE_Go_CHARGE = 19.99;
	final static double BASE_CONTRACT_CHARGE = 16.95;
	
	
	PhoneBill() {
		this(0,0);
	}

	PhoneBill(int minutes, int noOfParticipants) {
	this.minutes = minutes;
		this.noOfParticipants = noOfParticipants;
		this.value = 0;
		this.createdDate = new Date();
	}

	
	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getNoOfParticipants() {
		return noOfParticipants;
	}

	public void setNoOfParticipants(int noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
	}

	public double getValue() {
		return value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	protected void computeBill() {
	   // this method is implemented in the subclasses
		
	}

	
}// end PhoneBill Class
