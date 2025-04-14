package ICE06;

public class SingleFamily extends WaterBill{

	public SingleFamily(int gallons) {
		super(gallons);
		computeWaterBill();
		
	}

	@Override
	public void computeWaterBill() {
		if (gallons <= 7000)
			   value = BASE_CHARGE_SINGLR_FAMILY + gallons * 2.04 / 1000;
		else if (gallons <= 13000)
			   value = BASE_CHARGE_SINGLR_FAMILY + 7000 * 2.04 /1000 + 
			   (gallons - 7000) * 2.35 / 1000 ;
		else 
			 value = BASE_CHARGE_SINGLR_FAMILY + 7000 * 2.04 /1000 + 
			   (6000) * 2.35 / 1000 +  (gallons - 13000) * 2.70 / 1000;
		    
		
	}
	
	@Override
	public String toString() {
		return this.getGallons() + "\t" + String.format("%.2f", value) + "\t"
				+ "SingleFamily" + "\t" + this.getCreatedDate();
	}// end to String()


}
