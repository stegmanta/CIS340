package ICE2;
// Created by Dr. Abdunabi
import javax.swing.*;

public class TaylerStegmanICE2 {
	
	public static void main(String[] args) {
		
		// declare variables and constants
		final double BASE_CHARGE_SINGLE_FAMILY = 13.21;
		final double BASE_CHARGE_DUPLEX = 15.51;
			
		String custName = "";
		String custTypeStr = "";
		String sortedOutput = "";
		int custNumber = 0, gallons = 0, custType = 0;
		double billValue = 0;
		int noOfCustomers = 0;
		String output = "Water Bill:";
		output += "\n" + "Customer Type\t\tCustomer Number\tCustomer Name\tGallons\tBill Value\t\t";
		
		
		// declaring arrays
		String[] custInfoArr;
		double[] billArr;
		
		//obtain number of customers
		int option = JOptionPane.YES_OPTION; // = 0
		while(true) {
		   try {
			
			   noOfCustomers = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Customers")); 
			    // Input validation
				if (noOfCustomers <= 0) 
					throw new Exception();
								
				break;
												
			  } catch(Exception ex) {
					option = JOptionPane.showConfirmDialog(null, "Invalid Number of Customers Input \n Would You Like To Try Again?");
					if (option != JOptionPane.YES_OPTION)
					      System.exit(0);
			 }// end try-catch
				
			}// end while
				
		// create the arrays with the size of the number of customers
		custInfoArr = new String[noOfCustomers];
		billArr = new double[noOfCustomers];
		
		// read customers data and fill the arrays with that data
		// Start for-loop
		for (int i =0; i < noOfCustomers; i++ ) {
		
		//Obtain user input - customer type
		String[] choices = {" Single Family ", " Duplex "};
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
		
		
		// add customer type to the custTypeStr variable
		if (custType == 0)
			custTypeStr = "Single Family";
		else
			custTypeStr = "Duplex";
			
						
		//Obtain user input - customer number
		while(true) {
			try {
				
				custNumber = Integer.parseInt( JOptionPane.showInputDialog("Enter Customer Number: ") ) ;
				// check if the customer number is 6 digits
				if (String.valueOf(custNumber).trim().length()!=6)
					throw new NumberFormatException(); 

				break;
							
			} catch(Exception ex) {
				option = JOptionPane.showConfirmDialog(null, "Invalid Customer Number Input \n Would You Like To Try Again?");
				if (option != JOptionPane.YES_OPTION)
					System.exit(0);
		        }// end try-catch
         }// end while	
		
		//Obtain user input - customer name
		while(true) {
		      custName = JOptionPane.showInputDialog("Enter Customer Name:");
		      if(!custName.matches("[A-Z][a-z]+\\s+[A-Z][a-z]+")) {
		    	  option = JOptionPane.showConfirmDialog(null, "Invalid Customer Name Input \n Would You Like To Try Again?");
				  if (option != JOptionPane.YES_OPTION)
						System.exit(0);
		      } else
		    	  break;
	 	}// end while
		
		
		//Obtain user input - number of gallons used
		while(true) {
			try {
				gallons = Integer.parseInt( JOptionPane.showInputDialog("Enter Number of Gallons Used:") ) ;
				
				if (gallons < 0) 
					throw new Exception();
				break;
			
			
			} catch(Exception ex) {
				option = JOptionPane.showConfirmDialog(null, "Invalid Number Og Gallons Input \n Would You Like To Try Again?");
				if (option != JOptionPane.YES_OPTION)
					System.exit(0);
		        }// end try-catch
       }// end while	
		
		//Calculate the water bill amount
		switch(custType) {
		case 0: // Compute Water Bill For Single Family
			    if (gallons <= 7000)
			    	billValue = BASE_CHARGE_SINGLE_FAMILY + gallons * (2.04 / 1000);
			    else if (gallons <= 13000)
			    	billValue = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.04 / 1000) + 
			    	 (gallons - 7000) * (2.35 / 1000);
			    else
			    	 billValue = BASE_CHARGE_SINGLE_FAMILY + 7000 * (2.04 / 1000) + 
			    	 (13000 - 7000) * (2.35 / 1000) + (gallons - 13000) * (2.70 / 1000);
			
			  // output+= "\nSingle Family \n-------------------------";
			   break;
			
		case 1: // Compute Water Bill For Duplex 
			
			if (gallons <= 9000)
		    	billValue = BASE_CHARGE_SINGLE_FAMILY + gallons * (1.97 / 1000);
		    else if (gallons <= 13000)
		    	billValue = BASE_CHARGE_SINGLE_FAMILY + 9000 * (1.97 / 1000) + 
		    	 (gallons - 9000) * (2.26 / 1000);
		    else
		    	 billValue = BASE_CHARGE_SINGLE_FAMILY + 9000 * (1.97 / 1000) + 
		    	 (13000 - 9000) * (2.26 / 1000) + (gallons - 13000) * (2.60 / 1000);
			
			//output+= "\nDuplex \n-------------------------";
		
		}// end switch statement 
		
		// add customer info and value to the custInfoArr and billArr arrays at index i
		custInfoArr[i] = custTypeStr + "\t\t" + custNumber + "\t\t" + custName + "\t\t" +
		                  gallons +"\t";
		billArr[i] = billValue;
		
		// Fill the program output into the output message
		output+= "\n" + custInfoArr[i] + String.format("%.2f", billArr[i]) +"\t";
		
		} // end of for-loop	
		
		
		//To Complete
		// find the maximum bill value
		int index = 0;
		double max = billArr[0], min = billArr[0];
		for(int i = 0; i < billArr.length;i++) {
			if(billArr[i] > max) {
				max = billArr[i];
				index = i;
			}
		}
		
		
		//To Complete
		// Add the maximum bill value info to the output, using the index value found in the previous code
		output+= "\nMax Bill Value: ----------------------";
		output+= "\n" + custInfoArr[index] + String.format("%.2f", billArr[index]) +"\t";
		
		
		//To Complete
    	// find the minimum bill value
		index = 0;
		for(int i = 0; i < billArr.length; i++) {
			if(billArr[i] < min) {
				min = billArr[i];
				index = i;
			}
		}
		
		
		// Add the minimum bill value info to the output, using the index value found in the previous code
		output+= "\nMin Bill Value: " + min;
		output+= "\n" + custInfoArr[index] + String.format("%.2f", billArr[index]) +"\t";
		
