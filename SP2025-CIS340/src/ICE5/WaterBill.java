package ICE5;

import java.util.Date;

// To Complete
// Make this class as an abstract class, that has an abstract method computeBill()
// Next, this class implements and interface: BaseCharge 
// It has the public static variables and abstract method of computeBill()

public abstract class WaterBill implements BaseCharge{
	
	// data fields 
	private int gallons;
	protected double value;
	private Date createdDate;
	
	
	// constructors
	WaterBill(){
		this(0);
		this.value = 0;
	}

	WaterBill(int gallons) {
		this.gallons = gallons;
		this.createdDate = new Date();
		}

	public int getGallons() {
		return gallons;
	}

	public void setGallons(int gallons) {
		this.gallons = gallons;
	}

	public double getValue() {
		return value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	// To Complete
	// This needs to be placed in an interface
	
}// end
