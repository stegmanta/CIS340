package PA05;

/*Audience class to perform manipulations on Ticket class objects*/
public class Audience implements Comparable<Audience> {

	/* Instance variable declaration*/
	private String name;
	private Ticket ticket;
	private static int noOfAudience;

	/*default constructor*/
	public Audience() {
		//Fill in
	}

	/*parameterized constructor*/
	public Audience(String name, Ticket ticket) {
		//Fill in
	}

	/*Getter and setter methods*/
	public String getName() {
		//return
	}

	public void setName(String name) {
		//
	}

	public Ticket getticket() {
		//return
	}

	public void setticket(Ticket ticket) {
		//
	}

	public static int getNoOfAudience() {
		//return
	}

	@Override //method to name and ticket object details
	public String toString() {
		//return
	}

	@Override //method to compare the ticket cost of 2 objects
	public int compareTo(Audience Audience) {
		//Fill in the logic
	}
}// end class
