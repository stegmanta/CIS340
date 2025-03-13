package ICE5;

public interface BaseCharge {
	
	// Class variables and constants
	public	static final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
	public	static final double BASE_CHARGE_DUPLEX = 15.51;
		
	public abstract void computeBill();
}
