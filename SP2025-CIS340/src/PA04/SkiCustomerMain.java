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
package PA04;

import javax.swing.JOptionPane;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class SkiCustomerMain {
	public static void main(String[] args) {
		int numCust = 0;
		int option;
		int daysOfStay = 0;
		int noOfRentalItems;
		int firstTimeUser;
		int coupon;
		boolean ftu;
		boolean c;
		String custName;
		String memberID;
		
		//try numCust input
		try {
			numCust = Integer.parseInt( JOptionPane.showInputDialog(null,"How many customers are there?"));
			if(numCust < 1)
				throw new Exception();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error in customer number input, Exiting Program");
			System.exit(0);
		}
		
		SkiCustomer[] skiCustArr = new SkiCustomer[numCust];
		
		for(int i = 0; i < numCust; i++) {
			
			//**********************************************************************
			//*GATHER INPUTS
			//**********************************************************************
			
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
			
			//get days of stay
			while(true) {
				//try energy input
				try {
					daysOfStay = Integer.parseInt(JOptionPane.showInputDialog(null,"How many days of stay?"));
					//if negative enrg throw exception
					if(daysOfStay< 1) 
						throw new Exception();
					else
						break;
				}catch(Exception ex) {
					//if exception thrown check if they want to try again
					option = JOptionPane.showConfirmDialog(null, "Invalid Days of stay input, try again?","Invalid Input", JOptionPane.YES_NO_OPTION);
					  if (option != JOptionPane.YES_OPTION)
							System.exit(0);
				}
			}
			//get number of rental items
			while(true) {
				//try energy input
				try {
					noOfRentalItems = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter number of rental items"));
					//if negative enrg throw exception
					if(noOfRentalItems < 0 || noOfRentalItems > 3) 
						throw new Exception();
					else
						break;
				}catch(Exception ex) {
					//if exception thrown check if they want to try again
					option = JOptionPane.showConfirmDialog(null, "Invalid number of rental items input, try again?","Invalid Input", JOptionPane.YES_NO_OPTION);
					  if (option != JOptionPane.YES_OPTION)
							System.exit(0);
				}
			}
			
			String[] choices = {"Yes", "No"};
			while(true) {
				firstTimeUser = JOptionPane.showOptionDialog(
						null,
						"Is this a first time user?",
						"Title",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						null,
						choices,
						null
				);
				//if input is valid break out of loop
				if(firstTimeUser >= 0) {
					break;
				//otherwise ask if they are sure
				}else {
					option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Exit Program?", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}//end if else
			}//end first time user loop
			ftu = firstTimeUser == 0 ? true: false;
			//is there a coupon
			while(true) {
				coupon = JOptionPane.showOptionDialog(
						null,
						"Is there a coupon",
						"Title",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE,
						null,
						choices,
						null
				);
				//if input is valid break out of loop
				if(coupon >= 0) {
					break;
				//otherwise ask if they are sure
				}else {
					option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Exit Program?", JOptionPane.YES_NO_OPTION);
					if(option == JOptionPane.YES_OPTION) {
						System.exit(0);
					}
				}//end if else
			}//end first time user loop
			c = coupon == 0 ? true: false;
			
            memberID = JOptionPane.showInputDialog("Enter member ID (leave blank if non-member):");
            if (memberID == null || memberID.trim().isEmpty()) {
                skiCustArr[i] = addCustomer(custName, daysOfStay, noOfRentalItems, ftu, c);
            } else {
            	skiCustArr[i] = addCustomer(custName, daysOfStay, noOfRentalItems, ftu, c,memberID);
            }
			
			//**********************************************************************
			//*END GATHER INPUTS
			//**********************************************************************
			
		}//end for loop
		
		//call static methods
		sortCustomer(skiCustArr);
        output(skiCustArr);
        try {
			writeToFile(skiCustArr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end main
	
	public static SkiCustomer addCustomer(String name, int days, int noRental, boolean firstTime, boolean coupon) {
		return new SkiCustomer(name, days, noRental, firstTime, coupon);
	}
	public static SkiCustomer addCustomer(String name, int days, int noRental, boolean firstTime, boolean coupon, String memberID) {
		return new SkiCustomer(name, days, noRental, firstTime, coupon, memberID);
	}
	
	public static void sortCustomer(SkiCustomer[] ski) {
		//selection sort with j array
				for(int i = 0; i < ski.length - 1; i++) {
					//current min index
					int min = i;
					for(int j = i + 1; j < ski.length; j++) {
						if(ski[min].getTotalCharges() > ski[j].getTotalCharges()) {
							min = j;
						}
					}
					SkiCustomer temp = ski[i];
					ski[i] = ski[min];
					ski[min] = temp;
//					System.out.println("After inner loop temp var is " + temp + " and index " + i + " of array is " + arr[i]);
				}
	}
	
    //generate output
	public static void output(SkiCustomer[] skiCustArr) {
		//header
	    String out = "Sorted Customer Details:\n\n";
	    for (SkiCustomer cust : skiCustArr) {
	        out = out + cust.toString() + "\n\n";
	    }
	    JOptionPane.showMessageDialog(null, out, "Customer Details", JOptionPane.INFORMATION_MESSAGE);
	}
    
    // writes sorted customer details to SkiCustomer.txt
    static void writeToFile(SkiCustomer[] skiCustArr) throws FileNotFoundException {
    	//create file and print writer
        File file = new File("bills.txt");
        PrintWriter write = new PrintWriter(file);
        String out = "Water Bill\n" +
                     "Name\tDays of Stay\tNo. of Rental Items\tRental Amount\tTotal Discount\tSales Tax\tTotal Charges";
        //for each customer in the cust arr
        for (SkiCustomer cust : skiCustArr) {
            out += "\n" + cust.toString();
        }
        write.print(out);
        write.close();
        JOptionPane.showMessageDialog(null, "Done Storing Customer Data into a File");
    }
}//end class


