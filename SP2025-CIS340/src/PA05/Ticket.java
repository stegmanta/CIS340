package PA05;

import java.util.Date;

public abstract class Ticket implements BaseTicket{

	/* Instance variable declaration*/
	protected String ticketNumber;
	protected double ticketCost;
	protected Date purchaseDate;

	/* Default constructor*/
	Ticket(){
		this.purchaseDate = new Date();
	}

	/*getter methods*/
	public String getTicketNumber(){
		return this.ticketNumber;
	}

	public Date getPurchaseDate(){
		return this.purchaseDate;
	}
	
	public abstract void calculateTicket();

	@Override //method to print ticket number and ticket cost
	public String toString(){
		return "Ticket number: " + ticketNumber + " Ticket Cost: " + ticketCost;
	}
}// end class
