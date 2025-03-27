package PhoneBillGUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PhoneBillMain {

	static Customer[] customers;
	public static void main(String[] args) throws FileNotFoundException {
		
		//Declare variables 
		int minutes = 0, custType = 0, noOfParticipants = 0, noOfCustomers = 0, custId=0;
		String name = ""; 
	
		
	    // Input the number of customers
		int choice = 0;
		
		while (choice == JOptionPane.YES_OPTION) {
		try { 
			noOfCustomers =
		 Integer.parseInt(JOptionPane.showInputDialog("Input No of Customers"));
		  
		  if (noOfCustomers < 1) 
			   throw new NumberFormatException();
		  
		 choice = 1;  
		} catch (NumberFormatException ex) { 
			
			JOptionPane.showMessageDialog(null,"Invalid Customer Number Input Format");
			choice = JOptionPane.showConfirmDialog(null, "Would You Like to Continue!");
			
			if (choice !=0)
				System.exit(0);
		  }
		}
		
		// Create  arrays of size "numOfClients (n)"
		customers = new Customer[noOfCustomers+6];
		
		//Read data from file
		readFromFile("inputPhoneBill.txt");
		
		for (int i =0; i < noOfCustomers; i++ ) {
			
			minutes = 0; noOfParticipants =0;
			// Input customer id
			while(true) {							
			try {
			String custIdStr = JOptionPane.showInputDialog("Input Customer ID");
			
			if (custIdStr.length()!=6)
				throw new NumberFormatException();
			
			custId = Integer.parseInt(custIdStr); 
			
			break;
			
			} catch (NumberFormatException ex) {
				   JOptionPane.showMessageDialog(null, "Invalid Cust ID Input Format");
				 
			}
			}// end while
			
		
		// Input customer name
		while(true) {
		name = JOptionPane.showInputDialog("Input Name");
		if (name.isEmpty()) 
			JOptionPane.showMessageDialog(null, "Invalid Input Format");
		else 
			break;
		
		}
		
		// Input the customer type
		while (true) {
		try {
		custType = Integer.parseInt(JOptionPane.showInputDialog("Input Customer Type:" +
		  "\n0 - Go Bill" + "\n1 - Contract Bill"));
		
		if ( (custType != 0) && (custType != 1))
			throw new NumberFormatException();
		
		break;
		
		} catch (NumberFormatException ex) {
			   JOptionPane.showMessageDialog(null, "Invalid Input Format");
			   
		}
		}
		

		switch (custType) {
		case 0: // Input customer minutes
			
			    while (true) {
			    try {
				String minStr = JOptionPane.showInputDialog("Input Minutes");
				minutes = Integer.parseInt(minStr);
				
				if (minutes < 0)
					throw new NumberFormatException();
				
				break;
				
				} catch (NumberFormatException ex) {
				   JOptionPane.showMessageDialog(null, "Invalid Input Format");
				  
				 }
			    }// end while
				break;
		
		case 1: // Input number of participants 
			
			while (true) {
			try {
				
				String noStr = JOptionPane.showInputDialog("Input Number of Participants:");
				noOfParticipants = Integer.parseInt(noStr);
				
				if ( (noOfParticipants > 4) || (noOfParticipants < 1 ) ) 
						 throw new  NumberFormatException();
				
				break;
				} catch (NumberFormatException ex) {
				   JOptionPane.showMessageDialog(null, "Invalid Input Format");
				  
				 }
			}// end while	
				
			    break;
				
		}// end of switch
		
		// call method to create Customer object and add it to the array 
			addCustomer(name, custId, minutes, noOfParticipants, custType);
		
	}// for
		
	// display phone bills
		displayBill();
		
	// sort phone bill
		sortBill();
		
		
   // display phone bills
		displayBill();
		
	// store data to file
		writeToFile("PhoneBillOut.txt");
	}// end of method main
	
	
	static void addCustomer(String name, int custId, int minutes, int noOfParticipants, int custType) {
		// complete in class
		if (custType == 0)
			customers[Customer.getNoOfCustomers()] = new Customer(name,custId, new GoBill(minutes));
		else if (custType == 1)
			customers[Customer.getNoOfCustomers()] = new Customer(name,custId, new ContractBill(noOfParticipants)); 
	}

	static void sortBill() {
		// Sorting arrays using the selection sort based on bill value
	    for (int i = 0; i < customers.length -1; i++) {
	        
	        // Find the minimum in the list[i..list.length-1]
	        Customer currentMin = customers[i];
	        int currentMinIndex = i;
	        
	        for (int j = i + 1; j < customers.length; j++) {
	          if (currentMin.getName().compareTo(customers[j].getName()) > 0) {
	            currentMin = customers[j];
	            currentMinIndex = j;
	          }
	        } // end inner for loop

	        // Swap list[i] with list[currentMinIndex] if necessary;
	        if (currentMinIndex != i) {
	        	customers[currentMinIndex] = customers[i];
	        	customers[i] = currentMin;
	       }
	      } // end outer for loop
		
	}// end sortBill


	
	// display two after sorting areas
	public static void displayBill() {
		// output the areas after sorting
		String out ="Phone Bill:\n" + "Number\t" + "Name\t" + "Type\t" +
                "Minutes\t" + "Participants\t" + "Value\t" + "Date";
		for (int i =0; i < customers.length; i++)
			out+= "\n" + customers[i].toString();
		
		  // add the bill average
		  out+= "\n Avg Phone Bill Values: " + String.format("%.2f",avg());
		  
		  // add the minimum phone bill value
		  out+= "\n The Min Phone Bill Customer: " + customers[minIndex()].toString();
		  
		  // add the maximum phone bill value
		  out+= "\n The Max Phone Bill Customer: " + customers[maxIndex()].toString();
		
		JOptionPane.showMessageDialog(null, new JTextArea(out)); 
		
	}// displayBill
	
	
	static void writeToFile(String fileName) throws FileNotFoundException {
	    
		// create a file object
		File file = new File(fileName);
		
		// create the PrintWriter object
		PrintWriter p = new PrintWriter(file);
		
		// output the areas after sorting
				String out ="Phone Bill:\n" + "Number\t" + "Name\t" + "Type\t" +
		                     "Minutes\t" + "Participants\t" + "Value\t" + "Date";
				
				for (int i =0; i < customers.length; i++)
					out+= "\n" + customers[i].toString();
				
		// write data to file
		p.print(out);
		
		// close file
		p.close();
		
	}// end method writeToFile
	
	
 static void readFromFile(String fileName) throws FileNotFoundException {
		
		// create file object
		File file = new File(fileName);
		
		// create scanner object
		Scanner sc = new Scanner(file);
		
		// Change the scanner delimiter
		sc.useDelimiter(",|\r\n");
		
		while (sc.hasNext()) {
			
			int custNumber = Integer.parseInt(sc.next().trim());
			String custName = sc.next().trim();
			int custType = Integer.parseInt(sc.next().trim());
			int minutes = Integer.parseInt(sc.next().trim());
			int noOfParticipants = Integer.parseInt(sc.next().trim());
			
			// call 
			addCustomer(custName, custNumber, minutes, noOfParticipants, custType);
		}// end while
		
		sc.close();
		
		JOptionPane.showMessageDialog(null,"Done Reading from file!");
	}// end readFromFile

 static int minIndex() {
		double min = customers[0].getBill().getValue();
		int index = 0;
		
		for (int i = 1; i< customers.length; i++)
			if (min > customers[i].getBill().getValue()) {
				min = customers[i].getBill().getValue();
				index = i;
			}// end for
		
		return index;
	}
	
	static int maxIndex() {
		double max = customers[0].getBill().getValue();
		int index = 0;
		
		for (int i = 1; i< customers.length; i++)
			if (max < customers[i].getBill().getValue()) {
				max = customers[i].getBill().getValue();
				index = i;
			}// end for
				
		return index;
	}
	
	static double avg() {
		
		double sum =0;
		for (int i = 0; i< customers.length; i++)
			sum+=customers[i].getBill().getValue();
		
		return (sum/customers.length);
			
	}
 
 
} //end of class PhoneBill
