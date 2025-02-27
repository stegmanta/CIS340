package ICE4;

public class Customer {
	
	// Data Fields
	private String name;
	private int number;
	private WaterBill bill;
	
	// Class Variables
	private static int noOfCustObjects;
	
	// constructors
	Customer(){
		this.name= "";
		this.number = 0;
		this.bill = null;
		noOfCustObjects++;
	}

	Customer(String name, int number, WaterBill bill) {
		this.name = name;
		this.number = number;
		this.bill = bill;
		noOfCustObjects++;
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
		if (String.valueOf(number).length() == 6)
		this.number = number;
	}

	public WaterBill getBill() {
		return bill;
	}

	public void setBill(WaterBill bill) {
		this.bill = bill;
	}

	public static int getNoOfCustObjects() {
		return noOfCustObjects;
	}

	@Override
	public String toString() {
		return name + "\t" + number + "\t" + bill.toString();
	}
	
	
	
}// end 
