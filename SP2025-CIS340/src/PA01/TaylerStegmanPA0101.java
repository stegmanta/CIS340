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
		int actReturnDay = 0, actReturnMo = 0, expReturnDay = 0, expReturnMo = 0, daysLate = 0, monthsLate = 0;
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
				inError = true;
				errMsg += "\nERROR: Ensure Day and Month input is valid, must be greater than 0";
			} 
			//check if february error is true
			if(februaryErr) {
				inError = true;
				errMsg += "\nERROR: Febraury can't have more than 29 days";
			}
			//check if april error is true
			if(aprilErr) {
				inError = true;
				errMsg += "\nERROR: April can't have more than 30 days";
			}
			//if in error is true throw exception
			if(inError) 
				throw new Exception();
			
			if(actReturnMo == expReturnMo){
				//if returned in the same month
				daysLate = Math.max(0, actReturnDay - expReturnDay);
				fine = 0.15 *(daysLate);
			}else if(actReturnMo > expReturnMo) {
				//if returned in a different month
				daysLate = (31 - expReturnDay) + actReturnDay + (actReturnMo - expReturnMo - 1) * 31;
				fine = 5.00 * (actReturnMo - expReturnMo);
			}
			
			JOptionPane.showMessageDialog(null, "Number of days late: " + daysLate +"\nFine Amount: $" +fine);
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Error:\nInputted Current Return Date (M/D): " + actReturnMo + "/" + actReturnDay 
										 +"\nInputted Expected Return Date (M/D): " + expReturnMo + "/" + expReturnDay + errMsg);
			System.exit(0);
		}//end try
	}//end main

}
