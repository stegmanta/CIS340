package InheritancePolymorphism;

public class GoBill extends PhoneBill {
	
	public GoBill(int minutes) {
		super(minutes, 0);
		this.computeBill();
	}

	@Override
	protected void computeBill() {
		// TODO Auto-generated method stub
		if(this.getMinutes() < 200)
			value = BASE_Go_CHARGE;
		//more code for this alg is missing
	}

	@Override
	public String toString() {
		return "GoBill [value=" + value + "]" +  "\t" + this.getCreatedDate() ;
	}
	
	
	
}
