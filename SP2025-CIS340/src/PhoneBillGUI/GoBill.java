package PhoneBillGUI;

public class GoBill extends PhoneBill {

	public GoBill() {
		super();
	}

	public GoBill(int minutes) {
		super(minutes, 0);
		this.computeBill();
		
	}

	
	@Override
	public void computeBill() {
		 
		if (this.getMinutes() < 200)
			 value =  BASE_Go_CHARGE; 
		else if (getMinutes() < 350) 
			 value = BASE_Go_CHARGE+(getMinutes() - 200) * 0.1; 
		 else value = BASE_Go_CHARGE + (350 - 200) * 0.1 + (this.getMinutes() - 350)
		  * .12; 
     }

	@Override
	public String toString() {
		return "Go Bill\t" + getMinutes() + "\t" + 0 + "\t" +
				 String.format("%.2f",value) + "\t" + getCreatedDate();
	}
	
	

}