		// To complete
		// sort both arrays based on the bill values in the billArr array
		// use selection sort, find it under the array examples in Canvas 
		for (int i = 0; i < billArr.length - 1; i++) {
		      // Find the minimum in the list[i..list.length-1]
		      double currentMin = billArr[i];
		      String currentMinInfo = custInfoArr[i];
		      int currentMinIndex = i;

		      for (int j = i + 1; j < billArr.length; j++) {
		        if (currentMin > billArr[j]) {
		          currentMin = billArr[j];
		          //also change customer info
		          currentMinInfo = custInfoArr[j];
		          currentMinIndex = j;
		          sortedOutput+= "\n" + custInfoArr[i] + String.format("%.2f", billArr[i]) +"\t";
		        }
		      }//end inner for loop

		      // Swap list[i] with list[currentMinIndex] if necessary;
		      if (currentMinIndex != i) {
		    	//swap billArr
		        billArr[currentMinIndex] = billArr[i];
		        billArr[i] = currentMin;
		        //also change customer info
		        custInfoArr[currentMinIndex] = custInfoArr[i];
		        custInfoArr[i] = currentMinInfo;
		      }
		      
		  }//end outer for loop
		
		System.out.println(sortedOutput);
	    // To complete
	    // Add the customer data to the output variable after sorting the arrays
		// After sorting is complete, populate sortedOutput
		output += "\nSorted Output:------------------------------------\n";
		for (int i = 0; i < billArr.length; i++) {
		    output += custInfoArr[i] + String.format("%.2f", billArr[i]) + "\n";
		}

		
		// Display the program output with statistics 
		JOptionPane.showMessageDialog(null, new JTextArea(output),"WATER BILL CALCULATOR",JOptionPane.INFORMATION_MESSAGE); 
		

	}// end main

}// end class
