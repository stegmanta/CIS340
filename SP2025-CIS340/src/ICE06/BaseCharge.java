package ICE06;

public interface BaseCharge {
	
	final int SINGLR_FAMILY = 1;
	final int DUPLEX = 2;
	
	final double BASE_CHARGE_SINGLR_FAMILY=13.21;
	final double BASE_CHARGE_DUPLEX = 15.51  ;
	
	public abstract void computeWaterBill();

}
