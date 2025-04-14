package ICE06;

public class Duplex extends WaterBill {

	public Duplex(int gallons) {
		super(gallons);
		computeWaterBill();
	}

	@Override
	public void computeWaterBill() {
		if (gallons <= 9000)
		 	value = BASE_CHARGE_DUPLEX + gallons * 
		 	1.97	 / 1000;
		else if (gallons <= 13000)
			value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 + 
			(gallons - 9000) * 2.26 / 1000;
		else 
			value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 +
			4000 * 2.26 / 1000 + (gallons - 13000) * 2.60	 
			/ 1000;
	}
	
	
	@Override
	public String toString() {
		return this.getGallons() + "\t" + String.format("%.2f", value) + "\t"
				+ "Duplex" + "\t" + this.getCreatedDate();
	}// end to String()
	
	
}
