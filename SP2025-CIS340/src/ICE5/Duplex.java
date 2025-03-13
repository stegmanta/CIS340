package ICE5;

public class Duplex extends WaterBill{

	Duplex(int gallons) {
		super(gallons);
		computeBill();
	}

	@Override
	public void computeBill() {
		if (this.getGallons() <= 9000)
			 value = BASE_CHARGE_DUPLEX + getGallons()* (1.97 /1000.0);
			else if (getGallons() <=13000)
				value = BASE_CHARGE_DUPLEX + 9000 * (1.97 /1000.0) + (getGallons() - 9000) * (2.26 / 1000.0);
			else 
				value = BASE_CHARGE_DUPLEX + 9000 * (1.97 /1000.0) + (13000 - 9000) * (2.26 / 1000.0) +
				 (getGallons() - 13000) * (2.6 / 1000.0);
	}// end computeBill()

	@Override
	public String toString() {
		return getGallons() + "\t" + String.format("%.2f",value) + "\t" + "Duplex" + "\t"
				+ getCreatedDate();
	}
	
}
