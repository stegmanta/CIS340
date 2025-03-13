package ICE5;

public class SingleFamily extends WaterBill{
	
	SingleFamily(int gallons) {
		super(gallons);
		this.computeBill();
	}

	@Override
	public void computeBill() {
		if (getGallons() <= 7000)
			 value = BASE_CHARGE_SINGLE_FAMILY + getGallons() * (2.53 /1000.0);
			else if (getGallons() <=13000)
				value = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.53 /1000.0) + (getGallons() - 7000) * (2.91 / 1000.0);
			else 
				value = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.53 /1000.0) + (13000 - 7000) * (2.91 / 1000.0) +
				 (getGallons() - 13000) * (3.34 / 1000.0);
	}// end computeBill()

	
	@Override
	public String toString() {
		return getGallons() + "\t" + String.format("%.2f",value) + "\t" + "Single Family" + "\t"
				+ this.getCreatedDate();
	}
	
	

}
