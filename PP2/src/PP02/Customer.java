package PP02;


public class Customer extends Payment{
	
	private int id;
	private String fName, lName;
	private double amount;
	private CreditCard card;
	
	public Customer(String fName, String lName, int id, double amount, CreditCard card) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.id = id;
		this.amount = amount;
		this.card = card;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CreditCard getCard() {
		return card;
	}

	public void setCard(CreditCard card) {
		this.card = card;
	}

	@Override
	public String toString() {
	    return "Customer ID: " + id + ", Name: " + fName + " " + lName + ", Amount: $" + amount + ", Credit Card: " + card + ", hashCode: " + hashCode();
	}
	
	
	// add public setter/getter methods, and also the toString method

}
