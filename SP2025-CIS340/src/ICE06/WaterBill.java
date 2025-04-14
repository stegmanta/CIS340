package ICE06;

import java.util.Date;

public abstract class WaterBill implements BaseCharge{
	
	protected int gallons;
	protected double value;
	private Date createdDate;
	
	public WaterBill(int gallons) {
		this.gallons = gallons;
		this.createdDate =  new Date();
			
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

		

	

}
