package ICE4;

import java.util.Date;

public class WaterBill {
	
	// Data fields
	private int gallons;
	private int custType;
	private double value;
	private Date createdDate;
	
	// Class variables and constants
	static final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
	static final double BASE_CHARGE_DUPLEX = 15.51;
	
	// Constructors
	WaterBill(){
		this.gallons = 0;
		this.custType = 0;
		this.value = 0;
		this.createdDate = null;
		
	}

	public WaterBill(int gallons, int custType) {
		this.gallons = gallons;
		this.custType = custType;
		this.createdDate = new Date();
		this.computeBill();
	}

	public int getGallons() {
		return gallons;
	}

	public void setGallons(int gallons) {
		if (gallons > 0) {
		   this.gallons = gallons;
		  this.computeBill();  
		}
	}

	public int getCustType() {
		return custType;
	}

	public void setCustType(int custType) {
		if ((this.custType ==1) || (this.custType == 2) ) {
			this.custType = custType;
			this.computeBill();
		}
		
	}

	public double getValue() {
		return value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	private void computeBill() {
		switch (custType) {
		case 1: // Single family
			if (gallons <= 7000)
		    	value = BASE_CHARGE_SINGLE_FAMILY + gallons * (2.04 / 1000.0);
		    else if (gallons <= 13000)
		    	value = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.04 / 1000.0)
		    	+ (gallons - 7000) * (2.35 / 1000.0);
		    else
		    	value = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.04 / 1000.0)
		    	+ (13000 - 7000) * (2.35 / 1000.0) + (gallons - 13000)  *
		    	  (2.70 / 1000.0);
			    break;
		case 2: // Duplex
			if (gallons <= 9000)
		    	value = BASE_CHARGE_DUPLEX + gallons * (1.97 / 1000.0);
		    else if (gallons <= 13000)
		    	value = BASE_CHARGE_DUPLEX + 9000 * (1.97 / 1000.0)
		    	+ (this.gallons - 9000) * (2.26 / 1000.0);
		    else
		    	value = BASE_CHARGE_DUPLEX + 9000 * (1.97 / 1000.0)
		    	+ (13000 - 9000) * (2.26 / 1000.0) + (gallons - 13000)  *
		    	  (2.60 / 1000.0);
			    
		}// end switch
		
		
	}

	@Override
	public String toString() {
		if (custType == 1)
			return  gallons + "\t" + String.format("%.2f", value) + "\t"
			+ "SingleFamily" + "\t" + createdDate.toString();
		else 
			return gallons + "\t" + String.format("%.2f", value) + "\t"
			+ "Duplex" + "\t" + createdDate;
	}
		

}// end class
