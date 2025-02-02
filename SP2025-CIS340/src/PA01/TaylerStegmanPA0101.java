//**********************************************************************
//*
//* CIS340 Spring Tayler Stegman
//* *
//* Program Assignment PA01 *
//* *
//* Program to handle I/O Exceptions *
//* *
//* Date Created: 01.25.2025 *
//* Saved in: TaylerStegmanPA0101.java
//*********************************************************************
//
// import packages here (if needed – be sure to delete the //)
package PA01;
import javax.swing.*;
import java.lang.Math;

public class TaylerStegmanPA0101 {

	public static void main(String[] args) {
		// Declare variables and constants
		int actReturnDay = 0, actReturnMo = 0, expReturnDay = 0, expReturnMo = 0, daysLate = 0;
		double fine = 0.0;
		String errMsg = "";
		boolean februaryErr = false,  aprilErr = false, inError = false;
		//gather inputs
		try {
			actReturnDay = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter actual return day:"));
			actReturnMo = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter actual return month:"));
			expReturnDay = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter expected return day:"));
			expReturnMo = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter expected return month:"));
			//check for invalid month day combinations
			februaryErr = (actReturnMo == 2 && actReturnDay > 29) || (expReturnMo == 2 && expReturnDay > 29);
			aprilErr = (actReturnMo == 4 && actReturnDay > 30) || (expReturnMo == 4 && expReturnDay > 30);
			//check for generic errors (day greater than 31, month greater than 12, day/month <= 0
			if(actReturnDay > 31 || expReturnDay > 31 || actReturnMo > 12 || expReturnMo > 12 
					|| actReturnDay <= 0 || actReturnMo <= 0 || expReturnDay <=0 || expReturnMo <= 0 ) {
				errMsg += "\nERROR: Ensure Day and Month input is valid, must be greater than 0";
				throw new Exception();
			} 
			//check if february error is true
			if(februaryErr) {
				errMsg += "\nERROR: Febraury can't have more than 29 days";
				throw new Exception();
			}
			//check if april error is true
			if(aprilErr) {
				errMsg += "\nERROR: April can't have more than 30 days";
				throw new Exception();
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error:\nInputted Current Return Date (M/D): " + actReturnMo + "/" + actReturnDay 
										 +"\nInputted Expected Return Date (M/D): " + expReturnMo + "/" + expReturnDay + errMsg);
			System.exit(0);
		}//end try catch
		
		//switch to determine the max days given the month (would be good to put in a method but we're not that far yet in class)
		int maxDays = 0;
		switch(expReturnMo) {
			case 2:
				//years are not given so leap years can't be calculated
				maxDays = 29;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				maxDays = 30;
				break;
			default:
				maxDays = 31;
				break;
		}
		
		if (actReturnMo < expReturnMo || (actReturnMo == expReturnMo && actReturnDay <= expReturnDay)) {
		    // Book returned on or before the expected date. fine is declared 0 so it is not nessecary
		    daysLate = 0;
		}
		else if(actReturnMo == expReturnMo) {
			//if month is the same calculate days late and fine
			daysLate = actReturnDay - expReturnDay;
			fine = 0.15 * daysLate;
		}
		else {
			//if act return mo is greater than expected return mo
			daysLate += (maxDays - expReturnDay);
			//loop through total months and use switch to determine max
			for(int m = expReturnMo + 1; m < actReturnMo; m++ ){
				int daysInMonth = 0;
				switch(m) {
				case 2:
					//not accounting for leap years (no input) but would be easy to implement ehre
					daysInMonth = 29;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					daysInMonth = 30;
					break;
				default:
					daysInMonth = 31;
					break;
				}
				//add number of days late based on month that passed
				daysLate += daysInMonth;
			}//end for loop
			//add days from the actual return month
			daysLate += actReturnDay;
			fine = 5.00 * (actReturnMo - expReturnMo);
		}//end else
		
		JOptionPane.showMessageDialog(null, "Number of days late: " + daysLate +"\nFine Amount: $" + String.format("%.2f",fine));
			
	}//end main

}
