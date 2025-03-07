// Phone Bill Project 
// Dr. Abdunabi 

package InheritancePolymorphism;

import javax.swing.JOptionPane;

public class DataEntries {
	
	// returns an integer input greater than 0 
	public static int intInput(String m) {
        int choice = 0;
		int intUserInput = 0;
		while (choice == JOptionPane.YES_OPTION) {
			try { 
				intUserInput =
			 Integer.parseInt(JOptionPane.showInputDialog(m));
			  
			  if (intUserInput < 1) 
				   throw new NumberFormatException();
			  
			 choice = 1;  
			} catch (NumberFormatException ex) { 
				
				JOptionPane.showMessageDialog(null,"Invalid " + m + " Format");
				choice = JOptionPane.showConfirmDialog(null, "Would You Like to Continue!");
				
				if (choice !=0)
					System.exit(0);
			  } // end try-catch
		}// end while
		
		return intUserInput; // return user input
	}// end intInput()
	

	// returns an integer input with certain number of digits 
	 public static int intInputSize(int s, String m) {
	    	int intUserInput = 0;
	    	while(true) {							
				try {
				String custIdStr = JOptionPane.showInputDialog(m);
				
				if (custIdStr.length()!=s)
					throw new NumberFormatException();
				
				intUserInput = Integer.parseInt(custIdStr); 
				
				break;
				
				} catch (NumberFormatException ex) {
					   JOptionPane.showMessageDialog(null, "Invalid " + m + " Format");
					 
				}// end-try catch
			}// end while
			
	    	
	    	return intUserInput; // return user input
		}// end intInput()

	 // returns an integer input with two values only
	 public static int intInputChoice(int c1, int c2, String m) {
		
		 int intUserInput = 0;
		 while (true) {
				try {
				 intUserInput = Integer.parseInt(JOptionPane.showInputDialog(m));
				
				if ( (intUserInput != c1) && (intUserInput != c2))
					throw new NumberFormatException();
				
				break;
				
				} catch (NumberFormatException ex) {
					   JOptionPane.showMessageDialog(null, "Invalid " + m + " Format");
					   
				}// try-catch
			}//end while
			
		    return intUserInput; // return user input
		}// end intInput()
	    
	 // returns an integer input with a certain range
	 public static int intInputRange(int start, int end, String m) {
		 int intUserInput = 0;
		 while (true) {
				try {
					
					String noStr = JOptionPane.showInputDialog(m);
					intUserInput = Integer.parseInt(noStr);
					
					if ( (intUserInput > end) || (intUserInput < start ) ) 
							 throw new  NumberFormatException();
					
					break;
					} catch (NumberFormatException ex) {
					   JOptionPane.showMessageDialog(null, "Invalid " + m + " Format");
					  
					 }// try-catch
			}// end while
		 
		 return intUserInput; // return user input
	 } // end intRange()
	 
	 // returns a double input with a positive value
	 public static double doubleInput(String m) {
		 int choice = 0;
			double dbUserInput = 0;
			while (choice == JOptionPane.YES_OPTION) {
				try { 
					dbUserInput =
				 Double.parseDouble(JOptionPane.showInputDialog(m));
				  
				  if (dbUserInput < 1) 
					   throw new NumberFormatException();
				  
				 choice = 1;  
				} catch (NumberFormatException ex) { 
					
					JOptionPane.showMessageDialog(null,"Invalid " + m +" Format");
					choice = JOptionPane.showConfirmDialog(null, "Would You Like to Continue!");
					
					if (choice !=0)
						System.exit(0);
				  } // end try-catch
			}// end while
			
			return dbUserInput; // return user input
		
	}// end intInput()
	
	 // returns a string input with no null string
	public static String strInput(String m) {
		String strUserInput = null;
		while(true) {
			strUserInput = JOptionPane.showInputDialog(m);
			if (strUserInput.isEmpty()) 
				JOptionPane.showMessageDialog(null, "Invalid " + m + " Format");
			else 
				break;
			
			}// end while
			
		
		return strUserInput; // return user input
	}// end intInput()

    
   
}// end class 
