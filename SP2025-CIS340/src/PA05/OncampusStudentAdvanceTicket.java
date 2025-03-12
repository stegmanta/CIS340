package PA05;

public class OncampusStudentAdvanceTicket extends AdvancedTicket {

	/* Instance variable declaration*/
	private String studentID;
	private boolean status;

	/*parameterized constructor*/
	public OncampusStudentAdvanceTicket(String number, int days, String ID)
	{
		/*Fill in to instantiate the 1. purchase date variable
		2. ticket number
		3. days
		4. student ID
		5. student status
		6. ticketprice using ticket calculation
		*/
		//call super constructor for the date, ticketnumber, and days
		super(number, days);
		this.studentID = ID;
		this.status = true; //on campus true, off campus false
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
		if(status) {
			if(this.noOfDaysInAdvance >= 10)
				this.ticketCost = 15;
			else
				this.ticketCost  = 20;
		}
		this.ticketCost += onCampusBaseCharge;
	}

	@Override //overrided method to print the object details
	public String toString(){
		return super.toString() + "\t" + studentID + "\t" + status;
	}
}// end class
