
import java.util.Date;


public class PayPeriod {
	
	private int pID;
    private Date pStartDate, pEndDate;
    
    // 1- add the class constructor
    public PayPeriod(int pID, Date pStartDate, Date pEndDate) {
    	this.pID = pID;
    	this.pStartDate = pStartDate;
    	this.pEndDate = pEndDate;
    }
    // 2- add the setters/getters methods
    public int getPID() {
		return pID;
	}

	public void setPID(int pID) {
		this.pID = pID;
	}

	public Date getPStartDate() {
		return pStartDate;
	}

	public void setPStartDate(Date pStartDate) {
		this.pStartDate = pStartDate;
	}

	public Date getPEndDate() {
		return pEndDate;
	}

	public void setPEndDate(Date pEndDate) {
		this.pEndDate = pEndDate;
	}

	// 3- add override method toString() 
	@Override
	public String toString() {
		return String.format("PayPeriod [pID=%s, pStartDate=%s, pEndDate=%s]", pID, pStartDate, pEndDate);
	}
	
}
