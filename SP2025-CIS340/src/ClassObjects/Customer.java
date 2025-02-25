package ClassObjects;

public class Customer {
	//data fields
	private String name;
	private int number;
	private PhoneBill bill;
	
	//static
	public static int noOfCustomers;

	public Customer(String name, int number, PhoneBill bill) {
		this.name = name;
		this.number = number;
		this.bill = bill;
		//increment number of customers after constructed
		noOfCustomers++;
	}
	
	public Customer() {
		this("",0,null);
	}
	
}
