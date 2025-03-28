package InClassProgram;

import javax.swing.*;

public class PhoneBill {

	public static void main(String[] args) {
		
		// Declare all variables and constants
		int minutes = 0,  numberOfParticipants = 0, custType = 0;
		String name="";
		double value = 0;
		
		final double BASE_HOURLY_CHARGE = 19.99;
		final double BASE_CONTRACT_CHARGE = 16.95;
		
			
		
		// User Inputs
		// Display input dialog box
		
		// Input customer name
		name = JOptionPane.showInputDialog(null,"Enter The Customer Name:");
		if (name.isEmpty() || !name.matches("[A-Z][a-z]+\\s+[A-Z][a-z]+")) {
			JOptionPane.showMessageDialog(null, "Invalid, Customer Name, Input? \nSystem Exit!");
			System.exit(0);
		}// end if
		
		// Input the customer type
		try {
		
			custType = Integer.parseInt(JOptionPane.showInputDialog(
				"Enter Customer Type: \n 0 - Hourly Bill \n 1 - Contract Bill"));
			
			if ((custType != 0) && (custType != 1))
				throw new Exception();
						
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Ivalid, Customer Type, Input? \nSystem Exit!");
			System.exit(0);
			
		}// end try
		
		
		//Calculate the cell phone bill value
		switch(custType) {
		
		case 0:  // Compute Bill For Hourly Type
			
			// Input number of minutes
			try {
			
				minutes = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter The Number Of Minutes:"));
			
			
			if (minutes < 0 )
				throw new NumberFormatException();
						
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Ivalid, Number of Minutes, Input? \nSystem Exit!");
			System.exit(0);
			
		}// end try
						
			if (minutes < 200)
				value = BASE_HOURLY_CHARGE;
			else if ( (minutes >= 200) && (minutes < 350))
				value = BASE_HOURLY_CHARGE + (minutes - 200) * 0.1;
			else
				value = BASE_HOURLY_CHARGE + (350 - 200) * 0.1 + (minutes - 350) * 0.12;
			
			break;
			
		case 1: // Compute Bill For Contract Type
			try {
			
				numberOfParticipants = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter The Number Of Participants (Max 4):"));
						
				if ((numberOfParticipants < 1) || (numberOfParticipants > 4 ))
					throw new NumberFormatException();
							
			} catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ivalid, Number Of Participants, Input? \nSystem Exit!");
				System.exit(0);
				
			}// end try
				
			if (numberOfParticipants == 1)
				value = BASE_CONTRACT_CHARGE;
			else if (numberOfParticipants == 2)
				value = BASE_CONTRACT_CHARGE + BASE_CONTRACT_CHARGE * 0.5;
			else if (numberOfParticipants == 3)
				value = BASE_CONTRACT_CHARGE + BASE_CONTRACT_CHARGE * 0.5 +
						BASE_CONTRACT_CHARGE * 0.10;
			else if (numberOfParticipants == 4)
				value = BASE_CONTRACT_CHARGE + BASE_CONTRACT_CHARGE * 0.5 +
						BASE_CONTRACT_CHARGE * 0.10 + BASE_CONTRACT_CHARGE * 0.15;
			
		} // end switch
		
		
		//Output cell phone bill
		if (custType == 0)
		     JOptionPane.showMessageDialog(null, new JTextArea( "GO Bill:" +"\nCustomer Name " + name  
				   + "\nNumber of Minutes " + minutes + "\nYour Bill Value: "
				        + String.format("%.2f", value)) ); 
		else
			JOptionPane.showMessageDialog(null, new JTextArea( "Contract Bill:" +"\nCustomer Name " + name  
					   + "\nNumber of Participants " +  numberOfParticipants  + "\nYour Bill Value: "
					        + String.format("%.2f", value)) ); 	
		
	} // end main method

}// end class
