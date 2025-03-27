package PhoneBillGUI;

import java.util.Date;

public abstract class PhoneBill implements BaseCharge{
	
	// data fields
	private int minutes;
	private int noOfParticipants;
	protected double value;
	private Date createdDate;
	
	
	
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

	
	
	
}// end PhoneBill Class
