package PA05;

public class WalkupTicket extends Ticket{

	/*parameterized constructor*/
	public WalkupTicket(String number)
	{
		/*Fill in to instantiate the 1. date variable
		2. ticket number
		3. ticketprice using ticket calculation
		Note that this class does not have date variable nor
			date package*/
		//use super to instantiate the date
		super();
		this.ticketNumber = number;
		calculateTicket();
	}

	/*ticket calculation*/
	public void calculateTicket()
	{
		 /*set the ticketCost. */
		this.ticketCost = 50;
	}

}
