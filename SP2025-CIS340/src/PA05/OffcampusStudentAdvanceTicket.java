package PA05;

public class OffcampusStudentAdvanceTicket extends AdvancedTicket {

	/* Instance variable declaration*/
	private String studentID;
	private boolean status;

	/*parameterized constructor*/
	public OffcampusStudentAdvanceTicket(String number, int days, String ID){
		/*Fill in to instantiate the 1. purchase date variable
		2. ticket number
		3. days
		4. student ID
		5. student status
		6. ticketprice using ticket calculation
		*/
		super(number, days);
		this.studentID = ID;  
		this.status = false; //on campus true, off campus false
		calculateTicket();
	}

	/*getter methods*/
	public String getStudentID(){
		return this.studentID;
	}

	public boolean getStatus(){
		return this.status;
	}

	/*ticket calculation*/
	public void calculateTicket(){
		/*fill in to calculate ticket cost based on number of days
		Make sure to include the base charges*/
		if(this.noOfDaysInAdvance >= 10)
			this.ticketCost = 15;
		else
			this.ticketCost  = 20;
		this.ticketCost += offCampusBaseCharge;
	}

	@Override //overrided method to print the object details
	public String toString(){
		return super.toString() + "\t" + studentID + "\t" + status;
	}
}// end class
