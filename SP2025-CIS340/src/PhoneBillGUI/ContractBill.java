package PhoneBillGUI;

public class ContractBill extends PhoneBill {

	public ContractBill() {
		// TODO Auto-generated constructor stub
	}

	public ContractBill(int noOfParticipants) {
		super(0, noOfParticipants);
		this.computeBill();
	}

	@Override
	public void computeBill() {
		if (this.getNoOfParticipants() == 1)
			value = BASE_CONTRACT_CHARGE;
		else if (getNoOfParticipants() == 2)
			value = BASE_CONTRACT_CHARGE + (BASE_CONTRACT_CHARGE * 0.05);
		else if (getNoOfParticipants() == 3)
			value = BASE_CONTRACT_CHARGE + (BASE_CONTRACT_CHARGE * 0.05) +
					(BASE_CONTRACT_CHARGE * 0.1); 
		else 
			value = BASE_CONTRACT_CHARGE + (BASE_CONTRACT_CHARGE * 0.05) +
			(BASE_CONTRACT_CHARGE * 0.1) + (BASE_CONTRACT_CHARGE * 0.15); 
	}
	
	
	@Override
	public String toString() {
		return "Contract Bill\t" +  0 + "\t" + getNoOfParticipants()
				+ "\t" + String.format("%.2f",value) + "\t" + getCreatedDate();
	}
	
	

}
