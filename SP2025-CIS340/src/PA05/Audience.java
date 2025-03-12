package PA05;

/*Audience class to perform manipulations on Ticket class objects*/
public class Audience implements Comparable<Audience> {

	/* Instance variable declaration*/
	private String name;
	private Ticket ticket;
	private static int noOfAudience;

	/*default constructor*/
	public Audience() {
		this(null,null);
	}

	/*parameterized constructor*/
	public Audience(String name, Ticket ticket) {
		this.name = name;
		this.ticket = ticket;
		noOfAudience++;
	}

	/*Getter and setter methods*/
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public static int getNoOfAudience() {
		return noOfAudience;
	}

	@Override //method to name and ticket object details
	public String toString() {
		return name + "\t" + ticket.toString();
	}

	@Override //method to compare the ticket cost of 2 objects
	public int compareTo(Audience Audience) {
		return Double.compare(this.ticket.ticketCost, Audience.ticket.ticketCost);
	}
}// end class
