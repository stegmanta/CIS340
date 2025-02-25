package ClassObjects;
import java.util.Date;

import javax.swing.JOptionPane;

public class PhoneBill {
	//declare class vars
	private int custType;
	private int minutes;
	private int noOfParticipants;
	private double value;
	private Date createdDate;
	//constants
	final public double BASE_GO_CHARGE = 19.99;
	final public double BASE_CONTRACT_CHARGE = 16.95;

	//constructors
	PhoneBill(){
		this(0,0,0);
	}
	
	PhoneBill(int custType, int minutes, int noOfParticipants){
		this.custType = custType;
		this.minutes = minutes;
		this.noOfParticipants = noOfParticipants;
		this.createdDate = new Date();
		computeBill();
	}

	//getters and setters
	
	public int getCustType() {
		return custType;
	}

	public void setCustType(int custType) {
		this.custType = custType;
		computeBill();
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
		computeBill();
	}

	public int getNoOfParticipants() {
		return noOfParticipants;
	}

	public void setNoOfParticipants(int noOfParticipants) {
		this.noOfParticipants = noOfParticipants;
		computeBill();
	}

	public double getValue() {
		return value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	//methods
	private void computeBill() {
		//Calculate the cell phone bill value
				switch(custType) {
				case 0:  // Compute Bill For Hourly Type
					if (minutes < 200)
						value = BASE_GO_CHARGE;
					else if ( (minutes >= 200) && (minutes < 350))
						value = BASE_GO_CHARGE + (minutes - 200) * 0.1;
					else
						value = BASE_GO_CHARGE + (350 - 200) * 0.1 + (minutes - 350) * 0.12;
					break;
					
				case 1: // Compute Bill For Contract Type
					if (noOfParticipants == 1)
						value = BASE_CONTRACT_CHARGE;
					else if (noOfParticipants == 2)
						value = BASE_CONTRACT_CHARGE + BASE_CONTRACT_CHARGE * 0.5;
					else if (noOfParticipants == 3)
						value = BASE_CONTRACT_CHARGE + BASE_CONTRACT_CHARGE * 0.5 +
								BASE_CONTRACT_CHARGE * 0.10;
					else if (noOfParticipants == 4)
						value = BASE_CONTRACT_CHARGE + BASE_CONTRACT_CHARGE * 0.5 +
								BASE_CONTRACT_CHARGE * 0.10 + BASE_CONTRACT_CHARGE * 0.15;
					
				} // end switch
	}//end compute bill

	@Override
	public String toString() {
		if(custType == 0)
			return "Go Bill\t" + minutes + "\t" + noOfParticipants + "\tBill: " + "\t" + String.format("%.2f", value);
		else
			return "Go Bill\t" + minutes + "\t" + noOfParticipants + "\tBill: " + "\t" + String.format("%.2f", value);
	}
	
	
	
}
