package ICE4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/* ICE4 - To Complete in class
 * Created by Dr. Abdunabi 
 */
public class WaterBillMain {

	// class variables
	// create an array of Customer objects
	static Customer[] customers;
	
	public static void main(String[] args) throws FileNotFoundException {

		// declare variables and constants
		int gallons = 0, custNumber = 0, custType = 0, noOfCustomers=0;
		String custName = "";
		
		// Enter number of customers - Use the Validation Methods in class DataEntries
		noOfCustomers = DataEntries.intInput("Input No of Customers");
			
		
         // To complete 
		// 1- Call the getFileLength method to get the number of lines in the data input file, "inputWaterBill.txt"
		int numberOfLines = getFileLength("inputWaterBill.txt");
		// 2- Create customers array with size of noOfCustomers
		
		
		// read data from the input data file before reading the data from the users 
		readFromFile("inputWaterBill.txt");
		
		// start looping to read customer information and compute water bills 		
		for (int i = 0; i<noOfCustomers; i++) {
		
		//input customer rate - Use the Validation Methods in class DataEntries
		custType = DataEntries.intInputChoice(1, 2, "Input Customer Type:" +
						  "\n1 - Single Family Bill" + "\n2 - Duplex Bill");
				
		// Input Customer Number - Use the Validation Methods in class DataEntries
		custNumber = DataEntries.intInputSize(6, "Input Customer Number");
						
		// Enter customer name - Use the Validation Methods in class DataEntries
		custName = DataEntries.strInput("Input Customer Name");
						    
					   
		// Enter number of gallons - Use the Validation Methods in class DataEntries
		gallons = DataEntries.intInput("Input Number of Gallons");
		
		// To Complete
		// call the addCustomers() method to create a Customer object and add it to the customers array
		
	
      }// end for
		
		
		// Display output
		displayBill();
		
		//Sort customers array
		sortBill();
		
     
		// Display output
		displayBill();
		
                // store output to a file		
		writeToFile();
		
		
	}// end main
	
	
	// It receives the customer data and creates Customer objects and adds them to an array  
	private static void addCustomer(String custName, int custNumber, int g, int type) {
		// To Complete
        // Create the Customer and WaterBill objects and add the Customer object to the array of customers at the increasing index
	    
		
	}//end addCustomer

	// display program output
	public static void displayBill() {
		  
               String out = "Water Bill\n" + "name\t" + "number\t" + "Gallons\t" + "Value\t" +
		                 "Type\t" + "Date";
		  
              // To Complete
              // Use the for loop to read Customer data from the customers array, use method toString()
          
              // display the result 
		      JOptionPane.showMessageDialog(null, new JTextArea(out));
			  
	
	}// end displayBill 
	
	// sorts the customers array
	public static void  sortBill() {
			
		
		// use the selection sort to sort the arrays based on the customer's bill values
	    for (int i = 0; i < customers.length - 1; i++) {
	      // Find the minimum in the list[i..list.length-1]
	      Customer currentMin = customers[i];
	      int currentMinIndex = i;

	      for (int j = i + 1; j < customers.length; j++) {
	    	// To Complete
	    	// Write if-statement to compare the Customer objects based on the bill value  
	    	  if (true /* compare Customers objects based on the bill values */ ) {
		          currentMin = customers[j];
		          currentMinIndex = j;
		        } // end if
	    	  
	      }// end j for loop 

	      // Swap list[i] with list[currentMinIndex] if necessary;
	      if (currentMinIndex != i) {
	    	  customers[currentMinIndex] = customers[i];
	    	  customers[i] = currentMin;
	      }// end if
	      
	    }// end i for loop
	    
			  JOptionPane.showMessageDialog(null, "Done Sorting Customer Data");
		}// end sortBill
	
	// write data to file
	static void writeToFile() throws FileNotFoundException {
		
		// Create a File object
		File file = new File("bills.txt");
	    
        // Create a PrintWriter object
	    PrintWriter write = new PrintWriter(file);
		
        // Prepare the program output to be stored in a file
		String out = "Water Bill\n" + "name\t" + "number\t" + "Gallons\t" + "Value\t" +
                "Status\t" + "Date";
       
        // To Complete
        // Write a for loop to read the customer data using the toString method
		
		
	    // Write formatted output to the file
	    write.print(out);
	   

	    // Close the file
	    write.close();
	    
	    JOptionPane.showMessageDialog(null, "Done Storing Customer Data into a File");

	}// end writeToFile
	
	
	// reads the number of lines in the input data file - returns int value
		public static int getFileLength(String fileName) throws FileNotFoundException {
			
		    //To Complete in class
		    // read data from inputWaterBill, (see week 03 - Text I/O files)
			// Create a File instance
		    File file = new File(fileName);
		
		    // Create a Scanner for the file
		    Scanner sc = new Scanner(file);

		   
		    
		   // Start reading data from file using while loop
		    int i = 0;
		    while (sc.hasNext()) {
	          // Read the file data line by line, then count the number of lines using i
		    	sc.nextLine();
		    	// read data from file, line by line
		       	//JOptionPane.showMessageDialog(null, sc.nextLine());
		    	i++;

		   }// end while
			
			
			// Close the file
		    sc.close();
		    
		    	    
		    // display message the program done reading data
		    JOptionPane.showMessageDialog(null, "Completed Reading Data to File \"inputWaterBill.txt\"");
		     
		     return i;
		  }// end read methods
	
	// read from file and add data to the customer array
	public static void readFromFile(String fileName) throws FileNotFoundException {
				
			    //To Complete in class
			    // read data from inputWaterBill, (see week 03 - Text I/O files)
				// Create a File instance
			    File file = new File(fileName);
			
			    // Create a Scanner for the file
			    Scanner sc = new Scanner(file);

			    // Read data from a file, the data fields are separated by ',' 
			    // Change the Scanner default delimiter to ',' or '|', '\r\n'
			    
			    
			   // Start reading data from file using while loop
			 
			    while (sc.hasNext()) {
				   
			    	// To Complete - Read data from file token by token, separated by ','
			    	
				   				   
			    	// To Complete - call method addCustomer to create and add customer object to the Customers array
				  
				   				  
			   }// end while
				
				
				// Close the file
			    sc.close();
			    
			     // display message the program done reading data
			     JOptionPane.showMessageDialog(null, "Completed Reading Data to File \"inputWaterBill.txt\"");
			  }// end read methods
	
	


}// end class
