
public class PayRecord {
	
	private int rID;
    private Employee employee;
    private PayPeriod payPeriod;
    private TaxIncome payTax;
    
    private double payHours;
    private double payRate;
    
    private double monthlyIncome;
    private int numMonths;
    
       
    
    public static final int REG_HOURS = 40;
    public static final double OT_RATE = 1.25;
    
    // pay record constructor for hourly employee
    public PayRecord(int id, Employee e, PayPeriod period, double hours, double rate){
    	this.rID = id;
    	this.employee = e;
    	this.payPeriod = period;
    	this.payHours = hours;
    	this.payRate = rate;
    	this.monthlyIncome = 0;
    	this.numMonths = 0;
    	this.payTax = new TaxIncome();
    }
    
    // pay record constructor for full time employee
    public PayRecord(int id, Employee e, PayPeriod period, double mIncome, int mNum){
	 	this.rID = id;
	 	this.employee = e;
	 	this.payPeriod = period;
	 	this.payHours = 0;
	 	this.payRate = 0;
	 	this.monthlyIncome = mIncome;
	 	this.numMonths = mNum;
	 	this.payTax = new TaxIncome();
 }


  // 1- add setters and getters methods
    
    public int getRID() {
		return rID;
	}

	public void setRID(int rID) {
		this.rID = rID;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PayPeriod getPayPeriod() {
		return payPeriod;
	}

	public void setPayPeriod(PayPeriod payPeriod) {
		this.payPeriod = payPeriod;
	}

	public TaxIncome getPayTax() {
		return payTax;
	}

	public double getPayHours() {
		return payHours;
	}

	public void setPayHours(double payHours) {
		this.payHours = payHours;
	}

	public double getPayRate() {
		return payRate;
	}

	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public int getNumMonths() {
		return numMonths;
	}

	public void setNumMonths(int numMonths) {
		this.numMonths = numMonths;
	}

	public static int getRegHours() {
		return REG_HOURS;
	}

	public static double getOtRate() {
		return OT_RATE;
	}

  // 2- add override method toString()
	@Override
	public String toString() {
	    double gross = grossPay();
	    double tax   = payTax.compIncomeTax(gross);
	    double net   = gross - tax;
	    return String.format("PayRecord [rID=%d, Employee=%s, Period=%s, grossPay=%.2f, incomeTax=%.2f, netPay=%.2f]", 
	                         rID, employee, payPeriod, gross, tax, net);
	}
	
  // 3- complete the code in the following methods: grossPay() and netPay()
 

	// complete the code to compute the gross pay for the employee based on the employee status
	public double grossPay(){
		double gp = 0;
		//full time employee
		if(employee.empStatus() == Status.FULLTIME) {
			gp = numMonths * monthlyIncome; 
		//else hourly
		}else {
			if(payHours <= REG_HOURS) {
				gp = payRate * payHours;
			}else {
				gp = (payRate * REG_HOURS) + ((payHours - REG_HOURS) * payRate * OT_RATE);
			}
		}
		return gp;
	}
    
  // complete the code in this method to compute the net pay of the employee after taxes (state and federal)
    public double netPay(){
    	double gross = grossPay();
    	return gross - payTax.compIncomeTax(gross);
    }

}
