package ICE3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TaylerStegmanICE3 {

	// Developed by Dr. Ramadan Abdunabi
	// ICE3 - Practice Class Methods
	
	// class variables and constants 
	static String output= "";
	final static double BASE_CHARGE_SINGLE_FAMILY = 13.21 ;
	final static double BASE_CHARGE_DUPLEX = 15.51;
	static Date billDate = null;
	
		
	public static void main(String[] args) throws FileNotFoundException {

		// declare variables and constants
		double gallons = 0;
		String custName = null;
		int custNumber = 0;
		int custType=0;
		String customerTypeStr = null; //newly added 
		int noOfCustomers=0;
		String input = null;
		boolean continueInput = true;
		
		// declaring arrays
		String[] custInfoArr;
		double[] billArr;
		
		
		
		// Enter number of customers 
		 noOfCustomers = DataEntries.intInput("Input No of Customers");
		
		//The following initialize arrays with size of number of entries and lines in the input file
		// To complete 
		// Use the JFileChooser to select the file from the file system and return the file name
		String fileName = JFileChooserDemo.getFileName();
		
		
		// To Complete 
		// Implement method findNumberOfCustomersInFile() to return the number of lines in the data file
		int nnumberOfLines = findNumberOfCustomersInFile(fileName); 
		
		
		billArr=new double[noOfCustomers+nnumberOfLines];
		custInfoArr=new String[noOfCustomers+nnumberOfLines];
		
		// Update the output variable before sorting arrays
		billDate  = new Date();
		output+="Water Bill Date:  " + billDate;
		output+="\nNAME\tTYPE\tNUMBER\tGALLON\tBILL VALUE";
		output+="\nBefor Sorting Arrays:";
		
		
		
		// To Complete
		// Implement this method to read from file add data to the array
		readFromFile(billArr,custInfoArr, fileName);
		
		// loop receiving the customer data
		for(int i=nnumberOfLines;i<(noOfCustomers+nnumberOfLines);i++) {
			
			
			//input customer rate
			// input customer Rate/Type - It returns 0 or 1
			String[] choices = {"Single Family", "Duplex"};
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
			// increment by 1
			custType++;
		
		
		
		// Input Customer Number:
		custNumber = DataEntries.intInputSize(6, "Input Customer Number");
				
		// Enter customer name
		custName = DataEntries.strInput("Input Customer Name");
				    
			   
		// Enter number of gallons
		gallons = DataEntries.doubleInput("Input Number of Gallons");
				
							
		// compute customer bill
		switch (custType) {
		case 1: 
			    // fill the billArr with data
			    customerTypeStr="Single";
				billArr[i]=singleFamilyBill(gallons);
				break;
		case 2: 
			    // fill the billArr with data
			    customerTypeStr="Duplex";
				billArr[i]=duplexBill(gallons);
				break;
		}//end of switch
		
		// fill the custInfoArr with data
		custInfoArr[i]= custName+"\t"+customerTypeStr+"\t"+ custNumber+"\t"+ gallons;	
		
		// Update the output variable
		output+="\n"+custInfoArr[i]+"\t$"+String.format("%.2f", billArr[i]);
		
		}//end of for loop - End reading Customers Data

		
		// To Complete
		//Implement method to display output before sorting-Call displayBill() method
		displayBill();
		
		
		// To Complete
		// Implement method that finds the of the maximum bill value
		maxValue(billArr, custInfoArr);
		
		// To Complete
		// Implement method that finds the of the minimum bill value
		minValue(billArr, custInfoArr);
		
		// To Complete
		// Implement method that finds the bill value average
		avgValue(billArr); 
		
		//Display output before sorting-Call displayBill() method
		displayBill();
		
		//Sort custInfoArr array and bill array based on billValue-selection sort
		sortBill(billArr, custInfoArr);
							
		//Display output after sorting-Call displayBill() method
		displayBill();
		
		// To Complete
		// Update method in WriteData.java class to write data to output file
		writeToFile("WaterBillOutput.txt");
		
	}//end of main
	
	// computes the Single Family water bill
	public static double singleFamilyBill(double gallons) {
		double value;
		if (gallons <= 7000)
 			value = BASE_CHARGE_SINGLE_FAMILY + 
 			gallons * 2.04 / 1000;
		else if (gallons <= 13000)
 			value = BASE_CHARGE_SINGLE_FAMILY + 
 			7000 * 2.04 / 1000 + (gallons - 7000) * 2.35 / 1000;
		else 
			value = BASE_CHARGE_SINGLE_FAMILY + 
			7000 * 2.04 / 1000 + 6000 * 2.35 / 1000 + 
			(gallons - 13000) * 2.70	 / 1000;
		return value;
		
	}
	
	// computes the Duplex water bill
	public static double duplexBill(double gallons) {
		double value;
		if (gallons <= 9000)
		 	value = BASE_CHARGE_DUPLEX + gallons * 
		 	1.97	 / 1000;
		else if (gallons <= 13000)
			value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 + 
			(gallons - 9000) * 2.26 / 1000;
		else 
			value = BASE_CHARGE_DUPLEX + 9000 * 1.97 / 1000 +
			4000 * 2.26 / 1000 + (gallons - 13000) * 2.60	 
			/ 1000;
		return value;
	}
	
	// This is the sorting method of two arrays - billArr and custInfoArr 
	public static void sortBill(double[] billArr, String[] custInfoArr) {
		
		int i,j;
		
		for (i = 0; i < billArr.length - 1; i++) {
			
			int currentMinIndex = i;
			double currentMin = billArr[i];
			String currentMinInfo=custInfoArr[i];
			
			
			for(j=i+1;j<billArr.length;j++) {
				if(billArr[j]<currentMin) {
					currentMin=billArr[j];
					currentMinInfo=custInfoArr[j];
					currentMinIndex=j;
				}//end if
			}//end inner for
			
			//swap billArr[i] and billArr[currentMinIndex] if necessary
			if(currentMinIndex!=j) {
				billArr[currentMinIndex]=billArr[i];
				billArr[i]=currentMin;
				
				custInfoArr[currentMinIndex]=custInfoArr[i];
				custInfoArr[i]=currentMinInfo;
				
			}
		}//end outer for
		
		JOptionPane.showMessageDialog(null, "Completed Sorting Arrays");
		
		//Update the output variable after Sorting
		output+="\nAfter Sorting Arrays:";
		for(i=0;i<billArr.length;i++)	
		 output+="\n"+custInfoArr[i]+"\t$"+String.format("%.2f", billArr[i]);
	}//end of method sortArray 
	
	// Displays the program output - Displays the output variables
	public static void displayBill() {
		
		JOptionPane.showMessageDialog(null, new JTextArea(output));
		
	}// end of method displayBill
	
	// Complete this method to find the the maximum bill value, maxValue() 
    public static void maxValue(double[] billArr, String[] custInfoArr) {
    	
    	double max = billArr[0];
		int index = 0;
    	// complete the code to find index for the maximum bill value
    	// Use code from ICE2
		for(int i = 0; i < billArr.length;i++) {
			if(billArr[i] > max) {
				max = billArr[i];
				index = i;
			}
		}
   	    // Add the maximum bill value info to the output, using the index
		output+= "\nMax Bill Value------------------------------------";
		output+="\n"+custInfoArr[index]+"\t$"+String.format("%.2f", billArr[index]);	
		
		   	 
   	    // complete - call displayBill() to display the output
		displayBill();
		
    }// end maxValue()
    
    
    // Complete this method to find the the minimum bill value, maxValue() 
    public static void minValue(double[] billArr, String[] custInfoArr) {
    	
    	double min = billArr[0];
		int index = 0;
   	    // complete the code to find index for the minimum bill value
        // Use code from ICE2
		for(int i = 0; i < billArr.length; i++) {
			if(billArr[i] < min) {
				min = billArr[i];
				index = i;
			}
		}
   	    // Add the minimum bill value info to the output, using the index
	 	output+= "\nMinx Bill Value------------------------------------";
		output+="\n"+custInfoArr[index]+"\t$"+String.format("%.2f", billArr[index]);	
   	 
   	    // call displayBill() to display the output
		displayBill();
			
    }// end maxValue()
    
    
    // Complete this method to find bill value average, avgValue() 
    public static void avgValue(double[] billArr) {
    	
     double avg = 0, sum =0;	 
   	 // complete the code to find bill value average
   	 for(int i = 0; i < billArr.length; i++) {
   		 sum += billArr[i];
   	 }
   	 avg = sum / billArr.length;
    	
   	 // Add the average of the bill values info to the output
   	output+= "\nAverage Bill Value------------------------------------";
	output+="\nAverage Bill Value= " + String.format("%.2f",avg);	
	    
   	 // call displayBill() to display the output
	displayBill();	 
			
    }// end avgValue()

	
	// read from file and add data to arrays
	public static void readFromFile(double[] billArr, String[] custInfoArr, String fileName) throws FileNotFoundException {
		
		// read data from inputWaterBill, (week 03 files)
		// Create a File instance
	    File fileInput = new File(fileName);

	    // Create a Scanner for the file
	    Scanner sc = new Scanner(fileInput);

	    // Read data from a file, the data fields are separated by ',' 
	    int i=0;
//	    sc.useDelimiter(",|\\\\n");
	    while(sc.hasNext()) {
		    // Complete code to read data from file, line by line
	    	//or sc.useDelimiter(",|\\n")
//		    if((i % 3 ==0) && (i != 0)) {
//		    	billArr[i] = Double.parseDouble(sc.nextLine().trim());
//		    }else {
//			    custInfoArr[i] += sc.nextLine().trim();
//		    }
		    String[] line = sc.nextLine().split(",");
		    String name = line[0].trim();
		    int type = Integer.parseInt(line[1].trim());
		    int number = Integer.parseInt(line[2].trim());
		    int gallons = Integer.parseInt(line[3].trim());
		    //update the arrays at index i
		    if(type == 1) {
		    	billArr[i] = singleFamilyBill(gallons);
		    	custInfoArr[i] = name + " Single Family " + number + gallons; 
		    }
		    else {
		    	//duplex family
		    	//TODO:
		    	billArr[i] = duplexBill(gallons);
		    	custInfoArr[i] = name + " Duplex Family " + number + gallons;
		    }
		    
		    // Update the output variable with the array data
		    output+="\n"+custInfoArr[i]+"\t$"+String.format("%.2f", billArr[i]);
		    	
		    // Increment i for the next line in the file
		    i++;
	    
	    }// end while
		
		
		// Close the file
	    sc.close();
	    
	    JOptionPane.showMessageDialog(null, "Completed Reading Data to File \"inputWaterBill.txt\"");
	  }// end read methods
		
	
	// To Complete
		// Counts the number of lines in a file
		public static int findNumberOfCustomersInFile(String fileName) throws FileNotFoundException {
			// read data from inputWaterBill, (week 03 files)
					// Create a File instance
				    File fileInput = new File(fileName);

				    // Create a Scanner for the file
				    Scanner sc = new Scanner(fileInput);

				    // count the number of lines in a file 
				    int count=0;
				    while(sc.hasNext()) {
				    	// read data from file, line by line
				    	sc.nextLine().trim();
				    	count++;
				    
				    }// end while
					
					
					// Close the file
				    sc.close();
				    
				    JOptionPane.showMessageDialog(null, "Completed Reading Data from File, " + "fileName"+  ", and it has: " + count + " Lines!");
				    
				    return count;
				  
		}// end read methods
	
	
	// To Complete
	// writes the program output to file	
	public static void writeToFile(String fileName) throws FileNotFoundException {
		
		try {
			WriteData.writeFile(fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Call Updated method in WriteData.java class to write data in String output to fileName
		// The method should return boolean true value if everything went well
		// WriteData.java file program writes data into file (week 03 files)
	     
	    
	    JOptionPane.showMessageDialog(null, "Completed Writing Data to File \"output.txt\"");
		
	}// end writeToFile
	
		
}//end of class
