package PA05;

public class AdvancedTicket extends Ticket{

	/* Instance variable declaration*/
	protected int noOfDaysInAdvance;

	/* Default constructor*/
	AdvancedTicket(){
		/*Fill in to instantiate only the purchase date variable
			Note that this class does not have date variable nor
			date package*/
		//use super to instantiate purchase date
		super();
	}

	/*parameterized constructor*/
	public AdvancedTicket(String number, int days)	{
		/*Fill in to instantiate the 1. purchase date variable
		2. ticket number
		3. days
		4. ticketprice using ticket calculation */
		//use super to instantiate purchase date
		super();
		this.ticketNumber = number;
		this.noOfDaysInAdvance = days;
		calculateTicket();
	}

	/*getter method*/
	public int getNoOfDaysInAdvance(){
		//return
		return this.noOfDaysInAdvance;
	}

	/*ticket calculation*/
	public void calculateTicket(){
		//fill in to calculate ticket cost based on number of days
		if(this.noOfDaysInAdvance >= 10)
			//10 or more days before is 30
			this.ticketCost = 30;
		else
			//less than 10 days is 40
			this.ticketCost = 40;
	}

	@Override //overrided method to print the object details
	public String toString(){
		return super.toString() + "\t" + noOfDaysInAdvance;
	}
}// end class
