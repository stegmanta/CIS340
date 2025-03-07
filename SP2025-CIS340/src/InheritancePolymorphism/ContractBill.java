package InheritancePolymorphism;

public class ContractBill extends PhoneBill{
	
	public ContractBill(){
		super();
	}
	
	public ContractBill(int noOfParticipants) {
		super(0, noOfParticipants);
		// TODO Auto-generated constructor stub
	}

	public void computeBill() {
		if(getNoOfParticipants() == 1)
			value = BASE_CONTRACT_CHARGE;
	}
	
	public String toString() {
		return "Contract Bill\t" + this.getNoOfParticipants() + "\t"
				+ String.format("%.2f", value) + "\t" + this.getValue();
	}

}
