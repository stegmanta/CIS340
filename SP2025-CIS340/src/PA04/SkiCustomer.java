package PA04;

public class SkiCustomer {
	//declare instance variables
	private String custName;
	private int daysOfStay;
	private int noOfRentalItems;
	private String memberID;
	private double memberDiscount;
	private double firstTimeUserDiscount;
	private double couponDiscountAmount;
	private double salesTaxAmount;
	private double rentalAmount;
	private double totalDiscountAmount;
	private double totalCharges;
	final private double SALES_TAX_PERCENTAGE = 7.5;
	
	public SkiCustomer(String custName, int daysOfStay, int noOfRentalItems, boolean isFirstTimeUser, boolean isCoupon) {
		this(custName, daysOfStay, noOfRentalItems, isFirstTimeUser, isCoupon, null);
	}
	
	public SkiCustomer(String custName, int daysOfStay, int noOfRentalItems, boolean isFirstTimeUser, boolean isCoupon, String memberID) {
		this.custName = custName;
		this.daysOfStay = daysOfStay;
		this.noOfRentalItems = noOfRentalItems;
		this.memberID = memberID;
		//do calculations based on args
		calculateRentalAmount();
		if(isFirstTimeUser)
			calculateFirstTimeUserDiscount();
		if(isCoupon)
			calculateCouponDiscount();
		if(this.memberID != null)
			calculateMembershipDiscount();
		calculateDiscount();
		calculateTotalCharges();
	}
	
	//getters and setters
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getDaysOfStay() {
		return daysOfStay;
	}

	public void setDaysOfStay(int daysOfStay) {
		this.daysOfStay = daysOfStay;
	}

	public int getNoOfRentalItems() {
		return noOfRentalItems;
	}

	public void setNoOfRentalItems(int noOfRentalItems) {
		this.noOfRentalItems = noOfRentalItems;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public double getMemberDIscount() {
		return memberDiscount;
	}

	public void setMemberDiscount(double memberDiscount) {
		this.memberDiscount = memberDiscount;
	}

	public double getFirstTimeUserDiscount() {
		return firstTimeUserDiscount;
	}

	public void setFirstTimeUserDiscount(double firstTimeUserDiscount) {
		this.firstTimeUserDiscount = firstTimeUserDiscount;
	}

	public double getCouponDiscountAmount() {
		return couponDiscountAmount;
	}

	public void setCouponDiscountAmount(double couponDiscountAmount) {
		this.couponDiscountAmount = couponDiscountAmount;
	}

	public double getSalesTaxAmount() {
		return salesTaxAmount;
	}

	public void setSalesTaxAmount(double salesTaxAmount) {
		this.salesTaxAmount = salesTaxAmount;
	}

	public double getTotalDiscountAmount() {
		return totalDiscountAmount;
	}

	public void setTotalDiscountAmount(double totalDiscountAmount) {
		this.totalDiscountAmount = totalDiscountAmount;
	}

	public double getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}
	
	public double getRentalAmount() {
		return this.rentalAmount;
	}
	
	//class methods
	private void calculateMembershipDiscount() {
		//sets discount amount decimal multiplier
		if(this.noOfRentalItems == 0) this.memberDiscount = 0.05; else this.memberDiscount = 0.08;
	}
	
	private void calculateCouponDiscount() {
		//returns discount amount in dollars
		if(this.noOfRentalItems == 0) this.couponDiscountAmount = 5; else this.couponDiscountAmount = 10;
	}
	private void calculateFirstTimeUserDiscount() {
		//return discount amount decimal multiplier
		if(this.noOfRentalItems == 0) this.firstTimeUserDiscount = 0.1; else this.firstTimeUserDiscount = 0.12;
	}
	private void calculateRentalAmount() {
		double base = 0.0;
		switch(this.noOfRentalItems) {
		case 0:
			base = 60;
			break;
		case 1:
			base = 110;
			break;
		case 2:
			base = 155;
			break;
		case 3:
			base = 190;
			break;
		}
		this.rentalAmount = base * this.daysOfStay;
	}
	private void calculateDiscount() {
		double base = this.rentalAmount; 
		this.totalDiscountAmount = (base * this.memberDiscount) + this.couponDiscountAmount + (base * this.firstTimeUserDiscount);
	}
	private void calculateSalesTax() {
		double taxableAmount = this.rentalAmount - this.totalDiscountAmount;
		this.salesTaxAmount = taxableAmount * (this.SALES_TAX_PERCENTAGE/100.0);
	}
	private void calculateTotalCharges() {
		calculateSalesTax();
		this.totalCharges = (this.rentalAmount - this.totalDiscountAmount) + this.salesTaxAmount;
	}
	public String toString() {
		return "Customer Name: " + custName + "\n" +
	               "Days of Stay: " + daysOfStay + "\n" +
	               "No. of Rental Items: " + noOfRentalItems + "\n" +
	               "Rental Amount: $" + String.format("%.2f", rentalAmount) + "\n" +
	               "Total Discount: $" + String.format("%.2f", totalDiscountAmount) + "\n" +
	               "Sales Tax: $" + String.format("%.2f", salesTaxAmount) + "\n" +
	               "Total Charges: $" + String.format("%.2f", totalCharges);
	}





}
