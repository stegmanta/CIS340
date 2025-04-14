package ICE06;

// To Complete in class
// 1- make the customer class implements the Comparable interface
// 2- implement the compareTo() method to compare customers based on the bill values

public class Customer implements Comparable<Customer>{
	
	private String name;
	private int number;
	private WaterBill bill;
	
	private static int noOfCustomers;
	
	Customer(){
		this(null,0,null);
	}

	Customer(String name, int number, WaterBill bill) {
		this.name = name;
		this.number = number;
		this.bill = bill;
		noOfCustomers++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
		
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public WaterBill getBill() {
		return bill;
	}

	public static int getNoOfCustomers() {
		return noOfCustomers;
	}

	@Override
	public String toString() {
		return name + "\t" + number + "\t" + bill.toString();
	}

	@Override
	public int compareTo(Customer cust) {
		if (this.name.compareTo(cust.name) > 0)
			return 1;
		else if (this.name.compareTo(cust.name) < 0 ) // sorting by name
			return -1;
		else
		   return 0;
	}

	public int compareToByID(Customer cust) {
		if (this.number > cust.number)
			return 1;
		else if (this.number < cust.number)
			return -1;
		else
		    return 0;
	}

	
	
}
