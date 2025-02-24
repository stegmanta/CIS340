//**********************************************************************
//*
//* CIS340 Spring Tayler Stegman
//* *
//* Program Assignment PA03 *
//* *
//* Program for modularization*
//* *
//* Date Created: 2.20.2025 *
//* Saved in: TaylerStegmanPA0302.java
//*********************************************************************
//
// import packages here (if needed – be sure to delete the //)
package PA03;
import javax.swing.*;

public class TaylerStegmanPA0302 {
	

	public static void main(String[] args) {
		int numCust = 0, custType, option = 0, month = 0;
		double enrgUsed = 0.0, electricBill = 0.0;
		String strCustType = "", custName = "", strMonth = "", output = "";
		//arrays to hold each input for each customer
		String[] name;
		String[] arrCustType;
		Double[] arrEnrgUsed;
		String[] arrMonth;
		Double[] arrElectricBill;
		
		//try numCust input
		try {
			numCust = Integer.parseInt( JOptionPane.showInputDialog(null,"How many customers are there?"));
			if(numCust < 1)
				throw new Exception();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error in customer number input, Exiting Program");
			System.exit(0);
		}
		
		//create arrays with sizes based on number of customer
		name = new String[numCust];
		arrCustType = new String[numCust];
		arrEnrgUsed = new Double[numCust];
		arrMonth = new String[numCust];
		arrElectricBill = new Double[numCust];
		
		//loop through based on number of customers
		for (int i = 0; i < numCust; i++) {
			//get customer type
			String[] choices = {"Residential", "Commercial"};
			//loop through to make sure user is use they want to exit the program
			while(true) {
				custType = JOptionPane.showOptionDialog(
						null,
						"Select The Customer Type",
						"Electricity Bill",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						null,
						choices,
						null
				);
				//if input is valid break out of loop
				if(custType >= 0) {
					break;
				//otherwise ask if they are sure
				}else {
					option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Exit Program?", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}//end if else
			}//end customer type loop
			
			//ternary if custType = 0 set residential else set commercial
			strCustType = (custType == 0) ? "Residential": "Commercial";
			
			//gather customer name
			while(true) {
			      custName = JOptionPane.showInputDialog("Enter Customer Name:");
			      if(!custName.matches("[A-Z][a-z]+\\s+[A-Z][a-z]+")) {
			    	  option = JOptionPane.showConfirmDialog(null, "Invalid Customer Name Input \n Would You Like To Try Again?", "Invalid Customer Name", JOptionPane.YES_NO_OPTION);
					  if (option != JOptionPane.YES_OPTION)
							System.exit(0);
			      } else
			    	  break;
		 	}// end while
			
			//get energy used
			while(true) {
				//try energy input
				try {
					enrgUsed = Double.parseDouble(JOptionPane.showInputDialog(null,"Enter Total energy used in kWh"));
					//if negative enrg throw exception
					if(enrgUsed < 0) 
						throw new Exception();
					else
						break;
				}catch(Exception ex) {
					//if exception thrown check if they want to try again
					option = JOptionPane.showConfirmDialog(null, "Invalid Total Energy Input \n Would You Like To Try Again?","Invalid Energy Input", JOptionPane.YES_NO_OPTION);
					  if (option != JOptionPane.YES_OPTION)
							System.exit(0);
				}
			}
			
			//get month of the year
			while(true) {
				//try energy input
				try {
					month = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Month of year for billing"));
					//if negative enrg throw exception
					if(month < 1 || month > 12) 
						throw new Exception();
					else
						break;
				}catch(Exception ex) {
					//if exception thrown check if they want to try again
					option = JOptionPane.showConfirmDialog(null, "Invalid Month Input \n Would You Like To Try Again?","Invalid Energy Input", JOptionPane.YES_NO_OPTION);
					  if (option != JOptionPane.YES_OPTION)
							System.exit(0);
				}
			}
			
			//set month to string with switch
			switch(month) {
			    case 1:
			        strMonth = "Jan";
			        break;
			    case 2:
			        strMonth = "Feb";
			        break;
			    case 3:
			        strMonth = "Mar";
			        break;
			    case 4:
			        strMonth = "Apr";
			        break;
			    case 5:
			        strMonth = "May";
			        break;
			    case 6:
			        strMonth = "Jun";
			        break;
			    case 7:
			        strMonth = "Jul";
			        break;
			    case 8:
			        strMonth = "Aug";
			        break;
			    case 9:
			        strMonth = "Sep";
			        break;
			    case 10:
			        strMonth = "Oct";
			        break;
			    case 11:
			        strMonth = "Nov";
			        break;
			    case 12:
			        strMonth = "Dec";
			        break;
			}//end switch

			//calculate bill based on month switch
			switch(month) {
			//summer months
			case 6, 7, 8, 9:
				//custType commercial
				if(custType == 1)
					electricBill = commercialElecBill(true, enrgUsed);
				//custType residential
				else
					electricBill = residentialElecBill(true, enrgUsed);
				break;
			//winter months
			case 10, 11, 12, 1, 2, 3, 4, 5:
				//if customer type commercial
				if(custType == 1)
					electricBill = commercialElecBill(false, enrgUsed);
				//customer residential
				else
					electricBill = residentialElecBill(true, enrgUsed);
				break;
			}
			//set array values based on declared variables above
			name[i] = custName;
			arrCustType[i] = strCustType;
			arrEnrgUsed[i] = enrgUsed;
			arrMonth[i] = strMonth;
			arrElectricBill[i] = electricBill;
		}//end numCust for loop
		
		//display output via method
		display(numCust, name, arrCustType, arrEnrgUsed, arrMonth, arrElectricBill);
		
	}//end main
	
	//method for residential electric bills
	public static double residentialElecBill(boolean summer, double enrgUsed) {
		double total = 0.0;
		//if summer
		if(summer) {
			//check for tier 1
			if(enrgUsed < 500)
				total = 6.75 + (enrgUsed * 0.04604);
			//check for tier 2
			else 
				total = 6.75 + (500 * 0.04604) + ((enrgUsed - 500) * 0.09000);
		}
		//if winter
		else {
			total = 6.75 + (enrgUsed * 0.04604);
		}
		return total;
	}
	
	//method for commercial electric bills
	public static double commercialElecBill(boolean summer, double enrgUsed) {
		double total = 0.0;
		//if summer
		if(summer) {
			total = 10.75 + (enrgUsed * 0.06450);
		}
		//if winter
		else {
			total = 10.75 + (enrgUsed * 0.03920);
		}
		return total;
	}

	//method to calculate  the highest bill
	public static double highestCostCalculator(Double[] arrElectricBill) {
		double high = arrElectricBill[0];
		for(int i = 0; i < arrElectricBill.length; i++) {
			if(arrElectricBill[i] > high) {
				high = arrElectricBill[i];
			}
		}
		return high;
	}
	
	//method to calculate  the lowest  bill
	public static double lowestCostCalculator(Double[] arrElectricBill) {
		double low = arrElectricBill[0];
		for(int i = 0; i < arrElectricBill.length; i++) {
			if(arrElectricBill[i] < low) {
				low = arrElectricBill[i];
			}
		}
		return low;
	}
	
	//method to sort array by bill total
	public static void sortTotalCost(String[] name, String[] arrCustType, Double[] arrEnrgUsed, String[] arrMonth, Double[] arrElectricBill) {
		//selection sort with j array
		for(int i = 0; i < arrElectricBill.length - 1; i++) {
			//current min index
			int minIndex = i;
//			System.out.println("\nMain iteration number " + i + " minimum value is currently " + arr[min]);
			for(int j = i + 1; j < arrElectricBill.length; j++) {
				if(arrElectricBill[minIndex] > arrElectricBill[j]) {
					minIndex = j;
				}
//				System.out.println("After inner loop min is now " + arr[min]);
			}//end inner loop	
			 // Swap the bill values
	        double tempBill = arrElectricBill[i];
	        arrElectricBill[i] = arrElectricBill[minIndex];
	        arrElectricBill[minIndex] = tempBill;

	        // Swap the customer names
	        String tempName = name[i];
	        name[i] = name[minIndex];
	        name[minIndex] = tempName;

	        // Swap customer types
	        String tempCustType = arrCustType[i];
	        arrCustType[i] = arrCustType[minIndex];
	        arrCustType[minIndex] = tempCustType;

	        // Swap enrgUsed
	        double tempEnergy = arrEnrgUsed[i];
	        arrEnrgUsed[i] = arrEnrgUsed[minIndex];
	        arrEnrgUsed[minIndex] = tempEnergy;

	        // Swap month strings
	        String tempMonth = arrMonth[i];
	        arrMonth[i] = arrMonth[minIndex];
	        arrMonth[minIndex] = tempMonth;
		}//end outer loop
	}

	//method to display all output details
	public static void display(int numCust, String[] name, String[] arrCustType, Double[] arrEnrgUsed, String[] arrMonth, Double[] arrElectricBill) {
		//declare local variables
		String unsortedOutput = "", sortedOutput = "",
				max = String.format("%.2f", highestCostCalculator(arrElectricBill)),
				min =String.format("%.2f", lowestCostCalculator(arrElectricBill)),
				header = "Name\tType of Customer\tEnergy Used\tMonth\tBill amount\n";
		//loop through and create unsorted output
		for(int i = 0; i < numCust; i++) {
			unsortedOutput += name[i] + "\t" + arrCustType[i] + "\t\t" + String.format("%.2f", arrEnrgUsed[i]) + "\t" + arrMonth[i] + "\t$ " + String.format("%.2f", arrElectricBill[i]) + "\n";
		}
		//now sort output and create string
		sortTotalCost(name, arrCustType, arrEnrgUsed, arrMonth, arrElectricBill);
		for(int i = 0; i < numCust; i++) {
			sortedOutput += name[i] + "\t" + arrCustType[i] + "\t\t" + String.format("%.2f", arrEnrgUsed[i]) + "\t" + arrMonth[i] + "\t$ " + String.format("%.2f", arrElectricBill[i]) + "\n";
		}
		//display output
		JOptionPane.showMessageDialog(null,new JTextArea("UNSORTED OUTPUT \n\n" + header + unsortedOutput + "\n\nHighest bill value: " 
		+ max + "\nLowest bill value: " + min + "\n\nSORTED OUTPUT\n\n" + header + sortedOutput), "ELECTRIC BILL CALCULATOR", JOptionPane.INFORMATION_MESSAGE);
	}

}//end class

