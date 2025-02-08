//**********************************************************************
//*
//* CIS340 Spring Tayler Stegman
//* *
//* Program Assignment PA02 *
//* *
//* Program to Calculate Electric Bills *
//* *
//* Date Created: 02.06.2025 *
//* Saved in: TaylerStegmanPA0201.java
//*********************************************************************
//
// import packages here (if needed – be sure to delete the //)

package PA02;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class TaylerStegmanPA0201 {

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
				//custType commercial, calculated since it doesn't rely on energy amounts
				if(custType == 1)
					electricBill = 10.75 + (enrgUsed * 0.06450);
				//else must be residential
				//check for tier 1
				else if(enrgUsed < 500) {
					electricBill = 6.75 + (enrgUsed * 0.04604);
				}
				//check for tier 2
				else {
					electricBill = 6.75 + (500 * 0.04604) + ((enrgUsed - 500) * 0.09000);
				}
				break;
			//winter months
			case 10, 11, 12, 1, 2, 3, 4, 5:
				//if customer type commercial
				if(custType == 1)
					electricBill = 10.75 + (enrgUsed * 0.03920);
				//if customer type residential
				else
					electricBill = 6.75 + (enrgUsed * 0.04604);
				break;
			}
			//set array values based on declared variables above
			name[i] = custName;
			arrCustType[i] = strCustType;
			arrEnrgUsed[i] = enrgUsed;
			arrMonth[i] = strMonth;
			arrElectricBill[i] = electricBill;
			//generate output
			output += name[i] + "\t" + arrCustType[i] + "\t\t" + String.format("%.2f", arrEnrgUsed[i]) + "\t" + arrMonth[i] + "\t$ " + String.format("%.2f", arrElectricBill[i]) + "\n";
				
		}//end numCust loop
		//show output
		JOptionPane.showMessageDialog(null,new JTextArea("Name\tType of Customer\tEnergy Used\tMonth\tBill amount\n" + output), "ELECTRIC BILL CALCULATOR", JOptionPane.INFORMATION_MESSAGE);

		
//		JOptionPane.showMessageDialog(null, new JTextArea(output),"WATER BILL CALCULATOR",JOptionPane.INFORMATION_MESSAGE);
	}//end main

}//end class
