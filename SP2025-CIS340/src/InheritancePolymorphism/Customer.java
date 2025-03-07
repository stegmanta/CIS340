package InheritancePolymorphism;

public class Customer {
	
	private String name;
	private int number;
	private PhoneBill bill;
	
	private static int noOfCustomers;

	Customer(String name, int number, PhoneBill bill) {
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

	public PhoneBill getBill() {
		return bill;
	}

	public static int getNoOfCustomers() {
		return noOfCustomers;
	}

	@Override
	public String toString() {
		return number + "\t" + name + "\t" + bill.toString();
	}		

}
