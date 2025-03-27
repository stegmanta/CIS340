package PhoneBillGUI;

public interface BaseCharge {
	
	final int GO_BILL = 0;
	final int CONTRACT_BILL = 1;
	
	
	final static double BASE_Go_CHARGE = 19.99;
	final static double BASE_CONTRACT_CHARGE = 16.95;
	
	public abstract void computeBill(); 

}
