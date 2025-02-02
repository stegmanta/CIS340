package ICE1;
import javax.swing.*;

/* ICE1 To Be Completed in Class
   Created By Dr. Abdunabi
   01/24/2024 */
public class TaylerStegmanICE1 {

	public static void main(String[] args) {
		
		// declare variables and constants
		int gallons = 0;
		double value = 0;
		String custName = null;
		int custNumber = 0;
		int custType=0;
		String output="WATER BILL";
		
		// constants for single-family & duplex base charges
		final double BASE_CHARGE_SINGLE_FAMILY = 13.21 ;
		final double BASE_CHARGE_DUPLEX = 15.51  ;
		
		
		// input customer Rate/Type
		// To Complete: add input validation, and customer number must be 0 or 1
		String[] choices = {" Single Family ", "Duplex "};
	       custType = JOptionPane.showOptionDialog(
	               null                       // Center in window.
	               , "Select The Customer Bill Type:"        // Message
	               , "Water Bill"               // Title in titlebar
	               , JOptionPane.YES_NO_OPTION  // Option type
	               , JOptionPane.PLAIN_MESSAGE  // messageType
	               , null                       // Icon (none)
	               , choices                    // Button text as above.
	               , null    // Default button's label
	       );
	     if(custType == -1) {
	    	 JOptionPane.showMessageDialog(null,"Invalid rate, please select a rate");
	    	 System.exit(0);
	     }
	     
		
		// input customer number
		// To Complete: Add input validation, the number must be 6 digits
	     try {
			custNumber=Integer.parseInt(
					JOptionPane.showInputDialog(null,"Enter customer number: "));
			if(!String.valueOf(custNumber).matches("[0-9][0-9][0-9][0-9][0-9][0-9]"))
				throw new Exception();
	     }catch(Exception ex) {
	    	 JOptionPane.showMessageDialog(null, "Please enter a 6-digit customer number", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
	    	 System.exit(0);
	     }
		// input customer name
		// To Complete: Add input validation, the name must not be empty
		custName=JOptionPane.showInputDialog(null,"Enter customer name: ");
		if(!custName.matches("[A-Z][a-z]+\\s+[A-Z][a-z]+")) {
			 JOptionPane.showMessageDialog(null, "Please enter a valid customer name\ncannot be empty!", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			 System.exit(0);
		}
		
		// input number of gallons
		// To Complete: Add input validation, the number must not be below 0
		try {
			gallons=Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of gallons: "));
			if(gallons < 0)
				throw new Exception();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Please enter a valid value for gallons!\nCannot be negative!", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		// compute customer bill
		switch (custType) {
		case 0: // To Complete: compute the water bill value for single-family
			output+=" -Single-Type Rate:\n------------------------------------------------------\n";
			if(gallons <= 7000)
				value = BASE_CHARGE_SINGLE_FAMILY + gallons * 2.04 / 1000;
			else if(gallons <= 13000)
				value = BASE_CHARGE_SINGLE_FAMILY + 7000 * 2.04 / 1000 + (gallons - 7000) * 2.35 / 1000;
			else
				value = BASE_CHARGE_SINGLE_FAMILY + 7000 * 2.04 / 1000 + 6000 * 2.35 / 1000 + (gallons - 13000) * 2.70 / 1000;
				break;
		case 1: // To Complete: compute the water bill value for duplex
			output+=" - Duplex rate:\n----------------------------------------------------------\n";
			if(gallons <= 9000)
				value = BASE_CHARGE_DUPLEX + gallons * 1.97 / 1000;
			else if(gallons <= 13000)
				value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 + (gallons - 7000) * 2.26 / 1000;
			else
				value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 + 4000 * 2.26 / 1000 + (gallons - 13000) * 2.60 / 1000;
		}// end of switch statement
		
		
		// display the program output
		output+="Customer Number:\t"+custNumber+"\nCustomer Name:\t"+custName+
				"\nGallons:\t\t"+gallons+"\nBill Value:\t\t$"+String.format("%.2f", value);
		JOptionPane.showMessageDialog(null, new JTextArea(output));

	}// end of main
}// end of class
